package com.tencent.mobileqq.springhb.interactive.providers.c2c_group;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/springhb/interactive/providers/c2c_group/b;", "Lcom/tencent/mobileqq/springhb/interactive/providers/c2c_group/C2CGroupBaseInteractiveAbilityProvider;", "Lcom/tencent/mobileqq/springhb/interactive/api/a;", "d", "Lcom/tencent/aio/api/help/a;", "param", "<init>", "(Lcom/tencent/aio/api/help/a;)V", "springhb-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class b extends C2CGroupBaseInteractiveAbilityProvider {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull com.tencent.aio.api.help.a param) {
        super(param);
        Intrinsics.checkNotNullParameter(param, "param");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) param);
        }
    }

    @Override // com.tencent.mobileqq.springhb.interactive.api.b
    @NotNull
    public com.tencent.mobileqq.springhb.interactive.api.a d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.springhb.interactive.api.a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return com.tencent.mobileqq.springhb.interactive.frequencyControl.b.f289236a;
    }
}
