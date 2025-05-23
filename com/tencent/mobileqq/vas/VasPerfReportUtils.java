package com.tencent.mobileqq.vas;

import android.text.TextUtils;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import java.util.HashMap;

/* loaded from: classes20.dex */
public class VasPerfReportUtils {
    public static final String ADD_GIFT_ANIM = "addGiftAnimation";
    public static final String BANNER_PLAY_END = "bannerViewPlayed";
    public static final String BANNER_PLAY_START = "bannerPlayStart";
    public static final String BANNER_RES_DOWNLOADED = "bannerResDownloaded";
    public static final String BEGAN = "began";
    private static final String EVENT_NAME = "GIFT_PERF";
    public static final String GET_RES_DOWNLOAD = "getResourcesDownload";
    public static final String GET_RES_LOCAL = "getResourcesLocal";
    public static final String GIFT_NEED_PLAY = "giftNeedPlay";
    public static final String GIFT_VIEW_IMPL_PLAY = "giftViewImplPlay";
    public static final String GIFT_VIEW_IMPL_PLAY_START = "giftViewImplPlayStart";
    public static final String INTENT_TO_PLAY = "intentToPlay";
    public static final String JUNIOR_GIFT_VIEW = "junior";
    public static final String PAG_GIFT_VIEW = "pag";
    public static final String PNG_GIFT_VIEW = "png";
    public static final String PREPARE_ENGINE = "prepareEngine";
    public static final String SUCCESS = "success";
    public static final String WHILE_COST_TOTAL = "totalCost";
    public static final String WHILE_CREATE_PANEL = "createGiftPanel";
    public static final String WHILE_GET_LIST = "getList";
    public static final String WHILE_INIT = "init";
    public static final String WHILE_ON_PANEL_SHOW = "onPanelShow";
    public static final String WHILE_SHOW_POPUP_WINDOW = "showByPop";
    public static final String WHILE_UPDATE_ITEM = "updateView";
    public static final String WITHIN_BUSINESS = "[business]";
    public static final String WITHIN_SDK = "[sdk]";
    private static final HashMap<String, Long> sSceneIdToStartTime = new HashMap<>();

    public static void report(String str, String str2, String str3, String str4, long j3) {
        HashMap<String, Long> hashMap;
        Long l3;
        if (WHILE_COST_TOTAL.equals(str)) {
            if (TextUtils.isEmpty(str3) || (l3 = (hashMap = sSceneIdToStartTime).get(str3)) == null) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis() - l3.longValue();
            hashMap.remove(str3);
            j3 = currentTimeMillis;
        }
        VasCommonReporter.newReport(EVENT_NAME).setValue1(str).setValue2(str2).setValue3(str3).setValue4(str4).setNum1(j3).report();
    }

    public static void reportGiftViewPlay(String str, String str2) {
        VasCommonReporter.newReport(EVENT_NAME).setValue1(str).setValue2(str2).report();
    }

    public static void saveStartTime(String str) {
        if (!TextUtils.isEmpty(str)) {
            sSceneIdToStartTime.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }
}
