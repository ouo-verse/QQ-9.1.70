package com.tencent.mobileqq.matchfriend.reborn.content.msg.nt;

import android.content.Context;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendEntryApi;
import com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAHelper;
import com.tencent.mobileqq.matchfriend.reborn.liteinteraction.QQStrangerLIAItem;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqnt.chats.main.vm.usecase.click.b;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0011\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0096\u0002\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/nt/f;", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Landroid/content/Context;", "context", "", "b", "a", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b$a;", "params", "", "interestedIn", "invoke", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class f implements com.tencent.qqnt.chats.main.vm.usecase.click.b {
    private final void a(com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        Contact contact = new Contact(item.s().chatType, item.s().peerUid, "");
        QQStrangerLIAHelper qQStrangerLIAHelper = QQStrangerLIAHelper.f245114a;
        QQStrangerLIAItem u16 = qQStrangerLIAHelper.u(contact, 1);
        if (u16 != null) {
            qQStrangerLIAHelper.o(u16, 1);
        }
    }

    private final void b(com.tencent.qqnt.chats.core.adapter.itemdata.g item, Context context) {
        com.tencent.mobileqq.matchfriend.utils.d dVar = new com.tencent.mobileqq.matchfriend.utils.d(context);
        HashMap hashMap = new HashMap();
        hashMap.put("kl_new_from_openid", ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getSelfOpenId());
        dVar.c("pg_kl_new_chat_list", hashMap);
        List<String> arrayList = new ArrayList<>();
        arrayList.add("em_bas_specific_dialog_box");
        dVar.b(arrayList);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("to_uin", item.k());
        hashMap2.put("is_set_top", Integer.valueOf(item.H() ? 1 : 0));
        com.tencent.mobileqq.matchfriend.reborn.liteinteraction.e.a(item, hashMap2);
        dVar.e("em_bas_specific_dialog_box", hashMap2);
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean interestedIn(b.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        return (b16 instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) && ((com.tencent.qqnt.chats.core.adapter.itemdata.g) b16).n() == 104;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean invoke(b.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        if (!(b16 instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g)) {
            return false;
        }
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar = (com.tencent.qqnt.chats.core.adapter.itemdata.g) b16;
        ((IMatchFriendEntryApi) QRoute.api(IMatchFriendEntryApi.class)).enterMatchFriendAIO(BaseApplication.context, Long.parseLong(gVar.k()), gVar.s().peerName, 4);
        Context context = params.c().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "params.view.context");
        b(gVar, context);
        a(gVar);
        return true;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean needUnifiedAnim(b.a aVar) {
        return b.C9598b.a(this, aVar);
    }
}
