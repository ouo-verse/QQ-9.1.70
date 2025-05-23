package com.tencent.image;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLState;
import com.tencent.image.VideoDrawable;
import com.tencent.image.api.ICache;
import com.tencent.image.api.URLDrawableDepWrap;
import com.tencent.image.downloader.IllegalURLDownloader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.http.Header;
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicHeader;

/* compiled from: P */
/* loaded from: classes7.dex */
public class URLDrawable extends Drawable implements Drawable.Callback, Runnable, URLState.Callback {
    static IPatchRedirector $redirector_ = null;
    static final int ANIMATION_DURATION = 600;
    public static final int CANCLED = 3;
    private static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    public static boolean DEBUG = false;
    public static final int DECODE_FAIL_COMMON = 1;
    public static final int DECODE_FAIL_DEFAULT_IGNORE_DELETE_FILE = 3;
    public static final int DECODE_FAIL_DOWNLOADER_DELETE_FILE = 2;
    public static final int FAILED = 2;
    public static final int FILE_DOWNLOADED = 4;
    private static final int KEEP_ALIVE = 1;
    public static final int LOADING = 0;
    private static final int MAXIMUM_POOL_SIZE;
    private static final int PENDING_ACTION_CAPACITY = 100;
    public static final int SUCCESSED = 1;
    public static final String TAG = "URLDrawable_";
    public static final String THREAD_SUB_TAG = "Thread";
    public static URLDrawableDepWrap depImp;
    static Context mApplicationContext;
    static URLDrawableParams sDefaultDrawableParms;
    static boolean sPause;
    static Object sPauseLock;
    private static final LruCache<URLDrawable, LruCache> sPendingActions;
    private static final BlockingQueue<Runnable> sPoolWorkQueue;
    private static final ThreadFactory sThreadFactory;
    public boolean individualPause;
    private int individualPauseCount;
    private int mAlpha;
    private boolean mAlreadyChecked;
    private boolean mAutoDownload;
    private Exception mCallStack;
    private ColorFilter mColorFilter;
    private CookieStore mCookies;
    private Drawable mCurrDrawable;
    private DownloadListener mDownloadListener;
    protected URLState mDrawableContainerState;
    public String mDynamicDrawableType;
    private Matrix mExifMatrix;
    private Object mExtraInfo;
    private long mFadeInAnimationStartTime;
    private boolean mFadeInAnimationStarted;
    boolean mFadeInImage;
    private Drawable mFailedDrawable;
    private float mGifRoundCorner;
    private Header[] mHeaders;
    private boolean mIsShowWatermark;
    private URLDrawableListener mListener;
    private int mProgress;
    private Drawable mProgressDrawable;
    private int mRefreshDelay;
    private Object mTag;
    private int mTargetDensity;
    public boolean mUseApngImage;
    public boolean mUseDynamicDrawable;
    private boolean mUseExifOrientation;
    private boolean mUseGifAnimation;
    private boolean mUseSharpPAnimImage;

    @Deprecated
    private boolean mUseSharpPImage;
    private Bitmap mWatermarkDrawable;
    private int mWatermarkMarginButtom;
    private int mWatermarkMarginRight;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface DownloadListener {
        void onFileDownloadFailed(int i3);

        void onFileDownloadStarted();

        void onFileDownloadSucceed(long j3);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface URLDrawableListener {
        void onLoadCanceled(URLDrawable uRLDrawable);

        void onLoadFialed(URLDrawable uRLDrawable, Throwable th5);

        void onLoadProgressed(URLDrawable uRLDrawable, int i3);

        void onLoadSuccessed(URLDrawable uRLDrawable);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public interface URLDrawableListener2 extends URLDrawableListener {
        void onFileDownloaded(URLDrawable uRLDrawable);
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class URLDrawableOptions {
        static IPatchRedirector $redirector_ = null;
        private static final int MAX_POOL_SIZE = 30;
        private static final String TAG = "URLDrawableOptions";
        private static URLDrawableOptions sPool;
        private static int sPoolSize;
        private static final Object sPoolSync;
        public boolean isFlashPic;
        public int mDecodeFileStrategy;
        public String mDynamicDrawableType;
        public Object mExtraInfo;
        public Drawable mFailedDrawable;
        public int mGifRefreshDelay;
        public float mGifRoundCorner;
        public String mHostForHttpsVerify;
        public Object mHttpDownloaderParams;
        public int mImgType;
        public boolean mKeyAddWHSuffix;
        public Drawable mLoadingDrawable;
        public String mMemoryCacheKeySuffix;
        public boolean mNeedCheckNetType;
        private URLDrawableOptions mNext;
        public boolean mPlayGifImage;
        public byte mPriority;
        private boolean mRecycled;
        public int mRequestHeight;
        public int mRequestWidth;
        public int mRetryCount;
        public boolean mUseApngImage;
        public boolean mUseAutoScaleParams;
        public boolean mUseDynamicDrawable;
        public boolean mUseExifOrientation;
        public boolean mUseMemoryCache;
        public boolean mUseSharpPAnimImage;

        @Deprecated
        public boolean mUseSharpPImage;
        public boolean mUseThreadPool;
        public boolean mUseUnFinishCache;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11598);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                sPoolSync = new Object();
                sPoolSize = 0;
            }
        }

        URLDrawableOptions() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.mRequestWidth = 0;
            this.mRequestHeight = 0;
            this.mKeyAddWHSuffix = true;
            this.mLoadingDrawable = null;
            this.mFailedDrawable = null;
            this.mPlayGifImage = false;
            this.mGifRefreshDelay = -1;
            this.mUseDynamicDrawable = false;
            this.mDynamicDrawableType = "";
            this.mUseApngImage = false;
            this.mUseSharpPImage = false;
            this.mUseSharpPAnimImage = false;
            this.mNeedCheckNetType = false;
            this.mGifRoundCorner = 0.0f;
            this.mUseAutoScaleParams = true;
            this.mUseExifOrientation = true;
            this.mUseMemoryCache = true;
            this.mUseUnFinishCache = true;
            this.mUseThreadPool = true;
            this.mDecodeFileStrategy = 1;
            this.isFlashPic = false;
            this.mRetryCount = 0;
            this.mMemoryCacheKeySuffix = null;
            this.mHostForHttpsVerify = null;
            this.mPriority = getPriority();
            this.mRecycled = false;
        }

        private void clearForRecycle() {
            this.mRequestWidth = 0;
            this.mRequestHeight = 0;
            this.mLoadingDrawable = null;
            this.mFailedDrawable = null;
            this.mPlayGifImage = false;
            this.mGifRefreshDelay = -1;
            this.mUseApngImage = false;
            this.mUseDynamicDrawable = false;
            this.mDynamicDrawableType = "";
            this.mUseSharpPImage = false;
            this.mUseSharpPAnimImage = false;
            this.mGifRoundCorner = 0.0f;
            this.mUseAutoScaleParams = true;
            this.mUseExifOrientation = true;
            this.mUseMemoryCache = true;
            this.mUseUnFinishCache = true;
            this.mUseThreadPool = true;
            this.mRecycled = true;
            this.mExtraInfo = null;
            this.mMemoryCacheKeySuffix = null;
            this.mPriority = getPriority();
            this.mHttpDownloaderParams = null;
            this.mHostForHttpsVerify = null;
            this.mNeedCheckNetType = false;
            this.mKeyAddWHSuffix = true;
            this.mDecodeFileStrategy = 1;
        }

