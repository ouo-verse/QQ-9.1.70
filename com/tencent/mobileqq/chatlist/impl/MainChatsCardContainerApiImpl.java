package com.tencent.mobileqq.chatlist.impl;

import com.tencent.mobileqq.cardcontainer.k;
import com.tencent.mobileqq.chatlist.IMainChatsCardContainerApi;
import com.tencent.mobileqq.chatlist.a;
import com.tencent.mobileqq.chatlist.e;
import com.tencent.qqnt.chats.biz.main.part.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/chatlist/impl/MainChatsCardContainerApiImpl;", "Lcom/tencent/mobileqq/chatlist/IMainChatsCardContainerApi;", "Lcom/tencent/qqnt/chats/biz/main/part/c;", "chatListPart", "Lcom/tencent/mobileqq/cardcontainer/k;", "parentScrollHelper", "Lcom/tencent/mobileqq/chatlist/a;", "createMainChatsCardContainerPart", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MainChatsCardContainerApiImpl implements IMainChatsCardContainerApi {
    @Override // com.tencent.mobileqq.chatlist.IMainChatsCardContainerApi
    public a createMainChatsCardContainerPart(c chatListPart, k parentScrollHelper) {
        Intrinsics.checkNotNullParameter(chatListPart, "chatListPart");
        Intrinsics.checkNotNullParameter(parentScrollHelper, "parentScrollHelper");
        return new e(chatListPart, parentScrollHelper);
    }
}
