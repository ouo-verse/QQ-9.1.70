package com.tencent.ecommerce.biz.logistics;

import android.widget.TextView;
import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.base.network.service.IECNetworkCallback;
import com.tencent.ecommerce.base.ui.SoftKeyboardStateHelper;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/biz/logistics/ECSubmitLogisticsFragment$onSoftInputAction$1", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Lcom/tencent/ecommerce/biz/logistics/e;", "Lcom/tencent/ecommerce/biz/logistics/f;", "reqModel", "respModel", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECSubmitLogisticsFragment$onSoftInputAction$1 implements IECNetworkCallback<e, f> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ECSubmitLogisticsFragment f102876a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECSubmitLogisticsFragment$onSoftInputAction$1(ECSubmitLogisticsFragment eCSubmitLogisticsFragment) {
        this.f102876a = eCSubmitLogisticsFragment;
    }

    @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onError(e reqModel, ECRemoteResponse errorResponse) {
        cg0.a.a("SubmitLogisticsFragment", "onError", "ECLogisticsQueryReq onError code=" + errorResponse.getCode() + " msg=" + errorResponse.getMsg());
    }

    @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onSuccess(e reqModel, final f respModel) {
        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.logistics.ECSubmitLogisticsFragment$onSoftInputAction$1$onSuccess$1
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
                String str;
                CharSequence text = ECSubmitLogisticsFragment.Mh(ECSubmitLogisticsFragment$onSoftInputAction$1.this.f102876a).getText();
                if (text != null) {
                    if (!(text.length() == 0) || respModel.getCom.tencent.mobileqq.profilecard.api.IProfileProtocolConst.KEY_COMPANY java.lang.String() == null) {
                        return;
                    }
                    TextView Mh = ECSubmitLogisticsFragment.Mh(ECSubmitLogisticsFragment$onSoftInputAction$1.this.f102876a);
                    ECExpressCompany eCExpressCompany = respModel.getCom.tencent.mobileqq.profilecard.api.IProfileProtocolConst.KEY_COMPANY java.lang.String();
                    Mh.setText(eCExpressCompany != null ? eCExpressCompany.name : null);
                    ECSubmitLogisticsFragment eCSubmitLogisticsFragment = ECSubmitLogisticsFragment$onSoftInputAction$1.this.f102876a;
                    ECExpressCompany eCExpressCompany2 = respModel.getCom.tencent.mobileqq.profilecard.api.IProfileProtocolConst.KEY_COMPANY java.lang.String();
                    if (eCExpressCompany2 == null || (str = eCExpressCompany2.code) == null) {
                        str = "";
                    }
                    eCSubmitLogisticsFragment.expressCompanyCode = str;
                    SoftKeyboardStateHelper.INSTANCE.d(ECSubmitLogisticsFragment$onSoftInputAction$1.this.f102876a.yh());
                }
            }
        });
    }
}
