package com.tencent.mobileqq.guild.feed.feedsquare.data;

import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.rewardad.utils.QAdRewardDefine$VideoParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.o;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetGuildFeedsReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetGuildFeedsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildFeedsFilter;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStGetChannelFeedsReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStGetChannelFeedsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GuildInteractiveNotificationItem;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetChannelTimelineFeedsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetGuildFeedsCallback;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u0000 42\u00020\u0001:\u0002),B\u0017\u0012\u0006\u0010+\u001a\u00020\u0002\u0012\u0006\u0010.\u001a\u00020\u000b\u00a2\u0006\u0004\b2\u00103J>\u0010\u000e\u001a\u00020\r2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u00a7\u0001\u0010\u001c\u001a\u00020\r\"\b\b\u0000\u0010\u000f*\u00020\u0001\"\u0004\b\u0001\u0010\u00102\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\u0011\u001a\u00028\u00002\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00010\u00122b\u0010\u001b\u001a^\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\r0\u0014H\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0099\u0001\u0010\u001f\u001a\u00020\r\"\b\b\u0000\u0010\u000f*\u00020\u0001\"\u0004\b\u0001\u0010\u00102\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t2\u0006\u0010\u0011\u001a\u00028\u00002b\u0010\u001e\u001a^\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0015\u0012\u0013\u0018\u00010\u0002\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00118\u0001\u00a2\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\r0\u0014H\u0002\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u0001H\u0002J$\u0010%\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020#0\t2\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0\u0012J$\u0010(\u001a\u00020\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020&0\t2\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010'0\u0012R\u0014\u0010+\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010.\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00101\u001a\u00020\u00028BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b/\u00100\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedListDataRepo;", "", "", "errorMsg", "", "isSuccess", "", "retCode", QAdRewardDefine$VideoParams.ISCACHE, "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedListDataRepo$b;", "reqParam", "", "vecFeedCount", "", "j", "Req", "Rsp", Const.BUNDLE_KEY_REQUEST, "Lqx1/a;", "responseProcessor", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "result", "errMsg", "isDbCache", "rsp", "tempCallback", "r", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedListDataRepo$b;Ljava/lang/Object;Lqx1/a;Lkotlin/jvm/functions/Function4;)V", "cb", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedListDataRepo$b;Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)V", "req", "i", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGetGuildFeedsReq;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/b;", "l", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStGetChannelFeedsReq;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/a;", "k", "a", "Ljava/lang/String;", "tagPrefix", "b", "I", "mContextHashCode", tl.h.F, "()Ljava/lang/String;", "logTag", "<init>", "(Ljava/lang/String;I)V", "c", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedListDataRepo {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final AtomicLong f218787d = new AtomicLong(1);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tagPrefix;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int mContextHashCode;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\tR\u0014\u0010\u0011\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\t\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedListDataRepo$a;", "", "Ljava/util/concurrent/atomic/AtomicLong;", "sReqSeq", "Ljava/util/concurrent/atomic/AtomicLong;", "a", "()Ljava/util/concurrent/atomic/AtomicLong;", "", "DEFAULT_COUNT", "I", "GLOBAL_CONTEXT_HASHCODE", "SORT_OPTION_COMMENT_TIME", "SORT_OPTION_PUBLISH_TIME", "", "TAG", "Ljava/lang/String;", "TYPE_HOT", "TYPE_TIME", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedListDataRepo$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final AtomicLong a() {
            return GuildFeedListDataRepo.f218787d;
        }

        Companion() {
        }
    }

    public GuildFeedListDataRepo(@NotNull String tagPrefix, int i3) {
        Intrinsics.checkNotNullParameter(tagPrefix, "tagPrefix");
        this.tagPrefix = tagPrefix;
        this.mContextHashCode = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String h() {
        return this.tagPrefix + ".GuildFeedListDataRepo";
    }

    private final String i(Object req) {
        Integer num;
        Integer num2;
        Integer num3 = null;
        if (req instanceof GProGetGuildFeedsReq) {
            GProGetGuildFeedsReq gProGetGuildFeedsReq = (GProGetGuildFeedsReq) req;
            int i3 = gProGetGuildFeedsReq.count;
            int i16 = gProGetGuildFeedsReq.from;
            boolean z16 = gProGetGuildFeedsReq.needRecommendCard;
            String str = gProGetGuildFeedsReq.feedAttchInfo;
            if (str != null) {
                num = Integer.valueOf(str.hashCode());
            } else {
                num = null;
            }
            int i17 = gProGetGuildFeedsReq.needNewFeature;
            byte[] bArr = gProGetGuildFeedsReq.adReq;
            if (bArr != null) {
                num2 = Integer.valueOf(bArr.hashCode());
            } else {
                num2 = null;
            }
            byte[] bArr2 = gProGetGuildFeedsReq.token;
            if (bArr2 != null) {
                num3 = Integer.valueOf(bArr2.hashCode());
            }
            return "[GProGetGuildFeedsReq count:" + i3 + " from:" + i16 + " needRecommendCard:" + z16 + " feedAttchInfo:" + num + " needNewFeature:" + i17 + " adReq:" + num2 + " token:" + num3 + "] filter:" + gProGetGuildFeedsReq.filter + "]";
        }
        if (req instanceof GProStGetChannelFeedsReq) {
            GProStGetChannelFeedsReq gProStGetChannelFeedsReq = (GProStGetChannelFeedsReq) req;
            int i18 = gProStGetChannelFeedsReq.count;
            int i19 = gProStGetChannelFeedsReq.from;
            String str2 = gProStGetChannelFeedsReq.feedAttchInfo;
            if (str2 != null) {
                num3 = Integer.valueOf(str2.hashCode());
            }
            return "[GProStGetChannelFeedsReq count:" + i18 + " from:" + i19 + " feedAttchInfo:" + num3 + " needChannelList:" + gProStGetChannelFeedsReq.needChannelList + "]";
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(String errorMsg, boolean isSuccess, long retCode, boolean isCache, b<?> reqParam, int vecFeedCount) {
        QLog.d(h(), 1, "[FeedsLoad] requestFeedsData onReceive: dispatch Success:" + isSuccess + " | retCode:" + retCode + " | retMessage:" + errorMsg + " | reqSeq:" + reqParam.getReqSeq() + " | isLoadMore:" + reqParam.getIsLoadMore() + " | isCache:" + isCache + " | size:" + vecFeedCount);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <Req, Rsp> void m(b<Req> reqParam, Req request, final Function4<? super Integer, ? super String, ? super Boolean, ? super Rsp, Unit> cb5) {
        o c16;
        QLog.i(h(), 1, "[FeedsLoad] sendRequest reqSeq:" + reqParam.getReqSeq() + " " + i(request));
        final long currentTimeMillis = System.currentTimeMillis();
        if (request instanceof GProGetGuildFeedsReq) {
            o c17 = com.tencent.mobileqq.guild.feed.util.l.c();
            if (c17 != null) {
                c17.getGuildFeeds((GProGetGuildFeedsReq) request, reqParam.getEnableUseCache(), new IGProGetGuildFeedsCallback() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.data.c
                    @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetGuildFeedsCallback
                    public final void onResult(int i3, String str, boolean z16, GProGetGuildFeedsRsp gProGetGuildFeedsRsp, GuildInteractiveNotificationItem guildInteractiveNotificationItem) {
                        GuildFeedListDataRepo.n(currentTimeMillis, cb5, i3, str, z16, gProGetGuildFeedsRsp, guildInteractiveNotificationItem);
                    }
                });
                return;
            }
            return;
        }
        if ((request instanceof GProStGetChannelFeedsReq) && (c16 = com.tencent.mobileqq.guild.feed.util.l.c()) != null) {
            c16.getChannelTimelineFeeds((GProStGetChannelFeedsReq) request, reqParam.getEnableUseCache(), new IGProGetChannelTimelineFeedsCallback() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.data.d
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetChannelTimelineFeedsCallback
                public final void onResult(int i3, String str, boolean z16, GProStGetChannelFeedsRsp gProStGetChannelFeedsRsp) {
                    GuildFeedListDataRepo.p(currentTimeMillis, cb5, i3, str, z16, gProStGetChannelFeedsRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(long j3, final Function4 cb5, final int i3, final String str, final boolean z16, GProGetGuildFeedsRsp rsp, GuildInteractiveNotificationItem guildInteractiveNotificationItem) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        QLog.i("GuildFeedListDataRepo", 1, "callback GProGetGuildFeedsRsp cost:" + (System.currentTimeMillis() - j3));
        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
        final com.tencent.mobileqq.guild.feed.feedsquare.data.b bVar = new com.tencent.mobileqq.guild.feed.feedsquare.data.b(z16, rsp, guildInteractiveNotificationItem);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.data.f
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedListDataRepo.o(Function4.this, i3, str, z16, bVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(Function4 cb5, int i3, String str, boolean z16, com.tencent.mobileqq.guild.feed.feedsquare.data.b rspWrapper) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        Intrinsics.checkNotNullParameter(rspWrapper, "$rspWrapper");
        cb5.invoke(Integer.valueOf(i3), str, Boolean.valueOf(z16), rspWrapper);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(long j3, final Function4 cb5, final int i3, final String str, final boolean z16, GProStGetChannelFeedsRsp rsp) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        QLog.i("GuildFeedListDataRepo", 1, "callback GProStGetChannelFeedsRsp cost:" + (System.currentTimeMillis() - j3));
        Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
        final a aVar = new a(z16, rsp);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.data.e
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedListDataRepo.q(Function4.this, i3, str, z16, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(Function4 cb5, int i3, String str, boolean z16, a rspWrapper) {
        Intrinsics.checkNotNullParameter(cb5, "$cb");
        Intrinsics.checkNotNullParameter(rspWrapper, "$rspWrapper");
        cb5.invoke(Integer.valueOf(i3), str, Boolean.valueOf(z16), rspWrapper);
    }

    private final <Req, Rsp> void r(final b<Req> reqParam, Req request, final qx1.a<Rsp> responseProcessor, final Function4<? super Integer, ? super String, ? super Boolean, ? super Rsp, Unit> tempCallback) {
        b.a<Req> h16 = reqParam.h();
        if (h16 != null) {
            h16.a(request);
        }
        m(reqParam, request, new Function4<Integer, String, Boolean, Rsp, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedListDataRepo$sendRequestProcedure$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(4);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, Boolean bool, Object obj) {
                invoke(num.intValue(), str, bool.booleanValue(), (boolean) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @Nullable String str, boolean z16, Rsp rsp) {
                String h17;
                tempCallback.invoke(Integer.valueOf(i3), str, Boolean.valueOf(z16), rsp);
                if (i3 == 0 && rsp != null) {
                    if (!reqParam.getEnableUseCache() && z16) {
                        h17 = this.h();
                        QLog.d(h17, 1, "Cache data returned, but cache usage is not allowed. Ignoring data.");
                        return;
                    } else {
                        responseProcessor.a(i3, str, rsp);
                        return;
                    }
                }
                responseProcessor.b(false, i3, str, rsp);
            }
        });
    }

    public final void k(@NotNull final b<GProStGetChannelFeedsReq> reqParam, @NotNull qx1.a<a> responseProcessor) {
        Intrinsics.checkNotNullParameter(reqParam, "reqParam");
        Intrinsics.checkNotNullParameter(responseProcessor, "responseProcessor");
        GProStGetChannelFeedsReq gProStGetChannelFeedsReq = new GProStGetChannelFeedsReq();
        gProStGetChannelFeedsReq.from = 0;
        gProStGetChannelFeedsReq.count = 12;
        gProStGetChannelFeedsReq.feedAttchInfo = reqParam.getAttachInfo();
        GProStChannelSign gProStChannelSign = gProStGetChannelFeedsReq.channelSign;
        gProStChannelSign.guildId = az.d(reqParam.getGuildId(), 0L);
        gProStChannelSign.channelId = az.d(reqParam.getChannelId(), 0L);
        int sortMode = reqParam.getSortMode();
        if (sortMode != 1) {
            if (sortMode != 3) {
                gProStGetChannelFeedsReq.sortOption = 1;
                QLog.e(h(), 1, "requestFeedListInPart invalid sortMode:" + reqParam.getSortMode());
            } else {
                gProStGetChannelFeedsReq.sortOption = 1;
            }
        } else {
            gProStGetChannelFeedsReq.sortOption = 2;
        }
        if (reqParam.d() != null) {
            gProStGetChannelFeedsReq.groupTransDataList = reqParam.d();
        }
        r(reqParam, gProStGetChannelFeedsReq, responseProcessor, new Function4<Integer, String, Boolean, a, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedListDataRepo$requestFeedListInPart$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, Boolean bool, a aVar) {
                invoke(num.intValue(), str, bool.booleanValue(), aVar);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @Nullable String str, boolean z16, @Nullable a aVar) {
                GProStGetChannelFeedsRsp gProGetChannelFeedsRsp;
                ArrayList<GProStFeed> arrayList;
                GuildFeedListDataRepo.this.j(str, i3 == 0, i3, z16, reqParam, (aVar == null || (gProGetChannelFeedsRsp = aVar.getGProGetChannelFeedsRsp()) == null || (arrayList = gProGetChannelFeedsRsp.vecFeedList) == null) ? 0 : arrayList.size());
            }
        });
    }

    public final void l(@NotNull final b<GProGetGuildFeedsReq> reqParam, @NotNull qx1.a<com.tencent.mobileqq.guild.feed.feedsquare.data.b> responseProcessor) {
        boolean z16;
        int i3;
        Intrinsics.checkNotNullParameter(reqParam, "reqParam");
        Intrinsics.checkNotNullParameter(responseProcessor, "responseProcessor");
        GProGetGuildFeedsReq gProGetGuildFeedsReq = new GProGetGuildFeedsReq();
        gProGetGuildFeedsReq.guildId = az.d(reqParam.getGuildId(), 0L);
        boolean z17 = false;
        gProGetGuildFeedsReq.from = 0;
        gProGetGuildFeedsReq.count = 12;
        gProGetGuildFeedsReq.feedAttchInfo = reqParam.getAttachInfo();
        int sortMode = reqParam.getSortMode();
        if (sortMode != 1) {
            if (sortMode != 2) {
                if (sortMode != 3) {
                    gProGetGuildFeedsReq.getType = 2;
                    gProGetGuildFeedsReq.sortOption = 1;
                    QLog.e(h(), 1, "requestFeedListInSquare invalid sortMode:" + reqParam.getSortMode());
                } else {
                    gProGetGuildFeedsReq.getType = 2;
                    gProGetGuildFeedsReq.sortOption = 1;
                }
            } else {
                gProGetGuildFeedsReq.getType = 1;
            }
        } else {
            gProGetGuildFeedsReq.getType = 2;
            gProGetGuildFeedsReq.sortOption = 2;
        }
        if (reqParam.getSortMode() == 3) {
            z16 = true;
        } else {
            z16 = false;
        }
        gProGetGuildFeedsReq.topFeedId = reqParam.getTopFeedId();
        gProGetGuildFeedsReq.topChannelId = az.d(reqParam.getTopChannelId(), 0L);
        if (gProGetGuildFeedsReq.getType == 1) {
            i3 = 79;
        } else {
            i3 = 80;
        }
        gProGetGuildFeedsReq.adReq = uj1.d.f439072a.n("guild", i3).toByteArray();
        gProGetGuildFeedsReq.topType = reqParam.getTopType();
        gProGetGuildFeedsReq.topBusinessId = reqParam.getTopBusinessId();
        gProGetGuildFeedsReq.needRecommendCard = z16;
        GProGuildFeedsFilter gProGuildFeedsFilter = new GProGuildFeedsFilter();
        gProGuildFeedsFilter.needHasFeedFlag = true;
        gProGuildFeedsFilter.needAdv = z16;
        gProGuildFeedsFilter.needHeadAdv = !reqParam.getIsLoadMore();
        gProGuildFeedsFilter.needLive = z16;
        gProGuildFeedsFilter.needVoice = z16;
        gProGuildFeedsFilter.needScheduler = z16;
        gProGuildFeedsFilter.needSysMsg = z16;
        if (z16 && !reqParam.getIsLoadMore()) {
            z17 = true;
        }
        gProGuildFeedsFilter.needSum = z17;
        gProGuildFeedsFilter.needTopInfo = !reqParam.getIsLoadMore();
        gProGetGuildFeedsReq.filter = gProGuildFeedsFilter;
        r(reqParam, gProGetGuildFeedsReq, responseProcessor, new Function4<Integer, String, Boolean, com.tencent.mobileqq.guild.feed.feedsquare.data.b, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedListDataRepo$requestFeedListInSquare$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, Boolean bool, b bVar) {
                invoke(num.intValue(), str, bool.booleanValue(), bVar);
                return Unit.INSTANCE;
            }

            public final void invoke(int i16, @Nullable String str, boolean z18, @Nullable b bVar) {
                GProGetGuildFeedsRsp gProGetGuildFeedsRsp;
                ArrayList<GProStFeed> arrayList;
                GuildFeedListDataRepo.this.j(str, i16 == 0, i16, z18, reqParam, (bVar == null || (gProGetGuildFeedsRsp = bVar.getGProGetGuildFeedsRsp()) == null || (arrayList = gProGetGuildFeedsRsp.vecFeedList) == null) ? 0 : arrayList.size());
            }
        });
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u000bB\u0095\u0001\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\u0006\u0010\u001d\u001a\u00020\t\u0012\u0006\u0010\u001f\u001a\u00020\t\u0012\u0006\u0010!\u001a\u00020\u0003\u0012\u0006\u0010$\u001a\u00020\u0003\u0012\u001c\b\u0002\u0010*\u001a\u0016\u0012\u0004\u0012\u00020&\u0018\u00010%j\n\u0012\u0004\u0012\u00020&\u0018\u0001`'\u0012\b\b\u0002\u0010-\u001a\u00020\u0006\u0012\b\b\u0002\u0010.\u001a\u00020\u0003\u0012\b\b\u0002\u00102\u001a\u00020/\u0012\u0010\b\u0002\u00106\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u000103\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0006\u0010\u0005\u001a\u00020\u0003J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0011\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u0017\u0010\u0014\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0013\u0010\u000eR\u0017\u0010\u0019\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001d\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001f\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001a\u001a\u0004\b\u0012\u0010\u001cR\u0017\u0010!\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b \u0010\f\u001a\u0004\b\u000b\u0010\u000eR\u0017\u0010$\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\f\u001a\u0004\b#\u0010\u000eR+\u0010*\u001a\u0016\u0012\u0004\u0012\u00020&\u0018\u00010%j\n\u0012\u0004\u0012\u00020&\u0018\u0001`'8\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010(\u001a\u0004\b\u0015\u0010)R\u0017\u0010-\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b+\u0010\u0016\u001a\u0004\b,\u0010\u0018R\u0017\u0010.\u001a\u00020\u00038\u0006\u00a2\u0006\f\n\u0004\b#\u0010\f\u001a\u0004\b+\u0010\u000eR\u0017\u00102\u001a\u00020/8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u00100\u001a\u0004\b \u00101R\u001f\u00106\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001038\u0006\u00a2\u0006\f\n\u0004\b,\u00104\u001a\u0004\b\"\u00105R\"\u00109\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001a\u001a\u0004\b\u001e\u0010\u001c\"\u0004\b7\u00108\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedListDataRepo$b;", "Request", "", "", "toString", "p", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "guildId", "b", "channelId", "c", "l", "topFeedId", "d", "I", "i", "()I", "sortMode", "Z", DomainData.DOMAIN_NAME, "()Z", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "f", "enableUseCache", "g", "attachInfo", tl.h.F, "k", "topChannelId", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "groupTransData", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, MiniChatConstants.MINI_APP_TOP_TYPE, "topBusinessId", "", "J", "()J", "reqSeq", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedListDataRepo$b$a;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedListDataRepo$b$a;", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedListDataRepo$b$a;", "requestHooker", "o", "(Z)V", "hasNotCacheFeedHandle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZZLjava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;ILjava/lang/String;JLcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedListDataRepo$b$a;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final /* data */ class b<Request> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String guildId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String channelId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String topFeedId;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final int sortMode;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean isLoadMore;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        private final boolean enableUseCache;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String attachInfo;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String topChannelId;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final ArrayList<byte[]> groupTransData;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata */
        private final int topType;

        /* renamed from: k, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String topBusinessId;

        /* renamed from: l, reason: collision with root package name and from kotlin metadata */
        private final long reqSeq;

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        @Nullable
        private final a<Request> requestHooker;

        /* renamed from: n, reason: collision with root package name and from kotlin metadata */
        private boolean hasNotCacheFeedHandle;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\u00020\u0002J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0001H&\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedListDataRepo$b$a;", "Request", "", Const.BUNDLE_KEY_REQUEST, "", "a", "(Ljava/lang/Object;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes13.dex */
        public interface a<Request> {
            void a(Request request);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(@NotNull String guildId, @NotNull String channelId, @NotNull String topFeedId, int i3, boolean z16, boolean z17, @NotNull String attachInfo, @NotNull String topChannelId, @Nullable ArrayList<byte[]> arrayList, int i16, @NotNull String topBusinessId, long j3, @Nullable a<? super Request> aVar) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            Intrinsics.checkNotNullParameter(topFeedId, "topFeedId");
            Intrinsics.checkNotNullParameter(attachInfo, "attachInfo");
            Intrinsics.checkNotNullParameter(topChannelId, "topChannelId");
            Intrinsics.checkNotNullParameter(topBusinessId, "topBusinessId");
            this.guildId = guildId;
            this.channelId = channelId;
            this.topFeedId = topFeedId;
            this.sortMode = i3;
            this.isLoadMore = z16;
            this.enableUseCache = z17;
            this.attachInfo = attachInfo;
            this.topChannelId = topChannelId;
            this.groupTransData = arrayList;
            this.topType = i16;
            this.topBusinessId = topBusinessId;
            this.reqSeq = j3;
            this.requestHooker = aVar;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getAttachInfo() {
            return this.attachInfo;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getEnableUseCache() {
            return this.enableUseCache;
        }

        @Nullable
        public final ArrayList<byte[]> d() {
            return this.groupTransData;
        }

        @NotNull
        /* renamed from: e, reason: from getter */
        public final String getGuildId() {
            return this.guildId;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (Intrinsics.areEqual(this.guildId, bVar.guildId) && Intrinsics.areEqual(this.channelId, bVar.channelId) && Intrinsics.areEqual(this.topFeedId, bVar.topFeedId) && this.sortMode == bVar.sortMode && this.isLoadMore == bVar.isLoadMore && this.enableUseCache == bVar.enableUseCache && Intrinsics.areEqual(this.attachInfo, bVar.attachInfo) && Intrinsics.areEqual(this.topChannelId, bVar.topChannelId) && Intrinsics.areEqual(this.groupTransData, bVar.groupTransData) && this.topType == bVar.topType && Intrinsics.areEqual(this.topBusinessId, bVar.topBusinessId) && this.reqSeq == bVar.reqSeq && Intrinsics.areEqual(this.requestHooker, bVar.requestHooker)) {
                return true;
            }
            return false;
        }

        /* renamed from: f, reason: from getter */
        public final boolean getHasNotCacheFeedHandle() {
            return this.hasNotCacheFeedHandle;
        }

        /* renamed from: g, reason: from getter */
        public final long getReqSeq() {
            return this.reqSeq;
        }

        @Nullable
        public final a<Request> h() {
            return this.requestHooker;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            int hashCode2 = ((((((this.guildId.hashCode() * 31) + this.channelId.hashCode()) * 31) + this.topFeedId.hashCode()) * 31) + this.sortMode) * 31;
            boolean z16 = this.isLoadMore;
            int i3 = 1;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            int i17 = (hashCode2 + i16) * 31;
            boolean z17 = this.enableUseCache;
            if (!z17) {
                i3 = z17 ? 1 : 0;
            }
            int hashCode3 = (((((i17 + i3) * 31) + this.attachInfo.hashCode()) * 31) + this.topChannelId.hashCode()) * 31;
            ArrayList<byte[]> arrayList = this.groupTransData;
            int i18 = 0;
            if (arrayList == null) {
                hashCode = 0;
            } else {
                hashCode = arrayList.hashCode();
            }
            int hashCode4 = (((((((hashCode3 + hashCode) * 31) + this.topType) * 31) + this.topBusinessId.hashCode()) * 31) + androidx.fragment.app.a.a(this.reqSeq)) * 31;
            a<Request> aVar = this.requestHooker;
            if (aVar != null) {
                i18 = aVar.hashCode();
            }
            return hashCode4 + i18;
        }

        /* renamed from: i, reason: from getter */
        public final int getSortMode() {
            return this.sortMode;
        }

        @NotNull
        /* renamed from: j, reason: from getter */
        public final String getTopBusinessId() {
            return this.topBusinessId;
        }

        @NotNull
        /* renamed from: k, reason: from getter */
        public final String getTopChannelId() {
            return this.topChannelId;
        }

        @NotNull
        /* renamed from: l, reason: from getter */
        public final String getTopFeedId() {
            return this.topFeedId;
        }

        /* renamed from: m, reason: from getter */
        public final int getTopType() {
            return this.topType;
        }

        /* renamed from: n, reason: from getter */
        public final boolean getIsLoadMore() {
            return this.isLoadMore;
        }

        public final void o(boolean z16) {
            this.hasNotCacheFeedHandle = z16;
        }

        @NotNull
        public final String p() {
            return "[reqSeq:" + this.reqSeq + " guildId:" + this.guildId + " channelId:" + this.channelId + " sortMode:" + this.sortMode + " isLoadMore:" + this.isLoadMore + "]";
        }

        @NotNull
        public String toString() {
            return "[reqSeq:" + this.reqSeq + " guildId:" + this.guildId + " channelId:" + this.channelId + " enableUseCache:" + this.enableUseCache + " topFeedId:" + this.topFeedId + " sortMode:" + this.sortMode + " isLoadMore:" + this.isLoadMore + " attachInfo:" + this.attachInfo.hashCode() + " topChannelId:" + this.topChannelId + " topType:" + this.topType + " topBusinessId:" + this.topBusinessId + "]";
        }

        public /* synthetic */ b(String str, String str2, String str3, int i3, boolean z16, boolean z17, String str4, String str5, ArrayList arrayList, int i16, String str6, long j3, a aVar, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, str3, i3, z16, z17, str4, str5, (i17 & 256) != 0 ? null : arrayList, (i17 & 512) != 0 ? 0 : i16, (i17 & 1024) != 0 ? "" : str6, (i17 & 2048) != 0 ? GuildFeedListDataRepo.INSTANCE.a().getAndIncrement() : j3, (i17 & 4096) != 0 ? null : aVar);
        }
    }
}
