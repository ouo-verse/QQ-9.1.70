package com.tencent.mobileqq.microapp.appbrand.ui;

import android.text.TextUtils;
import com.tencent.mobileqq.microapp.app.b;
import com.tencent.mobileqq.microapp.appbrand.b.h;
import com.tencent.mobileqq.microapp.appbrand.j;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
final class e implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ b.a f246023a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ d f246024b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, b.a aVar) {
        this.f246024b = dVar;
        this.f246023a = aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) dVar, (Object) aVar);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        b.a aVar = this.f246023a;
        int i3 = aVar.f245887a;
        if (i3 != -1) {
            if (i3 != 1) {
                if (i3 == 3) {
                    h.a().a(this.f246024b.f246022a);
                } else {
                    return;
                }
            }
            com.tencent.mobileqq.microapp.a.c cVar = this.f246023a.f245888b;
            if (cVar != null) {
                this.f246024b.f246022a.f246008a.a(cVar, cVar.f245825f.launchParam.entryPath);
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(aVar.f245889c)) {
            j jVar = this.f246024b.f246022a.f246008a;
            b.a aVar2 = this.f246023a;
            com.tencent.mobileqq.microapp.appbrand.a a16 = jVar.a(aVar2.f245889c, aVar2.f245890d);
            if (a16 != null) {
                a16.b();
            }
        }
        this.f246024b.f246022a.f246012e = true;
        this.f246024b.f246022a.a();
    }
}
