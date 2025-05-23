package com.qzone.reborn.qzmoment.view.blur;

import android.graphics.Bitmap;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.qzone.reborn.qzmoment.view.blur.QZMBlurTask;
import com.tencent.qphone.base.util.QLog;
import jo.d;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QZMBlurry {

    /* renamed from: a, reason: collision with root package name */
    private static volatile QZMBlurry f59061a;

    /* renamed from: b, reason: collision with root package name */
    private static d f59062b;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class BitmapComposer {

        /* renamed from: a, reason: collision with root package name */
        private final Bitmap f59063a;

        /* renamed from: b, reason: collision with root package name */
        private final com.qzone.reborn.qzmoment.view.blur.b f59064b;

        /* renamed from: c, reason: collision with root package name */
        private final boolean f59065c;

        /* compiled from: P */
        /* loaded from: classes37.dex */
        class a implements QZMBlurTask.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ImageView f59068a;

            a(ImageView imageView) {
                this.f59068a = imageView;
            }

            @Override // com.qzone.reborn.qzmoment.view.blur.QZMBlurTask.a
            public void a(Bitmap bitmap) {
                QZMBlurry.e(bitmap, this.f59068a);
            }
        }

        public BitmapComposer(Bitmap bitmap, com.qzone.reborn.qzmoment.view.blur.b bVar, boolean z16) {
            this.f59063a = bitmap;
            this.f59064b = bVar;
            this.f59065c = z16;
        }

        public void a(final ImageView imageView) {
            if (this.f59063a == null) {
                QLog.e("QZMBlurry", 1, "into  bitmap == null");
                return;
            }
            QZMBlurry.f59062b.g(imageView, true);
            this.f59064b.f59078a = this.f59063a.getWidth();
            this.f59064b.f59079b = this.f59063a.getHeight();
            if (this.f59065c) {
                new QZMBlurTask(imageView.getContext(), this.f59063a, this.f59064b, new a(imageView)).e();
            } else {
                final Bitmap a16 = com.qzone.reborn.qzmoment.view.blur.a.a(imageView.getContext(), this.f59063a, this.f59064b);
                c.c(new Runnable() { // from class: com.qzone.reborn.qzmoment.view.blur.QZMBlurry.BitmapComposer.2
                    @Override // java.lang.Runnable
                    public void run() {
                        QZMBlurry.e(a16, imageView);
                    }
                });
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class a {

        /* renamed from: b, reason: collision with root package name */
        private boolean f59075b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f59076c;

        /* renamed from: d, reason: collision with root package name */
        private int f59077d = 300;

        /* renamed from: a, reason: collision with root package name */
        private final com.qzone.reborn.qzmoment.view.blur.b f59074a = new com.qzone.reborn.qzmoment.view.blur.b();

        /* JADX INFO: Access modifiers changed from: private */
        public void b(ViewGroup viewGroup, Bitmap bitmap) {
            if (viewGroup != null && viewGroup.getContext() != null) {
                ImageView imageView = new ImageView(viewGroup.getContext());
                imageView.setTag("QZMBlurry");
                QZMBlurry.e(bitmap, imageView);
                viewGroup.addView(imageView);
                if (this.f59076c) {
                    c.a(imageView, this.f59077d);
                    return;
                }
                return;
            }
            QLog.e("QZMBlurry", 1, "addView  target == null");
        }

        public BitmapComposer d(Bitmap bitmap) {
            return new BitmapComposer(bitmap, this.f59074a, this.f59075b);
        }

        public a e(int i3) {
            this.f59074a.f59080c = i3;
            return this;
        }

        public a f(int i3) {
            this.f59074a.f59081d = i3;
            return this;
        }

        public a c() {
            this.f59075b = true;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class b {
    }

    QZMBlurry() {
        f59062b = new d("feed_pic_blur_render");
    }

    public static QZMBlurry d() {
        if (f59061a == null) {
            synchronized (QZMBlurry.class) {
                if (f59061a == null) {
                    f59061a = new QZMBlurry();
                }
            }
        }
        return f59061a;
    }

    public a c() {
        return new a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(Bitmap bitmap, ImageView imageView) {
        if (imageView == null || bitmap == null) {
            return;
        }
        f59062b.a(imageView);
        imageView.setImageBitmap(bitmap);
    }
}
