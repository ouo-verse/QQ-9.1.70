package com.tencent.ecommerce.biz.orders.sellerorders.container;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.tencent.ecommerce.repo.ServiceLocator;
import com.tencent.ecommerce.repo.sampleorder.d;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002R.\u0010\n\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0006 \u0007*\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050\u00050\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR#\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sellerorders/container/ECSellerOrderContainerViewModel;", "Landroidx/lifecycle/ViewModel;", "", "O1", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/tencent/ecommerce/biz/orders/sellerorders/container/ECSellerOrderTab;", "kotlin.jvm.PlatformType", "i", "Landroidx/lifecycle/MutableLiveData;", "_orderTabState", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "N1", "()Landroidx/lifecycle/LiveData;", "orderTabState", "Lcom/tencent/ecommerce/repo/sampleorder/d;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/ecommerce/repo/sampleorder/d;", "operateRepository", "<init>", "()V", "D", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECSellerOrderContainerViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final d operateRepository;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<List<ECSellerOrderTab>> _orderTabState;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final LiveData<List<ECSellerOrderTab>> orderTabState;

    public ECSellerOrderContainerViewModel() {
        List listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(ECSellerOrderTab.SAAS);
        MutableLiveData<List<ECSellerOrderTab>> mutableLiveData = new MutableLiveData<>(listOf);
        this._orderTabState = mutableLiveData;
        this.orderTabState = mutableLiveData;
        this.operateRepository = ServiceLocator.f104891i.d();
    }

    public final LiveData<List<ECSellerOrderTab>> N1() {
        return this.orderTabState;
    }

    public final void O1() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECSellerOrderContainerViewModel$refreshTabState$1(this, null), 3, null);
    }
}
