package com.tencent.ams.fusion.service;

import android.content.Context;
import android.util.Pair;
import com.tencent.ams.fusion.a.j;
import com.tencent.ams.fusion.service.resdownload.c;
import com.tencent.ams.fusion.service.splash.data.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import nt.h;
import ot.e;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static volatile boolean f70242c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile b f70243d;

    /* renamed from: a, reason: collision with root package name */
    private Context f70244a;

    /* renamed from: b, reason: collision with root package name */
    private Map<Class<? extends a>, a> f70245b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55762);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            f70242c = false;
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f70245b = new ConcurrentHashMap();
        }
    }

    private synchronized <T extends a> T a(Class<T> cls) {
        q();
        if (cls != null) {
            T t16 = (T) this.f70245b.get(cls);
            if (cls.isInstance(t16)) {
                return t16;
            }
            return null;
        }
        throw new IllegalArgumentException("Param 'serviceClazz' should be not null!");
    }

    public static b b() {
        if (f70243d == null) {
            synchronized (b.class) {
                if (f70243d == null) {
                    f70243d = new b();
                }
            }
        }
        return f70243d;
    }

    private void q() {
        if (f70242c) {
        } else {
            throw new IllegalStateException("You must call ServiceManager.getInstance().init(context) first!");
        }
    }

    public void c(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        if (context != null && this.f70244a == null) {
            this.f70244a = context.getApplicationContext();
        }
        f70242c = true;
    }

    public synchronized void d(Class<? extends a> cls, a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) cls, (Object) aVar);
        } else if (cls != null && aVar != null) {
            q();
            if (!this.f70245b.containsValue(aVar)) {
                this.f70245b.put(cls, aVar);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized void e(List<Pair<Class<? extends a>, a>> list) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
            return;
        }
        if (j.b(list)) {
            return;
        }
        q();
        for (Pair<Class<? extends a>, a> pair : list) {
            if (pair != null && pair.first != null && (obj = pair.second) != null && !this.f70245b.containsValue(obj)) {
                this.f70245b.put(pair.first, pair.second);
            }
        }
    }

    public Context f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Context) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        q();
        return this.f70244a;
    }

    public lt.a g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (lt.a) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        lt.a aVar = (lt.a) a(lt.a.class);
        if (aVar == null) {
            com.tencent.ams.fusion.service.d.a.a aVar2 = new com.tencent.ams.fusion.service.d.a.a();
            d(lt.a.class, aVar2);
            return aVar2;
        }
        return aVar;
    }

    public f h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (f) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return (f) a(f.class);
    }

    public c i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (c) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return (c) a(c.class);
    }

    public com.tencent.ams.fusion.service.a.a j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.ams.fusion.service.a.a) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return (com.tencent.ams.fusion.service.a.a) a(com.tencent.ams.fusion.service.a.a.class);
    }

    public com.tencent.ams.fusion.service.event.c k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (com.tencent.ams.fusion.service.event.c) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        com.tencent.ams.fusion.service.event.c cVar = (com.tencent.ams.fusion.service.event.c) a(com.tencent.ams.fusion.service.event.c.class);
        if (cVar == null) {
            com.tencent.ams.fusion.service.event.impl.a aVar = new com.tencent.ams.fusion.service.event.impl.a();
            d(com.tencent.ams.fusion.service.event.c.class, aVar);
            return aVar;
        }
        return cVar;
    }

    public jt.a l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (jt.a) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        jt.a aVar = (jt.a) a(jt.a.class);
        if (aVar == null) {
            com.tencent.ams.fusion.service.b.a.a aVar2 = new com.tencent.ams.fusion.service.b.a.a();
            d(jt.a.class, aVar2);
            return aVar2;
        }
        return aVar;
    }

    public com.tencent.ams.fusion.service.splash.data.b m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (com.tencent.ams.fusion.service.splash.data.b) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return (com.tencent.ams.fusion.service.splash.data.b) a(com.tencent.ams.fusion.service.splash.data.b.class);
    }

    public qt.c n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (qt.c) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return (qt.c) a(qt.c.class);
    }

    public e o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (e) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return (e) a(e.class);
    }

    public h p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (h) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return (h) a(h.class);
    }
}
