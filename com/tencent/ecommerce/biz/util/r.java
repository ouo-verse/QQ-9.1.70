package com.tencent.ecommerce.biz.util;

import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.Window;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\u0005J\u0016\u0010\u000e\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0002J\u0010\u0010\u000f\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\u0012\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010R\u0016\u0010\u0014\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/ecommerce/biz/util/r;", "", "Landroid/view/Window;", "", "flag", "", "d", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "isLight", "", "e", "isTextDarkMode", "window", "c", "a", "Landroid/content/res/Resources;", DKConfiguration.Directory.RESOURCES, "b", "I", "statusBarHeight", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static int statusBarHeight;

    /* renamed from: b, reason: collision with root package name */
    public static final r f104881b = new r();

    r() {
    }

    private final boolean d(Window window, int i3) {
        try {
            window.getDecorView().setSystemUiVisibility(i3);
            return true;
        } catch (Throwable th5) {
            cg0.a.a("ECStatusBarUtils", "setSystemUiVisibility", "failed, e=" + th5.getMessage());
            return false;
        }
    }

    public final int b(Resources resources) {
        Integer valueOf;
        if (statusBarHeight > 0) {
            cg0.a.b("ECStatusBarUtils", "[getStatusBarHeight] statusHeight = " + statusBarHeight);
            return statusBarHeight;
        }
        if (resources != null) {
            try {
                valueOf = Integer.valueOf(resources.getIdentifier("status_bar_height", "dimen", "android"));
            } catch (Resources.NotFoundException e16) {
                cg0.a.a("ECStatusBarUtils", "[getStatusBarHeight]", e16.toString());
            }
        } else {
            valueOf = null;
        }
        if (valueOf != null) {
            statusBarHeight = resources.getDimensionPixelSize(valueOf.intValue());
        }
        cg0.a.b("ECStatusBarUtils", "[getStatusBarHeight] statusHeight = " + statusBarHeight);
        return statusBarHeight;
    }

    public final boolean c(boolean isTextDarkMode, Window window) {
        int systemUiVisibility;
        if (w.c()) {
            return v.c(window, isTextDarkMode);
        }
        if (w.d()) {
            return v.b(window, isTextDarkMode);
        }
        if (isTextDarkMode) {
            systemUiVisibility = window.getDecorView().getSystemUiVisibility() | 8192;
        } else {
            systemUiVisibility = window.getDecorView().getSystemUiVisibility() & (-8193);
        }
        return d(window, systemUiVisibility);
    }

    public final int a(Activity activity) {
        return b(activity != null ? activity.getResources() : null);
    }

    public final void e(Activity activity, boolean isLight) {
        View decorView;
        View decorView2;
        View decorView3;
        View decorView4;
        Integer num = null;
        if ((activity != null ? activity.getWindow() : null) != null) {
            Window window = activity.getWindow();
            if ((window != null ? window.getDecorView() : null) == null) {
                return;
            }
            Window window2 = activity.getWindow();
            if (window2 != null) {
                window2.addFlags(Integer.MIN_VALUE);
            }
            if (isLight) {
                Window window3 = activity.getWindow();
                if (window3 != null) {
                    window3.setStatusBarColor(-1);
                }
                Window window4 = activity.getWindow();
                if (window4 == null || (decorView3 = window4.getDecorView()) == null) {
                    return;
                }
                Window window5 = activity.getWindow();
                if (window5 != null && (decorView4 = window5.getDecorView()) != null) {
                    num = Integer.valueOf(decorView4.getSystemUiVisibility());
                }
                Intrinsics.checkNotNull(num);
                decorView3.setSystemUiVisibility(num.intValue() | 8192);
                return;
            }
            Window window6 = activity.getWindow();
            if (window6 != null) {
                window6.setStatusBarColor(-16777216);
            }
            Window window7 = activity.getWindow();
            if (window7 == null || (decorView = window7.getDecorView()) == null) {
                return;
            }
            Window window8 = activity.getWindow();
            if (window8 != null && (decorView2 = window8.getDecorView()) != null) {
                num = Integer.valueOf(decorView2.getSystemUiVisibility());
            }
            Intrinsics.checkNotNull(num);
            decorView.setSystemUiVisibility(num.intValue() & (-8193));
        }
    }
}
