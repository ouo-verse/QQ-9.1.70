package com.qzone.widget.cardview;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

/* compiled from: P */
/* loaded from: classes37.dex */
public class CardView extends FrameLayout {
    private static final int[] D = {R.attr.colorBackground};
    private static final c E;
    private final b C;

    /* renamed from: d, reason: collision with root package name */
    private boolean f60710d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f60711e;

    /* renamed from: f, reason: collision with root package name */
    int f60712f;

    /* renamed from: h, reason: collision with root package name */
    int f60713h;

    /* renamed from: i, reason: collision with root package name */
    final Rect f60714i;

    /* renamed from: m, reason: collision with root package name */
    final Rect f60715m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements b {

        /* renamed from: a, reason: collision with root package name */
        private Drawable f60716a;

        a() {
        }

        @Override // com.qzone.widget.cardview.b
        public Drawable getCardBackground() {
            return this.f60716a;
        }

        @Override // com.qzone.widget.cardview.b
        public View getCardView() {
            return CardView.this;
        }

        @Override // com.qzone.widget.cardview.b
        public boolean getPreventCornerOverlap() {
            return CardView.this.b();
        }

        @Override // com.qzone.widget.cardview.b
        public boolean getUseCompatPadding() {
            return CardView.this.c();
        }

        @Override // com.qzone.widget.cardview.b
        public void setCardBackground(Drawable drawable) {
            this.f60716a = drawable;
            CardView.this.setBackgroundDrawable(drawable);
        }

        @Override // com.qzone.widget.cardview.b
        public void setShadowPadding(int i3, int i16, int i17, int i18) {
            CardView.this.f60715m.set(i3, i16, i17, i18);
            CardView cardView = CardView.this;
            Rect rect = cardView.f60714i;
            CardView.super.setPadding(i3 + rect.left, i16 + rect.top, i17 + rect.right, i18 + rect.bottom);
        }
    }

    public CardView(Context context) {
        super(context);
        this.f60714i = new Rect();
        this.f60715m = new Rect();
        this.C = new a();
        d(context, null, 0);
    }

    private void d(Context context, AttributeSet attributeSet, int i3) {
        int color;
        ColorStateList valueOf;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mobileqq.R.styleable.CardView, i3, com.tencent.mobileqq.R.style.f173388c1);
        try {
            if (obtainStyledAttributes.hasValue(2)) {
                valueOf = obtainStyledAttributes.getColorStateList(2);
            } else {
                TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(D);
                int color2 = obtainStyledAttributes2.getColor(0, 0);
                obtainStyledAttributes2.recycle();
                float[] fArr = new float[3];
                Color.colorToHSV(color2, fArr);
                if (fArr[2] > 0.5f) {
                    color = getResources().getColor(com.tencent.mobileqq.R.color.f156851d4);
                } else {
                    color = getResources().getColor(com.tencent.mobileqq.R.color.f156850d3);
                }
                valueOf = ColorStateList.valueOf(color);
            }
            ColorStateList colorStateList = valueOf;
            float dimension = obtainStyledAttributes.getDimension(3, 0.0f);
            float dimension2 = obtainStyledAttributes.getDimension(4, 0.0f);
            float dimension3 = obtainStyledAttributes.getDimension(5, 0.0f);
            this.f60710d = obtainStyledAttributes.getBoolean(7, false);
            this.f60711e = obtainStyledAttributes.getBoolean(6, true);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(8, 0);
            this.f60714i.left = obtainStyledAttributes.getDimensionPixelSize(10, dimensionPixelSize);
            this.f60714i.top = obtainStyledAttributes.getDimensionPixelSize(12, dimensionPixelSize);
            this.f60714i.right = obtainStyledAttributes.getDimensionPixelSize(11, dimensionPixelSize);
            this.f60714i.bottom = obtainStyledAttributes.getDimensionPixelSize(9, dimensionPixelSize);
            float f16 = dimension2 > dimension3 ? dimension2 : dimension3;
            this.f60712f = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            this.f60713h = obtainStyledAttributes.getDimensionPixelSize(1, 0);
            E.g(this.C, context, colorStateList, dimension, dimension2, f16);
        } finally {
            try {
            } finally {
            }
        }
    }

    public boolean b() {
        return this.f60711e;
    }

    public boolean c() {
        return this.f60710d;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        if (!(E instanceof com.qzone.widget.cardview.a)) {
            int mode = View.MeasureSpec.getMode(i3);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i3 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.h(this.C)), View.MeasureSpec.getSize(i3)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i16);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i16 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.e(this.C)), View.MeasureSpec.getSize(i16)), mode2);
            }
            super.onMeasure(i3, i16);
            return;
        }
        super.onMeasure(i3, i16);
    }

    public void setCardBackgroundColor(int i3) {
        E.c(this.C, ColorStateList.valueOf(i3));
    }

    public void setCardElevation(float f16) {
        E.f(this.C, f16);
    }

    public void setContentPadding(int i3, int i16, int i17, int i18) {
        this.f60714i.set(i3, i16, i17, i18);
        E.j(this.C);
    }

    public void setMaxCardElevation(float f16) {
        E.a(this.C, f16);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i3) {
        this.f60713h = i3;
        super.setMinimumHeight(i3);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i3) {
        this.f60712f = i3;
        super.setMinimumWidth(i3);
    }

    public void setPreventCornerOverlap(boolean z16) {
        if (z16 != this.f60711e) {
            this.f60711e = z16;
            E.d(this.C);
        }
    }

    public void setRadius(float f16) {
        E.i(this.C, f16);
    }

    public void setUseCompatPadding(boolean z16) {
        if (this.f60710d != z16) {
            this.f60710d = z16;
            E.b(this.C);
        }
    }

    static {
        com.qzone.widget.cardview.a aVar = new com.qzone.widget.cardview.a();
        E = aVar;
        aVar.initStatic();
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        E.c(this.C, colorStateList);
    }

    public CardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f60714i = new Rect();
        this.f60715m = new Rect();
        this.C = new a();
        d(context, attributeSet, 0);
    }

    public CardView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f60714i = new Rect();
        this.f60715m = new Rect();
        this.C = new a();
        d(context, attributeSet, i3);
    }

    @Override // android.view.View
    public void setPadding(int i3, int i16, int i17, int i18) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i3, int i16, int i17, int i18) {
    }
}