        private byte getPriority() {
            ICache iCache;
            URLDrawableDepWrap uRLDrawableDepWrap = URLDrawable.depImp;
            if (uRLDrawableDepWrap != null && (iCache = uRLDrawableDepWrap.mCache) != null) {
                return iCache.getNormalPriority();
            }
            return (byte) 1;
        }

        public static URLDrawableOptions obtain() {
            synchronized (sPoolSync) {
                URLDrawableOptions uRLDrawableOptions = sPool;
                if (uRLDrawableOptions != null) {
                    uRLDrawableOptions.mUseApngImage = false;
                    uRLDrawableOptions.mUseSharpPAnimImage = false;
                    uRLDrawableOptions.mUseDynamicDrawable = false;
                    uRLDrawableOptions.mGifRefreshDelay = -1;
                    uRLDrawableOptions.mDynamicDrawableType = "";
                    uRLDrawableOptions.mExtraInfo = null;
                    uRLDrawableOptions.mHttpDownloaderParams = null;
                    sPool = uRLDrawableOptions.mNext;
                    uRLDrawableOptions.mRecycled = false;
                    uRLDrawableOptions.mNext = null;
                    uRLDrawableOptions.isFlashPic = false;
                    sPoolSize--;
                    return uRLDrawableOptions;
                }
                return new URLDrawableOptions();
            }
        }

