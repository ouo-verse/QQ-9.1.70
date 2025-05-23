package com.tencent.mobileqq.qcoroutine.souce;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DefaultExecutorKt;
import kotlinx.coroutines.Delay;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a\u0006\u0010\u0001\u001a\u00020\u0000\u001a\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0000\"\u0017\u0010\b\u001a\u00020\u00008\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lkotlinx/coroutines/Delay;", "b", "", "", "a", "Lkotlinx/coroutines/Delay;", "c", "()Lkotlinx/coroutines/Delay;", "qdelay", "QCoroutine_debug"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes16.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Delay f261856a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11963);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f261856a = b();
        }
    }

    public static final void a(int i3) {
        boolean z16 = true;
        if (i3 < 1) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        throw new IllegalArgumentException(("Expected positive parallelism level, but got " + i3).toString());
    }

    @NotNull
    public static final Delay b() {
        int i3 = DefaultExecutorKt.f412771a;
        Field declaredField = DefaultExecutorKt.class.getDeclaredField("DefaultDelay");
        Intrinsics.checkNotNullExpressionValue(declaredField, "classc.getDeclaredField(\"DefaultDelay\")");
        declaredField.setAccessible(true);
        Object obj = declaredField.get(DefaultExecutorKt.class);
        if (obj != null) {
            return (Delay) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.Delay");
    }

    @NotNull
    public static final Delay c() {
        return f261856a;
    }
}
