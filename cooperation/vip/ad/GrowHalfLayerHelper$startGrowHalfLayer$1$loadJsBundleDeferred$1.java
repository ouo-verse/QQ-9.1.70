package cooperation.vip.ad;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "cooperation.vip.ad.GrowHalfLayerHelper$startGrowHalfLayer$1$loadJsBundleDeferred$1", f = "GrowHalfLayerHelper.kt", i = {}, l = {143}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes28.dex */
final class GrowHalfLayerHelper$startGrowHalfLayer$1$loadJsBundleDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ GrowHalfLayerInfo $growHalfLayerInfo;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GrowHalfLayerHelper$startGrowHalfLayer$1$loadJsBundleDeferred$1(GrowHalfLayerInfo growHalfLayerInfo, Continuation<? super GrowHalfLayerHelper$startGrowHalfLayer$1$loadJsBundleDeferred$1> continuation) {
        super(2, continuation);
        this.$growHalfLayerInfo = growHalfLayerInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GrowHalfLayerHelper$startGrowHalfLayer$1$loadJsBundleDeferred$1(this.$growHalfLayerInfo, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            GrowHalfLayerHelper growHalfLayerHelper = GrowHalfLayerHelper.f391021a;
            GrowHalfLayerInfo growHalfLayerInfo = this.$growHalfLayerInfo;
            this.label = 1;
            obj = growHalfLayerHelper.k(growHalfLayerInfo, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Integer> continuation) {
        return ((GrowHalfLayerHelper$startGrowHalfLayer$1$loadJsBundleDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
