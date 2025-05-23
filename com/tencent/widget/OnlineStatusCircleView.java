package com.tencent.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.onlinestatus.bu;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;

/* compiled from: P */
/* loaded from: classes27.dex */
public class OnlineStatusCircleView extends LinearLayout {
    static IPatchRedirector $redirector_;
    private ImageView mImageView;

    public OnlineStatusCircleView(Context context, int i3) {
        this(context, (AttributeSet) null, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, i3);
    }

    private void init(Context context, @Nullable AttributeSet attributeSet, float f16) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, bu.R2);
            f16 = obtainStyledAttributes.getInt(bu.S2, 16);
            obtainStyledAttributes.recycle();
        }
        if (f16 == 0.0f) {
            f16 = 16.0f;
        }
        this.mImageView = new ImageView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewUtils.dip2px(f16), ViewUtils.dip2px(f16));
        setGravity(17);
        addView(this.mImageView, layoutParams);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        Drawable background = getBackground();
        if (background == null) {
            background = ContextCompat.getDrawable(getContext(), R.drawable.f161899ky2);
        }
        if (background instanceof GradientDrawable) {
            GradientDrawable gradientDrawable = (GradientDrawable) background;
            gradientDrawable.setColor(i3);
            setBackgroundDrawable(gradientDrawable);
        }
    }

    public void setImageDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) drawable);
            return;
        }
        ImageView imageView = this.mImageView;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) scaleType);
        } else {
            this.mImageView.setScaleType(scaleType);
        }
    }

    public OnlineStatusCircleView(Context context, @Nullable AttributeSet attributeSet, float f16) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            init(context, attributeSet, f16);
        } else {
            iPatchRedirector.redirect((short) 2, this, context, attributeSet, Float.valueOf(f16));
        }
    }

    public OnlineStatusCircleView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0.0f);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) attributeSet);
    }

    public OnlineStatusCircleView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, this, context, attributeSet, Integer.valueOf(i3));
    }
}
