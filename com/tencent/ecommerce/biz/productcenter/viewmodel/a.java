package com.tencent.ecommerce.biz.productcenter.viewmodel;

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
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\t\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR$\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u000fj\b\u0012\u0004\u0012\u00020\u0006`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R#\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u001a0\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/ecommerce/biz/productcenter/viewmodel/a;", "Landroidx/lifecycle/ViewModel;", "", "isEmpty", "", "Q1", "", "searchQuery", "L1", "M1", "P1", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_inputTextEmpty", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/ArrayList;", "_searchHistoryItemList", "Landroidx/lifecycle/LiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "N1", "()Landroidx/lifecycle/LiveData;", "inputTextEmptyLiveData", "", "D", "O1", "()Landroidx/lifecycle/MutableLiveData;", "searchHistoryItemListLiveData", "<init>", "()V", "E", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final LiveData<Boolean> inputTextEmptyLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<List<String>> searchHistoryItemListLiveData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Boolean> _inputTextEmpty;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<String> _searchHistoryItemList;

    public a() {
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>(Boolean.TRUE);
        this._inputTextEmpty = mutableLiveData;
        ArrayList<String> arrayList = new ArrayList<>();
        this._searchHistoryItemList = arrayList;
        this.inputTextEmptyLiveData = mutableLiveData;
        this.searchHistoryItemListLiveData = new MutableLiveData<>(arrayList);
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
        if (this._searchHistoryItemList.size() > 8) {
            this._searchHistoryItemList.remove(8);
        }
        this.searchHistoryItemListLiveData.postValue(this._searchHistoryItemList);
        ECLocalConfig.f100650f.setString("ec_history_search_item_list_sp_key", oVar.b(this._searchHistoryItemList), Boolean.TRUE);
    }

    public final void M1() {
        this._searchHistoryItemList.clear();
        this.searchHistoryItemListLiveData.postValue(this._searchHistoryItemList);
        ECLocalConfig.f100650f.setString("ec_history_search_item_list_sp_key", "", Boolean.TRUE);
    }

    public final LiveData<Boolean> N1() {
        return this.inputTextEmptyLiveData;
    }

    public final MutableLiveData<List<String>> O1() {
        return this.searchHistoryItemListLiveData;
    }

    public final void P1() {
        String string = ECLocalConfig.f100650f.getString("ec_history_search_item_list_sp_key", "", Boolean.TRUE);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        List<String> a16 = o.f104877a.a(string);
        this._searchHistoryItemList.clear();
        this._searchHistoryItemList.addAll(a16);
        this.searchHistoryItemListLiveData.setValue(this._searchHistoryItemList);
    }

    public final void Q1(boolean isEmpty) {
        this._inputTextEmpty.setValue(Boolean.valueOf(isEmpty));
    }
}
