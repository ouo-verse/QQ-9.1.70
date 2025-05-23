package com.vivo.push.restructure.a.a;

import com.vivo.push.util.u;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class j implements i<com.vivo.push.restructure.a.a> {

    /* renamed from: a, reason: collision with root package name */
    private a f387787a;

    /* renamed from: b, reason: collision with root package name */
    private n f387788b;

    /* renamed from: c, reason: collision with root package name */
    private k f387789c;

    /* renamed from: d, reason: collision with root package name */
    private com.vivo.push.restructure.c.a f387790d;

    public j(n nVar, k kVar, com.vivo.push.restructure.c.a aVar) {
        this.f387788b = nVar;
        this.f387789c = kVar;
        this.f387790d = aVar;
    }

    @Override // com.vivo.push.restructure.a.a.i
    public final /* synthetic */ void a(a aVar, com.vivo.push.restructure.a.a aVar2, int i3) {
        com.vivo.push.restructure.a.a aVar3 = aVar2;
        if (aVar3 == null) {
            u.a("onNodeError() receivedMsg is null ");
            return;
        }
        u.a("onNodeError() , msgID = " + aVar3.a() + ", nodeName = " + aVar.b());
        com.vivo.push.restructure.c.a aVar4 = this.f387790d;
        if (aVar4 != null) {
            aVar4.a(i3, aVar3.a());
        }
        a2(aVar3);
    }

    @Override // com.vivo.push.restructure.a.a.i
    public final /* bridge */ /* synthetic */ void a(com.vivo.push.restructure.a.a aVar) {
        com.vivo.push.restructure.a.a aVar2 = aVar;
        if (aVar2 == null) {
            u.a("onAllNodeExecuteComplete, receivedMsg is null");
        } else if (this.f387787a == null) {
            u.a("onAllNodeExecuteComplete, mFirstNode is null");
        } else {
            a2(aVar2);
        }
    }

    @Override // com.vivo.push.restructure.a.a.i
    public final void a(a aVar) {
        this.f387787a = aVar;
    }

    /* renamed from: a, reason: avoid collision after fix types in other method */
    private void a2(com.vivo.push.restructure.a.a aVar) {
        if (aVar == null) {
            return;
        }
        if (!aVar.e()) {
            u.a("core is not support monitor report");
            return;
        }
        u.a("reportNodeMonitorInfo() , isNeedCollectNodeMonitor: " + aVar.f());
        if (aVar.f()) {
            n nVar = this.f387788b;
            if (nVar != null) {
                nVar.a(aVar, this.f387787a);
            }
            k kVar = this.f387789c;
            if (kVar != null) {
                kVar.a(aVar, this.f387787a.c().toString());
                u.a("reportNodeMonitorInfo() , report client NodeInfo\uff01\uff01\uff01");
            } else {
                u.a("onNodeError , mReporter is null\uff0c can not report");
            }
        }
    }
}
