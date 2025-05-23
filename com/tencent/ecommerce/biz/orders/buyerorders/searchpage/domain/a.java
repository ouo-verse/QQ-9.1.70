package com.tencent.ecommerce.biz.orders.buyerorders.searchpage.domain;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.ecommerce.base.config.service.ECLocalConfig;
import com.tencent.ecommerce.biz.util.o;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0007J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\u0007J\u0016\u0010\u000e\u001a\u00020\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\fH\u0007R\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00100\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/ecommerce/biz/orders/buyerorders/searchpage/domain/a;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/searchpage/domain/ECOrderSearchScene;", "scene", "", "N1", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "M1", "L1", "R1", "P1", "", "histories", "Q1", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/searchpage/domain/c;", "i", "Landroidx/lifecycle/MutableLiveData;", "_searchHistoryData", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "O1", "()Landroidx/lifecycle/LiveData;", "searchHistoryData", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/ecommerce/biz/orders/buyerorders/searchpage/domain/ECOrderSearchScene;", "<init>", "(Lcom/tencent/ecommerce/biz/orders/buyerorders/searchpage/domain/ECOrderSearchScene;)V", "D", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final ECOrderSearchScene scene;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<SearchHistoryData> _searchHistoryData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final LiveData<SearchHistoryData> searchHistoryData;

    public a(ECOrderSearchScene eCOrderSearchScene) {
        this.scene = eCOrderSearchScene;
        MutableLiveData<SearchHistoryData> mutableLiveData = new MutableLiveData<>();
        this._searchHistoryData = mutableLiveData;
        this.searchHistoryData = mutableLiveData;
    }

    private final String N1(ECOrderSearchScene scene) {
        return "sp_key_shop_order_history_search_item_list_" + scene.ordinal();
    }

    public final void L1() {
        List<String> emptyList;
        cg0.a.b("ECShopOrderSearchViewModel", "clearSearchHistoryItem");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        Q1(emptyList);
    }

    public final void M1(String item) {
        List mutableList;
        int lastIndex;
        List<String> list;
        if (TextUtils.isEmpty(item)) {
            return;
        }
        SearchHistoryData value = this._searchHistoryData.getValue();
        if (value != null) {
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) value.a());
            mutableList.remove(item);
            mutableList.add(0, item);
            for (lastIndex = CollectionsKt__CollectionsKt.getLastIndex(mutableList); lastIndex >= 10; lastIndex--) {
                mutableList.remove(lastIndex);
            }
            list = CollectionsKt___CollectionsKt.toList(mutableList);
            Q1(list);
            return;
        }
        cg0.a.a("ECShopOrderSearchViewModel", "enqueueSearchHistoryItem", "call initSearchHistoryItems first!");
    }

    public final LiveData<SearchHistoryData> O1() {
        return this.searchHistoryData;
    }

    public final void P1() {
        List emptyList;
        String string = ECLocalConfig.f100650f.getString(N1(this.scene), "", Boolean.TRUE);
        if (!TextUtils.isEmpty(string)) {
            List<String> a16 = o.f104877a.a(string);
            this._searchHistoryData.postValue(new SearchHistoryData(true, a16));
            cg0.a.b("ECShopOrderSearchViewModel", "initSearchHistoryItems size: " + a16.size());
            return;
        }
        MutableLiveData<SearchHistoryData> mutableLiveData = this._searchHistoryData;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        mutableLiveData.postValue(new SearchHistoryData(true, emptyList));
        cg0.a.b("ECShopOrderSearchViewModel", "initSearchHistoryItems size: 0");
    }

    public final void Q1(List<String> histories) {
        this._searchHistoryData.postValue(new SearchHistoryData(false, histories));
        ECLocalConfig.f100650f.setString(N1(this.scene), o.f104877a.b(histories), Boolean.TRUE);
    }

    public final void R1(String item) {
        List mutableList;
        List<String> list;
        cg0.a.b("ECShopOrderSearchViewModel", "removeSearchHistoryItem item: " + item);
        if (TextUtils.isEmpty(item)) {
            return;
        }
        SearchHistoryData value = this._searchHistoryData.getValue();
        if (value != null) {
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) value.a());
            mutableList.remove(item);
            list = CollectionsKt___CollectionsKt.toList(mutableList);
            Q1(list);
            return;
        }
        cg0.a.a("ECShopOrderSearchViewModel", "enqueueSearchHistoryItem", "call initSearchHistoryItems first!");
    }
}
