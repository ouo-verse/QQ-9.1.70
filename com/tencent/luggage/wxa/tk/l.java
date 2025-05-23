package com.tencent.luggage.wxa.tk;

import android.os.Looper;
import com.tencent.luggage.wxa.tn.b0;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f141501a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static volatile a f141502b;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends b0 {
        public a(String str) {
            super(str);
        }

        @Override // com.tencent.luggage.wxa.tn.b0, com.tencent.luggage.wxa.dq.a
        public Looper a() {
            throw new UnsupportedOperationException();
        }

        public final boolean b(Runnable runnable, long j3) {
            return super.a(runnable, j3);
        }
    }

    public static a a() {
        if (f141502b == null) {
            synchronized (l.class) {
                if (f141502b == null) {
                    f141502b = new a("Luggage.Common.ThreadUtil.WORKER_THREAD");
                }
            }
        }
        return f141502b;
    }

    public static void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            com.tencent.luggage.wxa.zp.h.f146825d.a(runnable);
        }
    }
}
