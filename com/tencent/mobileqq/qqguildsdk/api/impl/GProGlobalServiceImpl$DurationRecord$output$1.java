package com.tencent.mobileqq.qqguildsdk.api.impl;

import com.tencent.mobileqq.qqguildsdk.api.impl.GProGlobalServiceImpl;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequenceScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlin/sequences/SequenceScope;", "Lcom/tencent/mobileqq/qqguildsdk/api/impl/GProGlobalServiceImpl$DurationRecord$a;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.qqguildsdk.api.impl.GProGlobalServiceImpl$DurationRecord$output$1", f = "GProGlobalServiceImpl.kt", i = {0}, l = {179}, m = "invokeSuspend", n = {"$this$sequence"}, s = {"L$0"})
/* loaded from: classes17.dex */
final class GProGlobalServiceImpl$DurationRecord$output$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super GProGlobalServiceImpl.DurationRecord.EventRecord>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.IntRef $index;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GProGlobalServiceImpl.DurationRecord this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GProGlobalServiceImpl$DurationRecord$output$1(Ref.IntRef intRef, GProGlobalServiceImpl.DurationRecord durationRecord, Continuation<? super GProGlobalServiceImpl$DurationRecord$output$1> continuation) {
        super(2, continuation);
        this.$index = intRef;
        this.this$0 = durationRecord;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GProGlobalServiceImpl$DurationRecord$output$1 gProGlobalServiceImpl$DurationRecord$output$1 = new GProGlobalServiceImpl$DurationRecord$output$1(this.$index, this.this$0, continuation);
        gProGlobalServiceImpl$DurationRecord$output$1.L$0 = obj;
        return gProGlobalServiceImpl$DurationRecord$output$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0036  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0052 -> B:5:0x0055). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        SequenceScope sequenceScope;
        GProGlobalServiceImpl$DurationRecord$output$1 gProGlobalServiceImpl$DurationRecord$output$1;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                sequenceScope = (SequenceScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                gProGlobalServiceImpl$DurationRecord$output$1 = this;
                gProGlobalServiceImpl$DurationRecord$output$1.$index.element++;
                if (gProGlobalServiceImpl$DurationRecord$output$1.$index.element < gProGlobalServiceImpl$DurationRecord$output$1.this$0.b().size()) {
                    GProGlobalServiceImpl.DurationRecord.EventRecord valueAt = gProGlobalServiceImpl$DurationRecord$output$1.this$0.b().valueAt(gProGlobalServiceImpl$DurationRecord$output$1.$index.element);
                    Intrinsics.checkNotNullExpressionValue(valueAt, "map.valueAt(index)");
                    gProGlobalServiceImpl$DurationRecord$output$1.L$0 = sequenceScope;
                    gProGlobalServiceImpl$DurationRecord$output$1.label = 1;
                    if (sequenceScope.yield(valueAt, gProGlobalServiceImpl$DurationRecord$output$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    gProGlobalServiceImpl$DurationRecord$output$1.$index.element++;
                    if (gProGlobalServiceImpl$DurationRecord$output$1.$index.element < gProGlobalServiceImpl$DurationRecord$output$1.this$0.b().size()) {
                        return Unit.INSTANCE;
                    }
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            sequenceScope = (SequenceScope) this.L$0;
            gProGlobalServiceImpl$DurationRecord$output$1 = this;
            if (gProGlobalServiceImpl$DurationRecord$output$1.$index.element < gProGlobalServiceImpl$DurationRecord$output$1.this$0.b().size()) {
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull SequenceScope<? super GProGlobalServiceImpl.DurationRecord.EventRecord> sequenceScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GProGlobalServiceImpl$DurationRecord$output$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
