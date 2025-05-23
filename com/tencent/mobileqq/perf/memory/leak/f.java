package com.tencent.mobileqq.perf.memory.leak;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.perf.process.config.MainProcConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.argus.WindowCallbackWrapper;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J \u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/perf/memory/leak/f;", "", "Landroid/app/Activity;", "targetActivity", "", "e", "d", "", "windowFieldName", "g", "decorCaptionView", "fieldName", "f", "b", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f257774a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30406);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f257774a = new f();
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void c(WeakReference weakActivity, Ref.BooleanRef fixPhoneWindow, Ref.BooleanRef fixDecorCaptionWindow) {
        Intrinsics.checkNotNullParameter(weakActivity, "$weakActivity");
        Intrinsics.checkNotNullParameter(fixPhoneWindow, "$fixPhoneWindow");
        Intrinsics.checkNotNullParameter(fixDecorCaptionWindow, "$fixDecorCaptionWindow");
        Activity activity = (Activity) weakActivity.get();
        if (activity == null) {
            return;
        }
        try {
            if (fixPhoneWindow.element) {
                f257774a.e(activity);
            }
            if (fixDecorCaptionWindow.element) {
                f257774a.d(activity);
            }
        } catch (Exception e16) {
            com.tencent.mobileqq.perf.memory.util.b.b(com.tencent.mobileqq.perf.memory.util.b.f257791a, "PhoneWindowLeak", "fix fail", false, e16, 4, null);
        }
    }

    private final void d(Activity targetActivity) {
        View decorView;
        Object d16;
        Window window = targetActivity.getWindow();
        if (window != null && (decorView = window.getDecorView()) != null) {
            g gVar = g.f257775a;
            Object i3 = gVar.i(decorView, "mDecorCaptionView");
            if (i3 == null) {
                com.tencent.mobileqq.perf.memory.util.b.b(com.tencent.mobileqq.perf.memory.util.b.f257791a, "PhoneWindowLeak", "decorCaptionView is null", false, null, 12, null);
                return;
            }
            if (Intrinsics.areEqual(i3.getClass().getName(), "com.android.internal.widget.DecorCaptionView") || Intrinsics.areEqual(i3.getClass().getName(), "com.android.internal.widget.MiuiDecorCaptionView") || Intrinsics.areEqual(i3.getClass().getName(), "com.android.internal.widget.VivoDecorCaptionViewImpl") || Intrinsics.areEqual(i3.getClass().getName(), "com.android.internal.app.DecorCaptionViewWr")) {
                f(targetActivity, i3, "mContent");
                f(targetActivity, i3, "mOwner");
                f(targetActivity, i3, "mFocused");
                try {
                    Field g16 = g.g(gVar, "android.view.View", "mContext", false, 4, null);
                    h hVar = h.f257780a;
                    if (hVar.d(i3, g16) == targetActivity) {
                        hVar.i(i3, g16, null);
                    }
                } catch (Exception e16) {
                    com.tencent.mobileqq.perf.memory.util.b.b(com.tencent.mobileqq.perf.memory.util.b.f257791a, "PhoneWindowLeak_mContext2", "reset decorCaptionWindow context fail, " + e16.getMessage(), false, null, 12, null);
                }
            }
            if (Intrinsics.areEqual(i3.getClass().getName(), "com.android.internal.widget.MiuiDecorCaptionView")) {
                f(targetActivity, i3, "mBottomCaption");
            }
            if (Intrinsics.areEqual(i3.getClass().getName(), "com.android.internal.widget.VivoDecorCaptionViewImpl")) {
                try {
                    g gVar2 = g.f257775a;
                    Field f16 = g.f(gVar2, i3, "mButtonContainer", false, 4, null);
                    h hVar2 = h.f257780a;
                    Object d17 = hVar2.d(i3, f16);
                    if (d17 != null && (d16 = hVar2.d(d17, g.f(gVar2, d17, "context", false, 4, null))) != null && (d16 instanceof Context) && hVar2.a((Context) d16) == targetActivity) {
                        hVar2.i(i3, f16, null);
                        return;
                    }
                    return;
                } catch (Exception e17) {
                    com.tencent.mobileqq.perf.memory.util.b.b(com.tencent.mobileqq.perf.memory.util.b.f257791a, "PhoneWindowLeak_mButtonContainer", "reset VivoDecorCaptionViewImpl field fail, " + e17.getMessage(), false, null, 12, null);
                    return;
                }
            }
            return;
        }
        com.tencent.mobileqq.perf.memory.util.b.b(com.tencent.mobileqq.perf.memory.util.b.f257791a, "PhoneWindowLeak", "decorView is null", false, null, 12, null);
    }

    private final void e(Activity targetActivity) {
        if (targetActivity.getWindow() == null) {
            return;
        }
        ViewParent parent = targetActivity.getWindow().getDecorView().getParent();
        if (parent != null) {
            Object i3 = g.f257775a.i(parent, "mAdded");
            Intrinsics.checkNotNull(i3, "null cannot be cast to non-null type kotlin.Boolean");
            if (((Boolean) i3).booleanValue()) {
                QLog.w("PhoneWindowLeak", 1, "fixPhoneWindowMemoryLeak, viewRootImpl is added");
                return;
            }
        }
        g(targetActivity, "mContext");
        g(targetActivity, "mCallback");
        g(targetActivity, "mContentParent");
        g(targetActivity, "mActivityCallback");
        g(targetActivity, "mWindowControllerCallback");
        g(targetActivity, "mOnWindowDismissedCallback");
        QLog.w("PhoneWindowLeak", 1, "fixPhoneWindowMemoryLeak complete, " + targetActivity + ", " + parent);
    }

    private final void f(Activity targetActivity, Object decorCaptionView, String fieldName) {
        Field f16;
        try {
            if (Intrinsics.areEqual(fieldName, "mFocused")) {
                f16 = g.g(g.f257775a, "android.view.ViewGroup", fieldName, false, 4, null);
            } else {
                f16 = g.f(g.f257775a, decorCaptionView, fieldName, false, 4, null);
            }
            h hVar = h.f257780a;
            if (hVar.d(hVar.d(decorCaptionView, f16), g.g(g.f257775a, "android.view.View", "mContext", false, 4, null)) == targetActivity) {
                hVar.i(decorCaptionView, f16, null);
            }
        } catch (Exception e16) {
            com.tencent.mobileqq.perf.memory.util.b.b(com.tencent.mobileqq.perf.memory.util.b.f257791a, "PhoneWindowLeak_" + fieldName, "reset decorCaptionWindow field fail, " + e16.getMessage(), false, null, 12, null);
        }
    }

    private final void g(Activity targetActivity, String windowFieldName) {
        Field g16;
        try {
            Window window = targetActivity.getWindow();
            if (window == null) {
                return;
            }
            if (Intrinsics.areEqual(windowFieldName, "mContentParent")) {
                g16 = g.g(g.f257775a, "com.android.internal.policy.PhoneWindow", windowFieldName, false, 4, null);
            } else {
                g16 = g.g(g.f257775a, "android.view.Window", windowFieldName, false, 4, null);
            }
            h hVar = h.f257780a;
            Object d16 = hVar.d(window, g16);
            if (Intrinsics.areEqual(windowFieldName, "mCallback") && (d16 instanceof WindowCallbackWrapper)) {
                d16 = hVar.d(d16, g.f(g.f257775a, d16, "mCallback", false, 4, null));
            } else if (Intrinsics.areEqual(windowFieldName, "mContentParent") && (d16 instanceof View)) {
                Context context = ((View) d16).getContext();
                Intrinsics.checkNotNullExpressionValue(context, "targetObject.context");
                d16 = hVar.a(context);
            }
            if (d16 == targetActivity) {
                hVar.i(window, g16, null);
            }
        } catch (Exception e16) {
            com.tencent.mobileqq.perf.memory.util.b.b(com.tencent.mobileqq.perf.memory.util.b.f257791a, "PhoneWindowLeak_" + windowFieldName, "reset window field fail, " + e16.getMessage(), false, null, 12, null);
        }
    }

    public final void b(@NotNull Activity targetActivity) {
        boolean z16;
        long coerceAtLeast;
        boolean equals;
        boolean equals2;
        boolean z17;
        boolean equals3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) targetActivity);
            return;
        }
        Intrinsics.checkNotNullParameter(targetActivity, "targetActivity");
        MainProcConfig.Companion companion = MainProcConfig.INSTANCE;
        if (!companion.e().m()) {
            return;
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        boolean z18 = false;
        if (Build.VERSION.SDK_INT < 28) {
            String str = Build.MANUFACTURER;
            equals = StringsKt__StringsJVMKt.equals("xiaomi", str, true);
            booleanRef2.element = equals;
            equals2 = StringsKt__StringsJVMKt.equals("xiaomi", str, true);
            if (!equals2) {
                equals3 = StringsKt__StringsJVMKt.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI, str, true);
                if (!equals3) {
                    z17 = false;
                    booleanRef.element = z17;
                }
            }
            z17 = true;
            booleanRef.element = z17;
        }
        Pair<Boolean, Boolean> b16 = companion.b();
        if (!booleanRef.element && !b16.getFirst().booleanValue()) {
            z16 = false;
        } else {
            z16 = true;
        }
        booleanRef.element = z16;
        if (booleanRef2.element || b16.getSecond().booleanValue()) {
            z18 = true;
        }
        booleanRef2.element = z18;
        com.tencent.mobileqq.perf.memory.util.b.b(com.tencent.mobileqq.perf.memory.util.b.f257791a, "PhoneWindowLeak", "switch status, " + booleanRef.element + ", " + booleanRef2.element, false, null, 12, null);
        if (booleanRef.element || booleanRef2.element) {
            final WeakReference weakReference = new WeakReference(targetActivity);
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.perf.memory.leak.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.c(WeakReference.this, booleanRef, booleanRef2);
                }
            };
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(companion.e().F(), 30000L);
            uIHandlerV2.postDelayed(runnable, coerceAtLeast);
        }
    }
}
