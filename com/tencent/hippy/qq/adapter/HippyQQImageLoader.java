package com.tencent.hippy.qq.adapter;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.hippy.qq.adapter.image.HippyImageInfo;
import com.tencent.hippy.qq.adapter.image.decoder.AvifLibraryLoader;
import com.tencent.hippy.qq.adapter.image.decoder.ByteBufferAvifDecoder;
import com.tencent.hippy.qq.adapter.image.decoder.ByteBufferAvifSequenceDecoder;
import com.tencent.hippy.qq.adapter.image.decoder.HippyImageDecoder;
import com.tencent.hippy.qq.adapter.image.decoder.ImageDetector;
import com.tencent.hippy.qq.offline.HippyOfflineAssist;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.ApngDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mtt.hippy.adapter.image.HippyDrawable;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.text.Typography;
import libavif.AvifSequenceDrawable;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyQQImageLoader extends HippyImageLoader {
    private static final String AVIF_FLAG = "avif=1";
    private static final String CACHE_FILE_PREFIX = "Cache_";
    private static final long HTTP2_CONFIG_LOAD_MIN_INTERVAL = 7200000;
    private static final int MAX_DOWNLOAD_RETRY_COUNT = 3;
    protected static final String TAG = "HippyImageAdapter";
    private static final String URL_DRAWABLE_MEMORY_CACHE_KEY_SUFFIX = "hippy";
    private static final String URL_PARAM_USE_AVIF = "ci-style=avif&imageMogr2/";
    private final ByteBufferAvifDecoder mAvifDecoder = new ByteBufferAvifDecoder();
    private final ByteBufferAvifSequenceDecoder mAvifSequenceDecoder = new ByteBufferAvifSequenceDecoder();
    private Set<URLDrawable> mUrlDrawables = Collections.synchronizedSet(new HashSet());
    public final Object mImageCacheLock = new Object();
    HashMap<String, WeakReference<Bitmap>> mImageCache = new HashMap<>();
    HashMap<String, ArrayList<HippyImageInfo>> mLoadingImages = new HashMap<>();
    private boolean mIsDestroyed = false;

    public HippyQQImageLoader() {
        AvifLibraryLoader.loadLibrary();
    }

    private void callbackAnimatedAvif(HippyImageInfo hippyImageInfo, AvifSequenceDrawable avifSequenceDrawable) {
        if (avifSequenceDrawable == null) {
            return;
        }
        int i3 = hippyImageInfo.repeatCount;
        if (i3 > 0) {
            avifSequenceDrawable.u(1);
            avifSequenceDrawable.setLoopCount(hippyImageInfo.repeatCount);
        } else if (i3 == 0) {
            avifSequenceDrawable.u(2);
        } else {
            avifSequenceDrawable.u(3);
        }
        HippyDrawable hippyDrawable = new HippyDrawable();
        hippyDrawable.setDrawable(avifSequenceDrawable);
        hippyDrawable.setImageType("apng");
        onImageLoadSuccess(hippyImageInfo, hippyDrawable);
    }

    private void callbackStaticAvif(HippyImageInfo hippyImageInfo, Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        HippyDrawable hippyDrawable = new HippyDrawable();
        hippyDrawable.setImageType("image/*");
        hippyDrawable.setData(bitmap);
        onImageLoadSuccess(hippyImageInfo, hippyDrawable);
    }

    private HippyDrawable createHippyDrawableByApng(HippyImageInfo hippyImageInfo, String str) {
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setRequestHeight(hippyImageInfo.reqHeight);
        apngOptions.setRequestWidth(hippyImageInfo.reqWidth);
        apngOptions.setLoop(hippyImageInfo.repeatCount);
        apngOptions.setUseCache(false);
        URLDrawable apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable(hippyImageInfo.url, apngOptions, str);
        if (apngURLDrawable == null) {
            return null;
        }
        HippyDrawable hippyDrawable = new HippyDrawable();
        hippyDrawable.setDrawable(apngURLDrawable);
        hippyDrawable.setImageType("apng");
        if (!hippyImageInfo.resizeMode.equals("cover")) {
            Drawable currDrawable = apngURLDrawable.getCurrDrawable();
            if (currDrawable instanceof ApngDrawable) {
                ((ApngDrawable) currDrawable).setGravity(17);
            }
        }
        return hippyDrawable;
    }

    private void decodeAvifImage(HippyImageInfo hippyImageInfo, File file) {
        String str;
        byte[] readFile;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "decodeAvifImage url:" + hippyImageInfo.url);
        }
        if (!AvifLibraryLoader.isLibReady()) {
            onImageDownloadFailed(hippyImageInfo, "lib is NOT ready, fail to decode avif image.");
            return;
        }
        try {
            readFile = FileUtils.readFile(file.getAbsolutePath());
        } catch (Throwable th5) {
            str = "fail to decode avif e:" + th5;
            QLog.e(TAG, 1, str);
        }
        if (readFile != null && readFile.length > 0) {
            Object decode = getAvifDecoder(readFile).decode(ByteBuffer.wrap(readFile), hippyImageInfo.reqWidth, hippyImageInfo.reqHeight);
            if (decode instanceof AvifSequenceDrawable) {
                callbackAnimatedAvif(hippyImageInfo, (AvifSequenceDrawable) decode);
                return;
            } else if (decode instanceof Bitmap) {
                callbackStaticAvif(hippyImageInfo, (Bitmap) decode);
                return;
            } else {
                str = "fail to decode avif, imageData is null.";
                onImageDownloadFailed(hippyImageInfo, str);
                return;
            }
        }
        onImageDownloadFailed(hippyImageInfo, "read file error, fail to decode avif image.");
    }

    private void decodeGifImage(HippyImageInfo hippyImageInfo, File file) {
        HippyDrawable hippyDrawable = new HippyDrawable();
        hippyDrawable.setImageType("gif");
        hippyDrawable.setData(file, true);
        if (hippyDrawable.getGIF() != null && hippyDrawable.getGIF().duration() > 0) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.hippy.qq.adapter.d
                @Override // java.lang.Runnable
                public final void run() {
                    AbstractGifImage.resumeAll();
                }
            });
            ArrayList arrayList = new ArrayList();
            synchronized (this.mImageCacheLock) {
                ArrayList<HippyImageInfo> remove = this.mLoadingImages.remove(hippyImageInfo.getImageCacheKey());
                if (remove != null) {
                    arrayList.addAll(remove);
                }
            }
            if (arrayList.size() > 0) {
                ((HippyImageInfo) arrayList.get(0)).onRequestSuccessInUiThread(hippyDrawable);
                arrayList.remove(0);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    HippyImageInfo hippyImageInfo2 = (HippyImageInfo) it.next();
                    HippyDrawable hippyDrawable2 = new HippyDrawable();
                    hippyDrawable2.setImageType("gif");
                    hippyDrawable2.setData(file, true);
                    hippyImageInfo2.onRequestSuccessInUiThread(hippyDrawable2);
                }
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "decodeGifImage as staticImage. url:" + hippyImageInfo.url);
        decodeStaticImage(hippyImageInfo, file);
    }

    private void decodeStaticImage(HippyImageInfo hippyImageInfo, File file) {
        Bitmap imageCache = getImageCache(hippyImageInfo.getImageCacheKey());
        if ((imageCache == null || imageCache.isRecycled()) && (imageCache = hippyImageInfo.decodeStaticImage(file)) != null) {
            synchronized (this.mImageCacheLock) {
                this.mImageCache.put(hippyImageInfo.getImageCacheKey(), new WeakReference<>(imageCache));
            }
        }
        HippyDrawable hippyDrawable = new HippyDrawable();
        hippyDrawable.setImageType("image/*");
        hippyDrawable.setData(imageCache);
        onImageLoadSuccess(hippyImageInfo, hippyDrawable);
    }

    private void downloadImage(final HippyImageInfo hippyImageInfo, final URLDrawable uRLDrawable, URLDrawable.URLDrawableOptions uRLDrawableOptions) {
        if (uRLDrawable.getStatus() == 1 && (uRLDrawable.getFileInLocal() == null || !uRLDrawable.getFileInLocal().exists())) {
            QLog.i(TAG, 1, "fetchImage url:" + hippyImageInfo.url + " remove cache status:" + uRLDrawable.getStatus());
            URLDrawable.removeMemoryCacheByUrl(hippyImageInfo.url, uRLDrawableOptions);
            uRLDrawable = URLDrawable.getDrawable(hippyImageInfo.url, uRLDrawableOptions);
        }
        URLDrawable.URLDrawableListener2 uRLDrawableListener2 = new URLDrawable.URLDrawableListener2() { // from class: com.tencent.hippy.qq.adapter.HippyQQImageLoader.1
            @Override // com.tencent.image.URLDrawable.URLDrawableListener2
            public void onFileDownloaded(URLDrawable uRLDrawable2) {
                File fileInLocal = uRLDrawable2.getFileInLocal();
                if (fileInLocal != null && fileInLocal.exists()) {
                    HippyQQImageLoader.this.onImageDownloaded(hippyImageInfo, fileInLocal.getAbsolutePath());
                } else {
                    QLog.i(HippyQQImageLoader.TAG, 2, "fetchImage url:" + hippyImageInfo.url + " onFileDownloaded file not exists");
                    HippyQQImageLoader.this.onImageDownloadFailed(hippyImageInfo, "onLoadSuccessed file not exists");
                }
                HippyQQImageLoader.this.mUrlDrawables.remove(uRLDrawable2);
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadCanceled(URLDrawable uRLDrawable2) {
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadSuccessed(URLDrawable uRLDrawable2) {
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadFialed(URLDrawable uRLDrawable2, Throwable th5) {
            }

            @Override // com.tencent.image.URLDrawable.URLDrawableListener
            public void onLoadProgressed(URLDrawable uRLDrawable2, int i3) {
            }
        };
        URLDrawable.DownloadListener downloadListener = new URLDrawable.DownloadListener() { // from class: com.tencent.hippy.qq.adapter.HippyQQImageLoader.2
            @Override // com.tencent.image.URLDrawable.DownloadListener
            public void onFileDownloadFailed(int i3) {
                hippyImageInfo.getPerformanceData().recordDownLoadEndTime();
                if (QLog.isColorLevel()) {
                    QLog.e(HippyQQImageLoader.TAG, 2, "fetchImage url:" + hippyImageInfo.url + " onFileDownloadFailed + linsenter:" + this + " errorCode:" + i3);
                }
                HippyQQImageLoader.this.mUrlDrawables.remove(uRLDrawable);
                HippyQQImageLoader.this.onImageDownloadFailed(hippyImageInfo, "", new Throwable("onFileDownloadFailed code:" + i3));
            }

            @Override // com.tencent.image.URLDrawable.DownloadListener
            public void onFileDownloadStarted() {
                hippyImageInfo.getPerformanceData().recordDownLoadStartTime();
            }

            @Override // com.tencent.image.URLDrawable.DownloadListener
            public void onFileDownloadSucceed(long j3) {
                hippyImageInfo.getPerformanceData().recordDownLoadEndTime();
            }
        };
        uRLDrawable.setTag(0);
        uRLDrawable.setURLDrawableListener(uRLDrawableListener2);
        uRLDrawable.setDownloadListener(downloadListener);
        this.mUrlDrawables.add(uRLDrawable);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.hippy.qq.adapter.a
            @Override // java.lang.Runnable
            public final void run() {
                HippyQQImageLoader.lambda$downloadImage$0(URLDrawable.this);
            }
        });
    }

    private HippyImageDecoder<ByteBuffer, ? extends Object> getAvifDecoder(byte[] bArr) {
        if (ImageDetector.isAvifAnimated(ByteBuffer.wrap(bArr))) {
            return this.mAvifSequenceDecoder;
        }
        return this.mAvifDecoder;
    }

    private Bitmap getImageCache(String str) {
        Bitmap bitmap;
        synchronized (this.mImageCacheLock) {
            WeakReference<Bitmap> weakReference = this.mImageCache.get(str);
            if (weakReference != null) {
                bitmap = weakReference.get();
            } else {
                bitmap = null;
            }
        }
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        return bitmap;
    }

    public static String getUrlWithIsAvifSupport(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (str.indexOf(AVIF_FLAG) < 0) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        if (AvifLibraryLoader.isLibReady()) {
            if (str.indexOf(63) >= 0) {
                sb5.append(Typography.amp);
            } else {
                sb5.append('?');
            }
            sb5.append(URL_PARAM_USE_AVIF);
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$downloadImage$0(URLDrawable uRLDrawable) {
        if (uRLDrawable.getStatus() != 2 && uRLDrawable.getStatus() != 3) {
            uRLDrawable.startDownload(false);
        } else {
            uRLDrawable.restartDownload(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onImageDownloaded$2(final String str, final HippyImageInfo hippyImageInfo) {
        File file = new File(str);
        if (!file.exists()) {
            onImageDownloadFailed(hippyImageInfo, "Image file not exists");
            return;
        }
        try {
            if (hippyImageInfo.isApng(file)) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.hippy.qq.adapter.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        HippyQQImageLoader.this.lambda$onImageDownloaded$1(hippyImageInfo, str);
                    }
                });
            } else if (hippyImageInfo.isGif(file)) {
                decodeGifImage(hippyImageInfo, file);
            } else if (hippyImageInfo.isAvif(file)) {
                decodeAvifImage(hippyImageInfo, file);
            } else {
                decodeStaticImage(hippyImageInfo, file);
            }
        } catch (IOException e16) {
            QLog.e(TAG, 1, "onImageDownloaded e:", e16);
            onImageDownloadFailed(hippyImageInfo, "Check apng error", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onAngImageDownloaded, reason: merged with bridge method [inline-methods] */
    public void lambda$onImageDownloaded$1(HippyImageInfo hippyImageInfo, String str) {
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "onAngImageDownloaded url:" + hippyImageInfo.url);
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this.mImageCacheLock) {
            ArrayList<HippyImageInfo> remove = this.mLoadingImages.remove(hippyImageInfo.getImageCacheKey());
            if (remove != null) {
                arrayList.addAll(remove);
            }
        }
        if (arrayList.size() <= 0) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            HippyImageInfo hippyImageInfo2 = (HippyImageInfo) it.next();
            HippyDrawable createHippyDrawableByApng = createHippyDrawableByApng(hippyImageInfo, str);
            if (createHippyDrawableByApng == null) {
                hippyImageInfo2.onRequestFailInUiThread(null, "apng drawable is null");
            } else {
                hippyImageInfo2.onRequestSuccessInUiThread(createHippyDrawableByApng);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onImageDownloadFailed(HippyImageInfo hippyImageInfo, String str) {
        onImageDownloadFailed(hippyImageInfo, str, null);
    }

    private void onImageLoadSuccess(HippyImageInfo hippyImageInfo, HippyDrawable hippyDrawable) {
        synchronized (this.mImageCacheLock) {
            ArrayList<HippyImageInfo> remove = this.mLoadingImages.remove(hippyImageInfo.getImageCacheKey());
            if (remove == null) {
                return;
            }
            Iterator<HippyImageInfo> it = remove.iterator();
            while (it.hasNext()) {
                it.next().onRequestSuccessInUiThread(hippyDrawable);
            }
        }
    }

    private void startDownloadImage(HippyImageInfo hippyImageInfo, Object obj) {
        String offlineResPath = HippyOfflineAssist.getOfflineResPath(hippyImageInfo.url);
        if (!TextUtils.isEmpty(offlineResPath)) {
            onImageDownloaded(hippyImageInfo, offlineResPath);
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mRequestWidth = hippyImageInfo.reqWidth;
        obtain.mRequestHeight = hippyImageInfo.reqHeight;
        obtain.mRetryCount = 3;
        obtain.mMemoryCacheKeySuffix = "hippy";
        Bundle bundle = new Bundle();
        bundle.putBoolean("enableHttp2", HippyUtils.enableHttp2());
        obtain.mExtraInfo = bundle;
        URLDrawable drawable = URLDrawable.getDrawable(hippyImageInfo.url, obtain);
        File fileInLocal = drawable.getFileInLocal();
        if (fileInLocal != null && fileInLocal.exists()) {
            onImageDownloaded(hippyImageInfo, fileInLocal.getAbsolutePath());
        } else {
            downloadImage(hippyImageInfo, drawable, obtain);
        }
    }

    @Override // com.tencent.mtt.hippy.adapter.image.HippyImageLoader
    public void destroyIfNeed() {
        this.mIsDestroyed = true;
        synchronized (this.mImageCacheLock) {
            this.mImageCache.clear();
        }
    }

    protected void onImageDownloaded(final HippyImageInfo hippyImageInfo, final String str) {
        if (this.mIsDestroyed) {
            return;
        }
        if (hippyImageInfo != null && str != null) {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.hippy.qq.adapter.b
                @Override // java.lang.Runnable
                public final void run() {
                    HippyQQImageLoader.this.lambda$onImageDownloaded$2(str, hippyImageInfo);
                }
            }, 8, null, true);
        } else {
            QLog.e(TAG, 1, "onImageDownloaded parameters error");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onImageDownloadFailed(HippyImageInfo hippyImageInfo, String str, Throwable th5) {
        synchronized (this.mImageCacheLock) {
            ArrayList<HippyImageInfo> remove = this.mLoadingImages.remove(hippyImageInfo.getImageCacheKey());
            if (remove == null) {
                return;
            }
            Iterator<HippyImageInfo> it = remove.iterator();
            while (it.hasNext()) {
                it.next().onRequestFailInUiThread(th5, str);
            }
        }
    }

    @Override // com.tencent.mtt.supportui.adapters.image.IImageLoaderAdapter
    public void fetchImage(String str, HippyImageLoader.Callback callback, Object obj) {
        if (this.mIsDestroyed) {
            return;
        }
        HippyImageInfo hippyImageInfo = new HippyImageInfo(getUrlWithIsAvifSupport(str), obj, callback);
        if (TextUtils.isEmpty(hippyImageInfo.url)) {
            return;
        }
        hippyImageInfo.getPerformanceData().recordDataLoadStartTime();
        Bitmap imageCache = getImageCache(hippyImageInfo.getImageCacheKey());
        if (imageCache != null) {
            hippyImageInfo.onRequestSuccessInUiThread(imageCache);
            return;
        }
        synchronized (this.mImageCacheLock) {
            String imageCacheKey = hippyImageInfo.getImageCacheKey();
            ArrayList<HippyImageInfo> arrayList = this.mLoadingImages.get(imageCacheKey);
            if (arrayList == null) {
                ArrayList<HippyImageInfo> arrayList2 = new ArrayList<>();
                arrayList2.add(hippyImageInfo);
                this.mLoadingImages.put(imageCacheKey, arrayList2);
                startDownloadImage(hippyImageInfo, obj);
                return;
            }
            arrayList.add(hippyImageInfo);
        }
    }
}
