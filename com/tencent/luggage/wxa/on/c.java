package com.tencent.luggage.wxa.on;

import android.os.Looper;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {

    /* renamed from: b, reason: collision with root package name */
    public boolean f137056b;

    /* renamed from: a, reason: collision with root package name */
    public Runnable f137055a = null;

    /* renamed from: c, reason: collision with root package name */
    public int f137057c = 0;

    public int a() {
        if (this.f137057c == 0) {
            this.f137057c = getClass().getName().hashCode();
        }
        return this.f137057c;
    }

    public boolean b() {
        return this.f137056b;
    }

    public final boolean c() {
        return a.f137044d.a(this);
    }

    public final void a(Looper looper) {
        a.f137044d.a(this, looper);
    }
}
