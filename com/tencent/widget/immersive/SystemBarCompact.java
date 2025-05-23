package com.tencent.widget.immersive;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.view.Window;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SystemBarCompact {
    static IPatchRedirector $redirector_;
    public boolean isStatusBarVisible;
    public boolean mDrawStatus;
    public boolean mInited;
    private int mPendingStatusBarColor;
    public int mStatusBarColor;
    public Drawable mStatusBarDarwable;
    private SystemBarTintManager mTintManager;
    private Window mWindow;

    public SystemBarCompact(Activity activity, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        this.mDrawStatus = true;
        this.mStatusBarColor = 0;
        this.isStatusBarVisible = true;
        this.mWindow = activity.getWindow();
        this.mDrawStatus = z16;
        this.mPendingStatusBarColor = i3;
    }

    private void ensureTintManager() {
        if (this.mTintManager == null) {
            this.mTintManager = new SystemBarTintManager(this.mWindow, this.mDrawStatus);
        }
    }

    @TargetApi(19)
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.mInited) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("systembar", 2, "mChatBarComp init()");
        }
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            ensureTintManager();
            this.mTintManager.setStatusBarTintEnabled(this.mDrawStatus);
        }
        Drawable drawable = this.mStatusBarDarwable;
        if (drawable != null) {
            setStatusBarDrawable(drawable);
        } else {
            setStatusBarColor(this.mPendingStatusBarColor);
        }
        this.isStatusBarVisible = true;
        this.mInited = true;
    }

    @TargetApi(19)
    public void setStatusBarColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        this.mStatusBarColor = i3;
        if (this.mTintManager != null && ImmersiveUtils.isSupporImmersive() == 1) {
            this.mTintManager.setStatusBarTintColor(i3);
        }
    }

    @TargetApi(19)
    public void setStatusBarDarkMode(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else if (ImmersiveUtils.supportStatusBarDarkMode()) {
            if (!QQTheme.isDefaultOrDIYTheme()) {
                z16 = false;
            }
            ImmersiveUtils.setStatusBarDarkMode(this.mWindow, z16);
        }
    }

    public void setStatusBarDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) drawable);
            return;
        }
        this.mStatusBarDarwable = drawable;
        if (this.mTintManager != null && ImmersiveUtils.isSupporImmersive() == 1) {
            this.mTintManager.setStatusBarTintDrawable(drawable);
        }
    }

    public void setStatusBarMask(ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) colorFilter);
        } else {
            this.mTintManager.setColorFilter(colorFilter);
        }
    }

    public void setStatusBarVisible(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("status", 2, "setStatusBarVisible=" + i3);
        }
        if (i3 == 0) {
            this.isStatusBarVisible = true;
        } else {
            this.isStatusBarVisible = false;
        }
        SystemBarTintManager systemBarTintManager = this.mTintManager;
        if (systemBarTintManager != null) {
            systemBarTintManager.setStatusBarVisible(i3, i16);
        }
    }

    public void setStatusColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.mPendingStatusBarColor = i3;
        }
    }

    public void setStatusDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) drawable);
        } else {
            this.mStatusBarDarwable = drawable;
        }
    }

    public void setgetStatusBarVisible(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("status", 2, "setgetStatusBarVisible=" + z16);
        }
        this.isStatusBarVisible = z16;
        SystemBarTintManager systemBarTintManager = this.mTintManager;
        if (systemBarTintManager != null) {
            systemBarTintManager.setStatusBarVisible(z16, i3);
        }
    }

    public SystemBarCompact(Dialog dialog, boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, dialog, Boolean.valueOf(z16), Integer.valueOf(i3));
            return;
        }
        this.mDrawStatus = true;
        this.mStatusBarColor = 0;
        this.isStatusBarVisible = true;
        this.mWindow = dialog.getWindow();
        this.mDrawStatus = z16;
        this.mPendingStatusBarColor = i3;
    }
}
