package com.tencent.mobileqq.mini.report;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.launch.MiniAppMainServiceApiManager;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.QbSdk;
import com.tenpay.proxy.dlg.location.QbAddrData;
import cooperation.qzone.QUA;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes33.dex */
public class MiniProgramLpReportDC05115 {
    private static final HashMap<String, ReportModel> MINI_APP_ID_REPORT_MODEL_HASH_MAP = new HashMap<>();
    private static final String TAG = "MiniProgramLpReportDC05";

    /* loaded from: classes33.dex */
    public static class ReportModel {
        private int cpuAVG;
        private long downloadRequestCost;
        private long downloadRequestErrorNum;
        private long downloadRequestLength;
        private long downloadRequestNum;
        private int fpsAVG;
        private long gamePrepareCost;
        private long gameUseTime;
        private long httpRequestCost;
        private long httpRequestErrorNum;
        private long httpRequestLength;
        private long httpRequestNum;
        private long launchCost;
        private String launchResult;
        private int memAVG;
        private int memINC;
        private MiniAppConfig miniAppConfig;
        private long pkgDownloadCost;
        private String pkgDownloadResult;
        private long relaunchCost;
        private boolean launchFlag = false;
        private int fpsVARI = 0;
        private long jsErrorNum = 0;
        private long oomErrorNum = 0;
        private long crashErrorNum = 0;
        private String x5Version = String.valueOf(QbSdk.getTbsVersion(BaseApplicationImpl.getApplication()));
        private String openID = "null";
        private String clientVersion = AppSetting.f99554n;
        private String devicePlatform = "android";
        private String deviceManufacturer = Build.MANUFACTURER;
        private String deviceModel = DeviceInfoMonitor.getModel();
        private String deviceVersion = Build.VERSION.RELEASE;
        private String qua = QUA.getQUA3();
        private String networkType = MiniProgramReportHelper.getNetworkType();
        private String networkGateWayIP = "null";
        private String networkSSID = null;
        private String androidID = null;
        private List<Long> httpRequestCostList = new ArrayList();
        private List<Long> httpRequestLengths = new ArrayList();
        private List<Long> downloadRequestCostList = new ArrayList();
        private List<Long> downloadRequestLengths = new ArrayList();

        public ReportModel(MiniAppConfig miniAppConfig) {
            this.miniAppConfig = miniAppConfig;
        }

        private synchronized void prepareReportRecord() {
            try {
                if (this.networkSSID == null) {
                    this.networkSSID = NetworkUtil.getCurrentWifiSSID(com.tencent.open.adapter.a.f().e());
                }
                if (this.androidID == null) {
                    this.androidID = ah.e();
                }
            } catch (Throwable th5) {
                QLog.e(MiniProgramLpReportDC05115.TAG, 1, th5, new Object[0]);
            }
            long j3 = 0;
            if (!this.httpRequestCostList.isEmpty()) {
                int size = this.httpRequestCostList.size();
                Iterator<Long> it = this.httpRequestCostList.iterator();
                long j16 = 0;
                while (it.hasNext()) {
                    j16 += it.next().longValue();
                }
                this.httpRequestCost = j16 / size;
            }
            if (!this.httpRequestLengths.isEmpty()) {
                Iterator<Long> it5 = this.httpRequestLengths.iterator();
                long j17 = 0;
                while (it5.hasNext()) {
                    j17 += it5.next().longValue();
                }
                this.httpRequestLength = j17 / this.httpRequestLengths.size();
            }
            if (!this.downloadRequestCostList.isEmpty()) {
                int size2 = this.downloadRequestCostList.size();
                Iterator<Long> it6 = this.downloadRequestCostList.iterator();
                long j18 = 0;
                while (it6.hasNext()) {
                    j18 += Math.max(it6.next().longValue(), 0L);
                }
                this.downloadRequestCost = j18 / size2;
            }
            if (!this.downloadRequestLengths.isEmpty()) {
                Iterator<Long> it7 = this.downloadRequestLengths.iterator();
                while (it7.hasNext()) {
                    j3 += it7.next().longValue();
                }
                this.downloadRequestLength = j3 / this.downloadRequestLengths.size();
            }
        }

        public synchronized void reportDownloadRequestResult(long j3, long j16, boolean z16) {
            this.downloadRequestNum++;
            if (z16) {
                this.downloadRequestErrorNum++;
            } else {
                this.downloadRequestCostList.add(Long.valueOf(j3));
                this.downloadRequestLengths.add(Long.valueOf(j16));
            }
        }

        public synchronized void reportHttpRequestResult(long j3, long j16, int i3) {
            this.httpRequestNum++;
            if (i3 < 0) {
                this.httpRequestErrorNum++;
            } else {
                this.httpRequestCostList.add(Long.valueOf(j3));
                this.httpRequestLengths.add(Long.valueOf(j16));
            }
        }

        public void reportLaunchResult(long j3, String str) {
            this.launchResult = str;
            this.launchCost = j3;
        }

        public void reportPKGDownloadResult(long j3, String str) {
            this.pkgDownloadCost = j3;
            this.pkgDownloadResult = str;
        }

