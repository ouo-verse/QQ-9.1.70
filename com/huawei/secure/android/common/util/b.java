package com.huawei.secure.android.common.util;

import android.os.Looper;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b {
    public static boolean a() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }
}
