package com.tencent.mobileqq.matchfriend.reborn.mark.chatlist;

import android.os.Looper;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.nt.QQStrangerInteractiveMarkUpdateEvent;
import com.tencent.mobileqq.matchfriend.reborn.couple.api.IQQStrangerInteractiveMarkService;
import com.tencent.mobileqq.matchfriend.reborn.couple.model.QQStrangerInteractiveMarkModel;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0014\u0010\u000e\u001a\u00020\u00062\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0006\u0010\u000f\u001a\u00020\u0006R(\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/mark/chatlist/QQStrangerInteractiveMarkChatListHelper;", "", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "tinyIdList", "", "d", "", "chatType", "f", "", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/b;", "items", "c", "g", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/a;", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/QQStrangerInteractiveMarkModel;", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "currentObserverMap", "b", "I", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerInteractiveMarkChatListHelper {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private ConcurrentHashMap<String, com.tencent.mobileqq.matchfriend.reborn.couple.a<QQStrangerInteractiveMarkModel>> currentObserverMap = new ConcurrentHashMap<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int chatType = 104;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/matchfriend/reborn/mark/chatlist/QQStrangerInteractiveMarkChatListHelper$b", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/a;", "Lcom/tencent/mobileqq/matchfriend/reborn/couple/model/QQStrangerInteractiveMarkModel;", "", "coupleList", "", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public static final class b implements com.tencent.mobileqq.matchfriend.reborn.couple.a<QQStrangerInteractiveMarkModel> {
        b() {
        }

        @Override // com.tencent.mobileqq.matchfriend.reborn.couple.a
        public void a(List<? extends QQStrangerInteractiveMarkModel> coupleList) {
            Object first;
            Intrinsics.checkNotNullParameter(coupleList, "coupleList");
            if (coupleList.isEmpty()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) coupleList);
            arrayList.add(((QQStrangerInteractiveMarkModel) first).coupleId);
            QQStrangerInteractiveMarkChatListHelper.this.d(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(final ArrayList<String> tinyIdList) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            SimpleEventBus.getInstance().dispatchEvent(new QQStrangerInteractiveMarkUpdateEvent(tinyIdList));
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.mark.chatlist.a
                @Override // java.lang.Runnable
                public final void run() {
                    QQStrangerInteractiveMarkChatListHelper.e(tinyIdList);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(ArrayList tinyIdList) {
        Intrinsics.checkNotNullParameter(tinyIdList, "$tinyIdList");
        SimpleEventBus.getInstance().dispatchEvent(new QQStrangerInteractiveMarkUpdateEvent(tinyIdList));
    }

    public final void c(List<? extends com.tencent.qqnt.chats.core.adapter.itemdata.b> items) {
        Object lastOrNull;
        Intrinsics.checkNotNullParameter(items, "items");
        if (items.isEmpty()) {
            return;
        }
        lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) items);
        if (lastOrNull instanceof g) {
            ArrayList<String> arrayList = new ArrayList<>();
            ArrayList<g> arrayList2 = new ArrayList();
            for (Object obj : items) {
                if (!this.currentObserverMap.containsKey(((g) obj).k())) {
                    arrayList2.add(obj);
                }
            }
            for (g gVar : arrayList2) {
                b bVar = new b();
                arrayList.add(gVar.k());
                this.currentObserverMap.put(gVar.k(), bVar);
                com.tencent.mobileqq.matchfriend.reborn.couple.b<? extends QQStrangerInteractiveMarkModel> coupleMgr = ((IQQStrangerInteractiveMarkService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQStrangerInteractiveMarkService.class, "")).getCoupleMgr(gVar.n());
                if (coupleMgr == null) {
                    QLog.e("ChatListInteractiveMarkHelper", 1, "[handleChatItems] manager is null.");
                    return;
                }
                coupleMgr.a(gVar.k(), "", bVar);
            }
            if (arrayList.isEmpty()) {
                return;
            }
            d(arrayList);
        }
    }

    public final void f(int chatType) {
        this.chatType = chatType;
        com.tencent.mobileqq.matchfriend.reborn.mark.config.b.f245190a.f(new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.mark.chatlist.QQStrangerInteractiveMarkChatListHelper$onCreate$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                QLog.i("ChatListInteractiveMarkHelper", 1, "[onCreate] initConfig: " + z16);
            }
        });
    }

    public final void g() {
        com.tencent.mobileqq.matchfriend.reborn.couple.b<? extends QQStrangerInteractiveMarkModel> coupleMgr = ((IQQStrangerInteractiveMarkService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQStrangerInteractiveMarkService.class, "")).getCoupleMgr(this.chatType);
        if (coupleMgr == null) {
            QLog.e("ChatListInteractiveMarkHelper", 1, "[onDestroy] manager is null.");
            return;
        }
        for (Map.Entry<String, com.tencent.mobileqq.matchfriend.reborn.couple.a<QQStrangerInteractiveMarkModel>> entry : this.currentObserverMap.entrySet()) {
            coupleMgr.c(entry.getKey(), "", entry.getValue());
        }
        this.currentObserverMap.clear();
    }
}
