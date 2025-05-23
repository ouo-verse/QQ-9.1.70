package com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.INearbyFeedDetailDTReporter;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard.NearbyFDPStatusContentViewModel;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard.NearbyFDPUserFeedsCardViewModel;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NearbyFDPStatusContentAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPStatusContentAttr.class, "viewModel", "getViewModel()Lcom/tencent/hippykotlin/demo/pages/nearby/feed_detail/view_model/UserFeedsCard/NearbyFDPStatusContentViewModel;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPStatusContentAttr.class, "cardViewModel", "getCardViewModel()Lcom/tencent/hippykotlin/demo/pages/nearby/feed_detail/view_model/UserFeedsCard/NearbyFDPUserFeedsCardViewModel;", 0)};
    public INearbyFeedDetailDTReporter dtReporter;
    public final ReadWriteProperty viewModel$delegate = c.a(null);
    public final ReadWriteProperty cardViewModel$delegate = c.a(null);

    public final NearbyFDPUserFeedsCardViewModel getCardViewModel() {
        return (NearbyFDPUserFeedsCardViewModel) this.cardViewModel$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final NearbyFDPStatusContentViewModel getViewModel() {
        return (NearbyFDPStatusContentViewModel) this.viewModel$delegate.getValue(this, $$delegatedProperties[0]);
    }
}
