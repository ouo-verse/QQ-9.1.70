package com.tencent.qqnt.chats.api;

import androidx.lifecycle.LifecycleCoroutineScope;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0003H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0003H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/chats/api/IChatsDataRepoCreator;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "createMainRepo", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "scope", "Landroidx/lifecycle/LifecycleCoroutineScope;", "getPreloadMainRepo", "mainRepoPreload", "chats_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IChatsDataRepoCreator extends QRouteApi {
    @NotNull
    IRecentContactRepo createMainRepo(@Nullable LifecycleCoroutineScope scope);

    @Nullable
    IRecentContactRepo getPreloadMainRepo();

    @Nullable
    IRecentContactRepo mainRepoPreload();
}
