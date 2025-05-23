package com.tencent.biz.richframework.compat;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.tencent.biz.richframework.delegate.impl.RFWLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWImmersiveUtils {

    /* compiled from: P */
    /* renamed from: com.tencent.biz.richframework.compat.RFWImmersiveUtils$1, reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Integer val$finalFitsHeight;
        final /* synthetic */ ViewGroup.LayoutParams val$finalLayoutParams;
        final /* synthetic */ int val$statusBarHeight;
        final /* synthetic */ View val$v;

        @Override // java.lang.Runnable
        public void run() {
            this.val$finalLayoutParams.height = (this.val$v.getHeight() + this.val$statusBarHeight) - this.val$finalFitsHeight.intValue();
            View view = this.val$v;
            view.setPadding(view.getPaddingLeft(), (this.val$v.getPaddingTop() + this.val$statusBarHeight) - this.val$finalFitsHeight.intValue(), this.val$v.getPaddingRight(), this.val$v.getPaddingBottom());
            this.val$v.setLayoutParams(this.val$finalLayoutParams);
        }
    }

    public static void addFlags(Window window, int i3) {
        WindowManager.LayoutParams attributes;
        if (window == null || (attributes = window.getAttributes()) == null) {
            return;
        }
        int i16 = attributes.flags;
        if (i16 != (((~i3) & i16) | (i3 & i3))) {
            window.addFlags(i3);
        }
    }

    public static void clearFlags(Window window, int i3) {
        WindowManager.LayoutParams attributes;
        if (window == null || (attributes = window.getAttributes()) == null) {
            return;
        }
        int i16 = attributes.flags;
        if (i16 != (((~i3) & i16) | (i3 & 0))) {
            window.clearFlags(i3);
        }
    }

    public static int getStatusBarHeight() {
        return ImmersiveUtils.getStatusBarHeight();
    }

    public static boolean isNavigationBarExist(Window window) {
        ViewGroup viewGroup;
        int id5;
        boolean z16;
        if (window.getDecorView() instanceof ViewGroup) {
            viewGroup = (ViewGroup) window.getDecorView();
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            RFWLog.e("RFWImmersiveUtils", RFWLog.USR, "isNavigationBarExist false decorView is not attach");
            return false;
        }
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            try {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt.getVisibility() == 0 && (id5 = childAt.getId()) != -1) {
                    if (id5 != 16908336 && !"navigationBarBackground".equals(viewGroup.getResources().getResourceEntryName(id5))) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (z16) {
                        return true;
                    }
                }
            } catch (Exception e16) {
                RFWLog.e("RFWImmersiveUtils", RFWLog.USR, "isNavigationBarExist error" + e16);
            }
        }
        return false;
    }

    public static boolean isStatusBarTextShow(Window window) {
        if ((window.getDecorView().getSystemUiVisibility() & 4) == 0) {
            return true;
        }
        return false;
    }

    public static void setImmersiveLayout(Window window, boolean z16) {
        int i3;
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        if (z16) {
            i3 = 512;
        } else {
            i3 = 1280;
        }
        window.getDecorView().setSystemUiVisibility(i3 | systemUiVisibility);
    }

    public static void setNavigationBarColor(Window window, int i3) {
        if (window == null) {
            return;
        }
        window.addFlags(Integer.MIN_VALUE);
        window.setNavigationBarColor(i3);
    }

    public static void setNavigationBarIconColor(Window window, boolean z16) {
        WindowInsetsControllerCompat insetsController;
        if (window != null && (insetsController = WindowCompat.getInsetsController(window, window.getDecorView())) != null) {
            insetsController.setAppearanceLightNavigationBars(z16);
        }
    }

    public static void setStatusBarColor(Window window, int i3) {
        if (window == null) {
            return;
        }
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(i3);
    }

    public static void setStatusBarTextColor(Window window, boolean z16) {
        WindowInsetsControllerCompat insetsController;
        if (window != null && (insetsController = WindowCompat.getInsetsController(window, window.getDecorView())) != null) {
            insetsController.setAppearanceLightStatusBars(z16);
        }
    }

    public static void setTransparentStatusBar(@NonNull Window window) {
        setStatusBarColor(window, 0);
    }

    @Deprecated
    public static int getStatusBarHeight(Context context) {
        return ImmersiveUtils.getStatusBarHeight(context);
    }
}
