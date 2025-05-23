package com.tencent.mobileqq.aio.troop.api.impl;

import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.msglist.z;
import com.tencent.mobileqq.aio.troop.api.ITroopAIOAdapterApi;
import com.tencent.mobileqq.aio.troop.api.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.route.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/aio/troop/api/impl/TroopAIOAdapterApiImpl;", "Lcom/tencent/mobileqq/aio/troop/api/ITroopAIOAdapterApi;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/mobileqq/aio/troop/api/a;", "getBlurRecyclerView", "<init>", "()V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class TroopAIOAdapterApiImpl implements ITroopAIOAdapterApi {
    static IPatchRedirector $redirector_;

    public TroopAIOAdapterApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.troop.api.ITroopAIOAdapterApi
    @NotNull
    public a getBlurRecyclerView(@NotNull com.tencent.aio.api.runtime.a aioContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) aioContext);
        }
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        k k3 = aioContext.e().k(AIOMsgListEvent.BottomBlurEvent.f188279d);
        Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msglist.MsgListResult.GetBlurRecyclerView");
        z.b bVar = (z.b) k3;
        return new a(bVar.b(), bVar.a());
    }
}
