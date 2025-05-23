package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import androidx.cardview.widget.RoundRectDrawableWithShadow;

/* compiled from: P */
/* loaded from: classes.dex */
class CardViewBaseImpl implements CardViewImpl {
    final RectF mCornerRect = new RectF();

    private RoundRectDrawableWithShadow createBackground(Context context, ColorStateList colorStateList, float f16, float f17, float f18) {
        return new RoundRectDrawableWithShadow(context.getResources(), colorStateList, f16, f17, f18);
    }

    private RoundRectDrawableWithShadow getShadowBackground(CardViewDelegate cardViewDelegate) {
        return (RoundRectDrawableWithShadow) cardViewDelegate.getCardBackground();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public ColorStateList getBackgroundColor(CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).getColor();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getElevation(CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).getShadowSize();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMaxElevation(CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).getMaxShadowSize();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMinHeight(CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).getMinHeight();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getMinWidth(CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).getMinWidth();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public float getRadius(CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).getCornerRadius();
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void initStatic() {
        RoundRectDrawableWithShadow.sRoundRectHelper = new RoundRectDrawableWithShadow.RoundRectHelper() { // from class: androidx.cardview.widget.CardViewBaseImpl.1
            @Override // androidx.cardview.widget.RoundRectDrawableWithShadow.RoundRectHelper
            public void drawRoundRect(Canvas canvas, RectF rectF, float f16, Paint paint) {
                float f17 = 2.0f * f16;
                float width = (rectF.width() - f17) - 1.0f;
                float height = (rectF.height() - f17) - 1.0f;
                if (f16 >= 1.0f) {
                    float f18 = f16 + 0.5f;
                    float f19 = -f18;
                    CardViewBaseImpl.this.mCornerRect.set(f19, f19, f18, f18);
                    int save = canvas.save();
                    canvas.translate(rectF.left + f18, rectF.top + f18);
                    canvas.drawArc(CardViewBaseImpl.this.mCornerRect, 180.0f, 90.0f, true, paint);
                    canvas.translate(width, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(CardViewBaseImpl.this.mCornerRect, 180.0f, 90.0f, true, paint);
                    canvas.translate(height, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(CardViewBaseImpl.this.mCornerRect, 180.0f, 90.0f, true, paint);
                    canvas.translate(width, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(CardViewBaseImpl.this.mCornerRect, 180.0f, 90.0f, true, paint);
                    canvas.restoreToCount(save);
                    float f26 = (rectF.left + f18) - 1.0f;
                    float f27 = rectF.top;
                    canvas.drawRect(f26, f27, (rectF.right - f18) + 1.0f, f27 + f18, paint);
                    float f28 = (rectF.left + f18) - 1.0f;
                    float f29 = rectF.bottom;
                    canvas.drawRect(f28, f29 - f18, (rectF.right - f18) + 1.0f, f29, paint);
                }
                canvas.drawRect(rectF.left, rectF.top + f16, rectF.right, rectF.bottom - f16, paint);
            }
        };
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void initialize(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f16, float f17, float f18) {
        RoundRectDrawableWithShadow createBackground = createBackground(context, colorStateList, f16, f17, f18);
        createBackground.setAddPaddingForCorners(cardViewDelegate.getPreventCornerOverlap());
        cardViewDelegate.setCardBackground(createBackground);
        updatePadding(cardViewDelegate);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void onPreventCornerOverlapChanged(CardViewDelegate cardViewDelegate) {
        getShadowBackground(cardViewDelegate).setAddPaddingForCorners(cardViewDelegate.getPreventCornerOverlap());
        updatePadding(cardViewDelegate);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setBackgroundColor(CardViewDelegate cardViewDelegate, @Nullable ColorStateList colorStateList) {
        getShadowBackground(cardViewDelegate).setColor(colorStateList);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setElevation(CardViewDelegate cardViewDelegate, float f16) {
        getShadowBackground(cardViewDelegate).setShadowSize(f16);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setMaxElevation(CardViewDelegate cardViewDelegate, float f16) {
        getShadowBackground(cardViewDelegate).setMaxShadowSize(f16);
        updatePadding(cardViewDelegate);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void setRadius(CardViewDelegate cardViewDelegate, float f16) {
        getShadowBackground(cardViewDelegate).setCornerRadius(f16);
        updatePadding(cardViewDelegate);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void updatePadding(CardViewDelegate cardViewDelegate) {
        Rect rect = new Rect();
        getShadowBackground(cardViewDelegate).getMaxShadowAndCornerPadding(rect);
        cardViewDelegate.setMinWidthHeightInternal((int) Math.ceil(getMinWidth(cardViewDelegate)), (int) Math.ceil(getMinHeight(cardViewDelegate)));
        cardViewDelegate.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // androidx.cardview.widget.CardViewImpl
    public void onCompatPaddingChanged(CardViewDelegate cardViewDelegate) {
    }
}
