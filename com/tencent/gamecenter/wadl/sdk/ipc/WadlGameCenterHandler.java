package com.tencent.gamecenter.wadl.sdk.ipc;

import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamecenter.wadl.api.IQQGameDLReportService;
import com.tencent.gamecenter.wadl.api.WadlRequest;
import com.tencent.gamecenter.wadl.api.impl.WadlProxyService;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.sdk.app.WadlReportManager;
import com.tencent.gamecenter.wadl.sdk.checker.WadlCheckResult;
import com.tencent.gamecenter.wadl.sdk.checker.WadlChecker;
import com.tencent.gamecenter.wadl.sdk.dlapt.WadlAgentV2Adapter;
import com.tencent.gamecenter.wadl.sdk.dlmgr.WadlGameCenterTaskMgr;
import com.tencent.gamecenter.wadl.sdk.dlmgr.WadlPackageMgr;
import com.tencent.gamecenter.wadl.sdk.dlmgr.WadlTask;
import com.tencent.gamecenter.wadl.sdk.dlmgr.WadlTaskV2;
import com.tencent.gamecenter.wadl.sdk.dlmgr.WadlTgpaTaskMgr;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlGameCenterHandler implements WadlHandlerInterface, WadlChecker.ICheckListener {
    private static final String TAG = "Wadl_WadlGameCenterHandler";
    private static final long TIMEOUT_2 = 120000;
    private static final long TIMEOUT_5 = 300000;
    private int businessId;
    private long lastDownloadTime;
    private WadlGameCenterTaskMgr taskMgr = WadlGameCenterTaskMgr.getInstance();
    private WadlChecker wadlChecker;
    private WadlPackageMgr wadlPackageMgr;

    public WadlGameCenterHandler(int i3) {
        this.businessId = i3;
        WadlChecker wadlChecker = new WadlChecker();
        this.wadlChecker = wadlChecker;
        wadlChecker.setCheckListener(this);
        WadlPackageMgr wadlPackageMgr = WadlPackageMgr.getInstance();
        this.wadlPackageMgr = wadlPackageMgr;
        this.taskMgr.addObserver(wadlPackageMgr);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean checkLocalVersion(long j3, WadlParams wadlParams, WadlParams wadlParams2) {
        boolean z16;
        JSONObject jSONObject;
        int i3;
        if (wadlParams != null && wadlParams.versionCode >= 1 && j3 >= 1) {
            String loadAsString = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(IGameCenterUnitedConfigApi.GAME_INSTALL_CHANNEL_CONFIG, "");
            QLog.i(TAG, 1, "checkLocalVersion configJsonStr=" + loadAsString);
            boolean z17 = false;
            long j16 = 0;
            if (!TextUtils.isEmpty(loadAsString)) {
                try {
                    jSONObject = new JSONObject(loadAsString);
                    z16 = jSONObject.optBoolean("checkTaskVersion", false);
                } catch (JSONException e16) {
                    e = e16;
                    z16 = false;
                }
                try {
                    j16 = jSONObject.optLong("autoDownloadValidTime") * 1000;
                } catch (JSONException e17) {
                    e = e17;
                    QLog.e(TAG, 1, "checkLocalVersion init config exception", e);
                    QLog.d(TAG, 1, "checkLocalVersion appId=" + wadlParams.appId + ",task versionCode=" + wadlParams.versionCode + ",request versionCode=" + wadlParams2.versionCode);
                    if (!z16) {
                    }
                    i3 = wadlParams.downloadType;
                    if (i3 == 2) {
                    }
                    if (j16 >= 1) {
                    }
                }
            } else {
                z16 = false;
            }
            QLog.d(TAG, 1, "checkLocalVersion appId=" + wadlParams.appId + ",task versionCode=" + wadlParams.versionCode + ",request versionCode=" + wadlParams2.versionCode);
            if (!z16 && wadlParams2.versionCode > wadlParams.versionCode) {
                ((IQQGameDLReportService) QRoute.api(IQQGameDLReportService.class)).onDeleteLowVersionTask(wadlParams, wadlParams2);
                return false;
            }
            i3 = wadlParams.downloadType;
            if (i3 == 2 && i3 != 4) {
                return false;
            }
            if (j16 >= 1) {
                QLog.w(TAG, 1, "checkLocalVersion config invalid, autoDownloadValidTime=" + j16);
                return true;
            }
            if (j3 + j16 < NetConnInfoCenter.getServerTimeMillis()) {
                z17 = true;
            }
            QLog.d(TAG, 1, "checkLocalVersion appId=" + wadlParams.appId + ", isExpire=" + z17);
            if (z17) {
                ((IQQGameDLReportService) QRoute.api(IQQGameDLReportService.class)).onFilterExpireTask(wadlParams);
            }
            return !z17;
        }
        QLog.d(TAG, 1, "checkLocalVersion break, taskParams=" + wadlParams);
        return true;
    }

    private boolean checkTaskVersion(WadlTask wadlTask, WadlParams wadlParams) {
        if (wadlTask.isTestVersion()) {
            if (!wadlParams.getFlagEnable(4096)) {
                return false;
            }
            if (!wadlParams.isExtFlagEnable(2) && !comparisonUrl(wadlTask.mWadlParams.apkUrl, wadlParams.apkUrl)) {
                QLog.d(TAG, 1, "checkTaskVersion by test version, comparisonUrl false");
                return false;
            }
        } else {
            if (wadlParams.downloadType == 3 && !comparisonUrl(wadlTask.mWadlParams.apkUrl, wadlParams.apkUrl)) {
                QLog.d(TAG, 1, "checkTaskVersion by update, comparisonUrl false");
                return false;
            }
            int i3 = wadlParams.downloadType;
            if ((i3 == 2 || i3 == 4) && !checkLocalVersion(wadlTask.createTime, wadlTask.mWadlParams, wadlParams)) {
                QLog.w(TAG, 1, "checkTaskVersion by auto download, checkLocalVersion false");
                return false;
            }
        }
        wadlParams.flags = wadlTask.mWadlParams.flags;
        return true;
    }

    private boolean comparisonUrl(String str, String str2) {
        Uri parse;
        Uri parse2;
        try {
            parse = Uri.parse(str);
            parse2 = Uri.parse(str2);
            QLog.d(TAG, 1, "comparisonUrl oldURI.host=" + parse.getHost() + ",requestURI.host=" + parse2.getHost() + ",oldURI.path=" + parse.getPath() + ",requestURI.path=" + parse2.getPath());
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "comparisonUrl exception", th5);
        }
        if (parse.getHost().equalsIgnoreCase(parse2.getHost())) {
            if (parse.getPath().equalsIgnoreCase(parse2.getPath())) {
                return true;
            }
            return false;
        }
        return false;
    }

    private void download(WadlTask wadlTask, WadlParams wadlParams) {
        String str;
        updateParams(wadlTask.mWadlParams, wadlParams);
        wadlTask.clearCloseFloatFlag();
        wadlTask.onTaskStarted();
        String isApkExist = GameCenterUtil.isApkExist(wadlTask.appId, wadlTask.businessId, wadlTask.mWadlParams.versionCode);
        QLog.d(TAG, 1, "download find LocalApkPath=" + isApkExist);
        if (TextUtils.isEmpty(isApkExist)) {
            String createFileNameBySuffix = GameCenterUtil.createFileNameBySuffix(wadlTask.appId, wadlTask.mWadlParams.versionCode, ".apk");
            String str2 = GameCenterUtil.getDownloadResDir(wadlTask.appId, 4) + "/" + createFileNameBySuffix;
            QLog.d(TAG, 1, "download find TGPA tgpaResPath=" + str2);
            if (GameCenterUtil.fileExists(str2)) {
                str = "from local preload";
                isApkExist = str2;
            } else {
                str = "";
            }
        } else {
            str = "from local apk";
        }
        if (!TextUtils.isEmpty(isApkExist)) {
            long length = new File(isApkExist).length();
            wadlTask.fileSize = length;
            wadlTask.downloadFileSize = length;
            wadlTask.createTime = System.currentTimeMillis();
            wadlTask.initProgress();
            wadlTask.onTaskCompleted(isApkExist, 0L, str);
            return;
        }
        WadlTgpaTaskMgr.getInstance().pauseResByAppid(wadlParams.appId);
        if (wadlTask.isRequireWifi() && !AppNetConnInfo.isWifiConn()) {
            QLog.w(TAG, 1, "download pauseDownload, because is not Wifi");
            wadlTask.pauseDownload("4");
            return;
        }
        QLog.d(TAG, 1, "download setSpeedBuffer=" + wadlTask.mWadlParams.speedBuffer);
        if (wadlTask.mWadlParams.speedBuffer < 1) {
            WadlAgentV2Adapter.getInstance().setSpeedBuffer(0);
        } else {
            WadlAgentV2Adapter.getInstance().setSpeedBuffer(wadlTask.mWadlParams.speedBuffer);
        }
        QLog.d(TAG, 1, "start download, task=" + wadlTask);
        wadlTask.startDownload();
    }

    private boolean handleBroadcastAction(String str, Bundle bundle) {
        if (WadlProxyConsts.REMOTE_CMD_APP_INSTALLED.equals(str)) {
            String string = bundle.getString("packageName");
            int i3 = bundle.getInt("actionFrom", 0);
            QLog.d(TAG, 1, "doInstallAppCompleted actionFrom=" + i3 + ", packageName=" + string);
            this.taskMgr.appInstalled(i3, string);
            return true;
        }
        if (!WadlProxyConsts.REMOTE_CMD_APP_UNINSTALLED.equals(str)) {
            return false;
        }
        String string2 = bundle.getString("packageName");
        QLog.d(TAG, 1, "doUninstallAppCompleted packageName=" + string2);
        this.taskMgr.appUninstalled(string2);
        return true;
    }

    private boolean handleDownloadAction(String str, Bundle bundle) {
        WadlParams wadlParams;
        String string = bundle.getString("appId");
        if (WadlProxyConsts.REMOTE_CMD_APP_DOWNLOAD_ACTION.equals(str)) {
            WadlParams wadlParams2 = (WadlParams) bundle.getParcelable(WadlProxyConsts.PARAM_DOWNLOAD_INFO);
            QLog.d(TAG, 1, "doDownloadAction requestParams=" + wadlParams2);
            handleDownload(wadlParams2);
            return true;
        }
        if (WadlProxyConsts.REMOTE_CMD_APP_RESUME_ACTION.equals(str)) {
            WadlTask findWadlTask = this.taskMgr.findWadlTask(string);
            QLog.d(TAG, 1, "doResumeAction t=" + findWadlTask);
            if (findWadlTask != null && (wadlParams = findWadlTask.mWadlParams) != null) {
                wadlParams.setFlagDisable(8);
                handleDownload(findWadlTask.mWadlParams);
            }
            return true;
        }
        if (WadlProxyConsts.REMOTE_CMD_APP_DELETE_ACTION.equals(str)) {
            QLog.d(TAG, 1, "doDeleteAction from=" + bundle.getInt("actionFrom") + ",appId=" + string);
            this.wadlChecker.cancel(string);
            this.taskMgr.deleteWadlTask(string, true, WadlProxyConsts.DELETE_FROM_CMD_DELETE_ACTION);
            return true;
        }
        if (!WadlProxyConsts.REMOTE_CMD_APP_PAUSE_ACTION.equals(str)) {
            return false;
        }
        String string2 = bundle.getString(WadlProxyConsts.SCENE_ID, "3");
        QLog.d(TAG, 1, "doPauseAction appId=" + string + ", sceneId=" + string2);
        this.wadlChecker.cancel(string);
        WadlTask findWadlTask2 = this.taskMgr.findWadlTask(string);
        if (findWadlTask2 != null) {
            findWadlTask2.clearCloseFloatFlag();
            findWadlTask2.pauseDownload(string2);
            findWadlTask2.interruptedFlag = false;
            findWadlTask2.isPausedByWifiDisconnected = false;
        }
        return true;
    }

    private boolean handleInstallAction(String str, WadlRequest wadlRequest) {
        if (WadlProxyConsts.REMOTE_CMD_APP_INSTALL_ACTION.equals(str)) {
            WadlPackageMgr.getInstance().install(wadlRequest);
            return true;
        }
        return false;
    }

    private boolean handleQueryAction(String str, Bundle bundle) {
        if (WadlProxyConsts.REMOTE_CMD_APP_QUERY_ID_ACTION.equals(str)) {
            Bundle bundle2 = new Bundle();
            ArrayList<WadlResult> queryWadlTask = this.taskMgr.queryWadlTask(bundle.getStringArrayList(WadlProxyConsts.PARAM_APPID_LIS));
            QLog.d(TAG, 1, "doQueryAction result size:" + queryWadlTask.size());
            bundle2.putParcelableArrayList("query_result", queryWadlTask);
            WadlProxyService c16 = WadlProxyService.c();
            if (c16 != null) {
                c16.f(WadlProxyConsts.REMOTE_REVERSE_ONQUERY_RESULT, bundle2);
            }
            return true;
        }
        if (WadlProxyConsts.REMOTE_CMD_APP_QUERY_VIA_ACTION.equals(str)) {
            String string = bundle.getString("via");
            Bundle bundle3 = new Bundle();
            ArrayList<WadlResult> queryWadlTaskByVia = this.taskMgr.queryWadlTaskByVia(string);
            QLog.d(TAG, 1, "doQueryActionByVia result size:" + queryWadlTaskByVia.size());
            bundle3.putParcelableArrayList("query_result", queryWadlTaskByVia);
            WadlProxyService c17 = WadlProxyService.c();
            if (c17 != null) {
                c17.f(WadlProxyConsts.REMOTE_REVERSE_ONQUERY_VIA_RESULT, bundle3);
            }
            return true;
        }
        if (!WadlProxyConsts.REMOTE_CMD_QUERY_TASK.equals(str)) {
            return false;
        }
        Bundle bundle4 = new Bundle();
        ArrayList<WadlResult> queryAllWadlTask = this.taskMgr.queryAllWadlTask(false);
        QLog.d(TAG, 1, "doQueryAllTask result size:" + queryAllWadlTask.size());
        bundle4.putInt("businessId", this.businessId);
        bundle4.putParcelableArrayList("query_result", queryAllWadlTask);
        if (bundle != null && bundle.containsKey(WadlProxyConsts.PARAM_IS_PRELOAD)) {
            bundle4.putBoolean(WadlProxyConsts.PARAM_IS_PRELOAD, bundle.getBoolean(WadlProxyConsts.PARAM_IS_PRELOAD));
        }
        WadlProxyService c18 = WadlProxyService.c();
        if (c18 != null) {
            c18.f(WadlProxyConsts.REMOTE_REVERSE_ONQUERY_ALL_TASK, bundle4);
        }
        return true;
    }

    private boolean handleReportInstallRequest(String str, Bundle bundle) {
        WadlTask findWadlTask;
        if (!WadlProxyConsts.REMOTE_CMD_REPORT_INSTALL_REQUEST.equals(str)) {
            return false;
        }
        String string = bundle.getString("appid");
        boolean z16 = bundle.getBoolean("isForeground", false);
        if (!TextUtils.isEmpty(string) && (findWadlTask = this.taskMgr.findWadlTask(string)) != null && findWadlTask.mWadlParams != null) {
            ((IQQGameDLReportService) QRoute.api(IQQGameDLReportService.class)).onRequestInstall(findWadlTask.mWadlParams, z16);
            return true;
        }
        return true;
    }

    private boolean handleSetSpeedBuffer(String str, Bundle bundle) {
        if (WadlProxyConsts.REMOTE_CMD_SET_SPEED_BUFFER.equals(str)) {
            WadlAgentV2Adapter.getInstance().setSpeedBuffer(bundle.getInt(WadlProxyConsts.PARAM_SPEED_BUFFER));
            return true;
        }
        return false;
    }

    private boolean handleSyncTaskData(String str, Bundle bundle) {
        int i3 = 0;
        if (!WadlProxyConsts.REMOTE_CMD_SYNC_TASK_DATA.equals(str)) {
            return false;
        }
        ArrayList<WadlResult> parcelableArrayList = bundle.getParcelableArrayList("query_result");
        StringBuilder sb5 = new StringBuilder();
        sb5.append("handleSyncTaskData wadlResults size:");
        if (parcelableArrayList != null) {
            i3 = parcelableArrayList.size();
        }
        sb5.append(i3);
        QLog.d(TAG, 1, sb5.toString());
        this.taskMgr.syncTaskData(parcelableArrayList);
        return true;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.ipc.WadlHandlerInterface
    public void clearAllTask() {
        ArrayList<WadlResult> queryAllWadlTask = this.taskMgr.queryAllWadlTask(true);
        if (queryAllWadlTask != null && !queryAllWadlTask.isEmpty()) {
            QLog.d(TAG, 1, "clearAllTask rs size=" + queryAllWadlTask.size());
            Iterator<WadlResult> it = queryAllWadlTask.iterator();
            while (it.hasNext()) {
                WadlResult next = it.next();
                this.wadlChecker.cancel(next.wadlParams.appId);
                this.taskMgr.deleteWadlTask(next.wadlParams.appId, true, WadlProxyConsts.DELETE_FROM_CMD_DELETE_ALL_ACTION);
            }
            return;
        }
        QLog.d(TAG, 1, "clearAllTask rs is empty");
    }

    public void handleDownload(WadlParams wadlParams) {
        if (wadlParams != null && !TextUtils.isEmpty(wadlParams.apkUrl)) {
            if (!TextUtils.isEmpty(wadlParams.packageName)) {
                wadlParams.packageName = wadlParams.packageName.trim();
            }
            if (!TextUtils.isEmpty(wadlParams.appId)) {
                wadlParams.appId = wadlParams.appId.trim();
            }
            WadlTask findWadlTask = this.taskMgr.findWadlTask(wadlParams.appId);
            if (findWadlTask != null && (!findWadlTask.isValid() || !checkTaskVersion(findWadlTask, wadlParams))) {
                this.taskMgr.deleteWadlTask(findWadlTask.appId, false, WadlProxyConsts.DELETE_FROM_HANDLE_DOWNLOAD);
                findWadlTask = null;
            }
            if (findWadlTask != null) {
                WadlReportManager.handleReportDownload(wadlParams);
                WadlParams wadlParams2 = findWadlTask.mWadlParams;
                if (wadlParams2 != null) {
                    wadlParams2.isDirectUseDualWay = wadlParams.isDirectUseDualWay;
                }
                ((IQQGameDLReportService) QRoute.api(IQQGameDLReportService.class)).onResumeAction(findWadlTask.mWadlParams);
                download(findWadlTask, wadlParams);
                return;
            }
            this.wadlChecker.check(wadlParams);
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.ipc.WadlHandlerInterface
    public void handleRemoteActionNotify(WadlRequest wadlRequest) {
        if (handleSetSpeedBuffer(wadlRequest.f106594e, wadlRequest.f106596h) || handleSyncTaskData(wadlRequest.f106594e, wadlRequest.f106596h)) {
            return;
        }
        WadlReportManager.reportEvent(wadlRequest);
        if (handleQueryAction(wadlRequest.f106594e, wadlRequest.f106596h) || handleDownloadAction(wadlRequest.f106594e, wadlRequest.f106596h) || handleBroadcastAction(wadlRequest.f106594e, wadlRequest.f106596h) || handleInstallAction(wadlRequest.f106594e, wadlRequest) || handleReportInstallRequest(wadlRequest.f106594e, wadlRequest.f106596h)) {
            return;
        }
        QLog.w(TAG, 1, "handleRemoteActionNotify UnKnow cmdId=" + wadlRequest.f106594e);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.ipc.WadlHandlerInterface
    public boolean isActive(boolean z16) {
        long j3;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.lastDownloadTime == 0) {
            if (z16) {
                return false;
            }
            this.lastDownloadTime = elapsedRealtime;
        }
        long j16 = elapsedRealtime - this.lastDownloadTime;
        if (z16) {
            j3 = 120000;
        } else {
            j3 = 300000;
        }
        if (j16 > j3) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.ipc.WadlHandlerInterface
    public void notifyEventObserver(int i3, boolean z16, WadlTask wadlTask) {
        this.taskMgr.notifyEventObserver(i3, z16, wadlTask);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.checker.WadlChecker.ICheckListener
    public void onCheckDone(WadlParams wadlParams, WadlCheckResult wadlCheckResult) {
        WadlParams wadlParams2;
        WadlTask findWadlTask = this.taskMgr.findWadlTask(wadlParams.appId);
        QLog.d(TAG, 1, "onCheckDone requestParams=" + wadlParams + ",checkResult=" + wadlCheckResult + ",findTask=" + findWadlTask);
        if (!wadlCheckResult.isSucc || wadlCheckResult.fileSize < 1) {
            QLog.w(TAG, 1, "onCheckDone fail, appId=" + wadlParams.appId + ",pkgSize=" + wadlParams.pkgSize);
            wadlCheckResult.fileSize = wadlParams.pkgSize;
        }
        if (findWadlTask == null) {
            if (wadlCheckResult.isIPv6) {
                wadlParams.setFlags(32768);
            }
            QLog.d(TAG, 1, "onCheckDone create new task,params=" + wadlParams);
            findWadlTask = new WadlTaskV2(1, wadlParams);
            findWadlTask.fileSize = wadlCheckResult.fileSize;
            this.taskMgr.addWadlTask(findWadlTask);
            wadlParams2 = wadlParams;
        } else {
            wadlParams2 = findWadlTask.mWadlParams;
        }
        WadlReportManager.handleReportDownload(wadlParams);
        ((IQQGameDLReportService) QRoute.api(IQQGameDLReportService.class)).onStartDownload(wadlParams2);
        if (wadlCheckResult.fileSize < 1) {
            findWadlTask.onTaskStarted();
            findWadlTask.onTaskFailed(1000, wadlCheckResult.errMsg);
        } else {
            download(findWadlTask, wadlParams);
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.ipc.WadlHandlerInterface
    public void onCreate() {
        QLog.d(TAG, 1, "onCreate");
        this.taskMgr.restartUnfinishedTask();
    }

    @Override // com.tencent.gamecenter.wadl.sdk.ipc.WadlHandlerInterface
    public void onDestroy() {
        QLog.i(TAG, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        WadlChecker wadlChecker = this.wadlChecker;
        if (wadlChecker != null) {
            wadlChecker.onDestroy();
        }
        WadlGameCenterTaskMgr wadlGameCenterTaskMgr = this.taskMgr;
        if (wadlGameCenterTaskMgr != null) {
            wadlGameCenterTaskMgr.onDestroy();
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.ipc.WadlHandlerInterface
    public void pauseAllDownloadTask(boolean z16) {
        QLog.d(TAG, 1, "pauseAllDownloadTask isPausedByNet=" + z16);
        this.taskMgr.pauseAllDownloadTask(z16);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.ipc.WadlHandlerInterface
    public void refreshLastActiveTime() {
        this.lastDownloadTime = SystemClock.elapsedRealtime();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "refreshLastActiveTime lastDownloadTime=" + this.lastDownloadTime);
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.ipc.WadlHandlerInterface
    public void resumeAllDownloadTask() {
        QLog.d(TAG, 1, "resumeAllDownloadTask");
        this.taskMgr.resumeAllTaskForReConn();
    }

    public void updateParams(WadlParams wadlParams, WadlParams wadlParams2) {
        wadlParams.setFlags(wadlParams2.flags);
        if (!wadlParams2.getFlagEnable(8)) {
            wadlParams.setFlagDisable(8);
        }
        wadlParams.ignoreSpace = Math.max(wadlParams2.ignoreSpace, wadlParams.ignoreSpace);
        wadlParams.fromWebUrl = wadlParams2.fromWebUrl;
        wadlParams.speedBuffer = wadlParams2.speedBuffer;
        wadlParams.isDualDownload = wadlParams2.isDualDownload;
        wadlParams.isDirectUseDualWay = wadlParams2.isDirectUseDualWay;
        wadlParams.dualSwitch = wadlParams2.dualSwitch;
    }
}
