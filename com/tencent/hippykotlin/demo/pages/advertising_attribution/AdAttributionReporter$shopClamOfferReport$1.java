package com.tencent.hippykotlin.demo.pages.advertising_attribution;

import com.tencent.hippykotlin.demo.pages.advertising_attribution.model.AdAttributionAddResult;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.advertising_attribution.AdAttributionReporter$shopClamOfferReport$1", f = "AdAttributionReporter.kt", i = {}, l = {41}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes31.dex */
public final class AdAttributionReporter$shopClamOfferReport$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ e $reportData;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdAttributionReporter$shopClamOfferReport$1(e eVar, Continuation<? super AdAttributionReporter$shopClamOfferReport$1> continuation) {
        super(2, continuation);
        this.$reportData = eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AdAttributionReporter$shopClamOfferReport$1(this.$reportData, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((AdAttributionReporter$shopClamOfferReport$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            AdAttributionRepo adAttributionRepo = (AdAttributionRepo) AdAttributionReporter.repo$delegate.getValue();
            e eVar = this.$reportData;
            this.label = 1;
            obj = adAttributionRepo.addAdAttributionData(eVar, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AdAttributionReporter adAttributionReporter = AdAttributionReporter.INSTANCE;
        AdAttributionReporter.access$reportDT(this.$reportData, (AdAttributionAddResult) obj);
        return Unit.INSTANCE;
    }
}
