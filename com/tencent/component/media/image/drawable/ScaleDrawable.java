package com.tencent.component.media.image.drawable;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.annotation.Public;
import com.tencent.component.media.image.drawable.DrawableContainer;

/* compiled from: P */
@Public
/* loaded from: classes5.dex */
public class ScaleDrawable extends DrawableContainer {
    private static final float PIVOT_DEFAULT_VALUE = 0.0f;
    private Matrix mDrawMatrix;
    private float mPivotXRate;
    private float mPivotYRate;
    private ScaleState mScaleState;
    private int mScaleType;
    private Rect mTmpRect;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class ScaleState extends DrawableContainer.ContainerState {
        ScaleState(Drawable drawable, ScaleDrawable scaleDrawable) {
            super(drawable, scaleDrawable);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new ScaleDrawable(this, null);
        }

        ScaleState(ScaleState scaleState, ScaleDrawable scaleDrawable, Resources resources) {
            super(scaleState, scaleDrawable, resources);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new ScaleDrawable(this, resources);
        }
    }

    /* compiled from: P */
    @Public
    /* loaded from: classes5.dex */
    public static class ScaleType {
        public static final int CENTER = 9;
        public static final int CROP_BY_PIVOT = 10;
        public static final int CROP_CENTER = 0;
        public static final int CROP_END = 2;
        public static final int CROP_START = 1;
        public static final int FIT_CENTER = 3;
        public static final int FIT_END = 5;
        public static final int FIT_START = 4;
        public static final int INVALID = -1;
        public static final int MATCH_WIDTH_BOTTOM = 7;
        public static final int MATCH_WIDTH_CENTER = 8;
        public static final int MATCH_WIDTH_TOP = 6;
    }

    public static void getMatrix(Matrix matrix, int i3, int i16, int i17, int i18, int i19, float f16, float f17) {
        float f18;
        float f19;
        float f26;
        float f27;
        float f28;
        float f29;
        float f36;
        float f37;
        float f38;
        float f39;
        float f46;
        float f47;
        float f48;
        float f49;
        float f56;
        if (i3 == -1) {
            if (matrix != null) {
                matrix.reset();
                return;
            }
            return;
        }
        if (matrix == null) {
            matrix = new Matrix();
        }
        float f57 = 0.0f;
        switch (i3) {
            case 0:
                if (i16 * i19 > i18 * i17) {
                    f18 = i19 / i17;
                    float f58 = (i18 - (i16 * f18)) * 0.5f;
                    f19 = 0.0f;
                    f57 = f58;
                } else {
                    f18 = i18 / i16;
                    f19 = (i19 - (i17 * f18)) * 0.5f;
                }
                matrix.setScale(f18, f18);
                matrix.postTranslate((int) (f57 + 0.5f), (int) (f19 + 0.5f));
                return;
            case 1:
                if (i16 * i19 > i18 * i17) {
                    f26 = i19;
                    f27 = i17;
                } else {
                    f26 = i18;
                    f27 = i16;
                }
                float f59 = f26 / f27;
                matrix.setScale(f59, f59);
                matrix.postTranslate((int) 0.5f, (int) 0.5f);
                return;
            case 2:
                if (i16 * i19 > i18 * i17) {
                    f28 = i19 / i17;
                    float f65 = (i18 - (i16 * f28)) * 1.0f;
                    f29 = 0.0f;
                    f57 = f65;
                } else {
                    f28 = i18 / i16;
                    f29 = (i19 - (i17 * f28)) * 1.0f;
                }
                matrix.setScale(f28, f28);
                matrix.postTranslate((int) (f57 + 0.5f), (int) (f29 + 0.5f));
                return;
            case 3:
                if (i16 * i19 > i18 * i17) {
                    f36 = i18 / i16;
                    f37 = (i19 - (i17 * f36)) * 0.5f;
                } else {
                    f36 = i19 / i17;
                    float f66 = (i18 - (i16 * f36)) * 0.5f;
                    f37 = 0.0f;
                    f57 = f66;
                }
                matrix.setScale(f36, f36);
                matrix.postTranslate((int) (f57 + 0.5f), (int) (f37 + 0.5f));
                return;
            case 4:
                if (i16 * i19 > i18 * i17) {
                    f38 = i18;
                    f39 = i16;
                } else {
                    f38 = i19;
                    f39 = i17;
                }
                float f67 = f38 / f39;
                matrix.setScale(f67, f67);
                matrix.postTranslate((int) 0.5f, (int) 0.5f);
                return;
            case 5:
                if (i16 * i19 > i18 * i17) {
                    f46 = i18 / i16;
                    f47 = (i19 - (i17 * f46)) * 1.0f;
                } else {
                    f46 = i19 / i17;
                    f47 = 0.0f;
                    f57 = (i18 - (i16 * f46)) * 1.0f;
                }
                matrix.setScale(f46, f46);
                matrix.postTranslate((int) (f57 + 0.5f), (int) (f47 + 0.5f));
                break;
            case 6:
                break;
            case 7:
                float f68 = i18 / i16;
                matrix.setScale(f68, f68);
                matrix.postTranslate((int) 0.5f, (int) (((i19 - (i17 * f68)) * 1.0f) + 0.5f));
                return;
            case 8:
                float f69 = i18 / i16;
                matrix.setScale(f69, f69);
                matrix.postTranslate((int) 0.5f, (int) (((i19 - (i17 * f69)) * 0.5f) + 0.5f));
                return;
            case 9:
                matrix.postTranslate((int) (((i18 - i16) * 0.5f) + 0.5f), (int) (((i19 - i17) * 0.5f) + 0.5f));
                return;
            case 10:
                if (i16 * i19 > i18 * i17) {
                    f48 = i19;
                    f49 = i17;
                } else {
                    f48 = i18;
                    f49 = i16;
                }
                float f75 = f48 / f49;
                float f76 = i18 * 0.5f;
                float f77 = i19 * 0.5f;
                int i26 = (int) (i16 * f75);
                int i27 = (int) (i17 * f75);
                float f78 = f16 * i26;
                float f79 = f17 * i27;
                if (i26 <= i18 || f78 <= f76) {
                    f56 = 0.0f;
                } else {
                    f56 = Math.min(i26 - i18, f78 - f76);
                }
                if (i27 > i19 && f79 > f77) {
                    f57 = Math.min(i27 - i19, f79 - f77);
                }
                matrix.setScale(f75, f75);
                matrix.postTranslate(((int) (f56 + 0.5f)) * (-1), ((int) (f57 + 0.5f)) * (-1));
                return;
            default:
                return;
        }
        float f85 = i18 / i16;
        matrix.setScale(f85, f85);
        float f86 = (int) 0.5f;
        matrix.postTranslate(f86, f86);
    }

