package com.tencent.luggage.wxa.o6;

import android.graphics.Bitmap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements b {

    /* renamed from: a, reason: collision with root package name */
    public final Class f136191a;

    /* renamed from: b, reason: collision with root package name */
    public final Bitmap.Config f136192b;

    public a(Class cls) {
        this(cls, null);
    }

    @Override // com.tencent.luggage.wxa.o6.b
    public Object make() {
        if (this.f136192b == null) {
            return this.f136191a.newInstance();
        }
        return this.f136191a.getConstructor(Bitmap.Config.class).newInstance(this.f136192b);
    }

    public a(Class cls, Bitmap.Config config) {
        this.f136191a = cls;
        this.f136192b = config;
    }
}
