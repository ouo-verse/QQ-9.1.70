package com.tencent.mobileqq.mini.report;

import NS_COMM.COMM;
import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER;
import NS_MINI_REPORT.REPORT$SingleDcData;
import NS_MINI_REPORT.REPORT$StDcReportReq;
import NS_MINI_REPORT.REPORT$StGameDcReportReq;
import NS_MINI_REPORT.REPORT$StThirdDcReportReq;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.AppConfigInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.utils.EnvUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import com.tencent.smtt.sdk.QbSdk;
import cooperation.qqcircle.report.QCircleLpReportDc05494;
import cooperation.qzone.QUA;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes33.dex */
public class MiniProgramReportHelper {
    private static final Map<String, String> APP_ID_LAUNCH_ID_MAP = new HashMap();
    private static final Map<String, String> LAUNCH_ID_MAP_MAIN_PROCESS = new HashMap();
    private static MiniAppConfig MINI_APP_CONFIG_FOR_PRELOAD = null;
    public static String PERF_LEVEL = null;
    public static final String PRELOAD_MINI_APP_ID = "0000000000";
    public static final String REPORT_ALKAID_PT_KEY = "alkaid_pt";
    private static final String TAG = "MiniProgramReportHelper";

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes33.dex */
    @interface DCIDType {
    }

    static {
        MiniAppInfo miniAppInfo = new MiniAppInfo();
        miniAppInfo.appId = "0000000000";
        MiniAppConfig miniAppConfig = new MiniAppConfig(miniAppInfo);
        MINI_APP_CONFIG_FOR_PRELOAD = miniAppConfig;
        miniAppConfig.launchParam = new LaunchParam();
        MINI_APP_CONFIG_FOR_PRELOAD.launchParam.miniAppId = "0000000000";
    }

    MiniProgramReportHelper() {
    }

    public static void assignAppLaunchId(MiniAppConfig miniAppConfig) {
        String miniAppIdSafely = getMiniAppIdSafely(miniAppConfig);
        if (!TextUtils.isEmpty(miniAppIdSafely)) {
            String valueOf = String.valueOf(System.currentTimeMillis());
            APP_ID_LAUNCH_ID_MAP.put(miniAppIdSafely, valueOf);
            QLog.e(TAG, 1, "[mini] assignAppLaunchId [appId= " + miniAppIdSafely + "] [launchId=" + valueOf);
        }
        MINI_APP_CONFIG_FOR_PRELOAD = miniAppConfig;
    }

    public static void generateLaunchIdInMainProcess(MiniAppConfig miniAppConfig) {
        String miniAppIdSafely = getMiniAppIdSafely(miniAppConfig);
        if (TextUtils.isEmpty(miniAppIdSafely)) {
            return;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        LAUNCH_ID_MAP_MAIN_PROCESS.put(miniAppIdSafely, valueOf);
        QLog.e(TAG, 1, "[mini] generateLaunchIdInMainProcess [appId= " + miniAppIdSafely + "] [launchId=" + valueOf);
    }

    public static String getLaunchIdFromMainProcess(MiniAppConfig miniAppConfig) {
        return LAUNCH_ID_MAP_MAIN_PROCESS.get(getMiniAppIdSafely(miniAppConfig));
    }

    public static String getNetworkType() {
        String netWorkTypeByStr = HttpUtil.getNetWorkTypeByStr();
        if (netWorkTypeByStr == null) {
            return "unknown";
        }
        return netWorkTypeByStr.toLowerCase();
    }

    public static String getReportDataAlkaidPtInfo(String str) {
        QLog.i(TAG, 4, "reportData is:" + str);
        if (!TextUtils.isEmpty(str) && str.contains("alkaid_pt=") && str.split(ContainerUtils.FIELD_DELIMITER).length != 0) {
            try {
                for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
                    if (str2.contains("alkaid_pt=")) {
                        return str2.substring(10);
                    }
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, "getReportDataAlkaidPtInfo error! reportData is:" + str, e16);
            }
            return "";
        }
        QLog.i(TAG, 1, "getReportDataAlkaidPtInfo reportData is null or empty!");
        return "";
    }

    public static String launchIdForMiniAppConfig(MiniAppConfig miniAppConfig) {
        return APP_ID_LAUNCH_ID_MAP.get(getMiniAppIdSafely(miniAppConfig));
    }

