package com.tencent.image;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.image.NativeGifIOException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.concurrent.RejectedExecutionException;

/* compiled from: P */
/* loaded from: classes7.dex */
public class NativeGifIndex8 extends AbstractGifImage {
    static IPatchRedirector $redirector_ = null;
    public static final int INDEX_EXT_DATA_NEXT_DELAY = 0;
    public static final int INDEX_EXT_DATA_RESULT_CODE = 1;
    public static final String TAG = "NativeGifIndex8";
    private static boolean mIsGIFEngineAvaliable;
    private static boolean mIsLibLoaded;
    private boolean mCacheFirstFrame;
    protected Bitmap mCurrentFrameBitmap;
    protected Bitmap mCurrentFrameBitmapBuffer;
    protected boolean mDecodeNextFrameEnd;
    protected int[] mExtData;
    protected Bitmap mFirstFrameBitmap;
    public int mFrameNumber;
    private volatile int mGifHandler;
    private boolean mIsFirstBitmap;
    private Bitmap mLastBitmap;
    protected int mReqHeight;
    protected int mReqWidth;
    protected String mSrcGifFile;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public class NativeDecodeFrameTask implements Runnable {
        static IPatchRedirector $redirector_;
        final long mNextFrameTime;

        public NativeDecodeFrameTask(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NativeGifIndex8.this, Long.valueOf(j3));
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
            NativeGifIndex8.this.getNextFrame();
            if (NativeGifIndex8.this.mFrameNumber > 1) {
                long uptimeMillis = SystemClock.uptimeMillis();
                Runnable runnable = new Runnable() { // from class: com.tencent.image.NativeGifIndex8.NativeDecodeFrameTask.1
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
                        NativeGifIndex8 nativeGifIndex8 = NativeGifIndex8.this;
                        if (nativeGifIndex8.mRefreshDelay != -1) {
                            nativeGifIndex8.doApplyNextFrameItemRefresh();
                        } else {
                            AbstractGifImage.sAccumulativeRunnable.add(new WeakReference<>(NativeGifIndex8.this));
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10247);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            mIsGIFEngineAvaliable = false;
            mIsLibLoaded = false;
        }
    }

    public NativeGifIndex8(File file, boolean z16, boolean z17, int i3, int i16, float f16) throws IOException {
        this(file, z16, z17, i3, i16, f16, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, file, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16));
    }

