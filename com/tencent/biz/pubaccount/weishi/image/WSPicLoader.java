package com.tencent.biz.pubaccount.weishi.image;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.weishi.report.g;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.view.RoundCornerImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.kandian.base.image.imageloader.RIJImageOptReport;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes32.dex */
public class WSPicLoader {

    /* renamed from: a, reason: collision with root package name */
    private static volatile WSPicLoader f80859a;

    /* renamed from: com.tencent.biz.pubaccount.weishi.image.WSPicLoader$1, reason: invalid class name */
    /* loaded from: classes32.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WeakReference f80860d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f80861e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Drawable f80862f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ WeakReference f80863h;
        final /* synthetic */ WSPicLoader this$0;

        @Override // java.lang.Runnable
        public void run() {
            if (((ImageView) this.f80860d.get()) == null || bb.c(this.f80861e) == null) {
                return;
            }
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            Drawable drawable = this.f80862f;
            obtain.mFailedDrawable = drawable;
            obtain.mLoadingDrawable = drawable;
            this.this$0.s(this.f80860d, URLDrawable.getDrawable(this.f80861e, obtain), this.f80861e, this.f80863h);
        }
    }

    /* loaded from: classes32.dex */
    class a implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f80878d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ImageView f80879e;

        a(String str, ImageView imageView) {
            this.f80878d = str;
            this.f80879e = imageView;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            x.i("815", "onLoadCanceled - " + this.f80878d);
            this.f80879e.setImageResource(R.drawable.d7y);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            x.i("815", "onLoadFialed - " + this.f80878d);
            this.f80879e.setImageResource(R.drawable.d7y);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
            x.i("815", "onLoadProgressed - " + this.f80878d);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            x.i("815", "onLoadSuccessed - " + this.f80878d);
            this.f80879e.setImageDrawable(uRLDrawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements k52.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f80881a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f80882b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f80883c;

        b(long j3, String str, String str2) {
            this.f80881a = j3;
            this.f80882b = str;
            this.f80883c = str2;
        }

        @Override // k52.a
        public void b(com.tencent.mobileqq.kandian.base.image.b bVar, Throwable th5) {
            x.b("PreloadCoverImgLog", "onFail request = " + bVar);
            RIJImageOptReport.f(6, bVar);
            g.d().j(bVar, true, true, 0L, bVar.f239004a.toString(), this.f80883c, -1);
        }

        @Override // k52.a
        public void a(com.tencent.mobileqq.kandian.base.image.b bVar, k52.b bVar2) {
            RIJImageOptReport.f(6, bVar);
            WSPicLoader.this.v(bVar, this.f80881a, this.f80882b, this.f80883c);
        }

        @Override // k52.a
        public void c(com.tencent.mobileqq.kandian.base.image.b bVar, int i3) {
        }
    }

    /* loaded from: classes32.dex */
    public interface d {
        void a(Drawable drawable);
    }

    WSPicLoader() {
    }

    public static WSPicLoader g() {
        if (f80859a == null) {
            synchronized (WSPicLoader.class) {
                if (f80859a == null) {
                    f80859a = new WSPicLoader();
                }
            }
        }
        return f80859a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(final Drawable drawable, final WeakReference<d> weakReference) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.image.WSPicLoader.4
            @Override // java.lang.Runnable
            public void run() {
                d dVar = (d) weakReference.get();
                if (dVar != null) {
                    dVar.a(drawable);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(com.tencent.mobileqq.kandian.base.image.b bVar, long j3, String str, String str2) {
        long uptimeMillis = SystemClock.uptimeMillis() - j3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("onSuccess cost = ");
        sb5.append(uptimeMillis);
        sb5.append(", hashCode:");
        sb5.append(bVar != null ? bVar.hashCode() : 0);
        sb5.append(",request = ");
        sb5.append(bVar);
        x.b("PreloadCoverImgLog", sb5.toString());
        g.d().j(bVar, true, true, bVar != null ? bVar.f239023t : 0L, str, str2, -1);
    }

    public void d(String str, int i3, int i16, iy.a aVar) {
        URL c16 = bb.c(str);
        com.tencent.mobileqq.kandian.base.image.b bVar = new com.tencent.mobileqq.kandian.base.image.b();
        bVar.f239004a = c16;
        bVar.f239005b = i3;
        bVar.f239006c = i16;
        ((IImageManager) QRoute.api(IImageManager.class)).loadImage(bVar, new c(aVar, c16));
    }

    public void e(String str, int i3, int i16, String str2) {
        URL c16 = bb.c(str);
        com.tencent.mobileqq.kandian.base.image.b bVar = new com.tencent.mobileqq.kandian.base.image.b();
        bVar.f239004a = c16;
        bVar.f239005b = i3;
        bVar.f239006c = i16;
        bVar.f239008e = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        RIJImageOptReport.f(1, bVar);
        ((IImageManager) QRoute.api(IImageManager.class)).loadImage(bVar, new b(uptimeMillis, str, str2));
    }

    public boolean i(int i3) {
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }

    public void k(final Context context, ImageView imageView, final String str, d dVar) {
        x.b("AvatarImageLog", "WeishiUtils loadAvatarImage url:" + str + ", imageView:" + imageView);
        if (context == null || imageView == null) {
            return;
        }
        final WeakReference weakReference = new WeakReference(imageView);
        final WeakReference weakReference2 = new WeakReference(dVar);
        ThreadManager.getSubThreadHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.image.WSPicLoader.3
            @Override // java.lang.Runnable
            public void run() {
                if (((ImageView) weakReference.get()) == null) {
                    return;
                }
                Drawable drawable = context.getResources().getDrawable(R.drawable.f160830com);
                if (bb.c(str) == null) {
                    WSPicLoader.this.q(drawable, weakReference2);
                    WSPicLoader.this.r(weakReference, drawable, str);
                    return;
                }
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mFailedDrawable = drawable;
                obtain.mLoadingDrawable = drawable;
                URLDrawable drawable2 = URLDrawable.getDrawable(str, obtain);
                WSPicLoader.this.q(drawable2, weakReference2);
                WSPicLoader.this.r(weakReference, drawable2, str);
            }
        });
    }

    public void l(KandianUrlImageView kandianUrlImageView, stSimpleMetaFeed stsimplemetafeed, Drawable drawable, String str, boolean z16, int i3) {
        o(BaseApplicationImpl.getApplication(), new com.tencent.biz.pubaccount.weishi.image.c(kandianUrlImageView, bb.n(stsimplemetafeed, z16)).j(drawable).k(str).i(i3));
    }

    public void m(KandianUrlImageView kandianUrlImageView, stSimpleMetaFeed stsimplemetafeed, boolean z16, String str, int i3) {
        o(BaseApplicationImpl.getApplication(), new com.tencent.biz.pubaccount.weishi.image.c(kandianUrlImageView, bb.n(stsimplemetafeed, z16)).k(str).i(i3));
    }

    public void n(KandianUrlImageView kandianUrlImageView, String str, Drawable drawable, String str2, int i3) {
        o(BaseApplicationImpl.getApplication(), new com.tencent.biz.pubaccount.weishi.image.c(kandianUrlImageView, str).j(drawable).k(str2).i(i3));
    }

    public void p(KandianUrlImageView kandianUrlImageView, String str) {
        o(BaseApplicationImpl.getApplication(), new com.tencent.biz.pubaccount.weishi.image.c(kandianUrlImageView, str).j(BaseApplicationImpl.getApplication().getApplicationContext().getResources().getDrawable(R.drawable.f161250he3)).h(false));
    }

    public void s(final WeakReference<ImageView> weakReference, final Drawable drawable, final String str, final WeakReference<com.tencent.biz.pubaccount.weishi.image.a> weakReference2) {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.image.WSPicLoader.2

            /* renamed from: com.tencent.biz.pubaccount.weishi.image.WSPicLoader$2$a */
            /* loaded from: classes32.dex */
            class a implements URLDrawable.URLDrawableListener {
                a() {
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadCanceled(URLDrawable uRLDrawable) {
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    com.tencent.biz.pubaccount.weishi.image.a h16 = WSPicLoader.this.h(weakReference2);
                    if (h16 != null) {
                        h16.a(uRLDrawable);
                    }
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
                    x.f("AvatarImageLog", "WeishiUtils loadAvatarImage onFail url:" + str);
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    com.tencent.biz.pubaccount.weishi.image.a h16 = WSPicLoader.this.h(weakReference2);
                    if (h16 != null) {
                        h16.b(uRLDrawable, th5);
                    }
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    com.tencent.biz.pubaccount.weishi.image.a h16 = WSPicLoader.this.h(weakReference2);
                    if (h16 != null) {
                        h16.c(uRLDrawable, i3);
                    }
                }

                @Override // com.tencent.image.URLDrawable.URLDrawableListener
                public void onLoadSuccessed(URLDrawable uRLDrawable) {
                    ImageView imageView = (ImageView) weakReference.get();
                    if (imageView == null) {
                        return;
                    }
                    x.b("AvatarImageLog", "WeishiUtils loadAvatarImage onSuccess url:" + str);
                    imageView.setImageDrawable(uRLDrawable);
                    AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                    com.tencent.biz.pubaccount.weishi.image.a h16 = WSPicLoader.this.h(weakReference2);
                    if (h16 != null) {
                        h16.onLoadSuccess(uRLDrawable);
                    }
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                ImageView imageView = (ImageView) weakReference.get();
                if (imageView == null) {
                    return;
                }
                imageView.setImageDrawable(drawable);
                Drawable drawable2 = drawable;
                if (drawable2 instanceof URLDrawable) {
                    ((URLDrawable) drawable2).setURLDrawableListener(new a());
                }
            }
        });
    }

    public void t(List<stSimpleMetaFeed> list, boolean z16) {
        u(list, z16, "");
    }

    public void u(List<stSimpleMetaFeed> list, final boolean z16, final String str) {
        if (!NetworkUtil.isWifiConnected(BaseApplication.getContext()) || list == null || list.size() == 0) {
            return;
        }
        x.b("PreloadCoverImgLog", "preloadImg size = " + list.size());
        final ArrayList arrayList = new ArrayList(list);
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.image.WSPicLoader.6
            @Override // java.lang.Runnable
            public void run() {
                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                    stSimpleMetaFeed stsimplemetafeed = (stSimpleMetaFeed) arrayList.get(i3);
                    String n3 = bb.n(stsimplemetafeed, z16);
                    if (!TextUtils.isEmpty(n3)) {
                        Pair<Integer, Integer> i16 = ba.i(stsimplemetafeed);
                        WSPicLoader.this.e(n3, ((Integer) i16.first).intValue(), ((Integer) i16.second).intValue(), str);
                    }
                }
            }
        }, 5, null, true);
    }

    public void f(String str, String str2) {
        e(str, 0, 0, str2);
    }

    public void j(Context context, ImageView imageView, String str) {
        k(context, imageView, str, null);
    }

    public void r(WeakReference<ImageView> weakReference, Drawable drawable, String str) {
        s(weakReference, drawable, str, null);
    }

    public void w(KandianUrlImageView kandianUrlImageView, String str, Drawable drawable) {
        if (kandianUrlImageView == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            kandianUrlImageView.setImageDrawable(drawable);
            return;
        }
        URL c16 = bb.c(str);
        kandianUrlImageView.setIsRecyclerView(true);
        kandianUrlImageView.setImagePlaceHolder(drawable).setImage(c16);
    }

    public void x(ImageView imageView, String str, Drawable drawable, Drawable drawable2, String str2) {
        if (imageView == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            imageView.setImageDrawable(drawable);
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mFailedDrawable = drawable;
        obtain.mLoadingDrawable = drawable2;
        URLDrawable drawable3 = URLDrawable.getDrawable(str, obtain);
        imageView.setImageDrawable(drawable3);
        drawable3.setURLDrawableListener(new a(str2, imageView));
        drawable3.startDownload();
        if (1 != drawable3.getStatus()) {
            drawable3.restartDownload();
            return;
        }
        x.i("815", "onLoad ~~~~~~" + str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.tencent.biz.pubaccount.weishi.image.a h(WeakReference<com.tencent.biz.pubaccount.weishi.image.a> weakReference) {
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void o(Context context, com.tencent.biz.pubaccount.weishi.image.c cVar) {
        if (context == null || cVar == null) {
            return;
        }
        Drawable e16 = cVar.e();
        if (e16 == null) {
            e16 = context.getResources().getDrawable(R.drawable.d7y);
        }
        KandianUrlImageView kandianUrlImageView = (KandianUrlImageView) cVar.a();
        URL c16 = bb.c(cVar.d());
        if (!TextUtils.isEmpty(cVar.d()) && c16 != null) {
            kandianUrlImageView.setPublicAccountImageDownListener(new WSImageDownListener(cVar));
            kandianUrlImageView.setIsRecyclerView(true);
            if (kandianUrlImageView instanceof RoundCornerImageView) {
                RoundCornerImageView roundCornerImageView = (RoundCornerImageView) kandianUrlImageView;
                roundCornerImageView.setImagePlaceHolder(e16);
                roundCornerImageView.setImageSrc(c16);
                return;
            }
            kandianUrlImageView.setImagePlaceHolder(e16).setImage(c16);
            return;
        }
        kandianUrlImageView.setImageDrawable(e16);
    }

    /* loaded from: classes32.dex */
    class c implements k52.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ iy.a f80885a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ URL f80886b;

        c(iy.a aVar, URL url) {
            this.f80885a = aVar;
            this.f80886b = url;
        }

        @Override // k52.a
        public void a(com.tencent.mobileqq.kandian.base.image.b bVar, k52.b bVar2) {
            iy.a aVar = this.f80885a;
            if (aVar != null) {
                aVar.a(this.f80886b, bVar2);
            }
        }

        @Override // k52.a
        public void b(com.tencent.mobileqq.kandian.base.image.b bVar, Throwable th5) {
            x.b("PreloadCoverImgLog", "onFail request = " + bVar);
            iy.a aVar = this.f80885a;
            if (aVar != null) {
                aVar.c(this.f80886b, th5);
            }
        }

        @Override // k52.a
        public void c(com.tencent.mobileqq.kandian.base.image.b bVar, int i3) {
        }
    }
}
