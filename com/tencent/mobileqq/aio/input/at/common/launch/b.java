package com.tencent.mobileqq.aio.input.at.common.launch;

import com.tencent.mobileqq.aio.input.at.common.c;
import com.tencent.mobileqq.aio.input.at.common.f;
import com.tencent.mobileqq.aio.input.at.common.i;
import com.tencent.mobileqq.aio.input.at.common.k;
import com.tencent.mobileqq.aio.input.at.common.l;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0014\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/common/launch/b;", "Lcom/tencent/mobileqq/aio/input/at/common/c;", "T", "", "Lcom/tencent/mobileqq/aio/input/at/common/launch/a;", "createParam", "Lcom/tencent/mobileqq/aio/input/at/common/f;", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b<T extends c> {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final f a(@NotNull a<T> createParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (f) iPatchRedirector.redirect((short) 2, (Object) this, (Object) createParam);
        }
        Intrinsics.checkNotNullParameter(createParam, "createParam");
        k kVar = new k();
        kVar.o(createParam.a());
        kVar.q(createParam.c());
        kVar.p(createParam.b());
        kVar.r(createParam.d());
        kVar.s(createParam.e());
        i iVar = new i(kVar);
        iVar.k();
        return new l(iVar);
    }
}
