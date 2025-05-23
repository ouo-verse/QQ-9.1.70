package com.tencent.gamecenter.wadl.sdk.ipc;

import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamecenter.wadl.api.WadlRequest;
import com.tencent.gamecenter.wadl.api.impl.WadlProxyService;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.sdk.app.WadlReportManager;
import com.tencent.gamecenter.wadl.sdk.checker.WadlCheckResult;
import com.tencent.gamecenter.wadl.sdk.checker.WadlChecker;
import com.tencent.gamecenter.wadl.sdk.dlcom.WadlUtils;
import com.tencent.gamecenter.wadl.sdk.dlmgr.WadlGameCenterTaskMgr;
import com.tencent.gamecenter.wadl.sdk.dlmgr.WadlTask;
import com.tencent.gamecenter.wadl.sdk.dlmgr.WadlTaskV2;
import com.tencent.gamecenter.wadl.sdk.dlmgr.WadlTgpaTaskMgr;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlTgpaHandler implements WadlHandlerInterface, WadlChecker.ICheckListener {
    private static final String TAG = "Wadl_WadlTgpaHandler";
    private static final long TIMEOUT_2 = 120000;
    private int businessId;
    private long lastDownloadTime;
    private WadlTgpaTaskMgr resMgr = WadlTgpaTaskMgr.getInstance();
    private WadlChecker wadlChecker;

    public WadlTgpaHandler(int i3) {
        this.businessId = i3;
        QLog.d(TAG, 1, "WadlResMgr init");
        WadlChecker wadlChecker = new WadlChecker();
        this.wadlChecker = wadlChecker;
        wadlChecker.setCheckListener(this);
    }

    private void download(WadlTask wadlTask, WadlParams wadlParams) {
        WadlParams wadlParams2;
        updateParams(wadlTask.mWadlParams, wadlParams);
        if (wadlParams.resType == 4) {
            WadlTask findWadlTask = WadlGameCenterTaskMgr.getInstance().findWadlTask(wadlParams.appId);
            if (findWadlTask != null && (wadlParams2 = findWadlTask.mWadlParams) != null && wadlParams.versionCode <= wadlParams2.versionCode) {
                QLog.w(TAG, 1, "download TGPA apk cancel, local apk task version=" + findWadlTask.mWadlParams.versionCode + ",resVersion=" + wadlParams.versionCode);
                this.resMgr.delRes(false, wadlParams.resType, null, null, wadlParams.getResId());
                return;
            }
            String isApkExist = GameCenterUtil.isApkExist(wadlParams.appId, 1, wadlParams.versionCode);
            if (!TextUtils.isEmpty(isApkExist)) {
                QLog.w(TAG, 1, "download TGPA apk cancel, localApkPath=" + isApkExist);
                this.resMgr.delRes(false, wadlParams.resType, null, null, wadlParams.getResId());
                return;
            }
        }
        boolean fileExists = WadlUtils.fileExists(wadlTask.downloadFilePath);
        QLog.w(TAG, 1, "download TGPA  fileExists=" + fileExists + ", downloadFilePath=" + wadlTask.downloadFilePath);
        if (fileExists) {
            long length = new File(wadlTask.downloadFilePath).length();
            wadlTask.fileSize = length;
            wadlTask.downloadFileSize = length;
            wadlTask.createTime = System.currentTimeMillis();
            wadlTask.initProgress();
            wadlTask.onTaskCompleted(wadlTask.downloadFilePath, 0L, "from local apk");
            return;
        }
        wadlTask.onTaskStarted();
        if (wadlTask.isRequireWifi() && !AppNetConnInfo.isWifiConn()) {
            QLog.w(TAG, 1, "download pauseDownload, because is not Wifi");
            wadlTask.pauseDownload("4");
            return;
        }
        QLog.d(TAG, 1, "start download, task=" + wadlTask);
        wadlTask.startDownload();
    }

    private boolean handleDownloadAction(String str, Bundle bundle) {
        WadlParams wadlParams;
        QLog.d(TAG, 1, "handleDownloadAction strNotifyCmd=" + str);
        if (WadlProxyConsts.REMOTE_CMD_APP_DOWNLOAD_ACTION.equals(str)) {
            handleDownload((WadlParams) bundle.getParcelable(WadlProxyConsts.PARAM_DOWNLOAD_INFO));
            return true;
        }
        if (WadlProxyConsts.REMOTE_CMD_APP_PAUSE_ACTION.equals(str)) {
            String string = bundle.getString("resId");
            this.wadlChecker.cancel(string);
            WadlTask wadlTask = this.resMgr.getWadlTask(string);
            if (wadlTask != null) {
                wadlTask.pauseDownload(bundle.getString(WadlProxyConsts.SCENE_ID, "3"));
                wadlTask.interruptedFlag = false;
                wadlTask.isPausedByWifiDisconnected = false;
            }
            return true;
        }
        if (WadlProxyConsts.REMOTE_CMD_APP_RESUME_ACTION.equals(str)) {
            WadlTask wadlTask2 = this.resMgr.getWadlTask(bundle.getString("resId"));
            if (wadlTask2 != null && (wadlParams = wadlTask2.mWadlParams) != null) {
                wadlParams.setFlagDisable(8);
                handleDownload(wadlTask2.mWadlParams);
            }
            return true;
        }
        if (!WadlProxyConsts.REMOTE_CMD_APP_DELETE_ACTION.equals(str)) {
            return false;
        }
        String string2 = bundle.getString("resId");
        String string3 = bundle.getString("packageName");
        String string4 = bundle.getString(WadlProxyConsts.PARAM_FILENAME);
        if (!TextUtils.isEmpty(string2)) {
            this.wadlChecker.cancel(string2);
        }
        this.resMgr.delRes(true, 0, string3, string4, string2);
        return true;
    }

    private boolean handleQueryAction(String str) {
        if (!WadlProxyConsts.REMOTE_CMD_QUERY_TASK.equals(str)) {
            return false;
        }
        Bundle bundle = new Bundle();
        ArrayList<WadlResult> queryAllWadlTask = this.resMgr.queryAllWadlTask(false);
        QLog.d(TAG, 1, "handleQueryAction result size:" + queryAllWadlTask.size());
        bundle.putInt("businessId", this.businessId);
        bundle.putParcelableArrayList("query_result", queryAllWadlTask);
        WadlProxyService c16 = WadlProxyService.c();
        if (c16 != null) {
            c16.f(WadlProxyConsts.REMOTE_REVERSE_ONQUERY_ALL_TASK, bundle);
        }
        return true;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.ipc.WadlHandlerInterface
    public void clearAllTask() {
        ArrayList<WadlResult> queryAllWadlTask = this.resMgr.queryAllWadlTask(true);
        if (queryAllWadlTask != null && !queryAllWadlTask.isEmpty()) {
            QLog.d(TAG, 1, "clearAllTask rs size=" + queryAllWadlTask.size());
            Iterator<WadlResult> it = queryAllWadlTask.iterator();
            while (it.hasNext()) {
                WadlResult next = it.next();
                this.wadlChecker.cancel(next.wadlParams.getResId());
                this.resMgr.delResForResId(true, next.wadlParams.getResId());
            }
            return;
        }
        QLog.d(TAG, 1, "clearAllTask rs is empty");
    }

    public void handleDownload(WadlParams wadlParams) {
        if (wadlParams != null && !TextUtils.isEmpty(wadlParams.apkUrl)) {
            WadlTask wadlTask = this.resMgr.getWadlTask(wadlParams.getResId());
            if (wadlTask != null) {
                if (!wadlTask.isValid()) {
                    WadlTgpaTaskMgr wadlTgpaTaskMgr = this.resMgr;
                    WadlParams wadlParams2 = wadlTask.mWadlParams;
                    wadlTgpaTaskMgr.delRes(false, wadlParams2.resType, null, null, wadlParams2.getResId());
                } else if (wadlTask.taskStatus == 6 && !WadlUtils.fileExists(wadlTask.downloadFilePath)) {
                    WadlTgpaTaskMgr wadlTgpaTaskMgr2 = this.resMgr;
                    WadlParams wadlParams3 = wadlTask.mWadlParams;
                    wadlTgpaTaskMgr2.delRes(false, wadlParams3.resType, null, null, wadlParams3.getResId());
                }
                wadlTask = null;
            }
            if (wadlTask != null) {
                WadlReportManager.handleReportDownload(wadlParams);
                download(wadlTask, wadlParams);
            } else {
                this.wadlChecker.check(wadlParams);
            }
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.ipc.WadlHandlerInterface
    public void handleRemoteActionNotify(WadlRequest wadlRequest) {
        WadlReportManager.reportEvent(wadlRequest);
        if (handleQueryAction(wadlRequest.f106594e) || handleDownloadAction(wadlRequest.f106594e, wadlRequest.f106596h)) {
            return;
        }
        QLog.w(TAG, 1, "handleRemoteActionNotify UnKnow cmdId=" + wadlRequest.f106594e);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.ipc.WadlHandlerInterface
    public boolean isActive(boolean z16) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.lastDownloadTime == 0) {
            if (z16) {
                return false;
            }
            this.lastDownloadTime = elapsedRealtime;
        }
        if (elapsedRealtime - this.lastDownloadTime > 120000) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.ipc.WadlHandlerInterface
    public void notifyEventObserver(int i3, boolean z16, WadlTask wadlTask) {
        this.resMgr.notifyEventObserver(i3, z16, wadlTask);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.checker.WadlChecker.ICheckListener
    public void onCheckDone(WadlParams wadlParams, WadlCheckResult wadlCheckResult) {
        WadlTask wadlTask = this.resMgr.getWadlTask(wadlParams.getResId());
        QLog.d(TAG, 1, "onCheckDone checkResult=" + wadlCheckResult + ",requestParams=" + wadlParams);
        if (wadlTask == null) {
            wadlTask = new WadlTaskV2(2, wadlParams);
            wadlTask.fileSize = wadlCheckResult.fileSize;
            this.resMgr.addWadlTask(wadlTask);
            QLog.d(TAG, 1, "onCheckDone create new task=" + wadlTask);
        } else {
            QLog.d(TAG, 1, "onCheckDone find old task=" + wadlTask);
        }
        WadlReportManager.handleReportDownload(wadlParams);
        if (wadlCheckResult.isSucc && wadlCheckResult.fileSize >= 1) {
            download(wadlTask, wadlParams);
        } else {
            wadlTask.onTaskStarted();
            wadlTask.onTaskFailed(1000, wadlCheckResult.errMsg);
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.ipc.WadlHandlerInterface
    public void onCreate() {
        QLog.d(TAG, 1, "onCreate");
        this.resMgr.restartUnfinishedTask();
    }

    @Override // com.tencent.gamecenter.wadl.sdk.ipc.WadlHandlerInterface
    public void onDestroy() {
        QLog.i(TAG, 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        WadlChecker wadlChecker = this.wadlChecker;
        if (wadlChecker != null) {
            wadlChecker.onDestroy();
        }
        WadlTgpaTaskMgr wadlTgpaTaskMgr = this.resMgr;
        if (wadlTgpaTaskMgr != null) {
            wadlTgpaTaskMgr.onDestroy();
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.ipc.WadlHandlerInterface
    public void pauseAllDownloadTask(boolean z16) {
        QLog.d(TAG, 1, "pauseAllDownloadTask isPausedByNet=" + z16);
        this.resMgr.pauseAllDownloadTask(z16);
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
        this.resMgr.resumeAllTaskForReConn();
    }

    public void updateParams(WadlParams wadlParams, WadlParams wadlParams2) {
        wadlParams.setFlags(wadlParams2.flags);
        if (!wadlParams2.getFlagEnable(8)) {
            wadlParams.setFlagDisable(8);
        }
        wadlParams.ignoreSpace = Math.max(wadlParams2.ignoreSpace, wadlParams.ignoreSpace);
        wadlParams.fromWebUrl = wadlParams2.fromWebUrl;
    }
}
