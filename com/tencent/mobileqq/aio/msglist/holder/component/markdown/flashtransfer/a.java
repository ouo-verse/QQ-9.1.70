package com.tencent.mobileqq.aio.msglist.holder.component.markdown.flashtransfer;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/holder/component/markdown/flashtransfer/a;", "Lcom/tencent/qqnt/aio/markdown/b;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/qqnt/aio/markdown/a;", "a", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class a implements com.tencent.qqnt.aio.markdown.b {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.markdown.b
    @NotNull
    public com.tencent.qqnt.aio.markdown.a a(@NotNull com.tencent.aio.api.runtime.a aioContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.aio.markdown.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aioContext);
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        return new b(aioContext);
    }
}
