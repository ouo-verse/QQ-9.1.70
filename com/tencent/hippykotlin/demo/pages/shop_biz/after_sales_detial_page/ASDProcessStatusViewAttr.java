package com.tencent.hippykotlin.demo.pages.shop_biz.after_sales_detial_page;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import java.util.ArrayList;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes33.dex */
public final class ASDProcessStatusViewAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ASDProcessStatusViewAttr.class, "processStatusList", "getProcessStatusList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ASDProcessStatusViewAttr.class, "title", "getTitle()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ASDProcessStatusViewAttr.class, QQWinkConstants.TAB_SUBTITLE, "getSubTitle()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(ASDProcessStatusViewAttr.class, "hyperTextSpanList", "getHyperTextSpanList()Ljava/util/ArrayList;", 0)};
    public final ReadWriteProperty processStatusList$delegate = c.b();
    public final ReadWriteProperty title$delegate = c.a("");
    public final ReadWriteProperty subTitle$delegate = c.a("");
    public final ReadWriteProperty hyperTextSpanList$delegate = c.a(new ArrayList());

    public final com.tencent.kuikly.core.reactive.collection.c<ProcessStatusItem> getProcessStatusList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.processStatusList$delegate.getValue(this, $$delegatedProperties[0]);
    }
}
