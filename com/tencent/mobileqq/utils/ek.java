package com.tencent.mobileqq.utils;

import android.annotation.SuppressLint;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ek {

    /* renamed from: b, reason: collision with root package name */
    private static long f307724b;

    /* renamed from: d, reason: collision with root package name */
    private static int f307726d;

    /* renamed from: a, reason: collision with root package name */
    @SuppressLint({"SimpleDateFormat"})
    private static final SimpleDateFormat f307723a = new SimpleDateFormat("yy-MM-dd HH:mm");

    /* renamed from: c, reason: collision with root package name */
    private static final HashMap<String, Integer> f307725c = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements Comparator<Map.Entry<String, Integer>> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
            return entry2.getValue().compareTo(entry.getValue());
        }
    }

    private static Map.Entry<String, Integer> a() {
        HashMap<String, Integer> hashMap = f307725c;
        if (hashMap.size() == 0) {
            return null;
        }
        int i3 = (f307726d / 100) * 3;
        HashMap hashMap2 = new HashMap();
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue().intValue() >= i3) {
                hashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        if (hashMap2.size() == 0) {
            return null;
        }
        PriorityQueue priorityQueue = new PriorityQueue(2048, new a());
        priorityQueue.addAll(hashMap2.entrySet());
        return (Map.Entry) priorityQueue.peek();
    }

    private static void b(Map.Entry<String, Integer> entry, int i3) {
        if (entry == null) {
            return;
        }
        String key = entry.getKey();
        int intValue = entry.getValue().intValue();
        int i16 = (intValue * 100) / i3;
        if (QLog.isColorLevel()) {
            QLog.d("TagRatioReportUtil", 2, "TAG=", key, ", count=", Integer.valueOf(intValue), ", ratio=", Integer.valueOf(i16));
        }
        if (!c(i16, intValue)) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("time", f307723a.format(Long.valueOf(System.currentTimeMillis())));
        hashMap.put("processName", BaseApplication.processName);
        hashMap.put("tag", key);
        hashMap.put("count", String.valueOf(intValue));
        hashMap.put("ratio", String.valueOf(i16));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "LogTagRatioAbnormalReport", true, 0L, 0L, hashMap, null);
    }

    private static boolean c(int i3, int i16) {
        if (i3 > 20 && i16 > 20000) {
            return true;
        }
        return false;
    }

    public static void d(String str) {
        int intValue;
        if (f307724b == 0) {
            f307724b = System.currentTimeMillis();
        }
        HashMap<String, Integer> hashMap = f307725c;
        Integer num = hashMap.get(str);
        if (num == null) {
            intValue = 1;
        } else {
            intValue = num.intValue() + 1;
        }
        hashMap.put(str, Integer.valueOf(intValue));
        f307726d++;
        if (System.currentTimeMillis() - f307724b < 360000) {
            return;
        }
        b(a(), f307726d);
        hashMap.clear();
        f307726d = 0;
        f307724b = System.currentTimeMillis();
    }
}
