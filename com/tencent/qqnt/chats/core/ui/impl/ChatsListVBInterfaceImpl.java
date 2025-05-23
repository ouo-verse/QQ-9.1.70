package com.tencent.qqnt.chats.core.ui.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.core.ui.IChatsListVBInterface;
import com.tencent.qqnt.chats.core.ui.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\n\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/chats/core/ui/impl/ChatsListVBInterfaceImpl;", "Lcom/tencent/qqnt/chats/core/ui/IChatsListVBInterface;", "()V", "chatListHighLightItem", "", "chatType", "", "peerUid", "", "guildId", "chatListIsInVisibleIndex", "", "chats_view_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes24.dex */
public final class ChatsListVBInterfaceImpl implements IChatsListVBInterface {
    static IPatchRedirector $redirector_;

    public ChatsListVBInterfaceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chats.core.ui.IChatsListVBInterface
    public void chatListHighLightItem(int chatType, @NotNull String peerUid, @NotNull String guildId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(chatType), peerUid, guildId);
            return;
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        k.f354958a.a(chatType, peerUid, guildId);
    }

    @Override // com.tencent.qqnt.chats.core.ui.IChatsListVBInterface
    public boolean chatListIsInVisibleIndex(int chatType, @NotNull String peerUid, @NotNull String guildId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, Integer.valueOf(chatType), peerUid, guildId)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        return k.f354958a.b(chatType, peerUid, guildId);
    }
}
