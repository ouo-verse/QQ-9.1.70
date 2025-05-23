package com.tencent.qqnt.chats.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.api.IChatsMenuDefaultUseCaseProvider;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import com.tencent.qqnt.chats.main.vm.usecase.menu.DefaultCancelTopUseCase;
import com.tencent.qqnt.chats.main.vm.usecase.menu.DefaultDeleteMenuUseCase;
import com.tencent.qqnt.chats.main.vm.usecase.menu.DefaultMarkReadUseCase;
import com.tencent.qqnt.chats.main.vm.usecase.menu.DefaultMarkUnreadUseCase;
import com.tencent.qqnt.chats.main.vm.usecase.menu.DefaultTopMenuUseCase;
import com.tencent.qqnt.chats.main.vm.usecase.menu.DefaultUnSubscribeUseCase;
import com.tencent.qqnt.chats.main.vm.usecase.menu.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/chats/api/impl/ChatsMenuDefaultUseCaseProviderImpl;", "Lcom/tencent/qqnt/chats/api/IChatsMenuDefaultUseCaseProvider;", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "repo", "Lcom/tencent/qqnt/chats/main/vm/usecase/meun/a;", "newCancelTopUseCase", "newCopyDataUseCase", "newDeleteMenuUseCase", "newMarkReadUseCase", "newMarkUnreadUseCase", "newPAUnsubscribeUseCase", "newTopUseCase", "newUnsubscribeUseCase", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class ChatsMenuDefaultUseCaseProviderImpl implements IChatsMenuDefaultUseCaseProvider {
    static IPatchRedirector $redirector_;

    public ChatsMenuDefaultUseCaseProviderImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chats.api.IChatsMenuDefaultUseCaseProvider
    @NotNull
    public com.tencent.qqnt.chats.main.vm.usecase.meun.a newCancelTopUseCase(@NotNull IRecentContactRepo repo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.chats.main.vm.usecase.meun.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) repo);
        }
        Intrinsics.checkNotNullParameter(repo, "repo");
        return new DefaultCancelTopUseCase(repo);
    }

    @Override // com.tencent.qqnt.chats.api.IChatsMenuDefaultUseCaseProvider
    @NotNull
    public com.tencent.qqnt.chats.main.vm.usecase.meun.a newCopyDataUseCase(@NotNull IRecentContactRepo repo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.chats.main.vm.usecase.meun.a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) repo);
        }
        Intrinsics.checkNotNullParameter(repo, "repo");
        return new com.tencent.qqnt.chats.main.vm.usecase.menu.b(repo);
    }

    @Override // com.tencent.qqnt.chats.api.IChatsMenuDefaultUseCaseProvider
    @NotNull
    public com.tencent.qqnt.chats.main.vm.usecase.meun.a newDeleteMenuUseCase(@NotNull IRecentContactRepo repo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (com.tencent.qqnt.chats.main.vm.usecase.meun.a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) repo);
        }
        Intrinsics.checkNotNullParameter(repo, "repo");
        return new DefaultDeleteMenuUseCase(repo);
    }

    @Override // com.tencent.qqnt.chats.api.IChatsMenuDefaultUseCaseProvider
    @NotNull
    public com.tencent.qqnt.chats.main.vm.usecase.meun.a newMarkReadUseCase(@NotNull IRecentContactRepo repo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (com.tencent.qqnt.chats.main.vm.usecase.meun.a) iPatchRedirector.redirect((short) 5, (Object) this, (Object) repo);
        }
        Intrinsics.checkNotNullParameter(repo, "repo");
        return new DefaultMarkReadUseCase(repo);
    }

    @Override // com.tencent.qqnt.chats.api.IChatsMenuDefaultUseCaseProvider
    @NotNull
    public com.tencent.qqnt.chats.main.vm.usecase.meun.a newMarkUnreadUseCase(@NotNull IRecentContactRepo repo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.qqnt.chats.main.vm.usecase.meun.a) iPatchRedirector.redirect((short) 6, (Object) this, (Object) repo);
        }
        Intrinsics.checkNotNullParameter(repo, "repo");
        return new DefaultMarkUnreadUseCase(repo);
    }

    @Override // com.tencent.qqnt.chats.api.IChatsMenuDefaultUseCaseProvider
    @NotNull
    public com.tencent.qqnt.chats.main.vm.usecase.meun.a newPAUnsubscribeUseCase(@NotNull IRecentContactRepo repo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (com.tencent.qqnt.chats.main.vm.usecase.meun.a) iPatchRedirector.redirect((short) 7, (Object) this, (Object) repo);
        }
        Intrinsics.checkNotNullParameter(repo, "repo");
        return new g(repo);
    }

    @Override // com.tencent.qqnt.chats.api.IChatsMenuDefaultUseCaseProvider
    @NotNull
    public com.tencent.qqnt.chats.main.vm.usecase.meun.a newTopUseCase(@NotNull IRecentContactRepo repo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.qqnt.chats.main.vm.usecase.meun.a) iPatchRedirector.redirect((short) 8, (Object) this, (Object) repo);
        }
        Intrinsics.checkNotNullParameter(repo, "repo");
        return new DefaultTopMenuUseCase(repo);
    }

    @Override // com.tencent.qqnt.chats.api.IChatsMenuDefaultUseCaseProvider
    @NotNull
    public com.tencent.qqnt.chats.main.vm.usecase.meun.a newUnsubscribeUseCase(@NotNull IRecentContactRepo repo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (com.tencent.qqnt.chats.main.vm.usecase.meun.a) iPatchRedirector.redirect((short) 9, (Object) this, (Object) repo);
        }
        Intrinsics.checkNotNullParameter(repo, "repo");
        return new DefaultUnSubscribeUseCase(repo);
    }
}
