package com.tencent.component.media.gif;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.view.Gravity;
import com.tencent.component.media.utils.ImageManagerLog;
import com.tencent.thread.monitor.plugin.proxy.BaseScheduledThreadPoolExecutor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import libavif.AvifDecoder;
import libavif.AvifImage;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AvifGifDrawable extends Drawable implements Animatable {
    public static final boolean DEBUG = true;
    private static final long DEFAULT_DELAY_MS = 100;
    public static final int LOOP_DEFAULT = 3;
    public static final int LOOP_FINITE = 1;
    public static final int LOOP_INF = 2;
    private static final long MIN_DELAY_MS = 20;
    private static final String TAG = "AvifGifDrawable";
    private static final BitmapProvider sAllocatingBitmapProvider = new BitmapProvider() { // from class: com.tencent.component.media.gif.AvifGifDrawable.1
        @Override // com.tencent.component.media.gif.AvifGifDrawable.BitmapProvider
        public Bitmap acquireBitmap(int i3, int i16) {
            return Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        }

        @Override // com.tencent.component.media.gif.AvifGifDrawable.BitmapProvider
        public void releaseBitmap(Bitmap bitmap) {
        }
    };
    private final AvifDecoder mAvifDecoder;
    private final Bitmap mBitmap;
    private final BitmapProvider mBitmapProvider;
    private int mCurrentLoop;
    private final Runnable mDecodeTask;
    private ScheduledFuture<?> mDecodeTaskFuture;
    private boolean mDestroyed;
    private final Rect mDstRect;
    private final ScheduledThreadPoolExecutor mExecutor;
    private final Runnable mFinishedCallbackRunnable;
    private int mGravity;
    private int mHeight;
    private final Handler mInvalidateHandler;
    boolean mIsRunning;
    private final Object mLock;
    private int mLoopBehavior;
    private int mLoopCount;
    private long mNextFrameRenderTime;
    private OnFinishedListener mOnFinishedListener;
    private final Paint mPaint;
    private final Rect mSrcRect;
    private int mWidth;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    static final class AvifRenderingExecutor extends BaseScheduledThreadPoolExecutor {
        private static final AvifRenderingExecutor INSTANCE = new AvifRenderingExecutor();

        AvifRenderingExecutor() {
            super(1, new ThreadPoolExecutor.DiscardPolicy());
        }

        static AvifRenderingExecutor getInstance() {
            return INSTANCE;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface BitmapProvider {
        Bitmap acquireBitmap(int i3, int i16);

        void releaseBitmap(Bitmap bitmap);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface OnFinishedListener {
        void onFinished(AvifGifDrawable avifGifDrawable);
    }

    public AvifGifDrawable(AvifDecoder avifDecoder) {
        this(avifDecoder, sAllocatingBitmapProvider);
    }

    static /* synthetic */ int access$508(AvifGifDrawable avifGifDrawable) {
        int i3 = avifGifDrawable.mCurrentLoop;
        avifGifDrawable.mCurrentLoop = i3 + 1;
        return i3;
    }

    private static Bitmap acquireAndValidateBitmap(BitmapProvider bitmapProvider, int i3, int i16) {
        Bitmap acquireBitmap = bitmapProvider.acquireBitmap(i3, i16);
        if (acquireBitmap.getWidth() >= i3 && acquireBitmap.getHeight() >= i16 && acquireBitmap.getConfig() == Bitmap.Config.ARGB_8888) {
            return acquireBitmap;
        }
        throw new IllegalArgumentException("Invalid bitmap provided");
    }

    private void checkDestroyedLocked() {
        if (!this.mDestroyed) {
        } else {
            throw new IllegalStateException("Cannot perform operation on recycled drawable");
        }
    }

    private void scheduleNextRender() {
        if (isRunning()) {
            long j3 = this.mNextFrameRenderTime;
            if (j3 != Long.MIN_VALUE) {
                long max = Math.max(0L, j3 - SystemClock.uptimeMillis());
                this.mNextFrameRenderTime = Long.MIN_VALUE;
                this.mExecutor.remove(this.mDecodeTask);
                this.mDecodeTaskFuture = this.mExecutor.schedule(this.mDecodeTask, max, TimeUnit.MILLISECONDS);
            }
        }
    }

    public void destroy() {
        if (this.mBitmapProvider != null) {
            synchronized (this.mLock) {
                checkDestroyedLocked();
                this.mDestroyed = true;
            }
            this.mAvifDecoder.b();
            this.mBitmapProvider.releaseBitmap(this.mBitmap);
            return;
        }
        throw new IllegalStateException("BitmapProvider must be non-null");
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        synchronized (this.mLock) {
            int i3 = this.mGravity;
            if (i3 != 0) {
                Gravity.apply(i3, this.mBitmap.getWidth(), this.mBitmap.getHeight(), getBounds(), this.mDstRect);
                canvas.drawBitmap(this.mBitmap, this.mSrcRect, this.mDstRect, this.mPaint);
            } else {
                canvas.drawBitmap(this.mBitmap, this.mSrcRect, getBounds(), this.mPaint);
            }
        }
    }

    public int getGravity() {
        return this.mGravity;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public int getSize() {
        return this.mWidth * this.mHeight * 4;
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        super.invalidateSelf();
        scheduleNextRender();
    }

    public boolean isDestroyed() {
        boolean z16;
        synchronized (this.mLock) {
            z16 = this.mDestroyed;
        }
        return z16;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        boolean z16;
        synchronized (this.mLock) {
            if (this.mIsRunning && !this.mDestroyed) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.mPaint.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z16) {
        this.mPaint.setFilterBitmap(z16);
    }

    public void setGravity(int i3) {
        this.mGravity = i3;
    }

    public void setIntrinsicHeight(int i3) {
        this.mHeight = i3;
    }

    public void setIntrinsicWidth(int i3) {
        this.mWidth = i3;
    }

    public void setLoopBehavior(int i3) {
        this.mLoopBehavior = i3;
    }

    public void setLoopCount(int i3) {
        this.mLoopCount = i3;
    }

    public void setOnFinishedListener(OnFinishedListener onFinishedListener) {
        this.mOnFinishedListener = onFinishedListener;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z16, boolean z17) {
        boolean visible = super.setVisible(z16, z17);
        if (z16) {
            if (z17) {
                stop();
            }
            start();
        } else {
            stop();
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        synchronized (this.mLock) {
            if (this.mIsRunning) {
                return;
            }
            this.mIsRunning = true;
            checkDestroyedLocked();
            this.mNextFrameRenderTime = SystemClock.uptimeMillis();
            this.mCurrentLoop = 0;
            scheduleNextRender();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        synchronized (this.mLock) {
            if (!this.mIsRunning) {
                return;
            }
            this.mIsRunning = false;
            ScheduledFuture<?> scheduledFuture = this.mDecodeTaskFuture;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.mCurrentLoop = 0;
            this.mAvifDecoder.k();
        }
    }

    public AvifGifDrawable(AvifDecoder avifDecoder, BitmapProvider bitmapProvider) {
        this.mExecutor = AvifRenderingExecutor.getInstance();
        this.mInvalidateHandler = new Handler(Looper.getMainLooper()) { // from class: com.tencent.component.media.gif.AvifGifDrawable.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                AvifGifDrawable.this.invalidateSelf();
            }
        };
        this.mNextFrameRenderTime = Long.MIN_VALUE;
        this.mIsRunning = false;
        this.mPaint = new Paint(2);
        this.mLock = new Object();
        this.mDestroyed = false;
        this.mLoopBehavior = 3;
        this.mLoopCount = 1;
        this.mDecodeTask = new Runnable() { // from class: com.tencent.component.media.gif.AvifGifDrawable.3
            @Override // java.lang.Runnable
            public void run() {
                long j3;
                boolean z16;
                long j16;
                synchronized (AvifGifDrawable.this.mLock) {
                    AvifGifDrawable avifGifDrawable = AvifGifDrawable.this;
                    if (avifGifDrawable.mIsRunning && !avifGifDrawable.mDestroyed) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        if (AvifGifDrawable.this.mAvifDecoder.j()) {
                            try {
                                j3 = AvifGifDrawable.this.mAvifDecoder.f(AvifGifDrawable.this.mBitmap);
                                z16 = false;
                            } catch (Exception e16) {
                                ImageManagerLog.e(AvifGifDrawable.TAG, "exception during decode: " + e16);
                                j3 = 0L;
                                z16 = true;
                            }
                            if (j3 < 20) {
                                j3 = 100;
                            }
                            AvifGifDrawable avifGifDrawable2 = AvifGifDrawable.this;
                            if (z16) {
                                j16 = Long.MIN_VALUE;
                            } else {
                                j16 = uptimeMillis + j3;
                            }
                            avifGifDrawable2.mNextFrameRenderTime = j16;
                            if (AvifGifDrawable.this.mAvifDecoder.i() >= AvifGifDrawable.this.mAvifDecoder.h() - 1) {
                                AvifGifDrawable.access$508(AvifGifDrawable.this);
                                if (AvifGifDrawable.this.mLoopBehavior == 1 && AvifGifDrawable.this.mCurrentLoop == AvifGifDrawable.this.mLoopCount) {
                                    AvifGifDrawable avifGifDrawable3 = AvifGifDrawable.this;
                                    avifGifDrawable3.scheduleSelf(avifGifDrawable3.mFinishedCallbackRunnable, 0L);
                                } else {
                                    AvifGifDrawable.this.mAvifDecoder.k();
                                }
                            }
                            AvifGifDrawable.this.mInvalidateHandler.sendEmptyMessage(0);
                        }
                    }
                }
            }
        };
        this.mFinishedCallbackRunnable = new Runnable() { // from class: com.tencent.component.media.gif.AvifGifDrawable.4
            @Override // java.lang.Runnable
            public void run() {
                AvifGifDrawable.this.stop();
                if (AvifGifDrawable.this.mOnFinishedListener != null) {
                    AvifGifDrawable.this.mOnFinishedListener.onFinished(AvifGifDrawable.this);
                }
            }
        };
        if (avifDecoder != null && bitmapProvider != null) {
            this.mAvifDecoder = avifDecoder;
            avifDecoder.j();
            AvifImage g16 = avifDecoder.g();
            this.mWidth = g16.b();
            int a16 = g16.a();
            this.mHeight = a16;
            this.mBitmapProvider = bitmapProvider;
            Bitmap acquireAndValidateBitmap = acquireAndValidateBitmap(bitmapProvider, this.mWidth, a16);
            this.mBitmap = acquireAndValidateBitmap;
            this.mSrcRect = new Rect(0, 0, this.mWidth, this.mHeight);
            this.mDstRect = new Rect();
            this.mGravity = 0;
            avifDecoder.f(acquireAndValidateBitmap);
            return;
        }
        throw new IllegalArgumentException();
    }
}
