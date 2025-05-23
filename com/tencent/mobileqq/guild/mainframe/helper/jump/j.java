package com.tencent.mobileqq.guild.mainframe.helper.jump;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.api.LaunchGuildChatPieParam;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.helper.jump.GuildMainFrameJumpParam;
import com.tencent.mobileqq.guild.util.debug.GuildJumpDebugUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes14.dex */
public class j implements c {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.guild.mainframe.i f227460a;

    public j(com.tencent.mobileqq.guild.mainframe.i iVar) {
        this.f227460a = iVar;
    }

    private LaunchGuildChatPieParam b(GuildMainFrameJumpParam guildMainFrameJumpParam) {
        Bundle bundle = new Bundle();
        bundle.putByte(AppConstants.Key.GUILD_DIRECT_MESSAGE_FLAG, (byte) 1);
        return new LaunchGuildChatPieParam().l(guildMainFrameJumpParam.f227440d.f227443d.f227447e).b(guildMainFrameJumpParam.f227442f.getString("channelId", "")).r(false).o(1).g(0).k(bundle).q(guildMainFrameJumpParam.f227442f.getString("c2cNickName", "")).a();
    }

    @Override // com.tencent.mobileqq.guild.mainframe.helper.jump.c
    public void a(Bundle bundle) {
        if (this.f227460a == null) {
            return;
        }
        GuildJumpDebugUtils.a("GUILD_JUMP", "OpenGuildCenterPanelJumper handleAction(): extra = ", bundle);
        GuildAppReportSourceInfo f06 = this.f227460a.f0();
        String string = bundle.getString("sgrp_stream_pgin_source_name");
        if (bundle.getInt("openGuildFrom") == 1) {
            f06.addReportItem("sgrp_stream_pgin_source_name", "qq_push");
        } else if (!TextUtils.isEmpty(string)) {
            f06.addReportItem("sgrp_stream_pgin_source_name", string);
        }
        GuildAppReportSourceInfo guildAppReportSourceInfo = (GuildAppReportSourceInfo) bundle.getParcelable("GuildAppReportSourceInfo");
        if (guildAppReportSourceInfo != null && !guildAppReportSourceInfo.getStartFromGuildTab()) {
            Map<String, String> reportInfoMap = guildAppReportSourceInfo.getReportInfoMap();
            int i3 = guildAppReportSourceInfo.extraInfo.channelOpenSourceForOnlineReport;
            if (i3 != 0) {
                f06.extraInfo.channelOpenSourceForOnlineReport = i3;
            }
            if (reportInfoMap != null && !reportInfoMap.isEmpty()) {
                String str = reportInfoMap.get("sgrp_share_session_id");
                String str2 = reportInfoMap.get("sgrp_share_type");
                if (!TextUtils.isEmpty(str)) {
                    f06.addReportItem("sgrp_share_session_id", str);
                }
                if (!TextUtils.isEmpty(str2)) {
                    f06.addReportItem("sgrp_share_type", str2);
                }
                if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
                    bundle.remove("GuildAppReportSourceInfo");
                }
            }
        }
        GuildMainFrameJumpParam guildMainFrameJumpParam = new GuildMainFrameJumpParam();
        guildMainFrameJumpParam.f227442f.putAll(bundle);
        guildMainFrameJumpParam.f227437a = bundle.getInt("BUNDLE_KEY_TARGET_ITEM_TYPE", 1);
        guildMainFrameJumpParam.f227438b = bundle.getString("BUNDLE_KEY_TARGET_ITEM_KEY", "");
        guildMainFrameJumpParam.f227439c = bundle.getBoolean("BUNDLE_KEY_NEED_OPEN_CENTER_PANEL", true);
        int i16 = guildMainFrameJumpParam.f227437a;
        if (i16 == 4) {
            guildMainFrameJumpParam.f227440d.f227443d = new GuildMainFrameJumpParam.GuildInboxJumpExtra();
            guildMainFrameJumpParam.f227440d.f227443d.f227446d = bundle.getInt("BUNDLE_KEY_TARGET_INBOX_TYPE", 0);
            guildMainFrameJumpParam.f227440d.f227443d.f227447e = bundle.getString("BUNDLE_KEY_TARGET_INBOX_KEY");
            GuildMainFrameJumpParam.GuildCenterPanelJumpExtra guildCenterPanelJumpExtra = guildMainFrameJumpParam.f227440d;
            if (guildCenterPanelJumpExtra.f227443d.f227446d == 0) {
                guildCenterPanelJumpExtra.f227444e = b(guildMainFrameJumpParam);
            }
        } else if (i16 == 1) {
            guildMainFrameJumpParam.f227440d.f227444e = (LaunchGuildChatPieParam) bundle.getParcelable("guildChatPie");
        }
        JumpGuildParam.ChannelDetailPageJumpInfo channelDetailPageJumpInfo = (JumpGuildParam.ChannelDetailPageJumpInfo) bundle.getParcelable(JumpGuildParam.KEY_DETAIL_PAGE_JUMP_INFO);
        if (channelDetailPageJumpInfo != null) {
            guildMainFrameJumpParam.f227440d.f227445f = channelDetailPageJumpInfo;
        }
        guildMainFrameJumpParam.f227441e = f06;
        QLog.i("Guild.jump.OpenGuildCenterPanelJumper", 1, "handleAction param:" + guildMainFrameJumpParam);
        if (!this.f227460a.Z0().C()) {
            this.f227460a.Z0().r();
        }
        if (AppSetting.t(this.f227460a.getActivity()) && this.f227460a.getActivity() != null) {
            com.tencent.mobileqq.pad.m.a(this.f227460a.getActivity());
        }
        GuildJumpDebugUtils.a("GUILD_JUMP", "OpenGuildCenterPanelJumper handleAction(): param = ", guildMainFrameJumpParam);
        this.f227460a.f(guildMainFrameJumpParam);
    }
}
