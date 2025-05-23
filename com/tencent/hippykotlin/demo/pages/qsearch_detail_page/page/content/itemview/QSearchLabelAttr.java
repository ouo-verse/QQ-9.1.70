package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchLabelAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchLabelAttr.class, "label", "getLabel()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchLabelAttr.class, "isSelected", "isSelected()Z", 0)};
    public final ReadWriteProperty label$delegate = c.a("");
    public final ReadWriteProperty isSelected$delegate = c.a(Boolean.FALSE);

    public final boolean isSelected() {
        return ((Boolean) this.isSelected$delegate.getValue(this, $$delegatedProperties[1])).booleanValue();
    }

    public final void setLabel(String str) {
        this.label$delegate.setValue(this, $$delegatedProperties[0], str);
    }

    public final void setSelected(boolean z16) {
        this.isSelected$delegate.setValue(this, $$delegatedProperties[1], Boolean.valueOf(z16));
    }
}
