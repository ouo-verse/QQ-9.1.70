package com.vivo.push.util;

import android.os.Looper;
import android.util.Log;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class k {
    public static void a(String str) {
        if (u.b() && Looper.myLooper() == Looper.getMainLooper()) {
            Log.w("DebugUtil", "Operation: " + str + " in main thread!", new Throwable());
        }
    }
}
