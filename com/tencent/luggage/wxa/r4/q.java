package com.tencent.luggage.wxa.r4;

import android.text.TextUtils;
import com.tencent.luggage.wxa.hn.mc;
import com.tencent.luggage.wxa.xd.i1;
import com.tencent.mm.plugin.appbrand.debugger.RemoteDebugJsEngine;
import com.tencent.qqmini.miniapp.util.DebugUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public class q extends f implements com.tencent.luggage.wxa.id.c {

    /* renamed from: i, reason: collision with root package name */
    public com.tencent.luggage.wxa.id.e f139234i;

    /* renamed from: j, reason: collision with root package name */
    public RemoteDebugJsEngine f139235j;

    public q(d dVar) {
        super(dVar);
        super.a(com.tencent.luggage.wxa.id.c.class, this);
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public final boolean G() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public boolean J() {
        return true;
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public boolean L() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public void P() {
        w();
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public void S() {
        super.S();
        this.f139235j.J();
    }

    @Override // com.tencent.luggage.wxa.id.c
    public void a(String str) {
        com.tencent.luggage.wxa.tn.w.a("Luggage.MPRemoteDebugServiceLogic", "RemoteDebugInfo %s", str);
        mc mcVar = new mc();
        mcVar.f128203e = ((d) t()).J().getComponentId();
        mcVar.f128202d = str;
        this.f139235j.a(com.tencent.luggage.wxa.id.l.a(mcVar, this.f139234i, DebugUtils.Command.DOM_EVENT));
    }

    @Override // com.tencent.luggage.wxa.xi.e
    public boolean b(String str) {
        return false;
    }

    @Override // com.tencent.luggage.wxa.id.c
    public String f() {
        return String.format("var __wxConfig = %s;\nvar __wxIndexPage = \"%s\"", ((d) t()).I().toString(), ((d) t()).getRuntime().E().S);
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public com.tencent.luggage.wxa.ei.j v() {
        RemoteDebugJsEngine remoteDebugJsEngine = new RemoteDebugJsEngine();
        this.f139235j = remoteDebugJsEngine;
        return remoteDebugJsEngine;
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public void b(com.tencent.luggage.wxa.ic.g gVar) {
        super.b(gVar);
        ((d) t()).r();
        com.tencent.luggage.wxa.id.e eVar = com.tencent.luggage.wxa.id.l.f130086a;
        if (eVar != null) {
            this.f139234i = eVar;
            com.tencent.luggage.wxa.id.l.f130086a = null;
        } else {
            this.f139234i = new com.tencent.luggage.wxa.id.e();
        }
        this.f139234i.a((d) t(), ((d) t()).getRuntime().S().P);
        this.f139234i.b(((d) t()).getRuntime().S().R);
        this.f139235j.a(this.f139234i);
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public boolean a(String str, String str2, int i3, int i16) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "{}";
        }
        com.tencent.luggage.wxa.tn.w.a("Luggage.MPRemoteDebugServiceLogic", "dispatch, event: %s, data size: %s, srcId: %d", str, Integer.valueOf(str2.length()), Integer.valueOf(i3));
        this.f139235j.a(str);
        i1.a(this.f139235j, str, str2, i3);
        return true;
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public boolean b(int i3, String str) {
        if (TextUtils.isEmpty(str)) {
            str = "{}";
        }
        this.f139235j.a(i3, str);
        return true;
    }

    @Override // com.tencent.luggage.wxa.r4.f
    public void Q() {
    }
}
