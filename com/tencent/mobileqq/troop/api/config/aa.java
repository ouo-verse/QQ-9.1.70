package com.tencent.mobileqq.troop.api.config;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes19.dex */
public class aa {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static ArrayList<h> f293945a;

    /* renamed from: b, reason: collision with root package name */
    private static aa f293946b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63866);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f293945a = new ArrayList<>();
        }
    }

    aa() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            b();
        }
    }

    public static aa a() {
        if (f293946b == null) {
            synchronized (aa.class) {
                if (f293946b == null) {
                    f293946b = new aa();
                }
            }
        }
        return f293946b;
    }

    void b() {
        ArrayList<Class<? extends h>> arrayList = com.tencent.mobileqq.troop.api.config.extension.a.f293980d;
        if (arrayList != null) {
            Iterator<Class<? extends h>> it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    f293945a.add(it.next().newInstance());
                } catch (Throwable th5) {
                    QLog.i("TroopGagProcessorConfig", 1, "Init Fail", th5);
                }
            }
        }
    }

    public void c(AppInterface appInterface, long j3, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appInterface, Long.valueOf(j3), Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        Iterator<h> it = f293945a.iterator();
        while (it.hasNext()) {
            it.next().a(appInterface, j3, z16, z17);
        }
    }

    public void d(AppInterface appInterface, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appInterface, Long.valueOf(j3));
            return;
        }
        Iterator<h> it = f293945a.iterator();
        while (it.hasNext()) {
            it.next().b(appInterface, j3);
        }
    }
}
