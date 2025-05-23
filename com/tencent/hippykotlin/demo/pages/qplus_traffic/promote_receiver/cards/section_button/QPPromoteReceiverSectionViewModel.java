package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.cards.section_button;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.model.KTVAlertInfo;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class QPPromoteReceiverSectionViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPPromoteReceiverSectionViewModel.class, "selectItems", "getSelectItems()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPPromoteReceiverSectionViewModel.class, "descLabel", "getDescLabel()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPPromoteReceiverSectionViewModel.class, "subDescLabel", "getSubDescLabel()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPPromoteReceiverSectionViewModel.class, "hasQuestionIcon", "getHasQuestionIcon()Z", 0)};
    public final ReadWriteProperty selectItems$delegate = c.b();
    public ArrayList<QPPromoteReceiverItem> items = new ArrayList<>();
    public final ReadWriteProperty descLabel$delegate = c.a("");
    public final ReadWriteProperty subDescLabel$delegate = c.a("");
    public final ReadWriteProperty hasQuestionIcon$delegate = c.a(Boolean.FALSE);
    public KTVAlertInfo alertInfo = new KTVAlertInfo("", "");

    public final void didClickItem(QPPromoteReceiverItem qPPromoteReceiverItem) {
        if (hasSelectItem(qPPromoteReceiverItem)) {
            getSelectItems().remove(qPPromoteReceiverItem);
            if (getSelectItems().isEmpty()) {
                for (QPPromoteReceiverItem qPPromoteReceiverItem2 : this.items) {
                    if (qPPromoteReceiverItem2.isDefault) {
                        getSelectItems().add(qPPromoteReceiverItem2);
                    }
                }
                return;
            }
            return;
        }
        if (qPPromoteReceiverItem.isSingleSelect) {
            getSelectItems().clear();
            getSelectItems().add(qPPromoteReceiverItem);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (QPPromoteReceiverItem qPPromoteReceiverItem3 : getSelectItems()) {
            if (qPPromoteReceiverItem3.isSingleSelect) {
                arrayList.add(qPPromoteReceiverItem3);
            }
        }
        getSelectItems().removeAll(arrayList);
        getSelectItems().add(qPPromoteReceiverItem);
    }

    public final com.tencent.kuikly.core.reactive.collection.c<QPPromoteReceiverItem> getSelectItems() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.selectItems$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final boolean hasSelectItem(QPPromoteReceiverItem qPPromoteReceiverItem) {
        Iterator<QPPromoteReceiverItem> it = getSelectItems().iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(qPPromoteReceiverItem, it.next())) {
                return true;
            }
        }
        return false;
    }

    public final void setDescLabel(String str) {
        this.descLabel$delegate.setValue(this, $$delegatedProperties[1], str);
    }

    public final void setSubDescLabel(String str) {
        this.subDescLabel$delegate.setValue(this, $$delegatedProperties[2], str);
    }

    public final void updateItemsOnFirstCreated(ArrayList<QPPromoteReceiverItem> arrayList) {
        if (!(arrayList == null || arrayList.isEmpty())) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                didClickItem((QPPromoteReceiverItem) it.next());
            }
        } else {
            Iterator<QPPromoteReceiverItem> it5 = this.items.iterator();
            while (it5.hasNext()) {
                QPPromoteReceiverItem next = it5.next();
                if (next.isDefault) {
                    getSelectItems().add(next);
                }
            }
        }
    }
}
