package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellSummary;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StRichMsg;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0001H\u0000\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellSummary;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellSummary;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonCellSummaryKt {
    public static final CommonCellSummary toCommon(StFeedCellSummary stFeedCellSummary) {
        int collectionSizeOrDefault;
        if (stFeedCellSummary == null) {
            return null;
        }
        CommonCellSummary commonCellSummary = new CommonCellSummary();
        List<StRichMsg> list = stFeedCellSummary.summary;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonRichMsgKt.toCommon((StRichMsg) it.next()));
        }
        commonCellSummary.setSummary(arrayList);
        Boolean bool = stFeedCellSummary.hasMore;
        commonCellSummary.setHasMore(bool != null ? bool.booleanValue() : false);
        return commonCellSummary;
    }

    public static final StFeedCellSummary toPb(CommonCellSummary commonCellSummary) {
        int collectionSizeOrDefault;
        List mutableList;
        if (commonCellSummary == null) {
            return null;
        }
        List<CommonRichMsg> summary = commonCellSummary.getSummary();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(summary, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = summary.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonRichMsgKt.toPb((CommonRichMsg) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        return new StFeedCellSummary(mutableList, Boolean.valueOf(commonCellSummary.getHasMore()), null, 4, null);
    }
}
