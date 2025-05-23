package com.tencent.aio.view_dsl.dsl;

import android.view.ViewGroup;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.reflect.Method;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0006\u0010\u0001\u001a\u00020\u0000\"\u001d\u0010\u0005\u001a\u0004\u0018\u00010\u00008FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0002\u0010\u0004\u00a8\u0006\u0006"}, d2 = {"Ljava/lang/reflect/Method;", "b", "a", "Lkotlin/Lazy;", "()Ljava/lang/reflect/Method;", "generateDefaultLayoutParamsMethod", "core_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class LayoutBuilderKt {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private static final Lazy f69915a;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(7444);
        $redirector_ = redirector;
        if (redirector == null || !redirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(LayoutBuilderKt$generateDefaultLayoutParamsMethod$2.INSTANCE);
            f69915a = lazy;
        } else {
            redirector.redirect((short) 1);
        }
    }

    @Nullable
    public static final Method a() {
        return (Method) f69915a.getValue();
    }

    @NotNull
    public static final Method b() {
        if (a() != null) {
            Method a16 = a();
            Intrinsics.checkNotNull(a16);
            return a16;
        }
        Method method = ViewGroup.class.getDeclaredMethod("generateDefaultLayoutParams", new Class[0]);
        Intrinsics.checkNotNullExpressionValue(method, "method");
        method.setAccessible(true);
        return method;
    }
}
