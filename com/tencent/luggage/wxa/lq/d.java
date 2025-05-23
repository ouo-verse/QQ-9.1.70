package com.tencent.luggage.wxa.lq;

import com.tencent.luggage.wxa.lq.a;
import java.util.concurrent.Future;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d {
    public static Future a(Runnable runnable) {
        return a.C6453a.a().execute(runnable);
    }

    public static Future b(Runnable runnable) {
        return a.C6453a.a().a(runnable);
    }

    public static Future a(Runnable runnable, long j3) {
        return a.C6453a.a().a(runnable, j3);
    }
}
