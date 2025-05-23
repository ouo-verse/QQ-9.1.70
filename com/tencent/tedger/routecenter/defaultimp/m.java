package com.tencent.tedger.routecenter.defaultimp;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import ve4.m;

/* compiled from: P */
/* loaded from: classes26.dex */
public class m extends c<ve4.m> implements ve4.m {
    static IPatchRedirector $redirector_;

    public m(com.tencent.tedger.routecenter.a aVar) {
        super(aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar);
        }
    }

    @Override // ve4.m
    public String C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (v()) {
            return null;
        }
        return ((ve4.m) this.f375322c).C();
    }

    @Override // ve4.m
    public void asyncRunInRequestThread(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) runnable);
        } else {
            if (v()) {
                return;
            }
            ((ve4.m) this.f375322c).asyncRunInRequestThread(runnable);
        }
    }

    @Override // ve4.m
    public void l(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) runnable);
        } else {
            if (v()) {
                return;
            }
            ((ve4.m) this.f375322c).l(runnable);
        }
    }

    @Override // ve4.m
    public void m(Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) runnable);
        } else {
            if (v()) {
                return;
            }
            ((ve4.m) this.f375322c).m(runnable);
        }
    }

    @Override // com.tencent.tedger.routecenter.defaultimp.c, com.tencent.tedger.outapi.api.i
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        if (this.f375322c != 0) {
            ((ve4.m) this.f375322c).onDestroy();
        }
        super.onDestroy();
    }

    @Override // ve4.m
    public void syncRunInRequestThread(m.a aVar, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, aVar, Long.valueOf(j3));
        } else {
            if (v()) {
                return;
            }
            ((ve4.m) this.f375322c).syncRunInRequestThread(aVar, j3);
        }
    }
}
