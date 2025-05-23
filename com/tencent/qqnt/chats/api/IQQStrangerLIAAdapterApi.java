package com.tencent.qqnt.chats.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/api/IQQStrangerLIAAdapterApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "newItem", "oldItem", "", "needAddLIAPayload", "chats_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IQQStrangerLIAAdapterApi extends QRouteApi {
    boolean needAddLIAPayload(@NotNull g newItem, @NotNull g oldItem);
}
