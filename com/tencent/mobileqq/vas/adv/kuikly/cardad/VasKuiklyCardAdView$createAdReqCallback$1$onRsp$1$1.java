package com.tencent.mobileqq.vas.adv.kuikly.cardad;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.vas.adv.kuikly.cardad.VasKuiklyCardAdView$createAdReqCallback$1$onRsp$1$1", f = "VasKuiklyCardAdView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes20.dex */
final class VasKuiklyCardAdView$createAdReqCallback$1$onRsp$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $it;
    int label;
    final /* synthetic */ VasKuiklyCardAdView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasKuiklyCardAdView$createAdReqCallback$1$onRsp$1$1(VasKuiklyCardAdView vasKuiklyCardAdView, long j3, Continuation<? super VasKuiklyCardAdView$createAdReqCallback$1$onRsp$1$1> continuation) {
        super(2, continuation);
        this.this$0 = vasKuiklyCardAdView;
        this.$it = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VasKuiklyCardAdView$createAdReqCallback$1$onRsp$1$1(this.this$0, this.$it, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        String str;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            VasKuiklyCardAdManager vasKuiklyCardAdManager = VasKuiklyCardAdManager.f308031a;
            str = this.this$0.mPosId;
            vasKuiklyCardAdManager.p(false, str, this.$it);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VasKuiklyCardAdView$createAdReqCallback$1$onRsp$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
