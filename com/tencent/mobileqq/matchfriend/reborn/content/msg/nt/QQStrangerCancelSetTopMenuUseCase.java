package com.tencent.mobileqq.matchfriend.reborn.content.msg.nt;

import android.content.Context;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.nt.QQStrangerCancelSetTopMenuUseCase;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IStrangerChatsApi;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import com.tencent.qqnt.chats.main.vm.usecase.meun.a;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0019\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\bH\u0096\u0002\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/nt/QQStrangerCancelSetTopMenuUseCase;", "Lcom/tencent/qqnt/chats/main/vm/usecase/meun/a;", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "a", "Lcom/tencent/qqnt/chats/main/vm/usecase/meun/a$a;", "params", "", "interestedIn", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/qqnt/chats/main/vm/usecase/result/a;", "invoke", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "recentContactRepo", "<init>", "(Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerCancelSetTopMenuUseCase extends com.tencent.qqnt.chats.main.vm.usecase.meun.a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/content/msg/nt/QQStrangerCancelSetTopMenuUseCase$b", "Lcom/tencent/qqnt/chats/api/c;", "", "result", "", "errMsg", "", "onResult", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b implements com.tencent.qqnt.chats.api.c {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.qqnt.chats.core.adapter.itemdata.b f244663b;

        b(com.tencent.qqnt.chats.core.adapter.itemdata.b bVar) {
            this.f244663b = bVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(int i3, String str) {
            QLog.d("QQStrangerCancelSetTopMenuUseCase", 1, "cancelItemTop result: " + i3 + ", errMsg: " + str);
        }

        @Override // com.tencent.qqnt.chats.api.c
        public void onResult(int result, String errMsg) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            if (QLog.isColorLevel()) {
                QLog.d("QQStrangerCancelSetTopMenuUseCase", 2, "cancelItemTop result: " + result + ", errMsg: " + errMsg);
            }
            if (result == 0) {
                QQStrangerCancelSetTopMenuUseCase.this.getRecentContactRepo().k(((com.tencent.qqnt.chats.core.adapter.itemdata.g) this.f244663b).k(), ((com.tencent.qqnt.chats.core.adapter.itemdata.g) this.f244663b).l(), false, ((com.tencent.qqnt.chats.core.adapter.itemdata.g) this.f244663b).n(), new IOperateCallback() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.nt.a
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i3, String str) {
                        QQStrangerCancelSetTopMenuUseCase.b.b(i3, str);
                    }
                });
            } else {
                QQToastUtil.showQQToastInUiThread(1, BaseApplication.getContext().getString(R.string.f201034tq));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerCancelSetTopMenuUseCase(IRecentContactRepo recentContactRepo) {
        super(recentContactRepo);
        Intrinsics.checkNotNullParameter(recentContactRepo, "recentContactRepo");
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.meun.a
    public boolean interestedIn(a.C9600a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        return (b16 instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) && ((com.tencent.qqnt.chats.core.adapter.itemdata.g) b16).n() == 104;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.meun.a
    public Flow<com.tencent.qqnt.chats.main.vm.usecase.result.a> invoke(a.C9600a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        if (!(b16 instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g)) {
            return null;
        }
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar = (com.tencent.qqnt.chats.core.adapter.itemdata.g) b16;
        ((IStrangerChatsApi) QRoute.api(IStrangerChatsApi.class)).doSetTopOrNot(gVar.k(), false, new b(b16));
        a(params.a(), gVar);
        return FlowKt.flow(new QQStrangerCancelSetTopMenuUseCase$invoke$2(null));
    }

    private final void a(Context context, com.tencent.qqnt.chats.core.adapter.itemdata.g item) {
        if (context != null) {
            try {
                com.tencent.mobileqq.matchfriend.utils.d dVar = new com.tencent.mobileqq.matchfriend.utils.d(context);
                HashMap hashMap = new HashMap();
                hashMap.put("kl_new_from_openid", ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getSelfOpenId());
                dVar.c("pg_kl_new_chat_list", hashMap);
                ArrayList arrayList = new ArrayList();
                arrayList.add("em_kl_slide_the_top_button_left");
                dVar.b(arrayList);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("is_set_top", 0);
                hashMap2.put("to_uin", item.k());
                dVar.e("em_kl_slide_the_top_button_left", hashMap2);
            } catch (NullPointerException e16) {
                QLog.e("QQStrangerCancelSetTopMenuUseCase", 1, e16, new Object[0]);
            }
        }
    }
}
