package com.tencent.ecommerce.biz.customerservice;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel;
import com.tencent.ecommerce.repo.ServiceLocator;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b)\u0010*J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001d\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001d\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00190\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R#\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040#8\u0006\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/ecommerce/biz/customerservice/ECCustomerServiceViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/ecommerce/biz/customerservice/CustomerServiceScene;", "scene", "", "shopId", "spuId", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "", "R1", "Lcom/tencent/ecommerce/biz/customerservice/IECCustomerServiceRepo;", "i", "Lcom/tencent/ecommerce/biz/customerservice/IECCustomerServiceRepo;", "repo", "Landroidx/lifecycle/MutableLiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/MutableLiveData;", "_urlData", "Landroidx/lifecycle/LiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "Q1", "()Landroidx/lifecycle/LiveData;", "urlData", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/tencent/ecommerce/biz/orders/buyerorders/submit/ECOrderSubmitViewModel$g;", "D", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_pageState", "Lkotlinx/coroutines/flow/StateFlow;", "E", "Lkotlinx/coroutines/flow/StateFlow;", "P1", "()Lkotlinx/coroutines/flow/StateFlow;", "pageState", "", UserInfo.SEX_FEMALE, "Ljava/util/Map;", "O1", "()Ljava/util/Map;", "interceptInfos", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECCustomerServiceViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final LiveData<String> urlData;

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableStateFlow<ECOrderSubmitViewModel.g> _pageState;

    /* renamed from: E, reason: from kotlin metadata */
    private final StateFlow<ECOrderSubmitViewModel.g> pageState;

    /* renamed from: F, reason: from kotlin metadata */
    private final Map<String, String> interceptInfos;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final IECCustomerServiceRepo repo = ServiceLocator.f104891i.g();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<String> _urlData;

    public ECCustomerServiceViewModel() {
        MutableLiveData<String> mutableLiveData = new MutableLiveData<>();
        this._urlData = mutableLiveData;
        this.urlData = mutableLiveData;
        MutableStateFlow<ECOrderSubmitViewModel.g> MutableStateFlow = StateFlowKt.MutableStateFlow(ECOrderSubmitViewModel.g.c.f103527a);
        this._pageState = MutableStateFlow;
        this.pageState = MutableStateFlow;
        this.interceptInfos = new LinkedHashMap();
    }

    public final Map<String, String> O1() {
        return this.interceptInfos;
    }

    public final StateFlow<ECOrderSubmitViewModel.g> P1() {
        return this.pageState;
    }

    public final LiveData<String> Q1() {
        return this.urlData;
    }

    public final void R1(CustomerServiceScene scene, String shopId, String spuId, String orderId) {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECCustomerServiceViewModel$startCustomerServicePage$1(this, scene, shopId, spuId, orderId, null), 3, null);
    }
}
