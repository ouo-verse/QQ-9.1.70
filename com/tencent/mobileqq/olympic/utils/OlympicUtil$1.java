package com.tencent.mobileqq.olympic.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes16.dex */
class OlympicUtil$1 implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ AppInterface f255228d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f255229e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f255230f;

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            a.f(this.f255228d, this.f255229e, this.f255230f);
        }
    }
}
