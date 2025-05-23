package androidx.cardview.widget;

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
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;

/* compiled from: P */
/* loaded from: classes.dex */
public class CardView extends FrameLayout {
    private static final int[] COLOR_BACKGROUND_ATTR = {R.attr.colorBackground};
    private static final CardViewImpl IMPL;
    private final CardViewDelegate mCardViewDelegate;
    private boolean mCompatPadding;
    final Rect mContentPadding;
    private boolean mPreventCornerOverlap;
    final Rect mShadowBounds;
    int mUserSetMinHeight;
    int mUserSetMinWidth;

    static {
        CardViewApi21Impl cardViewApi21Impl = new CardViewApi21Impl();
        IMPL = cardViewApi21Impl;
        cardViewApi21Impl.initStatic();
    }

    public CardView(@NonNull Context context) {
        this(context, null);
    }

    @NonNull
    public ColorStateList getCardBackgroundColor() {
        return IMPL.getBackgroundColor(this.mCardViewDelegate);
    }

    public float getCardElevation() {
        return IMPL.getElevation(this.mCardViewDelegate);
    }

    @Px
    public int getContentPaddingBottom() {
        return this.mContentPadding.bottom;
    }

    @Px
    public int getContentPaddingLeft() {
        return this.mContentPadding.left;
    }

    @Px
    public int getContentPaddingRight() {
        return this.mContentPadding.right;
    }

    @Px
    public int getContentPaddingTop() {
        return this.mContentPadding.top;
    }

    public float getMaxCardElevation() {
        return IMPL.getMaxElevation(this.mCardViewDelegate);
    }

    public boolean getPreventCornerOverlap() {
        return this.mPreventCornerOverlap;
    }

    public float getRadius() {
        return IMPL.getRadius(this.mCardViewDelegate);
    }

