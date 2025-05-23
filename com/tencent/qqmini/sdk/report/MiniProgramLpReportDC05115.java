package com.tencent.qqmini.sdk.report;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.ipc.AppBrandCmdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import com.tenpay.proxy.dlg.location.QbAddrData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Deprecated
/* loaded from: classes23.dex */
public class MiniProgramLpReportDC05115 {
    private static final String TAG = "MiniProgramLpReportDC05";
    private static final HashMap<String, ReportModel> sAppIdReportModelMap = new HashMap<>();

    /* loaded from: classes23.dex */
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
        private MiniAppInfo miniAppConfig;
        private long pkgDownloadCost;
        private String pkgDownloadResult;
        private long relaunchCost;
        private boolean launchFlag = false;
        private int fpsVARI = 0;
        private long jsErrorNum = 0;
        private long oomErrorNum = 0;
        private long crashErrorNum = 0;
        private String x5Version = "1.0";
        private String openID = "null";
        private String clientVersion = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getAppVersion();
        private String devicePlatform = "android";
        private String deviceManufacturer = Build.MANUFACTURER;
        private String deviceVersion = Build.VERSION.RELEASE;
        private String qua = QUAUtil.getPlatformQUA();
        private String networkType = MiniProgramReportHelper.getNetworkType();
        private String networkGateWayIP = "null";
        private String sdkVersion = QUAUtil.getQUA();
        private String sourceApp = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getPlatformId();
        private String sourceVersion = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getAppVersion();
        private String sourceUinPlatform = QUAUtil.getLoginType();
        private List<Long> httpRequestCostList = new ArrayList();
        private List<Long> httpRequestLengths = new ArrayList();
        private List<Long> downloadRequestCostList = new ArrayList();
        private List<Long> downloadRequestLengths = new ArrayList();

        public ReportModel(MiniAppInfo miniAppInfo) {
            this.miniAppConfig = miniAppInfo;
        }