        public void Recycle() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (this.mRecycled) {
                return;
            }
            clearForRecycle();
            synchronized (sPoolSync) {
                int i3 = sPoolSize;
                if (i3 < 30) {
                    this.mNext = sPool;
                    sPool = this;
                    sPoolSize = i3 + 1;
                } else if (URLDrawable.depImp.mLog.isColorLevel()) {
                    URLDrawable.depImp.mLog.i(TAG, 2, "URLDrawableOptions pool size is full");
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11613);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 72)) {
            redirector.redirect((short) 72);
            return;
        }
        sPendingActions = new LruCache<>(100);
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        CORE_POOL_SIZE = availableProcessors + 1;
        MAXIMUM_POOL_SIZE = (availableProcessors * 2) + 1;
        sPoolWorkQueue = new LinkedBlockingQueue(128);
        sThreadFactory = new ThreadFactory() { // from class: com.tencent.image.URLDrawable.1
            static IPatchRedirector $redirector_;
            private final AtomicInteger mCount;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                } else {
                    this.mCount = new AtomicInteger(1);
                }
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return (Thread) iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
                }
                return new BaseThread(runnable, "URLDrawable #" + this.mCount.getAndIncrement());
            }
        };
        DEBUG = false;
        sPause = false;
        sPauseLock = new Object();
    }

    URLDrawable(URL url, URLDrawableOptions uRLDrawableOptions) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) url, (Object) uRLDrawableOptions);
            return;
        }
        this.individualPause = false;
        this.mUseDynamicDrawable = false;
        this.mDynamicDrawableType = "";
        this.mTargetDensity = 160;
        this.mRefreshDelay = -1;
        this.mUseExifOrientation = true;
        this.mWatermarkDrawable = null;
        this.mWatermarkMarginRight = 0;
        this.mWatermarkMarginButtom = 0;
        this.mIsShowWatermark = false;
        this.mProgress = 0;
        this.mFadeInAnimationStarted = false;
        this.mFadeInAnimationStartTime = -1L;
        this.mAutoDownload = true;
        this.mAlpha = 255;
        this.individualPauseCount = 0;
        this.mAlreadyChecked = false;
        this.mDrawableContainerState = new URLState(url, uRLDrawableOptions);
        this.mFailedDrawable = uRLDrawableOptions.mFailedDrawable;
        Drawable drawable = uRLDrawableOptions.mLoadingDrawable;
        this.mCurrDrawable = drawable;
        if (drawable == null && sDefaultDrawableParms.getDefaultLoadingDrawable() != null) {
            this.mCurrDrawable = sDefaultDrawableParms.getDefaultLoadingDrawable();
        }
        this.mDrawableContainerState.addCallBack(this);
    }

    private static URLDrawable autoScale(Resources resources, URLDrawable uRLDrawable) {
        URLDrawableParams uRLDrawableParams = sDefaultDrawableParms;
        if (uRLDrawableParams.mAutoScaleByDensity) {
            if (resources != null) {
                uRLDrawable.setTargetDensity(resources.getDisplayMetrics().densityDpi);
            } else {
                uRLDrawable.setTargetDensity(uRLDrawableParams.mDeviceDensity);
            }
        }
        return uRLDrawable;
    }

    private void checkBitmapSize() {
        String str;
        if (!depImp.mVersion.isPublicVersion() && DEBUG && !this.mAlreadyChecked && RegionDrawable.class.isInstance(this.mCurrDrawable)) {
            this.mAlreadyChecked = true;
            Drawable.Callback callback = getCallback();
            if (ImageView.class.isInstance(callback)) {
                ImageView imageView = (ImageView) callback;
                int measuredWidth = imageView.getMeasuredWidth();
                int measuredHeight = imageView.getMeasuredHeight();
                RegionDrawable regionDrawable = (RegionDrawable) this.mCurrDrawable;
                int width = regionDrawable.getBitmap().getWidth();
                int height = regionDrawable.getBitmap().getHeight();
                if (isBitmapOversize(width, height, measuredWidth, measuredHeight)) {
                    String str2 = "(" + measuredWidth + "," + measuredHeight + ")";
                    String str3 = "(" + width + "," + height + ")";
                    if (imageView.getContext() != null && (imageView.getContext() instanceof Activity)) {
                        str = imageView.getContext().getClass().getName();
                    } else {
                        str = "";
                    }
                    DownloadParams downloadParams = this.mDrawableContainerState.mParams;
                    int i3 = downloadParams.reqHeight;
                    depImp.mReport.debug(1, new Object[]{str2, str3, getURL().toString(), str, this.mCallStack, "(" + downloadParams.reqWidth + "," + i3 + ")"});
                }
            }
        }
    }

    private static void checkParams() {
        if (sDefaultDrawableParms != null) {
        } else {
            throw new IllegalStateException("Default params is not seted, please call setURLDrawableParams first");
        }
    }

    public static void clearMemoryCache() {
        depImp.mCache.evictAll();
    }

    private static URLDrawable doIllegalURL(String str) {
        depImp.mLog.d(TAG, 1, "doIllegalURL :" + str + " isPublicVersion:" + depImp.mVersion.isPublicVersion());
        if (depImp.mVersion.isPublicVersion()) {
            try {
                return getDrawable(new URL(IllegalURLDownloader.ILLEGAL_URL, (String) null, ""));
            } catch (MalformedURLException e16) {
                e16.printStackTrace();
                return null;
            }
        }
        throw new IllegalArgumentException("illegal url format: " + str);
    }

    @Deprecated
    public static URLDrawable getDrawable(URL url) {
        return getDrawable(url, (Drawable) null, (Drawable) null);
    }

    public static URLDrawable getFileDrawable(String str, URLDrawableOptions uRLDrawableOptions) {
        try {
            URL url = new URI("file", null, str, null).toURL();
            if (url != null) {
                return getDrawable(url, uRLDrawableOptions);
            }
        } catch (MalformedURLException e16) {
            e16.printStackTrace();
        } catch (URISyntaxException e17) {
            e17.printStackTrace();
        }
        return null;
    }

    public static int getPoolSize() {
        return URLDrawableOptions.sPoolSize;
    }

    private void httpdownloadError() {
        depImp.mReport.debug(2, new Object[]{getURL().toString(), this.mCallStack});
    }

    public static void init(URLDrawableDepWrap uRLDrawableDepWrap, URLDrawableParams uRLDrawableParams) {
        uRLDrawableDepWrap.mTool.initURLStreamHandlerFactory();
        if (sDefaultDrawableParms == null) {
            depImp = uRLDrawableDepWrap;
            if (uRLDrawableParams.mSubHandler == null) {
                uRLDrawableParams.mSubHandler = new Handler(uRLDrawableDepWrap.mThreadManager.getSubThread().getLooper());
            }
            sDefaultDrawableParms = uRLDrawableParams;
            mApplicationContext = uRLDrawableDepWrap.mTool.getContext();
            return;
        }
        throw new IllegalArgumentException("please don't call setURLDrawableParams twice");
    }

    private boolean isBitmapOversize(int i3, int i16, int i17, int i18) {
        if (i17 != 0 && i18 != 0 && i17 != -1 && i18 != -1 && i16 > i18 && i3 > i17) {
            int round = Math.round(i16 / i18);
            int round2 = Math.round(i3 / i17);
            if (round <= round2) {
                round = round2;
            }
            if (round >= 2) {
                return true;
            }
        }
        return false;
    }

    public static void pause() {
        if (depImp.mLog.isColorLevel()) {
            depImp.mLog.d("URLDrawable_pause", 4, "pause load image ");
        }
        synchronized (sPauseLock) {
            sPause = true;
        }
    }

    public static void removeMemoryCacheByUrl(String str, URLDrawableOptions uRLDrawableOptions) {
        depImp.mCache.remove(URLState.getMemoryCacheKey(str, uRLDrawableOptions));
    }

    public static void resume() {
        if (depImp.mLog.isColorLevel()) {
            depImp.mLog.d("URLDrawable_resume", 4, "resume load image ");
        }
        synchronized (sPauseLock) {
            sPause = false;
            sPauseLock.notifyAll();
            LruCache<URLDrawable, LruCache> lruCache = sPendingActions;
            Map<URLDrawable, LruCache> snapshot = lruCache.snapshot();
            if (depImp.mLog.isColorLevel()) {
                depImp.mLog.d("URLDrawable_resume", 4, "resume sPendingActions size= " + lruCache.size());
            }
            for (URLDrawable uRLDrawable : snapshot.keySet()) {
                uRLDrawable.scheduleSelf(uRLDrawable, SystemClock.uptimeMillis() + 1);
                sPendingActions.remove(uRLDrawable);
            }
        }
    }

    public void addCookies(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            iPatchRedirector.redirect((short) 52, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (this.mCookies == null) {
            this.mCookies = new BasicCookieStore();
        }
        this.mCookies.addCookie(new BasicClientCookie(str, str2));
    }

    public void addHeader(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, (Object) str, (Object) str2);
            return;
        }
        Header[] headerArr = this.mHeaders;
        if (headerArr != null && headerArr.length != 0) {
            Header[] headerArr2 = new Header[headerArr.length + 1];
            System.arraycopy(headerArr, 0, headerArr2, 0, headerArr.length);
            headerArr2[this.mHeaders.length] = new BasicHeader(str, str2);
            this.mHeaders = headerArr2;
            return;
        }
        this.mHeaders = new Header[]{new BasicHeader(str, str2)};
    }

    public void cancelDownload(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, z16);
            return;
        }
        if (depImp.mLog.isColorLevel()) {
            depImp.mLog.i(TAG, 2, "[cancelDownload]" + getURL());
        }
        URLState.PreDownloadRunnable preDownloadRunnable = this.mDrawableContainerState.mTask;
        if (preDownloadRunnable != null) {
            preDownloadRunnable.mDownloadRunnable.cancel();
            return;
        }
        if (depImp.mLog.isColorLevel()) {
            depImp.mLog.i(TAG, 2, "[cancelDownload]task is null, cancel failed..." + getURL());
        }
    }

    public void downloadImediatly() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 35)) {
            this.mDrawableContainerState.downloadImediatly(this.mHeaders, this.mCookies, this.mTag, true, this.mUseGifAnimation, this.mUseApngImage, this.mUseSharpPImage, this.mGifRoundCorner, this.mUseExifOrientation, this.mUseSharpPAnimImage, this.mExtraInfo, this.mUseDynamicDrawable, this.mDynamicDrawableType);
        } else {
            iPatchRedirector.redirect((short) 35, (Object) this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable;
        Bitmap bitmap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) canvas);
            return;
        }
        if (this.mCurrDrawable != null) {
            checkBitmapSize();
            int save = canvas.save();
            if (this.mFadeInImage && this.mFadeInAnimationStarted) {
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
                if (this.mFadeInAnimationStartTime == -1) {
                    this.mFadeInAnimationStartTime = currentAnimationTimeMillis;
                }
                float f16 = ((float) (currentAnimationTimeMillis - this.mFadeInAnimationStartTime)) / 600.0f;
                if (f16 >= 0.0f && f16 <= 1.0f) {
                    float f17 = 1.0f - f16;
                    int min = Math.min((int) ((1.0f - (f17 * f17)) * 255.0f), 255);
                    Rect bounds = getBounds();
                    canvas.saveLayerAlpha(bounds.left, bounds.top, bounds.width(), bounds.height(), min);
                    invalidateSelf();
                } else {
                    this.mFadeInAnimationStarted = false;
                }
            }
            Matrix matrix = this.mExifMatrix;
            if (matrix != null) {
                canvas.concat(matrix);
            }
            this.mCurrDrawable.draw(canvas);
            if (this.mIsShowWatermark && (bitmap = this.mWatermarkDrawable) != null) {
                int width = bitmap.getWidth();
                int height = this.mWatermarkDrawable.getHeight();
                int intrinsicWidth = this.mCurrDrawable.getIntrinsicWidth();
                int intrinsicHeight = this.mCurrDrawable.getIntrinsicHeight();
                int i3 = (intrinsicWidth - width) - this.mWatermarkMarginRight;
                int i16 = (intrinsicHeight - height) - this.mWatermarkMarginButtom;
                if (intrinsicWidth > 0 && intrinsicHeight > 0 && i3 >= 0 && i16 >= 0) {
                    canvas.drawBitmap(this.mWatermarkDrawable, i3, i16, (Paint) null);
                }
            }
            if (getStatus() == 0 && (drawable = this.mProgressDrawable) != null && this.mDrawableContainerState.mIsLoadingStarted == 1) {
                drawable.draw(canvas);
            }
            canvas.restoreToCount(save);
        }
        if (this.mAutoDownload) {
            boolean z16 = this.individualPause;
            if (z16) {
                this.individualPauseCount++;
            }
            if ((sPause && !this.mDrawableContainerState.mIgnorePause) || (z16 && (!z16 || this.individualPauseCount != 1))) {
                LruCache lruCache = sPendingActions;
                lruCache.put(this, lruCache);
            } else {
                startDownload();
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Drawable.ConstantState) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.mDrawableContainerState;
    }

    public Drawable getCurrDrawable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            return (Drawable) iPatchRedirector.redirect((short) 65, (Object) this);
        }
        return this.mCurrDrawable;
    }

    public int getExifOrientation() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Integer) iPatchRedirector.redirect((short) 21, (Object) this)).intValue();
        }
        URLState uRLState = this.mDrawableContainerState;
        if (uRLState.mStatus == 1 && this.mCurrDrawable != null) {
            return uRLState.mOrientation;
        }
        return 0;
    }

    public Object getExtraInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 71)) {
            return iPatchRedirector.redirect((short) 71, (Object) this);
        }
        return this.mExtraInfo;
    }

    public File getFileInLocal() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (File) iPatchRedirector.redirect((short) 28, (Object) this);
        }
        URLState uRLState = this.mDrawableContainerState;
        if (uRLState == null || TextUtils.isEmpty(uRLState.mCacheFile)) {
            return null;
        }
        return new File(this.mDrawableContainerState.mCacheFile);
    }

    public Header getHeader(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return (Header) iPatchRedirector.redirect((short) 49, (Object) this, (Object) str);
        }
        Header[] headerArr = this.mHeaders;
        if (headerArr != null) {
            for (Header header : headerArr) {
                if (str != null && str.equals(header.getName())) {
                    return header;
                }
            }
            return null;
        }
        return null;
    }

    public Header[] getHeaders() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            return (Header[]) iPatchRedirector.redirect((short) 47, (Object) this);
        }
        return this.mHeaders;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        if (this.mUseExifOrientation) {
            URLState uRLState = this.mDrawableContainerState;
            if (uRLState.mStatus == 1 && (drawable = this.mCurrDrawable) != null) {
                int i3 = uRLState.mOrientation;
                if (i3 != 5 && i3 != 6 && i3 != 7 && i3 != 8) {
                    int i16 = uRLState.mHeight;
                    if (i16 <= 0) {
                        return drawable.getIntrinsicHeight();
                    }
                    return i16;
                }
                int i17 = uRLState.mWidth;
                if (i17 <= 0) {
                    return drawable.getIntrinsicWidth();
                }
                return i17;
            }
        }
        int i18 = this.mDrawableContainerState.mHeight;
        if (i18 <= 0) {
            Drawable drawable2 = this.mCurrDrawable;
            if (drawable2 != null) {
                return drawable2.getIntrinsicHeight();
            }
            return -1;
        }
        return i18;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        if (this.mUseExifOrientation) {
            URLState uRLState = this.mDrawableContainerState;
            if (uRLState.mStatus == 1 && (drawable = this.mCurrDrawable) != null) {
                int i3 = uRLState.mOrientation;
                if (i3 != 5 && i3 != 6 && i3 != 7 && i3 != 8) {
                    int i16 = uRLState.mWidth;
                    if (i16 <= 0) {
                        return drawable.getIntrinsicWidth();
                    }
                    return i16;
                }
                int i17 = uRLState.mHeight;
                if (i17 <= 0) {
                    return drawable.getIntrinsicHeight();
                }
                return i17;
            }
        }
        int i18 = this.mDrawableContainerState.mWidth;
        if (i18 <= 0) {
            Drawable drawable2 = this.mCurrDrawable;
            if (drawable2 != null) {
                return drawable2.getIntrinsicWidth();
            }
            return -1;
        }
        return i18;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return -2;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) rect)).booleanValue();
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            return drawable.getPadding(rect);
        }
        return super.getPadding(rect);
    }

    public int getProgress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Integer) iPatchRedirector.redirect((short) 34, (Object) this)).intValue();
        }
        return this.mProgress;
    }

    public CustomError getStateError() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 58)) {
            return (CustomError) iPatchRedirector.redirect((short) 58, (Object) this);
        }
        URLState uRLState = this.mDrawableContainerState;
        if (uRLState != null) {
            return uRLState.mCustomError;
        }
        return null;
    }

    public Object getStateTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return iPatchRedirector.redirect((short) 57, (Object) this);
        }
        URLState uRLState = this.mDrawableContainerState;
        if (uRLState != null) {
            return uRLState.mParams.tag;
        }
        return null;
    }

    public int getStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Integer) iPatchRedirector.redirect((short) 33, (Object) this)).intValue();
        }
        return this.mDrawableContainerState.mStatus;
    }

    public Object getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return iPatchRedirector.redirect((short) 55, (Object) this);
        }
        return this.mTag;
    }

    public URL getURL() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return (URL) iPatchRedirector.redirect((short) 32, (Object) this);
        }
        return this.mDrawableContainerState.mUrl;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) drawable);
        } else {
            invalidateSelf();
        }
    }

    public boolean isAnim() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 66)) {
            return ((Boolean) iPatchRedirector.redirect((short) 66, (Object) this)).booleanValue();
        }
        Drawable drawable = this.mCurrDrawable;
        if (!(drawable instanceof GifDrawable) && !(drawable instanceof ApngDrawable)) {
            return false;
        }
        return true;
    }

    public boolean isDownloadStarted() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        if (this.mDrawableContainerState.mIsLoadingStarted == 1) {
            return true;
        }
        return false;
    }

    public boolean isFakeSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 67)) {
            return ((Boolean) iPatchRedirector.redirect((short) 67, (Object) this)).booleanValue();
        }
        URLState uRLState = this.mDrawableContainerState;
        if (uRLState.mWidth != 0 && uRLState.mHeight != 0) {
            return true;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Drawable) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onBoundsChange(Rect rect) {
        Drawable drawable;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) rect);
            return;
        }
        if (this.mUseExifOrientation) {
            URLState uRLState = this.mDrawableContainerState;
            if (uRLState.mStatus == 1 && this.mCurrDrawable != null && (i3 = uRLState.mOrientation) != 0 && i3 != 1) {
                int width = rect.width();
                float f16 = width / 2.0f;
                int height = rect.height();
                float f17 = height / 2.0f;
                Rect rect2 = new Rect();
                Matrix matrix = new Matrix();
                int i16 = this.mDrawableContainerState.mOrientation;
                int i17 = 90;
                switch (i16) {
                    case 2:
                        rect2.set(0, 0, width, height);
                        matrix.setTranslate(-f16, -f17);
                        matrix.postScale(-1.0f, 1.0f);
                        matrix.postTranslate(f16 + rect.left, f17 + rect.top);
                        break;
                    case 3:
                        rect2.set(0, 0, width, height);
                        matrix.setTranslate(-f16, -f17);
                        matrix.postRotate(180.0f);
                        matrix.postTranslate(f16 + rect.left, f17 + rect.top);
                        break;
                    case 4:
                        rect2.set(0, 0, width, height);
                        matrix.setTranslate(-f16, -f17);
                        matrix.postScale(1.0f, -1.0f);
                        matrix.postTranslate(f16 + rect.left, f17 + rect.top);
                        break;
                    case 5:
                    case 7:
                        if (i16 != 5) {
                            i17 = 270;
                        }
                        rect2.set(0, 0, width, height);
                        matrix.setTranslate(-f16, -f17);
                        matrix.postScale(1.0f, -1.0f);
                        matrix.postRotate(i17);
                        matrix.postTranslate(f16 + rect.left, f17 + rect.top);
                        break;
                    case 6:
                    case 8:
                        if (i16 != 6) {
                            i17 = 270;
                        }
                        rect2.set(0, 0, height, width);
                        matrix.setTranslate(-f17, -f16);
                        matrix.postRotate(i17);
                        matrix.postTranslate(f16 + rect.left, f17 + rect.top);
                        break;
                    default:
                        matrix = null;
                        rect2 = rect;
                        break;
                }
                this.mExifMatrix = matrix;
                this.mCurrDrawable.setBounds(rect2);
                drawable = this.mProgressDrawable;
                if (drawable == null) {
                    drawable.setBounds(rect);
                    return;
                }
                return;
            }
        }
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
        drawable = this.mProgressDrawable;
        if (drawable == null) {
        }
    }

    @Override // com.tencent.image.URLState.Callback
    public void onFileDownloadFailed(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, i3);
            return;
        }
        DownloadListener downloadListener = this.mDownloadListener;
        if (downloadListener != null) {
            downloadListener.onFileDownloadFailed(i3);
        }
    }

    @Override // com.tencent.image.URLState.Callback
    public void onFileDownloadStarted() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this);
            return;
        }
        DownloadListener downloadListener = this.mDownloadListener;
        if (downloadListener != null) {
            downloadListener.onFileDownloadStarted();
        }
    }

    @Override // com.tencent.image.URLState.Callback
    public void onFileDownloadSucceed(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, j3);
            return;
        }
        DownloadListener downloadListener = this.mDownloadListener;
        if (downloadListener != null) {
            downloadListener.onFileDownloadSucceed(j3);
        }
    }

    @Override // com.tencent.image.URLState.Callback
    public void onFileDownloaded(URLState uRLState) {
        URLDrawableListener uRLDrawableListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) uRLState);
        } else if (getStatus() == 4 && (uRLDrawableListener = this.mListener) != null && (uRLDrawableListener instanceof URLDrawableListener2)) {
            ((URLDrawableListener2) uRLDrawableListener).onFileDownloaded(this);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, i3)).booleanValue();
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            return drawable.setLevel(i3);
        }
        return false;
    }

    @Override // com.tencent.image.URLState.Callback
    public void onLoadCanceled(URLState uRLState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, (Object) uRLState);
            return;
        }
        URLDrawableListener uRLDrawableListener = this.mListener;
        if (uRLDrawableListener != null) {
            uRLDrawableListener.onLoadCanceled(this);
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return;
        }
        invalidateSelf();
    }

    @Override // com.tencent.image.URLState.Callback
    public void onLoadFailed(URLState uRLState, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) uRLState, (Object) th5);
            return;
        }
        Drawable drawable = this.mCurrDrawable;
        CustomError customError = uRLState.mCustomError;
        if (customError != null) {
            this.mFailedDrawable = customError.getFailedDrawable();
        } else if (this.mFailedDrawable == null) {
            this.mFailedDrawable = sDefaultDrawableParms.getDefualtFailedDrawable();
        }
        Drawable drawable2 = this.mFailedDrawable;
        this.mCurrDrawable = drawable2;
        if (drawable2 != null) {
            drawable2.setAlpha(this.mAlpha);
            this.mCurrDrawable.setVisible(isVisible(), true);
            this.mCurrDrawable.setDither(this.mDrawableContainerState.mDither);
            this.mCurrDrawable.setColorFilter(this.mColorFilter);
            this.mCurrDrawable.setState(getState());
            this.mCurrDrawable.setLevel(getLevel());
            this.mCurrDrawable.setCallback(this);
            this.mCurrDrawable.setBounds(getBounds());
        }
        if (drawable != null) {
            drawable.setCallback(null);
        }
        URLDrawableListener uRLDrawableListener = this.mListener;
        if (uRLDrawableListener != null) {
            uRLDrawableListener.onLoadFialed(this, th5);
        }
        if (this.mFadeInImage) {
            this.mFadeInAnimationStarted = true;
        }
        this.mDrawableContainerState.mCacheFile = null;
        invalidateSelf();
        if (th5.toString().contains("response_code=404")) {
            httpdownloadError();
        }
    }

    @Override // com.tencent.image.URLState.Callback
    public void onLoadStarted(URLState uRLState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) uRLState);
        } else {
            invalidateSelf();
        }
    }

    @Override // com.tencent.image.URLState.Callback
    public void onLoadSuccessed(URLState uRLState) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) uRLState);
            return;
        }
        Drawable drawable = this.mCurrDrawable;
        Drawable newDrawable = uRLState.mSuccessed.newDrawable();
        newDrawable.setAlpha(this.mAlpha);
        newDrawable.setVisible(isVisible(), true);
        newDrawable.setColorFilter(this.mColorFilter);
        newDrawable.setState(getState());
        newDrawable.setLevel(getLevel());
        newDrawable.setCallback(this);
        newDrawable.setBounds(getBounds());
        this.mCurrDrawable = newDrawable;
        if (newDrawable instanceof RegionDrawable) {
            ((RegionDrawable) newDrawable).setTargetDensity(this.mTargetDensity);
        } else if (newDrawable instanceof SliceBitmapDrawable) {
            ((SliceBitmapDrawable) newDrawable).setTargetDensity(this.mTargetDensity);
        } else if (newDrawable instanceof GifDrawable) {
            GifDrawable gifDrawable = (GifDrawable) newDrawable;
            gifDrawable.setTargetDensity(this.mTargetDensity);
            gifDrawable.setGifRefreshDelay(this.mRefreshDelay);
            gifDrawable.mUseAnimation = this.mUseGifAnimation;
        } else if (newDrawable instanceof ApngDrawable) {
            ApngDrawable apngDrawable = (ApngDrawable) newDrawable;
            apngDrawable.setTargetDensity(this.mTargetDensity);
            apngDrawable.setUseRect(this.mExtraInfo);
            apngDrawable.mUseAnimation = this.mUseApngImage;
        } else if (newDrawable instanceof SharpDrawable) {
            SharpDrawable sharpDrawable = (SharpDrawable) newDrawable;
            sharpDrawable.setTargetDensity(this.mTargetDensity);
            sharpDrawable.setUseRect(this.mExtraInfo);
            sharpDrawable.mUseAnimation = this.mUseSharpPAnimImage;
        } else if (newDrawable instanceof RoundRectDrawable) {
            ((RoundRectDrawable) newDrawable).setTargetDensity(this.mTargetDensity);
        } else if (newDrawable instanceof VideoDrawable) {
            VideoDrawable videoDrawable = (VideoDrawable) newDrawable;
            videoDrawable.setTargetDensity(this.mTargetDensity);
            Object obj = this.mExtraInfo;
            if (obj != null && (obj instanceof VideoDrawable.VideoDrawableParams)) {
                videoDrawable.mPlayVideoFrame = ((VideoDrawable.VideoDrawableParams) obj).mPlayVideoFrame;
            }
        }
        this.mCurrDrawable = newDrawable;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        URLDrawableListener uRLDrawableListener = this.mListener;
        if (uRLDrawableListener != null) {
            uRLDrawableListener.onLoadSuccessed(this);
        }
        if (this.mFadeInImage) {
            this.mFadeInAnimationStarted = true;
        }
        Drawable drawable2 = this.mProgressDrawable;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            this.mProgressDrawable = null;
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) iArr)).booleanValue();
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            drawable.setState(iArr);
            return true;
        }
        return true;
    }

    @Override // com.tencent.image.URLState.Callback
    public void onUpdateProgress(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, i3);
            return;
        }
        Drawable drawable = this.mProgressDrawable;
        if (drawable != null) {
            drawable.setLevel(i3);
            invalidateSelf();
        }
        URLDrawableListener uRLDrawableListener = this.mListener;
        if (uRLDrawableListener != null) {
            uRLDrawableListener.onLoadProgressed(this, i3);
        }
    }

    public void restartDownload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 24)) {
            restartDownload(true);
        } else {
            iPatchRedirector.redirect((short) 24, (Object) this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this);
            return;
        }
        if (depImp.mLog.isColorLevel()) {
            depImp.mLog.d("URLDrawable_resume", 4, "startDownload from run : " + this.mDrawableContainerState.mUrlStr);
        }
        startDownload();
    }

    public String saveTo(String str) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return (String) iPatchRedirector.redirect((short) 63, (Object) this, (Object) str);
        }
        return this.mDrawableContainerState.saveTo(str);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, drawable, runnable, Long.valueOf(j3));
        } else {
            scheduleSelf(runnable, j3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        if (this.mAlpha != i3) {
            this.mAlpha = i3;
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                drawable.setAlpha(i3);
            }
        }
    }

    public void setAutoDownload(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, z16);
            return;
        }
        this.mAutoDownload = z16;
        if (z16) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) colorFilter);
            return;
        }
        if (this.mColorFilter != colorFilter) {
            this.mColorFilter = colorFilter;
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    public void setCookies(CookieStore cookieStore) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            iPatchRedirector.redirect((short) 51, (Object) this, (Object) cookieStore);
        } else {
            this.mCookies = cookieStore;
        }
    }

    public void setDecodeHandler(DownloadParams.DecodeHandler decodeHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            iPatchRedirector.redirect((short) 59, (Object) this, (Object) decodeHandler);
        } else {
            this.mDrawableContainerState.mParams.mDecodeHandler = decodeHandler;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        URLState uRLState = this.mDrawableContainerState;
        if (uRLState.mDither != z16) {
            uRLState.mDither = z16;
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                drawable.setDither(z16);
            }
        }
    }

    public void setDownloadListener(DownloadListener downloadListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 54)) {
            iPatchRedirector.redirect((short) 54, (Object) this, (Object) downloadListener);
        } else {
            this.mDownloadListener = downloadListener;
        }
    }

    public void setFadeInImage(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, z16);
        } else {
            this.mFadeInImage = z16;
        }
    }

    public void setGIFPlayOnceListener(GifDrawable.OnGIFPlayOnceListener onGIFPlayOnceListener) {
        GifDrawable.GifState gifState;
        AbstractGifImage abstractGifImage;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 70)) {
            iPatchRedirector.redirect((short) 70, (Object) this, (Object) onGIFPlayOnceListener);
            return;
        }
        Drawable drawable = this.mCurrDrawable;
        if ((drawable instanceof GifDrawable) && (gifState = (GifDrawable.GifState) ((GifDrawable) drawable).getConstantState()) != null && (abstractGifImage = gifState.mGif) != null) {
            abstractGifImage.setGIFPlayOnceListener(onGIFPlayOnceListener);
        }
    }

    public void setHeaders(Header... headerArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) headerArr);
        } else {
            this.mHeaders = headerArr;
        }
    }

    public void setIgnorePause(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this, z16);
        } else {
            this.mDrawableContainerState.mIgnorePause = z16;
        }
    }

    public void setIndividualPause(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 69)) {
            iPatchRedirector.redirect((short) 69, (Object) this, z16);
            return;
        }
        Drawable drawable = this.mCurrDrawable;
        if (drawable instanceof GifDrawable) {
            ((GifDrawable.GifState) ((GifDrawable) drawable).getConstantState()).setStickerPause(z16);
        }
    }

    public void setProgressDrawable(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this, (Object) drawable);
            return;
        }
        Drawable drawable2 = this.mProgressDrawable;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.mProgressDrawable = drawable;
            if (drawable != null) {
                drawable.setCallback(this);
                this.mProgressDrawable.setBounds(getBounds());
                this.mProgressDrawable.setLevel(this.mProgress);
            }
            onUpdateProgress(this.mDrawableContainerState.mProgress);
        }
    }

    public void setTag(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 56)) {
            iPatchRedirector.redirect((short) 56, (Object) this, obj);
        } else {
            this.mTag = obj;
        }
    }

    public void setTargetDensity(int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, i3);
            return;
        }
        if (i3 != this.mTargetDensity) {
            if (i3 == 0) {
                i16 = 160;
            } else {
                i16 = i3;
            }
            this.mTargetDensity = i16;
            if (getStatus() == 1) {
                Drawable drawable = this.mCurrDrawable;
                if (drawable instanceof RegionDrawable) {
                    ((RegionDrawable) drawable).setTargetDensity(i3);
                    return;
                }
                if (drawable instanceof SliceBitmapDrawable) {
                    ((SliceBitmapDrawable) drawable).setTargetDensity(this.mTargetDensity);
                    return;
                }
                if (drawable instanceof GifDrawable) {
                    ((GifDrawable) drawable).setTargetDensity(i3);
                    return;
                }
                if (drawable instanceof ApngDrawable) {
                    ((ApngDrawable) drawable).setTargetDensity(i3);
                } else if (drawable instanceof RoundRectDrawable) {
                    ((RoundRectDrawable) drawable).setTargetDensity(i3);
                } else if (drawable instanceof VideoDrawable) {
                    ((VideoDrawable) drawable).setTargetDensity(i3);
                }
            }
        }
    }

    public void setURLDrawableListener(URLDrawableListener uRLDrawableListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            iPatchRedirector.redirect((short) 53, (Object) this, (Object) uRLDrawableListener);
        } else {
            this.mListener = uRLDrawableListener;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), Boolean.valueOf(z17))).booleanValue();
        }
        boolean visible = super.setVisible(z16, z17);
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            drawable.setVisible(z16, z17);
        }
        return visible;
    }

    public void setWatermarkDrawable(Bitmap bitmap, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            iPatchRedirector.redirect((short) 61, this, bitmap, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.mWatermarkDrawable = bitmap;
        this.mWatermarkMarginRight = i3;
        this.mWatermarkMarginButtom = i16;
    }

    public void setWatermarkVisibility(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 62)) {
            iPatchRedirector.redirect((short) 62, (Object) this, i3);
            return;
        }
        if (i3 == 0) {
            this.mIsShowWatermark = true;
        } else {
            this.mIsShowWatermark = false;
        }
        invalidateSelf();
    }

    public void startDownload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            startDownload(true);
        } else {
            iPatchRedirector.redirect((short) 20, (Object) this);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) drawable, (Object) runnable);
        } else {
            unscheduleSelf(runnable);
        }
    }

    public void updateRegionBitmap(RegionDrawableData regionDrawableData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 68)) {
            iPatchRedirector.redirect((short) 68, (Object) this, (Object) regionDrawableData);
            return;
        }
        if (!RegionDrawable.class.isInstance(this.mCurrDrawable)) {
            return;
        }
        Matrix matrix = this.mExifMatrix;
        if (matrix != null && !matrix.isIdentity()) {
            RectF rectF = new RectF(regionDrawableData.mShowArea);
            Matrix matrix2 = new Matrix();
            matrix.invert(matrix2);
            matrix2.mapRect(rectF);
            rectF.round(regionDrawableData.mShowArea);
            rectF.set(regionDrawableData.mImageArea);
            matrix2.mapRect(rectF);
            rectF.round(regionDrawableData.mImageArea);
        }
        ((RegionDrawable) this.mCurrDrawable).updateRegionRect(regionDrawableData);
    }

    @Deprecated
    public static URLDrawable getDrawable(URL url, boolean z16) {
        return getDrawable(url, (Drawable) null, (Drawable) null, z16);
    }

    public void downloadImediatly(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 36)) {
            this.mDrawableContainerState.downloadImediatly(this.mHeaders, this.mCookies, this.mTag, z16, this.mUseGifAnimation, this.mUseApngImage, this.mUseSharpPImage, this.mGifRoundCorner, this.mUseExifOrientation, this.mUseSharpPAnimImage, this.mExtraInfo, this.mUseDynamicDrawable, this.mDynamicDrawableType);
        } else {
            iPatchRedirector.redirect((short) 36, (Object) this, z16);
        }
    }

    public void restartDownload(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
        } else if (this.mDrawableContainerState.reStartDownload(this.mHeaders, this.mCookies, this.mTag, z16, this.mUseGifAnimation, this.mUseApngImage, this.mUseSharpPImage, this.mGifRoundCorner, this.mUseExifOrientation, this.mUseSharpPAnimImage, this.mExtraInfo, this.mUseDynamicDrawable, this.mDynamicDrawableType) && z16) {
            invalidateSelf();
        }
    }

    public void startDownload(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
            this.mDrawableContainerState.startDownload(this.mHeaders, this.mCookies, this.mTag, z16, this.mUseGifAnimation, this.mUseApngImage, this.mUseSharpPImage, this.mGifRoundCorner, this.mUseExifOrientation, this.mUseSharpPAnimImage, this.mExtraInfo, this.mUseDynamicDrawable, this.mDynamicDrawableType);
        } else {
            iPatchRedirector.redirect((short) 22, (Object) this, z16);
        }
    }

    @Deprecated
    public static URLDrawable getDrawable(URL url, int i3, int i16) {
        return getDrawable(url, i3, i16, (Drawable) null, (Drawable) null);
    }

    @Deprecated
    public static void removeMemoryCacheByUrl(String str) {
        depImp.mCache.remove(str);
    }

    @Deprecated
    public static URLDrawable getDrawable(URL url, int i3, int i16, boolean z16) {
        return getDrawable(url, i3, i16, null, null, z16, 0.0f);
    }

    @Deprecated
    public static URLDrawable getDrawable(URL url, Drawable drawable, Drawable drawable2) {
        return getDrawable(url, 0, 0, drawable, drawable2);
    }

    @Deprecated
    public static URLDrawable getDrawable(URL url, Drawable drawable, Drawable drawable2, boolean z16) {
        return getDrawable(url, 0, 0, drawable, drawable2, z16, 0.0f);
    }

    @Deprecated
    public static URLDrawable getDrawable(URL url, int i3, int i16, Drawable drawable, Drawable drawable2) {
        return getDrawable(url, i3, i16, drawable, drawable2, false, 0.0f);
    }

    public void cancelDownload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 27)) {
            cancelDownload(false);
        } else {
            iPatchRedirector.redirect((short) 27, (Object) this);
        }
    }

    @Deprecated
    public static URLDrawable getDrawable(URL url, int i3, int i16, Drawable drawable, Drawable drawable2, boolean z16) {
        return getDrawable(url, i3, i16, drawable, drawable2, z16, 0.0f);
    }

    @Deprecated
    public static URLDrawable getDrawable(URL url, int i3, int i16, Drawable drawable, Drawable drawable2, boolean z16, float f16) {
        URLDrawableOptions obtain = URLDrawableOptions.obtain();
        obtain.mRequestWidth = i3;
        obtain.mRequestHeight = i16;
        obtain.mLoadingDrawable = drawable;
        obtain.mFailedDrawable = drawable2;
        obtain.mPlayGifImage = z16;
        obtain.mGifRoundCorner = f16;
        return getDrawable(url, obtain);
    }

    @Deprecated
    public static URLDrawable getDrawable(String str) throws IllegalArgumentException {
        return getDrawable(str, (Drawable) null, (Drawable) null);
    }

    @Deprecated
    public static URLDrawable getDrawable(String str, boolean z16) throws IllegalArgumentException {
        return getDrawable(str, (Drawable) null, (Drawable) null, z16);
    }

    @Deprecated
    public static URLDrawable getDrawable(String str, int i3, int i16) throws IllegalArgumentException {
        return getDrawable(str, i3, i16, (Drawable) null, (Drawable) null);
    }

    @Deprecated
    public static URLDrawable getDrawable(String str, int i3, int i16, boolean z16) throws IllegalArgumentException {
        return getDrawable(str, i3, i16, (Drawable) null, (Drawable) null, z16);
    }

    @Deprecated
    public static URLDrawable getDrawable(String str, Drawable drawable, Drawable drawable2) throws IllegalArgumentException {
        return getDrawable(str, 0, 0, drawable, drawable2);
    }

    @Deprecated
    public static URLDrawable getDrawable(String str, Drawable drawable, Drawable drawable2, boolean z16) throws IllegalArgumentException {
        return getDrawable(str, 0, 0, drawable, drawable2, z16);
    }

    @Deprecated
    public static URLDrawable getDrawable(String str, int i3, int i16, Drawable drawable, Drawable drawable2) throws IllegalArgumentException {
        return getDrawable(str, i3, i16, drawable, drawable2, false);
    }

    @Deprecated
    public static URLDrawable getDrawable(String str, int i3, int i16, Drawable drawable, Drawable drawable2, boolean z16) throws IllegalArgumentException {
        try {
            return getDrawable(new URL(str), i3, i16, drawable, drawable2, z16, 0.0f);
        } catch (MalformedURLException unused) {
            return doIllegalURL(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public URLDrawable(URLState uRLState, Resources resources) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) uRLState, (Object) resources);
            return;
        }
        this.individualPause = false;
        this.mUseDynamicDrawable = false;
        this.mDynamicDrawableType = "";
        this.mTargetDensity = 160;
        this.mRefreshDelay = -1;
        this.mUseExifOrientation = true;
        this.mWatermarkDrawable = null;
        this.mWatermarkMarginRight = 0;
        this.mWatermarkMarginButtom = 0;
        this.mIsShowWatermark = false;
        this.mProgress = 0;
        this.mFadeInAnimationStarted = false;
        this.mFadeInAnimationStartTime = -1L;
        this.mAutoDownload = true;
        this.mAlpha = 255;
        this.individualPauseCount = 0;
        this.mAlreadyChecked = false;
        this.mDrawableContainerState = uRLState;
        if (uRLState.mStatus == 1) {
            Drawable newDrawable = uRLState.mSuccessed.newDrawable(resources);
            this.mCurrDrawable = newDrawable;
            newDrawable.setCallback(this);
            return;
        }
        uRLState.addCallBack(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x01ae A[Catch: all -> 0x01c1, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0008, B:7:0x000c, B:9:0x0017, B:11:0x0023, B:12:0x0027, B:14:0x0036, B:16:0x003c, B:17:0x0128, B:21:0x004c, B:23:0x0050, B:24:0x0064, B:26:0x0068, B:27:0x0080, B:29:0x0084, B:31:0x0088, B:33:0x008c, B:34:0x0096, B:36:0x00c1, B:38:0x00cb, B:40:0x00f8, B:41:0x010e, B:42:0x00ff, B:44:0x0103, B:45:0x0106, B:46:0x0113, B:48:0x011b, B:49:0x011f, B:51:0x0126, B:52:0x0137, B:54:0x018a, B:55:0x0190, B:57:0x0194, B:60:0x0199, B:61:0x01a8, B:63:0x01ae, B:64:0x01b2, B:67:0x019e), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized URLDrawable getDrawable(URL url, URLDrawableOptions uRLDrawableOptions) {
        int i3;
        Object obj;
        synchronized (URLDrawable.class) {
            checkParams();
            if (uRLDrawableOptions == null) {
                uRLDrawableOptions = URLDrawableOptions.obtain();
            }
            URLState constants = URLState.getConstants(url.toString(), uRLDrawableOptions);
            if (constants != null) {
                URLDrawable uRLDrawable = (URLDrawable) constants.newDrawable(null);
                if (constants.mParams.mAutoScaleByDensity) {
                    uRLDrawable = autoScale(null, uRLDrawable);
                }
                uRLDrawable.mUseExifOrientation = uRLDrawableOptions.mUseExifOrientation;
                uRLDrawable.mExtraInfo = uRLDrawableOptions.mExtraInfo;
                int status = uRLDrawable.getStatus();
                if (status == 1) {
                    Drawable drawable = uRLDrawable.mCurrDrawable;
                    if (drawable instanceof GifDrawable) {
                        ((GifDrawable) drawable).mUseAnimation = uRLDrawableOptions.mPlayGifImage;
                        ((GifDrawable) drawable).setGifRefreshDelay(uRLDrawableOptions.mGifRefreshDelay);
                    } else if (drawable instanceof ApngDrawable) {
                        ((ApngDrawable) drawable).mUseAnimation = uRLDrawableOptions.mUseApngImage;
                        ((ApngDrawable) drawable).setUseRect(uRLDrawableOptions.mExtraInfo);
                        uRLDrawable.mUseApngImage = uRLDrawableOptions.mUseApngImage;
                    } else if (drawable instanceof SharpDrawable) {
                        ((SharpDrawable) drawable).mUseAnimation = uRLDrawableOptions.mUseSharpPAnimImage;
                        ((SharpDrawable) drawable).setUseRect(uRLDrawableOptions.mExtraInfo);
                        uRLDrawable.mUseSharpPImage = uRLDrawableOptions.mUseSharpPImage;
                        uRLDrawable.mUseSharpPAnimImage = uRLDrawableOptions.mUseSharpPAnimImage;
                    } else if ((drawable instanceof VideoDrawable) && (obj = uRLDrawableOptions.mExtraInfo) != null && (obj instanceof VideoDrawable.VideoDrawableParams)) {
                        ((VideoDrawable) drawable).mPlayVideoFrame = ((VideoDrawable.VideoDrawableParams) obj).mPlayVideoFrame;
                    }
                } else {
                    uRLDrawable.mUseGifAnimation = uRLDrawableOptions.mPlayGifImage;
                    uRLDrawable.mRefreshDelay = uRLDrawableOptions.mGifRefreshDelay;
                    uRLDrawable.mUseApngImage = uRLDrawableOptions.mUseApngImage;
                    uRLDrawable.mUseDynamicDrawable = uRLDrawableOptions.mUseDynamicDrawable;
                    uRLDrawable.mDynamicDrawableType = uRLDrawableOptions.mDynamicDrawableType;
                    uRLDrawable.mUseSharpPImage = uRLDrawableOptions.mUseSharpPImage;
                    uRLDrawable.mUseSharpPAnimImage = uRLDrawableOptions.mUseSharpPAnimImage;
                    uRLDrawable.mGifRoundCorner = uRLDrawableOptions.mGifRoundCorner;
                    URLDrawableParams uRLDrawableParams = sDefaultDrawableParms;
                    uRLDrawable.mFadeInImage = uRLDrawableParams.mFadeInImage;
                    CustomError customError = constants.mCustomError;
                    if (status == 2) {
                        if (depImp.mLog.isColorLevel()) {
                            depImp.mLog.d(TAG, 2, "getDrawable from cache url= " + url.toString() + ",isLoadingStarted" + constants.mIsLoadingStarted);
                        }
                        if (customError != null) {
                            uRLDrawable.mFailedDrawable = customError.getFailedDrawable();
                        } else {
                            Drawable drawable2 = uRLDrawableOptions.mFailedDrawable;
                            if (drawable2 != null) {
                                uRLDrawable.mFailedDrawable = drawable2;
                            } else {
                                uRLDrawable.mFailedDrawable = sDefaultDrawableParms.getDefualtFailedDrawable();
                            }
                        }
                        uRLDrawable.mCurrDrawable = uRLDrawable.mFailedDrawable;
                    } else {
                        uRLDrawable.mFailedDrawable = uRLDrawableOptions.mFailedDrawable;
                        Drawable drawable3 = uRLDrawableOptions.mLoadingDrawable;
                        if (drawable3 == null) {
                            drawable3 = uRLDrawableParams.getDefaultLoadingDrawable();
                        }
                        uRLDrawable.mProgressDrawable = drawable3;
                        uRLDrawable.mCurrDrawable = drawable3;
                        if (status == 4) {
                            int i16 = uRLDrawableOptions.mRequestWidth;
                        }
                    }
                }
                uRLDrawable.mCallStack = new IllegalStateException("UrlDrawable getStack");
                uRLDrawableOptions.Recycle();
                return uRLDrawable;
            }
            URLDrawable uRLDrawable2 = new URLDrawable(url, uRLDrawableOptions);
            uRLDrawable2.mUseGifAnimation = uRLDrawableOptions.mPlayGifImage;
            uRLDrawable2.mRefreshDelay = uRLDrawableOptions.mGifRefreshDelay;
            uRLDrawable2.mUseApngImage = uRLDrawableOptions.mUseApngImage;
            uRLDrawable2.mUseDynamicDrawable = uRLDrawableOptions.mUseDynamicDrawable;
            uRLDrawable2.mDynamicDrawableType = uRLDrawableOptions.mDynamicDrawableType;
            uRLDrawable2.mUseSharpPImage = uRLDrawableOptions.mUseSharpPImage;
            uRLDrawable2.mUseSharpPAnimImage = uRLDrawableOptions.mUseSharpPAnimImage;
            uRLDrawable2.mGifRoundCorner = uRLDrawableOptions.mGifRoundCorner;
            uRLDrawable2.mFadeInImage = sDefaultDrawableParms.mFadeInImage;
            uRLDrawable2.mUseExifOrientation = uRLDrawableOptions.mUseExifOrientation;
            uRLDrawable2.mExtraInfo = uRLDrawableOptions.mExtraInfo;
            DownloadParams downloadParams = uRLDrawable2.mDrawableContainerState.mParams;
            downloadParams.url = url;
            downloadParams.urlStr = url.toString();
            downloadParams.needCheckNetType = uRLDrawableOptions.mNeedCheckNetType;
            downloadParams.retryCount = uRLDrawableOptions.mRetryCount;
            downloadParams.mHttpDownloaderParams = uRLDrawableOptions.mHttpDownloaderParams;
            downloadParams.hostForHttpsVerify = uRLDrawableOptions.mHostForHttpsVerify;
            boolean z16 = uRLDrawableOptions.mUseAutoScaleParams;
            if (z16) {
                downloadParams.mAutoScaleByDensity = sDefaultDrawableParms.mAutoScaleByDensity;
            }
            int i17 = uRLDrawableOptions.mRequestWidth;
            if (i17 != 0 && (i3 = uRLDrawableOptions.mRequestHeight) != 0) {
                downloadParams.reqWidth = i17;
                downloadParams.reqHeight = i3;
                downloadParams.mImgType = uRLDrawableOptions.mImgType;
                if (z16) {
                    uRLDrawable2 = autoScale(null, uRLDrawable2);
                }
                uRLDrawable2.mCallStack = new IllegalStateException("UrlDrawable getStack");
                uRLDrawableOptions.Recycle();
                return uRLDrawable2;
            }
            URLDrawableParams uRLDrawableParams2 = sDefaultDrawableParms;
            downloadParams.reqWidth = uRLDrawableParams2.mReqWidth;
            downloadParams.reqHeight = uRLDrawableParams2.mReqHeight;
            downloadParams.mImgType = uRLDrawableOptions.mImgType;
            if (z16) {
            }
            uRLDrawable2.mCallStack = new IllegalStateException("UrlDrawable getStack");
            uRLDrawableOptions.Recycle();
            return uRLDrawable2;
        }
    }

    public static URLDrawable getDrawable(String str, URLDrawableOptions uRLDrawableOptions) {
        try {
            return getDrawable(new URL(str), uRLDrawableOptions);
        } catch (MalformedURLException unused) {
            return doIllegalURL(str);
        }
    }

    @Deprecated
    public static URLDrawable getDrawable(File file, URLDrawableOptions uRLDrawableOptions) {
        try {
            URL url = file.toURI().toURL();
            if (url != null) {
                return getDrawable(url, uRLDrawableOptions);
            }
            return null;
        } catch (MalformedURLException unused) {
            return null;
        }
    }
}
