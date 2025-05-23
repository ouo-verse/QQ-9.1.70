package com.tencent.biz.qui.quisecnavbar;

import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\t\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBarBlurUtil;", "", "Landroid/content/Context;", "context", "", "b", "a", "Lkotlin/Lazy;", "()Z", "needBlurFilter", "<init>", "()V", "QUISecNavBar_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes5.dex */
public final class QUISecNavBarBlurUtil {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Lazy needBlurFilter;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final QUISecNavBarBlurUtil f95260b = new QUISecNavBarBlurUtil();

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.biz.qui.quisecnavbar.QUISecNavBarBlurUtil$needBlurFilter$2
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Boolean invoke() {
                return Boolean.valueOf(invoke2());
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final boolean invoke2() {
                boolean b16 = ud0.g.b("qui_nav_bar_blur_filter", false);
                Object a16 = ud0.c.a(td0.f.class);
                Intrinsics.checkNotNullExpressionValue(a16, "QUIDelegate.getDelegate(\u2026BlurDelegate::class.java)");
                boolean z16 = b16 || !((td0.f) a16).a();
                ud0.d.g("QUISecNavBar", ud0.d.f438811e, "needBlurFilter: " + z16);
                return z16;
            }
        });
        needBlurFilter = lazy;
    }

    QUISecNavBarBlurUtil() {
    }

    private final boolean a() {
        return ((Boolean) needBlurFilter.getValue()).booleanValue();
    }

    public final boolean b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!e.d()) {
            ud0.d.b("QUISecNavBar", ud0.d.f438810d, "Only default theme support blur.");
        } else {
            if (!a() || com.tencent.qui.quiblurview.c.f363628c.b(context)) {
                return true;
            }
            ud0.d.b("QUISecNavBar", ud0.d.f438811e, "The device does not support blur.");
        }
        return false;
    }
}
