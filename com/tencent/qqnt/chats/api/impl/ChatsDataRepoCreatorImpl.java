package com.tencent.qqnt.chats.api.impl;

import androidx.lifecycle.LifecycleCoroutineScope;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatsDataRepoCreator;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import com.tencent.qqnt.chats.main.vm.datasource.MainRecentContactRepo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/chats/api/impl/ChatsDataRepoCreatorImpl;", "Lcom/tencent/qqnt/chats/api/IChatsDataRepoCreator;", "Landroidx/lifecycle/LifecycleCoroutineScope;", "scope", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "createMainRepo", "mainRepoPreload", "getPreloadMainRepo", "Lcom/tencent/qqnt/chats/main/vm/datasource/MainRecentContactRepo;", "repo", "Lcom/tencent/qqnt/chats/main/vm/datasource/MainRecentContactRepo;", "<init>", "()V", "Companion", "a", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class ChatsDataRepoCreatorImpl implements IChatsDataRepoCreator {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "ChatsDataRepoCreatorImpl";

    @Nullable
    private MainRecentContactRepo repo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/api/impl/ChatsDataRepoCreatorImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.api.impl.ChatsDataRepoCreatorImpl$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(31018);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ChatsDataRepoCreatorImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chats.api.IChatsDataRepoCreator
    @NotNull
    public IRecentContactRepo createMainRepo(@Nullable LifecycleCoroutineScope scope) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IRecentContactRepo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) scope);
        }
        return new MainRecentContactRepo();
    }

    @Override // com.tencent.qqnt.chats.api.IChatsDataRepoCreator
    @Nullable
    public IRecentContactRepo getPreloadMainRepo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (IRecentContactRepo) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        MainRecentContactRepo mainRecentContactRepo = this.repo;
        this.repo = null;
        return mainRecentContactRepo;
    }

    @Override // com.tencent.qqnt.chats.api.IChatsDataRepoCreator
    @Nullable
    public IRecentContactRepo mainRepoPreload() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IRecentContactRepo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        long currentTimeMillis = System.currentTimeMillis();
        IRecentContactRepo createMainRepo = ((IChatsDataRepoCreator) QRoute.api(IChatsDataRepoCreator.class)).createMainRepo(null);
        Intrinsics.checkNotNull(createMainRepo, "null cannot be cast to non-null type com.tencent.qqnt.chats.main.vm.datasource.MainRecentContactRepo");
        MainRecentContactRepo mainRecentContactRepo = (MainRecentContactRepo) createMainRepo;
        this.repo = mainRecentContactRepo;
        Intrinsics.checkNotNull(mainRecentContactRepo);
        mainRecentContactRepo.create();
        QLog.i(TAG, 1, "createPreloadRepo cost: " + (System.currentTimeMillis() - currentTimeMillis));
        return this.repo;
    }
}
