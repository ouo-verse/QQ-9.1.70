package com.tencent.qqnt.chats.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH&J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/chats/api/IChatsUnreadAPI;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lmqq/app/AppRuntime;", "app", "", "aioPeerUid", "", "aioChatType", "getAIOShowUnreadCount", "(Lmqq/app/AppRuntime;Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/qqnt/kernel/invorker/d;", "listener", "", "addExpandRecentContactListener", "removeExpandRecentContactListener", "chats_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes24.dex */
public interface IChatsUnreadAPI extends QRouteApi {
    void addExpandRecentContactListener(@NotNull com.tencent.qqnt.kernel.invorker.d listener);

    @Nullable
    Object getAIOShowUnreadCount(@NotNull AppRuntime appRuntime, @NotNull String str, int i3, @NotNull Continuation<? super Integer> continuation);

    void removeExpandRecentContactListener(@NotNull com.tencent.qqnt.kernel.invorker.d listener);
}
