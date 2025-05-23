package com.tencent.hippykotlin.demo.pages.qplus_traffic.promote_receiver.page_model;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.protocol.list.IListRequestLogic;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusSearchTalentsReq;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusSearchTalentsRsp;
import com.tencent.kuikly.core.base.aa;
import com.tencent.kuikly.core.views.FooterRefreshState;
import com.tencent.kuikly.core.views.InputView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes31.dex */
public class QPPromoteReceiverPortraitPageModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPPromoteReceiverPortraitPageModel.class, "allItemList", "getAllItemList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPPromoteReceiverPortraitPageModel.class, "showItemList", "getShowItemList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPPromoteReceiverPortraitPageModel.class, "searchStatus", "getSearchStatus()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPPromoteReceiverPortraitPageModel.class, "selectedList", "getSelectedList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPPromoteReceiverPortraitPageModel.class, "selectedCount", "getSelectedCount()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPPromoteReceiverPortraitPageModel.class, "needSearchResultFooter", "getNeedSearchResultFooter()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPPromoteReceiverPortraitPageModel.class, "searchResultState", "getSearchResultState()Lcom/tencent/kuikly/core/views/FooterRefreshState;", 0)};
    public boolean isRequesting;
    public aa<InputView> searchBarInputViewRef;
    public IListRequestLogic<QPlusSearchTalentsReq, QPlusSearchTalentsRsp> searchLogic;
    public final ReadWriteProperty allItemList$delegate = c.b();
    public final ReadWriteProperty showItemList$delegate = c.b();
    public final ReadWriteProperty searchStatus$delegate = c.a(0);
    public final ReadWriteProperty selectedList$delegate = c.b();
    public final ReadWriteProperty selectedCount$delegate = c.a(0);
    public final int selectedMaxNum = 20;
    public String dataParam = "";
    public final ReadWriteProperty needSearchResultFooter$delegate = c.a(Boolean.FALSE);
    public final ReadWriteProperty searchResultState$delegate = c.a(FooterRefreshState.REFRESHING);

    public final com.tencent.kuikly.core.reactive.collection.c<QPPromoteReceiverPortraitListItem> getAllItemList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.allItemList$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final boolean getNeedSearchResultFooter() {
        return ((Boolean) this.needSearchResultFooter$delegate.getValue(this, $$delegatedProperties[5])).booleanValue();
    }

    public final int getSearchStatus() {
        return ((Number) this.searchStatus$delegate.getValue(this, $$delegatedProperties[2])).intValue();
    }

    public final int getSelectedCount() {
        return ((Number) this.selectedCount$delegate.getValue(this, $$delegatedProperties[4])).intValue();
    }

    public final com.tencent.kuikly.core.reactive.collection.c<QPPromoteReceiverPortraitListItem> getSelectedList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.selectedList$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final com.tencent.kuikly.core.reactive.collection.c<QPPromoteReceiverPortraitListItem> getShowItemList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.showItemList$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final boolean hasAddedToAllItems(QPPromoteReceiverPortraitListItem qPPromoteReceiverPortraitListItem) {
        Iterator<QPPromoteReceiverPortraitListItem> it = getAllItemList().iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().uin, qPPromoteReceiverPortraitListItem.uin)) {
                return true;
            }
        }
        return false;
    }

    public final boolean hasSelectedItem(QPPromoteReceiverPortraitListItem qPPromoteReceiverPortraitListItem) {
        Iterator<QPPromoteReceiverPortraitListItem> it = getSelectedList().iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(it.next().uin, qPPromoteReceiverPortraitListItem.uin)) {
                return true;
            }
        }
        return false;
    }

    public void onBeginSearch(String str) {
        boolean contains;
        boolean contains$default;
        ArrayList arrayList = new ArrayList();
        Iterator<QPPromoteReceiverPortraitListItem> it = getAllItemList().iterator();
        while (it.hasNext()) {
            QPPromoteReceiverPortraitListItem next = it.next();
            contains = StringsKt__StringsKt.contains((CharSequence) next.name, (CharSequence) str, true);
            if (!contains) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) next.uin, (CharSequence) str, false, 2, (Object) null);
                if (contains$default) {
                }
            }
            arrayList.add(next);
        }
        getShowItemList().clear();
        getShowItemList().addAll(arrayList);
        setSearchStatus(1);
    }

    public void onSwitchItemStatus(QPPromoteReceiverPortraitListItem qPPromoteReceiverPortraitListItem) {
        if (hasSelectedItem(qPPromoteReceiverPortraitListItem)) {
            int size = getSelectedList().size();
            int i3 = 0;
            int i16 = 0;
            while (true) {
                if (i16 >= size) {
                    break;
                }
                if (Intrinsics.areEqual(getSelectedList().get(i16).uin, qPPromoteReceiverPortraitListItem.uin)) {
                    i3 = i16;
                    break;
                }
                i16++;
            }
            getSelectedList().remove(i3);
            setSelectedCount(getSelectedCount() - 1);
            return;
        }
        if (getSelectedList().size() >= 20) {
            BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("\u6700\u591a\u9009\u62e9");
            m3.append(this.selectedMaxNum);
            m3.append('\u4e2a');
            currentBridgeModule.toast(m3.toString());
            return;
        }
        getSelectedList().add(qPPromoteReceiverPortraitListItem);
        setSelectedCount(getSelectedCount() + 1);
    }

    public final void setNeedSearchResultFooter() {
        this.needSearchResultFooter$delegate.setValue(this, $$delegatedProperties[5], Boolean.TRUE);
    }

    public final void setSearchResultState(FooterRefreshState footerRefreshState) {
        this.searchResultState$delegate.setValue(this, $$delegatedProperties[6], footerRefreshState);
    }

    public final void setSearchStatus(int i3) {
        this.searchStatus$delegate.setValue(this, $$delegatedProperties[2], Integer.valueOf(i3));
    }

    public final void setSelectedCount(int i3) {
        this.selectedCount$delegate.setValue(this, $$delegatedProperties[4], Integer.valueOf(i3));
    }

    public final void onEndSearch(boolean z16) {
        aa<InputView> aaVar;
        InputView b16;
        if (z16) {
            Utils.INSTANCE.currentBridgeModule().callNativeMethod("closeKeyboard", null, null);
        }
        if (getSearchStatus() == 1 && (aaVar = this.searchBarInputViewRef) != null && (b16 = aaVar.b()) != null) {
            b16.setText("");
        }
        setSearchStatus(0);
    }

    public void loadMore() {
    }
}
