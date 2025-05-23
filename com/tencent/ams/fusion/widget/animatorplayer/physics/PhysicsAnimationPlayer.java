package com.tencent.ams.fusion.widget.animatorplayer.physics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.ViewGroup;
import com.tencent.ams.fusion.widget.animatorplayer.AnimationClickInfo;
import com.tencent.ams.fusion.widget.animatorplayer.AnimationItem;
import com.tencent.ams.fusion.widget.animatorplayer.AnimationPlayInfo;
import com.tencent.ams.fusion.widget.animatorplayer.AnimationPlayer;
import com.tencent.ams.fusion.widget.animatorplayer.physics.PhysicsEngine;
import com.tencent.ams.fusion.widget.utils.Logger;
import com.tencent.ams.fusion.widget.utils.Utils;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class PhysicsAnimationPlayer extends SurfaceView implements SurfaceHolder.Callback, AnimationPlayer {
    static IPatchRedirector $redirector_ = null;
    private static final int DEFAULT_TIME_GAP = 16;
    private static final int MIN_FRAME_GAP = 2;
    private static final String TAG = "PhysicsAnimationPlayer";
    private AnimationPlayer.AnimationClickListener mAnimationClickListener;
    private AnimationPlayer.AnimationPlayListener mAnimationPlayListener;
    private long mBaseTimeGap;
    private List<Rect> mBrokenAreaList;
    private final byte[] mDrawLock;
    private DrawThread mDrawThread;
    private volatile boolean mIsUserStarted;
    private volatile boolean mPaused;
    private PhysicsEngine mPhysicsEngine;
    private boolean mPlayCompleted;
    private final Matrix mRenderMatrix;
    private volatile boolean mSurfaceCreated;
    private final SurfaceHolder mSurfaceHolder;
    private int mTimeGap;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public final class DrawThread extends BaseThread {
        static IPatchRedirector $redirector_;
        private volatile boolean mRunning;

        DrawThread() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhysicsAnimationPlayer.this);
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Logger.d(PhysicsAnimationPlayer.TAG, "draw thread run start.");
            this.mRunning = true;
            long uptimeMillis = SystemClock.uptimeMillis();
            while (true) {
                if (!this.mRunning) {
                    break;
                }
                long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
                if (uptimeMillis2 > PhysicsAnimationPlayer.this.mTimeGap) {
                    uptimeMillis = SystemClock.uptimeMillis();
                    synchronized (PhysicsAnimationPlayer.this.mDrawLock) {
                        Canvas canvas = null;
                        try {
                            if (PhysicsAnimationPlayer.this.mPhysicsEngine == null) {
                                Logger.d(PhysicsAnimationPlayer.TAG, "mPhysicsEngine is null");
                            } else {
                                if (!PhysicsAnimationPlayer.this.mPaused) {
                                    if (PhysicsAnimationPlayer.this.mSurfaceHolder != null) {
                                        canvas = PhysicsAnimationPlayer.this.mSurfaceHolder.lockCanvas();
                                    }
                                    if (canvas != null) {
                                        PhysicsAnimationPlayer.this.mPhysicsEngine.dynamicLogic();
                                        PhysicsAnimationPlayer.this.drawCanvas(canvas);
                                    }
                                }
                                if (canvas != null) {
                                    try {
                                        PhysicsAnimationPlayer.this.mSurfaceHolder.unlockCanvasAndPost(canvas);
                                    } catch (Throwable th5) {
                                        th = th5;
                                        String str = PhysicsAnimationPlayer.TAG;
                                        String str2 = "unlock draw canvas error.";
                                        Logger.e(str, str2, th);
                                    }
                                }
                            }
                        } finally {
                            try {
                                if (canvas != null) {
                                    try {
                                    } catch (Throwable th6) {
                                        Logger.e(str, str2, th);
                                    }
                                }
                            } finally {
                            }
                        }
                    }
                    break;
                }
                try {
                    LockMethodProxy.sleep(Math.max(2L, PhysicsAnimationPlayer.this.mTimeGap - uptimeMillis2));
                } catch (InterruptedException e16) {
                    Logger.e(PhysicsAnimationPlayer.TAG, "DrawThread", e16);
                }
            }
            Logger.d(PhysicsAnimationPlayer.TAG, "draw thread run finish.");
        }

        public void stopThread() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            this.mRunning = false;
            try {
                interrupt();
            } catch (Throwable th5) {
                Logger.e(PhysicsAnimationPlayer.TAG, th5);
            }
        }

        /* synthetic */ DrawThread(PhysicsAnimationPlayer physicsAnimationPlayer, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) physicsAnimationPlayer, (Object) anonymousClass1);
        }
    }

    public PhysicsAnimationPlayer(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) viewGroup);
            return;
        }
        this.mPaused = false;
        this.mSurfaceCreated = false;
        this.mIsUserStarted = false;
        this.mDrawLock = new byte[0];
        this.mBrokenAreaList = new ArrayList();
        viewGroup.addView(this, new ViewGroup.LayoutParams(-1, -1));
        SurfaceHolder holder = getHolder();
        this.mSurfaceHolder = holder;
        if (!PhysicsAnimatorConfig.isEnablePhysicsHardware()) {
            setLayerType(1, null);
        }
        setZOrderOnTop(true);
        this.mRenderMatrix = new Matrix();
        if (holder != null) {
            holder.setFormat(-2);
            holder.addCallback(this);
        }
    }

    private void clearBrokenArea(Canvas canvas) {
        if (!Utils.isEmpty(this.mBrokenAreaList) && canvas != null) {
            for (Rect rect : this.mBrokenAreaList) {
                if (Build.VERSION.SDK_INT >= 26) {
                    canvas.clipOutRect(rect);
                } else {
                    canvas.clipRect(rect, Region.Op.DIFFERENCE);
                }
            }
            return;
        }
        Logger.d(TAG, "clearBrokenArea return");
    }

    private void clearCanvas(Canvas canvas) {
        if (canvas != null) {
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        }
    }

    private void drawBodyBox(Canvas canvas, AnimationItem animationItem) {
        AnimationItem.AnimationBody animationBody;
        if (canvas == null) {
            Logger.d(TAG, "drawBodyBox canvas is null ");
            return;
        }
        if (animationItem != null) {
            animationBody = animationItem.getBody();
        } else {
            animationBody = null;
        }
        if (animationBody != null) {
            int elementWidth = (int) (animationItem.getElementWidth() * animationBody.getScale());
            int elementHeight = ((int) (animationItem.getElementHeight() * animationBody.getScale())) / 2;
            this.mRenderMatrix.reset();
            this.mRenderMatrix.postScale(animationBody.getScale(), animationBody.getScale());
            this.mRenderMatrix.postRotate((float) ((animationBody.getAngle() * 180.0f) / 3.141592653589793d), elementWidth / 2, elementHeight);
            this.mRenderMatrix.postTranslate(animationBody.getElementX(), animationBody.getElementY());
            canvas.drawBitmap(animationItem.getBitmapElement(), this.mRenderMatrix, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drawCanvas(Canvas canvas) {
        if (canvas != null && this.mPhysicsEngine != null) {
            clearBrokenArea(canvas);
            clearCanvas(canvas);
            PhysicsEngine.AnimationItemIterator drawItemIterator = this.mPhysicsEngine.getDrawItemIterator();
            while (drawItemIterator.hasNext()) {
                drawBodyBox(canvas, drawItemIterator.next());
            }
            return;
        }
        Logger.d(TAG, "drawCanvas null");
    }

    private List<Rect> getBrokenAreaList(AnimationPlayInfo animationPlayInfo) {
        List<AnimationItem> list;
        if (animationPlayInfo != null) {
            list = animationPlayInfo.getAnimationItems();
        } else {
            list = null;
        }
        if (Utils.isEmpty(list)) {
            Logger.d(TAG, "itemList is null");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (AnimationItem animationItem : list) {
            if (animationItem != null && animationItem.getElementType() == 3) {
                arrayList.add(animationItem.getBrokenElement());
            }
        }
        return arrayList;
    }

    private void initAnimationEngine(AnimationPlayInfo animationPlayInfo) {
        if (animationPlayInfo == null) {
            return;
        }
        TBox2dPhysicsEngine tBox2dPhysicsEngine = new TBox2dPhysicsEngine(animationPlayInfo);
        this.mPhysicsEngine = tBox2dPhysicsEngine;
        tBox2dPhysicsEngine.setStepTimeGap(this.mTimeGap / 1000.0f);
        this.mPhysicsEngine.setEngineStateListener(new PhysicsEngineStateListener() { // from class: com.tencent.ams.fusion.widget.animatorplayer.physics.PhysicsAnimationPlayer.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhysicsAnimationPlayer.this);
                }
            }

            @Override // com.tencent.ams.fusion.widget.animatorplayer.physics.PhysicsEngineStateListener
            public void onAllBodySleep() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Logger.d(PhysicsAnimationPlayer.TAG, "onAllBodySleep");
                if (PhysicsAnimationPlayer.this.mAnimationPlayListener != null && !PhysicsAnimationPlayer.this.mPlayCompleted) {
                    PhysicsAnimationPlayer.this.mPlayCompleted = true;
                    PhysicsAnimationPlayer.this.mAnimationPlayListener.onComplete();
                }
            }
        });
    }

    private boolean isAnimationPlayInfoValid(AnimationPlayInfo animationPlayInfo) {
        if (animationPlayInfo == null) {
            AnimationPlayer.AnimationPlayListener animationPlayListener = this.mAnimationPlayListener;
            if (animationPlayListener != null) {
                animationPlayListener.onError(null, 102);
            }
            Logger.d(TAG, "mPlayInfo is null");
            return false;
        }
        if (Utils.isEmpty(animationPlayInfo.getAnimationItems())) {
            AnimationPlayer.AnimationPlayListener animationPlayListener2 = this.mAnimationPlayListener;
            if (animationPlayListener2 != null) {
                animationPlayListener2.onError(null, 101);
            }
            Logger.d(TAG, "mPlayInfo is null");
            return false;
        }
        for (AnimationItem animationItem : animationPlayInfo.getAnimationItems()) {
            int validAnimationItem = validAnimationItem(animationItem);
            if (validAnimationItem != 0) {
                Logger.d(TAG, "AnimationItem Parameter error" + validAnimationItem);
                AnimationPlayer.AnimationPlayListener animationPlayListener3 = this.mAnimationPlayListener;
                if (animationPlayListener3 != null) {
                    animationPlayListener3.onError(animationItem, validAnimationItem);
                }
                return false;
            }
        }
        return true;
    }

    private synchronized void startDrawThread() {
        DrawThread drawThread = this.mDrawThread;
        if (drawThread == null || !drawThread.isAlive()) {
            if (this.mDrawThread == null) {
                this.mDrawThread = new DrawThread(this, null);
            }
            this.mDrawThread.start();
            PhysicsEngine physicsEngine = this.mPhysicsEngine;
            if (physicsEngine != null) {
                physicsEngine.setAnimationBaseTime(SystemClock.uptimeMillis() - this.mBaseTimeGap);
            }
            AnimationPlayer.AnimationPlayListener animationPlayListener = this.mAnimationPlayListener;
            if (animationPlayListener != null) {
                animationPlayListener.onStart();
            }
        }
    }

    private synchronized void stopDrawThread() {
        DrawThread drawThread = this.mDrawThread;
        if (drawThread != null) {
            drawThread.stopThread();
        }
        this.mDrawThread = null;
    }

    private int validAnimationItem(AnimationItem animationItem) {
        if (animationItem == null) {
            return 106;
        }
        if (animationItem.getElementType() == 1) {
            if (animationItem.getBitmapElement() == null) {
                return 102;
            }
            if (animationItem.getElementWidth() > 0 && animationItem.getElementHeight() > 0) {
                if (animationItem.getBody() == null) {
                    return 105;
                }
                return 0;
            }
            return 103;
        }
        if (animationItem.getElementType() == 3 && animationItem.getBrokenElement() == null) {
            return 102;
        }
        return 0;
    }

    @Override // android.view.View, com.tencent.ams.fusion.widget.animatorplayer.AnimationPlayer
    public void clearAnimation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        Logger.d(TAG, "clearCanvas");
        if (!this.mSurfaceCreated) {
            Logger.w(TAG, "clearCanvas failed: surface destroyed");
        } else {
            stopDrawThread();
            clearCanvas(this.mSurfaceHolder);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) motionEvent)).booleanValue();
        }
        if (motionEvent == null) {
            return false;
        }
        if ((motionEvent.getAction() & 255) == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        PhysicsEngine physicsEngine = this.mPhysicsEngine;
        if (physicsEngine == null || !z16) {
            return false;
        }
        AnimationItem clickBoxItem = physicsEngine.getClickBoxItem(motionEvent.getX(), motionEvent.getY());
        if (this.mAnimationClickListener == null) {
            return false;
        }
        AnimationClickInfo animationClickInfo = new AnimationClickInfo();
        animationClickInfo.item = clickBoxItem;
        animationClickInfo.f70534x = motionEvent.getX();
        animationClickInfo.f70535y = motionEvent.getY();
        this.mAnimationClickListener.onAnimationClick(animationClickInfo);
        if (clickBoxItem == null) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.ams.fusion.widget.animatorplayer.AnimationPlayer
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        this.mPaused = true;
        if (this.mPhysicsEngine != null) {
            this.mBaseTimeGap = SystemClock.uptimeMillis() - this.mPhysicsEngine.getAnimationBaseTime();
        }
        stopDrawThread();
        clearCanvas(this.mSurfaceHolder);
        AnimationPlayer.AnimationPlayListener animationPlayListener = this.mAnimationPlayListener;
        if (animationPlayListener != null) {
            animationPlayListener.onPause();
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorplayer.AnimationPlayer
    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.mPaused = false;
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorplayer.AnimationPlayer
    public void setAnimationClickListener(AnimationPlayer.AnimationClickListener animationClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) animationClickListener);
        } else {
            this.mAnimationClickListener = animationClickListener;
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorplayer.AnimationPlayer
    public void setAnimationPlayInfo(AnimationPlayInfo animationPlayInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) animationPlayInfo);
            return;
        }
        if (isAnimationPlayInfoValid(animationPlayInfo)) {
            this.mBrokenAreaList = getBrokenAreaList(animationPlayInfo);
            if (animationPlayInfo.getFPS() > 0 && animationPlayInfo.getFPS() < 1000) {
                this.mTimeGap = 1000 / animationPlayInfo.getFPS();
            } else {
                this.mTimeGap = 16;
            }
            initAnimationEngine(animationPlayInfo);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorplayer.AnimationPlayer
    public void setAnimationPlayListener(AnimationPlayer.AnimationPlayListener animationPlayListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) animationPlayListener);
        } else {
            this.mAnimationPlayListener = animationPlayListener;
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorplayer.AnimationPlayer
    public void start() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.mIsUserStarted = true;
        this.mPlayCompleted = false;
        this.mBaseTimeGap = 0L;
        if (this.mSurfaceCreated) {
            startDrawThread();
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorplayer.AnimationPlayer
    public void stop() {
        AnimationPlayer.AnimationPlayListener animationPlayListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        stopDrawThread();
        clearCanvas(this.mSurfaceHolder);
        if (this.mIsUserStarted && (animationPlayListener = this.mAnimationPlayListener) != null) {
            animationPlayListener.onStop();
        }
        this.mIsUserStarted = false;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, surfaceHolder, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) surfaceHolder);
            return;
        }
        this.mSurfaceCreated = true;
        if (surfaceHolder == null) {
            Logger.d(TAG, "surfaceCreated: holder is null");
            return;
        }
        clearCanvas(surfaceHolder);
        if (this.mIsUserStarted) {
            startDrawThread();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) surfaceHolder);
        } else {
            this.mSurfaceCreated = false;
        }
    }

    private void clearCanvas(SurfaceHolder surfaceHolder) {
        Canvas canvas;
        try {
            canvas = surfaceHolder.lockCanvas();
        } catch (Throwable th5) {
            th = th5;
            canvas = null;
        }
        try {
            clearCanvas(canvas);
        } catch (Throwable th6) {
            th = th6;
            try {
                Logger.e(TAG, "clearCanvas", th);
                if (canvas == null) {
                }
            } finally {
                if (canvas != null) {
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }
        }
    }
}
