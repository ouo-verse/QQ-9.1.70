package com.tencent.mobileqq.springhb.interactive;

import com.tencent.aio.main.businesshelper.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.springhb.api.IInteractiveApi;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/springhb/interactive/b;", "", "Lcom/tencent/mobileqq/springhb/api/IInteractiveApi;", "a", "Lcom/tencent/aio/api/help/a;", "param", "Lkotlin/Pair;", "", "Lkotlin/Function0;", "Lcom/tencent/aio/main/businesshelper/h;", "b", "<init>", "()V", "springhb-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f289214a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(24025);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f289214a = new b();
        }
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final IInteractiveApi a() {
        QRouteApi api = QRoute.api(IInteractiveApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IInteractiveApi::class.java)");
        return (IInteractiveApi) api;
    }

    @Nullable
    public final Pair<String, Function0<h>> b(@NotNull com.tencent.aio.api.help.a param) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Pair) iPatchRedirector.redirect((short) 2, (Object) this, (Object) param);
        }
        Intrinsics.checkNotNullParameter(param, "param");
        return a().createInteractiveAnimationHelper(param);
    }
}
