package com.tencent.mobileqq.flock.utils;

import android.content.Context;
import com.tencent.mobileqq.dt.api.IDTAPI;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import y45.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/flock/utils/f;", "", "Ly45/b;", "feed", "Lcom/tencent/mobileqq/dt/api/b;", "a", "Landroid/content/Context;", "context", "data", "", "b", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f210485a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49490);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f210485a = new f();
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final com.tencent.mobileqq.dt.api.b a(@NotNull y45.b feed) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.dt.api.b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) feed);
        }
        Intrinsics.checkNotNullParameter(feed, "feed");
        com.tencent.mobileqq.dt.api.b bVar = new com.tencent.mobileqq.dt.api.b();
        bVar.n(feed.f449369d.f449449a);
        bVar.o(2);
        o oVar = feed.f449369d;
        Intrinsics.checkNotNullExpressionValue(oVar, "feed.publisher");
        if (com.tencent.mobileqq.flock.ktx.e.g(oVar)) {
            str = "1";
        } else {
            str = "0";
        }
        bVar.j(str);
        bVar.s(0);
        bVar.m(feed.f449380o.f449441c);
        return bVar;
    }

    public final void b(@NotNull Context context, @NotNull com.tencent.mobileqq.dt.api.b data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        ((IDTAPI) QRoute.api(IDTAPI.class)).jumpReport(context, data);
    }
}
