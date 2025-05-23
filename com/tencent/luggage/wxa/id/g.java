package com.tencent.luggage.wxa.id;

import com.tencent.mm.plugin.appbrand.debugger.RemoteDebugJsEngine;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    public static volatile g f130060b;

    /* renamed from: a, reason: collision with root package name */
    public RemoteDebugJsEngine f130061a;

    public static g b() {
        if (f130060b == null) {
            synchronized (g.class) {
                if (f130060b == null) {
                    f130060b = new g();
                }
            }
        }
        return f130060b;
    }

    public RemoteDebugJsEngine a(com.tencent.luggage.wxa.r4.d dVar) {
        if (dVar == null || dVar.getRuntime() == null) {
            return null;
        }
        if (dVar.getRuntime().H) {
            RemoteDebugJsEngine remoteDebugJsEngine = this.f130061a;
            if (remoteDebugJsEngine != null && remoteDebugJsEngine.D() != null) {
                this.f130061a.D().a(dVar, dVar.getRuntime().S().P);
                this.f130061a.D().b(dVar.getRuntime().S().R);
                RemoteDebugJsEngine remoteDebugJsEngine2 = this.f130061a;
                remoteDebugJsEngine2.a(remoteDebugJsEngine2.D(), true, true);
                dVar.getRuntime().H = false;
                return this.f130061a;
            }
            dVar.getRuntime().H = false;
        }
        this.f130061a = new RemoteDebugJsEngine();
        e eVar = new e();
        eVar.a(dVar, dVar.getRuntime().S().P);
        eVar.b(dVar.getRuntime().S().R);
        this.f130061a.a(eVar, false, true);
        return this.f130061a;
    }

    public void a() {
        if (this.f130061a != null) {
            this.f130061a = null;
        }
    }
}
