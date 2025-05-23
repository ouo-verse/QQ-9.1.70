package com.tencent.mobileqq.app.fms;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Observable;
import mqq.manager.Manager;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a extends Observable implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private final QQAppInterface f195607d;

    /* renamed from: e, reason: collision with root package name */
    private HashMap<String, SoftReference<b>> f195608e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.app.fms.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C7377a implements e {
        static IPatchRedirector $redirector_;

        C7377a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.app.fms.e
        public void a(FullMessageSearchResult fullMessageSearchResult) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                a.this.setChanged();
                a.this.notifyObservers(fullMessageSearchResult);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) fullMessageSearchResult);
            }
        }
    }

    public a(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f195608e = new HashMap<>();
            this.f195607d = qQAppInterface;
        }
    }

    private b b(String str) {
        b bVar;
        synchronized (this.f195608e) {
            SoftReference<b> softReference = this.f195608e.get(str);
            if (softReference != null) {
                bVar = softReference.get();
            } else {
                bVar = null;
            }
            if (bVar == null) {
                bVar = new b(this.f195607d, str, new C7377a());
                this.f195608e.put(str, new SoftReference<>(bVar));
            }
        }
        return bVar;
    }

    public void c(String str) {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.FullMessageSearch", 2, "pauseSearch " + str);
        }
        synchronized (this.f195608e) {
            SoftReference<b> softReference = this.f195608e.get(str);
            if (softReference != null) {
                bVar = softReference.get();
            } else {
                bVar = null;
            }
        }
        if (bVar != null) {
            bVar.b();
        }
    }

    public FullMessageSearchResult d(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (FullMessageSearchResult) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        return b(str).g();
    }

    public FullMessageSearchResult e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (FullMessageSearchResult) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        return b(str).h();
    }

    public void f() {
        b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.FullMessageSearch", 2, "stopSearch " + this.f195608e.size());
        }
        synchronized (this.f195608e) {
            for (SoftReference<b> softReference : this.f195608e.values()) {
                if (softReference != null && (bVar = softReference.get()) != null) {
                    bVar.a(2);
                }
            }
            this.f195608e.clear();
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            f();
        }
    }
}
