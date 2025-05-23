package com.tencent.mobileqq.guild.feed.morepanel.handler;

import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.feed.morepanel.PanelContext;
import com.tencent.mobileqq.guild.feed.morepanel.handler.GenerateFeedSharePictureV2Handler;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.compat.FeedDetailMainDisplayableParser;
import com.tencent.mobileqq.guild.share.util.GuildActionSheetAttaUtil;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchShareUrlRsp;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.morepanel.handler.GenerateFeedSharePictureV2Handler$realHandle$1$1$1", f = "GenerateFeedSharePictureV2Handler.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class GenerateFeedSharePictureV2Handler$realHandle$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ FeedDetailMainDisplayableParser $feedDataReader;
    final /* synthetic */ vk1.a $feedProvider;
    final /* synthetic */ IGProFetchShareUrlRsp $fetchedCommonInfo;
    final /* synthetic */ IGProGuildInfo $guildInfo;
    final /* synthetic */ PanelContext<Activity, vk1.b> $panelContext;
    final /* synthetic */ GProStFeed $stFeed;
    int label;
    final /* synthetic */ GenerateFeedSharePictureV2Handler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenerateFeedSharePictureV2Handler$realHandle$1$1$1(GenerateFeedSharePictureV2Handler generateFeedSharePictureV2Handler, PanelContext<Activity, vk1.b> panelContext, Bitmap bitmap, FeedDetailMainDisplayableParser feedDetailMainDisplayableParser, IGProGuildInfo iGProGuildInfo, GProStFeed gProStFeed, IGProFetchShareUrlRsp iGProFetchShareUrlRsp, vk1.a aVar, Continuation<? super GenerateFeedSharePictureV2Handler$realHandle$1$1$1> continuation) {
        super(2, continuation);
        this.this$0 = generateFeedSharePictureV2Handler;
        this.$panelContext = panelContext;
        this.$bitmap = bitmap;
        this.$feedDataReader = feedDetailMainDisplayableParser;
        this.$guildInfo = iGProGuildInfo;
        this.$stFeed = gProStFeed;
        this.$fetchedCommonInfo = iGProFetchShareUrlRsp;
        this.$feedProvider = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GenerateFeedSharePictureV2Handler$realHandle$1$1$1(this.this$0, this.$panelContext, this.$bitmap, this.$feedDataReader, this.$guildInfo, this.$stFeed, this.$fetchedCommonInfo, this.$feedProvider, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ShareActionSheet m3;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            m3 = this.this$0.m(this.$panelContext.h(), this.$bitmap, this.$feedDataReader);
            GenerateFeedSharePictureV2Handler generateFeedSharePictureV2Handler = this.this$0;
            PanelContext<Activity, vk1.b> panelContext = this.$panelContext;
            Bitmap bitmap = this.$bitmap;
            IGProGuildInfo iGProGuildInfo = this.$guildInfo;
            GProStFeed gProStFeed = this.$stFeed;
            String shareLink = this.$fetchedCommonInfo.getShareLink();
            Intrinsics.checkNotNullExpressionValue(shareLink, "fetchedCommonInfo.shareLink");
            m3.setItemClickListenerV2(new GenerateFeedSharePictureV2Handler.PictureShareSheet(generateFeedSharePictureV2Handler, panelContext, bitmap, iGProGuildInfo, gProStFeed, shareLink, this.$feedDataReader));
            m3.show();
            GuildActionSheetAttaUtil.p(this.$fetchedCommonInfo, this.$panelContext.getExtra().getInt(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE, GuildSharePageSource.UNKNOWN.ordinal()), String.valueOf(this.$feedProvider.getGuildId()), String.valueOf(this.$feedProvider.getChannelId()), this.$feedProvider.getFeedId());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GenerateFeedSharePictureV2Handler$realHandle$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
