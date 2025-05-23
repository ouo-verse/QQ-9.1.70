package com.tencent.mobileqq.guild.feed.nativepublish.draft;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.feed.publish.publishV2.IFeedDraftServiceV2;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import zl1.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativepublish.draft.FeedEditorDraftUseCase$discardDraft$1", f = "FeedEditorDraftUseCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class FeedEditorDraftUseCase$discardDraft$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FeedEditorDraftUseCase this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedEditorDraftUseCase$discardDraft$1(FeedEditorDraftUseCase feedEditorDraftUseCase, Continuation<? super FeedEditorDraftUseCase$discardDraft$1> continuation) {
        super(2, continuation);
        this.this$0 = feedEditorDraftUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FeedEditorDraftUseCase$discardDraft$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        AppInterface appInterface;
        com.tencent.base.api.runtime.a aVar;
        com.tencent.base.api.runtime.a aVar2;
        com.tencent.base.api.runtime.a aVar3;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            IRuntimeService iRuntimeService = null;
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface != null) {
                iRuntimeService = appInterface.getRuntimeService(IFeedDraftServiceV2.class, "");
            }
            IFeedDraftServiceV2 iFeedDraftServiceV2 = (IFeedDraftServiceV2) iRuntimeService;
            if (iFeedDraftServiceV2 != null) {
                aVar = this.this$0.context;
                Object h16 = aVar.h();
                Intrinsics.checkNotNullExpressionValue(h16, "context.baseParam");
                String a16 = b.a((zl1.a) h16);
                aVar2 = this.this$0.context;
                Object h17 = aVar2.h();
                Intrinsics.checkNotNullExpressionValue(h17, "context.baseParam");
                int b16 = b.b((zl1.a) h17);
                aVar3 = this.this$0.context;
                iFeedDraftServiceV2.deleteGuildFeedDraft(a16, b16, ((zl1.a) aVar3.h()).getDraftKey());
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedEditorDraftUseCase$discardDraft$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
