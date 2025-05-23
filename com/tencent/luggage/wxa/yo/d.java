package com.tencent.luggage.wxa.yo;

import android.os.Looper;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public static final g f146044a = new g(Looper.getMainLooper(), "Vending.UI");

    /* renamed from: b, reason: collision with root package name */
    public static final g f146045b = new g(com.tencent.luggage.wxa.zo.b.a().b(), "Vending.LOGIC");

    /* renamed from: c, reason: collision with root package name */
    public static final g f146046c = new g(com.tencent.luggage.wxa.zo.a.a().b(), "Vending.HEAVY_WORK");

    static {
        f.b();
    }

    public abstract void a();

    public abstract void a(Runnable runnable);

    public abstract void a(Runnable runnable, long j3);
}
