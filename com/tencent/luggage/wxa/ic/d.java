package com.tencent.luggage.wxa.ic;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.LifecycleOwner;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d extends com.tencent.luggage.wxa.xd.j {
    public com.tencent.luggage.wxa.mc.m C() {
        g runtime = getRuntime();
        if (runtime == null) {
            return null;
        }
        return com.tencent.luggage.wxa.mc.k0.b(runtime);
    }

    public abstract com.tencent.luggage.wxa.wj.c D();

    @Override // com.tencent.luggage.wxa.xd.e, com.tencent.luggage.wxa.xd.d
    public boolean a(com.tencent.luggage.wxa.xd.m mVar) {
        if (isRunning() && getRuntime().a(mVar)) {
            return true;
        }
        return super.a(mVar);
    }

    @Override // com.tencent.luggage.wxa.xd.e, com.tencent.luggage.wxa.xd.d
    public final com.tencent.luggage.wxa.h1.b b(Class cls) {
        com.tencent.luggage.wxa.h1.b bVar;
        if (com.tencent.luggage.wxa.rc.q.class == cls) {
            return super.b(cls);
        }
        g runtime = getRuntime();
        if (runtime != null && (bVar = (com.tencent.luggage.wxa.h1.b) runtime.f(cls)) != null) {
            return bVar;
        }
        return super.b(cls);
    }

    @Override // com.tencent.luggage.wxa.xd.e, com.tencent.luggage.wxa.xd.d
    public com.tencent.luggage.wxa.xd.m c(Class cls) {
        com.tencent.luggage.wxa.xd.m c16;
        if (isRunning() && (c16 = getRuntime().c(cls)) != null) {
            return c16;
        }
        return super.c(cls);
    }

    @Override // com.tencent.luggage.wxa.xd.e
    public com.tencent.luggage.wxa.xd.l d(Class cls) {
        g runtime = getRuntime();
        if (runtime != null) {
            return runtime.a(cls, false);
        }
        return super.d(cls);
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public String getAppId() {
        g runtime = getRuntime();
        if (runtime == null) {
            return null;
        }
        return runtime.getAppId();
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public com.tencent.luggage.wxa.qc.b getAppState() {
        if (!isRunning()) {
            return com.tencent.luggage.wxa.qc.b.DESTROYED;
        }
        return getRuntime().c0().b();
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public final Context getContext() {
        if (getRuntime() == null) {
            return com.tencent.luggage.wxa.tn.z.c();
        }
        Activity L = getRuntime().L();
        if (L != null) {
            return L;
        }
        Context context = getRuntime().f129749a;
        if (context != null) {
            return context;
        }
        return com.tencent.luggage.wxa.tn.z.c();
    }

    @Override // com.tencent.luggage.wxa.xd.e, com.tencent.luggage.wxa.xd.d
    public com.tencent.luggage.wxa.ml.r getDialogContainer() {
        if (!isRunning()) {
            return super.getDialogContainer();
        }
        return getRuntime().N();
    }

    @Override // com.tencent.luggage.wxa.xd.e, com.tencent.luggage.wxa.xd.d
    public com.tencent.luggage.wxa.rc.r getFileSystem() {
        if (!isRunning()) {
            return super.getFileSystem();
        }
        return getRuntime().P();
    }

    @Override // com.tencent.luggage.wxa.xd.e, com.tencent.luggage.wxa.xd.d
    public LifecycleOwner getLifecycleOwner() {
        g runtime = getRuntime();
        if (runtime == null) {
            return null;
        }
        return runtime.T();
    }

    @Override // com.tencent.luggage.wxa.xd.i
    public final com.tencent.luggage.wxa.rc.q i() {
        return (com.tencent.luggage.wxa.rc.q) b(com.tencent.luggage.wxa.rc.q.class);
    }

    @Override // com.tencent.luggage.wxa.xd.d
    public boolean isRunning() {
        g runtime = getRuntime();
        if (runtime != null && !runtime.t0()) {
            return true;
        }
        return false;
    }

    public final void a(com.tencent.luggage.wxa.rc.q qVar) {
        qVar.getClass();
        super.a(com.tencent.luggage.wxa.rc.q.class, qVar);
    }
}
