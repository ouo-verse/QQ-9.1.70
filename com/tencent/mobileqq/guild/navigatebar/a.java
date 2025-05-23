package com.tencent.mobileqq.guild.navigatebar;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.data.ChannelMsgEvent;
import com.tencent.mobileqq.guild.message.api.IGuildMessageBoxDataService;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.data.c;
import com.tencent.mobileqq.troop.data.d;
import com.tencent.mobileqq.troop.navigatebar.NavConstants;
import com.tencent.mobileqq.troop.navigatebar.g;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a extends g {
    protected static void d(QQAppInterface qQAppInterface, String str, c cVar, MessageRecord messageRecord, boolean z16) {
        boolean z17 = cVar.f() == 14;
        int c16 = cVar.c(z16);
        String a16 = a(str, z16);
        if (QLog.isColorLevel()) {
            QLog.d("GuildAioMsgNavigateUpdateMsgInfoUtil", 2, "updateNavMsgInfo, msgInfo = " + cVar + " mr= " + messageRecord + " channelId = " + a16);
        }
        int b16 = NavConstants.b(c16);
        d dVar = cVar.f294893c;
        long a17 = com.tencent.mobileqq.troop.navigatebar.a.a(b16, dVar.f294896b, dVar.f294897c);
        if (QLog.isColorLevel()) {
            QLog.d("GuildAioMsgNavigateUpdateMsgInfoUtil", 2, "updateNavMsgInfo msgSeq " + a17);
        }
        if (h(qQAppInterface, a16, messageRecord)) {
            ((GuildAioNavigateBarManager) qQAppInterface.getManager(QQManagerFactory.GUILD_AIO_NAVIGATE_BAR)).f(a16, b16, cVar.f294893c.f294896b, a17, "", null);
        }
        if (z17) {
            return;
        }
        f(qQAppInterface, a16, messageRecord, b16);
    }

    private static boolean g(QQAppInterface qQAppInterface, String str) {
        IGProChannelInfo channelInfo = ((IGPSService) qQAppInterface.getRuntimeService(IGPSService.class, "")).getChannelInfo(str);
        return channelInfo != null && channelInfo.getFinalMsgNotify() == 1;
    }

    static boolean h(QQAppInterface qQAppInterface, String str, MessageRecord messageRecord) {
        if (!((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isPersonalRedPacketMsg(messageRecord) && ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isRedPacketMsg(messageRecord)) {
            return g(qQAppInterface, str);
        }
        return true;
    }

    public static void i(QQAppInterface qQAppInterface, String str, c cVar, MessageRecord messageRecord, boolean z16) {
        d(qQAppInterface, str, cVar, messageRecord, z16);
    }

    private static void f(QQAppInterface qQAppInterface, String str, MessageRecord messageRecord, int i3) {
        if (qQAppInterface == null || i3 != 23) {
            return;
        }
        ChannelMsgEvent channelMsgEvent = new ChannelMsgEvent();
        channelMsgEvent.channelId = str;
        channelMsgEvent.eventType = 1L;
        channelMsgEvent.msgSeq = messageRecord.shmsgseq;
        channelMsgEvent.tinyId = messageRecord.senderuin;
        if (((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isGiftMsg(messageRecord)) {
            channelMsgEvent.subType = 1;
        } else if (((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isPersonalRedPacketMsg(messageRecord)) {
            channelMsgEvent.subType = 3;
        } else if (((IGuildTempApi) QRoute.api(IGuildTempApi.class)).isRedPacketMsg(messageRecord)) {
            if (!g(qQAppInterface, str)) {
                return;
            } else {
                channelMsgEvent.subType = 2;
            }
        }
        ((IGuildMessageBoxDataService) qQAppInterface.getRuntimeService(IGuildMessageBoxDataService.class, "")).addChannelMsgBoxEvent(channelMsgEvent);
    }

    protected static String a(String str, boolean z16) {
        return str;
    }
}
