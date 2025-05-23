package com.tencent.hippykotlin.demo.pages.nearby.base.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.views.RefreshViewState;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NearbyRefreshAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyRefreshAttr.class, "refreshState", "getRefreshState()Lcom/tencent/kuikly/core/views/RefreshViewState;", 0)};
    public final ReadWriteProperty refreshState$delegate = c.a(RefreshViewState.IDLE);

    public final RefreshViewState getRefreshState() {
        return (RefreshViewState) this.refreshState$delegate.getValue(this, $$delegatedProperties[0]);
    }
}
