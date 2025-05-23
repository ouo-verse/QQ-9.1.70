package com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view.feed_card;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import com.tencent.ttpic.openapi.filter.LightConstants;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import q25.f;

/* loaded from: classes31.dex */
public final class NearbyFDPContentFeedAvatarViewAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPContentFeedAvatarViewAttr.class, "tinyId", "getTinyId()J", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPContentFeedAvatarViewAttr.class, LightConstants.MALE, "getMale()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPContentFeedAvatarViewAttr.class, "filamentResource", "getFilamentResource()Lkuikly/com/tencent/trpcprotocol/lplan/common/status/ResourceInfo;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPContentFeedAvatarViewAttr.class, "loadAvatarView", "getLoadAvatarView()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPContentFeedAvatarViewAttr.class, "playAvatarEnable", "getPlayAvatarEnable()Z", 0)};
    public final ReadWriteProperty filamentResource$delegate;
    public final ReadWriteProperty loadAvatarView$delegate;
    public final ReadWriteProperty male$delegate;
    public final ReadWriteProperty playAvatarEnable$delegate;
    public final ReadWriteProperty tinyId$delegate = c.a(0L);

    public NearbyFDPContentFeedAvatarViewAttr() {
        Boolean bool = Boolean.TRUE;
        this.male$delegate = c.a(bool);
        this.filamentResource$delegate = c.a(null);
        this.loadAvatarView$delegate = c.a(Boolean.FALSE);
        this.playAvatarEnable$delegate = c.a(bool);
    }

    public final void setFilamentResource(f fVar) {
        this.filamentResource$delegate.setValue(this, $$delegatedProperties[2], fVar);
    }

    public final void setLoadAvatarView(boolean z16) {
        this.loadAvatarView$delegate.setValue(this, $$delegatedProperties[3], Boolean.valueOf(z16));
    }

    public final void setMale(boolean z16) {
        this.male$delegate.setValue(this, $$delegatedProperties[1], Boolean.valueOf(z16));
    }

    public final void setTinyId(long j3) {
        this.tinyId$delegate.setValue(this, $$delegatedProperties[0], Long.valueOf(j3));
    }
}
