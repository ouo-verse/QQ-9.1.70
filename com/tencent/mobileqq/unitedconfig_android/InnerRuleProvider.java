package com.tencent.mobileqq.unitedconfig_android;

import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.util.SSODebugUtil;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004H\u0016R\u001b\u0010\n\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/unitedconfig_android/InnerRuleProvider;", "Lcom/tencent/mobileqq/unitedconfig_android/f;", "", "c", "", "a", "", "Lkotlin/Lazy;", "b", "()J", "mem", "<init>", "()V", "UnitedConfig-sdk_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class InnerRuleProvider implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mem;

    public InnerRuleProvider() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(InnerRuleProvider$mem$2.INSTANCE);
            this.mem = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final long b() {
        return ((Number) this.mem.getValue()).longValue();
    }

    @Override // com.tencent.mobileqq.unitedconfig_android.f
    @NotNull
    public Map<String, String> a() {
        Map<String, String> mapOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Map) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        String lowerCase = String.valueOf(a.f()).toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("systemVersion", String.valueOf(Build.VERSION.SDK_INT)), TuplesKt.to("memory", String.valueOf(b())), TuplesKt.to("envId", c()), TuplesKt.to("isGrayVersion", lowerCase));
        return mapOf;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (!a.g()) {
            String str = SSODebugUtil.loadTestEnvironment()[1];
            Intrinsics.checkNotNullExpressionValue(str, "{\n            val ssoEnv\u2026  ssoEnvInfo[1]\n        }");
            return str;
        }
        return "";
    }
}
