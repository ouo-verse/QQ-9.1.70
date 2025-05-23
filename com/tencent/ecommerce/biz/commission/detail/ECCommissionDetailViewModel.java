package com.tencent.ecommerce.biz.commission.detail;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.biz.common.ui.ECCommonFilterDialog;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import sj0.ECFilterOptionItem;
import sj0.ECFilterOptionModel;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b-\u0010.J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J.\u0010\r\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\tR \u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R#\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00030\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001aR,\u0010#\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\t0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0010R/\u0010&\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00070\t0\u00128\u0006\u00a2\u0006\f\n\u0004\b$\u0010\u0014\u001a\u0004\b%\u0010\u0016R/\u0010*\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0'0\u00070\u00128\u0006\u00a2\u0006\f\n\u0004\b(\u0010\u0014\u001a\u0004\b)\u0010\u0016R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078F\u00a2\u0006\u0006\u001a\u0004\b+\u0010\u001e\u00a8\u0006/"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/detail/ECCommissionDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "Lsj0/c;", "Lcom/tencent/ecommerce/biz/common/ui/ECCommonFilterDialog$a;", "P1", "", "W1", "", "newFilterData", "", "", "Lcom/tencent/ecommerce/biz/common/ui/ECCommonFilterDialog$b;", "newSelectedOption", "X1", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_filterOption", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "S1", "()Landroidx/lifecycle/LiveData;", "filterOption", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/List;", "_defaultFilterData", "D", "Q1", "()Ljava/util/List;", "defaultFilterData", "E", "_filterData", UserInfo.SEX_FEMALE, "_selectedOption", "G", "U1", "selectedOption", "Lkotlin/Pair;", "H", "T1", "filterOptionList", "R1", "filterData", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECCommissionDetailViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final List<ECCommonFilterDialog.FilterItem> _defaultFilterData;

    /* renamed from: D, reason: from kotlin metadata */
    private final List<ECCommonFilterDialog.FilterItem> defaultFilterData;

    /* renamed from: E, reason: from kotlin metadata */
    private List<ECCommonFilterDialog.FilterItem> _filterData;

    /* renamed from: F, reason: from kotlin metadata */
    private final MutableLiveData<Map<String, List<ECCommonFilterDialog.FilterOptionItem>>> _selectedOption;

    /* renamed from: G, reason: from kotlin metadata */
    private final LiveData<Map<String, List<ECCommonFilterDialog.FilterOptionItem>>> selectedOption;

    /* renamed from: H, reason: from kotlin metadata */
    private final LiveData<List<Pair<String, String>>> filterOptionList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<List<ECFilterOptionModel>> _filterOption;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final LiveData<List<ECFilterOptionModel>> filterOption;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0007\u001a.\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0006 \u0004*\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0006\u0018\u00010\u00020\u000222\u0010\u0005\u001a.\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002 \u0004*\u0016\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"", "", "", "Lcom/tencent/ecommerce/biz/common/ui/ECCommonFilterDialog$b;", "kotlin.jvm.PlatformType", "it", "Lkotlin/Pair;", "a", "(Ljava/util/Map;)Ljava/util/List;"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class a<I, O> implements Function<Map<String, ? extends List<? extends ECCommonFilterDialog.FilterOptionItem>>, List<? extends Pair<? extends String, ? extends String>>> {

        /* renamed from: a, reason: collision with root package name */
        public static final a f101446a = new a();

        a() {
        }

        @Override // androidx.arch.core.util.Function
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<Pair<String, String>> apply(Map<String, ? extends List<ECCommonFilterDialog.FilterOptionItem>> map) {
            int collectionSizeOrDefault;
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<String, ? extends List<ECCommonFilterDialog.FilterOptionItem>> entry : map.entrySet()) {
                List<ECCommonFilterDialog.FilterOptionItem> value = entry.getValue();
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(value, 10);
                ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = value.iterator();
                while (it.hasNext()) {
                    arrayList2.add(new Pair(entry.getKey(), ((ECCommonFilterDialog.FilterOptionItem) it.next()).value));
                }
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, arrayList2);
            }
            return arrayList;
        }
    }

    public ECCommissionDetailViewModel() {
        MutableLiveData<List<ECFilterOptionModel>> mutableLiveData = new MutableLiveData<>();
        this._filterOption = mutableLiveData;
        this.filterOption = mutableLiveData;
        ArrayList arrayList = new ArrayList();
        this._defaultFilterData = arrayList;
        this.defaultFilterData = arrayList;
        this._filterData = new ArrayList();
        MutableLiveData<Map<String, List<ECCommonFilterDialog.FilterOptionItem>>> mutableLiveData2 = new MutableLiveData<>();
        this._selectedOption = mutableLiveData2;
        this.selectedOption = mutableLiveData2;
        this.filterOptionList = Transformations.map(mutableLiveData2, a.f101446a);
    }

    public final List<ECCommonFilterDialog.FilterItem> Q1() {
        return this.defaultFilterData;
    }

    public final List<ECCommonFilterDialog.FilterItem> R1() {
        return this._filterData;
    }

    public final LiveData<List<ECFilterOptionModel>> S1() {
        return this.filterOption;
    }

    public final LiveData<List<Pair<String, String>>> T1() {
        return this.filterOptionList;
    }

    public final LiveData<Map<String, List<ECCommonFilterDialog.FilterOptionItem>>> U1() {
        return this.selectedOption;
    }

    public final void W1() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECCommissionDetailViewModel$requestFilterOption$1(this, null), 3, null);
    }

    public final void X1(List<ECCommonFilterDialog.FilterItem> newFilterData, Map<String, ? extends List<ECCommonFilterDialog.FilterOptionItem>> newSelectedOption) {
        List<ECCommonFilterDialog.FilterItem> mutableList;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) newFilterData);
        this._filterData = mutableList;
        this._selectedOption.setValue(newSelectedOption);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECCommonFilterDialog.FilterItem P1(ECFilterOptionModel eCFilterOptionModel) {
        int collectionSizeOrDefault;
        List mutableList;
        List<ECFilterOptionItem> a16 = eCFilterOptionModel.a();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(a16, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        int i3 = 0;
        for (Object obj : a16) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ECFilterOptionItem eCFilterOptionItem = (ECFilterOptionItem) obj;
            arrayList.add(new ECCommonFilterDialog.FilterOptionItem(i3 == 0, eCFilterOptionItem.text, eCFilterOptionItem.value, eCFilterOptionItem.getType(), null, null, 48, null));
            i3 = i16;
        }
        String str = eCFilterOptionModel.title;
        String str2 = eCFilterOptionModel.key;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
        return new ECCommonFilterDialog.FilterItem(str, str2, mutableList);
    }
}
