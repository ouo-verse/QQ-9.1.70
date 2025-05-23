package com.tencent.mobileqq.matchfriend.reborn.couple.api.impl;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.matchfriend.reborn.couple.api.impl.QQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMark$3", f = "QQStrangerInteractiveMarkServiceImpl.kt", i = {0, 0}, l = {43}, m = "invokeSuspend", n = {"total", "i"}, s = {"I$0", "I$1"})
/* loaded from: classes33.dex */
final class QQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMark$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $chatType;
    final /* synthetic */ ArrayList<Long> $needReqTinyIds;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    int label;
    final /* synthetic */ QQStrangerInteractiveMarkServiceImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMark$3(ArrayList<Long> arrayList, QQStrangerInteractiveMarkServiceImpl qQStrangerInteractiveMarkServiceImpl, int i3, Continuation<? super QQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMark$3> continuation) {
        super(2, continuation);
        this.$needReqTinyIds = arrayList;
        this.this$0 = qQStrangerInteractiveMarkServiceImpl;
        this.$chatType = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMark$3(this.$needReqTinyIds, this.this$0, this.$chatType, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0078 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x0076 -> B:5:0x0079). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        IntRange until;
        IntProgression step;
        int step2;
        int i3;
        QQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMark$3 qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMark$3;
        int i16;
        int i17;
        Object batchGetInteractiveMarkInner;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i18 = this.label;
        if (i18 != 0) {
            if (i18 == 1) {
                step2 = this.I$3;
                i17 = this.I$2;
                i16 = this.I$1;
                i3 = this.I$0;
                ResultKt.throwOnFailure(obj);
                qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMark$3 = this;
                if (i16 != i17) {
                    i16 += step2;
                    int min = Math.min(i16 + 50, i3);
                    ArrayList arrayList = new ArrayList();
                    arrayList.addAll(qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMark$3.$needReqTinyIds.subList(i16, min));
                    QQStrangerInteractiveMarkServiceImpl qQStrangerInteractiveMarkServiceImpl = qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMark$3.this$0;
                    int i19 = qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMark$3.$chatType;
                    qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMark$3.I$0 = i3;
                    qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMark$3.I$1 = i16;
                    qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMark$3.I$2 = i17;
                    qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMark$3.I$3 = step2;
                    qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMark$3.label = 1;
                    batchGetInteractiveMarkInner = qQStrangerInteractiveMarkServiceImpl.batchGetInteractiveMarkInner(i19, arrayList, qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMark$3);
                    if (batchGetInteractiveMarkInner == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    if (i16 != i17) {
                    }
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        int size = this.$needReqTinyIds.size();
        until = RangesKt___RangesKt.until(0, size);
        step = RangesKt___RangesKt.step(until, 50);
        int first = step.getFirst();
        int last = step.getLast();
        step2 = step.getStep();
        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
            i3 = size;
            qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMark$3 = this;
            i16 = first;
            i17 = last;
            int min2 = Math.min(i16 + 50, i3);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMark$3.$needReqTinyIds.subList(i16, min2));
            QQStrangerInteractiveMarkServiceImpl qQStrangerInteractiveMarkServiceImpl2 = qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMark$3.this$0;
            int i192 = qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMark$3.$chatType;
            qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMark$3.I$0 = i3;
            qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMark$3.I$1 = i16;
            qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMark$3.I$2 = i17;
            qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMark$3.I$3 = step2;
            qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMark$3.label = 1;
            batchGetInteractiveMarkInner = qQStrangerInteractiveMarkServiceImpl2.batchGetInteractiveMarkInner(i192, arrayList2, qQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMark$3);
            if (batchGetInteractiveMarkInner == coroutine_suspended) {
            }
            if (i16 != i17) {
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((QQStrangerInteractiveMarkServiceImpl$batchGetInteractiveMark$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
