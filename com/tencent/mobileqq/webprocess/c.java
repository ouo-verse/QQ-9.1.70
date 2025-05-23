package com.tencent.mobileqq.webprocess;

import android.content.IntentFilter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.manager.Manager;

/* compiled from: P */
@Deprecated
/* loaded from: classes20.dex */
public class c implements Manager {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    protected QQAppInterface f313738d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f313739e;

    public c(QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
            return;
        }
        this.f313739e = false;
        this.f313738d = qQAppInterface;
        a();
    }

    @Deprecated
    private void a() {
        if (!this.f313739e) {
            this.f313739e = true;
            try {
                new IntentFilter().addAction("com.tencent.mobileqq.babyq.add");
            } catch (Exception unused) {
            }
        }
    }

    @Deprecated
    private void b() {
        if (this.f313739e) {
            try {
                this.f313739e = false;
            } catch (Exception unused) {
            }
        }
    }

    @Override // mqq.manager.Manager
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            b();
        }
    }
}
