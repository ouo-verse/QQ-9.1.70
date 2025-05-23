package com.tencent.could.huiyansdk.manager;

import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Fragment f100126a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f100127b;

    public a(b bVar, Fragment fragment) {
        this.f100127b = bVar;
        this.f100126a = fragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar, (Object) fragment);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f100127b.b(this.f100126a);
        }
    }
}
