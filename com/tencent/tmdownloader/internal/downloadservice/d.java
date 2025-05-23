package com.tencent.tmdownloader.internal.downloadservice;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    protected static d f380709b;

    /* renamed from: a, reason: collision with root package name */
    protected final List<f> f380710a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17530);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    protected d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f380710a = Collections.synchronizedList(new ArrayList());
        }
    }

    public static d a() {
        if (f380709b == null) {
            f380709b = new d();
        }
        return f380709b;
    }

    public synchronized void b(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) fVar);
        } else {
            this.f380710a.remove(fVar);
        }
    }

    public synchronized void a(f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) fVar);
        } else {
            if (!this.f380710a.contains(fVar)) {
                this.f380710a.add(fVar);
            }
        }
    }

    public synchronized void a(String str, int i3, int i16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2);
            return;
        }
        Iterator<f> it = this.f380710a.iterator();
        while (it.hasNext()) {
            it.next().a(str, i3, i16, str2);
        }
    }

    public synchronized void a(String str, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        Iterator<f> it = this.f380710a.iterator();
        while (it.hasNext()) {
            it.next().a(str, j3, j16);
        }
    }

    public synchronized void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        Iterator<f> it = this.f380710a.iterator();
        while (it.hasNext()) {
            it.next().a(str);
        }
    }
}
