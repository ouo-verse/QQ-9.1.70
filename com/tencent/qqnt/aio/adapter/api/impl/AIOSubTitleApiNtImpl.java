package com.tencent.qqnt.aio.adapter.api.impl;

import com.tencent.mobileqq.aio.event.AIOTitleEvent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IAIOSubTitleApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/AIOSubTitleApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IAIOSubTitleApi;", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "onRoamLoadingEnd", "<init>", "()V", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class AIOSubTitleApiNtImpl implements IAIOSubTitleApi {
    static IPatchRedirector $redirector_;

    public AIOSubTitleApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOSubTitleApi
    @Nullable
    public com.tencent.mobileqq.aio.title.ai getSubTitleSync(@NotNull com.tencent.aio.api.runtime.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.mobileqq.aio.title.ai) iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        }
        return IAIOSubTitleApi.a.a(this, aVar);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IAIOSubTitleApi
    public void onRoamLoadingEnd(@NotNull com.tencent.aio.api.runtime.a aioContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aioContext);
        } else {
            Intrinsics.checkNotNullParameter(aioContext, "aioContext");
            aioContext.e().h(new AIOTitleEvent.TitleResponseEvent(11, ""));
        }
    }
}
