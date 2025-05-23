package com.tencent.mobileqq.guild.feed.morepanel.handler;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import com.tencent.mobileqq.guild.api.IGuildContentShareApi;
import com.tencent.mobileqq.guild.feed.morepanel.PanelContext;
import com.tencent.mobileqq.guild.feed.morepanel.handler.GenerateFeedSharePictureV2Handler;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.compat.FeedDetailMainDisplayableParser;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchShareUrlRsp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.richframework.thread.RFWThreadManager;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.morepanel.handler.FeedShare2XHSActionHandler$realHandle$1", f = "FeedShare2XHSActionHandler.kt", i = {1, 1, 1}, l = {110, 117, 131, 154}, m = "invokeSuspend", n = {"feedProvider", "stFeed", "feedDataReader"}, s = {"L$1", "L$2", "L$3"})
/* loaded from: classes13.dex */
public final class FeedShare2XHSActionHandler$realHandle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Dialog $dialog;
    final /* synthetic */ boolean $isPublishFail;
    final /* synthetic */ PanelContext<Activity, vk1.b> $panelContext;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedShare2XHSActionHandler$realHandle$1(Dialog dialog, PanelContext<Activity, vk1.b> panelContext, boolean z16, Continuation<? super FeedShare2XHSActionHandler$realHandle$1> continuation) {
        super(2, continuation);
        this.$dialog = dialog;
        this.$panelContext = panelContext;
        this.$isPublishFail = z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(File file, PanelContext panelContext) {
        if (!file.exists()) {
            com.tencent.mobileqq.guild.util.qqui.g.f(1, "\u5206\u4eab\u5931\u8d25\uff0c\u65e0\u6cd5\u5199\u5165\u50a8\u5b58\u5361");
        } else {
            m02.d.f415923a.s((Activity) panelContext.h(), file.getAbsolutePath(), "\u5206\u4eab\u4e00\u7bc7\u817e\u8baf\u9891\u9053\u70ed\u8bae\u5e16\u5b50", "");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FeedShare2XHSActionHandler$realHandle$1 feedShare2XHSActionHandler$realHandle$1 = new FeedShare2XHSActionHandler$realHandle$1(this.$dialog, this.$panelContext, this.$isPublishFail, continuation);
        feedShare2XHSActionHandler$realHandle$1.L$0 = obj;
        return feedShare2XHSActionHandler$realHandle$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c8 A[Catch: all -> 0x0164, TryCatch #0 {all -> 0x0164, blocks: (B:15:0x002c, B:17:0x0128, B:24:0x0044, B:26:0x00b9, B:28:0x00c8, B:30:0x00eb, B:33:0x0149, B:34:0x0151, B:35:0x0152, B:36:0x015a, B:38:0x0052, B:40:0x0083, B:42:0x0088, B:46:0x015b, B:47:0x0163, B:49:0x0064, B:52:0x0070), top: B:2:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0152 A[Catch: all -> 0x0164, TryCatch #0 {all -> 0x0164, blocks: (B:15:0x002c, B:17:0x0128, B:24:0x0044, B:26:0x00b9, B:28:0x00c8, B:30:0x00eb, B:33:0x0149, B:34:0x0151, B:35:0x0152, B:36:0x015a, B:38:0x0052, B:40:0x0083, B:42:0x0088, B:46:0x015b, B:47:0x0163, B:49:0x0064, B:52:0x0070), top: B:2:0x0010 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object m476constructorimpl;
        Throwable m479exceptionOrNullimpl;
        final PanelContext<Activity, vk1.b> panelContext;
        boolean z16;
        Object f16;
        Object f17;
        GProStFeed gProStFeed;
        vk1.a aVar;
        FeedDetailMainDisplayableParser feedDetailMainDisplayableParser;
        boolean isBlank;
        Object i3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i16 = this.label;
        try {
        } catch (Throwable th5) {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 3) {
                        if (i16 == 4) {
                            ResultKt.throwOnFailure(obj);
                            this.$dialog.dismiss();
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    PanelContext<Activity, vk1.b> panelContext2 = (PanelContext) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    panelContext = panelContext2;
                    i3 = obj;
                    final File createCacheFile = ((IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class)).createCacheFile((Bitmap) i3);
                    RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.m
                        @Override // java.lang.Runnable
                        public final void run() {
                            FeedShare2XHSActionHandler$realHandle$1.b(createCacheFile, panelContext);
                        }
                    });
                    m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
                    m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                    if (m479exceptionOrNullimpl != null) {
                        i.e eVar = i.e.f261783e;
                        FeedShare2XHSActionHandler$realHandle$1$2$1 feedShare2XHSActionHandler$realHandle$1$2$1 = new FeedShare2XHSActionHandler$realHandle$1$2$1(m479exceptionOrNullimpl, null);
                        this.L$0 = m476constructorimpl;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 4;
                        if (CorountineFunKt.i(eVar, null, null, feedShare2XHSActionHandler$realHandle$1$2$1, this, 6, null) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    this.$dialog.dismiss();
                    return Unit.INSTANCE;
                }
                FeedDetailMainDisplayableParser feedDetailMainDisplayableParser2 = (FeedDetailMainDisplayableParser) this.L$3;
                GProStFeed gProStFeed2 = (GProStFeed) this.L$2;
                aVar = (vk1.a) this.L$1;
                PanelContext<Activity, vk1.b> panelContext3 = (PanelContext) this.L$0;
                ResultKt.throwOnFailure(obj);
                feedDetailMainDisplayableParser = feedDetailMainDisplayableParser2;
                panelContext = panelContext3;
                f17 = obj;
                gProStFeed = gProStFeed2;
                IGProFetchShareUrlRsp iGProFetchShareUrlRsp = (IGProFetchShareUrlRsp) f17;
                String shareLink = iGProFetchShareUrlRsp.getShareLink();
                Intrinsics.checkNotNullExpressionValue(shareLink, "fetchedCommonInfo.shareLink");
                isBlank = StringsKt__StringsJVMKt.isBlank(shareLink);
                if (isBlank) {
                    long currentTimeMillis = System.currentTimeMillis();
                    IRuntimeService S0 = ch.S0(IGPSService.class, "");
                    Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
                    IGProGuildInfo guildInfo = ((IGPSService) S0).getGuildInfo(String.valueOf(aVar.getGuildId()));
                    if (guildInfo != null) {
                        QLog.i("SPic.FeedShare2XHSActionHandler", 2, "getGuildInfo coast:" + (System.currentTimeMillis() - currentTimeMillis));
                        GenerateFeedSharePictureV2Handler.Companion companion2 = GenerateFeedSharePictureV2Handler.INSTANCE;
                        String shareLink2 = iGProFetchShareUrlRsp.getShareLink();
                        Intrinsics.checkNotNullExpressionValue(shareLink2, "fetchedCommonInfo.shareLink");
                        this.L$0 = panelContext;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 3;
                        i3 = companion2.i(panelContext, guildInfo, gProStFeed, shareLink2, feedDetailMainDisplayableParser, true, this);
                        if (i3 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        final File createCacheFile2 = ((IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class)).createCacheFile((Bitmap) i3);
                        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.m
                            @Override // java.lang.Runnable
                            public final void run() {
                                FeedShare2XHSActionHandler$realHandle$1.b(createCacheFile2, panelContext);
                            }
                        });
                        m476constructorimpl = Result.m476constructorimpl(Unit.INSTANCE);
                        m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                        if (m479exceptionOrNullimpl != null) {
                        }
                        this.$dialog.dismiss();
                        return Unit.INSTANCE;
                    }
                    throw new Exception(" no guildInfo info ");
                }
                throw new Exception(" no share url can't generate code");
            }
            PanelContext<Activity, vk1.b> panelContext4 = (PanelContext) this.L$0;
            ResultKt.throwOnFailure(obj);
            panelContext = panelContext4;
            f16 = obj;
        } else {
            ResultKt.throwOnFailure(obj);
            panelContext = this.$panelContext;
            boolean z17 = this.$isPublishFail;
            Result.Companion companion3 = Result.INSTANCE;
            GuildFeedMorePanelHandlerUtils guildFeedMorePanelHandlerUtils = GuildFeedMorePanelHandlerUtils.f220288a;
            if (z17) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.L$0 = panelContext;
            this.label = 1;
            f16 = GuildFeedMorePanelHandlerUtils.f(guildFeedMorePanelHandlerUtils, panelContext, 0L, z16, this, 1, null);
            if (f16 == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        GProStFeed gProStFeed3 = (GProStFeed) f16;
        if (gProStFeed3 != null) {
            vk1.a aVar2 = new vk1.a(new GProStFeedDetailRspWrapper(gProStFeed3, null, 2, null));
            FeedDetailMainDisplayableParser feedDetailMainDisplayableParser3 = new FeedDetailMainDisplayableParser(aVar2);
            GenerateFeedSharePictureV2Handler.Companion companion4 = GenerateFeedSharePictureV2Handler.INSTANCE;
            this.L$0 = panelContext;
            this.L$1 = aVar2;
            this.L$2 = gProStFeed3;
            this.L$3 = feedDetailMainDisplayableParser3;
            this.label = 2;
            f17 = GenerateFeedSharePictureV2Handler.Companion.f(companion4, aVar2, false, this, 2, null);
            if (f17 == coroutine_suspended) {
                return coroutine_suspended;
            }
            gProStFeed = gProStFeed3;
            aVar = aVar2;
            feedDetailMainDisplayableParser = feedDetailMainDisplayableParser3;
            IGProFetchShareUrlRsp iGProFetchShareUrlRsp2 = (IGProFetchShareUrlRsp) f17;
            String shareLink3 = iGProFetchShareUrlRsp2.getShareLink();
            Intrinsics.checkNotNullExpressionValue(shareLink3, "fetchedCommonInfo.shareLink");
            isBlank = StringsKt__StringsJVMKt.isBlank(shareLink3);
            if (isBlank) {
            }
        } else {
            throw new Exception("no feedInfo info");
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FeedShare2XHSActionHandler$realHandle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
