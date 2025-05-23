package com.tencent.mobileqq.guild.api.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.be;
import com.tencent.mobileqq.guild.api.IGuildMiniProgramApi;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.api.IGuildWebApi;
import com.tencent.mobileqq.guild.data.GuildFeedJumpData;
import com.tencent.mobileqq.guild.data.GuildJumpBaseData;
import com.tencent.mobileqq.guild.data.GuildJumpData;
import com.tencent.mobileqq.guild.data.GuildLiveJumpData;
import com.tencent.mobileqq.guild.data.GuildScheduleJumpData;
import com.tencent.mobileqq.guild.discover.f;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.GuildShareUrlParam;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.live.model.GLiveChannelStartParams;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\fH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000eH\u0016J\u0012\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildMiniProgramApiImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildMiniProgramApi;", "Lcom/tencent/mobileqq/guild/data/e;", "data", "", "jumpToGuild", "Lcom/tencent/mobileqq/guild/data/d;", "jumpBean", "", "traceId", "Lcom/tencent/mobileqq/guild/data/f;", "jumpToLiveRoom", "Lcom/tencent/mobileqq/guild/data/c;", "jumpToFeed", "Lcom/tencent/mobileqq/guild/data/i;", "jumpToSchedule", "url", "jumpToWebBrowser", "Ljava/lang/Runnable;", "sucRunnable", "joinGuild", "", "getJoinedGuildCount", "<init>", "()V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildMiniProgramApiImpl implements IGuildMiniProgramApi {

    @NotNull
    private static final String TAG = "Guild.jump.GuildMiniProgramService";

    @Override // com.tencent.mobileqq.guild.api.IGuildMiniProgramApi
    public int getJoinedGuildCount() {
        be obtainGuildMainFrame = ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).obtainGuildMainFrame();
        int i3 = 0;
        if (obtainGuildMainFrame instanceof com.tencent.mobileqq.guild.mainframe.s) {
            IRuntimeService runtimeService = obtainGuildMainFrame.getActivity().getAppRuntime().getRuntimeService(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "frame.activity.appRuntim\u2026va, ProcessConstant.MAIN)");
            List<IGProGuildInfo> guildList = ((IGPSService) runtimeService).getGuildList();
            if (guildList != null) {
                i3 = guildList.size();
            }
        }
        QLog.i(TAG, 1, "[getJoinedGuildCount] count = " + i3);
        return i3;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildMiniProgramApi
    public void joinGuild(@NotNull GuildJumpBaseData data, @NotNull Runnable sucRunnable) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(sucRunnable, "sucRunnable");
        QLog.d(TAG, 1, "[joinGuild] " + data);
        JumpGuildParam a16 = com.tencent.mobileqq.guild.discover.c.INSTANCE.a(data);
        a16.getJoinInfoParam().setPageEntranceId(1);
        boolean isGuildTabSelected = ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isGuildTabSelected() ^ true;
        f.Companion companion = com.tencent.mobileqq.guild.discover.f.INSTANCE;
        Context i3 = ch.i();
        Intrinsics.checkNotNullExpressionValue(i3, "appContext()");
        companion.b(i3, a16, isGuildTabSelected, false, sucRunnable);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildMiniProgramApi
    public void jumpToFeed(@NotNull GuildFeedJumpData data) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(data, "data");
        boolean z18 = true;
        QLog.d(TAG, 1, "[jumpToFeed] data = " + data);
        String shareUrl = data.getShareUrl();
        if (shareUrl != null && shareUrl.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            String shareUrl2 = data.getShareUrl();
            Intrinsics.checkNotNull(shareUrl2);
            GuildJumpUtil.m(BaseApplication.context, new GuildShareUrlParam(shareUrl2));
            return;
        }
        Activity currentTopActivity = ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).getCurrentTopActivity();
        String mainSource = data.getMainSource();
        if (mainSource.length() == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            mainSource = "share";
        }
        String subSource = data.getSubSource();
        if (subSource.length() != 0) {
            z18 = false;
        }
        if (z18) {
            subSource = "others";
        }
        JumpGuildParam.JoinInfoParam joinInfoParam = new JumpGuildParam.JoinInfoParam("", data.getJoinSign(), mainSource, subSource);
        if (currentTopActivity == null) {
            QRouteApi api = QRoute.api(IGuildFeedLauncherApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IGuildFeedLauncherApi::class.java)");
            IGuildFeedLauncherApi iGuildFeedLauncherApi = (IGuildFeedLauncherApi) api;
            BaseApplication baseApplication = BaseApplication.context;
            Bundle bundle = new Bundle();
            bundle.putString("guildId", data.getGuildId());
            bundle.putString("channelId", data.getChannelId());
            bundle.putString("posterTinyId", data.getPosterTinyId());
            bundle.putString("feedId", data.getFeedId());
            bundle.putInt("shareSource", data.getShareSource());
            bundle.putLong(WadlProxyConsts.CREATE_TIME, data.getCreateTime());
            bundle.putString("visitorTinyId", ch.g());
            bundle.putParcelable("joinInfoParam", joinInfoParam);
            GuildAppReportSourceInfo guildAppReportSourceInfo = new GuildAppReportSourceInfo();
            guildAppReportSourceInfo.addReportItem(JumpGuildParam.EXTRA_KEY_TRACE_ID, data.getTraceId());
            guildAppReportSourceInfo.addReportItem("sgrp_stream_pgin_source_name", data.getPginSource());
            Unit unit = Unit.INSTANCE;
            bundle.putParcelable("jumpExtraInfo", guildAppReportSourceInfo);
            IGuildFeedLauncherApi.a.a(iGuildFeedLauncherApi, baseApplication, bundle, false, 4, null);
            return;
        }
        QRouteApi api2 = QRoute.api(IGuildFeedLauncherApi.class);
        Intrinsics.checkNotNullExpressionValue(api2, "api(IGuildFeedLauncherApi::class.java)");
        Bundle bundle2 = new Bundle();
        bundle2.putString("guildId", data.getGuildId());
        bundle2.putString("channelId", data.getChannelId());
        bundle2.putString("posterTinyId", data.getPosterTinyId());
        bundle2.putString("feedId", data.getFeedId());
        bundle2.putInt("shareSource", data.getShareSource());
        bundle2.putLong(WadlProxyConsts.CREATE_TIME, data.getCreateTime());
        bundle2.putString("visitorTinyId", ch.g());
        bundle2.putParcelable("joinInfoParam", joinInfoParam);
        GuildAppReportSourceInfo guildAppReportSourceInfo2 = new GuildAppReportSourceInfo();
        guildAppReportSourceInfo2.addReportItem(JumpGuildParam.EXTRA_KEY_TRACE_ID, data.getTraceId());
        guildAppReportSourceInfo2.addReportItem("sgrp_stream_pgin_source_name", data.getPginSource());
        Unit unit2 = Unit.INSTANCE;
        bundle2.putParcelable("jumpExtraInfo", guildAppReportSourceInfo2);
        IGuildFeedLauncherApi.a.a((IGuildFeedLauncherApi) api2, currentTopActivity, bundle2, false, 4, null);
        currentTopActivity.overridePendingTransition(0, 0);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildMiniProgramApi
    public void jumpToGuild(@NotNull GuildJumpData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.d(TAG, 1, "[jumpToGuild] data = " + data);
        Bundle bundle = new Bundle();
        bundle.putBoolean("share_element_info_from", true);
        bundle.putString("share_element_info_view_url", data.getCoverUrl());
        bundle.putString("share_element_info_head_url", QQGuildUIUtil.E(data.getIcon(), 100));
        bundle.putString("share_element_info_guild_name", data.getName());
        JumpGuildParam jumpGuildParam = new JumpGuildParam(data.getGuildId(), data.getChannelId(), data.getJoinSign(), data.getMainSource(), data.getSubSource());
        jumpGuildParam.extras.putAll(bundle);
        GuildAppReportSourceInfo guildAppReportSourceInfo = new GuildAppReportSourceInfo();
        guildAppReportSourceInfo.addReportItem(JumpGuildParam.EXTRA_KEY_TRACE_ID, data.getTraceId());
        guildAppReportSourceInfo.addReportItem("sgrp_stream_pgin_source_name", data.getPginSource());
        jumpGuildParam.setReportSourceInfo(guildAppReportSourceInfo);
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        GuildJumpUtil.n(context, jumpGuildParam);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildMiniProgramApi
    public void jumpToLiveRoom(@NotNull GuildLiveJumpData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.i(TAG, 1, "[jumpToLiveRoom] data = " + data);
        JumpGuildParam.JoinInfoParam joinInfoParam = new JumpGuildParam.JoinInfoParam(data.getChannelId(), data.getJoinSign(), data.getMainSource(), data.getSubSource());
        Bundle bundle = o02.a.a(data.getEnterSource());
        bundle.putString("guild_id", String.valueOf(data.getGuildId()));
        bundle.putParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM, joinInfoParam);
        GuildAppReportSourceInfo guildAppReportSourceInfo = new GuildAppReportSourceInfo();
        guildAppReportSourceInfo.addReportItem(JumpGuildParam.EXTRA_KEY_TRACE_ID, data.getTraceId());
        guildAppReportSourceInfo.addReportItem("sgrp_stream_pgin_source_name", data.getPginSource());
        Unit unit = Unit.INSTANCE;
        bundle.putParcelable("GuildAppReportSourceInfo", guildAppReportSourceInfo);
        GLiveChannelStartParams b16 = GLiveChannelStartParams.INSTANCE.b(data);
        Intrinsics.checkNotNullExpressionValue(bundle, "bundle");
        b16.setBundle(bundle);
        gq1.c.e(b16);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildMiniProgramApi
    public void jumpToSchedule(@NotNull GuildScheduleJumpData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.i(TAG, 1, "[jumpToSchedule] " + data + " ");
        JumpGuildParam jumpGuildParam = new JumpGuildParam(data.getGuildId(), data.getChannelId(), data.getJoinSign(), data.getMainSource(), data.getSubSource());
        o02.a.f(data.getEnterSource());
        com.tencent.mobileqq.guild.mainframe.helper.jump.g.a(BaseApplication.context, jumpGuildParam, data.getScheduleId(), data.getShareUrl(), null);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildMiniProgramApi
    public void jumpToWebBrowser(@Nullable String url) {
        QLog.i(TAG, 1, "[jumpToWebBrowser] url = " + url);
        QRouteApi api = QRoute.api(IGuildWebApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildWebApi::class.java)");
        IGuildWebApi.a.a((IGuildWebApi) api, null, url, null, null, null, 28, null);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildMiniProgramApi
    public void jumpToGuild(@NotNull GuildJumpBaseData jumpBean, @NotNull String traceId) {
        Intrinsics.checkNotNullParameter(jumpBean, "jumpBean");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        JumpGuildParam jumpGuildParam = new JumpGuildParam(jumpBean.getGuildId(), jumpBean.getChannelId(), jumpBean.getJoinSign(), jumpBean.getMainSource(), jumpBean.getSubSource());
        GuildAppReportSourceInfo guildAppReportSourceInfo = new GuildAppReportSourceInfo();
        guildAppReportSourceInfo.addReportItem("sgrp_stream_pgin_source_name", jumpBean.getPginSource());
        guildAppReportSourceInfo.addReportItem(JumpGuildParam.EXTRA_KEY_TRACE_ID, traceId);
        jumpGuildParam.setReportSourceInfo(guildAppReportSourceInfo);
        BaseApplication context = BaseApplication.context;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        GuildJumpUtil.n(context, jumpGuildParam);
    }
}
