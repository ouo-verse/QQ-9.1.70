package com.tencent.mobileqq.guild.feed.mvi;

import androidx.exifinterface.media.ExifInterface;
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

/* JADX INFO: Add missing generic type declarations: [I] */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u00022\u0006\u0010\u0004\u001a\u00028\u0001H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/mvi/b;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/guild/feed/mvi/c;", "I", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.mvi.BaseViewModel$collectIntent$1", f = "BaseViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class BaseViewModel$collectIntent$1<I> extends SuspendLambda implements Function2<I, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BaseViewModel<S, I> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseViewModel$collectIntent$1(BaseViewModel<S, I> baseViewModel, Continuation<? super BaseViewModel$collectIntent$1> continuation) {
        super(2, continuation);
        this.this$0 = baseViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        BaseViewModel$collectIntent$1 baseViewModel$collectIntent$1 = new BaseViewModel$collectIntent$1(this.this$0, continuation);
        baseViewModel$collectIntent$1.L$0 = obj;
        return baseViewModel$collectIntent$1;
    }

    /* JADX WARN: Incorrect types in method signature: (TI;Lkotlin/coroutines/Continuation<-Lkotlin/Unit;>;)Ljava/lang/Object; */
    @Nullable
    public final Object invoke(@NotNull c cVar, @Nullable Continuation continuation) {
        return ((BaseViewModel$collectIntent$1) create(cVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            c cVar = (c) this.L$0;
            BaseViewModel<S, I> baseViewModel = this.this$0;
            baseViewModel.U1(cVar, baseViewModel.R1());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke((c) obj, (Continuation) continuation);
    }
}
