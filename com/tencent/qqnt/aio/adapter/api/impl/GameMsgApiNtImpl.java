package com.tencent.qqnt.aio.adapter.api.impl;

import android.app.Activity;
import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.aio.adapter.api.IGameMsgApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/adapter/api/impl/GameMsgApiNtImpl;", "Lcom/tencent/qqnt/aio/adapter/api/IGameMsgApi;", "Lcom/tencent/qqnt/aio/interceptor/sendmsg/c;", "paramWrapper", "Lcom/tencent/qqnt/aio/interceptor/sendmsg/d;", "onSendMsgIntercept", "<init>", "()V", "aio_adapter_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class GameMsgApiNtImpl implements IGameMsgApi {
    static IPatchRedirector $redirector_;

    public GameMsgApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IGameMsgApi
    public boolean isShowGameTeamingIcon() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return IGameMsgApi.a.a(this);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IGameMsgApi
    @NotNull
    public com.tencent.qqnt.aio.interceptor.sendmsg.d onSendMsgIntercept(@NotNull com.tencent.qqnt.aio.interceptor.sendmsg.c paramWrapper) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.aio.interceptor.sendmsg.d) iPatchRedirector.redirect((short) 2, (Object) this, (Object) paramWrapper);
        }
        Intrinsics.checkNotNullParameter(paramWrapper, "paramWrapper");
        return new com.tencent.qqnt.aio.interceptor.sendmsg.d(false, false, 2, null);
    }

    @Override // com.tencent.qqnt.aio.adapter.api.IGameMsgApi
    public void startGameTeaming(@NotNull Activity activity, @NotNull AIOParam aIOParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity, (Object) aIOParam);
        } else {
            IGameMsgApi.a.b(this, activity, aIOParam);
        }
    }
}
