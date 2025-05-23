package com.tencent.ecommerce.biz.consulthistory;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.base.network.service.IECNetworkCallback;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/biz/consulthistory/ECConsultHistoryFragment$requestData$1", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Lcom/tencent/ecommerce/biz/consulthistory/b;", "Lcom/tencent/ecommerce/biz/consulthistory/c;", "reqModel", "respModel", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECConsultHistoryFragment$requestData$1 implements IECNetworkCallback<b, c> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ECConsultHistoryFragment f101571a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECConsultHistoryFragment$requestData$1(ECConsultHistoryFragment eCConsultHistoryFragment) {
        this.f101571a = eCConsultHistoryFragment;
    }

    @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onError(b reqModel, ECRemoteResponse errorResponse) {
        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.consulthistory.ECConsultHistoryFragment$requestData$1$onError$1
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
                ECConsultHistoryFragment.Nh(ECConsultHistoryFragment$requestData$1.this.f101571a).setFailedState("");
            }
        });
        this.f101571a.Qh(false);
    }

    @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onSuccess(b reqModel, final c respModel) {
        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.consulthistory.ECConsultHistoryFragment$requestData$1$onSuccess$1
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
                if (respModel.a().isEmpty()) {
                    ECConsultHistoryFragment.Nh(ECConsultHistoryFragment$requestData$1.this.f101571a).setFailedState("\u8bf7\u6c42\u5931\u8d25");
                    ECConsultHistoryFragment$requestData$1.this.f101571a.Qh(false);
                    return;
                }
                ECConsultHistoryFragment.Nh(ECConsultHistoryFragment$requestData$1.this.f101571a).setSucceededState();
                ECConsultHistoryFragment$requestData$1.this.f101571a.Ph(respModel.a());
                RecyclerView.Adapter adapter = ECConsultHistoryFragment.Mh(ECConsultHistoryFragment$requestData$1.this.f101571a).getAdapter();
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                }
                ECConsultHistoryFragment$requestData$1.this.f101571a.Qh(true);
            }
        });
    }
}
