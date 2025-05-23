package com.tencent.qqnt.chats.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/chats/api/IChatsMenuDefaultUseCaseProvider;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "repo", "Lcom/tencent/qqnt/chats/main/vm/usecase/meun/a;", "newCancelTopUseCase", "newCopyDataUseCase", "newDeleteMenuUseCase", "newMarkReadUseCase", "newMarkUnreadUseCase", "newPAUnsubscribeUseCase", "newTopUseCase", "newUnsubscribeUseCase", "chats_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes24.dex */
public interface IChatsMenuDefaultUseCaseProvider extends QRouteApi {
    @NotNull
    com.tencent.qqnt.chats.main.vm.usecase.meun.a newCancelTopUseCase(@NotNull IRecentContactRepo repo);

    @NotNull
    com.tencent.qqnt.chats.main.vm.usecase.meun.a newCopyDataUseCase(@NotNull IRecentContactRepo repo);

    @NotNull
    com.tencent.qqnt.chats.main.vm.usecase.meun.a newDeleteMenuUseCase(@NotNull IRecentContactRepo repo);

    @NotNull
    com.tencent.qqnt.chats.main.vm.usecase.meun.a newMarkReadUseCase(@NotNull IRecentContactRepo repo);

    @NotNull
    com.tencent.qqnt.chats.main.vm.usecase.meun.a newMarkUnreadUseCase(@NotNull IRecentContactRepo repo);

    @NotNull
    com.tencent.qqnt.chats.main.vm.usecase.meun.a newPAUnsubscribeUseCase(@NotNull IRecentContactRepo repo);

    @NotNull
    com.tencent.qqnt.chats.main.vm.usecase.meun.a newTopUseCase(@NotNull IRecentContactRepo repo);

    @NotNull
    com.tencent.qqnt.chats.main.vm.usecase.meun.a newUnsubscribeUseCase(@NotNull IRecentContactRepo repo);
}
