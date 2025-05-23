package com.tencent.luggage.wxa.de;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c implements e {

    /* renamed from: b, reason: collision with root package name */
    public static final c f124198b = new c();

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f124199a;

    public c() {
        e eVar = (e) com.tencent.luggage.wxa.h1.e.a(e.class);
        this.f124199a = eVar == null ? d.f124200a : eVar;
    }

    @Override // com.tencent.luggage.wxa.de.e
    public a a(b scene, f fVar) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        return this.f124199a.a(scene, fVar);
    }

    @Override // com.tencent.luggage.wxa.de.e
    public void a(b scene, boolean z16, String token) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        Intrinsics.checkNotNullParameter(token, "token");
        this.f124199a.a(scene, z16, token);
    }
}
