package com.tencent.mobileqq.troop.troopnotification.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002R'\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/data/TroopSuspiciousTipsConfig;", "", "", "code", "b", "a", "", "Lorg/json/JSONObject;", "Lkotlin/Lazy;", "c", "()Ljava/util/Map;", "jsonConfig", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSuspiciousTipsConfig {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TroopSuspiciousTipsConfig f300660a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy jsonConfig;

    static {
        Lazy lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(58624);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        f300660a = new TroopSuspiciousTipsConfig();
        lazy = LazyKt__LazyJVMKt.lazy(TroopSuspiciousTipsConfig$jsonConfig$2.INSTANCE);
        jsonConfig = lazy;
    }

    TroopSuspiciousTipsConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Map<String, JSONObject> c() {
        return (Map) jsonConfig.getValue();
    }

    @NotNull
    public final String a(@NotNull String code) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) code);
        }
        Intrinsics.checkNotNullParameter(code, "code");
        JSONObject jSONObject = c().get(code);
        if (jSONObject != null) {
            str = jSONObject.optString("detailErrorTips");
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    @NotNull
    public final String b(@NotNull String code) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) code);
        }
        Intrinsics.checkNotNullParameter(code, "code");
        JSONObject jSONObject = c().get(code);
        if (jSONObject != null) {
            str = jSONObject.optString("errorTips");
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }
}
