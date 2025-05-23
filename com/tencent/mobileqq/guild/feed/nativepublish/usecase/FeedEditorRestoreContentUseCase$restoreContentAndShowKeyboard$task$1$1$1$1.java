package com.tencent.mobileqq.guild.feed.nativepublish.usecase;

import com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditTextMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.mediapreview.FeedEditorMediaMsgIntent;
import com.tencent.mvi.base.route.j;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import om1.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativepublish.usecase.FeedEditorRestoreContentUseCase$restoreContentAndShowKeyboard$task$1$1$1$1", f = "FeedEditorRestoreContentUseCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class FeedEditorRestoreContentUseCase$restoreContentAndShowKeyboard$task$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.base.api.runtime.a<zl1.a> $context;
    final /* synthetic */ Function1<j, Unit> $howToShowKeyboard;
    final /* synthetic */ b $result;
    int label;
    final /* synthetic */ FeedEditorRestoreContentUseCase this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FeedEditorRestoreContentUseCase$restoreContentAndShowKeyboard$task$1$1$1$1(com.tencent.base.api.runtime.a<zl1.a> aVar, b bVar, FeedEditorRestoreContentUseCase feedEditorRestoreContentUseCase, Function1<? super j, Unit> function1, Continuation<? super FeedEditorRestoreContentUseCase$restoreContentAndShowKeyboard$task$1$1$1$1> continuation) {
        super(2, continuation);
        this.$context = aVar;
        this.$result = bVar;
        this.this$0 = feedEditorRestoreContentUseCase;
        this.$howToShowKeyboard = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FeedEditorRestoreContentUseCase$restoreContentAndShowKeyboard$task$1$1$1$1(this.$context, this.$result, this.this$0, this.$howToShowKeyboard, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Unit unit;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            j e16 = this.$context.e();
            b bVar = this.$result;
            com.tencent.base.api.runtime.a<zl1.a> aVar = this.$context;
            FeedEditorRestoreContentUseCase feedEditorRestoreContentUseCase = this.this$0;
            Function1<j, Unit> function1 = this.$howToShowKeyboard;
            e16.h(new GuildFeedEditTextMsgIntent.SetEditText(bVar.getMEditable()));
            e16.h(new FeedEditorMediaMsgIntent.InitMediaList(bVar.b(), aVar.h().getMediaLockSize()));
            feedEditorRestoreContentUseCase.e(aVar, bVar);
            if (function1 != null) {
                Intrinsics.checkNotNullExpressionValue(e16, "this");
                function1.invoke(e16);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                e16.h(GuildFeedEditTextMsgIntent.ShowKeyboard.f221846d);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedEditorRestoreContentUseCase$restoreContentAndShowKeyboard$task$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
