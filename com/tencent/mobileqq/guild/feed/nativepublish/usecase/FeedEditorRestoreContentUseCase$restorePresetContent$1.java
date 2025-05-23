package com.tencent.mobileqq.guild.feed.nativepublish.usecase;

import com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.factory.e;
import com.tencent.mobileqq.guild.feed.util.ae;
import com.tencent.qphone.base.util.QLog;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import om1.RestoreInfo;
import om1.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativepublish.usecase.FeedEditorRestoreContentUseCase$restorePresetContent$1", f = "FeedEditorRestoreContentUseCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class FeedEditorRestoreContentUseCase$restorePresetContent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.base.api.runtime.a<zl1.a> $context;
    final /* synthetic */ Function0<Unit> $onRestoreContent;
    final /* synthetic */ String $presetFeedJson;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FeedEditorRestoreContentUseCase this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedEditorRestoreContentUseCase$restorePresetContent$1(String str, com.tencent.base.api.runtime.a<zl1.a> aVar, FeedEditorRestoreContentUseCase feedEditorRestoreContentUseCase, Function0<Unit> function0, Continuation<? super FeedEditorRestoreContentUseCase$restorePresetContent$1> continuation) {
        super(2, continuation);
        this.$presetFeedJson = str;
        this.$context = aVar;
        this.this$0 = feedEditorRestoreContentUseCase;
        this.$onRestoreContent = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FeedEditorRestoreContentUseCase$restorePresetContent$1 feedEditorRestoreContentUseCase$restorePresetContent$1 = new FeedEditorRestoreContentUseCase$restorePresetContent$1(this.$presetFeedJson, this.$context, this.this$0, this.$onRestoreContent, continuation);
        feedEditorRestoreContentUseCase$restorePresetContent$1.L$0 = obj;
        return feedEditorRestoreContentUseCase$restorePresetContent$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object m476constructorimpl;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            String str = this.$presetFeedJson;
            com.tencent.base.api.runtime.a<zl1.a> aVar = this.$context;
            try {
                Result.Companion companion = Result.INSTANCE;
                com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.factory.a a16 = e.f222261a.a(3);
                JSONObject jSONObject = new JSONObject(str);
                aVar.h().D(jSONObject);
                m476constructorimpl = Result.m476constructorimpl(a16.a(jSONObject, new RestoreInfo(aVar)));
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            FeedEditorRestoreContentUseCase feedEditorRestoreContentUseCase = this.this$0;
            com.tencent.base.api.runtime.a<zl1.a> aVar2 = this.$context;
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                QLog.e("FeedEditor.RestoreUseCase", 1, "[restorePresetContent] restoring preset fails, error: " + m479exceptionOrNullimpl);
                feedEditorRestoreContentUseCase.l(aVar2);
            }
            if (Result.m482isFailureimpl(m476constructorimpl)) {
                m476constructorimpl = null;
            }
            b bVar = (b) m476constructorimpl;
            if (bVar != null) {
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, ae.a().e(), null, new FeedEditorRestoreContentUseCase$restorePresetContent$1$3$1(this.this$0, this.$context, bVar, this.$onRestoreContent, null), 2, null);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedEditorRestoreContentUseCase$restorePresetContent$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
