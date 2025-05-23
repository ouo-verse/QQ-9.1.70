package com.tencent.qqnt.chats.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.api.IChatsUnreadAPI;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J+\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/qqnt/chats/api/impl/ChatsUnreadAPIImpl;", "Lcom/tencent/qqnt/chats/api/IChatsUnreadAPI;", "Lcom/tencent/qqnt/kernel/api/aa;", "getRecentContactService", "Lmqq/app/AppRuntime;", "app", "", "aioPeerUid", "", "aioChatType", "getAIOShowUnreadCount", "(Lmqq/app/AppRuntime;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernel/invorker/d;", "listener", "", "addExpandRecentContactListener", "removeExpandRecentContactListener", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class ChatsUnreadAPIImpl implements IChatsUnreadAPI {
    static IPatchRedirector $redirector_;

    public ChatsUnreadAPIImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final aa getRecentContactService() {
        IKernelService iKernelService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) != null) {
            return iKernelService.getRecentContactService();
        }
        return null;
    }

    @Override // com.tencent.qqnt.chats.api.IChatsUnreadAPI
    public void addExpandRecentContactListener(@NotNull com.tencent.qqnt.kernel.invorker.d listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        aa recentContactService = getRecentContactService();
        if (recentContactService != null) {
            recentContactService.addExpandRecentContactListener(listener);
        }
    }

    @Override // com.tencent.qqnt.chats.api.IChatsUnreadAPI
    @Nullable
    public Object getAIOShowUnreadCount(@NotNull AppRuntime appRuntime, @NotNull String str, int i3, @NotNull Continuation<? super Integer> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return iPatchRedirector.redirect((short) 2, this, appRuntime, str, Integer.valueOf(i3), continuation);
        }
        return com.tencent.qqnt.chats.main.vm.unread.b.f355436a.d(appRuntime, str, i3, continuation);
    }

    @Override // com.tencent.qqnt.chats.api.IChatsUnreadAPI
    public void removeExpandRecentContactListener(@NotNull com.tencent.qqnt.kernel.invorker.d listener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) listener);
            return;
        }
        Intrinsics.checkNotNullParameter(listener, "listener");
        aa recentContactService = getRecentContactService();
        if (recentContactService != null) {
            recentContactService.removeExpandRecentContactListener(listener);
        }
    }
}
