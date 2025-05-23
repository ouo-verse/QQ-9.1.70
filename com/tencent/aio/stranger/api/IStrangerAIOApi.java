package com.tencent.aio.stranger.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/aio/stranger/api/IStrangerAIOApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getStrangerFromDescription", "", "chaType", "", "peerUid", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isSupportAIOTitleMutual", "", "chatType", "aio_stranger_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IStrangerAIOApi extends QRouteApi {
    @Nullable
    Object getStrangerFromDescription(int i3, @NotNull String str, @NotNull Continuation<? super String> continuation);

    boolean isSupportAIOTitleMutual(int chatType);
}
