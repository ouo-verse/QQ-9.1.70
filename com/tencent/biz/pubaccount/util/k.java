package com.tencent.biz.pubaccount.util;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<String, Long> f80340a = new ConcurrentHashMap<>(new HashMap(8));

    /* renamed from: b, reason: collision with root package name */
    private static long f80341b = 0;

    /* renamed from: c, reason: collision with root package name */
    private static long f80342c = 0;

    /* renamed from: d, reason: collision with root package name */
    private static long f80343d = 0;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f80344e = true;

    /* renamed from: f, reason: collision with root package name */
    public static boolean f80345f = true;

    /* renamed from: g, reason: collision with root package name */
    public static boolean f80346g = true;

    /* renamed from: h, reason: collision with root package name */
    public static boolean f80347h = true;

    /* renamed from: i, reason: collision with root package name */
    public static boolean f80348i = true;

    /* renamed from: j, reason: collision with root package name */
    private static long f80349j = 0;

    /* renamed from: k, reason: collision with root package name */
    private static long f80350k = 0;

    /* renamed from: l, reason: collision with root package name */
    private static long f80351l = 0;

    /* renamed from: m, reason: collision with root package name */
    public static int f80352m = 1;

    public static void a(String str, String str2) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (str != null) {
            Long remove = f80340a.remove(str);
            if (remove != null) {
                if (QLog.isColorLevel()) {
                    QLog.i("PubAccAutoMonitor", 2, str + ", cost=" + (uptimeMillis - remove.longValue()));
                }
                if (TextUtils.equals(str, "KANDIAN_NEW_FEEDS_CREATE")) {
                    f80349j = uptimeMillis - remove.longValue();
                    return;
                }
                if (TextUtils.equals(str, "KANDIAN_NEW_FEEDS_LOAD_ARTICLE")) {
                    f80350k = uptimeMillis - remove.longValue();
                    return;
                }
                if (TextUtils.equals(str, "KANDIAN_NEW_FEEDS_LIST_VIEW_GROUP_MEASURE_LAYOUT_DRAW")) {
                    f80351l = uptimeMillis - remove.longValue();
                    return;
                }
                if (TextUtils.equals(str, "KANDIAN_FEEDS_STAGE_1_COST")) {
                    f80341b = uptimeMillis - remove.longValue();
                    return;
                }
                if (TextUtils.equals(str, "KANDIAN_FEEDS_STAGE_2_COST")) {
                    f80342c = uptimeMillis - remove.longValue();
                    return;
                }
                long longValue = uptimeMillis - remove.longValue();
                f80343d = longValue;
                if (longValue > 10000) {
                    return;
                }
                if (TextUtils.equals(str, "SUBSCRIPT_FEEDS_COST")) {
                    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actSubscribeOpenCost", true, f80343d, 0L, null, null);
                    return;
                }
                if (TextUtils.equals(str, "SUBSCRIPT_AIO_COST")) {
                    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actSubscribeAIOOpenCost", true, f80343d, 0L, null, null);
                    return;
                }
                if (TextUtils.equals(str, "KANDIAN_FEEDS_COST")) {
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("stage_total", String.valueOf(f80343d));
                    hashMap.put("tab_index", String.valueOf(f80352m));
                    hashMap.put("stage_1", String.valueOf(f80341b));
                    hashMap.put("stage_2", String.valueOf(f80342c));
                    hashMap.put("on_create", String.valueOf(f80349j));
                    hashMap.put("load_article", String.valueOf(f80350k));
                    hashMap.put("listView_cost", String.valueOf(f80351l));
                    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actKandianOpenCost", true, f80343d, 0L, hashMap, null);
                    if (QLog.isColorLevel()) {
                        QLog.i("PubAccAutoMonitor", 2, "isRecommendFirst = " + f80344e);
                        QLog.d("PubAccAutoMonitor", 2, "kandian_feeds_open_cost, total_cost = ", Long.valueOf(f80343d), ", tab_index = ", Integer.valueOf(f80352m));
                        return;
                    }
                    return;
                }
                if (TextUtils.equals(str, "KANDIAN_TO_SUBSCRIPT_COST")) {
                    StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actKandianToSubscribeCost", true, f80343d, 0L, null, null);
                    return;
                }
                if (!TextUtils.equals(str, "LEBA_KANDIAN_FEEDS_COST")) {
                    if (TextUtils.equals(str, "SERVICE_FOLDER_COST")) {
                        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actServiceFolderToServiceNumListCost", true, f80343d, 0L, null, null);
                        return;
                    }
                    if (TextUtils.equals(str, "recommend_tab_cost")) {
                        if (QLog.isColorLevel()) {
                            QLog.i("PubAccAutoMonitor", 2, "isRecommendCostFirst = " + f80345f);
                        }
                        HashMap<String, String> hashMap2 = new HashMap<>();
                        hashMap2.put(MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, String.valueOf(f80345f ? 1 : 0));
                        hashMap2.put("which", String.valueOf(1));
                        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actKandianTabOpenCost", true, f80343d, 0L, hashMap2, null);
                        f80345f = false;
                        return;
                    }
                    if (TextUtils.equals(str, "video_tab_cost")) {
                        if (QLog.isColorLevel()) {
                            QLog.i("PubAccAutoMonitor", 2, "isVideoFirst = " + f80346g);
                        }
                        HashMap<String, String> hashMap3 = new HashMap<>();
                        hashMap3.put(MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, String.valueOf(f80346g ? 1 : 0));
                        hashMap3.put("which", String.valueOf(2));
                        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actKandianTabOpenCost", true, f80343d, 0L, hashMap3, null);
                        f80346g = false;
                        return;
                    }
                    if (TextUtils.equals(str, "subscribe_tab_cost")) {
                        if (QLog.isColorLevel()) {
                            QLog.i("PubAccAutoMonitor", 2, "isSubscribeFirst = " + f80347h);
                        }
                        HashMap<String, String> hashMap4 = new HashMap<>();
                        hashMap4.put(MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, String.valueOf(f80347h ? 1 : 0));
                        hashMap4.put("which", String.valueOf(3));
                        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actKandianTabOpenCost", true, f80343d, 0L, hashMap4, null);
                        f80347h = false;
                        return;
                    }
                    if (TextUtils.equals(str, "self_tab_cost")) {
                        if (QLog.isColorLevel()) {
                            QLog.i("PubAccAutoMonitor", 2, "isSelfFirst = " + f80348i);
                        }
                        HashMap<String, String> hashMap5 = new HashMap<>();
                        hashMap5.put(MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST, String.valueOf(f80348i ? 1 : 0));
                        hashMap5.put("which", String.valueOf(4));
                        StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "actKandianTabOpenCost", true, f80343d, 0L, hashMap5, null);
                        f80348i = false;
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        if (str2 != null) {
            if (TextUtils.equals(str2, "KANDIAN_NEW_FEEDS_CREATE")) {
                f80349j = 0L;
            } else if (TextUtils.equals(str2, "KANDIAN_NEW_FEEDS_LOAD_ARTICLE")) {
                f80350k = 0L;
            } else if (TextUtils.equals(str2, "KANDIAN_NEW_FEEDS_LIST_VIEW_GROUP_MEASURE_LAYOUT_DRAW")) {
                f80351l = 0L;
            } else if (TextUtils.equals(str2, "KANDIAN_FEEDS_STAGE_1_COST")) {
                f80341b = 0L;
            } else if (TextUtils.equals(str2, "KANDIAN_FEEDS_STAGE_2_COST")) {
                f80342c = 0L;
            } else {
                f80343d = 0L;
            }
            f80340a.put(str2, Long.valueOf(uptimeMillis));
        }
    }
}
