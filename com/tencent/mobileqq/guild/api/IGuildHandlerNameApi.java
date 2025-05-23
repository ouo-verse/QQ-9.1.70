package com.tencent.mobileqq.guild.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildHandlerNameApi extends QRouteApi {
    String getGuildCommentArgMsgHandlerName();

    String getGuildDispersionRoamMsgHandlerName();

    String getGuildFileHandlerName();

    String getGuildGuestHandlerName();

    String getGuildMessageEventHandlerName();

    String getGuildMsgBoxHandlerName();

    String getGuildMsgEmojiHandlerName();

    String getGuildPullMultiMsgHandlerName();

    String getGuildPushMsgHandlerName();

    String getGuildRecentUseEmojiHandlerName();

    String getGuildRegisterProxyMsgHandlerName();

    String getGuildRegisterProxyRevokeEventHandlerName();

    String getGuildReportFocusInfoHandlerName();

    String getGuildReportHandlerName();

    String getGuildRevokeMessageHandlerName();

    String getGuildRoamMsgHandlerName();

    String getGuildSendMsgHandlerName();

    String getMobaPremadesTeamHandlerName();

    String getQQGuildHandlerName();

    String getSendGuildScheduleMsgHandlerName();

    String getServerSendArkMsgHandlerName();
}
