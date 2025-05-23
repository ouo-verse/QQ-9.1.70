package com.tencent.mobileqq.zplan.portal.aigc.view;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlin/sequences/SequenceScope;", "Lkotlin/Pair;", "", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.portal.aigc.view.AigcWatermarkViewKt$circleCoordination$1", f = "AigcWatermarkView.kt", i = {1, 1, 2, 2, 3, 3, 4, 4}, l = {19, 22, 23, 24, 25}, m = "invokeSuspend", n = {"$this$sequence", "i", "$this$sequence", "i", "$this$sequence", "i", "$this$sequence", "i"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0", "L$0", "I$0"})
/* loaded from: classes34.dex */
final class AigcWatermarkViewKt$circleCoordination$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Pair<? extends Integer, ? extends Integer>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $radius;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AigcWatermarkViewKt$circleCoordination$1(int i3, Continuation<? super AigcWatermarkViewKt$circleCoordination$1> continuation) {
        super(2, continuation);
        this.$radius = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AigcWatermarkViewKt$circleCoordination$1 aigcWatermarkViewKt$circleCoordination$1 = new AigcWatermarkViewKt$circleCoordination$1(this.$radius, continuation);
        aigcWatermarkViewKt$circleCoordination$1.L$0 = obj;
        return aigcWatermarkViewKt$circleCoordination$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(SequenceScope<? super Pair<? extends Integer, ? extends Integer>> sequenceScope, Continuation<? super Unit> continuation) {
        return invoke2((SequenceScope<? super Pair<Integer, Integer>>) sequenceScope, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00c5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00e7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0108 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0109  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0109 -> B:9:0x010c). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        SequenceScope sequenceScope;
        int i3;
        int i16;
        AigcWatermarkViewKt$circleCoordination$1 aigcWatermarkViewKt$circleCoordination$1;
        AigcWatermarkViewKt$circleCoordination$1 aigcWatermarkViewKt$circleCoordination$12;
        SequenceScope sequenceScope2;
        Pair pair;
        Pair pair2;
        Pair pair3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i17 = this.label;
        if (i17 == 0) {
            ResultKt.throwOnFailure(obj);
            sequenceScope = (SequenceScope) this.L$0;
            int i18 = this.$radius;
            i3 = 0;
            if (i18 <= 0) {
                Pair pair4 = TuplesKt.to(Boxing.boxInt(0), Boxing.boxInt(0));
                this.label = 1;
                if (sequenceScope.yield(pair4, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                i16 = i18 * 2;
                aigcWatermarkViewKt$circleCoordination$1 = this;
                if (i3 < i16) {
                }
            }
        } else if (i17 == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i17 == 2) {
            i16 = this.I$1;
            i3 = this.I$0;
            sequenceScope2 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            aigcWatermarkViewKt$circleCoordination$12 = this;
            pair3 = TuplesKt.to(Boxing.boxInt(-aigcWatermarkViewKt$circleCoordination$12.$radius), Boxing.boxInt(aigcWatermarkViewKt$circleCoordination$12.$radius - i3));
            aigcWatermarkViewKt$circleCoordination$12.L$0 = sequenceScope2;
            aigcWatermarkViewKt$circleCoordination$12.I$0 = i3;
            aigcWatermarkViewKt$circleCoordination$12.I$1 = i16;
            aigcWatermarkViewKt$circleCoordination$12.label = 3;
            if (sequenceScope2.yield(pair3, aigcWatermarkViewKt$circleCoordination$12) == coroutine_suspended) {
            }
            pair2 = TuplesKt.to(Boxing.boxInt((-aigcWatermarkViewKt$circleCoordination$12.$radius) + i3), Boxing.boxInt(-aigcWatermarkViewKt$circleCoordination$12.$radius));
            aigcWatermarkViewKt$circleCoordination$12.L$0 = sequenceScope2;
            aigcWatermarkViewKt$circleCoordination$12.I$0 = i3;
            aigcWatermarkViewKt$circleCoordination$12.I$1 = i16;
            aigcWatermarkViewKt$circleCoordination$12.label = 4;
            if (sequenceScope2.yield(pair2, aigcWatermarkViewKt$circleCoordination$12) == coroutine_suspended) {
            }
            pair = TuplesKt.to(Boxing.boxInt(aigcWatermarkViewKt$circleCoordination$12.$radius), Boxing.boxInt((-aigcWatermarkViewKt$circleCoordination$12.$radius) + i3));
            aigcWatermarkViewKt$circleCoordination$12.L$0 = sequenceScope2;
            aigcWatermarkViewKt$circleCoordination$12.I$0 = i3;
            aigcWatermarkViewKt$circleCoordination$12.I$1 = i16;
            aigcWatermarkViewKt$circleCoordination$12.label = 5;
            if (sequenceScope2.yield(pair, aigcWatermarkViewKt$circleCoordination$12) != coroutine_suspended) {
            }
        } else if (i17 == 3) {
            i16 = this.I$1;
            i3 = this.I$0;
            sequenceScope2 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            aigcWatermarkViewKt$circleCoordination$12 = this;
            pair2 = TuplesKt.to(Boxing.boxInt((-aigcWatermarkViewKt$circleCoordination$12.$radius) + i3), Boxing.boxInt(-aigcWatermarkViewKt$circleCoordination$12.$radius));
            aigcWatermarkViewKt$circleCoordination$12.L$0 = sequenceScope2;
            aigcWatermarkViewKt$circleCoordination$12.I$0 = i3;
            aigcWatermarkViewKt$circleCoordination$12.I$1 = i16;
            aigcWatermarkViewKt$circleCoordination$12.label = 4;
            if (sequenceScope2.yield(pair2, aigcWatermarkViewKt$circleCoordination$12) == coroutine_suspended) {
            }
            pair = TuplesKt.to(Boxing.boxInt(aigcWatermarkViewKt$circleCoordination$12.$radius), Boxing.boxInt((-aigcWatermarkViewKt$circleCoordination$12.$radius) + i3));
            aigcWatermarkViewKt$circleCoordination$12.L$0 = sequenceScope2;
            aigcWatermarkViewKt$circleCoordination$12.I$0 = i3;
            aigcWatermarkViewKt$circleCoordination$12.I$1 = i16;
            aigcWatermarkViewKt$circleCoordination$12.label = 5;
            if (sequenceScope2.yield(pair, aigcWatermarkViewKt$circleCoordination$12) != coroutine_suspended) {
            }
        } else if (i17 == 4) {
            i16 = this.I$1;
            i3 = this.I$0;
            sequenceScope2 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            aigcWatermarkViewKt$circleCoordination$12 = this;
            pair = TuplesKt.to(Boxing.boxInt(aigcWatermarkViewKt$circleCoordination$12.$radius), Boxing.boxInt((-aigcWatermarkViewKt$circleCoordination$12.$radius) + i3));
            aigcWatermarkViewKt$circleCoordination$12.L$0 = sequenceScope2;
            aigcWatermarkViewKt$circleCoordination$12.I$0 = i3;
            aigcWatermarkViewKt$circleCoordination$12.I$1 = i16;
            aigcWatermarkViewKt$circleCoordination$12.label = 5;
            if (sequenceScope2.yield(pair, aigcWatermarkViewKt$circleCoordination$12) != coroutine_suspended) {
            }
        } else if (i17 == 5) {
            i16 = this.I$1;
            i3 = this.I$0;
            SequenceScope sequenceScope3 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            sequenceScope = sequenceScope3;
            aigcWatermarkViewKt$circleCoordination$1 = this;
            i3++;
            if (i3 < i16) {
                Pair pair5 = TuplesKt.to(Boxing.boxInt(aigcWatermarkViewKt$circleCoordination$1.$radius - i3), Boxing.boxInt(aigcWatermarkViewKt$circleCoordination$1.$radius));
                aigcWatermarkViewKt$circleCoordination$1.L$0 = sequenceScope;
                aigcWatermarkViewKt$circleCoordination$1.I$0 = i3;
                aigcWatermarkViewKt$circleCoordination$1.I$1 = i16;
                aigcWatermarkViewKt$circleCoordination$1.label = 2;
                if (sequenceScope.yield(pair5, aigcWatermarkViewKt$circleCoordination$1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                AigcWatermarkViewKt$circleCoordination$1 aigcWatermarkViewKt$circleCoordination$13 = aigcWatermarkViewKt$circleCoordination$1;
                sequenceScope2 = sequenceScope;
                aigcWatermarkViewKt$circleCoordination$12 = aigcWatermarkViewKt$circleCoordination$13;
                pair3 = TuplesKt.to(Boxing.boxInt(-aigcWatermarkViewKt$circleCoordination$12.$radius), Boxing.boxInt(aigcWatermarkViewKt$circleCoordination$12.$radius - i3));
                aigcWatermarkViewKt$circleCoordination$12.L$0 = sequenceScope2;
                aigcWatermarkViewKt$circleCoordination$12.I$0 = i3;
                aigcWatermarkViewKt$circleCoordination$12.I$1 = i16;
                aigcWatermarkViewKt$circleCoordination$12.label = 3;
                if (sequenceScope2.yield(pair3, aigcWatermarkViewKt$circleCoordination$12) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pair2 = TuplesKt.to(Boxing.boxInt((-aigcWatermarkViewKt$circleCoordination$12.$radius) + i3), Boxing.boxInt(-aigcWatermarkViewKt$circleCoordination$12.$radius));
                aigcWatermarkViewKt$circleCoordination$12.L$0 = sequenceScope2;
                aigcWatermarkViewKt$circleCoordination$12.I$0 = i3;
                aigcWatermarkViewKt$circleCoordination$12.I$1 = i16;
                aigcWatermarkViewKt$circleCoordination$12.label = 4;
                if (sequenceScope2.yield(pair2, aigcWatermarkViewKt$circleCoordination$12) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                pair = TuplesKt.to(Boxing.boxInt(aigcWatermarkViewKt$circleCoordination$12.$radius), Boxing.boxInt((-aigcWatermarkViewKt$circleCoordination$12.$radius) + i3));
                aigcWatermarkViewKt$circleCoordination$12.L$0 = sequenceScope2;
                aigcWatermarkViewKt$circleCoordination$12.I$0 = i3;
                aigcWatermarkViewKt$circleCoordination$12.I$1 = i16;
                aigcWatermarkViewKt$circleCoordination$12.label = 5;
                if (sequenceScope2.yield(pair, aigcWatermarkViewKt$circleCoordination$12) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                SequenceScope sequenceScope4 = sequenceScope2;
                aigcWatermarkViewKt$circleCoordination$1 = aigcWatermarkViewKt$circleCoordination$12;
                sequenceScope = sequenceScope4;
                i3++;
                if (i3 < i16) {
                }
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(SequenceScope<? super Pair<Integer, Integer>> sequenceScope, Continuation<? super Unit> continuation) {
        return ((AigcWatermarkViewKt$circleCoordination$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
