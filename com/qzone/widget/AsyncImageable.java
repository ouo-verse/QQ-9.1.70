package com.qzone.widget;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.ImageUrl;
import com.tencent.component.network.utils.AssertUtil;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes37.dex */
public interface AsyncImageable {

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public interface AsyncImageListener {
        void onImageFailed(AsyncImageable asyncImageable);

        void onImageLoaded(AsyncImageable asyncImageable);

        void onImageProgress(AsyncImageable asyncImageable, float f16);

        void onImageStarted(AsyncImageable asyncImageable);
    }

    /* compiled from: P */
    /* loaded from: classes37.dex */
    public static class AsyncImageableImpl implements AsyncImageable {
        private final AsyncImageable C;
        private AsyncImageListener D;
        private AsyncImageListener E;
        private final ImageView F;
        private final b G;
        private final a H;
        private final Thread I;
        private final Handler J;
        private boolean K;
        private boolean L;
        private ImageLoader.Options M;

        /* renamed from: d, reason: collision with root package name */
        private int f60158d = 0;

        /* renamed from: e, reason: collision with root package name */
        private int f60159e = 0;

        /* renamed from: f, reason: collision with root package name */
        private String f60160f = null;

        /* renamed from: h, reason: collision with root package name */
        private String f60161h = null;

        /* renamed from: i, reason: collision with root package name */
        private int f60162i;

        /* renamed from: m, reason: collision with root package name */
        private final ImageLoader.Options f60163m;

        /* compiled from: P */
        /* loaded from: classes37.dex */
        static class a implements IPicLoadStateListener {

            /* renamed from: d, reason: collision with root package name */
            private WeakReference<AsyncImageableImpl> f60167d;

            public a(AsyncImageableImpl asyncImageableImpl) {
                AssertUtil.assertTrue(asyncImageableImpl != null);
                this.f60167d = new WeakReference<>(asyncImageableImpl);
            }

