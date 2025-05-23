package com.tencent.creatorad.ui;

import com.tencent.creatorad.ui.presenter.h;
import com.tencent.creatorad.ui.presenter.i;
import com.tencent.creatorad.ui.presenter.j;
import com.tencent.creatorad.ui.presenter.k;
import com.tencent.creatorad.ui.presenter.l;
import com.tencent.creatorad.ui.presenter.m;
import com.tencent.creatorad.ui.presenter.n;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Integer, Class<?>> f100392a;

    /* renamed from: b, reason: collision with root package name */
    private static c f100393b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26612);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        HashMap hashMap = new HashMap();
        f100392a = hashMap;
        hashMap.put(Integer.valueOf(com.tencent.creatorad.ui.presenter.f.f100413q), com.tencent.creatorad.ui.presenter.f.class);
        hashMap.put(Integer.valueOf(com.tencent.creatorad.ui.presenter.c.f100406j), com.tencent.creatorad.ui.presenter.c.class);
        hashMap.put(Integer.valueOf(i.f100436h), i.class);
        hashMap.put(Integer.valueOf(h.f100435h), h.class);
        hashMap.put(Integer.valueOf(n.f100451f), n.class);
        hashMap.put(Integer.valueOf(m.f100450f), m.class);
        hashMap.put(Integer.valueOf(k.f100438f), k.class);
        hashMap.put(Integer.valueOf(j.f100437f), j.class);
        hashMap.put(Integer.valueOf(l.f100439y), l.class);
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static c b() {
        if (f100393b == null) {
            synchronized (c.class) {
                if (f100393b == null) {
                    f100393b = new c();
                }
            }
        }
        return f100393b;
    }

    public static int c(int i3, boolean z16, int i16) {
        return ((i3 * 10) + (z16 ? 1 : 0)) * 10000;
    }

    public b a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (b) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        Class<?> cls = f100392a.get(Integer.valueOf(i3));
        if (cls == null) {
            QLog.e("CreatorAdFactory", 1, "classRef not found ");
            return null;
        }
        if (!b.class.isAssignableFrom(cls)) {
            QLog.e("CreatorAdFactory", 1, " classRef is not assignableFrom Base ");
            return null;
        }
        try {
            return (b) cls.newInstance();
        } catch (IllegalAccessException e16) {
            QLog.e("CreatorAdFactory", 1, "IllegalAccessException " + e16);
            return null;
        } catch (InstantiationException e17) {
            QLog.e("CreatorAdFactory", 1, "InstantiationException " + e17);
            return null;
        }
    }
}
