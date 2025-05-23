package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.itemview;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.UnifySearchTabInfo;
import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public class QSearchBaseWholeCardItemAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchBaseWholeCardItemAttr.class, "isLastItem", "isLastItem()Z", 0)};
    public int index;
    public boolean isFirstItem;
    public final ReadWriteProperty isLastItem$delegate = c.a(Boolean.FALSE);
    public UnifySearchTabInfo tabData;

    public final UnifySearchTabInfo getTabData() {
        UnifySearchTabInfo unifySearchTabInfo = this.tabData;
        if (unifySearchTabInfo != null) {
            return unifySearchTabInfo;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tabData");
        return null;
    }

    public final boolean isLastItem() {
        return ((Boolean) this.isLastItem$delegate.getValue(this, $$delegatedProperties[0])).booleanValue();
    }

    public final void setLastItem(boolean z16) {
        this.isLastItem$delegate.setValue(this, $$delegatedProperties[0], Boolean.valueOf(z16));
    }
}
