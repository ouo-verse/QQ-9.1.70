package com.tencent.imcore.message.ext.codec.decoder.msgType0x210;

import IMMsgBodyPack.MsgType0x210;
import OnlinePushPack.MsgInfo;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.shortcut.api.ITroopShortcutApi;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarHandler;
import com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26$AppTipNotify;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26$MsgBody;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ak implements a<com.tencent.imcore.message.af> {
    static IPatchRedirector $redirector_;

    public ak() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static long b(QQAppInterface qQAppInterface, submsgtype0x26$MsgBody submsgtype0x26_msgbody) {
        long j3 = 0;
        if (submsgtype0x26_msgbody.uint32_sub_cmd.get() == 1 && submsgtype0x26_msgbody.rpt_msg_subcmd_0x1_push_body.has()) {
            List<submsgtype0x26$MsgBody.SubCmd0x1UpdateAppUnreadNum> list = submsgtype0x26_msgbody.rpt_msg_subcmd_0x1_push_body.get();
            int i3 = 0;
            while (i3 < list.size()) {
                submsgtype0x26$MsgBody.SubCmd0x1UpdateAppUnreadNum subCmd0x1UpdateAppUnreadNum = list.get(i3);
                long j16 = subCmd0x1UpdateAppUnreadNum.uint64_group_code.get();
                long j17 = subCmd0x1UpdateAppUnreadNum.msg_app_id.uint64_app_id.get();
                int i16 = subCmd0x1UpdateAppUnreadNum.sint32_unread_num.get();
                TroopShortcutBarManager troopShortcutBarManager = (TroopShortcutBarManager) qQAppInterface.getManager(QQManagerFactory.TROOP_SHORTCUTBAR_MANAGER);
                if (troopShortcutBarManager != null) {
                    if (j17 == 101846662) {
                        com.tencent.qqnt.kernel.api.s h16 = com.tencent.mobileqq.troop.utils.bg.h("");
                        if (h16 != null) {
                            h16.cleanCapsuleCache(j16);
                            ((ITroopShortcutApi) QRoute.api(ITroopShortcutApi.class)).notifyDataExpired(Long.valueOf(j16));
                        }
                        troopShortcutBarManager.C(j16);
                        if (QLog.isColorLevel()) {
                            QLog.d("SubType0x26", 2, "handleAioShortcutBarPush SHORTCUTBAR_STATUS_CHANGE_APPID troopUin:" + j16);
                        }
                    } else if (j17 == 101896870) {
                        troopShortcutBarManager.v(j16, i16);
                        if (QLog.isColorLevel()) {
                            QLog.d("SubType0x26", 2, "handleAioShortcutBarPush REMIND_GRAYTIP_APPID troopUin:" + j16 + " unreadNum:" + i16);
                        }
                    }
                    troopShortcutBarManager.B(j16, j17, i16);
                }
                i3++;
                j3 = j16;
            }
        }
        return j3;
    }

    public static void c(com.tencent.imcore.message.af afVar, byte[] bArr) {
        TroopShortcutBarHandler troopShortcutBarHandler;
        if (QLog.isColorLevel()) {
            QLog.d("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26");
        }
        submsgtype0x26$MsgBody submsgtype0x26_msgbody = new submsgtype0x26$MsgBody();
        try {
            submsgtype0x26_msgbody.mergeFrom(bArr);
            if (!submsgtype0x26_msgbody.uint32_sub_cmd.has()) {
                if (QLog.isColorLevel()) {
                    QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26 : msg has not body");
                    return;
                }
                return;
            }
            QQAppInterface qQAppInterface = (QQAppInterface) afVar.d();
            e(qQAppInterface, submsgtype0x26_msgbody);
            long b16 = b(qQAppInterface, submsgtype0x26_msgbody);
            if (b16 != 0 && (troopShortcutBarHandler = (TroopShortcutBarHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_SHORTCUTBAR_HANDLE)) != null) {
                troopShortcutBarHandler.notifyUI(3, true, new Object[]{Long.valueOf(b16)});
            }
            if (submsgtype0x26_msgbody.uint32_sub_cmd.get() == 3) {
                d(qQAppInterface, submsgtype0x26_msgbody);
            }
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26 : fail to parse submsgtype0x26.");
            }
        }
    }

    private static void d(QQAppInterface qQAppInterface, submsgtype0x26$MsgBody submsgtype0x26_msgbody) {
        if (!submsgtype0x26_msgbody.msg_subcmd_0x3_push_body.has() && QLog.isColorLevel()) {
            QLog.e("Q.msg.BaseMessageProcessor", 2, "handleMsgType0x210SubMsgType0x26 : msg has not 0x3_push_body");
        }
        submsgtype0x26$MsgBody.SubCmd0x3UpdateDiscussAppInfo subCmd0x3UpdateDiscussAppInfo = submsgtype0x26_msgbody.msg_subcmd_0x3_push_body.get();
        if (subCmd0x3UpdateDiscussAppInfo.uint64_conf_uin.has() && subCmd0x3UpdateDiscussAppInfo.msg_app_tip_notify.has()) {
            subCmd0x3UpdateDiscussAppInfo.uint64_conf_uin.get();
            submsgtype0x26$AppTipNotify submsgtype0x26_apptipnotify = subCmd0x3UpdateDiscussAppInfo.msg_app_tip_notify.get();
            if (submsgtype0x26_apptipnotify.bytes_text.has()) {
                byte[] byteArray = submsgtype0x26_apptipnotify.bytes_text.get().toByteArray();
                if (byteArray.length > 0) {
                    qQAppInterface.getGAudioHandler().n(byteArray);
                }
            }
        }
    }

    private static void e(QQAppInterface qQAppInterface, submsgtype0x26$MsgBody submsgtype0x26_msgbody) {
        List<submsgtype0x26$MsgBody.SubCmd0x1UpdateAppUnreadNum> list;
        if (submsgtype0x26_msgbody == null || submsgtype0x26_msgbody.uint32_sub_cmd.get() != 1 || !submsgtype0x26_msgbody.rpt_msg_subcmd_0x1_push_body.has() || (list = submsgtype0x26_msgbody.rpt_msg_subcmd_0x1_push_body.get()) == null) {
            return;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            submsgtype0x26$MsgBody.SubCmd0x1UpdateAppUnreadNum subCmd0x1UpdateAppUnreadNum = list.get(i3);
            if (subCmd0x1UpdateAppUnreadNum != null) {
                subCmd0x1UpdateAppUnreadNum.msg_app_id.uint64_app_id.get();
            }
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.msgType0x210.a
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public MessageRecord decode(com.tencent.imcore.message.af afVar, MsgType0x210 msgType0x210, long j3, byte[] bArr, MsgInfo msgInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, this, afVar, msgType0x210, Long.valueOf(j3), bArr, msgInfo);
        }
        c(afVar, msgType0x210.vProtobuf);
        return null;
    }
}
