package cooperation.qzone.panorama.controller;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import cooperation.qzone.panorama.callback.PanoramaTouchListener;
import cooperation.qzone.panorama.util.PanoramaConfig;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: P */
/* loaded from: classes38.dex */
public class TouchController implements View.OnTouchListener {
    private static final int DEFAULT_TOUCH_SLOP = 40;
    private static final int FLING_SCROLL_PERIOD = 15;
    private static final int FLING_SCROLL_SPEED = 3;
    private static final String TAG = "TouchController";
    public static final float TOUCH_SCALE_SENSITIVITY_MAX_CYLINDER = 1.0f;
    public static final float TOUCH_SCALE_SENSITIVITY_MAX_SPHERE = 1.5f;
    public static final float TOUCH_SCALE_SENSITIVITY_MIN_CYLINDER = 0.122f;
    public static final float TOUCH_SCALE_SENSITIVITY_MIN_SPHERE = 0.35f;
    private Context context;
    private float currentTouchSensitivity;
    private float downX;
    private float downY;
    private float mCurrentScale;
    private float mPreviousX;
    private float mPreviousY;
    private VelocityTracker mVelocityTracker;
    private int modeType;
    private PanoramaTouchListener panoramaTouchListener;
    private int panoramaType;
    private View parent;
    private float rotateX;
    private float rotateY;
    private ScaleGestureDetector scaleGestureDetector;
    private int showType;
    private Timer timer;
    private TimerTask timerTask;
    private float touchMoveScaleRate;
    private float touchMoveSensitivityLow;
    private float touchScaleSensitivityLow;
    private boolean isTouchMove = false;
    private ScaleGestureDetector.OnScaleGestureListener onScaleGestureListener = new ScaleGestureDetector.OnScaleGestureListener() { // from class: cooperation.qzone.panorama.controller.TouchController.2
        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            TouchController.this.mCurrentScale += 1.0f - scaleFactor;
            if (TouchController.this.modeType == 0) {
                TouchController touchController = TouchController.this;
                touchController.mCurrentScale = Math.max(touchController.touchScaleSensitivityLow, Math.min(1.5f, TouchController.this.mCurrentScale));
            } else {
                TouchController touchController2 = TouchController.this;
                touchController2.mCurrentScale = Math.max(touchController2.touchScaleSensitivityLow, Math.min(1.0f, TouchController.this.mCurrentScale));
            }
            TouchController touchController3 = TouchController.this;
            touchController3.currentTouchSensitivity = touchController3.mCurrentScale / TouchController.this.touchMoveScaleRate;
            if (TouchController.this.panoramaTouchListener == null) {
                return true;
            }
            TouchController.this.panoramaTouchListener.onTouchScale(TouchController.this.mCurrentScale);
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    };

