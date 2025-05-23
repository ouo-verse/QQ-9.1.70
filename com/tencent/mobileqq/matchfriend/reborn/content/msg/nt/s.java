package com.tencent.mobileqq.matchfriend.reborn.content.msg.nt;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.matchfriend.reborn.couple.api.IQQStrangerInteractiveMarkService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/nt/s;", "Lcom/tencent/qqnt/chats/main/vm/datasource/filter/a;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "info", "", "a", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class s extends com.tencent.qqnt.chats.main.vm.datasource.filter.a {
    @Override // com.tencent.qqnt.chats.main.vm.datasource.filter.a
    public boolean a(com.tencent.qqnt.chats.core.adapter.itemdata.g info) {
        Intrinsics.checkNotNullParameter(info, "info");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        return !(((IQQStrangerInteractiveMarkService) (appInterface != null ? appInterface.getRuntimeService(IQQStrangerInteractiveMarkService.class, "") : null)) != null ? r2.canShownInOftenChatTab(info.n(), info.k()) : false);
    }
}
