package com.tencent.biz.qui.quishimmer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QUIShimmer {
    private static final float BASE_ALPHA_DEFAULT = 0.5f;
    private static final int COMPONENT_COUNT = 4;
    private static final float HIGH_ALPHA_DEFAULT = 0.3f;
    final int[] colors = new int[4];
    final float[] positions = new float[4];

    @ColorInt
    int highlightColor = Color.parseColor("#D7E7FF");

    @ColorInt
    int baseColor = Color.parseColor("#E0F3FF");
    int repeatCount = -1;
    final int repeatMode = 1;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class ColorHighlightBuilder extends Builder<ColorHighlightBuilder> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.qui.quishimmer.QUIShimmer.Builder
        public ColorHighlightBuilder getThis() {
            return this;
        }

        public ColorHighlightBuilder setBaseColor(@ColorInt int i3) {
            QUIShimmer qUIShimmer = this.mQUIShimmer;
            qUIShimmer.baseColor = (i3 & 16777215) | (qUIShimmer.baseColor & (-16777216));
            return getThis();
        }

        public ColorHighlightBuilder setHighlightColor(@ColorInt int i3) {
            QUIShimmer qUIShimmer = this.mQUIShimmer;
            qUIShimmer.highlightColor = (i3 & 16777215) | (qUIShimmer.highlightColor & (-16777216));
            return getThis();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.tencent.biz.qui.quishimmer.QUIShimmer.Builder
        public ColorHighlightBuilder consumeAttributes(TypedArray typedArray) {
            super.consumeAttributes(typedArray);
            int i3 = R.styleable.ShimmerFrameLayout_shimmer_base_color;
            if (typedArray.hasValue(i3)) {
                setBaseColor(typedArray.getColor(i3, this.mQUIShimmer.baseColor));
            }
            int i16 = R.styleable.ShimmerFrameLayout_shimmer_highlight_color;
            if (typedArray.hasValue(i16)) {
                setHighlightColor(typedArray.getColor(i16, this.mQUIShimmer.highlightColor));
            }
            return getThis();
        }
    }

    QUIShimmer() {
    }

    void restoreColors() {
        int[] iArr = this.colors;
        iArr[0] = 0;
        iArr[1] = this.highlightColor;
        iArr[2] = this.baseColor;
        iArr[3] = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public QUIShimmer updateColors(int i3, int i16, int i17, int i18) {
        int[] iArr = this.colors;
        iArr[0] = i3;
        iArr[1] = i16;
        iArr[2] = i17;
        iArr[3] = i18;
        return this;
    }

    void updatePositions() {
        float[] fArr = this.positions;
        fArr[0] = 0.605f;
        fArr[1] = 0.755f;
        fArr[2] = 0.83f;
        fArr[3] = 1.0f;
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static abstract class Builder<T extends Builder<T>> {
        final QUIShimmer mQUIShimmer = new QUIShimmer();

        private static float clamp(float f16, float f17, float f18) {
            return Math.min(f17, Math.max(f16, f18));
        }

        public QUIShimmer build() {
            this.mQUIShimmer.restoreColors();
            this.mQUIShimmer.updatePositions();
            return this.mQUIShimmer;
        }

        public T consumeAttributes(Context context, AttributeSet attributeSet) {
            return consumeAttributes(context.obtainStyledAttributes(attributeSet, R.styleable.ShimmerFrameLayout, 0, 0));
        }

        public T copyFrom(QUIShimmer qUIShimmer) {
            setRepeatCount(qUIShimmer.repeatCount);
            QUIShimmer qUIShimmer2 = this.mQUIShimmer;
            qUIShimmer2.baseColor = qUIShimmer.baseColor;
            qUIShimmer2.highlightColor = qUIShimmer.highlightColor;
            return getThis();
        }

        protected abstract T getThis();

        public T initAttributes() {
            setBaseAlpha(0.5f);
            setHighlightAlpha(0.3f);
            return getThis();
        }

        public T setBaseAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f16) {
            int clamp = (int) (clamp(0.0f, 1.0f, f16) * 255.0f);
            QUIShimmer qUIShimmer = this.mQUIShimmer;
            qUIShimmer.baseColor = (clamp << 24) | (qUIShimmer.baseColor & 16777215);
            return getThis();
        }

        public T setHighlightAlpha(@FloatRange(from = 0.0d, to = 1.0d) float f16) {
            int clamp = (int) (clamp(0.0f, 1.0f, f16) * 255.0f);
            QUIShimmer qUIShimmer = this.mQUIShimmer;
            qUIShimmer.highlightColor = (clamp << 24) | (qUIShimmer.highlightColor & 16777215);
            return getThis();
        }

        public T setRepeatCount(int i3) {
            this.mQUIShimmer.repeatCount = i3;
            return getThis();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public T consumeAttributes(TypedArray typedArray) {
            int i3 = R.styleable.ShimmerFrameLayout_shimmer_base_alpha;
            if (typedArray.hasValue(i3)) {
                setBaseAlpha(typedArray.getFloat(i3, 0.5f));
            } else {
                setBaseAlpha(0.5f);
            }
            int i16 = R.styleable.ShimmerFrameLayout_shimmer_highlight_alpha;
            if (typedArray.hasValue(i16)) {
                setHighlightAlpha(typedArray.getFloat(i16, 0.3f));
            } else {
                setHighlightAlpha(0.3f);
            }
            int i17 = R.styleable.ShimmerFrameLayout_shimmer_repeat_count;
            if (typedArray.hasValue(i17)) {
                setRepeatCount(typedArray.getInt(i17, this.mQUIShimmer.repeatCount));
            }
            return getThis();
        }
    }
}
