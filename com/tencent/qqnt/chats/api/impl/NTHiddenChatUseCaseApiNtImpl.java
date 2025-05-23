package com.tencent.qqnt.chats.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.INTHiddenChatUseCaseApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chats/api/impl/NTHiddenChatUseCaseApiNtImpl;", "Lcom/tencent/qqnt/chats/api/INTHiddenChatUseCaseApi;", "()V", "TAG", "", "delHiddenChat", "", "peerUin", "chatType", "", "chats_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public final class NTHiddenChatUseCaseApiNtImpl implements INTHiddenChatUseCaseApi {
    static IPatchRedirector $redirector_;

    @NotNull
    private final String TAG;

    public NTHiddenChatUseCaseApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.TAG = "NTHiddenChatUseCaseApiNtImpl";
        }
    }

    @Override // com.tencent.qqnt.chats.api.INTHiddenChatUseCaseApi
    public void delHiddenChat(@NotNull String peerUin, int chatType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) peerUin, chatType);
        } else {
            Intrinsics.checkNotNullParameter(peerUin, "peerUin");
            QLog.d(this.TAG, 1, "NT NTHiddenChatUseCaseApiNtImpl delHiddenChat");
        }
    }
}
