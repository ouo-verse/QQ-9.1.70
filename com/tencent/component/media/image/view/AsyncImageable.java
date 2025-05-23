package com.tencent.component.media.image.view;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.tencent.component.media.image.ImageKey;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.RawImageProcessor;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface AsyncImageable {
    public static final int GL_MAX_TEXTURE_SIZE = 2048;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface AsyncImageListener {
        void onImageFailed(AsyncImageable asyncImageable);

        void onImageLoaded(AsyncImageable asyncImageable);

        void onImageProgress(AsyncImageable asyncImageable, float f16);

        void onImageStarted(AsyncImageable asyncImageable);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class AsyncImageableImpl implements AsyncImageable {
        private static final String[] EMPTY_STR_ARRAY = new String[0];
        private int mAsyncImageId;
        private AsyncImageListener mAsyncListener;
        private final AsyncImageable mAsyncListenerCallback;
        private final ImageLoader mImageLoader;
        private final ImageView mImageView;
        private AsyncImageListener mInternalAsyncListener;
        private String mUrl = null;
        private String mLatestUrl = null;
        private ImageLoader.Options mOptions = new ImageLoader.Options();
        private AsyncOptions mAsyncOptions = new AsyncOptions() { // from class: com.tencent.component.media.image.view.AsyncImageable.AsyncImageableImpl.1
            @Override // com.tencent.component.media.image.view.AsyncImageable.AsyncOptions
            protected void onClipSizeChanged(int i3, int i16) {
                AsyncImageableImpl.this.resetAsyncImage();
            }
        };
        private final Thread mMainThread = Looper.getMainLooper().getThread();
        private final Handler mMainHandler = new Handler(Looper.getMainLooper());
        private final WeakImageLoadListener mImageLoadListener = new WeakImageLoadListener(this);
        private final WeakStreamLoadListener mStreamLoadListener = new WeakStreamLoadListener(this);

        public AsyncImageableImpl(ImageView imageView, AsyncImageable asyncImageable) {
            this.mImageView = imageView;
            this.mImageLoader = ImageLoader.getInstance(imageView.getContext());
            this.mAsyncListenerCallback = asyncImageable;
            this.mOptions.useMainThread = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void applyAsyncImage(final Drawable drawable, boolean z16) {
            if (drawable != null) {
                if (!z16) {
                    this.mImageView.setImageDrawable(drawable);
                } else {
                    AsyncOptions asyncOptions = this.mAsyncOptions;
                    final Animation animation = asyncOptions.inAnimation;
                    Animation animation2 = asyncOptions.outAnimation;
                    if (animation2 != null) {
                        scheduleAnimation(this.mImageView, animation2, new Runnable() { // from class: com.tencent.component.media.image.view.AsyncImageable.AsyncImageableImpl.3
                            @Override // java.lang.Runnable
                            public void run() {
                                AsyncImageableImpl.this.mImageView.setImageDrawable(drawable);
                                AsyncImageableImpl.scheduleAnimation(AsyncImageableImpl.this.mImageView, animation, null);
                            }
                        });
                    } else if (animation != null) {
                        this.mImageView.setImageDrawable(drawable);
                        scheduleAnimation(this.mImageView, animation, null);
                    } else {
                        this.mImageView.setImageDrawable(drawable);
                    }
                }
                this.mAsyncImageId = drawable.hashCode();
                return;
            }
            this.mAsyncImageId = 0;
        }

        private void applyDefaultImage() {
            AsyncOptions asyncOptions = this.mAsyncOptions;
            Drawable drawable = asyncOptions.defaultImage;
            int i3 = asyncOptions.defaultImageId;
            if (drawable != null) {
                this.mImageView.setImageDrawable(drawable);
            } else if (i3 != 0) {
                this.mImageView.setImageResource(i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void applyFailImage() {
            AsyncOptions asyncOptions = this.mAsyncOptions;
            Drawable drawable = asyncOptions.failImage;
            int i3 = asyncOptions.failImageId;
            if (drawable != null) {
                this.mImageView.setImageDrawable(drawable);
            } else if (i3 != 0) {
                this.mImageView.setImageResource(i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean checkAsyncChanged(String str) {
            return !equalsString(this.mUrl, str);
        }

        private void ensureDrawable() {
            int i3 = this.mAsyncImageId;
            if (i3 != 0) {
                Drawable drawable = this.mImageView.getDrawable();
                if (drawable == null || drawable.hashCode() != i3) {
                    resetAsyncImage();
                }
            }
        }

        private void ensureThread(String str) {
            if (Thread.currentThread() == this.mMainThread) {
                return;
            }
            throw new RuntimeException(str + " can ONLY be called within main thread!");
        }

        private static boolean equalsString(String str, String str2) {
            if (str != null && str2 != null) {
                if (str.equals(str2)) {
                    return true;
                }
                return ImageKey.getUrlKey(str, true).equals(ImageKey.getUrlKey(str2, true));
            }
            return false;
        }

        private static boolean equalsStringArray(String[] strArr, String[] strArr2) {
            if (strArr == strArr2) {
                return true;
            }
            if (strArr == null || strArr2 == null || strArr.length != strArr2.length) {
                return false;
            }
            for (int i3 = 0; i3 < strArr.length; i3++) {
                if (!equalsString(strArr[i3], strArr2[i3])) {
                    return false;
                }
            }
            return true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.tencent.component.media.image.view.AsyncImageable] */
        public void notifyAsyncImageFailed() {
            AsyncImageableImpl asyncImageableImpl;
            AsyncImageListener asyncImageListener = this.mAsyncListener;
            ?? r16 = this.mAsyncListenerCallback;
            if (asyncImageListener != null) {
                if (r16 != 0) {
                    asyncImageableImpl = r16;
                } else {
                    asyncImageableImpl = this;
                }
                asyncImageListener.onImageFailed(asyncImageableImpl);
            }
            AsyncImageListener asyncImageListener2 = this.mInternalAsyncListener;
            AsyncImageableImpl asyncImageableImpl2 = r16;
            if (asyncImageListener2 != null) {
                if (r16 == 0) {
                    asyncImageableImpl2 = this;
                }
                asyncImageListener2.onImageFailed(asyncImageableImpl2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.tencent.component.media.image.view.AsyncImageable] */
        public void notifyAsyncImageLoaded() {
            AsyncImageableImpl asyncImageableImpl;
            AsyncImageListener asyncImageListener = this.mAsyncListener;
            ?? r16 = this.mAsyncListenerCallback;
            if (asyncImageListener != null) {
                if (r16 != 0) {
                    asyncImageableImpl = r16;
                } else {
                    asyncImageableImpl = this;
                }
                asyncImageListener.onImageLoaded(asyncImageableImpl);
            }
            AsyncImageListener asyncImageListener2 = this.mInternalAsyncListener;
            AsyncImageableImpl asyncImageableImpl2 = r16;
            if (asyncImageListener2 != null) {
                if (r16 == 0) {
                    asyncImageableImpl2 = this;
                }
                asyncImageListener2.onImageLoaded(asyncImageableImpl2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.tencent.component.media.image.view.AsyncImageable] */
        public void notifyAsyncImageProgress(float f16) {
            AsyncImageableImpl asyncImageableImpl;
            AsyncImageListener asyncImageListener = this.mAsyncListener;
            ?? r16 = this.mAsyncListenerCallback;
            if (asyncImageListener != null) {
                if (r16 != 0) {
                    asyncImageableImpl = r16;
                } else {
                    asyncImageableImpl = this;
                }
                asyncImageListener.onImageProgress(asyncImageableImpl, f16);
            }
            AsyncImageListener asyncImageListener2 = this.mInternalAsyncListener;
            AsyncImageableImpl asyncImageableImpl2 = r16;
            if (asyncImageListener2 != null) {
                if (r16 == 0) {
                    asyncImageableImpl2 = this;
                }
                asyncImageListener2.onImageProgress(asyncImageableImpl2, f16);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.tencent.component.media.image.view.AsyncImageable] */
        private void notifyAsyncImageStart() {
            AsyncImageableImpl asyncImageableImpl;
            AsyncImageListener asyncImageListener = this.mAsyncListener;
            ?? r16 = this.mAsyncListenerCallback;
            if (asyncImageListener != null) {
                if (r16 != 0) {
                    asyncImageableImpl = r16;
                } else {
                    asyncImageableImpl = this;
                }
                asyncImageListener.onImageStarted(asyncImageableImpl);
            }
            AsyncImageListener asyncImageListener2 = this.mInternalAsyncListener;
            AsyncImageableImpl asyncImageableImpl2 = r16;
            if (asyncImageListener2 != null) {
                if (r16 == 0) {
                    asyncImageableImpl2 = this;
                }
                asyncImageListener2.onImageStarted(asyncImageableImpl2);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void resetAsyncImage() {
            this.mUrl = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void scheduleAnimation(View view, Animation animation, final Runnable runnable) {
            if (view != null && animation != null) {
                view.clearAnimation();
                animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.tencent.component.media.image.view.AsyncImageable.AsyncImageableImpl.4
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation2) {
                        Runnable runnable2 = runnable;
                        if (runnable2 != null) {
                            runnable2.run();
                        }
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation2) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation2) {
                    }
                });
                view.startAnimation(animation);
            } else if (runnable != null) {
                runnable.run();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAsyncImageInternal(String str, String... strArr) {
            Drawable loadImage;
            int i3;
            int i16;
            String str2 = this.mUrl;
            if (str2 == null && str == null) {
                applyDefaultImage();
                return;
            }
            ImageLoader.Options options = this.mOptions;
            if (str == null && str2 != null) {
                this.mUrl = null;
                this.mImageLoader.cancel(str2, this.mImageLoadListener, options);
                applyDefaultImage();
                return;
            }
            ensureThread("setAsyncImage");
            this.mUrl = str;
            this.mLatestUrl = str;
            ImageLoader.Options copy = ImageLoader.Options.copy(this.mOptions);
            this.mOptions = copy;
            this.mAsyncOptions.fillOptions(copy);
            ImageLoader.Options options2 = this.mOptions;
            options2.needCallBackProcessPercent = true;
            options2.useMainThread = true;
            ViewGroup.LayoutParams layoutParams = this.mImageView.getLayoutParams();
            if (layoutParams != null && (i3 = layoutParams.width) > 0 && (i16 = layoutParams.height) > 0) {
                ImageLoader.Options options3 = this.mOptions;
                options3.clipWidth = i3;
                options3.clipHeight = i16;
            }
            notifyAsyncImageStart();
            if (this.mAsyncOptions.justMemoryCache) {
                loadImage = this.mImageLoader.loadImageSync(str, this.mOptions);
            } else {
                loadImage = this.mImageLoader.loadImage(str, this.mImageLoadListener, this.mOptions);
            }
            if (loadImage != null) {
                applyAsyncImage(loadImage, false);
                notifyAsyncImageLoaded();
            } else {
                applyDefaultImage();
            }
        }

        public void finalize() throws Throwable {
            try {
                this.mImageLoader.cancel(this.mUrl, this.mImageLoadListener, this.mOptions);
            } finally {
                super.finalize();
            }
        }

        @Override // com.tencent.component.media.image.view.AsyncImageable
        public String getAsyncImage() {
            return this.mLatestUrl;
        }

        @Override // com.tencent.component.media.image.view.AsyncImageable
        public AsyncOptions getAsyncOptions() {
            return this.mAsyncOptions;
        }

        @Override // com.tencent.component.media.image.view.AsyncImageable
        public void setAsyncImage(String str) {
            setAsyncImage(str, EMPTY_STR_ARRAY);
        }

        @Override // com.tencent.component.media.image.view.AsyncImageable
        public void setAsyncImageListener(AsyncImageListener asyncImageListener) {
            this.mAsyncListener = asyncImageListener;
        }

        @Override // com.tencent.component.media.image.view.AsyncImageable
        public void setInternalAsyncImageListener(AsyncImageListener asyncImageListener) {
            this.mInternalAsyncListener = asyncImageListener;
        }

        @Override // com.tencent.component.media.image.view.AsyncImageable
        public void setAsyncImage(final String str, final String... strArr) {
            if (Thread.currentThread() != this.mMainThread) {
                this.mMainHandler.post(new Runnable() { // from class: com.tencent.component.media.image.view.AsyncImageable.AsyncImageableImpl.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AsyncImageableImpl.this.setAsyncImageInternal(str, strArr);
                    }
                });
            } else {
                setAsyncImageInternal(str, strArr);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes5.dex */
        public static class WeakImageLoadListener implements ImageLoader.ImageLoadListener {
            private WeakReference<AsyncImageableImpl> mAsyncImageableRef;

            public WeakImageLoadListener(AsyncImageableImpl asyncImageableImpl) {
                this.mAsyncImageableRef = new WeakReference<>(asyncImageableImpl);
            }

            private AsyncImageableImpl getAsyncImageable() {
                return this.mAsyncImageableRef.get();
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageFailed(String str, ImageLoader.Options options) {
                AsyncImageableImpl asyncImageable = getAsyncImageable();
                if (asyncImageable != null && !asyncImageable.checkAsyncChanged(str)) {
                    asyncImageable.applyFailImage();
                    asyncImageable.resetAsyncImage();
                    asyncImageable.notifyAsyncImageFailed();
                }
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
                AsyncImageableImpl asyncImageable = getAsyncImageable();
                if (asyncImageable != null && !asyncImageable.checkAsyncChanged(str)) {
                    asyncImageable.applyAsyncImage(drawable, true);
                    asyncImageable.notifyAsyncImageLoaded();
                }
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageProgress(String str, float f16, ImageLoader.Options options) {
                AsyncImageableImpl asyncImageable = getAsyncImageable();
                if (asyncImageable != null && !asyncImageable.checkAsyncChanged(str)) {
                    asyncImageable.notifyAsyncImageProgress(f16);
                }
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageCanceled(String str, ImageLoader.Options options) {
            }
        }

        /* compiled from: P */
        /* loaded from: classes5.dex */
        static class WeakStreamLoadListener implements ImageLoader.StreamDownloadListener {
            private WeakReference<AsyncImageableImpl> mAsyncImageableRef;

            public WeakStreamLoadListener(AsyncImageableImpl asyncImageableImpl) {
                this.mAsyncImageableRef = new WeakReference<>(asyncImageableImpl);
            }

            private AsyncImageableImpl getAsyncImageable() {
                return this.mAsyncImageableRef.get();
            }

            @Override // com.tencent.component.media.image.ImageLoader.StreamDownloadListener
            public void onApplyToImage(String str, Drawable drawable, ImageLoader.Options options) {
                AsyncImageableImpl asyncImageable = getAsyncImageable();
                if (asyncImageable != null && !asyncImageable.checkAsyncChanged(str)) {
                    asyncImageable.applyAsyncImage(drawable, true);
                }
            }

            @Override // com.tencent.component.media.image.ImageLoader.StreamDownloadListener
            public void onDownloadCanceled(String str, String str2, String str3) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.StreamDownloadListener
            public void onDownloadFailed(String str, String str2, String str3) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.StreamDownloadListener
            public void onDownloadSucceed(String str, String str2, String str3) {
            }

            @Override // com.tencent.component.media.image.ImageLoader.StreamDownloadListener
            public void onDownloadProgress(String str, String str2, String str3, byte[] bArr, int i3) {
            }
        }
    }

    String getAsyncImage();

    AsyncOptions getAsyncOptions();

    void setAsyncImage(String str);

    void setAsyncImage(String str, String... strArr);

    void setAsyncImageListener(AsyncImageListener asyncImageListener);

    void setInternalAsyncImageListener(AsyncImageListener asyncImageListener);

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class AsyncOptions {
        int clipWidth = -1;
        int clipHeight = -1;
        boolean preferQuality = false;
        boolean justCover = true;
        boolean tryStream = false;
        boolean needShowGifAnimation = false;
        Bitmap.Config imageConfig = ImageLoader.ImageOptions.DEFAULT_IMAGE_CONFIG;
        ImageProcessor imageProcessor = null;
        RawImageProcessor rawImageProcessor = null;
        boolean priority = true;
        boolean alwaysLoad = false;
        boolean justMemoryCache = false;
        int defaultImageId = 0;
        Drawable defaultImage = null;
        int failImageId = 0;
        Drawable failImage = null;
        Animation inAnimation = null;
        Animation outAnimation = null;
        String fileRootPath = null;

        AsyncOptions() {
        }

        public final void fillOptions(ImageLoader.Options options) {
            options.clipWidth = this.clipWidth;
            options.clipHeight = this.clipHeight;
            options.preferQuality = this.preferQuality;
            options.justCover = this.justCover;
            options.needShowGifAnimation = this.needShowGifAnimation;
            options.imageConfig = this.imageConfig;
            options.extraProcessor = this.imageProcessor;
            options.processor = this.rawImageProcessor;
            options.priority = this.priority;
            options.fileRootPath = this.fileRootPath;
        }

        public void setAlwaysLoad(boolean z16) {
            if (this.alwaysLoad != z16) {
                this.alwaysLoad = z16;
            }
        }

        public void setAnimation(Animation animation, Animation animation2) {
            if (this.inAnimation != animation || this.outAnimation != animation2) {
                this.inAnimation = animation;
                this.outAnimation = animation2;
            }
        }

        public void setClipSize(int i3, int i16) {
            if (this.clipWidth != i3 || this.clipHeight != i16) {
                this.clipWidth = i3;
                this.clipHeight = i16;
                onClipSizeChanged(i3, i16);
            }
        }

        public void setDefaultImage(int i3) {
            this.defaultImageId = i3;
            this.defaultImage = null;
        }

        public void setFailImage(int i3) {
            this.failImageId = i3;
            this.failImage = null;
        }

        public void setFileRootPath(String str) {
            if (str != null && !str.equals(this.fileRootPath)) {
                this.fileRootPath = str;
            } else if (str == null) {
                this.fileRootPath = null;
            }
        }

        public void setImageConfig(Bitmap.Config config) {
            if (this.imageConfig != config) {
                this.imageConfig = config;
            }
        }

        public void setImageProcessor(ImageProcessor imageProcessor) {
            if (this.imageProcessor != imageProcessor) {
                this.imageProcessor = imageProcessor;
            }
        }

        public void setJustCover(boolean z16) {
            if (this.justCover != z16) {
                this.justCover = z16;
            }
        }

        public void setJustMemoryCache(boolean z16) {
            if (this.justMemoryCache != z16) {
                this.justMemoryCache = z16;
            }
        }

        public void setNeedShowGifAnimation(boolean z16) {
            if (this.needShowGifAnimation != z16) {
                this.needShowGifAnimation = z16;
            }
        }

        public void setPreferQuality(boolean z16) {
            if (this.preferQuality != z16) {
                this.preferQuality = z16;
            }
        }

        public void setPriority(boolean z16) {
            if (this.priority != z16) {
                this.priority = z16;
            }
        }

        public void setRawImageProcessor(RawImageProcessor rawImageProcessor) {
            if (this.rawImageProcessor != rawImageProcessor) {
                this.rawImageProcessor = rawImageProcessor;
            }
        }

        public void setTryStream(boolean z16) {
            if (this.tryStream != z16) {
                this.tryStream = z16;
            }
        }

        public void setDefaultImage(Drawable drawable) {
            this.defaultImageId = 0;
            this.defaultImage = drawable;
        }

        public void setFailImage(Drawable drawable) {
            this.failImageId = 0;
            this.failImage = drawable;
        }

        protected void onClipSizeChanged(int i3, int i16) {
        }
    }
}
