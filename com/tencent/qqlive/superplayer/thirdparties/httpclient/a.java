package com.tencent.qqlive.superplayer.thirdparties.httpclient;

import android.text.TextUtils;
import androidx.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class a {
    public static void b(boolean z16) {
        if (z16) {
        } else {
            throw new IllegalArgumentException();
        }
    }

    public static String c(@Nullable String str) {
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException();
    }

    public static <T> T d(@Nullable T t16) {
        t16.getClass();
        return t16;
    }

    public static void e(boolean z16) {
        if (z16) {
        } else {
            throw new IllegalStateException();
        }
    }

    public static <T> T a(@Nullable T t16) {
        return t16;
    }
}
