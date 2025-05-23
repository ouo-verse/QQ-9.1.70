package com.tencent.mobileqq.guild.feed.morepanel.handler;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
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
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.morepanel.handler.GenerateFeedSharePictureV2Handler$realHandle$1", f = "GenerateFeedSharePictureV2Handler.kt", i = {0, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3}, l = {357, 362, 369, 376, MsgConstant.KRMFILETHUMBSIZE384, 412}, m = "invokeSuspend", n = {"$this$invokeSuspend_u24lambda_u240", "$this$invokeSuspend_u24lambda_u240", "feedProvider", "stFeed", "feedDataReader", "$this$invokeSuspend_u24lambda_u240", "feedProvider", "stFeed", "feedDataReader", "fetchedCommonInfo", "startTime", "$this$invokeSuspend_u24lambda_u240", "feedProvider", "stFeed", "feedDataReader", "fetchedCommonInfo", "guildInfo"}, s = {"L$2", "L$2", "L$3", "L$4", "L$5", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7"})
/* loaded from: classes13.dex */
public final class GenerateFeedSharePictureV2Handler$realHandle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Dialog $dialog;
    final /* synthetic */ boolean $isPublishFail;
    final /* synthetic */ PanelContext<Activity, vk1.b> $panelContext;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    final /* synthetic */ GenerateFeedSharePictureV2Handler this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GenerateFeedSharePictureV2Handler$realHandle$1(Dialog dialog, PanelContext<Activity, vk1.b> panelContext, boolean z16, GenerateFeedSharePictureV2Handler generateFeedSharePictureV2Handler, Continuation<? super GenerateFeedSharePictureV2Handler$realHandle$1> continuation) {
        super(2, continuation);
        this.$dialog = dialog;
        this.$panelContext = panelContext;
        this.$isPublishFail = z16;
        this.this$0 = generateFeedSharePictureV2Handler;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GenerateFeedSharePictureV2Handler$realHandle$1 generateFeedSharePictureV2Handler$realHandle$1 = new GenerateFeedSharePictureV2Handler$realHandle$1(this.$dialog, this.$panelContext, this.$isPublishFail, this.this$0, continuation);
        generateFeedSharePictureV2Handler$realHandle$1.L$0 = obj;
        return generateFeedSharePictureV2Handler$realHandle$1;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000e. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0238 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01f8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0189 A[Catch: all -> 0x0252, TryCatch #0 {all -> 0x0252, blocks: (B:10:0x001f, B:12:0x0239, B:19:0x0046, B:21:0x0207, B:25:0x0077, B:27:0x0175, B:30:0x019e, B:34:0x0189, B:35:0x0191, B:37:0x0097, B:40:0x011c, B:42:0x012c, B:44:0x014f, B:49:0x0240, B:50:0x0248, B:52:0x00af, B:54:0x00ec, B:56:0x00f0, B:60:0x0249, B:61:0x0251, B:63:0x00c4, B:66:0x00d0), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x012c A[Catch: all -> 0x0252, TryCatch #0 {all -> 0x0252, blocks: (B:10:0x001f, B:12:0x0239, B:19:0x0046, B:21:0x0207, B:25:0x0077, B:27:0x0175, B:30:0x019e, B:34:0x0189, B:35:0x0191, B:37:0x0097, B:40:0x011c, B:42:0x012c, B:44:0x014f, B:49:0x0240, B:50:0x0248, B:52:0x00af, B:54:0x00ec, B:56:0x00f0, B:60:0x0249, B:61:0x0251, B:63:0x00c4, B:66:0x00d0), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0240 A[Catch: all -> 0x0252, TryCatch #0 {all -> 0x0252, blocks: (B:10:0x001f, B:12:0x0239, B:19:0x0046, B:21:0x0207, B:25:0x0077, B:27:0x0175, B:30:0x019e, B:34:0x0189, B:35:0x0191, B:37:0x0097, B:40:0x011c, B:42:0x012c, B:44:0x014f, B:49:0x0240, B:50:0x0248, B:52:0x00af, B:54:0x00ec, B:56:0x00f0, B:60:0x0249, B:61:0x0251, B:63:0x00c4, B:66:0x00d0), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f0 A[Catch: all -> 0x0252, TryCatch #0 {all -> 0x0252, blocks: (B:10:0x001f, B:12:0x0239, B:19:0x0046, B:21:0x0207, B:25:0x0077, B:27:0x0175, B:30:0x019e, B:34:0x0189, B:35:0x0191, B:37:0x0097, B:40:0x011c, B:42:0x012c, B:44:0x014f, B:49:0x0240, B:50:0x0248, B:52:0x00af, B:54:0x00ec, B:56:0x00f0, B:60:0x0249, B:61:0x0251, B:63:0x00c4, B:66:0x00d0), top: B:2:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0249 A[Catch: all -> 0x0252, TryCatch #0 {all -> 0x0252, blocks: (B:10:0x001f, B:12:0x0239, B:19:0x0046, B:21:0x0207, B:25:0x0077, B:27:0x0175, B:30:0x019e, B:34:0x0189, B:35:0x0191, B:37:0x0097, B:40:0x011c, B:42:0x012c, B:44:0x014f, B:49:0x0240, B:50:0x0248, B:52:0x00af, B:54:0x00ec, B:56:0x00f0, B:60:0x0249, B:61:0x0251, B:63:0x00c4, B:66:0x00d0), top: B:2:0x000e }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object m476constructorimpl;
        Throwable m479exceptionOrNullimpl;
        CoroutineScope coroutineScope;
        PanelContext<Activity, vk1.b> panelContext;
        boolean z16;
        Object f16;
        GenerateFeedSharePictureV2Handler generateFeedSharePictureV2Handler;
        GProStFeed gProStFeed;
        Object e16;
        CoroutineScope coroutineScope2;
        GenerateFeedSharePictureV2Handler generateFeedSharePictureV2Handler2;
        vk1.a aVar;
        FeedDetailMainDisplayableParser feedDetailMainDisplayableParser;
        PanelContext<Activity, vk1.b> panelContext2;
        GProStFeed gProStFeed2;
        boolean isBlank;
        long currentTimeMillis;
        IGProFetchShareUrlRsp iGProFetchShareUrlRsp;
        IGProGuildInfo iGProGuildInfo;
        PanelContext<Activity, vk1.b> panelContext3;
        vk1.a aVar2;
        long j3;
        FeedDetailMainDisplayableParser feedDetailMainDisplayableParser2;
        GProStFeed gProStFeed3;
        CoroutineScope coroutineScope3;
        GenerateFeedSharePictureV2Handler generateFeedSharePictureV2Handler3;
        Object d16;
        vk1.a aVar3;
        IGProFetchShareUrlRsp iGProFetchShareUrlRsp2;
        vk1.a aVar4;
        Object j16;
        FeedDetailMainDisplayableParser feedDetailMainDisplayableParser3;
        GenerateFeedSharePictureV2Handler generateFeedSharePictureV2Handler4;
        CoroutineScope coroutineScope4;
        IGProFetchShareUrlRsp iGProFetchShareUrlRsp3;
        GProStFeed gProStFeed4;
        PanelContext<Activity, vk1.b> panelContext4;
        IGProGuildInfo iGProGuildInfo2;
        IGProGuildInfo iGProGuildInfo3;
        Object i3;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Throwable th5) {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
                panelContext = this.$panelContext;
                boolean z17 = this.$isPublishFail;
                GenerateFeedSharePictureV2Handler generateFeedSharePictureV2Handler5 = this.this$0;
                Result.Companion companion2 = Result.INSTANCE;
                GuildFeedMorePanelHandlerUtils guildFeedMorePanelHandlerUtils = GuildFeedMorePanelHandlerUtils.f220288a;
                if (z17) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                this.L$0 = panelContext;
                this.L$1 = generateFeedSharePictureV2Handler5;
                this.L$2 = coroutineScope;
                this.label = 1;
                f16 = GuildFeedMorePanelHandlerUtils.f(guildFeedMorePanelHandlerUtils, panelContext, 0L, z16, this, 1, null);
                if (f16 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                generateFeedSharePictureV2Handler = generateFeedSharePictureV2Handler5;
                gProStFeed = (GProStFeed) f16;
                if (gProStFeed == null) {
                    vk1.a aVar5 = new vk1.a(new GProStFeedDetailRspWrapper(gProStFeed, null, 2, null));
                    FeedDetailMainDisplayableParser feedDetailMainDisplayableParser4 = new FeedDetailMainDisplayableParser(aVar5);
                    GenerateFeedSharePictureV2Handler.Companion companion3 = GenerateFeedSharePictureV2Handler.INSTANCE;
                    this.L$0 = panelContext;
                    this.L$1 = generateFeedSharePictureV2Handler;
                    this.L$2 = coroutineScope;
                    this.L$3 = aVar5;
                    this.L$4 = gProStFeed;
                    this.L$5 = feedDetailMainDisplayableParser4;
                    this.label = 2;
                    e16 = companion3.e(aVar5, true, this);
                    if (e16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    coroutineScope2 = coroutineScope;
                    generateFeedSharePictureV2Handler2 = generateFeedSharePictureV2Handler;
                    aVar = aVar5;
                    feedDetailMainDisplayableParser = feedDetailMainDisplayableParser4;
                    panelContext2 = panelContext;
                    gProStFeed2 = gProStFeed;
                    IGProFetchShareUrlRsp iGProFetchShareUrlRsp4 = (IGProFetchShareUrlRsp) e16;
                    String shareLink = iGProFetchShareUrlRsp4.getShareLink();
                    Intrinsics.checkNotNullExpressionValue(shareLink, "fetchedCommonInfo.shareLink");
                    isBlank = StringsKt__StringsJVMKt.isBlank(shareLink);
                    if (isBlank) {
                        currentTimeMillis = System.currentTimeMillis();
                        IRuntimeService S0 = ch.S0(IGPSService.class, "");
                        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
                        IGProGuildInfo guildInfo = ((IGPSService) S0).getGuildInfo(String.valueOf(aVar.getGuildId()));
                        if (guildInfo == null) {
                            GenerateFeedSharePictureV2Handler.Companion companion4 = GenerateFeedSharePictureV2Handler.INSTANCE;
                            String valueOf = String.valueOf(aVar.getGuildId());
                            this.L$0 = panelContext2;
                            this.L$1 = generateFeedSharePictureV2Handler2;
                            this.L$2 = coroutineScope2;
                            this.L$3 = aVar;
                            this.L$4 = gProStFeed2;
                            this.L$5 = feedDetailMainDisplayableParser;
                            this.L$6 = iGProFetchShareUrlRsp4;
                            this.J$0 = currentTimeMillis;
                            this.label = 3;
                            d16 = companion4.d(valueOf, this);
                            if (d16 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            aVar3 = aVar;
                            iGProFetchShareUrlRsp2 = iGProFetchShareUrlRsp4;
                            iGProGuildInfo3 = (IGProGuildInfo) d16;
                            if (iGProGuildInfo3 == null) {
                                iGProGuildInfo = iGProGuildInfo3;
                                iGProFetchShareUrlRsp = iGProFetchShareUrlRsp2;
                                j3 = currentTimeMillis;
                                feedDetailMainDisplayableParser2 = feedDetailMainDisplayableParser;
                                gProStFeed3 = gProStFeed2;
                                PanelContext<Activity, vk1.b> panelContext5 = panelContext2;
                                aVar2 = aVar3;
                                panelContext3 = panelContext5;
                                GenerateFeedSharePictureV2Handler generateFeedSharePictureV2Handler6 = generateFeedSharePictureV2Handler2;
                                coroutineScope3 = coroutineScope2;
                                generateFeedSharePictureV2Handler3 = generateFeedSharePictureV2Handler6;
                                QLog.i("SPic.GenerateFeedSharePictureV2Handler", 2, "getGuildInfo coast:" + (System.currentTimeMillis() - j3));
                                GenerateFeedSharePictureV2Handler.Companion companion5 = GenerateFeedSharePictureV2Handler.INSTANCE;
                                String shareLink2 = iGProFetchShareUrlRsp.getShareLink();
                                Intrinsics.checkNotNullExpressionValue(shareLink2, "fetchedCommonInfo.shareLink");
                                this.L$0 = panelContext3;
                                this.L$1 = generateFeedSharePictureV2Handler3;
                                this.L$2 = coroutineScope3;
                                this.L$3 = aVar2;
                                this.L$4 = gProStFeed3;
                                this.L$5 = feedDetailMainDisplayableParser2;
                                this.L$6 = iGProFetchShareUrlRsp;
                                this.L$7 = iGProGuildInfo;
                                this.label = 4;
                                PanelContext<Activity, vk1.b> panelContext6 = panelContext3;
                                GenerateFeedSharePictureV2Handler generateFeedSharePictureV2Handler7 = generateFeedSharePictureV2Handler3;
                                CoroutineScope coroutineScope5 = coroutineScope3;
                                aVar4 = aVar2;
                                j16 = GenerateFeedSharePictureV2Handler.Companion.j(companion5, panelContext3, iGProGuildInfo, gProStFeed3, shareLink2, feedDetailMainDisplayableParser2, false, this, 32, null);
                                if (j16 != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                feedDetailMainDisplayableParser3 = feedDetailMainDisplayableParser2;
                                generateFeedSharePictureV2Handler4 = generateFeedSharePictureV2Handler7;
                                coroutineScope4 = coroutineScope5;
                                iGProFetchShareUrlRsp3 = iGProFetchShareUrlRsp;
                                gProStFeed4 = gProStFeed3;
                                panelContext4 = panelContext6;
                                iGProGuildInfo2 = iGProGuildInfo;
                                Bitmap bitmap = (Bitmap) j16;
                                CoroutineScopeKt.ensureActive(coroutineScope4);
                                i.e eVar = i.e.f261783e;
                                GenerateFeedSharePictureV2Handler$realHandle$1$1$1 generateFeedSharePictureV2Handler$realHandle$1$1$1 = new GenerateFeedSharePictureV2Handler$realHandle$1$1$1(generateFeedSharePictureV2Handler4, panelContext4, bitmap, feedDetailMainDisplayableParser3, iGProGuildInfo2, gProStFeed4, iGProFetchShareUrlRsp3, aVar4, null);
                                this.L$0 = null;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.L$5 = null;
                                this.L$6 = null;
                                this.L$7 = null;
                                this.label = 5;
                                i3 = CorountineFunKt.i(eVar, null, null, generateFeedSharePictureV2Handler$realHandle$1$1$1, this, 6, null);
                                if (i3 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                m476constructorimpl = Result.m476constructorimpl((Unit) i3);
                                m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                                if (m479exceptionOrNullimpl != null) {
                                    GenerateFeedSharePictureV2Handler.Companion companion6 = GenerateFeedSharePictureV2Handler.INSTANCE;
                                    this.L$0 = m476constructorimpl;
                                    this.L$1 = null;
                                    this.L$2 = null;
                                    this.L$3 = null;
                                    this.L$4 = null;
                                    this.L$5 = null;
                                    this.L$6 = null;
                                    this.L$7 = null;
                                    this.label = 6;
                                    if (companion6.c(m479exceptionOrNullimpl, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                }
                                this.$dialog.dismiss();
                                return Unit.INSTANCE;
                            }
                            throw new Exception(" no guildInfo info ");
                        }
                        iGProFetchShareUrlRsp = iGProFetchShareUrlRsp4;
                        iGProGuildInfo = guildInfo;
                        panelContext3 = panelContext2;
                        aVar2 = aVar;
                        j3 = currentTimeMillis;
                        feedDetailMainDisplayableParser2 = feedDetailMainDisplayableParser;
                        gProStFeed3 = gProStFeed2;
                        GenerateFeedSharePictureV2Handler generateFeedSharePictureV2Handler8 = generateFeedSharePictureV2Handler2;
                        coroutineScope3 = coroutineScope2;
                        generateFeedSharePictureV2Handler3 = generateFeedSharePictureV2Handler8;
                        QLog.i("SPic.GenerateFeedSharePictureV2Handler", 2, "getGuildInfo coast:" + (System.currentTimeMillis() - j3));
                        GenerateFeedSharePictureV2Handler.Companion companion52 = GenerateFeedSharePictureV2Handler.INSTANCE;
                        String shareLink22 = iGProFetchShareUrlRsp.getShareLink();
                        Intrinsics.checkNotNullExpressionValue(shareLink22, "fetchedCommonInfo.shareLink");
                        this.L$0 = panelContext3;
                        this.L$1 = generateFeedSharePictureV2Handler3;
                        this.L$2 = coroutineScope3;
                        this.L$3 = aVar2;
                        this.L$4 = gProStFeed3;
                        this.L$5 = feedDetailMainDisplayableParser2;
                        this.L$6 = iGProFetchShareUrlRsp;
                        this.L$7 = iGProGuildInfo;
                        this.label = 4;
                        PanelContext<Activity, vk1.b> panelContext62 = panelContext3;
                        GenerateFeedSharePictureV2Handler generateFeedSharePictureV2Handler72 = generateFeedSharePictureV2Handler3;
                        CoroutineScope coroutineScope52 = coroutineScope3;
                        aVar4 = aVar2;
                        j16 = GenerateFeedSharePictureV2Handler.Companion.j(companion52, panelContext3, iGProGuildInfo, gProStFeed3, shareLink22, feedDetailMainDisplayableParser2, false, this, 32, null);
                        if (j16 != coroutine_suspended) {
                        }
                    } else {
                        throw new Exception(" no share url can't generate code");
                    }
                } else {
                    throw new Exception("no feedInfo info");
                }
            case 1:
                coroutineScope = (CoroutineScope) this.L$2;
                GenerateFeedSharePictureV2Handler generateFeedSharePictureV2Handler9 = (GenerateFeedSharePictureV2Handler) this.L$1;
                PanelContext<Activity, vk1.b> panelContext7 = (PanelContext) this.L$0;
                ResultKt.throwOnFailure(obj);
                panelContext = panelContext7;
                generateFeedSharePictureV2Handler = generateFeedSharePictureV2Handler9;
                f16 = obj;
                gProStFeed = (GProStFeed) f16;
                if (gProStFeed == null) {
                }
                break;
            case 2:
                FeedDetailMainDisplayableParser feedDetailMainDisplayableParser5 = (FeedDetailMainDisplayableParser) this.L$5;
                gProStFeed = (GProStFeed) this.L$4;
                aVar = (vk1.a) this.L$3;
                CoroutineScope coroutineScope6 = (CoroutineScope) this.L$2;
                GenerateFeedSharePictureV2Handler generateFeedSharePictureV2Handler10 = (GenerateFeedSharePictureV2Handler) this.L$1;
                PanelContext<Activity, vk1.b> panelContext8 = (PanelContext) this.L$0;
                ResultKt.throwOnFailure(obj);
                coroutineScope2 = coroutineScope6;
                generateFeedSharePictureV2Handler2 = generateFeedSharePictureV2Handler10;
                panelContext2 = panelContext8;
                e16 = obj;
                feedDetailMainDisplayableParser = feedDetailMainDisplayableParser5;
                gProStFeed2 = gProStFeed;
                IGProFetchShareUrlRsp iGProFetchShareUrlRsp42 = (IGProFetchShareUrlRsp) e16;
                String shareLink3 = iGProFetchShareUrlRsp42.getShareLink();
                Intrinsics.checkNotNullExpressionValue(shareLink3, "fetchedCommonInfo.shareLink");
                isBlank = StringsKt__StringsJVMKt.isBlank(shareLink3);
                if (isBlank) {
                }
                break;
            case 3:
                long j17 = this.J$0;
                iGProFetchShareUrlRsp2 = (IGProFetchShareUrlRsp) this.L$6;
                feedDetailMainDisplayableParser = (FeedDetailMainDisplayableParser) this.L$5;
                gProStFeed2 = (GProStFeed) this.L$4;
                aVar3 = (vk1.a) this.L$3;
                coroutineScope2 = (CoroutineScope) this.L$2;
                generateFeedSharePictureV2Handler2 = (GenerateFeedSharePictureV2Handler) this.L$1;
                panelContext2 = (PanelContext) this.L$0;
                ResultKt.throwOnFailure(obj);
                currentTimeMillis = j17;
                d16 = obj;
                iGProGuildInfo3 = (IGProGuildInfo) d16;
                if (iGProGuildInfo3 == null) {
                }
                break;
            case 4:
                IGProGuildInfo iGProGuildInfo4 = (IGProGuildInfo) this.L$7;
                IGProFetchShareUrlRsp iGProFetchShareUrlRsp5 = (IGProFetchShareUrlRsp) this.L$6;
                FeedDetailMainDisplayableParser feedDetailMainDisplayableParser6 = (FeedDetailMainDisplayableParser) this.L$5;
                GProStFeed gProStFeed5 = (GProStFeed) this.L$4;
                vk1.a aVar6 = (vk1.a) this.L$3;
                coroutineScope4 = (CoroutineScope) this.L$2;
                GenerateFeedSharePictureV2Handler generateFeedSharePictureV2Handler11 = (GenerateFeedSharePictureV2Handler) this.L$1;
                PanelContext<Activity, vk1.b> panelContext9 = (PanelContext) this.L$0;
                ResultKt.throwOnFailure(obj);
                iGProGuildInfo2 = iGProGuildInfo4;
                iGProFetchShareUrlRsp3 = iGProFetchShareUrlRsp5;
                feedDetailMainDisplayableParser3 = feedDetailMainDisplayableParser6;
                gProStFeed4 = gProStFeed5;
                aVar4 = aVar6;
                generateFeedSharePictureV2Handler4 = generateFeedSharePictureV2Handler11;
                panelContext4 = panelContext9;
                j16 = obj;
                Bitmap bitmap2 = (Bitmap) j16;
                CoroutineScopeKt.ensureActive(coroutineScope4);
                i.e eVar2 = i.e.f261783e;
                GenerateFeedSharePictureV2Handler$realHandle$1$1$1 generateFeedSharePictureV2Handler$realHandle$1$1$12 = new GenerateFeedSharePictureV2Handler$realHandle$1$1$1(generateFeedSharePictureV2Handler4, panelContext4, bitmap2, feedDetailMainDisplayableParser3, iGProGuildInfo2, gProStFeed4, iGProFetchShareUrlRsp3, aVar4, null);
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.L$4 = null;
                this.L$5 = null;
                this.L$6 = null;
                this.L$7 = null;
                this.label = 5;
                i3 = CorountineFunKt.i(eVar2, null, null, generateFeedSharePictureV2Handler$realHandle$1$1$12, this, 6, null);
                if (i3 == coroutine_suspended) {
                }
                m476constructorimpl = Result.m476constructorimpl((Unit) i3);
                m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                if (m479exceptionOrNullimpl != null) {
                }
                this.$dialog.dismiss();
                return Unit.INSTANCE;
            case 5:
                ResultKt.throwOnFailure(obj);
                i3 = obj;
                m476constructorimpl = Result.m476constructorimpl((Unit) i3);
                m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
                if (m479exceptionOrNullimpl != null) {
                }
                this.$dialog.dismiss();
                return Unit.INSTANCE;
            case 6:
                ResultKt.throwOnFailure(obj);
                this.$dialog.dismiss();
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GenerateFeedSharePictureV2Handler$realHandle$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
