package com.tencent.component.media.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.component.media.annotation.Public;
import com.tencent.component.media.utils.BaseHandler;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ImageLoader {
    public static final String AVATAR_URL_PREFIX = "avatar://";
    private static ImageLoader sInstance;
    private BaseHandler mMainHandler = new BaseHandler(Looper.getMainLooper());

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface ImageDownloadListener {
        void onDownloadCanceled(String str);

        void onDownloadFailed(String str);

        void onDownloadProgress(String str, long j3, float f16);

        void onDownloadSucceed(String str);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface ImageLoadListener {
        @Public
        void onImageCanceled(String str, Options options);

        @Public
        void onImageFailed(String str, Options options);

        @Public
        void onImageLoaded(String str, Drawable drawable, Options options);

        @Public
        void onImageProgress(String str, float f16, Options options);
    }

    /* compiled from: P */
    @Public
    /* loaded from: classes5.dex */
    public static class ImageOptions implements Cloneable {
        public static final int DEFAULT_CLIP_HEIGHT = -1;
        public static final int DEFAULT_CLIP_WIDTH = -1;
        public static final boolean DEFAULT_JUST_COVER = true;
        public static final boolean DEFAULT_PREFER_QUALITY = false;
        public static final boolean DEFAULT_PRIORITY = true;
        public static final boolean DEFAULT_TRY_STREAM = false;
        public static final Bitmap.Config DEFAULT_IMAGE_CONFIG = Bitmap.Config.RGB_565;
        public static final SecondImageProcessor DEFAULT_PROCESSOR = null;
        public int clipWidth = -1;
        public int clipHeight = -1;
        public boolean preferQuality = false;
        public boolean priority = true;
        public boolean justCover = true;
        public Bitmap.Config imageConfig = DEFAULT_IMAGE_CONFIG;
        public SecondImageProcessor processor = DEFAULT_PROCESSOR;
        public boolean needShowGifAnimation = false;
        public boolean needCache = true;
        public boolean isNeedPieceLoad = false;

        public final ImageOptions copy() {
            try {
                return (ImageOptions) clone();
            } catch (CloneNotSupportedException e16) {
                e16.printStackTrace();
                return null;
            }
        }

        public final boolean equals(Object obj) {
            return super.equals(obj);
        }

        public final int hashCode() {
            return super.hashCode();
        }
    }

    /* compiled from: P */
    @Public
    /* loaded from: classes5.dex */
    public static class Options extends ImageOptions {
        public static final int DEFAULT_GIF_TYPE = 2;
        public static final int DEFAULT_IMAGE_TYPE = 1;
        public static final int DEFAULT_PANORAMA_ORIG_TYPE = 4;
        public static final int DEFAULT_PANORAMA_THUMB_TYPE = 3;
        private static final long DEFAULT_PHOTO_DELAY_TIME_IN_MS = 200;
        public static final int DEFAULT_TYPE = 0;
        public static final boolean DEFAULT_USE_MAIN_THREAD = false;
        private static LinkedList<Options> mObjectCache;
        public int arg1;
        public int arg2;

        @Public
        public String errCode;
        public ImageProcessor extraProcessor;
        public Object obj;
        public ArrayList<String> photoList;
        public long totalSize;
        public String type;
        public WeakReference<Drawable> watermarkDrawableRef;
        public boolean needRecycle = false;
        public boolean needCallBackProcessPercent = false;

        @Public
        public boolean useMainThread = false;
        public boolean isGifPlayWhileDownloading = false;
        public int mImageType = 0;
        public String fileRootPath = null;
        public boolean isPreDecode = false;
        public boolean needShowPhotoGifAnimation = false;
        public long photoDelayTimeInMs = DEFAULT_PHOTO_DELAY_TIME_IN_MS;
        public boolean disableHitRateReport = false;
        public boolean useArgb8888 = false;
        public boolean cropHead = false;
        public float cropHwRation = 1.0f;

        static {
            LinkedList<Options> linkedList = new LinkedList<>();
            mObjectCache = linkedList;
            synchronized (linkedList) {
                for (int i3 = 0; i3 < 50; i3++) {
                    mObjectCache.add(new Options());
                }
            }
        }

        @Public
        public Options() {
        }

        public static Options copy(Options options) {
            if (options == null) {
                return null;
            }
            Options obtain = obtain();
            obtain.needRecycle = options.needRecycle;
            obtain.useMainThread = options.useMainThread;
            obtain.extraProcessor = options.extraProcessor;
            obtain.obj = options.obj;
            obtain.arg1 = options.arg1;
            obtain.arg2 = options.arg2;
            obtain.totalSize = options.totalSize;
            obtain.clipWidth = options.clipWidth;
            obtain.clipHeight = options.clipHeight;
            obtain.preferQuality = options.preferQuality;
            obtain.priority = options.priority;
            obtain.justCover = options.justCover;
            obtain.needCallBackProcessPercent = options.needCallBackProcessPercent;
            obtain.needShowGifAnimation = options.needShowGifAnimation;
            obtain.imageConfig = options.imageConfig;
            obtain.processor = options.processor;
            obtain.fileRootPath = options.fileRootPath;
            obtain.isPreDecode = options.isPreDecode;
            obtain.type = options.type;
            obtain.needShowPhotoGifAnimation = options.needShowPhotoGifAnimation;
            obtain.photoDelayTimeInMs = options.photoDelayTimeInMs;
            obtain.photoList = options.photoList;
            obtain.isGifPlayWhileDownloading = options.isGifPlayWhileDownloading;
            obtain.mImageType = options.mImageType;
            obtain.errCode = options.errCode;
            obtain.watermarkDrawableRef = options.watermarkDrawableRef;
            obtain.needCache = options.needCache;
            obtain.isNeedPieceLoad = options.isNeedPieceLoad;
            obtain.useArgb8888 = options.useArgb8888;
            obtain.cropHead = options.cropHead;
            obtain.cropHwRation = options.cropHwRation;
            return obtain;
        }

        public static Options obtain() {
            Options poll;
            synchronized (mObjectCache) {
                poll = mObjectCache.poll();
            }
            if (poll == null) {
                poll = new Options();
            }
            poll.needRecycle = true;
            return poll;
        }

        public void recycle() {
            if (this.needRecycle) {
                this.useMainThread = false;
                this.extraProcessor = null;
                this.obj = null;
                this.arg1 = 0;
                this.arg2 = 0;
                this.totalSize = 0L;
                this.clipWidth = -1;
                this.clipHeight = -1;
                this.preferQuality = false;
                this.priority = true;
                this.justCover = true;
                this.needCallBackProcessPercent = false;
                this.needShowGifAnimation = false;
                this.imageConfig = ImageOptions.DEFAULT_IMAGE_CONFIG;
                this.processor = ImageOptions.DEFAULT_PROCESSOR;
                this.fileRootPath = null;
                this.type = null;
                this.needShowPhotoGifAnimation = false;
                this.photoDelayTimeInMs = DEFAULT_PHOTO_DELAY_TIME_IN_MS;
                this.photoList = null;
                this.isGifPlayWhileDownloading = false;
                this.mImageType = 0;
                this.isPreDecode = false;
                this.errCode = null;
                this.watermarkDrawableRef = null;
                this.needCache = true;
                this.useArgb8888 = false;
                this.cropHead = false;
                this.cropHwRation = 1.0f;
                synchronized (mObjectCache) {
                    mObjectCache.add(this);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface StreamDownloadListener {
        void onApplyToImage(String str, Drawable drawable, Options options);

        void onDownloadCanceled(String str, String str2, String str3);

        void onDownloadFailed(String str, String str2, String str3);

        void onDownloadProgress(String str, String str2, String str3, byte[] bArr, int i3);

        void onDownloadSucceed(String str, String str2, String str3);
    }

    public ImageLoader() {
        ImageManager.getInstance();
    }

    @Public
    public static ImageLoader getInstance(Context context) {
        if (sInstance == null) {
            synchronized (ImageLoader.class) {
                if (sInstance == null) {
                    sInstance = new ImageLoader();
                }
            }
        }
        return sInstance;
    }

    public static void onListViewIdle() {
        ImageManager.getInstance().onListViewIdle();
    }

    public void cancel() {
    }

    public void clear(String str) {
        ImageManager.getInstance().clear(str);
    }

    public void downloadImage(String str, ImageDownloadListener imageDownloadListener, Options options) {
        ImageManager.getInstance().getImage(str, (ImageLoadListener) null, options, (byte) 2, imageDownloadListener);
    }

    public void downloadImageOnly(String str, ImageDownloadListener imageDownloadListener) {
        ImageManager.getInstance().getImage(str, (ImageLoadListener) null, (Options) null, (byte) 3, imageDownloadListener);
    }

    @Public
    public File getImageFile(String str) {
        return getImageFile(str, null);
    }

    @Public
    public File getImageFileForSuperResolution(String str) {
        return ImageManager.getInstance().getImageFileForSuperResolution(str);
    }

    @Public
    public Drawable loadImage(String str, Options options) {
        return ImageManager.getInstance().getImage(str, (ImageLoadListener) null, options, (byte) 0, (ImageDownloadListener) null);
    }

    @Public
    public void loadImageAsync(String str, ImageLoadListener imageLoadListener) {
        loadImageAsync(str, imageLoadListener, null);
    }

    public Drawable loadImageDownloadOnly(String str, ImageLoadListener imageLoadListener, Options options) {
        return ImageManager.getInstance().getImage(str, imageLoadListener, options, (byte) 3, (ImageDownloadListener) null);
    }

    public Drawable loadImageSync(String str) {
        return loadImageSync(str, null);
    }

    public void removeImageFile(String str) {
        removeImageFile(str, null);
    }

    public void cancel(String str, ImageLoadListener imageLoadListener, Options options) {
        ImageManager.getInstance().cancel(str, imageLoadListener, options);
    }

    @Public
    public void clear(String str, Options options) {
        ImageManager.getInstance().clear(str, options);
    }

    public void downloadImage(ImageUrl imageUrl, String str, ImageDownloadListener imageDownloadListener, Options options) {
        if (imageUrl != null) {
            ImageManager.getInstance().getImage(imageUrl, (ImageLoadListener) null, options, (byte) 2, imageDownloadListener);
        } else {
            downloadImage(str, imageDownloadListener, options);
        }
    }

    public Drawable downloadImageOnly(String str, ImageDownloadListener imageDownloadListener, Options options) {
        return ImageManager.getInstance().getImage(str, (ImageLoadListener) null, options, (byte) 3, imageDownloadListener);
    }

    @Public
    public File getImageFile(String str, Options options) {
        return ImageManager.getInstance().getImageFile(str, options);
    }

    public Drawable loadImage(ImageUrl imageUrl, String str, Options options) {
        if (imageUrl != null) {
            return ImageManager.getInstance().getImage(imageUrl, (ImageLoadListener) null, options, (byte) 0, (ImageDownloadListener) null);
        }
        return loadImage(str, options);
    }

    @Public
    public void loadImageAsync(String str, ImageLoadListener imageLoadListener, Options options) {
        loadImageAsync(null, str, imageLoadListener, options);
    }

    public Drawable loadImageDownloadOnly(ImageUrl imageUrl, String str, ImageLoadListener imageLoadListener, Options options) {
        if (imageUrl != null) {
            return ImageManager.getInstance().getImage(imageUrl, imageLoadListener, options, (byte) 3, (ImageDownloadListener) null);
        }
        return loadImageDownloadOnly(str, imageLoadListener, options);
    }

    public Drawable loadImageSync(String str, Options options) {
        return loadImageSync(str, null, options);
    }

    public void removeImageFile(String str, Options options) {
        ImageManager.getInstance().removeImageFile(str, options);
    }

    public void clear(boolean z16) {
        ImageManager.getInstance().clear(z16);
    }

    public Drawable downloadImageOnly(String str, ImageLoadListener imageLoadListener, ImageDownloadListener imageDownloadListener, Options options) {
        return ImageManager.getInstance().getImage(str, imageLoadListener, options, (byte) 3, imageDownloadListener);
    }

    public void loadImageAsync(final ImageUrl imageUrl, final String str, final ImageLoadListener imageLoadListener, final Options options) {
        Drawable image;
        if (imageUrl != null && !TextUtils.isEmpty(imageUrl.url)) {
            image = ImageManager.getInstance().getImage(imageUrl, imageLoadListener, options, (byte) 2, (ImageDownloadListener) null);
        } else {
            image = ImageManager.getInstance().getImage(str, imageLoadListener, options, (byte) 2, (ImageDownloadListener) null);
        }
        final Drawable drawable = image;
        if (drawable == null || imageLoadListener == null) {
            return;
        }
        if (options != null && options.useMainThread) {
            this.mMainHandler.post(new Runnable() { // from class: com.tencent.component.media.image.ImageLoader.1
                @Override // java.lang.Runnable
                public void run() {
                    ImageUrl imageUrl2 = imageUrl;
                    if (imageUrl2 != null) {
                        imageLoadListener.onImageLoaded(imageUrl2.url, drawable, options);
                    } else {
                        imageLoadListener.onImageLoaded(str, drawable, options);
                    }
                }
            });
        } else if (imageUrl != null) {
            imageLoadListener.onImageLoaded(imageUrl.url, drawable, options);
        } else {
            imageLoadListener.onImageLoaded(str, drawable, options);
        }
    }

    public Drawable loadImageSync(String str, ImageLoadListener imageLoadListener, Options options) {
        return ImageManager.getInstance().getImage(str, imageLoadListener, options, (byte) 1, (ImageDownloadListener) null);
    }

    public void downloadImageOnly(ImageUrl imageUrl, String str, ImageDownloadListener imageDownloadListener) {
        if (imageUrl != null) {
            ImageManager.getInstance().getImage(imageUrl, (ImageLoadListener) null, (Options) null, (byte) 3, imageDownloadListener);
        } else {
            downloadImageOnly(str, imageDownloadListener);
        }
    }

    @Public
    @Deprecated
    public Drawable loadImage(String str, ImageLoadListener imageLoadListener) {
        return loadImage(str, imageLoadListener, (Options) null);
    }

    public Drawable loadImageSync(ImageUrl imageUrl, String str, ImageLoadListener imageLoadListener, Options options) {
        if (imageUrl != null) {
            return ImageManager.getInstance().getImage(imageUrl, imageLoadListener, options, (byte) 1, (ImageDownloadListener) null);
        }
        return loadImageSync(str, imageLoadListener, options);
    }

    @Public
    @Deprecated
    public Drawable loadImage(String str, ImageLoadListener imageLoadListener, Options options) {
        return ImageManager.getInstance().getImage(str, imageLoadListener, options, (byte) 2, (ImageDownloadListener) null);
    }

    public Drawable downloadImageOnly(ImageUrl imageUrl, String str, ImageDownloadListener imageDownloadListener, Options options) {
        if (imageUrl != null) {
            return ImageManager.getInstance().getImage(imageUrl, (ImageLoadListener) null, options, (byte) 3, imageDownloadListener);
        }
        return downloadImageOnly(str, imageDownloadListener, options);
    }

    @Public
    @Deprecated
    public Drawable loadImage(ImageUrl imageUrl, String str, ImageLoadListener imageLoadListener, Options options) {
        if (imageUrl != null) {
            return ImageManager.getInstance().getImage(imageUrl, imageLoadListener, options, (byte) 2, (ImageDownloadListener) null);
        }
        return loadImage(str, imageLoadListener, options);
    }

    @Public
    public static ImageLoader getInstance() {
        if (sInstance == null) {
            synchronized (ImageLoader.class) {
                if (sInstance == null) {
                    sInstance = new ImageLoader();
                }
            }
        }
        return sInstance;
    }
}
