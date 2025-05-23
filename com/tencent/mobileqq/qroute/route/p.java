package com.tencent.mobileqq.qroute.route;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.exception.QRouteException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qroute/route/p;", "Lcom/tencent/mobileqq/qroute/route/j;", "", "Lcom/tencent/mobileqq/qroute/route/RouteMetaData;", "routeMetaData", "Lcom/tencent/mobileqq/qroute/route/Navigator;", "navigator", "b", "<init>", "()V", "QRoute_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes17.dex */
public final class p implements j<Unit> {
    static IPatchRedirector $redirector_;

    public p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qroute.route.j
    public /* bridge */ /* synthetic */ Unit a(RouteMetaData routeMetaData, Navigator navigator) {
        b(routeMetaData, navigator);
        return Unit.INSTANCE;
    }

    public void b(@NotNull RouteMetaData routeMetaData, @NotNull Navigator navigator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) routeMetaData, (Object) navigator);
            return;
        }
        Intrinsics.checkParameterIsNotNull(routeMetaData, "routeMetaData");
        Intrinsics.checkParameterIsNotNull(navigator, "navigator");
        k.b("Handle Service..");
        Intent action = new Intent().setComponent(new ComponentName(navigator.getContext(), routeMetaData.b())).putExtras(navigator.getExtras()).setAction(navigator.getAction());
        Intrinsics.checkExpressionValueIsNotNull(action, "Intent().setComponent(Co\u2026tAction(navigator.action)");
        if (navigator.getData() != null) {
            Uri data = navigator.getData();
            if (data == null) {
                Intrinsics.throwNpe();
            }
            action.setDataAndTypeAndNormalize(data, navigator.getType());
        } else {
            action.setType(navigator.getType());
        }
        try {
            if (navigator.getServiceConn() != null) {
                k.b("Bind Service");
                Context context = navigator.getContext();
                ServiceConnection serviceConn = navigator.getServiceConn();
                if (serviceConn == null) {
                    Intrinsics.throwNpe();
                }
                context.bindService(action, serviceConn, navigator.getBindServiceFlags());
                return;
            }
            if (navigator.getContext().startService(action) != null) {
                return;
            }
            throw new QRouteException(1002, "Service " + routeMetaData.b() + " not found!", null, 4, null);
        } catch (IllegalStateException e16) {
            throw new QRouteException(1007, '[' + routeMetaData.b() + "] state error!", e16);
        } catch (SecurityException e17) {
            throw new QRouteException(1006, '[' + routeMetaData.b() + "] the caller does not have permission to access the service or the service can not be found.", e17);
        }
    }
}
