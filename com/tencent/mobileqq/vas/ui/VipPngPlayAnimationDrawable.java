package com.tencent.mobileqq.vas.ui;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/* loaded from: classes20.dex */
public class VipPngPlayAnimationDrawable extends Drawable implements Runnable {
    public static final int ANIMATION_TYPE_BUBBLE = 101;
    public static final int ANIMATION_TYPE_PENDANT = 102;
    public static final int ANIMATION_TYPE_SIGNATURE = 103;
    public static final int ANIMATION_TYPE_TROOP_NICK = 104;
    public static final String BUBBLE_ASSET_DIR = "file:///android_assets/bubbles/";
    public static final int DELAY_DEFAULT = 50;
    public static final int REPEAT_COUNT_FORVER = -1;
    private static final String TAG = "VipPngPlayAnimationDrawable";
    public static final int TYPE_BIG_PNG = 1;
    public static final int TYPE_PNG_IDS = 2;
    public static final int TYPE_PNG_PATHS = 0;
    public Bitmap mCache;
    public int mHeight;
    public int mLayoutHeight;
    public int mLayoutWidth;
    public Resources mResources;
    public Object mSource;
    public DecodeNextFrameTask mTask;
    public int mWidth;
    public int mType = -1;
    private int mCurrentType = -1;
    public int mCurFrameIndex = -1;
    private int mFrameCount = 0;
    public int mFrameDelay = 50;
    private Rect sTmpRect = new Rect();
    public Handler sHandler = new Handler(Looper.getMainLooper());
    public boolean mDecodeNextFrameEnd = true;
    public boolean mPaused = false;
    public int mRepeatCount = 0;
    public boolean mReverse = false;
    public boolean mFinished = false;
    protected Paint mPaint = new Paint(6);
    public INinePathBitmap mCurrent = new VipPngBitmap();

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes20.dex */
    public class DecodeNextFrameTask extends AsyncTask<Long, Void, Void> {
        private Object source;

