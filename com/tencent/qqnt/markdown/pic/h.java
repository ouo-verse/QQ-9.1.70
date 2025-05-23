package com.tencent.qqnt.markdown.pic;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Size;
import android.widget.ImageView;
import com.tencent.android.androidbypass.enhance.drawable.image.LoadFailedDrawable;
import com.tencent.android.androidbypass.enhance.drawable.image.LoadingDrawable;
import com.tencent.android.androidbypass.enhance.h;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pic.api.IPicAIOApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\rH\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\rH\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001c\u0010\u0015\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\rH\u0016J\u0014\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u00162\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016R&\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001a0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/qqnt/markdown/pic/h;", "Lcom/tencent/android/androidbypass/enhance/g;", "Lcom/tencent/libra/request/Option;", "option", "Lcom/tencent/android/androidbypass/enhance/h$b;", "proxy", "", "j", "", "url", "v", "", "u", "Lcom/tencent/android/androidbypass/enhance/h$a;", "p", DomainData.DOMAIN_NAME, "Lcom/tencent/android/androidbypass/enhance/drawable/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", "a", "c", "Landroid/graphics/drawable/Drawable;", "b", "l", "Ljava/util/WeakHashMap;", "Ljava/lang/ref/WeakReference;", "Ljava/util/WeakHashMap;", "drawableCache", "<init>", "()V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class h implements com.tencent.android.androidbypass.enhance.g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final h f359445a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final WeakHashMap<String, WeakReference<h.b>> drawableCache;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35323);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f359445a = new h();
            drawableCache = new WeakHashMap<>();
        }
    }

    h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void j(final Option option, final h.b proxy) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.markdown.pic.g
            @Override // java.lang.Runnable
            public final void run() {
                h.k(Option.this, proxy);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Option option, h.b proxy) {
        Long l3;
        Intrinsics.checkNotNullParameter(option, "$option");
        Intrinsics.checkNotNullParameter(proxy, "$proxy");
        Bitmap resultBitMap = option.getResultBitMap();
        Object animatable = option.getAnimatable();
        if (resultBitMap != null) {
            proxy.o(resultBitMap);
        } else if (animatable instanceof Drawable) {
            proxy.n((Drawable) animatable);
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[loadDrawable]: libra.seq=");
            sb5.append(option.getSeq());
            sb5.append(", seq=");
            h.b.c e16 = proxy.e();
            if (e16 != null) {
                l3 = Long.valueOf(e16.f72172a);
            } else {
                l3 = null;
            }
            sb5.append(l3);
            sb5.append(" state is success, but no output");
            QLog.e("UrlToDrawableDelegate", 1, sb5.toString());
            return;
        }
        a aVar = a.f359431a;
        String localPath = option.getLocalPath();
        Intrinsics.checkNotNullExpressionValue(localPath, "option.localPath");
        aVar.b(localPath, proxy);
        drawableCache.put(proxy.g(), new WeakReference<>(proxy));
    }

    private final com.tencent.android.androidbypass.enhance.drawable.a m(Option option) {
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
            QLog.e("UrlToDrawableDelegate", 1, "[getRoundDrawableFromOption]: bitmap is null, seq=" + option.getSeq());
            return null;
        }
        return new com.tencent.android.androidbypass.enhance.drawable.a(resultBitMap);
    }

    private final void n(String url, final h.a proxy) {
        Long l3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[handleLoadPicFinishError] seq=");
        h.b.c e16 = proxy.e();
        if (e16 != null) {
            l3 = Long.valueOf(e16.f72172a);
        } else {
            l3 = null;
        }
        sb5.append(l3);
        sb5.append(", url=");
        sb5.append(url);
        QLog.i("UrlToDrawableDelegate", 1, sb5.toString());
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.markdown.pic.d
            @Override // java.lang.Runnable
            public final void run() {
                h.o(h.a.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(h.a proxy) {
        Intrinsics.checkNotNullParameter(proxy, "$proxy");
        proxy.l(f359445a.l(proxy.x()));
    }

    private final void p(String url, final Option option, final h.a proxy) {
        Long l3;
        if (option.getResultBitMap() == null && !(option.getAnimatable() instanceof Drawable)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[onStateChange]|no output seq=");
            h.b.c e16 = proxy.e();
            if (e16 != null) {
                l3 = Long.valueOf(e16.f72172a);
            } else {
                l3 = null;
            }
            sb5.append(l3);
            sb5.append(" url=");
            sb5.append(url);
            QLog.e("UrlToDrawableDelegate", 1, sb5.toString());
            return;
        }
        final com.tencent.android.androidbypass.enhance.drawable.a m3 = m(option);
        if (m3 != null) {
            m3.g(0.0f);
            m3.h(proxy.z(ViewUtils.dpToPx(4.0f)));
            m3.k(ImageView.ScaleType.FIT_XY);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.markdown.pic.e
                @Override // java.lang.Runnable
                public final void run() {
                    h.q(Option.this, proxy, m3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Option option, h.a proxy, com.tencent.android.androidbypass.enhance.drawable.a it) {
        Intrinsics.checkNotNullParameter(option, "$option");
        Intrinsics.checkNotNullParameter(proxy, "$proxy");
        Intrinsics.checkNotNullParameter(it, "$it");
        a aVar = a.f359431a;
        String localPath = option.getLocalPath();
        Intrinsics.checkNotNullExpressionValue(localPath, "option.localPath");
        aVar.b(localPath, proxy);
        proxy.b(it);
        drawableCache.put(proxy.g(), new WeakReference<>(proxy));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(final h.b proxy, String url, final Context context, LoadState loadState, Option option) {
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
            h hVar = f359445a;
            Intrinsics.checkNotNullExpressionValue(option, "option");
            hVar.j(option, proxy);
            return;
        }
        if (loadState != null && loadState.isFinishError()) {
            z17 = true;
        }
        if (z17) {
            QLog.e("UrlToDrawableDelegate", 1, "[loadDrawable]: isFinishError, seq=" + option.getSeq() + ", url=" + url);
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.markdown.pic.f
                @Override // java.lang.Runnable
                public final void run() {
                    h.s(h.b.this, context);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(h.b proxy, Context context) {
        Intrinsics.checkNotNullParameter(proxy, "$proxy");
        proxy.l(f359445a.l(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(String str, h.a aVar, LoadState loadState, Option option) {
        boolean z16;
        boolean z17 = true;
        if (loadState != null && loadState.isFinishSuccess()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            h hVar = f359445a;
            Intrinsics.checkNotNullExpressionValue(option, "option");
            hVar.p(str, option, aVar);
        } else {
            if (loadState == null || !loadState.isFinishError()) {
                z17 = false;
            }
            if (z17) {
                f359445a.n(str, aVar);
            }
        }
    }

    private final boolean u(String url, h.b proxy) {
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

    private final Option v(String url, h.b proxy) {
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
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, url, proxy);
            return;
        }
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(proxy, "proxy");
        h.b.c e16 = proxy.e();
        if (e16 != null) {
            j3 = e16.f72172a;
        } else {
            j3 = 0;
        }
        if (u(url, proxy)) {
            QLog.d("UrlToDrawableDelegate", 1, "[loadDrawable] hitCache, seq=" + j3 + ", url=" + url);
            return;
        }
        ((IPicAIOApi) QRoute.api(IPicAIOApi.class)).loadPic(v(url, proxy), new IPicLoadStateListener() { // from class: com.tencent.qqnt.markdown.pic.c
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                h.r(h.b.this, url, context, loadState, option);
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
        Long l3;
        h.b.c e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) url, (Object) proxy);
            return;
        }
        h.b bVar = null;
        if (proxy != null && (e16 = proxy.e()) != null) {
            l3 = Long.valueOf(e16.f72172a);
        } else {
            l3 = null;
        }
        if (url != null && proxy != null) {
            WeakReference<h.b> weakReference = drawableCache.get(url);
            if (weakReference != null) {
                bVar = weakReference.get();
            }
            if (bVar != null && Intrinsics.areEqual(bVar.c(), proxy.c())) {
                proxy.b(bVar.f());
                Map<String, Object> d16 = proxy.d();
                Map<String, Object> d17 = bVar.d();
                Intrinsics.checkNotNullExpressionValue(d17, "cache.extraData");
                d16.putAll(d17);
                QLog.d("UrlToDrawableDelegate", 1, "[loadDrawable]: hit cache, seq=" + l3 + " url=" + url);
                return;
            }
            IPicAIOApi iPicAIOApi = (IPicAIOApi) QRoute.api(IPicAIOApi.class);
            Option url2 = Option.obtain().setRequestHeight((int) (proxy.y() * 0.8f)).setRequestWidth((int) (proxy.C() * 0.8f)).setUrl(url);
            QLog.d("UrlToDrawableDelegate", 1, "libra.seq=" + url2.getSeq() + ", seq=" + l3);
            Intrinsics.checkNotNullExpressionValue(url2, "obtain()\n               \u2026aceId\")\n                }");
            iPicAIOApi.loadPic(url2, new IPicLoadStateListener() { // from class: com.tencent.qqnt.markdown.pic.b
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    h.t(url, proxy, loadState, option);
                }
            });
            return;
        }
        QLog.e("UrlToDrawableDelegate", 1, "[loadDrawable]: seq=" + l3 + ", url=" + url);
    }

    @Nullable
    public Drawable l(@Nullable Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Drawable) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
        }
        if (context == null) {
            return null;
        }
        WeakReference weakReference = new WeakReference(context);
        int color = context.getColor(R.color.qui_common_overlay_light);
        int color2 = context.getColor(R.color.qui_common_text_tertiary);
        Drawable drawable = context.getDrawable(R.drawable.j7n);
        Intrinsics.checkNotNull(drawable);
        return new LoadFailedDrawable(new com.tencent.android.androidbypass.enhance.drawable.image.a(weakReference, color, color2, drawable));
    }
}
