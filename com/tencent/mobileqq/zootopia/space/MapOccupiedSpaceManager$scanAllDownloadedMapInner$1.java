package com.tencent.mobileqq.zootopia.space;

import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.mapstatus.ZootopiaMapStatusManager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/tencent/mobileqq/zootopia/download/ui/d;", "list", "", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class MapOccupiedSpaceManager$scanAllDownloadedMapInner$1 extends Lambda implements Function1<List<? extends com.tencent.mobileqq.zootopia.download.ui.d>, Unit> {
    public static final MapOccupiedSpaceManager$scanAllDownloadedMapInner$1 INSTANCE = new MapOccupiedSpaceManager$scanAllDownloadedMapInner$1();

    /* JADX INFO: Access modifiers changed from: private */
    public static final int b(com.tencent.mobileqq.zootopia.download.ui.d dVar, com.tencent.mobileqq.zootopia.download.ui.d dVar2) {
        long completeTime = dVar.getData().getResData().getCompleteTime();
        long completeTime2 = dVar2.getData().getResData().getCompleteTime();
        if (completeTime > completeTime2) {
            return -1;
        }
        return completeTime == completeTime2 ? 0 : 1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.tencent.mobileqq.zootopia.download.ui.d> list) {
        invoke2((List<com.tencent.mobileqq.zootopia.download.ui.d>) list);
        return Unit.INSTANCE;
    }

    MapOccupiedSpaceManager$scanAllDownloadedMapInner$1() {
        super(1);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<com.tencent.mobileqq.zootopia.download.ui.d> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        if (list.isEmpty()) {
            QLog.e("MapOccupiedSpaceManager", 1, "initAsync list is empty");
        }
        ArrayList arrayList = new ArrayList();
        for (com.tencent.mobileqq.zootopia.download.ui.d dVar : list) {
            com.tencent.sqshow.zootopia.mapstatus.b d16 = ZootopiaMapStatusManager.f370743d.d(dVar.getData().getSummaryData().getId());
            if (d16 != null) {
                dVar.o(d16.c().getMapStatus());
            }
            arrayList.add(dVar);
        }
        CollectionsKt__MutableCollectionsJVMKt.sortWith(arrayList, new Comparator() { // from class: com.tencent.mobileqq.zootopia.space.i
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int b16;
                b16 = MapOccupiedSpaceManager$scanAllDownloadedMapInner$1.b((com.tencent.mobileqq.zootopia.download.ui.d) obj, (com.tencent.mobileqq.zootopia.download.ui.d) obj2);
                return b16;
            }
        });
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((com.tencent.mobileqq.zootopia.download.ui.d) it.next()).getData().getSummaryData().getId());
        }
        QLog.i("MapOccupiedSpaceManager", 1, "initAsync downloadedMapIdList:" + arrayList2);
        MapOccupiedSpaceManager.f329259b.H(arrayList2);
    }
}