    public TouchController(View view, Context context, PanoramaTouchListener panoramaTouchListener, PanoramaConfig.Builder builder) {
        this.mCurrentScale = 1.0f;
        this.panoramaTouchListener = panoramaTouchListener;
        this.context = context;
        this.modeType = builder.getModeType();
        this.showType = builder.getShowType();
        this.panoramaType = builder.getPanoramaType();
        this.parent = view;
        this.scaleGestureDetector = new ScaleGestureDetector(context, this.onScaleGestureListener);
        int i3 = this.modeType;
        if (i3 == 0) {
            this.touchScaleSensitivityLow = 0.35f;
            this.touchMoveSensitivityLow = 0.057f;
            this.touchMoveScaleRate = 0.35f / 0.057f;
            this.currentTouchSensitivity = 0.162f;
        } else {
            this.touchScaleSensitivityLow = 0.122f;
            this.touchMoveSensitivityLow = 0.01f;
            this.touchMoveScaleRate = 0.122f / 0.01f;
            this.currentTouchSensitivity = 0.08f;
        }
        if (this.showType != 1) {
            this.mCurrentScale = 1.0f;
        } else if (i3 == 0) {
            this.mCurrentScale = 0.41426522f;
        } else {
            this.mCurrentScale = 0.5228754f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTouchMove(float f16, float f17) {
        PanoramaTouchListener panoramaTouchListener = this.panoramaTouchListener;
        if (panoramaTouchListener != null) {
            panoramaTouchListener.onTouchMove(f16, f17);
        }
        float f18 = this.rotateX + f16;
        this.rotateX = f18;
        this.rotateY += f17;
        if (f18 > 90.0f) {
            this.rotateX = 90.0f;
        } else if (f18 < -90.0f) {
            this.rotateX = -90.0f;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        PanoramaTouchListener panoramaTouchListener;
        View view2 = this.parent;
        if (view2 != null) {
            view2.getParent().requestDisallowInterceptTouchEvent(true);
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        boolean onTouchEvent = this.scaleGestureDetector.onTouchEvent(motionEvent);
        if (motionEvent.getActionMasked() == 6) {
            this.isTouchMove = true;
        }
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        if (!this.scaleGestureDetector.isInProgress() && motionEvent.getPointerCount() == 1 && !this.isTouchMove) {
            if (motionEvent.getAction() == 0) {
                this.downX = x16;
                this.downY = y16;
                Timer timer = this.timer;
                if (timer != null) {
                    timer.cancel();
                }
                TimerTask timerTask = this.timerTask;
                if (timerTask != null) {
                    timerTask.cancel();
                }
            } else if (motionEvent.getAction() == 2) {
                float f16 = x16 - this.mPreviousX;
                float f17 = y16 - this.mPreviousY;
                if (this.panoramaType != 4) {
                    float f18 = y16 - this.downY;
                    float f19 = x16 - this.downX;
                    int scaledTouchSlop = ViewConfiguration.get(this.context).getScaledTouchSlop() * 2;
                    if (scaledTouchSlop < 40) {
                        scaledTouchSlop = 40;
                    }
                    float f26 = f18 / f19;
                    if (f26 >= 1.0f || f26 <= -1.0f) {
                        float f27 = scaledTouchSlop;
                        if (Math.abs(f18) <= f27 && Math.abs(f19) <= f27) {
                            View view3 = this.parent;
                            if (view3 != null) {
                                view3.getParent().requestDisallowInterceptTouchEvent(false);
                            }
                            return true;
                        }
                    }
                }
                float f28 = this.currentTouchSensitivity;
                onTouchMove(f17 * f28, f16 * f28);
            }
            this.mPreviousY = y16;
            this.mPreviousX = x16;
        }
        if (motionEvent.getAction() == 1) {
            this.isTouchMove = false;
            float scaledTouchSlop2 = ViewConfiguration.get(this.context).getScaledTouchSlop();
            if (Math.abs(x16 - this.downX) <= scaledTouchSlop2 && Math.abs(y16 - this.downY) <= scaledTouchSlop2 && (panoramaTouchListener = this.panoramaTouchListener) != null) {
                panoramaTouchListener.onClickListener();
            }
            this.mVelocityTracker.computeCurrentVelocity(10);
            int xVelocity = (int) this.mVelocityTracker.getXVelocity();
            int yVelocity = (int) this.mVelocityTracker.getYVelocity();
            final int[] iArr = {xVelocity, yVelocity};
            final int i3 = xVelocity > 0 ? 1 : 0;
            final int i16 = yVelocity <= 0 ? 0 : 1;
            this.timer = new BaseTimer();
            TimerTask timerTask2 = new TimerTask() { // from class: cooperation.qzone.panorama.controller.TouchController.1
                private int[] cancelXY = {0, 0};

                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    if (i3 == 1) {
                        int[] iArr2 = iArr;
                        if (iArr2[0] <= 0) {
                            this.cancelXY[0] = 1;
                        } else {
                            this.cancelXY[0] = 0;
                            iArr2[0] = iArr2[0] - 3;
                        }
                    } else {
                        int[] iArr3 = iArr;
                        if (iArr3[0] >= 0) {
                            this.cancelXY[0] = 1;
                        } else {
                            this.cancelXY[0] = 0;
                            iArr3[0] = iArr3[0] + 3;
                        }
                    }
                    if (i16 == 1) {
                        int[] iArr4 = iArr;
                        if (iArr4[1] <= 0) {
                            this.cancelXY[1] = 1;
                        } else {
                            this.cancelXY[1] = 0;
                            iArr4[1] = iArr4[1] - 3;
                        }
                    } else {
                        int[] iArr5 = iArr;
                        if (iArr5[1] >= 0) {
                            this.cancelXY[1] = 1;
                        } else {
                            this.cancelXY[1] = 0;
                            iArr5[1] = iArr5[1] + 3;
                        }
                    }
                    int[] iArr6 = this.cancelXY;
                    if (iArr6[1] == 1 && iArr6[0] == 1) {
                        TouchController.this.timer.cancel();
                        cancel();
                    }
                    TouchController.this.onTouchMove(0.0f, iArr[0] * TouchController.this.currentTouchSensitivity);
                }
            };
            this.timerTask = timerTask2;
            this.timer.schedule(timerTask2, 0L, 15L);
        }
        return onTouchEvent;
    }
}
