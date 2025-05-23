package com.tencent.ecommerce.biz.commission.subsidy;

import androidx.lifecycle.MutableLiveData;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.repo.ServiceLocator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import sj0.ECTaxLinkModel;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.ecommerce.biz.commission.subsidy.ECSubsidyOverviewViewModel$requestTaxLink$1", f = "ECSubsidyOverviewViewModel.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class ECSubsidyOverviewViewModel$requestTaxLink$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CharSequence $invalidUrlToast;
    final /* synthetic */ String $token;
    int label;
    final /* synthetic */ ECSubsidyOverviewViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ECSubsidyOverviewViewModel$requestTaxLink$1(ECSubsidyOverviewViewModel eCSubsidyOverviewViewModel, String str, CharSequence charSequence, Continuation continuation) {
        super(2, continuation);
        this.this$0 = eCSubsidyOverviewViewModel;
        this.$token = str;
        this.$invalidUrlToast = charSequence;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ECSubsidyOverviewViewModel$requestTaxLink$1(this.this$0, this.$token, this.$invalidUrlToast, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ECSubsidyOverviewViewModel$requestTaxLink$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MutableLiveData mutableLiveData;
        MutableLiveData mutableLiveData2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            mutableLiveData = this.this$0._showLoadingDialog;
            mutableLiveData.setValue(Boxing.boxBoolean(false));
            com.tencent.ecommerce.repo.commission.subsidy.a r16 = ServiceLocator.f104891i.r();
            String str = this.$token;
            this.label = 1;
            obj = r16.a(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ECTaxLinkModel eCTaxLinkModel = (ECTaxLinkModel) ((ECNetworkResponse) obj).b();
        if (eCTaxLinkModel == null) {
            this.this$0.f2();
            return Unit.INSTANCE;
        }
        if (eCTaxLinkModel.validCode != 0) {
            mutableLiveData2 = this.this$0._taxLink;
            mutableLiveData2.setValue(eCTaxLinkModel.getUrl());
            return Unit.INSTANCE;
        }
        i.f101155b.d(this.$invalidUrlToast, ECToastIcon.ICON_ERROR, 0);
        return Unit.INSTANCE;
    }
}
