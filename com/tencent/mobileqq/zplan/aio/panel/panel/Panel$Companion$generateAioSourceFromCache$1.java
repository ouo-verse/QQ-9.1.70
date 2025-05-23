package com.tencent.mobileqq.zplan.aio.panel.panel;

import com.tencent.mobileqq.zplan.aio.panel.panel.Panel;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/mobileqq/zplan/aio/panel/panel/Panel;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.panel.panel.Panel$Companion$generateAioSourceFromCache$1", f = "Panel.kt", i = {}, l = {189}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
public final class Panel$Companion$generateAioSourceFromCache$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Panel>, Object> {
    final /* synthetic */ List<a> $builders;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Panel$Companion$generateAioSourceFromCache$1(List<? extends a> list, Continuation<? super Panel$Companion$generateAioSourceFromCache$1> continuation) {
        super(2, continuation);
        this.$builders = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Panel$Companion$generateAioSourceFromCache$1(this.$builders, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Panel.Companion companion = Panel.INSTANCE;
            List<a> list = this.$builders;
            this.label = 1;
            obj = companion.n(1, list, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Panel> continuation) {
        return ((Panel$Companion$generateAioSourceFromCache$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
