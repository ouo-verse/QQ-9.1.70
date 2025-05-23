package com.tencent.mobileqq.msgbackup.authentication;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.msgbackup.controller.MsgBackupManager;
import com.tencent.mobileqq.msgbackup.data.MsgBackupUserData;
import com.tencent.mobileqq.msgbackup.data.a;
import com.tencent.mobileqq.msgbackup.data.f;
import com.tencent.mobileqq.msgbackup.tempapi.IMsgBackupTempApi;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.service.message.ac;
import com.tencent.mobileqq.service.message.s;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import msf.msgsvc.msg_svc$PbSendMsgReq;
import tencent.im.msg.im_msg_head$InstCtrl;
import tencent.im.msg.im_msg_head$InstInfo;
import tencent.im.s2c.msgtype0x210.submsgtype0x11a.submsgtype0x11a$MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x11a.submsgtype0x11a$UserData;
import tencent.im.s2c.msgtype0x210.submsgtype0x11b.submsgtype0x11b$MsgBody;
import tencent.im.s2c.msgtype0x211.submsgtype0x7.SubMsgType0x7$MsgBody;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static c f251011a;

    c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private MsgBackupUserData a(submsgtype0x11a$UserData submsgtype0x11a_userdata) {
        MsgBackupUserData.b bVar = new MsgBackupUserData.b();
        if (submsgtype0x11a_userdata.bytes_ip.has()) {
            bVar.c(submsgtype0x11a_userdata.bytes_ip.get().toStringUtf8());
        }
        if (submsgtype0x11a_userdata.rpt_fixed32_port.has()) {
            bVar.f(submsgtype0x11a_userdata.rpt_fixed32_port.get());
        }
        if (submsgtype0x11a_userdata.bytes_bssid.has()) {
            bVar.b(submsgtype0x11a_userdata.bytes_bssid.get().toStringUtf8());
        }
        if (submsgtype0x11a_userdata.bytes_ssid.has()) {
            bVar.g(submsgtype0x11a_userdata.bytes_ssid.get().toStringUtf8());
        }
        if (submsgtype0x11a_userdata.enum_platform.has()) {
            bVar.e(submsgtype0x11a_userdata.enum_platform.get());
        }
        return bVar.a();
    }

    public static c b() {
        if (f251011a == null) {
            synchronized (c.class) {
                if (f251011a == null) {
                    f251011a = new c();
                }
            }
        }
        return f251011a;
    }

    public void c(submsgtype0x11a$MsgBody submsgtype0x11a_msgbody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) submsgtype0x11a_msgbody);
            return;
        }
        if (submsgtype0x11a_msgbody != null) {
            a.C8110a c8110a = new a.C8110a();
            if (submsgtype0x11a_msgbody.enum_result.has()) {
                int i3 = submsgtype0x11a_msgbody.enum_result.get();
                if (i3 == 0) {
                    if (submsgtype0x11a_msgbody.bytes_token.has()) {
                        c8110a.d(submsgtype0x11a_msgbody.bytes_token.get().toStringUtf8());
                    }
                    if (submsgtype0x11a_msgbody.bytes_encrypt_key.has()) {
                        c8110a.c(submsgtype0x11a_msgbody.bytes_encrypt_key.get().toStringUtf8());
                    }
                    if (submsgtype0x11a_msgbody.msg_user_data.has()) {
                        c8110a.e(a(submsgtype0x11a_msgbody.msg_user_data.get()));
                    }
                    if (submsgtype0x11a_msgbody.enum_biz_type.has()) {
                        c8110a.b(submsgtype0x11a_msgbody.enum_biz_type.get());
                    }
                    com.tencent.mobileqq.msgbackup.data.a a16 = c8110a.a();
                    if (QLog.isColorLevel()) {
                        QLog.d("MsgBackup.MsgBackupPushHandler", 2, "processOnLinePush receive processOnLinePush0x11a response = " + a16);
                    }
                    MsgBackupManager.x().K(a16);
                    return;
                }
                if (i3 == 6) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MsgBackup.MsgBackupPushHandler", 2, "processOnLinePush receive 0x210_0x11a\uff0c \u5bf9\u7aef\u62d2\u7edd\u4e86\uff01");
                    }
                    MsgBackupManager.x().K(6);
                } else if (i3 == 20) {
                    if (QLog.isColorLevel()) {
                        QLog.d("MsgBackup.MsgBackupPushHandler", 2, "processOnLinePush receive 0x210_0x11a\uff0c \u5185\u90e8\u9519\u8bef");
                    }
                    MsgBackupManager.x().K(20);
                }
            }
        }
    }

    public void d(submsgtype0x11b$MsgBody submsgtype0x11b_msgbody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) submsgtype0x11b_msgbody);
            return;
        }
        if (submsgtype0x11b_msgbody != null) {
            f.b bVar = new f.b();
            if (submsgtype0x11b_msgbody.bytes_qr_sig.has()) {
                bVar.c(submsgtype0x11b_msgbody.bytes_qr_sig.get().toStringUtf8());
            }
            if (submsgtype0x11b_msgbody.enum_biz_type.has()) {
                bVar.b(submsgtype0x11b_msgbody.enum_biz_type.get());
            }
            f a16 = bVar.a();
            if (QLog.isColorLevel()) {
                QLog.d("MsgBackup.MsgBackupPushHandler", 2, "processOnLinePush receive processOnLinePush0x11b " + a16);
            }
            MsgBackupManager.x().J(a16);
            return;
        }
        MsgBackupManager.x().J(null);
    }

    public void e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        SubMsgType0x7$MsgBody.GenericSubCmd genericSubCmd = new SubMsgType0x7$MsgBody.GenericSubCmd();
        genericSubCmd.uint64_sessionid.set(1L);
        genericSubCmd.uint32_size.set(1);
        genericSubCmd.uint32_index.set(0);
        genericSubCmd.uint32_type.set(7);
        genericSubCmd.bytes_buf.set(ByteStringMicro.copyFrom(str.getBytes()));
        genericSubCmd.uint32_support_auth.set(1);
        genericSubCmd.setHasFlag(true);
        SubMsgType0x7$MsgBody subMsgType0x7$MsgBody = new SubMsgType0x7$MsgBody();
        subMsgType0x7$MsgBody.uint32_sub_cmd.set(4);
        BaseQQAppInterface baseQQAppInterface = (BaseQQAppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        IMsgBackupTempApi iMsgBackupTempApi = (IMsgBackupTempApi) QRoute.api(IMsgBackupTempApi.class);
        iMsgBackupTempApi.fillMsgHeader(baseQQAppInterface, subMsgType0x7$MsgBody.msg_header, Long.valueOf(baseQQAppInterface.getCurrentAccountUin()));
        subMsgType0x7$MsgBody.msg_subcmd_0x4_generic.set(genericSubCmd);
        subMsgType0x7$MsgBody.setHasFlag(true);
        ac acVar = new ac();
        byte[] byteArray = subMsgType0x7$MsgBody.toByteArray();
        acVar.f286177a = 7;
        acVar.f286178b = byteArray;
        long Q = ah.Q();
        msg_svc$PbSendMsgReq createPbSendMsgReq = iMsgBackupTempApi.createPbSendMsgReq(baseQQAppInterface, 13, baseQQAppInterface.getCurrentUin(), acVar, ah.P(), s.g(Q));
        im_msg_head$InstInfo im_msg_head_instinfo = new im_msg_head$InstInfo();
        im_msg_head_instinfo.uint32_apppid.set(1);
        im_msg_head_instinfo.uint32_instid.set(0);
        im_msg_head_instinfo.enum_device_type.set(2);
        im_msg_head_instinfo.setHasFlag(true);
        createPbSendMsgReq.routing_head.trans_0x211.inst_ctrl.rpt_msg_send_to_inst.add(im_msg_head_instinfo);
        im_msg_head$InstInfo im_msg_head_instinfo2 = new im_msg_head$InstInfo();
        im_msg_head_instinfo2.uint32_apppid.set(1001);
        im_msg_head_instinfo2.uint32_instid.set(AppSetting.f());
        im_msg_head_instinfo2.enum_device_type.set(2);
        im_msg_head_instinfo2.setHasFlag(true);
        im_msg_head$InstCtrl im_msg_head_instctrl = createPbSendMsgReq.routing_head.trans_0x211.inst_ctrl;
        im_msg_head_instctrl.msg_from_inst = im_msg_head_instinfo2;
        im_msg_head_instctrl.setHasFlag(true);
        ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", baseQQAppInterface.getCurrentAccountUin(), BaseConstants.CMD_MSG_PBSENDMSG);
        toServiceMsg.putWupBuffer(createPbSendMsgReq.toByteArray());
        toServiceMsg.addAttribute(MobileQQServiceBase.REQ_PB_PROTOCOL_FLAG, Boolean.TRUE);
        toServiceMsg.extraData.putBoolean("exit_push_0x211_key", true);
        baseQQAppInterface.sendToService(toServiceMsg);
    }
}
