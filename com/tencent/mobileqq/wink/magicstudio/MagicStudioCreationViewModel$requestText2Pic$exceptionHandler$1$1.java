package com.tencent.mobileqq.wink.magicstudio;

import com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel;
import com.tencent.tmassistantbase.common.TMAssistantDownloadErrorCode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel$requestText2Pic$exceptionHandler$1$1", f = "MagicStudioCreationViewModel.kt", i = {}, l = {TMAssistantDownloadErrorCode.DownloadSDKErrorCode_URL_EMPTY}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
final class MagicStudioCreationViewModel$requestText2Pic$exceptionHandler$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Throwable $throwable;
    int label;
    final /* synthetic */ MagicStudioCreationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicStudioCreationViewModel$requestText2Pic$exceptionHandler$1$1(MagicStudioCreationViewModel magicStudioCreationViewModel, Throwable th5, Continuation<? super MagicStudioCreationViewModel$requestText2Pic$exceptionHandler$1$1> continuation) {
        super(2, continuation);
        this.this$0 = magicStudioCreationViewModel;
        this.$throwable = th5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new MagicStudioCreationViewModel$requestText2Pic$exceptionHandler$1$1(this.this$0, this.$throwable, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        MutableSharedFlow mutableSharedFlow;
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
            mutableSharedFlow = this.this$0._event;
            MagicStudioCreationViewModel.b.MakeFail makeFail = new MagicStudioCreationViewModel.b.MakeFail(this.$throwable);
            this.label = 1;
            if (mutableSharedFlow.emit(makeFail, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicStudioCreationViewModel$requestText2Pic$exceptionHandler$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
