package com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds;

import com.tencent.hippykotlin.demo.pages.nearby.middle_page.NBPMiddlePageDTReporter;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p35.n;

/* loaded from: classes31.dex */
public final /* synthetic */ class NearbyFeedListViewModel$handlePublishFeedSuccess$feedVm$3 extends FunctionReferenceImpl implements Function2<n, e, Unit> {
    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(n nVar, e eVar) {
        NBPMiddlePageDTReporter.reportElementClick$default(((NearbyFeedListViewModel) this.receiver).dtReporter, "em_nearby_post_dynamic_feed", eVar, null, 4);
        return Unit.INSTANCE;
    }

    public NearbyFeedListViewModel$handlePublishFeedSuccess$feedVm$3(Object obj) {
        super(2, obj, NearbyFeedListViewModel.class, "onReportClick", "onReportClick(Lkuikly/com/tencent/trpcprotocol/qqstranger/common/feed/Feed;Lcom/tencent/kuikly/core/nvi/serialization/json/JSONObject;)V", 0);
    }
}
