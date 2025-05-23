package com.tencent.mobileqq.olympic.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
class OlympicUtil$2 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AppInterface f255231d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f255232e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f255233f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ String f255234h;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            a.g(this.f255231d, this.f255232e, this.f255233f, this.f255234h);
        }
    }
}
