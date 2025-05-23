package com.tencent.qqnt.chats.api.impl;

import android.content.Context;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.api.IChatsViewModelCreator;
import com.tencent.qqnt.chats.biz.qqstranger.QQStrangerChatListVM;
import com.tencent.qqnt.chats.biz.troophelper.TroopHelperListVM;
import com.tencent.qqnt.chats.main.vm.ChatsListVM;
import com.tencent.qqnt.chats.main.vm.MainChatListVM;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import com.tencent.qqnt.chats.main.vm.datasource.MainRecentContactRepo;
import com.tencent.qqnt.chats.main.vm.datasource.biz.GuildHelperChatsRepo;
import com.tencent.qqnt.chats.main.vm.datasource.biz.QQStrangerChatsRepo;
import com.tencent.qqnt.chats.main.vm.datasource.biz.TroopHelperChatsRepo;
import com.tencent.qqnt.chats.main.vm.usecase.ItemClickUseCase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b(\u0010)J/\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ9\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J9\u0010\u0013\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016\u00a2\u0006\u0004\b\u0013\u0010\u0014J7\u0010\u0017\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a2\u0006\u0004\b\u0017\u0010\u0018J%\u0010\u0019\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001aJ-\u0010\u001d\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001bH\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001eJ%\u0010\u001f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u001f\u0010\u001aJ/\u0010 \u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a2\u0006\u0004\b \u0010!J-\u0010\"\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016\u00a2\u0006\u0004\b\"\u0010\nJ9\u0010%\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010$\u001a\u0004\u0018\u00010#H\u0016\u00a2\u0006\u0004\b%\u0010&J%\u0010'\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b'\u0010\u001a\u00a8\u0006*"}, d2 = {"Lcom/tencent/qqnt/chats/api/impl/ChatsViewModelCreatorImpl;", "Lcom/tencent/qqnt/chats/api/IChatsViewModelCreator;", "T", "Landroidx/lifecycle/LifecycleCoroutineScope;", "scope", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "repo", "createChatsViewModel", "(Landroidx/lifecycle/LifecycleCoroutineScope;Landroid/content/Context;Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;)Ljava/lang/Object;", "", "clickUseCase", "Lcom/tencent/qqnt/chats/biz/troophelper/a;", "troopUseCase", "createTroopViewModel", "(Landroidx/lifecycle/LifecycleCoroutineScope;Landroid/content/Context;Ljava/lang/Object;Lcom/tencent/qqnt/chats/biz/troophelper/a;)Ljava/lang/Object;", "Lcom/tencent/qqnt/chats/biz/notifyservice/a;", "notifyServiceUseCase", "createNotifyServiceViewModel", "(Landroidx/lifecycle/LifecycleCoroutineScope;Landroid/content/Context;Ljava/lang/Object;Lcom/tencent/qqnt/chats/biz/notifyservice/a;)Ljava/lang/Object;", "", "isSayHello", "createNearbyViewModel", "(Landroidx/lifecycle/LifecycleCoroutineScope;Landroid/content/Context;ZLjava/lang/Object;)Ljava/lang/Object;", "createNearbyProViewModel", "(Landroidx/lifecycle/LifecycleCoroutineScope;Landroid/content/Context;)Ljava/lang/Object;", "", "gameBoxScene", "createGameBoxViewModel", "(Landroidx/lifecycle/LifecycleCoroutineScope;Landroid/content/Context;I)Ljava/lang/Object;", "createMiniAioViewModel", "createHiddenChatViewModel", "(Landroidx/lifecycle/LifecycleCoroutineScope;Landroid/content/Context;Ljava/lang/Object;)Ljava/lang/Object;", "createServiceAccountFolderViewModel", "Lcom/tencent/qqnt/chats/main/vm/datasource/filter/a;", "localDateFilter", "createQQStrangerChatsViewModel", "(Landroidx/lifecycle/LifecycleCoroutineScope;Landroid/content/Context;Ljava/lang/Object;Lcom/tencent/qqnt/chats/main/vm/datasource/filter/a;)Ljava/lang/Object;", "createGuildViewModel", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class ChatsViewModelCreatorImpl implements IChatsViewModelCreator {
    static IPatchRedirector $redirector_;

    public ChatsViewModelCreatorImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chats.api.IChatsViewModelCreator
    public <T> T createChatsViewModel(@NotNull LifecycleCoroutineScope scope, @NotNull Context context, @Nullable IRecentContactRepo repo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (T) iPatchRedirector.redirect((short) 2, this, scope, context, repo);
        }
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(context, "context");
        if (repo == null) {
            return (T) new MainChatListVM(scope, context, new MainRecentContactRepo());
        }
        return (T) new MainChatListVM(scope, context, repo);
    }

    @Override // com.tencent.qqnt.chats.api.IChatsViewModelCreator
    public <T> T createGameBoxViewModel(@NotNull LifecycleCoroutineScope scope, @NotNull Context context, int gameBoxScene) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (T) iPatchRedirector.redirect((short) 7, this, scope, context, Integer.valueOf(gameBoxScene));
        }
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(context, "context");
        return (T) new com.tencent.qqnt.chats.biz.gamebox.a(scope, context, new com.tencent.qqnt.chats.main.vm.datasource.biz.a(scope, gameBoxScene));
    }

    @Override // com.tencent.qqnt.chats.api.IChatsViewModelCreator
    public <T> T createGuildViewModel(@NotNull LifecycleCoroutineScope scope, @NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (T) iPatchRedirector.redirect((short) 12, (Object) this, (Object) scope, (Object) context);
        }
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(context, "context");
        return (T) new com.tencent.qqnt.chats.biz.guildhelper.e(scope, context, new GuildHelperChatsRepo(scope));
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, com.tencent.qqnt.chats.biz.hiddenchat.b, com.tencent.qqnt.chats.main.vm.ChatsListVM] */
    @Override // com.tencent.qqnt.chats.api.IChatsViewModelCreator
    public <T> T createHiddenChatViewModel(@NotNull LifecycleCoroutineScope scope, @NotNull Context context, @Nullable Object clickUseCase) {
        com.tencent.qqnt.chats.main.vm.usecase.click.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (T) iPatchRedirector.redirect((short) 9, this, scope, context, clickUseCase);
        }
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(context, "context");
        ?? r06 = (T) new com.tencent.qqnt.chats.biz.hiddenchat.b(scope, context, new com.tencent.qqnt.chats.main.vm.datasource.biz.b(scope));
        if (clickUseCase instanceof com.tencent.qqnt.chats.main.vm.usecase.click.b) {
            bVar = (com.tencent.qqnt.chats.main.vm.usecase.click.b) clickUseCase;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            r06.a0(bVar);
        }
        return r06;
    }

    @Override // com.tencent.qqnt.chats.api.IChatsViewModelCreator
    public <T> T createMiniAioViewModel(@NotNull LifecycleCoroutineScope scope, @NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (T) iPatchRedirector.redirect((short) 8, (Object) this, (Object) scope, (Object) context);
        }
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(context, "context");
        return (T) new ChatsListVM(scope, new com.tencent.qqnt.chats.core.a(context, 7), new com.tencent.qqnt.chats.main.vm.datasource.biz.c(scope));
    }

    @Override // com.tencent.qqnt.chats.api.IChatsViewModelCreator
    public <T> T createNearbyProViewModel(@NotNull LifecycleCoroutineScope scope, @NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (T) iPatchRedirector.redirect((short) 6, (Object) this, (Object) scope, (Object) context);
        }
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(context, "context");
        return (T) new kw3.a(scope, context, new com.tencent.qqnt.chats.main.vm.datasource.biz.f(scope));
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, jw3.a, com.tencent.qqnt.chats.main.vm.ChatsListVM] */
    @Override // com.tencent.qqnt.chats.api.IChatsViewModelCreator
    public <T> T createNearbyViewModel(@NotNull LifecycleCoroutineScope scope, @NotNull Context context, boolean isSayHello, @Nullable Object clickUseCase) {
        ItemClickUseCase itemClickUseCase;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (T) iPatchRedirector.redirect((short) 5, this, scope, context, Boolean.valueOf(isSayHello), clickUseCase);
        }
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(context, "context");
        ?? r06 = (T) new jw3.a(scope, context, new com.tencent.qqnt.chats.main.vm.datasource.biz.e(scope, isSayHello));
        if (clickUseCase instanceof ItemClickUseCase) {
            itemClickUseCase = (ItemClickUseCase) clickUseCase;
        } else {
            itemClickUseCase = null;
        }
        if (itemClickUseCase != null) {
            r06.b0(itemClickUseCase);
        }
        return r06;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, com.tencent.qqnt.chats.main.vm.ChatsListVM, com.tencent.qqnt.chats.biz.publicaccount.notifyservice.a] */
    @Override // com.tencent.qqnt.chats.api.IChatsViewModelCreator
    public <T> T createNotifyServiceViewModel(@NotNull LifecycleCoroutineScope scope, @NotNull Context context, @Nullable Object clickUseCase, @Nullable com.tencent.qqnt.chats.biz.notifyservice.a notifyServiceUseCase) {
        ItemClickUseCase itemClickUseCase;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (T) iPatchRedirector.redirect((short) 4, this, scope, context, clickUseCase, notifyServiceUseCase);
        }
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(context, "context");
        ?? r06 = (T) new com.tencent.qqnt.chats.biz.publicaccount.notifyservice.a(scope, context, new com.tencent.qqnt.chats.biz.publicaccount.notifyservice.repo.b(scope), notifyServiceUseCase);
        if (clickUseCase instanceof ItemClickUseCase) {
            itemClickUseCase = (ItemClickUseCase) clickUseCase;
        } else {
            itemClickUseCase = null;
        }
        if (itemClickUseCase != null) {
            r06.b0(itemClickUseCase);
        }
        return r06;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, com.tencent.qqnt.chats.main.vm.ChatsListVM, com.tencent.qqnt.chats.biz.qqstranger.QQStrangerChatListVM] */
    @Override // com.tencent.qqnt.chats.api.IChatsViewModelCreator
    public <T> T createQQStrangerChatsViewModel(@NotNull LifecycleCoroutineScope scope, @NotNull Context context, @Nullable Object clickUseCase, @Nullable com.tencent.qqnt.chats.main.vm.datasource.filter.a localDateFilter) {
        com.tencent.qqnt.chats.main.vm.usecase.click.b bVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (T) iPatchRedirector.redirect((short) 11, this, scope, context, clickUseCase, localDateFilter);
        }
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(context, "context");
        ?? r06 = (T) new QQStrangerChatListVM(scope, context, new QQStrangerChatsRepo(scope, localDateFilter));
        if (clickUseCase instanceof com.tencent.qqnt.chats.main.vm.usecase.click.b) {
            bVar = (com.tencent.qqnt.chats.main.vm.usecase.click.b) clickUseCase;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            r06.a0(bVar);
        }
        return r06;
    }

    @Override // com.tencent.qqnt.chats.api.IChatsViewModelCreator
    public <T> T createServiceAccountFolderViewModel(@NotNull LifecycleCoroutineScope scope, @NotNull Context context, @NotNull IRecentContactRepo repo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (T) iPatchRedirector.redirect((short) 10, this, scope, context, repo);
        }
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(repo, "repo");
        return (T) new com.tencent.qqnt.chats.biz.publicaccount.b(scope, context, repo);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, com.tencent.qqnt.chats.main.vm.ChatsListVM, com.tencent.qqnt.chats.biz.troophelper.TroopHelperListVM] */
    @Override // com.tencent.qqnt.chats.api.IChatsViewModelCreator
    public <T> T createTroopViewModel(@NotNull LifecycleCoroutineScope scope, @NotNull Context context, @Nullable Object clickUseCase, @Nullable com.tencent.qqnt.chats.biz.troophelper.a troopUseCase) {
        ItemClickUseCase itemClickUseCase;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (T) iPatchRedirector.redirect((short) 3, this, scope, context, clickUseCase, troopUseCase);
        }
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(context, "context");
        ?? r06 = (T) new TroopHelperListVM(scope, context, new TroopHelperChatsRepo(scope), troopUseCase);
        if (clickUseCase instanceof ItemClickUseCase) {
            itemClickUseCase = (ItemClickUseCase) clickUseCase;
        } else {
            itemClickUseCase = null;
        }
        if (itemClickUseCase != null) {
            r06.b0(itemClickUseCase);
        }
        return r06;
    }
}
