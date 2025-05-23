package com.tencent.ecommerce.biz.commission.overview;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.config.api.IECLocalConfig;
import com.tencent.ecommerce.base.config.service.ECLocalConfig;
import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback;
import com.tencent.ecommerce.base.network.service.a;
import com.tencent.ecommerce.biz.commission.forecast.IECCommissionForecastRepo;
import com.tencent.ecommerce.biz.commission.forecast.b;
import com.tencent.ecommerce.biz.util.i;
import com.tencent.ecommerce.repo.ServiceLocator;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000  2\u00020\u0001:\u0002!\"B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0007R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00180\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\fR\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u0012\u00a8\u0006#"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/overview/ECCommissionOverviewViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/ecommerce/base/network/service/IECJsonNetworkCallback;", "callback", "", "S1", "P1", "", "R1", "Landroidx/lifecycle/MutableLiveData;", "Lorg/json/JSONObject;", "i", "Landroidx/lifecycle/MutableLiveData;", "_commissionInfoJson", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "Q1", "()Landroidx/lifecycle/LiveData;", "commissionInfoJson", "Lcom/tencent/ecommerce/biz/commission/forecast/IECCommissionForecastRepo;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/ecommerce/biz/commission/forecast/IECCommissionForecastRepo;", "commissionForecastRepo", "Lcom/tencent/ecommerce/biz/commission/overview/ECCommissionOverviewViewModel$a;", "D", "_commissionForecastInfo", "E", "O1", "commissionForecastInfo", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECCommissionOverviewViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final IECCommissionForecastRepo commissionForecastRepo;

    /* renamed from: D, reason: from kotlin metadata */
    private final MutableLiveData<CommissionForecastInfo> _commissionForecastInfo;

    /* renamed from: E, reason: from kotlin metadata */
    private final LiveData<CommissionForecastInfo> commissionForecastInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<JSONObject> _commissionInfoJson;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final LiveData<JSONObject> commissionInfoJson;

    public ECCommissionOverviewViewModel() {
        MutableLiveData<JSONObject> mutableLiveData = new MutableLiveData<>();
        this._commissionInfoJson = mutableLiveData;
        this.commissionInfoJson = mutableLiveData;
        this.commissionForecastRepo = ServiceLocator.f104891i.f();
        MutableLiveData<CommissionForecastInfo> mutableLiveData2 = new MutableLiveData<>();
        this._commissionForecastInfo = mutableLiveData2;
        this.commissionForecastInfo = mutableLiveData2;
    }

    private final void S1(IECJsonNetworkCallback callback) {
        a.c("trpc.ecom.income_detail_page_svr.IncomeDetailPageSvr", "/trpc.ecom.income_detail_page_svr.IncomeDetailPageSvr/GetCommissionInfoV2", new JSONObject(), callback);
    }

    public final LiveData<CommissionForecastInfo> O1() {
        return this.commissionForecastInfo;
    }

    public final void P1() {
        S1(new c());
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ECCommissionOverviewViewModel$getCommissionInfo$2(this, null), 3, null);
    }

    public final LiveData<JSONObject> Q1() {
        return this.commissionInfoJson;
    }

    public final String R1() {
        return IECLocalConfig.a.f(ECLocalConfig.f100650f, "lc_commission_overview_info_data_key", "", null, 4, null);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000f\u001a\u00020\f8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/overview/ECCommissionOverviewViewModel$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "desc", "", "b", "J", "commission", "<init>", "(Ljava/lang/String;J)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.commission.overview.ECCommissionOverviewViewModel$a, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class CommissionForecastInfo {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final String desc;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final long commission;

        public CommissionForecastInfo(String str, long j3) {
            this.desc = str;
            this.commission = j3;
        }

        public int hashCode() {
            String str = this.desc;
            return ((str != null ? str.hashCode() : 0) * 31) + b.a(this.commission);
        }

        public String toString() {
            return "CommissionForecastInfo(desc=" + this.desc + ", commission=" + this.commission + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof CommissionForecastInfo)) {
                return false;
            }
            CommissionForecastInfo commissionForecastInfo = (CommissionForecastInfo) other;
            return Intrinsics.areEqual(this.desc, commissionForecastInfo.desc) && this.commission == commissionForecastInfo.commission;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\u000b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/ecommerce/biz/commission/overview/ECCommissionOverviewViewModel$c", "Lcom/tencent/ecommerce/base/network/service/IECJsonNetworkCallback;", "Lorg/json/JSONObject;", "reqParams", "respData", "", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "", "onSuccess", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "onError", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements IECJsonNetworkCallback {
        c() {
        }

        @Override // com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback
        public void onError(JSONObject reqParams, ECRemoteResponse errorResponse) {
            cg0.a.a("ECCommissionOverviewViewModel", "getCommissionInfo", String.valueOf(errorResponse));
        }

        @Override // com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback
        public void onSuccess(JSONObject reqParams, JSONObject respData, String traceInfo) {
            if (respData == null) {
                return;
            }
            long optLong = respData.optLong("total");
            long optLong2 = respData.optLong("paid");
            long optLong3 = respData.optLong("unpaid");
            i iVar = i.f104869a;
            respData.put("total", iVar.d(optLong));
            respData.put("paid", iVar.d(optLong2));
            respData.put("unpaid", iVar.d(optLong3));
            ECCommissionOverviewViewModel.this._commissionInfoJson.postValue(respData);
            IECLocalConfig.a.j(ECLocalConfig.f100650f, "lc_commission_overview_info_data_key", respData.toString(), null, 4, null);
        }
    }
}
