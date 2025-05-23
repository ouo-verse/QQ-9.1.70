package com.qzone.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.qzone.widget.AsyncImageable;
import com.tencent.component.media.image.ImageProcessor;

/* loaded from: classes37.dex */
public class FlexiableProcessImageView extends AsyncImageView {
    private ImageProcessor C;
    private int D;
    private int E;

    /* renamed from: d, reason: collision with root package name */
    private Context f60403d;

    /* renamed from: e, reason: collision with root package name */
    private Drawable f60404e;

    /* renamed from: f, reason: collision with root package name */
    private Drawable f60405f;

    /* renamed from: h, reason: collision with root package name */
    private int f60406h;

    /* renamed from: i, reason: collision with root package name */
    private int f60407i;

    /* renamed from: m, reason: collision with root package name */
    private ImageProcessor f60408m;

    public FlexiableProcessImageView(Context context) {
        super(context);
        k(context);
    }

    private Drawable j(Context context, int i3, ImageProcessor imageProcessor) {
        Drawable drawable = context.getResources().getDrawable(i3);
        if (drawable == null) {
            return null;
        }
        drawable.setBounds(0, 0, this.D, this.E);
        return imageProcessor.process(drawable);
    }

    private void k(Context context) {
        this.f60403d = context;
        setAsyncImageListener(new a());
    }

    public void setDefaultImage(int i3, ImageProcessor imageProcessor) {
        this.f60408m = imageProcessor;
        setDefaultImage(i3);
    }

    @Override // com.qzone.widget.AsyncImageView, com.qzone.widget.AsyncImageable
    public void setFailImage(int i3) {
        ImageProcessor imageProcessor;
        Context context = this.f60403d;
        if (context == null || i3 == 0) {
            return;
        }
        if (this.E > 0 && this.D > 0 && (imageProcessor = this.C) != null) {
            if (this.f60407i != i3 || this.f60405f == null) {
                this.f60407i = i3;
                this.f60405f = j(context, i3, imageProcessor);
                return;
            }
            return;
        }
        super.setFailImage(i3);
    }

    public void setFailedImage(int i3, ImageProcessor imageProcessor) {
        this.C = imageProcessor;
        setFailImage(i3);
    }

    public FlexiableProcessImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k(context);
    }

    @Override // com.qzone.widget.AsyncImageView, com.qzone.widget.AsyncImageable
    public void setDefaultImage(int i3) {
        ImageProcessor imageProcessor;
        Context context = this.f60403d;
        if (context == null || i3 == 0) {
            return;
        }
        if (this.E > 0 && this.D > 0 && (imageProcessor = this.f60408m) != null) {
            if (this.f60406h != i3 || this.f60404e == null) {
                this.f60406h = i3;
                this.f60404e = j(context, i3, imageProcessor);
                return;
            }
            return;
        }
        super.setDefaultImage(i3);
    }

    public void setNonAsycnDrawableWidth(int i3, int i16) {
        if (i3 > 0) {
            this.D = i3;
        }
        if (i16 > 0) {
            this.E = i16;
        }
    }

    public FlexiableProcessImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        k(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class a implements AsyncImageable.AsyncImageListener {
        a() {
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageFailed(AsyncImageable asyncImageable) {
            if (FlexiableProcessImageView.this.f60405f == null || FlexiableProcessImageView.this.f60407i <= 0) {
                return;
            }
            FlexiableProcessImageView flexiableProcessImageView = FlexiableProcessImageView.this;
            flexiableProcessImageView.setImageDrawable(flexiableProcessImageView.f60405f);
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageStarted(AsyncImageable asyncImageable) {
            if (FlexiableProcessImageView.this.f60404e == null || FlexiableProcessImageView.this.f60406h <= 0) {
                return;
            }
            FlexiableProcessImageView flexiableProcessImageView = FlexiableProcessImageView.this;
            flexiableProcessImageView.setImageDrawable(flexiableProcessImageView.f60404e);
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageLoaded(AsyncImageable asyncImageable) {
        }

        @Override // com.qzone.widget.AsyncImageable.AsyncImageListener
        public void onImageProgress(AsyncImageable asyncImageable, float f16) {
        }
    }
}
