package com.tencent.luggage.wxa.tg;

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
        if (z16) {
        } else {
            throw new IllegalStateException();
        }
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
