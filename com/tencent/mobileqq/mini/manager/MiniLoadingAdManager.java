package com.tencent.mobileqq.mini.manager;

import NS_MINI_AD.MiniAppAd$SpecifiedAdsItem;
import NS_MINI_AD.MiniAppAd$StGetAdReq;
import NS_MINI_AD.MiniAppAd$StGetAdRsp;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.MiniAppFileManager;
import com.tencent.mobileqq.mini.appbrand.utils.ThreadPools;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.reuse.MiniappDownloadUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.mini.utils.MiniAppMMKVUtils;
import com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniLoadingAdManager {
    public static final String EXTRA_JSON_ARRAY_KEY = "adarray";
    private static final String EXTRA_PRELOAD_INTERVAL_CHECK_PREFIX = "mini_loading_ad_extra_preload_interval_check_";
    public static final String EXTRA_VIRTUAL_APP_ID = "100";
    private static final String HAS_CLEAR_OLD_SP_CACHE_DATA = "mini_loading_ad_has_clear_old_sp_cache_data";
    public static final String KEY_UIN = "uin";
    public static final int LOADING_AD_LIMIT_TYPE_PRELOAD = 1;
    public static final int LOADING_AD_LIMIT_TYPE_SELECT = 0;
    private static final String PRELOAD_ADJSON_KEY_PREFEX = "mini_loading_ad_preload_adjson_key_";
    private static final String PRELOAD_PREFIX = "mini_loading_ad_preload_";
    private static final String SELECT_PREFIX = "mini_loading_ad_select_";
    public static final String TAG = "MiniLoadingAdManager";
    private static HashMap<Long, String> cachedAidFilePathMap = new HashMap<>();
    private static long maxAdCachedSize = 209715200;
    private static final long oneHourDuration = 3600000;
    private static volatile MiniLoadingAdManager sInstance;
    private int extraPullPreloadInterval = QzoneConfig.getInstance().getConfig("qqminiapp", QzoneConfig.SECONDARY_MINI_LOADING_AD_EXTRA_PULL_PRELOAD_INTERVAL, 1);

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class CachedAdInfo {
        private long aid;
        private long creativeId;
        public String filePath;
        private Downloader.DownloadListener listener = new Downloader.DownloadListener() { // from class: com.tencent.mobileqq.mini.manager.MiniLoadingAdManager.CachedAdInfo.1
            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadSucceed(String str, DownloadResult downloadResult) {
                QLog.d("MiniLoadingAdManager", 1, "onDownloadSucceed url\uff1a" + str + " filePath:" + CachedAdInfo.this.filePath);
                CachedAdInfo.this.updatePreloadAdCache();
            }

            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadCanceled(String str) {
            }

            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadFailed(String str, DownloadResult downloadResult) {
            }

            @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
            public void onDownloadProgress(String str, long j3, float f16) {
            }
        };
        private String saveKey;
        public String url;
        public String videoPath;
        public String videoUrl;

        public CachedAdInfo(GdtAd gdtAd, String str, String str2) {
            qq_ad_get.QQAdGetRsp.AdInfo adInfo;
            qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo displayInfo;
            qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo traceInfo;
            if (gdtAd != null && (adInfo = gdtAd.info) != null && (displayInfo = adInfo.display_info) != null) {
                qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo basicInfo = displayInfo.basic_info;
                if (basicInfo != null && !TextUtils.isEmpty(basicInfo.img.get())) {
                    this.url = gdtAd.info.display_info.basic_info.img.get();
                }
                qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo reportInfo = gdtAd.info.report_info;
                if (reportInfo != null && (traceInfo = reportInfo.trace_info) != null) {
                    this.aid = traceInfo.aid.get();
                    this.creativeId = gdtAd.info.report_info.trace_info.creative_id.get();
                }
                if (!TextUtils.isEmpty(gdtAd.getVideoUrl())) {
                    this.videoUrl = gdtAd.getVideoUrl();
                    this.videoPath = MiniAppFileManager.getLoadingAdCacheFilePath(this.videoUrl, str) + AdUtils.getFileSuffixByUrl(this.videoUrl);
                }
                if (!TextUtils.isEmpty(this.url)) {
                    this.filePath = MiniAppFileManager.getLoadingAdCacheFilePath(this.url, str);
                }
            }
            this.saveKey = MiniLoadingAdManager.PRELOAD_ADJSON_KEY_PREFEX + str + "_" + str2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updatePreloadAdCache() {
            QLog.d("MiniLoadingAdManager", 1, "updatePreloadAdCache \u66f4\u65b0\u7f13\u5b58\u5e7f\u544a\u5217\u8868");
            try {
                JSONObject jSONObject = new JSONObject(MiniAppMMKVUtils.getString(this.saveKey, new JSONObject().toString()));
                JSONArray optJSONArray = jSONObject.optJSONArray("adarray");
                if (optJSONArray == null) {
                    optJSONArray = new JSONArray();
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("aid", this.aid);
                jSONObject2.put("creativeId", this.creativeId);
                jSONObject2.put("url", this.url);
                jSONObject2.put("filePath", this.filePath);
                jSONObject2.put(AppConstants.Key.KEY_QZONE_VIDEO_URL, this.videoUrl);
                jSONObject2.put("videoPath", this.videoPath);
                optJSONArray.mo162put(jSONObject2);
                jSONObject.put("adarray", optJSONArray);
                MiniAppMMKVUtils.putString(this.saveKey, jSONObject.toString());
                MiniLoadingAdManager.clearCachedSpAdJsonOld();
            } catch (JSONException e16) {
                QLog.e("MiniLoadingAdManager", 1, "updatePreloadAdCache failed, error is " + e16);
            }
        }

        public boolean isValid(String str, String str2) {
            File file = new File(str2);
            if (file.exists()) {
                updatePreloadAdCache();
            }
            return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || this.aid == 0 || this.creativeId == 0 || file.exists()) ? false : true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    @interface CheckLoadingAdLimitType {
    }

    MiniLoadingAdManager() {
    }

    private static void checkCacheFolder() {
        if (FileUtils.getFileOrFolderSize(MiniAppFileManager.getLoadingAdCacheFolder()) > maxAdCachedSize) {
            QLog.d("MiniLoadingAdManager", 1, "checkCacheFolder size > maxAdCachedSize ");
            FileUtils.deleteFilesInDirectory(MiniAppFileManager.getLoadingAdCacheFolder());
        }
    }

    public static void clearCachedSpAdJson() {
        clearCachedSpAdJsonOld();
        Map<String, ?> all = StorageUtil.getAdPreference().getAll();
        HashSet hashSet = new HashSet();
        for (String str : all.keySet()) {
            if (str.startsWith(PRELOAD_ADJSON_KEY_PREFEX)) {
                hashSet.add(str);
            } else if (str.startsWith(HAS_CLEAR_OLD_SP_CACHE_DATA)) {
                hashSet.add(str);
            }
        }
        SharedPreferences.Editor edit = StorageUtil.getAdPreference().edit();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            edit.remove(str2);
            MiniAppMMKVUtils.removeValue(str2);
            QLog.d("MiniLoadingAdManager", 1, "clearCachedSpAdJson, sp key is " + str2);
        }
        edit.apply();
    }

    public static void clearCachedSpAdJsonOld() {
        if (getInstance().hasClearOldSpCache()) {
            return;
        }
        Map<String, ?> all = StorageUtil.getPreference().getAll();
        HashSet hashSet = new HashSet();
        if (all != null) {
            for (String str : all.keySet()) {
                if (str.startsWith(PRELOAD_ADJSON_KEY_PREFEX)) {
                    hashSet.add(str);
                }
            }
        }
        SharedPreferences.Editor edit = StorageUtil.getPreference().edit();
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            edit.remove(str2);
            QLog.d("MiniLoadingAdManager", 1, "clearCachedSpAdJsonOld, sp key is " + str2);
        }
        edit.apply();
        getInstance().updateHasClearOldSpCache();
    }

    public static void downloadAndSaveLoadingAd(String str, String str2, String str3) {
        QLog.d("MiniLoadingAdManager", 1, "downloadAndSaveLoadingAd \u9884\u52a0\u8f7d\u5e7f\u544a\u7f13\u5b58\u903b\u8f91start");
        MiniAppMMKVUtils.putString(PRELOAD_ADJSON_KEY_PREFEX + str2 + "_" + str3, new JSONObject().toString());
        checkCacheFolder();
        List<GdtAd> convertJson2GdtAds = AdUtils.convertJson2GdtAds(str);
        if (convertJson2GdtAds != null && !convertJson2GdtAds.isEmpty()) {
            for (GdtAd gdtAd : convertJson2GdtAds) {
                final CachedAdInfo cachedAdInfo = new CachedAdInfo(gdtAd, str2, str3);
                if (cachedAdInfo.isValid(cachedAdInfo.url, cachedAdInfo.filePath)) {
                    ThreadPools.getNetworkIOThreadPool().execute(new Runnable() { // from class: com.tencent.mobileqq.mini.manager.MiniLoadingAdManager.2
                        @Override // java.lang.Runnable
                        public void run() {
                            MiniappDownloadUtil miniappDownloadUtil = MiniappDownloadUtil.getInstance();
                            CachedAdInfo cachedAdInfo2 = CachedAdInfo.this;
                            miniappDownloadUtil.download(cachedAdInfo2.url, cachedAdInfo2.filePath, false, cachedAdInfo2.listener, Downloader.DownloadMode.OkHttpMode, null);
                        }
                    });
                } else {
                    QLog.d("MiniLoadingAdManager", 1, "downloadAndSaveLoadingAd \u5e7f\u544a\u56fe\u7247\u6570\u636e\u4e0d\u5408\u6cd5\u6216\u5df2\u7ecf\u4e0b\u8f7d\u8fc7");
                }
                if (isVideoAd(gdtAd) && cachedAdInfo.isValid(cachedAdInfo.videoUrl, cachedAdInfo.videoPath)) {
                    ThreadPools.getNetworkIOThreadPool().execute(new Runnable() { // from class: com.tencent.mobileqq.mini.manager.MiniLoadingAdManager.3
                        @Override // java.lang.Runnable
                        public void run() {
                            MiniappDownloadUtil miniappDownloadUtil = MiniappDownloadUtil.getInstance();
                            CachedAdInfo cachedAdInfo2 = CachedAdInfo.this;
                            miniappDownloadUtil.download(cachedAdInfo2.videoUrl, cachedAdInfo2.videoPath, false, cachedAdInfo2.listener, Downloader.DownloadMode.OkHttpMode, null);
                        }
                    });
                } else {
                    QLog.d("MiniLoadingAdManager", 1, "downloadAndSaveLoadingAd \u5e7f\u544a\u89c6\u9891\u6570\u636e\u4e0d\u5408\u6cd5\u6216\u5df2\u7ecf\u4e0b\u8f7d\u8fc7");
                }
            }
            return;
        }
        QLog.d("MiniLoadingAdManager", 1, "downloadAndSaveLoadingAd \u5e7f\u544a\u6570\u636e\u4e3a\u7a7a");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void extraPreloadIntervalUpdate(String str, String str2) {
        MiniAppMMKVUtils.putLong("mini_loading_ad_extra_preload_interval_check__" + str2 + "_" + str, System.currentTimeMillis());
    }

    private boolean extraPullPreloadIntervalCheck(String str) {
        long j3 = MiniAppMMKVUtils.getLong("launch_adv_app_pull_preload_interval_" + str, -1L);
        return j3 > 0 && System.currentTimeMillis() - j3 <= ((long) this.extraPullPreloadInterval) * 3600000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void extraPullPreloadIntervalUpdate(String str) {
        MiniAppMMKVUtils.putLong("launch_adv_app_pull_preload_interval_" + str, System.currentTimeMillis());
    }

    private JSONArray getCachedAdJsonArray(String str) {
        try {
            JSONArray optJSONArray = new JSONObject(MiniAppMMKVUtils.getString(str, new JSONObject().toString())).optJSONArray("adarray");
            if (optJSONArray != null) {
                if (optJSONArray.length() >= 1) {
                    return optJSONArray;
                }
            }
            return null;
        } catch (JSONException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static ArrayList<MiniAppAd$SpecifiedAdsItem> getCurCachedAdsList(String str, String str2) {
        cachedAidFilePathMap.clear();
        getInstance();
        ArrayList<MiniAppAd$SpecifiedAdsItem> cachedAdList = getCachedAdList(getInstance().getCachedAdJsonArray(PRELOAD_ADJSON_KEY_PREFEX + str + "_" + str2));
        getInstance();
        ArrayList<MiniAppAd$SpecifiedAdsItem> cachedAdList2 = getCachedAdList(getInstance().getCachedAdJsonArray(PRELOAD_ADJSON_KEY_PREFEX + str + "_100"));
        ArrayList<MiniAppAd$SpecifiedAdsItem> arrayList = new ArrayList<>();
        if (cachedAdList != null) {
            arrayList.addAll(cachedAdList);
        }
        if (cachedAdList2 != null) {
            arrayList.addAll(cachedAdList2);
        }
        return arrayList;
    }

    public static long getCurZeroTimeMillis() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static MiniLoadingAdManager getInstance() {
        if (sInstance == null) {
            synchronized (MiniLoadingAdManager.class) {
                if (sInstance == null) {
                    sInstance = new MiniLoadingAdManager();
                }
            }
        }
        return sInstance;
    }

    private boolean hasClearOldSpCache() {
        return StorageUtil.getAdPreference().getBoolean(HAS_CLEAR_OLD_SP_CACHE_DATA, false);
    }

    private static long parseUinToLong(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return Long.parseLong(str);
            }
            return Long.parseLong(BaseApplicationImpl.getApplication().getRuntime().getAccount());
        } catch (Exception e16) {
            QLog.e("MiniLoadingAdManager", 1, "uin format error!", e16);
            return 0L;
        }
    }

    private void updateHasClearOldSpCache() {
        SharedPreferences.Editor edit = StorageUtil.getAdPreference().edit();
        if (edit != null) {
            edit.putBoolean(HAS_CLEAR_OLD_SP_CACHE_DATA, true);
            edit.apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateLoadingAdFrequencyLimitationRecord(String str, String str2, int i3) {
        String str3 = getPrefix(i3) + str2;
        String str4 = str3 + "_times";
        String str5 = getPrefix(i3) + str2 + "_" + str;
        String str6 = str5 + "_times";
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "vas_mmkv_configurations");
        long decodeLong = from.decodeLong(str3, 0L);
        int decodeInt = from.decodeInt(str4, 0);
        long decodeLong2 = from.decodeLong(str5, 0L);
        int decodeInt2 = from.decodeInt(str6, 0);
        long curZeroTimeMillis = getCurZeroTimeMillis();
        if (decodeLong != curZeroTimeMillis) {
            from.encodeLong(str3, curZeroTimeMillis);
            from.encodeInt(str4, 1);
        } else {
            from.encodeInt(str4, decodeInt + 1);
        }
        if (decodeLong2 != curZeroTimeMillis) {
            from.encodeLong(str5, curZeroTimeMillis);
            from.encodeInt(str6, 1);
        } else {
            from.encodeInt(str6, decodeInt2 + 1);
        }
    }

    public void show(MiniLoadingAdLayout miniLoadingAdLayout, String str, String str2, MiniLoadingAdLayout.OnDismissListener onDismissListener) {
        miniLoadingAdLayout.show(onDismissListener);
        updateLoadingAdFrequencyLimitationRecord(str, str2, 0);
    }

    public static boolean isVideoAd(GdtAd gdtAd) {
        return gdtAd != null && (gdtAd.getInnerShowType() == 3 || gdtAd.getInnerShowType() == 4 || gdtAd.getInnerShowType() == 34);
    }

    public static void requestPreloadLoadingAd(final MiniAppConfig miniAppConfig, final String str) {
        if (miniAppConfig == null || miniAppConfig.config == null) {
            return;
        }
        QLog.d("MiniLoadingAdManager", 1, "\u9884\u52a0\u8f7d\u63a5\u53e3\u8c03\u7528");
        MiniAppAd$StGetAdReq adReq = getAdReq(miniAppConfig, str, 1);
        MiniProgramLpReportDC04239.reportMiniAppEvent(miniAppConfig, MiniProgramLpReportDC04239.getAppType(miniAppConfig), null, "ad", "ad_loading", "preload_call", null);
        final long currentTimeMillis = System.currentTimeMillis();
        MiniAppCmdUtil.getInstance().getRewardedVideoADInfo(adReq, new MiniAppCmdInterface() { // from class: com.tencent.mobileqq.mini.manager.MiniLoadingAdManager.1
            @Override // com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface
            public void onCmdListener(boolean z16, JSONObject jSONObject) {
                QLog.d("MiniLoadingAdManager", 1, "\u9884\u52a0\u8f7d\u63a5\u53e3 receive isSuc= " + z16);
                if (z16 && jSONObject != null) {
                    try {
                        MiniAppAd$StGetAdRsp miniAppAd$StGetAdRsp = (MiniAppAd$StGetAdRsp) jSONObject.get("response");
                        int i3 = jSONObject.getInt("retCode");
                        String string = jSONObject.getString("errMsg");
                        String str2 = miniAppAd$StGetAdRsp.strAdsJson.get();
                        QLog.d("MiniLoadingAdManager", 1, "\u9884\u52a0\u8f7d\u63a5\u53e3 receive retCode= " + i3 + " errMsg=" + string);
                        if (i3 == 0 && !TextUtils.isEmpty(str2)) {
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            MiniAppConfig miniAppConfig2 = miniAppConfig;
                            MiniProgramLpReportDC04239.reportMiniAppEvent(miniAppConfig2, MiniProgramLpReportDC04239.getAppType(miniAppConfig2), null, "ad", "ad_loading", "preload_success", String.valueOf(currentTimeMillis2));
                            MiniLoadingAdManager.downloadAndSaveLoadingAd(str2, str, miniAppConfig.config.appId);
                            MiniLoadingAdManager.updateLoadingAdFrequencyLimitationRecord(miniAppConfig.config.appId, str, 1);
                            MiniLoadingAdManager.extraPreloadIntervalUpdate(miniAppConfig.config.appId, str);
                            MiniLoadingAdManager.extraPullPreloadIntervalUpdate(str);
                            return;
                        }
                    } catch (JSONException unused) {
                        return;
                    }
                }
                int optInt = jSONObject != null ? jSONObject.optInt("retCode", -1) : -1;
                MiniAppConfig miniAppConfig3 = miniAppConfig;
                MiniProgramLpReportDC04239.reportMiniAppEvent(miniAppConfig3, MiniProgramLpReportDC04239.getAppType(miniAppConfig3), null, "ad", "ad_loading", "preload_fail", optInt + "");
            }
        });
    }

    public static ArrayList<MiniAppAd$SpecifiedAdsItem> getCachedAdList(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            try {
                ArrayList<MiniAppAd$SpecifiedAdsItem> arrayList = new ArrayList<>();
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    MiniAppAd$SpecifiedAdsItem miniAppAd$SpecifiedAdsItem = new MiniAppAd$SpecifiedAdsItem();
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    if (jSONObject != null) {
                        String string = jSONObject.getString("filePath");
                        if (new File(string).exists()) {
                            long j3 = jSONObject.getLong("aid");
                            cachedAidFilePathMap.put(Long.valueOf(j3), string);
                            miniAppAd$SpecifiedAdsItem.aid.set(j3);
                            miniAppAd$SpecifiedAdsItem.creative_id.set(jSONObject.getLong("creativeId"));
                            arrayList.add(miniAppAd$SpecifiedAdsItem);
                        }
                    }
                }
                return arrayList;
            } catch (JSONException e16) {
                QLog.e("MiniLoadingAdManager", 1, "getCachedAdList failed, error is " + e16);
            }
        }
        return null;
    }

    private static String getPrefix(int i3) {
        if (i3 == 0) {
            return SELECT_PREFIX;
        }
        if (i3 != 1) {
            return "";
        }
        return PRELOAD_PREFIX;
    }

    private static MiniAppAd$StGetAdReq getAdReq(MiniAppConfig miniAppConfig, String str, int i3) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        MiniAppInfo miniAppInfo;
        LaunchParam launchParam;
        int i16 = !(miniAppConfig != null && miniAppConfig.isEngineTypeMiniGame()) ? 14 : 15;
        if (miniAppConfig == null || (launchParam = miniAppConfig.launchParam) == null) {
            str2 = "";
            str3 = str2;
            str4 = str3;
        } else {
            String str7 = launchParam.entryPath;
            String str8 = launchParam.reportData;
            str4 = String.valueOf(launchParam.scene);
            str2 = str7;
            str3 = str8;
        }
        if (miniAppConfig == null || (miniAppInfo = miniAppConfig.config) == null) {
            str5 = "";
            str6 = str5;
        } else {
            String str9 = miniAppInfo.via;
            str5 = miniAppInfo.appId;
            str6 = str9;
        }
        String spAdGdtCookie = AdUtils.getSpAdGdtCookie(i16);
        int config = QzoneConfig.getInstance().getConfig("QZoneSetting", "MiniGameShareRate", 53);
        long parseUinToLong = parseUinToLong(str);
        if (parseUinToLong == 0) {
            return null;
        }
        if (i3 == 0) {
            return AdUtils.createAdRequest(BaseApplication.getContext(), parseUinToLong, "", str5, config, i16, 0, spAdGdtCookie, str2, str3, str4, str6, 1, 2, getCurCachedAdsList(str, str5));
        }
        if (i3 == 1) {
            return AdUtils.createAdRequest(BaseApplication.getContext(), parseUinToLong, "", str5, config, i16, 0, spAdGdtCookie, str2, str3, str4, str6, 1, 1, null);
        }
        return null;
    }
}
