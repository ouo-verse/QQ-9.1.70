package com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NearbyImageContentViewAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyImageContentViewAttr.class, "contentWidth", "getContentWidth()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyImageContentViewAttr.class, "viewModel", "getViewModel()Lcom/tencent/hippykotlin/demo/pages/nearby/feed_detail/view_model/UserFeedsCard/NearbyFDPStatusContentViewModel;", 0)};
    public final ReadWriteProperty contentWidth$delegate = c.a(Float.valueOf(0.0f));
    public final ReadWriteProperty viewModel$delegate = c.a(null);

    public final float getContentWidth() {
        return ((Number) this.contentWidth$delegate.getValue(this, $$delegatedProperties[0])).floatValue();
    }
}
