package com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard.NearbyFDPStatusContentViewModel;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NearbyContentTagsAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyContentTagsAttr.class, "viewModel", "getViewModel()Lcom/tencent/hippykotlin/demo/pages/nearby/feed_detail/view_model/UserFeedsCard/NearbyFDPStatusContentViewModel;", 0)};
    public boolean isDarkStyle;
    public final ReadWriteProperty viewModel$delegate = c.a(null);

    public final NearbyFDPStatusContentViewModel getViewModel() {
        return (NearbyFDPStatusContentViewModel) this.viewModel$delegate.getValue(this, $$delegatedProperties[0]);
    }
}
