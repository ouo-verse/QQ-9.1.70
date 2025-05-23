package com.tencent.gamecenter.wadl.sdk.dlmgr;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.gamecenter.wadl.api.IQQGameDualDownloadService;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.biz.entity.f;
import com.tencent.gamecenter.wadl.sdk.dlapt.WadlTaskListener;
import com.tencent.gamecenter.wadl.sdk.dlcom.WadlUtils;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTask;
import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderTaskAttr;
import com.tencent.gamecenter.wadl.sdk.ipc.WadlHandlerFactory;
import com.tencent.gamecenter.wadl.sdk.ipc.WadlHandlerInterface;
import com.tencent.gamecenter.wadl.sdk.ipc.WadlRemoteHandler;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.mobileqq.minigame.api.IMiniGameVAUtilsApi;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.reporter.flow.TrafficFlowReporter;
import com.tencent.qqperf.reporter.flow.b;
import com.tencent.util.Pair;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes6.dex */
public class WadlTask extends f implements WadlTaskListener {
    public static final float DISK_RATE_1 = 1.1f;
    public static final float DISK_RATE_2 = 2.2f;
    public static final int FROM_FLOAT_PROGRESS = 1;
    public static final int FROM_INT_PROGRESS = 0;
    private static final String REPORT_FLOW_BUSINESS_SCENE = "Wadl_downloader";
    protected static final String TAG = "Wadl_WadlTask";
    public int businessId;
    public long costTime;
    public long createTime;
    public long downloadFileSize;
    public DownloaderTask downloaderTask;
    public int errCode;
    public long fileSize;
    public boolean interruptedFlag;
    public boolean isFinish;
    public boolean isPausedByWifiDisconnected;
    public boolean isStartedUnderWifi;
    float lastFloatProgress;
    int lastProgress;
    public long lastUpdateTime;
    public WadlParams mWadlParams;

    /* renamed from: msg, reason: collision with root package name */
    public String f107253msg;
    public String saveDir;
    public String saveName;
    private long beginFlow = -1;
    private int beginBattery = 0;

    public WadlTask(int i3, @NotNull WadlParams wadlParams) {
        this.businessId = i3;
        this.mWadlParams = wadlParams;
        this.appId = wadlParams.appId;
        this.pkgName = wadlParams.packageName;
        initSaveInfo();
        this.createTime = NetConnInfoCenter.getServerTimeMillis();
    }

    private int getReportFlowNetType() {
        if (NetworkUtil.isWifiConnected(MobileQQ.sMobileQQ)) {
            return 0;
        }
        if (((IQQGameDualDownloadService) QRoute.api(IQQGameDualDownloadService.class)).isKingCard()) {
            return 2;
        }
        return 1;
    }

    private void initSaveInfo() {
        int i3 = this.businessId;
        if (i3 == 2) {
            WadlParams wadlParams = this.mWadlParams;
            this.saveName = wadlParams.resName;
            if (!TextUtils.isEmpty(wadlParams.resDir)) {
                this.saveDir = this.mWadlParams.resDir;
                return;
            } else {
                WadlParams wadlParams2 = this.mWadlParams;
                this.saveDir = GameCenterUtil.getDownloadResDir(wadlParams2.appId, wadlParams2.resType);
                return;
            }
        }
        if (i3 == 3 && ((IMiniGameVAUtilsApi) QRoute.api(IMiniGameVAUtilsApi.class)).isApkDownloadInnerStorageEnable()) {
            IMiniGameVAUtilsApi iMiniGameVAUtilsApi = (IMiniGameVAUtilsApi) QRoute.api(IMiniGameVAUtilsApi.class);
            WadlParams wadlParams3 = this.mWadlParams;
            this.saveName = iMiniGameVAUtilsApi.getVaDownloadApkName(wadlParams3.appId, wadlParams3.versionCode, wadlParams3.extraData);
            IMiniGameVAUtilsApi iMiniGameVAUtilsApi2 = (IMiniGameVAUtilsApi) QRoute.api(IMiniGameVAUtilsApi.class);
            WadlParams wadlParams4 = this.mWadlParams;
            this.saveDir = iMiniGameVAUtilsApi2.getVaDownloadApkDir(wadlParams4.appId, wadlParams4.versionCode);
            QLog.d(TAG, 2, "initSaveInfo saveName:" + this.saveName + " saveDir:" + this.saveDir);
            return;
        }
        WadlParams wadlParams5 = this.mWadlParams;
        this.saveName = GameCenterUtil.createFileNameBySuffix(wadlParams5.appId, wadlParams5.versionCode, ".apk");
        this.saveDir = GameCenterUtil.getDownloadApkDir(this.businessId);
    }

