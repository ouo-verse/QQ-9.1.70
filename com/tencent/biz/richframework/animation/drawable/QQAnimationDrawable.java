package com.tencent.biz.richframework.animation.drawable;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.lang.ref.SoftReference;
import java.util.AbstractCollection;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QQAnimationDrawable extends Drawable implements Runnable, Animatable {
    private static final ExecutorService THREAD_POOL_EXECUTOR = ProxyExecutors.newSingleThreadExecutor();
    private static final byte[] sInTempStorage = new byte[24576];
    private boolean isParenMethod;
    private QQAnimationListener mAnimationListener;
    private int mCountOfFrame;
    protected int mCurFrame;
    private Bitmap mCurrBitmap;
    private boolean mDecodeNextFrameEnd;
    private long mDuration;
    private final SerialExecutor mExecutor;
    private Bitmap mFirstBitmap;
    private long mFrameInterval;
    private boolean mIsStart;
    private int mListLength;
    private final Object mLockObj;
    private Bitmap mNextBitmap;
    private int mNextFrame;
    private boolean mOneShot;
    private final Paint mPaint;
    private String[] mPngPaths;
    private int mRepeatCount;
    private int mRequestHeight;
    private int mRequestWidth;
    private final Set<SoftReference<Bitmap>> mReusableBitmaps;
    private int mTargetDensity;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface QQAnimationListener {
        void onPlay(int i3);

        void onStart();

        void onStop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class SerialExecutor implements Executor {
        Runnable mActive;
        final Task<Runnable> mTasks;

        SerialExecutor() {
            this.mTasks = new Task<>();
        }

        protected synchronized void clear() {
            this.mTasks.clear();
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(final Runnable runnable) {
            this.mTasks.offer(new Runnable() { // from class: com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable.SerialExecutor.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        runnable.run();
                    } finally {
                        SerialExecutor.this.scheduleNext();
                    }
                }
            });
            if (this.mActive == null) {
                scheduleNext();
            }
        }

        protected synchronized void scheduleNext() {
            try {
                Runnable poll = this.mTasks.poll();
                this.mActive = poll;
                if (poll != null) {
                    QQAnimationDrawable.THREAD_POOL_EXECUTOR.execute(this.mActive);
                }
            } catch (OutOfMemoryError e16) {
                RFWLog.e("QQAnimationDrawable", RFWLog.USR, "scheduleNext OutOfMemoryError:" + e16.getMessage(), e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class Task<T> {
        final AbstractCollection<T> task = new ArrayDeque();

        public void clear() {
            this.task.clear();
        }

        public void offer(T t16) {
            AbstractCollection<T> abstractCollection = this.task;
            if (abstractCollection instanceof ArrayDeque) {
                ((ArrayDeque) abstractCollection).offer(t16);
            }
        }

        public T poll() {
            AbstractCollection<T> abstractCollection = this.task;
            if (abstractCollection instanceof ArrayDeque) {
                return (T) ((ArrayDeque) abstractCollection).poll();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class WorkerRunnable implements Runnable {
        private long drawTime;
        private int frame;

        public WorkerRunnable(int i3, long j3) {
            this.frame = i3;
            this.drawTime = j3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Process.setThreadPriority(10);
            long uptimeMillis = SystemClock.uptimeMillis();
            QQAnimationDrawable qQAnimationDrawable = QQAnimationDrawable.this;
            qQAnimationDrawable.mNextBitmap = qQAnimationDrawable.getBitmap(this.frame);
            QQAnimationDrawable.this.mNextFrame = this.frame;
            if (QQAnimationDrawable.this.mFirstBitmap == null && this.frame == 0) {
                QQAnimationDrawable qQAnimationDrawable2 = QQAnimationDrawable.this;
                qQAnimationDrawable2.mFirstBitmap = qQAnimationDrawable2.mNextBitmap;
            }
            if (QQAnimationDrawable.this.mAnimationListener != null) {
                QQAnimationDrawable.this.mAnimationListener.onPlay(this.frame);
            }
            QQAnimationDrawable qQAnimationDrawable3 = QQAnimationDrawable.this;
            qQAnimationDrawable3.scheduleSelf(qQAnimationDrawable3, SystemClock.uptimeMillis() + Math.max(this.drawTime - uptimeMillis, 0L));
        }
    }

    public QQAnimationDrawable() {
        this(null);
    }

    private void addInBitmapOptions(BitmapFactory.Options options) {
        options.inMutable = true;
        Bitmap bitmapFromReusableSet = getBitmapFromReusableSet(options);
        if (bitmapFromReusableSet != null) {
            options.inBitmap = bitmapFromReusableSet;
        }
    }

    private Bitmap decodeBitmap(String str) {
        Bitmap bitmap = null;
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inTempStorage = sInTempStorage;
            BitmapFactory.decodeFile(str, options);
            int i3 = this.mRequestWidth;
            if (i3 <= 0) {
                i3 = RFWApplication.getApplication().getResources().getDisplayMetrics().widthPixels;
            }
            int i16 = this.mRequestHeight;
            if (i16 <= 0) {
                i16 = RFWApplication.getApplication().getResources().getDisplayMetrics().heightPixels;
            }
            int calculateInSampleSize = BitmapUtil.calculateInSampleSize(options, i3, i16);
            options.inJustDecodeBounds = false;
            options.inSampleSize = calculateInSampleSize;
            addInBitmapOptions(options);
            bitmap = BitmapFactory.decodeFile(str, options);
            if (bitmap == null) {
                RFWLog.w("QQAnimationDrawable", RFWLog.USR, "decode failed path:" + str);
            }
            if (bitmap != null && !bitmap.isRecycled()) {
                this.mReusableBitmaps.add(new SoftReference<>(bitmap));
            }
        } catch (Exception unused) {
            RFWLog.w("QQAnimationDrawable", RFWLog.USR, "decode exception");
        } catch (OutOfMemoryError e16) {
            RFWLog.e("QQAnimationDrawable", RFWLog.USR, "decode outOoMemory", e16);
        }
        return bitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized Bitmap getBitmap(int i3) {
        Bitmap bitmap;
        String str;
        String[] strArr = this.mPngPaths;
        if (strArr != null && i3 < strArr.length && (str = strArr[i3]) != null) {
            bitmap = decodeBitmap(str);
        } else {
            bitmap = null;
        }
        if (bitmap == null) {
            return this.mNextBitmap;
        }
        return bitmap;
    }

    private void loadNextBitmap(boolean z16, boolean z17, boolean z18) {
        long uptimeMillis;
        boolean z19 = true;
        int i3 = this.mCurFrame + 1;
        if (i3 > this.mCountOfFrame) {
            i3 = 0;
        }
        if (z17) {
            unscheduleSelf(this);
        }
        if ((!this.mOneShot && this.mRepeatCount > 0) || i3 < this.mCountOfFrame) {
            z19 = false;
        }
        if (!z19 && this.mDecodeNextFrameEnd && z18) {
            this.mDecodeNextFrameEnd = false;
            if (z16) {
                uptimeMillis = 0;
            } else {
                uptimeMillis = SystemClock.uptimeMillis() + this.mFrameInterval;
            }
            this.mExecutor.execute(new WorkerRunnable(i3, uptimeMillis));
        }
        if (z19) {
            stop();
            QQAnimationListener qQAnimationListener = this.mAnimationListener;
            if (qQAnimationListener != null) {
                qQAnimationListener.onStop();
            }
        }
    }

    private void updateFrameInterval() {
        long j3 = this.mFrameInterval;
        long j16 = 0;
        if (j3 == 0) {
            int i3 = this.mListLength;
            if (i3 != 0) {
                j16 = this.mDuration / i3;
            }
            this.mFrameInterval = j16;
            return;
        }
        if (this.mDuration == 0) {
            this.mDuration = j3 * this.mListLength;
        }
    }

    public void cancel() {
        this.mExecutor.clear();
    }

    public synchronized void clear() {
        Bitmap bitmap = this.mFirstBitmap;
        if (bitmap != null && !bitmap.isRecycled()) {
            this.mFirstBitmap.recycle();
        }
        Bitmap bitmap2 = this.mCurrBitmap;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            synchronized (this.mLockObj) {
                this.mCurrBitmap.recycle();
            }
        }
        Bitmap bitmap3 = this.mNextBitmap;
        if (bitmap3 != null && !bitmap3.isRecycled()) {
            this.mNextBitmap.recycle();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        synchronized (this.mLockObj) {
            Bitmap bitmap = this.mCurrBitmap;
            if (bitmap != null && !bitmap.isRecycled()) {
                canvas.drawBitmap(this.mCurrBitmap, (Rect) null, getBounds(), this.mPaint);
            }
        }
        loadNextBitmap(false, false, true);
    }

    protected Bitmap getBitmapFromReusableSet(BitmapFactory.Options options) {
        Set<SoftReference<Bitmap>> set = this.mReusableBitmaps;
        Bitmap bitmap = null;
        if (set != null && !set.isEmpty()) {
            synchronized (this.mReusableBitmaps) {
                Iterator<SoftReference<Bitmap>> it = this.mReusableBitmaps.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Bitmap bitmap2 = it.next().get();
                    if (bitmap2 != null && bitmap2.isMutable() && !bitmap2.isRecycled()) {
                        if (BitmapUtil.canUseForInBitmap(bitmap2, options)) {
                            it.remove();
                            bitmap = bitmap2;
                            break;
                        }
                    } else {
                        it.remove();
                    }
                }
            }
        }
        return bitmap;
    }

    public int getCountOfFrames() {
        return this.mCountOfFrame;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Bitmap bitmap = this.mFirstBitmap;
        if (bitmap != null) {
            return bitmap.getScaledHeight(this.mTargetDensity);
        }
        return super.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Bitmap bitmap = this.mFirstBitmap;
        if (bitmap != null) {
            return bitmap.getScaledWidth(this.mTargetDensity);
        }
        return super.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        if (this.mCurFrame > -1) {
            return true;
        }
        return false;
    }

    public void pause() {
        super.unscheduleSelf(this);
    }

    public void reset() {
        this.mRepeatCount = 1;
        this.mCurFrame = -1;
        this.mNextFrame = 0;
        this.mCurrBitmap = null;
        this.mNextBitmap = null;
        cancel();
    }

    public void restart() {
        this.mDecodeNextFrameEnd = true;
        loadNextBitmap(true, true, true);
    }

    @Override // java.lang.Runnable
    public void run() {
        QQAnimationListener qQAnimationListener;
        if (!this.mIsStart) {
            return;
        }
        if (!this.isParenMethod && this.mCurFrame == getCountOfFrames() - 1) {
            this.mRepeatCount--;
        }
        this.mDecodeNextFrameEnd = true;
        Bitmap bitmap = this.mNextBitmap;
        if (bitmap != null) {
            this.mCurrBitmap = bitmap;
        }
        if (this.mCurFrame == -1 && (qQAnimationListener = this.mAnimationListener) != null) {
            qQAnimationListener.onStart();
        }
        this.mCurFrame = this.mNextFrame;
        invalidateSelf();
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
    public void setDither(boolean z16) {
        this.mPaint.setDither(z16);
    }

    public void setDuration(long j3) {
        this.mDuration = j3;
        updateFrameInterval();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z16) {
        this.mPaint.setFilterBitmap(z16);
    }

    public void setFrameInterval(long j3) {
        this.mFrameInterval = j3;
        updateFrameInterval();
    }

    public void setListener(QQAnimationListener qQAnimationListener) {
        this.mAnimationListener = qQAnimationListener;
    }

    public void setOneShot(boolean z16) {
        this.mOneShot = z16;
    }

    public void setPngPaths(String[] strArr) {
        setPngPaths(strArr, false);
    }

    public void setRequestHeight(int i3) {
        this.mRequestHeight = i3;
    }

    public void setRequestWidth(int i3) {
        this.mRequestWidth = i3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z16, boolean z17) {
        boolean visible = super.setVisible(z16, z17);
        if (z16) {
            if (visible || z17) {
                restart();
            }
        } else {
            pause();
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.mIsStart = true;
        if (this.mCountOfFrame > 0 && this.mFrameInterval > 0) {
            if (!isRunning()) {
                this.mDecodeNextFrameEnd = true;
                loadNextBitmap(true, false, true);
                return;
            }
            return;
        }
        RFWLog.w("QQAnimationDrawable", RFWLog.USR, "pngs size and duration must > 0");
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.mIsStart = false;
        RFWLog.d("QQAnimationDrawable", RFWLog.USR, " stop");
        if (isRunning()) {
            unscheduleSelf(this);
        }
        if (!this.isParenMethod) {
            this.mRepeatCount = 1;
        }
        reset();
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        this.mCurFrame = -1;
        super.unscheduleSelf(runnable);
    }

    public QQAnimationDrawable(QQAnimationListener qQAnimationListener) {
        this.mExecutor = new SerialExecutor();
        this.mDuration = 0L;
        this.mRepeatCount = 1;
        this.mLockObj = new Object();
        this.mPaint = new Paint(6);
        this.mCurFrame = -1;
        this.mCountOfFrame = 0;
        this.mNextFrame = 0;
        this.isParenMethod = true;
        this.mDecodeNextFrameEnd = true;
        int i3 = RFWApplication.getApplication().getResources().getDisplayMetrics().densityDpi;
        this.mTargetDensity = i3;
        this.mTargetDensity = i3 == 0 ? 160 : i3;
        this.mAnimationListener = qQAnimationListener;
        this.mReusableBitmaps = Collections.synchronizedSet(new HashSet());
    }

    public void setPngPaths(String[] strArr, boolean z16) {
        if (!Arrays.equals(this.mPngPaths, strArr)) {
            clear();
            this.mPngPaths = strArr;
        }
        String[] strArr2 = this.mPngPaths;
        if (strArr2 != null) {
            this.mCountOfFrame = strArr2.length;
        } else {
            this.mCountOfFrame = 0;
        }
        this.mListLength = strArr.length;
        updateFrameInterval();
        if (z16) {
            this.mCurrBitmap = getBitmap(0);
        }
    }
}
