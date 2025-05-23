package com.tencent.mobileqq.guild.aisearch.models.operators;

import com.tencent.mobileqq.guild.aisearch.models.ChatAnswerData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000\u00a8\u0006\u0004"}, d2 = {"Lkotlinx/coroutines/flow/StateFlow;", "Lcom/tencent/mobileqq/guild/aisearch/models/e;", "Lkotlinx/coroutines/flow/Flow;", "a", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class AdaptiveContentEmitKt {
    @NotNull
    public static final Flow<ChatAnswerData> a(@NotNull StateFlow<ChatAnswerData> stateFlow) {
        Intrinsics.checkNotNullParameter(stateFlow, "<this>");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Ref.LongRef longRef = new Ref.LongRef();
        return FlowKt.flow(new AdaptiveContentEmitKt$adaptiveContentEmit$$inlined$transform$1(InterpolateEmitKt.c(stateFlow), null, objectRef, new d(), longRef));
    }
}
