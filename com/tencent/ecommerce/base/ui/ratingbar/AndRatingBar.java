package com.tencent.ecommerce.base.ui.ratingbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import com.tencent.mobileqq.R;
import dh0.c;
import ok0.b;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AndRatingBar extends RatingBar implements RatingBar.OnRatingBarChangeListener {
    private float C;
    private float D;
    private boolean E;
    private c F;
    private OnRatingChangeListener G;
    private float H;

    /* renamed from: d, reason: collision with root package name */
    private ColorStateList f101172d;

    /* renamed from: e, reason: collision with root package name */
    private ColorStateList f101173e;

    /* renamed from: f, reason: collision with root package name */
    private ColorStateList f101174f;

    /* renamed from: h, reason: collision with root package name */
    private int f101175h;

    /* renamed from: i, reason: collision with root package name */
    private int f101176i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f101177m;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface OnRatingChangeListener {
        void onRatingChanged(AndRatingBar andRatingBar, float f16, boolean z16);
    }

    public AndRatingBar(Context context) {
        this(context, null);
    }

    private void a(Context context, AttributeSet attributeSet, int i3) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, b.f423037a, i3, 0);
        this.E = obtainStyledAttributes.getBoolean(b.f423041e, false);
        int i16 = b.f423043g;
        if (obtainStyledAttributes.hasValue(i16)) {
            if (this.E) {
                this.f101174f = obtainStyledAttributes.getColorStateList(i16);
            } else {
                this.f101172d = obtainStyledAttributes.getColorStateList(i16);
            }
        }
        int i17 = b.f423046j;
        if (obtainStyledAttributes.hasValue(i17) && !this.E) {
            this.f101173e = obtainStyledAttributes.getColorStateList(i17);
        }
        int i18 = b.f423038b;
        if (obtainStyledAttributes.hasValue(i18)) {
            if (this.E) {
                this.f101172d = obtainStyledAttributes.getColorStateList(i18);
            } else {
                this.f101174f = obtainStyledAttributes.getColorStateList(i18);
            }
        }
        this.f101177m = obtainStyledAttributes.getBoolean(b.f423040d, false);
        this.C = obtainStyledAttributes.getFloat(b.f423042f, 1.0f);
        this.D = obtainStyledAttributes.getDimension(b.f423045i, 0.0f);
        this.f101175h = obtainStyledAttributes.getResourceId(b.f423044h, R.drawable.e7a);
        int i19 = b.f423039c;
        if (obtainStyledAttributes.hasValue(i19)) {
            this.f101176i = obtainStyledAttributes.getResourceId(i19, R.drawable.e7a);
        } else {
            this.f101176i = this.f101175h;
        }
        obtainStyledAttributes.recycle();
        c cVar = new c(new dh0.b(context, getNumStars(), this.f101176i, this.f101175h, this.f101174f, this.f101173e, this.f101172d, this.f101177m));
        this.F = cVar;
        setProgressDrawable(cVar);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        int measuredHeight = getMeasuredHeight();
        setMeasuredDimension(View.resolveSizeAndState(Math.round(measuredHeight * this.F.b() * getNumStars() * this.C) + ((int) ((getNumStars() - 1) * this.D)), i3, 0), measuredHeight);
    }

    @Override // android.widget.RatingBar.OnRatingBarChangeListener
    public void onRatingChanged(RatingBar ratingBar, float f16, boolean z16) {
        OnRatingChangeListener onRatingChangeListener = this.G;
        if (onRatingChangeListener != null && f16 != this.H) {
            if (this.E) {
                onRatingChangeListener.onRatingChanged(this, getNumStars() - f16, z16);
            } else {
                onRatingChangeListener.onRatingChanged(this, f16, z16);
            }
        }
        this.H = f16;
    }

    @Override // android.widget.RatingBar
    public void setNumStars(int i3) {
        super.setNumStars(i3);
        c cVar = this.F;
        if (cVar != null) {
            cVar.d(i3);
        }
    }

    public void setOnRatingChangeListener(OnRatingChangeListener onRatingChangeListener) {
        this.G = onRatingChangeListener;
        setOnRatingBarChangeListener(this);
    }

    @Override // android.widget.RatingBar
    public void setRating(float f16) {
        super.setRating(f16);
        if (this.E) {
            super.setRating(getNumStars() - getRating());
        }
    }

    public void setScaleFactor(float f16) {
        this.C = f16;
        requestLayout();
    }

    public void setStarSpacing(float f16) {
        this.D = f16;
        requestLayout();
    }

    public AndRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet, 0);
    }

    public AndRatingBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a(context, attributeSet, i3);
    }
}
