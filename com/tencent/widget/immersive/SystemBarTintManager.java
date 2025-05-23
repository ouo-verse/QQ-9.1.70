package com.tencent.widget.immersive;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemProperties;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.util.VersionUtils;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SystemBarTintManager implements Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    public static final int DEFAULT_TINT_COLOR = 255;
    public static final int MSG_GONE = 2;
    public static final int MSG_INVISIBLE = 1;
    public static final int MSG_VISIBLE = 0;
    private static final String NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME = "navigation_bar_height_landscape";
    private static final String NAV_BAR_HEIGHT_RES_NAME = "navigation_bar_height";
    private static final String NAV_BAR_WIDTH_RES_NAME = "navigation_bar_width";
    private static final String SHOW_NAV_BAR_RES_NAME = "config_showNavigationBar";
    public static boolean mInPortrait;
    private static int mhasNavBar;
    private static String sNavBarOverride;
    private ColorFilter filter;
    private final SystemBarConfig mConfig;
    public Handler mHandler;
    private boolean mStatusBarAvailable;
    public boolean mStatusBarTintEnabled;
    public View mStatusBarTintView;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class SystemBarConfig {
        static IPatchRedirector $redirector_ = null;
        private static final String STATUS_BAR_HEIGHT_RES_NAME = "status_bar_height";
        private final boolean mInPortrait;
        private final int mStatusBarHeight;
        private final boolean mTranslucentStatusBar;

        SystemBarConfig(Window window, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, window, Boolean.valueOf(z16));
                return;
            }
            this.mInPortrait = window.getContext().getResources().getConfiguration().orientation == 1;
            this.mStatusBarHeight = ImmersiveUtils.getStatusBarHeight(window.getContext());
            this.mTranslucentStatusBar = z16;
        }

        @TargetApi(14)
        private int getActionBarHeight(Context context) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
            return TypedValue.complexToDimensionPixelSize(typedValue.data, context.getResources().getDisplayMetrics());
        }

        public int getStatusBarHeight() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.mStatusBarHeight;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42945);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
            return;
        }
        if (VersionUtils.isKITKAT()) {
            try {
                Method declaredMethod = SystemProperties.class.getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                sNavBarOverride = (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
                sNavBarOverride = null;
            }
        }
        mhasNavBar = -1;
    }

    @TargetApi(19)
    public SystemBarTintManager(Window window, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, window, Boolean.valueOf(z16));
            return;
        }
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            this.mStatusBarAvailable = z16;
        }
        this.mConfig = new SystemBarConfig(window, this.mStatusBarAvailable);
        if (this.mStatusBarAvailable) {
            setupStatusBarView(window, viewGroup);
        }
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        mInPortrait = window.getContext().getResources().getConfiguration().orientation == 1;
    }

    private static int getInternalDimensionSize(Resources resources, String str) {
        int identifier = resources.getIdentifier(str, "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private Drawable getMutateDrawable(Drawable drawable) {
        Drawable mutate;
        if (drawable instanceof SkinnableBitmapDrawable) {
            mutate = ((SkinnableBitmapDrawable) drawable).mutate2();
        } else {
            mutate = drawable.mutate();
        }
        mutate.setColorFilter(this.filter);
        return mutate;
    }

    @TargetApi(14)
    public static int getNavigationBarHeight(Context context) {
        String str;
        Resources resources = context.getResources();
        if (mInPortrait) {
            str = NAV_BAR_HEIGHT_RES_NAME;
        } else {
            str = NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME;
        }
        return getInternalDimensionSize(resources, str);
    }

    @TargetApi(14)
    public static boolean hasNavBar(Context context) {
        boolean z16;
        int i3 = mhasNavBar;
        if (i3 != -1) {
            if (i3 != 1) {
                return false;
            }
            return true;
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(SHOW_NAV_BAR_RES_NAME, "bool", "android");
        if (identifier != 0) {
            z16 = resources.getBoolean(identifier);
            if ("1".equals(sNavBarOverride)) {
                z16 = false;
            } else if ("0".equals(sNavBarOverride)) {
                z16 = true;
            }
        } else {
            z16 = !ViewConfiguration.get(context).hasPermanentMenuKey();
        }
        if (QLog.isColorLevel()) {
            QLog.d("XPanelContainer", 2, "hasNavbar=" + z16);
        }
        if (z16) {
            mhasNavBar = 1;
        } else {
            mhasNavBar = 0;
        }
        return z16;
    }

    public static void setLayerType(View view) {
        if (view == null) {
            return;
        }
        view.setLayerType(0, null);
    }

    private void setupStatusBarView(Window window, ViewGroup viewGroup) {
        this.mStatusBarTintView = new View(window.getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, this.mConfig.getStatusBarHeight());
        layoutParams.gravity = 48;
        this.mStatusBarTintView.setLayoutParams(layoutParams);
        try {
            setLayerType(this.mStatusBarTintView);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("setupStatusBarView", 2, e16.toString());
            }
        }
        this.mStatusBarTintView.setVisibility(8);
        viewGroup.addView(this.mStatusBarTintView);
    }

    public SystemBarConfig getConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (SystemBarConfig) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.mConfig;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) message)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("status", 2, "SystemBarTintManager=" + message.what);
        }
        View view = this.mStatusBarTintView;
        if (view == null) {
            return false;
        }
        int i3 = message.what;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    view.setVisibility(8);
                }
            } else {
                view.setVisibility(4);
            }
        } else {
            view.setVisibility(0);
        }
        return false;
    }

    public boolean isStatusBarTintEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.mStatusBarTintEnabled;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) colorFilter);
            return;
        }
        this.filter = colorFilter;
        Drawable background = this.mStatusBarTintView.getBackground();
        if (background != null) {
            this.mStatusBarTintView.setBackground(getMutateDrawable(background));
        }
    }

    @TargetApi(11)
    public void setStatusBarAlpha(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Float.valueOf(f16));
            return;
        }
        if (this.mStatusBarAvailable) {
            this.mStatusBarTintView.setAlpha(f16);
            return;
        }
        AlphaAnimation alphaAnimation = new AlphaAnimation(f16, f16);
        alphaAnimation.setDuration(0L);
        alphaAnimation.setFillAfter(true);
        this.mStatusBarTintView.startAnimation(alphaAnimation);
    }

    public void setStatusBarTintColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, i3);
            return;
        }
        if (this.mStatusBarAvailable) {
            this.mStatusBarTintView.setBackgroundColor(i3);
            Drawable background = this.mStatusBarTintView.getBackground();
            if (background != null && this.filter != null) {
                this.mStatusBarTintView.setBackground(getMutateDrawable(background));
            }
        }
    }

    public void setStatusBarTintDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) drawable);
            return;
        }
        if (this.mStatusBarAvailable) {
            this.mStatusBarTintView.setBackgroundDrawable(drawable);
            if (drawable != null && this.filter != null) {
                this.mStatusBarTintView.setBackground(getMutateDrawable(drawable));
            }
        }
    }

    public void setStatusBarTintEnabled(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SystemBarTintManager", 2, "setStatusBarTintEnabled enabled = " + z16);
        }
        this.mStatusBarTintEnabled = z16;
        if (this.mStatusBarAvailable) {
            View view = this.mStatusBarTintView;
            if (z16) {
                i3 = 0;
            } else {
                i3 = 4;
            }
            view.setVisibility(i3);
        }
    }

    public void setStatusBarTintResource(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
            return;
        }
        if (this.mStatusBarAvailable) {
            this.mStatusBarTintView.setBackgroundResource(i3);
            Drawable background = this.mStatusBarTintView.getBackground();
            if (background != null && this.filter != null) {
                this.mStatusBarTintView.setBackground(getMutateDrawable(background));
            }
        }
    }

    public void setStatusBarVisible(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("status", 2, "setStatusBarVisible=" + z16);
        }
        this.mStatusBarTintEnabled = z16;
        if (z16) {
            this.mHandler.sendEmptyMessageDelayed(0, i3);
        } else {
            this.mHandler.sendEmptyMessageDelayed(1, i3);
        }
    }

    public void setTintAlpha(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Float.valueOf(f16));
        } else {
            setStatusBarAlpha(f16);
        }
    }

    public void setTintColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            setStatusBarTintColor(i3);
        }
    }

    public void setTintDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) drawable);
        } else {
            setStatusBarTintDrawable(drawable);
        }
    }

    public void setTintResource(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            setStatusBarTintResource(i3);
        }
    }

    public void setStatusBarVisible(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("status", 2, "setStatusBarVisible=" + i3);
        }
        if (i3 == 0) {
            this.mStatusBarTintEnabled = true;
        } else {
            this.mStatusBarTintEnabled = false;
        }
        this.mHandler.sendEmptyMessageDelayed(i3, i16);
    }
}
