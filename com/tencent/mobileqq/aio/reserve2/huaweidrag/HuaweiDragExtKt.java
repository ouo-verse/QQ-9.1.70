package com.tencent.mobileqq.aio.reserve2.huaweidrag;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a\b\u0010\u0001\u001a\u00020\u0000H\u0002\"\u001b\u0010\u0006\u001a\u00020\u00008@X\u0080\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0007"}, d2 = {"", "b", "a", "Lkotlin/Lazy;", "c", "()Z", "isHarmonyOs", "aio_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class HuaweiDragExtKt {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Lazy f193469a;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(64883);
        $redirector_ = redirector;
        if (redirector == null || !redirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(HuaweiDragExtKt$isHarmonyOs$2.INSTANCE);
            f193469a = lazy;
        } else {
            redirector.redirect((short) 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean b() {
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            String obj = cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]).toString();
            Locale locale = Locale.ROOT;
            String lowerCase = "Harmony".toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            String lowerCase2 = obj.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            return TextUtils.equals(lowerCase, lowerCase2);
        } catch (Exception unused) {
            return false;
        }
    }

    public static final boolean c() {
        return ((Boolean) f193469a.getValue()).booleanValue();
    }
}
