package com.tencent.biz.qqcircle.immersive.views;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import com.tencent.biz.qui.quibutton.QUIButton;

/* compiled from: P */
/* loaded from: classes4.dex */
public class RadiusChangeableQUIButton extends QUIButton {
    private int I;
    private int J;

    public RadiusChangeableQUIButton(Context context) {
        super(context);
        this.I = -1;
        this.J = 1000;
        z(context, null);
    }

    private StateListDrawable u(Context context, int i3, int i16, int i17, int i18) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, y(context, i3, i16, i17, i18));
        stateListDrawable.addState(new int[]{R.attr.state_selected}, y(context, i3, i16, i17, i18));
        stateListDrawable.addState(new int[]{-16842910}, w(context, i3, i16, i17, i18));
        stateListDrawable.addState(new int[0], v(context, i3, i16, i17, i18));
        return stateListDrawable;
    }

    private GradientDrawable v(Context context, int i3, int i16, int i17, int i18) {
        GradientDrawable b16 = ee0.b.g().b(context, i3, i16, i17);
        b16.setCornerRadius(i18);
        return b16;
    }

    private GradientDrawable w(Context context, int i3, int i16, int i17, int i18) {
        GradientDrawable c16 = ee0.b.g().c(context, i3, i16, i17);
        c16.setCornerRadius(i18);
        return c16;
    }

    private GradientDrawable y(Context context, int i3, int i16, int i17, int i18) {
        GradientDrawable d16 = ee0.b.g().d(context, i3, i16, i17);
        d16.setCornerRadius(i18);
        return d16;
    }

    private void z(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, y91.a.O7);
            this.I = obtainStyledAttributes.getDimensionPixelSize(y91.a.P7, -1);
            obtainStyledAttributes.recycle();
        }
        o();
    }

    @Override // com.tencent.biz.qui.quibutton.QUIButton
    public void o() {
        int i3 = this.I;
        if (i3 < 0) {
            i3 = ee0.b.g().e(getContext(), i());
        }
        setBackground(u(getContext(), j(), i(), this.J, i3));
        com.tencent.xaction.log.b.a("RadiusChangeableQUIButton", 4, "radius:" + i3);
    }

    public void setCustomRadius(int i3) {
        this.I = i3;
        o();
    }

    @Override // com.tencent.biz.qui.quibutton.QUIButton
    public void setThemeId(int i3) {
        super.setThemeId(i3);
        this.J = i3;
        o();
    }

    @Override // com.tencent.biz.qui.quibutton.QUIButton
    public void setType(int i3) {
        super.setType(i3);
        o();
    }

    public RadiusChangeableQUIButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.I = -1;
        this.J = 1000;
        z(context, attributeSet);
    }

    public RadiusChangeableQUIButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.I = -1;
        this.J = 1000;
        z(context, attributeSet);
    }
}
