package com.qq.e.comm.plugin.tangramsplash.interactive.a;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private d f40155a;

    public c(d dVar) {
        this.f40155a = dVar;
    }

    public boolean a() {
        d dVar = this.f40155a;
        if (dVar == null) {
            return false;
        }
        dVar.y();
        return true;
    }

    public void b() {
        d dVar = this.f40155a;
        if (dVar != null) {
            dVar.a("{\"type\": \"all\"}");
        }
    }
}
