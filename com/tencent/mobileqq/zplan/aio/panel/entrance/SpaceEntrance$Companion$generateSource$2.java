package com.tencent.mobileqq.zplan.aio.panel.entrance;

import android.view.View;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", ReportConstant.COSTREPORT_PREFIX, "Landroid/view/View;", "<anonymous parameter 1>", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.panel.entrance.SpaceEntrance$Companion$generateSource$2", f = "SpaceEntrance.kt", i = {}, l = {144}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class SpaceEntrance$Companion$generateSource$2 extends SuspendLambda implements Function3<CoroutineScope, View, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<CoroutineScope, Integer, Continuation<? super Unit>, Object> $showPanelLayout;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SpaceEntrance$Companion$generateSource$2(Function3<? super CoroutineScope, ? super Integer, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super SpaceEntrance$Companion$generateSource$2> continuation) {
        super(3, continuation);
        this.$showPanelLayout = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Function3<CoroutineScope, Integer, Continuation<? super Unit>, Object> function3 = this.$showPanelLayout;
            Integer boxInt = Boxing.boxInt(1);
            this.label = 1;
            if (function3.invoke(coroutineScope, boxInt, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(CoroutineScope coroutineScope, View view, Continuation<? super Unit> continuation) {
        SpaceEntrance$Companion$generateSource$2 spaceEntrance$Companion$generateSource$2 = new SpaceEntrance$Companion$generateSource$2(this.$showPanelLayout, continuation);
        spaceEntrance$Companion$generateSource$2.L$0 = coroutineScope;
        return spaceEntrance$Companion$generateSource$2.invokeSuspend(Unit.INSTANCE);
    }
}
