package com.tencent.qqnt.chats.biz.gamebox;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chats/biz/gamebox/IGameBoxApplyPartnerApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "isApplyPartnerContact", "", "contactId", "", "updateApplyPartnerIdList", "", "newApplyPartnerIdList", "", "chats_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IGameBoxApplyPartnerApi extends QRouteApi {
    boolean isApplyPartnerContact(@NotNull String contactId);

    void updateApplyPartnerIdList(@NotNull List<String> newApplyPartnerIdList);
}
