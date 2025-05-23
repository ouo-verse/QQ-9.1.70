package com.tencent.aio.runtime.strategy;

import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/tencent/aio/runtime/strategy/a;", "Lcom/tencent/aio/runtime/strategy/b;", "Lcom/tencent/aio/data/AIOParam;", "a", "Lcom/tencent/aio/data/AIOParam;", "getAioParam", "()Lcom/tencent/aio/data/AIOParam;", "aioParam", "<init>", "(Lcom/tencent/aio/data/AIOParam;)V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class a implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AIOParam aioParam;

    public a(@NotNull AIOParam aioParam) {
        Intrinsics.checkNotNullParameter(aioParam, "aioParam");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aioParam);
        } else {
            this.aioParam = aioParam;
        }
    }
}
