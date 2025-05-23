package com.tencent.component.media;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageDownloadInfo;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.drawable.BitmapRefDrawable;
import com.tencent.component.media.image.drawable.ImageDrawable;
import com.tencent.component.media.image.drawable.SpecifiedBitmapDrawable;
import com.tencent.component.media.image.drawable.SpecifiedDrawable;
import com.tencent.component.media.utils.BitmapUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.Executor;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class ImageManagerEnv {
    public static final int DECODING_FAILURE_CODE_BITMAP_EXCEPTION = 3;
    public static final int DECODING_FAILURE_CODE_BITMAP_NULL = 1;
    public static final int DECODING_FAILURE_CODE_BITMAP_OOM = 2;
    public static final int DECODING_FAILURE_CODE_BITMAP_THROWABLE = 4;
    public static final int DECODING_FAILURE_CODE_DELETE_SHARPP_CACHE = 5;
    public static final int DECODING_FAILURE_CODE_FAILED = 51000;
    public static final int DECODING_FAILURE_CODE_SUCCESS = 0;
    public static final String MTA_EVENT_KEY_IMAGE_DECODE = "qzone_image_decode";
    public static final String MTA_SUB_KEY_IMAGE_TIME_COST = "image_time_cost";
    public static final String MTA_VALUE_DECODE_TIME = "decode_time";
    public static final String MTA_VALUE_DECODE_TIME_NONE_SR = "decode_time_none_sr";
    public static final String MTA_VALUE_DOWNLOAD_TIME = "download_time";
    public static final String MTA_VALUE_DOWNLOAD_TIME_NONE_SR = "download_time_none_sr";
    public static final String QZONE_GIF_PLAYING_FAIL_COUNT_REPORT = "gifPlayingFailCountReport";
    public static final String QZONE_GIF_PLAYING_REPORT = "gifPlayingReportNew";
    public static final int TASK_TYPE_PARALLEL_RENDER_TASK = 2;
    public static final int TASK_TYPE_SERIAL_RENDER_TASK = 1;
    private static volatile Context appContext;
    static HandlerThread sHandlerThread;
    private static volatile ImageManagerEnv sInstance;
    private static volatile ILog sLogger;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface ILruCacheProxy {
        Object get(String str);

        void put(String str, Object obj);

        void remove(String str);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface ImageDownloaderListener {
        void onDownloadCanceled(String str);

        void onDownloadFailed(String str, ImageDownloadInfo imageDownloadInfo);

        void onDownloadProgress(String str, long j3, float f16);

        void onDownloadSucceed(String str, String str2, boolean z16, ImageDownloadInfo imageDownloadInfo);

        void onStreamProgress(String str, String str2);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface StreamLoadListener {
        void onDownloadCanceled(String str, String str2);

        void onDownloadFailed(String str, String str2);

        void onDownloadProgress(String str, String str2, String str3, byte[] bArr, int i3);

        void onDownloadSucceed(String str, String str2);
    }

    public static ImageManagerEnv g() {
        if (sInstance != null) {
            return sInstance;
        }
        throw new RuntimeException("ImageManagerEnv \u6ca1\u6709\u521d\u59cb\u5316\uff01\uff01\uff01");
    }

    public static synchronized Context getAppContext() {
        Context context;
        synchronized (ImageManagerEnv.class) {
            context = appContext;
        }
        return context;
    }

    public static ILog getLogger() {
        return sLogger;
    }

    public static synchronized void init(Context context, ImageManagerEnv imageManagerEnv, ILog iLog) {
        synchronized (ImageManagerEnv.class) {
            appContext = context;
            sInstance = imageManagerEnv;
            sLogger = iLog;
        }
    }

    public abstract boolean closeNativeAndinBitmap();

    public abstract boolean copyFiles(File file, File file2);

    public BitmapReference drawableToBitmap(Drawable drawable) {
        if (drawable instanceof SpecifiedBitmapDrawable) {
            return ((SpecifiedBitmapDrawable) drawable).getBitmapRef();
        }
        if (drawable instanceof BitmapRefDrawable) {
            return ((BitmapRefDrawable) drawable).getBitmapRef();
        }
        if (drawable instanceof BitmapDrawable) {
            return BitmapReference.getBitmapReference(((BitmapDrawable) drawable).getBitmap());
        }
        if (drawable instanceof ImageDrawable) {
            return ((ImageDrawable) drawable).getBitmapRef();
        }
        if (drawable instanceof SpecifiedDrawable) {
            return BitmapUtils.drawableToBitmapByCanvas(drawable);
        }
        return null;
    }

    public abstract boolean enableBitmapNativeAlloc();

    public abstract boolean enableSocketMonitor();

    public abstract float getAnimationDrawableCacheRatio();

    public abstract String getAvatarPath(String str);

    public abstract float getCacheMemRatio();

    public abstract boolean getCurrentLoadingImgStatus();

    public abstract int getDecodeThreadNum(boolean z16);

    public abstract float getDesity();

    public abstract Looper getDispatcher();

    public abstract IDownloader getDownloader(ImageDownloaderListener imageDownloaderListener);

    public abstract Executor getExecutor();

    public abstract Looper getFileThreadLooper();

    public abstract int getHaboReportSampleRange();

    public abstract String getImageBigUrlSegment();

    public abstract String getImageCacheDir(boolean z16);

    public abstract String getImageCurrentUrlSegment();

    public abstract int getMaxGifRenderThreadNum();

    public abstract int getMaxNumOfDecodingFailures();

    public abstract int getMinMemoryClassInArt();

    public abstract int getModelIdFromUrl(String str);

    public abstract int getNetWorkState();

    public abstract long getNoCacheImageExpiredTime();

    public abstract Drawable getPhotoGifDefaultDrawable();

    public abstract String getProcessName(Context context);

    public abstract String getQAParameterRex();

    public abstract ILruCacheProxy getQQImagecache();

    public abstract int getRotationDegree(String str);

    public abstract String getSRParameterRex();

    public abstract int getScreenHeight();

    public abstract int getScreenWidth();

    public abstract String getSocketMonitorUrl(String str, ImageLoader.Options options);

    public abstract Drawable getWatermarkLogoDrawable();

    public abstract boolean isAvifSoLoaded();

    public abstract boolean isBigUrl(String str);

    public abstract boolean isForceShutdownGif();

    public abstract boolean isGifSupport565();

    public abstract boolean isHighScaleUrl(String str);

    public abstract boolean isMainProcess(Context context);

    public abstract boolean isNeedRecycle();

    public abstract boolean isOpenGetImageSuccessRecorder();

    public abstract boolean isPreferNewAnimationImp();

    public abstract boolean isPreferNewGifDecodeTask();

    public abstract boolean isQQProcess(Context context);

    public abstract boolean isSuperResolutionUrl(String str);

    public abstract boolean isSupportGifPlaying();

    public abstract boolean isSupportSharpp();

    public abstract boolean isWNSSupportPieceLoad();

    public abstract boolean loadLibrary(String str);

    public abstract boolean needCheckAvatar();

    public abstract boolean openProgressTracer();

    public abstract int panoramaComputeSampleSize(ImageLoader.Options options, int i3, int i16);

    public abstract byte[] readFile(String str);

    public abstract String removeSocketMonitorParam(String str);

    public abstract void reportAnimationDrawableSize(int i3);

    public abstract void reportEventToMTA(String str, Properties properties);

    public abstract void reportException(Throwable th5);

    public abstract void reportGetImageCacheToMM(int i3);

    public abstract void reportGifFrameRate(int i3, float f16, float f17);

    public abstract void reportImageDecodingRes(String str, String str2, long j3, boolean z16, long j16, int i3);

    public abstract void reportImageDecodingResMTA(String str, String str2);

    public abstract void reportImageDecodingTask(String str, String str2, long j3, int i3, String str3, long j16);

    public abstract void reportImageTimeCostMTA(String str, String str2, String str3, int i3);

    public abstract boolean shouldPlayAnimWebp();

    public abstract boolean shouldPlayPhotoGif();

    public abstract boolean shouldUseJpgWhenAvifDisable();

    public abstract void showToast(int i3, Context context, CharSequence charSequence, int i16);

    public abstract void statisticCollectorReport(String str, HashMap<String, String> hashMap);

    public abstract boolean useARGB8888Config();
}
