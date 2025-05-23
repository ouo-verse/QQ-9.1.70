package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.portrait_list_views;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverPortraitListItem;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model.QPPromoteReceiverPortraitPageModel;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class QPPromoteReceiverPortraitSectionListModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPPromoteReceiverPortraitSectionListModel.class, "title", "getTitle()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPPromoteReceiverPortraitSectionListModel.class, "sectionList", "getSectionList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPPromoteReceiverPortraitSectionListModel.class, "isCollapsed", "isCollapsed()Z", 0)};
    public final QPPromoteReceiverPortraitPageModel pageModel;
    public final ReadWriteProperty title$delegate = c.a("");
    public final ReadWriteProperty sectionList$delegate = c.b();
    public final ReadWriteProperty isCollapsed$delegate = c.a(Boolean.TRUE);

    public QPPromoteReceiverPortraitSectionListModel(QPPromoteReceiverPortraitPageModel qPPromoteReceiverPortraitPageModel) {
        this.pageModel = qPPromoteReceiverPortraitPageModel;
    }

    public final com.tencent.kuikly.core.reactive.collection.c<QPPromoteReceiverPortraitListItem> getSectionList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.sectionList$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final boolean isCollapsed() {
        return ((Boolean) this.isCollapsed$delegate.getValue(this, $$delegatedProperties[2])).booleanValue();
    }
}
