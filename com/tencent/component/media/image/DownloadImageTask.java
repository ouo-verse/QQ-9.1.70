package com.tencent.component.media.image;

import android.graphics.drawable.Drawable;
import com.tencent.component.media.IDownloader;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.utils.ImageManagerLog;
import com.tencent.sharpP.SharpPUtils;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class DownloadImageTask extends ImageTask {
    private static final String TAG = "DownloadImageTask";
    private static IDownloader mImageDownloader;
    private static int mObjectPoolSize;
    private static DownloadImageTask sPool;
    private static final Object sPoolSync;
    private DownloadImageTask next;
    private static ConcurrentHashMap<String, DownloadImageTask> mDownloadTaskRecord = new ConcurrentHashMap<>();
    private static ImageManagerEnv.ImageDownloaderListener imageDownloaderListener = new ImageManagerEnv.ImageDownloaderListener() { // from class: com.tencent.component.media.image.DownloadImageTask.1
        private void processErrorInfo(ImageKey imageKey, ImageDownloadInfo imageDownloadInfo) {
            if (imageKey != null && imageKey.options != null && imageDownloadInfo != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(ImageTaskConst.RESULT, ImageTaskConst.getImageTaskErrorDescription(imageDownloadInfo.nocacheCode));
                    jSONObject.put(ImageTaskConst.SERVER_IP, imageDownloadInfo.serverIp);
                    jSONObject.put(ImageTaskConst.CLIENT_IP, imageDownloadInfo.clientIp);
                    jSONObject.put(ImageTaskConst.NOCACHE_CODE, String.valueOf(imageDownloadInfo.nocacheCode));
                    jSONObject.put("filePath", imageKey.filePath);
                    jSONObject.put(ImageTaskConst.DOWNLOAD_DETAIL_INFO, imageDownloadInfo.downloadDetailInfo);
                } catch (JSONException e16) {
                    ImageManagerLog.e(DownloadImageTask.TAG, "onDownloadFailed, Json Exception!");
                    e16.printStackTrace();
                }
                imageKey.options.errCode = jSONObject.toString();
                ImageManagerLog.w(DownloadImageTask.TAG, "processErrorInfo, info = " + jSONObject.toString());
            }
        }

        @Override // com.tencent.component.media.ImageManagerEnv.ImageDownloaderListener
        public void onDownloadCanceled(String str) {
            String str2;
            DownloadImageTask downloadImageTask = (DownloadImageTask) DownloadImageTask.mDownloadTaskRecord.remove(str);
            ImageTracer.cancel(str);
            if (downloadImageTask != null) {
                ImageKey imageKey = downloadImageTask.mImageKey;
                if (imageKey != null && (str2 = imageKey.urlKey) != null) {
                    ImageTaskTracer.removeImageDownloadRecord(str2);
                }
                downloadImageTask.setResult(0, str);
            }
        }

        @Override // com.tencent.component.media.ImageManagerEnv.ImageDownloaderListener
        public void onDownloadFailed(String str, ImageDownloadInfo imageDownloadInfo) {
            String str2;
            int i3;
            DownloadImageTask downloadImageTask = (DownloadImageTask) DownloadImageTask.mDownloadTaskRecord.remove(str);
            ImageTracer.downloadFail(str);
            ProgressTracer.print(1001, str);
            if (downloadImageTask != null) {
                ImageKey imageKey = downloadImageTask.getImageKey();
                if (imageKey != null && imageKey.options != null && imageDownloadInfo != null) {
                    String valueOf = String.valueOf(imageDownloadInfo.failCode);
                    String valueOf2 = String.valueOf(imageDownloadInfo.retCode);
                    if (imageDownloadInfo.retCode < 0) {
                        i3 = 1;
                    } else {
                        i3 = 2;
                    }
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put(ImageTaskConst.RESULT, ImageTaskConst.getImageTaskErrorDescription(imageDownloadInfo.retCode));
                        jSONObject.put(ImageTaskConst.FAIL_CODE, valueOf);
                        jSONObject.put(ImageTaskConst.EXCEPTION_CODE, valueOf2);
                        jSONObject.put(ImageTaskConst.SERVER_IP, imageDownloadInfo.serverIp);
                        jSONObject.put(ImageTaskConst.CLIENT_IP, imageDownloadInfo.clientIp);
                        jSONObject.put(ImageTaskConst.ERROR_TYPE, String.valueOf(i3));
                        jSONObject.put("url", str);
                    } catch (JSONException e16) {
                        ImageManagerLog.e(DownloadImageTask.TAG, "onDownloadFailed, Json Exception!");
                        e16.printStackTrace();
                    }
                    imageKey.options.errCode = jSONObject.toString();
                    ImageManagerLog.e(DownloadImageTask.TAG, "onDownloadFailed, failCode=" + imageDownloadInfo.failCode + ", exceptionCode=" + imageDownloadInfo.retCode + ", serverIp=" + imageDownloadInfo.serverIp + ", clientIp=" + imageDownloadInfo.clientIp + ", contentType=" + imageDownloadInfo.contentType + "\uff0c url=" + str);
                }
                if (imageKey != null && (str2 = imageKey.urlKey) != null) {
                    ImageTaskTracer.removeImageDownloadRecord(str2);
                    ImageTaskTracer.addImageDownloadFailedRecord(imageKey.urlKey);
                }
                downloadImageTask.setResult(1, str);
            }
        }

        @Override // com.tencent.component.media.ImageManagerEnv.ImageDownloaderListener
        public void onDownloadProgress(String str, long j3, float f16) {
            String str2;
            DownloadImageTask downloadImageTask = (DownloadImageTask) DownloadImageTask.mDownloadTaskRecord.get(str);
            if (downloadImageTask != null) {
                ImageKey imageKey = downloadImageTask.mImageKey;
                if (imageKey != null && (str2 = imageKey.urlKey) != null) {
                    ImageTaskTracer.removeImageDownloadRecord(str2);
                }
                downloadImageTask.setResult(3, str, Long.valueOf(j3), Float.valueOf(f16));
            }
        }

        @Override // com.tencent.component.media.ImageManagerEnv.ImageDownloaderListener
        public void onDownloadSucceed(String str, String str2, boolean z16, ImageDownloadInfo imageDownloadInfo) {
            ImageLoader.Options options;
            String str3;
            DownloadImageTask downloadImageTask = (DownloadImageTask) DownloadImageTask.mDownloadTaskRecord.remove(str);
            if (downloadImageTask == null) {
                return;
            }
            ImageKey imageKey = downloadImageTask.mImageKey;
            if (imageKey != null && (str3 = imageKey.urlKey) != null) {
                ImageTaskTracer.removeImageDownloadRecord(str3);
            }
            boolean onDownloadSucceed = ImageManager.getInstance().onDownloadSucceed(downloadImageTask.mImageKey, str, str2, z16);
            if (onDownloadSucceed) {
                if (z16) {
                    processErrorInfo(downloadImageTask.getImageKey(), imageDownloadInfo);
                }
                downloadImageTask.setResult(2, str, str2, Boolean.valueOf(z16));
                return;
            }
            ImageKey imageKey2 = downloadImageTask.getImageKey();
            if (imageKey2 != null && (options = imageKey2.options) != null) {
                options.errCode = ImageManager.getErrorString(imageKey2, 800);
            }
            ImageManagerLog.w(DownloadImageTask.TAG, "onDownloadSucceed, canDecode = " + onDownloadSucceed + ", url=" + str);
            downloadImageTask.setResult(1, str);
        }

        @Override // com.tencent.component.media.ImageManagerEnv.ImageDownloaderListener
        public void onStreamProgress(String str, String str2) {
            ImageLoader.Options options;
            String str3;
            DownloadImageTask downloadImageTask = (DownloadImageTask) DownloadImageTask.mDownloadTaskRecord.get(str);
            ImageKey imageKey = downloadImageTask.mImageKey;
            if (imageKey != null && (str3 = imageKey.urlKey) != null) {
                ImageTaskTracer.removeImageDownloadRecord(str3);
            }
            ImageKey imageKey2 = downloadImageTask.mImageKey;
            if (imageKey2 != null && (options = imageKey2.options) != null && options.isGifPlayWhileDownloading) {
                downloadImageTask.setResult(14, str, str2);
            }
        }
    };

    static {
        initDownloader();
        sPool = null;
        sPoolSync = new Object();
        mObjectPoolSize = 0;
        clearAndInitSize();
    }

    DownloadImageTask(ImageTask imageTask) {
        super(imageTask);
        this.next = null;
    }

    public static void clearAndInitSize() {
        synchronized (sPoolSync) {
            sPool = null;
            for (int i3 = 0; i3 < ImageTask.mInitAllocatedSize; i3++) {
                DownloadImageTask downloadImageTask = new DownloadImageTask((ImageKey) null);
                downloadImageTask.next = sPool;
                sPool = downloadImageTask;
                mObjectPoolSize++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static IDownloader getDownloader() {
        return mImageDownloader;
    }

    private static void initDownloader() {
        mImageDownloader = ImageManagerEnv.g().getDownloader(imageDownloaderListener);
    }

    public static DownloadImageTask obtain(ImageTask imageTask) {
        if (ImageTask.needRecycle) {
            synchronized (sPoolSync) {
                DownloadImageTask downloadImageTask = sPool;
                if (downloadImageTask != null) {
                    sPool = downloadImageTask.next;
                    downloadImageTask.next = null;
                    mObjectPoolSize--;
                    downloadImageTask.setImageTask(imageTask);
                    return downloadImageTask;
                }
            }
        }
        return new DownloadImageTask(imageTask);
    }

    @Override // com.tencent.component.media.image.ImageTask
    public /* bridge */ /* synthetic */ void cancel() {
        super.cancel();
    }

    @Override // com.tencent.component.media.image.ImageTask
    public void excuteTask() {
        boolean z16;
        Drawable drawbleFromCache = ImageManager.getInstance().getDrawbleFromCache(this.mImageKey);
        if (drawbleFromCache != null) {
            setResult(11, drawbleFromCache);
            return;
        }
        ImageManager.getInstance().imageKeyFilePathCheck(this.mImageKey);
        File file = new File(this.mImageKey.filePath);
        SharpPUtils.deleteSharppCacheFileIfNessary(file, this.mImageKey.url);
        SharpPUtils.checkNotSharppCacheFileIfNessary(file, this.mImageKey.url);
        if (file.exists()) {
            setResult(12, new Object[0]);
            return;
        }
        boolean canDownloadImage = ImageManager.getInstance().canDownloadImage(getImageKey());
        if (!canDownloadImage) {
            ImageKey imageKey = this.mImageKey;
            ImageLoader.Options options = imageKey.options;
            if (options != null) {
                options.errCode = ImageManager.getErrorString(imageKey, 801);
            }
            ImageManagerLog.e(TAG, "image canDownload=" + canDownloadImage + ", url=" + this.mImageKey.url);
            setResult(1, this.mImageKey.url);
            return;
        }
        ImageKey imageKey2 = this.mImageKey;
        if (imageKey2.isNetworkUrl) {
            ImageLoader.Options options2 = imageKey2.options;
            if (options2 == null) {
                z16 = true;
            } else {
                z16 = options2.priority;
            }
            String str = imageKey2.url;
            if (ImageManagerEnv.g().enableSocketMonitor()) {
                str = ImageManagerEnv.g().getSocketMonitorUrl(str, this.mImageKey.options);
            }
            if (!ImageManagerEnv.g().isSupportSharpp()) {
                str = SharpPUtils.getWebpUrl(str);
                ImageManagerLog.w(TAG, "sharpp is not support,transfer to webp url");
            }
            mDownloadTaskRecord.put(str, this);
            ImageTaskTracer.addImageDownloadRecord(this.mImageKey.urlKey);
            ImageTracer.startDownlaod(this.mImageKey.url);
            ProgressTracer.print(1, this.mImageKey.urlKey);
            mImageDownloader.download(str, this.mImageKey.filePath, z16);
            return;
        }
        if (ImageManagerEnv.g().needCheckAvatar() && this.mImageKey.isAvatarUrl()) {
            mDownloadTaskRecord.put(this.mImageKey.url, this);
            ImageTaskTracer.addImageDownloadRecord(this.mImageKey.urlKey);
            ProgressTracer.print(1, this.mImageKey.urlKey);
            mImageDownloader.download(this.mImageKey.url, "", false);
            return;
        }
        ImageTask imageTask = this.mNextTask;
        if (imageTask != null) {
            imageTask.excuteTask();
            return;
        }
        ImageKey imageKey3 = this.mImageKey;
        ImageLoader.Options options3 = imageKey3.options;
        if (options3 != null) {
            options3.errCode = ImageManager.getErrorString(imageKey3, 802);
        }
        setResult(1, this.mImageKey.url);
    }

    @Override // com.tencent.component.media.image.ImageTask
    public /* bridge */ /* synthetic */ ImageKey getImageKey() {
        return super.getImageKey();
    }

    @Override // com.tencent.component.media.image.ImageTask
    public /* bridge */ /* synthetic */ ImageTask getNextTask() {
        return super.getNextTask();
    }

    @Override // com.tencent.component.media.image.ImageTask
    public /* bridge */ /* synthetic */ ImageTask getPreviousTask() {
        return super.getPreviousTask();
    }

    @Override // com.tencent.component.media.image.ImageTask
    public /* bridge */ /* synthetic */ boolean isCanceled() {
        return super.isCanceled();
    }

    @Override // com.tencent.component.media.image.ImageTask
    public void recycle() {
        if (!ImageTask.needRecycle) {
            return;
        }
        reset();
        synchronized (sPoolSync) {
            int i3 = mObjectPoolSize;
            if (i3 < 50) {
                this.next = sPool;
                sPool = this;
                mObjectPoolSize = i3 + 1;
            }
        }
    }

    DownloadImageTask(ImageKey imageKey) {
        super(imageKey);
        this.next = null;
    }

    public static DownloadImageTask obtain(ImageKey imageKey) {
        if (ImageTask.needRecycle) {
            synchronized (sPoolSync) {
                DownloadImageTask downloadImageTask = sPool;
                if (downloadImageTask != null) {
                    sPool = downloadImageTask.next;
                    downloadImageTask.next = null;
                    mObjectPoolSize--;
                    downloadImageTask.setImageKey(imageKey);
                    return downloadImageTask;
                }
            }
        }
        return new DownloadImageTask(imageKey);
    }

    @Override // com.tencent.component.media.image.ImageTask
    protected void onResult(int i3, Object... objArr) {
    }
}
