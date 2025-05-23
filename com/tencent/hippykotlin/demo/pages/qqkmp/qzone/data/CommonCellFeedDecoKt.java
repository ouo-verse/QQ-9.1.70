package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.BytesEntry;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellFeedDeco;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0001H\u0000\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellFeedDeco;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellFeedDeco;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonCellFeedDecoKt {
    public static final CommonCellFeedDeco toCommon(StCellFeedDeco stCellFeedDeco) {
        int collectionSizeOrDefault;
        List<CommonBytesEntry> mutableList;
        if (stCellFeedDeco == null) {
            return null;
        }
        CommonCellFeedDeco commonCellFeedDeco = new CommonCellFeedDeco();
        List<BytesEntry> list = stCellFeedDeco.mapInfoData;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonBytesEntryKt.toCommon((BytesEntry) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        commonCellFeedDeco.setMapInfoData(mutableList);
        commonCellFeedDeco.setUserDecoration(stCellFeedDeco.userDecoration);
        return commonCellFeedDeco;
    }

    public static final StCellFeedDeco toPb(CommonCellFeedDeco commonCellFeedDeco) {
        int collectionSizeOrDefault;
        List mutableList;
        if (commonCellFeedDeco == null) {
            return null;
        }
        List<CommonBytesEntry> mapInfoData = commonCellFeedDeco.getMapInfoData();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(mapInfoData, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = mapInfoData.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonBytesEntryKt.toPb((CommonBytesEntry) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        return new StCellFeedDeco(mutableList, commonCellFeedDeco.getUserDecoration());
    }
}
