package com.tencent.image;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.image.GifDrawable;
import com.tencent.image.NativeGifIOException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes7.dex */
public class NativeGifImage extends AbstractGifImage {
    static IPatchRedirector $redirector_ = null;
    protected static int CURRENT_FRAMEINDEX_INDEX = 0;
    protected static int CURRENT_LOOP_INDEX = 0;
    public static final Bitmap.Config DEFAULT_CONFIG;
    protected static int ERRCODE_INDEX = 0;
    protected static int FRAME_COUNT_INDEX = 0;
    public static int GIF_DEFAULT_DELAY = 0;
    protected static int HEIGHT_INDEX = 0;
    private static int IMAGE_SIZE_DISABLE_DOUBLE_BUFFER = 0;
    protected static int POST_INVALIDATION_TIME_INDEX = 0;
    public static int QZONE_DELAY = 0;
    public static final String TAG = "NativeGifImage";
    protected static int WIDTH_INDEX;
    private static boolean mIsGIFEngineAvaliable;
    private static AtomicBoolean mIsLibLoaded;
    private static int[] sequence;
    protected Bitmap.Config mCurrentConfig;
    protected Bitmap mCurrentFrameBitmap;
    protected Bitmap mCurrentFrameBitmapBuffer;
    protected int mCurrentFrameIndex;
    protected int mCurrentLoop;
    protected boolean mDecodeNextFrameEnd;
    protected Bitmap mFirstFrameBitmap;
    private volatile long mGifFilePtr;
    protected final boolean mIsEmosmFile;
    protected final int[] mMetaData;
    protected final int mReqHeight;
    protected final int mReqWidth;
    protected final String mSrcGifFile;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class NativeDecodeFrameTask implements Runnable {
        static IPatchRedirector $redirector_;
        final long mNextFrameTime;

        public NativeDecodeFrameTask(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NativeGifImage.this, Long.valueOf(j3));
            } else {
                this.mNextFrameTime = j3;
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            NativeGifImage.this.getNextFrame();
            if (NativeGifImage.this.mMetaData[NativeGifImage.FRAME_COUNT_INDEX] > 1) {
                long uptimeMillis = SystemClock.uptimeMillis();
                Runnable runnable = new Runnable() { // from class: com.tencent.image.NativeGifImage.NativeDecodeFrameTask.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) NativeDecodeFrameTask.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        NativeGifImage nativeGifImage = NativeGifImage.this;
                        if (nativeGifImage.mRefreshDelay != -1) {
                            nativeGifImage.doApplyNextFrameItemRefresh();
                        } else {
                            AbstractGifImage.sAccumulativeRunnable.add(new WeakReference<>(NativeGifImage.this));
                        }
                    }
                };
                long j3 = this.mNextFrameTime;
                if (uptimeMillis < j3) {
                    AbstractGifImage.sUIThreadHandler.postDelayed(runnable, j3 - uptimeMillis);
                } else {
                    AbstractGifImage.sUIThreadHandler.post(runnable);
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10173);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
            return;
        }
        DEFAULT_CONFIG = Bitmap.Config.ARGB_8888;
        QZONE_DELAY = -1;
        GIF_DEFAULT_DELAY = -1;
        WIDTH_INDEX = 0;
        HEIGHT_INDEX = 1;
        FRAME_COUNT_INDEX = 2;
        ERRCODE_INDEX = 3;
        POST_INVALIDATION_TIME_INDEX = 4;
        CURRENT_FRAMEINDEX_INDEX = 5;
        CURRENT_LOOP_INDEX = 6;
        mIsGIFEngineAvaliable = false;
        mIsLibLoaded = new AtomicBoolean(false);
        IMAGE_SIZE_DISABLE_DOUBLE_BUFFER = 262144;
    }

    public NativeGifImage(File file, boolean z16, boolean z17, int i3, int i16, float f16) throws IOException {
        this(file, z16, z17, i3, i16, f16, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, file, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16));
    }

    public static Rect getImageSize(File file, boolean z16) throws IOException {
        if (file != null) {
            if (!file.exists()) {
                return new Rect(0, 0, 0, 0);
            }
            int[] iArr = new int[7];
            if (mIsGIFEngineAvaliable) {
                nativeGetFileImageSize(iArr, file.getPath(), z16);
            } else {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(file.getPath(), options);
                iArr[WIDTH_INDEX] = options.outWidth;
                iArr[HEIGHT_INDEX] = options.outHeight;
            }
            return new Rect(0, 0, iArr[WIDTH_INDEX], iArr[HEIGHT_INDEX]);
        }
        throw new NullPointerException("Source is null");
    }

    private void init(boolean z16) {
        getNextFrame();
        applyNextFrame();
        if (z16) {
            try {
                Bitmap bitmap = this.mCurrentFrameBitmap;
                this.mFirstFrameBitmap = bitmap.copy(bitmap.getConfig(), false);
            } catch (OutOfMemoryError unused) {
            }
        }
    }

    private void initCurrentFrameBitmap() {
        if (mIsGIFEngineAvaliable) {
            try {
                this.mCurrentFrameBitmap = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
            } catch (OutOfMemoryError unused) {
                if (this.mCurrentConfig == Bitmap.Config.ARGB_8888) {
                    try {
                        Bitmap.Config config = Bitmap.Config.ARGB_4444;
                        this.mCurrentConfig = config;
                        this.mCurrentFrameBitmap = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, config);
                    } catch (OutOfMemoryError unused2) {
                        URLDrawable.clearMemoryCache();
                        this.mCurrentFrameBitmap = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
                    }
                } else {
                    URLDrawable.clearMemoryCache();
                    this.mCurrentFrameBitmap = Bitmap.createBitmap(this.mReqWidth, this.mReqHeight, this.mCurrentConfig);
                }
            }
            int i3 = this.mReqWidth;
            int i16 = this.mReqHeight;
            if (i3 * i16 <= IMAGE_SIZE_DISABLE_DOUBLE_BUFFER) {
                try {
                    this.mCurrentFrameBitmapBuffer = Bitmap.createBitmap(i3, i16, this.mCurrentConfig);
                } catch (OutOfMemoryError unused3) {
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0058 A[Catch: Exception -> 0x009c, UnsatisfiedLinkError -> 0x00c9, all -> 0x00f6, TRY_LEAVE, TryCatch #3 {Exception -> 0x009c, UnsatisfiedLinkError -> 0x00c9, blocks: (B:14:0x0015, B:16:0x0041, B:19:0x0045, B:21:0x0049, B:24:0x0050, B:31:0x0058), top: B:13:0x0015, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x007c A[Catch: all -> 0x00f6, TryCatch #1 {, blocks: (B:8:0x000d, B:10:0x0012, B:14:0x0015, B:16:0x0041, B:19:0x0045, B:21:0x0049, B:24:0x0050, B:31:0x0058, B:33:0x0064, B:35:0x007c, B:36:0x009a, B:40:0x009d, B:42:0x00a7, B:43:0x00c7, B:46:0x00ca, B:48:0x00d4, B:49:0x00f4), top: B:7:0x000d, inners: #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean loadLibrary() {
        boolean z16;
        if (mIsLibLoaded.get()) {
            return true;
        }
        synchronized (NativeGifImage.class) {
            if (URLDrawable.mApplicationContext == null) {
                return false;
            }
            try {
                Utils.beginPile();
                mIsGIFEngineAvaliable = URLDrawable.depImp.mTool.loadSoByName(URLDrawable.mApplicationContext, "GIFEngine");
                int[] nativeTestColor = nativeTestColor(Bitmap.createBitmap(new int[]{Color.argb(255, 0, 1, 2)}, 1, 1, DEFAULT_CONFIG));
                sequence = nativeTestColor;
                if (nativeTestColor != null && nativeTestColor.length == 4) {
                    for (int i3 : nativeTestColor) {
                        if (i3 >= 0 && i3 <= 3) {
                        }
                    }
                    z16 = false;
                    if (z16) {
                        sequence = new int[]{0, 1, 2, 3};
                    }
                    mIsLibLoaded.set(true);
                    Utils.endPile(TAG, "Load libGIFEngine");
                    if (URLDrawable.depImp.mLog.isColorLevel()) {
                        URLDrawable.depImp.mLog.i(TAG, 2, "libGIFEngine.so loaded " + mIsLibLoaded);
                    }
                    return true;
                }
                z16 = true;
                if (z16) {
                }
                mIsLibLoaded.set(true);
                Utils.endPile(TAG, "Load libGIFEngine");
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                }
                return true;
            } catch (Exception e16) {
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                    URLDrawable.depImp.mLog.e(TAG, 2, "loadLibrary(): " + e16.getMessage());
                }
                return false;
            } catch (UnsatisfiedLinkError e17) {
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                    URLDrawable.depImp.mLog.e(TAG, 2, "loadLibrary(): " + e17.getMessage());
                }
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeFree(long j3);

    private static native long nativeGetAllocationByteCount(long j3);

    private static native int nativeGetFileImageSize(int[] iArr, String str, boolean z16) throws NativeGifIOException;

    private static native long nativeOpenFile(int[] iArr, String str, Bitmap bitmap, boolean z16) throws NativeGifIOException;

    private static native boolean nativeReset(long j3);

    private static native void nativeSeekToNextFrame(Bitmap bitmap, long j3, int[] iArr, int[] iArr2);

    private static native int[] nativeTestColor(Bitmap bitmap);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.image.AbstractGifImage
    public synchronized void applyNextFrame() {
        GifDrawable.OnGIFPlayOnceListener onGIFPlayOnceListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        int[] iArr = this.mMetaData;
        int i3 = iArr[CURRENT_FRAMEINDEX_INDEX];
        this.mCurrentFrameIndex = i3;
        int i16 = iArr[CURRENT_LOOP_INDEX];
        this.mCurrentLoop = i16;
        if (i16 == 1 && i3 == 0) {
            WeakReference<GifDrawable.OnGIFPlayOnceListener> weakReference = this.mPlayOnceListener;
            if (weakReference != null && (onGIFPlayOnceListener = weakReference.get()) != null) {
                onGIFPlayOnceListener.onPlayOnce();
            }
            GifDrawable.OnGIFPlayOnceListener onGIFPlayOnceListener2 = this.mStrongPlayOnceListener;
            if (onGIFPlayOnceListener2 != null) {
                onGIFPlayOnceListener2.onPlayOnce();
            }
        }
        Paint paint = null;
        r1 = null;
        r1 = null;
        Bitmap createBitmap = null;
        if (this.mCurrentFrameBitmapBuffer != null) {
            Canvas canvas = new Canvas(this.mCurrentFrameBitmap);
            this.mCurrentFrameBitmap.eraseColor(0);
            if (this.mDefaultRoundCorner > 0.0f) {
                paint = new Paint();
                paint.setAntiAlias(true);
                RectF rectF = new RectF(0.0f, 0.0f, this.mCurrentFrameBitmap.getWidth(), this.mCurrentFrameBitmap.getHeight());
                float f16 = this.mDefaultRoundCorner;
                canvas.drawRoundRect(rectF, f16, f16, paint);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            }
            canvas.drawBitmap(this.mCurrentFrameBitmapBuffer, 0.0f, 0.0f, paint);
        } else if (this.mDefaultRoundCorner > 0.0f) {
            try {
                createBitmap = Bitmap.createBitmap(this.mCurrentFrameBitmap.getWidth(), this.mCurrentFrameBitmap.getHeight(), this.mCurrentConfig);
            } catch (OutOfMemoryError unused) {
                if (this.mCurrentConfig == Bitmap.Config.ARGB_8888) {
                    try {
                        createBitmap = Bitmap.createBitmap(this.mCurrentFrameBitmap.getWidth(), this.mCurrentFrameBitmap.getHeight(), Bitmap.Config.ARGB_4444);
                    } catch (OutOfMemoryError unused2) {
                        if (URLDrawable.depImp.mLog.isColorLevel()) {
                            URLDrawable.depImp.mLog.d(TAG, 2, "create ARGB_4444 bitmap oom!");
                        }
                    }
                }
            }
            if (createBitmap != null) {
                Canvas canvas2 = new Canvas(createBitmap);
                Paint paint2 = new Paint();
                paint2.setAntiAlias(true);
                RectF rectF2 = new RectF(0.0f, 0.0f, this.mCurrentFrameBitmap.getWidth(), this.mCurrentFrameBitmap.getHeight());
                float f17 = this.mDefaultRoundCorner;
                canvas2.drawRoundRect(rectF2, f17, f17, paint2);
                paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                canvas2.drawBitmap(this.mCurrentFrameBitmap, 0.0f, 0.0f, paint2);
                this.mCurrentFrameBitmap = createBitmap;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.image.AbstractGifImage
    public void doApplyNextFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            this.mDecodeNextFrameEnd = true;
            super.doApplyNextFrame();
        }
    }

    @Override // com.tencent.image.AbstractGifImage
    public void draw(Canvas canvas, Rect rect, Paint paint, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, canvas, rect, paint, Boolean.valueOf(z16));
            return;
        }
        initHandlerAndRunnable();
        if (this.mMetaData[FRAME_COUNT_INDEX] > 1 && (z16 || this.mCurrentFrameBitmap == null)) {
            Bitmap bitmap = this.mCurrentFrameBitmap;
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, (Rect) null, rect, paint);
            }
            boolean z17 = AbstractGifImage.sPaused;
            if (!z17) {
                executeNewTask();
                return;
            } else {
                if (!this.mIsInPendingAction) {
                    if (z17) {
                        AbstractGifImage.sPendingActions.add(new WeakReference<>(this));
                    }
                    this.mIsInPendingAction = true;
                    return;
                }
                return;
            }
        }
        canvas.drawBitmap(this.mCurrentFrameBitmap, (Rect) null, rect, paint);
    }

    public void drawFirstFrame(Canvas canvas, Rect rect, Paint paint) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, canvas, rect, paint);
            return;
        }
        initHandlerAndRunnable();
        Bitmap bitmap = this.mFirstFrameBitmap;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, (Rect) null, rect, paint);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.image.AbstractGifImage
    public void executeNewTask() {
        long uptimeMillis;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.mDecodeNextFrameEnd) {
            this.mDecodeNextFrameEnd = false;
            GIF_DEFAULT_DELAY = this.mMetaData[POST_INVALIDATION_TIME_INDEX];
            if (QZONE_DELAY == -1) {
                uptimeMillis = SystemClock.uptimeMillis();
                i3 = this.mMetaData[POST_INVALIDATION_TIME_INDEX];
            } else {
                uptimeMillis = SystemClock.uptimeMillis();
                i3 = QZONE_DELAY;
            }
            try {
                URLDrawable.depImp.mThreadManager.executeOnFileThreadExcutor(new NativeDecodeFrameTask(uptimeMillis + i3), null, true);
            } catch (RejectedExecutionException e16) {
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                    URLDrawable.depImp.mLog.e(URLDrawable.TAG, 2, "executeNewTask()", e16);
                }
            }
        }
    }

    protected void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        long j3 = this.mGifFilePtr;
        this.mGifFilePtr = 0L;
        if (mIsGIFEngineAvaliable) {
            URLDrawable.depImp.mThreadManager.executeOnFileThreadExcutor(new Runnable(j3) { // from class: com.tencent.image.NativeGifImage.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ long val$tmpPtr;

                {
                    this.val$tmpPtr = j3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, NativeGifImage.this, Long.valueOf(j3));
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                        NativeGifImage.nativeFree(this.val$tmpPtr);
                    } else {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                }
            }, null, false);
        }
        super.finalize();
    }

    @Override // com.tencent.image.AbstractGifImage
    @TargetApi(12)
    public int getByteSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        long j3 = 0;
        if (mIsGIFEngineAvaliable) {
            try {
                j3 = 0 + nativeGetAllocationByteCount(this.mGifFilePtr);
            } catch (UnsatisfiedLinkError e16) {
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                    URLDrawable.depImp.mLog.e(TAG, 2, "getByteSize(): " + e16.getMessage());
                }
            }
        }
        return (int) (j3 + Utils.getBitmapSize(this.mCurrentFrameBitmap) + Utils.getBitmapSize(this.mFirstFrameBitmap) + Utils.getBitmapSize(this.mCurrentFrameBitmapBuffer));
    }

    public NativeGifIOException.NativeGifError getError() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (NativeGifIOException.NativeGifError) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return NativeGifIOException.NativeGifError.fromCode(this.mMetaData[ERRCODE_INDEX]);
    }

    public Bitmap getFirstFrameBitmap() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Bitmap) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.mFirstFrameBitmap;
    }

    @Override // com.tencent.image.AbstractGifImage
    public int getHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        Bitmap bitmap = this.mCurrentFrameBitmap;
        if (bitmap != null) {
            return bitmap.getHeight();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void getNextFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (mIsGIFEngineAvaliable) {
            Bitmap bitmap = this.mCurrentFrameBitmapBuffer;
            if (bitmap != null) {
                nativeSeekToNextFrame(bitmap, this.mGifFilePtr, this.mMetaData, sequence);
            } else {
                nativeSeekToNextFrame(this.mCurrentFrameBitmap, this.mGifFilePtr, this.mMetaData, sequence);
            }
        } else {
            try {
                Bitmap decodeFile = BitmapFactory.decodeFile(this.mSrcGifFile);
                this.mCurrentFrameBitmap = decodeFile;
                this.mCurrentFrameBitmap = Bitmap.createScaledBitmap(decodeFile, this.mReqWidth, this.mReqHeight, true);
            } catch (OutOfMemoryError unused) {
            }
        }
    }

    @Override // com.tencent.image.AbstractGifImage
    public int getWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        Bitmap bitmap = this.mCurrentFrameBitmap;
        if (bitmap != null) {
            return bitmap.getWidth();
        }
        return 0;
    }

    @Override // com.tencent.image.AbstractGifImage
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        this.mCurrentFrameIndex = -1;
        this.mCurrentLoop = -1;
        if (mIsGIFEngineAvaliable) {
            nativeReset(this.mGifFilePtr);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return String.format(Locale.US, "Size: %dx%d, %d frames, error: %d", Integer.valueOf(this.mMetaData[0]), Integer.valueOf(this.mMetaData[1]), Integer.valueOf(this.mMetaData[2]), Integer.valueOf(this.mMetaData[3]));
    }

    public NativeGifImage(File file, boolean z16, boolean z17, int i3, int i16, float f16, Bundle bundle) throws IOException {
        super(bundle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, file, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16), bundle);
            return;
        }
        int[] iArr = new int[7];
        this.mMetaData = iArr;
        this.mDecodeNextFrameEnd = true;
        this.mCurrentConfig = DEFAULT_CONFIG;
        this.mGifFilePtr = 0L;
        if (!loadLibrary() && URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.e(TAG, 2, "NativeGifImage loadLibrary error");
        }
        if (file != null) {
            String absolutePath = file.getAbsolutePath();
            this.mSrcGifFile = absolutePath;
            this.mIsEmosmFile = z17;
            if (!file.exists() && URLDrawable.depImp.mLog.isColorLevel()) {
                URLDrawable.depImp.mLog.e(TAG, 2, absolutePath + " doesn't exist");
            }
            Rect imageSize = getImageSize(file, z17);
            int width = imageSize.width();
            int height = imageSize.height();
            if (i3 > 0 && i16 > 0) {
                float f17 = width;
                float f18 = i3 / f17;
                float f19 = height;
                float f26 = i16 / f19;
                f18 = f18 >= f26 ? f26 : f18;
                if (f18 < 1.0f) {
                    width = (int) (f17 * f18);
                    height = (int) (f19 * f18);
                }
            }
            this.mReqWidth = width;
            this.mReqHeight = height;
            initCurrentFrameBitmap();
            if (mIsGIFEngineAvaliable) {
                this.mGifFilePtr = nativeOpenFile(iArr, file.getPath(), this.mCurrentFrameBitmap, z17);
            } else {
                iArr[WIDTH_INDEX] = imageSize.width();
                iArr[HEIGHT_INDEX] = imageSize.height();
                iArr[FRAME_COUNT_INDEX] = 1;
                iArr[ERRCODE_INDEX] = 0;
                iArr[POST_INVALIDATION_TIME_INDEX] = Integer.MAX_VALUE;
                iArr[CURRENT_FRAMEINDEX_INDEX] = -1;
                iArr[CURRENT_LOOP_INDEX] = -1;
            }
            this.mDefaultRoundCorner = f16;
            init(z16);
            return;
        }
        throw new NullPointerException("Source is null");
    }

    public NativeGifImage(File file, boolean z16) throws IOException {
        this(file, z16, false, 0, 0, 0.0f, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, file, Boolean.valueOf(z16));
    }
}
