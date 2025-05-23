package com.tencent.rfix.lib.event;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.rfix.lib.RFixListener;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final List<RFixListener> f364980a;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f364980a = new ArrayList();
        }
    }

    private Object[] b() {
        Object[] array;
        synchronized (this) {
            array = this.f364980a.toArray();
        }
        return array;
    }

    public void a(RFixListener rFixListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rFixListener);
        } else {
            if (rFixListener == null) {
                return;
            }
            synchronized (this) {
                if (!this.f364980a.contains(rFixListener)) {
                    this.f364980a.add(rFixListener);
                }
            }
        }
    }

    public void c(boolean z16, int i3, ConfigEvent configEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Integer.valueOf(i3), configEvent);
            return;
        }
        Object[] b16 = b();
        for (int length = b16.length - 1; length >= 0; length--) {
            ((RFixListener) b16[length]).onConfig(z16, i3, configEvent);
        }
    }

    public void d(boolean z16, int i3, DownloadEvent downloadEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3), downloadEvent);
            return;
        }
        Object[] b16 = b();
        for (int length = b16.length - 1; length >= 0; length--) {
            ((RFixListener) b16[length]).onDownload(z16, i3, downloadEvent);
        }
    }

    public void e(boolean z16, int i3, InstallEvent installEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Integer.valueOf(i3), installEvent);
            return;
        }
        Object[] b16 = b();
        for (int length = b16.length - 1; length >= 0; length--) {
            ((RFixListener) b16[length]).onInstall(z16, i3, installEvent);
        }
    }

    public void f(RFixListener rFixListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rFixListener);
        } else {
            synchronized (this) {
                this.f364980a.remove(rFixListener);
            }
        }
    }
}
