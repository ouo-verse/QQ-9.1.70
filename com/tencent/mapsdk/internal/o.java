package com.tencent.mapsdk.internal;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    private static HashMap<String, String> f149476a = new HashMap<>();

    o() {
    }

    public static <T extends p> void a(Class<T> cls) {
        try {
            T newInstance = cls.newInstance();
            if (newInstance != null) {
                String className = newInstance.className();
                if ("".equals(className)) {
                    className = cls.getName();
                }
                f149476a.put(className, cls.getName());
            }
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
        } catch (InstantiationException e17) {
            e17.printStackTrace();
        }
    }

    public static String a(String str) {
        return f149476a.get(str);
    }
}
