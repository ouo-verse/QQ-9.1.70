package com.tencent.mobileqq.wink.editor.music.viewmodel;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel$doPlayerActionAsync$1", f = "MusicSourceViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MusicSourceViewModel$doPlayerActionAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $callFunctionName;
    final /* synthetic */ Function0<Unit> $playerAction;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MusicSourceViewModel$doPlayerActionAsync$1(Function0<Unit> function0, String str, Continuation<? super MusicSourceViewModel$doPlayerActionAsync$1> continuation) {
        super(2, continuation);
        this.$playerAction = function0;
        this.$callFunctionName = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MusicSourceViewModel$doPlayerActionAsync$1(this.$playerAction, this.$callFunctionName, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object obj2;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            obj2 = MusicSourceViewModel.f321160w0;
            Function0<Unit> function0 = this.$playerAction;
            String str = this.$callFunctionName;
            synchronized (obj2) {
                try {
                    function0.invoke();
                } catch (Exception e16) {
                    w53.b.d("MusicSourceViewModel", str + " exception", e16);
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MusicSourceViewModel$doPlayerActionAsync$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
