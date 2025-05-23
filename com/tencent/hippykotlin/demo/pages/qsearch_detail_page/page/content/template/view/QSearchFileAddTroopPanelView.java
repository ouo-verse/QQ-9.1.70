package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.content.template.view;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.data.pb.template.QSearchFileTemplateModel;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.dialog.QSearchBaseDialogEvent;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.view.dialog.QSearchBaseDialogView;
import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.event.Event;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes32.dex */
public final class QSearchFileAddTroopPanelView extends QSearchBaseDialogView<QSearchFileAddTroopPanelAttr, QSearchBaseDialogEvent> {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchFileAddTroopPanelView.class, "animated", "getAnimated()Z", 0)};
    public final ReadWriteProperty animated$delegate = c.a(Boolean.FALSE);

    public static final boolean access$getAnimated(QSearchFileAddTroopPanelView qSearchFileAddTroopPanelView) {
        return ((Boolean) qSearchFileAddTroopPanelView.animated$delegate.getValue(qSearchFileAddTroopPanelView, $$delegatedProperties[0])).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ QSearchFileAddTroopPanelAttr access$getAttr(QSearchFileAddTroopPanelView qSearchFileAddTroopPanelView) {
        return (QSearchFileAddTroopPanelAttr) qSearchFileAddTroopPanelView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void access$joinTroop(QSearchFileAddTroopPanelView qSearchFileAddTroopPanelView) {
        QSearchFileTemplateModel qSearchFileTemplateModel = ((QSearchFileAddTroopPanelAttr) qSearchFileAddTroopPanelView.getAttr()).fileTemplateModel;
        BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
        String str = qSearchFileTemplateModel.groupId;
        String str2 = qSearchFileTemplateModel.groupName;
        String str3 = qSearchFileTemplateModel.authSign;
        int i3 = BridgeModule.$r8$clinit;
        currentBridgeModule.joinTroop(str, str2, false, str3, null);
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new QSearchFileAddTroopPanelAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QSearchBaseDialogEvent();
    }

    @Override // com.tencent.kuikly.core.base.ComposeView
    public final void viewDidLayout() {
        super.viewDidLayout();
        this.animated$delegate.setValue(this, $$delegatedProperties[0], Boolean.TRUE);
    }
}
