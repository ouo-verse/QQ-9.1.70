package com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import n25.l;

/* loaded from: classes31.dex */
public final /* synthetic */ class NearbyFDPageViewModel$fetchFollowList$1$1$firstCardModel$1 extends FunctionReferenceImpl implements Function1<l, Unit> {
    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(l lVar) {
        ((NearbyFDPageViewModel) this.receiver).onFeedActionSheetShow(lVar);
        return Unit.INSTANCE;
    }

    public NearbyFDPageViewModel$fetchFollowList$1$1$firstCardModel$1(Object obj) {
        super(1, obj, NearbyFDPageViewModel.class, "onFeedActionSheetShow", "onFeedActionSheetShow(Lkuikly/com/tencent/trpcprotocol/lplan/common/feed/StatusFeed;)V", 0);
    }
}
