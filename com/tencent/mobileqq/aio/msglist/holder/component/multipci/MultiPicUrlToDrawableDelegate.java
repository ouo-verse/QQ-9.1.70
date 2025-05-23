package com.tencent.mobileqq.aio.msglist.holder.component.multipci;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Size;
import android.widget.ImageView;
import com.tencent.android.androidbypass.enhance.drawable.image.LoadingDrawable;
import com.tencent.android.androidbypass.enhance.g;
import com.tencent.android.androidbypass.enhance.h;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pic.api.IPicAIOApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u0006H\u0002J\"\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0012H\u0016J\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R&\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00170\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0018R\u001b\u0010\u001d\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/multipci/MultiPicUrlToDrawableDelegate;", "Lcom/tencent/android/androidbypass/enhance/g;", "", "url", "Lcom/tencent/android/androidbypass/enhance/h$b;", "proxy", "Lcom/tencent/libra/request/Option;", "p", "", "o", "option", "", h.F, "Lcom/tencent/android/androidbypass/enhance/drawable/a;", "k", "Landroid/content/Context;", "context", "a", "Lcom/tencent/android/androidbypass/enhance/h$a;", "c", "Landroid/graphics/drawable/Drawable;", "b", "Ljava/util/WeakHashMap;", "Ljava/lang/ref/WeakReference;", "Ljava/util/WeakHashMap;", "drawableCache", "Lkotlin/Lazy;", "j", "()Landroid/graphics/drawable/Drawable;", "loadingDrawable", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class MultiPicUrlToDrawableDelegate implements g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final MultiPicUrlToDrawableDelegate f191311a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final WeakHashMap<String, WeakReference<h.b>> drawableCache;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy loadingDrawable;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62555);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
            return;
        }
        f191311a = new MultiPicUrlToDrawableDelegate();
        drawableCache = new WeakHashMap<>();
        lazy = LazyKt__LazyJVMKt.lazy(MultiPicUrlToDrawableDelegate$loadingDrawable$2.INSTANCE);
        loadingDrawable = lazy;
    }

    MultiPicUrlToDrawableDelegate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void h(final Option option, final h.b proxy) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.multipci.f
            @Override // java.lang.Runnable
            public final void run() {
                MultiPicUrlToDrawableDelegate.i(Option.this, proxy);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Option option, h.b proxy) {
        Intrinsics.checkNotNullParameter(option, "$option");
        Intrinsics.checkNotNullParameter(proxy, "$proxy");
        Bitmap resultBitMap = option.getResultBitMap();
        Object animatable = option.getAnimatable();
        if (resultBitMap != null) {
            proxy.o(resultBitMap);
        } else if (animatable instanceof Drawable) {
            proxy.n((Drawable) animatable);
        } else {
            QLog.e("MultiPicUrlToDrawableDelegate", 1, "[loadDrawable]");
            return;
        }
        com.tencent.qqnt.markdown.pic.a aVar = com.tencent.qqnt.markdown.pic.a.f359431a;
        String localPath = option.getLocalPath();
        Intrinsics.checkNotNullExpressionValue(localPath, "option.localPath");
        aVar.b(localPath, proxy);
        drawableCache.put(proxy.g(), new WeakReference<>(proxy));
    }

    private final Drawable j() {
        return (Drawable) loadingDrawable.getValue();
    }

    private final com.tencent.android.androidbypass.enhance.drawable.a k(Option option) {
        Drawable drawable;
        Bitmap resultBitMap = option.getResultBitMap();
        if (resultBitMap == null) {
            Object animatable = option.getAnimatable();
            if (animatable instanceof Drawable) {
                drawable = (Drawable) animatable;
            } else {
                drawable = null;
            }
            if (drawable != null) {
                resultBitMap = com.tencent.android.androidbypass.enhance.drawable.a.c(drawable);
            } else {
                resultBitMap = null;
            }
        }
        if (resultBitMap == null) {
            QLog.e("MultiPicUrlToDrawableDelegate", 1, "[getRoundDrawableFromOption]: bitmap is null, url=" + option.getUrl());
            return null;
        }
        return new com.tencent.android.androidbypass.enhance.drawable.a(resultBitMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(final h.b proxy, String url, final Context context, LoadState loadState, Option option) {
        boolean z16;
        Intrinsics.checkNotNullParameter(proxy, "$proxy");
        Intrinsics.checkNotNullParameter(url, "$url");
        boolean z17 = false;
        if (loadState != null && loadState.isFinishSuccess()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            MultiPicUrlToDrawableDelegate multiPicUrlToDrawableDelegate = f191311a;
            Intrinsics.checkNotNullExpressionValue(option, "option");
            multiPicUrlToDrawableDelegate.h(option, proxy);
            return;
        }
        if (loadState != null && loadState.isFinishError()) {
            z17 = true;
        }
        if (z17) {
            QLog.e("MultiPicUrlToDrawableDelegate", 1, "[loadDrawable]: isFinishError, seq=" + option.getSeq() + ", url=" + url);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.multipci.e
                @Override // java.lang.Runnable
                public final void run() {
                    MultiPicUrlToDrawableDelegate.m(h.b.this, context);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(h.b proxy, Context context) {
        Intrinsics.checkNotNullParameter(proxy, "$proxy");
        proxy.l(com.tencent.qqnt.markdown.pic.h.f359445a.l(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(String str, h.a aVar, LoadState loadState, Option option) {
        boolean z16 = false;
        if (loadState != null && loadState.isFinishSuccess()) {
            z16 = true;
        }
        if (z16 && new File(str).exists()) {
            MultiPicUrlToDrawableDelegate multiPicUrlToDrawableDelegate = f191311a;
            Intrinsics.checkNotNullExpressionValue(option, "option");
            com.tencent.android.androidbypass.enhance.drawable.a k3 = multiPicUrlToDrawableDelegate.k(option);
            if (k3 != null) {
                k3.g(0.0f);
                k3.h(aVar.z(ViewUtils.dpToPx(4.0f)));
                k3.k(ImageView.ScaleType.CENTER_CROP);
                com.tencent.qqnt.markdown.pic.a aVar2 = com.tencent.qqnt.markdown.pic.a.f359431a;
                String localPath = option.getLocalPath();
                Intrinsics.checkNotNullExpressionValue(localPath, "option.localPath");
                aVar2.b(localPath, aVar);
                aVar.b(k3);
                drawableCache.put(aVar.g(), new WeakReference<>(aVar));
                return;
            }
            return;
        }
        aVar.b(f191311a.j());
    }

    private final boolean o(String url, h.b proxy) {
        h.b bVar;
        WeakReference<h.b> weakReference = drawableCache.get(url);
        if (weakReference != null && (bVar = weakReference.get()) != null) {
            proxy.b(bVar.f());
            Map<String, Object> d16 = proxy.d();
            Map<String, Object> d17 = bVar.d();
            Intrinsics.checkNotNullExpressionValue(d17, "it.extraData");
            d16.putAll(d17);
            return true;
        }
        return false;
    }

    private final Option p(String url, h.b proxy) {
        Option obtain = Option.obtain();
        obtain.setUrl(url);
        h.b.c e16 = proxy.e();
        if (e16 != null) {
            Size size = e16.f72173b;
            if (size != null) {
                obtain.setRequestWidth(size.getWidth());
                obtain.setRequestHeight(size.getHeight());
            }
            ImageView.ScaleType scaleType = e16.f72175d;
            if (e16.f72174c && scaleType != null) {
                obtain.setDecodeMode(1);
                obtain.setRegionScaleType(e16.f72175d);
            }
        }
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain().apply {\n       \u2026}\n            }\n        }");
        return obtain;
    }

    @Override // com.tencent.android.androidbypass.enhance.g
    public void a(@Nullable final Context context, @NotNull final String url, @NotNull final h.b proxy) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, url, proxy);
            return;
        }
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        if (o(url, proxy)) {
            QLog.d("MultiPicUrlToDrawableDelegate", 1, "[loadDrawable] hitCache, url=" + url);
            return;
        }
        ((IPicAIOApi) QRoute.api(IPicAIOApi.class)).loadPic(p(url, proxy), new IPicLoadStateListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.multipci.d
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                MultiPicUrlToDrawableDelegate.l(h.b.this, url, context, loadState, option);
            }
        });
    }

    @Override // com.tencent.android.androidbypass.enhance.g
    @Nullable
    public Drawable b(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Drawable) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        }
        if (context == null) {
            return null;
        }
        return new LoadingDrawable(new com.tencent.android.androidbypass.enhance.drawable.image.b(new WeakReference(context), context.getColor(R.color.qui_common_overlay_light), context.getColor(R.color.qui_common_text_tertiary)));
    }

    @Override // com.tencent.android.androidbypass.enhance.g
    public void c(@Nullable final String url, @Nullable final h.a proxy) {
        boolean z16;
        h.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) url, (Object) proxy);
            return;
        }
        if (proxy != null) {
            proxy.m(j());
        }
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && !Intrinsics.areEqual(url, "unknown") && proxy != null) {
            WeakReference<h.b> weakReference = drawableCache.get(url);
            if (weakReference != null) {
                bVar = weakReference.get();
            } else {
                bVar = null;
            }
            if (bVar != null && Intrinsics.areEqual(bVar.c(), proxy.c())) {
                proxy.b(bVar.f());
                Map<String, Object> d16 = proxy.d();
                Map<String, Object> d17 = bVar.d();
                Intrinsics.checkNotNullExpressionValue(d17, "cache.extraData");
                d16.putAll(d17);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MultiPicUrlToDrawableDelegate", 2, "loadDrawable: " + url);
            }
            IPicAIOApi iPicAIOApi = (IPicAIOApi) QRoute.api(IPicAIOApi.class);
            Option url2 = Option.obtain().setRequestHeight(proxy.y()).setRequestWidth(proxy.C()).setUrl(url);
            Intrinsics.checkNotNullExpressionValue(url2, "obtain()\n               \u2026             .setUrl(url)");
            iPicAIOApi.loadPic(url2, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.aio.msglist.holder.component.multipci.c
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    MultiPicUrlToDrawableDelegate.n(url, proxy, loadState, option);
                }
            });
            return;
        }
        QLog.e("MultiPicUrlToDrawableDelegate", 1, "[loadDrawable]: url=" + url + ", proxy=" + proxy);
    }
}
