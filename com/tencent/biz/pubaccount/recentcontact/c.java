package com.tencent.biz.pubaccount.recentcontact;

import com.tencent.biz.pubaccount.accountdetail.api.IMsgListPluginApi;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.cardcontainer.api.IChatListTestAndVibrateApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/biz/pubaccount/recentcontact/c;", "Lcom/tencent/qqnt/chats/biz/publicaccount/part/a;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/chats/data/converter/c;", "params", "", "b", "", "uin", "a", "<init>", "()V", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class c extends com.tencent.qqnt.chats.biz.publicaccount.part.a {
    @Override // com.tencent.qqnt.chats.biz.publicaccount.part.a
    public boolean a(long uin) {
        return ((IChatListTestAndVibrateApi) QRoute.api(IChatListTestAndVibrateApi.class)).getPublicAccountPluginSwitch() && ((IMsgListPluginApi) QRoute.api(IMsgListPluginApi.class)).getEntityByUin("HealthPaMenuLogic", uin) != null;
    }

    @Override // com.tencent.qqnt.chats.biz.publicaccount.part.a
    public boolean b(com.tencent.qqnt.chats.core.adapter.itemdata.g item, com.tencent.qqnt.chats.data.converter.c params) {
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(params, "params");
        return item.s().chatType == 103 && m.INSTANCE.a(String.valueOf(item.l())) && com.tencent.mobileqq.activity.recent.m.a().e() && !com.tencent.mobileqq.activity.recent.m.a().f(String.valueOf(item.l()));
    }
}
