package com.tencent.could.huiyansdk.fragments;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class b implements com.tencent.could.huiyansdk.callback.f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AuthingFragment f100086a;

    public b(AuthingFragment authingFragment) {
        this.f100086a = authingFragment;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) authingFragment);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i3) {
        this.f100086a.f100051f.setText(i3 + this.f100086a.c().getString(R.string.txy_count_down_txt));
    }

    public void a(final int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.f100086a.a(new Runnable() { // from class: com.tencent.could.huiyansdk.fragments.aa
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.b(i3);
                }
            });
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
    }
}
