package com.tencent.qqmini.sdk.report;

import NS_COMM.COMM;
import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER;
import NS_MINI_REPORT.REPORT$SingleDcData;
import NS_MINI_REPORT.REPORT$StDcReportReq;
import NS_MINI_REPORT.REPORT$StGameDcReportReq;
import NS_MINI_REPORT.REPORT$StThirdDcReportReq;
import android.app.ActivityManager;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ams.adcore.mma.util.SharedPreferencedUtil;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.winkpublish.api.constant.FSPublishConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.DeviceUtil;
import com.tencent.qqmini.sdk.core.utils.NetworkUtil;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.BaseLibInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.utils.DeviceInfoUtil;
import com.tencent.qqmini.sdk.utils.EnvUtils;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import cooperation.qqcircle.report.QCircleLpReportDc05494;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes23.dex */
public class MiniProgramReportHelper {
    private static MiniAppInfo MINI_APP_CONFIG_FOR_PRELOAD = null;
    public static String PERF_LEVEL = null;
    public static final String PRELOAD_MINI_APP_ID = "0000000000";
    private static final String TAG = "MiniProgramReportHelper";
    private static final Map<String, String> APP_ID_LAUNCH_ID_MAP = new HashMap();
    private static final Map<String, String> LAUNCH_ID_MAP_MAIN_PROCESS = new HashMap();
    private static String sDeviceInfo = null;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes23.dex */
    @interface DCIDType {
    }

    static {
        MiniAppInfo miniAppInfo = new MiniAppInfo();
        miniAppInfo.appId = "0000000000";
        MINI_APP_CONFIG_FOR_PRELOAD = miniAppInfo;
        miniAppInfo.launchParam.miniAppId = "0000000000";
    }

    MiniProgramReportHelper() {
    }

    private static String adjustRefer(String str) {
        if (!QUAUtil.isQQMainApp() && !QUAUtil.isTimApp()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getAppName());
            sb5.append("_");
            if (str == null) {
                str = "1001";
            }
            sb5.append(str);
            return sb5.toString();
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public static void assignAppLaunchId(MiniAppInfo miniAppInfo) {
        String miniAppIdSafely = getMiniAppIdSafely(miniAppInfo);
        if (!TextUtils.isEmpty(miniAppIdSafely)) {
            String valueOf = String.valueOf(System.currentTimeMillis());
            APP_ID_LAUNCH_ID_MAP.put(miniAppIdSafely, valueOf);
            QMLog.i(TAG, "[mini] assignAppLaunchId [appId= " + miniAppIdSafely + "] [launchId=" + valueOf + "]");
        }
        MINI_APP_CONFIG_FOR_PRELOAD = miniAppInfo;
    }

    public static void checkShouldAssignPreloadLaunchId(int i3) {
        if (i3 == 605 || i3 == 1) {
            APP_ID_LAUNCH_ID_MAP.put("0000000000", "0");
        }
    }

    public static void generateLaunchIdInMainProcess(MiniAppInfo miniAppInfo) {
        String miniAppIdSafely = getMiniAppIdSafely(miniAppInfo);
        if (!TextUtils.isEmpty(miniAppIdSafely)) {
            String valueOf = String.valueOf(System.currentTimeMillis());
            LAUNCH_ID_MAP_MAIN_PROCESS.put(miniAppIdSafely, valueOf);
            QMLog.e(TAG, "[mini] generateLaunchIdInMainProcess [appId= " + miniAppIdSafely + "] [launchId=" + valueOf);
        }
    }

    private static String getDeviceInfo() {
        if (!TextUtils.isEmpty(sDeviceInfo)) {
            return sDeviceInfo;
        }
        String str = "a=" + Build.VERSION.SDK_INT + "&mem=" + getDeviceRamSize() + "&mo=" + getModelName();
        sDeviceInfo = str;
        return str;
    }

    private static long getDeviceRamSize() {
        try {
            ActivityManager activityManager = (ActivityManager) AppLoaderFactory.g().getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            return (memoryInfo.totalMem / 1024) / 1024;
        } catch (Exception e16) {
            e16.printStackTrace();
            QMLog.e(TAG, "getDeviceRamSize exception", e16);
            return 0L;
        }
    }

    public static String getLaunchIdFromMainProcess(MiniAppInfo miniAppInfo) {
        return LAUNCH_ID_MAP_MAIN_PROCESS.get(getMiniAppIdSafely(miniAppInfo));
    }

    private static String getMiniAppIdSafely(MiniAppInfo miniAppInfo) {
        String str;
        LaunchParam launchParam;
        if (miniAppInfo != null && (launchParam = miniAppInfo.launchParam) != null) {
            str = launchParam.miniAppId;
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str) && miniAppInfo != null) {
            str = miniAppInfo.appId;
        }
        if (TextUtils.isEmpty(str)) {
            return "0000000000";
        }
        return str;
    }

