package com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.cache;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final List<com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.b> f270517a;

    /* renamed from: b, reason: collision with root package name */
    private static final a f270518b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55136);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f270517a = new ArrayList();
            f270518b = new a();
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static List<com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.b> a() {
        return f270517a;
    }

    public static com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a b() {
        for (com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.b bVar : f270517a) {
            if (bVar != null) {
                for (com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a aVar : bVar.f270511e) {
                    if (aVar != null && aVar.d()) {
                        return aVar;
                    }
                }
            }
        }
        return null;
    }

    private static void c() {
        for (com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.b bVar : f270517a) {
            if (bVar != null) {
                for (com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a aVar : bVar.f270511e) {
                    if (aVar != null && aVar.f270503m) {
                        b.a(aVar);
                    }
                }
            }
        }
        f270517a.add(0, b.d());
    }

    public static void d() {
        f270517a.clear();
    }

    public static void e() {
        for (com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.b bVar : f270517a) {
            if (bVar != null) {
                for (com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a aVar : bVar.f270511e) {
                    if (aVar != null) {
                        aVar.g(false);
                    }
                }
            }
        }
    }

    public static void f(@NonNull com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a aVar, boolean z16) {
        for (com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.b bVar : f270517a) {
            if (bVar != null) {
                for (com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a aVar2 : bVar.f270511e) {
                    if (aVar2 != null && aVar2.b(aVar)) {
                        aVar2.g(z16);
                        return;
                    }
                }
            }
        }
    }

    public static void g(@NonNull List<com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.b> list) {
        if (list != null && !list.isEmpty()) {
            synchronized (c.class) {
                d();
                f270517a.addAll(list);
                c();
            }
        }
    }
}
