package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeedCellTitle;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StRichMsg;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0001H\u0000\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonCellTitle;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/base/StFeedCellTitle;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonCellTitleKt {
    public static final CommonCellTitle toCommon(StFeedCellTitle stFeedCellTitle) {
        int collectionSizeOrDefault;
        if (stFeedCellTitle == null) {
            return null;
        }
        CommonCellTitle commonCellTitle = new CommonCellTitle();
        List<StRichMsg> list = stFeedCellTitle.title;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonRichMsgKt.toCommon((StRichMsg) it.next()));
        }
        commonCellTitle.setTitle(arrayList);
        commonCellTitle.setTitleUrl(stFeedCellTitle.titleUrl);
        return commonCellTitle;
    }

    public static final StFeedCellTitle toPb(CommonCellTitle commonCellTitle) {
        int collectionSizeOrDefault;
        List mutableList;
        if (commonCellTitle == null) {
            return null;
        }
        List<CommonRichMsg> title = commonCellTitle.getTitle();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(title, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = title.iterator();
        while (it.hasNext()) {
            arrayList.add(CommonRichMsgKt.toPb((CommonRichMsg) it.next()));
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        return new StFeedCellTitle(mutableList, commonCellTitle.getTitleUrl());
    }
}