    private static String getModelName() {
        String str = Build.MANUFACTURER;
        String phoneModel = DeviceInfoUtil.getPhoneModel();
        if (phoneModel != null && str != null && phoneModel.toLowerCase().startsWith(str.toLowerCase())) {
            return phoneModel;
        }
        return str + " " + phoneModel;
    }

    public static String getNetworkType() {
        String netWorkTypeByStr = NetworkUtil.getNetWorkTypeByStr(AppLoaderFactory.g().getContext());
        if (netWorkTypeByStr == null) {
            return "unknown";
        }
        return netWorkTypeByStr.toLowerCase();
    }

    public static String launchIdForMiniAppConfig(MiniAppInfo miniAppInfo) {
        return APP_ID_LAUNCH_ID_MAP.get(getMiniAppIdSafely(miniAppInfo));
    }

    public static MiniAppInfo miniAppConfigForPreload() {
        return MINI_APP_CONFIG_FOR_PRELOAD;
    }

    public static List<COMM.Entry> newAppQualityEntries(MiniAppInfo miniAppInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        List<COMM.Entry> newAppQualityEntries = newAppQualityEntries(miniAppInfo, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, "", "", "", "", "");
        if (!QUAUtil.isQQApp()) {
            newAppQualityEntries.addAll(newThirdSourceEntries());
        }
        return newAppQualityEntries;
    }

