package com.tencent.mvi.mvvm.extension;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.exception.MviException;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0005\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mvi/mvvm/extension/c;", "", "", "providerToken", "Lcom/tencent/mvi/api/ability/c;", "generator", "", "a", "b", "", "Ljava/util/Map;", "stateGenerator", "<init>", "()V", "mvi_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes21.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, com.tencent.mvi.api.ability.c> stateGenerator;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final c f337790b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13989);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f337790b = new c();
            stateGenerator = new LinkedHashMap();
        }
    }

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    public final void a(@NotNull String providerToken, @NotNull com.tencent.mvi.api.ability.c generator) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) providerToken, (Object) generator);
            return;
        }
        Intrinsics.checkNotNullParameter(providerToken, "providerToken");
        Intrinsics.checkNotNullParameter(generator, "generator");
        Map<String, com.tencent.mvi.api.ability.c> map = stateGenerator;
        if (!map.containsKey(providerToken)) {
            map.put(providerToken, generator);
            return;
        }
        throw new MviException("please check! token " + providerToken + " already have generator " + generator);
    }

    public final void b(@NotNull String providerToken) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) providerToken);
        } else {
            Intrinsics.checkNotNullParameter(providerToken, "providerToken");
            stateGenerator.remove(providerToken);
        }
    }
}
