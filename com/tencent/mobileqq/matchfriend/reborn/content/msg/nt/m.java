package com.tencent.mobileqq.matchfriend.reborn.content.msg.nt;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.chats.api.IStrangerChatsApi;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/nt/m;", "Lcom/tencent/qqnt/chats/main/vm/datasource/preprocess/c;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "info", "", "isGuildUpdate", "", "a", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class m implements com.tencent.qqnt.chats.main.vm.datasource.preprocess.c {
    @Override // com.tencent.qqnt.chats.main.vm.datasource.preprocess.c
    public void a(RecentContactInfo info, boolean isGuildUpdate) {
        Intrinsics.checkNotNullParameter(info, "info");
        IStrangerChatsApi iStrangerChatsApi = (IStrangerChatsApi) QRoute.api(IStrangerChatsApi.class);
        String str = info.peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "info.peerUid");
        info.topFlag = iStrangerChatsApi.isTop(str) ? (byte) 1 : (byte) 0;
    }
}
