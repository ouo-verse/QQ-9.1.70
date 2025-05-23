package com.tencent.ecommerce.biz.showwindow.viewmodel;

import android.content.Context;
import bi0.ECHREvent;
import cj0.a;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.biz.productcenter.repo.IECSelectProductDefaultRepository;
import com.tencent.ecommerce.biz.showwindow.repo.ECGlobalAddProductWindowRequest;
import com.tencent.ecommerce.biz.showwindow.repo.window.ECShowWindowAddProductRsp;
import com.tencent.ecommerce.biz.showwindow.repo.window.k;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import qi0.ECSelectProductAddWindowResponse;
import ri0.ECAddProductToWindowEvent;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.showwindow.viewmodel.ECGlobalShowWindowViewModel$requestAddProductWindow$1", f = "ECGlobalShowWindowViewModel.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECGlobalShowWindowViewModel$requestAddProductWindow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $goodsType;
    final /* synthetic */ JSONObject $productInfo;
    final /* synthetic */ String $saasProductId;
    final /* synthetic */ String $saasType;
    int label;
    final /* synthetic */ ECGlobalShowWindowViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECGlobalShowWindowViewModel$requestAddProductWindow$1(ECGlobalShowWindowViewModel eCGlobalShowWindowViewModel, String str, String str2, String str3, Context context, JSONObject jSONObject, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCGlobalShowWindowViewModel;
        this.$saasType = str;
        this.$saasProductId = str2;
        this.$goodsType = str3;
        this.$context = context;
        this.$productInfo = jSONObject;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECGlobalShowWindowViewModel$requestAddProductWindow$1(this.this$0, this.$saasType, this.$saasProductId, this.$goodsType, this.$context, this.$productInfo, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECGlobalShowWindowViewModel$requestAddProductWindow$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        com.tencent.ecommerce.biz.productcenter.repo.a M1;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            ECGlobalAddProductWindowRequest eCGlobalAddProductWindowRequest = new ECGlobalAddProductWindowRequest(this.$saasType, this.$saasProductId, fj0.c.f399474a.g(this.$goodsType));
            M1 = this.this$0.M1();
            this.label = 1;
            obj = IECSelectProductDefaultRepository.a.a(M1, eCGlobalAddProductWindowRequest, null, this, 2, null);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ECNetworkResponse eCNetworkResponse = (ECNetworkResponse) obj;
        ECSelectProductAddWindowResponse eCSelectProductAddWindowResponse = (ECSelectProductAddWindowResponse) eCNetworkResponse.b();
        if (eCNetworkResponse.getCode() == 0 && eCSelectProductAddWindowResponse != null) {
            cg0.a.b("ECGlobalShowWindowViewModel", "[addProductWindow] success addWindowResponse = " + eCSelectProductAddWindowResponse);
            a.b respMsgInfo = eCSelectProductAddWindowResponse.getRespMsgInfo();
            if (respMsgInfo != null && respMsgInfo.getDisplay()) {
                a.b respMsgInfo2 = eCSelectProductAddWindowResponse.getRespMsgInfo();
                if (respMsgInfo2 != null) {
                    ECShowWindowAddProductRsp.INSTANCE.a(this.$context, new ECShowWindowAddProductRsp.a(respMsgInfo2.getDisplay(), respMsgInfo2.getTitle(), respMsgInfo2.getText(), respMsgInfo2.getLeftBtnText(), respMsgInfo2.getLeftBtnUrl(), respMsgInfo2.getRightBtnText(), respMsgInfo2.getRightBtnUrl()));
                    cg0.a.b("ECGlobalShowWindowViewModel", "[handleAddWindowBtnClick] showMessageBox");
                }
                return Unit.INSTANCE;
            }
            k result = eCSelectProductAddWindowResponse.getResult();
            if (result != null && result.getCom.tencent.mobileqq.vas.api.RemoteProxy.KEY_RESULT_TYPE java.lang.String() == 1) {
                i.f101155b.d(this.$context.getResources().getString(R.string.wf9), ECToastIcon.ICON_SUCCESS, 0);
                LifecycleEventBus lifecycleEventBus = LifecycleEventBus.f100688b;
                lifecycleEventBus.f(new ECAddProductToWindowEvent(true, this.$saasProductId, String.valueOf(eCSelectProductAddWindowResponse.getMediaProductId()), this.$productInfo));
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("productID", this.$saasProductId);
                lifecycleEventBus.f(new ECHREvent("ECWindowAddNotification", jSONObject));
            } else {
                i iVar = i.f101155b;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(this.$context.getResources().getString(R.string.wf8));
                k result2 = eCSelectProductAddWindowResponse.getResult();
                sb5.append(result2 != null ? result2.getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_CAUSE java.lang.String() : null);
                iVar.d(sb5.toString(), ECToastIcon.ICON_ERROR, 0);
                LifecycleEventBus.f100688b.f(new ECAddProductToWindowEvent(false, this.$saasProductId, String.valueOf(eCSelectProductAddWindowResponse.getMediaProductId()), this.$productInfo));
            }
        } else {
            cg0.a.a("ECGlobalShowWindowViewModel", "addProductWindow", "[addProductWindow] fail errCode = " + eCNetworkResponse.getCode() + " errMsg = " + eCNetworkResponse.getMessage());
            i iVar2 = i.f101155b;
            StringBuilder sb6 = new StringBuilder();
            sb6.append(this.$context.getResources().getString(R.string.wf8));
            sb6.append(eCNetworkResponse.getMessage());
            iVar2.d(sb6.toString(), ECToastIcon.ICON_ERROR, 0);
            LifecycleEventBus.f100688b.f(new ECAddProductToWindowEvent(false, this.$saasProductId, null, this.$productInfo, 4, null));
        }
        return Unit.INSTANCE;
    }
}
