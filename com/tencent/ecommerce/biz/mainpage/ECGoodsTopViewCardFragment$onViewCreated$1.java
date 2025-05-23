package com.tencent.ecommerce.biz.mainpage;

import com.tencent.ecommerce.base.router.api.IECLogicCallback;
import com.tencent.ecommerce.biz.consumer.ui.api.IECGoodsViewModel;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\"\u0010\u0004\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007`\bH\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/mainpage/ECGoodsTopViewCardFragment$onViewCreated$1", "Lcom/tencent/ecommerce/base/router/api/IECLogicCallback;", "onResult", "", "result", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECGoodsTopViewCardFragment$onViewCreated$1 implements IECLogicCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ECGoodsTopViewCardFragment f102939a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECGoodsTopViewCardFragment$onViewCreated$1(ECGoodsTopViewCardFragment eCGoodsTopViewCardFragment) {
        this.f102939a = eCGoodsTopViewCardFragment;
    }

    @Override // com.tencent.ecommerce.base.router.api.IECLogicCallback
    public void onResult(final HashMap<String, Object> result) {
        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.mainpage.ECGoodsTopViewCardFragment$onViewCreated$1$onResult$1
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
                ECGoodsTopViewCardFragment eCGoodsTopViewCardFragment = ECGoodsTopViewCardFragment$onViewCreated$1.this.f102939a;
                Object obj = result.get("PARAM_VIEW_MODEL_OBJECT");
                if (!(obj instanceof IECGoodsViewModel)) {
                    obj = null;
                }
                eCGoodsTopViewCardFragment.topViewViewModel = (IECGoodsViewModel) obj;
                IECGoodsViewModel iECGoodsViewModel = ECGoodsTopViewCardFragment$onViewCreated$1.this.f102939a.topViewViewModel;
                if (iECGoodsViewModel != null) {
                    iECGoodsViewModel.setWrapperView(ECGoodsTopViewCardFragment.Ph(ECGoodsTopViewCardFragment$onViewCreated$1.this.f102939a), null);
                }
                IECGoodsViewModel iECGoodsViewModel2 = ECGoodsTopViewCardFragment$onViewCreated$1.this.f102939a.topViewViewModel;
                if (iECGoodsViewModel2 != null) {
                    iECGoodsViewModel2.onWrapperViewAppear(false);
                }
            }
        });
    }
}
