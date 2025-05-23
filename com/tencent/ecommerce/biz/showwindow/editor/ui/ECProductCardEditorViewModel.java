package com.tencent.ecommerce.biz.showwindow.editor.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.biz.showwindow.editor.network.ECProductCardEditorRepo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\nJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u000eR\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0013R\u001d\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00158\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u0017\u001a\u0004\b\u001e\u0010\u0019R\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00060\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u0013R\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060\u00158\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u0017\u001a\u0004\b#\u0010\u0019R\u001b\u0010*\u001a\u00020%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/ecommerce/biz/showwindow/editor/ui/ECProductCardEditorViewModel;", "Landroidx/lifecycle/ViewModel;", "Lorg/json/JSONArray;", "U1", "Lorg/json/JSONObject;", "T1", "", "index", "", "Z1", "", "spuId", "X1", "W1", "", "O1", "Landroidx/lifecycle/MutableLiveData;", "", "i", "Landroidx/lifecycle/MutableLiveData;", "_hasNetworkData", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "P1", "()Landroidx/lifecycle/LiveData;", "hasNetworkData", BdhLogUtil.LogTag.Tag_Conn, "_productInfo", "D", "R1", "productInfoLiveData", "E", "_selectedIndex", UserInfo.SEX_FEMALE, "S1", "selectedIndex", "Lcom/tencent/ecommerce/biz/showwindow/editor/network/ECProductCardEditorRepo;", "G", "Lkotlin/Lazy;", "Q1", "()Lcom/tencent/ecommerce/biz/showwindow/editor/network/ECProductCardEditorRepo;", "productCardEditorRepo", "<init>", "()V", "H", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECProductCardEditorViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final MutableLiveData<JSONObject> _productInfo;

    /* renamed from: D, reason: from kotlin metadata */
    private final LiveData<JSONObject> productInfoLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    private MutableLiveData<Integer> _selectedIndex;

    /* renamed from: F, reason: from kotlin metadata */
    private final LiveData<Integer> selectedIndex;

    /* renamed from: G, reason: from kotlin metadata */
    private final Lazy productCardEditorRepo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Boolean> _hasNetworkData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final LiveData<Boolean> hasNetworkData;

    public ECProductCardEditorViewModel() {
        Lazy lazy;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this._hasNetworkData = mutableLiveData;
        this.hasNetworkData = mutableLiveData;
        MutableLiveData<JSONObject> mutableLiveData2 = new MutableLiveData<>();
        this._productInfo = mutableLiveData2;
        this.productInfoLiveData = mutableLiveData2;
        MutableLiveData<Integer> mutableLiveData3 = new MutableLiveData<>();
        this._selectedIndex = mutableLiveData3;
        this.selectedIndex = mutableLiveData3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ECProductCardEditorRepo>() { // from class: com.tencent.ecommerce.biz.showwindow.editor.ui.ECProductCardEditorViewModel$productCardEditorRepo$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ECProductCardEditorRepo invoke() {
                return new ECProductCardEditorRepo();
            }
        });
        this.productCardEditorRepo = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECProductCardEditorRepo Q1() {
        return (ECProductCardEditorRepo) this.productCardEditorRepo.getValue();
    }

    private final JSONObject T1() {
        JSONObject value = this.productInfoLiveData.getValue();
        if (value != null) {
            return a.a(value);
        }
        return null;
    }

    private final JSONArray U1() {
        JSONObject T1 = T1();
        if (T1 != null) {
            return a.b(T1);
        }
        return null;
    }

    public final List<String> O1() {
        ArrayList arrayList = new ArrayList();
        JSONArray U1 = U1();
        if (U1 != null) {
            int length = U1.length();
            for (int i3 = 0; i3 < length; i3++) {
                arrayList.add(U1.get(i3).toString());
            }
        }
        return arrayList;
    }

    public final LiveData<Boolean> P1() {
        return this.hasNetworkData;
    }

    public final LiveData<JSONObject> R1() {
        return this.productInfoLiveData;
    }

    public final LiveData<Integer> S1() {
        return this.selectedIndex;
    }

    public final String W1() {
        String c16;
        JSONObject T1 = T1();
        return (T1 == null || (c16 = a.c(T1)) == null) ? "" : c16;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [org.json.JSONObject, T] */
    public final void X1(String spuId) {
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? jSONObject = new JSONObject();
        jSONObject.put("spu_id", spuId);
        Unit unit = Unit.INSTANCE;
        objectRef.element = jSONObject;
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECProductCardEditorViewModel$requestNetworkProductInfo$1(this, objectRef, null), 3, null);
    }

    public final void Z1(int index) {
        this._selectedIndex.postValue(Integer.valueOf(index));
    }
}
