package com.tencent.local_edit.andserver.util;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class a {
    public static void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
        } else {
            throw new IllegalArgumentException(str2);
        }
    }

    public static void b(boolean z16, String str) {
        if (z16) {
        } else {
            throw new IllegalArgumentException(str);
        }
    }

    public static void c(Object obj, String str) {
        if (obj != null) {
        } else {
            throw new IllegalArgumentException(str);
        }
    }

    public static void d(boolean z16, String str) {
        if (z16) {
        } else {
            throw new IllegalStateException(str);
        }
    }
}
