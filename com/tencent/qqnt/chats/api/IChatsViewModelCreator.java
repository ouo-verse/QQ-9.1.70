package com.tencent.qqnt.chats.api;

import android.content.Context;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J1\u0010\t\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007H&\u00a2\u0006\u0004\b\t\u0010\nJ;\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH&\u00a2\u0006\u0004\b\u000f\u0010\u0010J;\u0010\u0012\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0011H&\u00a2\u0006\u0004\b\u0012\u0010\u0013J7\u0010\u0016\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&\u00a2\u0006\u0004\b\u0016\u0010\u0017J%\u0010\u0018\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a2\u0006\u0004\b\u0018\u0010\u0019J-\u0010\u001c\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH&\u00a2\u0006\u0004\b\u001c\u0010\u001dJ%\u0010\u001e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a2\u0006\u0004\b\u001e\u0010\u0019J/\u0010\u001f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH&\u00a2\u0006\u0004\b\u001f\u0010 J-\u0010!\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H&\u00a2\u0006\u0004\b!\u0010\nJ;\u0010$\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\"H&\u00a2\u0006\u0004\b$\u0010%J%\u0010&\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a2\u0006\u0004\b&\u0010\u0019\u00a8\u0006'"}, d2 = {"Lcom/tencent/qqnt/chats/api/IChatsViewModelCreator;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "T", "Landroidx/lifecycle/LifecycleCoroutineScope;", "scope", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "repo", "createChatsViewModel", "(Landroidx/lifecycle/LifecycleCoroutineScope;Landroid/content/Context;Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;)Ljava/lang/Object;", "", "clickUseCase", "Lcom/tencent/qqnt/chats/biz/troophelper/a;", "troopUseCase", "createTroopViewModel", "(Landroidx/lifecycle/LifecycleCoroutineScope;Landroid/content/Context;Ljava/lang/Object;Lcom/tencent/qqnt/chats/biz/troophelper/a;)Ljava/lang/Object;", "Lcom/tencent/qqnt/chats/biz/notifyservice/a;", "createNotifyServiceViewModel", "(Landroidx/lifecycle/LifecycleCoroutineScope;Landroid/content/Context;Ljava/lang/Object;Lcom/tencent/qqnt/chats/biz/notifyservice/a;)Ljava/lang/Object;", "", "isSayHello", "createNearbyViewModel", "(Landroidx/lifecycle/LifecycleCoroutineScope;Landroid/content/Context;ZLjava/lang/Object;)Ljava/lang/Object;", "createNearbyProViewModel", "(Landroidx/lifecycle/LifecycleCoroutineScope;Landroid/content/Context;)Ljava/lang/Object;", "", "gameBoxScene", "createGameBoxViewModel", "(Landroidx/lifecycle/LifecycleCoroutineScope;Landroid/content/Context;I)Ljava/lang/Object;", "createMiniAioViewModel", "createHiddenChatViewModel", "(Landroidx/lifecycle/LifecycleCoroutineScope;Landroid/content/Context;Ljava/lang/Object;)Ljava/lang/Object;", "createServiceAccountFolderViewModel", "Lcom/tencent/qqnt/chats/main/vm/datasource/filter/a;", "localDateFilter", "createQQStrangerChatsViewModel", "(Landroidx/lifecycle/LifecycleCoroutineScope;Landroid/content/Context;Ljava/lang/Object;Lcom/tencent/qqnt/chats/main/vm/datasource/filter/a;)Ljava/lang/Object;", "createGuildViewModel", "chats_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IChatsViewModelCreator extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public static final class a {
        public static /* synthetic */ Object a(IChatsViewModelCreator iChatsViewModelCreator, LifecycleCoroutineScope lifecycleCoroutineScope, Context context, Object obj, com.tencent.qqnt.chats.biz.notifyservice.a aVar, int i3, Object obj2) {
            if (obj2 == null) {
                if ((i3 & 8) != 0) {
                    aVar = null;
                }
                return iChatsViewModelCreator.createNotifyServiceViewModel(lifecycleCoroutineScope, context, obj, aVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createNotifyServiceViewModel");
        }

        public static /* synthetic */ Object b(IChatsViewModelCreator iChatsViewModelCreator, LifecycleCoroutineScope lifecycleCoroutineScope, Context context, Object obj, com.tencent.qqnt.chats.main.vm.datasource.filter.a aVar, int i3, Object obj2) {
            if (obj2 == null) {
                if ((i3 & 8) != 0) {
                    aVar = null;
                }
                return iChatsViewModelCreator.createQQStrangerChatsViewModel(lifecycleCoroutineScope, context, obj, aVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createQQStrangerChatsViewModel");
        }

        public static /* synthetic */ Object c(IChatsViewModelCreator iChatsViewModelCreator, LifecycleCoroutineScope lifecycleCoroutineScope, Context context, Object obj, com.tencent.qqnt.chats.biz.troophelper.a aVar, int i3, Object obj2) {
            if (obj2 == null) {
                if ((i3 & 8) != 0) {
                    aVar = null;
                }
                return iChatsViewModelCreator.createTroopViewModel(lifecycleCoroutineScope, context, obj, aVar);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createTroopViewModel");
        }
    }

    <T> T createChatsViewModel(@NotNull LifecycleCoroutineScope scope, @NotNull Context context, @Nullable IRecentContactRepo repo);

    <T> T createGameBoxViewModel(@NotNull LifecycleCoroutineScope scope, @NotNull Context context, int gameBoxScene);

    <T> T createGuildViewModel(@NotNull LifecycleCoroutineScope scope, @NotNull Context context);

    <T> T createHiddenChatViewModel(@NotNull LifecycleCoroutineScope scope, @NotNull Context context, @Nullable Object clickUseCase);

    <T> T createMiniAioViewModel(@NotNull LifecycleCoroutineScope scope, @NotNull Context context);

    <T> T createNearbyProViewModel(@NotNull LifecycleCoroutineScope scope, @NotNull Context context);

    <T> T createNearbyViewModel(@NotNull LifecycleCoroutineScope scope, @NotNull Context context, boolean isSayHello, @Nullable Object clickUseCase);

    <T> T createNotifyServiceViewModel(@NotNull LifecycleCoroutineScope scope, @NotNull Context context, @Nullable Object clickUseCase, @Nullable com.tencent.qqnt.chats.biz.notifyservice.a troopUseCase);

    <T> T createQQStrangerChatsViewModel(@NotNull LifecycleCoroutineScope scope, @NotNull Context context, @Nullable Object clickUseCase, @Nullable com.tencent.qqnt.chats.main.vm.datasource.filter.a localDateFilter);

    <T> T createServiceAccountFolderViewModel(@NotNull LifecycleCoroutineScope scope, @NotNull Context context, @NotNull IRecentContactRepo repo);

    <T> T createTroopViewModel(@NotNull LifecycleCoroutineScope scope, @NotNull Context context, @Nullable Object clickUseCase, @Nullable com.tencent.qqnt.chats.biz.troophelper.a troopUseCase);
}