    public static MiniAppConfig miniAppConfigForPreload() {
        return MINI_APP_CONFIG_FOR_PRELOAD;
    }

    public static List<COMM.Entry> newAppQualityEntries(MiniAppConfig miniAppConfig, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        return newAppQualityEntries(miniAppConfig, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, "", "", "", "");
    }

    public static List<COMM.Entry> newBaseBusinessEntries(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(newEntry("actiontype", String.valueOf(str)), newEntry("sub_actiontype", String.valueOf(str2)), newEntry("reserves_action", String.valueOf(str3)), newEntry("reserves2", String.valueOf(str4)), newEntry("reserves3", String.valueOf(str5)), newEntry("reserves4", String.valueOf(str6)), newEntry("reserves5", String.valueOf(str7))));
        return arrayList;
    }

    public static List<COMM.Entry> newBusinessEntries(MiniAppConfig miniAppConfig, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        return newBusinessEntries(miniAppConfig, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, null);
    }

    public static APP_REPORT_TRANSFER.StDataReportReq newDataReportReq(List<APP_REPORT_TRANSFER.SingleDcData> list) {
        APP_REPORT_TRANSFER.StDataReportReq stDataReportReq = new APP_REPORT_TRANSFER.StDataReportReq();
        stDataReportReq.dcdata.addAll(list);
        return stDataReportReq;
    }

    public static REPORT$StDcReportReq newDcReportReq(List<REPORT$SingleDcData> list) {
        REPORT$StDcReportReq rEPORT$StDcReportReq = new REPORT$StDcReportReq();
        rEPORT$StDcReportReq.dcdata.addAll(list);
        return rEPORT$StDcReportReq;
    }

    public static COMM.Entry newEntry(Map.Entry<String, String> entry) {
        COMM.Entry entry2 = new COMM.Entry();
        if (entry.getKey() != null) {
            entry2.key.set(entry.getKey());
        }
        if (entry.getValue() != null) {
            entry2.value.set(entry.getValue());
        }
        return entry2;
    }

    public static REPORT$StGameDcReportReq newGameCPReportReq(List<REPORT$SingleDcData> list) {
        REPORT$StGameDcReportReq rEPORT$StGameDcReportReq = new REPORT$StGameDcReportReq();
        if (list != null) {
            rEPORT$StGameDcReportReq.dcdata.addAll(list);
        }
        return rEPORT$StGameDcReportReq;
    }

    public static List<COMM.Entry> newGenericEntries() {
        ArrayList arrayList = new ArrayList(Arrays.asList(newEntry("device_platform", "android"), newEntry(QCircleLpReportDc05494.KEY_DEVICE_MAKER, Build.MANUFACTURER), newEntry("device_model", DeviceInfoMonitor.getModel()), newEntry("device_version", Build.VERSION.RELEASE), newEntry("network_type", getNetworkType()), newEntry("network_gateway_ip", ""), newEntry("network_ssid", "")));
        String location = getLocation(com.tencent.open.adapter.a.f().e());
        if (location != null) {
            String[] split = location.split("\\*");
            if (split.length == 2) {
                arrayList.addAll(Arrays.asList(newEntry("gps_x", split[0]), newEntry("gps_y", split[1])));
            }
        }
        return arrayList;
    }

    public static List<COMM.Entry> newModeAndLocation(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(newEntry("mode", String.valueOf(str)), newEntry("location", String.valueOf(str2))));
        return arrayList;
    }

    public static List<COMM.Entry> newQQqunInfoBusinessEntries(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(newEntry("actiontype", String.valueOf(str)), newEntry("sub_actiontype", String.valueOf(str2)), newEntry("reserves_action", String.valueOf(str3)), newEntry("reserves2", String.valueOf(str4)), newEntry("reserves3", String.valueOf(str5)), newEntry("reserves4", String.valueOf(str6)), newEntry(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, String.valueOf(str7))));
        return arrayList;
    }

    public static List<COMM.Entry> newReportEntries(String str) {
        Map<String, String> parseReportData = parseReportData(str);
        ArrayList arrayList = new ArrayList();
        if (parseReportData != null) {
            for (Map.Entry<String, String> entry : parseReportData.entrySet()) {
                arrayList.add(newEntry(entry.getKey(), entry.getValue()));
            }
        }
        return arrayList;
    }

    public static REPORT$SingleDcData newSingleDcData(int i3, String str, Map<String, String> map, Map<String, String> map2) {
        REPORT$SingleDcData rEPORT$SingleDcData = new REPORT$SingleDcData();
        rEPORT$SingleDcData.dcid.set(i3);
        rEPORT$SingleDcData.type.set(str);
        if (map != null) {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                rEPORT$SingleDcData.report_data.add(newEntry(it.next()));
            }
        }
        if (map2 != null) {
            Iterator<Map.Entry<String, String>> it5 = map2.entrySet().iterator();
            while (it5.hasNext()) {
                rEPORT$SingleDcData.extinfo.add(newEntry(it5.next()));
            }
        }
        return rEPORT$SingleDcData;
    }

    public static APP_REPORT_TRANSFER.SingleDcData newSingleReportData(int i3, List<COMM.Entry> list, List<COMM.Entry> list2) {
        APP_REPORT_TRANSFER.SingleDcData singleDcData = new APP_REPORT_TRANSFER.SingleDcData();
        singleDcData.dcid.set(i3);
        if (list != null && !list.isEmpty()) {
            singleDcData.report_data.addAll(list);
        }
        if (list2 != null && !list2.isEmpty()) {
            singleDcData.extinfo.addAll(list2);
        }
        return singleDcData;
    }

    public static REPORT$StThirdDcReportReq newThirdDcReportReq(List<REPORT$SingleDcData> list) {
        REPORT$StThirdDcReportReq rEPORT$StThirdDcReportReq = new REPORT$StThirdDcReportReq();
        if (list != null) {
            rEPORT$StThirdDcReportReq.dcdata.addAll(list);
        }
        return rEPORT$StThirdDcReportReq;
    }

    public static List<COMM.Entry> newUserInfoEntries() {
        return new ArrayList(Arrays.asList(newEntry("uin", String.valueOf(com.tencent.open.adapter.a.f().l())), newEntry("touin", ""), newEntry("timestamp", String.valueOf(NetConnInfoCenter.getServerTimeMillis())), newEntry("qqversion", QUA.getQUA3()), newEntry("imei", o.c()), newEntry("idfa", ""), newEntry("idfv", ""), newEntry(SharedPreferencedUtil.SP_KEY_ANDROID_ID, o.b())));
    }

    public static List<COMM.Entry> newVersionEntries(MiniAppConfig miniAppConfig) {
        BaseLibInfo baseLibInfo;
        MiniAppInfo miniAppInfo;
        String str;
        ArrayList arrayList = new ArrayList();
        if (miniAppConfig != null && (miniAppInfo = miniAppConfig.config) != null) {
            COMM.Entry[] entryArr = new COMM.Entry[7];
            entryArr[0] = newEntry("appid", miniAppInfo.appId);
            entryArr[1] = newEntry("app_version", String.valueOf(miniAppConfig.config.version));
            entryArr[2] = newEntry("app_classification", null);
            entryArr[3] = newEntry("app_tag", "");
            String str2 = "1";
            if (EnvUtils.isPkgDownloaded(miniAppConfig)) {
                str = "1";
            } else {
                str = "0";
            }
            entryArr[4] = newEntry("isPkgDownloaed", str);
            if (!EnvUtils.isX5Enabled(miniAppConfig.config)) {
                str2 = "0";
            }
            entryArr[5] = newEntry("isX5Enabled", str2);
            entryArr[6] = newEntry(DTConstants.APPStatusConstant.APP_STATUS, String.valueOf(miniAppConfig.config.verType));
            arrayList.addAll(Arrays.asList(entryArr));
            if (!TextUtils.isEmpty(miniAppConfig.config.via)) {
                arrayList.add(newEntry("via", miniAppConfig.config.via));
            }
        }
        if (miniAppConfig != null && (baseLibInfo = miniAppConfig.baseLibInfo) != null) {
            arrayList.add(newEntry("app_js_version", baseLibInfo.baseLibVersion));
        }
        return arrayList;
    }

    private static Map<String, String> parseReportData(String str) {
        HashMap hashMap = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
                    int indexOf = str2.indexOf(ContainerUtils.KEY_VALUE_DELIMITER);
                    if (indexOf > 0 && indexOf < str2.length() - 1) {
                        String decode = URLDecoder.decode(str2.substring(0, indexOf), "UTF-8");
                        String decode2 = URLDecoder.decode(str2.substring(indexOf + 1), "UTF-8");
                        if (hashMap == null) {
                            hashMap = new HashMap();
                        }
                        hashMap.put(decode, decode2);
                    }
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, " parse reportData error.", e16);
            }
        }
        return hashMap;
    }

    public static String getLaunchIdFromMainProcess(String str) {
        return LAUNCH_ID_MAP_MAIN_PROCESS.get(str);
    }

    public static List<COMM.Entry> newAppQualityEntries(MiniAppConfig miniAppConfig, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        LaunchParam launchParam;
        BaseLibInfo baseLibInfo;
        MiniAppInfo miniAppInfo;
        if (PERF_LEVEL == null) {
            PERF_LEVEL = String.valueOf(DeviceInfoUtils.getPerfLevel());
        }
        COMM.Entry[] entryArr = new COMM.Entry[24];
        entryArr[0] = newEntry("uid", String.valueOf(com.tencent.open.adapter.a.f().l()));
        entryArr[1] = newEntry("appid", getMiniAppIdSafely(miniAppConfig));
        entryArr[2] = newEntry("launchid", str10);
        String str15 = "";
        entryArr[3] = newEntry("event", str2 != null ? str2 : "");
        entryArr[4] = newEntry("timestamp", str9);
        entryArr[5] = newEntry("page", str != null ? str : "");
        entryArr[6] = newEntry("attachinfo", str3 != null ? str3 : "");
        entryArr[7] = newEntry("appversion", AppSetting.f99554n);
        entryArr[8] = newEntry("miniapp_version", (miniAppConfig == null || (miniAppInfo = miniAppConfig.config) == null) ? "" : miniAppInfo.version);
        entryArr[9] = newEntry("qua", QUA.getQUA3());
        entryArr[10] = newEntry("cmd", str4 != null ? str4 : "");
        entryArr[11] = newEntry("retcode", str5);
        entryArr[12] = newEntry("time_cost", str7);
        entryArr[13] = newEntry("third_url", str8);
        entryArr[14] = newEntry("baselib_version", (miniAppConfig == null || (baseLibInfo = miniAppConfig.baseLibInfo) == null) ? "" : baseLibInfo.baseLibVersion);
        entryArr[15] = newEntry("x5_version", String.valueOf(QbSdk.getTbsVersion(BaseApplicationImpl.getApplication())));
        entryArr[16] = newEntry("app_type", str6);
        entryArr[17] = newEntry("network_type", getNetworkType());
        if (miniAppConfig != null && (launchParam = miniAppConfig.launchParam) != null) {
            str15 = String.valueOf(launchParam.scene);
        }
        entryArr[18] = newEntry("scene", str15);
        entryArr[19] = newEntry("reverse1", str11);
        entryArr[20] = newEntry("reverse2", str12);
        entryArr[21] = newEntry("reverse3", str13);
        entryArr[22] = newEntry("reverse4", str14);
        entryArr[23] = newEntry(IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, PERF_LEVEL);
        return new ArrayList(Arrays.asList(entryArr));
    }

    public static List<COMM.Entry> newBusinessEntries(MiniAppConfig miniAppConfig, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15) {
        String str16;
        MiniAppInfo miniAppInfo;
        BaseLibInfo baseLibInfo;
        ArrayList arrayList = new ArrayList();
        if (miniAppConfig != null && miniAppConfig.config != null) {
            COMM.Entry[] entryArr = new COMM.Entry[8];
            entryArr[0] = newEntry("launchid", str14);
            entryArr[1] = newEntry("appid", miniAppConfig.config.appId);
            entryArr[2] = newEntry("app_version", String.valueOf(miniAppConfig.config.version));
            entryArr[3] = newEntry("app_classification", null);
            entryArr[4] = newEntry("app_tag", "");
            entryArr[5] = newEntry("isPkgDownloaed", EnvUtils.isPkgDownloaded(miniAppConfig) ? "1" : "0");
            entryArr[6] = newEntry("isX5Enabled", EnvUtils.isX5Enabled(miniAppConfig.config) ? "1" : "0");
            entryArr[7] = newEntry(DTConstants.APPStatusConstant.APP_STATUS, String.valueOf(miniAppConfig.config.verType));
            arrayList.addAll(Arrays.asList(entryArr));
            if (!TextUtils.isEmpty(miniAppConfig.config.via)) {
                arrayList.add(newEntry("via", miniAppConfig.config.via));
            }
            if (!TextUtils.isEmpty(miniAppConfig.config.hostScene)) {
                arrayList.add(newEntry("host_scene", miniAppConfig.config.hostScene));
            }
            if (!TextUtils.isEmpty(str2) && !miniAppConfig.config.isWxMiniApp()) {
                arrayList.add(newEntry("refer", str2));
            }
        }
        if (miniAppConfig != null && (baseLibInfo = miniAppConfig.baseLibInfo) != null) {
            arrayList.add(newEntry("app_js_version", baseLibInfo.baseLibVersion));
        }
        arrayList.addAll(Arrays.asList(newEntry("path", str), newEntry("actiontype", String.valueOf(str3)), newEntry("sub_actiontype", String.valueOf(str4)), newEntry("reserves_action", String.valueOf(str5)), newEntry("reserves2", String.valueOf(str6)), newEntry("reserves3", String.valueOf(str7)), newEntry("reserves4", String.valueOf(str8)), newEntry("reserves5", String.valueOf(str9)), newEntry("reserves6", String.valueOf(str10)), newEntry("reserves7", String.valueOf(str11)), newEntry("reserves8", String.valueOf(str12)), newEntry("app_type", String.valueOf(str13))));
        if (!TextUtils.isEmpty(str15)) {
            arrayList.add(newEntry(com.tencent.qqmini.sdk.report.MiniAppReportManager2.KEY_SLOT_ID, str15));
        }
        if (miniAppConfig != null) {
            LaunchParam launchParam = miniAppConfig.launchParam;
            str16 = launchParam != null ? launchParam.reportData : null;
            if (TextUtils.isEmpty(str16) && (miniAppInfo = miniAppConfig.config) != null) {
                str16 = miniAppInfo.reportData;
            }
        } else {
            str16 = null;
        }
        if (!TextUtils.isEmpty(str16)) {
            arrayList.addAll(newReportEntries(str16));
        }
        return arrayList;
    }

    private static String getLocation(Context context) {
        SosoLocation sosoLocation;
        if (context == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        SosoLbsInfo cachedLbsInfo = ((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo("miniapp");
        if (cachedLbsInfo != null && (sosoLocation = cachedLbsInfo.mLocation) != null) {
            sb5.append(sosoLocation.mLat02);
            sb5.append('*');
            sb5.append(cachedLbsInfo.mLocation.mLon02);
        }
        return sb5.toString();
    }

    private static String getMiniAppIdSafely(MiniAppConfig miniAppConfig) {
        MiniAppInfo miniAppInfo;
        String str = (miniAppConfig == null || (miniAppInfo = miniAppConfig.config) == null) ? null : miniAppInfo.appId;
        return TextUtils.isEmpty(str) ? "0000000000" : str;
    }

    public static String currentUrlFromApkInfo(ApkgInfo apkgInfo) {
        MiniAppConfig miniAppConfig;
        LaunchParam launchParam;
        if (apkgInfo == null) {
            return null;
        }
        AppConfigInfo appConfigInfo = apkgInfo.mAppConfigInfo;
        String str = appConfigInfo != null ? appConfigInfo.entryPagePath : null;
        return (!TextUtils.isEmpty(str) || (miniAppConfig = apkgInfo.appConfig) == null || (launchParam = miniAppConfig.launchParam) == null) ? str : launchParam.entryPath;
    }

    public static COMM.Entry newEntry(String str, String str2) {
        COMM.Entry entry = new COMM.Entry();
        if (str != null) {
            entry.key.set(str);
        }
        if (str2 != null) {
            entry.value.set(str2);
        }
        return entry;
    }

    public static void checkShouldAssignPreloadLaunchId(int i3) {
        if (i3 == 605 || i3 == 1) {
            APP_ID_LAUNCH_ID_MAP.put("0000000000", "0");
        }
    }

    public static REPORT$SingleDcData newSingleDcData(int i3, String str, List<COMM.Entry> list, List<COMM.Entry> list2) {
        REPORT$SingleDcData rEPORT$SingleDcData = new REPORT$SingleDcData();
        rEPORT$SingleDcData.dcid.set(i3);
        rEPORT$SingleDcData.type.set(str);
        if (list != null && !list.isEmpty()) {
            rEPORT$SingleDcData.report_data.addAll(list);
        }
        if (list2 != null && !list2.isEmpty()) {
            rEPORT$SingleDcData.extinfo.addAll(list2);
        }
        return rEPORT$SingleDcData;
    }
}
