package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QUIDrawableTextView extends AppCompatTextView {
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private boolean H;
    private int I;
    private int J;

    /* renamed from: h, reason: collision with root package name */
    private int f316119h;

    /* renamed from: i, reason: collision with root package name */
    private int f316120i;

    /* renamed from: m, reason: collision with root package name */
    private int f316121m;

    public QUIDrawableTextView(Context context) {
        this(context, null);
    }

    @SuppressLint({"CustomViewStyleable"})
    private void initView(Context context, AttributeSet attributeSet, int i3) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.C8);
        this.f316119h = obtainStyledAttributes.getDimensionPixelSize(jj2.b.G8, 0);
        this.f316120i = obtainStyledAttributes.getDimensionPixelSize(jj2.b.K8, 0);
        this.f316121m = obtainStyledAttributes.getDimensionPixelSize(jj2.b.I8, 0);
        this.C = obtainStyledAttributes.getDimensionPixelSize(jj2.b.E8, 0);
        this.D = obtainStyledAttributes.getDimensionPixelSize(jj2.b.F8, 0);
        this.E = obtainStyledAttributes.getDimensionPixelSize(jj2.b.J8, 0);
        this.F = obtainStyledAttributes.getDimensionPixelSize(jj2.b.H8, 0);
        this.G = obtainStyledAttributes.getDimensionPixelSize(jj2.b.D8, 0);
        this.H = obtainStyledAttributes.getBoolean(jj2.b.L8, false);
        obtainStyledAttributes.recycle();
    }

    private void setDrawable(Drawable drawable, int i3, int i16, int i17) {
        int lineHeight;
        int i18;
        int i19;
        if (i16 == 0) {
            i16 = drawable.getIntrinsicWidth();
        }
        if (i17 == 0) {
            i17 = drawable.getIntrinsicHeight();
        }
        int i26 = 0;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    lineHeight = 0;
                    i16 = 0;
                    i18 = 0;
                }
            } else {
                if (this.H) {
                    i19 = 0;
                } else {
                    i19 = ((-this.I) / 2) + (i16 / 2);
                }
                i16 += i19;
                i18 = i17 + 0;
                i26 = i19;
                lineHeight = 0;
            }
            drawable.setBounds(i26, lineHeight, i16, i18);
        }
        if (this.H) {
            lineHeight = 0;
        } else {
            lineHeight = (((-getLineCount()) * getLineHeight()) / 2) + (getLineHeight() / 2);
        }
        i18 = i17 + lineHeight;
        drawable.setBounds(i26, lineHeight, i16, i18);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        this.I = i3;
        this.J = i16;
        Drawable[] compoundDrawables = getCompoundDrawables();
        Drawable drawable = compoundDrawables[0];
        Drawable drawable2 = compoundDrawables[1];
        Drawable drawable3 = compoundDrawables[2];
        Drawable drawable4 = compoundDrawables[3];
        if (drawable != null) {
            setDrawable(drawable, 0, this.f316119h, this.D);
        }
        if (drawable2 != null) {
            setDrawable(drawable2, 1, this.f316120i, this.E);
        }
        if (drawable3 != null) {
            setDrawable(drawable3, 2, this.f316121m, this.F);
        }
        if (drawable4 != null) {
            setDrawable(drawable4, 3, this.C, this.G);
        }
        setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    public QUIDrawableTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QUIDrawableTextView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.H = false;
        initView(context, attributeSet, i3);
    }
}
