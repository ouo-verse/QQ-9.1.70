package com.tencent.aio.api.widget;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\b\n\u0002\b\u0005\"\u001b\u0010\u0004\u001a\u00020\u00008FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0001\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"", "a", "Lkotlin/Lazy;", "()I", "chatPieContainerViewId", "sdk_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class WidgetsKt {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Lazy f69147a;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23498);
        $redirector_ = redirector;
        if (redirector == null || !redirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(WidgetsKt$chatPieContainerViewId$2.INSTANCE);
            f69147a = lazy;
        } else {
            redirector.redirect((short) 1);
        }
    }

    public static final int a() {
        return ((Number) f69147a.getValue()).intValue();
    }
}
