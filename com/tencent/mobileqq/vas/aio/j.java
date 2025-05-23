package com.tencent.mobileqq.vas.aio;

import android.graphics.drawable.Drawable;
import com.tencent.image.ApngDrawable;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.apng.api.ApngOptions;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\t\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u001e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/vas/aio/j;", "", "", "url", "Landroid/graphics/drawable/Drawable;", "a", "loadingDrawable", "Lcom/tencent/image/ApngDrawable$OnPlayRepeatListener;", "listener", "b", "Lcom/tencent/image/GifDrawable$OnGIFPlayOnceListener;", "gifPlayOnceListener", "c", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public static final j f308385a = new j();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/vas/aio/j$a", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "", "onLoadSuccessed", "", "throwable", "onLoadFialed", "onLoadCanceled", "", "i", "onLoadProgressed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ApngDrawable.OnPlayRepeatListener f308386d;

        a(ApngDrawable.OnPlayRepeatListener onPlayRepeatListener) {
            this.f308386d = onPlayRepeatListener;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable urlDrawable) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable urlDrawable, Throwable throwable) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            Intrinsics.checkNotNullParameter(throwable, "throwable");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable urlDrawable, int i3) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable urlDrawable) {
            Intrinsics.checkNotNullParameter(urlDrawable, "urlDrawable");
            Drawable currDrawable = urlDrawable.getCurrDrawable();
            if (currDrawable instanceof ApngDrawable) {
                ((ApngDrawable) currDrawable).getImage().setOnPlayRepeatListener(this.f308386d);
            }
        }
    }

    j() {
    }

    public final Drawable a(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mPlayGifImage = true;
        obtain.mUseApngImage = true;
        obtain.mUseMemoryCache = true;
        obtain.mMemoryCacheKeySuffix = "aioSmallHomeIcon";
        URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
        if (drawable.getStatus() != 1) {
            drawable.startDownload();
        }
        Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
        return drawable;
    }

    public final Drawable b(Drawable loadingDrawable, String url, ApngDrawable.OnPlayRepeatListener listener) {
        Intrinsics.checkNotNullParameter(loadingDrawable, "loadingDrawable");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(listener, "listener");
        ApngOptions apngOptions = new ApngOptions();
        apngOptions.setLoop(1);
        apngOptions.setLoadingDrawable(loadingDrawable);
        apngOptions.setUseCache(false);
        apngOptions.setLoadListener(new a(listener));
        URLDrawable apngURLDrawable = ((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getApngURLDrawable("VasZplanGifApngUtils", url, apngOptions);
        if (apngURLDrawable != null && apngURLDrawable.getStatus() == 1) {
            apngOptions.getLoadListener().onLoadSuccessed(apngURLDrawable);
        } else if (apngURLDrawable != null) {
            apngURLDrawable.startDownload();
        }
        return apngURLDrawable;
    }

    public final Drawable c(Drawable loadingDrawable, String url, GifDrawable.OnGIFPlayOnceListener gifPlayOnceListener) {
        Intrinsics.checkNotNullParameter(loadingDrawable, "loadingDrawable");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(gifPlayOnceListener, "gifPlayOnceListener");
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = loadingDrawable;
        obtain.mFailedDrawable = loadingDrawable;
        obtain.mPlayGifImage = true;
        obtain.mUseMemoryCache = false;
        URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
        b bVar = new b(gifPlayOnceListener);
        drawable.setURLDrawableListener(bVar);
        if (drawable.getStatus() == 1) {
            bVar.onLoadSuccessed(drawable);
        } else {
            drawable.startDownload();
        }
        Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
        return drawable;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u000bH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/vas/aio/j$b", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "Lcom/tencent/image/URLDrawable;", "urlDrawable", "", "onLoadSuccessed", "p0", "", "p1", "onLoadFialed", "onLoadCanceled", "", "onLoadProgressed", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ GifDrawable.OnGIFPlayOnceListener f308387d;

        b(GifDrawable.OnGIFPlayOnceListener onGIFPlayOnceListener) {
            this.f308387d = onGIFPlayOnceListener;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable urlDrawable) {
            Drawable currDrawable = urlDrawable != null ? urlDrawable.getCurrDrawable() : null;
            if (currDrawable instanceof GifDrawable) {
                ((GifDrawable) currDrawable).setGIFPlayOnceListener(this.f308387d);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable p06) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable p06, Throwable p16) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable p06, int p16) {
        }
    }
}
