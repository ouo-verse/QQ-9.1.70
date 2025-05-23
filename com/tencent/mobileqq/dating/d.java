package com.tencent.mobileqq.dating;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes10.dex */
public class d implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private QQAppInterface f203414d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.mobileqq.dating.widget.a f203415e;

    /* renamed from: f, reason: collision with root package name */
    private StrangerHdHeadUrlFetcher f203416f;

    /* renamed from: h, reason: collision with root package name */
    private Object f203417h;

    /* renamed from: i, reason: collision with root package name */
    private Object f203418i;

    public d(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f203417h = new Object();
        this.f203418i = new Object();
        this.f203414d = qQAppInterface;
    }

    public StrangerHdHeadUrlFetcher a() {
        StrangerHdHeadUrlFetcher strangerHdHeadUrlFetcher;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (StrangerHdHeadUrlFetcher) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        StrangerHdHeadUrlFetcher strangerHdHeadUrlFetcher2 = this.f203416f;
        if (strangerHdHeadUrlFetcher2 != null) {
            return strangerHdHeadUrlFetcher2;
        }
        synchronized (this.f203418i) {
            if (this.f203416f == null) {
                this.f203416f = new StrangerHdHeadUrlFetcher(this.f203414d);
            }
            strangerHdHeadUrlFetcher = this.f203416f;
        }
        return strangerHdHeadUrlFetcher;
    }

    public com.tencent.mobileqq.dating.widget.a b() {
        com.tencent.mobileqq.dating.widget.a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.dating.widget.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        com.tencent.mobileqq.dating.widget.a aVar2 = this.f203415e;
        if (aVar2 != null) {
            return aVar2;
        }
        synchronized (this.f203417h) {
            if (this.f203415e == null) {
                this.f203415e = new com.tencent.mobileqq.dating.widget.a(this.f203414d);
            }
            aVar = this.f203415e;
        }
        return aVar;
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.mobileqq.dating.widget.a aVar = this.f203415e;
        if (aVar != null) {
            aVar.g();
        }
        this.f203415e = null;
        StrangerHdHeadUrlFetcher strangerHdHeadUrlFetcher = this.f203416f;
        if (strangerHdHeadUrlFetcher != null) {
            strangerHdHeadUrlFetcher.f();
            this.f203416f = null;
        }
    }
}
