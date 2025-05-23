package com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card;

import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.INearbyFeedDetailDTReporter;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard.NearbyFDPUserFeedsCardViewModel;
import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NearbyUserFeedsAttr extends k {
    public INearbyFeedDetailDTReporter dtReporter;
    public NearbyFDPUserFeedsCardViewModel viewModel;

    public final NearbyFDPUserFeedsCardViewModel getViewModel() {
        NearbyFDPUserFeedsCardViewModel nearbyFDPUserFeedsCardViewModel = this.viewModel;
        if (nearbyFDPUserFeedsCardViewModel != null) {
            return nearbyFDPUserFeedsCardViewModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }
}
