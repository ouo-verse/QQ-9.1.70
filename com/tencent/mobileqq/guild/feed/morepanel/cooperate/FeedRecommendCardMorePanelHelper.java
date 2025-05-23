package com.tencent.mobileqq.guild.feed.morepanel.cooperate;

import android.app.Activity;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDeleteEvent;
import com.tencent.mobileqq.guild.feed.util.ad;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.media.thirdapp.share.GuildMediaShareActionSheet;
import com.tencent.mobileqq.guild.share.m;
import com.tencent.mobileqq.guild.share.shorturl.ShareServiceType;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTopFeedActionReq;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import sy1.a;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/cooperate/FeedRecommendCardMorePanelHelper;", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "feed", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/guild/share/m;", "actionSheet", "f", tl.h.F, "Lcom/tencent/mobileqq/guild/share/m$e;", "j", "i", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Landroid/app/Activity;)V", "b", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedRecommendCardMorePanelHelper {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity activity;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/morepanel/cooperate/FeedRecommendCardMorePanelHelper$a;", "", "", "guildId", "feedId", "", "topTimestamp", "", "b", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.morepanel.cooperate.FeedRecommendCardMorePanelHelper$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean b(String guildId, String feedId, long topTimestamp) {
            boolean z16;
            Boolean e16 = yl1.i.e(yl1.i.f450608a, guildId, feedId, null, 4, null);
            if (e16 == null) {
                if (topTimestamp > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                e16 = Boolean.valueOf(z16);
            }
            return e16.booleanValue();
        }

        Companion() {
        }
    }

    public FeedRecommendCardMorePanelHelper(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activity = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(com.tencent.mobileqq.guild.share.m actionSheet, final GProStFeed feed) {
        boolean z16;
        int i3;
        String valueOf = String.valueOf(feed.channelInfo.sign.guildId);
        String valueOf2 = String.valueOf(feed.channelInfo.sign.channelId);
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        if (ch.m0(valueOf)) {
            Companion companion = INSTANCE;
            String str = feed.idd;
            Intrinsics.checkNotNullExpressionValue(str, "feed.idd");
            if (companion.b(valueOf, str, feed.topInfo.topTimestamp)) {
                i3 = 243;
            } else {
                i3 = 242;
            }
            actionSheet.d(i3, j(feed));
        }
        if (!iGPSService.getGuildPermission(valueOf).a(30002) && !iGPSService.getChannelPermission(valueOf, valueOf2).a(30002)) {
            z16 = false;
        } else {
            z16 = true;
        }
        boolean areEqual = Intrinsics.areEqual(feed.poster.idd, iGPSService.getSelfTinyId());
        actionSheet.d(1, null);
        if (z16 || areEqual) {
            actionSheet.d(40, new m.e() { // from class: com.tencent.mobileqq.guild.feed.morepanel.cooperate.h
                @Override // com.tencent.mobileqq.guild.share.m.e
                public final void a(int i16) {
                    FeedRecommendCardMorePanelHelper.g(FeedRecommendCardMorePanelHelper.this, feed, i16);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(FeedRecommendCardMorePanelHelper this$0, GProStFeed feed, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(feed, "$feed");
        if (i3 == 40) {
            this$0.h(feed);
        }
    }

    private final void h(GProStFeed feed) {
        final String feedId = feed.idd;
        final String valueOf = String.valueOf(feed.channelInfo.sign.guildId);
        final String valueOf2 = String.valueOf(feed.channelInfo.sign.channelId);
        ad adVar = ad.f223828a;
        Activity activity = this.activity;
        GProStChannelSign gProStChannelSign = feed.channelInfo.sign;
        long j3 = gProStChannelSign.guildId;
        long j16 = gProStChannelSign.channelId;
        Intrinsics.checkNotNullExpressionValue(feedId, "feedId");
        String str = feed.poster.idd;
        Intrinsics.checkNotNullExpressionValue(str, "feed.poster.idd");
        adVar.f(new ad.FeedDeleteArgs(activity, j3, j16, feedId, str, feed.createTime, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.morepanel.cooperate.FeedRecommendCardMorePanelHelper$doItemDelete$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                SimpleEventBus.getInstance().dispatchEvent(new GuildFeedDeleteEvent(feedId, valueOf, valueOf2));
            }
        }, null));
    }

    private final m.e j(final GProStFeed feed) {
        return new m.e() { // from class: com.tencent.mobileqq.guild.feed.morepanel.cooperate.j
            @Override // com.tencent.mobileqq.guild.share.m.e
            public final void a(int i3) {
                FeedRecommendCardMorePanelHelper.k(GProStFeed.this, i3);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(GProStFeed feed, int i3) {
        boolean z16;
        Intrinsics.checkNotNullParameter(feed, "$feed");
        if (i3 == 243) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (com.tencent.mobileqq.guild.feed.util.l.c() == null) {
            return;
        }
        GProTopFeedActionReq gProTopFeedActionReq = new GProTopFeedActionReq();
        GProStChannelSign gProStChannelSign = feed.channelInfo.sign;
        gProTopFeedActionReq.guildId = gProStChannelSign.guildId;
        gProTopFeedActionReq.channelId = gProStChannelSign.channelId;
        gProTopFeedActionReq.feedId = feed.idd;
        gProTopFeedActionReq.userId = feed.poster.idd;
        gProTopFeedActionReq.cardType = feed.recommendCard.cardType;
        yl1.h.f450607a.h(z16, gProTopFeedActionReq, false);
    }

    private final void l(final GProStFeed feed) {
        GuildMainFrameUtils.g(String.valueOf(feed.channelInfo.sign.guildId), String.valueOf(feed.channelInfo.sign.channelId), 0, "", false, new Function1<GuildMainFrameUtils.GuildAndChannelInfoRsp, Unit>() { // from class: com.tencent.mobileqq.guild.feed.morepanel.cooperate.FeedRecommendCardMorePanelHelper$shareForLiveChannel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildMainFrameUtils.GuildAndChannelInfoRsp guildAndChannelInfoRsp) {
                invoke2(guildAndChannelInfoRsp);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GuildMainFrameUtils.GuildAndChannelInfoRsp rsp) {
                Activity activity;
                Activity activity2;
                Intrinsics.checkNotNullParameter(rsp, "rsp");
                if (rsp.l() && rsp.h() != null && rsp.getChannelInfo() != null) {
                    activity = FeedRecommendCardMorePanelHelper.this.activity;
                    if (!activity.isFinishing()) {
                        activity2 = FeedRecommendCardMorePanelHelper.this.activity;
                        IGProGuildInfo h16 = rsp.h();
                        Intrinsics.checkNotNull(h16);
                        com.tencent.mobileqq.guild.share.m mVar = new com.tencent.mobileqq.guild.share.m(activity2, h16, rsp.getChannelInfo(), GuildSharePageSource.LIVE_CHANNEL, "pindao_card", ShareServiceType.LIVE);
                        FeedRecommendCardMorePanelHelper.this.f(mVar, feed);
                        mVar.z();
                        return;
                    }
                }
                QLog.e("FeedRecommendCardMorePanelHelper", 1, "shareForLiveChannel fetchGuildAndChannelInfo fail.");
            }
        });
    }

    private final void m(final GProStFeed feed) {
        GuildMainFrameUtils.g(String.valueOf(feed.channelInfo.sign.guildId), String.valueOf(feed.channelInfo.sign.channelId), 0, "", false, new Function1<GuildMainFrameUtils.GuildAndChannelInfoRsp, Unit>() { // from class: com.tencent.mobileqq.guild.feed.morepanel.cooperate.FeedRecommendCardMorePanelHelper$shareForMediaChannel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildMainFrameUtils.GuildAndChannelInfoRsp guildAndChannelInfoRsp) {
                invoke2(guildAndChannelInfoRsp);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull GuildMainFrameUtils.GuildAndChannelInfoRsp rsp) {
                Activity activity;
                Activity activity2;
                Intrinsics.checkNotNullParameter(rsp, "rsp");
                if (rsp.l() && rsp.h() != null && rsp.getChannelInfo() != null) {
                    activity = FeedRecommendCardMorePanelHelper.this.activity;
                    if (!activity.isFinishing()) {
                        activity2 = FeedRecommendCardMorePanelHelper.this.activity;
                        IGProGuildInfo h16 = rsp.h();
                        Intrinsics.checkNotNull(h16);
                        GuildMediaShareActionSheet guildMediaShareActionSheet = new GuildMediaShareActionSheet(activity2, h16, rsp.getChannelInfo(), GuildMediaShareActionSheet.ShareScene.FEED_RECOMMEND_CARD, "pindao_card");
                        FeedRecommendCardMorePanelHelper.this.f(guildMediaShareActionSheet, feed);
                        guildMediaShareActionSheet.z();
                        return;
                    }
                }
                QLog.e("FeedRecommendCardMorePanelHelper", 1, "shareForMediaChannel fetchGuildAndChannelInfo fail.");
            }
        });
    }

    private final void n(final GProStFeed feed) {
        boolean z16;
        boolean z17;
        String valueOf = String.valueOf(feed.channelInfo.sign.guildId);
        String valueOf2 = String.valueOf(feed.channelInfo.sign.channelId);
        GuildScheduleInfo f16 = ij1.c.f(feed.recommendCard.data);
        IGPSService iGPSService = (IGPSService) ch.R0(IGPSService.class);
        IGProGuildInfo guildInfo = iGPSService.getGuildInfo(valueOf);
        IGProChannelInfo channelInfo = iGPSService.getChannelInfo(valueOf2);
        if (guildInfo != null && channelInfo != null && f16 != null) {
            QLog.d("FeedRecommendCardMorePanelHelper", 1, "shareForScheduleDetail " + valueOf + " " + valueOf2 + " " + f16.getScheduleId());
            sy1.a.e(this.activity, guildInfo, channelInfo, f16, true, new a.b() { // from class: com.tencent.mobileqq.guild.feed.morepanel.cooperate.i
                @Override // sy1.a.b
                public final void a(com.tencent.mobileqq.guild.share.m mVar) {
                    FeedRecommendCardMorePanelHelper.o(FeedRecommendCardMorePanelHelper.this, feed, mVar);
                }
            });
            return;
        }
        boolean z18 = false;
        if (guildInfo == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (channelInfo == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (f16 == null) {
            z18 = true;
        }
        QLog.e("FeedRecommendCardMorePanelHelper", 1, "shareForScheduleDetail " + valueOf + "-" + z16 + "-" + valueOf2 + "-" + z17 + ContainerUtils.KEY_VALUE_DELIMITER + z18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(FeedRecommendCardMorePanelHelper this$0, GProStFeed feed, com.tencent.mobileqq.guild.share.m shareActionSheet) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(feed, "$feed");
        Intrinsics.checkNotNullParameter(shareActionSheet, "shareActionSheet");
        this$0.f(shareActionSheet, feed);
    }

    public final void i(@NotNull GProStFeed feed) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        int i3 = feed.recommendCard.cardType;
        QLog.i("FeedRecommendCardMorePanelHelper", 1, "handleRecommendCardShare type:" + i3);
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    n(feed);
                    return;
                }
                return;
            }
            l(feed);
            return;
        }
        m(feed);
    }
}
