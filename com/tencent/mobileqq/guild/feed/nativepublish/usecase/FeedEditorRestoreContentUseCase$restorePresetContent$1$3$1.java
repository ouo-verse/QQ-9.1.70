package com.tencent.mobileqq.guild.feed.nativepublish.usecase;

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
import om1.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativepublish.usecase.FeedEditorRestoreContentUseCase$restorePresetContent$1$3$1", f = "FeedEditorRestoreContentUseCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class FeedEditorRestoreContentUseCase$restorePresetContent$1$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ b $box;
    final /* synthetic */ com.tencent.base.api.runtime.a<zl1.a> $context;
    final /* synthetic */ Function0<Unit> $onRestoreContent;
    int label;
    final /* synthetic */ FeedEditorRestoreContentUseCase this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedEditorRestoreContentUseCase$restorePresetContent$1$3$1(FeedEditorRestoreContentUseCase feedEditorRestoreContentUseCase, com.tencent.base.api.runtime.a<zl1.a> aVar, b bVar, Function0<Unit> function0, Continuation<? super FeedEditorRestoreContentUseCase$restorePresetContent$1$3$1> continuation) {
        super(2, continuation);
        this.this$0 = feedEditorRestoreContentUseCase;
        this.$context = aVar;
        this.$box = bVar;
        this.$onRestoreContent = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FeedEditorRestoreContentUseCase$restorePresetContent$1$3$1(this.this$0, this.$context, this.$box, this.$onRestoreContent, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.f(this.$context, this.$box);
            this.$onRestoreContent.invoke();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedEditorRestoreContentUseCase$restorePresetContent$1$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
