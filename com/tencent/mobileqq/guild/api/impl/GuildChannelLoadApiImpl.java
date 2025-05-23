package com.tencent.mobileqq.guild.api.impl;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.guild.api.IGuildChannelLoadApi;
import com.tencent.mobileqq.guild.channel.frame.manager.GuildSubscribePollingManage;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.debug.GuildJumpDebugUtils;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import java.util.Map;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildChannelLoadApiImpl implements IGuildChannelLoadApi {
    public static final String TAG = "Guild.jump.GuildChannelLoadApiImpl";

    private boolean loadGuildChannel(Context context, JumpGuildParam jumpGuildParam, int i3) {
        IGProChannelInfo C = ch.C(ch.l(), jumpGuildParam.getGuildId(), jumpGuildParam.getChannelId());
        if (C == null) {
            QLog.e(TAG, 1, "launchGuildChannel: channel info is null.guildId[" + jumpGuildParam.getGuildId() + "] channelId[" + jumpGuildParam.getChannelId() + "]");
            return false;
        }
        QLog.d(TAG, 1, "launchGuildChannel: guildId[" + jumpGuildParam.getGuildId() + "] channelId[" + jumpGuildParam.getChannelId() + "] type[" + C.getType() + "] from=" + i3);
        jumpGuildParam.setChannelLoadFrom(i3);
        jumpGuildParam.setReportSourceInfo(supplyReportSourceInfo(jumpGuildParam));
        GuildJumpDebugUtils.a("GUILD_JUMP", "GuildChannelLoadApiImpl::loadGuildChannel() jumpGuildParam", jumpGuildParam);
        return sf1.b.d(context, jumpGuildParam);
    }

    private GuildAppReportSourceInfo mergeParamsForDiscoverSearch(String str, GuildAppReportSourceInfo guildAppReportSourceInfo) {
        if (guildAppReportSourceInfo != null && !guildAppReportSourceInfo.getGuildReportParams(str).isEmpty()) {
            guildAppReportSourceInfo = guildAppReportSourceInfo.copy();
            for (Map.Entry<String, Object> entry : guildAppReportSourceInfo.getGuildReportParams(str).entrySet()) {
                if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                    guildAppReportSourceInfo.addReportItem(entry.getKey(), entry.getValue().toString());
                }
            }
        }
        return guildAppReportSourceInfo;
    }

    @Nullable
    private GuildAppReportSourceInfo supplyReportSourceInfo(JumpGuildParam jumpGuildParam) {
        GuildAppReportSourceInfo reportSourceInfo = jumpGuildParam.getReportSourceInfo();
        if (reportSourceInfo == null) {
            reportSourceInfo = (GuildAppReportSourceInfo) jumpGuildParam.getExtras().getParcelable("GuildAppReportSourceInfo");
            QLog.e(TAG, 1, "GuildAppReportSourceInfo\u5e94\u8be5\u901a\u8fc7JoinGuildParam.setReportSourceInfo\u8bbe\u7f6e\uff0cfrom SOURCE_INFO_EXTRA_KEY", new Exception());
        }
        if (reportSourceInfo == null || reportSourceInfo.reportItemsIsEmpty()) {
            AppSetting.isDebugVersion();
        }
        GuildAppReportSourceInfo mergeParamsForDiscoverSearch = mergeParamsForDiscoverSearch(jumpGuildParam.getGuildId(), reportSourceInfo);
        if (mergeParamsForDiscoverSearch != null && TextUtils.isEmpty(mergeParamsForDiscoverSearch.getPageInSourceName())) {
            mergeParamsForDiscoverSearch.addReportItem("sgrp_stream_pgin_source_name", com.tencent.mobileqq.guild.report.b.c());
        }
        return mergeParamsForDiscoverSearch;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildChannelLoadApi
    public void destroyChannelUpdateManager() {
        GuildSubscribePollingManage.f214907d.m();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildChannelLoadApi
    public void initChannelUpdateManager(AppRuntime appRuntime) {
        GuildSubscribePollingManage.f214907d.p(appRuntime);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildChannelLoadApi
    public boolean loadGuildChannelFromSplash(Context context, JumpGuildParam jumpGuildParam) {
        if (ch.C(ch.l(), jumpGuildParam.getGuildId(), jumpGuildParam.getChannelId()) == null) {
            QLog.e(TAG, 1, "loadGuildChannelFromSplash: channel info is null.guildId[" + jumpGuildParam.getGuildId() + "] channelId[" + jumpGuildParam.getChannelId() + "]");
            return false;
        }
        if (jumpGuildParam.getJoinInfoParam().isValid()) {
            jumpGuildParam.getJoinInfoParam().saveTo(jumpGuildParam.extras);
        }
        if (jumpGuildParam.getReportSourceInfo() != null && !jumpGuildParam.getReportSourceInfo().reportItemsIsEmpty()) {
            jumpGuildParam.getReportSourceInfo().saveTo(jumpGuildParam.extras);
        }
        dq1.k.b(jumpGuildParam.guildId, jumpGuildParam.getChannelId(), jumpGuildParam.getExtras()).jump(context);
        return true;
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildChannelLoadApi
    public boolean loadGuildChannelWithFullGuild(Context context, JumpGuildParam jumpGuildParam) {
        return loadGuildChannel(context, jumpGuildParam, 3);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildChannelLoadApi
    public boolean loadGuildChannelWithMsgListTab(Context context, JumpGuildParam jumpGuildParam) {
        return loadGuildChannel(context, jumpGuildParam, 1);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildChannelLoadApi
    public boolean loadGuildDirectMessageAio(Context context, JumpGuildParam jumpGuildParam, int i3) {
        QLog.i(TAG, 1, "loadGuildDirectMessageAio: guildId[" + jumpGuildParam.getGuildId() + "] channelId[" + jumpGuildParam.getChannelId() + "]");
        jumpGuildParam.setChannelLoadFrom(i3);
        jumpGuildParam.setReportSourceInfo(supplyReportSourceInfo(jumpGuildParam));
        return sf1.b.d(context, jumpGuildParam);
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildChannelLoadApi
    public void notifyGuildHelperDestroy() {
        GuildSubscribePollingManage.f214907d.r();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildChannelLoadApi
    public void onConversationTabChanged(boolean z16) {
        if (z16) {
            GuildSubscribePollingManage.f214907d.t();
        } else {
            GuildSubscribePollingManage.f214907d.s();
        }
    }
}
