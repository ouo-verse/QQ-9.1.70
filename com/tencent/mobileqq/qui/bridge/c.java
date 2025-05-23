package com.tencent.mobileqq.qui.bridge;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQUIAppSetting;
import kotlin.Metadata;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0004\u001a\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qui/bridge/c;", "", "", "a", "b", "<init>", "()V", "qqui_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f276863a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37006);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f276863a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void a() {
        try {
            Class.forName("com.tencent.mobileqq.debug.componentization.floating.QUIViewMarkManager").getMethod("registerLifecycle", new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable th5) {
            QLog.e("QUIDelegateInjector", 1, "initQUIViewMark error,", th5);
        }
        try {
            Class.forName("com.tencent.mobileqq.debug.componentization.floating.QUITokenCheckManager").getMethod("initTokenCheck", new Class[0]).invoke(null, new Object[0]);
        } catch (Throwable th6) {
            QLog.e("QUIDelegateInjector", 1, "initTokenCheck error,", th6);
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ud0.c.b(td0.b.class, new e());
        ud0.c.b(td0.a.class, new a());
        ud0.c.b(td0.g.class, new g());
        ud0.c.b(td0.d.class, new d());
        if (MobileQQ.sProcessId != 1 && !QQUIAppSetting.isGrayVersion() && !QQUIAppSetting.isPublicVersion()) {
            a();
        }
        ud0.c.b(td0.m.class, new m());
        ud0.c.b(td0.f.class, new b());
        ud0.c.b(td0.k.class, new k());
        ud0.c.b(td0.j.class, new j());
        ud0.c.b(td0.e.class, new f());
        ud0.c.b(td0.l.class, new l());
        ud0.c.b(td0.h.class, new h());
        ud0.c.b(td0.i.class, new i());
        QLog.d("QUIDelegateInjector", 2, "inject qui delegate cost:" + (System.currentTimeMillis() - currentTimeMillis));
    }
}
