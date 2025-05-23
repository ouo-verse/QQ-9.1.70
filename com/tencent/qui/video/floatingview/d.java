package com.tencent.qui.video.floatingview;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qui.video.floatingview.view.QUIVideoFloatViewContainer;
import com.tencent.qui.video.floatingview.view.m;
import java.util.HashSet;
import java.util.Iterator;
import ud0.f;
import ud0.i;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static volatile d f363904d;

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.qui.video.floatingview.operate.a f363905a;

    /* renamed from: b, reason: collision with root package name */
    private final HashSet<cz3.b> f363906b;

    /* renamed from: c, reason: collision with root package name */
    private a f363907c;

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f363906b = new HashSet<>();
        }
    }

    private com.tencent.qui.video.floatingview.operate.a c(Activity activity, View view, c cVar, bz3.b bVar) {
        if (cVar != null && !TextUtils.isEmpty(cVar.a())) {
            if (view != null && bVar != null) {
                Context a16 = ud0.b.a();
                if (a16 == null) {
                    return new com.tencent.qui.video.floatingview.operate.a(cVar).n(b.b());
                }
                if (this.f363905a != null) {
                    return new com.tencent.qui.video.floatingview.operate.a(cVar).n(b.e());
                }
                if (cVar.g() && activity != null && !i.a(a16)) {
                    i.b(activity);
                    return new com.tencent.qui.video.floatingview.operate.a(cVar).n(b.d());
                }
                if (!g()) {
                    f.b(ud0.b.a(), 1, ud0.b.a().getResources().getString(R.string.f2171960c), 0);
                    return new com.tencent.qui.video.floatingview.operate.a(cVar).n(b.a());
                }
                return null;
            }
            return new com.tencent.qui.video.floatingview.operate.a(cVar).n(b.c());
        }
        return new com.tencent.qui.video.floatingview.operate.a(new c("UN_KNOW_BUSINESS")).n(b.c());
    }

    private void e(a aVar) {
        try {
            Iterator<cz3.b> it = this.f363906b.iterator();
            while (it.hasNext()) {
                it.next().e(aVar);
            }
        } catch (Exception e16) {
            ud0.d.b("QUIVideoFloatWindowManger", ud0.d.f438811e, "disPatchInfluence error:" + e16);
        }
    }

    public static d i() {
        if (f363904d == null) {
            synchronized (d.class) {
                if (f363904d == null) {
                    f363904d = new d();
                }
            }
        }
        return f363904d;
    }

    public void a(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) aVar);
            return;
        }
        a aVar2 = this.f363907c;
        if (aVar2 != null && aVar2.equals(aVar)) {
            ud0.d.a("QUIVideoFloatWindowManger", ud0.d.f438811e, "businessInfluenceFloatWindowWithType repeat:" + aVar);
            return;
        }
        ud0.d.a("QUIVideoFloatWindowManger", ud0.d.f438811e, "businessInfluenceFloatWindowWithType oldType :" + this.f363907c + "| new type:" + aVar);
        this.f363907c = aVar;
        e(aVar);
    }

    public void b(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
            return;
        }
        if (aVar == null) {
            ud0.d.a("QUIVideoFloatWindowManger", ud0.d.f438811e, "businessUnInfluenceFloatWindowWithType null");
            return;
        }
        ud0.d.a("QUIVideoFloatWindowManger", ud0.d.f438811e, "businessUnInfluenceFloatWindowWithType oldType :" + this.f363907c + "| new type:" + aVar);
        this.f363907c = null;
        f(aVar);
    }

    public com.tencent.qui.video.floatingview.operate.a d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qui.video.floatingview.operate.a) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f363905a;
    }

    public void f(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) aVar);
            return;
        }
        try {
            Iterator<cz3.b> it = this.f363906b.iterator();
            while (it.hasNext()) {
                it.next().f(aVar);
            }
        } catch (Exception e16) {
            ud0.d.b("QUIVideoFloatWindowManger", ud0.d.f438811e, "disPatchInfluence error:" + e16);
        }
    }

    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        a aVar = this.f363907c;
        if (aVar == null) {
            ud0.d.a("QUIVideoFloatWindowManger", ud0.d.f438811e, "enableOpenFolder true influenceType np");
            return true;
        }
        if (100 != aVar.a() && 101 != this.f363907c.a() && 102 != this.f363907c.a()) {
            ud0.d.a("QUIVideoFloatWindowManger", ud0.d.f438811e, "enableOpenFolder false influenceType :" + this.f363907c);
            return true;
        }
        ud0.d.a("QUIVideoFloatWindowManger", ud0.d.f438811e, "enableOpenFolder false influenceType :" + this.f363907c);
        return false;
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        com.tencent.qui.video.floatingview.operate.a aVar = this.f363905a;
        if (aVar == null) {
            return;
        }
        if (aVar.c().c()) {
            this.f363905a.a();
        }
        this.f363905a = null;
    }

    public com.tencent.qui.video.floatingview.operate.a j(Activity activity, View view, c cVar, bz3.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qui.video.floatingview.operate.a) iPatchRedirector.redirect((short) 2, this, activity, view, cVar, bVar);
        }
        com.tencent.qui.video.floatingview.operate.a c16 = c(activity, view, cVar, bVar);
        if (c16 != null) {
            ud0.d.a("QUIVideoFloatWindowManger", ud0.d.f438811e, "openWithContentView error:" + c16);
            return c16;
        }
        bVar.k();
        com.tencent.qui.video.floatingview.operate.a aVar = new com.tencent.qui.video.floatingview.operate.a(cVar);
        aVar.c().l(cVar.c());
        QUIVideoFloatViewContainer qUIVideoFloatViewContainer = new QUIVideoFloatViewContainer(ud0.b.a());
        aVar.p(qUIVideoFloatViewContainer).m(bVar);
        qUIVideoFloatViewContainer.j0(view, new m(cVar.c(), cVar.b()), bVar, aVar);
        this.f363905a = aVar;
        bVar.c();
        return aVar;
    }

    public void k(cz3.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) bVar);
            return;
        }
        if (bVar == null) {
            return;
        }
        this.f363906b.add(bVar);
        ud0.d.a("QUIVideoFloatWindowManger", ud0.d.f438811e, "resisterNotification :" + bVar.getClass().getName());
    }
}
