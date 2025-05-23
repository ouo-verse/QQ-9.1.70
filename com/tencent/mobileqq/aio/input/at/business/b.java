package com.tencent.mobileqq.aio.input.at.business;

import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/business/b;", "Lcom/tencent/mobileqq/aio/input/at/common/c;", "Lcom/tencent/aio/data/AIOParam;", "a", "Lcom/tencent/aio/data/AIOParam;", "()Lcom/tencent/aio/data/AIOParam;", "aioParams", "<init>", "(Lcom/tencent/aio/data/AIOParam;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class b implements com.tencent.mobileqq.aio.input.at.common.c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIOParam aioParams;

    public b(@NotNull AIOParam aioParams) {
        Intrinsics.checkNotNullParameter(aioParams, "aioParams");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aioParams);
        } else {
            this.aioParams = aioParams;
        }
    }

    @NotNull
    public final AIOParam a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (AIOParam) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.aioParams;
    }
}
