package od1;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi;
import com.tencent.mobileqq.gamecenter.utils.f;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.qqnt.chats.biz.eventprocessor.b;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016R\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lod1/c;", "Lcom/tencent/qqnt/chats/biz/eventprocessor/b$b;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "c", "", "Lcom/tencent/qqnt/chats/core/bizEvent/b;", "items", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "", "", "a", "Ljava/util/concurrent/ConcurrentHashMap;", "lastReportTimeMap", "<init>", "()V", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c implements b.InterfaceC9565b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ConcurrentHashMap<String, Long> lastReportTimeMap = new ConcurrentHashMap<>();

    private final void c(g item) {
        boolean z16;
        String str;
        TempChatGameSession gameSessionFromContact;
        String str2;
        if (item.x().b() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            str = "has_reddot_";
        } else {
            str = "no_reddot_";
        }
        String str3 = str + VasUtil.getCurrentUin();
        Long l3 = this.lastReportTimeMap.get(str3);
        if (l3 == null) {
            l3 = 0L;
        }
        long longValue = l3.longValue();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - longValue < 86400000) {
            return;
        }
        this.lastReportTimeMap.put(str3, Long.valueOf(currentTimeMillis));
        QRouteApi api = QRoute.api(IGameMsgNtApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGameMsgNtApi::class.java)");
        IGameMsgNtApi iGameMsgNtApi = (IGameMsgNtApi) api;
        List<RecentContactInfo> gameRecentContactList = iGameMsgNtApi.getGameRecentContactList();
        if ((true ^ gameRecentContactList.isEmpty()) && (gameSessionFromContact = iGameMsgNtApi.getGameSessionFromContact(gameRecentContactList.get(0))) != null) {
            if (z16) {
                str2 = "0";
            } else {
                str2 = "1";
            }
            String str4 = str2;
            long gameAppId = gameSessionFromContact.getGameAppId();
            StringBuilder sb5 = new StringBuilder();
            sb5.append(gameAppId);
            f.j0(sb5.toString(), "1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "920", "92003", "209055", "", "", "8", str4);
        }
    }

    @Override // com.tencent.qqnt.chats.biz.eventprocessor.b.InterfaceC9565b
    public void a(@NotNull List<com.tencent.qqnt.chats.core.bizEvent.b> list) {
        b.InterfaceC9565b.a.a(this, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.chats.biz.eventprocessor.b.InterfaceC9565b
    public void b(@NotNull List<com.tencent.qqnt.chats.core.bizEvent.b> items) {
        g gVar;
        boolean z16;
        Object obj;
        Intrinsics.checkNotNullParameter(items, "items");
        b.InterfaceC9565b.a.b(this, items);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = items.iterator();
        while (true) {
            gVar = null;
            if (!it.hasNext()) {
                break;
            }
            Map<String, Object> b16 = ((com.tencent.qqnt.chats.core.bizEvent.b) it.next()).b();
            if (b16 != null) {
                obj = b16.get("expo_recent_data");
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
            if (((g) previous).n() == 116) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                gVar = previous;
                break;
            }
        }
        g gVar2 = gVar;
        if (gVar2 != null) {
            c(gVar2);
        }
    }
}
