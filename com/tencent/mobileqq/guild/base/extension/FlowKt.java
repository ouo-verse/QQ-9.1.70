package com.tencent.mobileqq.guild.base.extension;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt__ContextKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a.\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u00012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0003\u001a<\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\t\u001a\u00020\b2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00010\nH\u0007\u001a:\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\r\u001a\u00020\b2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000e0\u0003\u00a8\u0006\u0011"}, d2 = {"T", "Lkotlinx/coroutines/flow/Flow;", "flow", "Lkotlin/Function1;", "", "observer", "Lkotlinx/coroutines/Job;", "a", "", "timeoutMillis", "Lkotlin/Function0;", "onTimeout", "c", "duration", "", "predict", "b", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlowKt {
    @NotNull
    public static final <T> Job a(@NotNull Flow<? extends T> flow, @NotNull Function1<? super T, Unit> observer) {
        Job launch$default;
        Intrinsics.checkNotNullParameter(flow, "flow");
        Intrinsics.checkNotNullParameter(observer, "observer");
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new FlowKt$collectFlow$1(flow, observer, null), 3, null);
        return launch$default;
    }

    @NotNull
    public static final <T> Flow<T> b(@NotNull Flow<? extends T> flow, long j3, @NotNull Function1<? super T, Boolean> predict) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(predict, "predict");
        return kotlinx.coroutines.flow.FlowKt.transformLatest(flow, new FlowKt$tickLatestItemUntil$2(predict, j3, null));
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public static final <T> Flow<T> c(@NotNull Flow<? extends T> flow, long j3, @NotNull Function0<? extends Flow<? extends T>> onTimeout) {
        Flow<T> buffer$default;
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(onTimeout, "onTimeout");
        buffer$default = FlowKt__ContextKt.buffer$default(kotlinx.coroutines.flow.FlowKt.channelFlow(new FlowKt$withIdleTimeout$2(flow, onTimeout, j3, null)), Integer.MAX_VALUE, null, 2, null);
        return buffer$default;
    }
}
