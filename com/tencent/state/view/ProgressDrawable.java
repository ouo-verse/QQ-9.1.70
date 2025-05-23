package com.tencent.state.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.luggage.wxa.c8.c;
import com.tencent.state.view.ProgressDrawable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 ;2\u00020\u0001:\u0003;<=B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010!\u001a\u00020\u0017H\u0002J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010'\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010(\u001a\u00020\u0014H\u0016J\u0006\u0010)\u001a\u00020#J\b\u0010*\u001a\u00020#H\u0002J\u0010\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\u0014H\u0016J\u0012\u0010-\u001a\u00020#2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0010\u00100\u001a\u00020#2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u000e\u00101\u001a\u00020#2\u0006\u00102\u001a\u00020\u0012J\u000e\u00103\u001a\u00020#2\u0006\u00102\u001a\u00020\u0017J\u000e\u00104\u001a\u00020#2\u0006\u00102\u001a\u00020\u0010J\u000e\u00105\u001a\u00020#2\u0006\u0010 \u001a\u00020\u001dJ\u000e\u00106\u001a\u00020#2\u0006\u0010 \u001a\u00020\u001dJ\u000e\u00107\u001a\u00020#2\u0006\u0010 \u001a\u00020\u001dJ\u0006\u00108\u001a\u00020#J\u0006\u00109\u001a\u00020#J\u0010\u0010:\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0014X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006>"}, d2 = {"Lcom/tencent/state/view/ProgressDrawable;", "Landroid/graphics/drawable/Drawable;", "drawStyle", "Lcom/tencent/state/view/ProgressDrawableStyle;", "(Lcom/tencent/state/view/ProgressDrawableStyle;)V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "mArcRect", "Landroid/graphics/RectF;", "mCountdownProgressListener", "Lcom/tencent/state/view/ProgressDrawable$OnCountdownProgressListener;", "mPaint", "Landroid/graphics/Paint;", "mProgressType", "Lcom/tencent/state/view/ProgressDrawable$ProgressType;", "needRadius", "", "outLineColor", "", "outLineWidth", "progress", "", "progressChangeTask", "Ljava/lang/Runnable;", "progressLineColor", "progressLineWidth", "refreshDelayTimeMills", "", "startOffsetTimeMills", "startTimeMillis", "timeMillis", "computeProgress", "draw", "", PM.CANVAS, "Landroid/graphics/Canvas;", "drawCircle", "drawRect", "getOpacity", "reStart", "resetProgress", "setAlpha", c.f123400v, "setColorFilter", CustomAnimation.KeyPath.COLOR_FILTER, "Landroid/graphics/ColorFilter;", "setCountdownProgressListener", "setNeedRadius", "value", HippyQQPagView.FunctionName.SET_PROGRESS, "setProgressType", "setRefreshDelayTime", "setStartOffset", "setTimeMillis", "start", "stop", "validateProgress", "Companion", "OnCountdownProgressListener", "ProgressType", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class ProgressDrawable extends Drawable {
    private static final String TAG = "ProgressDrawable";
    private final ProgressDrawableStyle drawStyle;
    private final Handler handler;
    private final RectF mArcRect;
    private OnCountdownProgressListener mCountdownProgressListener;
    private final Paint mPaint;
    private ProgressType mProgressType;
    private boolean needRadius;
    private final int outLineColor;
    private final int outLineWidth;
    private float progress;
    private final Runnable progressChangeTask;
    private final int progressLineColor;
    private final int progressLineWidth;
    private long refreshDelayTimeMills;
    private long startOffsetTimeMills;
    private long startTimeMillis;
    private long timeMillis;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/state/view/ProgressDrawable$OnCountdownProgressListener;", "", "onProgress", "", "progress", "", "onProgressEnd", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public interface OnCountdownProgressListener {
        void onProgress(float progress);

        void onProgressEnd();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/state/view/ProgressDrawable$ProgressType;", "", "(Ljava/lang/String;I)V", "COUNT", "COUNT_BACK", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public enum ProgressType {
        COUNT,
        COUNT_BACK
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ProgressDrawableStyle.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ProgressDrawableStyle.RECT.ordinal()] = 1;
            iArr[ProgressDrawableStyle.CIRCLE.ordinal()] = 2;
            int[] iArr2 = new int[ProgressType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ProgressType.COUNT.ordinal()] = 1;
            iArr2[ProgressType.COUNT_BACK.ordinal()] = 2;
        }
    }

    public ProgressDrawable(ProgressDrawableStyle drawStyle) {
        Intrinsics.checkNotNullParameter(drawStyle, "drawStyle");
        this.drawStyle = drawStyle;
        this.progressLineColor = Color.parseColor("#FF823C");
        this.outLineWidth = 2;
        this.progressLineWidth = 8;
        this.progress = 1.0f;
        this.mProgressType = ProgressType.COUNT_BACK;
        this.timeMillis = 3000L;
        this.refreshDelayTimeMills = 20L;
        this.mPaint = new Paint(1);
        this.mArcRect = new RectF();
        this.handler = new Handler(Looper.getMainLooper());
        this.progressChangeTask = new Runnable() { // from class: com.tencent.state.view.ProgressDrawable$progressChangeTask$1
            @Override // java.lang.Runnable
            public void run() {
                float computeProgress;
                float f16;
                float f17;
                float validateProgress;
                ProgressDrawable.OnCountdownProgressListener onCountdownProgressListener;
                float f18;
                ProgressDrawable.OnCountdownProgressListener onCountdownProgressListener2;
                long j3;
                float f19;
                ProgressDrawable.this.getHandler().removeCallbacks(this);
                ProgressDrawable progressDrawable = ProgressDrawable.this;
                computeProgress = progressDrawable.computeProgress();
                progressDrawable.progress = computeProgress;
                f16 = ProgressDrawable.this.progress;
                if (f16 >= 0) {
                    f18 = ProgressDrawable.this.progress;
                    if (f18 <= 1) {
                        onCountdownProgressListener2 = ProgressDrawable.this.mCountdownProgressListener;
                        if (onCountdownProgressListener2 != null) {
                            f19 = ProgressDrawable.this.progress;
                            onCountdownProgressListener2.onProgress(f19);
                        }
                        ProgressDrawable.this.invalidateSelf();
                        Handler handler = ProgressDrawable.this.getHandler();
                        j3 = ProgressDrawable.this.refreshDelayTimeMills;
                        handler.postDelayed(this, j3);
                        return;
                    }
                }
                ProgressDrawable progressDrawable2 = ProgressDrawable.this;
                f17 = progressDrawable2.progress;
                validateProgress = progressDrawable2.validateProgress(f17);
                progressDrawable2.progress = validateProgress;
                ProgressDrawable.this.invalidateSelf();
                onCountdownProgressListener = ProgressDrawable.this.mCountdownProgressListener;
                if (onCountdownProgressListener != null) {
                    onCountdownProgressListener.onProgressEnd();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float computeProgress() {
        float currentTimeMillis = ((float) ((System.currentTimeMillis() - this.startTimeMillis) + this.startOffsetTimeMills)) / ((float) this.timeMillis);
        return this.mProgressType == ProgressType.COUNT ? currentTimeMillis : 1 - currentTimeMillis;
    }

    private final void drawCircle(Canvas canvas) {
        int height;
        if (getBounds().height() > getBounds().width()) {
            height = getBounds().width();
        } else {
            height = getBounds().height();
        }
        float f16 = height / 2;
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(0);
        canvas.drawCircle(getBounds().centerX(), getBounds().centerY(), f16 - this.outLineWidth, this.mPaint);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.outLineWidth);
        this.mPaint.setColor(this.outLineColor);
        canvas.drawCircle(getBounds().centerX(), getBounds().centerY(), f16 - (this.outLineWidth / 2), this.mPaint);
        this.mPaint.setColor(this.progressLineColor);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.progressLineWidth);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        int i3 = (this.progressLineWidth + this.outLineWidth) / 2;
        this.mArcRect.set(getBounds().left + i3, getBounds().top + i3, getBounds().right - i3, getBounds().bottom - i3);
        canvas.drawArc(this.mArcRect, 270.0f, 360 * this.progress, false, this.mPaint);
    }

    private final void drawRect(Canvas canvas) {
        float f16;
        int height;
        if (this.needRadius) {
            if (getBounds().height() > getBounds().width()) {
                height = getBounds().width();
            } else {
                height = getBounds().height();
            }
            f16 = height / 2;
        } else {
            f16 = 0.0f;
        }
        float f17 = getBounds().left;
        float f18 = getBounds().top;
        float f19 = getBounds().right;
        float f26 = getBounds().bottom;
        int argb = Color.argb(26, 0, 0, 0);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(argb);
        float f27 = f16;
        float f28 = f16;
        canvas.drawRoundRect(f17, f18, f19, f26, f27, f28, this.mPaint);
        this.mPaint.setColor(this.progressLineColor);
        this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
        this.mPaint.setStyle(Paint.Style.FILL);
        canvas.drawRoundRect(f17, f18, f19 * this.progress, f26, f27, f28, this.mPaint);
    }

    private final void resetProgress() {
        float f16;
        int i3 = WhenMappings.$EnumSwitchMapping$1[this.mProgressType.ordinal()];
        if (i3 == 1) {
            f16 = 0.0f;
        } else {
            if (i3 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            f16 = 1.0f;
        }
        this.progress = f16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float validateProgress(float progress) {
        if (progress > 1.0f) {
            return 1.0f;
        }
        if (progress < 0) {
            return 0.0f;
        }
        return progress;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.drawStyle.ordinal()];
        if (i3 == 1) {
            drawRect(canvas);
        } else {
            if (i3 != 2) {
                return;
            }
            drawCircle(canvas);
        }
    }

    public final Handler getHandler() {
        return this.handler;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final void reStart() {
        resetProgress();
        start();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.mPaint.setAlpha(alpha);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public final void setCountdownProgressListener(OnCountdownProgressListener mCountdownProgressListener) {
        this.mCountdownProgressListener = mCountdownProgressListener;
    }

    public final void setNeedRadius(boolean value) {
        this.needRadius = value;
    }

    public final void setProgress(float value) {
        this.progress = validateProgress(value);
        invalidateSelf();
    }

    public final void setProgressType(ProgressType value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.mProgressType = value;
    }

    public final void setRefreshDelayTime(long timeMillis) {
        this.refreshDelayTimeMills = timeMillis;
        invalidateSelf();
    }

    public final void setTimeMillis(long timeMillis) {
        this.timeMillis = timeMillis;
        invalidateSelf();
    }

    public final void start() {
        stop();
        this.startTimeMillis = System.currentTimeMillis();
        this.handler.post(this.progressChangeTask);
    }

    public final void stop() {
        this.handler.removeCallbacks(this.progressChangeTask);
    }

    public final void setStartOffset(long timeMillis) {
        if (timeMillis < 0) {
            timeMillis = 0;
        }
        this.startOffsetTimeMills = timeMillis;
        invalidateSelf();
    }
}