    public static Rect getImageSize(File file, boolean z16) {
        if (!file.exists()) {
            return new Rect(0, 0, 0, 0);
        }
        if (mIsGIFEngineAvaliable) {
            int nativeInit = nativeInit(file.getPath(), z16);
            nativeGetWidth(nativeInit);
            nativeGetHeight(nativeInit);
            nativeUnInit(nativeInit);
        } else {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(file.getPath(), options);
        }
        BitmapFactory.Options options2 = new BitmapFactory.Options();
        options2.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getPath(), options2);
        return new Rect(0, 0, options2.outWidth, options2.outHeight);
    }

    public static String getSoLibPath(Context context) {
        File filesDir;
        if (context == null || (filesDir = context.getFilesDir()) == null) {
            return null;
        }
        return filesDir.getParent() + SoLoadCore.PATH_TX_LIB;
    }

    private void init(boolean z16) {
        getNextFrame();
        applyNextFrame();
        if (z16) {
            try {
                this.mFirstFrameBitmap = this.mCurrentFrameBitmap;
            } catch (OutOfMemoryError unused) {
            }
        }
    }

    private void initSize(int i3, int i16) {
        Rect imageSize = getImageSize();
        int width = imageSize.width();
        int height = imageSize.height();
        if (i3 > 0 && i16 > 0) {
            float f16 = width;
            float f17 = i3 / f16;
            float f18 = height;
            float f19 = i16 / f18;
            if (f17 >= f19) {
                f17 = f19;
            }
            if (f17 < 1.0f) {
                width = (int) (f16 * f17);
                height = (int) (f18 * f17);
            }
        }
        this.mReqWidth = width;
        this.mReqHeight = height;
    }

    public static boolean isGifEngineAvail() {
        loadLibrary();
        if (mIsGIFEngineAvaliable) {
            return true;
        }
        return false;
    }

    private static void loadLibrary() {
        SharedPreferences sharedPreferences;
        boolean z16;
        Context context = URLDrawable.mApplicationContext;
        if (context != null) {
            sharedPreferences = context.getSharedPreferences("early_qq.android.native.gif", 4);
            if (sharedPreferences != null) {
                z16 = sharedPreferences.getBoolean("gif_so_is_update", false);
                if ((mIsLibLoaded && URLDrawable.mApplicationContext != null) || z16) {
                    try {
                        System.load(getSoLibPath(URLDrawable.mApplicationContext) + "libkIndexGif.so");
                        mIsGIFEngineAvaliable = true;
                        if (sharedPreferences != null) {
                            sharedPreferences.edit().putBoolean("gif_so_is_update", false).commit();
                        }
                        if (URLDrawable.depImp.mLog.isColorLevel()) {
                            URLDrawable.depImp.mLog.d(TAG, 2, "libkIndexGif.so is loaded. gifIsUpdate:" + z16);
                        }
                    } catch (Exception e16) {
                        if (URLDrawable.depImp.mLog.isColorLevel()) {
                            URLDrawable.depImp.mLog.e(TAG, 2, "loadLibrary(): " + e16.getMessage());
                        }
                    } catch (UnsatisfiedLinkError e17) {
                        if (URLDrawable.depImp.mLog.isColorLevel()) {
                            URLDrawable.depImp.mLog.e(TAG, 2, "loadLibrary(): " + e17.getMessage());
                        }
                    }
                    mIsLibLoaded = true;
                    return;
                }
            }
        } else {
            sharedPreferences = null;
        }
        z16 = false;
        if (mIsLibLoaded) {
        }
    }

    private static native Bitmap nativeDecodeNext(int[] iArr, int i3);

    private static native int nativeGetFrameNum(int i3);

    private static native int nativeGetHeight(int i3);

    private static native int nativeGetWidth(int i3);

    private static native int nativeInit(String str, boolean z16);

    private static native boolean nativeIsEnd(int i3);

    private static native void nativeSetDestSize(int i3, int i16, int i17);

    private static native void nativeSetLoopCount(int i3, int i16);

    private static native int nativeUnInit(int i3);

    @Override // com.tencent.image.AbstractGifImage
    protected void applyNextFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.image.AbstractGifImage
    public void doApplyNextFrame() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.mDecodeNextFrameEnd = true;
            super.doApplyNextFrame();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.image.AbstractGifImage
    public void draw(Canvas canvas, Rect rect, Paint paint, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, canvas, rect, paint, Boolean.valueOf(z16));
            return;
        }
        initHandlerAndRunnable();
        if (this.mFrameNumber > 1 && z16) {
            Bitmap bitmap = this.mCurrentFrameBitmap;
            if (bitmap != null && !bitmap.isRecycled()) {
                try {
                    canvas.drawBitmap(this.mCurrentFrameBitmap, (Rect) null, rect, paint);
                } catch (Throwable th5) {
                    if (URLDrawable.depImp.mLog.isColorLevel()) {
                        URLDrawable.depImp.mLog.w(TAG, 2, th5.getMessage());
                    }
                    URLDrawable.mApplicationContext.getSharedPreferences("early_qq.android.native.gif", 4).edit().putBoolean("use_new_gif_so", false).commit();
                }
            }
            Bitmap bitmap2 = this.mLastBitmap;
            if (bitmap2 != null && !bitmap2.isRecycled() && !this.mIsFirstBitmap) {
                this.mLastBitmap.recycle();
                this.mIsFirstBitmap = false;
            }
            Bitmap bitmap3 = this.mCurrentFrameBitmap;
            if (bitmap3 != null && !bitmap3.isRecycled()) {
                this.mLastBitmap = this.mCurrentFrameBitmap;
            }
            if (!AbstractGifImage.sPaused) {
                executeNewTask();
                return;
            } else {
                if (!this.mIsInPendingAction) {
                    AbstractGifImage.sPendingActions.add(new WeakReference<>(this));
                    this.mIsInPendingAction = true;
                    return;
                }
                return;
            }
        }
        Bitmap bitmap4 = this.mCurrentFrameBitmap;
        if (bitmap4 != null && !bitmap4.isRecycled()) {
            canvas.drawBitmap(this.mCurrentFrameBitmap, (Rect) null, rect, paint);
        } else {
            URLDrawable.mApplicationContext.getSharedPreferences("early_qq.android.native.gif", 4).edit().putBoolean("use_new_gif_so", false).commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.image.AbstractGifImage
    public void executeNewTask() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.mDecodeNextFrameEnd) {
            this.mDecodeNextFrameEnd = false;
            try {
                URLDrawable.depImp.mThreadManager.executeOnFileThreadExcutor(new NativeDecodeFrameTask(SystemClock.uptimeMillis() + this.mExtData[0]), null, true);
            } catch (RejectedExecutionException e16) {
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                    URLDrawable.depImp.mLog.e(URLDrawable.TAG, 2, "executeNewTask->" + e16.getMessage());
                }
                URLDrawable.mApplicationContext.getSharedPreferences("early_qq.android.native.gif", 4).edit().putBoolean("use_new_gif_so", false).commit();
            } catch (Exception e17) {
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                    URLDrawable.depImp.mLog.e(URLDrawable.TAG, 2, "executeNewTask->" + e17.getMessage());
                }
                URLDrawable.mApplicationContext.getSharedPreferences("early_qq.android.native.gif", 4).edit().putBoolean("use_new_gif_so", false).commit();
            }
        }
    }

    protected void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        int i3 = this.mGifHandler;
        this.mGifHandler = 0;
        if (mIsGIFEngineAvaliable) {
            nativeUnInit(i3);
        }
        super.finalize();
    }

    @Override // com.tencent.image.AbstractGifImage
    public int getByteSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        return (int) (Utils.getBitmapSize(this.mCurrentFrameBitmap) + 0 + Utils.getBitmapSize(this.mFirstFrameBitmap));
    }

    public NativeGifIOException.NativeGifError getError() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (NativeGifIOException.NativeGifError) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return NativeGifIOException.NativeGifError.fromCode(this.mExtData[1]);
    }

    @Override // com.tencent.image.AbstractGifImage
    public int getHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        if (this.mGifHandler != 0) {
            return nativeGetHeight(this.mGifHandler);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void getNextFrame() {
        SharedPreferences sharedPreferences;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (mIsGIFEngineAvaliable) {
            try {
                this.mCurrentFrameBitmap = nativeDecodeNext(this.mExtData, this.mGifHandler);
            } catch (IllegalArgumentException e16) {
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                    URLDrawable.depImp.mLog.w(TAG, 2, e16.getMessage());
                }
            } catch (OutOfMemoryError e17) {
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                    URLDrawable.depImp.mLog.w(TAG, 2, e17.getMessage());
                }
            }
            if ((this.mCurrentFrameBitmap == null || this.mExtData[1] != 0) && (sharedPreferences = URLDrawable.mApplicationContext.getSharedPreferences("early_qq.android.native.gif", 4)) != null) {
                sharedPreferences.edit().putBoolean("use_new_gif_so", false).commit();
            }
            return;
        }
        if (URLDrawable.depImp.mLog.isColorLevel()) {
            URLDrawable.depImp.mLog.w(TAG, 2, "mIsGIFEngineAvaliable is false.");
        }
        if (this.mReqHeight > 0 && this.mReqWidth > 0) {
            try {
                Bitmap decodeFile = BitmapFactory.decodeFile(this.mSrcGifFile);
                this.mCurrentFrameBitmap = decodeFile;
                this.mCurrentFrameBitmap = Bitmap.createScaledBitmap(decodeFile, this.mReqWidth, this.mReqHeight, true);
            } catch (OutOfMemoryError e18) {
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                    URLDrawable.depImp.mLog.e(TAG, 2, "getNextFrame failed,[oom], " + e18.getMessage());
                }
            } catch (Throwable th5) {
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                    URLDrawable.depImp.mLog.e(TAG, 2, "getNextFrame failed, " + th5.getMessage());
                }
            }
            return;
        }
        return;
    }

    @Override // com.tencent.image.AbstractGifImage
    public int getWidth() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        if (this.mGifHandler != 0) {
            return nativeGetWidth(this.mGifHandler);
        }
        return 0;
    }

    public NativeGifIndex8(File file, boolean z16, boolean z17, int i3, int i16, float f16, Bundle bundle) throws IOException {
        super(bundle);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, file, Boolean.valueOf(z16), Boolean.valueOf(z17), Integer.valueOf(i3), Integer.valueOf(i16), Float.valueOf(f16), bundle);
            return;
        }
        this.mDecodeNextFrameEnd = true;
        this.mGifHandler = 0;
        this.mIsFirstBitmap = true;
        this.mCacheFirstFrame = false;
        if (file != null) {
            loadLibrary();
            this.mSrcGifFile = file.getAbsolutePath();
            this.mCacheFirstFrame = z16;
            if (!file.exists()) {
                if (URLDrawable.depImp.mLog.isColorLevel()) {
                    URLDrawable.depImp.mLog.e(TAG, 2, this.mSrcGifFile + " doesn't exist");
                    return;
                }
                return;
            }
            int[] iArr = new int[2];
            this.mExtData = iArr;
            if (mIsGIFEngineAvaliable) {
                this.mGifHandler = nativeInit(this.mSrcGifFile, z17);
                initSize(i3, i16);
                nativeSetDestSize(this.mGifHandler, this.mReqWidth, this.mReqHeight);
                nativeSetLoopCount(this.mGifHandler, -1);
                this.mFrameNumber = nativeGetFrameNum(this.mGifHandler);
                this.mExtData[0] = 0;
            } else {
                this.mFrameNumber = 1;
                iArr[0] = 100;
            }
            this.mDefaultRoundCorner = f16;
            init(z16);
            return;
        }
        throw new NullPointerException("Source is null");
    }

    public Rect getImageSize() {
        int i3;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Rect) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (mIsGIFEngineAvaliable) {
            i16 = nativeGetWidth(this.mGifHandler);
            i3 = nativeGetHeight(this.mGifHandler);
        } else {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(this.mSrcGifFile, options);
            int i17 = options.outWidth;
            i3 = options.outHeight;
            i16 = i17;
        }
        return new Rect(0, 0, i16, i3);
    }

    public NativeGifIndex8(File file, boolean z16) throws IOException {
        this(file, z16, false, 0, 0, 0.0f, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, this, file, Boolean.valueOf(z16));
    }
}
