package com.tencent.mobileqq.wink.newalbum.processor.mediascan;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00020\u0001H\u008a@"}, d2 = {"T", "Lkotlinx/coroutines/flow/FlowCollector;", "", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.newalbum.processor.mediascan.WinkNewAlbumMediaScanProcessor$chunked$1", f = "WinkNewAlbumMediaScanProcessor.kt", i = {0, 0}, l = {312, 176}, m = "invokeSuspend", n = {"$this$flow", "buffer"}, s = {"L$0", "L$1"})
/* loaded from: classes21.dex */
final class WinkNewAlbumMediaScanProcessor$chunked$1<T> extends SuspendLambda implements Function2<FlowCollector<? super List<? extends T>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $size;
    final /* synthetic */ Flow<T> $this_chunked;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WinkNewAlbumMediaScanProcessor$chunked$1(Flow<? extends T> flow, int i3, Continuation<? super WinkNewAlbumMediaScanProcessor$chunked$1> continuation) {
        super(2, continuation);
        this.$this_chunked = flow;
        this.$size = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        WinkNewAlbumMediaScanProcessor$chunked$1 winkNewAlbumMediaScanProcessor$chunked$1 = new WinkNewAlbumMediaScanProcessor$chunked$1(this.$this_chunked, this.$size, continuation);
        winkNewAlbumMediaScanProcessor$chunked$1.L$0 = obj;
        return winkNewAlbumMediaScanProcessor$chunked$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        FlowCollector flowCollector;
        List arrayList;
        List list;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            arrayList = (List) this.L$1;
            flowCollector = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            flowCollector = (FlowCollector) this.L$0;
            arrayList = new ArrayList();
            Flow<T> flow = this.$this_chunked;
            WinkNewAlbumMediaScanProcessor$chunked$1$invokeSuspend$$inlined$collect$1 winkNewAlbumMediaScanProcessor$chunked$1$invokeSuspend$$inlined$collect$1 = new WinkNewAlbumMediaScanProcessor$chunked$1$invokeSuspend$$inlined$collect$1(arrayList, this.$size, flowCollector);
            this.L$0 = flowCollector;
            this.L$1 = arrayList;
            this.label = 1;
            if (flow.collect(winkNewAlbumMediaScanProcessor$chunked$1$invokeSuspend$$inlined$collect$1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        if (!arrayList.isEmpty()) {
            list = CollectionsKt___CollectionsKt.toList(arrayList);
            this.L$0 = null;
            this.L$1 = null;
            this.label = 2;
            if (flowCollector.emit(list, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super List<? extends T>> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkNewAlbumMediaScanProcessor$chunked$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
