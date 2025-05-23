package com.tencent.luggage.wxa.u9;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static Object[] f142158a = new Object[0];

    /* renamed from: b, reason: collision with root package name */
    public static Object[] f142159b = new Object[73];

    public static boolean a(Object[] objArr, Object obj) {
        for (Object obj2 : objArr) {
            if (obj2 == null) {
                if (obj == null) {
                    return true;
                }
            } else if (obj != null && obj2.equals(obj)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(int[] iArr, int i3) {
        for (int i16 : iArr) {
            if (i16 == i3) {
                return true;
            }
        }
        return false;
    }
}
