package com.tencent.mobileqq.guild.message;

import android.text.TextUtils;
import com.tencent.imcore.message.ad;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.guild.message.api.IGuildUniteGrayTipUtilApi;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes14.dex */
public class p {

    /* renamed from: a, reason: collision with root package name */
    public static ad.c f230723a = new com.tencent.imcore.message.msgproxy.c();

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f230724b = {MessageRecord.MSG_TYPE_GUILD_WELCOME_TIPS, MessageRecord.MSG_TYPE_GUILD_ROBOT_WELCOME_TIPS, MessageRecord.MSG_TYPE_GUILD_YOLO_GAME_RESULT, MessageRecord.MSG_TYPE_GUILD_YOLO_SYSTEM, MessageRecord.MSG_TYPE_GUILD_YOLO_TEAM, MessageRecord.MSG_TYPE_TROOP_UNREAD_TIPS, MessageRecord.MSG_TYPE_GUILD_REVOKE_GRAY_TIP, MessageRecord.MSG_TYPE_GUILD_SUBSCRIBE_CHANNEL_TIPS, MessageRecord.MSG_TYPE_GUILD_MSG_NOTIFY_SETTING_TIPS, MessageRecord.MSG_TYPE_GUILD_GRAYTIP_NOT_ROAM};

    public static boolean a(AppRuntime appRuntime, MessageRecord messageRecord, MessageRecord messageRecord2, boolean z16, boolean z17) {
        int i3;
        int i16;
        String str = messageRecord.frienduin;
        if (str != null && str.equals(messageRecord2.frienduin)) {
            if (!z16) {
                if (!z17) {
                    if (Math.abs(messageRecord.time - messageRecord2.time) >= 30 || !b(messageRecord, messageRecord2)) {
                        return false;
                    }
                    return true;
                }
                if (messageRecord.shmsgseq != messageRecord2.shmsgseq) {
                    return false;
                }
                int i17 = messageRecord.msgtype;
                int i18 = messageRecord2.msgtype;
                if (i17 == i18) {
                    if (!(messageRecord instanceof MessageForUniteGrayTip) || !(messageRecord2 instanceof MessageForUniteGrayTip)) {
                        return true;
                    }
                    return d((MessageForUniteGrayTip) messageRecord, (MessageForUniteGrayTip) messageRecord2);
                }
                if ((i17 == -1000 && i18 == -2007) || i17 == -2006 || i18 == -2006) {
                    return true;
                }
                if ((i17 == -1000 && i18 == -2011) || f(messageRecord)) {
                    return true;
                }
                int i19 = messageRecord2.msgtype;
                if (i19 == -1051 && ((i16 = messageRecord.msgtype) == -1000 || i16 == -2011)) {
                    return true;
                }
                int i26 = messageRecord.msgtype;
                if (i26 == -2011 && i19 == -1000) {
                    return true;
                }
                if (i19 == -1051 && i26 == -1035) {
                    return true;
                }
                if (i26 != -1051 || i19 != -1035) {
                    return false;
                }
                return true;
            }
            if (!messageRecord.isSendFromLocal()) {
                if (QLog.isColorLevel()) {
                    QLog.d("GuildMsgProxyUtils", 2, "compGuildMsgContent. isSendFromLocal == false.");
                }
                return false;
            }
            if (!TextUtils.equals(messageRecord.getExtInfoFromExtStr("key_guild_sending_message_success"), "1") && (i3 = messageRecord.extraflag) != 32772 && i3 != 32768) {
                if (messageRecord.msgtype == -1035) {
                    if (i3 != 32770) {
                        if (QLog.isColorLevel()) {
                            QLog.d("GuildMsgProxyUtils", 2, "compGuildMsgContent. mixMsg cachRecord extraflag doesn't equal to SEND.");
                        }
                        return false;
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("GuildMsgProxyUtils", 2, "compGuildMsgContent. nomalMsg cachRecord extraflag doesn't equal to SEND.");
                    }
                    return false;
                }
            }
            if (messageRecord.msgtype == -2006) {
                if (QLog.isColorLevel()) {
                    QLog.d("GuildMsgProxyUtils", 2, "compGuildMsgContent. msgType == 0x7F.");
                }
                return false;
            }
            if (!c(appRuntime, messageRecord, messageRecord2)) {
                if (QLog.isColorLevel()) {
                    QLog.d("GuildMsgProxyUtils", 2, "compGuildMsgContent. compSenderUin == false.");
                }
                return false;
            }
            long j3 = messageRecord2.msgUid;
            if (j3 != 0 && messageRecord.msgUid == j3) {
                if (QLog.isColorLevel()) {
                    QLog.d("GuildMsgProxyUtils", 2, "compTroopMsgContent RewriteSeq: find msg by uid=" + messageRecord.msgUid);
                }
                return true;
            }
            if (QLog.isColorLevel()) {
                QLog.d("GuildMsgProxyUtils", 2, "compTroopMsgContent RewriteSeq: find msg by time");
            }
            if ((Math.abs(messageRecord.time - messageRecord2.time) >= e() + 30 && Math.abs(messageRecord.shmsgseq - messageRecord2.shmsgseq) >= 2) || !b(messageRecord, messageRecord2)) {
                return false;
            }
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("GuildMsgProxyUtils", 2, "compGuildMsgContent FAILED. frienduin doesn't equal.");
        }
        return false;
    }

