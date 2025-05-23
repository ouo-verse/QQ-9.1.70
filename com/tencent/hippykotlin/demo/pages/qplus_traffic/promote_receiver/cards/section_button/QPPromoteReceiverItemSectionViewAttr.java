package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button;

import c01.c;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverViewModel;
import com.tencent.kuikly.core.base.k;
import kotlin.jvm.functions.Function3;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class QPPromoteReceiverItemSectionViewAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPPromoteReceiverItemSectionViewAttr.class, PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "getItem()Lcom/tencent/hippykotlin/demo/pages/qplus_traffic/promote_receiver/cards/section_button/QPPromoteReceiverItem;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPPromoteReceiverItemSectionViewAttr.class, "sectionTitle", "getSectionTitle()Ljava/lang/String;", 0)};
    public QPPromoteReceiverViewModel viewModel = new QPPromoteReceiverViewModel();
    public QPPromoteReceiverSectionViewModel sectionViewModel = new QPPromoteReceiverSectionViewModel();
    public final ReadWriteProperty item$delegate = c.a(new QPPromoteReceiverItem((String) null, 0, 0, false, false, (Function3) null, 127));
    public final ReadWriteProperty sectionTitle$delegate = c.a("");

    public final QPPromoteReceiverItem getItem() {
        return (QPPromoteReceiverItem) this.item$delegate.getValue(this, $$delegatedProperties[0]);
    }
}
