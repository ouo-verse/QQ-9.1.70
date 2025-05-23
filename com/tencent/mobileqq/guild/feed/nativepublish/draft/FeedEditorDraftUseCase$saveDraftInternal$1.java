package com.tencent.mobileqq.guild.feed.nativepublish.draft;

import cm1.a;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.feed.nativeinterface.kt.GProStFeedKt;
import com.tencent.mobileqq.guild.feed.publish.publishV2.IFeedDraftServiceV2;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildFeedDraft;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import yl1.n;
import zl1.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativepublish.draft.FeedEditorDraftUseCase$saveDraftInternal$1", f = "FeedEditorDraftUseCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class FeedEditorDraftUseCase$saveDraftInternal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $draftId;
    final /* synthetic */ a.MakeJsonMsgResult $draftResult;
    final /* synthetic */ int $draftType;
    int label;
    final /* synthetic */ FeedEditorDraftUseCase this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedEditorDraftUseCase$saveDraftInternal$1(String str, int i3, FeedEditorDraftUseCase feedEditorDraftUseCase, a.MakeJsonMsgResult makeJsonMsgResult, Continuation<? super FeedEditorDraftUseCase$saveDraftInternal$1> continuation) {
        super(2, continuation);
        this.$draftId = str;
        this.$draftType = i3;
        this.this$0 = feedEditorDraftUseCase;
        this.$draftResult = makeJsonMsgResult;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new FeedEditorDraftUseCase$saveDraftInternal$1(this.$draftId, this.$draftType, this.this$0, this.$draftResult, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        com.tencent.base.api.runtime.a aVar;
        Object m476constructorimpl;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Object obj2 = null;
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
                String str = this.$draftId;
                int i3 = this.$draftType;
                aVar = this.this$0.context;
                String draftKey = ((zl1.a) aVar.h()).getDraftKey();
                GProGuildFeedDraft gProGuildFeedDraft = new GProGuildFeedDraft();
                a.MakeJsonMsgResult makeJsonMsgResult = this.$draftResult;
                gProGuildFeedDraft.draftUpdateTimeSec = System.currentTimeMillis() / 1000;
                Intrinsics.checkNotNull(makeJsonMsgResult);
                gProGuildFeedDraft.expandJsonStr = makeJsonMsgResult.getFeedJson();
                try {
                    Result.Companion companion = Result.INSTANCE;
                    JSONObject feedJSONObject = makeJsonMsgResult.getFeedJSONObject();
                    GProStFeedKt gProStFeedKt = GProStFeedKt.f221782a;
                    String optString = feedJSONObject.optString("contentJsonFeed");
                    Intrinsics.checkNotNullExpressionValue(optString, "feedJsonObj.optString(\"contentJsonFeed\")");
                    m476constructorimpl = Result.m476constructorimpl(GProStFeedKt.b(gProStFeedKt, optString, true, null, null, 8, null));
                } catch (Throwable th5) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                }
                if (!Result.m482isFailureimpl(m476constructorimpl)) {
                    obj2 = m476constructorimpl;
                }
                GProStFeed gProStFeed = (GProStFeed) obj2;
                if (gProStFeed == null) {
                    gProStFeed = new GProStFeed();
                }
                gProGuildFeedDraft.draftFeed = gProStFeed;
                Unit unit = Unit.INSTANCE;
                iFeedDraftServiceV2.setFeedDraft(str, i3, draftKey, gProGuildFeedDraft);
            }
            final FeedEditorDraftUseCase feedEditorDraftUseCase = this.this$0;
            n.h("ReportSaveDraft", 1000L, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.draft.FeedEditorDraftUseCase$saveDraftInternal$1.2
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    com.tencent.base.api.runtime.a aVar2;
                    com.tencent.base.api.runtime.a aVar3;
                    String str2;
                    com.tencent.base.api.runtime.a aVar4;
                    aVar2 = FeedEditorDraftUseCase.this.context;
                    String h16 = ((zl1.a) aVar2.h()).h();
                    aVar3 = FeedEditorDraftUseCase.this.context;
                    Object h17 = aVar3.h();
                    Intrinsics.checkNotNullExpressionValue(h17, "context.baseParam");
                    Long f16 = b.f((zl1.a) h17);
                    if (f16 == null || (str2 = f16.toString()) == null) {
                        str2 = "";
                    }
                    aVar4 = FeedEditorDraftUseCase.this.context;
                    a.d(h16, true, str2, ((zl1.a) aVar4.h()).getFeedId());
                }
            });
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedEditorDraftUseCase$saveDraftInternal$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
