package com.tencent.mobileqq.guild.feed.nativepublish.draft;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.FeedEditorDraftUseCaseMsgIntent;
import com.tencent.mobileqq.guild.feed.publish.publishV2.IFeedDraftServiceV2;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildFeedDraft;
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
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativepublish.draft.FeedEditorDraftUseCase$queryLastDraft$1", f = "FeedEditorDraftUseCase.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class FeedEditorDraftUseCase$queryLastDraft$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FeedEditorDraftUseCase this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedEditorDraftUseCase$queryLastDraft$1(FeedEditorDraftUseCase feedEditorDraftUseCase, Continuation<? super FeedEditorDraftUseCase$queryLastDraft$1> continuation) {
        super(2, continuation);
        this.this$0 = feedEditorDraftUseCase;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FeedEditorDraftUseCase$queryLastDraft$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        GProGuildFeedDraft gProGuildFeedDraft;
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        com.tencent.base.api.runtime.a aVar;
        com.tencent.base.api.runtime.a aVar2;
        com.tencent.base.api.runtime.a aVar3;
        com.tencent.base.api.runtime.a aVar4;
        com.tencent.base.api.runtime.a aVar5;
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
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            gProGuildFeedDraft = null;
            if (peekAppRuntime instanceof AppInterface) {
                appInterface = (AppInterface) peekAppRuntime;
            } else {
                appInterface = null;
            }
            if (appInterface != null) {
                iRuntimeService = appInterface.getRuntimeService(IFeedDraftServiceV2.class, "");
            } else {
                iRuntimeService = null;
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
                String draftKey = ((zl1.a) aVar3.h()).getDraftKey();
                this.label = 1;
                obj = iFeedDraftServiceV2.getFeedDraft(a16, b16, draftKey, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            aVar4 = this.this$0.context;
            aVar4.e().h(new FeedEditorDraftUseCaseMsgIntent.OnDraftResponseMsgIntent(gProGuildFeedDraft));
            FeedEditorDraftUseCase feedEditorDraftUseCase = this.this$0;
            aVar5 = feedEditorDraftUseCase.context;
            feedEditorDraftUseCase.f(aVar5, gProGuildFeedDraft);
            return Unit.INSTANCE;
        }
        gProGuildFeedDraft = (GProGuildFeedDraft) obj;
        aVar4 = this.this$0.context;
        aVar4.e().h(new FeedEditorDraftUseCaseMsgIntent.OnDraftResponseMsgIntent(gProGuildFeedDraft));
        FeedEditorDraftUseCase feedEditorDraftUseCase2 = this.this$0;
        aVar5 = feedEditorDraftUseCase2.context;
        feedEditorDraftUseCase2.f(aVar5, gProGuildFeedDraft);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedEditorDraftUseCase$queryLastDraft$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
