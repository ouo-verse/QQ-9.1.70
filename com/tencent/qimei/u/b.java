package com.tencent.qimei.u;

import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b implements com.tencent.oaid2.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f343388a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f343389b;

    public b(c cVar, d dVar) {
        this.f343389b = cVar;
        this.f343388a = dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar, (Object) dVar);
        }
    }

    @Override // com.tencent.oaid2.a
    public void onResult(boolean z16, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), str, str2);
            return;
        }
        this.f343389b.f343398h = str2;
        if (str2 != null && !str2.isEmpty()) {
            i3 = 1;
        }
        if (i3 != 0) {
            this.f343389b.f343393c = SystemClock.elapsedRealtime() - this.f343389b.f343392b;
        }
        d dVar = this.f343388a;
        if (dVar != null) {
            dVar.a(i3 ^ 1);
        }
    }
}
