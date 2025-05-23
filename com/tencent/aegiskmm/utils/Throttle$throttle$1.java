package com.tencent.aegiskmm.utils;

import com.tencent.kuikly.core.coroutines.BuildersKt;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.coroutines.e;
import com.tencent.kuikly.core.timer.TimerKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes37.dex */
public final class Throttle$throttle$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1 $action;
    final /* synthetic */ e $coroutineScope;
    final /* synthetic */ int $delayMillis;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Throttle$throttle$1(int i3, e eVar, Function1 function1) {
        super(0);
        this.$delayMillis = i3;
        this.$coroutineScope = eVar;
        this.$action = function1;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        String str;
        Throttle throttle = Throttle.f61800b;
        str = Throttle.timeOutRef;
        if (str != null) {
            TimerKt.b(str);
        }
        Throttle.timeOutRef = TimerKt.d(this.$delayMillis, new Function0<Unit>() { // from class: com.tencent.aegiskmm.utils.Throttle$throttle$1.2

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: P */
            @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\u008a@\u00a2\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/tencent/kuikly/core/coroutines/b;", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "<anonymous>"}, k = 3, mv = {1, 4, 1})
            @DebugMetadata(c = "com.tencent.aegiskmm.utils.Throttle$throttle$1$2$1", f = "throttle.kt", i = {}, l = {24}, m = "invokeSuspend", n = {}, s = {})
            /* renamed from: com.tencent.aegiskmm.utils.Throttle$throttle$1$2$1, reason: invalid class name */
            /* loaded from: classes37.dex */
            public static final class AnonymousClass1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
                int label;

                AnonymousClass1(Continuation continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
                    Intrinsics.checkNotNullParameter(completion, "completion");
                    return new AnonymousClass1(completion);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    Object coroutine_suspended;
                    coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i3 = this.label;
                    if (i3 == 0) {
                        ResultKt.throwOnFailure(obj);
                        Function1 function1 = Throttle$throttle$1.this.$action;
                        this.label = 1;
                        if (function1.invoke(this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else if (i3 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return Unit.INSTANCE;
                }
            }

            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                BuildersKt.e(Throttle$throttle$1.this.$coroutineScope, null, null, new AnonymousClass1(null), 3, null);
            }
        });
    }
}