        public void reportReLaunchResult(long j3, String str) {
            this.launchResult = str;
            this.relaunchCost = j3;
        }

        public synchronized void reset() {
            this.launchFlag = false;
            this.launchCost = 0L;
            this.launchResult = "";
            this.relaunchCost = 0L;
            this.pkgDownloadCost = 0L;
            this.pkgDownloadResult = "";
            this.gamePrepareCost = 0L;
            this.gameUseTime = 0L;
            this.jsErrorNum = 0L;
            this.oomErrorNum = 0L;
            this.crashErrorNum = 0L;
            this.downloadRequestErrorNum = 0L;
            this.downloadRequestNum = 0L;
            this.downloadRequestLengths.clear();
            this.downloadRequestCostList.clear();
            this.httpRequestErrorNum = 0L;
            this.httpRequestNum = 0L;
            this.httpRequestLengths.clear();
            this.httpRequestCostList.clear();
        }

        public void setGamePrepareCost(long j3) {
            this.gamePrepareCost = j3;
        }

        public void setGameUseTime(long j3) {
            this.gameUseTime = j3;
        }

        public void setJsErrorNum() {
            this.jsErrorNum++;
        }

        public void setMiniAppConfig(MiniAppConfig miniAppConfig) {
            this.miniAppConfig = miniAppConfig;
        }

