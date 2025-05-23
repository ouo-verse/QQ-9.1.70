package com.tencent.mobileqq.guild.feed.part;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"", "state", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.part.RecyclerViewGifAutoPlayPart$onInitView$1", f = "GifAutoPlayPart.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class RecyclerViewGifAutoPlayPart$onInitView$1 extends SuspendLambda implements Function2<Integer, Continuation<? super Unit>, Object> {
    /* synthetic */ int I$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerViewGifAutoPlayPart$onInitView$1(Continuation<? super RecyclerViewGifAutoPlayPart$onInitView$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RecyclerViewGifAutoPlayPart$onInitView$1 recyclerViewGifAutoPlayPart$onInitView$1 = new RecyclerViewGifAutoPlayPart$onInitView$1(continuation);
        recyclerViewGifAutoPlayPart$onInitView$1.I$0 = ((Number) obj).intValue();
        return recyclerViewGifAutoPlayPart$onInitView$1;
    }

    @Nullable
    public final Object invoke(int i3, @Nullable Continuation<? super Unit> continuation) {
        return ((RecyclerViewGifAutoPlayPart$onInitView$1) create(Integer.valueOf(i3), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            int i3 = this.I$0;
            if (i3 == 0) {
                c.d();
            } else if (i3 == 1) {
                c.c();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Integer num, Continuation<? super Unit> continuation) {
        return invoke(num.intValue(), continuation);
    }
}
