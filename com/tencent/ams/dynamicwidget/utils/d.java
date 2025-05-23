package com.tencent.ams.dynamicwidget.utils;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.RectF;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.TypedValue;
import android.view.View;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\f\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0018\u0010\u0003\u001a\u00020\r2\u0010\u0010\u0010\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000fJ\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J*\u0010\u0019\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014J:\u0010\u001c\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u00112\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/ams/dynamicwidget/utils/d;", "", "Landroid/content/Context;", "c", "Landroid/app/Activity;", "b", "Ljava/lang/Runnable;", "runnable", "", "g", "", "delayMillis", h.F, "", "d", "", "collection", "", "dp", "a", "Landroid/view/View;", "view", HippyTKDListViewAdapter.X, "y", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "f", "xEnlarge", "yEnlarge", "e", "<init>", "()V", "lib_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final d f70220a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21032);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            f70220a = new d();
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        }
    }

    public final float a(float dp5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Float) iPatchRedirector.redirect((short) 7, this, Float.valueOf(dp5))).floatValue();
        }
        Resources system = Resources.getSystem();
        Intrinsics.checkExpressionValueIsNotNull(system, "Resources.getSystem()");
        return TypedValue.applyDimension(1, dp5, system.getDisplayMetrics());
    }

    @Nullable
    public final Activity b(@NotNull Context c16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Activity) iPatchRedirector.redirect((short) 2, (Object) this, (Object) c16);
        }
        Intrinsics.checkParameterIsNotNull(c16, "c");
        while (c16 instanceof ContextWrapper) {
            if (c16 instanceof Activity) {
                return (Activity) c16;
            }
            c16 = ((ContextWrapper) c16).getBaseContext();
            Intrinsics.checkExpressionValueIsNotNull(c16, "context.baseContext");
        }
        return null;
    }

    public final boolean c(@Nullable Map<?, ?> collection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) collection)).booleanValue();
        }
        if (collection != null && !collection.isEmpty()) {
            return false;
        }
        return true;
    }

    public final boolean d(@Nullable Context c16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) c16)).booleanValue();
        }
        if (c16 != null) {
            try {
                Object systemService = c16.getSystemService("connectivity");
                if (systemService != null) {
                    NetworkInfo info = ((ConnectivityManager) systemService).getActiveNetworkInfo();
                    if (info != null) {
                        Intrinsics.checkExpressionValueIsNotNull(info, "info");
                        if (info.getState() != NetworkInfo.State.CONNECTED) {
                            return false;
                        }
                        return true;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager");
                }
            } catch (Throwable unused) {
                Unit unit = Unit.INSTANCE;
            }
        }
        return false;
    }

    public final boolean e(@Nullable View view, float x16, float y16, float xEnlarge, float yEnlarge, @Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, view, Float.valueOf(x16), Float.valueOf(y16), Float.valueOf(xEnlarge), Float.valueOf(yEnlarge), rootView)).booleanValue();
        }
        if (view == null) {
            return false;
        }
        float xInRootView = Utils.getXInRootView(view, rootView);
        float yInRootView = Utils.getYInRootView(view, rootView);
        RectF rectF = new RectF();
        rectF.left = xInRootView - xEnlarge;
        rectF.right = view.getWidth() + xInRootView + xEnlarge;
        rectF.top = yInRootView - yEnlarge;
        rectF.bottom = view.getHeight() + yInRootView + yEnlarge;
        b.f70218a.a("Utils", "isTouchInView xInRoot:" + xInRootView + ", yInRoot:" + yInRootView + ", rect:" + rectF);
        return rectF.contains((int) x16, (int) y16);
    }

    public final boolean f(@Nullable View view, float x16, float y16, @Nullable View rootView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, this, view, Float.valueOf(x16), Float.valueOf(y16), rootView)).booleanValue();
        }
        return e(view, x16, y16, 0.0f, 0.0f, rootView);
    }

    public final void g(@Nullable Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) runnable);
        } else {
            MosaicUtils.I(runnable);
        }
    }

    public final void h(@Nullable Runnable runnable, long delayMillis) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, runnable, Long.valueOf(delayMillis));
        } else {
            MosaicUtils.J(runnable, delayMillis);
        }
    }
}
