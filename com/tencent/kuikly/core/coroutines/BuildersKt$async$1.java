package com.tencent.kuikly.core.coroutines;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@"}, d2 = {"T", "Lcom/tencent/kuikly/core/coroutines/b;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.kuikly.core.coroutines.BuildersKt$async$1", f = "Builders.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class BuildersKt$async$1<T> extends SuspendLambda implements Function2<b, Continuation<? super T>, Object> {
    final /* synthetic */ Function2<b, Continuation<? super T>, Object> $block;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public BuildersKt$async$1(Function2<? super b, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super BuildersKt$async$1> continuation) {
        super(2, continuation);
        this.$block = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BuildersKt$async$1 buildersKt$async$1 = new BuildersKt$async$1(this.$block, continuation);
        buildersKt$async$1.L$0 = obj;
        return buildersKt$async$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super T> continuation) {
        return ((BuildersKt$async$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                b bVar = (b) this.L$0;
                Function2<b, Continuation<? super T>, Object> function2 = this.$block;
                this.label = 1;
                obj = function2.invoke(bVar, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return obj;
        } catch (Throwable th5) {
            BuildersKt.f(th5);
            throw th5;
        }
    }
}
