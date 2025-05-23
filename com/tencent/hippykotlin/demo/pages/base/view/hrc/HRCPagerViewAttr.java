package com.tencent.hippykotlin.demo.pages.base.view.hrc;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class HRCPagerViewAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(HRCPagerViewAttr.class, "hrcDataList", "getHrcDataList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0)};
    public final ReadWriteProperty hrcDataList$delegate = c.b();

    public final com.tencent.kuikly.core.reactive.collection.c<e> getHrcDataList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.hrcDataList$delegate.getValue(this, $$delegatedProperties[0]);
    }
}
