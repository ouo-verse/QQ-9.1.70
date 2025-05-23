package com.tencent.ecommerce.biz.shophome.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import bj0.ECShopHomeCategoryListRequest;
import bj0.ECShopHomeProductRequest;
import bj0.ECShopHomeRequest;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.ecommerce.base.report.service.k;
import com.tencent.ecommerce.base.report.service.m;
import com.tencent.ecommerce.base.share.api.ECActionItemData;
import com.tencent.ecommerce.biz.shophome.model.ECShopCategoryInfo;
import com.tencent.ecommerce.biz.shophome.model.ECShopTabInfo;
import com.tencent.ecommerce.biz.shophome.repo.ECShareActionInfo;
import com.tencent.ecommerce.biz.shophome.util.e;
import com.tencent.ecommerce.biz.shophome.viewmodel.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0016\u0018\u0000 X2\u00020\u0001:\u0001YB\u0007\u00a2\u0006\u0004\bV\u0010WJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000bJ\u000e\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dJ\u000e\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 J \u0010(\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#2\u0006\u0010&\u001a\u00020%2\b\u0010\u0003\u001a\u0004\u0018\u00010'R\"\u0010-\u001a\u0010\u0012\f\u0012\n **\u0004\u0018\u00010\u00120\u00120)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020#0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010,R$\u00104\u001a\u0012\u0012\u0004\u0012\u00020\b00j\b\u0012\u0004\u0012\u00020\b`18\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R \u00107\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b050)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u0010,R\u001a\u00109\u001a\b\u0012\u0004\u0012\u00020\b0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u0010,R\u001d\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00120:8\u0006\u00a2\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u001d\u0010B\u001a\b\u0012\u0004\u0012\u00020#0:8\u0006\u00a2\u0006\f\n\u0004\b@\u0010<\u001a\u0004\bA\u0010>R#\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b050:8\u0006\u00a2\u0006\f\n\u0004\bC\u0010<\u001a\u0004\bD\u0010>R\u001d\u0010H\u001a\b\u0012\u0004\u0012\u00020\b0:8\u0006\u00a2\u0006\f\n\u0004\bF\u0010<\u001a\u0004\bG\u0010>R\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020I0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010,R\u001d\u0010N\u001a\b\u0012\u0004\u0012\u00020I0:8\u0006\u00a2\u0006\f\n\u0004\bL\u0010<\u001a\u0004\bM\u0010>R\u001a\u0010P\u001a\b\u0012\u0004\u0012\u00020\u000b0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010,R\u001d\u0010S\u001a\b\u0012\u0004\u0012\u00020\u000b0:8\u0006\u00a2\u0006\f\n\u0004\bQ\u0010<\u001a\u0004\bR\u0010>R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010U\u00a8\u0006Z"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/viewmodel/ECShopHomeViewModel;", "Lcom/tencent/ecommerce/biz/shophome/viewmodel/a;", "Lorg/json/JSONObject;", "data", "", "C2", "Lcom/tencent/ecommerce/biz/shophome/viewmodel/a$b;", "R1", "Lcom/tencent/ecommerce/biz/shophome/model/b;", "currentFirstLevelCategory", "Q2", "", "isSuccess", "isSelect", "N2", "Lcom/tencent/ecommerce/base/report/service/k;", "showPageCostTime", "O2", "Lcom/tencent/ecommerce/biz/shophome/model/d;", "currentTabInfo", "S2", "R2", "Lbj0/c;", "shopHomeRequest", "isFirstScreen", "H2", "Lbj0/b;", "shopHomeProductRequest", "I2", "Lbj0/a;", "categoryListRequest", Constants.MMCCID, "Lorg/json/JSONArray;", "categoryJsonArray", "P2", "", "shopId", "", "shareAction", "Lcom/tencent/ecommerce/base/share/api/b;", "L2", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "k0", "Landroidx/lifecycle/MutableLiveData;", "_currentTabInfo", "l0", "_shopInfo", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "m0", "Ljava/util/ArrayList;", "_categoryInfoList", "", "n0", "_categoryInfoListLiveData", "o0", "_currentFirstLevelCategoryInfo", "Landroidx/lifecycle/LiveData;", "p0", "Landroidx/lifecycle/LiveData;", "F2", "()Landroidx/lifecycle/LiveData;", "currentTabInfoLiveData", "q0", "J2", "shopInfoLiveData", "r0", Constants.BASE_IN_PLUGIN_VERSION, "categoryInfoListLiveData", "s0", "E2", "currentFirstLevelCategoryInfoLiveData", "Lcom/tencent/ecommerce/biz/shophome/repo/a;", "t0", "_shopShareInfo", "u0", "K2", "shopShareInfo", "v0", "_showShareBtn", "w0", "M2", "showShareBtn", "x0", "Lcom/tencent/ecommerce/base/report/service/k;", "<init>", "()V", "y0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public class ECShopHomeViewModel extends a {

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<ECShopTabInfo> _currentTabInfo;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<String> _shopInfo;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<ECShopCategoryInfo> _categoryInfoList;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<List<ECShopCategoryInfo>> _categoryInfoListLiveData;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<ECShopCategoryInfo> _currentFirstLevelCategoryInfo;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private final LiveData<ECShopTabInfo> currentTabInfoLiveData;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private final LiveData<String> shopInfoLiveData;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private final LiveData<List<ECShopCategoryInfo>> categoryInfoListLiveData;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private final LiveData<ECShopCategoryInfo> currentFirstLevelCategoryInfoLiveData;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<ECShareActionInfo> _shopShareInfo;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    private final LiveData<ECShareActionInfo> shopShareInfo;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Boolean> _showShareBtn;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    private final LiveData<Boolean> showShareBtn;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    private k showPageCostTime;

    public ECShopHomeViewModel() {
        MutableLiveData<ECShopTabInfo> mutableLiveData = new MutableLiveData<>(new ECShopTabInfo("1", "\u5546\u54c1"));
        this._currentTabInfo = mutableLiveData;
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>();
        this._shopInfo = mutableLiveData2;
        ArrayList<ECShopCategoryInfo> arrayList = new ArrayList<>();
        this._categoryInfoList = arrayList;
        MutableLiveData<List<ECShopCategoryInfo>> mutableLiveData3 = new MutableLiveData<>(arrayList);
        this._categoryInfoListLiveData = mutableLiveData3;
        MutableLiveData<ECShopCategoryInfo> mutableLiveData4 = new MutableLiveData<>();
        this._currentFirstLevelCategoryInfo = mutableLiveData4;
        this.currentTabInfoLiveData = mutableLiveData;
        this.shopInfoLiveData = mutableLiveData2;
        this.categoryInfoListLiveData = mutableLiveData3;
        this.currentFirstLevelCategoryInfoLiveData = mutableLiveData4;
        MutableLiveData<ECShareActionInfo> mutableLiveData5 = new MutableLiveData<>();
        this._shopShareInfo = mutableLiveData5;
        this.shopShareInfo = mutableLiveData5;
        MutableLiveData<Boolean> mutableLiveData6 = new MutableLiveData<>();
        this._showShareBtn = mutableLiveData6;
        this.showShareBtn = mutableLiveData6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C2(JSONObject data) {
        f2().postValue(R1(data));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N2(boolean isSuccess, boolean isSelect) {
        Map<Object, ? extends Object> d16 = new m().b(isSelect).c(isSuccess ? 2 : 3).d();
        k kVar = this.showPageCostTime;
        if (kVar != null) {
            kVar.b(d16);
        }
    }

    private final void Q2(ECShopCategoryInfo currentFirstLevelCategory) {
        Iterator<ECShopCategoryInfo> it = this._categoryInfoList.iterator();
        while (it.hasNext()) {
            ECShopCategoryInfo next = it.next();
            next.c(Intrinsics.areEqual(next, currentFirstLevelCategory));
        }
    }

    private final a.b R1(JSONObject data) {
        if (data.length() == 0) {
            return new a.b.EmptyState(null, 1, null);
        }
        int optInt = data.optInt("code", 0);
        if (optInt == 0) {
            JSONArray optJSONArray = data.optJSONArray("categories");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            if (optJSONArray.length() > 0) {
                return a.b.d.f104429a;
            }
            return new a.b.EmptyState(null, 1, null);
        }
        return new a.b.ErrorState(optInt, null, 2, null);
    }

    public final LiveData<List<ECShopCategoryInfo>> D2() {
        return this.categoryInfoListLiveData;
    }

    public final LiveData<ECShopCategoryInfo> E2() {
        return this.currentFirstLevelCategoryInfoLiveData;
    }

    public final LiveData<ECShopTabInfo> F2() {
        return this.currentTabInfoLiveData;
    }

    public final void I2(ECShopHomeProductRequest shopHomeProductRequest) {
        L1(shopHomeProductRequest.loadMore);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECShopHomeViewModel$getShopHomeProductListData$1(this, shopHomeProductRequest, null), 3, null);
    }

    public final LiveData<String> J2() {
        return this.shopInfoLiveData;
    }

    public final LiveData<ECShareActionInfo> K2() {
        return this.shopShareInfo;
    }

    public final void L2(String shopId, int shareAction, ECActionItemData data) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECShopHomeViewModel$getShopShareInfo$1(this, shopId, shareAction, data, null), 3, null);
    }

    public final LiveData<Boolean> M2() {
        return this.showShareBtn;
    }

    public final void O2(k showPageCostTime) {
        this.showPageCostTime = showPageCostTime;
    }

    public final void R2(ECShopCategoryInfo currentFirstLevelCategory) {
        this._currentFirstLevelCategoryInfo.postValue(currentFirstLevelCategory);
        Q2(currentFirstLevelCategory);
    }

    public final void S2(ECShopTabInfo currentTabInfo) {
        this._currentTabInfo.postValue(currentTabInfo);
    }

    public final void G2(ECShopHomeCategoryListRequest categoryListRequest) {
        L1(false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECShopHomeViewModel$getShopHomeCategory$1(this, categoryListRequest, null), 3, null);
    }

    public final void H2(ECShopHomeRequest shopHomeRequest, boolean isFirstScreen) {
        L1(false);
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECShopHomeViewModel$getShopHomePageData$1(this, shopHomeRequest, isFirstScreen, null), 3, null);
    }

    public final void P2(JSONArray categoryJsonArray) {
        ArrayList arrayList = new ArrayList();
        int length = categoryJsonArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = categoryJsonArray.optJSONObject(i3);
            arrayList.add(new ECShopCategoryInfo(optJSONObject.optString("name"), optJSONObject.optJSONObject("category_info"), optJSONObject.optInt(PictureConst.KEY_CATEGORY_TYPE), e.f104394a.a(optJSONObject.optJSONArray("sub_category")), optJSONObject.optString("url"), false, 32, null));
        }
        if (!arrayList.isEmpty()) {
            this._categoryInfoList.clear();
            this._categoryInfoList.addAll(arrayList);
            this._categoryInfoListLiveData.setValue(this._categoryInfoList);
            R2(this._categoryInfoList.get(0));
        }
    }
}
