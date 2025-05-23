package com.tencent.gdtad.views.video.circle;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.utils.ViewUtils;
import p71.a;

/* loaded from: classes6.dex */
public class DonutProgress extends View {
    private static final String INSTANCE_BACKGROUND_COLOR = "inner_background_color";
    private static final String INSTANCE_FINISHED_STROKE_COLOR = "finished_stroke_color";
    private static final String INSTANCE_FINISHED_STROKE_WIDTH = "finished_stroke_width";
    private static final String INSTANCE_INNER_BOTTOM_TEXT = "inner_bottom_text";
    private static final String INSTANCE_INNER_BOTTOM_TEXT_COLOR = "inner_bottom_text_color";
    private static final String INSTANCE_INNER_BOTTOM_TEXT_SIZE = "inner_bottom_text_size";
    private static final String INSTANCE_INNER_DRAWABLE = "inner_drawable";
    private static final String INSTANCE_MAX = "max";
    private static final String INSTANCE_PREFIX = "prefix";
    private static final String INSTANCE_PROGRESS = "progress";
    private static final String INSTANCE_STARTING_DEGREE = "starting_degree";
    private static final String INSTANCE_STATE = "saved_instance";
    private static final String INSTANCE_SUFFIX = "suffix";
    private static final String INSTANCE_TEXT = "text";
    private static final String INSTANCE_TEXT_COLOR = "text_color";
    private static final String INSTANCE_TEXT_SIZE = "text_size";
    private static final String INSTANCE_UNFINISHED_STROKE_COLOR = "unfinished_stroke_color";
    private static final String INSTANCE_UNFINISHED_STROKE_WIDTH = "unfinished_stroke_width";
    private int attributeResourceId;

    @Nullable
    private Bitmap bitmap;
    private boolean clockWise;
    private final int defaultFinishedColor;
    private final int defaultInnerBackgroundColor;
    private final int defaultInnerBottomTextColor;
    private final float defaultInnerBottomTextSize;
    private final int defaultMax;
    private final int defaultStartingDegree;
    private final float defaultStrokeWidth;
    private final int defaultTextColor;
    private final float defaultTextSize;
    private final int defaultUnfinishedColor;

    @NonNull
    private RectF finishedOuterRect;
    private Paint finishedPaint;
    private int finishedStrokeColor;
    private float finishedStrokeWidth;
    private int innerBackgroundColor;

    @Nullable
    private String innerBottomText;
    private int innerBottomTextColor;
    private float innerBottomTextHeight;
    protected Paint innerBottomTextPaint;
    private float innerBottomTextSize;
    private Paint innerCirclePaint;
    private int max;
    private final int minSize;

    @Nullable
    private String prefixText;
    private float progress;
    private boolean showText;
    private int startingDegree;

    @Nullable
    private String suffixText;

    @Nullable
    private String text;
    private int textColor;
    protected Paint textPaint;
    private float textSize;

    @NonNull
    private RectF unfinishedOuterRect;
    private Paint unfinishedPaint;
    private int unfinishedStrokeColor;
    private float unfinishedStrokeWidth;

    public DonutProgress(@NonNull Context context) {
        this(context, null);
    }

    private float getProgressAngle() {
        return (getProgress() / this.max) * 360.0f;
    }

