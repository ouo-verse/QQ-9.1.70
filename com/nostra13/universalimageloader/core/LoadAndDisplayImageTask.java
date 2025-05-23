package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.decode.ImageDecoder;
import com.nostra13.universalimageloader.core.decode.ImageDecodingInfo;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.utils.IoUtils;
import com.nostra13.universalimageloader.utils.L;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class LoadAndDisplayImageTask implements Runnable, IoUtils.CopyListener {
    private static final String ERROR_NO_IMAGE_STREAM = "No stream for image [%s]";
    private static final String ERROR_POST_PROCESSOR_NULL = "Post-processor returned null [%s]";
    private static final String ERROR_PRE_PROCESSOR_NULL = "Pre-processor returned null [%s]";
    private static final String ERROR_PROCESSOR_FOR_DISK_CACHE_NULL = "Bitmap processor for disk cache returned null [%s]";
    private static final String LOG_CACHE_IMAGE_IN_MEMORY = "Cache image in memory [%s]";
    private static final String LOG_CACHE_IMAGE_ON_DISK = "Cache image on disk [%s]";
    private static final String LOG_DELAY_BEFORE_LOADING = "Delay %d ms before loading...  [%s]";
    private static final String LOG_GET_IMAGE_FROM_MEMORY_CACHE_AFTER_WAITING = "...Get cached bitmap from memory after waiting. [%s]";
    private static final String LOG_LOAD_IMAGE_FROM_DISK_CACHE = "Load image from disk cache [%s]";
    private static final String LOG_LOAD_IMAGE_FROM_NETWORK = "Load image from network [%s]";
    private static final String LOG_POSTPROCESS_IMAGE = "PostProcess image before displaying [%s]";
    private static final String LOG_PREPROCESS_IMAGE = "PreProcess image before caching in memory [%s]";
    private static final String LOG_PROCESS_IMAGE_BEFORE_CACHE_ON_DISK = "Process image before cache on disk [%s]";
    private static final String LOG_RESIZE_CACHED_IMAGE_FILE = "Resize image in disk cache [%s]";
    private static final String LOG_RESUME_AFTER_PAUSE = ".. Resume loading [%s]";
    private static final String LOG_START_DISPLAY_IMAGE_TASK = "Start display image task [%s]";
    private static final String LOG_TASK_CANCELLED_IMAGEAWARE_COLLECTED = "ImageAware was collected by GC. Task is cancelled. [%s]";
    private static final String LOG_TASK_CANCELLED_IMAGEAWARE_REUSED = "ImageAware is reused for another image. Task is cancelled. [%s]";
    private static final String LOG_TASK_INTERRUPTED = "Task was interrupted [%s]";
    private static final String LOG_WAITING_FOR_IMAGE_LOADED = "Image already is loading. Waiting... [%s]";
    private static final String LOG_WAITING_FOR_RESUME = "ImageLoader is paused. Waiting...  [%s]";
    private final ImageLoaderConfiguration configuration;
    private final ImageDecoder decoder;
    private final ImageDownloader downloader;
    private final ImageLoaderEngine engine;
    private final Handler handler;
    final ImageAware imageAware;
    private final ImageLoadingInfo imageLoadingInfo;
    final ImageLoadingListener listener;
    private LoadedFrom loadedFrom = LoadedFrom.NETWORK;
    private final String memoryCacheKey;
    private final ImageDownloader networkDeniedDownloader;
    final DisplayImageOptions options;
    final ImageLoadingProgressListener progressListener;
    private final ImageDownloader slowNetworkDownloader;
    private final boolean syncLoading;
    private final ImageSize targetSize;
    final String uri;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class TaskCancelledException extends Exception {
        TaskCancelledException() {
        }
    }

    public LoadAndDisplayImageTask(ImageLoaderEngine imageLoaderEngine, ImageLoadingInfo imageLoadingInfo, Handler handler) {
        this.engine = imageLoaderEngine;
        this.imageLoadingInfo = imageLoadingInfo;
        this.handler = handler;
        ImageLoaderConfiguration imageLoaderConfiguration = imageLoaderEngine.configuration;
        this.configuration = imageLoaderConfiguration;
        this.downloader = imageLoaderConfiguration.downloader;
        this.networkDeniedDownloader = imageLoaderConfiguration.networkDeniedDownloader;
        this.slowNetworkDownloader = imageLoaderConfiguration.slowNetworkDownloader;
        this.decoder = imageLoaderConfiguration.decoder;
        this.uri = imageLoadingInfo.uri;
        this.memoryCacheKey = imageLoadingInfo.memoryCacheKey;
        this.imageAware = imageLoadingInfo.imageAware;
        this.targetSize = imageLoadingInfo.targetSize;
        DisplayImageOptions displayImageOptions = imageLoadingInfo.options;
        this.options = displayImageOptions;
        this.listener = imageLoadingInfo.listener;
        this.progressListener = imageLoadingInfo.progressListener;
        this.syncLoading = displayImageOptions.isSyncLoading();
    }

    private void checkTaskInterrupted() throws TaskCancelledException {
        if (!isTaskInterrupted()) {
        } else {
            throw new TaskCancelledException();
        }
    }

    private void checkTaskNotActual() throws TaskCancelledException {
        checkViewCollected();
        checkViewReused();
    }

    private void checkViewCollected() throws TaskCancelledException {
        if (!isViewCollected()) {
        } else {
            throw new TaskCancelledException();
        }
    }

    private void checkViewReused() throws TaskCancelledException {
        if (!isViewReused()) {
        } else {
            throw new TaskCancelledException();
        }
    }

    private Bitmap decodeImage(String str) throws IOException {
        return this.decoder.decode(new ImageDecodingInfo(this.memoryCacheKey, str, this.uri, this.targetSize, this.imageAware.getScaleType(), getDownloader(), this.options));
    }

    private boolean delayIfNeed() {
        if (!this.options.shouldDelayBeforeLoading()) {
            return false;
        }
        L.d(LOG_DELAY_BEFORE_LOADING, Integer.valueOf(this.options.getDelayBeforeLoading()), this.memoryCacheKey);
        try {
            LockMethodProxy.sleep(this.options.getDelayBeforeLoading());
            return isTaskNotActual();
        } catch (InterruptedException unused) {
            L.e(LOG_TASK_INTERRUPTED, this.memoryCacheKey);
            return true;
        }
    }

    private boolean downloadImage() throws IOException {
        InputStream stream = getDownloader().getStream(this.uri, this.options.getExtraForDownloader());
        if (stream == null) {
            L.e(ERROR_NO_IMAGE_STREAM, this.memoryCacheKey);
            return false;
        }
        try {
            return this.configuration.diskCache.save(this.uri, stream, this);
        } finally {
            IoUtils.closeSilently(stream);
        }
    }

    private void fireCancelEvent() {
        if (!this.syncLoading && !isTaskInterrupted()) {
            runTask(new Runnable() { // from class: com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.3
                @Override // java.lang.Runnable
                public void run() {
                    LoadAndDisplayImageTask loadAndDisplayImageTask = LoadAndDisplayImageTask.this;
                    loadAndDisplayImageTask.listener.onLoadingCancelled(loadAndDisplayImageTask.uri, loadAndDisplayImageTask.imageAware.getWrappedView());
                }
            }, false, this.handler, this.engine);
        }
    }

    private void fireFailEvent(final FailReason.FailType failType, final Throwable th5) {
        if (!this.syncLoading && !isTaskInterrupted() && !isTaskNotActual()) {
            runTask(new Runnable() { // from class: com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.2
                @Override // java.lang.Runnable
                public void run() {
                    if (LoadAndDisplayImageTask.this.options.shouldShowImageOnFail()) {
                        LoadAndDisplayImageTask loadAndDisplayImageTask = LoadAndDisplayImageTask.this;
                        loadAndDisplayImageTask.imageAware.setImageDrawable(loadAndDisplayImageTask.options.getImageOnFail(loadAndDisplayImageTask.configuration.resources));
                    }
                    LoadAndDisplayImageTask loadAndDisplayImageTask2 = LoadAndDisplayImageTask.this;
                    loadAndDisplayImageTask2.listener.onLoadingFailed(loadAndDisplayImageTask2.uri, loadAndDisplayImageTask2.imageAware.getWrappedView(), new FailReason(failType, th5));
                }
            }, false, this.handler, this.engine);
        }
    }

    private boolean fireProgressEvent(final int i3, final int i16) {
        if (isTaskInterrupted() || isTaskNotActual()) {
            return false;
        }
        if (this.progressListener != null) {
            runTask(new Runnable() { // from class: com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.1
                @Override // java.lang.Runnable
                public void run() {
                    LoadAndDisplayImageTask loadAndDisplayImageTask = LoadAndDisplayImageTask.this;
                    loadAndDisplayImageTask.progressListener.onProgressUpdate(loadAndDisplayImageTask.uri, loadAndDisplayImageTask.imageAware.getWrappedView(), i3, i16);
                }
            }, false, this.handler, this.engine);
            return true;
        }
        return true;
    }

    private ImageDownloader getDownloader() {
        if (this.engine.isNetworkDenied()) {
            return this.networkDeniedDownloader;
        }
        if (this.engine.isSlowNetwork()) {
            return this.slowNetworkDownloader;
        }
        return this.downloader;
    }

    private boolean isTaskInterrupted() {
        if (!Thread.interrupted()) {
            return false;
        }
        L.d(LOG_TASK_INTERRUPTED, this.memoryCacheKey);
        return true;
    }

    private boolean isTaskNotActual() {
        if (!isViewCollected() && !isViewReused()) {
            return false;
        }
        return true;
    }

    private boolean isViewCollected() {
        if (!this.imageAware.isCollected()) {
            return false;
        }
        L.d(LOG_TASK_CANCELLED_IMAGEAWARE_COLLECTED, this.memoryCacheKey);
        return true;
    }

    private boolean isViewReused() {
        if (!(!this.memoryCacheKey.equals(this.engine.getLoadingUriForView(this.imageAware)))) {
            return false;
        }
        L.d(LOG_TASK_CANCELLED_IMAGEAWARE_REUSED, this.memoryCacheKey);
        return true;
    }

    private boolean resizeAndSaveImage(int i3, int i16) throws IOException {
        File file = this.configuration.diskCache.get(this.uri);
        if (file == null || !file.exists()) {
            return false;
        }
        Bitmap decode = this.decoder.decode(new ImageDecodingInfo(this.memoryCacheKey, ImageDownloader.Scheme.FILE.wrap(file.getAbsolutePath()), this.uri, new ImageSize(i3, i16), ViewScaleType.FIT_INSIDE, getDownloader(), new DisplayImageOptions.Builder().cloneFrom(this.options).imageScaleType(ImageScaleType.IN_SAMPLE_INT).build()));
        if (decode != null && this.configuration.processorForDiskCache != null) {
            L.d(LOG_PROCESS_IMAGE_BEFORE_CACHE_ON_DISK, this.memoryCacheKey);
            decode = this.configuration.processorForDiskCache.process(decode);
            if (decode == null) {
                L.e(ERROR_PROCESSOR_FOR_DISK_CACHE_NULL, this.memoryCacheKey);
            }
        }
        if (decode == null) {
            return false;
        }
        boolean save = this.configuration.diskCache.save(this.uri, decode);
        decode.recycle();
        return save;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void runTask(Runnable runnable, boolean z16, Handler handler, ImageLoaderEngine imageLoaderEngine) {
        if (z16) {
            runnable.run();
        } else if (handler == null) {
            imageLoaderEngine.fireCallback(runnable);
        } else {
            handler.post(runnable);
        }
    }

    private boolean tryCacheImageOnDisk() throws TaskCancelledException {
        L.d(LOG_CACHE_IMAGE_ON_DISK, this.memoryCacheKey);
        try {
            boolean downloadImage = downloadImage();
            if (downloadImage) {
                ImageLoaderConfiguration imageLoaderConfiguration = this.configuration;
                int i3 = imageLoaderConfiguration.maxImageWidthForDiskCache;
                int i16 = imageLoaderConfiguration.maxImageHeightForDiskCache;
                if (i3 > 0 || i16 > 0) {
                    L.d(LOG_RESIZE_CACHED_IMAGE_FILE, this.memoryCacheKey);
                    resizeAndSaveImage(i3, i16);
                }
            }
            return downloadImage;
        } catch (IOException e16) {
            L.e(e16);
            return false;
        }
    }

    private Bitmap tryLoadBitmap() throws TaskCancelledException {
        Bitmap bitmap;
        File file;
        Bitmap bitmap2 = null;
        try {
            try {
                File file2 = this.configuration.diskCache.get(this.uri);
                if (file2 != null && file2.exists() && file2.length() > 0) {
                    L.d(LOG_LOAD_IMAGE_FROM_DISK_CACHE, this.memoryCacheKey);
                    this.loadedFrom = LoadedFrom.DISC_CACHE;
                    checkTaskNotActual();
                    bitmap = decodeImage(ImageDownloader.Scheme.FILE.wrap(file2.getAbsolutePath()));
                } else {
                    bitmap = null;
                }
                if (bitmap != null) {
                    try {
                        if (bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
                            return bitmap;
                        }
                    } catch (IOException e16) {
                        Bitmap bitmap3 = bitmap;
                        e = e16;
                        bitmap2 = bitmap3;
                        L.e(e);
                        fireFailEvent(FailReason.FailType.IO_ERROR, e);
                        return bitmap2;
                    } catch (IllegalStateException unused) {
                        fireFailEvent(FailReason.FailType.NETWORK_DENIED, null);
                        return bitmap;
                    } catch (OutOfMemoryError e17) {
                        Bitmap bitmap4 = bitmap;
                        e = e17;
                        bitmap2 = bitmap4;
                        L.e(e);
                        fireFailEvent(FailReason.FailType.OUT_OF_MEMORY, e);
                        return bitmap2;
                    } catch (Throwable th5) {
                        Bitmap bitmap5 = bitmap;
                        th = th5;
                        bitmap2 = bitmap5;
                        L.e(th);
                        fireFailEvent(FailReason.FailType.UNKNOWN, th);
                        return bitmap2;
                    }
                }
                L.d(LOG_LOAD_IMAGE_FROM_NETWORK, this.memoryCacheKey);
                this.loadedFrom = LoadedFrom.NETWORK;
                String str = this.uri;
                if (this.options.isCacheOnDisk() && tryCacheImageOnDisk() && (file = this.configuration.diskCache.get(this.uri)) != null) {
                    str = ImageDownloader.Scheme.FILE.wrap(file.getAbsolutePath());
                }
                checkTaskNotActual();
                bitmap = decodeImage(str);
                if (bitmap == null || bitmap.getWidth() <= 0 || bitmap.getHeight() <= 0) {
                    fireFailEvent(FailReason.FailType.DECODING_ERROR, null);
                    return bitmap;
                }
                return bitmap;
            } catch (IOException e18) {
                e = e18;
            } catch (IllegalStateException unused2) {
                bitmap = null;
            } catch (OutOfMemoryError e19) {
                e = e19;
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (TaskCancelledException e26) {
            throw e26;
        }
    }

    private boolean waitIfPaused() {
        AtomicBoolean pause = this.engine.getPause();
        if (pause.get()) {
            synchronized (this.engine.getPauseLock()) {
                if (pause.get()) {
                    L.d(LOG_WAITING_FOR_RESUME, this.memoryCacheKey);
                    try {
                        LockMethodProxy.wait(this.engine.getPauseLock());
                        L.d(LOG_RESUME_AFTER_PAUSE, this.memoryCacheKey);
                    } catch (InterruptedException unused) {
                        L.e(LOG_TASK_INTERRUPTED, this.memoryCacheKey);
                        return true;
                    }
                }
            }
        }
        return isTaskNotActual();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getLoadingUri() {
        return this.uri;
    }

    @Override // com.nostra13.universalimageloader.utils.IoUtils.CopyListener
    public boolean onBytesCopied(int i3, int i16) {
        if (!this.syncLoading && !fireProgressEvent(i3, i16)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00d9 A[Catch: all -> 0x0103, TaskCancelledException -> 0x0105, Merged into TryCatch #1 {all -> 0x0103, TaskCancelledException -> 0x0105, blocks: (B:13:0x0035, B:15:0x0044, B:18:0x004b, B:20:0x00b9, B:22:0x00c1, B:24:0x00d9, B:25:0x00e5, B:29:0x005c, B:33:0x0066, B:35:0x0074, B:37:0x008c, B:39:0x009a, B:41:0x00a2, B:42:0x0105), top: B:12:0x0035 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        if (waitIfPaused() || delayIfNeed()) {
            return;
        }
        ReentrantLock reentrantLock = this.imageLoadingInfo.loadFromUriLock;
        L.d(LOG_START_DISPLAY_IMAGE_TASK, this.memoryCacheKey);
        if (reentrantLock.isLocked()) {
            L.d(LOG_WAITING_FOR_IMAGE_LOADED, this.memoryCacheKey);
        }
        reentrantLock.lock();
        try {
            checkTaskNotActual();
            Bitmap bitmap = this.configuration.memoryCache.get(this.memoryCacheKey);
            if (bitmap != null && !bitmap.isRecycled()) {
                this.loadedFrom = LoadedFrom.MEMORY_CACHE;
                L.d(LOG_GET_IMAGE_FROM_MEMORY_CACHE_AFTER_WAITING, this.memoryCacheKey);
                if (bitmap != null && this.options.shouldPostProcess()) {
                    L.d(LOG_POSTPROCESS_IMAGE, this.memoryCacheKey);
                    bitmap = this.options.getPostProcessor().process(bitmap);
                    if (bitmap == null) {
                        L.e(ERROR_POST_PROCESSOR_NULL, this.memoryCacheKey);
                    }
                }
                checkTaskNotActual();
                checkTaskInterrupted();
                reentrantLock.unlock();
                runTask(new DisplayBitmapTask(bitmap, this.imageLoadingInfo, this.engine, this.loadedFrom), this.syncLoading, this.handler, this.engine);
            }
            bitmap = tryLoadBitmap();
            if (bitmap == null) {
                return;
            }
            checkTaskNotActual();
            checkTaskInterrupted();
            if (this.options.shouldPreProcess()) {
                L.d(LOG_PREPROCESS_IMAGE, this.memoryCacheKey);
                bitmap = this.options.getPreProcessor().process(bitmap);
                if (bitmap == null) {
                    L.e(ERROR_PRE_PROCESSOR_NULL, this.memoryCacheKey);
                }
            }
            if (bitmap != null && this.options.isCacheInMemory()) {
                L.d(LOG_CACHE_IMAGE_IN_MEMORY, this.memoryCacheKey);
                this.configuration.memoryCache.put(this.memoryCacheKey, bitmap);
            }
            if (bitmap != null) {
                L.d(LOG_POSTPROCESS_IMAGE, this.memoryCacheKey);
                bitmap = this.options.getPostProcessor().process(bitmap);
                if (bitmap == null) {
                }
            }
            checkTaskNotActual();
            checkTaskInterrupted();
            reentrantLock.unlock();
            runTask(new DisplayBitmapTask(bitmap, this.imageLoadingInfo, this.engine, this.loadedFrom), this.syncLoading, this.handler, this.engine);
        } catch (TaskCancelledException unused) {
            fireCancelEvent();
        } finally {
            reentrantLock.unlock();
        }
    }
}
