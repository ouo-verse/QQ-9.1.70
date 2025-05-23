package com.tencent.mobileqq.nearbypro.utils;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.libra.IPicLoader;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.nearbypro.base.f;
import com.tencent.mobileqq.utils.BaseImageUtil;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u0016\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\"\u001d\u0010\f\u001a\u0004\u0018\u00010\u00078FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u001d\u0010\r\u001a\u0004\u0018\u00010\u00078FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\t\u001a\u0004\b\b\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"", "picUrl", "Landroid/widget/ImageView;", "targetView", "", "c", "d", "Landroid/graphics/drawable/Drawable;", "a", "Lkotlin/Lazy;", "b", "()Landroid/graphics/drawable/Drawable;", "defaultLoadingDrawable", "defaultErrorDrawable", "qq_nearby_pro_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class PicLoadUtilsKt {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Lazy f253944a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy f253945b;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Drawable>() { // from class: com.tencent.mobileqq.nearbypro.utils.PicLoadUtilsKt$defaultLoadingDrawable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Drawable invoke() {
                return ResourcesCompat.getDrawable(RFWApplication.getApplication().getResources(), R.drawable.n3f, null);
            }
        });
        f253944a = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<Drawable>() { // from class: com.tencent.mobileqq.nearbypro.utils.PicLoadUtilsKt$defaultErrorDrawable$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final Drawable invoke() {
                return ResourcesCompat.getDrawable(RFWApplication.getApplication().getResources(), R.drawable.n3f, null);
            }
        });
        f253945b = lazy2;
    }

    @Nullable
    public static final Drawable a() {
        return (Drawable) f253945b.getValue();
    }

    @Nullable
    public static final Drawable b() {
        return (Drawable) f253944a.getValue();
    }

    public static final void c(@NotNull String picUrl, @NotNull ImageView targetView) {
        Intrinsics.checkNotNullParameter(picUrl, "picUrl");
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        Option option = Option.getDefaultOptions(targetView).setUrl(picUrl).setTargetView(targetView).setNeedFilterUrl(false).setFailDrawable(BaseImageUtil.getDefaultFaceDrawable()).setLoadingDrawable(BaseImageUtil.getDefaultFaceDrawable());
        com.tencent.mobileqq.nearbypro.base.f<Option, IPicLoadStateListener, IPicLoader> f16 = com.tencent.mobileqq.nearbypro.base.j.f();
        Intrinsics.checkNotNullExpressionValue(option, "option");
        f.a.a(f16, option, null, 2, null);
    }

    public static final void d(@NotNull String picUrl, @NotNull ImageView targetView) {
        Intrinsics.checkNotNullParameter(picUrl, "picUrl");
        Intrinsics.checkNotNullParameter(targetView, "targetView");
        Option needFilterUrl = Option.getDefaultOptions(targetView).setUrl(picUrl).setTargetView(targetView).setNeedFilterUrl(false);
        Drawable drawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        Option option = needFilterUrl.setFailDrawable(drawable).setLoadingDrawable(drawable);
        com.tencent.mobileqq.nearbypro.base.f<Option, IPicLoadStateListener, IPicLoader> f16 = com.tencent.mobileqq.nearbypro.base.j.f();
        Intrinsics.checkNotNullExpressionValue(option, "option");
        f.a.a(f16, option, null, 2, null);
    }
}
