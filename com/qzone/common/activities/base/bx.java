package com.qzone.common.activities.base;

import cooperation.qzone.QZoneHelper;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes39.dex */
public class bx {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f45468a = {"com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity", QZoneHelper.QZONE_TRANSLUCENT_ACTIVITY, QZoneHelper.QZONE_TRANSLUCENT_ACTIVITY2};

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f45469b = {QZoneHelper.PAGE_DIALOG};

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f45470c = {QZoneHelper.PAGE_ENCOURAGE_ADV};

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f45471d = new String[0];

    /* renamed from: e, reason: collision with root package name */
    private static final String[] f45472e = new String[0];

    /* renamed from: f, reason: collision with root package name */
    private static Map<Integer, List<String>> f45473f;

    public static int a(String str) {
        if (f45473f == null) {
            f45473f = b();
        }
        for (Map.Entry<Integer, List<String>> entry : f45473f.entrySet()) {
            if (entry.getValue().contains(str)) {
                return entry.getKey().intValue();
            }
        }
        return 0;
    }

    private static Map<Integer, List<String>> b() {
        HashMap hashMap = new HashMap();
        hashMap.put(1, Arrays.asList(f45468a));
        hashMap.put(2, Arrays.asList(f45470c));
        hashMap.put(3, Arrays.asList(f45469b));
        hashMap.put(4, Arrays.asList(f45472e));
        hashMap.put(5, Arrays.asList(f45471d));
        return hashMap;
    }

    public static boolean c(String str) {
        int a16 = a(str);
        return a16 == 1 || a16 == 3 || a16 == 4;
    }
}
