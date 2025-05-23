package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellVisitor;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StUser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002\u001a\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0001\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellVisitor;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellVisitor;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonCellVisitorKt {
    public static final CommonCellVisitor toCommon(StFeedCellVisitor stFeedCellVisitor) {
        int collectionSizeOrDefault;
        if (stFeedCellVisitor == null) {
            return null;
        }
        CommonCellVisitor commonCellVisitor = new CommonCellVisitor();
        Integer num = stFeedCellVisitor.viewNum;
        commonCellVisitor.setViewNum(num != null ? num.intValue() : 0);
        Integer num2 = stFeedCellVisitor.visitorNum;
        commonCellVisitor.setVisitorNum(num2 != null ? num2.intValue() : 0);
        List<StUser> list = stFeedCellVisitor.visitors;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonUserKt.toCommonNonNull((StUser) it.next()));
        }
        commonCellVisitor.setVisitors(arrayList);
        commonCellVisitor.setActionUrl(stFeedCellVisitor.actionUrl);
        return commonCellVisitor;
    }

    public static final StFeedCellVisitor toPb(CommonCellVisitor commonCellVisitor) {
        int collectionSizeOrDefault;
        List mutableList;
        if (commonCellVisitor == null) {
            return null;
        }
        Integer valueOf = Integer.valueOf(commonCellVisitor.getViewNum());
        Integer valueOf2 = Integer.valueOf(commonCellVisitor.getVisitorNum());
        List<CommonUser> visitors = commonCellVisitor.getVisitors();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(visitors, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = visitors.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonUserKt.toPbNonNull((CommonUser) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        return new StFeedCellVisitor(valueOf, valueOf2, mutableList, commonCellVisitor.getActionUrl());
    }
}
