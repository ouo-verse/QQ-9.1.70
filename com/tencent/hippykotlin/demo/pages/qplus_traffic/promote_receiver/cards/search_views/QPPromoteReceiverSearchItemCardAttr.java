package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.search_views;

import c01.c;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverPortraitListItem;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverPortraitPageModel;
import com.tencent.kuikly.core.base.k;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class QPPromoteReceiverSearchItemCardAttr extends k {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPPromoteReceiverSearchItemCardAttr.class, PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "getItem()Lcom/tencent/hippykotlin/demo/pages/qplus_traffic/promote_receiver/page_model/QPPromoteReceiverPortraitListItem;", 0)};
    public QPPromoteReceiverPortraitPageModel viewModel;
    public final String groupDefaultAvatar = "https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/sNUq1Yzn.png";
    public final String userDefaultAvatar = "https://vfiles.gtimg.cn/wuji_dashboard/xy/componenthub/nLY3LmQK.png";
    public final ReadWriteProperty item$delegate = c.a(new QPPromoteReceiverPortraitListItem("", "", "", 56));

    public final QPPromoteReceiverPortraitListItem getItem() {
        return (QPPromoteReceiverPortraitListItem) this.item$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final QPPromoteReceiverPortraitPageModel getViewModel() {
        QPPromoteReceiverPortraitPageModel qPPromoteReceiverPortraitPageModel = this.viewModel;
        if (qPPromoteReceiverPortraitPageModel != null) {
            return qPPromoteReceiverPortraitPageModel;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public final void item(QPPromoteReceiverPortraitListItem qPPromoteReceiverPortraitListItem) {
        this.item$delegate.setValue(this, $$delegatedProperties[0], qPPromoteReceiverPortraitListItem);
    }
}
