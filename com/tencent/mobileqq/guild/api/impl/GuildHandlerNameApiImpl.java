package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.emoj.handler.GuildMsgEmojHandler;
import com.tencent.mobileqq.guild.file.GuildFileHandler;
import com.tencent.mobileqq.guild.focus.GuildReportFocusInfoHandler;
import com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler;
import com.tencent.mobileqq.guild.message.api.impl.GuildDispersionRoamMsgHandler;
import com.tencent.mobileqq.guild.message.api.impl.GuildMessageBoxHandler;
import com.tencent.mobileqq.guild.message.api.impl.GuildPullMultiMessageHandler;
import com.tencent.mobileqq.guild.message.api.impl.GuildRecentUseEmojiHandler;
import com.tencent.mobileqq.guild.message.api.impl.GuildRevokeMessageHandler;
import com.tencent.mobileqq.guild.message.api.impl.GuildRoamMessageHandler;
import com.tencent.mobileqq.guild.message.api.impl.GuildSendMessageHandler;
import com.tencent.mobileqq.guild.message.api.impl.onlinepush.GuildMessagePushHandler;
import com.tencent.mobileqq.guild.message.eventflow.GuildEventFlowHandler;
import com.tencent.mobileqq.guild.message.eventflow.revoke.GuildRegisterProxyRevokeEventHandler;
import com.tencent.mobileqq.guild.message.forward.ArkMessageForwardHandler;
import com.tencent.mobileqq.guild.message.guest.GuildGuestHandler;
import com.tencent.mobileqq.guild.message.mobapremadesteam.MobaPremadesTeamHandler;
import com.tencent.mobileqq.guild.message.registerproxy.GuildRegisterProxyMsgHandler;
import com.tencent.mobileqq.guild.message.schedule.SendGuildScheduleMsgHandler;
import com.tencent.mobileqq.guild.message.serversendarkmsg.GuildInvitationArkMsgHandler;
import com.tencent.mobileqq.guild.report.GuildReportHandler;

/* compiled from: P */
/* loaded from: classes12.dex */
public class GuildHandlerNameApiImpl implements IGuildHandlerNameApi {
    @Override // com.tencent.mobileqq.guild.api.IGuildHandlerNameApi
    public String getGuildCommentArgMsgHandlerName() {
        return ArkMessageForwardHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildHandlerNameApi
    public String getGuildDispersionRoamMsgHandlerName() {
        return GuildDispersionRoamMsgHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildHandlerNameApi
    public String getGuildFileHandlerName() {
        return GuildFileHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildHandlerNameApi
    public String getGuildGuestHandlerName() {
        return GuildGuestHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildHandlerNameApi
    public String getGuildMessageEventHandlerName() {
        return GuildEventFlowHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildHandlerNameApi
    public String getGuildMsgBoxHandlerName() {
        return GuildMessageBoxHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildHandlerNameApi
    public String getGuildMsgEmojiHandlerName() {
        return GuildMsgEmojHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildHandlerNameApi
    public String getGuildPullMultiMsgHandlerName() {
        return GuildPullMultiMessageHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildHandlerNameApi
    public String getGuildPushMsgHandlerName() {
        return GuildMessagePushHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildHandlerNameApi
    public String getGuildRecentUseEmojiHandlerName() {
        return GuildRecentUseEmojiHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildHandlerNameApi
    public String getGuildRegisterProxyMsgHandlerName() {
        return GuildRegisterProxyMsgHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildHandlerNameApi
    public String getGuildRegisterProxyRevokeEventHandlerName() {
        return GuildRegisterProxyRevokeEventHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildHandlerNameApi
    public String getGuildReportFocusInfoHandlerName() {
        return GuildReportFocusInfoHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildHandlerNameApi
    public String getGuildReportHandlerName() {
        return GuildReportHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildHandlerNameApi
    public String getGuildRevokeMessageHandlerName() {
        return GuildRevokeMessageHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildHandlerNameApi
    public String getGuildRoamMsgHandlerName() {
        return GuildRoamMessageHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildHandlerNameApi
    public String getGuildSendMsgHandlerName() {
        return GuildSendMessageHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildHandlerNameApi
    public String getMobaPremadesTeamHandlerName() {
        return MobaPremadesTeamHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildHandlerNameApi
    public String getQQGuildHandlerName() {
        return QQGuildHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildHandlerNameApi
    public String getSendGuildScheduleMsgHandlerName() {
        return SendGuildScheduleMsgHandler.class.getName();
    }

    @Override // com.tencent.mobileqq.guild.api.IGuildHandlerNameApi
    public String getServerSendArkMsgHandlerName() {
        return GuildInvitationArkMsgHandler.class.getName();
    }
}
