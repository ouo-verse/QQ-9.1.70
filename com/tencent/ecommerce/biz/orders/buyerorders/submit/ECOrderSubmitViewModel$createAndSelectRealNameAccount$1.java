package com.tencent.ecommerce.biz.orders.buyerorders.submit;

import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.biz.orders.buyerorders.submit.l;
import com.tencent.ecommerce.biz.orders.realname.IECRealNameOperateRepo;
import com.tencent.ecommerce.biz.orders.realname.RealNameAccount;
import cooperation.qzone.report.lp.LpReportInfoConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.orders.buyerorders.submit.ECOrderSubmitViewModel$createAndSelectRealNameAccount$1", f = "ECOrderSubmitViewModel.kt", i = {3}, l = {584, LpReportInfoConfig.ACTION_TYPE_COMMON_SETTING, 597, 601, 603}, m = "invokeSuspend", n = {"it"}, s = {"L$1"})
/* loaded from: classes31.dex */
public final class ECOrderSubmitViewModel$createAndSelectRealNameAccount$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ RealNameAccount $account;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ECOrderSubmitViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECOrderSubmitViewModel$createAndSelectRealNameAccount$1(ECOrderSubmitViewModel eCOrderSubmitViewModel, RealNameAccount realNameAccount, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCOrderSubmitViewModel;
        this.$account = realNameAccount;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECOrderSubmitViewModel$createAndSelectRealNameAccount$1(this.this$0, this.$account, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECOrderSubmitViewModel$createAndSelectRealNameAccount$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00f7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0115 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        IECRealNameOperateRepo iECRealNameOperateRepo;
        Object createAccount;
        boolean z16;
        MutableSharedFlow mutableSharedFlow;
        l.ErrorCommonEvent errorCommonEvent;
        RealNameAccount realNameAccount;
        MutableSharedFlow mutableSharedFlow2;
        RealNameAccount realNameAccount2;
        MutableSharedFlow mutableSharedFlow3;
        Map emptyMap;
        String str;
        MutableSharedFlow mutableSharedFlow4;
        Integer boxInt;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            iECRealNameOperateRepo = this.this$0.realNameRepo;
            RealNameAccount realNameAccount3 = this.$account;
            this.label = 1;
            createAccount = iECRealNameOperateRepo.createAccount(realNameAccount3, this);
            if (createAccount == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                if (i3 == 3) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                if (i3 != 4) {
                    if (i3 == 5) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                realNameAccount = (RealNameAccount) this.L$1;
                realNameAccount2 = (RealNameAccount) this.L$0;
                ResultKt.throwOnFailure(obj);
                this.this$0.e3(realNameAccount);
                mutableSharedFlow4 = this.this$0._realNameDialogEvent;
                boxInt = Boxing.boxInt(2);
                this.L$0 = realNameAccount2;
                this.L$1 = null;
                this.label = 5;
                if (mutableSharedFlow4.emit(boxInt, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            createAccount = obj;
        }
        ECNetworkResponse eCNetworkResponse = (ECNetworkResponse) createAccount;
        IECRealNameOperateRepo.CreateRealNameAccountWrapper createRealNameAccountWrapper = (IECRealNameOperateRepo.CreateRealNameAccountWrapper) eCNetworkResponse.b();
        if (eCNetworkResponse.getCode() == 0 && createRealNameAccountWrapper != null && (str = createRealNameAccountWrapper.alertMsg) != null) {
            if (str.length() == 0) {
                z16 = true;
                if (z16) {
                    com.tencent.ecommerce.base.report.service.b bVar = com.tencent.ecommerce.base.report.service.b.f100913b;
                    emptyMap = MapsKt__MapsKt.emptyMap();
                    IECDataReport.a.a(bVar, "qstore_order_submit_id_check_success", emptyMap, false, 4, null);
                }
                if (eCNetworkResponse.getCode() == 0 || createRealNameAccountWrapper == null) {
                    mutableSharedFlow = this.this$0._errorEvent;
                    errorCommonEvent = new l.ErrorCommonEvent(eCNetworkResponse.getCode(), "");
                    this.label = 2;
                    if (mutableSharedFlow.emit(errorCommonEvent, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                if (createRealNameAccountWrapper.alertMsg.length() > 0) {
                    mutableSharedFlow3 = this.this$0._errorEvent;
                    l.ErrorToastWithMsgEvent errorToastWithMsgEvent = new l.ErrorToastWithMsgEvent(createRealNameAccountWrapper.alertMsg);
                    this.label = 3;
                    if (mutableSharedFlow3.emit(errorToastWithMsgEvent, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                realNameAccount = createRealNameAccountWrapper.user;
                if (realNameAccount != null) {
                    mutableSharedFlow2 = this.this$0._realNameDialogEvent;
                    Integer boxInt2 = Boxing.boxInt(3);
                    this.L$0 = realNameAccount;
                    this.L$1 = realNameAccount;
                    this.label = 4;
                    if (mutableSharedFlow2.emit(boxInt2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    realNameAccount2 = realNameAccount;
                    this.this$0.e3(realNameAccount);
                    mutableSharedFlow4 = this.this$0._realNameDialogEvent;
                    boxInt = Boxing.boxInt(2);
                    this.L$0 = realNameAccount2;
                    this.L$1 = null;
                    this.label = 5;
                    if (mutableSharedFlow4.emit(boxInt, this) == coroutine_suspended) {
                    }
                }
                return Unit.INSTANCE;
            }
        }
        z16 = false;
        if (z16) {
        }
        if (eCNetworkResponse.getCode() == 0) {
        }
        mutableSharedFlow = this.this$0._errorEvent;
        errorCommonEvent = new l.ErrorCommonEvent(eCNetworkResponse.getCode(), "");
        this.label = 2;
        if (mutableSharedFlow.emit(errorCommonEvent, this) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }
}
