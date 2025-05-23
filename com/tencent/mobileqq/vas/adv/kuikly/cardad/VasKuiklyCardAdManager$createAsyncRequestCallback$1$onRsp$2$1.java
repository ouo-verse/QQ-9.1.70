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
@DebugMetadata(c = "com.tencent.mobileqq.vas.adv.kuikly.cardad.VasKuiklyCardAdManager$createAsyncRequestCallback$1$onRsp$2$1", f = "VasKuiklyCardAdManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes20.dex */
final class VasKuiklyCardAdManager$createAsyncRequestCallback$1$onRsp$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $it;
    final /* synthetic */ String $posId;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VasKuiklyCardAdManager$createAsyncRequestCallback$1$onRsp$2$1(String str, long j3, Continuation<? super VasKuiklyCardAdManager$createAsyncRequestCallback$1$onRsp$2$1> continuation) {
        super(2, continuation);
        this.$posId = str;
        this.$it = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new VasKuiklyCardAdManager$createAsyncRequestCallback$1$onRsp$2$1(this.$posId, this.$it, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            VasKuiklyCardAdManager.f308031a.p(true, this.$posId, this.$it);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((VasKuiklyCardAdManager$createAsyncRequestCallback$1$onRsp$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
