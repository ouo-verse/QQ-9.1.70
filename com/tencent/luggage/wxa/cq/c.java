package com.tencent.luggage.wxa.cq;

import android.os.HandlerThread;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c extends a {
    public static Thread a(String str, Runnable runnable, int i3) {
        Thread a16 = a.a(str, runnable);
        a16.setPriority(i3);
        return a16;
    }

    public static HandlerThread b(String str) {
        return a.a(str);
    }
}
