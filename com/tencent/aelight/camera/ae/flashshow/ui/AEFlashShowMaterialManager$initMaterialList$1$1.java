package com.tencent.aelight.camera.ae.flashshow.ui;

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
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMaterialManager$initMaterialList$1$1", f = "AEFlashShowMaterialManager.kt", i = {}, l = {224}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes32.dex */
public final class AEFlashShowMaterialManager$initMaterialList$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $start;
    int label;
    final /* synthetic */ AEFlashShowMaterialManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AEFlashShowMaterialManager$initMaterialList$1$1(AEFlashShowMaterialManager aEFlashShowMaterialManager, long j3, Continuation<? super AEFlashShowMaterialManager$initMaterialList$1$1> continuation) {
        super(2, continuation);
        this.this$0 = aEFlashShowMaterialManager;
        this.$start = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AEFlashShowMaterialManager$initMaterialList$1$1(this.this$0, this.$start, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Object R;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            AEFlashShowMaterialManager aEFlashShowMaterialManager = this.this$0;
            this.label = 1;
            R = aEFlashShowMaterialManager.R(this);
            if (R == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0.W(this.$start);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AEFlashShowMaterialManager$initMaterialList$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
