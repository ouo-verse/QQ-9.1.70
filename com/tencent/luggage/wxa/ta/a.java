package com.tencent.luggage.wxa.ta;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static boolean a(Class cls, Class cls2) {
        if (cls != null && cls2 != null) {
            if (cls.isAnnotationPresent(cls2)) {
                return true;
            }
            for (Class<?> cls3 : cls.getInterfaces()) {
                if (cls3.isAnnotationPresent(cls2)) {
                    return true;
                }
            }
            if (cls.getSuperclass() != null) {
                return a(cls.getSuperclass(), cls2);
            }
        }
        return false;
    }
}
