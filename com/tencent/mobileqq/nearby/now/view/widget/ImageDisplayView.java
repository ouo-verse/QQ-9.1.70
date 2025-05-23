package com.tencent.mobileqq.nearby.now.view.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.nearby.now.IResourceUtil;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.utils.INowVideoReporter;
import com.tencent.mobileqq.nearby.now.view.g;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes15.dex */
public class ImageDisplayView extends FrameLayout implements URLDrawable.URLDrawableListener {

    /* renamed from: d, reason: collision with root package name */
    private View f252965d;

    /* renamed from: e, reason: collision with root package name */
    public FitXImageView f252966e;

    /* renamed from: f, reason: collision with root package name */
    private g f252967f;

    /* renamed from: h, reason: collision with root package name */
    private URLDrawable f252968h;

    public ImageDisplayView(Context context) {
        super(context);
        b();
    }

    private void b() {
        View inflate = LayoutInflater.from(getContext()).inflate(((IResourceUtil) QRoute.api(IResourceUtil.class)).getQQNearbyImageDisplayView(), (ViewGroup) this, true);
        this.f252965d = inflate;
        this.f252966e = (FitXImageView) inflate.findViewById(((IResourceUtil) QRoute.api(IResourceUtil.class)).getDisplayImageView());
    }

    private void d(final String str, final int i3, final int i16) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView.1
            @Override // java.lang.Runnable
            public void run() {
                final Bitmap bitmap = null;
                try {
                    final Bitmap decodeFile = BitmapFactory.decodeFile(str);
                    int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 0);
                    Matrix matrix = new Matrix();
                    switch (attributeInt) {
                        case 2:
                            matrix.postScale(-1.0f, 1.0f);
                            break;
                        case 3:
                            matrix.postRotate(180.0f);
                            break;
                        case 4:
                            matrix.postRotate(180.0f);
                            matrix.postScale(-1.0f, 1.0f);
                            break;
                        case 5:
                            matrix.postRotate(90.0f);
                            matrix.postScale(-1.0f, 1.0f);
                            break;
                        case 6:
                            matrix.postRotate(90.0f);
                            break;
                        case 7:
                            matrix.postRotate(270.0f);
                            matrix.postScale(-1.0f, 1.0f);
                            break;
                        case 8:
                            matrix.postRotate(270.0f);
                            break;
                        default:
                            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    ImageDisplayView.this.f252966e.setImageBitmap(decodeFile);
                                    g gVar = ImageDisplayView.this.f252967f;
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    gVar.b(i3, i16);
                                }
                            });
                            return;
                    }
                    final Bitmap createBitmap = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ImageDisplayView.this.f252966e.setImageBitmap(createBitmap);
                            g gVar = ImageDisplayView.this.f252967f;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            gVar.b(i3, i16);
                        }
                    });
                } catch (Exception unused) {
                    if (0 == 0) {
                        return;
                    }
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            ImageDisplayView.this.f252966e.setImageBitmap(bitmap);
                            g gVar = ImageDisplayView.this.f252967f;
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            gVar.b(i3, i16);
                        }
                    });
                } catch (OutOfMemoryError unused2) {
                }
            }
        }, 8, null, true);
    }

    public void c(VideoData videoData) {
        ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).setFeedId(videoData.f252695e);
        ((INowVideoReporter) QRoute.api(INowVideoReporter.class)).setAnchorUin(String.valueOf(videoData.D));
        if (videoData.f252693d == 4) {
            d(videoData.f252703i0.get(0).f252712a, videoData.f252703i0.get(0).f252713b, videoData.f252703i0.get(0).f252714c);
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mUseAutoScaleParams = true;
        URLDrawable drawable = URLDrawable.getDrawable(videoData.f252703i0.get(0).f252712a, obtain);
        this.f252968h = drawable;
        if (drawable.getStatus() == 1) {
            this.f252966e.setImageDrawable(this.f252968h);
            this.f252967f.b(this.f252968h.getIntrinsicWidth(), this.f252968h.getIntrinsicHeight());
        } else {
            this.f252968h.setURLDrawableListener(this);
            this.f252968h.startDownload();
        }
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadCanceled(URLDrawable uRLDrawable) {
        g gVar = this.f252967f;
        if (gVar != null) {
            gVar.a(uRLDrawable.getURL().toString(), this.f252966e, 1);
        }
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
        g gVar = this.f252967f;
        if (gVar != null) {
            gVar.a(uRLDrawable.getURL().toString(), this.f252966e, 0);
        }
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadSuccessed(URLDrawable uRLDrawable) {
        this.f252966e.setImageDrawable(uRLDrawable);
        this.f252967f.b(uRLDrawable.getIntrinsicWidth(), uRLDrawable.getIntrinsicHeight());
    }

    public void setRelayoutListener(g gVar) {
        this.f252967f = gVar;
    }

    public ImageDisplayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public ImageDisplayView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        b();
    }

    @Override // com.tencent.image.URLDrawable.URLDrawableListener
    public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
    }
}
