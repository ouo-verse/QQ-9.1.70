package com.tencent.aio.stranger.api.impl;

import com.tencent.aio.stranger.api.IStrangerAIOApi;
import com.tencent.aio.stranger.impl.title.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J#\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/tencent/aio/stranger/api/impl/StrangerAIOApiImpl;", "Lcom/tencent/aio/stranger/api/IStrangerAIOApi;", "()V", "getStrangerFromDescription", "", "chaType", "", "peerUid", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isSupportAIOTitleMutual", "", "chatType", "aio_stranger_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class StrangerAIOApiImpl implements IStrangerAIOApi {
    static IPatchRedirector $redirector_;

    public StrangerAIOApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.aio.stranger.api.IStrangerAIOApi
    @Nullable
    public Object getStrangerFromDescription(int i3, @NotNull String str, @NotNull Continuation<? super String> continuation) {
        Object coroutine_suspended;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, continuation);
        }
        if (QLog.isColorLevel()) {
            QLog.d("StrangerAIOApiImpl", 1, "getStrangerFromDescription chatType:" + i3 + ", peerUid:" + str);
        }
        gt.a a16 = b.f69907a.a(i3);
        if (a16 != null) {
            Object a17 = a16.a(i3, str, continuation);
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (a17 == coroutine_suspended) {
                return a17;
            }
            return (String) a17;
        }
        return null;
    }

    @Override // com.tencent.aio.stranger.api.IStrangerAIOApi
    public boolean isSupportAIOTitleMutual(int chatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, chatType)).booleanValue();
        }
        if (chatType == 104) {
            return true;
        }
        return false;
    }
}
