package com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.cache;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.IAegisLogApi;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.b f270515a;

    /* renamed from: b, reason: collision with root package name */
    private static final IAegisLogApi f270516b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(55135);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.b bVar = new com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.b();
        f270515a = bVar;
        f270516b = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        bVar.f270507a = "collect_tab";
        bVar.f270508b = "\u6536\u85cf";
        bVar.f270511e = new ArrayList();
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean a(com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a aVar) {
        if (aVar == null) {
            f270516b.i("LocalCollectCacheHelper", "add failed, item is null");
            return false;
        }
        if (b(aVar)) {
            f270516b.i("LocalCollectCacheHelper", "add failed, collect list has item id = " + aVar.f270491a);
            return false;
        }
        synchronized (b.class) {
            f270515a.f270511e.add(aVar);
        }
        return true;
    }

    public static boolean b(@NonNull com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a aVar) {
        for (com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a aVar2 : f270515a.f270511e) {
            if (aVar2 != null && aVar2.b(aVar)) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a aVar) {
        if (aVar == null) {
            f270516b.i("LocalCollectCacheHelper", "delete failed, item is null");
            return false;
        }
        if (b(aVar)) {
            return f(aVar);
        }
        f270516b.i("LocalCollectCacheHelper", "delete failed, collect list has not item id = " + aVar.f270491a);
        return false;
    }

    public static com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.b d() {
        return f270515a;
    }

    public static com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a e() {
        for (com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a aVar : f270515a.f270511e) {
            if (aVar != null && aVar.d()) {
                return aVar;
            }
        }
        return null;
    }

    private static boolean f(com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a aVar) {
        com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a aVar2 = null;
        for (com.tencent.mobileqq.qqlive.anchor.beauty.ui.prop.bean.a aVar3 : f270515a.f270511e) {
            if (aVar3 != null && aVar3.b(aVar)) {
                aVar2 = aVar3;
            }
        }
        if (aVar2 == null) {
            return false;
        }
        synchronized (b.class) {
            f270515a.f270511e.remove(aVar2);
        }
        return true;
    }
}
