package com.tencent.luggage.wxa.s6;

import com.tencent.luggage.wxaapi.WxaAppCustomActionSheetDelegate;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f140078a = new g();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a implements Comparator {
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int compareValues;
            g gVar = g.f140078a;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(gVar.a((com.tencent.luggage.wxa.ui.a) obj)), Integer.valueOf(gVar.a((com.tencent.luggage.wxa.ui.a) obj2)));
            return compareValues;
        }
    }

    public final int a(com.tencent.luggage.wxa.ui.a aVar) {
        if (aVar instanceof com.tencent.luggage.wxa.l7.c) {
            return ((com.tencent.luggage.wxa.l7.c) aVar).j();
        }
        int b16 = aVar.b();
        if (b16 == com.tencent.luggage.wxa.ui.b.ShareAppMsg.ordinal()) {
            return 100;
        }
        if (b16 == com.tencent.luggage.wxa.ui.b.ShareToTimeLine.ordinal()) {
            return 200;
        }
        if (b16 == com.tencent.luggage.wxa.ui.b.Fav.ordinal()) {
            return 300;
        }
        if (b16 == com.tencent.luggage.wxa.ui.b.ModifyCollection.ordinal()) {
            return 400;
        }
        throw new UnsupportedOperationException();
    }

    public final List a(List originList, List customList) {
        Intrinsics.checkNotNullParameter(originList, "originList");
        Intrinsics.checkNotNullParameter(customList, "customList");
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        Iterator it = originList.iterator();
        boolean z16 = true;
        while (it.hasNext()) {
            com.tencent.luggage.wxa.ui.a aVar = (com.tencent.luggage.wxa.ui.a) it.next();
            if (aVar.e()) {
                linkedList.add(aVar);
            } else {
                linkedList2.add(aVar);
            }
            if (com.tencent.luggage.wxa.ui.b.ShareAppMsg.ordinal() == aVar.b()) {
                z16 = aVar.d();
            }
        }
        Iterator it5 = customList.iterator();
        while (it5.hasNext()) {
            com.tencent.luggage.wxa.l7.c a16 = com.tencent.luggage.wxa.l7.d.f133104m.a((WxaAppCustomActionSheetDelegate.ActionItem) it5.next());
            if (a16.l() == WxaAppCustomActionSheetDelegate.ActionType.onShareAPPMessage) {
                a16.a(z16);
            }
            linkedList.add(a16);
        }
        if (linkedList.size() > 1) {
            CollectionsKt__MutableCollectionsJVMKt.sortWith(linkedList, new a());
        }
        LinkedList linkedList3 = new LinkedList();
        linkedList3.addAll(linkedList);
        linkedList3.addAll(linkedList2);
        return linkedList3;
    }
}
