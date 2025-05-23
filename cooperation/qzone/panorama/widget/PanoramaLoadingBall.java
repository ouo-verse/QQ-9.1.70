package cooperation.qzone.panorama.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import cooperation.qzone.util.PanoramaUtil;
import cooperation.qzone.util.QZLog;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes38.dex */
public class PanoramaLoadingBall extends View {
    private static final float INCREASE_SPEED = 0.3f;
    private static final int ROTATE_SPEED = 2;
    public static final int START_DEGREE = 60;
    private static final String TAG = "PanoramaLoadingBall";
    private static final int TYPE_ANTI_CLOCK_WISE = 1;
    private static final int TYPE_CLOCK_WISE = 0;
    public static final int TYPE_HORIZONTAL = 0;
    public static final int TYPE_VERTICAL = 1;
    private Context context;
    private float currentDegree;
    private float finalDegree;
    private Handler handler;
    private int inCircleRadius;
    private boolean isStop;
    private Paint mPaint;
    private int mViewHeight;
    private int mViewWidth;
    private int midCircleRadius;
    private int outCircleRadius;
    private PanoramaLoadingBackground panoramaLoadingBackground;
    private int rotateDirection;
    private Timer timer;
    private TimerTask timerTask;
    private int type;

    public PanoramaLoadingBall(Context context) {
        super(context);
        this.mViewWidth = PanoramaLoadingLayout.WIDTH;
        this.mViewHeight = PanoramaLoadingLayout.HEIGHT;
        this.handler = new Handler(Looper.getMainLooper()) { // from class: cooperation.qzone.panorama.widget.PanoramaLoadingBall.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 291) {
                    if (PanoramaLoadingBall.this.isStop) {
                        PanoramaLoadingBall.this.currentDegree = 60.0f;
                    }
                    if (PanoramaLoadingBall.this.type == 0) {
                        PanoramaLoadingBall panoramaLoadingBall = PanoramaLoadingBall.this;
                        panoramaLoadingBall.setRotationX(panoramaLoadingBall.currentDegree);
                    } else {
                        PanoramaLoadingBall panoramaLoadingBall2 = PanoramaLoadingBall.this;
                        panoramaLoadingBall2.setRotationY(panoramaLoadingBall2.currentDegree);
                    }
                }
            }
        };
        init(context);
    }

    private void drawMidCircle(Canvas canvas) {
        this.mPaint.setColor(-1);
        this.mPaint.setStrokeWidth(3.0f);
        this.mPaint.setStyle(Paint.Style.STROKE);
        int i3 = this.mViewWidth;
        canvas.drawCircle(i3 / 2, i3 / 2, this.midCircleRadius, this.mPaint);
    }

    private void init(Context context) {
        this.context = context;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        setPivotX((this.mViewWidth / 2) + 5);
        setPivotY((this.mViewHeight / 2) - 5);
    }

    private int measureHeight(int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode != 1073741824) {
            if (mode == Integer.MIN_VALUE) {
                size = Math.min(size, this.mViewHeight);
            } else {
                size = this.mViewHeight;
            }
        }
        this.mViewHeight = size;
        return size;
    }

    private int measureWidth(int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode != 1073741824) {
            if (mode == Integer.MIN_VALUE) {
                size = Math.min(size, this.mViewWidth);
            } else {
                size = this.mViewWidth;
            }
        }
        this.mViewWidth = size;
        return size;
    }

    private void startTimerTask() {
        stopTimer();
        this.isStop = false;
        this.timer = new BaseTimer();
        TimerTask timerTask = new TimerTask() { // from class: cooperation.qzone.panorama.widget.PanoramaLoadingBall.2
            boolean isSlow = false;

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (!PanoramaLoadingBall.this.isStop) {
                    if (!this.isSlow) {
                        if (PanoramaLoadingBall.this.rotateDirection == 0) {
                            PanoramaLoadingBall.this.currentDegree += 2.0f;
                        } else {
                            PanoramaLoadingBall.this.currentDegree -= 2.0f;
                        }
                    }
                    if (PanoramaLoadingBall.this.currentDegree > PanoramaLoadingBall.this.finalDegree) {
                        PanoramaLoadingBall.this.currentDegree -= 0.3f;
                        this.isSlow = true;
                        if (PanoramaLoadingBall.this.currentDegree <= PanoramaLoadingBall.this.finalDegree) {
                            PanoramaLoadingBall.this.rotateDirection = 1;
                            this.isSlow = false;
                        }
                    } else if (PanoramaLoadingBall.this.currentDegree < 0.0f) {
                        PanoramaLoadingBall.this.currentDegree += 0.3f;
                        this.isSlow = true;
                        if (PanoramaLoadingBall.this.currentDegree >= 0.0f) {
                            PanoramaLoadingBall.this.rotateDirection = 0;
                            this.isSlow = false;
                        }
                    }
                    PanoramaLoadingBall.this.handler.sendEmptyMessage(291);
                    return;
                }
                PanoramaLoadingBall.this.timer.cancel();
                cancel();
            }
        };
        this.timerTask = timerTask;
        try {
            this.timer.schedule(timerTask, 0L, 15L);
        } catch (IllegalStateException e16) {
            QZLog.e(TAG, "startTimerTask IllegalStateException", e16);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i3 = this.mViewWidth / 2;
        this.outCircleRadius = i3;
        this.midCircleRadius = i3 - (i3 / 5);
        this.inCircleRadius = i3 - ((i3 * 2) / 5);
        drawMidCircle(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        setMeasuredDimension(measureWidth(i3), measureHeight(i16));
    }

    @Override // android.view.View
    public void setRotationX(float f16) {
        if (!PanoramaUtil.getInstance().isClosePanoramaRotation()) {
            super.setRotationX(f16);
        }
        float f17 = f16 / this.finalDegree;
        float f18 = (f17 * (255 - r0)) + PanoramaLoadingBackground.MIN_ALPHA;
        if (f18 > 255.0f) {
            f18 = 255.0f;
        }
        PanoramaLoadingBackground panoramaLoadingBackground = this.panoramaLoadingBackground;
        if (panoramaLoadingBackground != null) {
            panoramaLoadingBackground.setContentAlpha((int) f18);
        }
    }

    @Override // android.view.View
    public void setRotationY(float f16) {
        if (PanoramaUtil.getInstance().isClosePanoramaRotation()) {
            return;
        }
        super.setRotationY(f16);
    }

    public void startRotate(float f16, int i3, PanoramaLoadingBackground panoramaLoadingBackground) {
        this.finalDegree = f16;
        this.currentDegree = f16;
        this.type = i3;
        this.panoramaLoadingBackground = panoramaLoadingBackground;
        if (i3 == 0) {
            setRotationX(f16);
        } else {
            setRotationY(f16);
        }
        startTimerTask();
    }

    public void stopTimer() {
        this.isStop = true;
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
        }
        TimerTask timerTask = this.timerTask;
        if (timerTask != null) {
            timerTask.cancel();
        }
    }

    public PanoramaLoadingBall(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mViewWidth = PanoramaLoadingLayout.WIDTH;
        this.mViewHeight = PanoramaLoadingLayout.HEIGHT;
        this.handler = new Handler(Looper.getMainLooper()) { // from class: cooperation.qzone.panorama.widget.PanoramaLoadingBall.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 291) {
                    if (PanoramaLoadingBall.this.isStop) {
                        PanoramaLoadingBall.this.currentDegree = 60.0f;
                    }
                    if (PanoramaLoadingBall.this.type == 0) {
                        PanoramaLoadingBall panoramaLoadingBall = PanoramaLoadingBall.this;
                        panoramaLoadingBall.setRotationX(panoramaLoadingBall.currentDegree);
                    } else {
                        PanoramaLoadingBall panoramaLoadingBall2 = PanoramaLoadingBall.this;
                        panoramaLoadingBall2.setRotationY(panoramaLoadingBall2.currentDegree);
                    }
                }
            }
        };
        init(context);
    }
}
