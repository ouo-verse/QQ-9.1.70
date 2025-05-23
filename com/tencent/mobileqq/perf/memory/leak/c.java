package com.tencent.mobileqq.perf.memory.leak;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.hardware.display.DisplayManager;
import android.os.Build;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.perf.process.config.MainProcConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/perf/memory/leak/c;", "", "Landroid/app/Activity;", "targetActivity", "", "b", "a", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f257769a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30395);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f257769a = new c();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @SuppressLint({"PrivateApi", "DiscouragedPrivateApi"})
    private final void b(Activity targetActivity) {
        try {
            g gVar = g.f257775a;
            Method c16 = gVar.c("android.hardware.display.DisplayManagerGlobal", "getInstance");
            h hVar = h.f257780a;
            Object h16 = hVar.h(c16, null, new Object[0]);
            if (h16 == null) {
                return;
            }
            Object d16 = hVar.d(h16, g.f(gVar, h16, "mDisplayListeners", false, 4, null));
            Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type kotlin.collections.List<*>");
            Field g16 = g.g(gVar, "android.hardware.display.DisplayManagerGlobal$DisplayListenerDelegate", "mListener", false, 4, null);
            for (Object obj : (List) d16) {
                h hVar2 = h.f257780a;
                Object d17 = hVar2.d(obj, g16);
                if ((d17 instanceof DisplayManager.DisplayListener) && Intrinsics.areEqual(d17.getClass().getName(), "android.hardware.display.DisplayManager$1")) {
                    g gVar2 = g.f257775a;
                    Object d18 = hVar2.d(d17, g.f(gVar2, d17, "this$0", false, 4, null));
                    if ((d18 instanceof DisplayManager) && Intrinsics.areEqual(hVar2.d(d18, g.f(gVar2, d18, "mContext", false, 4, null)), targetActivity)) {
                        ((DisplayManager) d18).unregisterDisplayListener((DisplayManager.DisplayListener) d17);
                        QLog.d("DisplayManagerLeak", 1, "fix success");
                    }
                }
            }
        } catch (Throwable th5) {
            com.tencent.mobileqq.perf.memory.util.b.b(com.tencent.mobileqq.perf.memory.util.b.f257791a, "DisplayManagerLeak", "fix failed, " + th5.getMessage(), false, null, 12, null);
        }
    }

    public final void a(@NotNull Activity targetActivity) {
        boolean contains$default;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) targetActivity);
            return;
        }
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29 && i3 <= 33) {
            String MANUFACTURER = Build.MANUFACTURER;
            Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase = MANUFACTURER.toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO, false, 2, (Object) null);
            if (contains$default && MainProcConfig.INSTANCE.e().k()) {
                b(targetActivity);
            }
        }
    }
}
