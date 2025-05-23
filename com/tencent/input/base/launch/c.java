package com.tencent.input.base.launch;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.api.runtime.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/input/base/launch/c;", "Lcom/tencent/mvi/api/runtime/b;", "T", "", "Lcom/tencent/input/base/launch/d;", "launchParams", "Lcom/tencent/input/base/launch/b;", "a", "<init>", "()V", "input-base_debug"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public final class c<T extends com.tencent.mvi.api.runtime.b> {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final b a(@NotNull d<T> launchParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (b) iPatchRedirector.redirect((short) 2, (Object) this, (Object) launchParams);
        }
        Intrinsics.checkNotNullParameter(launchParams, "launchParams");
        launchParams.c().addView(launchParams.d().buildViewTree(launchParams.a(), launchParams.c(), launchParams.e()));
        launchParams.d().buildVM(launchParams.b());
        return new a(launchParams.b());
    }
}
