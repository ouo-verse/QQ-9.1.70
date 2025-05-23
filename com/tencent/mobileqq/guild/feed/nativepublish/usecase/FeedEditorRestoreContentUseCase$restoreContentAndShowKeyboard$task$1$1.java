package com.tencent.mobileqq.guild.feed.nativepublish.usecase;

import com.tencent.guild.aio.util.GuildAIODispatchers;
import com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.factory.e;
import com.tencent.mvi.base.route.j;
import com.tencent.qphone.base.util.QLog;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import om1.RestoreInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativepublish.usecase.FeedEditorRestoreContentUseCase$restoreContentAndShowKeyboard$task$1$1", f = "FeedEditorRestoreContentUseCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class FeedEditorRestoreContentUseCase$restoreContentAndShowKeyboard$task$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.tencent.base.api.runtime.a<zl1.a> $context;
    final /* synthetic */ String $feedJson;
    final /* synthetic */ Function1<j, Unit> $howToShowKeyboard;
    final /* synthetic */ int $restoreToolType;
    final /* synthetic */ boolean $shouldFilterIllegalStateTopic;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ FeedEditorRestoreContentUseCase this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FeedEditorRestoreContentUseCase$restoreContentAndShowKeyboard$task$1$1(int i3, String str, com.tencent.base.api.runtime.a<zl1.a> aVar, boolean z16, FeedEditorRestoreContentUseCase feedEditorRestoreContentUseCase, Function1<? super j, Unit> function1, Continuation<? super FeedEditorRestoreContentUseCase$restoreContentAndShowKeyboard$task$1$1> continuation) {
        super(2, continuation);
        this.$restoreToolType = i3;
        this.$feedJson = str;
        this.$context = aVar;
        this.$shouldFilterIllegalStateTopic = z16;
        this.this$0 = feedEditorRestoreContentUseCase;
        this.$howToShowKeyboard = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FeedEditorRestoreContentUseCase$restoreContentAndShowKeyboard$task$1$1 feedEditorRestoreContentUseCase$restoreContentAndShowKeyboard$task$1$1 = new FeedEditorRestoreContentUseCase$restoreContentAndShowKeyboard$task$1$1(this.$restoreToolType, this.$feedJson, this.$context, this.$shouldFilterIllegalStateTopic, this.this$0, this.$howToShowKeyboard, continuation);
        feedEditorRestoreContentUseCase$restoreContentAndShowKeyboard$task$1$1.L$0 = obj;
        return feedEditorRestoreContentUseCase$restoreContentAndShowKeyboard$task$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object m476constructorimpl;
        String stackTraceToString;
        boolean z16;
        Job launch$default;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            int i3 = this.$restoreToolType;
            String str = this.$feedJson;
            com.tencent.base.api.runtime.a<zl1.a> aVar = this.$context;
            boolean z17 = this.$shouldFilterIllegalStateTopic;
            FeedEditorRestoreContentUseCase feedEditorRestoreContentUseCase = this.this$0;
            Function1<j, Unit> function1 = this.$howToShowKeyboard;
            try {
                Result.Companion companion = Result.INSTANCE;
                com.tencent.mobileqq.guild.feed.nativepublish.tool.restore.factory.a a16 = e.f222261a.a(i3);
                JSONObject jSONObject = new JSONObject(str);
                aVar.h().D(jSONObject);
                RestoreInfo restoreInfo = new RestoreInfo(aVar);
                if (z17) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                restoreInfo.e(z16);
                Unit unit = Unit.INSTANCE;
                launch$default = BuildersKt__Builders_commonKt.launch$default(coroutineScope, GuildAIODispatchers.f112358a.e(), null, new FeedEditorRestoreContentUseCase$restoreContentAndShowKeyboard$task$1$1$1$1(aVar, a16.a(jSONObject, restoreInfo), feedEditorRestoreContentUseCase, function1, null), 2, null);
                m476constructorimpl = Result.m476constructorimpl(launch$default);
            } catch (Throwable th5) {
                Result.Companion companion2 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
            }
            com.tencent.base.api.runtime.a<zl1.a> aVar2 = this.$context;
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                String l3 = aVar2.h().l();
                stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(m479exceptionOrNullimpl);
                QLog.e("FeedEditor.RestoreUseCase", 1, "[restoreContentAndShowKeyboard]: " + l3 + ", restore json feed error: " + stackTraceToString);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedEditorRestoreContentUseCase$restoreContentAndShowKeyboard$task$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
