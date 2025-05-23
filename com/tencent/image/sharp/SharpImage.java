package com.tencent.image.sharp;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.image.AnimationCallback;
import com.tencent.image.ArgumentsRunnable;
import com.tencent.image.SharpDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: P */
/* loaded from: classes7.dex */
public class SharpImage implements Runnable {
    static IPatchRedirector $redirector_ = null;
    private static final boolean DEBUG = false;
    public static final int DENSITY_NONE = 0;
    private static int IMAGE_SIZE_DISABLE_DOUBLE_BUFFER = 0;
    public static final String KEY_DENSITY = "key_density";
    public static final String KEY_DOUBLE_BITMAP = "key_double_bitmap";
    public static final String KEY_DRAW_ROUND = "key_draw_round";
    public static final String KEY_GET_RESET_LOOP = "key_get_reset_loop";
    public static final String KEY_LOOP = "key_loop";
    public static final String KEY_ONCE_CLEAR = "key_once_clear";
    public static final String KEY_PRE_MULTIPLED = "key_pre_multipled";
    public static final String KEY_STOP_ON_FIRST = "key_stop_on_first";
    public static final String KEY_TAGID_ARR = "key_tagId_arr";
    public static final String KEY_USE_RECT = "key_use_rect";
    private static final int ONE_FRAME_LIMIT_5_MS = 5;
    private static final int PENDING_ACTION_CAPACITY = 100;
    private static final String TAG = "SharpImage";
    public static ArrayList<Integer> canDecodeIDs;
    private static ArgumentsRunnable<WeakReference<SharpImage>> sAccumulativeRunnable;
    private static Handler sHandler;
    protected static boolean sPaused;
    protected static final ArrayList<WeakReference<SharpImage>> sPendingActions;
    private boolean mCacheFirstFrame;
    private CopyOnWriteArrayList<WeakReference<AnimationCallback>> mCallbacks;
    private Bitmap mCurFrame;
    protected int mCurrentFrameDelay;
    public int mCurrentSharpLoop;
    private boolean mDecodeNextFrameEnd;
    private SharpPDecoderHelper mDecoder;
    protected int mDensity;
    public boolean mDoubleBitmap;
    public boolean mDrawRoundCorner;
    protected File mFile;
    public Bitmap mFirstFrame;
    public int mFrameCount;
    public boolean mGetResetLoop;
    private long mHDec;
    public int mHeight;
    boolean mIsInPendingAction;
    protected ArrayList<WeakReference<SharpDrawable.OnPlayRepeatListener>> mListener;
    private Bitmap mNextFrame;
    private volatile int mNextFrameIndex;
    private long mNextFrameTime;
    public boolean mOnceAndClear;
    private boolean mOnlyOneFrame;
    private Paint mPaint;
    protected boolean mPaused;
    private boolean mPreMultipled;
    private int mSharpLoop;
    public boolean mStopOnFirstFrame;
    private boolean mSupportGlobalPasued;
    private int[] mTagIDArr;
    public int mWidth;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class DecodeNextFrameAsyncTask extends AsyncTask<Void, Void, Object> {
        static IPatchRedirector $redirector_;
        long nextFrameDrawingTime;

        public DecodeNextFrameAsyncTask(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SharpImage.this, Long.valueOf(j3));
            } else {
                this.nextFrameDrawingTime = j3;
            }
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                SharpImage.this.onDecodeNextFrameCanceled();
            }
        }

        @Override // android.os.AsyncTask
        protected void onPostExecute(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, obj);
            } else if (obj instanceof Throwable) {
                SharpImage.this.onDecodeNextFrameFailed((Throwable) obj);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Object doInBackground(Void... voidArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return iPatchRedirector.redirect((short) 2, (Object) this, (Object) voidArr);
            }
            try {
                SharpImage.this.onDecodeNextFrameSuccessed(SharpImage.this.getNextFrame(), this.nextFrameDrawingTime);
                return null;
            } catch (Throwable th5) {
                return th5;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class WriteableInteger {
        static IPatchRedirector $redirector_;
        int realInt;

        public WriteableInteger(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3);
            } else {
                this.realInt = i3;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13432);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 32)) {
            redirector.redirect((short) 32);
            return;
        }
        sPendingActions = new ArrayList<WeakReference<SharpImage>>(105) { // from class: com.tencent.image.sharp.SharpImage.1
            static IPatchRedirector $redirector_;

            {
                super(r4);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, r4);
                }
            }

            private void ensureCapacity() {
                if (size() > 100) {
                    removeRange(0, (r0 - 100) - 1);
                }
            }

            @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
            public boolean add(WeakReference<SharpImage> weakReference) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) weakReference)).booleanValue();
                }
                boolean add = super.add((AnonymousClass1) weakReference);
                ensureCapacity();
                return add;
            }
        };
        sPaused = false;
        IMAGE_SIZE_DISABLE_DOUBLE_BUFFER = 262144;
        canDecodeIDs = new ArrayList<>();
    }

    public SharpImage(File file, boolean z16) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, file, Boolean.valueOf(z16));
            return;
        }
        this.mNextFrameIndex = 0;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mFrameCount = 0;
        this.mGetResetLoop = true;
        this.mPaused = false;
        this.mDensity = 160;
        this.mListener = new ArrayList<>();
        this.mIsInPendingAction = false;
        this.mPaint = new Paint();
        this.mSupportGlobalPasued = true;
        this.mOnlyOneFrame = false;
        this.mCallbacks = new CopyOnWriteArrayList<>();
        this.mDecodeNextFrameEnd = true;
        this.mPreMultipled = true;
        this.mFile = file;
        init(z16);
    }

    private void decodeFrame(int i3, long j3) {
        synchronized (this.mCallbacks) {
            for (int i16 = 0; i16 < this.mCallbacks.size(); i16++) {
                WeakReference<AnimationCallback> weakReference = this.mCallbacks.get(i16);
                if (weakReference != null && (weakReference.get() instanceof SharpDrawable)) {
                    ((SharpDrawable) weakReference.get()).decodeFrame(i3, j3);
                }
            }
        }
    }

    private void getImageInfo(File file) throws IOException {
        SharpPDecoderHelper sharpPDecoderHelper = new SharpPDecoderHelper(file.getAbsolutePath());
        this.mDecoder = sharpPDecoderHelper;
        int parseHeader = sharpPDecoderHelper.parseHeader();
        if (parseHeader == 0) {
            this.mHDec = this.mDecoder.createDecoder();
            this.mFrameCount = this.mDecoder.getFeatureInfo().getFrameCount();
            if (this.mDecoder.getFeatureInfo().getImageMode() == 4) {
                URLDrawable.depImp.mLog.d(TAG, 2, "sharpP: emMode_AnimationWithAlpha");
            }
            this.mWidth = this.mDecoder.getFeatureInfo().getWidth();
            this.mHeight = this.mDecoder.getFeatureInfo().getHeight();
            if (URLDrawable.depImp.mLog.isColorLevel()) {
                URLDrawable.depImp.mLog.d(TAG, 2, "start decode success width = " + this.mWidth + " height = " + this.mHeight + " frameCount = " + this.mFrameCount);
            }
            if (this.mWidth > 0 && this.mHeight > 0 && this.mFrameCount > 0) {
                return;
            }
            throw new IOException("bad sharpP, w=" + this.mWidth + " h=" + this.mHeight + " frames=" + this.mFrameCount);
        }
        throw new IOException("start decode error: " + parseHeader);
    }

    private void init(boolean z16) throws IOException {
        this.mPaint.setAntiAlias(true);
        this.mCacheFirstFrame = z16;
        getImageInfo(this.mFile);
        initBitmap();
        if (!getNextFrame() || this.mFrameCount == 1) {
            this.mOnlyOneFrame = true;
        }
        applyNextFrame();
        if (z16) {
            this.mFirstFrame = this.mCurFrame;
        }
        if (this.mOnlyOneFrame) {
            this.mFirstFrame = this.mCurFrame;
            this.mNextFrame = null;
        }
    }

    private void initBitmap() {
        int i3;
        if (this.mWidth > 0 && this.mHeight > 0) {
            Bitmap bitmap = this.mCurFrame;
            if (bitmap == null || bitmap.getWidth() != this.mWidth || this.mCurFrame.getHeight() != this.mHeight) {
                try {
                    this.mCurFrame = Bitmap.createBitmap(this.mWidth, this.mHeight, Bitmap.Config.ARGB_8888);
                    if (URLDrawable.depImp.mLog.isColorLevel()) {
                        URLDrawable.depImp.mLog.d(TAG, 2, "init curFrame success width = " + this.mCurFrame.getWidth() + " height = " + this.mCurFrame.getHeight());
                    }
                } catch (OutOfMemoryError unused) {
                    URLDrawable.clearMemoryCache();
                    try {
                        this.mCurFrame = Bitmap.createBitmap(this.mWidth, this.mHeight, Bitmap.Config.ARGB_8888);
                    } catch (OutOfMemoryError unused2) {
                        URLDrawable.depImp.mLog.e(TAG, 1, "sharpP create Bitmap OOM");
                    }
                }
            }
            int i16 = this.mWidth;
            if (i16 > 0 && (i3 = this.mHeight) > 0) {
                if (this.mDoubleBitmap || i16 * i3 <= IMAGE_SIZE_DISABLE_DOUBLE_BUFFER) {
                    Bitmap bitmap2 = this.mNextFrame;
                    if (bitmap2 == null || bitmap2.getWidth() != this.mWidth || this.mNextFrame.getHeight() != this.mHeight) {
                        try {
                            this.mNextFrame = Bitmap.createBitmap(this.mWidth, this.mHeight, Bitmap.Config.ARGB_8888);
                            if (URLDrawable.depImp.mLog.isColorLevel()) {
                                URLDrawable.depImp.mLog.d(TAG, 2, "init nextFrame success width = " + this.mNextFrame.getWidth() + " height = " + this.mNextFrame.getHeight());
                            }
                        } catch (OutOfMemoryError unused3) {
                            URLDrawable.depImp.mLog.e(TAG, 1, "sharpP buffer create OOM");
                        }
                    }
                }
            }
        }
    }

    private void invalidateSelf() {
        synchronized (this.mCallbacks) {
            for (int i3 = 0; i3 < this.mCallbacks.size(); i3++) {
                WeakReference<AnimationCallback> weakReference = this.mCallbacks.get(i3);
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().invalidateSelf();
                }
            }
        }
    }

    private void onRefresh(int i3, int i16) {
        synchronized (this.mCallbacks) {
            for (int i17 = 0; i17 < this.mCallbacks.size(); i17++) {
                WeakReference<AnimationCallback> weakReference = this.mCallbacks.get(i17);
                if (weakReference != null && (weakReference.get() instanceof SharpDrawable)) {
                    ((SharpDrawable) weakReference.get()).refresh(i3, i16);
                }
            }
        }
    }

    public static final void pauseAll() {
        sPaused = true;
        synchronized (canDecodeIDs) {
            canDecodeIDs.clear();
        }
    }

    public static final void pauseByTag(int i3) {
        if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.d(TAG, 2, "sharp pauseByTag , conplayids:" + canDecodeIDs + ", tag:" + i3);
        }
        synchronized (canDecodeIDs) {
            int indexOf = canDecodeIDs.indexOf(Integer.valueOf(i3));
            if (indexOf >= 0) {
                canDecodeIDs.remove(indexOf);
            }
        }
    }

    public static final void playByTag(int i3) {
        if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.d(TAG, 2, "sharp playByTag , conplayids:" + canDecodeIDs + ", tag:" + i3);
        }
        if (sPaused) {
            pauseAll();
        }
        if (!canDecodeIDs.contains(Integer.valueOf(i3))) {
            canDecodeIDs.add(Integer.valueOf(i3));
        }
        resumeAll();
    }

    public static final synchronized void resumeAll() {
        synchronized (SharpImage.class) {
            sPaused = false;
            for (int size = sPendingActions.size() - 1; size >= 0; size--) {
                ArrayList<WeakReference<SharpImage>> arrayList = sPendingActions;
                SharpImage sharpImage = arrayList.get(size).get();
                if (sharpImage == null) {
                    arrayList.remove(size);
                } else if (sharpImage.getIsEnable()) {
                    arrayList.remove(size);
                    sharpImage.reDraw();
                }
            }
        }
    }

    public static int scaleFromDensity(int i3, int i16, int i17) {
        if (i16 != 0 && i16 != i17) {
            return ((i3 * i17) + (i16 >> 1)) / i16;
        }
        return i3;
    }

    private void scheduleSelf(Runnable runnable, long j3) {
        synchronized (this.mCallbacks) {
            for (int i3 = 0; i3 < this.mCallbacks.size(); i3++) {
                WeakReference<AnimationCallback> weakReference = this.mCallbacks.get(i3);
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().scheduleSelf(runnable, j3);
                }
            }
        }
    }

    public void addCallBack(AnimationCallback animationCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) animationCallback);
        } else if (animationCallback != null) {
            synchronized (this.mCallbacks) {
                this.mCallbacks.add(new WeakReference<>(animationCallback));
            }
        }
    }

    void addToPendingActions(SharpImage sharpImage) {
        if (sharpImage != null && !sharpImage.mIsInPendingAction) {
            for (int size = sPendingActions.size() - 1; size >= 0; size--) {
                if (sPendingActions.get(size).get() == sharpImage) {
                    return;
                }
            }
            sPendingActions.add(new WeakReference<>(sharpImage));
            sharpImage.mIsInPendingAction = true;
        }
    }

    public synchronized void applyNextFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        if (this.mNextFrame != null) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            Canvas canvas = new Canvas(this.mCurFrame);
            this.mCurFrame.eraseColor(0);
            if (this.mDrawRoundCorner) {
                paint.setFilterBitmap(true);
                canvas.drawRoundRect(new RectF(0.0f, 0.0f, this.mWidth, this.mHeight), this.mWidth, this.mHeight, paint);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            }
            canvas.drawBitmap(this.mNextFrame, 0.0f, 0.0f, paint);
        }
    }

    int calculateDelayTime(int i3) {
        if (i3 <= 1) {
            return 100;
        }
        return i3;
    }

    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this);
            return;
        }
        try {
            this.mNextFrameIndex = 0;
            long j3 = this.mHDec;
            if (j3 == 0) {
                URLDrawable.depImp.mLog.d(TAG, 2, "SharpPGifDecoder.close():mHDec=0");
            } else {
                this.mDecoder.closeDecoder(j3);
                this.mHDec = 0L;
            }
        } catch (Throwable th5) {
            URLDrawable.depImp.mLog.e(TAG, 2, "", th5);
        }
    }

    protected void doApplyNextFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        applyNextFrame();
        this.mDecodeNextFrameEnd = true;
        if (getIsEnable()) {
            invalidateSelf();
        } else {
            addToPendingActions(this);
        }
    }

    public void draw(Canvas canvas, Rect rect, Rect rect2, Paint paint, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, canvas, rect, rect2, paint, Boolean.valueOf(z16));
            return;
        }
        if (canvas != null && rect2 != null) {
            int i3 = this.mSharpLoop;
            if (i3 > 0 && i3 <= this.mCurrentSharpLoop && this.mOnceAndClear) {
                canvas.drawColor(16777215);
                return;
            }
            initHandlerAndRunnable();
            if (!this.mOnlyOneFrame && z16) {
                Bitmap bitmap = this.mCurFrame;
                if (bitmap != null) {
                    canvas.drawBitmap(bitmap, rect, rect2, paint);
                }
                onRefresh(this.mNextFrameIndex, this.mFrameCount);
                if (getIsEnable()) {
                    int i16 = this.mSharpLoop;
                    if (i16 > 0 && i16 <= this.mCurrentSharpLoop) {
                        if (this.mStopOnFirstFrame && this.mNextFrameIndex == this.mFrameCount) {
                            executeNewTask();
                            return;
                        }
                        return;
                    }
                    executeNewTask();
                    return;
                }
                addToPendingActions(this);
                return;
            }
            Bitmap bitmap2 = this.mFirstFrame;
            if (bitmap2 != null) {
                canvas.drawBitmap(bitmap2, rect, rect2, paint);
            }
        }
    }

    protected void executeNewTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        if (this.mDecodeNextFrameEnd) {
            this.mDecodeNextFrameEnd = false;
            if (URLDrawable.depImp.mLog.isColorLevel()) {
                URLDrawable.depImp.mLog.d(TAG, 2, toString() + " start executeNewTask frame: " + this.mNextFrameIndex + "  thread name: " + Thread.currentThread().getName());
            }
            int delay = getDelay();
            long uptimeMillis = SystemClock.uptimeMillis();
            long j3 = this.mNextFrameTime;
            if (j3 == 0) {
                this.mNextFrameTime = uptimeMillis;
            } else if (j3 + (delay * 2) <= uptimeMillis) {
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                    URLDrawable.depImp.mLog.d(URLDrawable.TAG, 2, "executeNewTask reset  :" + this.mNextFrameTime + "," + delay + "," + uptimeMillis);
                }
                this.mNextFrameTime = uptimeMillis;
            }
            this.mNextFrameTime += delay;
            try {
                Utils.executeAsyncTaskOnThreadPool(new DecodeNextFrameAsyncTask(this.mNextFrameTime), null);
            } catch (RejectedExecutionException e16) {
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                    URLDrawable.depImp.mLog.e(URLDrawable.TAG, 2, "executeNewTask()", e16);
                }
            }
        }
    }

    protected void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
        } else {
            close();
            super.finalize();
        }
    }

    public int getByteSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Integer) iPatchRedirector.redirect((short) 29, (Object) this)).intValue();
        }
        if (this.mOnlyOneFrame) {
            return Utils.getBitmapSize(this.mFirstFrame);
        }
        Bitmap bitmap = this.mCurFrame;
        int i3 = 0;
        if (bitmap != null) {
            i3 = 0 + Utils.getBitmapSize(bitmap);
        }
        Bitmap bitmap2 = this.mNextFrame;
        if (bitmap2 != null) {
            i3 += Utils.getBitmapSize(bitmap2);
        }
        if (this.mDecoder != null) {
            return i3 + (this.mWidth * this.mHeight * 4);
        }
        return i3;
    }

    public Bitmap getCurrentFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Bitmap) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.mCurFrame;
    }

    public int getDelay() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Integer) iPatchRedirector.redirect((short) 14, (Object) this)).intValue();
        }
        return this.mCurrentFrameDelay;
    }

    public int getHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mHeight;
    }

    final boolean getIsEnable() {
        if (this.mPaused) {
            return false;
        }
        if (this.mSupportGlobalPasued && sPaused) {
            return false;
        }
        if (this.mTagIDArr == null) {
            return true;
        }
        int i3 = 0;
        while (true) {
            int[] iArr = this.mTagIDArr;
            if (i3 >= iArr.length) {
                return false;
            }
            if (canDecodeIDs.contains(Integer.valueOf(iArr[i3]))) {
                return true;
            }
            i3++;
        }
    }

    public int getLoopCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.mSharpLoop;
    }

    protected synchronized boolean getNextFrame() {
        Bitmap decodeSharpP2GifFrame;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (this.mHDec != 0) {
            WriteableInteger writeableInteger = new WriteableInteger(0);
            if (this.mNextFrameIndex == this.mFrameCount) {
                this.mNextFrameIndex = 0;
            }
            if (this.mNextFrame != null) {
                long currentTimeMillis = System.currentTimeMillis();
                decodeSharpP2GifFrame = this.mDecoder.decodeSharpP2GifFrame(this.mHDec, this.mNextFrameIndex, this.mWidth, this.mHeight, writeableInteger, this.mNextFrame, this.mPreMultipled);
                this.mNextFrameIndex++;
                decodeFrame(this.mNextFrameIndex, System.currentTimeMillis() - currentTimeMillis);
                if (decodeSharpP2GifFrame != null) {
                    this.mNextFrame = decodeSharpP2GifFrame;
                    this.mCurrentFrameDelay = calculateDelayTime(writeableInteger.realInt);
                }
            } else {
                long currentTimeMillis2 = System.currentTimeMillis();
                decodeSharpP2GifFrame = this.mDecoder.decodeSharpP2GifFrame(this.mHDec, this.mNextFrameIndex, this.mWidth, this.mHeight, writeableInteger, this.mCurFrame, this.mPreMultipled);
                this.mNextFrameIndex++;
                decodeFrame(this.mNextFrameIndex, System.currentTimeMillis() - currentTimeMillis2);
                if (decodeSharpP2GifFrame != null) {
                    this.mCurFrame = decodeSharpP2GifFrame;
                    this.mCurrentFrameDelay = calculateDelayTime(writeableInteger.realInt);
                }
            }
            if (decodeSharpP2GifFrame != null) {
                return true;
            }
            if (URLDrawable.depImp.mLog.isColorLevel()) {
                URLDrawable.depImp.mLog.d(TAG, 2, "getNextFrame fail: frameIndex: " + this.mNextFrameIndex);
            }
        }
        return false;
    }

    public int getScaledHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this, i3)).intValue();
        }
        return scaleFromDensity(this.mHeight, this.mDensity, i3);
    }

    public int getScaledWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this, i3)).intValue();
        }
        return scaleFromDensity(this.mWidth, this.mDensity, i3);
    }

    public int getWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.mWidth;
    }

    protected void initHandlerAndRunnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else if (sHandler == null) {
            sHandler = new Handler(Looper.getMainLooper());
            sAccumulativeRunnable = new DoAccumulativeRunnable(null);
        }
    }

    void onDecodeNextFrameCanceled() {
        if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.e(URLDrawable.TAG, 2, "sharpP decode canceled. " + this.mFile);
        }
        this.mDecodeNextFrameEnd = true;
    }

    void onDecodeNextFrameFailed(Throwable th5) {
        if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.e(URLDrawable.TAG, 2, "sharpP decode error. " + this.mFile, th5);
        }
        this.mDecodeNextFrameEnd = true;
    }

    void onDecodeNextFrameSuccessed(boolean z16, long j3) {
        if (z16) {
            long uptimeMillis = SystemClock.uptimeMillis();
            if (uptimeMillis < j3) {
                sHandler.postDelayed(this, j3 - uptimeMillis);
            } else {
                sHandler.post(this);
            }
            if (this.mSharpLoop > 0 && this.mFrameCount == this.mNextFrameIndex) {
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                    URLDrawable.depImp.mLog.d(TAG, 2, "sharpP mFrameCount:" + this.mFrameCount + ", current:" + this.mNextFrameIndex);
                }
                this.mCurrentSharpLoop++;
                synchronized (this.mListener) {
                    for (int size = this.mListener.size() - 1; size >= 0; size--) {
                        SharpDrawable.OnPlayRepeatListener onPlayRepeatListener = this.mListener.get(size).get();
                        if (onPlayRepeatListener != null) {
                            onPlayRepeatListener.onPlayRepeat(this.mCurrentSharpLoop);
                        } else {
                            this.mListener.remove(size);
                        }
                    }
                }
            }
        }
    }

    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
        } else {
            this.mPaused = true;
        }
    }

    public void reDraw() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            invalidateSelf();
            this.mIsInPendingAction = false;
        }
    }

    public void removeCallBack(AnimationCallback animationCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) animationCallback);
            return;
        }
        synchronized (this.mCallbacks) {
            int i3 = 0;
            while (i3 < this.mCallbacks.size()) {
                WeakReference<AnimationCallback> weakReference = this.mCallbacks.get(i3);
                if (weakReference != null && weakReference.get() != null) {
                    if (weakReference.get() == animationCallback) {
                        this.mCallbacks.remove(i3);
                        return;
                    }
                    i3++;
                }
                this.mCallbacks.remove(i3);
                i3--;
                i3++;
            }
        }
    }

    public void removeOnPlayRepeatListener(SharpDrawable.OnPlayRepeatListener onPlayRepeatListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) onPlayRepeatListener);
            return;
        }
        if (onPlayRepeatListener != null) {
            synchronized (this.mListener) {
                for (int size = this.mListener.size() - 1; size >= 0; size--) {
                    if (this.mListener.get(size).get() == onPlayRepeatListener) {
                        this.mListener.remove(size);
                    }
                }
            }
        }
    }

    public void replay() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this);
        } else {
            this.mCurrentSharpLoop = 0;
            reDraw();
        }
    }

    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this);
            return;
        }
        this.mPaused = false;
        for (int size = sPendingActions.size() - 1; size >= 0; size--) {
            ArrayList<WeakReference<SharpImage>> arrayList = sPendingActions;
            SharpImage sharpImage = arrayList.get(size).get();
            if (sharpImage == this && sharpImage.getIsEnable()) {
                arrayList.remove(size);
                sharpImage.reDraw();
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            sAccumulativeRunnable.add(new WeakReference<>(this));
        }
    }

    public void setDensity(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, i3);
        } else {
            this.mDensity = i3;
        }
    }

    public void setLoopCount(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.mSharpLoop = i3;
        }
    }

    public void setOnPlayRepeatListener(SharpDrawable.OnPlayRepeatListener onPlayRepeatListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) onPlayRepeatListener);
            return;
        }
        if (onPlayRepeatListener != null) {
            synchronized (this.mListener) {
                boolean z16 = false;
                int i3 = 0;
                while (true) {
                    if (i3 >= this.mListener.size()) {
                        break;
                    }
                    if (this.mListener.get(i3).get() == onPlayRepeatListener) {
                        z16 = true;
                        break;
                    }
                    i3++;
                }
                if (!z16) {
                    this.mListener.add(new WeakReference<>(onPlayRepeatListener));
                }
            }
        }
    }

    public synchronized void setSharpFile(File file) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) file);
            return;
        }
        close();
        this.mFile = file;
        init(false);
        initHandlerAndRunnable();
        sHandler.post(new Runnable() { // from class: com.tencent.image.sharp.SharpImage.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SharpImage.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                } else {
                    SharpImage.this.replay();
                }
            }
        });
    }

    public void setSupportGlobalPasued(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, z16);
        } else {
            this.mSupportGlobalPasued = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class DoAccumulativeRunnable extends ArgumentsRunnable<WeakReference<SharpImage>> {
        static IPatchRedirector $redirector_;
        private long lastRefreshTime;

        DoAccumulativeRunnable() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.lastRefreshTime = 0L;
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.image.ArgumentsRunnable
        protected void run(List<WeakReference<SharpImage>> list) {
            SharpImage sharpImage;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                return;
            }
            for (WeakReference<SharpImage> weakReference : list) {
                if (weakReference != null && (sharpImage = weakReference.get()) != null) {
                    sharpImage.doApplyNextFrame();
                }
            }
            this.lastRefreshTime = SystemClock.uptimeMillis();
        }

        @Override // com.tencent.image.ArgumentsRunnable
        protected void submit() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            long j3 = this.lastRefreshTime;
            if (j3 != 0 && uptimeMillis - j3 <= 5) {
                SharpImage.sHandler.postDelayed(this, 5 - (uptimeMillis - this.lastRefreshTime));
            } else {
                run();
                this.lastRefreshTime = uptimeMillis;
            }
        }

        /* synthetic */ DoAccumulativeRunnable(AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) anonymousClass1);
        }
    }

    public SharpImage(File file, boolean z16, Bundle bundle) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, file, Boolean.valueOf(z16), bundle);
            return;
        }
        this.mNextFrameIndex = 0;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mFrameCount = 0;
        this.mGetResetLoop = true;
        this.mPaused = false;
        this.mDensity = 160;
        this.mListener = new ArrayList<>();
        this.mIsInPendingAction = false;
        this.mPaint = new Paint();
        this.mSupportGlobalPasued = true;
        this.mOnlyOneFrame = false;
        this.mCallbacks = new CopyOnWriteArrayList<>();
        this.mDecodeNextFrameEnd = true;
        this.mPreMultipled = true;
        if (bundle != null) {
            this.mSharpLoop = bundle.getInt("key_loop", 0);
            this.mOnceAndClear = bundle.getBoolean("key_once_clear", false);
            this.mDrawRoundCorner = bundle.getBoolean("key_draw_round", false);
            this.mGetResetLoop = bundle.getBoolean("key_get_reset_loop", true);
            this.mDoubleBitmap = this.mDrawRoundCorner || bundle.getBoolean("key_double_bitmap", false);
            this.mStopOnFirstFrame = bundle.getBoolean("key_stop_on_first", false);
            this.mPreMultipled = bundle.getBoolean(KEY_PRE_MULTIPLED, true);
            setDensity(bundle.getInt("key_density", this.mDensity));
            int[] intArray = bundle.getIntArray("key_tagId_arr");
            if (intArray != null && intArray.length > 0) {
                this.mTagIDArr = bundle.getIntArray("key_tagId_arr");
            }
        }
        this.mFile = file;
        init(z16);
    }
}
