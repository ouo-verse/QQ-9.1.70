package com.tencent.mobileqq.guild.feed.api.impl;

import android.view.View;
import com.tencent.mobileqq.guild.feed.api.IFeedSharePreviewApi;
import com.tencent.mobileqq.guild.feed.share.preview.GuildFeedShareNormalPreviewContainer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.api.impl.FeedSharePreviewApiImpl$requestView$1$1", f = "FeedSharePreviewApiImpl.kt", i = {}, l = {73}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class FeedSharePreviewApiImpl$requestView$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ IFeedSharePreviewApi.a<View> $callback;
    final /* synthetic */ GuildFeedShareNormalPreviewContainer $view;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedSharePreviewApiImpl$requestView$1$1(IFeedSharePreviewApi.a<View> aVar, GuildFeedShareNormalPreviewContainer guildFeedShareNormalPreviewContainer, Continuation<? super FeedSharePreviewApiImpl$requestView$1$1> continuation) {
        super(2, continuation);
        this.$callback = aVar;
        this.$view = guildFeedShareNormalPreviewContainer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FeedSharePreviewApiImpl$requestView$1$1 feedSharePreviewApiImpl$requestView$1$1 = new FeedSharePreviewApiImpl$requestView$1$1(this.$callback, this.$view, continuation);
        feedSharePreviewApiImpl$requestView$1$1.L$0 = obj;
        return feedSharePreviewApiImpl$requestView$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        GuildFeedShareNormalPreviewContainer guildFeedShareNormalPreviewContainer;
        IFeedSharePreviewApi.a<View> aVar;
        Throwable th5;
        Object m476constructorimpl;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                aVar = (IFeedSharePreviewApi.a) this.L$1;
                guildFeedShareNormalPreviewContainer = (GuildFeedShareNormalPreviewContainer) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th6) {
                    th5 = th6;
                    Result.Companion companion = Result.INSTANCE;
                    m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                    aVar.onResult(m476constructorimpl);
                    return Unit.INSTANCE;
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            IFeedSharePreviewApi.a<View> aVar2 = this.$callback;
            guildFeedShareNormalPreviewContainer = this.$view;
            try {
                Result.Companion companion2 = Result.INSTANCE;
                this.L$0 = guildFeedShareNormalPreviewContainer;
                this.L$1 = aVar2;
                this.label = 1;
                if (guildFeedShareNormalPreviewContainer.x(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                aVar = aVar2;
            } catch (Throwable th7) {
                aVar = aVar2;
                th5 = th7;
                Result.Companion companion3 = Result.INSTANCE;
                m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
                aVar.onResult(m476constructorimpl);
                return Unit.INSTANCE;
            }
        }
        m476constructorimpl = Result.m476constructorimpl(guildFeedShareNormalPreviewContainer);
        aVar.onResult(m476constructorimpl);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedSharePreviewApiImpl$requestView$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
