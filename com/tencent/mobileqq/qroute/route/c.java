package com.tencent.mobileqq.qroute.route;

import android.app.Fragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.exception.QRouteException;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qroute/route/c;", "Lcom/tencent/mobileqq/qroute/route/j;", "Landroid/app/Fragment;", "Lcom/tencent/mobileqq/qroute/route/RouteMetaData;", "routeMetaData", "Lcom/tencent/mobileqq/qroute/route/Navigator;", "navigator", "b", "<init>", "()V", "QRoute_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes17.dex */
public final class c implements j<Fragment> {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qroute.route.j
    @NotNull
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Fragment a(@NotNull RouteMetaData routeMetaData, @NotNull Navigator navigator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (Fragment) iPatchRedirector.redirect((short) 1, (Object) this, (Object) routeMetaData, (Object) navigator);
        }
        Intrinsics.checkParameterIsNotNull(routeMetaData, "routeMetaData");
        Intrinsics.checkParameterIsNotNull(navigator, "navigator");
        k.b("Handle Fragment..");
        String b16 = routeMetaData.b();
        try {
            Object newInstance = Class.forName(b16).newInstance();
            if (newInstance != null) {
                Fragment fragment = (Fragment) newInstance;
                fragment.setArguments(navigator.getExtras());
                return fragment;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.app.Fragment");
        } catch (ClassCastException e16) {
            throw new QRouteException(1004, b16 + " can not be cast to android.app.Fragment", e16);
        } catch (ClassNotFoundException e17) {
            throw new QRouteException(1002, "fragment " + routeMetaData.b() + " not found!", e17);
        }
    }
}
