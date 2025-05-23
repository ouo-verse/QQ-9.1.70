package com.tencent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.util.LoadingUtil;

/* compiled from: P */
/* loaded from: classes27.dex */
public class LoadingView extends ImageView {
    static IPatchRedirector $redirector_;
    private boolean isAutoAdaptTheme;
    private int loadingType;

    public LoadingView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void init() {
        setImageDrawable(LoadingUtil.getLoadingDrawable(getContext(), this.loadingType));
        if (this.isAutoAdaptTheme) {
            adaptTheme();
        }
    }

    public void adaptTheme() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else if (QQTheme.isNowThemeIsNight()) {
            setImageDrawableByLoadingType(1);
        } else {
            setImageDrawableByLoadingType(2);
        }
    }

    public void setAutoAdaptTheme(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.isAutoAdaptTheme = z16;
        }
    }

    public void setImageDrawableByLoadingType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            setImageDrawable(LoadingUtil.getLoadingDrawable(getContext(), i3));
        }
    }

    public LoadingView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
    }

    public LoadingView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        this.isAutoAdaptTheme = true;
        this.loadingType = 2;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.K3);
            this.loadingType = obtainStyledAttributes.getInt(jj2.b.M3, 2);
            this.isAutoAdaptTheme = obtainStyledAttributes.getBoolean(jj2.b.L3, true);
            obtainStyledAttributes.recycle();
        }
        init();
    }
}
