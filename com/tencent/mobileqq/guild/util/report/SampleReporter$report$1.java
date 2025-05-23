package com.tencent.mobileqq.guild.util.report;

import com.tencent.mobileqq.qqguildsdk.tianjige.GuildHistogramScene;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.util.report.SampleReporter$report$1", f = "SampleReporter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class SampleReporter$report$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ HashMap<Pair<GuildHistogramScene, String>, Float> $clonedMap;
    int label;
    final /* synthetic */ SampleReporter this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SampleReporter$report$1(HashMap<Pair<GuildHistogramScene, String>, Float> hashMap, SampleReporter sampleReporter, Continuation<? super SampleReporter$report$1> continuation) {
        super(2, continuation);
        this.$clonedMap = hashMap;
        this.this$0 = sampleReporter;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SampleReporter$report$1(this.$clonedMap, this.this$0, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x004f, code lost:
    
        r2 = r4.this$0.reportCallback;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        c cVar;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            QLog.i("GuildAioSampleReporter", 1, "report: map size: " + this.$clonedMap.size());
            Set<Pair<GuildHistogramScene, String>> keySet = this.$clonedMap.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "clonedMap.keys");
            for (Pair<GuildHistogramScene, String> pair : keySet) {
                Float f16 = this.$clonedMap.get(pair);
                if (f16 != null && cVar != null) {
                    cVar.c(pair.getFirst(), pair.getSecond(), f16.floatValue());
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SampleReporter$report$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
