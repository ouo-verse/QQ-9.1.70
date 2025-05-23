package com.tencent.hippykotlin.demo.pages.nearby.base.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import n25.l;

/* loaded from: classes31.dex */
public final class NBPCityWalkMapViewAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPCityWalkMapViewAttr.class, "statusFeed", "getStatusFeed()Lkuikly/com/tencent/trpcprotocol/lplan/common/feed/StatusFeed;", 0)};
    public float bottomDistance;
    public int jumpArticleFeedDetailSource;
    public float topDistance;
    public boolean showCount = true;
    public boolean canClick = true;
    public final ReadWriteProperty statusFeed$delegate = c.a(new l(null, null, null, null, null, null, null, 0, null, false, 0, null, 0, null, null, 2097151));

    public final l getStatusFeed() {
        return (l) this.statusFeed$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void setStatusFeed(l lVar) {
        this.statusFeed$delegate.setValue(this, $$delegatedProperties[0], lVar);
    }
}
