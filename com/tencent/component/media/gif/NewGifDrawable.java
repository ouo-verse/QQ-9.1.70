package com.tencent.component.media.gif;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.gif.NewGifDecoder;
import com.tencent.component.media.utils.ImageManagerLog;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes5.dex */
public class NewGifDrawable extends Drawable implements Animatable, GifPlayerControl {
    public static final int MODEL_NORMAL_LOOP = 1;
    public static final int MODEL_REVERSE_LOOP = 2;
    public static final int MODEL_WAIT = 3;
    public static final int MODEL_WAIT_FILE = 4;
    public static final int STATE_PLAYING = 2;
    public static final int STATE_PLAY_ANY_CASE = 0;
    public static final int STATE_PLAY_END = 3;
    public static final int STATE_PLAY_START = 1;
    private static final String TAG = "NewGifDrawable";
    private volatile int curPlayCount;
    private GifPlayListener gifPlayListener;
    public boolean isEndDownload;
    public Bitmap mBuffer;
    private long mCreateTime;
    private Handler mCtrlHandler;
    private int mCurrentModel;
    private long mDrawCounts;
    private final Rect mDstRect;
    final ScheduledThreadPoolExecutor mExecutor;
    private float mFactor;
    private float mFrameRate;
    private boolean mFrameRateReported;
    NewGifDecoder mGifDecoder;
    public int mHashcode;
    final InvalidationHandler mInvalidationHandler;
    protected boolean mIsRenderingTriggeredOnDraw;
    private volatile boolean mIsResetting;
    volatile boolean mIsRunning;
    private boolean mIsSharpp;
    final ConcurrentLinkedQueue<AnimationListener> mListeners;
    public final Object mLock4Bmp;
    private float mMaxFrameRate;
    long mNextFrameRenderTime;
    protected final Paint mPaint;
    private final RenderTask mRenderTask;
    ScheduledFuture<?> mSchedule;
    private final Rect mSrcRect;
    private long mStartTimeStamp;
    private StopRunnable mStopTask;
    private int mTaskType;
    private ColorStateList mTint;
    private PorterDuffColorFilter mTintFilter;
    private PorterDuff.Mode mTintMode;
    private int sHeight;
    private int sWidth;
    private Object tag;
    public String url;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface GifPlayListener {
        void onGifPlaying(NewGifDrawable newGifDrawable);

        void onGifStartPlay(NewGifDrawable newGifDrawable);

        void onGifStopPlay(NewGifDrawable newGifDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class StopRunnable implements Runnable {
        StopRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NewGifDrawable.this.waitForPendingRenderTask();
            try {
                NewGifDrawable.this.mGifDecoder.stop();
            } catch (Throwable th5) {
                ImageManagerLog.e(NewGifDrawable.TAG, Log.getStackTraceString(th5));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class WaitRunnable implements Runnable {
        long lastFrameRemainder;

        public WaitRunnable(long j3) {
            this.lastFrameRemainder = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            NewGifDrawable.this.waitForPendingRenderTask();
            NewGifDrawable newGifDrawable = NewGifDrawable.this;
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = newGifDrawable.mExecutor;
            RenderTask renderTask = newGifDrawable.mRenderTask;
            long j3 = this.lastFrameRemainder;
            if (j3 <= 0) {
                j3 = 0;
            }
            newGifDrawable.mSchedule = scheduledThreadPoolExecutor.schedule(renderTask, j3, TimeUnit.MILLISECONDS);
        }
    }

    public NewGifDrawable(Resources resources, int i3) throws Resources.NotFoundException, IOException {
        this(resources.openRawResourceFd(i3));
    }

    private synchronized void addDrawCount() {
        if (this.mStartTimeStamp != 0) {
            this.mDrawCounts++;
        }
    }

    public static NewGifDrawable createFromResource(Resources resources, int i3) {
        try {
            return new NewGifDrawable(resources, i3);
        } catch (IOException unused) {
            return null;
        }
    }

    private synchronized void endFrameRateStat() {
        if (!isSupportGifPlaying() && !this.mIsSharpp) {
            long currentTimeMillis = System.currentTimeMillis() - this.mStartTimeStamp;
            long frameDelay = this.mRenderTask.getFrameDelay();
            if (!this.mFrameRateReported) {
                long j3 = this.mDrawCounts;
                if (j3 > 0 && currentTimeMillis > 2000 && frameDelay > 0) {
                    this.mFrameRate = (float) ((j3 * 1000) / currentTimeMillis);
                    if (this.mMaxFrameRate == 0.0f) {
                        this.mMaxFrameRate = (float) (1000 / frameDelay);
                    }
                    ImageManagerLog.i(TAG, "frameRate:" + this.mFrameRate + ",maxFrameRate:" + this.mMaxFrameRate);
                    ImageManagerEnv.g().reportGifFrameRate(this.mTaskType, this.mFrameRate, this.mMaxFrameRate);
                    this.mFrameRateReported = true;
                }
            }
            this.mStartTimeStamp = 0L;
        }
    }

    private boolean isSupportGifPlaying() {
        int i3 = this.mCurrentModel;
        if (i3 != 4 && i3 != 3) {
            return false;
        }
        return true;
    }

    private void shutdown() {
        this.mIsRunning = false;
        this.gifPlayListener = null;
        this.mInvalidationHandler.removeMessages(0);
        this.mGifDecoder.recycle();
    }

    private synchronized void startFrameRateStat() {
        if (!isSupportGifPlaying() && !this.mIsSharpp) {
            this.mStartTimeStamp = System.currentTimeMillis();
            this.mDrawCounts = 0L;
        }
    }

    private PorterDuffColorFilter updateTintFilter(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList != null && mode != null) {
            return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void waitForPendingRenderTask() {
        ScheduledFuture<?> scheduledFuture = this.mSchedule;
        if (scheduledFuture != null) {
            try {
                scheduledFuture.get();
                this.mRenderTask.waitFinish();
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        this.mInvalidationHandler.removeMessages(0);
    }

    public void addAnimationListener(AnimationListener animationListener) {
        this.mListeners.add(animationListener);
    }

    @Override // com.tencent.component.media.gif.GifPlayerControl
    public boolean canPause() {
        return true;
    }

    @Override // com.tencent.component.media.gif.GifPlayerControl
    public boolean canSeekBackward() {
        if (getNumberOfFrames() > 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.component.media.gif.GifPlayerControl
    public boolean canSeekForward() {
        if (getNumberOfFrames() > 1) {
            return true;
        }
        return false;
    }

    public void changeFile(String str) {
        waitForPendingRenderTask();
        this.mGifDecoder.changeFile(str);
        this.mSchedule = this.mExecutor.schedule(this.mRenderTask, 0L, TimeUnit.MILLISECONDS);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        addDrawCount();
        boolean z16 = true;
        handlePlayCallBack(1);
        if (this.mTintFilter != null && this.mPaint.getColorFilter() == null) {
            this.mPaint.setColorFilter(this.mTintFilter);
        } else {
            z16 = false;
        }
        if (this.mPaint.getShader() == null) {
            synchronized (this.mLock4Bmp) {
                if (!this.mBuffer.isRecycled()) {
                    handlePlayCallBack(2);
                    canvas.drawBitmap(this.mBuffer, this.mSrcRect, this.mDstRect, this.mPaint);
                }
            }
        } else {
            canvas.drawRect(this.mDstRect, this.mPaint);
        }
        if (z16) {
            this.mPaint.setColorFilter(null);
        }
        if (this.mIsRenderingTriggeredOnDraw && this.mIsRunning) {
            long j3 = this.mNextFrameRenderTime;
            if (j3 != Long.MIN_VALUE) {
                long max = Math.max(0L, j3 - SystemClock.uptimeMillis());
                this.mNextFrameRenderTime = Long.MIN_VALUE;
                this.mExecutor.remove(this.mRenderTask);
                this.mSchedule = this.mExecutor.schedule(this.mRenderTask, max, TimeUnit.MILLISECONDS);
            }
        }
        handlePlayCallBack(3);
    }

    public void finalize() throws Throwable {
        try {
            if (!isRecycled()) {
                recycle();
            }
        } finally {
            super.finalize();
        }
    }

    @TargetApi(19)
    public long getAllocationByteCount() {
        return this.mGifDecoder.getAllocationByteCount() + this.mBuffer.getAllocationByteCount();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mPaint.getAlpha();
    }

    public Bitmap.Config getBitmapConfig() {
        Bitmap bitmap = this.mBuffer;
        if (bitmap != null) {
            return bitmap.getConfig();
        }
        return this.mGifDecoder.getAcceptableConfig();
    }

    @Override // com.tencent.component.media.gif.GifPlayerControl
    public int getBufferPercentage() {
        return 100;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.mPaint.getColorFilter();
    }

    public String getComment() {
        return this.mGifDecoder.getComment();
    }

    public int getCurPlayCount() {
        return this.curPlayCount;
    }

    public Bitmap getCurrentFrame() {
        Bitmap copy;
        synchronized (this.mLock4Bmp) {
            Bitmap bitmap = this.mBuffer;
            copy = bitmap.copy(bitmap.getConfig(), this.mBuffer.isMutable());
        }
        return copy;
    }

    public int getCurrentFrameIndex() {
        return this.mGifDecoder.getCurrentFrameIndex();
    }

    public int getCurrentLoop() {
        return this.mGifDecoder.getCurrentLoop();
    }

    public int getCurrentModel() {
        return this.mCurrentModel;
    }

    @Override // com.tencent.component.media.gif.GifPlayerControl
    public int getCurrentPosition() {
        return this.mGifDecoder.getCurrentPosition();
    }

    @Override // com.tencent.component.media.gif.GifPlayerControl
    public int getDuration() {
        return this.mGifDecoder.getDuration();
    }

    public GifError getError() {
        return GifError.fromCode(this.mGifDecoder.getError());
    }

    public Bitmap getFrame(int i3) {
        Bitmap currentFrame;
        if (i3 >= 0) {
            synchronized (this.mLock4Bmp) {
                this.mBuffer = this.mGifDecoder.seekToFrame(i3, this.mBuffer);
                currentFrame = getCurrentFrame();
            }
            return currentFrame;
        }
        throw new IndexOutOfBoundsException("Frame index is not positive");
    }

    public int getFrameByteCount() {
        return this.mBuffer.getRowBytes() * this.mBuffer.getHeight();
    }

    public int getFrameDuration(int i3) {
        return this.mGifDecoder.getFrameDuration(i3);
    }

    public GifPlayListener getGifPlayListener() {
        return this.gifPlayListener;
    }

    public int getImageCount() {
        return this.mGifDecoder.getImageCount();
    }

    public long getInputSourceByteCount() {
        return this.mGifDecoder.getSourceLength();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        int i3 = this.sHeight;
        if (i3 == 0) {
            return this.mGifDecoder.getHeight();
        }
        return i3;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        int i3 = this.sWidth;
        if (i3 == 0) {
            return this.mGifDecoder.getWidth();
        }
        return i3;
    }

    public int getLoopCount() {
        return this.mGifDecoder.getLoopCount();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.mGifDecoder.getHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.mGifDecoder.getWidth();
    }

    public int getNumberOfFrames() {
        return this.mGifDecoder.getFrameCount();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public final Paint getPaint() {
        return this.mPaint;
    }

    public int getPixel(int i3, int i16) {
        if (i3 < this.mGifDecoder.getWidth()) {
            if (i16 < this.mGifDecoder.getHeight()) {
                synchronized (this.mLock4Bmp) {
                    this.mBuffer.getPixel(i3, i16);
                }
                return 0;
            }
            throw new IllegalArgumentException("y must be < height");
        }
        throw new IllegalArgumentException("x must be < width");
    }

    public void getPixels(int[] iArr) {
        synchronized (this.mLock4Bmp) {
            this.mBuffer.getPixels(iArr, 0, this.mGifDecoder.getWidth(), 0, 0, this.mGifDecoder.getWidth(), this.mGifDecoder.getHeight());
        }
    }

    public float getSpeedFactor() {
        float f16 = this.mFactor;
        if (f16 <= 0.0f) {
            return 1.0f;
        }
        return f16;
    }

    public Object getTag() {
        return this.tag;
    }

    public String getUrl() {
        return this.url;
    }

    public int getsHeight() {
        return this.mGifDecoder.getHeight();
    }

    public int getsWidth() {
        return this.mGifDecoder.getWidth();
    }

    protected void handlePlayCallBack(int i3) {
        if (this.gifPlayListener != null) {
            int currentFrameIndex = getCurrentFrameIndex();
            int numberOfFrames = getNumberOfFrames();
            int loopCount = getLoopCount();
            if ((i3 == 3 || i3 == 0) && currentFrameIndex == numberOfFrames - 1) {
                this.curPlayCount++;
            }
            if ((i3 == 1 || i3 == 0) && ((this.curPlayCount == 0 || loopCount == 0) && currentFrameIndex == 0)) {
                this.gifPlayListener.onGifStartPlay(this);
            }
            if ((i3 == 2 || i3 == 0) && currentFrameIndex > 0 && currentFrameIndex < numberOfFrames - 1 && (this.curPlayCount < loopCount || loopCount == 0)) {
                this.gifPlayListener.onGifPlaying(this);
            }
            if ((i3 == 3 || i3 == 0) && currentFrameIndex == numberOfFrames - 1) {
                if (this.curPlayCount == loopCount || loopCount == 0) {
                    this.gifPlayListener.onGifStopPlay(this);
                    if (this.curPlayCount >= Integer.MAX_VALUE) {
                        this.curPlayCount = 0;
                    }
                }
            }
        }
    }

    public boolean isAnimationCompleted() {
        return this.mGifDecoder.isAnimationCompleted();
    }

    public void isEndDownload() {
        this.mGifDecoder.setLoopCount(0);
        this.isEndDownload = true;
    }

    @Override // com.tencent.component.media.gif.GifPlayerControl
    public boolean isPlaying() {
        return this.mIsRunning;
    }

    public synchronized boolean isRecycled() {
        NewGifDecoder newGifDecoder = this.mGifDecoder;
        if (newGifDecoder == null) {
            return true;
        }
        return newGifDecoder.isRecycled();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        ColorStateList colorStateList;
        if (!super.isStateful() && ((colorStateList = this.mTint) == null || !colorStateList.isStateful())) {
            return false;
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.mDstRect.set(rect);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        ColorStateList colorStateList = this.mTint;
        if (colorStateList != null && (mode = this.mTintMode) != null) {
            this.mTintFilter = updateTintFilter(colorStateList, mode);
            return true;
        }
        return false;
    }

    @Override // com.tencent.component.media.gif.GifPlayerControl
    public void pause() {
        stop();
    }

    public synchronized void recycle() {
        shutdown();
        if (ImageManagerEnv.g().isNeedRecycle()) {
            synchronized (this.mLock4Bmp) {
                this.mBuffer.recycle();
            }
        }
    }

    public void recycleForGifPlay() {
        ImageManagerLog.e(TAG, "NewGifDrawable recycleForGifPlay");
        this.curPlayCount = 0;
        this.mIsRunning = false;
        waitForPendingRenderTask();
        try {
            this.mGifDecoder.stop();
            recycle();
        } catch (Throwable th5) {
            ImageManagerLog.e(TAG, th5.getMessage());
        }
    }

    public boolean removeAnimationListener(AnimationListener animationListener) {
        return this.mListeners.remove(animationListener);
    }

    public synchronized void reset() {
        if (this.mIsResetting) {
            ImageManagerLog.w(TAG, "it is resetting");
            return;
        }
        endFrameRateStat();
        this.mIsResetting = true;
        this.curPlayCount = 0;
        this.mIsRunning = false;
        this.mCtrlHandler.post(new Runnable() { // from class: com.tencent.component.media.gif.NewGifDrawable.1
            @Override // java.lang.Runnable
            public void run() {
                NewGifDrawable.this.waitForPendingRenderTask();
                NewGifDrawable newGifDrawable = NewGifDrawable.this;
                newGifDrawable.mExecutor.execute(new SafeRunnable(newGifDrawable) { // from class: com.tencent.component.media.gif.NewGifDrawable.1.1
                    @Override // com.tencent.component.media.gif.SafeRunnable
                    public void doWork() {
                        ImageManagerLog.e(NewGifDrawable.TAG, "reset");
                        if (NewGifDrawable.this.mGifDecoder.reset()) {
                            NewGifDrawable.this.start();
                        }
                        NewGifDrawable.this.mIsResetting = false;
                    }
                });
            }
        });
    }

    @Override // com.tencent.component.media.gif.GifPlayerControl
    public void seekTo(final int i3) {
        if (i3 >= 0) {
            this.mExecutor.execute(new SafeRunnable(this) { // from class: com.tencent.component.media.gif.NewGifDrawable.2
                @Override // com.tencent.component.media.gif.SafeRunnable
                public void doWork() {
                    synchronized (NewGifDrawable.this.mLock4Bmp) {
                        NewGifDrawable newGifDrawable = NewGifDrawable.this;
                        newGifDrawable.mBuffer = newGifDrawable.mGifDecoder.seekToTime(i3, newGifDrawable.mBuffer);
                    }
                    if (!this.mGifDrawable.mInvalidationHandler.hasMessages(0)) {
                        this.mGifDrawable.mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
                    }
                }
            });
            return;
        }
        throw new IllegalArgumentException("Position is not positive");
    }

    public void seekToFrame(final int i3) {
        if (i3 >= 0) {
            this.mExecutor.execute(new SafeRunnable(this) { // from class: com.tencent.component.media.gif.NewGifDrawable.3
                @Override // com.tencent.component.media.gif.SafeRunnable
                public void doWork() {
                    synchronized (NewGifDrawable.this.mLock4Bmp) {
                        NewGifDrawable newGifDrawable = NewGifDrawable.this;
                        newGifDrawable.mBuffer = newGifDrawable.mGifDecoder.seekToFrame(i3, newGifDrawable.mBuffer);
                    }
                    if (!NewGifDrawable.this.mInvalidationHandler.hasMessages(0)) {
                        NewGifDrawable.this.mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
                    }
                }
            });
            return;
        }
        throw new IndexOutOfBoundsException("Frame index is not positive");
    }

    public Bitmap seekToFrameAndGet(int i3) {
        Bitmap currentFrame;
        if (i3 >= 0) {
            synchronized (this.mLock4Bmp) {
                this.mBuffer = this.mGifDecoder.seekToFrame(i3, this.mBuffer);
                currentFrame = getCurrentFrame();
            }
            if (!this.mInvalidationHandler.hasMessages(0)) {
                this.mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
            }
            return currentFrame;
        }
        throw new IndexOutOfBoundsException("Frame index is not positive");
    }

    public Bitmap seekToPositionAndGet(int i3) {
        Bitmap currentFrame;
        if (i3 >= 0) {
            synchronized (this.mLock4Bmp) {
                this.mBuffer = this.mGifDecoder.seekToTime(i3, this.mBuffer);
                currentFrame = getCurrentFrame();
            }
            if (!this.mInvalidationHandler.hasMessages(0)) {
                this.mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
            }
            return currentFrame;
        }
        throw new IllegalArgumentException("Position is not positive");
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.mPaint.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public void setCurPlayCount(int i3) {
        this.curPlayCount = i3;
    }

    public void setCurrentModel(int i3) {
        this.mCurrentModel = i3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z16) {
        this.mPaint.setDither(z16);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z16) {
        this.mPaint.setFilterBitmap(z16);
        invalidateSelf();
    }

    public void setGifPlayListener(GifPlayListener gifPlayListener) {
        this.gifPlayListener = gifPlayListener;
    }

    public void setIntrinsicHeight(int i3) {
        if (this.sHeight == 0) {
            this.sHeight = i3;
        }
    }

    public void setIntrinsicWidth(int i3) {
        if (this.sWidth == 0) {
            this.sWidth = i3;
        }
    }

    public void setLoopCount(int i3) {
        this.mGifDecoder.setLoopCount(i3);
    }

    public void setSpeed(float f16) {
        try {
            this.mGifDecoder.setSpeed(f16);
            this.mFactor = f16;
        } catch (UnsatisfiedLinkError e16) {
            ImageManagerLog.e(TAG, Log.getStackTraceString(e16));
        }
    }

    public void setSrcRect(Rect rect) {
        if (rect != null) {
            this.mSrcRect.set(rect);
        }
    }

    public void setTag(Object obj) {
        this.tag = obj;
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.mTint = colorStateList;
        this.mTintFilter = updateTintFilter(colorStateList, this.mTintMode);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.mTintMode = mode;
        this.mTintFilter = updateTintFilter(this.mTint, mode);
        invalidateSelf();
    }

    public void setUrl(String str) {
        this.url = str;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z16, boolean z17) {
        boolean visible = super.setVisible(z16, z17);
        if (z16) {
            start();
        } else if (visible) {
            stop();
        }
        return visible;
    }

    public void setmCreateTime(long j3) {
        this.mCreateTime = j3;
    }

    @Override // android.graphics.drawable.Animatable, com.tencent.component.media.gif.GifPlayerControl
    public void start() {
        this.mIsRunning = true;
        long start = this.mGifDecoder.start();
        if (isSupportGifPlaying()) {
            startAnimation(0L);
        } else {
            startAnimation(start);
        }
        startFrameRateStat();
    }

    void startAnimation(long j3) {
        if (this.mIsRenderingTriggeredOnDraw) {
            this.mNextFrameRenderTime = 0L;
            if (!this.mInvalidationHandler.hasMessages(0)) {
                this.mInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
                return;
            } else {
                ImageManagerLog.d(TAG, "startAnimation: already has one message");
                return;
            }
        }
        this.mCtrlHandler.post(new WaitRunnable(j3));
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        endFrameRateStat();
        this.curPlayCount = 0;
        this.mIsRunning = false;
        this.mCtrlHandler.post(this.mStopTask);
    }

    public String toString() {
        return String.format(Locale.US, "GIF: size: %dx%d, frames: %d, error: %d", Integer.valueOf(this.mGifDecoder.getWidth()), Integer.valueOf(this.mGifDecoder.getHeight()), Integer.valueOf(this.mGifDecoder.getFrameCount()), Integer.valueOf(this.mGifDecoder.getError()));
    }

    public void updateFile(String str) {
        waitForPendingRenderTask();
        this.mGifDecoder.updateFile(str);
        this.mSchedule = this.mExecutor.schedule(this.mRenderTask, 0L, TimeUnit.MILLISECONDS);
    }

    public NewGifDrawable(AssetManager assetManager, String str) throws IOException {
        this(assetManager.openFd(str));
    }

    public NewGifDrawable(String str) throws IOException {
        this(GifInfoHandle.openFile(str, false, null), null, null, true, null);
    }

    public NewGifDrawable(String str, NewGifDecoder.Options options, String str2) throws IOException {
        this(GifInfoHandle.openFile(str, false, options), null, null, true, options);
        this.url = str2;
    }

    public NewGifDrawable(String str, NewGifDecoder.Options options) throws IOException {
        this(GifInfoHandle.openFile(str, false, options), null, null, true, options);
    }

    public NewGifDrawable(File file) throws IOException {
        this(GifInfoHandle.openFile(file.getPath(), false, null), null, null, true, null);
    }

    public NewGifDrawable(InputStream inputStream) throws IOException {
        this(GifInfoHandle.openMarkableInputStream(inputStream, false, null), null, null, true, null);
    }

    public NewGifDrawable(AssetFileDescriptor assetFileDescriptor) throws IOException {
        this(GifInfoHandle.openAssetFileDescriptor(assetFileDescriptor, false, null), null, null, true, null);
    }

    public NewGifDrawable(FileDescriptor fileDescriptor) throws IOException {
        this(GifInfoHandle.openFd(fileDescriptor, 0L, false, null), null, null, true, null);
    }

    public NewGifDrawable(byte[] bArr) throws IOException {
        this(GifInfoHandle.openByteArray(bArr, false, null), null, null, true, null);
    }

    public NewGifDrawable(ByteBuffer byteBuffer) throws IOException {
        this(GifInfoHandle.openDirectByteBuffer(byteBuffer, false, null), null, null, true, null);
    }

    public NewGifDrawable(ContentResolver contentResolver, Uri uri) throws IOException {
        this(GifInfoHandle.openUri(contentResolver, uri, false, null), null, null, true, null);
    }

    public NewGifDrawable(NewGifDecoder newGifDecoder) {
        this(newGifDecoder, null, null, true, 1, null);
    }

    public NewGifDrawable(NewGifDecoder newGifDecoder, NewGifDecoder.Options options) {
        this(newGifDecoder, null, null, true, 1, options);
    }

    public NewGifDrawable(NewGifDecoder newGifDecoder, String str) {
        this(newGifDecoder, null, null, true, 1, null);
        this.url = str;
    }

    NewGifDrawable(GifInfoHandle gifInfoHandle, NewGifDrawable newGifDrawable, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, boolean z16, NewGifDecoder.Options options) {
        this(new GenericNewGifDecoder(gifInfoHandle), newGifDrawable, scheduledThreadPoolExecutor, z16, 1, options);
    }

    public NewGifDrawable(String str, int i3, NewGifDecoder.Options options, int i16) throws IOException {
        this(new GenericNewGifDecoder(GifInfoHandle.openFileForGifPlaying(str, false, options)), null, null, false, i3, i16, options);
    }

    public NewGifDrawable(File file, int i3) throws IOException {
        this(new GenericNewGifDecoder(GifInfoHandle.openFileForGifPlaying(file.getPath(), false, null)), null, null, false, i3, null);
    }

    NewGifDrawable(NewGifDecoder newGifDecoder, NewGifDrawable newGifDrawable, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, boolean z16, int i3, NewGifDecoder.Options options) {
        this(newGifDecoder, null, null, false, i3, 0, options);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.tencent.component.media.gif.NewGifDrawable$1] */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    NewGifDrawable(NewGifDecoder newGifDecoder, NewGifDrawable newGifDrawable, ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, boolean z16, int i3, int i16, NewGifDecoder.Options options) {
        this.mIsRunning = true;
        this.mNextFrameRenderTime = Long.MIN_VALUE;
        this.mDstRect = new Rect();
        this.sWidth = 0;
        this.sHeight = 0;
        this.mPaint = new Paint(6);
        this.mListeners = new ConcurrentLinkedQueue<>();
        this.mIsRenderingTriggeredOnDraw = true;
        this.mHashcode = 0;
        this.mFactor = 1.0f;
        this.mCurrentModel = 1;
        this.mLock4Bmp = new Object();
        this.isEndDownload = false;
        this.mCtrlHandler = new Handler(ImageManagerEnv.g().getDispatcher());
        Bitmap bitmap = 0;
        bitmap = 0;
        bitmap = 0;
        bitmap = 0;
        this.mStopTask = new StopRunnable();
        this.mIsRenderingTriggeredOnDraw = z16;
        this.mExecutor = scheduledThreadPoolExecutor == null ? GifRenderingExecutor.getInstance() : scheduledThreadPoolExecutor;
        this.mHashcode = i16;
        this.mGifDecoder = newGifDecoder;
        if (i3 == 1) {
            newGifDecoder.setLoopCount(0);
            setCurrentModel(i3);
        } else {
            newGifDecoder.setLoopCount(1);
            setCurrentModel(i3);
        }
        if (newGifDecoder instanceof SharpPNewGifDecoder) {
            this.mIsSharpp = true;
        }
        if (ImageManagerEnv.g().isPreferNewGifDecodeTask() && !this.mIsSharpp && !isSupportGifPlaying()) {
            this.mRenderTask = new PrepareAndRenderTask(this);
            this.mTaskType = 2;
        } else {
            this.mRenderTask = new RenderTask(this);
            this.mTaskType = 1;
        }
        if (newGifDrawable != null) {
            synchronized (newGifDrawable.mLock4Bmp) {
                if (!newGifDrawable.mGifDecoder.isRecycled() && newGifDrawable.mGifDecoder.getHeight() >= this.mGifDecoder.getHeight() && newGifDrawable.mGifDecoder.getWidth() >= this.mGifDecoder.getWidth()) {
                    newGifDrawable.shutdown();
                    Bitmap bitmap2 = newGifDrawable.mBuffer;
                    bitmap2.eraseColor(0);
                    bitmap = bitmap2;
                }
            }
        }
        if (bitmap == 0) {
            Bitmap.Config config = Bitmap.Config.ARGB_8888;
            if (ImageManagerEnv.g().isGifSupport565() && !isSupportGifPlaying() && !this.mIsSharpp) {
                if (options != null && options.inPreferredConfig == Bitmap.Config.ARGB_8888) {
                    ImageManagerLog.w(TAG, "prefer to decode as 8888");
                } else {
                    config = this.mGifDecoder.getAcceptableConfig();
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(this.mGifDecoder.getWidth(), this.mGifDecoder.getHeight(), config);
            this.mBuffer = createBitmap;
            if (config == Bitmap.Config.ARGB_8888) {
                createBitmap.eraseColor(0);
            } else {
                createBitmap.eraseColor(Color.parseColor("#DFDFDF"));
            }
        } else {
            this.mBuffer = bitmap;
        }
        this.mSrcRect = new Rect(0, 0, this.mGifDecoder.getWidth(), this.mGifDecoder.getHeight());
        this.mInvalidationHandler = new InvalidationHandler(this);
        if (isSupportGifPlaying()) {
            return;
        }
        reset();
    }
}