    public boolean getUseCompatPadding() {
        return this.mCompatPadding;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        if (!(IMPL instanceof CardViewApi21Impl)) {
            int mode = View.MeasureSpec.getMode(i3);
            if (mode == Integer.MIN_VALUE || mode == 1073741824) {
                i3 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.getMinWidth(this.mCardViewDelegate)), View.MeasureSpec.getSize(i3)), mode);
            }
            int mode2 = View.MeasureSpec.getMode(i16);
            if (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) {
                i16 = View.MeasureSpec.makeMeasureSpec(Math.max((int) Math.ceil(r0.getMinHeight(this.mCardViewDelegate)), View.MeasureSpec.getSize(i16)), mode2);
            }
            super.onMeasure(i3, i16);
            return;
        }
        super.onMeasure(i3, i16);
    }

    public void setCardBackgroundColor(@ColorInt int i3) {
        IMPL.setBackgroundColor(this.mCardViewDelegate, ColorStateList.valueOf(i3));
    }

    public void setCardElevation(float f16) {
        IMPL.setElevation(this.mCardViewDelegate, f16);
    }

    public void setContentPadding(@Px int i3, @Px int i16, @Px int i17, @Px int i18) {
        this.mContentPadding.set(i3, i16, i17, i18);
        IMPL.updatePadding(this.mCardViewDelegate);
    }

    public void setMaxCardElevation(float f16) {
        IMPL.setMaxElevation(this.mCardViewDelegate, f16);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i3) {
        this.mUserSetMinHeight = i3;
        super.setMinimumHeight(i3);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i3) {
        this.mUserSetMinWidth = i3;
        super.setMinimumWidth(i3);
    }

    public void setPreventCornerOverlap(boolean z16) {
        if (z16 != this.mPreventCornerOverlap) {
            this.mPreventCornerOverlap = z16;
            IMPL.onPreventCornerOverlapChanged(this.mCardViewDelegate);
        }
    }

    public void setRadius(float f16) {
        IMPL.setRadius(this.mCardViewDelegate, f16);
    }

    public void setUseCompatPadding(boolean z16) {
        if (this.mCompatPadding != z16) {
            this.mCompatPadding = z16;
            IMPL.onCompatPaddingChanged(this.mCardViewDelegate);
        }
    }

    public CardView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, com.tencent.mobileqq.R.attr.a4u);
    }

    public void setCardBackgroundColor(@Nullable ColorStateList colorStateList) {
        IMPL.setBackgroundColor(this.mCardViewDelegate, colorStateList);
    }

    public CardView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        int color;
        ColorStateList valueOf;
        Rect rect = new Rect();
        this.mContentPadding = rect;
        this.mShadowBounds = new Rect();
        CardViewDelegate cardViewDelegate = new CardViewDelegate() { // from class: androidx.cardview.widget.CardView.1
            private Drawable mCardBackground;

            @Override // androidx.cardview.widget.CardViewDelegate
            public Drawable getCardBackground() {
                return this.mCardBackground;
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public View getCardView() {
                return CardView.this;
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public boolean getPreventCornerOverlap() {
                return CardView.this.getPreventCornerOverlap();
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public boolean getUseCompatPadding() {
                return CardView.this.getUseCompatPadding();
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public void setCardBackground(Drawable drawable) {
                this.mCardBackground = drawable;
                CardView.this.setBackgroundDrawable(drawable);
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public void setMinWidthHeightInternal(int i16, int i17) {
                CardView cardView = CardView.this;
                if (i16 > cardView.mUserSetMinWidth) {
                    CardView.super.setMinimumWidth(i16);
                }
                CardView cardView2 = CardView.this;
                if (i17 > cardView2.mUserSetMinHeight) {
                    CardView.super.setMinimumHeight(i17);
                }
            }

            @Override // androidx.cardview.widget.CardViewDelegate
            public void setShadowPadding(int i16, int i17, int i18, int i19) {
                CardView.this.mShadowBounds.set(i16, i17, i18, i19);
                CardView cardView = CardView.this;
                Rect rect2 = cardView.mContentPadding;
                CardView.super.setPadding(i16 + rect2.left, i17 + rect2.top, i18 + rect2.right, i19 + rect2.bottom);
            }
        };
        this.mCardViewDelegate = cardViewDelegate;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.cardview.R.styleable.CardView, i3, com.tencent.mobileqq.R.style.f173388c1);
        int i16 = androidx.cardview.R.styleable.CardView_cardBackgroundColor;
        if (obtainStyledAttributes.hasValue(i16)) {
            valueOf = obtainStyledAttributes.getColorStateList(i16);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(COLOR_BACKGROUND_ATTR);
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
        float dimension = obtainStyledAttributes.getDimension(androidx.cardview.R.styleable.CardView_cardCornerRadius, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(androidx.cardview.R.styleable.CardView_cardElevation, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(androidx.cardview.R.styleable.CardView_cardMaxElevation, 0.0f);
        this.mCompatPadding = obtainStyledAttributes.getBoolean(androidx.cardview.R.styleable.CardView_cardUseCompatPadding, false);
        this.mPreventCornerOverlap = obtainStyledAttributes.getBoolean(androidx.cardview.R.styleable.CardView_cardPreventCornerOverlap, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPadding, 0);
        rect.left = obtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingLeft, dimensionPixelSize);
        rect.top = obtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingTop, dimensionPixelSize);
        rect.right = obtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingRight, dimensionPixelSize);
        rect.bottom = obtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_contentPaddingBottom, dimensionPixelSize);
        float f16 = dimension2 > dimension3 ? dimension2 : dimension3;
        this.mUserSetMinWidth = obtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_android_minWidth, 0);
        this.mUserSetMinHeight = obtainStyledAttributes.getDimensionPixelSize(androidx.cardview.R.styleable.CardView_android_minHeight, 0);
        obtainStyledAttributes.recycle();
        IMPL.initialize(cardViewDelegate, context, colorStateList, dimension, dimension2, f16);
    }

    @Override // android.view.View
    public void setPadding(int i3, int i16, int i17, int i18) {
    }

    @Override // android.view.View
    public void setPaddingRelative(int i3, int i16, int i17, int i18) {
    }
}
