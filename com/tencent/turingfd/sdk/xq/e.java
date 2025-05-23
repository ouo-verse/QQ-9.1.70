package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.turingfd.sdk.xq.ComaBerenices;
import com.tencent.turingfd.sdk.xq.Hydra;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes27.dex */
public class e extends BaseThread {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ byte[] f383323a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f383324b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f383325c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f383326d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ f f383327e;

    public e(f fVar, byte[] bArr, AtomicBoolean atomicBoolean, AtomicReference atomicReference, Object obj) {
        this.f383327e = fVar;
        this.f383323a = bArr;
        this.f383324b = atomicBoolean;
        this.f383325c = atomicReference;
        this.f383326d = obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, fVar, bArr, atomicBoolean, atomicReference, obj);
        }
    }

    @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
    public void run() {
        Hydra.Cdo cdo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            cdo = ((ComaBerenices.Cdo) this.f383327e.f383334a.f383079a).a(this.f383323a);
        } catch (Throwable unused) {
            cdo = new Hydra.Cdo(-100, null);
        }
        if (this.f383324b.get()) {
            return;
        }
        this.f383325c.set(cdo);
        synchronized (this.f383326d) {
            this.f383326d.notify();
        }
    }
}
