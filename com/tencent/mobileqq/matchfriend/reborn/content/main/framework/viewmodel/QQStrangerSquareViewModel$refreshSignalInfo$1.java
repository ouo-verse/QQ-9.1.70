package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.viewmodel;

import com.tencent.mobileqq.matchfriend.reborn.content.signal.b;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.content.main.framework.viewmodel.QQStrangerSquareViewModel$refreshSignalInfo$1", f = "QQStrangerSquareViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
final class QQStrangerSquareViewModel$refreshSignalInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $loadCacheFirst;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerSquareViewModel$refreshSignalInfo$1(boolean z16, Continuation<? super QQStrangerSquareViewModel$refreshSignalInfo$1> continuation) {
        super(2, continuation);
        this.$loadCacheFirst = z16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QQStrangerSquareViewModel$refreshSignalInfo$1(this.$loadCacheFirst, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            b.f244871a.e(this.$loadCacheFirst);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QQStrangerSquareViewModel$refreshSignalInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