    private void updateDrawMatrix() {
        if (this.mDrawMatrix == null) {
            this.mDrawMatrix = new Matrix();
        }
        getMatrix(this.mDrawMatrix, this.mScaleType, getIntrinsicWidth(), getIntrinsicHeight(), getBounds().width(), getBounds().height(), this.mPivotXRate, this.mPivotYRate);
    }

    @Override // com.tencent.component.media.image.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Matrix matrix = this.mDrawMatrix;
        if (matrix != null && !matrix.isIdentity()) {
            int saveCount = canvas.getSaveCount();
            canvas.save();
            canvas.concat(matrix);
            super.draw(canvas);
            canvas.restoreToCount(saveCount);
            return;
        }
        super.draw(canvas);
    }

    @Override // com.tencent.component.media.image.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.mScaleState.canConstantState()) {
            this.mScaleState.mChangingConfigurations = getChangingConfigurations();
            return this.mScaleState;
        }
        return null;
    }

    @Override // com.tencent.component.media.image.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return 0;
    }

    @Override // com.tencent.component.media.image.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.component.media.image.drawable.DrawableContainer, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        int intrinsicWidth = getIntrinsicWidth();
        int intrinsicHeight = getIntrinsicHeight();
        if (intrinsicWidth > 0 && intrinsicHeight > 0) {
            rect = this.mTmpRect;
            rect.set(0, 0, intrinsicWidth, intrinsicHeight);
        }
        super.onBoundsChange(rect);
        updateDrawMatrix();
    }

    @Public
    public void setPivot(float f16, float f17) {
        if (this.mPivotXRate != f16 || this.mPivotYRate != f17) {
            this.mPivotXRate = f16;
            this.mPivotYRate = f17;
            updateDrawMatrix();
        }
    }

    @Public
    public void setScaleType(int i3) {
        if (this.mScaleType != i3) {
            this.mScaleType = i3;
            updateDrawMatrix();
        }
    }

    @Public
    public ScaleDrawable(Drawable drawable) {
        this(drawable, -1);
    }

    @Public
    public ScaleDrawable(Drawable drawable, int i3) {
        this.mPivotXRate = 0.0f;
        this.mPivotYRate = 0.0f;
        this.mTmpRect = new Rect();
        ScaleState scaleState = new ScaleState(drawable, this);
        this.mScaleState = scaleState;
        setConstantState(scaleState);
        setScaleType(i3);
    }

    ScaleDrawable(ScaleState scaleState, Resources resources) {
        this.mPivotXRate = 0.0f;
        this.mPivotYRate = 0.0f;
        this.mTmpRect = new Rect();
        ScaleState scaleState2 = new ScaleState(scaleState, this, resources);
        this.mScaleState = scaleState2;
        setConstantState(scaleState2);
    }

    public Matrix getMatrix() {
        return this.mDrawMatrix;
    }
}
