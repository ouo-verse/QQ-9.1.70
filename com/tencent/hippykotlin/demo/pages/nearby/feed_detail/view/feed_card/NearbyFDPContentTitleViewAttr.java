package com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard.NearbyFDPStatusContentViewModel;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class NearbyFDPContentTitleViewAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPContentTitleViewAttr.class, "viewModel", "getViewModel()Lcom/tencent/hippykotlin/demo/pages/nearby/feed_detail/view_model/UserFeedsCard/NearbyFDPStatusContentViewModel;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPContentTitleViewAttr.class, "isDarkStyle", "isDarkStyle()Z", 0)};
    public final ReadWriteProperty viewModel$delegate = c.a(null);
    public final ReadWriteProperty isDarkStyle$delegate = c.a(Boolean.FALSE);

    public final NearbyFDPStatusContentViewModel getViewModel() {
        return (NearbyFDPStatusContentViewModel) this.viewModel$delegate.getValue(this, $$delegatedProperties[0]);
    }
}
