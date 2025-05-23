package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.data;

import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.base.StFeed;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.pb.kuikly.trpc.qzone.local.StFeedList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002H\u0000\u001a\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0001H\u0000\u00a8\u0006\u0004"}, d2 = {"toCommon", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/data/CommonFeedList;", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/pb/kuikly/trpc/qzone/local/StFeedList;", "toPb", "qecommerce-biz_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class CommonFeedListKt {
    public static final CommonFeedList toCommon(StFeedList stFeedList) {
        int collectionSizeOrDefault;
        List<CommonFeed> mutableList;
        if (stFeedList == null) {
            return null;
        }
        CommonFeedList commonFeedList = new CommonFeedList();
        List<StFeed> list = stFeedList.feedItems;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            CommonFeed commonFeed = CommonFeedKt.toCommonFeed((StFeed) it.next());
            if (commonFeed == null) {
                commonFeed = new CommonFeed();
            }
            arrayList.add(commonFeed);
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        commonFeedList.setFeedItems(mutableList);
        return commonFeedList;
    }

    public static final StFeedList toPb(CommonFeedList commonFeedList) {
        int collectionSizeOrDefault;
        List mutableList;
        if (commonFeedList == null) {
            return null;
        }
        List<CommonFeed> feedItems = commonFeedList.getFeedItems();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(feedItems, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = feedItems.iterator();
        while (it.hasNext()) {
            StFeed pbFeed = CommonFeedKt.toPbFeed((CommonFeed) it.next());
            if (pbFeed == null) {
                pbFeed = new StFeed(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.MAX_VALUE, null);
            }
            arrayList.add(pbFeed);
        }
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        return new StFeedList(mutableList);
    }
}
