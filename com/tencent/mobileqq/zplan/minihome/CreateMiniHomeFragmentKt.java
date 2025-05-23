package com.tencent.mobileqq.zplan.minihome;

import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u00a8\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lr55/b;", "b", "zplan_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class CreateMiniHomeFragmentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableStateFlow<r55.b[]> b(CoroutineScope coroutineScope) {
        r55.b bVar = new r55.b();
        bVar.f430778a = "\u52a0\u8f7d\u4e2d";
        bVar.f430783f = "#EAEAEA";
        Unit unit = Unit.INSTANCE;
        MutableStateFlow<r55.b[]> MutableStateFlow = StateFlowKt.MutableStateFlow(new r55.b[]{bVar});
        CorountineFunKt.e(coroutineScope, "zplan_CreateMiniHomeFragment_\u62c9\u53d6\u521b\u7a9d", null, null, null, new CreateMiniHomeFragmentKt$generateSource$1(MutableStateFlow, null), 14, null);
        return MutableStateFlow;
    }
}
