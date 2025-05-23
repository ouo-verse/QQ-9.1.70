package com.tencent.hippykotlin.demo.pages.nearby.middle_page.view.feeds;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p35.n;

/* loaded from: classes31.dex */
public final /* synthetic */ class NearbyFeedListViewModel$handlePublishFeedSuccess$feedVm$2 extends FunctionReferenceImpl implements Function2<n, Float, Unit> {
    @Override // kotlin.jvm.functions.Function2
    public final Unit invoke(n nVar, Float f16) {
        float floatValue = f16.floatValue();
        NearbyFeedListViewModel.access$onReportExpose((NearbyFeedListViewModel) this.receiver, nVar, floatValue);
        return Unit.INSTANCE;
    }

    public NearbyFeedListViewModel$handlePublishFeedSuccess$feedVm$2(Object obj) {
        super(2, obj, NearbyFeedListViewModel.class, "onReportExpose", "onReportExpose(Lkuikly/com/tencent/trpcprotocol/qqstranger/common/feed/Feed;F)V", 0);
    }
}
