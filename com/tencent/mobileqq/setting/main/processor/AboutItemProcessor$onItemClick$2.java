package com.tencent.mobileqq.setting.main.processor;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.setting.main.processor.AboutItemProcessor$onItemClick$2", f = "AboutItemProcessor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class AboutItemProcessor$onItemClick$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AboutItemProcessor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AboutItemProcessor$onItemClick$2(AboutItemProcessor aboutItemProcessor, Continuation<? super AboutItemProcessor$onItemClick$2> continuation) {
        super(2, continuation);
        this.this$0 = aboutItemProcessor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AboutItemProcessor$onItemClick$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AboutItemProcessor$onItemClick$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean D;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            D = this.this$0.D();
            if (D) {
                com.tencent.mobileqq.setting.utils.o oVar = com.tencent.mobileqq.setting.utils.o.f286768a;
                String g16 = com.tencent.mobileqq.upgrade.k.g();
                Intrinsics.checkNotNullExpressionValue(g16, "getAppIdUpgradeTo()");
                oVar.c("CliOper", "0X8004DB1", "0X8004DB1", (r20 & 8) != 0 ? 0 : 0, (r20 & 16) != 0 ? "" : null, (r20 & 32) != 0 ? "" : null, (r20 & 64) != 0 ? "" : g16, (r20 & 128) != 0 ? "" : null);
            }
            com.tencent.mobileqq.setting.utils.o.f286768a.c("CliOper", "Setting_tab", "Clk_about", (r20 & 8) != 0 ? 0 : 0, (r20 & 16) != 0 ? "" : null, (r20 & 32) != 0 ? "" : null, (r20 & 64) != 0 ? "" : null, (r20 & 128) != 0 ? "" : null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
