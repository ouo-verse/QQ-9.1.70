package com.tencent.ecommerce.biz.customerservice;

import com.tencent.ecommerce.biz.customerservice.IECCustomerServiceRepo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\fB\u0011\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u000f\u0010\u0010J3\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ecommerce/biz/customerservice/ECCustomerServiceRepo;", "Lcom/tencent/ecommerce/biz/customerservice/IECCustomerServiceRepo;", "Lcom/tencent/ecommerce/biz/customerservice/CustomerServiceScene;", "scene", "", "shopId", "spuId", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "Lcom/tencent/ecommerce/biz/customerservice/IECCustomerServiceRepo$a;", "fetchCustomerServiceInfo", "(Lcom/tencent/ecommerce/biz/customerservice/CustomerServiceScene;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/CoroutineDispatcher;", "a", "Lkotlinx/coroutines/CoroutineDispatcher;", "coroutineDispatcher", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECCustomerServiceRepo implements IECCustomerServiceRepo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final CoroutineDispatcher coroutineDispatcher;

    public ECCustomerServiceRepo(CoroutineDispatcher coroutineDispatcher) {
        this.coroutineDispatcher = coroutineDispatcher;
    }

    @Override // com.tencent.ecommerce.biz.customerservice.IECCustomerServiceRepo
    public Object fetchCustomerServiceInfo(CustomerServiceScene customerServiceScene, String str, String str2, String str3, Continuation<? super IECCustomerServiceRepo.CustomerServiceResult> continuation) {
        return BuildersKt.withContext(this.coroutineDispatcher, new ECCustomerServiceRepo$fetchCustomerServiceInfo$2(customerServiceScene, str, str2, str3, null), continuation);
    }

    public /* synthetic */ ECCustomerServiceRepo(CoroutineDispatcher coroutineDispatcher, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? Dispatchers.getIO() : coroutineDispatcher);
    }
}
