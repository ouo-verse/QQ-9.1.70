package com.tencent.ams.fusion.widget.slideinteractive;

import android.content.Context;
import android.gesture.Gesture;
import android.gesture.GesturePoint;
import android.gesture.GestureStroke;
import android.gesture.GestureUtils;
import android.gesture.OrientedBoundingBox;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView;
import com.tencent.ams.fusion.widget.utils.FusionWidgetConfig;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SlideGestureView extends SurfaceView implements SurfaceHolder.Callback, ISlideGestureView {
    static IPatchRedirector $redirector_ = null;
    private static final boolean DITHER_FLAG = true;
    private static final int FADE_ANIMATION_RATE = 16;
    private static final boolean GESTURE_RENDERING_ANTIALIAS = true;
    public static final int GESTURE_STROKE_TYPE_MULTIPLE = 1;
    public static final int GESTURE_STROKE_TYPE_SINGLE = 0;
    public static final int ORIENTATION_HORIZONTAL = 0;
    public static final int ORIENTATION_VERTICAL = 1;
    private static final String TAG = "SlideGestureView";
    public static final float TOUCH_TOLERANCE = 3.0f;
    private int mCertainGestureColor;
    private int mCurrentColor;
    private Gesture mCurrentGesture;
    private float mCurveEndX;
    private float mCurveEndY;
    private Rect mDrawRect;
    private long mFadeDuration;
    private boolean mFadeEnabled;
    private long mFadeOffset;
    private float mFadingAlpha;
    private boolean mFadingHasStarted;
    private final FadeOutRunnable mFadingOut;
    private long mFadingStart;
    private final Paint mGesturePaint;
    private float mGestureStrokeAngleThreshold;
    private float mGestureStrokeLengthThreshold;
    private float mGestureStrokeSquarenessTreshold;
    private int mGestureStrokeType;
    private float mGestureStrokeWidth;
    private boolean mGestureVisible;
    private boolean mHandleGestureActions;
    private boolean mInterceptEvents;
    private final AccelerateDecelerateInterpolator mInterpolator;
    private final Rect mInvalidRect;
    private int mInvalidateExtraBorder;
    private boolean mIsEnableAsyncDrawSlideTrack;
    private boolean mIsFadingOut;
    private boolean mIsGesturing;
    private volatile boolean mIsInMove;
    private boolean mIsListeningForGestures;
    private final ArrayList<ISlideGestureView.OnGestureListener> mOnGestureListeners;
    private final ArrayList<ISlideGestureView.OnGesturePerformedListener> mOnGesturePerformedListeners;
    private final ArrayList<ISlideGestureView.OnGesturingListener> mOnGesturingListeners;
    private int mOrientation;
    private final Path mPath;
    private boolean mPreviousWasGesturing;
    private Handler mRenderHandler;
    private HandlerThread mRenderThread;
    private boolean mResetGesture;
    private boolean mStop;
    private final ArrayList<GesturePoint> mStrokeBuffer;
    private boolean mSurfaceCreated;
    private float mTotalLength;
    private int mUncertainGestureColor;
    private float mX;
    private float mY;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class FadeOutRunnable implements Runnable {
        static IPatchRedirector $redirector_;
        boolean fireActionPerformed;
        boolean resetMultipleStrokes;

        FadeOutRunnable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) SlideGestureView.this);
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (SlideGestureView.this.mIsFadingOut) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - SlideGestureView.this.mFadingStart;
                if (currentAnimationTimeMillis <= SlideGestureView.this.mFadeDuration) {
                    SlideGestureView.this.mFadingHasStarted = true;
                    float max = Math.max(0.0f, Math.min(1.0f, ((float) currentAnimationTimeMillis) / ((float) SlideGestureView.this.mFadeDuration)));
                    SlideGestureView slideGestureView = SlideGestureView.this;
                    slideGestureView.mFadingAlpha = 1.0f - slideGestureView.mInterpolator.getInterpolation(max);
                    SlideGestureView slideGestureView2 = SlideGestureView.this;
                    slideGestureView2.setPaintAlpha((int) (slideGestureView2.mFadingAlpha * 255.0f));
                    SlideGestureView.this.postDelayRender(this, 16L);
                } else {
                    if (this.fireActionPerformed) {
                        SlideGestureView.this.fireOnGesturePerformed();
                    }
                    SlideGestureView.this.mPreviousWasGesturing = false;
                    SlideGestureView.this.mIsFadingOut = false;
                    SlideGestureView.this.mFadingHasStarted = false;
                    SlideGestureView.this.mPath.rewind();
                    SlideGestureView.this.mCurrentGesture = null;
                    SlideGestureView.this.setPaintAlpha(255);
                }
            } else if (this.resetMultipleStrokes) {
                SlideGestureView.this.mResetGesture = true;
            } else {
                SlideGestureView.this.fireOnGesturePerformed();
                SlideGestureView.this.mFadingHasStarted = false;
                SlideGestureView.this.mPath.rewind();
                SlideGestureView.this.mCurrentGesture = null;
                SlideGestureView.this.mPreviousWasGesturing = false;
                SlideGestureView.this.setPaintAlpha(255);
            }
            SlideGestureView.this.invalidate();
        }

        /* synthetic */ FadeOutRunnable(SlideGestureView slideGestureView, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) slideGestureView, (Object) anonymousClass1);
        }
    }

    public SlideGestureView(Context context) {
        super(context);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.mGesturePaint = new Paint();
        this.mFadeDuration = 150L;
        this.mFadeOffset = 420L;
        this.mFadeEnabled = true;
        this.mCertainGestureColor = -256;
        this.mUncertainGestureColor = 1224736512;
        this.mGestureStrokeWidth = 12.0f;
        this.mInvalidateExtraBorder = 10;
        this.mGestureStrokeType = 0;
        this.mGestureStrokeLengthThreshold = 50.0f;
        this.mGestureStrokeSquarenessTreshold = 0.275f;
        this.mGestureStrokeAngleThreshold = 40.0f;
        this.mOrientation = 1;
        this.mInvalidRect = new Rect();
        this.mPath = new Path();
        this.mGestureVisible = true;
        this.mIsGesturing = false;
        this.mPreviousWasGesturing = false;
        this.mInterceptEvents = true;
        this.mStrokeBuffer = new ArrayList<>(100);
        this.mOnGestureListeners = new ArrayList<>();
        this.mOnGesturePerformedListeners = new ArrayList<>();
        this.mOnGesturingListeners = new ArrayList<>();
        this.mIsFadingOut = false;
        this.mFadingAlpha = 1.0f;
        this.mInterpolator = new AccelerateDecelerateInterpolator();
        this.mFadingOut = new FadeOutRunnable(this, null);
        this.mSurfaceCreated = false;
        this.mStop = false;
        init();
    }

    private void cancelGesture(MotionEvent motionEvent) {
        ArrayList<ISlideGestureView.OnGestureListener> arrayList = this.mOnGestureListeners;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.get(i3).onGestureCancelled(this, motionEvent);
        }
        clear(false);
    }

    private void clipRect(Canvas canvas, Rect rect) {
        if (canvas != null && rect != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                canvas.clipRect(rect);
            } else {
                canvas.clipRect(rect, Region.Op.INTERSECT);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doClearCanvas() {
        Canvas canvas;
        SurfaceHolder holder;
        SurfaceHolder surfaceHolder = null;
        Canvas canvas2 = null;
        try {
            try {
                holder = getHolder();
            } catch (Throwable unused) {
                canvas = null;
            }
            try {
            } catch (Throwable unused2) {
                canvas = canvas2;
                surfaceHolder = holder;
                if (surfaceHolder != null && canvas != null) {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                    Logger.i(TAG, "unlockCanvasAndPost");
                }
                return;
            }
            if (!isSurfaceValid(holder)) {
                return;
            }
            canvas2 = holder.lockCanvas(new Rect(0, 0, getWidth(), getHeight()));
            if (canvas2 != null) {
                clearCanvas(canvas2);
            }
            if (canvas2 != null) {
                holder.unlockCanvasAndPost(canvas2);
                Logger.i(TAG, "unlockCanvasAndPost");
            }
        } catch (Throwable unused3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doDraw() {
        Canvas canvas;
        if (this.mSurfaceCreated) {
            SurfaceHolder holder = getHolder();
            if (!isSurfaceValid(holder)) {
                return;
            }
            try {
                canvas = holder.lockCanvas();
                if (canvas != null) {
                    try {
                        if (this.mIsInMove) {
                            Rect rect = this.mDrawRect;
                            if (rect != null) {
                                clipRect(canvas, rect);
                            }
                            if (this.mCurrentGesture != null && this.mGestureVisible) {
                                clearCanvas(canvas);
                                canvas.drawPath(this.mPath, this.mGesturePaint);
                            }
                        } else {
                            clearCanvas(canvas);
                        }
                    } catch (Throwable unused) {
                        if (canvas == null) {
                            return;
                        }
                        holder.unlockCanvasAndPost(canvas);
                    }
                }
                if (canvas == null) {
                    return;
                }
            } catch (Throwable unused2) {
                canvas = null;
            }
            try {
                holder.unlockCanvasAndPost(canvas);
            } catch (Throwable unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fireOnGesturePerformed() {
        ArrayList<ISlideGestureView.OnGesturePerformedListener> arrayList = this.mOnGesturePerformedListeners;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            arrayList.get(i3).onGesturePerformed(this, this.mCurrentGesture);
        }
    }

    private void init() {
        setWillNotDraw(false);
        Paint paint = this.mGesturePaint;
        paint.setAntiAlias(true);
        paint.setColor(this.mCertainGestureColor);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(this.mGestureStrokeWidth);
        paint.setDither(true);
        this.mCurrentColor = this.mCertainGestureColor;
        setPaintAlpha(255);
        setZOrderOnTop(true);
        SurfaceHolder holder = getHolder();
        holder.setFormat(-2);
        holder.addCallback(this);
        setDrawingCacheEnabled(false);
        this.mIsEnableAsyncDrawSlideTrack = FusionWidgetConfig.isEnableAsyncDrawSlideTrack();
    }

    private boolean isMoveOutside(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        if (motionEvent.getX() <= getWidth() && motionEvent.getX() >= 0.0f && motionEvent.getY() <= getHeight() && motionEvent.getY() >= 0.0f) {
            return false;
        }
        return true;
    }

    private boolean isSurfaceValid(SurfaceHolder surfaceHolder) {
        Surface surface;
        if (surfaceHolder != null && (surface = surfaceHolder.getSurface()) != null) {
            return surface.isValid();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void postDelayRender(Runnable runnable, long j3) {
        Handler handler = this.mRenderHandler;
        if (this.mIsEnableAsyncDrawSlideTrack && handler != null) {
            handler.postDelayed(runnable, j3);
        } else {
            postDelayed(runnable, j3);
        }
    }

    private void postRender(Runnable runnable) {
        Handler handler = this.mRenderHandler;
        if (this.mIsEnableAsyncDrawSlideTrack && handler != null) {
            handler.post(runnable);
        } else {
            post(runnable);
        }
    }

    private boolean processEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        this.mIsInMove = false;
                    } else {
                        this.mIsInMove = false;
                        if (this.mIsListeningForGestures) {
                            touchUp(motionEvent, true);
                            invalidate();
                            return true;
                        }
                    }
                } else {
                    this.mIsInMove = true;
                    if (this.mIsListeningForGestures) {
                        if (isMoveOutside(motionEvent)) {
                            touchUp(motionEvent, false);
                            invalidate();
                        } else {
                            Rect rect = touchMove(motionEvent);
                            if (rect != null) {
                                invalidate(rect);
                            }
                        }
                        return true;
                    }
                }
            } else {
                this.mIsInMove = false;
                if (this.mIsListeningForGestures) {
                    touchUp(motionEvent, false);
                    invalidate();
                    return true;
                }
            }
            return false;
        }
        this.mIsInMove = false;
        touchDown(motionEvent);
        invalidate();
        return true;
    }

    private void setCurrentColor(int i3) {
        this.mCurrentColor = i3;
        if (this.mFadingHasStarted) {
            setPaintAlpha((int) (this.mFadingAlpha * 255.0f));
        } else {
            setPaintAlpha(255);
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPaintAlpha(int i3) {
        int i16 = this.mCurrentColor;
        this.mGesturePaint.setColor(((((i16 >>> 24) * (i3 + (i3 >> 7))) >> 8) << 24) | ((i16 << 8) >>> 8));
    }

    private void startRenderThread() {
        if (!this.mIsEnableAsyncDrawSlideTrack) {
            return;
        }
        HandlerThread handlerThread = this.mRenderThread;
        if (handlerThread != null && handlerThread.isAlive()) {
            Logger.i(TAG, "render thread is alive.");
            return;
        }
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("SLIDE_TRACK_RENDER_THREAD");
        baseHandlerThread.start();
        this.mRenderHandler = new Handler(baseHandlerThread.getLooper());
        this.mRenderThread = baseHandlerThread;
        Logger.i(TAG, "render thread start.");
    }

    private void stopRenderThread() {
        HandlerThread handlerThread = this.mRenderThread;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
        this.mRenderThread = null;
        this.mRenderHandler = null;
    }

    private void touchDown(MotionEvent motionEvent) {
        this.mIsListeningForGestures = true;
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        this.mX = x16;
        this.mY = y16;
        this.mTotalLength = 0.0f;
        this.mIsGesturing = false;
        if (this.mGestureStrokeType != 0 && !this.mResetGesture) {
            Gesture gesture = this.mCurrentGesture;
            if ((gesture == null || gesture.getStrokesCount() == 0) && this.mHandleGestureActions) {
                setCurrentColor(this.mUncertainGestureColor);
            }
        } else {
            if (this.mHandleGestureActions) {
                setCurrentColor(this.mUncertainGestureColor);
            }
            this.mResetGesture = false;
            this.mCurrentGesture = null;
            this.mPath.rewind();
        }
        if (this.mFadingHasStarted) {
            cancelClearAnimation();
        } else if (this.mIsFadingOut) {
            setPaintAlpha(255);
            this.mIsFadingOut = false;
            this.mFadingHasStarted = false;
            removeCallbacks(this.mFadingOut);
        }
        if (this.mCurrentGesture == null) {
            this.mCurrentGesture = new Gesture();
        }
        this.mStrokeBuffer.add(new GesturePoint(x16, y16, motionEvent.getEventTime()));
        this.mPath.moveTo(x16, y16);
        int i3 = this.mInvalidateExtraBorder;
        int i16 = (int) x16;
        int i17 = (int) y16;
        this.mInvalidRect.set(i16 - i3, i17 - i3, i16 + i3, i17 + i3);
        this.mCurveEndX = x16;
        this.mCurveEndY = y16;
        ArrayList<ISlideGestureView.OnGestureListener> arrayList = this.mOnGestureListeners;
        int size = arrayList.size();
        for (int i18 = 0; i18 < size; i18++) {
            arrayList.get(i18).onGestureStarted(this, motionEvent);
        }
    }

    private Rect touchMove(MotionEvent motionEvent) {
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        float f16 = this.mX;
        float f17 = this.mY;
        float abs = Math.abs(x16 - f16);
        float abs2 = Math.abs(y16 - f17);
        if (abs < 3.0f && abs2 < 3.0f) {
            return null;
        }
        Rect rect = this.mInvalidRect;
        int i3 = this.mInvalidateExtraBorder;
        float f18 = this.mCurveEndX;
        float f19 = this.mCurveEndY;
        rect.set(((int) f18) - i3, ((int) f19) - i3, ((int) f18) + i3, ((int) f19) + i3);
        float f26 = (x16 + f16) / 2.0f;
        this.mCurveEndX = f26;
        float f27 = (y16 + f17) / 2.0f;
        this.mCurveEndY = f27;
        this.mPath.quadTo(f16, f17, f26, f27);
        int i16 = (int) f16;
        int i17 = (int) f17;
        rect.union(i16 - i3, i17 - i3, i16 + i3, i17 + i3);
        int i18 = (int) f26;
        int i19 = (int) f27;
        rect.union(i18 - i3, i19 - i3, i18 + i3, i19 + i3);
        this.mX = x16;
        this.mY = y16;
        this.mStrokeBuffer.add(new GesturePoint(x16, y16, motionEvent.getEventTime()));
        if (this.mHandleGestureActions && !this.mIsGesturing) {
            float hypot = this.mTotalLength + ((float) Math.hypot(abs, abs2));
            this.mTotalLength = hypot;
            if (hypot > this.mGestureStrokeLengthThreshold) {
                OrientedBoundingBox computeOrientedBoundingBox = GestureUtils.computeOrientedBoundingBox(this.mStrokeBuffer);
                float abs3 = Math.abs(computeOrientedBoundingBox.orientation);
                if (abs3 > 90.0f) {
                    abs3 = 180.0f - abs3;
                }
                if (computeOrientedBoundingBox.squareness > this.mGestureStrokeSquarenessTreshold || (this.mOrientation != 1 ? abs3 > this.mGestureStrokeAngleThreshold : abs3 < this.mGestureStrokeAngleThreshold)) {
                    this.mIsGesturing = true;
                    setCurrentColor(this.mCertainGestureColor);
                    ArrayList<ISlideGestureView.OnGesturingListener> arrayList = this.mOnGesturingListeners;
                    int size = arrayList.size();
                    for (int i26 = 0; i26 < size; i26++) {
                        arrayList.get(i26).onGesturingStarted(this);
                    }
                }
            }
        }
        ArrayList<ISlideGestureView.OnGestureListener> arrayList2 = this.mOnGestureListeners;
        int size2 = arrayList2.size();
        for (int i27 = 0; i27 < size2; i27++) {
            arrayList2.get(i27).onGesture(this, motionEvent);
        }
        return rect;
    }

    private void touchUp(MotionEvent motionEvent, boolean z16) {
        boolean z17;
        this.mIsListeningForGestures = false;
        Gesture gesture = this.mCurrentGesture;
        if (gesture != null) {
            gesture.addStroke(new GestureStroke(this.mStrokeBuffer));
            if (!z16) {
                ArrayList<ISlideGestureView.OnGestureListener> arrayList = this.mOnGestureListeners;
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    arrayList.get(i3).onGestureEnded(this, motionEvent);
                }
                boolean z18 = this.mHandleGestureActions;
                boolean z19 = true;
                if (z18 && this.mFadeEnabled) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z18 || !this.mIsGesturing) {
                    z19 = false;
                }
                clear(z17, z19, false);
            } else {
                cancelGesture(motionEvent);
            }
        } else {
            cancelGesture(motionEvent);
        }
        this.mStrokeBuffer.clear();
        this.mPreviousWasGesturing = this.mIsGesturing;
        this.mIsGesturing = false;
        ArrayList<ISlideGestureView.OnGesturingListener> arrayList2 = this.mOnGesturingListeners;
        int size2 = arrayList2.size();
        for (int i16 = 0; i16 < size2; i16++) {
            arrayList2.get(i16).onGesturingEnded(this);
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void addOnGestureListener(ISlideGestureView.OnGestureListener onGestureListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) onGestureListener);
        } else {
            this.mOnGestureListeners.add(onGestureListener);
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void addOnGesturePerformedListener(ISlideGestureView.OnGesturePerformedListener onGesturePerformedListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) onGesturePerformedListener);
            return;
        }
        this.mOnGesturePerformedListeners.add(onGesturePerformedListener);
        if (this.mOnGesturePerformedListeners.size() > 0) {
            this.mHandleGestureActions = true;
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void addOnGesturingListener(ISlideGestureView.OnGesturingListener onGesturingListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) onGesturingListener);
        } else {
            this.mOnGesturingListeners.add(onGesturingListener);
        }
    }

    public void cancelClearAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this);
            return;
        }
        setPaintAlpha(255);
        this.mIsFadingOut = false;
        this.mFadingHasStarted = false;
        removeCallbacks(this.mFadingOut);
        this.mPath.rewind();
        this.mCurrentGesture = null;
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void cancelGestureEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) motionEvent);
            return;
        }
        this.mIsListeningForGestures = false;
        this.mCurrentGesture.addStroke(new GestureStroke(this.mStrokeBuffer));
        if (motionEvent != null && motionEvent.getAction() != 1) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            obtain.setAction(3);
            ArrayList<ISlideGestureView.OnGestureListener> arrayList = this.mOnGestureListeners;
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                arrayList.get(i3).onGestureCancelled(this, obtain);
            }
            obtain.recycle();
        }
        clear(false);
        this.mIsGesturing = false;
        this.mPreviousWasGesturing = false;
        this.mStrokeBuffer.clear();
        ArrayList<ISlideGestureView.OnGesturingListener> arrayList2 = this.mOnGesturingListeners;
        for (int i16 = 0; i16 < arrayList2.size(); i16++) {
            arrayList2.get(i16).onGesturingEnded(this);
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void clear(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 43)) {
            clear(z16, false, true);
        } else {
            iPatchRedirector.redirect((short) 43, (Object) this, z16);
        }
    }

    public void clearCanvas() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this);
            return;
        }
        Handler handler = this.mRenderHandler;
        if (this.mIsEnableAsyncDrawSlideTrack && handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.ams.fusion.widget.slideinteractive.SlideGestureView.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SlideGestureView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        SlideGestureView.this.doClearCanvas();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        } else {
            doClearCanvas();
        }
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        Gesture gesture;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return ((Boolean) iPatchRedirector.redirect((short) 48, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (isEnabled()) {
            if ((this.mIsGesturing || ((gesture = this.mCurrentGesture) != null && gesture.getStrokesCount() > 0 && this.mPreviousWasGesturing)) && this.mInterceptEvents) {
                z16 = true;
            } else {
                z16 = false;
            }
            processEvent(motionEvent);
            if (z16) {
                motionEvent.setAction(3);
            }
            super.dispatchTouchEvent(motionEvent);
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.SurfaceView, android.view.View
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) canvas);
            return;
        }
        super.draw(canvas);
        if (this.mStop) {
            return;
        }
        Handler handler = this.mRenderHandler;
        if (this.mIsEnableAsyncDrawSlideTrack && handler != null) {
            handler.post(new Runnable() { // from class: com.tencent.ams.fusion.widget.slideinteractive.SlideGestureView.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SlideGestureView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        SlideGestureView.this.doDraw();
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            });
        } else {
            doDraw();
        }
    }

    public ArrayList<GesturePoint> getCurrentStroke() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ArrayList) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.mStrokeBuffer;
    }

    public long getFadeOffset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Long) iPatchRedirector.redirect((short) 28, (Object) this)).longValue();
        }
        return this.mFadeOffset;
    }

    public Gesture getGesture() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (Gesture) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.mCurrentGesture;
    }

    public int getGestureColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.mCertainGestureColor;
    }

    public Paint getGesturePaint() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return (Paint) iPatchRedirector.redirect((short) 40, (Object) this);
        }
        return this.mGesturePaint;
    }

    public Path getGesturePath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 24)) ? this.mPath : (Path) iPatchRedirector.redirect((short) 24, (Object) this);
    }

    public float getGestureStrokeAngleThreshold() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Float) iPatchRedirector.redirect((short) 17, (Object) this)).floatValue();
        }
        return this.mGestureStrokeAngleThreshold;
    }

    public float getGestureStrokeLengthThreshold() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Float) iPatchRedirector.redirect((short) 13, (Object) this)).floatValue();
        }
        return this.mGestureStrokeLengthThreshold;
    }

    public float getGestureStrokeSquarenessTreshold() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Float) iPatchRedirector.redirect((short) 15, (Object) this)).floatValue();
        }
        return this.mGestureStrokeSquarenessTreshold;
    }

    public int getGestureStrokeType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.mGestureStrokeType;
    }

    public float getGestureStrokeWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Float) iPatchRedirector.redirect((short) 9, (Object) this)).floatValue();
        }
        return this.mGestureStrokeWidth;
    }

    public int getOrientation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mOrientation;
    }

    public int getUncertainGestureColor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.mUncertainGestureColor;
    }

    public boolean isEventsInterceptionEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return this.mInterceptEvents;
    }

    public boolean isFadeEnabled() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        return this.mFadeEnabled;
    }

    public boolean isGestureVisible() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        return this.mGestureVisible;
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public boolean isGesturing() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            return ((Boolean) iPatchRedirector.redirect((short) 39, (Object) this)).booleanValue();
        }
        return this.mIsGesturing;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this);
            return;
        }
        Logger.i(TAG, NodeProps.ON_DETACHED_FROM_WINDOW);
        clearCanvas();
        super.onDetachedFromWindow();
        cancelClearAnimation();
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void removeAllOnGestureListeners() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
        } else {
            this.mOnGestureListeners.clear();
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void removeAllOnGesturePerformedListeners() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this);
        } else {
            this.mOnGesturePerformedListeners.clear();
            this.mHandleGestureActions = false;
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void removeAllOnGesturingListeners() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this);
        } else {
            this.mOnGesturingListeners.clear();
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void removeOnGestureListener(ISlideGestureView.OnGestureListener onGestureListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) onGestureListener);
        } else {
            this.mOnGestureListeners.remove(onGestureListener);
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void removeOnGesturePerformedListener(ISlideGestureView.OnGesturePerformedListener onGesturePerformedListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) onGesturePerformedListener);
            return;
        }
        this.mOnGesturePerformedListeners.remove(onGesturePerformedListener);
        if (this.mOnGesturePerformedListeners.size() <= 0) {
            this.mHandleGestureActions = false;
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void removeOnGesturingListener(ISlideGestureView.OnGesturingListener onGesturingListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) onGesturingListener);
        } else {
            this.mOnGesturingListeners.remove(onGesturingListener);
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void setDrawRect(Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) rect);
        } else {
            this.mDrawRect = rect;
        }
    }

    public void setEventsInterceptionEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
        } else {
            this.mInterceptEvents = z16;
        }
    }

    public void setFadeEnabled(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, z16);
        } else {
            this.mFadeEnabled = z16;
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void setFadeOffset(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, j3);
        } else {
            this.mFadeOffset = j3;
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void setGestureColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
        } else {
            this.mCertainGestureColor = i3;
        }
    }

    public void setGestureStrokeAngleThreshold(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Float.valueOf(f16));
        } else {
            this.mGestureStrokeAngleThreshold = f16;
        }
    }

    public void setGestureStrokeLengthThreshold(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Float.valueOf(f16));
        } else {
            this.mGestureStrokeLengthThreshold = f16;
        }
    }

    public void setGestureStrokeSquarenessTreshold(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, Float.valueOf(f16));
        } else {
            this.mGestureStrokeSquarenessTreshold = f16;
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void setGestureStrokeType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.mGestureStrokeType = i3;
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void setGestureStrokeWidth(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16));
            return;
        }
        this.mGestureStrokeWidth = f16;
        this.mInvalidateExtraBorder = Math.max(1, ((int) f16) - 1);
        this.mGesturePaint.setStrokeWidth(f16);
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void setGestureVisible(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, z16);
        } else {
            this.mGestureVisible = z16;
        }
    }

    public void setOrientation(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.mOrientation = i3;
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void setUncertainGestureColor(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.mUncertainGestureColor = i3;
        }
    }

    @Override // com.tencent.ams.fusion.widget.slideinteractive.ISlideGestureView
    public void stop() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this);
            return;
        }
        this.mStop = true;
        clearCanvas();
        stopRenderThread();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, this, surfaceHolder, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        } else {
            Logger.i(TAG, "surfaceChanged");
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, (Object) surfaceHolder);
            return;
        }
        Logger.i(TAG, "surfaceCreated");
        this.mSurfaceCreated = true;
        startRenderThread();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, (Object) surfaceHolder);
            return;
        }
        Logger.i(TAG, "surfaceDestroyed");
        this.mSurfaceCreated = false;
        clearCanvas();
        stopRenderThread();
    }

    private void clear(boolean z16, boolean z17, boolean z18) {
        setPaintAlpha(255);
        removeCallbacks(this.mFadingOut);
        this.mResetGesture = false;
        FadeOutRunnable fadeOutRunnable = this.mFadingOut;
        fadeOutRunnable.fireActionPerformed = z17;
        fadeOutRunnable.resetMultipleStrokes = false;
        if (z16 && this.mCurrentGesture != null) {
            this.mFadingAlpha = 1.0f;
            this.mIsFadingOut = true;
            this.mFadingHasStarted = false;
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            long j3 = this.mFadeOffset;
            this.mFadingStart = currentAnimationTimeMillis + j3;
            postDelayRender(this.mFadingOut, j3);
        } else {
            this.mFadingAlpha = 1.0f;
            this.mIsFadingOut = false;
            this.mFadingHasStarted = false;
            if (z18) {
                this.mCurrentGesture = null;
                this.mPath.rewind();
                invalidate();
            } else if (z17) {
                postDelayRender(fadeOutRunnable, this.mFadeOffset);
            } else if (this.mGestureStrokeType == 1) {
                fadeOutRunnable.resetMultipleStrokes = true;
                postDelayRender(fadeOutRunnable, this.mFadeOffset);
            } else {
                this.mCurrentGesture = null;
                this.mPath.rewind();
                invalidate();
            }
        }
        clearCanvas();
    }

    public Path getGesturePath(Path path) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (Path) iPatchRedirector.redirect((short) 25, (Object) this, (Object) path);
        }
        path.set(this.mPath);
        return path;
    }

    private void clearCanvas(Canvas canvas) {
        if (canvas != null) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
    }
}
