package com.tencent.luggage.wxa.eq;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d {

    /* renamed from: b, reason: collision with root package name */
    public static final d f125061b = new d();

    /* renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f125062c = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final Looper f125063a;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        public final String f125064a;

        public a(String str, Looper looper, Handler.Callback callback) {
            super(looper, callback);
            this.f125064a = str;
        }

        @Override // android.os.Handler
        public String toString() {
            return this.f125064a;
        }
    }

    public d() {
        HandlerThread b16 = com.tencent.luggage.wxa.cq.c.b("TP#Internal");
        b16.setPriority(8);
        b16.start();
        this.f125063a = b16.getLooper();
    }

    public static Handler a(String str, Handler.Callback callback) {
        d dVar = f125061b;
        a aVar = new a(str, dVar.f125063a, callback);
        f125062c.put(dVar.f125063a, new WeakReference(aVar));
        return aVar;
    }
}
