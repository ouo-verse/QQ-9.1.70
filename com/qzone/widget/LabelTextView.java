package com.qzone.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.widget.ThemeImageWrapper;

/* compiled from: P */
/* loaded from: classes37.dex */
public class LabelTextView extends TextView implements ThemeImageWrapper.DrawInterface {

    /* renamed from: d, reason: collision with root package name */
    protected ThemeImageWrapper f60416d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f60417e;

    public LabelTextView(Context context) {
        super(context);
        this.f60417e = false;
        a();
    }

    private void b() {
        ThemeImageWrapper themeImageWrapper = new ThemeImageWrapper();
        this.f60416d = themeImageWrapper;
        themeImageWrapper.setSupportMaskView(true);
        this.f60416d.setMaskShape(ThemeImageWrapper.MODE_OTHER);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        ThemeImageWrapper themeImageWrapper;
        if (this.f60417e && (themeImageWrapper = this.f60416d) != null) {
            themeImageWrapper.onDraw(canvas, this);
        } else {
            super.draw(canvas);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i16) {
        Drawable drawable;
        Drawable drawable2;
        super.onMeasure(i3, i16);
        int measuredWidth = getMeasuredWidth();
        CharSequence text = getText();
        int visibility = getVisibility();
        if (text != null) {
            float paddingLeft = getPaddingLeft() + getPaddingRight();
            String charSequence = text.toString();
            Paint paint = new Paint();
            paint.setTextSize(getTextSize());
            float measureText = paddingLeft + paint.measureText(charSequence);
            Drawable[] compoundDrawables = getCompoundDrawables();
            if (compoundDrawables != null) {
                if (compoundDrawables.length > 0 && (drawable2 = compoundDrawables[0]) != null && drawable2.getBounds() != null) {
                    measureText = measureText + drawable2.getBounds().width() + getCompoundDrawablePadding();
                }
                if (compoundDrawables.length > 2 && (drawable = compoundDrawables[2]) != null && drawable.getBounds() != null) {
                    measureText = measureText + drawable.getBounds().width() + getCompoundDrawablePadding();
                }
            }
            visibility = ((float) measuredWidth) < measureText ? 8 : 0;
        }
        if (getVisibility() != visibility) {
            setVisibility(visibility);
        }
    }

    public void setParam(int i3, int i16, float f16) {
        setTextColor(i16);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i3);
        gradientDrawable.setCornerRadius(f16);
        setBackgroundDrawable(gradientDrawable);
    }

    @Override // com.tencent.widget.ThemeImageWrapper.DrawInterface
    public void superOnDraw(Canvas canvas) {
        super.draw(canvas);
    }

    private void a() {
        setMaxLines(1);
        setGravity(17);
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.END);
        b();
    }

    public LabelTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f60417e = false;
        a();
    }

    public LabelTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f60417e = false;
        a();
    }
}
