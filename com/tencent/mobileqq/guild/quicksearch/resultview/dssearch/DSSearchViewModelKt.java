package com.tencent.mobileqq.guild.quicksearch.resultview.dssearch;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a(\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006*\b\u0012\u0004\u0012\u00020\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\b"}, d2 = {"Lkotlinx/coroutines/flow/StateFlow;", "Lcom/tencent/mobileqq/guild/quicksearch/resultview/dssearch/p;", "", WidgetCacheConstellationData.INTERVAL, "", "stepLength", "Lkotlinx/coroutines/flow/Flow;", "a", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class DSSearchViewModelKt {
    @NotNull
    public static final Flow<DSSearchData> a(@NotNull StateFlow<DSSearchData> stateFlow, long j3, int i3) {
        Intrinsics.checkNotNullParameter(stateFlow, "<this>");
        return FlowKt.flow(new DSSearchViewModelKt$slowContentEmit$$inlined$transform$1(stateFlow, null, new Ref.ObjectRef(), new Ref.LongRef(), i3, j3));
    }
}
