package com.tencent.component.media.image.drawable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.gif.NewGifDrawable;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageUrl;
import com.tencent.component.media.utils.ImageManagerLog;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AutoGifDrawable {
    private static String TAG = "AutoGifDrawable";
    AutoGifCallback autoGifCallback;
    Context context;
    GifDownloadCallBackListener gifDownloadCallBackListener;
    GifDownloadListener gifDownloadListener = new GifDownloadListener();
    private Drawable.Callback gifDrawableCallback = new Drawable.Callback() { // from class: com.tencent.component.media.image.drawable.AutoGifDrawable.1
        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            try {
                AutoGifCallback autoGifCallback = AutoGifDrawable.this.autoGifCallback;
                if (autoGifCallback != null) {
                    autoGifCallback.invalidateGifView();
                }
            } catch (Throwable th5) {
                ImageManagerLog.w(AutoGifDrawable.TAG, "invalidateDrawable,catch an exception:" + Log.getStackTraceString(th5));
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
        }
    };
    NewGifDrawable realDrawable;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface AutoGifCallback {
        void invalidateGifView();

        boolean isListViewScrollIdle();
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface GifDownloadCallBackListener {
        void onImageCanceled(String str, ImageLoader.Options options);

        void onImageFailed(String str, ImageLoader.Options options);

        void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options);

        void onImageProgress(String str, float f16, ImageLoader.Options options);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class GifDownloadListener implements ImageLoader.ImageLoadListener {
        GifDownloadListener() {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
            GifDownloadCallBackListener gifDownloadCallBackListener = AutoGifDrawable.this.gifDownloadCallBackListener;
            if (gifDownloadCallBackListener != null) {
                gifDownloadCallBackListener.onImageCanceled(str, options);
            }
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
            GifDownloadCallBackListener gifDownloadCallBackListener = AutoGifDrawable.this.gifDownloadCallBackListener;
            if (gifDownloadCallBackListener != null) {
                gifDownloadCallBackListener.onImageFailed(str, options);
            }
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            if (drawable != null && (drawable instanceof NewGifDrawable)) {
                try {
                    AutoGifDrawable autoGifDrawable = AutoGifDrawable.this;
                    NewGifDrawable newGifDrawable = (NewGifDrawable) drawable;
                    autoGifDrawable.realDrawable = newGifDrawable;
                    newGifDrawable.setCallback(autoGifDrawable.gifDrawableCallback);
                    AutoGifDrawable autoGifDrawable2 = AutoGifDrawable.this;
                    GifDownloadCallBackListener gifDownloadCallBackListener = autoGifDrawable2.gifDownloadCallBackListener;
                    if (gifDownloadCallBackListener != null) {
                        gifDownloadCallBackListener.onImageLoaded(str, autoGifDrawable2.realDrawable, options);
                    }
                } catch (NullPointerException e16) {
                    ImageManagerLog.e(AutoGifDrawable.TAG, "catch an exception:" + Log.getStackTraceString(e16));
                }
            }
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
            GifDownloadCallBackListener gifDownloadCallBackListener = AutoGifDrawable.this.gifDownloadCallBackListener;
            if (gifDownloadCallBackListener != null) {
                gifDownloadCallBackListener.onImageProgress(str, f16, options);
            }
        }
    }

    AutoGifDrawable() {
    }

    public static AutoGifDrawable newAutoGifDrawable() {
        return new AutoGifDrawable();
    }

    public boolean draw(Canvas canvas, int i3, int i16) {
        NewGifDrawable newGifDrawable = this.realDrawable;
        if (newGifDrawable == null) {
            return false;
        }
        newGifDrawable.setCallback(this.gifDrawableCallback);
        this.realDrawable.setBounds(0, 0, i3, i16);
        this.realDrawable.draw(canvas);
        return true;
    }

    public NewGifDrawable.GifPlayListener getGifPlayListener() {
        NewGifDrawable newGifDrawable = this.realDrawable;
        if (newGifDrawable != null) {
            return newGifDrawable.getGifPlayListener();
        }
        return null;
    }

    public int getLoopCount() {
        NewGifDrawable newGifDrawable = this.realDrawable;
        if (newGifDrawable != null) {
            newGifDrawable.getLoopCount();
            return 0;
        }
        return 0;
    }

    public Drawable getRealDrawable() {
        return this.realDrawable;
    }

    public void init(String str, ImageLoader.Options options, Context context, AutoGifCallback autoGifCallback) {
        init(str, options, context, autoGifCallback, (GifDownloadCallBackListener) null);
    }

    public boolean isRunning() {
        NewGifDrawable newGifDrawable = this.realDrawable;
        if (newGifDrawable != null) {
            return newGifDrawable.isRunning();
        }
        return false;
    }

    public void recycled() {
        NewGifDrawable newGifDrawable = this.realDrawable;
        if (newGifDrawable != null) {
            newGifDrawable.setGifPlayListener(null);
            this.realDrawable.setVisible(false, false);
            this.realDrawable.stop();
            this.realDrawable = null;
        }
        this.gifDownloadCallBackListener = null;
        this.autoGifCallback = null;
        this.context = null;
    }

    public void reset() {
        NewGifDrawable newGifDrawable = this.realDrawable;
        if (newGifDrawable != null) {
            newGifDrawable.reset();
        }
    }

    public void restart() {
        NewGifDrawable newGifDrawable = this.realDrawable;
        if (newGifDrawable != null) {
            newGifDrawable.setVisible(true, true);
        }
    }

    public void setGifPlayListener(NewGifDrawable.GifPlayListener gifPlayListener) {
        NewGifDrawable newGifDrawable = this.realDrawable;
        if (newGifDrawable != null) {
            newGifDrawable.setGifPlayListener(gifPlayListener);
        }
    }

    public void setLoopCount(int i3) {
        NewGifDrawable newGifDrawable = this.realDrawable;
        if (newGifDrawable != null) {
            newGifDrawable.setLoopCount(i3);
        }
    }

    public void setLoopModel(int i3) {
        NewGifDrawable newGifDrawable = this.realDrawable;
        if (newGifDrawable != null) {
            newGifDrawable.setCurrentModel(i3);
        }
    }

    public void setSpeed(float f16) {
        NewGifDrawable newGifDrawable = this.realDrawable;
        if (newGifDrawable != null) {
            newGifDrawable.setSpeed(f16);
        }
    }

    public void start() {
        NewGifDrawable newGifDrawable = this.realDrawable;
        if (newGifDrawable != null) {
            newGifDrawable.setVisible(true, false);
        }
    }

    public void stop() {
        NewGifDrawable newGifDrawable = this.realDrawable;
        if (newGifDrawable != null) {
            newGifDrawable.setVisible(false, false);
            this.realDrawable.stop();
        }
    }

    public void init(ImageUrl imageUrl, ImageLoader.Options options, Context context, AutoGifCallback autoGifCallback) {
        init(imageUrl, options, context, autoGifCallback, (GifDownloadCallBackListener) null);
    }

    public void init(String str, ImageLoader.Options options, Context context, AutoGifCallback autoGifCallback, GifDownloadCallBackListener gifDownloadCallBackListener) {
        if (str == null || context == null) {
            return;
        }
        ImageLoader.Options copy = ImageLoader.Options.copy(options);
        copy.needShowGifAnimation = true;
        copy.isGifPlayWhileDownloading = ImageManagerEnv.g().isSupportGifPlaying();
        copy.useMainThread = true;
        copy.mImageType = 2;
        this.context = context;
        this.autoGifCallback = autoGifCallback;
        this.gifDownloadCallBackListener = gifDownloadCallBackListener;
        Drawable loadImage = ImageLoader.getInstance(context).loadImage(str, this.gifDownloadListener, copy);
        if (loadImage instanceof NewGifDrawable) {
            NewGifDrawable newGifDrawable = (NewGifDrawable) loadImage;
            this.realDrawable = newGifDrawable;
            newGifDrawable.setCallback(this.gifDrawableCallback);
            if (gifDownloadCallBackListener != null) {
                gifDownloadCallBackListener.onImageLoaded(str, this.realDrawable, options);
            }
        }
    }

    public void init(ImageUrl imageUrl, ImageLoader.Options options, Context context, AutoGifCallback autoGifCallback, GifDownloadCallBackListener gifDownloadCallBackListener) {
        if (imageUrl == null || context == null) {
            return;
        }
        ImageLoader.Options copy = ImageLoader.Options.copy(options);
        copy.needShowGifAnimation = true;
        copy.isGifPlayWhileDownloading = ImageManagerEnv.g().isSupportGifPlaying();
        copy.useMainThread = true;
        copy.mImageType = 2;
        this.context = context;
        this.autoGifCallback = autoGifCallback;
        this.gifDownloadCallBackListener = gifDownloadCallBackListener;
        Drawable loadImage = ImageLoader.getInstance(context).loadImage(imageUrl, imageUrl.url, this.gifDownloadListener, copy);
        if (loadImage instanceof NewGifDrawable) {
            NewGifDrawable newGifDrawable = (NewGifDrawable) loadImage;
            this.realDrawable = newGifDrawable;
            newGifDrawable.setCallback(this.gifDrawableCallback);
            if (gifDownloadCallBackListener != null) {
                gifDownloadCallBackListener.onImageLoaded(imageUrl.url, this.realDrawable, options);
            }
        }
    }
}
