package com.tencent.gdtad.views.image;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.image.AdImageViewBuilder;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.image.GdtDrawableLoader;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class GdtGifImageView extends URLImageView {
    private static final String TAG = "GdtImageView";
    GdtDrawableLoader.Listener bigImageLoaderListener;
    GdtDrawableLoader.Listener guassianImageLoaderListener;
    private String guassianUrl;
    private volatile boolean hasLoadImage;
    private String imgUrl;
    private boolean isImageLoadSuccess;
    private volatile boolean isOnlyLoadGuassianUrl;
    private WeakReference<AdImageViewBuilder.Listener> loadListener;
    private GdtDrawableLoader loader;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    static final class ImageLoadListener implements GdtDrawableLoader.Listener {
        private final WeakReference<GdtGifImageView> imageViewWeakReference;

        ImageLoadListener(WeakReference<GdtGifImageView> weakReference) {
            this.imageViewWeakReference = weakReference;
        }

        @Nullable
        private GdtGifImageView getGifImageView() {
            WeakReference<GdtGifImageView> weakReference = this.imageViewWeakReference;
            if (weakReference != null) {
                return weakReference.get();
            }
            return null;
        }

        @Nullable
        private AdImageViewBuilder.Listener getLoadListener() {
            GdtGifImageView gifImageView = getGifImageView();
            if (gifImageView == null || gifImageView.loadListener == null) {
                return null;
            }
            return (AdImageViewBuilder.Listener) gifImageView.loadListener.get();
        }

        @Override // com.tencent.gdtad.views.image.GdtDrawableLoader.Listener
        public void onLoadFailed(@Nullable URLDrawable uRLDrawable) {
            String str;
            if (uRLDrawable != null && uRLDrawable.getURL() != null) {
                str = uRLDrawable.getURL().toString();
            } else {
                str = null;
            }
            GdtLog.i(GdtGifImageView.TAG, String.format("onLoadFailed %s", str));
            GdtGifImageView gifImageView = getGifImageView();
            if (gifImageView != null && (!gifImageView.hasLoadImage || !gifImageView.isOnlyLoadGuassianUrl)) {
                gifImageView.setImageDrawable(uRLDrawable, str);
            }
            AdImageViewBuilder.Listener loadListener = getLoadListener();
            if (loadListener != null) {
                loadListener.onStopLoad(false);
            }
        }

        @Override // com.tencent.gdtad.views.image.GdtDrawableLoader.Listener
        public void onLoadSuccessful(@Nullable URLDrawable uRLDrawable) {
            String str;
            if (uRLDrawable != null && uRLDrawable.getURL() != null) {
                str = uRLDrawable.getURL().toString();
            } else {
                str = null;
            }
            GdtLog.i(GdtGifImageView.TAG, String.format("onLoadSuccessful %s", str));
            GdtGifImageView gifImageView = getGifImageView();
            if (gifImageView != null && (!gifImageView.hasLoadImage || !gifImageView.isOnlyLoadGuassianUrl)) {
                gifImageView.setImageDrawable(uRLDrawable, str);
            }
            AdImageViewBuilder.Listener loadListener = getLoadListener();
            if (loadListener != null && gifImageView != null && gifImageView.isImageLoadSuccess) {
                loadListener.onStopLoad(true);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface LoadListener extends AdImageViewBuilder.Listener {
    }

    public GdtGifImageView(Context context, String str, String str2, WeakReference<AdImageViewBuilder.Listener> weakReference, boolean z16) {
        super(context);
        this.loadListener = weakReference;
        this.isImageLoadSuccess = false;
        this.imgUrl = str;
        this.guassianUrl = str2;
        this.isOnlyLoadGuassianUrl = z16;
        if (!TextUtils.isEmpty(str2)) {
            this.guassianImageLoaderListener = new ImageLoadListener(new WeakReference(this));
            new GdtDrawableLoader(str2, 10000L, new WeakReference(this.guassianImageLoaderListener)).load();
        }
        if (!z16) {
            this.bigImageLoaderListener = new ImageLoadListener(new WeakReference(this));
            GdtDrawableLoader gdtDrawableLoader = new GdtDrawableLoader(str, 10000L, new WeakReference(this.bigImageLoaderListener));
            gdtDrawableLoader.load();
            setImageDrawable(gdtDrawableLoader.getDrawable());
        }
        URLDrawable.resume();
        AbstractGifImage.resumeAll();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setImageDrawable(URLDrawable uRLDrawable, @NonNull String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.imgUrl) && str.equals(this.imgUrl)) {
            this.isImageLoadSuccess = true;
            setImageDrawable(uRLDrawable);
        } else if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.guassianUrl) && str.equals(this.guassianUrl) && !this.isImageLoadSuccess) {
            setImageDrawable(uRLDrawable);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
    }

    public void updateUrl(String str, WeakReference<AdImageViewBuilder.Listener> weakReference) {
        this.isImageLoadSuccess = false;
        this.loadListener = weakReference;
        GdtDrawableLoader gdtDrawableLoader = new GdtDrawableLoader(str, 10000L, new WeakReference(this.bigImageLoaderListener));
        gdtDrawableLoader.load();
        setImageDrawable(gdtDrawableLoader.getDrawable());
        this.hasLoadImage = true;
        GdtLog.d(TAG, "GdtGifImageView update completed " + str);
        URLDrawable.resume();
        AbstractGifImage.resumeAll();
    }
}
