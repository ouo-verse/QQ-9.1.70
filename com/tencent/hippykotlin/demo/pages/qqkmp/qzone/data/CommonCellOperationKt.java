package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.Entry;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StCellOperation;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StOperationForwardToQzoneInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StOperationShareOutInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0001H\u0000\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellOperation;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StCellOperation;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonCellOperationKt {
    public static final CommonCellOperation toCommon(StCellOperation stCellOperation) {
        int collectionSizeOrDefault;
        List<CommonEntry> mutableList;
        if (stCellOperation == null) {
            return null;
        }
        CommonCellOperation commonCellOperation = new CommonCellOperation();
        commonCellOperation.setShareOutside(CommonOperationShareOutInfoKt.toCommon(stCellOperation.shareOutside));
        commonCellOperation.setForwardToQzone(CommonOperationForwardToQzoneInfoKt.toCommon(stCellOperation.forwardToQzone));
        List<Entry> list = stCellOperation.feedReportCookie;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonEntryKt.toCommon((Entry) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        commonCellOperation.setFeedReportCookie(mutableList);
        return commonCellOperation;
    }

    public static final StCellOperation toPb(CommonCellOperation commonCellOperation) {
        int collectionSizeOrDefault;
        List mutableList;
        if (commonCellOperation == null) {
            return null;
        }
        StOperationShareOutInfo pb5 = CommonOperationShareOutInfoKt.toPb(commonCellOperation.getShareOutside());
        StOperationForwardToQzoneInfo pb6 = CommonOperationForwardToQzoneInfoKt.toPb(commonCellOperation.getForwardToQzone());
        List<CommonEntry> feedReportCookie = commonCellOperation.getFeedReportCookie();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(feedReportCookie, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = feedReportCookie.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonEntryKt.toPb((CommonEntry) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        return new StCellOperation(pb5, pb6, mutableList);
    }
}
