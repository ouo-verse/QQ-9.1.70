package com.tencent.luggage.wxa.n0;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a {
    public static void a(boolean z16) {
        if (!z16) {
            throw new IllegalArgumentException();
        }
    }

    public static void b(boolean z16) {
        if (!z16) {
            throw new IllegalStateException();
        }
    }

    public static void a(boolean z16, Object obj) {
        if (!z16) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void b(boolean z16, Object obj) {
        if (!z16) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static int a(int i3, int i16, int i17) {
        if (i3 < i16 || i3 >= i17) {
            throw new IndexOutOfBoundsException();
        }
        return i3;
    }

    public static Object a(Object obj) {
        obj.getClass();
        return obj;
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        return str;
    }
}
