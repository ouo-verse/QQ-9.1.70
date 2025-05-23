package com.tencent.gamecenter.wadl.sdk.ipc;

import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamecenter.wadl.api.WadlRequest;
import com.tencent.gamecenter.wadl.api.impl.WadlProxyService;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.sdk.app.WadlVMReportManager;
import com.tencent.gamecenter.wadl.sdk.checker.WadlCheckResult;
import com.tencent.gamecenter.wadl.sdk.checker.WadlChecker;
import com.tencent.gamecenter.wadl.sdk.dlapt.WadlAgentV2Adapter;
import com.tencent.gamecenter.wadl.sdk.dlmgr.WadlPackageMgr;
import com.tencent.gamecenter.wadl.sdk.dlmgr.WadlTask;
import com.tencent.gamecenter.wadl.sdk.dlmgr.WadlTaskV2;
import com.tencent.gamecenter.wadl.sdk.dlmgr.WadlVMTaskManager;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlVMHandler implements WadlHandlerInterface, WadlChecker.ICheckListener {
    private static final String TAG = "VM_WadlVMHandler";
    private static final long TIMEOUT_2 = 120000;
    private static final long TIMEOUT_5 = 300000;
    private int businessId;
    private long lastDownloadTime;
    private WadlVMTaskManager taskMgr = WadlVMTaskManager.getInstance();
    private WadlChecker wadlChecker;
    private WadlPackageMgr wadlPackageMgr;

    public WadlVMHandler(int i3) {
        this.businessId = i3;
        QLog.d(TAG, 1, "WadlVMTaskManager init");
        WadlChecker wadlChecker = new WadlChecker();
        this.wadlChecker = wadlChecker;
        wadlChecker.setCheckListener(this);
        WadlPackageMgr wadlPackageMgr = WadlPackageMgr.getInstance();
        this.wadlPackageMgr = wadlPackageMgr;
        this.taskMgr.addObserver(wadlPackageMgr);
        QLog.d(TAG, 1, "addObserver done");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0083, code lost:
    
        if (r1.getPath().equalsIgnoreCase(r4.getPath()) == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean checkTaskVersion(WadlTask wadlTask, WadlParams wadlParams) {
        if (wadlTask.isTestVersion()) {
            if (!wadlParams.getFlagEnable(4096)) {
                return false;
            }
            if (!wadlParams.isExtFlagEnable(2)) {
                try {
                    Uri parse = Uri.parse(wadlTask.mWadlParams.apkUrl);
                    Uri parse2 = Uri.parse(wadlParams.apkUrl);
                    QLog.d(TAG, 1, "checkTaskVersion oldURI.host=" + parse.getHost() + ",requestURI.host=" + parse2.getHost() + ",oldURI.path=" + parse.getPath() + ",requestURI.path=" + parse2.getPath());
                    if (parse.getHost().equalsIgnoreCase(parse2.getHost())) {
                    }
                    return false;
                } catch (Throwable th5) {
                    QLog.e(TAG, 1, "checkTaskVersion exception", th5);
                }
            }
        }
        wadlParams.flags = wadlTask.mWadlParams.flags;
        return true;
    }

    private void download(WadlTask wadlTask, WadlParams wadlParams) {
        updateParams(wadlTask.mWadlParams, wadlParams);
        wadlTask.onTaskStarted();
        String isApkExist = GameCenterUtil.isApkExist(wadlTask.appId, wadlTask.businessId, wadlTask.mWadlParams.versionCode);
        QLog.d(TAG, 1, "download findLocalApkPath=" + isApkExist);
        if (!TextUtils.isEmpty(isApkExist)) {
            long length = new File(isApkExist).length();
            wadlTask.fileSize = length;
            wadlTask.downloadFileSize = length;
            wadlTask.createTime = System.currentTimeMillis();
            wadlTask.onTaskCompleted(isApkExist, 0L, "from local apk");
            return;
        }
        if (wadlTask.isRequireWifi() && !AppNetConnInfo.isWifiConn()) {
            QLog.w(TAG, 1, "download pauseDownload, because is not Wifi");
            wadlTask.pauseDownload("4");
            return;
        }
        QLog.d(TAG, 1, "start download, task=" + wadlTask);
        wadlTask.startDownload();
    }

    private boolean handleBroadcastAction(String str, Bundle bundle) {
        if (TextUtils.equals(str, WadlProxyConsts.REMOTE_CMD_APP_INSTALLED)) {
            String string = bundle.getString("packageName");
            QLog.d(TAG, 1, "doInstallAppCompleted packageName=" + string);
            this.taskMgr.appInstalled(string);
            return true;
        }
        return false;
    }

    private boolean handleDownloadAction(String str, Bundle bundle) {
        WadlParams wadlParams;
        String string = bundle.getString("packageName");
        if (WadlProxyConsts.REMOTE_CMD_APP_DOWNLOAD_ACTION.equals(str)) {
            WadlParams wadlParams2 = (WadlParams) bundle.getParcelable(WadlProxyConsts.PARAM_DOWNLOAD_INFO);
            QLog.d(TAG, 1, "handleDownloadAction wadlParams=" + wadlParams2);
            handleDownload(wadlParams2);
            return true;
        }
        if (WadlProxyConsts.REMOTE_CMD_APP_RESUME_ACTION.equals(str)) {
            QLog.d(TAG, 1, "doResumeAction packageName=" + string);
            WadlTask findTaskByPkgName = this.taskMgr.findTaskByPkgName(string);
            if (findTaskByPkgName != null && (wadlParams = findTaskByPkgName.mWadlParams) != null) {
                wadlParams.setFlagDisable(8);
                handleDownload(findTaskByPkgName.mWadlParams);
            }
            return true;
        }
        if (WadlProxyConsts.REMOTE_CMD_APP_DELETE_ACTION.equals(str)) {
            QLog.d(TAG, 1, "doDeleteAction packageName=" + string);
            this.taskMgr.deleteWadlTask(string, true);
            return true;
        }
        if (!WadlProxyConsts.REMOTE_CMD_APP_PAUSE_ACTION.equals(str)) {
            return false;
        }
        QLog.d(TAG, 1, "doPauseAction packageName=" + string);
        WadlTask findTaskByPkgName2 = this.taskMgr.findTaskByPkgName(string);
        if (findTaskByPkgName2 != null) {
            findTaskByPkgName2.pauseDownload(bundle.getString(WadlProxyConsts.SCENE_ID, ""));
            findTaskByPkgName2.interruptedFlag = false;
            findTaskByPkgName2.isPausedByWifiDisconnected = false;
        }
        return true;
    }

    private boolean handleInstallAction(String str, WadlRequest wadlRequest) {
        if (TextUtils.equals(str, WadlProxyConsts.REMOTE_CMD_APP_INSTALL_ACTION)) {
            WadlPackageMgr.getInstance().install(wadlRequest);
            return true;
        }
        return false;
    }

    private boolean handleQueryAction(String str, Bundle bundle) {
        if (!WadlProxyConsts.REMOTE_CMD_QUERY_TASK.equals(str)) {
            return false;
        }
        Bundle bundle2 = new Bundle();
        ArrayList<WadlResult> queryAllWadlTask = this.taskMgr.queryAllWadlTask(false);
        QLog.d(TAG, 1, "handleQueryAction result size:" + queryAllWadlTask.size());
        bundle2.putInt("businessId", this.businessId);
        bundle2.putParcelableArrayList("query_result", queryAllWadlTask);
        if (bundle != null && bundle.containsKey(WadlProxyConsts.PARAM_IS_PRELOAD)) {
            bundle2.putBoolean(WadlProxyConsts.PARAM_IS_PRELOAD, bundle.getBoolean(WadlProxyConsts.PARAM_IS_PRELOAD));
        }
        WadlProxyService c16 = WadlProxyService.c();
        if (c16 != null) {
            c16.f(WadlProxyConsts.REMOTE_REVERSE_ONQUERY_ALL_TASK, bundle2);
        }
        return true;
    }

    private boolean handleSetSpeedBuffer(String str, Bundle bundle) {
        if (WadlProxyConsts.REMOTE_CMD_SET_SPEED_BUFFER.equals(str)) {
            int i3 = bundle.getInt(WadlProxyConsts.PARAM_SPEED_BUFFER);
            QLog.d(TAG, 1, "handleSetSpeedBuffer speedBuffer:" + i3);
            WadlAgentV2Adapter.getInstance().setSpeedBuffer(i3);
            return true;
        }
        return false;
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
                this.taskMgr.deleteWadlTask(next.wadlParams.packageName, true);
            }
            return;
        }
        QLog.d(TAG, 1, "clearAllTask rs is empty");
    }

    public void handleDownload(WadlParams wadlParams) {
        if (wadlParams != null && !TextUtils.isEmpty(wadlParams.apkUrl)) {
            WadlTask findTaskByPkgName = this.taskMgr.findTaskByPkgName(wadlParams.packageName);
            if (findTaskByPkgName != null && (!findTaskByPkgName.isValid() || !checkTaskVersion(findTaskByPkgName, wadlParams))) {
                this.taskMgr.deleteWadlTask(findTaskByPkgName.pkgName, false);
                findTaskByPkgName = null;
            }
            if (findTaskByPkgName != null) {
                WadlVMReportManager.handleReportDownload(wadlParams);
                download(findTaskByPkgName, wadlParams);
            } else {
                this.wadlChecker.check(wadlParams);
            }
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.ipc.WadlHandlerInterface
    public void handleRemoteActionNotify(WadlRequest wadlRequest) {
        if (handleSetSpeedBuffer(wadlRequest.f106594e, wadlRequest.f106596h)) {
            return;
        }
        WadlVMReportManager.reportEvent(wadlRequest);
        if (handleQueryAction(wadlRequest.f106594e, wadlRequest.f106596h) || handleDownloadAction(wadlRequest.f106594e, wadlRequest.f106596h) || handleBroadcastAction(wadlRequest.f106594e, wadlRequest.f106596h) || handleInstallAction(wadlRequest.f106594e, wadlRequest)) {
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
        WadlTask findTaskByPkgName = this.taskMgr.findTaskByPkgName(wadlParams.packageName);
        QLog.d(TAG, 1, "onCheckDone requestParams=" + wadlParams + ",checkResult=" + wadlCheckResult + ",findTask=" + findTaskByPkgName);
        if (findTaskByPkgName == null) {
            QLog.d(TAG, 1, "onCheckDone create new task, params=" + wadlParams);
            findTaskByPkgName = new WadlTaskV2(3, wadlParams);
            findTaskByPkgName.fileSize = wadlCheckResult.fileSize;
            this.taskMgr.addWadlTask(findTaskByPkgName);
        }
        WadlVMReportManager.handleReportDownload(wadlParams);
        if (wadlCheckResult.isSucc && wadlCheckResult.fileSize >= 1) {
            download(findTaskByPkgName, wadlParams);
        } else {
            findTaskByPkgName.onTaskStarted();
            findTaskByPkgName.onTaskFailed(1000, wadlCheckResult.errMsg);
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
        WadlVMTaskManager wadlVMTaskManager = this.taskMgr;
        if (wadlVMTaskManager != null) {
            wadlVMTaskManager.onDestroy();
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
        if (QLog.isDebugVersion()) {
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
        wadlParams.ignoreSpace = Math.max(wadlParams2.ignoreSpace, wadlParams.ignoreSpace);
        wadlParams.speedBuffer = wadlParams2.speedBuffer;
        wadlParams.fromWebUrl = wadlParams2.fromWebUrl;
        wadlParams.isDualDownload = wadlParams2.isDualDownload;
        wadlParams.isDirectUseDualWay = wadlParams2.isDirectUseDualWay;
    }
}
