package com.tencent.luggage.wxa.zo;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static a f146771c = new a();

    /* renamed from: a, reason: collision with root package name */
    public HandlerThread f146772a;

    /* renamed from: b, reason: collision with root package name */
    public Handler f146773b;

    public a() {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("Vending-HeavyWorkThread", 10);
        this.f146772a = baseHandlerThread;
        baseHandlerThread.start();
        this.f146773b = new Handler(this.f146772a.getLooper());
    }

    public static a a() {
        return f146771c;
    }

    public Looper b() {
        return this.f146772a.getLooper();
    }
}
