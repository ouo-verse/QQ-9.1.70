package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview.troop.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.base.k;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes32.dex */
public final class PlaceAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(PlaceAttr.class, "isSelected", "isSelected()Z", 0)};
    public h selectedBgColor;
    public boolean showStrip;
    public h unselectedBgColor;
    public final ReadWriteProperty isSelected$delegate = c.a(Boolean.FALSE);
    public String text = "";

    public PlaceAttr() {
        h.Companion companion = h.INSTANCE;
        this.selectedBgColor = companion.j();
        this.unselectedBgColor = companion.j();
    }

    public final boolean isSelected() {
        return ((Boolean) this.isSelected$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setSelected(boolean z16) {
        this.isSelected$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z16));
    }
}
