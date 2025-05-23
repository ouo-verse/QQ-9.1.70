package com.tencent.hippykotlin.demo.pages.qplus_traffic.home.card.data;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.define.QPlusTrafficUIState;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.home.shell.QPlusTrafficHomeCardView;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusDateIndex;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusGetOverviewRsp;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusIndex;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusOverviewData;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.repository.protoc.QPlusViewTab;
import com.tencent.hippykotlin.demo.pages.qplus_traffic.shell.IQPlusTrafficCardHomeViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* loaded from: classes31.dex */
public final class QPlusTrafficHomeDataViewModel implements IQPlusTrafficCardHomeViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {IPagerIdKtxKt$$ExternalSyntheticOutline0.m(QPlusTrafficHomeDataViewModel.class, "dateTitles", "getDateTitles()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), IPagerIdKtxKt$$ExternalSyntheticOutline0.m(QPlusTrafficHomeDataViewModel.class, "overviewData", "getOverviewData()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPlusTrafficHomeDataViewModel.class, "columnCount", "getColumnCount()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPlusTrafficHomeDataViewModel.class, "overviewHeight", "getOverviewHeight()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QPlusTrafficHomeDataViewModel.class, "uiState", "getUiState()Lcom/tencent/hippykotlin/demo/pages/qplus_traffic/define/QPlusTrafficUIState;", 0)};
    public int selectDateIndex;
    public int selectTabIndex;
    public int selectTabOverviewCount;
    public final ReadWriteProperty dateTitles$delegate = c.b();
    public final ReadWriteProperty overviewData$delegate = c.b();
    public final ArrayList<String> categoryTitles = new ArrayList<>();
    public final ReadWriteProperty columnCount$delegate = c.a(4);
    public final ReadWriteProperty overviewHeight$delegate = c.a(Float.valueOf(45.0f));
    public final ReadWriteProperty uiState$delegate = c.a(QPlusTrafficUIState.LOADING);
    public final ArrayList<QPlusOverviewData> tabItems = new ArrayList<>();

    @Override // com.tencent.hippykotlin.demo.pages.qplus_traffic.shell.IQPlusTrafficCardHomeViewModel
    public final QPlusTrafficHomeCardView getCardView() {
        return new QPlusAccessHomeDataView();
    }

    public final com.tencent.kuikly.core.reactive.collection.c<QPlusTrafficHomeDataDateTitle> getDateTitles() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.dateTitles$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final com.tencent.kuikly.core.reactive.collection.c<QPlusIndex> getOverviewData() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.overviewData$delegate.getValue(this, $$delegatedProperties[1]);
    }

    public final QPlusTrafficUIState getUiState() {
        return (QPlusTrafficUIState) this.uiState$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final void selectOverviewData(int i3, int i16) {
        ArrayList<QPlusIndex> arrayList;
        ArrayList<QPlusIndex> arrayList2;
        if (i3 >= this.tabItems.size()) {
            return;
        }
        int i17 = 0;
        if (i16 < getDateTitles().size()) {
            QPlusTrafficHomeDataDateTitle qPlusTrafficHomeDataDateTitle = getDateTitles().get(this.selectDateIndex);
            QPlusTrafficHomeDataDateTitle qPlusTrafficHomeDataDateTitle2 = getDateTitles().get(i16);
            ReadWriteProperty readWriteProperty = qPlusTrafficHomeDataDateTitle.isSelect$delegate;
            KProperty<?>[] kPropertyArr = QPlusTrafficHomeDataDateTitle.$$delegatedProperties;
            readWriteProperty.setValue(qPlusTrafficHomeDataDateTitle, kPropertyArr[0], Boolean.FALSE);
            qPlusTrafficHomeDataDateTitle2.isSelect$delegate.setValue(qPlusTrafficHomeDataDateTitle2, kPropertyArr[0], Boolean.TRUE);
            this.selectDateIndex = i16;
        }
        QPlusOverviewData qPlusOverviewData = this.tabItems.get(i3);
        ArrayList<QPlusDateIndex> arrayList3 = qPlusOverviewData.dateIndexs;
        if ((arrayList3 != null ? arrayList3.size() : 0) > i16) {
            ArrayList<QPlusDateIndex> arrayList4 = qPlusOverviewData.dateIndexs;
            QPlusDateIndex qPlusDateIndex = arrayList4 != null ? arrayList4.get(i16) : null;
            if (qPlusDateIndex != null && (arrayList2 = qPlusDateIndex.indexs) != null) {
                i17 = arrayList2.size();
            }
            this.selectTabOverviewCount = i17;
            getOverviewData().clear();
            int i18 = this.selectTabOverviewCount;
            if (i18 > 4) {
                ReadWriteProperty readWriteProperty2 = this.overviewHeight$delegate;
                KProperty<?>[] kPropertyArr2 = $$delegatedProperties;
                readWriteProperty2.setValue(this, kPropertyArr2[3], Float.valueOf((((i18 + 3) - 1) / 3) * 45.0f));
                this.columnCount$delegate.setValue(this, kPropertyArr2[2], 3);
            } else {
                ReadWriteProperty readWriteProperty3 = this.overviewHeight$delegate;
                KProperty<?>[] kPropertyArr3 = $$delegatedProperties;
                readWriteProperty3.setValue(this, kPropertyArr3[3], Float.valueOf(45.0f));
                this.columnCount$delegate.setValue(this, kPropertyArr3[2], Integer.valueOf(i18));
            }
            if (qPlusDateIndex == null || (arrayList = qPlusDateIndex.indexs) == null) {
                return;
            }
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                getOverviewData().add((QPlusIndex) it.next());
            }
        }
    }

    public final void selectTabIndex(int i3) {
        if (i3 < this.tabItems.size()) {
            this.selectTabIndex = i3;
            getDateTitles().clear();
            ArrayList<QPlusDateIndex> arrayList = this.tabItems.get(i3).dateIndexs;
            if (arrayList != null) {
                Iterator<T> it = arrayList.iterator();
                while (it.hasNext()) {
                    getDateTitles().add(new QPlusTrafficHomeDataDateTitle(((QPlusDateIndex) it.next()).dateType));
                }
            }
        }
        selectOverviewData(i3, 0);
    }

    public final void setUiState(QPlusTrafficUIState qPlusTrafficUIState) {
        this.uiState$delegate.setValue(this, $$delegatedProperties[4], qPlusTrafficUIState);
    }

    public final void refreshData(QPlusGetOverviewRsp qPlusGetOverviewRsp) {
        String str;
        if (qPlusGetOverviewRsp == null) {
            return;
        }
        setUiState(QPlusTrafficUIState.LOADING);
        this.tabItems.clear();
        this.categoryTitles.clear();
        ArrayList<QPlusOverviewData> arrayList = qPlusGetOverviewRsp.overviewDatas;
        if (arrayList != null) {
            for (QPlusOverviewData qPlusOverviewData : arrayList) {
                this.tabItems.add(qPlusOverviewData);
                ArrayList<String> arrayList2 = this.categoryTitles;
                QPlusViewTab qPlusViewTab = qPlusOverviewData.viewTab;
                if (qPlusViewTab == null || (str = qPlusViewTab.tabName) == null) {
                    str = "\u672a\u77e5";
                }
                arrayList2.add(str);
            }
        }
        selectTabIndex(0);
        setUiState(QPlusTrafficUIState.COMPLETED);
    }
}
