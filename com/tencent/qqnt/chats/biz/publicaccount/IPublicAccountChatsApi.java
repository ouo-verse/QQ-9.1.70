package com.tencent.qqnt.chats.biz.publicaccount;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&\u00a2\u0006\u0002\u0010\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chats/biz/publicaccount/IPublicAccountChatsApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "getPublicAccountFolderIconResId", "", "getPublicAccountFolderName", "", "getPublicAccountIcon", "uin", "", "(Ljava/lang/Long;)Ljava/lang/Integer;", "chats_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes24.dex */
public interface IPublicAccountChatsApi extends QRouteApi {
    int getPublicAccountFolderIconResId();

    @NotNull
    String getPublicAccountFolderName();

    @Nullable
    Integer getPublicAccountIcon(@Nullable Long uin);
}
