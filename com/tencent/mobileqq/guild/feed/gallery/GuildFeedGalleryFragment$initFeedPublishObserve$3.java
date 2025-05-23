package com.tencent.mobileqq.guild.feed.gallery;

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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u008a@"}, d2 = {"Lkn1/a$b;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.gallery.GuildFeedGalleryFragment$initFeedPublishObserve$3", f = "GuildFeedGalleryFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildFeedGalleryFragment$initFeedPublishObserve$3 extends SuspendLambda implements Function2<a.FeedPublishFinish, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildFeedGalleryFragment this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedGalleryFragment$initFeedPublishObserve$3(GuildFeedGalleryFragment guildFeedGalleryFragment, Continuation<? super GuildFeedGalleryFragment$initFeedPublishObserve$3> continuation) {
        super(2, continuation);
        this.this$0 = guildFeedGalleryFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildFeedGalleryFragment$initFeedPublishObserve$3 guildFeedGalleryFragment$initFeedPublishObserve$3 = new GuildFeedGalleryFragment$initFeedPublishObserve$3(this.this$0, continuation);
        guildFeedGalleryFragment$initFeedPublishObserve$3.L$0 = obj;
        return guildFeedGalleryFragment$initFeedPublishObserve$3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.handlePublishEnd((a.FeedPublishFinish) this.L$0);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull a.FeedPublishFinish feedPublishFinish, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildFeedGalleryFragment$initFeedPublishObserve$3) create(feedPublishFinish, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
