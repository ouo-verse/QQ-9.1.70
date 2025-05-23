package com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds;

import com.tencent.hippykotlin.demo.pages.nearby.middle_page.NBPMiddlePageDTReporter;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p35.n;

/* compiled from: P */
/* loaded from: classes31.dex */
public final /* synthetic */ class NearbyFeedListViewModel$onLoadMore$1$newFeeds$2$3 extends FunctionReferenceImpl implements Function2<n, e, Unit> {
    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(n nVar, e eVar) {
        NearbyFeedListViewModel nearbyFeedListViewModel = (NearbyFeedListViewModel) this.receiver;
        int i3 = NearbyFeedListViewModel.$r8$clinit;
        NBPMiddlePageDTReporter.reportElementClick$default(nearbyFeedListViewModel.dtReporter, "em_nearby_post_dynamic_feed", eVar, null, 4);
        return Unit.INSTANCE;
    }

    public NearbyFeedListViewModel$onLoadMore$1$newFeeds$2$3(Object obj) {
        super(2, obj, NearbyFeedListViewModel.class, "onReportClick", "onReportClick(Lkuikly/com/tencent/trpcprotocol/qqstranger/common/feed/Feed;Lcom/tencent/kuikly/core/nvi/serialization/json/JSONObject;)V", 0);
    }
}
