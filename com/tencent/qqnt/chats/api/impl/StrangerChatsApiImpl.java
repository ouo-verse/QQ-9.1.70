package com.tencent.qqnt.chats.api.impl;

import android.os.Looper;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.nt.QQStrangerChatTopUpdateEvent;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.nt.m;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.nt.n;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.settop.SetTopBizType;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.settop.SetTopManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IStrangerChatsApi;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 *2\u00020\u0001:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\"\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0013H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0006H\u0016J \u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0006H\u0016J\u0018\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010!\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\u00a8\u0006,"}, d2 = {"Lcom/tencent/qqnt/chats/api/impl/StrangerChatsApiImpl;", "Lcom/tencent/qqnt/chats/api/IStrangerChatsApi;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "reportSetTopOrNotExpose", "", "implEnd", "reportChatItemExpo", "Lcom/tencent/qqnt/chats/main/vm/datasource/preprocess/c;", "createContactInfoPreProcessor", "Lcom/tencent/qqnt/chats/main/vm/datasource/preprocess/d;", "createContactListResortProcessor", "", "tinyId", "top", "Lcom/tencent/qqnt/chats/api/c;", "callback", "doSetTopOrNot", "Lcom/tencent/qqnt/chats/api/d;", "fetchOneSetTopStatus", "fetchSetTopList", "hasTop", "isTop", "notifyChatsListTopChanged", "ev", "clearSingle", "reportChatItemImplEvent", "", com.tencent.luggage.wxa.c8.c.G, "reportMenuOpenExpose", "Lcom/tencent/qqnt/chats/api/e;", "listener", "setTopSetUpdateListener", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/settop/SetTopManager;", "setTopManager$delegate", "Lkotlin/Lazy;", "getSetTopManager", "()Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/settop/SetTopManager;", "setTopManager", "<init>", "()V", "Companion", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class StrangerChatsApiImpl implements IStrangerChatsApi {
    private static final String TAG = "StrangerChatsApiImpl";

    /* renamed from: setTopManager$delegate, reason: from kotlin metadata */
    private final Lazy setTopManager;

    public StrangerChatsApiImpl() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<SetTopManager>() { // from class: com.tencent.qqnt.chats.api.impl.StrangerChatsApiImpl$setTopManager$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SetTopManager invoke() {
                return new SetTopManager(SetTopBizType.JIE_BAN);
            }
        });
        this.setTopManager = lazy;
    }

    private final SetTopManager getSetTopManager() {
        return (SetTopManager) this.setTopManager.getValue();
    }

    private final void reportChatItemExpo(final g item, final boolean implEnd) {
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.qqnt.chats.api.impl.StrangerChatsApiImpl$reportChatItemExpo$reportRunnable$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                HashMap hashMapOf;
                ArrayList arrayListOf;
                boolean z16 = implEnd;
                g gVar = item;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    com.tencent.mobileqq.matchfriend.utils.d dVar = new com.tencent.mobileqq.matchfriend.utils.d(QBaseActivity.sTopActivity);
                    int i3 = 1;
                    hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("kl_new_from_openid", ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getSelfOpenId()));
                    dVar.c("pg_kl_new_chat_list", hashMapOf);
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("em_bas_specific_dialog_box");
                    dVar.b(arrayListOf);
                    HashMap hashMap = new HashMap();
                    hashMap.put("to_uin", gVar.k());
                    if (!gVar.H()) {
                        i3 = 0;
                    }
                    hashMap.put("is_set_top", Integer.valueOf(i3));
                    com.tencent.mobileqq.matchfriend.reborn.liteinteraction.e.a(gVar, hashMap);
                    if (!com.tencent.mobileqq.matchfriend.reborn.liteinteraction.e.b(gVar)) {
                        p82.a.INSTANCE.a(gVar.m());
                    } else {
                        p82.a.INSTANCE.c(gVar.m());
                    }
                    if (z16) {
                        dVar.h("em_bas_specific_dialog_box", hashMap);
                    } else {
                        dVar.g("em_bas_specific_dialog_box", hashMap);
                    }
                    Result.m476constructorimpl(Unit.INSTANCE);
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
            }
        };
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            function0.invoke();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.qqnt.chats.api.impl.f
                @Override // java.lang.Runnable
                public final void run() {
                    StrangerChatsApiImpl.reportChatItemExpo$lambda$6(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void reportChatItemExpo$lambda$6(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    private final void reportSetTopOrNotExpose(g item) {
        try {
            com.tencent.mobileqq.matchfriend.utils.d dVar = new com.tencent.mobileqq.matchfriend.utils.d(QBaseActivity.sTopActivity);
            HashMap hashMap = new HashMap();
            hashMap.put("kl_new_from_openid", ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getSelfOpenId());
            dVar.c("pg_kl_new_chat_list", hashMap);
            List<String> arrayList = new ArrayList<>();
            arrayList.add("em_kl_slide_the_top_button_left");
            dVar.b(arrayList);
            HashMap hashMap2 = new HashMap();
            hashMap2.put("is_set_top", Integer.valueOf(item.H() ? 1 : 0));
            hashMap2.put("to_uin", item.k());
            dVar.g("em_kl_slide_the_top_button_left", hashMap2);
        } catch (NullPointerException e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    @Override // com.tencent.qqnt.chats.api.IStrangerChatsApi
    public com.tencent.qqnt.chats.main.vm.datasource.preprocess.c createContactInfoPreProcessor() {
        return new m();
    }

    @Override // com.tencent.qqnt.chats.api.IStrangerChatsApi
    public com.tencent.qqnt.chats.main.vm.datasource.preprocess.d createContactListResortProcessor() {
        return new n();
    }

    @Override // com.tencent.qqnt.chats.api.IStrangerChatsApi
    public void doSetTopOrNot(String tinyId, boolean top, com.tencent.qqnt.chats.api.c callback) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        if (top) {
            getSetTopManager().k(tinyId, callback);
        } else {
            getSetTopManager().j(tinyId, callback);
        }
    }

    @Override // com.tencent.qqnt.chats.api.IStrangerChatsApi
    public void fetchOneSetTopStatus(String tinyId, com.tencent.qqnt.chats.api.d callback) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getSetTopManager().l(tinyId, callback);
    }

    @Override // com.tencent.qqnt.chats.api.IStrangerChatsApi
    public void fetchSetTopList() {
        getSetTopManager().m();
    }

    @Override // com.tencent.qqnt.chats.api.IStrangerChatsApi
    public boolean hasTop() {
        return getSetTopManager().t();
    }

    @Override // com.tencent.qqnt.chats.api.IStrangerChatsApi
    public boolean isTop(String tinyId) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        return getSetTopManager().u(tinyId);
    }

    @Override // com.tencent.qqnt.chats.api.IStrangerChatsApi
    public void notifyChatsListTopChanged(String tinyId, boolean top) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        SimpleEventBus.getInstance().dispatchEvent(new QQStrangerChatTopUpdateEvent(tinyId, top));
    }

    @Override // com.tencent.qqnt.chats.api.IStrangerChatsApi
    public void reportChatItemImplEvent(String ev5, g item, boolean clearSingle) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        Intrinsics.checkNotNullParameter(item, "item");
        if (Intrinsics.areEqual(ev5, "qq_imp")) {
            reportChatItemExpo(item, false);
        } else if (Intrinsics.areEqual(ev5, "qq_imp_end")) {
            reportChatItemExpo(item, true);
        }
    }

    @Override // com.tencent.qqnt.chats.api.IStrangerChatsApi
    public void reportMenuOpenExpose(int pos, g item) {
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(item, "item");
        Iterator<T> it = item.a().iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                obj2 = null;
                break;
            } else {
                obj2 = it.next();
                if (((com.tencent.qqnt.chats.core.adapter.menu.a) obj2).c() == R.id.eqe) {
                    break;
                }
            }
        }
        if (((com.tencent.qqnt.chats.core.adapter.menu.a) obj2) != null) {
            reportSetTopOrNotExpose(item);
        }
        Iterator<T> it5 = item.a().iterator();
        while (true) {
            if (!it5.hasNext()) {
                break;
            }
            Object next = it5.next();
            if (((com.tencent.qqnt.chats.core.adapter.menu.a) next).c() == R.id.epu) {
                obj = next;
                break;
            }
        }
        if (((com.tencent.qqnt.chats.core.adapter.menu.a) obj) != null) {
            reportSetTopOrNotExpose(item);
        }
    }

    @Override // com.tencent.qqnt.chats.api.IStrangerChatsApi
    public void setTopSetUpdateListener(com.tencent.qqnt.chats.api.e listener) {
        getSetTopManager().y(listener);
    }
}
