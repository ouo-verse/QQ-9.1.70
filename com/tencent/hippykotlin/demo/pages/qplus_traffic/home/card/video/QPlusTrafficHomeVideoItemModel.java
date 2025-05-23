package com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.video;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusCirStFeed;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusLiveStatus;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class QPlusTrafficHomeVideoItemModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPlusTrafficHomeVideoItemModel.class, "isSelect", "isSelect()Z", 0)};
    public final QPlusCirStFeed info;
    public final ReadWriteProperty isSelect$delegate;
    public final QPlusLiveStatus live;

    public QPlusTrafficHomeVideoItemModel(QPlusCirStFeed qPlusCirStFeed, QPlusLiveStatus qPlusLiveStatus) {
        this.info = qPlusCirStFeed;
        this.live = qPlusLiveStatus;
        this.isSelect$delegate = c.a(Boolean.FALSE);
    }

    public final boolean isLiveItem() {
        return Intrinsics.areEqual(this.info.feedId, "live_feed_id");
    }

    public final void setSelect(boolean z16) {
        this.isSelect$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z16));
    }

    public /* synthetic */ QPlusTrafficHomeVideoItemModel(QPlusCirStFeed qPlusCirStFeed) {
        this(qPlusCirStFeed, new QPlusLiveStatus(0L, 0L, 0, 0, null, null, null, null, 255, null));
    }
}
