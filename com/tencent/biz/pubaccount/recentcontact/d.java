package com.tencent.biz.pubaccount.recentcontact;

import com.tencent.biz.pubaccount.api.IPublicAccountReport;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.chats.biz.eventprocessor.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J\u0016\u0010\u0007\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/biz/pubaccount/recentcontact/d;", "Lcom/tencent/qqnt/chats/biz/eventprocessor/b$b;", "", "Lcom/tencent/qqnt/chats/core/bizEvent/b;", "items", "", "a", "b", "<init>", "()V", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class d implements b.InterfaceC9565b {
    @Override // com.tencent.qqnt.chats.biz.eventprocessor.b.InterfaceC9565b
    public void a(List<com.tencent.qqnt.chats.core.bizEvent.b> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        b.InterfaceC9565b.a.a(this, items);
    }

    @Override // com.tencent.qqnt.chats.biz.eventprocessor.b.InterfaceC9565b
    public void b(List<com.tencent.qqnt.chats.core.bizEvent.b> items) {
        Intrinsics.checkNotNullParameter(items, "items");
        b.InterfaceC9565b.a.b(this, items);
        HashMap hashMap = new HashMap();
        ArrayList<com.tencent.qqnt.chats.core.adapter.itemdata.g> arrayList = new ArrayList();
        Iterator<T> it = items.iterator();
        while (it.hasNext()) {
            Map<String, Object> b16 = ((com.tencent.qqnt.chats.core.bizEvent.b) it.next()).b();
            Object obj = b16 != null ? b16.get("expo_recent_data") : null;
            com.tencent.qqnt.chats.core.adapter.itemdata.g gVar = obj instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g ? (com.tencent.qqnt.chats.core.adapter.itemdata.g) obj : null;
            if (gVar != null) {
                arrayList.add(gVar);
            }
        }
        for (com.tencent.qqnt.chats.core.adapter.itemdata.g gVar2 : arrayList) {
            if (gVar2.n() == 103) {
                hashMap.put(Long.valueOf(gVar2.m()), gVar2);
            }
        }
        Iterator it5 = hashMap.entrySet().iterator();
        while (it5.hasNext()) {
            ((IPublicAccountReport) QRoute.api(IPublicAccountReport.class)).reportItemShowOnConversation(((com.tencent.qqnt.chats.core.adapter.itemdata.g) ((Map.Entry) it5.next()).getValue()).s());
        }
    }
}
