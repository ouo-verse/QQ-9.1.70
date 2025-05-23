package com.tencent.av.avatar;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.api.IUIToolsApi;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import ew.b;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QavUpdateAvatarViewHelper {

    /* renamed from: e, reason: collision with root package name */
    private static QavUpdateAvatarViewHelper f73233e;

    /* renamed from: a, reason: collision with root package name */
    private b f73234a = null;

    /* renamed from: b, reason: collision with root package name */
    private boolean f73235b = false;

    /* renamed from: c, reason: collision with root package name */
    private VideoAppInterface f73236c = null;

    /* renamed from: d, reason: collision with root package name */
    private WeakReference<ImageView> f73237d = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.av.avatar.QavUpdateAvatarViewHelper$3, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass3 implements b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ VideoAppInterface f73246d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ b f73247e;

        /* compiled from: P */
        /* renamed from: com.tencent.av.avatar.QavUpdateAvatarViewHelper$3$1, reason: invalid class name */
        /* loaded from: classes3.dex */
        class AnonymousClass1 implements Runnable {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Drawable f73249d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ ew.a f73250e;

            AnonymousClass1(Drawable drawable, ew.a aVar) {
                this.f73249d = drawable;
                this.f73250e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Drawable drawable = this.f73249d;
                if (drawable != null && (drawable instanceof BitmapDrawable)) {
                    ((IUIToolsApi) QRoute.api(IUIToolsApi.class)).handleBitmapToGaussianBg(AnonymousClass3.this.f73246d.getApp(), this.f73250e, ((BitmapDrawable) this.f73249d).getBitmap(), new b() { // from class: com.tencent.av.avatar.QavUpdateAvatarViewHelper.3.1.1
                        @Override // ew.b
                        public void D1(final ew.a aVar, final Drawable drawable2) {
                            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.av.avatar.QavUpdateAvatarViewHelper.3.1.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    b bVar = AnonymousClass3.this.f73247e;
                                    if (bVar != null) {
                                        bVar.D1(aVar, drawable2);
                                    }
                                }
                            });
                        }
                    });
                }
            }
        }

        AnonymousClass3(VideoAppInterface videoAppInterface, b bVar) {
            this.f73246d = videoAppInterface;
            this.f73247e = bVar;
        }

        @Override // ew.b
        public void D1(ew.a aVar, Drawable drawable) {
            ThreadManagerV2.excute(new AnonymousClass1(drawable, aVar), 16, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ImageView e() {
        WeakReference<ImageView> weakReference = this.f73237d;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static QavUpdateAvatarViewHelper f() {
        if (f73233e == null) {
            synchronized (QavUpdateAvatarViewHelper.class) {
                if (f73233e == null) {
                    f73233e = new QavUpdateAvatarViewHelper();
                }
            }
        }
        return f73233e;
    }

    private void g(ImageView imageView) {
        this.f73237d = new WeakReference<>(imageView);
    }

    private void j(final ew.a aVar) {
        if (e() != null) {
            if (QLog.isDevelopLevel()) {
                QLog.i("QavAvatarHelper", 4, "updateAvatar, param = " + aVar);
            }
            if (this.f73234a == null) {
                this.f73234a = new b() { // from class: com.tencent.av.avatar.QavUpdateAvatarViewHelper.1
                    @Override // ew.b
                    public void D1(ew.a aVar2, final Drawable drawable) {
                        if (QLog.isDevelopLevel()) {
                            QLog.i("QavAvatarHelper", 4, "updateAvatar, param = " + aVar2 + ", drawable = " + drawable);
                        }
                        final ImageView e16 = QavUpdateAvatarViewHelper.this.e();
                        if (QavUpdateAvatarViewHelper.this.f73236c != null && e16 != null) {
                            if (drawable == null) {
                                final Bitmap J = QavUpdateAvatarViewHelper.this.f73236c.J(aVar2.f397247a, aVar2.f397248b, aVar2.f397249c, aVar2.f397250d, true);
                                com.tencent.qav.thread.a.d().post(new Runnable() { // from class: com.tencent.av.avatar.QavUpdateAvatarViewHelper.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ImageView imageView = e16;
                                        if (imageView != null) {
                                            imageView.setImageBitmap(J);
                                        }
                                    }
                                });
                                return;
                            } else {
                                com.tencent.qav.thread.a.d().post(new Runnable() { // from class: com.tencent.av.avatar.QavUpdateAvatarViewHelper.1.2
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ImageView imageView = e16;
                                        if (imageView != null) {
                                            imageView.setImageDrawable(drawable);
                                        }
                                    }
                                });
                                return;
                            }
                        }
                        QLog.e("QavAvatarHelper", 1, "onGetFaceDrawable error for illegal UI.");
                    }
                };
            }
            if (!this.f73235b) {
                this.f73234a.D1(aVar, null);
            }
            this.f73235b = true;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.avatar.QavUpdateAvatarViewHelper.2
                @Override // java.lang.Runnable
                public void run() {
                    QavAvatarHelper.k().j(QavUpdateAvatarViewHelper.this.f73236c, aVar, new mqq.util.WeakReference<>(QavUpdateAvatarViewHelper.this.f73234a));
                }
            }, 16, null, false);
            return;
        }
        if (QLog.isDevelopLevel()) {
            QLog.i("QavAvatarHelper", 4, "updateAvatar, fail view is null. param = " + aVar);
        }
    }

    private void k(final ew.a aVar, final b bVar) {
        if (QLog.isDevelopLevel()) {
            QLog.i("QavAvatarHelper", 4, "GaussianBg updateAvatar, param = " + aVar);
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.avatar.QavUpdateAvatarViewHelper.4
            @Override // java.lang.Runnable
            public void run() {
                QavAvatarHelper.k().j(QavUpdateAvatarViewHelper.this.f73236c, aVar, new mqq.util.WeakReference<>(bVar));
            }
        }, 16, null, false);
    }

    public void d(String str) {
        this.f73234a = null;
        this.f73236c = null;
        ImageView e16 = e();
        if (e16 != null) {
            e16.setImageDrawable(null);
        }
        this.f73237d = null;
        if (!TextUtils.isEmpty(str)) {
            QavAvatarHelper.k().d(str);
        }
    }

    public void h(VideoAppInterface videoAppInterface, ImageView imageView, ew.a aVar, Bitmap bitmap) {
        if (QLog.isDevelopLevel()) {
            QLog.i("QavAvatarHelper", 4, "updateAvatar, param = " + aVar + ", bitmap = " + bitmap + ", app = " + videoAppInterface + ", headView = " + imageView);
        }
        if (bitmap != null) {
            if (imageView != null) {
                imageView.setImageBitmap(bitmap);
            }
        } else if (imageView != null) {
            if (this.f73236c != videoAppInterface) {
                this.f73236c = videoAppInterface;
            }
            if (e() != imageView) {
                g(imageView);
                this.f73235b = false;
            }
            j(aVar);
        }
    }

    public void i(VideoAppInterface videoAppInterface, ew.a aVar, Bitmap bitmap, b bVar) {
        if (QLog.isDevelopLevel()) {
            QLog.i("QavAvatarHelper", 4, "updateAvatar, param = " + aVar + ", bitmap = " + bitmap + ", app = " + videoAppInterface);
        }
        AnonymousClass3 anonymousClass3 = new AnonymousClass3(videoAppInterface, bVar);
        if (bitmap != null) {
            anonymousClass3.D1(aVar, new BitmapDrawable(bitmap));
            return;
        }
        if (this.f73236c != videoAppInterface) {
            this.f73236c = videoAppInterface;
        }
        k(aVar, anonymousClass3);
    }
}
