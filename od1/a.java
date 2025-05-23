package od1;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.nt.api.IGameMallNtApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.biz.eventprocessor.a;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lod1/a;", "Lcom/tencent/qqnt/chats/biz/eventprocessor/a$a;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "b", "", "Lcom/tencent/qqnt/chats/core/bizEvent/b;", "items", "a", "<init>", "()V", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a implements a.InterfaceC9564a {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016\u00a8\u0006\b"}, d2 = {"od1/a$b", "Lcom/tencent/mobileqq/qqgamepub/nt/api/IGameMallNtApi$b;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "", "onSuccess", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements IGameMallNtApi.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f422498a;

        b(g gVar) {
            this.f422498a = gVar;
        }

        @Override // com.tencent.mobileqq.qqgamepub.nt.api.IGameMallNtApi.b
        public void onSuccess(@NotNull ArrayList<MsgRecord> msgList) {
            MsgRecord msgRecord;
            Intrinsics.checkNotNullParameter(msgList, "msgList");
            if (msgList.isEmpty()) {
                msgRecord = null;
            } else {
                msgRecord = msgList.get(0);
            }
            ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).reportAioListItemClick("3593944551", "914165", (int) this.f422498a.x().b(), "1033", msgRecord);
        }
    }

    private final void b(g item) {
        ((IGameMallNtApi) QRoute.api(IGameMallNtApi.class)).getMsgList(1, 1, new b(item));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.chats.biz.eventprocessor.a.InterfaceC9564a
    public void a(@NotNull List<com.tencent.qqnt.chats.core.bizEvent.b> items) {
        g gVar;
        boolean z16;
        Object obj;
        Intrinsics.checkNotNullParameter(items, "items");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = items.iterator();
        while (true) {
            gVar = null;
            if (!it.hasNext()) {
                break;
            }
            Map<String, Object> b16 = ((com.tencent.qqnt.chats.core.bizEvent.b) it.next()).b();
            if (b16 != null) {
                obj = b16.get("click_recent_data");
            } else {
                obj = null;
            }
            if (obj instanceof g) {
                gVar = (g) obj;
            }
            if (gVar != null) {
                arrayList.add(gVar);
            }
        }
        ListIterator listIterator = arrayList.listIterator(arrayList.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                break;
            }
            Object previous = listIterator.previous();
            g gVar2 = (g) previous;
            if (gVar2.n() == 103 && Intrinsics.areEqual(gVar2.k(), ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).getGameMallPeerUid())) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                gVar = previous;
                break;
            }
        }
        g gVar3 = gVar;
        if (gVar3 != null) {
            QLog.i("QQGamePub_GameMallClickHandler", 2, "[clicked] " + gVar3);
            b(gVar3);
        }
    }
}
