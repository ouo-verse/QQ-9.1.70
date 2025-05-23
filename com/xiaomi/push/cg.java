package com.xiaomi.push;

/* compiled from: P */
/* loaded from: classes28.dex */
public class cg implements jz4.a {

    /* renamed from: a, reason: collision with root package name */
    private jz4.a f388408a;

    /* renamed from: b, reason: collision with root package name */
    private jz4.a f388409b;

    public cg(jz4.a aVar, jz4.a aVar2) {
        this.f388408a = aVar;
        this.f388409b = aVar2;
    }

    @Override // jz4.a
    public void log(String str) {
        jz4.a aVar = this.f388408a;
        if (aVar != null) {
            aVar.log(str);
        }
        jz4.a aVar2 = this.f388409b;
        if (aVar2 != null) {
            aVar2.log(str);
        }
    }

    @Override // jz4.a
    public void log(String str, Throwable th5) {
        jz4.a aVar = this.f388408a;
        if (aVar != null) {
            aVar.log(str, th5);
        }
        jz4.a aVar2 = this.f388409b;
        if (aVar2 != null) {
            aVar2.log(str, th5);
        }
    }
}
