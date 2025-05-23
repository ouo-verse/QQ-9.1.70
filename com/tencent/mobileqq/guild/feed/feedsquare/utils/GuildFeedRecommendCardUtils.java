package com.tencent.mobileqq.guild.feed.feedsquare.utils;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildChannelInfoApi;
import com.tencent.mobileqq.guild.api.ILaunchGuildChatPieApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.live.model.GLiveChannelStartParams;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.schedule.detail.GuildScheduleDetailFragment;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.ag;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Function0;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.af;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J$\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J,\u0010\u0011\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0002J\"\u0010\u0014\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006J\"\u0010\u0016\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/GuildFeedRecommendCardUtils;", "", "", "d", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "feedJoinParam", "e", "Landroid/content/Context;", "context", tl.h.F, "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStChannelSign;", "sign", "", "scheduleId", "joinInfoParam", "k", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/c;", "feed", "j", "f", "i", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedRecommendCardUtils {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildFeedRecommendCardUtils f219300a = new GuildFeedRecommendCardUtils();

    GuildFeedRecommendCardUtils() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        QLog.e("GuildFeedRecommendCardUtils", 1, "jump2RecommendCardDetail fail, fetchChannelInfoAnyway is null.");
        Function0.d(new kotlin.jvm.functions.Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedRecommendCardUtils$handleFetchChannelInfoError$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                QQToast.makeText(BaseApplication.getContext(), R.string.f143830n5, 0).show();
            }
        });
    }

    private final void e(IGProChannelInfo channelInfo, JumpGuildParam.JoinInfoParam feedJoinParam) {
        QLog.i("GuildFeedRecommendCardUtils", 1, "jump2LiveChannel, channelId:" + channelInfo.getChannelUin());
        GLiveChannelStartParams f16 = GLiveChannelStartParams.Companion.f(GLiveChannelStartParams.INSTANCE, channelInfo, null, 2, null);
        Bundle bundle = o02.a.a(11);
        if (feedJoinParam == null) {
            QLog.e("GuildFeedRecommendCardUtils", 1, "jump2LiveChannel, feedJoinParam is empty!");
        } else {
            bundle.putParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM, feedJoinParam);
        }
        Intrinsics.checkNotNullExpressionValue(bundle, "bundle");
        f16.setBundle(bundle);
        gq1.c.e(f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(IGProChannelInfo channelInfo, JumpGuildParam.JoinInfoParam joinInfoParam, int i3, String str, List list, List list2, int i16) {
        boolean z16;
        Intrinsics.checkNotNullParameter(channelInfo, "$channelInfo");
        if (i3 != 0) {
            QQToastUtil.showQQToastInUiThread(1, str);
            QLog.e("GuildFeedRecommendCardUtils", 1, "jump2LiveChannel failed, " + i3 + "-" + str + ", size: " + list.size());
            return;
        }
        List list3 = list;
        if (list3 != null && !list3.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && !Intrinsics.areEqual(((ILiveRoomInfo) list.get(0)).getRoomId(), "0")) {
            f219300a.e(channelInfo, joinInfoParam);
            return;
        }
        QQToastUtil.showQQToastInUiThread(1, "\u76f4\u64ad\u5df2\u7ed3\u675f");
        QLog.e("GuildFeedRecommendCardUtils", 1, "jump2LiveChannel failed, roomInfoList: " + list);
    }

    private final void h(final IGProChannelInfo channelInfo, final Context context, JumpGuildParam.JoinInfoParam feedJoinParam) {
        QLog.i("GuildFeedRecommendCardUtils", 1, "jump2MediaChannel, channelId:" + channelInfo.getChannelUin());
        final Bundle bundle = new Bundle();
        if (feedJoinParam == null) {
            QLog.e("GuildFeedRecommendCardUtils", 1, "jump2MediaChannel, feedJoinParam is empty!");
        } else {
            bundle.putParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM, feedJoinParam);
        }
        String guildId = channelInfo.getGuildId();
        Intrinsics.checkNotNullExpressionValue(guildId, "channelInfo.guildId");
        GuildMainFrameUtils.k(guildId, new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedRecommendCardUtils$jump2MediaChannel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo) {
                invoke2(iGProGuildInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable IGProGuildInfo iGProGuildInfo) {
                if (iGProGuildInfo == null) {
                    QLog.e("GuildFeedRecommendCardUtils", 1, "jump2MediaChannel fail, fetchGuildInfoAnyway is null.");
                } else {
                    ((ILaunchGuildChatPieApi) QRoute.api(ILaunchGuildChatPieApi.class)).launchMediaChannel(context, iGProGuildInfo, channelInfo, bundle);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(Context context, GProStChannelSign sign, String scheduleId, JumpGuildParam.JoinInfoParam joinInfoParam) {
        JumpGuildParam jumpGuildParam = new JumpGuildParam(String.valueOf(sign.guildId), String.valueOf(sign.channelId), sign.joinGuildSig, "pindao_box", "recommend_join");
        boolean z16 = false;
        if (joinInfoParam != null && joinInfoParam.isValid()) {
            z16 = true;
        }
        if (z16) {
            jumpGuildParam.setJoinInfoParam(joinInfoParam);
        }
        GuildScheduleDetailFragment.bi(context, scheduleId, jumpGuildParam);
    }

    public final void f(@NotNull final IGProChannelInfo channelInfo, @Nullable final JumpGuildParam.JoinInfoParam joinInfoParam) {
        ArrayList<String> arrayListOf;
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        ag.a g16 = new ag.a().g(channelInfo.getGuildId());
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(channelInfo.getChannelUin());
        ((IGPSService) ch.R0(IGPSService.class)).fetchLiveRoomInfo(g16.f(arrayListOf).e(), new af() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.utils.h
            @Override // vh2.af
            public final void a(int i3, String str, List list, List list2, int i16) {
                GuildFeedRecommendCardUtils.g(IGProChannelInfo.this, joinInfoParam, i3, str, list, list2, i16);
            }
        });
    }

    public final void i(@Nullable Context context, @NotNull IGProChannelInfo channelInfo, @Nullable JumpGuildParam.JoinInfoParam joinInfoParam) {
        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
        h(channelInfo, context, joinInfoParam);
    }

    public final void j(@Nullable final Context context, @NotNull final c feed, @Nullable final JumpGuildParam.JoinInfoParam joinInfoParam) {
        Intrinsics.checkNotNullParameter(feed, "feed");
        ((IGuildChannelInfoApi) QRoute.api(IGuildChannelInfoApi.class)).fetchChannelInfoAnyway(String.valueOf(feed.a().guildId), String.valueOf(feed.a().channelId), new Function1<IGProChannelInfo, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedRecommendCardUtils$jump2RecommendCardDetail$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IGProChannelInfo iGProChannelInfo) {
                invoke2(iGProChannelInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable IGProChannelInfo iGProChannelInfo) {
                if (iGProChannelInfo == null) {
                    GuildFeedRecommendCardUtils.f219300a.d();
                    return;
                }
                int b16 = c.this.b();
                if (b16 == 1) {
                    GuildFeedRecommendCardUtils.f219300a.i(context, iGProChannelInfo, joinInfoParam);
                    return;
                }
                if (b16 == 2) {
                    GuildFeedRecommendCardUtils.f219300a.f(iGProChannelInfo, joinInfoParam);
                    return;
                }
                if (b16 == 3) {
                    GuildFeedRecommendCardUtils.f219300a.k(context, c.this.a(), String.valueOf(c.this.getScheduleId()), joinInfoParam);
                    return;
                }
                QLog.e("GuildFeedRecommendCardUtils", 1, "jump2RecommendCardDetail fail, card type:" + c.this.b());
            }
        });
    }
}
