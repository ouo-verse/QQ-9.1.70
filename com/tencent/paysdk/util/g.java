package com.tencent.paysdk.util;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0006\u0010\t\u001a\u00020\u0006J\u0006\u0010\n\u001a\u00020\u0006R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\rR\u0016\u0010\u000f\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/paysdk/util/g;", "", "Landroid/view/Display;", "a", "Landroid/view/WindowManager;", "f", "", "e", "c", "d", "b", "Landroid/view/Display;", "mDisplayDelay", "I", "mainActivityWidthPx", "mainActivityHeightPx", "<init>", "()V", "tencentvideo_pay_sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes22.dex */
public final class g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static Display mDisplayDelay;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static int mainActivityWidthPx;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static int mainActivityHeightPx;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final g f342100d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13326);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f342100d = new g();
        }
    }

    g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    private final Display a() {
        Display display = mDisplayDelay;
        if (display != null) {
            return display;
        }
        WindowManager f16 = f();
        if (f16 != null) {
            mDisplayDelay = f16.getDefaultDisplay();
        }
        return mDisplayDelay;
    }

    private final int c() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Context context = com.tencent.paysdk.a.f341941i.getContext();
        if (context != null) {
            Object systemService = context.getSystemService("window");
            if (systemService != null) {
                Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
                if (defaultDisplay != null) {
                    defaultDisplay.getMetrics(displayMetrics);
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
            }
        }
        return displayMetrics.heightPixels;
    }

    private final int e() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Context context = com.tencent.paysdk.a.f341941i.getContext();
        if (context != null) {
            Object systemService = context.getSystemService("window");
            if (systemService != null) {
                Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
                if (defaultDisplay != null) {
                    defaultDisplay.getMetrics(displayMetrics);
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
            }
        }
        return displayMetrics.widthPixels;
    }

    private final WindowManager f() {
        Object systemService = com.tencent.paysdk.a.f341941i.getContext().getSystemService("window");
        if (systemService != null) {
            return (WindowManager) systemService;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
    }

    public final int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        if (Build.VERSION.SDK_INT >= 24 && mainActivityWidthPx > 0) {
            int c16 = c();
            mainActivityHeightPx = c16;
            return c16;
        }
        Display a16 = a();
        if (a16 != null) {
            return a16.getHeight();
        }
        return 0;
    }

    public final int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return ((Integer) iPatchRedirector.redirect((short) 1, (Object) this)).intValue();
        }
        if (Build.VERSION.SDK_INT >= 24 && mainActivityWidthPx > 0) {
            int e16 = e();
            mainActivityWidthPx = e16;
            return e16;
        }
        Display a16 = a();
        if (a16 != null) {
            return a16.getWidth();
        }
        return 0;
    }
}