    private static boolean b(MessageRecord messageRecord, MessageRecord messageRecord2) {
        int i3 = messageRecord.msgtype;
        int i16 = messageRecord2.msgtype;
        if (i3 != i16) {
            return false;
        }
        String str = messageRecord.f203106msg;
        String str2 = messageRecord2.f203106msg;
        if (i16 == -1000) {
            return TextUtils.equals(str, str2);
        }
        return f230723a.k(messageRecord, messageRecord2, str, str2);
    }

    private static boolean c(AppRuntime appRuntime, MessageRecord messageRecord, MessageRecord messageRecord2) {
        if (messageRecord.senderuin != null && messageRecord2.senderuin != null) {
            String selfTinyId = ((IGPSService) appRuntime.getRuntimeService(IGPSService.class, "")).getSelfTinyId();
            if (messageRecord.senderuin.equals(messageRecord2.senderuin)) {
                return true;
            }
            if (messageRecord.senderuin.equals(appRuntime.getCurrentUin()) && messageRecord2.senderuin.equals(selfTinyId)) {
                return true;
            }
        }
        return false;
    }

    private static boolean d(MessageForUniteGrayTip messageForUniteGrayTip, MessageForUniteGrayTip messageForUniteGrayTip2) {
        if (messageForUniteGrayTip.msgUid == messageForUniteGrayTip2.msgUid) {
            IGuildUniteGrayTipUtilApi iGuildUniteGrayTipUtilApi = (IGuildUniteGrayTipUtilApi) QRoute.api(IGuildUniteGrayTipUtilApi.class);
            String busiId = iGuildUniteGrayTipUtilApi.getBusiId(messageForUniteGrayTip);
            String busiId2 = iGuildUniteGrayTipUtilApi.getBusiId(messageForUniteGrayTip2);
            if (busiId != null && busiId.equals(busiId2)) {
                String bytesContent = iGuildUniteGrayTipUtilApi.getBytesContent(messageForUniteGrayTip);
                String bytesContent2 = iGuildUniteGrayTipUtilApi.getBytesContent(messageForUniteGrayTip2);
                if (bytesContent != null && bytesContent.equals(bytesContent2)) {
                    QLog.i("GuildMsgProxyUtils", 1, "compareGrayTipMsg. Same GrayTip: " + messageForUniteGrayTip2.toString());
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    private static int e() {
        return f230723a.g();
    }

    private static boolean f(MessageRecord messageRecord) {
        return f230723a.a(messageRecord);
    }

    public static void g(ad.c cVar) {
        f230723a = cVar;
    }
}
