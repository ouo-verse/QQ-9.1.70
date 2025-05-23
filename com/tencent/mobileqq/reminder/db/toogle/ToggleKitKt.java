package com.tencent.mobileqq.reminder.db.toogle;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a,\u0010\u0004\u001a\u00020\u00012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00002\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000H\u0000\"\u001b\u0010\t\u001a\u00020\u00058FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0006\u0010\b\u00a8\u0006\n"}, d2 = {"Lkotlin/Function0;", "", "opt", "orNot", "b", "", "a", "Lkotlin/Lazy;", "()Z", "optConfig", "qqreminder-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class ToggleKitKt {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Lazy f281054a;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28790);
        $redirector_ = redirector;
        if (redirector == null || !redirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(ToggleKitKt$optConfig$2.INSTANCE);
            f281054a = lazy;
        } else {
            redirector.redirect((short) 1);
        }
    }

    public static final boolean a() {
        return ((Boolean) f281054a.getValue()).booleanValue();
    }

    public static final void b(@Nullable Function0<Unit> function0, @Nullable Function0<Unit> function02) {
        if (a()) {
            if (function0 != null) {
                function0.invoke();
            }
        } else if (function02 != null) {
            function02.invoke();
        }
    }
}
