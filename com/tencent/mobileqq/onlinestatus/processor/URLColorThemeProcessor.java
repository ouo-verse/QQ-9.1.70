package com.tencent.mobileqq.onlinestatus.processor;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import androidx.appcompat.content.res.AppCompatResources;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.onlinestatus.coroutine.OnlineStatusDispatchers;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusImmersiveThemeUtilsKt;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.theme.SkinConstants;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.net.MalformedURLException;
import java.net.URL;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001cB\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u00a2\u0006\u0004\bB\u0010CJ\"\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u0007J*\u0010\u0014\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004J\u0018\u0010\u0016\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u001a\u001a\u00020\u0007R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010&\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010#R\u0016\u0010)\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u00101R\u001b\u00106\u001a\u0002038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u00104\u001a\u0004\b*\u00105R\u0018\u00108\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u00107R\u001b\u0010;\u001a\u0002098BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u00104\u001a\u0004\b-\u0010:R\u001e\u0010?\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010>R\u0016\u0010A\u001a\u0004\u0018\u00010=8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010@\u00a8\u0006D"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/processor/URLColorThemeProcessor;", "", "", "urlStr", "", "defaultResId", SkinConstants.TintConstant.KEY_DEFAULT_COLOR, "", h.F, "Ljava/net/URL;", "url", "j", "Lcom/tencent/mobileqq/onlinestatus/processor/URLColorThemeProcessor$a;", "listener", "p", "", "needForceReload", "o", DomainData.DOMAIN_NAME, "fallbackUrl", "i", "themeColor", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/image/URLDrawable;", "drawable", "l", "k", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "b", "Z", "mNeedForceReload", "c", "Ljava/lang/String;", "mCurrentUrlStr", "d", "mFallbackUrlStr", "e", "I", "mDefaultResId", "f", "mDefaultColor", "Lcom/tencent/mobileqq/onlinestatus/processor/ImageLoadingState;", "g", "Lcom/tencent/mobileqq/onlinestatus/processor/ImageLoadingState;", "mImageLoadingState", "Lcom/tencent/mobileqq/onlinestatus/processor/ImageLoadingType;", "Lcom/tencent/mobileqq/onlinestatus/processor/ImageLoadingType;", "mImageLoadingType", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Lazy;", "()Lkotlinx/coroutines/CoroutineScope;", "mNormalScope", "Lcom/tencent/mobileqq/onlinestatus/processor/URLColorThemeProcessor$a;", "mOnGetColorListener", "Lcom/tencent/mobileqq/onlinestatus/processor/c;", "()Lcom/tencent/mobileqq/onlinestatus/processor/c;", "mURLColorDrawableListener", "Ljava/lang/ref/SoftReference;", "Landroid/graphics/drawable/Drawable;", "Ljava/lang/ref/SoftReference;", "mDefaultDrawableRef", "()Landroid/graphics/drawable/Drawable;", "defaultDrawable", "<init>", "(Landroid/content/Context;)V", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class URLColorThemeProcessor {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean mNeedForceReload;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mCurrentUrlStr;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mFallbackUrlStr;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mDefaultResId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mDefaultColor;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageLoadingState mImageLoadingState;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ImageLoadingType mImageLoadingType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mNormalScope;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a mOnGetColorListener;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mURLColorDrawableListener;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SoftReference<Drawable> mDefaultDrawableRef;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/onlinestatus/processor/URLColorThemeProcessor$a;", "", "", "success", "", "url", "Landroid/graphics/drawable/Drawable;", "drawable", "", "color", "", "c", "qqonlinestatus-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes16.dex */
    public interface a {
        void c(boolean success, @NotNull String url, @Nullable Drawable drawable, int color);
    }

    public URLColorThemeProcessor(@NotNull Context context) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.mCurrentUrlStr = "";
        this.mFallbackUrlStr = "";
        this.mDefaultResId = -1;
        this.mDefaultColor = -2430214;
        this.mImageLoadingState = ImageLoadingState.INIT;
        this.mImageLoadingType = ImageLoadingType.URL;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineScope>() { // from class: com.tencent.mobileqq.onlinestatus.processor.URLColorThemeProcessor$mNormalScope$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CoroutineScope invoke() {
                return CoroutineScopeKt.CoroutineScope(OnlineStatusDispatchers.f255840a.b());
            }
        });
        this.mNormalScope = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.onlinestatus.processor.URLColorThemeProcessor$mURLColorDrawableListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final c invoke() {
                return new c(URLColorThemeProcessor.this);
            }
        });
        this.mURLColorDrawableListener = lazy2;
        if (OnlineStatusToggleUtils.d()) {
            this.mDefaultColor = -1708289;
        }
    }

    private final Drawable e() {
        Drawable drawable;
        SoftReference<Drawable> softReference = null;
        if (this.mDefaultResId <= 0) {
            return null;
        }
        SoftReference<Drawable> softReference2 = this.mDefaultDrawableRef;
        if (softReference2 != null) {
            drawable = softReference2.get();
        } else {
            drawable = null;
        }
        if (drawable == null) {
            drawable = AppCompatResources.getDrawable(this.context, this.mDefaultResId);
            if (drawable != null) {
                softReference = d.a(drawable);
            }
            this.mDefaultDrawableRef = softReference;
        }
        return drawable;
    }

    private final CoroutineScope f() {
        return (CoroutineScope) this.mNormalScope.getValue();
    }

    private final c g() {
        return (c) this.mURLColorDrawableListener.getValue();
    }

    private final void h(String urlStr, int defaultResId, int defaultColor) {
        String str;
        if (defaultResId != this.mDefaultResId) {
            this.mDefaultResId = defaultResId;
            this.mDefaultDrawableRef = null;
        }
        if (urlStr != null && !TextUtils.isEmpty(urlStr)) {
            if (Intrinsics.areEqual(this.mCurrentUrlStr, urlStr) && this.mImageLoadingState == ImageLoadingState.SUCCESS && !this.mNeedForceReload) {
                return;
            }
            this.mDefaultColor = defaultColor;
            this.mCurrentUrlStr = urlStr;
            try {
                j(new URL(urlStr));
                return;
            } catch (MalformedURLException e16) {
                QLog.e("URLColorThemeProcessor", 1, "Invalid url: " + urlStr + "\n", e16);
                k();
                return;
            }
        }
        if (urlStr == null) {
            str = "";
        } else {
            str = urlStr;
        }
        this.mCurrentUrlStr = str;
        this.mDefaultColor = defaultColor;
        this.mImageLoadingType = ImageLoadingType.DEFAULT;
        a aVar = this.mOnGetColorListener;
        if (aVar != null) {
            if (urlStr == null) {
                urlStr = "";
            }
            aVar.c(true, urlStr, e(), this.mDefaultColor);
        }
    }

    private final void j(URL url) {
        if (URLDrawable.depImp == null) {
            QLog.e("URLColorThemeProcessor", 1, "URLDrawable not init!");
            k();
            return;
        }
        this.mImageLoadingState = ImageLoadingState.LOADING;
        Integer a16 = OnlineStatusImmersiveThemeUtilsKt.a(this.mCurrentUrlStr);
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        Drawable e16 = e();
        obtain.mLoadingDrawable = e16;
        obtain.mFailedDrawable = e16;
        URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
        drawable.setURLDrawableListener(g());
        if (drawable.getStatus() == 1) {
            if (a16 != null) {
                this.mImageLoadingState = ImageLoadingState.SUCCESS;
                a aVar = this.mOnGetColorListener;
                if (aVar != null) {
                    aVar.c(true, this.mCurrentUrlStr, drawable, a16.intValue());
                    return;
                }
                return;
            }
            Intrinsics.checkNotNullExpressionValue(drawable, "drawable");
            l(drawable);
            return;
        }
        QLog.d("URLColorThemeProcessor", 1, "Start to download image: " + this.mCurrentUrlStr);
        drawable.startDownload();
    }

    public final void i(@Nullable String urlStr, @Nullable String fallbackUrl, int defaultResId, int defaultColor) {
        if (fallbackUrl == null) {
            fallbackUrl = "";
        }
        this.mFallbackUrlStr = fallbackUrl;
        if (urlStr != null && !Intrinsics.areEqual(urlStr, "")) {
            this.mImageLoadingType = ImageLoadingType.URL;
            h(urlStr, defaultResId, defaultColor);
        } else {
            this.mImageLoadingType = ImageLoadingType.FALLBACK;
            h(this.mFallbackUrlStr, defaultResId, defaultColor);
        }
    }

    public final void k() {
        if (this.mImageLoadingType == ImageLoadingType.URL) {
            this.mImageLoadingType = ImageLoadingType.FALLBACK;
            h(this.mFallbackUrlStr, this.mDefaultResId, this.mDefaultColor);
            return;
        }
        this.mImageLoadingState = ImageLoadingState.FAILED;
        this.mImageLoadingType = ImageLoadingType.DEFAULT;
        a aVar = this.mOnGetColorListener;
        if (aVar != null) {
            aVar.c(false, this.mCurrentUrlStr, e(), this.mDefaultColor);
        }
        this.mCurrentUrlStr = "";
    }

    public final void l(@NotNull URLDrawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        BuildersKt__Builders_commonKt.launch$default(f(), null, null, new URLColorThemeProcessor$onDrawableSuccessLoad$1(drawable, this, null), 3, null);
    }

    public final void m(@Nullable String urlStr, int themeColor) {
        if (urlStr != null && !Intrinsics.areEqual(urlStr, "")) {
            OnlineStatusImmersiveThemeUtilsKt.d(urlStr, themeColor);
        }
    }

    public final void n() {
        this.mCurrentUrlStr = "";
        this.mImageLoadingState = ImageLoadingState.INIT;
    }

    public final void o(boolean needForceReload) {
        this.mNeedForceReload = needForceReload;
    }

    public final void p(@Nullable a listener) {
        this.mOnGetColorListener = listener;
    }
}
