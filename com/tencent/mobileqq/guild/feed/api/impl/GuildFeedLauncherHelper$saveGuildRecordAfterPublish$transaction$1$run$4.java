package com.tencent.mobileqq.guild.feed.api.impl;

import com.tencent.mobileqq.guild.api.IGuildTransactionManageService;
import com.tencent.mobileqq.guild.feed.event.FeedEditorEvent;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/event/FeedEditorEvent$OnFeedEditorClosedEvent;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.api.impl.GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1$run$4", f = "GuildShareToFeedApiImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1$run$4 extends SuspendLambda implements Function2<FeedEditorEvent.OnFeedEditorClosedEvent, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1 this$0;
    final /* synthetic */ GuildFeedLauncherHelper this$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1$run$4(GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1 guildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1, GuildFeedLauncherHelper guildFeedLauncherHelper, Continuation<? super GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1$run$4> continuation) {
        super(2, continuation);
        this.this$0 = guildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1;
        this.this$1 = guildFeedLauncherHelper;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1$run$4 guildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1$run$4 = new GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1$run$4(this.this$0, this.this$1, continuation);
        guildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1$run$4.L$0 = obj;
        return guildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1$run$4;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull FeedEditorEvent.OnFeedEditorClosedEvent onFeedEditorClosedEvent, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1$run$4) create(onFeedEditorClosedEvent, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        WeakReference weakReference;
        IGuildTransactionManageService iGuildTransactionManageService;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            FeedEditorEvent.OnFeedEditorClosedEvent onFeedEditorClosedEvent = (FeedEditorEvent.OnFeedEditorClosedEvent) this.L$0;
            Logger.f235387a.d().i("GuildFeedLauncherHelper", 1, "OnFeedEditorClosedEvent: " + onFeedEditorClosedEvent.getRequestId());
            AppRuntime Q0 = ch.Q0();
            if (Q0 != null && (iGuildTransactionManageService = (IGuildTransactionManageService) Q0.getRuntimeService(IGuildTransactionManageService.class, "")) != null) {
                iGuildTransactionManageService.removeTransaction(this.this$0.getId());
            }
            if (!onFeedEditorClosedEvent.isTriggerPost()) {
                weakReference = this.this$1.shareResultListenerRef;
                com.tencent.mobileqq.guild.feed.api.g gVar = (com.tencent.mobileqq.guild.feed.api.g) weakReference.get();
                if (gVar != null) {
                    gVar.a(false);
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
