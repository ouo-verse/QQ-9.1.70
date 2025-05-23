package com.tencent.report;

import android.view.View;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mm4.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tk4.d;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J.\u0010\b\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005JB\u0010\u000f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005JB\u0010\u0010\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005JB\u0010\u0011\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005J\"\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005J\"\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0005\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/report/a;", "", "target", "", ISchemeApi.KEY_PAGE_ID, "", "businessParams", "", "f", "Landroid/view/View;", "view", "", "isAsync", IECDtReport.ACTION_IDENTIFIER, "elementID", "a", "c", "d", "Ljava/lang/Object;", "obj", "g", "event", h.F, "<init>", "()V", "qq-live-od-adapter-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f364907a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19809);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            f364907a = new a();
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static /* synthetic */ void b(a aVar, View view, boolean z16, String str, String str2, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        boolean z17 = z16;
        if ((i3 & 4) != 0) {
            str = null;
        }
        String str3 = str;
        if ((i3 & 16) != 0) {
            map = new HashMap();
        }
        aVar.a(view, z17, str3, str2, map);
    }

    public static /* synthetic */ void e(a aVar, View view, boolean z16, String str, String str2, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        boolean z17 = z16;
        if ((i3 & 4) != 0) {
            str = null;
        }
        String str3 = str;
        if ((i3 & 16) != 0) {
            map = new HashMap();
        }
        aVar.d(view, z17, str3, str2, map);
    }

    public final void a(@NotNull View view, boolean isAsync, @Nullable String identifier, @NotNull String elementID, @NotNull Map<String, String> businessParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, view, Boolean.valueOf(isAsync), identifier, elementID, businessParams);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        ((ug4.a) b.b(ug4.a.class)).a(view, isAsync, identifier, elementID, businessParams);
    }

    public final void c(@NotNull View view, boolean isAsync, @Nullable String identifier, @NotNull String elementID, @NotNull Map<String, String> businessParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, view, Boolean.valueOf(isAsync), identifier, elementID, businessParams);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        ((ug4.a) b.b(ug4.a.class)).g(view, isAsync, identifier, elementID, businessParams);
    }

    public final void d(@NotNull View view, boolean isAsync, @Nullable String identifier, @NotNull String elementID, @NotNull Map<String, String> businessParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, view, Boolean.valueOf(isAsync), identifier, elementID, businessParams);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(elementID, "elementID");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        ((ug4.a) b.b(ug4.a.class)).c(view, isAsync, identifier, elementID, businessParams);
    }

    public final void f(@NotNull Object target, @NotNull String pageID, @Nullable Map<String, String> businessParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, target, pageID, businessParams);
            return;
        }
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(pageID, "pageID");
        ((ug4.a) b.b(ug4.a.class)).b(target, pageID, businessParams);
    }

    public final void g(@NotNull Object obj, @NotNull Map<String, String> businessParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, obj, (Object) businessParams);
            return;
        }
        Intrinsics.checkNotNullParameter(obj, "obj");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        ((ug4.a) b.b(ug4.a.class)).reportEvent("clck", obj, businessParams);
    }

    public final void h(@NotNull String event, @NotNull Map<String, String> businessParams) {
        Map<String, String> mutableMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) event, (Object) businessParams);
            return;
        }
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(businessParams, "businessParams");
        mutableMap = MapsKt__MapsKt.toMutableMap(businessParams);
        mutableMap.putAll(d.f436481a.f());
        ((ug4.a) b.b(ug4.a.class)).reportEvent(event, mutableMap);
    }
}
