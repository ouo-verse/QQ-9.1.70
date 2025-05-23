package com.tencent.mobileqq.guild.feed.api.impl;

import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.feed.api.SharePublishGuildFeedParam;
import com.tencent.mobileqq.guild.feed.event.FeedEditorEvent;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/event/FeedEditorEvent$OnStartPublishFeedEvent;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.api.impl.GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1$run$2", f = "GuildShareToFeedApiImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1$run$2 extends SuspendLambda implements Function2<FeedEditorEvent.OnStartPublishFeedEvent, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $guildId;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildFeedLauncherHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1$run$2(String str, GuildFeedLauncherHelper guildFeedLauncherHelper, Continuation<? super GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1$run$2> continuation) {
        super(2, continuation);
        this.$guildId = str;
        this.this$0 = guildFeedLauncherHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(GuildFeedLauncherHelper guildFeedLauncherHelper) {
        WeakReference weakReference;
        weakReference = guildFeedLauncherHelper.shareResultListenerRef;
        com.tencent.mobileqq.guild.feed.api.g gVar = (com.tencent.mobileqq.guild.feed.api.g) weakReference.get();
        if (gVar != null) {
            gVar.a(true);
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1$run$2 guildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1$run$2 = new GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1$run$2(this.$guildId, this.this$0, continuation);
        guildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1$run$2.L$0 = obj;
        return guildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1$run$2;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull FeedEditorEvent.OnStartPublishFeedEvent onStartPublishFeedEvent, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1$run$2) create(onStartPublishFeedEvent, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        SharePublishGuildFeedParam sharePublishGuildFeedParam;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            FeedEditorEvent.OnStartPublishFeedEvent onStartPublishFeedEvent = (FeedEditorEvent.OnStartPublishFeedEvent) this.L$0;
            Logger.f235387a.d().i("GuildFeedLauncherHelper", 1, "OnStartPublishFeedEvent: " + onStartPublishFeedEvent.getRequestId());
            ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).saveRecentForwardGuildRecord(this.$guildId);
            this.this$0.s();
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final GuildFeedLauncherHelper guildFeedLauncherHelper = this.this$0;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.api.impl.p
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedLauncherHelper$saveGuildRecordAfterPublish$transaction$1$run$2.b(GuildFeedLauncherHelper.this);
                }
            });
            GuildFeedLauncherHelper guildFeedLauncherHelper2 = this.this$0;
            sharePublishGuildFeedParam = guildFeedLauncherHelper2.shareParam;
            guildFeedLauncherHelper2.q(sharePublishGuildFeedParam);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
