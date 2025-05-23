package com.xiaomi.push;

import android.os.Looper;

/* compiled from: P */
/* loaded from: classes28.dex */
public class i {
    public static void a() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
        } else {
            throw new RuntimeException("can't do this on ui thread");
        }
    }
}