    public static List<COMM.Entry> newBaseBusinessEntries(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(newEntry("actiontype", String.valueOf(str)), newEntry("sub_actiontype", String.valueOf(str2)), newEntry("reserves_action", String.valueOf(str3)), newEntry("reserves2", String.valueOf(str4)), newEntry("reserves3", String.valueOf(str5)), newEntry("reserves4", String.valueOf(str6)), newEntry("reserves5", String.valueOf(str7))));
        return arrayList;
    }

    public static List<COMM.Entry> newBusinessEntries(MiniAppInfo miniAppInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        return newBusinessEntries(miniAppInfo, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, null, str11, str12);
    }

    public static List<COMM.Entry> newBusinessHalfEntries(MiniAppInfo miniAppInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        ArrayList arrayList = new ArrayList();
        if (miniAppInfo != null) {
            COMM.Entry[] entryArr = new COMM.Entry[8];
            entryArr[0] = newEntry("launchid", str9);
            entryArr[1] = newEntry("appid", miniAppInfo.appId);
            entryArr[2] = newEntry("app_version", String.valueOf(miniAppInfo.version));
            entryArr[3] = newEntry("app_classification", null);
            entryArr[4] = newEntry("app_tag", "");
            entryArr[5] = newEntry("isPkgDownloaed", EnvUtils.isPkgDownloaded(miniAppInfo) ? "1" : "0");
            entryArr[6] = newEntry("isX5Enabled", EnvUtils.isX5Enabled(miniAppInfo) ? "1" : "0");
            entryArr[7] = newEntry(DTConstants.APPStatusConstant.APP_STATUS, String.valueOf(miniAppInfo.verType));
            arrayList.addAll(Arrays.asList(entryArr));
            if (!TextUtils.isEmpty(miniAppInfo.via)) {
                arrayList.add(newEntry("via", miniAppInfo.via));
            }
            BaseLibInfo baseLibInfo = miniAppInfo.baseLibInfo;
            if (baseLibInfo != null) {
                arrayList.add(newEntry("app_js_version", baseLibInfo.baseLibVersion));
            }
            if (!TextUtils.isEmpty(miniAppInfo.launchParam.slotId)) {
                arrayList.add(newEntry(MiniAppReportManager2.KEY_SLOT_ID, miniAppInfo.launchParam.slotId));
            }
        }
        arrayList.addAll(Arrays.asList(newEntry("path", str), newEntry("refer", adjustRefer(str2)), newEntry("actiontype", String.valueOf(str3)), newEntry("sub_actiontype", String.valueOf(str4)), newEntry("reserves_action", String.valueOf(str5)), newEntry("reserves2", String.valueOf(str6)), newEntry("reserves3", String.valueOf(str7)), newEntry("app_type", String.valueOf(str8)), newEntry("sdk_version", QUAUtil.getQUA()), newEntry("reserves9", String.valueOf(str10)), newEntry("reserves10", String.valueOf(str11))));
        if (miniAppInfo != null) {
            LaunchParam launchParam = miniAppInfo.launchParam;
            if (launchParam != null && !TextUtils.isEmpty(launchParam.reportData)) {
                arrayList.addAll(newReportEntries(miniAppInfo.launchParam.reportData));
            }
            String str12 = miniAppInfo.reportData;
            if (str12 != null && !TextUtils.isEmpty(str12)) {
                arrayList.addAll(newReportEntries(miniAppInfo.reportData));
            }
        }
        return arrayList;
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
        ArrayList arrayList = new ArrayList(Arrays.asList(newEntry("device_platform", "android"), newEntry(QCircleLpReportDc05494.KEY_DEVICE_MAKER, Build.MANUFACTURER), newEntry("device_model", DeviceInfoUtil.getPhoneModel()), newEntry("device_version", Build.VERSION.RELEASE), newEntry("network_type", getNetworkType()), newEntry("network_gateway_ip", ""), newEntry("network_ssid", "")));
        String location = DeviceUtil.getLocation();
        if (location != null) {
            String[] split = location.split("\\*");
            if (split.length == 2) {
                arrayList.addAll(Arrays.asList(newEntry("gps_x", split[0]), newEntry("gps_y", split[1])));
            }
        }
        return arrayList;
    }

    public static List<COMM.Entry> newQQqunInfoBusinessEntries(String str, String str2, String str3, String str4, String str5) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(Arrays.asList(newEntry("actiontype", String.valueOf(str)), newEntry("sub_actiontype", String.valueOf(str2)), newEntry("reserves_action", String.valueOf(str3)), newEntry("reserves2", String.valueOf(str4)), newEntry(FSPublishConstants.FSPublishJsBridge.JSON_OBJECT_KEY_GROUP_ID, String.valueOf(str5))));
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

    public static List<COMM.Entry> newThirdSourceEntries() {
        return new ArrayList(Arrays.asList(newEntry("source_app", ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getPlatformId()), newEntry("source_version", ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getAppVersion()), newEntry("source_uin_platform", QUAUtil.getLoginType()), newEntry("connect_openid", LoginManager.getInstance().getPayOpenId()), newEntry("connect_type", String.valueOf(LoginManager.getInstance().getLoginType()))));
    }

    public static List<COMM.Entry> newUserInfoEntries() {
        ArrayList arrayList = new ArrayList();
        MiniAppProxy miniAppProxy = (MiniAppProxy) ProxyManager.get(MiniAppProxy.class);
        if (miniAppProxy != null) {
            arrayList.addAll(Arrays.asList(newEntry("uin", String.valueOf(LoginManager.getInstance().getAccount())), newEntry("touin", ""), newEntry("timestamp", String.valueOf(System.currentTimeMillis())), newEntry("qqversion", QUAUtil.getPlatformQUA()), newEntry("imei", miniAppProxy.getQImei36()), newEntry("idfa", ""), newEntry("idfv", ""), newEntry(SharedPreferencedUtil.SP_KEY_ANDROID_ID, miniAppProxy.getQImei16())));
        }
        return arrayList;
    }

    public static List<COMM.Entry> newVersionEntries(MiniAppInfo miniAppInfo) {
        String str;
        ArrayList arrayList = new ArrayList();
        if (miniAppInfo != null) {
            COMM.Entry[] entryArr = new COMM.Entry[7];
            entryArr[0] = newEntry("appid", miniAppInfo.appId);
            entryArr[1] = newEntry("app_version", String.valueOf(miniAppInfo.version));
            entryArr[2] = newEntry("app_classification", null);
            entryArr[3] = newEntry("app_tag", "");
            String str2 = "1";
            if (EnvUtils.isPkgDownloaded(miniAppInfo)) {
                str = "1";
            } else {
                str = "0";
            }
            entryArr[4] = newEntry("isPkgDownloaed", str);
            if (!EnvUtils.isX5Enabled(miniAppInfo)) {
                str2 = "0";
            }
            entryArr[5] = newEntry("isX5Enabled", str2);
            entryArr[6] = newEntry(DTConstants.APPStatusConstant.APP_STATUS, String.valueOf(miniAppInfo.verType));
            arrayList.addAll(Arrays.asList(entryArr));
            if (!TextUtils.isEmpty(miniAppInfo.via)) {
                arrayList.add(newEntry("via", miniAppInfo.via));
            }
            BaseLibInfo baseLibInfo = miniAppInfo.baseLibInfo;
            if (baseLibInfo != null) {
                arrayList.add(newEntry("app_js_version", baseLibInfo.baseLibVersion));
            }
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
                QMLog.e(TAG, " parse reportData error.", e16);
            }
        }
        return hashMap;
    }

    public static String getLaunchIdFromMainProcess(String str) {
        return LAUNCH_ID_MAP_MAIN_PROCESS.get(str);
    }

    public static List<COMM.Entry> newBusinessEntries(MiniAppInfo miniAppInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13) {
        ArrayList arrayList = new ArrayList();
        if (miniAppInfo != null) {
            COMM.Entry[] entryArr = new COMM.Entry[8];
            entryArr[0] = newEntry("launchid", str13);
            entryArr[1] = newEntry("appid", miniAppInfo.appId);
            entryArr[2] = newEntry("app_version", String.valueOf(miniAppInfo.version));
            entryArr[3] = newEntry("app_classification", null);
            entryArr[4] = newEntry("app_tag", "");
            entryArr[5] = newEntry("isPkgDownloaed", EnvUtils.isPkgDownloaded(miniAppInfo) ? "1" : "0");
            entryArr[6] = newEntry("isX5Enabled", EnvUtils.isX5Enabled(miniAppInfo) ? "1" : "0");
            entryArr[7] = newEntry(DTConstants.APPStatusConstant.APP_STATUS, String.valueOf(miniAppInfo.verType));
            arrayList.addAll(Arrays.asList(entryArr));
            if (!TextUtils.isEmpty(miniAppInfo.via)) {
                arrayList.add(newEntry("via", miniAppInfo.via));
            }
            BaseLibInfo baseLibInfo = miniAppInfo.baseLibInfo;
            if (baseLibInfo != null) {
                arrayList.add(newEntry("app_js_version", baseLibInfo.baseLibVersion));
            }
        }
        arrayList.addAll(Arrays.asList(newEntry("path", str), newEntry("refer", adjustRefer(str2)), newEntry("actiontype", String.valueOf(str3)), newEntry("sub_actiontype", String.valueOf(str4)), newEntry("reserves_action", String.valueOf(str5)), newEntry("reserves2", String.valueOf(str6)), newEntry("reserves3", String.valueOf(str7)), newEntry("reserves4", String.valueOf(str8)), newEntry("reserves5", String.valueOf(str9)), newEntry("reserves6", String.valueOf(str10)), newEntry("reserves7", String.valueOf(str11)), newEntry("app_type", String.valueOf(str12)), newEntry("sdk_version", QUAUtil.getQUA())));
        if (miniAppInfo != null) {
            LaunchParam launchParam = miniAppInfo.launchParam;
            if (launchParam != null && !TextUtils.isEmpty(launchParam.reportData)) {
                arrayList.addAll(newReportEntries(miniAppInfo.launchParam.reportData));
            }
            String str14 = miniAppInfo.reportData;
            if (str14 != null && !TextUtils.isEmpty(str14)) {
                arrayList.addAll(newReportEntries(miniAppInfo.reportData));
            }
        }
        return arrayList;
    }

    public static List<COMM.Entry> newAppQualityEntries(MiniAppInfo miniAppInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15) {
        LaunchParam launchParam;
        BaseLibInfo baseLibInfo;
        if (PERF_LEVEL == null) {
            PERF_LEVEL = String.valueOf(DeviceInfoUtil.getPerfLevel());
        }
        COMM.Entry[] entryArr = new COMM.Entry[32];
        entryArr[0] = newEntry("uid", LoginManager.getInstance().getAccount());
        entryArr[1] = newEntry("appid", getMiniAppIdSafely(miniAppInfo));
        entryArr[2] = newEntry("launchid", str10);
        String str16 = "";
        entryArr[3] = newEntry("event", str2 != null ? str2 : "");
        entryArr[4] = newEntry("timestamp", str9);
        entryArr[5] = newEntry("page", str != null ? str : "");
        entryArr[6] = newEntry("attachinfo", str3 != null ? str3 : "");
        entryArr[7] = newEntry("appversion", ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getAppVersion());
        entryArr[8] = newEntry("miniapp_version", miniAppInfo != null ? miniAppInfo.version : "");
        entryArr[9] = newEntry("qua", QUAUtil.getPlatformQUA());
        entryArr[10] = newEntry("sdk_version", QUAUtil.getQUA());
        entryArr[11] = newEntry("cmd", str4 != null ? str4 : "");
        entryArr[12] = newEntry("retcode", str5);
        entryArr[13] = newEntry("time_cost", str7);
        entryArr[14] = newEntry("third_url", str8);
        entryArr[15] = newEntry("baselib_version", (miniAppInfo == null || (baseLibInfo = miniAppInfo.baseLibInfo) == null) ? "" : baseLibInfo.baseLibVersion);
        entryArr[16] = newEntry("x5_version", String.valueOf(((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getTbsVersion()));
        entryArr[17] = newEntry("deviceinfo", getDeviceInfo());
        entryArr[18] = newEntry("app_type", str6);
        entryArr[19] = newEntry("network_type", getNetworkType());
        if (miniAppInfo != null && (launchParam = miniAppInfo.launchParam) != null) {
            str16 = String.valueOf(launchParam.scene);
        }
        entryArr[20] = newEntry("scene", str16);
        entryArr[21] = newEntry("source_app", ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getPlatformId());
        entryArr[22] = newEntry("source_version", ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getAppVersion());
        entryArr[23] = newEntry("source_uin_platform", QUAUtil.getLoginType());
        entryArr[24] = newEntry("connect_openid", LoginManager.getInstance().getPayOpenId());
        entryArr[25] = newEntry("connect_type", String.valueOf(LoginManager.getInstance().getLoginType()));
        entryArr[26] = newEntry("reverse1", str11);
        entryArr[27] = newEntry("reverse2", str12);
        entryArr[28] = newEntry("reverse3", str13);
        entryArr[29] = newEntry("reverse4", str14);
        entryArr[30] = newEntry("render_mode", str15);
        entryArr[31] = newEntry(IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, PERF_LEVEL);
        return new ArrayList(Arrays.asList(entryArr));
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
