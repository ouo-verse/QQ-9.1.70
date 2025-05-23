package com.tencent.luggage.wxa.vk;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes8.dex */
public enum a implements e {
    INST;


    /* renamed from: d, reason: collision with root package name */
    public static final c f143631d = new c();

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f143634b = new AtomicBoolean(false);

    /* renamed from: a, reason: collision with root package name */
    public final e f143633a = new b();

    a() {
    }

    @Override // com.tencent.luggage.wxa.vk.e
    public c a() {
        return this.f143633a.a();
    }

    @Override // com.tencent.luggage.wxa.vk.e
    public void init(Context context) {
        if (!this.f143634b.getAndSet(true)) {
            this.f143633a.init(context);
        }
    }
}
