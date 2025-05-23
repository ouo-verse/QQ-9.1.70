package com.tencent.bugly.proguard;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class cl extends m implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public String f98461a = "";

    /* renamed from: b, reason: collision with root package name */
    public String f98462b = "";

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb5, int i3) {
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f98461a, 0);
        lVar.a(this.f98462b, 1);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f98461a = kVar.b(0, true);
        this.f98462b = kVar.b(1, true);
    }
}
