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
import com.tencent.luggage.wxa.c8.c;
import com.tencent.state.view.CircleProgressDrawable;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u000212B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001d\u001a\u00020\u0013H\u0002J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u0010H\u0016J\u0006\u0010#\u001a\u00020\u001fJ\b\u0010$\u001a\u00020\u001fH\u0002J\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010&\u001a\u00020\u0010H\u0016J\u0012\u0010'\u001a\u00020\u001f2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u0010\u0010*\u001a\u00020\u001f2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u000e\u0010+\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u0019J\u000e\u0010,\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u0019J\u000e\u0010-\u001a\u00020\u001f2\u0006\u0010\u001c\u001a\u00020\u0019J\u0006\u0010.\u001a\u00020\u001fJ\u0006\u0010/\u001a\u00020\u001fJ\u0010\u00100\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2 = {"Lcom/tencent/state/view/CircleProgressDrawable;", "Landroid/graphics/drawable/Drawable;", "()V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "mArcRect", "Landroid/graphics/RectF;", "mCountdownProgressListener", "Lcom/tencent/state/view/CircleProgressDrawable$OnCountdownProgressListener;", "mPaint", "Landroid/graphics/Paint;", "mProgressType", "Lcom/tencent/state/view/CircleProgressDrawable$ProgressType;", "outLineColor", "", "outLineWidth", "progress", "", "progressChangeTask", "Ljava/lang/Runnable;", "progressLineColor", "progressLineWidth", "refreshDelayTimeMills", "", "startOffsetTimeMills", "startTimeMillis", "timeMillis", "computeProgress", "draw", "", PM.CANVAS, "Landroid/graphics/Canvas;", "getOpacity", "reStart", "resetProgress", "setAlpha", c.f123400v, "setColorFilter", CustomAnimation.KeyPath.COLOR_FILTER, "Landroid/graphics/ColorFilter;", "setCountdownProgressListener", "setRefreshDelayTime", "setStartOffset", "setTimeMillis", "start", "stop", "validateProgress", "OnCountdownProgressListener", "ProgressType", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class CircleProgressDrawable extends Drawable {
    private OnCountdownProgressListener mCountdownProgressListener;
    private final int outLineColor;
    private long startOffsetTimeMills;
    private long startTimeMillis;
    private final int progressLineWidth = 8;
    private final int progressLineColor = Color.parseColor("#FF823C");
    private final int outLineWidth = 2;
    private float progress = 1.0f;
    private final ProgressType mProgressType = ProgressType.COUNT_BACK;
    private long timeMillis = 3000;
    private long refreshDelayTimeMills = 20;
    private final Paint mPaint = new Paint(1);
    private final RectF mArcRect = new RectF();
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final Runnable progressChangeTask = new Runnable() { // from class: com.tencent.state.view.CircleProgressDrawable$progressChangeTask$1
        @Override // java.lang.Runnable
        public void run() {
            float computeProgress;
            float f16;
            float f17;
            float validateProgress;
            CircleProgressDrawable.OnCountdownProgressListener onCountdownProgressListener;
            float f18;
            CircleProgressDrawable.OnCountdownProgressListener onCountdownProgressListener2;
            long j3;
            float f19;
            CircleProgressDrawable.this.getHandler().removeCallbacks(this);
            CircleProgressDrawable circleProgressDrawable = CircleProgressDrawable.this;
            computeProgress = circleProgressDrawable.computeProgress();
            circleProgressDrawable.progress = computeProgress;
            f16 = CircleProgressDrawable.this.progress;
            if (f16 >= 0) {
                f18 = CircleProgressDrawable.this.progress;
                if (f18 <= 1) {
                    onCountdownProgressListener2 = CircleProgressDrawable.this.mCountdownProgressListener;
                    if (onCountdownProgressListener2 != null) {
                        f19 = CircleProgressDrawable.this.progress;
                        onCountdownProgressListener2.onProgress(f19);
                    }
                    CircleProgressDrawable.this.invalidateSelf();
                    Handler handler = CircleProgressDrawable.this.getHandler();
                    j3 = CircleProgressDrawable.this.refreshDelayTimeMills;
                    handler.postDelayed(this, j3);
                    return;
                }
            }
            CircleProgressDrawable circleProgressDrawable2 = CircleProgressDrawable.this;
            f17 = circleProgressDrawable2.progress;
            validateProgress = circleProgressDrawable2.validateProgress(f17);
            circleProgressDrawable2.progress = validateProgress;
            CircleProgressDrawable.this.invalidateSelf();
            onCountdownProgressListener = CircleProgressDrawable.this.mCountdownProgressListener;
            if (onCountdownProgressListener != null) {
                onCountdownProgressListener.onProgressEnd();
            }
        }
    };

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/state/view/CircleProgressDrawable$OnCountdownProgressListener;", "", "onProgress", "", "progress", "", "onProgressEnd", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public interface OnCountdownProgressListener {
        void onProgress(float progress);

        void onProgressEnd();
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/state/view/CircleProgressDrawable$ProgressType;", "", "(Ljava/lang/String;I)V", "COUNT", "COUNT_BACK", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public enum ProgressType {
        COUNT,
        COUNT_BACK
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProgressType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ProgressType.COUNT.ordinal()] = 1;
            iArr[ProgressType.COUNT_BACK.ordinal()] = 2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float computeProgress() {
        float currentTimeMillis = ((float) ((System.currentTimeMillis() - this.startTimeMillis) + this.startOffsetTimeMills)) / ((float) this.timeMillis);
        return this.mProgressType == ProgressType.COUNT ? currentTimeMillis : 1 - currentTimeMillis;
    }

    private final void resetProgress() {
        float f16;
        int i3 = WhenMappings.$EnumSwitchMapping$0[this.mProgressType.ordinal()];
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
        int height;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
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
