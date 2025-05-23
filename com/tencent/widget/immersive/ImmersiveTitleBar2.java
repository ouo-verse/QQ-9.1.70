package com.tencent.widget.immersive;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ImmersiveTitleBar2 extends View {
    static IPatchRedirector $redirector_;
    public static boolean TRANSLUCENT_STATUS_BAR;
    public static boolean mNeedDrawStatus;
    private int mStatusBarHeight;
    public int mViewHeight;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42934);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            TRANSLUCENT_STATUS_BAR = true;
            mNeedDrawStatus = true;
        }
    }

    public ImmersiveTitleBar2(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            initUI(context);
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
    
        if (com.tencent.widget.immersive.ImmersiveUtils.isSupporImmersive() == 1) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void initUI(Context context) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("status", 2, "ImmersiveTitleBar initUI");
        }
        if (TRANSLUCENT_STATUS_BAR) {
            z16 = true;
        }
        z16 = false;
        mNeedDrawStatus = z16;
        int statusBarHeight = ImmersiveUtils.getStatusBarHeight(context);
        this.mStatusBarHeight = statusBarHeight;
        if (mNeedDrawStatus) {
            setCustomHeight(statusBarHeight);
        } else {
            setCustomHeight(0);
        }
        if (!QQTheme.isDefaultOrDIYTheme() && !QQTheme.isNowThemeIsNight()) {
            setBackgroundColor(getResources().getColor(R.color.skin_color_title_immersive_bar));
        } else {
            setBackgroundResource(R.drawable.qui_bg_nav_secondary);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(this.mViewHeight, 1073741824));
            setMeasuredDimension(getMeasuredWidth(), this.mViewHeight);
        }
    }

    public void resetBkColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            setBackgroundColor(i3);
        }
    }

    public void setCustomHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.mViewHeight = i3;
            requestLayout();
        }
    }

    public ImmersiveTitleBar2(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            initUI(context);
        } else {
            iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3));
        }
    }

    public ImmersiveTitleBar2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            initUI(context);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) attributeSet);
        }
    }
}
