package com.tencent.bugly.proguard;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class ce extends m implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public String f98385a = "";

    /* renamed from: b, reason: collision with root package name */
    public String f98386b = "";

    /* renamed from: c, reason: collision with root package name */
    public String f98387c = "";

    /* renamed from: d, reason: collision with root package name */
    public String f98388d = "";

    /* renamed from: e, reason: collision with root package name */
    public String f98389e = "";

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb5, int i3) {
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f98385a, 0);
        String str = this.f98386b;
        if (str != null) {
            lVar.a(str, 1);
        }
        String str2 = this.f98387c;
        if (str2 != null) {
            lVar.a(str2, 2);
        }
        String str3 = this.f98388d;
        if (str3 != null) {
            lVar.a(str3, 3);
        }
        String str4 = this.f98389e;
        if (str4 != null) {
            lVar.a(str4, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f98385a = kVar.b(0, true);
        this.f98386b = kVar.b(1, false);
        this.f98387c = kVar.b(2, false);
        this.f98388d = kVar.b(3, false);
        this.f98389e = kVar.b(4, false);
    }
}
