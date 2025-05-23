package com.android.volley.toolbox;

import android.os.Looper;

/* compiled from: P */
/* loaded from: classes.dex */
final class l {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
        } else {
            throw new IllegalStateException("Must be invoked from the main thread.");
        }
    }
}
