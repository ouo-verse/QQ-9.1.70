package androidx.swiperefreshlayout.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class CircularProgressDrawable extends Drawable implements Animatable {
    private static final int ANIMATION_DURATION = 1332;
    private static final int ARROW_HEIGHT = 5;
    private static final int ARROW_HEIGHT_LARGE = 6;
    private static final int ARROW_WIDTH = 10;
    private static final int ARROW_WIDTH_LARGE = 12;
    private static final float CENTER_RADIUS = 7.5f;
    private static final float CENTER_RADIUS_LARGE = 11.0f;
    private static final float COLOR_CHANGE_OFFSET = 0.75f;
    public static final int DEFAULT = 1;
    private static final float GROUP_FULL_ROTATION = 216.0f;
    public static final int LARGE = 0;
    private static final float MAX_PROGRESS_ARC = 0.8f;
    private static final float MIN_PROGRESS_ARC = 0.01f;
    private static final float RING_ROTATION = 0.20999998f;
    private static final float SHRINK_OFFSET = 0.5f;
    private static final float STROKE_WIDTH = 2.5f;
    private static final float STROKE_WIDTH_LARGE = 3.0f;
    private Animator mAnimator;
    boolean mFinishing;
    private Resources mResources;
    private final Ring mRing;
    private float mRotation;
    float mRotationCount;
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private static final Interpolator MATERIAL_INTERPOLATOR = new FastOutSlowInInterpolator();
    private static final int[] COLORS = {-16777216};

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface ProgressDrawableSize {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Ring {
        int mAlpha;
        Path mArrow;
        int mArrowHeight;
        final Paint mArrowPaint;
        float mArrowScale;
        int mArrowWidth;
        final Paint mCirclePaint;
        int mColorIndex;
        int[] mColors;
        int mCurrentColor;
        float mEndTrim;
        final Paint mPaint;
        float mRingCenterRadius;
        float mRotation;
        boolean mShowArrow;
        float mStartTrim;
        float mStartingEndTrim;
        float mStartingRotation;
        float mStartingStartTrim;
        float mStrokeWidth;
        final RectF mTempBounds = new RectF();

        Ring() {
            Paint paint = new Paint();
            this.mPaint = paint;
            Paint paint2 = new Paint();
            this.mArrowPaint = paint2;
            Paint paint3 = new Paint();
            this.mCirclePaint = paint3;
            this.mStartTrim = 0.0f;
            this.mEndTrim = 0.0f;
            this.mRotation = 0.0f;
            this.mStrokeWidth = 5.0f;
            this.mArrowScale = 1.0f;
            this.mAlpha = 255;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
            paint3.setColor(0);
        }

        void draw(Canvas canvas, Rect rect) {
            RectF rectF = this.mTempBounds;
            float f16 = this.mRingCenterRadius;
            float f17 = (this.mStrokeWidth / 2.0f) + f16;
            if (f16 <= 0.0f) {
                f17 = (Math.min(rect.width(), rect.height()) / 2.0f) - Math.max((this.mArrowWidth * this.mArrowScale) / 2.0f, this.mStrokeWidth / 2.0f);
            }
            rectF.set(rect.centerX() - f17, rect.centerY() - f17, rect.centerX() + f17, rect.centerY() + f17);
            float f18 = this.mStartTrim;
            float f19 = this.mRotation;
            float f26 = (f18 + f19) * 360.0f;
            float f27 = ((this.mEndTrim + f19) * 360.0f) - f26;
            this.mPaint.setColor(this.mCurrentColor);
            this.mPaint.setAlpha(this.mAlpha);
            float f28 = this.mStrokeWidth / 2.0f;
            rectF.inset(f28, f28);
            canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, this.mCirclePaint);
            float f29 = -f28;
            rectF.inset(f29, f29);
            canvas.drawArc(rectF, f26, f27, false, this.mPaint);
            drawTriangle(canvas, f26, f27, rectF);
        }

        void drawTriangle(Canvas canvas, float f16, float f17, RectF rectF) {
            if (this.mShowArrow) {
                Path path = this.mArrow;
                if (path == null) {
                    Path path2 = new Path();
                    this.mArrow = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float min = Math.min(rectF.width(), rectF.height()) / 2.0f;
                float f18 = (this.mArrowWidth * this.mArrowScale) / 2.0f;
                this.mArrow.moveTo(0.0f, 0.0f);
                this.mArrow.lineTo(this.mArrowWidth * this.mArrowScale, 0.0f);
                Path path3 = this.mArrow;
                float f19 = this.mArrowWidth;
                float f26 = this.mArrowScale;
                path3.lineTo((f19 * f26) / 2.0f, this.mArrowHeight * f26);
                this.mArrow.offset((min + rectF.centerX()) - f18, rectF.centerY() + (this.mStrokeWidth / 2.0f));
                this.mArrow.close();
                this.mArrowPaint.setColor(this.mCurrentColor);
                this.mArrowPaint.setAlpha(this.mAlpha);
                canvas.save();
                canvas.rotate(f16 + f17, rectF.centerX(), rectF.centerY());
                canvas.drawPath(this.mArrow, this.mArrowPaint);
                canvas.restore();
            }
        }

        int getAlpha() {
            return this.mAlpha;
        }

        float getArrowHeight() {
            return this.mArrowHeight;
        }

        float getArrowScale() {
            return this.mArrowScale;
        }

        float getArrowWidth() {
            return this.mArrowWidth;
        }

        int getBackgroundColor() {
            return this.mCirclePaint.getColor();
        }

        float getCenterRadius() {
            return this.mRingCenterRadius;
        }

        int[] getColors() {
            return this.mColors;
        }

        float getEndTrim() {
            return this.mEndTrim;
        }

        int getNextColor() {
            return this.mColors[getNextColorIndex()];
        }

        int getNextColorIndex() {
            return (this.mColorIndex + 1) % this.mColors.length;
        }

        float getRotation() {
            return this.mRotation;
        }

        boolean getShowArrow() {
            return this.mShowArrow;
        }

        float getStartTrim() {
            return this.mStartTrim;
        }

        int getStartingColor() {
            return this.mColors[this.mColorIndex];
        }

        float getStartingEndTrim() {
            return this.mStartingEndTrim;
        }

        float getStartingRotation() {
            return this.mStartingRotation;
        }

        float getStartingStartTrim() {
            return this.mStartingStartTrim;
        }

        Paint.Cap getStrokeCap() {
            return this.mPaint.getStrokeCap();
        }

        float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        void goToNextColor() {
            setColorIndex(getNextColorIndex());
        }

        void resetOriginals() {
            this.mStartingStartTrim = 0.0f;
            this.mStartingEndTrim = 0.0f;
            this.mStartingRotation = 0.0f;
            setStartTrim(0.0f);
            setEndTrim(0.0f);
            setRotation(0.0f);
        }

        void setAlpha(int i3) {
            this.mAlpha = i3;
        }

        void setArrowDimensions(float f16, float f17) {
            this.mArrowWidth = (int) f16;
            this.mArrowHeight = (int) f17;
        }

        void setArrowScale(float f16) {
            if (f16 != this.mArrowScale) {
                this.mArrowScale = f16;
            }
        }

        void setBackgroundColor(int i3) {
            this.mCirclePaint.setColor(i3);
        }

        void setCenterRadius(float f16) {
            this.mRingCenterRadius = f16;
        }

        void setColor(int i3) {
            this.mCurrentColor = i3;
        }

        void setColorFilter(ColorFilter colorFilter) {
            this.mPaint.setColorFilter(colorFilter);
        }

        void setColorIndex(int i3) {
            this.mColorIndex = i3;
            this.mCurrentColor = this.mColors[i3];
        }

        void setColors(@NonNull int[] iArr) {
            this.mColors = iArr;
            setColorIndex(0);
        }

        void setEndTrim(float f16) {
            this.mEndTrim = f16;
        }

        void setRotation(float f16) {
            this.mRotation = f16;
        }

        void setShowArrow(boolean z16) {
            if (this.mShowArrow != z16) {
                this.mShowArrow = z16;
            }
        }

        void setStartTrim(float f16) {
            this.mStartTrim = f16;
        }

        void setStrokeCap(Paint.Cap cap) {
            this.mPaint.setStrokeCap(cap);
        }

        void setStrokeWidth(float f16) {
            this.mStrokeWidth = f16;
            this.mPaint.setStrokeWidth(f16);
        }

        void storeOriginals() {
            this.mStartingStartTrim = this.mStartTrim;
            this.mStartingEndTrim = this.mEndTrim;
            this.mStartingRotation = this.mRotation;
        }
    }

    public CircularProgressDrawable(@NonNull Context context) {
        this.mResources = ((Context) Preconditions.checkNotNull(context)).getResources();
        Ring ring = new Ring();
        this.mRing = ring;
        ring.setColors(COLORS);
        setStrokeWidth(STROKE_WIDTH);
        setupAnimators();
    }

    private void applyFinishTranslation(float f16, Ring ring) {
        updateRingColor(f16, ring);
        float floor = (float) (Math.floor(ring.getStartingRotation() / 0.8f) + 1.0d);
        ring.setStartTrim(ring.getStartingStartTrim() + (((ring.getStartingEndTrim() - 0.01f) - ring.getStartingStartTrim()) * f16));
        ring.setEndTrim(ring.getStartingEndTrim());
        ring.setRotation(ring.getStartingRotation() + ((floor - ring.getStartingRotation()) * f16));
    }

    private int evaluateColorChange(float f16, int i3, int i16) {
        return ((((i3 >> 24) & 255) + ((int) ((((i16 >> 24) & 255) - r0) * f16))) << 24) | ((((i3 >> 16) & 255) + ((int) ((((i16 >> 16) & 255) - r1) * f16))) << 16) | ((((i3 >> 8) & 255) + ((int) ((((i16 >> 8) & 255) - r2) * f16))) << 8) | ((i3 & 255) + ((int) (f16 * ((i16 & 255) - r8))));
    }

    private float getRotation() {
        return this.mRotation;
    }

    private void setRotation(float f16) {
        this.mRotation = f16;
    }

    private void setSizeParameters(float f16, float f17, float f18, float f19) {
        Ring ring = this.mRing;
        float f26 = this.mResources.getDisplayMetrics().density;
        ring.setStrokeWidth(f17 * f26);
        ring.setCenterRadius(f16 * f26);
        ring.setColorIndex(0);
        ring.setArrowDimensions(f18 * f26, f19 * f26);
    }

    private void setupAnimators() {
        final Ring ring = this.mRing;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: androidx.swiperefreshlayout.widget.CircularProgressDrawable.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                CircularProgressDrawable.this.updateRingColor(floatValue, ring);
                CircularProgressDrawable.this.applyTransformation(floatValue, ring, false);
                CircularProgressDrawable.this.invalidateSelf();
            }
        });
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(LINEAR_INTERPOLATOR);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: androidx.swiperefreshlayout.widget.CircularProgressDrawable.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                CircularProgressDrawable.this.applyTransformation(1.0f, ring, true);
                ring.storeOriginals();
                ring.goToNextColor();
                CircularProgressDrawable circularProgressDrawable = CircularProgressDrawable.this;
                if (circularProgressDrawable.mFinishing) {
                    circularProgressDrawable.mFinishing = false;
                    animator.cancel();
                    animator.setDuration(1332L);
                    animator.start();
                    ring.setShowArrow(false);
                    return;
                }
                circularProgressDrawable.mRotationCount += 1.0f;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                CircularProgressDrawable.this.mRotationCount = 0.0f;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }
        });
        this.mAnimator = ofFloat;
    }

    void applyTransformation(float f16, Ring ring, boolean z16) {
        float interpolation;
        float f17;
        if (this.mFinishing) {
            applyFinishTranslation(f16, ring);
            return;
        }
        if (f16 != 1.0f || z16) {
            float startingRotation = ring.getStartingRotation();
            if (f16 < 0.5f) {
                interpolation = ring.getStartingStartTrim();
                f17 = (MATERIAL_INTERPOLATOR.getInterpolation(f16 / 0.5f) * 0.79f) + 0.01f + interpolation;
            } else {
                float startingStartTrim = ring.getStartingStartTrim() + 0.79f;
                interpolation = startingStartTrim - (((1.0f - MATERIAL_INTERPOLATOR.getInterpolation((f16 - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
                f17 = startingStartTrim;
            }
            float f18 = startingRotation + (RING_ROTATION * f16);
            float f19 = (f16 + this.mRotationCount) * GROUP_FULL_ROTATION;
            ring.setStartTrim(interpolation);
            ring.setEndTrim(f17);
            ring.setRotation(f18);
            setRotation(f19);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.mRotation, bounds.exactCenterX(), bounds.exactCenterY());
        this.mRing.draw(canvas, bounds);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mRing.getAlpha();
    }

    public boolean getArrowEnabled() {
        return this.mRing.getShowArrow();
    }

    public float getArrowHeight() {
        return this.mRing.getArrowHeight();
    }

    public float getArrowScale() {
        return this.mRing.getArrowScale();
    }

    public float getArrowWidth() {
        return this.mRing.getArrowWidth();
    }

    public int getBackgroundColor() {
        return this.mRing.getBackgroundColor();
    }

    public float getCenterRadius() {
        return this.mRing.getCenterRadius();
    }

    @NonNull
    public int[] getColorSchemeColors() {
        return this.mRing.getColors();
    }

    public float getEndTrim() {
        return this.mRing.getEndTrim();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public float getProgressRotation() {
        return this.mRing.getRotation();
    }

    public float getStartTrim() {
        return this.mRing.getStartTrim();
    }

    @NonNull
    public Paint.Cap getStrokeCap() {
        return this.mRing.getStrokeCap();
    }

    public float getStrokeWidth() {
        return this.mRing.getStrokeWidth();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mAnimator.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.mRing.setAlpha(i3);
        invalidateSelf();
    }

    public void setArrowDimensions(float f16, float f17) {
        this.mRing.setArrowDimensions(f16, f17);
        invalidateSelf();
    }

    public void setArrowEnabled(boolean z16) {
        this.mRing.setShowArrow(z16);
        invalidateSelf();
    }

    public void setArrowScale(float f16) {
        this.mRing.setArrowScale(f16);
        invalidateSelf();
    }

    public void setBackgroundColor(int i3) {
        this.mRing.setBackgroundColor(i3);
        invalidateSelf();
    }

    public void setCenterRadius(float f16) {
        this.mRing.setCenterRadius(f16);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mRing.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setColorSchemeColors(@NonNull int... iArr) {
        this.mRing.setColors(iArr);
        this.mRing.setColorIndex(0);
        invalidateSelf();
    }

    public void setProgressRotation(float f16) {
        this.mRing.setRotation(f16);
        invalidateSelf();
    }

    public void setStartEndTrim(float f16, float f17) {
        this.mRing.setStartTrim(f16);
        this.mRing.setEndTrim(f17);
        invalidateSelf();
    }

    public void setStrokeCap(@NonNull Paint.Cap cap) {
        this.mRing.setStrokeCap(cap);
        invalidateSelf();
    }

    public void setStrokeWidth(float f16) {
        this.mRing.setStrokeWidth(f16);
        invalidateSelf();
    }

    public void setStyle(int i3) {
        if (i3 == 0) {
            setSizeParameters(CENTER_RADIUS_LARGE, 3.0f, 12.0f, 6.0f);
        } else {
            setSizeParameters(CENTER_RADIUS, STROKE_WIDTH, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.mAnimator.cancel();
        this.mRing.storeOriginals();
        if (this.mRing.getEndTrim() != this.mRing.getStartTrim()) {
            this.mFinishing = true;
            this.mAnimator.setDuration(666L);
            this.mAnimator.start();
        } else {
            this.mRing.setColorIndex(0);
            this.mRing.resetOriginals();
            this.mAnimator.setDuration(1332L);
            this.mAnimator.start();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.mAnimator.cancel();
        setRotation(0.0f);
        this.mRing.setShowArrow(false);
        this.mRing.setColorIndex(0);
        this.mRing.resetOriginals();
        invalidateSelf();
    }

    void updateRingColor(float f16, Ring ring) {
        if (f16 > 0.75f) {
            ring.setColor(evaluateColorChange((f16 - 0.75f) / 0.25f, ring.getStartingColor(), ring.getNextColor()));
        } else {
            ring.setColor(ring.getStartingColor());
        }
    }
}
