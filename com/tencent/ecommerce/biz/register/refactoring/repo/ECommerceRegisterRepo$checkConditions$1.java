package com.tencent.ecommerce.biz.register.refactoring.repo;

import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.base.network.service.IECNetworkCallback;
import com.tencent.ecommerce.biz.register.network.a;
import com.tencent.ecommerce.biz.register.network.b;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONArray;

/* compiled from: P */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/biz/register/refactoring/repo/ECommerceRegisterRepo$checkConditions$1", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Lcom/tencent/ecommerce/biz/register/network/a;", "Lcom/tencent/ecommerce/biz/register/network/b;", "reqModel", "respModel", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECommerceRegisterRepo$checkConditions$1 implements IECNetworkCallback<a, b> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IECRegisterConditionCallback f104100a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECommerceRegisterRepo$checkConditions$1(IECRegisterConditionCallback iECRegisterConditionCallback) {
        this.f104100a = iECRegisterConditionCallback;
    }

    @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onError(a reqModel, ECRemoteResponse errorResponse) {
        cg0.a.b("ECommerceRegisterRepo", "code:" + errorResponse.getCode() + " conditions:" + errorResponse.getMsg());
        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.repo.ECommerceRegisterRepo$checkConditions$1$onError$1
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
                IECRegisterConditionCallback iECRegisterConditionCallback = ECommerceRegisterRepo$checkConditions$1.this.f104100a;
                if (iECRegisterConditionCallback != null) {
                    iECRegisterConditionCallback.onCheck(new JSONArray());
                }
            }
        });
    }

    @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void onSuccess(a reqModel, final b respModel) {
        cg0.a.b("ECommerceRegisterRepo", "conditions:" + respModel.getConditions());
        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.register.refactoring.repo.ECommerceRegisterRepo$checkConditions$1$onSuccess$1
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
                IECRegisterConditionCallback iECRegisterConditionCallback = ECommerceRegisterRepo$checkConditions$1.this.f104100a;
                if (iECRegisterConditionCallback != null) {
                    JSONArray conditions = respModel.getConditions();
                    if (conditions == null) {
                        conditions = new JSONArray();
                    }
                    iECRegisterConditionCallback.onCheck(conditions);
                }
            }
        });
    }
}
