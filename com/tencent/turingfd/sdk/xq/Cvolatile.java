package com.tencent.turingfd.sdk.xq;

import android.net.Network;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.turingfd.sdk.xq.Aquila;
import com.tencent.turingfd.sdk.xq.CanisMinor;
import java.util.concurrent.Callable;

/* compiled from: P */
/* renamed from: com.tencent.turingfd.sdk.xq.volatile, reason: invalid class name */
/* loaded from: classes27.dex */
public class Cvolatile implements Callable<Object> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Network f383454a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CanisMinor.Cdo f383455b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Aquila.Cdo f383456c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Cinterface f383457d;

    public Cvolatile(Cinterface cinterface, Network network, CanisMinor.Cdo cdo, Aquila.Cdo cdo2) {
        this.f383457d = cinterface;
        this.f383454a = network;
        this.f383455b = cdo;
        this.f383456c = cdo2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, cinterface, network, cdo, cdo2);
        }
    }

    @Override // java.util.concurrent.Callable
    public Object call() throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, (Object) this);
        }
        this.f383457d.a(this.f383454a, this.f383455b, this.f383456c);
        return null;
    }
}