            private AsyncImageableImpl a() {
                WeakReference<AsyncImageableImpl> weakReference = this.f60167d;
                if (weakReference != null) {
                    return weakReference.get();
                }
                return null;
            }

            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public void onStateChange(LoadState loadState, Option option) {
                AsyncImageableImpl a16;
                if (loadState == LoadState.STATE_CANCEL) {
                    AsyncImageableImpl a17 = a();
                    if (a17 == null || a17.m(option.getUrl())) {
                        return;
                    }
                    a17.A();
                    a17.w();
                    return;
                }
                if (loadState != LoadState.STATE_SUCCESS || (a16 = a()) == null || a16.m(option.getUrl())) {
                    return;
                }
                a16.j(new BitmapDrawable(BaseApplication.getContext().getResources(), option.getResultBitMap()));
                a16.x();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes37.dex */
        public static class b implements ImageLoader.ImageLoadListener {

            /* renamed from: d, reason: collision with root package name */
            private WeakReference<AsyncImageableImpl> f60168d;

            public b(AsyncImageableImpl asyncImageableImpl) {
                AssertUtil.assertTrue(asyncImageableImpl != null);
                this.f60168d = new WeakReference<>(asyncImageableImpl);
            }

            private AsyncImageableImpl a() {
                WeakReference<AsyncImageableImpl> weakReference = this.f60168d;
                if (weakReference != null) {
                    return weakReference.get();
                }
                return null;
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageCanceled(String str, ImageLoader.Options options) {
                AsyncImageableImpl a16 = a();
                if (a16 == null || a16.m(str)) {
                    return;
                }
                a16.A();
                a16.w();
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageFailed(String str, ImageLoader.Options options) {
                AsyncImageableImpl a16 = a();
                if (a16 == null || a16.m(str)) {
                    return;
                }
                a16.M = options;
                a16.l();
                a16.H(str);
                a16.A();
                a16.w();
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
                AsyncImageableImpl a16 = a();
                if (a16 == null || a16.m(str)) {
                    return;
                }
                a16.j(drawable);
                a16.x();
            }

            @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
            public void onImageProgress(String str, float f16, ImageLoader.Options options) {
                AsyncImageableImpl a16 = a();
                if (a16 == null || a16.m(str)) {
                    return;
                }
                a16.y(f16);
            }
        }

        public AsyncImageableImpl(ImageView imageView, AsyncImageable asyncImageable) {
            ImageLoader.Options obtain = ImageLoader.Options.obtain();
            this.f60163m = obtain;
            this.I = Looper.getMainLooper().getThread();
            this.J = new Handler(Looper.getMainLooper());
            this.K = true;
            this.L = true;
            this.F = imageView;
            this.G = new b(this);
            this.H = new a(this);
            this.C = asyncImageable;
            obtain.useMainThread = true;
        }

        private void E(final String str, final boolean z16, final ImageUrl imageUrl) {
            if (Thread.currentThread() != this.I) {
                this.J.post(new Runnable() { // from class: com.qzone.widget.AsyncImageable.AsyncImageableImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AsyncImageableImpl.this.F(str, z16, imageUrl);
                    }
                });
            } else {
                F(str, z16, imageUrl);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l() {
            int i3 = this.f60159e;
            if (i3 != 0) {
                this.F.setImageResource(i3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean m(String str) {
            return !r(this.f60160f, str);
        }

        private static boolean n(String str) {
            return !TextUtils.isEmpty(str);
        }

        private void p() {
            int i3 = this.f60162i;
            if (i3 != 0) {
                Drawable drawable = this.F.getDrawable();
                if (drawable == null || drawable.hashCode() != i3) {
                    A();
                    return;
                }
                return;
            }
            A();
        }

        private void q(String str) {
            if (Thread.currentThread() == this.I) {
                return;
            }
            throw new RuntimeException(str + " can ONLY be called within main thread!");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.qzone.widget.AsyncImageable] */
        public void w() {
            AsyncImageListener asyncImageListener = this.D;
            ?? r16 = this.C;
            if (asyncImageListener != null) {
                asyncImageListener.onImageFailed(r16 != 0 ? r16 : this);
            }
            AsyncImageListener asyncImageListener2 = this.E;
            AsyncImageableImpl asyncImageableImpl = r16;
            if (asyncImageListener2 != null) {
                if (r16 == 0) {
                    asyncImageableImpl = this;
                }
                asyncImageListener2.onImageFailed(asyncImageableImpl);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.qzone.widget.AsyncImageable] */
        public void x() {
            AsyncImageListener asyncImageListener = this.D;
            ?? r16 = this.C;
            if (asyncImageListener != null) {
                asyncImageListener.onImageLoaded(r16 != 0 ? r16 : this);
            }
            AsyncImageListener asyncImageListener2 = this.E;
            AsyncImageableImpl asyncImageableImpl = r16;
            if (asyncImageListener2 != null) {
                if (r16 == 0) {
                    asyncImageableImpl = this;
                }
                asyncImageListener2.onImageLoaded(asyncImageableImpl);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.qzone.widget.AsyncImageable] */
        public void y(float f16) {
            AsyncImageListener asyncImageListener = this.D;
            ?? r16 = this.C;
            if (asyncImageListener != null) {
                asyncImageListener.onImageProgress(r16 != 0 ? r16 : this, f16);
            }
            AsyncImageListener asyncImageListener2 = this.E;
            AsyncImageableImpl asyncImageableImpl = r16;
            if (asyncImageListener2 != null) {
                if (r16 == 0) {
                    asyncImageableImpl = this;
                }
                asyncImageListener2.onImageProgress(asyncImageableImpl, f16);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [com.qzone.widget.AsyncImageable] */
        private void z() {
            AsyncImageListener asyncImageListener = this.D;
            ?? r16 = this.C;
            if (asyncImageListener != null) {
                asyncImageListener.onImageStarted(r16 != 0 ? r16 : this);
            }
            AsyncImageListener asyncImageListener2 = this.E;
            AsyncImageableImpl asyncImageableImpl = r16;
            if (asyncImageListener2 != null) {
                if (r16 == 0) {
                    asyncImageableImpl = this;
                }
                asyncImageListener2.onImageStarted(asyncImageableImpl);
            }
        }

        public void B(boolean z16) {
            this.K = z16;
        }

        public void C(ImageUrl imageUrl, String str) {
            E(imageUrl.url, false, imageUrl);
        }

        public void G(Bitmap.Config config) {
            this.f60163m.imageConfig = config;
        }

        public void H(String str) {
            this.f60161h = str;
        }

        public void I(int i3) {
            this.f60163m.mImageType = i3;
        }

        public void J(boolean z16) {
            this.f60163m.isGifPlayWhileDownloading = z16;
        }

        @Override // com.qzone.widget.AsyncImageable
        public void cancelAsyncLoadImage() {
            if (n(this.f60160f)) {
                ImageLoader.getInstance().cancel(this.f60160f, this.G, ImageLoader.Options.copy(this.f60163m));
            }
        }

        @Override // com.qzone.widget.AsyncImageable
        public void cancelAsyncLoadImageWithoutListener() {
            if (n(this.f60160f)) {
                ImageLoader.getInstance().cancel(this.f60160f, null, ImageLoader.Options.copy(this.f60163m));
            }
        }

        @Override // com.qzone.widget.AsyncImageable
        public Drawable getDrawable() {
            return this.F.getDrawable();
        }

        public void k() {
            int i3 = this.f60158d;
            if (i3 != 0) {
                this.F.setImageResource(i3);
            }
        }

        public void o() {
            if (this.f60160f != null) {
                ImageLoader.getInstance().clear(this.f60160f);
                ImageLoader.getInstance().removeImageFile(this.f60160f);
                A();
            }
        }

        public ImageLoader.Options s() {
            return this.M;
        }

        @Override // com.qzone.widget.AsyncImageable
        public void setAsyncClipSize(int i3, int i16) {
            ImageLoader.Options options = this.f60163m;
            if (options.clipWidth == i3 && options.clipHeight == i16) {
                return;
            }
            options.clipWidth = i3;
            options.clipHeight = i16;
            A();
        }

        @Override // com.qzone.widget.AsyncImageable
        public void setAsyncImageListener(AsyncImageListener asyncImageListener) {
            this.D = asyncImageListener;
        }

        @Override // com.qzone.widget.AsyncImageable
        public void setAsyncImageProcessor(ImageProcessor imageProcessor) {
            this.f60163m.extraProcessor = imageProcessor;
        }

        @Override // com.qzone.widget.AsyncImageable
        public void setAsyncJustCover(boolean z16) {
            this.f60163m.justCover = z16;
        }

        @Override // com.qzone.widget.AsyncImageable
        public void setAsyncPreferQuality(boolean z16) {
            this.f60163m.preferQuality = z16;
        }

        @Override // com.qzone.widget.AsyncImageable
        public void setAsyncPriority(boolean z16) {
            this.f60163m.priority = z16;
        }

        @Override // com.qzone.widget.AsyncImageable
        public void setAsyncRootFilePath(String str) {
            this.f60163m.fileRootPath = str;
        }

        @Override // com.qzone.widget.AsyncImageable
        public void setDefaultImage(int i3) {
            this.f60158d = i3;
        }

        @Override // com.qzone.widget.AsyncImageable
        public void setFailImage(int i3) {
            this.f60159e = i3;
        }

        @Override // com.qzone.widget.AsyncImageable
        public void setInternalAsyncImageListener(AsyncImageListener asyncImageListener) {
            this.E = asyncImageListener;
        }

        @Override // com.qzone.widget.AsyncImageable
        public void setNeedDownload(boolean z16) {
            this.L = z16;
        }

        @Override // com.qzone.widget.AsyncImageable
        public void setNeedGifStream(boolean z16) {
            this.f60163m.needShowGifAnimation = z16;
        }

        @Override // com.qzone.widget.AsyncImageable
        public void setNeedPieceLoad(boolean z16) {
            this.f60163m.isNeedPieceLoad = z16;
        }

        @Override // com.qzone.widget.AsyncImageable
        public void setNeedProgress(boolean z16) {
            this.f60163m.needCallBackProcessPercent = z16;
        }

        public String t() {
            return this.f60161h;
        }

        public ImageLoader.Options u() {
            return this.f60163m;
        }

        public String v() {
            return this.f60160f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void A() {
            this.f60160f = null;
        }

        private void D(String str, boolean z16) {
            F(str, z16, null);
        }

        @Override // com.qzone.widget.AsyncImageable
        public void setAsyncImage(String str) {
            D(str, false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j(Drawable drawable) {
            if (drawable != null) {
                this.F.setImageDrawable(drawable);
                this.f60162i = drawable.hashCode();
            } else {
                this.f60162i = 0;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void F(String str, boolean z16, ImageUrl imageUrl) {
            Drawable loadImageSync;
            Drawable drawable = null;
            if (!z16) {
                ImageLoader.Options options = this.f60163m;
                options.needShowPhotoGifAnimation = false;
                options.photoList = null;
                options.photoDelayTimeInMs = 0L;
            }
            q("setAsyncImage");
            p();
            this.f60160f = str;
            this.f60163m.type = AppConstants.HTTP_TYPE_QZONE_DOWNLOAD_PIC;
            if (n(str)) {
                z();
                if (this.L) {
                    loadImageSync = ImageLoader.getInstance().loadImage(imageUrl, str, this.G, ImageLoader.Options.copy(this.f60163m));
                } else {
                    loadImageSync = ImageLoader.getInstance().loadImageSync(imageUrl, str, this.G, ImageLoader.Options.copy(this.f60163m));
                }
                drawable = loadImageSync;
                if (drawable != null) {
                    j(drawable);
                    x();
                }
            }
            if (drawable == null && this.K) {
                k();
            }
        }

        @Override // com.qzone.widget.AsyncImageable
        public void setAsyncImages(ArrayList<String> arrayList, long j3) {
            if (arrayList != null && !arrayList.isEmpty()) {
                if (arrayList.size() != 1 && j3 > 0) {
                    ImageLoader.Options options = this.f60163m;
                    options.needShowPhotoGifAnimation = true;
                    options.photoList = arrayList;
                    options.photoDelayTimeInMs = j3;
                    D(arrayList.get(0), true);
                    return;
                }
                D(arrayList.get(0), false);
                return;
            }
            D(null, false);
        }

        private static boolean r(String str, String str2) {
            return str == str2 || (str != null && str.equals(str2));
        }
    }

    void cancelAsyncLoadImage();

    void cancelAsyncLoadImageWithoutListener();

    Drawable getDrawable();

    void setAsyncClipSize(int i3, int i16);

    void setAsyncImage(String str);

    void setAsyncImageListener(AsyncImageListener asyncImageListener);

    void setAsyncImageProcessor(ImageProcessor imageProcessor);

    void setAsyncImages(ArrayList<String> arrayList, long j3);

    void setAsyncJustCover(boolean z16);

    void setAsyncPreferQuality(boolean z16);

    void setAsyncPriority(boolean z16);

    void setAsyncRootFilePath(String str);

    void setDefaultImage(int i3);

    void setFailImage(int i3);

    void setInternalAsyncImageListener(AsyncImageListener asyncImageListener);

    void setNeedDownload(boolean z16);

    void setNeedGifStream(boolean z16);

    void setNeedPieceLoad(boolean z16);

    void setNeedProgress(boolean z16);
}
