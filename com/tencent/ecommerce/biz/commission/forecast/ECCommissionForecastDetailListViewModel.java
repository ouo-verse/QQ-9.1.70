package com.tencent.ecommerce.biz.commission.forecast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.repo.ServiceLocator;
import com.tencent.ecommerce.repo.proto.ecom.estimate_commission_svr.ECEstimateCommissionSvr$EstimateCommission;
import com.tencent.ecommerce.repo.proto.ecom.estimate_commission_svr.ECEstimateCommissionSvr$GetRsp;
import com.tencent.ecommerce.repo.proto.ecom.estimate_commission_svr.ECEstimateCommissionSvr$GetSummaryRsp;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b0\u00101J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J\u0013\u0010\t\u001a\u00020\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u001b\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001e0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001cR \u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001cR\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000b0$8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001d\u0010,\u001a\b\u0012\u0004\u0012\u00020\u001e0$8\u0006\u00a2\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b+\u0010(R#\u0010/\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030!0$8\u0006\u00a2\u0006\f\n\u0004\b-\u0010&\u001a\u0004\b.\u0010(\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00062"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/forecast/ECCommissionForecastDetailListViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/ecommerce/repo/proto/ecom/estimate_commission_svr/ECEstimateCommissionSvr$EstimateCommission;", "Lcom/tencent/ecommerce/biz/commission/forecast/e;", "T1", "", "refresh", FeedManager.LOAD_MORE, "Lcom/tencent/ecommerce/biz/commission/forecast/k;", "O1", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "S1", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/ecommerce/biz/commission/forecast/IECCommissionForecastRepo;", "i", "Lcom/tencent/ecommerce/biz/commission/forecast/IECCommissionForecastRepo;", "repo", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "[B", "cookie", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/ecommerce/biz/commission/forecast/k;", "summary", "Landroidx/lifecycle/MutableLiveData;", "D", "Landroidx/lifecycle/MutableLiveData;", "_hasNext", "Lcom/tencent/ecommerce/biz/commission/forecast/LoadingStatus;", "E", "_loadingStatus", "", UserInfo.SEX_FEMALE, "_dataList", "Landroidx/lifecycle/LiveData;", "G", "Landroidx/lifecycle/LiveData;", "Q1", "()Landroidx/lifecycle/LiveData;", "hasNext", "H", "R1", "loadingStatus", "I", "P1", "dataList", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECCommissionForecastDetailListViewModel extends ViewModel {

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> _hasNext;

    /* renamed from: E, reason: from kotlin metadata */
    private final MutableLiveData<LoadingStatus> _loadingStatus;

    /* renamed from: F, reason: from kotlin metadata */
    private final MutableLiveData<List<e>> _dataList;

    /* renamed from: G, reason: from kotlin metadata */
    private final LiveData<Boolean> hasNext;

    /* renamed from: H, reason: from kotlin metadata */
    private final LiveData<LoadingStatus> loadingStatus;

    /* renamed from: I, reason: from kotlin metadata */
    private final LiveData<List<e>> dataList;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private byte[] cookie;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final IECCommissionForecastRepo repo = ServiceLocator.f104891i.f();

    /* renamed from: C, reason: from kotlin metadata */
    private CommissionSummaryInfo summary = new CommissionSummaryInfo(0, 0);

    public ECCommissionForecastDetailListViewModel() {
        List emptyList;
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>(Boolean.FALSE);
        this._hasNext = mutableLiveData;
        MutableLiveData<LoadingStatus> mutableLiveData2 = new MutableLiveData<>();
        this._loadingStatus = mutableLiveData2;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        MutableLiveData<List<e>> mutableLiveData3 = new MutableLiveData<>(emptyList);
        this._dataList = mutableLiveData3;
        this.hasNext = mutableLiveData;
        this.loadingStatus = mutableLiveData2;
        this.dataList = mutableLiveData3;
    }

    private final e T1(ECEstimateCommissionSvr$EstimateCommission eCEstimateCommissionSvr$EstimateCommission) {
        return new CommissionForecastInfo(eCEstimateCommissionSvr$EstimateCommission.order_info.order_id.get(), eCEstimateCommissionSvr$EstimateCommission.product_info.product_title.get(), eCEstimateCommissionSvr$EstimateCommission.commission_info.commission.get(), eCEstimateCommissionSvr$EstimateCommission.order_info.create_time.get(), eCEstimateCommissionSvr$EstimateCommission.order_info.order_price.get());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object O1(Continuation<? super CommissionSummaryInfo> continuation) {
        ECCommissionForecastDetailListViewModel$fetchSummary$1 eCCommissionForecastDetailListViewModel$fetchSummary$1;
        Object coroutine_suspended;
        int i3;
        ECNetworkResponse eCNetworkResponse;
        if (continuation instanceof ECCommissionForecastDetailListViewModel$fetchSummary$1) {
            eCCommissionForecastDetailListViewModel$fetchSummary$1 = (ECCommissionForecastDetailListViewModel$fetchSummary$1) continuation;
            int i16 = eCCommissionForecastDetailListViewModel$fetchSummary$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCCommissionForecastDetailListViewModel$fetchSummary$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCCommissionForecastDetailListViewModel$fetchSummary$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCCommissionForecastDetailListViewModel$fetchSummary$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IECCommissionForecastRepo iECCommissionForecastRepo = this.repo;
                    eCCommissionForecastDetailListViewModel$fetchSummary$1.label = 1;
                    obj = iECCommissionForecastRepo.fetchSummary(eCCommissionForecastDetailListViewModel$fetchSummary$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                ECEstimateCommissionSvr$GetSummaryRsp eCEstimateCommissionSvr$GetSummaryRsp = (ECEstimateCommissionSvr$GetSummaryRsp) eCNetworkResponse.b();
                if (eCNetworkResponse.getCode() != 0 && eCEstimateCommissionSvr$GetSummaryRsp != null) {
                    return new CommissionSummaryInfo(eCEstimateCommissionSvr$GetSummaryRsp.commission_sum.get(), eCEstimateCommissionSvr$GetSummaryRsp.order_count.get());
                }
                return new CommissionSummaryInfo(0L, 0L);
            }
        }
        eCCommissionForecastDetailListViewModel$fetchSummary$1 = new ECCommissionForecastDetailListViewModel$fetchSummary$1(this, continuation);
        Object obj2 = eCCommissionForecastDetailListViewModel$fetchSummary$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCCommissionForecastDetailListViewModel$fetchSummary$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        ECEstimateCommissionSvr$GetSummaryRsp eCEstimateCommissionSvr$GetSummaryRsp2 = (ECEstimateCommissionSvr$GetSummaryRsp) eCNetworkResponse.b();
        if (eCNetworkResponse.getCode() != 0) {
        }
        return new CommissionSummaryInfo(0L, 0L);
    }

    public final LiveData<List<e>> P1() {
        return this.dataList;
    }

    public final LiveData<Boolean> Q1() {
        return this.hasNext;
    }

    public final LiveData<LoadingStatus> R1() {
        return this.loadingStatus;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object S1(boolean z16, Continuation<? super Unit> continuation) {
        ECCommissionForecastDetailListViewModel$loadMoreInternal$1 eCCommissionForecastDetailListViewModel$loadMoreInternal$1;
        Object coroutine_suspended;
        int i3;
        ECCommissionForecastDetailListViewModel eCCommissionForecastDetailListViewModel;
        ECNetworkResponse eCNetworkResponse;
        List<e> mutableListOf;
        int collectionSizeOrDefault;
        List<e> mutableListOf2;
        List<e> plus;
        if (continuation instanceof ECCommissionForecastDetailListViewModel$loadMoreInternal$1) {
            eCCommissionForecastDetailListViewModel$loadMoreInternal$1 = (ECCommissionForecastDetailListViewModel$loadMoreInternal$1) continuation;
            int i16 = eCCommissionForecastDetailListViewModel$loadMoreInternal$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCCommissionForecastDetailListViewModel$loadMoreInternal$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCCommissionForecastDetailListViewModel$loadMoreInternal$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCCommissionForecastDetailListViewModel$loadMoreInternal$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IECCommissionForecastRepo iECCommissionForecastRepo = this.repo;
                    byte[] bArr = this.cookie;
                    eCCommissionForecastDetailListViewModel$loadMoreInternal$1.L$0 = this;
                    eCCommissionForecastDetailListViewModel$loadMoreInternal$1.Z$0 = z16;
                    eCCommissionForecastDetailListViewModel$loadMoreInternal$1.label = 1;
                    obj = iECCommissionForecastRepo.loadList(bArr, eCCommissionForecastDetailListViewModel$loadMoreInternal$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    eCCommissionForecastDetailListViewModel = this;
                } else if (i3 == 1) {
                    z16 = eCCommissionForecastDetailListViewModel$loadMoreInternal$1.Z$0;
                    eCCommissionForecastDetailListViewModel = (ECCommissionForecastDetailListViewModel) eCCommissionForecastDetailListViewModel$loadMoreInternal$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                eCNetworkResponse = (ECNetworkResponse) obj;
                ECEstimateCommissionSvr$GetRsp eCEstimateCommissionSvr$GetRsp = (ECEstimateCommissionSvr$GetRsp) eCNetworkResponse.b();
                if (eCNetworkResponse.getCode() != 0 && eCEstimateCommissionSvr$GetRsp != null) {
                    eCCommissionForecastDetailListViewModel.cookie = eCEstimateCommissionSvr$GetRsp.cookie.get().toByteArray();
                    eCCommissionForecastDetailListViewModel._hasNext.setValue(Boxing.boxBoolean(!eCEstimateCommissionSvr$GetRsp.is_end.get()));
                    List<ECEstimateCommissionSvr$EstimateCommission> list = eCEstimateCommissionSvr$GetRsp.stimate_commissions.get();
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        arrayList.add(eCCommissionForecastDetailListViewModel.T1((ECEstimateCommissionSvr$EstimateCommission) it.next()));
                    }
                    if (!z16) {
                        mutableListOf2 = CollectionsKt__CollectionsKt.mutableListOf(eCCommissionForecastDetailListViewModel.summary);
                        if (arrayList.isEmpty()) {
                            mutableListOf2.add(f.f101483b);
                        } else {
                            mutableListOf2.addAll(arrayList);
                        }
                        eCCommissionForecastDetailListViewModel._dataList.setValue(mutableListOf2);
                        eCCommissionForecastDetailListViewModel._loadingStatus.setValue(LoadingStatus.REFRESHED);
                    } else {
                        List<e> value = eCCommissionForecastDetailListViewModel._dataList.getValue();
                        if (value == null) {
                            value = CollectionsKt__CollectionsKt.emptyList();
                        }
                        MutableLiveData<List<e>> mutableLiveData = eCCommissionForecastDetailListViewModel._dataList;
                        plus = CollectionsKt___CollectionsKt.plus((Collection) value, (Iterable) arrayList);
                        mutableLiveData.setValue(plus);
                        eCCommissionForecastDetailListViewModel._loadingStatus.setValue(LoadingStatus.LOADED);
                    }
                    return Unit.INSTANCE;
                }
                if (z16) {
                    mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(eCCommissionForecastDetailListViewModel.summary);
                    mutableListOf.add(h.f101484b);
                    eCCommissionForecastDetailListViewModel._dataList.setValue(mutableListOf);
                    eCCommissionForecastDetailListViewModel._loadingStatus.setValue(LoadingStatus.REFRESH_FAILED);
                } else {
                    eCCommissionForecastDetailListViewModel._loadingStatus.setValue(LoadingStatus.LOAD_FAILED);
                }
                return Unit.INSTANCE;
            }
        }
        eCCommissionForecastDetailListViewModel$loadMoreInternal$1 = new ECCommissionForecastDetailListViewModel$loadMoreInternal$1(this, continuation);
        Object obj2 = eCCommissionForecastDetailListViewModel$loadMoreInternal$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCCommissionForecastDetailListViewModel$loadMoreInternal$1.label;
        if (i3 != 0) {
        }
        eCNetworkResponse = (ECNetworkResponse) obj2;
        ECEstimateCommissionSvr$GetRsp eCEstimateCommissionSvr$GetRsp2 = (ECEstimateCommissionSvr$GetRsp) eCNetworkResponse.b();
        if (eCNetworkResponse.getCode() != 0) {
        }
        if (z16) {
        }
        return Unit.INSTANCE;
    }

    public final void loadMore() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECCommissionForecastDetailListViewModel$loadMore$1(this, null), 3, null);
    }

    public final void refresh() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECCommissionForecastDetailListViewModel$refresh$1(this, null), 3, null);
    }
}
