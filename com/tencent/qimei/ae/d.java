package com.tencent.qimei.ae;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.tencent.qimei.u.d f342948a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f342949b;

    public d(a aVar, com.tencent.qimei.u.d dVar) {
        this.f342949b = aVar;
        this.f342948a = dVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) dVar);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.qimei.u.c cVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        String d16 = com.tencent.qimei.aa.f.b(this.f342949b.f342945a).d("is_first");
        if (com.tencent.qimei.ar.a.a(this.f342949b.f342945a).f343094b.a() && !TextUtils.isEmpty(d16)) {
            String str = this.f342949b.f342945a;
            if (!com.tencent.qimei.u.a.f()) {
                this.f342948a.a(5);
                return;
            }
            a aVar = this.f342949b;
            com.tencent.qimei.u.d dVar = this.f342948a;
            aVar.f342947c = false;
            com.tencent.qimei.t.a.a().a(10000L, new e(aVar, dVar));
            synchronized (com.tencent.qimei.u.c.class) {
                cVar = com.tencent.qimei.u.c.f343390p;
            }
            f fVar = new f(aVar, dVar);
            if (cVar.f343398h == null) {
                cVar.f343392b = SystemClock.elapsedRealtime();
                new com.tencent.oaid2.b().b(cVar.f343391a, new com.tencent.qimei.u.b(cVar, fVar));
                return;
            }
            return;
        }
        this.f342948a.a(2);
    }
}
