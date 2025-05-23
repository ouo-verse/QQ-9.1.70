package com.tencent.component.media.photogif;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.IDecoder;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.ImageOptionSampleSize;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.component.media.utils.LruCache;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: P */
/* loaded from: classes5.dex */
public class NewAnimationDrawable extends Drawable implements Animatable {
    private static final String TAG = "NewAnimationDrawable";
    private static AtomicLong sMaxCacheSizeForAll;
    private BitmapReference mCurBitmapRef;
    private Drawable mDefaultFrame;
    private long mDelayTime;
    private int mFrameCounts;
    private volatile boolean mIsRunning;
    private LruCache<String, BitmapReference> mLruCache;
    private BitmapReference mNextBitmapRef;
    private ImageLoader.Options mOptions;
    private int mReqHeight;
    private int mReqWidth;
    private int mTotalSize;
    private int mCurFrameIndex = -1;
    private int mRepeatCount = 0;
    private int mCurPlayCount = 0;
    private final Rect mDstRect = new Rect();
    private final Paint mPaint = new Paint();
    private Map<String, BitmapFactory.Options> mOptionsMap = new HashMap();
    private Map<String, WeakReference<FrameRef>> mWeakRefCache = new HashMap();
    private Runnable mDecodeTask = new DecodeTask();
    private byte[] inTempStorage = new byte[16384];
    private Handler mInvalidHandler = new Handler(Looper.getMainLooper()) { // from class: com.tencent.component.media.photogif.NewAnimationDrawable.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0) {
                NewAnimationDrawable newAnimationDrawable = NewAnimationDrawable.this;
                newAnimationDrawable.mCurBitmapRef = newAnimationDrawable.mNextBitmapRef;
                NewAnimationDrawable.this.invalidateSelf();
            }
        }
    };

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private class DecodeTask implements Runnable, Comparable<DecodeTask> {
        DecodeTask() {
        }

        @Override // java.lang.Comparable
        public int compareTo(DecodeTask decodeTask) {
            return 0;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            if (!NewAnimationDrawable.this.canAnimate()) {
                NewAnimationDrawable.this.mInvalidHandler.removeMessages(0);
                NewAnimationDrawable.this.mInvalidHandler.sendEmptyMessageDelayed(0, NewAnimationDrawable.this.mDelayTime);
                ImageManagerEnv.getLogger().d(NewAnimationDrawable.TAG, "canAnimate:false,so don't invalidate");
                return;
            }
            if (!NewAnimationDrawable.this.mIsRunning) {
                ImageManagerEnv.getLogger().d(NewAnimationDrawable.TAG, "DecodeTask:mIsRunning=false, return");
                return;
            }
            if (NewAnimationDrawable.this.mCurFrameIndex == -1 || NewAnimationDrawable.this.mCurFrameIndex >= NewAnimationDrawable.this.mOptions.photoList.size()) {
                NewAnimationDrawable.this.mCurFrameIndex = 0;
            }
            String str = NewAnimationDrawable.this.mOptions.photoList.get(NewAnimationDrawable.this.mCurFrameIndex);
            BitmapReference bitmapReference = (BitmapReference) NewAnimationDrawable.this.mLruCache.get(str);
            if (NewAnimationDrawable.this.mCurBitmapRef == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            long j3 = 0;
            if (bitmapReference != null) {
                NewAnimationDrawable.this.mNextBitmapRef = bitmapReference;
                NewAnimationDrawable.this.mInvalidHandler.removeMessages(0);
                Handler handler = NewAnimationDrawable.this.mInvalidHandler;
                if (!z16) {
                    j3 = NewAnimationDrawable.this.mDelayTime;
                }
                handler.sendEmptyMessageDelayed(0, j3);
                ImageManagerEnv.getLogger().d(NewAnimationDrawable.TAG, "get from cache: index=" + NewAnimationDrawable.this.mCurFrameIndex);
                return;
            }
            BitmapReference decodeFrame = NewAnimationDrawable.this.decodeFrame(str);
            if (decodeFrame != null) {
                synchronized (NewAnimationDrawable.this.mLruCache) {
                    NewAnimationDrawable.this.mNextBitmapRef = decodeFrame;
                    NewAnimationDrawable.this.mLruCache.put(str, decodeFrame);
                    NewAnimationDrawable.this.mWeakRefCache.put(str, new WeakReference(new FrameRef(decodeFrame)));
                    NewAnimationDrawable.this.mInvalidHandler.removeMessages(0);
                    Handler handler2 = NewAnimationDrawable.this.mInvalidHandler;
                    if (!z16) {
                        j3 = NewAnimationDrawable.this.mDelayTime;
                    }
                    handler2.sendEmptyMessageDelayed(0, j3);
                    ImageManagerEnv.getLogger().d(NewAnimationDrawable.TAG, "get from decoder:index=" + NewAnimationDrawable.this.mCurFrameIndex);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class FrameRef {
        int mBmpGenerationId;
        BitmapReference mBmpRef;

        public FrameRef(BitmapReference bitmapReference) {
            this.mBmpRef = bitmapReference;
            this.mBmpGenerationId = bitmapReference.getBitmap().getGenerationId();
        }
    }

    static {
        AtomicLong atomicLong = new AtomicLong(0L);
        sMaxCacheSizeForAll = atomicLong;
        atomicLong.set((int) (ImageManager.getInstance().capacity() * ImageManagerEnv.g().getAnimationDrawableCacheRatio()));
        ImageManagerEnv.getLogger().w(TAG, "cache size:" + sMaxCacheSizeForAll.get());
    }

    public NewAnimationDrawable(ImageLoader.Options options) {
        this.mOptions = ImageLoader.Options.copy(options);
        setReqWidth(this.mOptions.clipWidth);
        setReqHeight(this.mOptions.clipHeight);
        setDelayTime(this.mOptions.photoDelayTimeInMs);
        setFrameCounts(this.mOptions.photoList.size());
        this.mTotalSize = getByteCount();
        sMaxCacheSizeForAll.addAndGet(-r4);
        this.mLruCache = new LruCache<String, BitmapReference>(getByteCount()) { // from class: com.tencent.component.media.photogif.NewAnimationDrawable.2
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.component.media.utils.LruCache
            public int sizeOf(String str, BitmapReference bitmapReference) {
                return bitmapReference.getAllocSize();
            }
        };
    }

    private void clearCache() {
        ImageManagerEnv.getLogger().d(TAG, "try clear cache");
        this.mLruCache.evictAll();
    }

    public static int computeSampleSize(BitmapFactory.Options options, int i3, int i16) {
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        obtain.clipWidth = i3;
        obtain.clipHeight = i16;
        obtain.preferQuality = false;
        int computeSampleSize = ImageOptionSampleSize.computeSampleSize(obtain, options.outWidth, options.outHeight);
        obtain.recycle();
        return computeSampleSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(11)
    public BitmapReference decodeFrame(String str) {
        try {
            IDecoder decoder = ImageManager.getInstance().getDecoder();
            if (!TextUtils.isEmpty(str)) {
                BitmapFactory.Options bitmapOptions = getBitmapOptions(str);
                bitmapOptions.inBitmap = null;
                BitmapReference decodeImage = decoder.decodeImage(new File(str), bitmapOptions);
                if (decodeImage != null) {
                    return BitmapUtils.processExif(decodeImage, str);
                }
                return decodeImage;
            }
        } catch (Throwable th5) {
            ImageManagerEnv.getLogger().e(TAG, "catch an exception:" + Log.getStackTraceString(th5));
        }
        ImageManagerEnv.getLogger().e(TAG, "get from decoder:deocode failed,index=" + this.mCurFrameIndex);
        return null;
    }

    private BitmapFactory.Options getBitmapOptions(String str) {
        BitmapFactory.Options options = this.mOptionsMap.get(str);
        if (options == null) {
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inJustDecodeBounds = true;
            options2.inTempStorage = this.inTempStorage;
            BitmapFactory.decodeFile(str, options2);
            options2.inSampleSize = computeSampleSize(options2, this.mReqWidth, this.mReqHeight);
            this.mOptionsMap.put(str, options2);
            options2.inJustDecodeBounds = false;
            return options2;
        }
        return options;
    }

    private static int getBytesPerPixel(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888) {
            return 4;
        }
        if (config == Bitmap.Config.RGB_565 || config == Bitmap.Config.ARGB_4444) {
            return 2;
        }
        Bitmap.Config config2 = Bitmap.Config.ALPHA_8;
        return 1;
    }

    private static int getFrameSize(BitmapFactory.Options options) {
        int i3 = options.inSampleSize;
        if (i3 <= 0) {
            i3 = 1;
        }
        return (options.outWidth / i3) * (options.outHeight / i3) * getBytesPerPixel(Bitmap.Config.ARGB_8888);
    }

    public static boolean isSuitable(List<String> list, int i3, int i16) {
        if (list == null || list.size() <= 0) {
            return false;
        }
        String str = list.get(0);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = computeSampleSize(options, i3, i16);
        int frameSize = getFrameSize(options) * list.size();
        ImageManagerEnv.getLogger().w(TAG, "estimate totalSize:" + frameSize);
        ImageManagerEnv.g().reportAnimationDrawableSize(frameSize / 1024);
        if (frameSize >= sMaxCacheSizeForAll.get()) {
            return false;
        }
        return true;
    }

    private synchronized void loadNextBitmap() {
        int i3;
        if (canAnimate()) {
            int i16 = this.mCurFrameIndex;
            int i17 = this.mFrameCounts;
            if (i16 == i17 - 1) {
                this.mCurPlayCount++;
            }
            this.mCurFrameIndex = (i16 + 1) % i17;
        }
        if (this.mIsRunning && ((i3 = this.mRepeatCount) == 0 || this.mCurPlayCount < i3)) {
            ImageManagerEnv.getLogger().d(TAG, "loadNextBitmap:" + this + ",delay:" + this.mDelayTime + ",frameIndex:" + this.mCurFrameIndex);
            ImageManager.post(this.mDecodeTask, true);
        }
    }

    private void rebuildCache() {
        FrameRef frameRef;
        ImageManagerEnv.getLogger().d(TAG, "try rebuild cache from weakRef");
        for (int i3 = 0; i3 < this.mFrameCounts; i3++) {
            String str = this.mOptions.photoList.get(i3);
            WeakReference<FrameRef> weakReference = this.mWeakRefCache.get(str);
            if (weakReference != null && (frameRef = weakReference.get()) != null && frameRef.mBmpRef.getBitmap().getGenerationId() == frameRef.mBmpGenerationId) {
                this.mLruCache.put(str, frameRef.mBmpRef);
                ImageManagerEnv.getLogger().d(TAG, "get one from weakRef");
            }
        }
    }

    private void reset() {
        ImageManagerEnv.getLogger().d(TAG, " reset");
        this.mIsRunning = false;
        this.mCurPlayCount = 0;
        this.mCurFrameIndex = -1;
        this.mCurBitmapRef = null;
        this.mNextBitmapRef = null;
    }

    public boolean canAnimate() {
        return ImageManagerEnv.g().shouldPlayPhotoGif();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        BitmapReference bitmapReference = this.mCurBitmapRef;
        if (bitmapReference != null && !bitmapReference.isRecycled()) {
            canvas.drawBitmap(this.mCurBitmapRef.getBitmap(), (Rect) null, getBounds(), this.mPaint);
            ImageManagerEnv.getLogger().d(TAG, "animation NewAnimationDrawable draw  currentBitmap != null ,frameIndex:" + this.mCurFrameIndex);
        } else {
            Drawable drawable = this.mDefaultFrame;
            if (drawable != null) {
                drawable.setBounds(getBounds());
                this.mDefaultFrame.draw(canvas);
                ImageManagerEnv.getLogger().d(TAG, "animation NewAnimationDrawable draw  currentBitmap = null ,frameIndex:" + this.mCurFrameIndex);
            } else {
                canvas.drawRect(this.mDstRect, this.mPaint);
            }
        }
        if (this.mIsRunning) {
            loadNextBitmap();
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        try {
            sMaxCacheSizeForAll.addAndGet(getByteCount());
        } catch (Throwable th5) {
            ImageManagerEnv.getLogger().e(TAG, "catch an exception:" + Log.getStackTraceString(th5));
        }
    }

    public int getByteCount() {
        if (this.mTotalSize == 0) {
            this.mTotalSize = (int) (getFrameSize(getBitmapOptions(this.mOptions.photoList.get(0))) * this.mFrameCounts * 1.1d);
        }
        return this.mTotalSize;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        BitmapReference bitmapReference = this.mCurBitmapRef;
        if (bitmapReference != null) {
            return bitmapReference.getHeight();
        }
        Drawable drawable = this.mDefaultFrame;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return this.mOptions.clipHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        BitmapReference bitmapReference = this.mCurBitmapRef;
        if (bitmapReference != null) {
            return bitmapReference.getWidth();
        }
        Drawable drawable = this.mDefaultFrame;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.mOptions.clipWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Animatable
    public synchronized boolean isRunning() {
        return this.mIsRunning;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.mDstRect.set(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        this.mPaint.setAlpha(i3);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public void setDefaultFrame(Drawable drawable) {
        this.mDefaultFrame = drawable;
    }

    public void setDelayTime(long j3) {
        this.mDelayTime = j3;
    }

    public void setFrameCounts(int i3) {
        this.mFrameCounts = i3;
    }

    public void setReqHeight(int i3) {
        this.mReqHeight = i3;
    }

    public void setReqWidth(int i3) {
        this.mReqWidth = i3;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z16, boolean z17) {
        boolean visible = super.setVisible(z16, z17);
        if (z16) {
            if (z17) {
                reset();
            }
            start();
        } else if (visible) {
            stop();
        }
        return visible;
    }

    @Override // android.graphics.drawable.Animatable
    public synchronized void start() {
        if (!this.mIsRunning) {
            if (this.mLruCache.size() == 0) {
                rebuildCache();
            }
            if (this.mInvalidHandler.hasMessages(0)) {
                this.mInvalidHandler.removeMessages(0);
            }
            this.mIsRunning = true;
            loadNextBitmap();
            ImageManagerEnv.getLogger().d(TAG, "--start:" + this.mCurFrameIndex);
        }
    }

    @Override // android.graphics.drawable.Animatable
    public synchronized void stop() {
        this.mIsRunning = false;
        clearCache();
        ImageManagerEnv.getLogger().d(TAG, "--stop:" + this.mCurFrameIndex);
    }
}
