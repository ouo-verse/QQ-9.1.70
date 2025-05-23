package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.graphics.drawable.DrawableCompat;
import com.tencent.mapsdk.internal.by;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes.dex */
public class DrawerArrowDrawable extends Drawable {
    public static final int ARROW_DIRECTION_END = 3;
    public static final int ARROW_DIRECTION_LEFT = 0;
    public static final int ARROW_DIRECTION_RIGHT = 1;
    public static final int ARROW_DIRECTION_START = 2;
    private static final float ARROW_HEAD_ANGLE = (float) Math.toRadians(45.0d);
    private float mArrowHeadLength;
    private float mArrowShaftLength;
    private float mBarGap;
    private float mBarLength;
    private int mDirection;
    private float mMaxCutForBarSize;
    private final Paint mPaint;
    private final Path mPath;
    private float mProgress;
    private final int mSize;
    private boolean mSpin;
    private boolean mVerticalMirror;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* loaded from: classes.dex */
    public @interface ArrowDirection {
    }

    public DrawerArrowDrawable(Context context) {
        Paint paint = new Paint();
        this.mPaint = paint;
        this.mPath = new Path();
        this.mVerticalMirror = false;
        this.mDirection = 2;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.MITER);
        paint.setStrokeCap(Paint.Cap.BUTT);
        paint.setAntiAlias(true);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, R.styleable.DrawerArrowToggle, com.tencent.mobileqq.R.attr.acx, com.tencent.mobileqq.R.style.f245696w);
        setColor(obtainStyledAttributes.getColor(R.styleable.DrawerArrowToggle_color, 0));
        setBarThickness(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_thickness, 0.0f));
        setSpinEnabled(obtainStyledAttributes.getBoolean(R.styleable.DrawerArrowToggle_spinBars, true));
        setGapSize(Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_gapBetweenBars, 0.0f)));
        this.mSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DrawerArrowToggle_drawableSize, 0);
        this.mBarLength = Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_barLength, 0.0f));
        this.mArrowHeadLength = Math.round(obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowHeadLength, 0.0f));
        this.mArrowShaftLength = obtainStyledAttributes.getDimension(R.styleable.DrawerArrowToggle_arrowShaftLength, 0.0f);
        obtainStyledAttributes.recycle();
    }

    private static float lerp(float f16, float f17, float f18) {
        return f16 + ((f17 - f16) * f18);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float f16;
        float f17;
        int i3;
        Rect bounds = getBounds();
        int i16 = this.mDirection;
        boolean z16 = false;
        if (i16 != 0 && (i16 == 1 || (i16 == 3 ? DrawableCompat.getLayoutDirection(this) == 0 : DrawableCompat.getLayoutDirection(this) == 1))) {
            z16 = true;
        }
        float f18 = this.mArrowHeadLength;
        float lerp = lerp(this.mBarLength, (float) Math.sqrt(f18 * f18 * 2.0f), this.mProgress);
        float lerp2 = lerp(this.mBarLength, this.mArrowShaftLength, this.mProgress);
        float round = Math.round(lerp(0.0f, this.mMaxCutForBarSize, this.mProgress));
        float lerp3 = lerp(0.0f, ARROW_HEAD_ANGLE, this.mProgress);
        if (z16) {
            f16 = 0.0f;
        } else {
            f16 = -180.0f;
        }
        if (z16) {
            f17 = 180.0f;
        } else {
            f17 = 0.0f;
        }
        float lerp4 = lerp(f16, f17, this.mProgress);
        double d16 = lerp;
        double d17 = lerp3;
        boolean z17 = z16;
        float round2 = (float) Math.round(Math.cos(d17) * d16);
        float round3 = (float) Math.round(d16 * Math.sin(d17));
        this.mPath.rewind();
        float lerp5 = lerp(this.mBarGap + this.mPaint.getStrokeWidth(), -this.mMaxCutForBarSize, this.mProgress);
        float f19 = (-lerp2) / 2.0f;
        this.mPath.moveTo(f19 + round, 0.0f);
        this.mPath.rLineTo(lerp2 - (round * 2.0f), 0.0f);
        this.mPath.moveTo(f19, lerp5);
        this.mPath.rLineTo(round2, round3);
        this.mPath.moveTo(f19, -lerp5);
        this.mPath.rLineTo(round2, -round3);
        this.mPath.close();
        canvas.save();
        float strokeWidth = this.mPaint.getStrokeWidth();
        float height = bounds.height() - (3.0f * strokeWidth);
        canvas.translate(bounds.centerX(), ((((int) (height - (2.0f * r5))) / 4) * 2) + (strokeWidth * 1.5f) + this.mBarGap);
        if (this.mSpin) {
            if (this.mVerticalMirror ^ z17) {
                i3 = -1;
            } else {
                i3 = 1;
            }
            canvas.rotate(lerp4 * i3);
        } else if (z17) {
            canvas.rotate(180.0f);
        }
        canvas.drawPath(this.mPath, this.mPaint);
        canvas.restore();
    }

    public float getArrowHeadLength() {
        return this.mArrowHeadLength;
    }

    public float getArrowShaftLength() {
        return this.mArrowShaftLength;
    }

    public float getBarLength() {
        return this.mBarLength;
    }

    public float getBarThickness() {
        return this.mPaint.getStrokeWidth();
    }

    @ColorInt
    public int getColor() {
        return this.mPaint.getColor();
    }

    public int getDirection() {
        return this.mDirection;
    }

    public float getGapSize() {
        return this.mBarGap;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mSize;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mSize;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final Paint getPaint() {
        return this.mPaint;
    }

    @FloatRange(from = 0.0d, to = by.f147964a)
    public float getProgress() {
        return this.mProgress;
    }

    public boolean isSpinEnabled() {
        return this.mSpin;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        if (i3 != this.mPaint.getAlpha()) {
            this.mPaint.setAlpha(i3);
            invalidateSelf();
        }
    }

    public void setArrowHeadLength(float f16) {
        if (this.mArrowHeadLength != f16) {
            this.mArrowHeadLength = f16;
            invalidateSelf();
        }
    }

    public void setArrowShaftLength(float f16) {
        if (this.mArrowShaftLength != f16) {
            this.mArrowShaftLength = f16;
            invalidateSelf();
        }
    }

    public void setBarLength(float f16) {
        if (this.mBarLength != f16) {
            this.mBarLength = f16;
            invalidateSelf();
        }
    }

    public void setBarThickness(float f16) {
        if (this.mPaint.getStrokeWidth() != f16) {
            this.mPaint.setStrokeWidth(f16);
            this.mMaxCutForBarSize = (float) ((f16 / 2.0f) * Math.cos(ARROW_HEAD_ANGLE));
            invalidateSelf();
        }
    }

    public void setColor(@ColorInt int i3) {
        if (i3 != this.mPaint.getColor()) {
            this.mPaint.setColor(i3);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public void setDirection(int i3) {
        if (i3 != this.mDirection) {
            this.mDirection = i3;
            invalidateSelf();
        }
    }

    public void setGapSize(float f16) {
        if (f16 != this.mBarGap) {
            this.mBarGap = f16;
            invalidateSelf();
        }
    }

    public void setProgress(@FloatRange(from = 0.0d, to = 1.0d) float f16) {
        if (this.mProgress != f16) {
            this.mProgress = f16;
            invalidateSelf();
        }
    }

    public void setSpinEnabled(boolean z16) {
        if (this.mSpin != z16) {
            this.mSpin = z16;
            invalidateSelf();
        }
    }

    public void setVerticalMirror(boolean z16) {
        if (this.mVerticalMirror != z16) {
            this.mVerticalMirror = z16;
            invalidateSelf();
        }
    }
}
