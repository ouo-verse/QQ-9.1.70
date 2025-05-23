package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.history;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.RefreshListState;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.qsearch_detail_page.util.QSearchStorageUtil;
import com.tencent.kuikly.core.nvi.serialization.json.JSONException;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchHistoryViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchHistoryViewModel.class, "dataList", "getDataList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(QSearchHistoryViewModel.class, "listState", "getListState()Lcom/tencent/hippykotlin/demo/pages/base/RefreshListState;", 0)};
    public final int userSource;
    public final ReadWriteProperty dataList$delegate = c.b();
    public final ReadWriteProperty listState$delegate = c.a(RefreshListState.Idle.INSTANCE);
    public int historiesMaxCount = QSearchStorageUtil.INSTANCE.getHistoriesMaxCount();

    public QSearchHistoryViewModel(int i3) {
        this.userSource = i3;
        loadHistoryWords();
    }

    public final com.tencent.kuikly.core.reactive.collection.c<String> getDataList() {
        return (com.tencent.kuikly.core.reactive.collection.c) this.dataList$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final void loadHistoryWords() {
        String str;
        b bVar;
        Object d16;
        this.listState$delegate.setValue(this, $$delegatedProperties[1], RefreshListState.Loading.INSTANCE);
        getDataList().clear();
        com.tencent.kuikly.core.reactive.collection.c<String> dataList = getDataList();
        if (this.userSource == 5) {
            str = "search_histories_q_zone";
        } else {
            str = "search_histories";
        }
        ArrayList arrayList = new ArrayList();
        String item = Utils.INSTANCE.cacheModule("").getItem(str);
        if (!(item.length() == 0)) {
            try {
                bVar = new b(item);
            } catch (JSONException e16) {
                Utils.INSTANCE.logToNative("QSearchStorageUtil #loadHistories:" + e16);
                bVar = null;
            }
            if (bVar != null) {
                int c16 = bVar.c();
                for (int i3 = 0; i3 < c16; i3++) {
                    if (BooleanCompanionObject.INSTANCE instanceof String) {
                        d16 = Boolean.valueOf(bVar.e(i3));
                    } else if (IntCompanionObject.INSTANCE instanceof String) {
                        d16 = Integer.valueOf(bVar.i(i3));
                    } else if (LongCompanionObject.INSTANCE instanceof String) {
                        d16 = Long.valueOf(bVar.m(i3));
                    } else if (StringCompanionObject.INSTANCE instanceof String) {
                        d16 = bVar.o(i3);
                    } else if (DoubleCompanionObject.INSTANCE instanceof String) {
                        d16 = Double.valueOf(bVar.g(i3));
                    } else {
                        d16 = bVar.d(i3);
                    }
                    if (d16 != null) {
                        arrayList.add((String) d16);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                    }
                }
            }
        }
        dataList.addAll(arrayList);
    }

    public final void syncStorage() {
        String str;
        b bVar;
        com.tencent.kuikly.core.reactive.collection.c<String> dataList = getDataList();
        if (this.userSource != 5) {
            str = "search_histories";
        } else {
            str = "search_histories_q_zone";
        }
        try {
            bVar = new b();
            Iterator<String> it = dataList.iterator();
            while (it.hasNext()) {
                bVar.t(it.next());
            }
        } catch (JSONException e16) {
            Utils.INSTANCE.logToNative("QSearchStorageUtil #saveHistories:" + e16);
            bVar = null;
        }
        if (bVar != null) {
            Utils utils = Utils.INSTANCE;
            utils.cacheModule("").setItem(str, bVar.toString());
            utils.cacheModule("").setItem("search_histories", bVar.toString());
        }
    }
}
