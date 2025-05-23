package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.nostra13.universalimageloader.cache.disc.DiskCache;
import com.nostra13.universalimageloader.cache.memory.MemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.ImageSize;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import com.nostra13.universalimageloader.core.assist.ViewScaleType;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import com.nostra13.universalimageloader.core.imageaware.NonViewAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.utils.ImageSizeUtils;
import com.nostra13.universalimageloader.utils.L;
import com.nostra13.universalimageloader.utils.MemoryCacheUtils;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ImageLoader {
    private static final String ERROR_INIT_CONFIG_WITH_NULL = "ImageLoader configuration can not be initialized with null";
    private static final String ERROR_NOT_INIT = "ImageLoader must be init with configuration before using";
    private static final String ERROR_WRONG_ARGUMENTS = "Wrong arguments were passed to displayImage() method (ImageView reference must not be null)";
    static final String LOG_DESTROY = "Destroy ImageLoader";
    static final String LOG_INIT_CONFIG = "Initialize ImageLoader with configuration";
    static final String LOG_LOAD_IMAGE_FROM_MEMORY_CACHE = "Load image from memory cache [%s]";
    public static final String TAG = "ImageLoader";
    private static final String WARNING_RE_INIT_CONFIG = "Try to initialize ImageLoader which had already been initialized before. To re-init ImageLoader with new configuration call ImageLoader.destroy() at first.";
    private static volatile ImageLoader instance;
    private ImageLoaderConfiguration configuration;
    private ImageLoadingListener defaultListener = new SimpleImageLoadingListener();
    private ImageLoaderEngine engine;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class SyncImageLoadingListener extends SimpleImageLoadingListener {
        private Bitmap loadedImage;

        SyncImageLoadingListener() {
        }

        public Bitmap getLoadedBitmap() {
            return this.loadedImage;
        }

        @Override // com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener, com.nostra13.universalimageloader.core.listener.ImageLoadingListener
        public void onLoadingComplete(String str, View view, Bitmap bitmap) {
            this.loadedImage = bitmap;
        }
    }

    private void checkConfiguration() {
        if (this.configuration != null) {
        } else {
            throw new IllegalStateException(ERROR_NOT_INIT);
        }
    }

    private static Handler defineHandler(DisplayImageOptions displayImageOptions) {
        Handler handler = displayImageOptions.getHandler();
        if (displayImageOptions.isSyncLoading()) {
            return null;
        }
        if (handler == null && Looper.myLooper() == Looper.getMainLooper()) {
            return new Handler();
        }
        return handler;
    }

    public static ImageLoader getInstance() {
        if (instance == null) {
            synchronized (ImageLoader.class) {
                if (instance == null) {
                    instance = new ImageLoader();
                }
            }
        }
        return instance;
    }

    public void cancelDisplayTask(ImageAware imageAware) {
        this.engine.cancelDisplayTaskFor(imageAware);
    }

    @Deprecated
    public void clearDiscCache() {
        clearDiskCache();
    }

    public void clearDiskCache() {
        checkConfiguration();
        this.configuration.diskCache.clear();
    }

    public void clearMemoryCache() {
        checkConfiguration();
        this.configuration.memoryCache.clear();
    }

    public void denyNetworkDownloads(boolean z16) {
        this.engine.denyNetworkDownloads(z16);
    }

    public void destroy() {
        if (isInited()) {
            L.d(LOG_DESTROY, new Object[0]);
            stop();
            this.configuration.diskCache.close();
            this.engine = null;
            this.configuration = null;
            return;
        }
        L.w("Trying to destroy not-initialized ImageLoader", new Object[0]);
    }

    public void displayImage(String str, ImageAware imageAware) {
        displayImage(str, imageAware, (DisplayImageOptions) null, (ImageLoadingListener) null, (ImageLoadingProgressListener) null);
    }

    @Deprecated
    public DiskCache getDiscCache() {
        return getDiskCache();
    }

    public DiskCache getDiskCache() {
        checkConfiguration();
        return this.configuration.diskCache;
    }

    public String getLoadingUriForView(ImageAware imageAware) {
        return this.engine.getLoadingUriForView(imageAware);
    }

    public MemoryCache getMemoryCache() {
        checkConfiguration();
        return this.configuration.memoryCache;
    }

    public void handleSlowNetwork(boolean z16) {
        this.engine.handleSlowNetwork(z16);
    }

    public synchronized void init(ImageLoaderConfiguration imageLoaderConfiguration) {
        if (imageLoaderConfiguration != null) {
            if (this.configuration == null) {
                L.d(LOG_INIT_CONFIG, new Object[0]);
                this.engine = new ImageLoaderEngine(imageLoaderConfiguration);
                this.configuration = imageLoaderConfiguration;
            } else {
                L.w(WARNING_RE_INIT_CONFIG, new Object[0]);
            }
        } else {
            throw new IllegalArgumentException(ERROR_INIT_CONFIG_WITH_NULL);
        }
    }

    public boolean isInited() {
        if (this.configuration != null) {
            return true;
        }
        return false;
    }

    public void loadImage(String str, ImageLoadingListener imageLoadingListener) {
        loadImage(str, null, null, imageLoadingListener, null);
    }

    public Bitmap loadImageSync(String str) {
        return loadImageSync(str, null, null);
    }

    public void pause() {
        if (isInited()) {
            this.engine.pause();
        } else {
            L.w("Trying to pause not-initialized ImageLoader", new Object[0]);
        }
    }

    public void resume() {
        if (isInited()) {
            this.engine.resume();
        } else {
            L.w("Trying to resume not-initialized ImageLoader", new Object[0]);
        }
    }

    public void setDefaultLoadingListener(ImageLoadingListener imageLoadingListener) {
        if (imageLoadingListener == null) {
            imageLoadingListener = new SimpleImageLoadingListener();
        }
        this.defaultListener = imageLoadingListener;
    }

    public void stop() {
        if (isInited()) {
            this.engine.stop();
        } else {
            L.w("Trying to stop not-initialized ImageLoader", new Object[0]);
        }
    }

    public void cancelDisplayTask(ImageView imageView) {
        this.engine.cancelDisplayTaskFor(new ImageViewAware(imageView));
    }

    public void displayImage(String str, ImageAware imageAware, ImageLoadingListener imageLoadingListener) {
        displayImage(str, imageAware, (DisplayImageOptions) null, imageLoadingListener, (ImageLoadingProgressListener) null);
    }

    public String getLoadingUriForView(ImageView imageView) {
        return this.engine.getLoadingUriForView(new ImageViewAware(imageView));
    }

    public void loadImage(String str, ImageSize imageSize, ImageLoadingListener imageLoadingListener) {
        loadImage(str, imageSize, null, imageLoadingListener, null);
    }

    public Bitmap loadImageSync(String str, DisplayImageOptions displayImageOptions) {
        return loadImageSync(str, null, displayImageOptions);
    }

    public void displayImage(String str, ImageAware imageAware, DisplayImageOptions displayImageOptions) {
        displayImage(str, imageAware, displayImageOptions, (ImageLoadingListener) null, (ImageLoadingProgressListener) null);
    }

    public void loadImage(String str, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener) {
        loadImage(str, null, displayImageOptions, imageLoadingListener, null);
    }

    public Bitmap loadImageSync(String str, ImageSize imageSize) {
        return loadImageSync(str, imageSize, null);
    }

    public void displayImage(String str, ImageAware imageAware, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener) {
        displayImage(str, imageAware, displayImageOptions, imageLoadingListener, (ImageLoadingProgressListener) null);
    }

    public void loadImage(String str, ImageSize imageSize, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener) {
        loadImage(str, imageSize, displayImageOptions, imageLoadingListener, null);
    }

    public Bitmap loadImageSync(String str, ImageSize imageSize, DisplayImageOptions displayImageOptions) {
        if (displayImageOptions == null) {
            displayImageOptions = this.configuration.defaultDisplayImageOptions;
        }
        DisplayImageOptions build = new DisplayImageOptions.Builder().cloneFrom(displayImageOptions).syncLoading(true).build();
        SyncImageLoadingListener syncImageLoadingListener = new SyncImageLoadingListener();
        loadImage(str, imageSize, build, syncImageLoadingListener);
        return syncImageLoadingListener.getLoadedBitmap();
    }

    public void displayImage(String str, ImageAware imageAware, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener, ImageLoadingProgressListener imageLoadingProgressListener) {
        displayImage(str, imageAware, displayImageOptions, null, imageLoadingListener, imageLoadingProgressListener);
    }

    public void loadImage(String str, ImageSize imageSize, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener, ImageLoadingProgressListener imageLoadingProgressListener) {
        checkConfiguration();
        if (imageSize == null) {
            imageSize = this.configuration.getMaxImageSize();
        }
        if (displayImageOptions == null) {
            displayImageOptions = this.configuration.defaultDisplayImageOptions;
        }
        displayImage(str, new NonViewAware(str, imageSize, ViewScaleType.CROP), displayImageOptions, imageLoadingListener, imageLoadingProgressListener);
    }

    public void displayImage(String str, ImageAware imageAware, DisplayImageOptions displayImageOptions, ImageSize imageSize, ImageLoadingListener imageLoadingListener, ImageLoadingProgressListener imageLoadingProgressListener) {
        checkConfiguration();
        if (imageAware != null) {
            if (imageLoadingListener == null) {
                imageLoadingListener = this.defaultListener;
            }
            ImageLoadingListener imageLoadingListener2 = imageLoadingListener;
            if (displayImageOptions == null) {
                displayImageOptions = this.configuration.defaultDisplayImageOptions;
            }
            if (TextUtils.isEmpty(str)) {
                this.engine.cancelDisplayTaskFor(imageAware);
                imageLoadingListener2.onLoadingStarted(str, imageAware.getWrappedView());
                if (displayImageOptions.shouldShowImageForEmptyUri()) {
                    imageAware.setImageDrawable(displayImageOptions.getImageForEmptyUri(this.configuration.resources));
                } else {
                    imageAware.setImageDrawable(null);
                }
                imageLoadingListener2.onLoadingComplete(str, imageAware.getWrappedView(), null);
                return;
            }
            if (imageSize == null) {
                imageSize = ImageSizeUtils.defineTargetSizeForView(imageAware, this.configuration.getMaxImageSize());
            }
            ImageSize imageSize2 = imageSize;
            String generateKey = MemoryCacheUtils.generateKey(str, imageSize2);
            this.engine.prepareDisplayTaskFor(imageAware, generateKey);
            imageLoadingListener2.onLoadingStarted(str, imageAware.getWrappedView());
            Bitmap bitmap = this.configuration.memoryCache.get(generateKey);
            if (bitmap != null && !bitmap.isRecycled()) {
                L.d(LOG_LOAD_IMAGE_FROM_MEMORY_CACHE, generateKey);
                if (displayImageOptions.shouldPostProcess()) {
                    ProcessAndDisplayImageTask processAndDisplayImageTask = new ProcessAndDisplayImageTask(this.engine, bitmap, new ImageLoadingInfo(str, imageAware, imageSize2, generateKey, displayImageOptions, imageLoadingListener2, imageLoadingProgressListener, this.engine.getLockForUri(str)), defineHandler(displayImageOptions));
                    if (displayImageOptions.isSyncLoading()) {
                        processAndDisplayImageTask.run();
                        return;
                    } else {
                        this.engine.submit(processAndDisplayImageTask);
                        return;
                    }
                }
                displayImageOptions.getDisplayer().display(bitmap, imageAware, LoadedFrom.MEMORY_CACHE);
                imageLoadingListener2.onLoadingComplete(str, imageAware.getWrappedView(), bitmap);
                return;
            }
            if (displayImageOptions.shouldShowImageOnLoading()) {
                imageAware.setImageDrawable(displayImageOptions.getImageOnLoading(this.configuration.resources));
            } else if (displayImageOptions.isResetViewBeforeLoading()) {
                imageAware.setImageDrawable(null);
            }
            LoadAndDisplayImageTask loadAndDisplayImageTask = new LoadAndDisplayImageTask(this.engine, new ImageLoadingInfo(str, imageAware, imageSize2, generateKey, displayImageOptions, imageLoadingListener2, imageLoadingProgressListener, this.engine.getLockForUri(str)), defineHandler(displayImageOptions));
            if (displayImageOptions.isSyncLoading()) {
                loadAndDisplayImageTask.run();
                return;
            } else {
                this.engine.submit(loadAndDisplayImageTask);
                return;
            }
        }
        throw new IllegalArgumentException(ERROR_WRONG_ARGUMENTS);
    }

    public void displayImage(String str, ImageView imageView) {
        displayImage(str, new ImageViewAware(imageView), (DisplayImageOptions) null, (ImageLoadingListener) null, (ImageLoadingProgressListener) null);
    }

    public void displayImage(String str, ImageView imageView, ImageSize imageSize) {
        displayImage(str, new ImageViewAware(imageView), null, imageSize, null, null);
    }

    public void displayImage(String str, ImageView imageView, DisplayImageOptions displayImageOptions) {
        displayImage(str, new ImageViewAware(imageView), displayImageOptions, (ImageLoadingListener) null, (ImageLoadingProgressListener) null);
    }

    public void displayImage(String str, ImageView imageView, ImageLoadingListener imageLoadingListener) {
        displayImage(str, new ImageViewAware(imageView), (DisplayImageOptions) null, imageLoadingListener, (ImageLoadingProgressListener) null);
    }

    public void displayImage(String str, ImageView imageView, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener) {
        displayImage(str, imageView, displayImageOptions, imageLoadingListener, (ImageLoadingProgressListener) null);
    }

    public void displayImage(String str, ImageView imageView, DisplayImageOptions displayImageOptions, ImageLoadingListener imageLoadingListener, ImageLoadingProgressListener imageLoadingProgressListener) {
        displayImage(str, new ImageViewAware(imageView), displayImageOptions, imageLoadingListener, imageLoadingProgressListener);
    }
}
