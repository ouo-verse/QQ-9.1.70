package com.tencent.mobileqq.qroute.route;

import android.app.Activity;
import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.exception.QRouteException;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ3\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ3\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J3\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/qroute/route/a;", "Lcom/tencent/mobileqq/qroute/route/j;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/content/Intent;", "intent", "", "requestCode", "Landroid/os/Bundle;", "options", "c", "(Landroid/app/Activity;Landroid/content/Intent;Ljava/lang/Integer;Landroid/os/Bundle;)V", "Landroid/app/Fragment;", "fragment", "d", "(Landroid/app/Fragment;Landroid/content/Intent;Ljava/lang/Integer;Landroid/os/Bundle;)V", "Landroidx/fragment/app/Fragment;", "e", "(Landroidx/fragment/app/Fragment;Landroid/content/Intent;Ljava/lang/Integer;Landroid/os/Bundle;)V", "Lcom/tencent/mobileqq/qroute/route/RouteMetaData;", "routeMetaData", "Lcom/tencent/mobileqq/qroute/route/Navigator;", "navigator", "b", "<init>", "()V", "QRoute_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes17.dex */
public final class a implements j<Unit> {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    private final void c(Activity activity, Intent intent, Integer requestCode, Bundle options) {
        if (requestCode == null) {
            if (options == null) {
                activity.startActivity(intent);
                return;
            } else {
                activity.startActivity(intent, options);
                return;
            }
        }
        if (options == null) {
            activity.startActivityForResult(intent, requestCode.intValue());
        } else {
            activity.startActivityForResult(intent, requestCode.intValue(), options);
        }
    }

    private final void d(Fragment fragment, Intent intent, Integer requestCode, Bundle options) {
        if (requestCode == null) {
            if (options == null) {
                fragment.startActivity(intent);
                return;
            } else {
                fragment.startActivity(intent, options);
                return;
            }
        }
        if (options == null) {
            fragment.startActivityForResult(intent, requestCode.intValue());
        } else {
            fragment.startActivityForResult(intent, requestCode.intValue(), options);
        }
    }

    private final void e(androidx.fragment.app.Fragment fragment, Intent intent, Integer requestCode, Bundle options) {
        if (requestCode == null) {
            if (options == null) {
                fragment.startActivity(intent);
                return;
            } else {
                fragment.startActivity(intent, options);
                return;
            }
        }
        if (options == null) {
            fragment.startActivityForResult(intent, requestCode.intValue());
        } else {
            fragment.startActivityForResult(intent, requestCode.intValue(), options);
        }
    }

    @Override // com.tencent.mobileqq.qroute.route.j
    public /* bridge */ /* synthetic */ Unit a(RouteMetaData routeMetaData, Navigator navigator) {
        b(routeMetaData, navigator);
        return Unit.INSTANCE;
    }

    public void b(@NotNull RouteMetaData routeMetaData, @NotNull Navigator navigator) {
        Activity activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) routeMetaData, (Object) navigator);
            return;
        }
        Intrinsics.checkParameterIsNotNull(routeMetaData, "routeMetaData");
        Intrinsics.checkParameterIsNotNull(navigator, "navigator");
        k.b("Handle Activity..");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(navigator.getContext(), routeMetaData.b())).addFlags(navigator.getFlags()).putExtras(navigator.getExtras()).setAction(navigator.getAction());
        if (navigator.getData() != null) {
            Uri data = navigator.getData();
            if (data == null) {
                Intrinsics.throwNpe();
            }
            intent.setDataAndTypeAndNormalize(data, navigator.getType());
        } else {
            intent.setType(navigator.getType());
        }
        try {
            k.a("startActivity >> " + routeMetaData.b() + ", intent: " + intent + ", request code: " + navigator.getRequestCode() + ", options: " + navigator.getOptions());
            if (navigator.getActivity() != null) {
                Activity activity2 = navigator.getActivity();
                if (activity2 == null) {
                    Intrinsics.throwNpe();
                }
                c(activity2, intent, navigator.getRequestCode(), navigator.getOptions());
            } else if (navigator.getFragment() != null) {
                Fragment fragment = navigator.getFragment();
                if (fragment == null) {
                    Intrinsics.throwNpe();
                }
                d(fragment, intent, navigator.getRequestCode(), navigator.getOptions());
            } else if (navigator.getFragmentX() != null) {
                androidx.fragment.app.Fragment fragmentX = navigator.getFragmentX();
                if (fragmentX == null) {
                    Intrinsics.throwNpe();
                }
                e(fragmentX, intent, navigator.getRequestCode(), navigator.getOptions());
            } else if (navigator.getContext() instanceof Activity) {
                c((Activity) navigator.getContext(), intent, navigator.getRequestCode(), navigator.getOptions());
            } else {
                intent.addFlags(268435456);
                ContextCompat.startActivity(navigator.getContext(), intent, navigator.getOptions());
            }
            if ((navigator.getEnterAnim() > 0 || navigator.getExitAnim() > 0) && (activity = navigator.getActivity()) != null) {
                activity.overridePendingTransition(navigator.getEnterAnim(), navigator.getExitAnim());
            }
        } catch (ActivityNotFoundException e16) {
            throw new QRouteException(1002, "route: " + navigator.getPath() + ", Activity: " + routeMetaData.b() + " not found!", e16);
        }
    }
}
