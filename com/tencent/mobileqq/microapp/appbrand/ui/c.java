package com.tencent.mobileqq.microapp.appbrand.ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class c extends AnimatorListenerAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.mobileqq.microapp.appbrand.a f246019a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.tencent.mobileqq.microapp.appbrand.a f246020b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AppBrandUI f246021c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AppBrandUI appBrandUI, com.tencent.mobileqq.microapp.appbrand.a aVar, com.tencent.mobileqq.microapp.appbrand.a aVar2) {
        this.f246021c = appBrandUI;
        this.f246019a = aVar;
        this.f246020b = aVar2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, appBrandUI, aVar, aVar2);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) animator);
            return;
        }
        super.onAnimationEnd(animator);
        this.f246019a.c();
        this.f246019a.f245902g.setTranslationY(0.0f);
        this.f246021c.f246008a.a(this.f246020b);
        com.tencent.mobileqq.microapp.appbrand.a aVar = this.f246020b;
        aVar.a(aVar.f245898c.f245825f);
    }
}
