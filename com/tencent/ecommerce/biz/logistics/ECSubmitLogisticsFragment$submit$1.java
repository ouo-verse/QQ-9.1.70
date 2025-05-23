package com.tencent.ecommerce.biz.logistics;

import androidx.fragment.app.FragmentActivity;
import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.base.network.service.IECNetworkCallback;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/biz/logistics/ECSubmitLogisticsFragment$submit$1", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Lcom/tencent/ecommerce/biz/logistics/g;", "Lcom/tencent/ecommerce/biz/logistics/h;", "reqModel", "respModel", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECSubmitLogisticsFragment$submit$1 implements IECNetworkCallback<g, h> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ECSubmitLogisticsFragment f102877a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECSubmitLogisticsFragment$submit$1(ECSubmitLogisticsFragment eCSubmitLogisticsFragment) {
        this.f102877a = eCSubmitLogisticsFragment;
    }

    @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onError(g reqModel, ECRemoteResponse errorResponse) {
        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.logistics.ECSubmitLogisticsFragment$submit$1$onError$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ECSubmitLogisticsFragment$submit$1.this.f102877a.hideLoading();
                ECSubmitLogisticsFragment$submit$1.this.f102877a.showToast("\u63d0\u4ea4\u5931\u8d25");
            }
        });
        cg0.a.a("SubmitLogisticsFragment", "onError", "ECLogisticsSubmitReq onError code=" + errorResponse.getCode() + " msg=" + errorResponse.getMsg());
    }

    @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onSuccess(g reqModel, final h respModel) {
        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.logistics.ECSubmitLogisticsFragment$submit$1$onSuccess$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (respModel.getCode() == 0) {
                    ECSubmitLogisticsFragment$submit$1.this.f102877a.showToast("\u63d0\u4ea4\u6210\u529f");
                    FragmentActivity activity = ECSubmitLogisticsFragment$submit$1.this.f102877a.getActivity();
                    if (activity != null) {
                        activity.finish();
                        return;
                    }
                    return;
                }
                ECSubmitLogisticsFragment$submit$1.this.f102877a.showToast(respModel.getMsg());
            }
        });
    }
}