    private boolean isEnd(int i3) {
        if (i3 != 1008 && i3 != 1005 && i3 != 1006 && i3 != 1007 && i3 != 5008 && i3 != 5005 && i3 != 5006 && i3 != 5007) {
            return false;
        }
        return true;
    }

    private void notifyEventOberver(int i3, boolean z16) {
        WadlRemoteHandler.getInstance().notifyEventObserver(this.businessId, i3, z16, this);
        if (this.beginFlow > -1 && isEnd(i3)) {
            reportFlow();
        }
    }

    private void reportFlow() {
        String str;
        long j3 = this.downloadFileSize - this.beginFlow;
        QLog.d(TAG, 1, "reportFlow flow=" + j3);
        if (j3 < 1) {
            return;
        }
        this.beginFlow = this.downloadFileSize;
        Pair<Integer, Integer> batteryValue = WadlUtils.getBatteryValue();
        int intValue = this.beginBattery - batteryValue.first.intValue();
        this.beginBattery = batteryValue.first.intValue();
        if (!TextUtils.isEmpty(this.mWadlParams.apkUrl)) {
            str = Uri.parse(this.mWadlParams.apkUrl).getHost();
        } else {
            str = "";
        }
        new WadlReportBuilder().setDcId(WadlProxyConsts.TAG_DC_00087).setOperId(WadlProxyConsts.OPER_ID_DOWNLOAD_FLOW).setOperType(WadlProxyConsts.OPER_TYPE_MONITOR).setGameAppId(this.mWadlParams.appId).setExt(32, this.mWadlParams.apkUrl).setExt(12, str).setExt(13, String.valueOf(j3)).setExt(16, String.valueOf(intValue)).report();
        reportFlowToQQ(j3, this.mWadlParams);
    }

    private void reportFlowToQQ(long j3, WadlParams wadlParams) {
        String str;
        b.a c16 = new b.a().b(5).g(getReportFlowNetType()).c(REPORT_FLOW_BUSINESS_SCENE);
        String str2 = "";
        if (wadlParams == null) {
            str = "";
        } else {
            str = wadlParams.apkUrl;
        }
        b.a k3 = c16.k(str);
        if (wadlParams != null) {
            str2 = wadlParams.fromWebUrl;
        }
        TrafficFlowReporter.r(k3.d(str2).f(Foreground.isCurrentProcessForeground() ? 1 : 0).e(String.valueOf(j3 / 1000)).a());
    }

    public boolean bCallback() {
        boolean z16;
        WadlParams wadlParams = this.mWadlParams;
        if (wadlParams != null && wadlParams.getFlagEnable(2)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return true;
        }
        int i3 = this.taskStatus;
        if (i3 != 6 && i3 != 12 && i3 != 9) {
            return false;
        }
        return true;
    }

    public void clearCloseFloatFlag() {
        WadlParams wadlParams = this.mWadlParams;
        if (wadlParams != null) {
            wadlParams.setFlagDisable(131072);
        }
    }

    public void deleteDownload(boolean z16) {
        QLog.d(TAG, 1, "deleteDownload callback=" + z16 + ",appId=" + this.appId);
        this.isFinish = true;
        WadlUtils.deleteFile(this.downloadFilePath);
        onTaskDeleted(z16);
    }

