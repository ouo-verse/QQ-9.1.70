package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.QAdUIKit.roundlayout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.QAdUIKit.roundlayout.RoundLayoutHelper;

/* compiled from: P */
/* loaded from: classes19.dex */
public class RoundRelativeLayout extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private RoundLayoutHelper f303753d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f303754e;

    public RoundRelativeLayout(Context context) {
        super(context);
        b(context, null);
    }

    private void b(Context context, AttributeSet attributeSet) {
        this.f303753d = new RoundLayoutHelper(context, attributeSet);
        Drawable drawable = this.f303754e;
        if (drawable != null) {
            setBackground(drawable);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
        int save = canvas.save();
        this.f303753d.b(this, canvas);
        try {
            super.dispatchDraw(canvas);
        } catch (Exception unused) {
        }
        canvas.restoreToCount(save);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        RoundLayoutHelper roundLayoutHelper = this.f303753d;
        if (roundLayoutHelper != null) {
            roundLayoutHelper.e(drawable);
            invalidate();
        } else {
            this.f303754e = drawable;
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(@ColorInt int i3) {
        setBackground(new ColorDrawable(i3));
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        setBackground(drawable);
    }

    @Override // android.view.View
    public void setBackgroundResource(@DrawableRes int i3) {
        setBackground(getResources().getDrawable(i3));
    }

    public void setRadius(int i3) {
        this.f303753d.f(i3);
    }

    public void setRadius(int i3, @RoundLayoutHelper.RadiusMode int i16) {
        this.f303753d.g(i3, i16);
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
    }

    public void setRadius(int i3, int i16, int i17, int i18) {
        this.f303753d.h(i3, i16, i17, i18);
    }

    public RoundRelativeLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        b(context, attributeSet);
    }
}
