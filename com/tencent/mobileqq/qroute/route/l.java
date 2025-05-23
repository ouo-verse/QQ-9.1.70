package com.tencent.mobileqq.qroute.route;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.exception.QRouteException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qroute/route/l;", "Lcom/tencent/mobileqq/qroute/route/j;", "", "Lcom/tencent/mobileqq/qroute/route/RouteMetaData;", "routeMetaData", "Lcom/tencent/mobileqq/qroute/route/Navigator;", "navigator", "a", "<init>", "()V", "QRoute_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes17.dex */
public final class l implements j<Object> {
    static IPatchRedirector $redirector_;

    public l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qroute.route.j
    @NotNull
    public Object a(@NotNull RouteMetaData routeMetaData, @NotNull Navigator navigator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return iPatchRedirector.redirect((short) 1, (Object) this, (Object) routeMetaData, (Object) navigator);
        }
        Intrinsics.checkParameterIsNotNull(routeMetaData, "routeMetaData");
        Intrinsics.checkParameterIsNotNull(navigator, "navigator");
        k.b("Handle provider..");
        try {
            Object any = Class.forName(routeMetaData.b()).newInstance();
            if (any instanceof e) {
                ((e) any).a(navigator.getContext(), navigator.getExtras());
            }
            Intrinsics.checkExpressionValueIsNotNull(any, "any");
            return any;
        } catch (ClassNotFoundException e16) {
            throw new QRouteException(1002, "class " + routeMetaData.b() + " not found!", e16);
        }
    }
}
