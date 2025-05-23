package com.tencent.qimei.h;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes22.dex */
public class d implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public a f343294a;

    /* renamed from: b, reason: collision with root package name */
    public c f343295b;

    public d(a aVar, c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) cVar);
        } else {
            this.f343294a = aVar;
            this.f343295b = cVar;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0055, code lost:
    
        if (r4 != null) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0075  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        c cVar;
        e eVar;
        com.tencent.qimei.a.a aVar;
        String str;
        String str2;
        a aVar2;
        a aVar3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (this.f343294a == null) {
            return;
        }
        int i3 = 0;
        boolean z16 = false;
        do {
            try {
                TimeUnit.MICROSECONDS.sleep(10L);
                z16 = this.f343294a.a();
                i3++;
                if (z16) {
                    break;
                }
            } catch (Exception unused) {
            }
        } while (i3 < 30);
        if (z16 && (cVar = this.f343295b) != null && (aVar = (eVar = (e) cVar).f343298c) != null) {
            boolean a16 = eVar.a();
            String str3 = "";
            if (eVar.a()) {
                b bVar = eVar.f343296a;
                bVar.getClass();
                try {
                    aVar3 = bVar.f343291d;
                } catch (Exception unused2) {
                }
                if (aVar3 == null) {
                    str = "";
                } else {
                    str = aVar3.l();
                }
            }
            str = "";
            if (eVar.a()) {
                b bVar2 = eVar.f343296a;
                bVar2.getClass();
                try {
                    aVar2 = bVar2.f343291d;
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
                if (aVar2 == null) {
                    str2 = "";
                    if (str2 != null) {
                        str3 = str2;
                    }
                } else {
                    str2 = aVar2.c();
                    if (str2 != null) {
                    }
                }
            }
            aVar.callbackOaid(a16, str, str3, false);
        }
    }
}
