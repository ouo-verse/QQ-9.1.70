package com.tencent.qqnt.chats.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J'\u0010\f\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH&\u00a2\u0006\u0004\b\f\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/chats/api/IContactCommAPI;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "event", "", "sendEventToChat", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "data", "", "listType", "Lcom/tencent/qqnt/chats/data/b;", "convertRecentInfoToNotifyItem", "(Ljava/util/List;Ljava/lang/Integer;)Lcom/tencent/qqnt/chats/data/b;", "chats_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes24.dex */
public interface IContactCommAPI extends QRouteApi {
    @NotNull
    com.tencent.qqnt.chats.data.b convertRecentInfoToNotifyItem(@NotNull List<RecentContactInfo> data, @Nullable Integer listType);

    void sendEventToChat(@NotNull Object event);
}
