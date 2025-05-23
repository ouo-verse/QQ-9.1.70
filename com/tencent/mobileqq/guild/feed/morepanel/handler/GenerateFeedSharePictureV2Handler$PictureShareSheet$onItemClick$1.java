package com.tencent.mobileqq.guild.feed.morepanel.handler;

import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.mobileqq.guild.feed.morepanel.PanelContext;
import com.tencent.mobileqq.guild.feed.morepanel.handler.GenerateFeedSharePictureV2Handler;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.compat.FeedDetailMainDisplayableParser;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.morepanel.handler.GenerateFeedSharePictureV2Handler$PictureShareSheet$onItemClick$1", f = "GenerateFeedSharePictureV2Handler.kt", i = {}, l = {555, PlayerResources.ViewId.EXTENDED_VIEW_NAME_PLUS_HEAD}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
final class GenerateFeedSharePictureV2Handler$PictureShareSheet$onItemClick$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ GenerateFeedSharePictureV2Handler.PictureShareSheet this$0;
    final /* synthetic */ GenerateFeedSharePictureV2Handler this$1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenerateFeedSharePictureV2Handler$PictureShareSheet$onItemClick$1(GenerateFeedSharePictureV2Handler.PictureShareSheet pictureShareSheet, GenerateFeedSharePictureV2Handler generateFeedSharePictureV2Handler, Continuation<? super GenerateFeedSharePictureV2Handler$PictureShareSheet$onItemClick$1> continuation) {
        super(2, continuation);
        this.this$0 = pictureShareSheet;
        this.this$1 = generateFeedSharePictureV2Handler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GenerateFeedSharePictureV2Handler$PictureShareSheet$onItemClick$1 generateFeedSharePictureV2Handler$PictureShareSheet$onItemClick$1 = new GenerateFeedSharePictureV2Handler$PictureShareSheet$onItemClick$1(this.this$0, this.this$1, continuation);
        generateFeedSharePictureV2Handler$PictureShareSheet$onItemClick$1.L$0 = obj;
        return generateFeedSharePictureV2Handler$PictureShareSheet$onItemClick$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object m476constructorimpl;
        GenerateFeedSharePictureV2Handler generateFeedSharePictureV2Handler;
        String str;
        FeedDetailMainDisplayableParser feedDetailMainDisplayableParser;
        GenerateFeedSharePictureV2Handler.PictureShareSheet pictureShareSheet;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        try {
        } catch (Throwable th5) {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            generateFeedSharePictureV2Handler = (GenerateFeedSharePictureV2Handler) this.L$1;
            pictureShareSheet = (GenerateFeedSharePictureV2Handler.PictureShareSheet) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            GenerateFeedSharePictureV2Handler.PictureShareSheet pictureShareSheet2 = this.this$0;
            generateFeedSharePictureV2Handler = this.this$1;
            Result.Companion companion2 = Result.INSTANCE;
            GenerateFeedSharePictureV2Handler.Companion companion3 = GenerateFeedSharePictureV2Handler.INSTANCE;
            PanelContext<Activity, vk1.b> f16 = pictureShareSheet2.f();
            IGProGuildInfo guildInfo = pictureShareSheet2.getGuildInfo();
            GProStFeed feedInfo = pictureShareSheet2.getFeedInfo();
            str = pictureShareSheet2.shareUrl;
            feedDetailMainDisplayableParser = pictureShareSheet2.feedDataReader;
            this.L$0 = pictureShareSheet2;
            this.L$1 = generateFeedSharePictureV2Handler;
            this.label = 1;
            Object i16 = companion3.i(f16, guildInfo, feedInfo, str, feedDetailMainDisplayableParser, true, this);
            if (i16 == coroutine_suspended) {
                return coroutine_suspended;
            }
            pictureShareSheet = pictureShareSheet2;
            obj = i16;
        }
        generateFeedSharePictureV2Handler.j((Bitmap) obj, pictureShareSheet.getActivity(), 5);
        m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
        Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
        if (m479exceptionOrNullimpl != null) {
            GenerateFeedSharePictureV2Handler.Companion companion4 = GenerateFeedSharePictureV2Handler.INSTANCE;
            this.L$0 = m476constructorimpl;
            this.L$1 = null;
            this.label = 2;
            if (companion4.c(m479exceptionOrNullimpl, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GenerateFeedSharePictureV2Handler$PictureShareSheet$onItemClick$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
