package com.tencent.biz.pubaccount.weishi.util;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ao {

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap<String, String> f81708a;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f81709b;

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        f81708a = hashMap;
        f81709b = false;
        hashMap.put("1_1_1", "2020020023");
        hashMap.put("1_1_2", "2020020023");
        hashMap.put("1_1_3", "2020020024");
        hashMap.put("1_1_4", "2020020024");
        hashMap.put("1_1_5", "2020020057");
        hashMap.put("1_1_6", "2020020028");
        hashMap.put("1_1_7", "2020020116");
        hashMap.put("1_1_8", "2020020115");
        hashMap.put("1_1_13", "2020020427");
        hashMap.put("1_1_14", "2020020428");
        hashMap.put("1_1_101", "2020020026");
        hashMap.put("1_1_102", "2020020027");
        hashMap.put("1_1_103", "2020020160");
        hashMap.put("1_1_401", "2020020167");
        hashMap.put("1_2_1", "2020020082");
        hashMap.put("1_2_2", "2020020082");
        hashMap.put("1_2_3", "2020020083");
        hashMap.put("1_2_4", "2020020084");
        hashMap.put("1_2_5", "2020020085");
        hashMap.put("1_2_6", "2020020086");
        hashMap.put("1_2_7", "2020020118");
        hashMap.put("1_2_8", "2020020117");
        hashMap.put("1_2_100", "2020020032");
        hashMap.put("1_2_104", "2020020163");
        hashMap.put("1_2_13", "2020020427");
        hashMap.put("1_2_14", "2020020428");
        hashMap.put("1_2_101", "2020020026");
        hashMap.put("1_2_102", "2020020027");
        hashMap.put("1_2_103", "2020020160");
        hashMap.put("1_2_401", "2020020167");
        hashMap.put("1_3_1", "2020020072");
        hashMap.put("1_3_2", "2020020072");
        hashMap.put("1_3_3", "2020020073");
        hashMap.put("1_3_4", "2020020074");
        hashMap.put("1_3_5", "2020020075");
        hashMap.put("1_3_6", "2020020076");
        hashMap.put("1_3_7", "2020020120");
        hashMap.put("1_3_8", "2020020119");
        hashMap.put("1_3_13", "2020020427");
        hashMap.put("1_3_14", "2020020428");
        hashMap.put("1_4_1", "2020020077");
        hashMap.put("1_4_2", "2020020077");
        hashMap.put("1_4_3", "2020020078");
        hashMap.put("1_4_4", "2020020079");
        hashMap.put("1_4_5", "2020020080");
        hashMap.put("1_4_6", "2020020081");
        hashMap.put("1_4_7", "2020020122");
        hashMap.put("1_4_8", "2020020121");
        hashMap.put("1_4_13", "2020020427");
        hashMap.put("1_4_14", "2020020428");
        hashMap.put("1_4_300", "2020020071");
        hashMap.put("1_4_401", "2020020167");
        hashMap.put("1_5_1", "2020020031");
        hashMap.put("1_5_2", "2020020031");
        hashMap.put("1_5_3", "2020020032");
        hashMap.put("1_5_4", "2020020033");
        hashMap.put("1_5_5", "2020020034");
        hashMap.put("1_5_6", "2020020035");
        hashMap.put("1_5_7", "2020020053");
        hashMap.put("1_5_8", "2020020052");
        hashMap.put("1_5_301", "2020020030");
        hashMap.put("1_5_101", "2020020026");
        hashMap.put("1_5_102", "2020020027");
        hashMap.put("1_5_103", "2020020160");
        hashMap.put("1_6_1", "2020020037");
        hashMap.put("1_6_2", "2020020037");
        hashMap.put("1_6_3", "2020020038");
        hashMap.put("1_6_4", "2020020039");
        hashMap.put("1_6_5", "2020020040");
        hashMap.put("1_6_6", "2020020041");
        hashMap.put("1_6_7", "2020020055");
        hashMap.put("1_6_8", "2020020054");
        hashMap.put("1_6_302", "2020020036");
        hashMap.put("1_6_101", "2020020026");
        hashMap.put("1_6_102", "2020020027");
        hashMap.put("1_6_103", "2020020160");
        hashMap.put("2_0_1", "2020020059");
        hashMap.put("2_0_2", "2020020059");
        hashMap.put("2_0_3", "2020020060");
        hashMap.put("2_0_4", "2020020061");
        hashMap.put("2_0_5", "2020020062");
        hashMap.put("2_0_6", "2020020064");
        hashMap.put("2_0_7", "2020020114");
        hashMap.put("2_0_8", "2020020113");
        hashMap.put("3_0_200", "2020020029");
        hashMap.put("3_0_201", "20200200230");
    }

    public static String c(String str) {
        return str + "&idx=" + iz.a.g().f();
    }

    public static boolean d(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("weishi://");
    }

    public static void e(Context context, String str, String str2) {
        String c16 = c(str2);
        x.f("WeishiScehmeUtil", "openWeishi: scheme = " + c16);
        f81709b = true;
        com.tencent.biz.qqstory.utils.l.d(context, str, c16);
    }

    public static void f(Context context, String str, String str2, int i3, int i16, int i17) {
        if (context != null && !TextUtils.isEmpty(str2)) {
            if (!str2.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                str2 = str2 + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
            }
            if (!str2.contains("&logsour=")) {
                str2 = str2 + "&logsour=" + b(i3, i16, i17);
            }
            x.l("WeishiScehmeUtil", "openWeishi final scheme = " + str2);
            e(context, str, str2);
            return;
        }
        x.f("WeishiScehmeUtil", "openWeishi context = " + context + "scheme = " + str2);
    }

    public static String a(stSimpleMetaFeed stsimplemetafeed) {
        if (stsimplemetafeed != null && !TextUtils.isEmpty(stsimplemetafeed.f25129id)) {
            return "weishi://feed?feed_id=" + stsimplemetafeed.f25129id;
        }
        return "weishi://main";
    }

    private static String b(int i3, int i16, int i17) {
        if (i3 <= 0) {
            i3 = 0;
        }
        if (i16 <= 0) {
            i16 = 0;
        }
        if (i17 <= 0) {
            i17 = 0;
        }
        String str = f81708a.get(i3 + "_" + i16 + "_" + i17);
        return !TextUtils.isEmpty(str) ? str : "2020020063";
    }
}
