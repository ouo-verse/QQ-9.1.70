package com.tencent.rmonitor.base.config;

import android.support.annotation.RestrictTo;

/* compiled from: P */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes25.dex */
public class c implements b {
    @Override // com.tencent.rmonitor.base.config.b
    public void a(g gVar) {
        ConfigProxy.INSTANCE.getConfig().e(gVar);
    }

    @Override // com.tencent.rmonitor.base.config.b
    public void b() {
        ConfigProxy.INSTANCE.getConfig().s();
    }

    @Override // com.tencent.rmonitor.base.config.b
    public void c(g gVar) {
        ConfigProxy.INSTANCE.getConfig().t(gVar);
    }

    @Override // com.tencent.rmonitor.base.config.b
    public void setDebugMode(boolean z16) {
        ConfigProxy.INSTANCE.getConfig().u(z16);
    }
}
