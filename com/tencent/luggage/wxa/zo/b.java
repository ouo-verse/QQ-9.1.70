package com.tencent.luggage.wxa.zo;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static b f146774c = new b();

    /* renamed from: a, reason: collision with root package name */
    public HandlerThread f146775a;

    /* renamed from: b, reason: collision with root package name */
    public Handler f146776b;

    public b() {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("Vending-LogicThread");
        this.f146775a = baseHandlerThread;
        baseHandlerThread.start();
        this.f146776b = new Handler(this.f146775a.getLooper());
    }

    public static b a() {
        return f146774c;
    }

    public Looper b() {
        return this.f146775a.getLooper();
    }
}
