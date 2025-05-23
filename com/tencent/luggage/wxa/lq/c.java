package com.tencent.luggage.wxa.lq;

import java.util.concurrent.FutureTask;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {
    public static final FutureTask a(Runnable runnable) {
        return new FutureTask(runnable, null);
    }
}
