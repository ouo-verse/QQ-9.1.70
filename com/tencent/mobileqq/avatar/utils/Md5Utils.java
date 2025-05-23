package com.tencent.mobileqq.avatar.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.MD5;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u001b\u0010\t\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/avatar/utils/Md5Utils;", "", "", "str", "b", "", "Lkotlin/Lazy;", "a", "()Z", "fixSwitch", "<init>", "()V", "qqavatar-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class Md5Utils {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final Md5Utils f200133a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy fixSwitch;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29850);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f200133a = new Md5Utils();
        lazy = LazyKt__LazyJVMKt.lazy(Md5Utils$fixSwitch$2.INSTANCE);
        fixSwitch = lazy;
    }

    Md5Utils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final boolean a() {
        return ((Boolean) fixSwitch.getValue()).booleanValue();
    }

    @JvmStatic
    @NotNull
    public static final String b(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        if (f200133a.a()) {
            String md5 = MD5.toMD5(str);
            Intrinsics.checkNotNullExpressionValue(md5, "{\n            com.tencen\u2026.MD5.toMD5(str)\n        }");
            return md5;
        }
        String d16 = com.tencent.open.base.g.d(str);
        Intrinsics.checkNotNullExpressionValue(d16, "{\n            MD5.toMD5(str)\n        }");
        return d16;
    }
}
