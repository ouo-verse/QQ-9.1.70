package com.tencent.mobileqq.guild.feed.share.preview;

import com.tencent.mobileqq.guild.api.IFeedDetailDataParser;
import com.tencent.mobileqq.widget.RoundImageView;
import kotlin.Metadata;
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
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lri1/a;", "kotlin.jvm.PlatformType", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.share.preview.GuildFeedShareNormalPreviewContainer$buildSingleImageThumbnail$1", f = "GuildFeedShareNormalPreviewContainer.kt", i = {}, l = {173}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class GuildFeedShareNormalPreviewContainer$buildSingleImageThumbnail$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ri1.a>, Object> {
    final /* synthetic */ RoundImageView $imageView;
    final /* synthetic */ IFeedDetailDataParser.MediaInfo $it;
    int label;
    final /* synthetic */ GuildFeedShareNormalPreviewContainer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedShareNormalPreviewContainer$buildSingleImageThumbnail$1(GuildFeedShareNormalPreviewContainer guildFeedShareNormalPreviewContainer, IFeedDetailDataParser.MediaInfo mediaInfo, RoundImageView roundImageView, Continuation<? super GuildFeedShareNormalPreviewContainer$buildSingleImageThumbnail$1> continuation) {
        super(2, continuation);
        this.this$0 = guildFeedShareNormalPreviewContainer;
        this.$it = mediaInfo;
        this.$imageView = roundImageView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildFeedShareNormalPreviewContainer$buildSingleImageThumbnail$1(this.this$0, this.$it, this.$imageView, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
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
            GuildFeedShareNormalPreviewContainer guildFeedShareNormalPreviewContainer = this.this$0;
            String thumbUrl = this.$it.getThumbUrl();
            RoundImageView roundImageView = this.$imageView;
            this.label = 1;
            obj = guildFeedShareNormalPreviewContainer.z(thumbUrl, roundImageView, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super ri1.a> continuation) {
        return ((GuildFeedShareNormalPreviewContainer$buildSingleImageThumbnail$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
