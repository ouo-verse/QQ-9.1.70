package com.tencent.halley.common.d;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
public class h implements a, c {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static volatile h f113525b;

    /* renamed from: a, reason: collision with root package name */
    public d f113526a;

    /* renamed from: c, reason: collision with root package name */
    private Map<String, com.tencent.halley.common.d.a.a> f113527c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12338);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            f113525b = null;
        }
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f113527c = new ConcurrentHashMap();
        a(new com.tencent.halley.common.d.a.c());
        a(new com.tencent.halley.common.d.a.b());
        a(new com.tencent.halley.common.d.a.a.a());
    }

    public static h d() {
        if (f113525b == null) {
            synchronized (h.class) {
                if (f113525b == null) {
                    f113525b = new h();
                }
            }
        }
        return f113525b;
    }

    @Override // com.tencent.halley.common.d.a
    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.f113526a.b();
        }
    }

    @Override // com.tencent.halley.common.d.c
    public final void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        Iterator<com.tencent.halley.common.d.a.a> it = this.f113527c.values().iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    public final f e() {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            obj = iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            obj = this.f113527c.get(QCircleDaTongConstant.ElementParamValue.SETTINGS);
        }
        return (f) obj;
    }

    public final e f() {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            obj = iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            obj = this.f113527c.get("accessscheduler");
        }
        return (e) obj;
    }

    @Override // com.tencent.halley.common.d.a
    public final void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.f113526a.a();
        } else {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.halley.common.d.a
    public final void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            com.tencent.halley.common.a.h().post(new Runnable(i3) { // from class: com.tencent.halley.common.d.h.1
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ int f113528a;

                {
                    this.f113528a = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) h.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public final void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    com.tencent.halley.common.utils.d.b("halley-cloud-PlatformMgr", "onHttpUsed:" + this.f113528a);
                    h.this.f113526a.a(this.f113528a);
                }
            });
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        }
    }

    private void a(com.tencent.halley.common.d.a.a aVar) {
        this.f113527c.put(aVar.b(), aVar);
    }

    @Override // com.tencent.halley.common.d.b
    public final void a(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) str2);
            return;
        }
        Iterator<com.tencent.halley.common.d.a.a> it = this.f113527c.values().iterator();
        while (it.hasNext()) {
            it.next().a(str, str2);
        }
    }

    @Override // com.tencent.halley.common.d.b
    public final void a(String str, byte[] bArr, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, bArr, str2);
            return;
        }
        Iterator<com.tencent.halley.common.d.a.a> it = this.f113527c.values().iterator();
        while (it.hasNext()) {
            it.next().a(str, bArr, str2);
        }
    }
}
