package com.vivo.push.f;

import com.vivo.push.cache.ClientConfigManagerImpl;

/* compiled from: P */
/* loaded from: classes13.dex */
final class c extends com.vivo.push.s {
    /* JADX INFO: Access modifiers changed from: package-private */
    public c(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        com.vivo.push.util.u.a(ClientConfigManagerImpl.getInstance(this.f387838a).isDebug());
    }
}
