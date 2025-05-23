package com.tencent.qqnt.chats.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatsRevealApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/chats/api/impl/ChatsRevealApiNtImpl;", "Lcom/tencent/qqnt/chats/api/IChatsRevealApi;", "()V", "handleClick", "", "content", "", "uid", "chats_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public final class ChatsRevealApiNtImpl implements IChatsRevealApi {
    static IPatchRedirector $redirector_;

    public ChatsRevealApiNtImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chats.api.IChatsRevealApi
    public void handleClick(@NotNull String content, @NotNull String uid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) content, (Object) uid);
            return;
        }
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(uid, "uid");
        QLog.d("ChatsRevealApiNtImpl", 2, "OnClick: " + uid + " " + content);
    }
}
