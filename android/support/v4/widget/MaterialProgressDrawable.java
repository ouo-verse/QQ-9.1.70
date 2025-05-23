package android.support.v4.widget;

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
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MaterialProgressDrawable extends Drawable implements Animatable {
    private static final int ANIMATION_DURATION = 1332;
    private static final int ARROW_HEIGHT = 5;
    private static final int ARROW_HEIGHT_LARGE = 6;
    private static final float ARROW_OFFSET_ANGLE = 5.0f;
    private static final int ARROW_WIDTH = 10;
    private static final int ARROW_WIDTH_LARGE = 12;
    private static final float CENTER_RADIUS = 8.75f;
    private static final float CENTER_RADIUS_LARGE = 12.5f;
    private static final int CIRCLE_DIAMETER = 40;
    private static final int CIRCLE_DIAMETER_LARGE = 56;
    private static final float COLOR_START_DELAY_OFFSET = 0.75f;
    static final int DEFAULT = 1;
    private static final float END_TRIM_START_DELAY_OFFSET = 0.5f;
    private static final float FULL_ROTATION = 1080.0f;
    static final int LARGE = 0;
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    private static final Interpolator MATERIAL_INTERPOLATOR = new FastOutSlowInInterpolator();
    private static final float MAX_PROGRESS_ARC = 0.8f;
    private static final float NUM_POINTS = 5.0f;
    private static final float START_TRIM_DURATION_OFFSET = 0.5f;
    private static final float STROKE_WIDTH = 2.5f;
    private static final float STROKE_WIDTH_LARGE = 3.0f;
    private final int[] COLORS;
    private Animation mAnimation;
    private final ArrayList<Animation> mAnimators = new ArrayList<>();
    private final Drawable.Callback mCallback;
    boolean mFinishing;
    private double mHeight;
    private View mParent;
    private Resources mResources;
    private final Ring mRing;
    private float mRotation;
    private float mRotationCount;
    private double mWidth;

    /* loaded from: classes.dex */
    public @interface ProgressDrawableSize {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Ring {
        private int mAlpha;
        private Path mArrow;
        private int mArrowHeight;
        private final Paint mArrowPaint;
        private float mArrowScale;
        private int mArrowWidth;
        private int mBackgroundColor;
        private final Drawable.Callback mCallback;
        private final Paint mCirclePaint;
        private int mColorIndex;
        private int[] mColors;
        private int mCurrentColor;
        private float mEndTrim;
        private final Paint mPaint;
        private double mRingCenterRadius;
        private float mRotation;
        private boolean mShowArrow;
        private float mStartTrim;
        private float mStartingEndTrim;
        private float mStartingRotation;
        private float mStartingStartTrim;
        private float mStrokeInset;
        private float mStrokeWidth;
        private final RectF mTempBounds = new RectF();

        public Ring(Drawable.Callback callback) {
            Paint paint = new Paint();
            this.mPaint = paint;
            Paint paint2 = new Paint();
            this.mArrowPaint = paint2;
            this.mStartTrim = 0.0f;
            this.mEndTrim = 0.0f;
            this.mRotation = 0.0f;
            this.mStrokeWidth = 5.0f;
            this.mStrokeInset = MaterialProgressDrawable.STROKE_WIDTH;
            this.mCirclePaint = new Paint(1);
            this.mCallback = callback;
            paint.setStrokeCap(Paint.Cap.SQUARE);
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.STROKE);
            paint2.setStyle(Paint.Style.FILL);
            paint2.setAntiAlias(true);
        }

        private void drawTriangle(Canvas canvas, float f16, float f17, Rect rect) {
            if (this.mShowArrow) {
                Path path = this.mArrow;
                if (path == null) {
                    Path path2 = new Path();
                    this.mArrow = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float f18 = (((int) this.mStrokeInset) / 2) * this.mArrowScale;
                float cos = (float) ((this.mRingCenterRadius * Math.cos(0.0d)) + rect.exactCenterX());
                float sin = (float) ((this.mRingCenterRadius * Math.sin(0.0d)) + rect.exactCenterY());
                this.mArrow.moveTo(0.0f, 0.0f);
                this.mArrow.lineTo(this.mArrowWidth * this.mArrowScale, 0.0f);
                Path path3 = this.mArrow;
                float f19 = this.mArrowWidth;
                float f26 = this.mArrowScale;
                path3.lineTo((f19 * f26) / 2.0f, this.mArrowHeight * f26);
                this.mArrow.offset(cos - f18, sin);
                this.mArrow.close();
                this.mArrowPaint.setColor(this.mCurrentColor);
                canvas.rotate((f16 + f17) - 5.0f, rect.exactCenterX(), rect.exactCenterY());
                canvas.drawPath(this.mArrow, this.mArrowPaint);
            }
        }

        private int getNextColorIndex() {
            return (this.mColorIndex + 1) % this.mColors.length;
        }

        private void invalidateSelf() {
            this.mCallback.invalidateDrawable(null);
        }

        public void draw(Canvas canvas, Rect rect) {
            RectF rectF = this.mTempBounds;
            rectF.set(rect);
            float f16 = this.mStrokeInset;
            rectF.inset(f16, f16);
            float f17 = this.mStartTrim;
            float f18 = this.mRotation;
            float f19 = (f17 + f18) * 360.0f;
            float f26 = ((this.mEndTrim + f18) * 360.0f) - f19;
            this.mPaint.setColor(this.mCurrentColor);
            canvas.drawArc(rectF, f19, f26, false, this.mPaint);
            drawTriangle(canvas, f19, f26, rect);
            if (this.mAlpha < 255) {
                this.mCirclePaint.setColor(this.mBackgroundColor);
                this.mCirclePaint.setAlpha(255 - this.mAlpha);
                canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), rect.width() / 2, this.mCirclePaint);
            }
        }

        public int getAlpha() {
            return this.mAlpha;
        }

        public double getCenterRadius() {
            return this.mRingCenterRadius;
        }

        public float getEndTrim() {
            return this.mEndTrim;
        }

        public float getInsets() {
            return this.mStrokeInset;
        }

        public int getNextColor() {
            return this.mColors[getNextColorIndex()];
        }

        public float getRotation() {
            return this.mRotation;
        }

        public float getStartTrim() {
            return this.mStartTrim;
        }

        public int getStartingColor() {
            return this.mColors[this.mColorIndex];
        }

        public float getStartingEndTrim() {
            return this.mStartingEndTrim;
        }

        public float getStartingRotation() {
            return this.mStartingRotation;
        }

        public float getStartingStartTrim() {
            return this.mStartingStartTrim;
        }

        public float getStrokeWidth() {
            return this.mStrokeWidth;
        }

        public void goToNextColor() {
            setColorIndex(getNextColorIndex());
        }

        public void resetOriginals() {
            this.mStartingStartTrim = 0.0f;
            this.mStartingEndTrim = 0.0f;
            this.mStartingRotation = 0.0f;
            setStartTrim(0.0f);
            setEndTrim(0.0f);
            setRotation(0.0f);
        }

        public void setAlpha(int i3) {
            this.mAlpha = i3;
        }

        public void setArrowDimensions(float f16, float f17) {
            this.mArrowWidth = (int) f16;
            this.mArrowHeight = (int) f17;
        }

        public void setArrowScale(float f16) {
            if (f16 != this.mArrowScale) {
                this.mArrowScale = f16;
                invalidateSelf();
            }
        }

        public void setBackgroundColor(int i3) {
            this.mBackgroundColor = i3;
        }

        public void setCenterRadius(double d16) {
            this.mRingCenterRadius = d16;
        }

        public void setColor(int i3) {
            this.mCurrentColor = i3;
        }

        public void setColorFilter(ColorFilter colorFilter) {
            this.mPaint.setColorFilter(colorFilter);
            invalidateSelf();
        }

        public void setColorIndex(int i3) {
            this.mColorIndex = i3;
            this.mCurrentColor = this.mColors[i3];
        }

        public void setColors(int[] iArr) {
            this.mColors = iArr;
            setColorIndex(0);
        }

        public void setEndTrim(float f16) {
            this.mEndTrim = f16;
            invalidateSelf();
        }

        public void setInsets(int i3, int i16) {
            double ceil;
            float min = Math.min(i3, i16);
            double d16 = this.mRingCenterRadius;
            if (d16 > 0.0d && min >= 0.0f) {
                ceil = (min / 2.0f) - d16;
            } else {
                ceil = Math.ceil(this.mStrokeWidth / 2.0f);
            }
            this.mStrokeInset = (float) ceil;
        }

        public void setRotation(float f16) {
            this.mRotation = f16;
            invalidateSelf();
        }

        public void setShowArrow(boolean z16) {
            if (this.mShowArrow != z16) {
                this.mShowArrow = z16;
                invalidateSelf();
            }
        }

        public void setStartTrim(float f16) {
            this.mStartTrim = f16;
            invalidateSelf();
        }

        public void setStrokeWidth(float f16) {
            this.mStrokeWidth = f16;
            this.mPaint.setStrokeWidth(f16);
            invalidateSelf();
        }

        public void storeOriginals() {
            this.mStartingStartTrim = this.mStartTrim;
            this.mStartingEndTrim = this.mEndTrim;
            this.mStartingRotation = this.mRotation;
        }
    }

    public MaterialProgressDrawable(Context context, View view) {
        int[] iArr = {-16777216};
        this.COLORS = iArr;
        Drawable.Callback callback = new Drawable.Callback() { // from class: android.support.v4.widget.MaterialProgressDrawable.3
            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable drawable) {
                MaterialProgressDrawable.this.invalidateSelf();
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
                MaterialProgressDrawable.this.scheduleSelf(runnable, j3);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                MaterialProgressDrawable.this.unscheduleSelf(runnable);
            }
        };
        this.mCallback = callback;
        this.mParent = view;
        this.mResources = context.getResources();
        Ring ring = new Ring(callback);
        this.mRing = ring;
        ring.setColors(iArr);
        updateSizes(1);
        setupAnimators();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void applyFinishTranslation(float f16, Ring ring) {
        updateRingColor(f16, ring);
        float floor = (float) (Math.floor(ring.getStartingRotation() / 0.8f) + 1.0d);
        ring.setStartTrim(ring.getStartingStartTrim() + (((ring.getStartingEndTrim() - getMinProgressArc(ring)) - ring.getStartingStartTrim()) * f16));
        ring.setEndTrim(ring.getStartingEndTrim());
        ring.setRotation(ring.getStartingRotation() + ((floor - ring.getStartingRotation()) * f16));
    }

    private int evaluateColorChange(float f16, int i3, int i16) {
        int intValue = Integer.valueOf(i3).intValue();
        int i17 = (intValue >> 24) & 255;
        int i18 = (intValue >> 16) & 255;
        int i19 = (intValue >> 8) & 255;
        int i26 = intValue & 255;
        int intValue2 = Integer.valueOf(i16).intValue();
        return ((i17 + ((int) ((((intValue2 >> 24) & 255) - i17) * f16))) << 24) | ((i18 + ((int) ((((intValue2 >> 16) & 255) - i18) * f16))) << 16) | ((i19 + ((int) ((((intValue2 >> 8) & 255) - i19) * f16))) << 8) | (i26 + ((int) (f16 * ((intValue2 & 255) - i26))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getMinProgressArc(Ring ring) {
        return (float) Math.toRadians(ring.getStrokeWidth() / (ring.getCenterRadius() * 6.283185307179586d));
    }

    private float getRotation() {
        return this.mRotation;
    }

    private void setSizeParameters(double d16, double d17, double d18, double d19, float f16, float f17) {
        Ring ring = this.mRing;
        float f18 = this.mResources.getDisplayMetrics().density;
        double d26 = f18;
        this.mWidth = d16 * d26;
        this.mHeight = d17 * d26;
        ring.setStrokeWidth(((float) d19) * f18);
        ring.setCenterRadius(d18 * d26);
        ring.setColorIndex(0);
        ring.setArrowDimensions(f16 * f18, f17 * f18);
        ring.setInsets((int) this.mWidth, (int) this.mHeight);
    }

    private void setupAnimators() {
        final Ring ring = this.mRing;
        Animation animation = new Animation() { // from class: android.support.v4.widget.MaterialProgressDrawable.1
            @Override // android.view.animation.Animation
            public void applyTransformation(float f16, Transformation transformation) {
                MaterialProgressDrawable materialProgressDrawable = MaterialProgressDrawable.this;
                if (materialProgressDrawable.mFinishing) {
                    materialProgressDrawable.applyFinishTranslation(f16, ring);
                    return;
                }
                float minProgressArc = materialProgressDrawable.getMinProgressArc(ring);
                float startingEndTrim = ring.getStartingEndTrim();
                float startingStartTrim = ring.getStartingStartTrim();
                float startingRotation = ring.getStartingRotation();
                MaterialProgressDrawable.this.updateRingColor(f16, ring);
                if (f16 <= 0.5f) {
                    ring.setStartTrim(startingStartTrim + ((0.8f - minProgressArc) * MaterialProgressDrawable.MATERIAL_INTERPOLATOR.getInterpolation(f16 / 0.5f)));
                }
                if (f16 > 0.5f) {
                    ring.setEndTrim(startingEndTrim + ((0.8f - minProgressArc) * MaterialProgressDrawable.MATERIAL_INTERPOLATOR.getInterpolation((f16 - 0.5f) / 0.5f)));
                }
                ring.setRotation(startingRotation + (0.25f * f16));
                MaterialProgressDrawable.this.setRotation((f16 * 216.0f) + ((MaterialProgressDrawable.this.mRotationCount / 5.0f) * MaterialProgressDrawable.FULL_ROTATION));
            }
        };
        animation.setRepeatCount(-1);
        animation.setRepeatMode(1);
        animation.setInterpolator(LINEAR_INTERPOLATOR);
        animation.setAnimationListener(new Animation.AnimationListener() { // from class: android.support.v4.widget.MaterialProgressDrawable.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation2) {
                ring.storeOriginals();
                ring.goToNextColor();
                Ring ring2 = ring;
                ring2.setStartTrim(ring2.getEndTrim());
                MaterialProgressDrawable materialProgressDrawable = MaterialProgressDrawable.this;
                if (!materialProgressDrawable.mFinishing) {
                    materialProgressDrawable.mRotationCount = (materialProgressDrawable.mRotationCount + 1.0f) % 5.0f;
                    return;
                }
                materialProgressDrawable.mFinishing = false;
                animation2.setDuration(1332L);
                ring.setShowArrow(false);
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation2) {
                MaterialProgressDrawable.this.mRotationCount = 0.0f;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation2) {
            }
        });
        this.mAnimation = animation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateRingColor(float f16, Ring ring) {
        if (f16 > 0.75f) {
            ring.setColor(evaluateColorChange((f16 - 0.75f) / 0.25f, ring.getStartingColor(), ring.getNextColor()));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.mRotation, bounds.exactCenterX(), bounds.exactCenterY());
        this.mRing.draw(canvas, bounds);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mRing.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.mHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.mWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        ArrayList<Animation> arrayList = this.mAnimators;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            Animation animation = arrayList.get(i3);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.mRing.setAlpha(i3);
    }

    public void setArrowScale(float f16) {
        this.mRing.setArrowScale(f16);
    }

    public void setBackgroundColor(int i3) {
        this.mRing.setBackgroundColor(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mRing.setColorFilter(colorFilter);
    }

    public void setColorSchemeColors(int... iArr) {
        this.mRing.setColors(iArr);
        this.mRing.setColorIndex(0);
    }

    public void setProgressRotation(float f16) {
        this.mRing.setRotation(f16);
    }

    void setRotation(float f16) {
        this.mRotation = f16;
        invalidateSelf();
    }

    public void setStartEndTrim(float f16, float f17) {
        this.mRing.setStartTrim(f16);
        this.mRing.setEndTrim(f17);
    }

    public void showArrow(boolean z16) {
        this.mRing.setShowArrow(z16);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.mAnimation.reset();
        this.mRing.storeOriginals();
        if (this.mRing.getEndTrim() != this.mRing.getStartTrim()) {
            this.mFinishing = true;
            this.mAnimation.setDuration(666L);
            this.mParent.startAnimation(this.mAnimation);
        } else {
            this.mRing.setColorIndex(0);
            this.mRing.resetOriginals();
            this.mAnimation.setDuration(1332L);
            this.mParent.startAnimation(this.mAnimation);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.mParent.clearAnimation();
        setRotation(0.0f);
        this.mRing.setShowArrow(false);
        this.mRing.setColorIndex(0);
        this.mRing.resetOriginals();
    }

    public void updateSizes(@ProgressDrawableSize int i3) {
        if (i3 == 0) {
            setSizeParameters(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        } else {
            setSizeParameters(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
        }
    }
}
