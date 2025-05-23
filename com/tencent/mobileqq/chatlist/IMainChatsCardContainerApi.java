package com.tencent.mobileqq.chatlist;

import com.tencent.mobileqq.cardcontainer.k;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/chatlist/IMainChatsCardContainerApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Lcom/tencent/qqnt/chats/biz/main/part/c;", "chatListPart", "Lcom/tencent/mobileqq/cardcontainer/k;", "parentScrollHelper", "Lcom/tencent/mobileqq/chatlist/a;", "createMainChatsCardContainerPart", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {""})
/* loaded from: classes11.dex */
public interface IMainChatsCardContainerApi extends QRouteApi {
    @NotNull
    a createMainChatsCardContainerPart(@NotNull com.tencent.qqnt.chats.biz.main.part.c chatListPart, @NotNull k parentScrollHelper);
}
