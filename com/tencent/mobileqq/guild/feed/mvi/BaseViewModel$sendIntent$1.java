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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Incorrect field signature: TI; */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0006\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\b\b\u0001\u0010\u0003*\u00020\u0002*\u00020\u0004H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/mvi/b;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/guild/feed/mvi/c;", "I", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.mvi.BaseViewModel$sendIntent$1", f = "BaseViewModel.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class BaseViewModel$sendIntent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ c $i;
    int label;
    final /* synthetic */ BaseViewModel<S, I> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Incorrect types in method signature: (Lcom/tencent/mobileqq/guild/feed/mvi/BaseViewModel<TS;TI;>;TI;Lkotlin/coroutines/Continuation<-Lcom/tencent/mobileqq/guild/feed/mvi/BaseViewModel$sendIntent$1;>;)V */
    public BaseViewModel$sendIntent$1(BaseViewModel baseViewModel, c cVar, Continuation continuation) {
        super(2, continuation);
        this.this$0 = baseViewModel;
        this.$i = cVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new BaseViewModel$sendIntent$1(this.this$0, this.$i, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Channel T1;
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
            T1 = this.this$0.T1();
            c cVar = this.$i;
            this.label = 1;
            if (T1.send(cVar, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((BaseViewModel$sendIntent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
