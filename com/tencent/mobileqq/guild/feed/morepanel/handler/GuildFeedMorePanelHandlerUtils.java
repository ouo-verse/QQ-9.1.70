package com.tencent.mobileqq.guild.feed.morepanel.handler;

import android.app.Activity;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.guild.feed.manager.GuildFeedDetailDataCacheManager;
import com.tencent.mobileqq.guild.feed.morepanel.PanelContext;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStGetFeedDetailReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStGetFeedDetailRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedDetailCallback;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\t\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ \u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00020\u000bj\u0002`\rJ=\u0010\u0013\u001a\u0004\u0018\u00010\u0006*\u0012\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00020\u000bj\u0002`\r2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/handler/GuildFeedMorePanelHandlerUtils;", "", "Lvk1/b;", "feed", "", "timeout", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "b", "(Lvk1/b;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "c", "(Lvk1/b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;", "Landroid/app/Activity;", "Lcom/tencent/mobileqq/guild/feed/morepanel/impl/MorePanelContext;", "panelContext", "Lkotlinx/coroutines/CoroutineScope;", "d", "", "getForce", "e", "(Lcom/tencent/mobileqq/guild/feed/morepanel/PanelContext;JZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedMorePanelHandlerUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildFeedMorePanelHandlerUtils f220288a = new GuildFeedMorePanelHandlerUtils();

    GuildFeedMorePanelHandlerUtils() {
    }

    private final Object b(vk1.b bVar, long j3, Continuation<? super GProStFeed> continuation) {
        if (j3 > 0) {
            return TimeoutKt.withTimeoutOrNull(j3, new GuildFeedMorePanelHandlerUtils$fetchFeedDetail$2(bVar, null), continuation);
        }
        return c(bVar, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object c(vk1.b bVar, Continuation<? super GProStFeed> continuation) {
        Continuation intercepted;
        AppInterface appInterface;
        Object coroutine_suspended;
        String selfTinyId;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        GProStChannelSign gProStChannelSign = new GProStChannelSign();
        gProStChannelSign.guildId = bVar.getGuildId();
        gProStChannelSign.channelId = bVar.getChannelId();
        GProStGetFeedDetailReq gProStGetFeedDetailReq = new GProStGetFeedDetailReq();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        String str = "";
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null && (selfTinyId = iGPSService.getSelfTinyId()) != null) {
            str = selfTinyId;
        }
        gProStGetFeedDetailReq.userId = str;
        gProStGetFeedDetailReq.feedId = bVar.getFeedId();
        gProStGetFeedDetailReq.channelSign = gProStChannelSign;
        gProStGetFeedDetailReq.contentType = 2;
        com.tencent.qqnt.kernel.api.o c16 = com.tencent.mobileqq.guild.feed.util.l.c();
        if (c16 != null) {
            c16.getFeedDetail(gProStGetFeedDetailReq, false, new IGProGetFeedDetailCallback() { // from class: com.tencent.mobileqq.guild.feed.morepanel.handler.GuildFeedMorePanelHandlerUtils$fetchFeedDetail$4$1

                @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
                @DebugMetadata(c = "com.tencent.mobileqq.guild.feed.morepanel.handler.GuildFeedMorePanelHandlerUtils$fetchFeedDetail$4$1$3", f = "GuildFeedMorePanelHandlerUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                /* renamed from: com.tencent.mobileqq.guild.feed.morepanel.handler.GuildFeedMorePanelHandlerUtils$fetchFeedDetail$4$1$3, reason: invalid class name */
                /* loaded from: classes13.dex */
                static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ GProStGetFeedDetailRsp $rsp;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass3(GProStGetFeedDetailRsp gProStGetFeedDetailRsp, Continuation<? super AnonymousClass3> continuation) {
                        super(2, continuation);
                        this.$rsp = gProStGetFeedDetailRsp;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        return new AnonymousClass3(this.$rsp, continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        if (this.label == 0) {
                            ResultKt.throwOnFailure(obj);
                            GuildFeedDetailDataCacheManager.y().e(this.$rsp.feed);
                            return Unit.INSTANCE;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }

                    @Override // kotlin.jvm.functions.Function2
                    @Nullable
                    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                        return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }
                }

                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetFeedDetailCallback
                public final void onResult(int i3, String str2, boolean z16, GProStGetFeedDetailRsp gProStGetFeedDetailRsp) {
                    if (i3 == 0 && gProStGetFeedDetailRsp != null) {
                        if (cancellableContinuationImpl.isActive()) {
                            CancellableContinuation<GProStFeed> cancellableContinuation = cancellableContinuationImpl;
                            Result.Companion companion = Result.INSTANCE;
                            cancellableContinuation.resumeWith(Result.m476constructorimpl(gProStGetFeedDetailRsp.feed));
                            Logger logger = Logger.f235387a;
                            if (QLog.isColorLevel()) {
                                logger.d().d("GuildFeedMorePanelHandlerUtils", 2, "fetchFeedDetail: isDb: " + z16);
                            }
                        } else {
                            Logger logger2 = Logger.f235387a;
                            Logger.b bVar2 = new Logger.b();
                            bVar2.a().add("Add names in comment to call arguments");
                            Iterator<T> it = bVar2.a().iterator();
                            while (it.hasNext()) {
                                Logger.f235387a.d().e("GuildFeedMorePanelHandlerUtils", 1, (String) it.next(), null);
                            }
                        }
                        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
                        if (f16 != null) {
                            CorountineFunKt.e(f16, "GuildFeedMorePanelHandlerUtils getFeedDetail", null, null, null, new AnonymousClass3(gProStGetFeedDetailRsp, null), 14, null);
                            return;
                        }
                        return;
                    }
                    Logger logger3 = Logger.f235387a;
                    Logger.b bVar3 = new Logger.b();
                    String str3 = "fetchFeedDetail, result: " + i3 + ", errMsg: " + str2;
                    if (str3 instanceof String) {
                        bVar3.a().add(str3);
                    }
                    Iterator<T> it5 = bVar3.a().iterator();
                    while (it5.hasNext()) {
                        Logger.f235387a.d().e("GuildFeedMorePanelHandlerUtils", 1, (String) it5.next(), null);
                    }
                    if (cancellableContinuationImpl.isActive()) {
                        cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(null));
                    }
                }
            });
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static /* synthetic */ Object f(GuildFeedMorePanelHandlerUtils guildFeedMorePanelHandlerUtils, PanelContext panelContext, long j3, boolean z16, Continuation continuation, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j3 = 0;
        }
        long j16 = j3;
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        return guildFeedMorePanelHandlerUtils.e(panelContext, j16, z16, continuation);
    }

    @Nullable
    public final CoroutineScope d(@NotNull PanelContext<Activity, vk1.b> panelContext) {
        Intrinsics.checkNotNullParameter(panelContext, "panelContext");
        CoroutineScope b16 = com.tencent.mobileqq.guild.feed.morepanel.i.b(panelContext.getApiRouter());
        if (b16 == null) {
            return com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        }
        return b16;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object e(@NotNull PanelContext<Activity, vk1.b> panelContext, long j3, boolean z16, @NotNull Continuation<? super GProStFeed> continuation) {
        GuildFeedMorePanelHandlerUtils$getWholeFeedDetail$1 guildFeedMorePanelHandlerUtils$getWholeFeedDetail$1;
        Object coroutine_suspended;
        int i3;
        PanelContext<Activity, vk1.b> panelContext2;
        String str;
        GProStFeed gProStFeed;
        if (continuation instanceof GuildFeedMorePanelHandlerUtils$getWholeFeedDetail$1) {
            guildFeedMorePanelHandlerUtils$getWholeFeedDetail$1 = (GuildFeedMorePanelHandlerUtils$getWholeFeedDetail$1) continuation;
            int i16 = guildFeedMorePanelHandlerUtils$getWholeFeedDetail$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                guildFeedMorePanelHandlerUtils$getWholeFeedDetail$1.label = i16 - Integer.MIN_VALUE;
                Object obj = guildFeedMorePanelHandlerUtils$getWholeFeedDetail$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = guildFeedMorePanelHandlerUtils$getWholeFeedDetail$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        z16 = guildFeedMorePanelHandlerUtils$getWholeFeedDetail$1.Z$0;
                        str = (String) guildFeedMorePanelHandlerUtils$getWholeFeedDetail$1.L$1;
                        panelContext2 = (PanelContext) guildFeedMorePanelHandlerUtils$getWholeFeedDetail$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    String feedId = panelContext.j().getFeedId();
                    if (panelContext.getExtra().getBoolean("extra_key_is_whole_feed", true) && !z16) {
                        Logger.f235387a.d().i("GuildFeedMorePanelHandlerUtils", 1, "getWholeFeedDetail isWholeFeed feedId:" + feedId);
                        Object a16 = panelContext.j().a();
                        if (!(a16 instanceof GProStFeed)) {
                            return null;
                        }
                        return (GProStFeed) a16;
                    }
                    GProStFeed r16 = GuildFeedDetailDataCacheManager.y().r(feedId, panelContext.j().m(), true);
                    if (r16 != null) {
                        Logger.f235387a.d().i("GuildFeedMorePanelHandlerUtils", 1, "getWholeFeedDetail from cache feedId:" + feedId + " getForce:" + z16);
                        return r16;
                    }
                    vk1.b j16 = panelContext.j();
                    guildFeedMorePanelHandlerUtils$getWholeFeedDetail$1.L$0 = panelContext;
                    guildFeedMorePanelHandlerUtils$getWholeFeedDetail$1.L$1 = feedId;
                    guildFeedMorePanelHandlerUtils$getWholeFeedDetail$1.Z$0 = z16;
                    guildFeedMorePanelHandlerUtils$getWholeFeedDetail$1.label = 1;
                    Object b16 = b(j16, j3, guildFeedMorePanelHandlerUtils$getWholeFeedDetail$1);
                    if (b16 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    panelContext2 = panelContext;
                    str = feedId;
                    obj = b16;
                }
                gProStFeed = (GProStFeed) obj;
                if (gProStFeed == null) {
                    Logger.f235387a.d().i("GuildFeedMorePanelHandlerUtils", 1, "getWholeFeedDetail from svr feedId:" + str + " getForce:" + z16);
                    return gProStFeed;
                }
                Logger.f235387a.d().i("GuildFeedMorePanelHandlerUtils", 1, "getWholeFeedDetail from default feedId:" + str + " getForce:" + z16);
                Object a17 = panelContext2.j().a();
                if (!(a17 instanceof GProStFeed)) {
                    return null;
                }
                return (GProStFeed) a17;
            }
        }
        guildFeedMorePanelHandlerUtils$getWholeFeedDetail$1 = new GuildFeedMorePanelHandlerUtils$getWholeFeedDetail$1(this, continuation);
        Object obj2 = guildFeedMorePanelHandlerUtils$getWholeFeedDetail$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = guildFeedMorePanelHandlerUtils$getWholeFeedDetail$1.label;
        if (i3 == 0) {
        }
        gProStFeed = (GProStFeed) obj2;
        if (gProStFeed == null) {
        }
    }
}
