package com.tencent.mobileqq.guild.feed.nativedetail.content.model;

import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishInfo;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import kn1.FeedPublishStateV2;
import kn1.a;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkn1/a$b;", "publishState", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativedetail.content.model.DetailMainViewModel$observePublishEndFlow$2", f = "DetailMainViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class DetailMainViewModel$observePublishEndFlow$2 extends SuspendLambda implements Function2<a.FeedPublishFinish, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ DetailMainViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetailMainViewModel$observePublishEndFlow$2(DetailMainViewModel detailMainViewModel, Continuation<? super DetailMainViewModel$observePublishEndFlow$2> continuation) {
        super(2, continuation);
        this.this$0 = detailMainViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DetailMainViewModel$observePublishEndFlow$2 detailMainViewModel$observePublishEndFlow$2 = new DetailMainViewModel$observePublishEndFlow$2(this.this$0, continuation);
        detailMainViewModel$observePublishEndFlow$2.L$0 = obj;
        return detailMainViewModel$observePublishEndFlow$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IPartHost iPartHost;
        IPartHost iPartHost2;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            FeedPublishStateV2 state = ((a.FeedPublishFinish) this.L$0).getState();
            GProStFeed stFeed = state.getStFeed();
            GuildFeedPublishInfo a16 = com.tencent.mobileqq.guild.feed.feedsquare.data.g.a(state.getTaskState(), com.tencent.mobileqq.guild.feed.nativeinterface.kt.a.j(stFeed));
            GuildSplitViewUtils guildSplitViewUtils = GuildSplitViewUtils.f235370a;
            iPartHost = this.this$0.partHost;
            guildSplitViewUtils.E(iPartHost, "guild_feed_publish_info", a16);
            if (kn1.c.c(state.getTaskState())) {
                iPartHost2 = this.this$0.partHost;
                guildSplitViewUtils.E(iPartHost2, "feed_id", stFeed.idd);
                DetailMainViewModel.z2(this.this$0, stFeed, 0, "", true, stFeed.meta.lastModifiedTime, null, 32, null);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull a.FeedPublishFinish feedPublishFinish, @Nullable Continuation<? super Unit> continuation) {
        return ((DetailMainViewModel$observePublishEndFlow$2) create(feedPublishFinish, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