    public void fixStatus() {
        if (WadlUtils.isRuningTask(this.taskStatus)) {
            this.taskStatus = 5;
            this.interruptedFlag = true;
        } else {
            int i3 = this.taskStatus;
            if (i3 == 7) {
                this.taskStatus = 5;
            } else if (i3 == 9) {
                this.taskStatus = 6;
            }
        }
        if (this.taskStatus == 6 && !WadlUtils.fileExists(this.downloadFilePath)) {
            this.taskStatus = 0;
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.dlapt.WadlTaskListener
    public long getAverageSpeed() {
        return 0L;
    }

    public DownloaderTaskAttr getDownloadAttr() {
        DownloaderTask downloaderTask = this.downloaderTask;
        if (downloaderTask != null) {
            return downloaderTask.getAttribute();
        }
        return null;
    }

    public int getEventByStatus() {
        int i3;
        int i16 = 1007;
        switch (this.taskStatus) {
            case 0:
                if (this.mWadlParams.isRes) {
                    i3 = 5007;
                    i16 = i3;
                    break;
                }
                break;
            case 1:
            case 3:
            case 8:
            case 11:
            default:
                i16 = -1;
                break;
            case 2:
                if (this.mWadlParams.isRes) {
                    i3 = 5003;
                } else {
                    i3 = 1003;
                }
                i16 = i3;
                break;
            case 4:
                if (this.mWadlParams.isRes) {
                    i3 = 5004;
                } else {
                    i3 = 1004;
                }
                i16 = i3;
                break;
            case 5:
                if (this.mWadlParams.isRes) {
                    i3 = 5006;
                } else {
                    i3 = 1006;
                }
                i16 = i3;
                break;
            case 6:
                if (this.mWadlParams.isRes) {
                    i3 = 5008;
                } else {
                    i3 = 1008;
                }
                i16 = i3;
                break;
            case 7:
                if (this.mWadlParams.isRes) {
                    i3 = 5005;
                } else {
                    i3 = 1005;
                }
                i16 = i3;
                break;
            case 9:
            case 10:
                i16 = 2002;
                break;
            case 12:
                break;
            case 13:
                i16 = 1002;
                break;
            case 14:
                i16 = 2000;
                break;
        }
        QLog.i(TAG, 1, "[getEventByStatus] taskStatus:" + this.taskStatus + ",event:" + i16);
        return i16;
    }

    public float getPercentage(long j3, long j16) {
        if (j16 >= 1 && j3 >= 1) {
            return Math.round((((float) j3) / ((float) j16)) * 10000.0f) / 100.0f;
        }
        return 0.0f;
    }

    public WadlResult getWadlResult(int i3) {
        WadlResult wadlResult = new WadlResult(this.mWadlParams);
        wadlResult.event = i3;
        wadlResult.speed = getAverageSpeed();
        wadlResult.businessId = this.businessId;
        wadlResult.taskStatus = this.taskStatus;
        wadlResult.errCode = this.errCode;
        wadlResult.downloadFilePath = this.downloadFilePath;
        wadlResult.downloadFileSize = this.downloadFileSize;
        wadlResult.fileSize = this.fileSize;
        int i16 = this.lastProgress;
        if (i16 < 1) {
            i16 = 1;
        }
        wadlResult.progress = i16;
        wadlResult.floatProgress = this.lastFloatProgress;
        wadlResult.createTime = this.createTime;
        wadlResult.lastUpdateTime = NetConnInfoCenter.getServerTimeMillis();
        return wadlResult;
    }

    public void initProgress() {
        float percentage = getPercentage(this.downloadFileSize, this.fileSize);
        this.lastFloatProgress = percentage;
        this.lastProgress = (int) percentage;
    }

    public boolean isDownloadApkFileVersionCodeEqual() {
        String str;
        try {
            WadlParams wadlParams = this.mWadlParams;
            if (wadlParams != null) {
                str = wadlParams.packageName;
            } else {
                str = "";
            }
            int versionCode = WadlUtils.getVersionCode(str);
            int apkVersonCodeFromPath = GameCenterUtil.getApkVersonCodeFromPath(this.downloadFilePath);
            QLog.d(TAG, 1, "isDownloadApkFileVersionCodeEqual installedVersionCode=" + versionCode + ",apkFileVersionCode=" + apkVersonCodeFromPath);
            if (versionCode < 1 || apkVersonCodeFromPath < 1 || apkVersonCodeFromPath <= versionCode) {
                return true;
            }
            return false;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "isDownloadApkFileVersionCodeEqual exception", e16);
            return false;
        }
    }

    public boolean isRequireWifi() {
        WadlParams wadlParams = this.mWadlParams;
        if (wadlParams != null && wadlParams.getFlagEnable(8)) {
            return true;
        }
        return false;
    }

    public boolean isTestVersion() {
        WadlParams wadlParams = this.mWadlParams;
        if (wadlParams != null && wadlParams.getFlagEnable(4096)) {
            return true;
        }
        return false;
    }

    public boolean isValid() {
        if (this.mWadlParams != null && this.fileSize >= 1 && this.taskStatus != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.dlapt.WadlTaskListener
    public boolean onForceInstalled(int i3, String str) {
        WadlParams wadlParams;
        if (i3 != 10 || TextUtils.isEmpty(str) || (wadlParams = this.mWadlParams) == null || !str.equals(wadlParams.packageName)) {
            return false;
        }
        this.taskStatus = 9;
        notifyEventOberver(2002, true);
        return true;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.dlapt.WadlTaskListener
    public void onInstallStart() {
        WadlParams wadlParams = this.mWadlParams;
        if (wadlParams != null) {
            wadlParams.setFlagDisable(131072);
        }
        notifyEventOberver(1010, false);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.dlapt.WadlTaskListener
    public boolean onPackageInstalled(String str) {
        WadlParams wadlParams;
        QLog.i(TAG, 1, "onPackageInstalled appId=" + this.appId + ",packageName=" + str);
        if (TextUtils.isEmpty(str) || (wadlParams = this.mWadlParams) == null || !str.equals(wadlParams.packageName) || this.taskStatus != 6 || !isDownloadApkFileVersionCodeEqual()) {
            return false;
        }
        if (((IQQGameCommApi) QRoute.api(IQQGameCommApi.class)).isExistMiniApp(str) && !WadlProxyConsts.VIA_MINI_APP.equals(this.mWadlParams.via)) {
            return false;
        }
        this.taskStatus = 9;
        notifyEventOberver(2002, true);
        return true;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.dlapt.WadlTaskListener
    public void onTaskCompleted(String str, long j3, String str2) {
        this.downloadFilePath = str;
        this.costTime = j3;
        this.taskStatus = 6;
        this.errCode = 0;
        this.f107253msg = str2;
        clearCloseFloatFlag();
        QLog.d(TAG, 1, "onTaskCompleted " + this);
        if (this.mWadlParams.isRes) {
            notifyEventOberver(5008, true);
        } else {
            notifyEventOberver(1008, true);
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.dlapt.WadlTaskListener
    public void onTaskDeleted(boolean z16) {
        this.errCode = 0;
        this.taskStatus = 12;
        QLog.d(TAG, 1, "onTaskDeleted callback=" + z16 + " " + this);
        if (this.mWadlParams.isRes) {
            notifyEventOberver(5007, z16);
        } else {
            notifyEventOberver(1007, z16);
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.dlapt.WadlTaskListener
    public void onTaskDetected() {
        float f16;
        int i3;
        int i16;
        this.taskStatus = 13;
        long j3 = this.fileSize;
        if (j3 != -1 && !this.isFinish) {
            long j16 = j3 - this.downloadFileSize;
            QLog.d(TAG, 1, "onTaskDetected diffSize=" + j16 + "," + this);
            if (this.mWadlParams.from == 0) {
                f16 = 2.2f;
            } else {
                f16 = 1.1f;
            }
            if (!WadlUtils.isSdCardEnough(j16, f16)) {
                WadlParams wadlParams = this.mWadlParams;
                if (wadlParams.ignoreSpace == 0) {
                    this.taskStatus = 7;
                    this.errCode = 999;
                    if (wadlParams.isRes) {
                        i16 = 5005;
                    } else {
                        i16 = 1005;
                    }
                    notifyEventOberver(i16, true);
                    pauseDownload("4");
                    return;
                }
            }
            if (this.mWadlParams.isRes) {
                i3 = 5002;
            } else {
                i3 = 1002;
            }
            notifyEventOberver(i3, true);
            this.mWadlParams.pkgSize = this.fileSize;
            return;
        }
        QLog.w(TAG, 1, "onTaskDetected fail, fileSize=" + this.fileSize + ",isFinish=" + this.isFinish);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.dlapt.WadlTaskListener
    public void onTaskFailed(int i3, String str) {
        int i16;
        this.isFinish = true;
        this.taskStatus = 7;
        this.errCode = i3;
        this.f107253msg = str;
        QLog.w(TAG, 1, "onTaskFailed appId=" + this.appId + ",code=" + i3 + ",errMsg=" + str);
        if (this.mWadlParams.isRes) {
            i16 = 5005;
        } else {
            i16 = 1005;
        }
        notifyEventOberver(i16, true);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.dlapt.WadlTaskListener
    public void onTaskPaused() {
        int i3;
        QLog.d(TAG, 1, "onTaskPaused " + this);
        if (WadlUtils.isRuningTask(this.taskStatus)) {
            this.errCode = 0;
            this.taskStatus = 5;
            if (this.mWadlParams.isRes) {
                i3 = 5006;
            } else {
                i3 = 1006;
            }
            notifyEventOberver(i3, true);
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.dlapt.WadlTaskListener
    public void onTaskReceived(int i3) {
        int i16;
        if (this.isFinish) {
            return;
        }
        try {
            this.taskStatus = 4;
            if (this.mWadlParams.isRes) {
                i16 = 5004;
            } else {
                i16 = 1004;
            }
            notifyEventOberver(i16, true);
            if (i3 == 0 && isRequireWifi() && !AppNetConnInfo.isWifiConn()) {
                QLog.w(TAG, 1, "onTaskReceived pauseDownload isWifi=" + AppNetConnInfo.isWifiConn());
                pauseDownload("4");
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "onTaskReceived exception:", e16);
            e16.printStackTrace();
        }
        WadlHandlerInterface businessHandler = WadlHandlerFactory.getBusinessHandler(this.businessId);
        if (businessHandler != null) {
            businessHandler.refreshLastActiveTime();
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.dlapt.WadlTaskListener
    public void onTaskStarted() {
        int i3;
        this.taskStatus = 2;
        QLog.d(TAG, 1, "onTaskStarted " + this);
        if (this.mWadlParams.isRes) {
            i3 = 5003;
        } else {
            i3 = 1003;
        }
        notifyEventOberver(i3, true);
    }

    @Override // com.tencent.gamecenter.wadl.sdk.dlapt.WadlTaskListener
    public void onTaskUpdate(WadlResult wadlResult) {
        WadlParams wadlParams = this.mWadlParams;
        if (wadlParams != null) {
            wadlParams.flags = wadlResult.wadlParams.flags;
        }
        notifyEventOberver(1009, false);
    }

    public void pauseDownload(String str) {
        QLog.d(TAG, 1, "pauseDownload appId=" + this.appId + ", sceneId=" + str);
        WadlParams wadlParams = this.mWadlParams;
        if (wadlParams != null) {
            wadlParams.sceneId = str;
        }
        this.isFinish = true;
    }

    public String simplePrintInfo() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("WadlTask{");
        stringBuffer.append("businessId=");
        stringBuffer.append(this.businessId);
        stringBuffer.append(", taskStatus=");
        stringBuffer.append(this.taskStatus);
        stringBuffer.append(", fileSize=");
        stringBuffer.append(this.fileSize);
        stringBuffer.append(", downloadFileSize=");
        stringBuffer.append(this.downloadFileSize);
        stringBuffer.append(", speed=");
        stringBuffer.append(getAverageSpeed());
        stringBuffer.append(", errCode=");
        stringBuffer.append(this.errCode);
        stringBuffer.append(", interruptedFlag=");
        stringBuffer.append(this.interruptedFlag);
        stringBuffer.append(", isPausedByWifiDisconnected=");
        stringBuffer.append(this.isPausedByWifiDisconnected);
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    public void startDownload() {
        this.isFinish = false;
        this.isStartedUnderWifi = WadlUtils.isUnderWifiConnection();
        WadlHandlerInterface businessHandler = WadlHandlerFactory.getBusinessHandler(this.businessId);
        if (businessHandler != null) {
            businessHandler.refreshLastActiveTime();
        }
        this.beginFlow = this.downloadFileSize;
        this.beginBattery = WadlUtils.getBatteryValue().first.intValue();
        QLog.d(TAG, 1, "startDownload beginFlow=" + this.beginFlow + ",beginBattery=" + this.beginBattery + "|" + this);
    }
}
