package com.tencent.mobileqq.config.business;

import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes10.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private static ConcurrentHashMap<Integer, String> f202697a;

    public static void a(int i3, String str) {
        if (f202697a == null) {
            f202697a = new ConcurrentHashMap<>();
        }
        f202697a.put(Integer.valueOf(i3), str);
    }

    public static String b(int i3) {
        if (i3 != 4) {
            if (i3 != 15) {
                if (i3 != 17) {
                    if (i3 != 7) {
                        if (i3 != 8) {
                            if (i3 != 11) {
                                if (i3 != 12) {
                                    ConcurrentHashMap<Integer, String> concurrentHashMap = f202697a;
                                    if (concurrentHashMap != null) {
                                        return concurrentHashMap.get(Integer.valueOf(i3));
                                    }
                                    return null;
                                }
                                return "hotpic";
                            }
                            return "camera";
                        }
                        return "recommend";
                    }
                    return "sysface";
                }
                return "zplan";
            }
            return "cmshow";
        }
        return "favorite";
    }
}
