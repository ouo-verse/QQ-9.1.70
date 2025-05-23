package com.vivo.push.f;

import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.model.UnvarnishedMessage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes13.dex */
public final class t extends aa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public t(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.o oVar = (com.vivo.push.b.o) vVar;
        com.vivo.push.m.a().a(new com.vivo.push.b.h(String.valueOf(oVar.f())));
        if (!ClientConfigManagerImpl.getInstance(this.f387838a).isEnablePush()) {
            com.vivo.push.util.u.d("OnMessageTask", "command  " + vVar + " is ignore by disable push ");
            super.a(1020);
            return;
        }
        if (com.vivo.push.m.a().g() && !a(com.vivo.push.util.ag.c(this.f387838a), oVar.d(), oVar.g())) {
            super.a(1021);
            return;
        }
        UnvarnishedMessage e16 = oVar.e();
        if (e16 != null) {
            com.vivo.push.util.u.d("OnMessageTask", "tragetType is " + e16.getTargetType() + " ; messageId is " + e16.getMsgId());
            ((aa) this).f387661b.onTransmissionMessage(this.f387838a, e16);
            super.a(0);
            return;
        }
        super.a(2807);
        com.vivo.push.util.u.a("OnMessageTask", " message is null");
    }
}
