package com.tencent.mobileqq.guild.feed.nativepublish.draft;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativepublish.draft.FeedEditorDraftUseCase$startAutoSaveTimer$1", f = "FeedEditorDraftUseCase.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class FeedEditorDraftUseCase$startAutoSaveTimer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    Object L$0;
    int label;
    final /* synthetic */ FeedEditorDraftUseCase this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedEditorDraftUseCase$startAutoSaveTimer$1(FeedEditorDraftUseCase feedEditorDraftUseCase, Continuation<? super FeedEditorDraftUseCase$startAutoSaveTimer$1> continuation) {
        super(2, continuation);
        this.this$0 = feedEditorDraftUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FeedEditorDraftUseCase$startAutoSaveTimer$1(this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0031  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:8:0x0040 -> B:5:0x0043). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        FeedEditorDraftUseCase feedEditorDraftUseCase;
        FeedEditorDraftUseCase$startAutoSaveTimer$1 feedEditorDraftUseCase$startAutoSaveTimer$1;
        int i3;
        int i16;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i17 = this.label;
        if (i17 != 0) {
            if (i17 == 1) {
                i16 = this.I$1;
                i3 = this.I$0;
                feedEditorDraftUseCase = (FeedEditorDraftUseCase) this.L$0;
                ResultKt.throwOnFailure(obj);
                feedEditorDraftUseCase$startAutoSaveTimer$1 = this;
                feedEditorDraftUseCase.j();
                i16++;
                if (i16 < i3) {
                    feedEditorDraftUseCase$startAutoSaveTimer$1.L$0 = feedEditorDraftUseCase;
                    feedEditorDraftUseCase$startAutoSaveTimer$1.I$0 = i3;
                    feedEditorDraftUseCase$startAutoSaveTimer$1.I$1 = i16;
                    feedEditorDraftUseCase$startAutoSaveTimer$1.label = 1;
                    if (DelayKt.delay(60000L, feedEditorDraftUseCase$startAutoSaveTimer$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    feedEditorDraftUseCase.j();
                    i16++;
                    if (i16 < i3) {
                        return Unit.INSTANCE;
                    }
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            feedEditorDraftUseCase = this.this$0;
            feedEditorDraftUseCase$startAutoSaveTimer$1 = this;
            i3 = Integer.MAX_VALUE;
            i16 = 0;
            if (i16 < i3) {
            }
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedEditorDraftUseCase$startAutoSaveTimer$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
