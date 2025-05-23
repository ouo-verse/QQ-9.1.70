package fy;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivityNew;
import com.tencent.biz.pubaccount.serviceAccountFolder.fragment.ServiceAccountFolderListFragment;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.main.vm.usecase.click.b;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0011\u0010\f\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0096\u0002\u00a8\u0006\u000f"}, d2 = {"Lfy/a;", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b;", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "chatItem", "", "a", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b$a;", "params", "", "interestedIn", "invoke", "<init>", "()V", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements com.tencent.qqnt.chats.main.vm.usecase.click.b {
    private final void a(Context context, g chatItem) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            return;
        }
        String valueOf = String.valueOf(chatItem.l());
        IRuntimeService runtimeService = qQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IP\u2026ava, ProcessConstant.ALL)");
        PublicAccountInfo publicAccountInfo = (PublicAccountInfo) ((IPublicAccountDataManager) runtimeService).findPublicAccountInfoCache(valueOf);
        String str = publicAccountInfo != null ? publicAccountInfo.name : null;
        if (((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).isValidUin(valueOf)) {
            ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).saveUidByUin(valueOf, chatItem.k());
        }
        if (TextUtils.isEmpty(str)) {
            str = chatItem.s().peerName;
        }
        Intent intent = new Intent(context, (Class<?>) ChatActivity.class);
        intent.putExtra("key_peerId", chatItem.k());
        intent.putExtra("key_chat_type", chatItem.n());
        intent.putExtra("key_chat_name", str);
        intent.putExtra("key_peerUin", chatItem.l());
        intent.putExtra("open_chatfragment_withanim", true);
        context.startActivity(intent);
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean interestedIn(b.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (!(params.b() instanceof g)) {
            return false;
        }
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.qqnt.chats.core.adapter.itemdata.RecentContactChatItem");
        if (((g) b16).n() != 30) {
            com.tencent.qqnt.chats.core.adapter.itemdata.b b17 = params.b();
            Intrinsics.checkNotNull(b17, "null cannot be cast to non-null type com.tencent.qqnt.chats.core.adapter.itemdata.RecentContactChatItem");
            if (((g) b17).n() != 103) {
                return false;
            }
        }
        return true;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean invoke(b.a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        if (!(params.b() instanceof g)) {
            return false;
        }
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.qqnt.chats.core.adapter.itemdata.RecentContactChatItem");
        g gVar = (g) b16;
        Context context = params.c().getContext();
        if (gVar.n() == 103) {
            Intrinsics.checkNotNullExpressionValue(context, "context");
            a(context, gVar);
            return true;
        }
        if (gVar.n() != 30) {
            return false;
        }
        ServiceAccountFolderListFragment.Companion companion = ServiceAccountFolderListFragment.INSTANCE;
        if (companion.a()) {
            Intrinsics.checkNotNullExpressionValue(context, "context");
            companion.b(context);
            return true;
        }
        Intent intent = new Intent(context, (Class<?>) ServiceAccountFolderActivityNew.class);
        intent.setFlags(67108864);
        context.startActivity(intent);
        return true;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean needUnifiedAnim(b.a aVar) {
        return b.C9598b.a(this, aVar);
    }
}
