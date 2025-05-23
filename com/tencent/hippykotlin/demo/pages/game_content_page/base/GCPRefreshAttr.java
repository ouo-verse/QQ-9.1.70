package com.tencent.hippykotlin.demo.pages.game_content_page.base;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.views.RefreshViewState;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class GCPRefreshAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(GCPRefreshAttr.class, "refreshViewState", "getRefreshViewState()Lcom/tencent/kuikly/core/views/RefreshViewState;", 0)};
    public final ReadWriteProperty refreshViewState$delegate = c.a(RefreshViewState.IDLE);

    public final RefreshViewState getRefreshViewState() {
        return (RefreshViewState) this.refreshViewState$delegate.getValue(this, $$delegatedProperties[0]);
    }
}