    private int measure(int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode != 1073741824) {
            int i16 = this.minSize;
            if (mode == Integer.MIN_VALUE) {
                return Math.min(i16, size);
            }
            return i16;
        }
        return size;
    }

    public int getAttributeResourceId() {
        return this.attributeResourceId;
    }

    public int getFinishedStrokeColor() {
        return this.finishedStrokeColor;
    }

    public float getFinishedStrokeWidth() {
        return this.finishedStrokeWidth;
    }

    public int getInnerBackgroundColor() {
        return this.innerBackgroundColor;
    }

    @Nullable
    public String getInnerBottomText() {
        return this.innerBottomText;
    }

    public int getInnerBottomTextColor() {
        return this.innerBottomTextColor;
    }

    public float getInnerBottomTextSize() {
        return this.innerBottomTextSize;
    }

    public int getMax() {
        return this.max;
    }

    @Nullable
    public String getPrefixText() {
        return this.prefixText;
    }

    public float getProgress() {
        return this.progress;
    }

    public int getStartingDegree() {
        return this.startingDegree;
    }

    @Nullable
    public String getSuffixText() {
        return this.suffixText;
    }

    @Nullable
    public String getText() {
        return this.text;
    }

    public int getTextColor() {
        return this.textColor;
    }

    public float getTextSize() {
        return this.textSize;
    }

    public int getUnfinishedStrokeColor() {
        return this.unfinishedStrokeColor;
    }

    public float getUnfinishedStrokeWidth() {
        return this.unfinishedStrokeWidth;
    }

    protected void initByAttributes(@NonNull TypedArray typedArray) {
        this.finishedStrokeColor = typedArray.getColor(a.E0, this.defaultFinishedColor);
        this.unfinishedStrokeColor = typedArray.getColor(a.S0, this.defaultUnfinishedColor);
        this.showText = typedArray.getBoolean(a.N0, true);
        this.attributeResourceId = typedArray.getResourceId(a.J0, 0);
        setMax(typedArray.getInt(a.K0, 100));
        setProgress(typedArray.getFloat(a.M0, 0.0f));
        this.finishedStrokeWidth = typedArray.getDimension(a.F0, this.defaultStrokeWidth);
        this.unfinishedStrokeWidth = typedArray.getDimension(a.T0, this.defaultStrokeWidth);
        if (this.showText) {
            int i3 = a.L0;
            if (typedArray.getString(i3) != null) {
                this.prefixText = typedArray.getString(i3);
            }
            int i16 = a.O0;
            if (typedArray.getString(i16) != null) {
                this.suffixText = typedArray.getString(i16);
            }
            int i17 = a.P0;
            if (typedArray.getString(i17) != null) {
                this.text = typedArray.getString(i17);
            }
            this.textColor = typedArray.getColor(a.Q0, this.defaultTextColor);
            this.textSize = typedArray.getDimension(a.R0, this.defaultTextSize);
            this.innerBottomTextSize = typedArray.getDimension(a.I0, this.defaultInnerBottomTextSize);
            this.innerBottomTextColor = typedArray.getColor(a.H0, this.defaultInnerBottomTextColor);
            this.innerBottomText = typedArray.getString(a.G0);
        }
        this.innerBottomTextSize = typedArray.getDimension(a.I0, this.defaultInnerBottomTextSize);
        this.innerBottomTextColor = typedArray.getColor(a.H0, this.defaultInnerBottomTextColor);
        this.innerBottomText = typedArray.getString(a.G0);
        this.startingDegree = typedArray.getInt(a.D0, 0);
        this.innerBackgroundColor = typedArray.getColor(a.C0, 0);
    }

    protected void initInnerBitmap(Context context) {
        int i3 = this.attributeResourceId;
        if (i3 != 0) {
            this.bitmap = Utils.getBitmap(context, i3);
        }
    }

    protected void initPainters() {
        if (this.showText) {
            TextPaint textPaint = new TextPaint();
            this.textPaint = textPaint;
            textPaint.setColor(this.textColor);
            this.textPaint.setTextSize(this.textSize);
            this.textPaint.setAntiAlias(true);
            TextPaint textPaint2 = new TextPaint();
            this.innerBottomTextPaint = textPaint2;
            textPaint2.setColor(this.innerBottomTextColor);
            this.innerBottomTextPaint.setTextSize(this.innerBottomTextSize);
            this.innerBottomTextPaint.setAntiAlias(true);
        }
        Paint paint = new Paint();
        this.finishedPaint = paint;
        paint.setColor(this.finishedStrokeColor);
        this.finishedPaint.setStyle(Paint.Style.STROKE);
        this.finishedPaint.setAntiAlias(true);
        this.finishedPaint.setStrokeWidth(this.finishedStrokeWidth);
        Paint paint2 = new Paint();
        this.unfinishedPaint = paint2;
        paint2.setColor(this.unfinishedStrokeColor);
        this.unfinishedPaint.setStyle(Paint.Style.STROKE);
        this.unfinishedPaint.setAntiAlias(true);
        this.unfinishedPaint.setStrokeWidth(this.unfinishedStrokeWidth);
        Paint paint3 = new Paint();
        this.innerCirclePaint = paint3;
        paint3.setColor(this.innerBackgroundColor);
        this.innerCirclePaint.setAntiAlias(true);
    }

    @Override // android.view.View
    public void invalidate() {
        initPainters();
        super.invalidate();
    }

    public boolean isClockWise() {
        return this.clockWise;
    }

    public boolean isShowText() {
        return this.showText;
    }

    @Override // android.view.View
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        float max = Math.max(this.finishedStrokeWidth, this.unfinishedStrokeWidth);
        this.finishedOuterRect.set(max, max, getWidth() - max, getHeight() - max);
        this.unfinishedOuterRect.set(max, max, getWidth() - max, getHeight() - max);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, ((getWidth() - Math.min(this.finishedStrokeWidth, this.unfinishedStrokeWidth)) + Math.abs(this.finishedStrokeWidth - this.unfinishedStrokeWidth)) / 2.0f, this.innerCirclePaint);
        if (!this.clockWise) {
            canvas.drawArc(this.finishedOuterRect, -(360.0f - getStartingDegree()), -getProgressAngle(), false, this.finishedPaint);
            canvas.drawArc(this.unfinishedOuterRect, (-(360.0f - getStartingDegree())) - getProgressAngle(), -(360.0f - getProgressAngle()), false, this.unfinishedPaint);
        } else {
            canvas.drawArc(this.finishedOuterRect, getStartingDegree(), getProgressAngle(), false, this.finishedPaint);
            canvas.drawArc(this.unfinishedOuterRect, getProgressAngle() + getStartingDegree(), 360.0f - getProgressAngle(), false, this.unfinishedPaint);
        }
        if (this.showText) {
            String str = this.text;
            if (str == null) {
                str = this.prefixText + this.progress + this.suffixText;
            }
            if (!TextUtils.isEmpty(str)) {
                canvas.drawText(str, (getWidth() - this.textPaint.measureText(str)) / 2.0f, (getWidth() - (this.textPaint.descent() + this.textPaint.ascent())) / 2.0f, this.textPaint);
            }
            if (!TextUtils.isEmpty(getInnerBottomText())) {
                this.innerBottomTextPaint.setTextSize(this.innerBottomTextSize);
                canvas.drawText(getInnerBottomText(), (getWidth() - this.innerBottomTextPaint.measureText(getInnerBottomText())) / 2.0f, (getHeight() - this.innerBottomTextHeight) - ((this.textPaint.descent() + this.textPaint.ascent()) / 2.0f), this.innerBottomTextPaint);
            }
        }
        Bitmap bitmap = this.bitmap;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, (getWidth() - this.bitmap.getWidth()) / 2.0f, (getHeight() - this.bitmap.getHeight()) / 2.0f, (Paint) null);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        setMeasuredDimension(measure(i3), measure(i16));
        this.innerBottomTextHeight = getHeight() - ((getHeight() * 3) / 4);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.textColor = bundle.getInt("text_color");
            this.textSize = bundle.getFloat("text_size");
            this.innerBottomTextSize = bundle.getFloat(INSTANCE_INNER_BOTTOM_TEXT_SIZE);
            this.innerBottomText = bundle.getString(INSTANCE_INNER_BOTTOM_TEXT);
            this.innerBottomTextColor = bundle.getInt(INSTANCE_INNER_BOTTOM_TEXT_COLOR);
            this.finishedStrokeColor = bundle.getInt(INSTANCE_FINISHED_STROKE_COLOR);
            this.unfinishedStrokeColor = bundle.getInt(INSTANCE_UNFINISHED_STROKE_COLOR);
            this.finishedStrokeWidth = bundle.getFloat(INSTANCE_FINISHED_STROKE_WIDTH);
            this.unfinishedStrokeWidth = bundle.getFloat(INSTANCE_UNFINISHED_STROKE_WIDTH);
            this.innerBackgroundColor = bundle.getInt(INSTANCE_BACKGROUND_COLOR);
            this.attributeResourceId = bundle.getInt(INSTANCE_INNER_DRAWABLE);
            initInnerBitmap();
            initPainters();
            setMax(bundle.getInt("max"));
            setStartingDegree(bundle.getInt(INSTANCE_STARTING_DEGREE));
            setProgress(bundle.getFloat("progress"));
            this.prefixText = bundle.getString(INSTANCE_PREFIX);
            this.suffixText = bundle.getString(INSTANCE_SUFFIX);
            this.text = bundle.getString("text");
            super.onRestoreInstanceState(bundle.getParcelable(INSTANCE_STATE));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(INSTANCE_STATE, super.onSaveInstanceState());
        bundle.putInt("text_color", getTextColor());
        bundle.putFloat("text_size", getTextSize());
        bundle.putFloat(INSTANCE_INNER_BOTTOM_TEXT_SIZE, getInnerBottomTextSize());
        bundle.putFloat(INSTANCE_INNER_BOTTOM_TEXT_COLOR, getInnerBottomTextColor());
        bundle.putString(INSTANCE_INNER_BOTTOM_TEXT, getInnerBottomText());
        bundle.putInt(INSTANCE_INNER_BOTTOM_TEXT_COLOR, getInnerBottomTextColor());
        bundle.putInt(INSTANCE_FINISHED_STROKE_COLOR, getFinishedStrokeColor());
        bundle.putInt(INSTANCE_UNFINISHED_STROKE_COLOR, getUnfinishedStrokeColor());
        bundle.putInt("max", getMax());
        bundle.putInt(INSTANCE_STARTING_DEGREE, getStartingDegree());
        bundle.putFloat("progress", getProgress());
        bundle.putString(INSTANCE_SUFFIX, getSuffixText());
        bundle.putString(INSTANCE_PREFIX, getPrefixText());
        bundle.putString("text", getText());
        bundle.putFloat(INSTANCE_FINISHED_STROKE_WIDTH, getFinishedStrokeWidth());
        bundle.putFloat(INSTANCE_UNFINISHED_STROKE_WIDTH, getUnfinishedStrokeWidth());
        bundle.putInt(INSTANCE_BACKGROUND_COLOR, getInnerBackgroundColor());
        bundle.putInt(INSTANCE_INNER_DRAWABLE, getAttributeResourceId());
        return bundle;
    }

    public void setAttributeResourceId(int i3) {
        this.attributeResourceId = i3;
        initInnerBitmap();
        invalidate();
    }

    public void setClockWise(boolean z16) {
        this.clockWise = z16;
    }

    public void setFinishedStrokeColor(int i3) {
        this.finishedStrokeColor = i3;
        invalidate();
    }

    public void setFinishedStrokeWidth(float f16) {
        this.finishedStrokeWidth = f16;
        invalidate();
    }

    public void setInnerBackgroundColor(int i3) {
        this.innerBackgroundColor = i3;
        invalidate();
    }

    public void setInnerBottomText(String str) {
        this.innerBottomText = str;
        invalidate();
    }

    public void setInnerBottomTextColor(int i3) {
        this.innerBottomTextColor = i3;
        invalidate();
    }

    public void setInnerBottomTextSize(float f16) {
        this.innerBottomTextSize = f16;
        invalidate();
    }

    public void setMax(int i3) {
        if (i3 > 0) {
            this.max = i3;
            invalidate();
        }
    }

    public void setPrefixText(String str) {
        this.prefixText = str;
        invalidate();
    }

    public void setProgress(float f16) {
        this.progress = f16;
        if (f16 > getMax()) {
            this.progress %= getMax();
        }
        invalidate();
    }

    public void setShowText(boolean z16) {
        this.showText = z16;
    }

    public void setStartingDegree(int i3) {
        this.startingDegree = i3;
        invalidate();
    }

    public void setSuffixText(String str) {
        this.suffixText = str;
        invalidate();
    }

    public void setText(String str) {
        this.text = str;
        invalidate();
    }

    public void setTextColor(int i3) {
        this.textColor = i3;
        invalidate();
    }

    public void setTextSize(float f16) {
        this.textSize = f16;
        invalidate();
    }

    public void setUnfinishedStrokeColor(int i3) {
        this.unfinishedStrokeColor = i3;
        invalidate();
    }

    public void setUnfinishedStrokeWidth(float f16) {
        this.unfinishedStrokeWidth = f16;
        invalidate();
    }

    public DonutProgress(@NonNull Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DonutProgress(@NonNull Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.finishedOuterRect = new RectF();
        this.unfinishedOuterRect = new RectF();
        this.attributeResourceId = 0;
        this.progress = 0.0f;
        this.prefixText = "";
        this.suffixText = "%";
        this.text = null;
        this.defaultFinishedColor = Color.rgb(66, 145, 241);
        this.defaultUnfinishedColor = Color.rgb(204, 204, 204);
        this.defaultTextColor = Color.rgb(66, 145, 241);
        this.defaultInnerBottomTextColor = Color.rgb(66, 145, 241);
        this.defaultInnerBackgroundColor = 0;
        this.defaultMax = 100;
        this.defaultStartingDegree = 0;
        this.defaultTextSize = ViewUtils.spToPx(18.0f);
        this.minSize = ViewUtils.dip2px(100.0f);
        this.defaultStrokeWidth = ViewUtils.dip2px(10.0f);
        this.defaultInnerBottomTextSize = ViewUtils.spToPx(18.0f);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, a.B0, i3, 0);
        initByAttributes(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        initInnerBitmap(context);
        initPainters();
    }

    protected void initInnerBitmap() {
        initInnerBitmap(getContext());
    }
}
