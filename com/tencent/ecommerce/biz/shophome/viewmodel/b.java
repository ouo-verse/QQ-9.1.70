package com.tencent.ecommerce.biz.shophome.viewmodel;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tencent.ecommerce.base.config.service.ECLocalConfig;
import com.tencent.ecommerce.biz.util.o;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0004R$\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u00020\tj\b\u0012\u0004\u0012\u00020\u0002`\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR \u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R#\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000f0\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/viewmodel/b;", "Landroidx/lifecycle/ViewModel;", "", "searchQuery", "", "L1", "M1", "P1", "O1", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "i", "Ljava/util/ArrayList;", "_searchHistoryItemList", "Landroidx/lifecycle/MutableLiveData;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_searchHistoryItemListLiveData", "Landroidx/lifecycle/LiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "N1", "()Landroidx/lifecycle/LiveData;", "searchHistoryItemListLiveData", "<init>", "()V", "D", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class b extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final LiveData<List<String>> searchHistoryItemListLiveData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<String> _searchHistoryItemList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<List<String>> _searchHistoryItemListLiveData;

    public b() {
        ArrayList<String> arrayList = new ArrayList<>();
        this._searchHistoryItemList = arrayList;
        MutableLiveData<List<String>> mutableLiveData = new MutableLiveData<>(arrayList);
        this._searchHistoryItemListLiveData = mutableLiveData;
        this.searchHistoryItemListLiveData = mutableLiveData;
    }

    public final void L1(String searchQuery) {
        if (TextUtils.isEmpty(searchQuery)) {
            return;
        }
        o oVar = o.f104877a;
        int c16 = oVar.c(searchQuery, this._searchHistoryItemList);
        if (c16 != -1) {
            this._searchHistoryItemList.remove(c16);
        }
        this._searchHistoryItemList.add(0, searchQuery);
        if (this._searchHistoryItemList.size() > 10) {
            this._searchHistoryItemList.remove(10);
        }
        this._searchHistoryItemListLiveData.postValue(this._searchHistoryItemList);
        ECLocalConfig.f100650f.setString("ec_shop_home_history_search_item_list_sp_key", oVar.b(this._searchHistoryItemList), Boolean.TRUE);
    }

    public final void M1() {
        this._searchHistoryItemList.clear();
        this._searchHistoryItemListLiveData.postValue(this._searchHistoryItemList);
        ECLocalConfig.f100650f.setString("ec_shop_home_history_search_item_list_sp_key", "", Boolean.TRUE);
    }

    public final LiveData<List<String>> N1() {
        return this.searchHistoryItemListLiveData;
    }

    public final void O1() {
        String string = ECLocalConfig.f100650f.getString("ec_shop_home_history_search_item_list_sp_key", "", Boolean.TRUE);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        List<String> a16 = o.f104877a.a(string);
        this._searchHistoryItemList.clear();
        this._searchHistoryItemList.addAll(a16);
        this._searchHistoryItemListLiveData.postValue(this._searchHistoryItemList);
    }

    public final void P1(String searchQuery) {
        if (TextUtils.isEmpty(searchQuery)) {
            return;
        }
        o oVar = o.f104877a;
        int c16 = oVar.c(searchQuery, this._searchHistoryItemList);
        if (c16 != -1) {
            this._searchHistoryItemList.remove(c16);
        }
        this._searchHistoryItemListLiveData.postValue(this._searchHistoryItemList);
        ECLocalConfig.f100650f.setString("ec_shop_home_history_search_item_list_sp_key", oVar.b(this._searchHistoryItemList), Boolean.TRUE);
    }
}