        public String toReportRecord() {
            String str;
            Object obj;
            Object obj2;
            String str2;
            BaseLibInfo baseLibInfo;
            MiniAppInfo miniAppInfo;
            MiniAppInfo miniAppInfo2;
            LaunchParam launchParam;
            MiniAppInfo miniAppInfo3;
            StringBuilder sb5 = new StringBuilder();
            prepareReportRecord();
            MiniAppConfig miniAppConfig = this.miniAppConfig;
            String str3 = "null";
            if (miniAppConfig == null || (miniAppInfo3 = miniAppConfig.config) == null) {
                str = "null";
            } else {
                str = miniAppInfo3.appId;
            }
            sb5.append(str);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.launchFlag ? 1 : 0);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.launchCost);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.relaunchCost);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.pkgDownloadCost);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.pkgDownloadResult);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.gamePrepareCost);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.fpsAVG);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.fpsVARI);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.cpuAVG);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.memAVG);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.memINC);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.httpRequestCost);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.httpRequestNum);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.httpRequestErrorNum);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.httpRequestLength);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.downloadRequestCost);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.downloadRequestNum);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.downloadRequestErrorNum);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.downloadRequestLength);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.jsErrorNum);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.oomErrorNum);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.crashErrorNum);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.launchResult);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.gameUseTime);
            sb5.append(QbAddrData.DATA_SPLITER);
            MiniAppConfig miniAppConfig2 = this.miniAppConfig;
            if (miniAppConfig2 == null || (launchParam = miniAppConfig2.launchParam) == null) {
                obj = "null";
            } else {
                obj = Integer.valueOf(launchParam.scene);
            }
            sb5.append(obj);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(NetConnInfoCenter.getServerTimeMillis());
            sb5.append(QbAddrData.DATA_SPLITER);
            MiniAppConfig miniAppConfig3 = this.miniAppConfig;
            if (miniAppConfig3 == null || (miniAppInfo2 = miniAppConfig3.config) == null) {
                obj2 = "null";
            } else {
                obj2 = Integer.valueOf(miniAppInfo2.getReportType());
            }
            sb5.append(obj2);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.networkType);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.qua);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.clientVersion);
            sb5.append(QbAddrData.DATA_SPLITER);
            MiniAppConfig miniAppConfig4 = this.miniAppConfig;
            if (miniAppConfig4 == null || (miniAppInfo = miniAppConfig4.config) == null) {
                str2 = "null";
            } else {
                str2 = miniAppInfo.version;
            }
            sb5.append(str2);
            sb5.append(QbAddrData.DATA_SPLITER);
            MiniAppConfig miniAppConfig5 = this.miniAppConfig;
            if (miniAppConfig5 != null && (baseLibInfo = miniAppConfig5.baseLibInfo) != null) {
                str3 = baseLibInfo.baseLibVersion;
            }
            sb5.append(str3);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.x5Version);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.devicePlatform);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.deviceManufacturer);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.deviceModel);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.deviceVersion);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.networkGateWayIP);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.networkSSID);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.androidID);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.openID);
            return sb5.toString();
        }

        public String toString() {
            return "ReportModel{launchFlag=" + this.launchFlag + ", launchCost=" + this.launchCost + ", relaunchCost=" + this.relaunchCost + ", pkgDownloadCost=" + this.pkgDownloadCost + ", pkgDownloadResult='" + this.pkgDownloadResult + "', gamePrepareCost=" + this.gamePrepareCost + ", fpsAVG=" + this.fpsAVG + ", fpsVARI=" + this.fpsVARI + ", cpuAVG=" + this.cpuAVG + ", memAVG=" + this.memAVG + ", memINC=" + this.memINC + ", httpRequestCost=" + this.httpRequestCost + ", httpRequestNum=" + this.httpRequestNum + ", httpRequestErrorNum=" + this.httpRequestErrorNum + ", httpRequestLength=" + this.httpRequestLength + ", downloadRequestCost=" + this.downloadRequestCost + ", downloadRequestNum=" + this.downloadRequestNum + ", downloadRequestErrorNum=" + this.downloadRequestErrorNum + ", downloadRequestLength=" + this.downloadRequestLength + ", jsErrorNum=" + this.jsErrorNum + ", oomErrorNum=" + this.oomErrorNum + ", crashErrorNum=" + this.crashErrorNum + ", launchResult='" + this.launchResult + "', gameUseTime=" + this.gameUseTime + ", x5Version='" + this.x5Version + "', openID='" + this.openID + "', clientVersion='" + this.clientVersion + "', devicePlatform='" + this.devicePlatform + "', deviceManufacturer='" + this.deviceManufacturer + "', deviceModel='" + this.deviceModel + "', deviceVersion='" + this.deviceVersion + "', qua='" + this.qua + "', networkType='" + this.networkType + "', networkGateWayIP='" + this.networkGateWayIP + "', networkSSID='" + this.networkSSID + "', androidID='" + this.androidID + "'}";
        }

        private void reportCPUMemoryFPS(float f16, float f17, float f18, float f19, float f26) {
            this.cpuAVG = (int) f16;
            this.memAVG = (int) f17;
            this.memINC = (int) f18;
            this.fpsAVG = (int) f19;
            this.fpsVARI = (int) f26;
        }
    }

    private static void doReport(ReportModel reportModel) {
        if (reportModel != null) {
            try {
                String reportRecord = reportModel.toReportRecord();
                QLog.d(TAG, 2, "doReport ", reportRecord);
                QLog.d(TAG, 2, "doReport ", reportModel.toString());
                Bundle bundle = new Bundle();
                bundle.putStringArray("data", new String[]{reportRecord});
                bundle.putString("log_key", "dc05115");
                MiniAppMainServiceApiManager.INSTANCE.sendCmd("cmd_dc_report_log_key_data", bundle, null);
                reportModel.reset();
            } catch (Exception e16) {
                QLog.e(TAG, 2, "doReport ", e16);
            }
        }
    }

    public static void reDispatchReportEvent(MiniAppConfig miniAppConfig, String str, String str2, long j3, String str3) {
        MiniAppInfo miniAppInfo;
        if (miniAppConfig == null || (miniAppInfo = miniAppConfig.config) == null || TextUtils.isEmpty(miniAppInfo.appId) || str == null) {
            return;
        }
        HashMap<String, ReportModel> hashMap = MINI_APP_ID_REPORT_MODEL_HASH_MAP;
        ReportModel reportModel = hashMap.get(miniAppConfig.config.appId);
        if (reportModel != null) {
            if ("app_download_result".equals(str)) {
                reportModel.reportPKGDownloadResult(j3, str2);
                return;
            }
            if ("launch_result".equals(str) && "cold_start".equals(str3)) {
                reportModel.reportLaunchResult(j3, str2);
                return;
            }
            if ("game_first_launch_result".equals(str)) {
                reportModel.launchFlag = true;
                return;
            }
            if ("game_twice_launch_result".equals(str)) {
                reportModel.reportReLaunchResult(j3, str2);
                return;
            }
            if (!"minigamestaytime".equals(str) && !"miniappstaytime".equals(str)) {
                if ("steplaunchgame".equals(str)) {
                    reportModel.setGamePrepareCost(j3);
                    return;
                } else {
                    if ("jsonerror".equals(str)) {
                        reportModel.setJsErrorNum();
                        return;
                    }
                    return;
                }
            }
            reportModel.setGameUseTime(j3);
            return;
        }
        hashMap.put(miniAppConfig.config.appId, new ReportModel(miniAppConfig));
    }

    public static void reportCrash(MiniAppConfig miniAppConfig, Throwable th5) {
        MiniAppInfo miniAppInfo;
        ReportModel reportModel;
        if (miniAppConfig == null || (miniAppInfo = miniAppConfig.config) == null || TextUtils.isEmpty(miniAppInfo.appId) || (reportModel = MINI_APP_ID_REPORT_MODEL_HASH_MAP.get(miniAppConfig.config.appId)) == null) {
            return;
        }
        reportModel.crashErrorNum = 1L;
        reportModel.oomErrorNum = th5 instanceof OutOfMemoryError ? 1L : 0L;
        doReport(reportModel);
    }

    public static void reportDownloadResult(MiniAppConfig miniAppConfig, DownloadResult downloadResult, long j3, boolean z16) {
        MiniAppInfo miniAppInfo;
        ReportModel reportModel;
        if (miniAppConfig == null || (miniAppInfo = miniAppConfig.config) == null || TextUtils.isEmpty(miniAppInfo.appId) || (reportModel = MINI_APP_ID_REPORT_MODEL_HASH_MAP.get(miniAppConfig.config.appId)) == null) {
            return;
        }
        reportModel.reportDownloadRequestResult(j3, (downloadResult == null || downloadResult.getContent() == null) ? 0L : downloadResult.getContent().length, z16);
    }
}
