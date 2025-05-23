package com.tencent.mobileqq.guild.discoveryv2.content.model;

import com.tencent.mobileqq.guild.discoveryv2.net.DataType;
import com.tencent.mobileqq.guild.discoveryv2.net.NetTransaction;
import com.tencent.mobileqq.qqguildsdk.data.genc.bg;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0006\u001a\u00020\u0005*\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\u00030\u00010\u00002\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\b\u0001\u0012\u00020\u00030\u0001H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/mobileqq/guild/discoveryv2/net/h;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/bg;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/model/a;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.discoveryv2.content.model.CategoryTabViewModel$pullToRefreshFromServer$1", f = "CategoryTabViewModel.kt", i = {0}, l = {107}, m = "invokeSuspend", n = {"it"}, s = {"L$0"})
/* loaded from: classes13.dex */
final class CategoryTabViewModel$pullToRefreshFromServer$1 extends SuspendLambda implements Function3<FlowCollector<? super NetTransaction<bg, ? extends a>>, NetTransaction<bg, ? extends a>, Continuation<? super Boolean>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CategoryTabViewModel$pullToRefreshFromServer$1(Continuation<? super CategoryTabViewModel$pullToRefreshFromServer$1> continuation) {
        super(3, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        NetTransaction netTransaction;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        boolean z16 = true;
        if (i3 != 0) {
            if (i3 == 1) {
                netTransaction = (NetTransaction) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            NetTransaction netTransaction2 = (NetTransaction) this.L$1;
            this.L$0 = netTransaction2;
            this.label = 1;
            if (flowCollector.emit(netTransaction2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            netTransaction = netTransaction2;
        }
        if (netTransaction.d() == DataType.NET) {
            z16 = false;
        }
        return Boxing.boxBoolean(z16);
    }

    @Override // kotlin.jvm.functions.Function3
    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super NetTransaction<bg, ? extends a>> flowCollector, @NotNull NetTransaction<bg, ? extends a> netTransaction, @Nullable Continuation<? super Boolean> continuation) {
        CategoryTabViewModel$pullToRefreshFromServer$1 categoryTabViewModel$pullToRefreshFromServer$1 = new CategoryTabViewModel$pullToRefreshFromServer$1(continuation);
        categoryTabViewModel$pullToRefreshFromServer$1.L$0 = flowCollector;
        categoryTabViewModel$pullToRefreshFromServer$1.L$1 = netTransaction;
        return categoryTabViewModel$pullToRefreshFromServer$1.invokeSuspend(Unit.INSTANCE);
    }
}