        public DecodeNextFrameTask(Object obj) {
            this.source = obj;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(Long... lArr) {
            try {
                long longValue = lArr[0].longValue();
                long longValue2 = lArr[1].longValue();
                Bitmap doDecodeNext = VipPngPlayAnimationDrawable.this.doDecodeNext((int) lArr[2].longValue(), this.source, (int) longValue2);
                if (doDecodeNext != null && !isCancelled()) {
                    VipPngPlayAnimationDrawable.this.mCache = doDecodeNext;
                    long uptimeMillis = SystemClock.uptimeMillis();
                    if (uptimeMillis < longValue) {
                        VipPngPlayAnimationDrawable vipPngPlayAnimationDrawable = VipPngPlayAnimationDrawable.this;
                        vipPngPlayAnimationDrawable.sHandler.postDelayed(vipPngPlayAnimationDrawable, longValue - uptimeMillis);
                    } else {
                        VipPngPlayAnimationDrawable vipPngPlayAnimationDrawable2 = VipPngPlayAnimationDrawable.this;
                        vipPngPlayAnimationDrawable2.sHandler.post(vipPngPlayAnimationDrawable2);
                    }
                }
            } catch (OutOfMemoryError e16) {
                if (QLog.isDevelopLevel()) {
                    QLog.e(VipPngPlayAnimationDrawable.TAG, 4, "", e16);
                }
                VipPngPlayAnimationDrawable vipPngPlayAnimationDrawable3 = VipPngPlayAnimationDrawable.this;
                vipPngPlayAnimationDrawable3.mCache = null;
                vipPngPlayAnimationDrawable3.mDecodeNextFrameEnd = true;
            } catch (Throwable th5) {
                if (QLog.isDevelopLevel()) {
                    QLog.e(VipPngPlayAnimationDrawable.TAG, 4, "", th5);
                }
                VipPngPlayAnimationDrawable vipPngPlayAnimationDrawable4 = VipPngPlayAnimationDrawable.this;
                vipPngPlayAnimationDrawable4.mCache = null;
                vipPngPlayAnimationDrawable4.mDecodeNextFrameEnd = true;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public void onPostExecute(Void r26) {
            VipPngPlayAnimationDrawable.this.mTask = null;
        }
    }

    public VipPngPlayAnimationDrawable(Resources resources) {
        this.mResources = resources;
    }

    protected void decodeNextFrame() {
        if (this.mType == 1 && this.mCurFrameIndex >= 0) {
            this.sHandler.postDelayed(this, this.mFrameDelay);
            return;
        }
        if (this.mDecodeNextFrameEnd && !this.mPaused) {
            this.mDecodeNextFrameEnd = false;
            long uptimeMillis = SystemClock.uptimeMillis() + this.mFrameDelay;
            DecodeNextFrameTask decodeNextFrameTask = new DecodeNextFrameTask(this.mSource);
            this.mTask = decodeNextFrameTask;
            decodeNextFrameTask.execute(Long.valueOf(uptimeMillis), Long.valueOf(this.mCurFrameIndex), Long.valueOf(this.mType));
        }
    }

    @TargetApi(11)
    protected Bitmap doDecodeNext(int i3, Object obj, int i16) throws IOException {
        BufferedInputStream bufferedInputStream;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (i3 != 0) {
            if (i3 != 1 && i3 != 2) {
                return null;
            }
            int[] iArr = (int[]) obj;
            return BitmapFactory.decodeResource(this.mResources, iArr[(i16 + 1) % iArr.length], options);
        }
        String[] strArr = (String[]) obj;
        String str = strArr[(i16 + 1) % strArr.length];
        options.inDensity = 320;
        options.inTargetDensity = this.mResources.getDisplayMetrics().densityDpi;
        if (str.startsWith(BUBBLE_ASSET_DIR)) {
            bufferedInputStream = new BufferedInputStream(this.mResources.getAssets().open(str.substring(23)));
        } else {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
        try {
            bufferedInputStream.close();
        } catch (IOException e16) {
            e16.printStackTrace();
        }
        return decodeStream;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        int i3;
        Rect rect;
        if (this.mType == -1) {
            return;
        }
        if (this.mCurFrameIndex != -1) {
            Rect bounds = super.getBounds();
            if (this.mReverse) {
                i3 = canvas.save();
                canvas.scale(-1.0f, 1.0f, bounds.centerX(), bounds.centerY());
            } else {
                i3 = 0;
            }
            int i16 = this.mType;
            if (i16 != 1 && ((i16 == 0 || i16 == 2) && this.mCurrent != null)) {
                if (this.mLayoutWidth > 0) {
                    rect = new Rect(0, 0, this.mLayoutWidth, getIntrinsicHeight());
                } else {
                    rect = null;
                }
                this.mCurrent.draw(canvas, rect, bounds, this.mPaint);
            }
            if (this.mReverse) {
                canvas.restoreToCount(i3);
            }
        }
        if (this.mRepeatCount == 0) {
            int i17 = this.mCurrentType;
            if (102 != i17 && 103 != i17) {
                recycle();
            }
            super.invalidateSelf();
            this.mFinished = true;
            return;
        }
        decodeNextFrame();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.mHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.mWidth;
    }

    protected int getNextFrameIndex(int i3) {
        if (i3 == this.mFrameCount - 1) {
            this.mRepeatCount--;
            return 0;
        }
        return i3 + 1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public boolean isStarted() {
        if (!this.mFinished && this.mCurFrameIndex >= 0) {
            return true;
        }
        return false;
    }

    public void measure(String[] strArr) throws IOException {
        if (this.mType == 0 && Arrays.equals((String[]) this.mSource, strArr)) {
            return;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        String str = strArr[0];
        if (str.startsWith(BUBBLE_ASSET_DIR)) {
            InputStream open = this.mResources.getAssets().open(str.substring(23));
            BitmapFactory.decodeStream(open, null, options);
            if (open != null) {
                try {
                    open.close();
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            }
        } else {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(strArr[0]));
            BitmapFactory.decodeStream(bufferedInputStream, null, options);
            bufferedInputStream.close();
        }
        this.mWidth = Utils.S(options.outWidth, 320, this.mResources.getDisplayMetrics().densityDpi);
        int S = Utils.S(options.outHeight, 320, this.mResources.getDisplayMetrics().densityDpi);
        this.mHeight = S;
        this.mLayoutWidth = this.mWidth;
        this.mLayoutHeight = S;
    }

    public void recycle() {
        INinePathBitmap iNinePathBitmap = this.mCurrent;
        if (iNinePathBitmap != null) {
            iNinePathBitmap.recycle();
        }
        Bitmap bitmap = this.mCache;
        if (bitmap != null) {
            bitmap.recycle();
            this.mCache = null;
        }
        DecodeNextFrameTask decodeNextFrameTask = this.mTask;
        if (decodeNextFrameTask != null) {
            decodeNextFrameTask.cancel(false);
            this.mTask = null;
        }
        this.mType = -1;
        this.mDecodeNextFrameEnd = true;
        this.mCurFrameIndex = -1;
        this.mFrameDelay = 50;
        this.mRepeatCount = -1;
        this.mFinished = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.mCache == null) {
            return;
        }
        this.mDecodeNextFrameEnd = true;
        this.mCurFrameIndex = getNextFrameIndex(this.mCurFrameIndex);
        if (this.mType != -1 && this.mCache != null && this.mCurrent.getMBitmap() != this.mCache) {
            this.mCurrent.recycle();
            this.mCurrent.next(this.mCache);
            this.mCache = null;
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        if (i3 != this.mPaint.getAlpha()) {
            this.mPaint.setAlpha(i3);
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        super.invalidateSelf();
    }

    public void setCurrentType(int i3) {
        this.mCurrentType = i3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z16) {
        this.mPaint.setDither(z16);
        super.invalidateSelf();
    }

    public void setPaused(boolean z16) {
        this.mPaused = z16;
        if (!z16) {
            super.invalidateSelf();
        }
    }

    public void setPngPaths(String[] strArr, int i3) {
        if (strArr != null) {
            if (this.mType != 0 || !Arrays.equals((String[]) this.mSource, strArr)) {
                recycle();
                this.mType = 0;
                this.mSource = strArr;
                this.mFrameCount = strArr.length;
                this.mFrameDelay = i3;
                this.mFinished = false;
            }
        }
    }

    public void startAnimation(int i3, int i16) {
        this.mFrameCount = i3;
        this.mRepeatCount = i16;
        this.mFinished = false;
    }
}