        private synchronized void prepareReportRecord() {
            this.gamePrepareCost = this.launchCost;
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

        /* JADX INFO: Access modifiers changed from: private */
        public void reportCPUMemoryFPS(float f16, float f17, float f18, float f19, float f26) {
            this.cpuAVG = (int) f16;
            this.memAVG = (int) f17;
            this.memINC = (int) f18;
            this.fpsAVG = (int) f19;
            this.fpsVARI = (int) f26;
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
            this.downloadRequestErrorNum = 0L;
            this.downloadRequestNum = 0L;
            this.downloadRequestLengths.clear();
            this.downloadRequestCostList.clear();
            this.httpRequestErrorNum = 0L;
            this.httpRequestNum = 0L;
            this.httpRequestLengths.clear();
            this.httpRequestCostList.clear();
        }

        public void setGameUseTime(long j3) {
            this.gameUseTime = j3;
        }

        public void setMiniAppConfig(MiniAppInfo miniAppInfo) {
            this.miniAppConfig = miniAppInfo;
        }

        public String toReportRecord() {
            String str;
            Object obj;
            Object obj2;
            String str2;
            BaseLibInfo baseLibInfo;
            LaunchParam launchParam;
            StringBuilder sb5 = new StringBuilder();
            prepareReportRecord();
            MiniAppInfo miniAppInfo = this.miniAppConfig;
            String str3 = "null";
            if (miniAppInfo == null) {
                str = "null";
            } else {
                str = miniAppInfo.appId;
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
            MiniAppInfo miniAppInfo2 = this.miniAppConfig;
            if (miniAppInfo2 == null || (launchParam = miniAppInfo2.launchParam) == null) {
                obj = "null";
            } else {
                obj = Integer.valueOf(launchParam.scene);
            }
            sb5.append(obj);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(System.currentTimeMillis());
            sb5.append(QbAddrData.DATA_SPLITER);
            MiniAppInfo miniAppInfo3 = this.miniAppConfig;
            if (miniAppInfo3 == null) {
                obj2 = "null";
            } else {
                obj2 = Integer.valueOf(miniAppInfo3.getReportType());
            }
            sb5.append(obj2);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.networkType);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.qua);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.clientVersion);
            sb5.append(QbAddrData.DATA_SPLITER);
            MiniAppInfo miniAppInfo4 = this.miniAppConfig;
            if (miniAppInfo4 == null) {
                str2 = "null";
            } else {
                str2 = miniAppInfo4.version;
            }
            sb5.append(str2);
            sb5.append(QbAddrData.DATA_SPLITER);
            MiniAppInfo miniAppInfo5 = this.miniAppConfig;
            if (miniAppInfo5 != null && (baseLibInfo = miniAppInfo5.baseLibInfo) != null) {
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
            sb5.append(DeviceInfoUtil.getPhoneModel());
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.deviceVersion);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.networkGateWayIP);
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(DeviceInfoUtil.getAndroidID());
            sb5.append(QbAddrData.DATA_SPLITER);
            sb5.append(this.openID);
            if (!QUAUtil.isQQApp()) {
                sb5.append("|");
                sb5.append(this.sdkVersion);
                sb5.append("|");
                sb5.append(this.sourceApp);
                sb5.append("|");
                sb5.append(this.sourceVersion);
                sb5.append("|");
                sb5.append(this.sourceUinPlatform);
            }
            return sb5.toString();
        }

        public String toString() {
            return "ReportModel{launchFlag=" + this.launchFlag + ", launchCost=" + this.launchCost + ", relaunchCost=" + this.relaunchCost + ", pkgDownloadCost=" + this.pkgDownloadCost + ", pkgDownloadResult='" + this.pkgDownloadResult + "', gamePrepareCost=" + this.gamePrepareCost + ", fpsAVG=" + this.fpsAVG + ", fpsVARI=" + this.fpsVARI + ", cpuAVG=" + this.cpuAVG + ", memAVG=" + this.memAVG + ", memINC=" + this.memINC + ", httpRequestCost=" + this.httpRequestCost + ", httpRequestNum=" + this.httpRequestNum + ", httpRequestErrorNum=" + this.httpRequestErrorNum + ", httpRequestLength=" + this.httpRequestLength + ", downloadRequestCost=" + this.downloadRequestCost + ", downloadRequestNum=" + this.downloadRequestNum + ", downloadRequestErrorNum=" + this.downloadRequestErrorNum + ", downloadRequestLength=" + this.downloadRequestLength + ", jsErrorNum=" + this.jsErrorNum + ", oomErrorNum=" + this.oomErrorNum + ", crashErrorNum=" + this.crashErrorNum + ", launchResult='" + this.launchResult + "', gameUseTime=" + this.gameUseTime + ", x5Version='" + this.x5Version + "', openID='" + this.openID + "', clientVersion='" + this.clientVersion + "', devicePlatform='" + this.devicePlatform + "', deviceManufacturer='" + this.deviceManufacturer + "', deviceModel='" + DeviceInfoUtil.getPhoneModel() + "', deviceVersion='" + this.deviceVersion + "', qua='" + this.qua + "', networkType='" + this.networkType + "', networkGateWayIP='" + this.networkGateWayIP + "', androidID='" + DeviceInfoUtil.getAndroidID() + "', sdk_version='" + this.sdkVersion + "', source_app='" + this.sourceApp + "', source_version='" + this.sourceVersion + "', source_uin_platform='" + this.sourceUinPlatform + "'}";
        }
    }

    private static void doReport(ReportModel reportModel) {
        String str;
        if (reportModel != null) {
            try {
                String reportRecord = reportModel.toReportRecord();
                QMLog.d(TAG, "doReport " + reportRecord);
                QMLog.d(TAG, "doReport " + reportModel.toString());
                Bundle bundle = new Bundle();
                bundle.putStringArray("data", new String[]{reportRecord});
                if (QUAUtil.isQQApp()) {
                    str = "dc05115";
                } else {
                    str = "dc05387";
                }
                bundle.putString("log_key", str);
                AppBrandCmdProxy.g().sendCmd("cmd_dc_report_log_key_data", bundle, null);
                reportModel.reset();
            } catch (Exception e16) {
                QMLog.e(TAG, "doReport ", e16);
            }
        }
    }

    public static void reportCPUMemoryFPS(MiniAppInfo miniAppInfo, float f16, float f17, float f18, float f19, float f26) {
        ReportModel reportModel;
        if (miniAppInfo != null && !TextUtils.isEmpty(miniAppInfo.appId) && (reportModel = sAppIdReportModelMap.get(miniAppInfo.appId)) != null) {
            reportModel.reportCPUMemoryFPS(f16, f17, f18, f19, f26);
            doReport(reportModel);
        }
    }

    public static void reportDownloadResult(MiniAppInfo miniAppInfo, int i3, long j3, boolean z16) {
        ReportModel reportModel;
        if (miniAppInfo != null && !TextUtils.isEmpty(miniAppInfo.appId) && (reportModel = sAppIdReportModelMap.get(miniAppInfo.appId)) != null) {
            reportModel.reportDownloadRequestResult(j3, i3, z16);
        }
    }

    public static void reportHttpRequestResult(MiniAppInfo miniAppInfo, int i3, long j3, long j16) {
        ReportModel reportModel;
        if (miniAppInfo != null && !TextUtils.isEmpty(miniAppInfo.appId) && (reportModel = sAppIdReportModelMap.get(miniAppInfo.appId)) != null) {
            reportModel.reportHttpRequestResult(j16, j3, i3);
        }
    }
}
