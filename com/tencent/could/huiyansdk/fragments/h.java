package com.tencent.could.huiyansdk.fragments;

import android.graphics.ColorMatrixColorFilter;
import com.tencent.could.huiyansdk.view.HuiYanReflectLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class h implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ColorMatrixColorFilter f100094a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f100095b;

    public h(i iVar, ColorMatrixColorFilter colorMatrixColorFilter) {
        this.f100095b = iVar;
        this.f100094a = colorMatrixColorFilter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iVar, (Object) colorMatrixColorFilter);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        HuiYanReflectLayout huiYanReflectLayout = this.f100095b.f100096a.f100053h;
        if (huiYanReflectLayout != null) {
            ColorMatrixColorFilter colorMatrixColorFilter = this.f100094a;
            if (huiYanReflectLayout.f100339a != null) {
                huiYanReflectLayout.f100340b = colorMatrixColorFilter;
                huiYanReflectLayout.invalidate();
            }
        }
    }
}
