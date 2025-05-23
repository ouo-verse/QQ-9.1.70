package com.tencent.mobileqq.zplan.aigc;

import com.tencent.qphone.base.util.QLog;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aigc.SuitPreviewFragment$makeUpChannel$1$onModifyColorInfo$1", f = "SuitPreviewFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class SuitPreviewFragment$makeUpChannel$1$onModifyColorInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ qu4.c $colorInfo;
    int label;
    final /* synthetic */ SuitPreviewFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SuitPreviewFragment$makeUpChannel$1$onModifyColorInfo$1(SuitPreviewFragment suitPreviewFragment, qu4.c cVar, Continuation<? super SuitPreviewFragment$makeUpChannel$1$onModifyColorInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = suitPreviewFragment;
        this.$colorInfo = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SuitPreviewFragment$makeUpChannel$1$onModifyColorInfo$1(this.this$0, this.$colorInfo, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z16;
        long j3;
        String Pi;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            QLog.i("SuitPreviewFragment", 1, "onModifyColorInfo begin");
            z16 = this.this$0.colorPanelShow;
            if (!z16) {
                return Unit.INSTANCE;
            }
            long currentTimeMillis = System.currentTimeMillis();
            j3 = this.this$0.preUpdateUgcTime;
            long j16 = currentTimeMillis - j3;
            if (j16 < 200) {
                QLog.i("SuitPreviewFragment", 1, "onModifyColorInfo cancel, delta time: " + j16);
                return Unit.INSTANCE;
            }
            qu4.d[] slotArr = this.$colorInfo.f429581b;
            Intrinsics.checkNotNullExpressionValue(slotArr, "slotArr");
            SuitPreviewFragment suitPreviewFragment = this.this$0;
            for (qu4.d dVar : slotArr) {
                if (dVar.f429583a == 103) {
                    Pi = suitPreviewFragment.Pi(dVar.f429585c.f429637b);
                    suitPreviewFragment.currentColor = Pi;
                    suitPreviewFragment.ak(suitPreviewFragment.currentPatternPosType, suitPreviewFragment.currentColor);
                    QLog.i("SuitPreviewFragment", 1, "onModifyColorInfo end, delta time: " + j16);
                    suitPreviewFragment.preUpdateUgcTime = currentTimeMillis;
                    return Unit.INSTANCE;
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SuitPreviewFragment$makeUpChannel$1$onModifyColorInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
