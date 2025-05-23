package com.tencent.qqmini.sdk.manager;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniQMMKVProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.utils.StartupReportUtil;
import com.tencent.qqmini.sdk.report.SDKMiniProgramLpReportDC04239;
import com.tencent.qqmini.sdk.utils.AdUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniLoadingAdManager {
    public static final String EXTRA_APP_LOADING_KEY = "AND_MINI";
    public static final String EXTRA_GAME_LOADING_KEY = "AND_GAME";
    public static final String EXTRA_JSON_ARRAY_KEY = "adarray";
    private static final String EXTRA_PRELOAD_INTERVAL_CHECK_PREFIX = "mini_loading_ad_extra_preload_interval_check_";
    public static final String EXTRA_VIRTUAL_APP_ID = "100";
    public static final String KEY_APP_CONFIG = "app_config";
    public static final String KEY_UIN = "uin";
    private static final int LOADING_AD_LIMIT_TYPE_PRELOAD = 1;
    private static final int LOADING_AD_LIMIT_TYPE_SELECT = 0;
    private static final String PRELOAD_ADJSON_KEY_PREFEX = "mini_loading_ad_preload_adjson_key_";
    private static final String PRELOAD_PREFIX = "mini_loading_ad_preload_";
    private static final String SELECT_PREFIX = "mini_loading_ad_select_";
    public static final String TAG = "MiniLoadingAdManager";
    public static final int TYPE_CLICK_BAR = 1;
    public static final int TYPE_CLICK_IMG = 0;
    private static final String VIA_AD_PREFIX = "2054_";
    private static HashMap<Long, String> cachedAidFilePathMap = new HashMap<>();
    private static HashMap<Long, String> cachedAidVideoPathMap = new HashMap<>();
    private static final String defaultViaListStr = "2054_1,2054_2,2054_3,2054_4,2054_5,2054_6,2054_7,2054_8,2054_9,2054_10,2054_11,2054_12,2054_13,2054_14,2054_15,2054_17,2054_18,2054_19,2014_31,4017_1,2016_72,2016_74";
    private static volatile MiniLoadingAdManager sInstance;
    private OnChooseAdEndListener chooseAdEndListener;
    private int maxSelectCountForUin = WnsConfig.getConfig("qqminiapp", "launch_adv_user_select_limit", 5);
    private int maxSelectCountForUinAndAppid = WnsConfig.getConfig("qqminiapp", "launch_adv_app_select_limit", 2);
    private int maxPreloadCountForUin = WnsConfig.getConfig("qqminiapp", "launch_adv_user_preload_limit", Integer.MAX_VALUE);
    private int maxPreloadCountForUinAndAppid = WnsConfig.getConfig("qqminiapp", "launch_adv_app_preload_limit", 5);
    private int extraPreloadInterval = WnsConfig.getConfig("qqminiapp", "launch_adv_app_preload_interval", 0);
    private String unsupportedViaList = WnsConfig.getConfig("qqminiapp", "launch_adv_unsupport_via_list", defaultViaListStr);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.qqmini.sdk.manager.MiniLoadingAdManager$3, reason: invalid class name */
    /* loaded from: classes23.dex */
    public static class AnonymousClass3 implements Runnable {
        final /* synthetic */ MiniAppInfo val$miniAppInfo;
        final /* synthetic */ String val$uin;

        AnonymousClass3(MiniAppInfo miniAppInfo, String str) {
            this.val$miniAppInfo = miniAppInfo;
            this.val$uin = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (((AdProxy) ProxyManager.get(AdProxy.class)) != null) {
                Bundle adReqBundle = MiniLoadingAdManager.getAdReqBundle(this.val$miniAppInfo, 1);
                MiniAppInfo miniAppInfo = this.val$miniAppInfo;
                SDKMiniProgramLpReportDC04239.reportMiniAppEvent(miniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo), null, "ad", "ad_loading", "preload_call", null);
                final long currentTimeMillis = System.currentTimeMillis();
                ((AdProxy) ProxyManager.get(AdProxy.class)).preloadLoadingAd(adReqBundle, new AdProxy.ILoadingAdListener() { // from class: com.tencent.qqmini.sdk.manager.MiniLoadingAdManager.3.1
                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
                    public void onPreloadAdReceive(int i3) {
                        boolean z16;
                        if (i3 == 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        QMLog.d("MiniLoadingAdManager", "\u9884\u52a0\u8f7d\u63a5\u53e3 onPreloadAdReceive success\uff1a" + z16);
                        if (z16) {
                            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                            MiniAppInfo miniAppInfo2 = AnonymousClass3.this.val$miniAppInfo;
                            SDKMiniProgramLpReportDC04239.reportMiniAppEvent(miniAppInfo2, SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo2), null, "ad", "ad_loading", "preload_success", String.valueOf(currentTimeMillis2));
                            ThreadManager.runIOTask(new Runnable() { // from class: com.tencent.qqmini.sdk.manager.MiniLoadingAdManager.3.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                                    MiniLoadingAdManager.updateLoadingAdFrequencyLimitationRecord(anonymousClass3.val$miniAppInfo.appId, anonymousClass3.val$uin, 1);
                                }
                            });
                            AnonymousClass3 anonymousClass3 = AnonymousClass3.this;
                            MiniLoadingAdManager.extraPreloadIntervalUpdate(anonymousClass3.val$miniAppInfo.appId, anonymousClass3.val$uin);
                            return;
                        }
                        MiniAppInfo miniAppInfo3 = AnonymousClass3.this.val$miniAppInfo;
                        SDKMiniProgramLpReportDC04239.reportMiniAppEvent(miniAppInfo3, SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo3), null, "ad", "ad_loading", "preload_fail", i3 + "");
                    }

                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
                    public void getLoadingAdLayoutReady() {
                    }

                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
                    public void onAdClick(int i3) {
                    }

                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
                    public void onAdDismiss(boolean z16) {
                    }

                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
                    public void onAdShow(View view) {
                    }

                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
                    public void onDownloadAdEnd(String str, long j3, String str2) {
                    }

                    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
                    public void onSelectAdProcessDone(String str, ArrayList<Long> arrayList, HashMap<String, String> hashMap) {
                    }
                });
                return;
            }
            QMLog.i("MiniLoadingAdManager", "start create, null");
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface OnChooseAdEndListener {
        void onChooseAdEnd(String str, long j3, boolean z16);

        void onDownloadAdEnd(String str, long j3);

        void onNeedWaitRealTime(String str, boolean z16, long j3);
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public interface OnDismissListener {
        void onDismiss();
    }

    MiniLoadingAdManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void assembleCachedAidMap(String str, String str2) {
        cachedAidFilePathMap.clear();
        getInstance().initCachedAdMap(getInstance().getCachedAdJsonArray(PRELOAD_ADJSON_KEY_PREFEX + str + "_" + str2));
        getInstance().initCachedAdMap(getInstance().getCachedAdJsonArray(PRELOAD_ADJSON_KEY_PREFEX + str + "_100"));
    }

    private boolean checkLoadingAdFrequencyLimitation(@NonNull String str, @NonNull String str2, @CheckLoadingAdLimitType int i3) {
        long j3;
        int i16;
        int i17;
        String str3 = getPrefix(i3) + str2;
        String str4 = str3 + "_times";
        String str5 = getPrefix(i3) + str2 + "_" + str;
        String str6 = str5 + "_times";
        MiniQMMKVProxy miniQMMKVProxy = (MiniQMMKVProxy) ProxyManager.get(MiniQMMKVProxy.class);
        long j16 = 0;
        if (miniQMMKVProxy != null) {
            long miniAppLong = miniQMMKVProxy.getMiniAppLong(str3, 0L);
            i17 = miniQMMKVProxy.getMiniAppInt(str4, 0);
            long miniAppLong2 = miniQMMKVProxy.getMiniAppLong(str5, 0L);
            i16 = miniQMMKVProxy.getMiniAppInt(str6, 0);
            j3 = miniAppLong2;
            j16 = miniAppLong;
        } else {
            j3 = 0;
            i16 = 0;
            i17 = 0;
        }
        QMLog.d("MiniLoadingAdManager", "lastTimestamp:" + j16 + " totalTimes:" + i17 + " lastTimestampForAppid:" + j3 + " totalTimesForAppid:" + i16);
        if (j16 == getCurZeroTimeMillis() && i17 >= 1) {
            if (i17 >= getLimit(i3, false)) {
                return false;
            }
            if (j3 == getCurZeroTimeMillis() && i16 >= 1 && i16 >= getLimit(i3, true)) {
                return false;
            }
            return true;
        }
        return true;
    }

    private boolean extraPreloadIntervalCheck(String str, String str2) {
        String str3 = "mini_loading_ad_extra_preload_interval_check__" + str2 + "_" + str;
        MiniQMMKVProxy miniQMMKVProxy = (MiniQMMKVProxy) ProxyManager.get(MiniQMMKVProxy.class);
        long j3 = -1;
        if (miniQMMKVProxy != null) {
            j3 = miniQMMKVProxy.getMiniAppLong(str3, -1L);
        }
        if (j3 <= 0 || (System.currentTimeMillis() - j3) / 1000 > this.extraPreloadInterval) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void extraPreloadIntervalUpdate(String str, String str2) {
        MiniQMMKVProxy miniQMMKVProxy = (MiniQMMKVProxy) ProxyManager.get(MiniQMMKVProxy.class);
        if (miniQMMKVProxy == null) {
            QMLog.e("MiniLoadingAdManager", "extraPreloadIntervalUpdate error: proxy is null");
            return;
        }
        miniQMMKVProxy.putMiniAppLong("mini_loading_ad_extra_preload_interval_check__" + str2 + "_" + str, System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Bundle getAdReqBundle(MiniAppInfo miniAppInfo, int i3) {
        int i16;
        String account = LoginManager.getInstance().getAccount();
        String str = miniAppInfo.appId;
        if (!(!miniAppInfo.isEngineTypeMiniApp())) {
            i16 = 14;
        } else {
            i16 = 15;
        }
        String spAdGdtCookie = AdUtil.getSpAdGdtCookie(i16);
        LaunchParam launchParam = miniAppInfo.launchParam;
        String str2 = launchParam.entryPath;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = launchParam.reportData;
        String valueOf = String.valueOf(launchParam.scene);
        String str4 = miniAppInfo.via;
        if (str4 == null) {
            str4 = "";
        }
        Bundle bundle = new Bundle();
        bundle.putString(AdProxy.KEY_ACCOUNT, account);
        bundle.putString(AdProxy.KEY_GDT_COOKIE, spAdGdtCookie);
        bundle.putString(AdProxy.KEY_ENTRY_PATH, str2);
        bundle.putString(AdProxy.KEY_REPORT_DATA, str3);
        bundle.putString(AdProxy.KEY_REFER, valueOf);
        bundle.putString(AdProxy.KEY_VIA, str4);
        bundle.putString(AdProxy.KEY_POSID, "");
        bundle.putString(AdProxy.KEY_APPID, str);
        bundle.putInt(AdProxy.KEY_AD_TYPE, i16);
        bundle.putInt(AdProxy.KEY_ORIENTATION, 0);
        bundle.putInt(AdProxy.KEY_SHARE_RATE, 53);
        bundle.putInt(AdProxy.KEY_ADCOUNT, 1);
        bundle.putInt(AdProxy.KEY_MODE, i3);
        return bundle;
    }

    private JSONArray getCachedAdJsonArray(String str) {
        MiniQMMKVProxy miniQMMKVProxy = (MiniQMMKVProxy) ProxyManager.get(MiniQMMKVProxy.class);
        String jSONObject = new JSONObject().toString();
        if (miniQMMKVProxy != null) {
            jSONObject = miniQMMKVProxy.getMiniAppString(str, jSONObject);
        }
        try {
            JSONArray optJSONArray = new JSONObject(jSONObject).optJSONArray("adarray");
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

    private long getLimit(@CheckLoadingAdLimitType int i3, boolean z16) {
        int i16;
        int i17;
        if (i3 != 0) {
            if (i3 != 1) {
                return 0L;
            }
            if (z16) {
                i17 = this.maxPreloadCountForUinAndAppid;
            } else {
                i17 = this.maxPreloadCountForUin;
            }
            return i17;
        }
        if (z16) {
            i16 = this.maxSelectCountForUinAndAppid;
        } else {
            i16 = this.maxSelectCountForUin;
        }
        return i16;
    }

    private static String getPrefix(@CheckLoadingAdLimitType int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                return "";
            }
            return PRELOAD_PREFIX;
        }
        return SELECT_PREFIX;
    }

    private void initCachedAdMap(JSONArray jSONArray) {
        if (jSONArray != null && jSONArray.length() != 0) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                try {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    if (jSONObject != null) {
                        String optString = jSONObject.optString("filePath");
                        if (new File(optString).exists()) {
                            long j3 = jSONObject.getLong("aid");
                            cachedAidFilePathMap.put(Long.valueOf(j3), optString);
                            String optString2 = jSONObject.optString("videoPath");
                            if (new File(optString2).exists()) {
                                cachedAidVideoPathMap.put(Long.valueOf(j3), optString2);
                            }
                        }
                    }
                } catch (JSONException e16) {
                    e16.printStackTrace();
                    return;
                }
            }
        }
    }

    private boolean isViaUnsupported(String str) {
        if (!TextUtils.isEmpty(this.unsupportedViaList) && !TextUtils.isEmpty(str)) {
            try {
                String[] split = this.unsupportedViaList.split(",");
                if (split != null && split.length >= 1) {
                    for (String str2 : split) {
                        if (str.equals(str2)) {
                            return true;
                        }
                    }
                }
                return false;
            } catch (Throwable th5) {
                QMLog.e("MiniLoadingAdManager", "isViaUnsupported exception via:" + str, th5);
            }
        }
        return false;
    }

    public static void requestPreloadLoadingAd(MiniAppInfo miniAppInfo, String str) {
        if (miniAppInfo == null) {
            return;
        }
        QMLog.d("MiniLoadingAdManager", "\u9884\u52a0\u8f7d\u63a5\u53e3\u8c03\u7528");
        ThreadManager.getSubThreadHandler().post(new AnonymousClass3(miniAppInfo, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void updateLoadingAdFrequencyLimitationRecord(@NonNull String str, @NonNull String str2, @CheckLoadingAdLimitType int i3) {
        MiniQMMKVProxy miniQMMKVProxy = (MiniQMMKVProxy) ProxyManager.get(MiniQMMKVProxy.class);
        if (miniQMMKVProxy == null) {
            QMLog.e("MiniLoadingAdManager", "updateLoadingAdFrequencyLimitationRecord error: proxy is null");
            return;
        }
        String str3 = getPrefix(i3) + str2;
        String str4 = str3 + "_times";
        String str5 = getPrefix(i3) + str2 + "_" + str;
        String str6 = str5 + "_times";
        long miniAppLong = miniQMMKVProxy.getMiniAppLong(str3, 0L);
        int miniAppInt = miniQMMKVProxy.getMiniAppInt(str4, 0);
        long miniAppLong2 = miniQMMKVProxy.getMiniAppLong(str5, 0L);
        int miniAppInt2 = miniQMMKVProxy.getMiniAppInt(str6, 0);
        long curZeroTimeMillis = getCurZeroTimeMillis();
        if (miniAppLong != curZeroTimeMillis) {
            miniQMMKVProxy.putMiniAppLong(str3, curZeroTimeMillis);
            miniQMMKVProxy.putMiniAppInt(str4, 1);
        } else {
            miniQMMKVProxy.putMiniAppInt(str4, miniAppInt + 1);
        }
        if (miniAppLong2 != curZeroTimeMillis) {
            miniQMMKVProxy.putMiniAppLong(str5, curZeroTimeMillis);
            miniQMMKVProxy.putMiniAppInt(str6, 1);
        } else {
            miniQMMKVProxy.putMiniAppInt(str6, miniAppInt2 + 1);
        }
    }

    public void Destroy() {
        this.chooseAdEndListener = null;
    }

    public boolean checkSelectAdNecessity(MiniAppInfo miniAppInfo, String str) {
        if (miniAppInfo != null && !TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(miniAppInfo.appId) && miniAppInfo.enableLoadingAd) {
                if (isViaUnsupported(miniAppInfo.via)) {
                    QMLog.d("MiniLoadingAdManager", "checkSelectAdNecessity via\u4e0d\u652f\u6301");
                    SDKMiniProgramLpReportDC04239.reportMiniAppEvent(miniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo), null, "ad", "ad_loading", SDKMiniProgramLpReportDC04239.AD_RESERVES_REQUEST_SHIELD, miniAppInfo.via);
                    return false;
                }
                if (!checkLoadingAdFrequencyLimitation(miniAppInfo.appId, str, 0)) {
                    QMLog.d("MiniLoadingAdManager", "checkSelectAdNecessity \u9891\u63a7\u9650\u5236");
                    return false;
                }
                return true;
            }
            QMLog.d("MiniLoadingAdManager", "checkSelectAdNecessity \u6ca1\u5f00\u5e7f\u544a\u4f4d");
            return false;
        }
        QMLog.d("MiniLoadingAdManager", "checkSelectAdNecessity \u53c2\u6570\u4e0d\u5408\u6cd5");
        return false;
    }

    public void preloadLoadingAd(MiniAppInfo miniAppInfo) {
        String account = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getAccount();
        if (miniAppInfo != null && !TextUtils.isEmpty(miniAppInfo.appId) && miniAppInfo.enableLoadingAd) {
            if (!checkLoadingAdFrequencyLimitation(miniAppInfo.appId, account, 1)) {
                QMLog.d("MiniLoadingAdManager", "preloadLoadingAd \u9891\u63a7\u9650\u5236");
                return;
            } else if (!extraPreloadIntervalCheck(miniAppInfo.appId, account)) {
                QMLog.d("MiniLoadingAdManager", "preloadLoadingAd \u9891\u63a7\u9650\u5236");
                return;
            } else {
                requestPreloadLoadingAd(miniAppInfo, account);
                return;
            }
        }
        QMLog.d("MiniLoadingAdManager", "preloadLoadingAd \u6ca1\u5f00\u5e7f\u544a\u4f4d");
    }

    public void processSelectAdWithUncachedAd(String str, String str2, String str3, @NonNull final OnChooseAdEndListener onChooseAdEndListener) {
        QMLog.d("MiniLoadingAdManager", "processSelectAdWithUncachedAd downloadRealTimeAdPic \u5b9e\u65f6\u4e0b\u8f7d\u56fe\u7247\u8d44\u6e90");
        ((AdProxy) ProxyManager.get(AdProxy.class)).downloadRealTimeAdPic(str, str2, str3, new AdProxy.ILoadingAdListener() { // from class: com.tencent.qqmini.sdk.manager.MiniLoadingAdManager.2
            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
            public void onDownloadAdEnd(String str4, long j3, String str5) {
                QMLog.d("MiniLoadingAdManager", "processSelectAdWithUncachedAd downloadRealTimeAdPic onDownloadAdEnd adJson:" + str4 + " aid:" + j3);
                if (!TextUtils.isEmpty(str4)) {
                    if (MiniLoadingAdManager.cachedAidFilePathMap != null) {
                        MiniLoadingAdManager.cachedAidFilePathMap.put(Long.valueOf(j3), str5);
                    }
                    onChooseAdEndListener.onDownloadAdEnd(str4, j3);
                    return;
                }
                onChooseAdEndListener.onDownloadAdEnd(null, -1L);
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
            public void getLoadingAdLayoutReady() {
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
            public void onAdClick(int i3) {
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
            public void onAdDismiss(boolean z16) {
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
            public void onAdShow(View view) {
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
            public void onPreloadAdReceive(int i3) {
            }

            @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
            public void onSelectAdProcessDone(String str4, ArrayList<Long> arrayList, HashMap<String, String> hashMap) {
            }
        });
    }

    public boolean selectAd(final MiniAppInfo miniAppInfo, final String str, @NonNull OnChooseAdEndListener onChooseAdEndListener) {
        if (!checkSelectAdNecessity(miniAppInfo, str)) {
            QMLog.d("MiniLoadingAdManager", "checkSelectAdNecessity fail");
            return false;
        }
        this.chooseAdEndListener = onChooseAdEndListener;
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.manager.MiniLoadingAdManager.1
            @Override // java.lang.Runnable
            public void run() {
                AdProxy adProxy = (AdProxy) ProxyManager.get(AdProxy.class);
                if (adProxy != null) {
                    MiniLoadingAdManager.assembleCachedAidMap(str, miniAppInfo.appId);
                    Bundle adReqBundle = MiniLoadingAdManager.getAdReqBundle(miniAppInfo, 0);
                    MiniAppInfo miniAppInfo2 = miniAppInfo;
                    SDKMiniProgramLpReportDC04239.reportMiniAppEvent(miniAppInfo2, SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo2), null, "ad", "ad_loading", "request_call_cnt", null);
                    QMLog.d("MiniLoadingAdManager", "\u9009\u5355\u63a5\u53e3\u8c03\u7528");
                    adProxy.selectLoadingAd(adReqBundle, str, new AdProxy.ILoadingAdListener() { // from class: com.tencent.qqmini.sdk.manager.MiniLoadingAdManager.1.1
                        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
                        public void onSelectAdProcessDone(String str2, ArrayList<Long> arrayList, HashMap<String, String> hashMap) {
                            long j3;
                            boolean z16;
                            long j16;
                            if (!arrayList.isEmpty()) {
                                j3 = arrayList.get(0).longValue();
                            } else {
                                j3 = -1;
                            }
                            QMLog.d("MiniLoadingAdManager", "\u9009\u5355\u63a5\u53e3 onSelectAdProcessDone adJson\uff1a" + str2 + " aid\uff1a" + j3);
                            MiniQMMKVProxy miniQMMKVProxy = (MiniQMMKVProxy) ProxyManager.get(MiniQMMKVProxy.class);
                            if (hashMap != null && !hashMap.isEmpty() && miniQMMKVProxy != null) {
                                miniQMMKVProxy.putMiniAppString(MiniLoadingAdManager.EXTRA_APP_LOADING_KEY, hashMap.get(MiniLoadingAdManager.EXTRA_APP_LOADING_KEY));
                                miniQMMKVProxy.putMiniAppString(MiniLoadingAdManager.EXTRA_GAME_LOADING_KEY, hashMap.get(MiniLoadingAdManager.EXTRA_GAME_LOADING_KEY));
                            }
                            if (arrayList.size() > 1) {
                                j16 = arrayList.get(1).longValue();
                                z16 = MiniLoadingAdManager.cachedAidFilePathMap.containsKey(Long.valueOf(j16));
                            } else {
                                z16 = false;
                                j16 = -1;
                            }
                            boolean z17 = !MiniLoadingAdManager.cachedAidFilePathMap.containsKey(Long.valueOf(j3));
                            QMLog.d("MiniLoadingAdManager", "\u9009\u5355\u63a5\u53e3 onSelectAdProcessDone  hasCachedAd\uff1a" + z16 + " needDownload " + z17 + " cachedAid " + j16);
                            if (MiniLoadingAdManager.this.chooseAdEndListener != null) {
                                if (z16 && z17) {
                                    MiniLoadingAdManager.this.chooseAdEndListener.onNeedWaitRealTime(str2, true, j16);
                                }
                                if (!TextUtils.isEmpty(str2)) {
                                    MiniLoadingAdManager.this.chooseAdEndListener.onChooseAdEnd(str2, j3, z17);
                                } else {
                                    MiniLoadingAdManager.this.chooseAdEndListener.onChooseAdEnd(null, -1L, false);
                                }
                            }
                            MiniLoadingAdManager.this.chooseAdEndListener = null;
                        }

                        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
                        public void getLoadingAdLayoutReady() {
                        }

                        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
                        public void onAdClick(int i3) {
                        }

                        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
                        public void onAdDismiss(boolean z16) {
                        }

                        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
                        public void onAdShow(View view) {
                        }

                        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
                        public void onPreloadAdReceive(int i3) {
                        }

                        @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
                        public void onDownloadAdEnd(String str2, long j3, String str3) {
                        }
                    });
                    return;
                }
                QMLog.i("MiniLoadingAdManager", "start create, null");
            }
        });
        return true;
    }

    public void updateLoadingAdLayoutAndShow(final MiniAppInfo miniAppInfo, final Activity activity, boolean z16, String str, long j3, @NonNull final OnDismissListener onDismissListener) {
        if (((AdProxy) ProxyManager.get(AdProxy.class)) == null) {
            QMLog.i("MiniLoadingAdManager", "start create, null");
            onDismissListener.onDismiss();
            return;
        }
        String str2 = cachedAidFilePathMap.get(Long.valueOf(j3));
        if (TextUtils.isEmpty(str2)) {
            onDismissListener.onDismiss();
        } else {
            SDKMiniProgramLpReportDC04239.reportMiniAppEvent(miniAppInfo, SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo), null, "ad", "ad_loading", "expo_call", null);
            ((AdProxy) ProxyManager.get(AdProxy.class)).updateLoadingAdLayoutAndShow(activity, miniAppInfo, z16, str, miniAppInfo.name, miniAppInfo.iconUrl, miniAppInfo.developerDesc, str2, cachedAidVideoPathMap.get(Long.valueOf(j3)), j3, new AdProxy.ILoadingAdListener() { // from class: com.tencent.qqmini.sdk.manager.MiniLoadingAdManager.4
                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
                public void onAdClick(int i3) {
                    if (i3 != 0) {
                        if (i3 != 1) {
                            QMLog.e("MiniLoadingAdManager", "onAdClick, unknown type:" + i3);
                            return;
                        }
                        MiniAppInfo miniAppInfo2 = miniAppInfo;
                        SDKMiniProgramLpReportDC04239.reportMiniAppEvent(miniAppInfo2, SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo2), null, "ad", "ad_loading", SDKMiniProgramLpReportDC04239.AD_RESERVES_CLICK_BAR, null);
                        return;
                    }
                    MiniAppInfo miniAppInfo3 = miniAppInfo;
                    SDKMiniProgramLpReportDC04239.reportMiniAppEvent(miniAppInfo3, SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo3), null, "ad", "ad_loading", "click", null);
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
                public void onAdDismiss(boolean z17) {
                    if (z17) {
                        MiniAppInfo miniAppInfo2 = miniAppInfo;
                        SDKMiniProgramLpReportDC04239.reportMiniAppEvent(miniAppInfo2, SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo2), null, "ad", "ad_loading", "skip", null);
                    }
                    onDismissListener.onDismiss();
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
                public void onAdShow(View view) {
                    ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
                    if (viewGroup == null) {
                        QMLog.e("MiniLoadingAdManager", "onAdShow, root view is null");
                        return;
                    }
                    final String account = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getAccount();
                    if (viewGroup instanceof FrameLayout) {
                        viewGroup.addView(view, new FrameLayout.LayoutParams(-1, -1));
                    } else if (viewGroup instanceof RelativeLayout) {
                        viewGroup.addView(view, new RelativeLayout.LayoutParams(-1, -1));
                    }
                    ThreadManager.runIOTask(new Runnable() { // from class: com.tencent.qqmini.sdk.manager.MiniLoadingAdManager.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MiniLoadingAdManager.updateLoadingAdFrequencyLimitationRecord(miniAppInfo.appId, account, 0);
                        }
                    });
                    MiniAppInfo miniAppInfo2 = miniAppInfo;
                    SDKMiniProgramLpReportDC04239.reportMiniAppEvent(miniAppInfo2, SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo2), null, "ad", "ad_loading", "expo_success", null);
                    if (miniAppInfo.isEngineTypeMiniGame()) {
                        StartupReportUtil.reportAdShow(miniAppInfo);
                    }
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
                public void getLoadingAdLayoutReady() {
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
                public void onPreloadAdReceive(int i3) {
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
                public void onDownloadAdEnd(String str3, long j16, String str4) {
                }

                @Override // com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener
                public void onSelectAdProcessDone(String str3, ArrayList<Long> arrayList, HashMap<String, String> hashMap) {
                }
            });
        }
    }
}
