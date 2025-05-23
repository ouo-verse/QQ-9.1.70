package com.tencent.image;

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
import com.tencent.image.ApngDrawable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ApngImage implements Runnable {
    static IPatchRedirector $redirector_ = null;
    public static final int CAN_PLAY_TAG_AIO = 0;
    private static final boolean DEBUG = false;
    public static int DECRYPTTYPE_DECRYPT = 0;
    public static final int DENSITY_NONE = 0;
    public static final int ERROR_CODE_SUCCESS = 0;
    private static final int IMAGE_INFO_INDEX_CURRENTFRAM = 3;
    private static final int IMAGE_INFO_INDEX_ERRORCODE = 5;
    private static final int IMAGE_INFO_INDEX_FRAMECOUNT = 2;
    private static final int IMAGE_INFO_INDEX_FRAMEDELAY = 4;
    private static final int IMAGE_INFO_INDEX_HEIGHT = 1;
    private static final int IMAGE_INFO_INDEX_PLAYCOUNT = 6;
    private static final int IMAGE_INFO_INDEX_WIDTH = 0;
    private static int IMAGE_SIZE_DISABLE_DOUBLE_BUFFER = 0;
    public static final String KEY_DECRYPTTYPE = "key_decryptType";
    public static final String KEY_DENSITY = "key_density";
    public static final String KEY_DOUBLE_BITMAP = "key_double_bitmap";
    public static final String KEY_DRAW_ROUND = "key_draw_round";
    public static final String KEY_GET_RESET_LOOP = "key_get_reset_loop";
    public static final String KEY_LOOP = "key_loop";
    public static final String KEY_ONCE_CLEAR = "key_once_clear";
    public static final String KEY_STOP_ON_FIRST = "key_stop_on_first";
    public static final String KEY_TAGID_ARR = "key_tagId_arr";
    public static final String KEY_TAGNAME = "key_name";
    public static final String KEY_USE_FILE_LOOP = "key_use_file_loop";
    public static final String KEY_USE_RECT = "key_use_rect";
    private static final int ONE_FRAME_LIMIT_5_MS = 5;
    private static final int PENDING_ACTION_CAPACITY = 100;
    private static final String TAG = "ApngImage";
    public static ArrayList<Integer> canDecodeIDs;
    private static ArgumentsRunnable<WeakReference<ApngImage>> sAccumulativeRunnable;
    private static Handler sHandler;
    protected static boolean sPaused;
    protected static final ArrayList<WeakReference<ApngImage>> sPendingActions;
    public int apngLoop;
    private boolean cacheFirstFrame;
    private CopyOnWriteArrayList<WeakReference<AnimationCallback>> callbacks;
    protected long contentIndex;
    private Bitmap curFrame;
    public int currentApngLoop;
    protected int currentFrameDelay;
    int decryptType;
    protected File file;
    public Bitmap firstFrame;
    public int height;
    private boolean mDecodeNextFrameEnd;
    protected int mDensity;
    public boolean mDoubleBitmap;
    public boolean mDrawRoundCorner;
    public int mFrameCount;
    public boolean mGetResetLoop;
    int[] mImageInfo;
    boolean mIsInPendingAction;
    protected ArrayList<WeakReference<ApngDrawable.OnPlayRepeatListener>> mListener;
    String mName;
    private long mNextFrameTime;
    public boolean mOnceAndClear;
    protected boolean mPaused;
    public boolean mStopOnFirstFrame;
    private boolean mSupportGlobalPasued;
    int[] mTagIDArr;
    public boolean mUseFileLoop;
    long nativeFrameInfoInstance;
    long nativeImageInstance;
    private Bitmap nextFrame;
    private boolean onlyOneFrame;
    private Paint paint;
    private Paint paintTransparentBlack;
    public int width;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class DecodeNextFrameAsyncTask extends AsyncTask<Void, Void, Object> {
        static IPatchRedirector $redirector_;
        long nextFrameDrawingTime;

        public DecodeNextFrameAsyncTask(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, ApngImage.this, Long.valueOf(j3));
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
                ApngImage.this.onDecodeNextFrameCanceled();
            }
        }

        @Override // android.os.AsyncTask
        protected void onPostExecute(Object obj) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, obj);
            } else if (obj instanceof Throwable) {
                ApngImage.this.onDecodeNextFrameFailed((Throwable) obj);
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
                ApngImage.this.onDecodeNextFrameSuccessed(ApngImage.this.getNextFrame(), this.nextFrameDrawingTime);
                return null;
            } catch (Throwable th5) {
                return th5;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private static final class FinalizeNativeRunnable implements Runnable {
        static IPatchRedirector $redirector_;
        private final long nativeFrameInfoInstance;
        private final long nativeImageInstance;

        FinalizeNativeRunnable(long j3, long j16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Long.valueOf(j16));
            } else {
                this.nativeFrameInfoInstance = j3;
                this.nativeImageInstance = j16;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            QLog.i(ApngImage.TAG, 4, "WeakRunnable running:nativeFrameInfoInstance=" + this.nativeFrameInfoInstance + ",nativeImageInstance=" + this.nativeImageInstance);
            try {
                long j3 = this.nativeFrameInfoInstance;
                if (j3 != 0) {
                    ApngImage.nativeFreeFrame(j3);
                }
                long j16 = this.nativeImageInstance;
                if (j16 != 0) {
                    ApngImage.nativeFreeImage(j16);
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
                QLog.e(ApngImage.TAG, 1, "freeNativeInstance error", th5);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(8388);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 32)) {
            redirector.redirect((short) 32);
            return;
        }
        sPendingActions = new ArrayList<WeakReference<ApngImage>>(105) { // from class: com.tencent.image.ApngImage.1
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
            public boolean add(WeakReference<ApngImage> weakReference) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) weakReference)).booleanValue();
                }
                boolean add = super.add((AnonymousClass1) weakReference);
                ensureCapacity();
                return add;
            }
        };
        canDecodeIDs = new ArrayList<>();
        DECRYPTTYPE_DECRYPT = 1;
        sPaused = false;
        IMAGE_SIZE_DISABLE_DOUBLE_BUFFER = 262144;
    }

    public ApngImage(File file, boolean z16) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, file, Boolean.valueOf(z16));
            return;
        }
        this.width = 0;
        this.height = 0;
        this.mFrameCount = 0;
        this.mGetResetLoop = true;
        this.mPaused = false;
        this.mDensity = 160;
        this.mListener = new ArrayList<>();
        this.mIsInPendingAction = false;
        this.mImageInfo = new int[7];
        this.paint = new Paint();
        this.paintTransparentBlack = new Paint();
        this.mSupportGlobalPasued = true;
        this.onlyOneFrame = false;
        this.callbacks = new CopyOnWriteArrayList<>();
        this.mDecodeNextFrameEnd = true;
        this.file = file;
        init(z16);
    }

    private boolean cleanUpRecycleElements() {
        ArrayList arrayList = new ArrayList();
        Iterator<WeakReference<AnimationCallback>> it = this.callbacks.iterator();
        while (it.hasNext()) {
            WeakReference<AnimationCallback> next = it.next();
            if (next.get() == null) {
                arrayList.add(next);
            }
        }
        this.callbacks.removeAll(arrayList);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "cleanUpRecycleElements fileName:" + this.file.getAbsolutePath() + ", size:" + arrayList.size());
        }
        return !arrayList.isEmpty();
    }

    private void drawScaledBitmap(Canvas canvas, Rect rect, Rect rect2, Paint paint) {
        int i3 = this.width;
        int i16 = this.height;
        Bitmap bitmap = null;
        for (int i17 = 0; i17 < 3; i17++) {
            i3 /= 2;
            i16 /= 2;
            bitmap = Bitmap.createScaledBitmap(this.firstFrame, i3, i16, true);
            try {
                QLog.i(TAG, 1, "createScaledBitmap, width:" + i3 + ", height:" + i16);
                canvas.drawBitmap(bitmap, rect, rect2, paint);
                break;
            } catch (RuntimeException e16) {
                QLog.e(TAG, 1, "still too large, width:" + i3 + ", height:" + i16, e16);
            }
        }
        this.firstFrame = bitmap;
    }

    private void getImageInfo(File file) {
        this.nativeImageInstance = nativeStartDecode(file.getAbsolutePath(), this.mImageInfo, this.decryptType);
        int[] iArr = this.mImageInfo;
        if (iArr[5] == 0) {
            int i3 = iArr[0];
            this.width = i3;
            int i16 = iArr[1];
            this.height = i16;
            int i17 = iArr[2];
            this.mFrameCount = i17;
            if (this.mUseFileLoop) {
                this.apngLoop = iArr[6];
            }
            if (i3 > 0 && i16 > 0 && i17 > 0) {
                return;
            }
            throw new RuntimeException("bad apng, w=" + this.width + " h=" + this.height + " frames=" + this.mFrameCount);
        }
        throw new RuntimeException("start decode error: " + this.mImageInfo[5]);
    }

    private void init(boolean z16) throws IOException {
        this.paint.setAntiAlias(true);
        this.paintTransparentBlack.setAntiAlias(true);
        this.paintTransparentBlack.setColor(0);
        this.cacheFirstFrame = z16;
        getImageInfo(this.file);
        initBitmap();
        if (!getNextFrame() || this.mFrameCount == 1) {
            this.onlyOneFrame = true;
        }
        applyNextFrame();
        if (z16) {
            this.firstFrame = this.curFrame;
        }
        if (this.onlyOneFrame) {
            this.firstFrame = this.curFrame;
            this.nextFrame = null;
        }
    }

    private void initBitmap() {
        int i3;
        int i16;
        int i17 = this.width;
        if (i17 > 0 && (i3 = this.height) > 0) {
            try {
                try {
                    this.curFrame = Bitmap.createBitmap(i17, i3, Bitmap.Config.ARGB_8888);
                } catch (OutOfMemoryError unused) {
                    QLog.e(TAG, 1, "APNG create Bitmap OOM");
                }
            } catch (OutOfMemoryError unused2) {
                this.curFrame = Bitmap.createBitmap(this.width, this.height, Bitmap.Config.ARGB_8888);
            }
            int i18 = this.width;
            if (i18 > 0 && (i16 = this.height) > 0) {
                if (this.mDoubleBitmap || i18 * i16 <= IMAGE_SIZE_DISABLE_DOUBLE_BUFFER) {
                    try {
                        this.nextFrame = Bitmap.createBitmap(i18, i16, Bitmap.Config.ARGB_8888);
                    } catch (OutOfMemoryError unused3) {
                        QLog.e(TAG, 1, "APNG buffer create OOM");
                    }
                }
            }
        }
    }

    private void invalidateSelf() {
        synchronized (this.callbacks) {
            for (int i3 = 0; i3 < this.callbacks.size(); i3++) {
                WeakReference<AnimationCallback> weakReference = this.callbacks.get(i3);
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().invalidateSelf();
                }
            }
        }
    }

    public static native void nativeFreeFrame(long j3);

    public static native void nativeFreeImage(long j3);

    public static native long nativeGetNextFrame(long j3, long j16, Bitmap bitmap, int[] iArr);

    public static native long nativeStartDecode(String str, int[] iArr, int i3);

    public static final void pauseAll() {
        sPaused = true;
        synchronized (canDecodeIDs) {
            canDecodeIDs.clear();
        }
    }

    public static final void pauseByTag(int i3) {
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "pauseByTag , conplayids:" + canDecodeIDs + ", tag:" + i3);
        }
        synchronized (canDecodeIDs) {
            int indexOf = canDecodeIDs.indexOf(Integer.valueOf(i3));
            if (indexOf >= 0) {
                canDecodeIDs.remove(indexOf);
            }
        }
    }

    public static final void playByTag(int i3) {
        if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 4, "playByTag , conplayids:" + canDecodeIDs + ", tag:" + i3);
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
        synchronized (ApngImage.class) {
            sPaused = false;
            for (int size = sPendingActions.size() - 1; size >= 0; size--) {
                ArrayList<WeakReference<ApngImage>> arrayList = sPendingActions;
                ApngImage apngImage = arrayList.get(size).get();
                if (apngImage == null) {
                    arrayList.remove(size);
                } else if (apngImage.getIsEnable()) {
                    arrayList.remove(size);
                    apngImage.reDraw();
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
        synchronized (this.callbacks) {
            int i3 = 0;
            while (i3 < this.callbacks.size()) {
                WeakReference<AnimationCallback> weakReference = this.callbacks.get(i3);
                if (weakReference != null && weakReference.get() != null) {
                    weakReference.get().scheduleSelf(runnable, j3);
                    i3++;
                }
                this.callbacks.remove(i3);
                i3--;
                i3++;
            }
        }
    }

    public void addCallBack(AnimationCallback animationCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) animationCallback);
        } else if (animationCallback != null) {
            synchronized (this.callbacks) {
                this.callbacks.add(new WeakReference<>(animationCallback));
            }
        }
    }

    void addToPendingActions(ApngImage apngImage) {
        if (apngImage != null && !apngImage.mIsInPendingAction) {
            for (int size = sPendingActions.size() - 1; size >= 0; size--) {
                if (sPendingActions.get(size).get() == apngImage) {
                    return;
                }
            }
            sPendingActions.add(new WeakReference<>(apngImage));
            apngImage.mIsInPendingAction = true;
        }
    }

    public synchronized void applyNextFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.nextFrame != null) {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            Canvas canvas = new Canvas(this.curFrame);
            this.curFrame.eraseColor(0);
            if (this.mDrawRoundCorner) {
                paint.setFilterBitmap(true);
                canvas.drawRoundRect(new RectF(0.0f, 0.0f, this.width, this.height), this.width, this.height, paint);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            }
            canvas.drawBitmap(this.nextFrame, 0.0f, 0.0f, paint);
        }
    }

    protected void doApplyNextFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, canvas, rect, rect2, paint, Boolean.valueOf(z16));
            return;
        }
        if (canvas != null && rect2 != null) {
            int i3 = this.apngLoop;
            if (i3 > 0 && i3 <= this.currentApngLoop && this.mOnceAndClear) {
                canvas.drawColor(16777215);
                return;
            }
            initHandlerAndRunnable();
            if (!this.onlyOneFrame && z16) {
                Bitmap bitmap = this.curFrame;
                if (bitmap != null) {
                    canvas.drawBitmap(bitmap, rect, rect2, paint);
                }
                if (getIsEnable()) {
                    int i16 = this.apngLoop;
                    if (i16 > 0 && i16 <= this.currentApngLoop) {
                        if (this.mStopOnFirstFrame && this.mImageInfo[3] == this.mFrameCount - 1) {
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
            Bitmap bitmap2 = this.firstFrame;
            if (bitmap2 != null) {
                try {
                    canvas.drawBitmap(bitmap2, rect, rect2, paint);
                } catch (RuntimeException e16) {
                    QLog.e(TAG, 1, "draw first frame RuntimeException, width:" + this.width + ", height:" + this.height, e16);
                    drawScaledBitmap(canvas, rect, rect2, paint);
                }
            }
        }
    }

    public void drawFrame(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) canvas);
        }
    }

    protected void executeNewTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (this.mDecodeNextFrameEnd) {
            this.mDecodeNextFrameEnd = false;
            int delay = getDelay();
            long uptimeMillis = SystemClock.uptimeMillis();
            long j3 = this.mNextFrameTime;
            if (j3 == 0) {
                this.mNextFrameTime = uptimeMillis;
            } else if (j3 + (delay * 2) <= uptimeMillis) {
                if (QLog.isDevelopLevel()) {
                    QLog.d(TAG, 4, "executeNewTask reset " + this.mName + ":" + this.mNextFrameTime + "," + delay + "," + uptimeMillis);
                }
                this.mNextFrameTime = uptimeMillis;
            }
            this.mNextFrameTime += delay;
            try {
                com.tencent.image.util.Utils.executeAsyncTaskOnSerialExcuter(new DecodeNextFrameAsyncTask(this.mNextFrameTime), null);
            } catch (RejectedExecutionException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "executeNewTask()", e16);
                }
            }
        }
    }

    protected void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
            return;
        }
        try {
            sHandler.post(new FinalizeNativeRunnable(this.nativeFrameInfoInstance, this.nativeImageInstance));
            this.nativeFrameInfoInstance = 0L;
            this.nativeImageInstance = 0L;
        } finally {
            super.finalize();
        }
    }

    public int getByteSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Integer) iPatchRedirector.redirect((short) 30, (Object) this)).intValue();
        }
        if (this.onlyOneFrame) {
            return com.tencent.image.util.Utils.getBitmapSize(this.firstFrame);
        }
        Bitmap bitmap = this.curFrame;
        int i3 = 0;
        if (bitmap != null) {
            i3 = 0 + com.tencent.image.util.Utils.getBitmapSize(bitmap);
        }
        Bitmap bitmap2 = this.nextFrame;
        if (bitmap2 != null) {
            i3 += com.tencent.image.util.Utils.getBitmapSize(bitmap2);
        }
        if (this.nativeFrameInfoInstance != 0) {
            return i3 + (this.width * this.height * 4);
        }
        return i3;
    }

    public Bitmap getCurrentFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Bitmap) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.curFrame;
    }

    public int getDelay() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.currentFrameDelay;
    }

    public int getHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.height;
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
        return this.mImageInfo[6];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized boolean getNextFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        long j3 = this.nativeImageInstance;
        if (j3 != 0) {
            Bitmap bitmap = this.nextFrame;
            if (bitmap != null) {
                this.nativeFrameInfoInstance = nativeGetNextFrame(j3, this.nativeFrameInfoInstance, bitmap, this.mImageInfo);
            } else {
                this.nativeFrameInfoInstance = nativeGetNextFrame(j3, this.nativeFrameInfoInstance, this.curFrame, this.mImageInfo);
            }
            int[] iArr = this.mImageInfo;
            if (iArr[5] == 0) {
                this.currentFrameDelay = iArr[4];
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getNextFrame fail: " + this.mImageInfo[5]);
            }
        }
        return false;
    }

    public boolean getPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return ((Boolean) iPatchRedirector.redirect((short) 27, (Object) this)).booleanValue();
        }
        return this.mPaused;
    }

    public int getScaledHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this, i3)).intValue();
        }
        return scaleFromDensity(this.height, this.mDensity, i3);
    }

    public int getScaledWidth(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, i3)).intValue();
        }
        return scaleFromDensity(this.width, this.mDensity, i3);
    }

    public int getWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.width;
    }

    protected void initHandlerAndRunnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else if (sHandler == null) {
            sHandler = new Handler(Looper.getMainLooper());
            sAccumulativeRunnable = new DoAccumulativeRunnable(null);
        }
    }

    void onDecodeNextFrameCanceled() {
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "apng decode canceled. " + this.file);
        }
        this.mDecodeNextFrameEnd = true;
    }

    void onDecodeNextFrameFailed(Throwable th5) {
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "apng decode error. " + this.file, th5);
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
            if (this.apngLoop > 0 && this.mFrameCount == this.mImageInfo[3] + 1) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "apng mFrameCount:" + this.mFrameCount + ", current:" + this.mImageInfo[3]);
                }
                this.currentApngLoop++;
                synchronized (this.mListener) {
                    for (int size = this.mListener.size() - 1; size >= 0; size--) {
                        ApngDrawable.OnPlayRepeatListener onPlayRepeatListener = this.mListener.get(size).get();
                        if (onPlayRepeatListener != null) {
                            onPlayRepeatListener.onPlayRepeat(this.currentApngLoop);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this);
        } else {
            this.mPaused = true;
        }
    }

    public void pauseIfNoReferences() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        cleanUpRecycleElements();
        if (this.callbacks.isEmpty()) {
            pause();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "pauseIfNoReferences");
            }
        }
    }

    public void reDraw() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            invalidateSelf();
            this.mIsInPendingAction = false;
        }
    }

    public void removeCallBack(AnimationCallback animationCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) animationCallback);
            return;
        }
        synchronized (this.callbacks) {
            int i3 = 0;
            while (i3 < this.callbacks.size()) {
                WeakReference<AnimationCallback> weakReference = this.callbacks.get(i3);
                if (weakReference != null && weakReference.get() != null) {
                    if (weakReference.get() == animationCallback) {
                        this.callbacks.remove(i3);
                        return;
                    }
                    i3++;
                }
                this.callbacks.remove(i3);
                i3--;
                i3++;
            }
        }
    }

    public void removeOnPlayRepeatListener(ApngDrawable.OnPlayRepeatListener onPlayRepeatListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) onPlayRepeatListener);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            this.currentApngLoop = 0;
            reDraw();
        }
    }

    public void resume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        this.mPaused = false;
        for (int size = sPendingActions.size() - 1; size >= 0; size--) {
            ArrayList<WeakReference<ApngImage>> arrayList = sPendingActions;
            ApngImage apngImage = arrayList.get(size).get();
            if (apngImage == this && apngImage.getIsEnable()) {
                arrayList.remove(size);
                apngImage.reDraw();
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            sAccumulativeRunnable.add(new WeakReference<>(this));
        }
    }

    public void setDensity(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
        } else {
            this.mDensity = i3;
        }
    }

    public void setOnPlayRepeatListener(ApngDrawable.OnPlayRepeatListener onPlayRepeatListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) onPlayRepeatListener);
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

    public void setSupportGlobalPasued(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, z16);
        } else {
            this.mSupportGlobalPasued = z16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class DoAccumulativeRunnable extends ArgumentsRunnable<WeakReference<ApngImage>> {
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
        protected void run(List<WeakReference<ApngImage>> list) {
            ApngImage apngImage;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
                return;
            }
            for (WeakReference<ApngImage> weakReference : list) {
                if (weakReference != null && (apngImage = weakReference.get()) != null) {
                    apngImage.doApplyNextFrame();
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
                ApngImage.sHandler.postDelayed(this, 5 - (uptimeMillis - this.lastRefreshTime));
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

    public ApngImage(File file, boolean z16, Bundle bundle) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, file, Boolean.valueOf(z16), bundle);
            return;
        }
        this.width = 0;
        this.height = 0;
        this.mFrameCount = 0;
        this.mGetResetLoop = true;
        this.mPaused = false;
        this.mDensity = 160;
        this.mListener = new ArrayList<>();
        this.mIsInPendingAction = false;
        this.mImageInfo = new int[7];
        this.paint = new Paint();
        this.paintTransparentBlack = new Paint();
        this.mSupportGlobalPasued = true;
        this.onlyOneFrame = false;
        this.callbacks = new CopyOnWriteArrayList<>();
        this.mDecodeNextFrameEnd = true;
        if (bundle != null) {
            this.apngLoop = bundle.getInt("key_loop", 0);
            this.decryptType = bundle.getInt(KEY_DECRYPTTYPE, this.decryptType);
            this.mName = bundle.getString("key_name");
            this.mOnceAndClear = bundle.getBoolean("key_once_clear", false);
            this.mDrawRoundCorner = bundle.getBoolean("key_draw_round", false);
            this.mGetResetLoop = bundle.getBoolean("key_get_reset_loop", true);
            if (!this.mDrawRoundCorner && !bundle.getBoolean("key_double_bitmap", false)) {
                z17 = false;
            }
            this.mDoubleBitmap = z17;
            this.mStopOnFirstFrame = bundle.getBoolean("key_stop_on_first", false);
            this.mUseFileLoop = bundle.getBoolean(KEY_USE_FILE_LOOP, false);
            setDensity(bundle.getInt("key_density", this.mDensity));
            int[] intArray = bundle.getIntArray("key_tagId_arr");
            if (intArray != null && intArray.length > 0) {
                this.mTagIDArr = bundle.getIntArray("key_tagId_arr");
            }
        }
        this.file = file;
        init(z16);
    }
}
