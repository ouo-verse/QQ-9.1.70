package com.tencent.mobileqq.zplan.aio.panel.entrance;

import android.view.View;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.aio.panel.entrance.SpaceEntrance$Companion$generateSource$4$1$1", f = "SpaceEntrance.kt", i = {}, l = {153}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes35.dex */
final class SpaceEntrance$Companion$generateSource$4$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $it;
    final /* synthetic */ CoroutineScope $scope;
    final /* synthetic */ MutableStateFlow<List<SpaceEntrance>> $this_apply;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpaceEntrance$Companion$generateSource$4$1$1(MutableStateFlow<List<SpaceEntrance>> mutableStateFlow, CoroutineScope coroutineScope, View view, Continuation<? super SpaceEntrance$Companion$generateSource$4$1$1> continuation) {
        super(2, continuation);
        this.$this_apply = mutableStateFlow;
        this.$scope = coroutineScope;
        this.$it = view;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SpaceEntrance$Companion$generateSource$4$1$1(this.$this_apply, this.$scope, this.$it, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        Object obj2;
        Function3<CoroutineScope, View, Continuation<? super Unit>, Object> b16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Iterator<T> it = this.$this_apply.getValue().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it.next();
                if (Intrinsics.areEqual(((SpaceEntrance) obj2).getText(), "\u52a8\u4f5c")) {
                    break;
                }
            }
            SpaceEntrance spaceEntrance = (SpaceEntrance) obj2;
            if (spaceEntrance != null && (b16 = spaceEntrance.b()) != null) {
                CoroutineScope coroutineScope = this.$scope;
                View view = this.$it;
                this.label = 1;
                if (b16.invoke(coroutineScope, view, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SpaceEntrance$Companion$generateSource$4$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
