package com.tencent.mobileqq.app.handler.receivesuccess;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.imcore.message.ao;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseMessageHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.friend.api.IFriendNameService;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qidian.controller.QidianHandler;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import msf.msgsvc.msg_svc$PbSendMsgResp;

/* compiled from: P */
/* loaded from: classes11.dex */
public class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private MessageHandler f195684a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f195685b;

    /* renamed from: c, reason: collision with root package name */
    private ToServiceMsg f195686c;

    /* renamed from: d, reason: collision with root package name */
    private FromServiceMsg f195687d;

    /* renamed from: e, reason: collision with root package name */
    private String f195688e;

    /* renamed from: f, reason: collision with root package name */
    private long f195689f;

    /* renamed from: g, reason: collision with root package name */
    private long f195690g;

    /* renamed from: h, reason: collision with root package name */
    private long f195691h;

    /* renamed from: i, reason: collision with root package name */
    private int f195692i;

    /* renamed from: j, reason: collision with root package name */
    private int f195693j;

    /* renamed from: k, reason: collision with root package name */
    private int f195694k;

    /* renamed from: l, reason: collision with root package name */
    private int f195695l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f195696m;

    /* renamed from: n, reason: collision with root package name */
    private int f195697n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f195698o;

    /* renamed from: p, reason: collision with root package name */
    private int f195699p;

    /* renamed from: q, reason: collision with root package name */
    private msg_svc$PbSendMsgResp f195700q;

    /* renamed from: r, reason: collision with root package name */
    private SendMessageHandler f195701r;

    public e(MessageHandler messageHandler, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, String str, long j3, long j16, long j17, int i3, int i16, int i17, int i18, boolean z16, int i19, boolean z17, int i26, msg_svc$PbSendMsgResp msg_svc_pbsendmsgresp, SendMessageHandler sendMessageHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, messageHandler, toServiceMsg, fromServiceMsg, str, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Boolean.valueOf(z16), Integer.valueOf(i19), Boolean.valueOf(z17), Integer.valueOf(i26), msg_svc_pbsendmsgresp, sendMessageHandler);
            return;
        }
        this.f195684a = messageHandler;
        this.f195686c = toServiceMsg;
        this.f195687d = fromServiceMsg;
        this.f195688e = str;
        this.f195689f = j3;
        this.f195690g = j16;
        this.f195691h = j17;
        this.f195692i = i3;
        this.f195693j = i16;
        this.f195694k = i17;
        this.f195695l = i18;
        this.f195696m = z16;
        this.f195697n = i19;
        this.f195698o = z17;
        this.f195699p = i26;
        this.f195700q = msg_svc_pbsendmsgresp;
        this.f195701r = sendMessageHandler;
    }

    private void a(msg_svc$PbSendMsgResp msg_svc_pbsendmsgresp, String str, int i3, int i16) {
        if (i3 == 1006) {
            b(msg_svc_pbsendmsgresp, str, i3, i16);
        } else if (i3 == 1022) {
            e(msg_svc_pbsendmsgresp, str, i3, i16);
        } else if (i3 == 1010) {
            c(msg_svc_pbsendmsgresp, str, i3, i16);
        } else if (i3 != 1001 && i3 != 10002) {
            if (i3 == 0) {
                d(msg_svc_pbsendmsgresp, str, i3, i16);
                ReportController.o(this.f195684a.Q, "CliOper", "", "", "0X800C005", "0X800C005", 0, 0, "", "", "", "");
            }
        } else {
            f(msg_svc_pbsendmsgresp, str, i3, i16);
        }
        if (msg_svc_pbsendmsgresp.errmsg.has() && i16 == 201) {
            this.f195684a.q4(i3, msg_svc_pbsendmsgresp.errmsg.get(), str);
        }
    }

    private void b(msg_svc$PbSendMsgResp msg_svc_pbsendmsgresp, String str, int i3, int i16) {
        if (msg_svc_pbsendmsgresp.errmsg.has()) {
            if (i16 == 1600 || i16 == 1601 || i16 == 1602 || i16 == 1603) {
                this.f195684a.q4(i3, msg_svc_pbsendmsgresp.errmsg.get(), str);
            }
        }
    }

    private void c(msg_svc$PbSendMsgResp msg_svc_pbsendmsgresp, String str, int i3, int i16) {
        if (msg_svc_pbsendmsgresp.errmsg.has()) {
            if (i16 == 54 || i16 == 61 || i16 == 62 || i16 == 63 || i16 == 64 || i16 == 65) {
                com.tencent.mobileqq.app.message.c.c(this.f195684a.Q, str, msg_svc_pbsendmsgresp.errmsg.get(), i3, false, false);
                switch (i16) {
                    case 63:
                        ReportController.o(this.f195684a.Q, "CliOper", "", "", "0X80052A8", "0X80052A8", 0, 0, "", "", "", "");
                        return;
                    case 64:
                        ReportController.o(this.f195684a.Q, "CliOper", "", "", "0X80052A9", "0X80052A9", 0, 0, "", "", "", "");
                        return;
                    case 65:
                        ReportController.o(this.f195684a.Q, "CliOper", "", "", "0X80052AA", "0X80052AA", 0, 0, "", "", "", "");
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private void e(msg_svc$PbSendMsgResp msg_svc_pbsendmsgresp, String str, int i3, int i16) {
        if (msg_svc_pbsendmsgresp.errmsg.has() && i16 == 201) {
            this.f195684a.q4(i3, msg_svc_pbsendmsgresp.errmsg.get(), str);
        }
    }

    private void f(msg_svc$PbSendMsgResp msg_svc_pbsendmsgresp, String str, int i3, int i16) {
        String str2;
        if ((msg_svc_pbsendmsgresp.errmsg.has() && (i16 == 63 || i16 == 64 || i16 == 65 || (i16 >= 10000 && i16 < 20000))) || i16 == 10109 || i16 == 10110) {
            if (i16 != 10109 && i16 != 10110) {
                com.tencent.mobileqq.app.message.c.c(this.f195684a.Q, str, msg_svc_pbsendmsgresp.errmsg.get(), i3, false, false);
            } else {
                String str3 = msg_svc_pbsendmsgresp.errmsg.get();
                com.tencent.mobileqq.graytip.g gVar = new com.tencent.mobileqq.graytip.g(str, this.f195684a.Q.getCurrentAccountUin(), str3, i3, -5000, 655381, com.tencent.mobileqq.service.message.e.K0());
                Bundle bundle = new Bundle();
                bundle.putInt("key_action", 66);
                gVar.b(str3.length() - 4, str3.length(), bundle);
                MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
                messageForUniteGrayTip.initGrayTipMsg(this.f195684a.Q, gVar);
                com.tencent.mobileqq.graytip.f.a(this.f195684a.Q, messageForUniteGrayTip);
            }
            switch (i16) {
                case 63:
                    ReportController.o(this.f195684a.Q, "CliOper", "", "", "0X80052A8", "0X80052A8", 0, 0, "", "", "", "");
                    break;
                case 64:
                    ReportController.o(this.f195684a.Q, "CliOper", "", "", "0X80052A9", "0X80052A9", 0, 0, "", "", "", "");
                    break;
                case 65:
                    ReportController.o(this.f195684a.Q, "CliOper", "", "", "0X80052AA", "0X80052AA", 0, 0, "", "", "", "");
                    break;
            }
            if (i16 >= 10000 && i16 < 20000) {
                QQAppInterface qQAppInterface = this.f195684a.Q;
                if (i3 == 1001) {
                    str2 = "0";
                } else {
                    str2 = "1";
                }
                ReportController.o(qQAppInterface, "dc00899", "grp_lbs", "", "c2c_tmp", "no_send", 0, 0, str2, "" + i16, "", "");
            }
        }
    }

    public void d(msg_svc$PbSendMsgResp msg_svc_pbsendmsgresp, String str, int i3, int i16) {
        String qqStr;
        PBStringField pBStringField;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, msg_svc_pbsendmsgresp, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (i16 == 16) {
            if (msg_svc_pbsendmsgresp != null && (pBStringField = msg_svc_pbsendmsgresp.errmsg) != null && !TextUtils.isEmpty(pBStringField.get())) {
                qqStr = msg_svc_pbsendmsgresp.errmsg.get();
            } else {
                qqStr = HardCodeUtil.qqStr(R.string.c8_);
            }
            String str2 = qqStr;
            com.tencent.mobileqq.graytip.g gVar = new com.tencent.mobileqq.graytip.g(str, this.f195684a.Q.getCurrentAccountUin(), str2, i3, MessageRecord.MSG_TYPE_UNITE_GRAY_TAB_INVI, 1376257, com.tencent.mobileqq.service.message.e.K0());
            Bundle bundle = new Bundle();
            bundle.putInt("key_action", 70);
            bundle.putString("textColor", "#40A0FF");
            try {
                bundle.putString("key_action_DATA", ((IFriendNameService) this.f195684a.Q.getRuntimeService(IFriendNameService.class, "")).getFriendName(str));
            } catch (IllegalStateException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("Q.msg.MessageHandler", 2, "e: " + e16.toString());
                }
            }
            bundle.putString("key_a_action_DATA", str);
            gVar.b(str2.lastIndexOf("\u5148") + 1, str2.length(), bundle);
            com.tencent.mobileqq.gamecenter.data.e.j(this.f195684a.Q, 0L, gVar);
        }
    }

    public e g() {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (e) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        a(this.f195700q, this.f195688e, this.f195695l, this.f195699p);
        int i3 = this.f195699p;
        if (i3 == 10 || i3 == 34) {
            this.f195696m = true;
            MessageRecord w06 = this.f195684a.Q.getMessageFacade().w0(this.f195688e, this.f195695l, this.f195689f);
            MessageHandler messageHandler = this.f195684a;
            if (messageHandler.U4(w06, messageHandler.P4(this.f195686c))) {
                this.f195684a.removeSendMessageHandler(this.f195690g);
                this.f195685b = true;
                return this;
            }
        }
        this.f195684a.l4(this.f195686c, this.f195700q);
        int Z2 = this.f195684a.Z2(this.f195694k);
        Object[] objArr = new Object[8];
        objArr[0] = this.f195688e;
        objArr[1] = Integer.valueOf(this.f195695l);
        objArr[2] = Integer.valueOf(this.f195699p);
        objArr[3] = this.f195686c.getAttribute("sendmsgHandler");
        objArr[4] = Long.valueOf(this.f195691h);
        objArr[5] = Long.valueOf(this.f195689f);
        if (this.f195700q.errmsg.has()) {
            str = this.f195700q.errmsg.get();
        } else {
            str = "";
        }
        objArr[6] = str;
        this.f195684a.s5(objArr, this.f195687d.getUin(), this.f195699p);
        if (ao.c(this.f195695l) == 1032) {
            objArr[7] = Integer.valueOf(this.f195697n);
        }
        this.f195684a.notifyBusiness(Z2, true, objArr);
        if (this.f195698o) {
            int i16 = this.f195692i;
            StatictisInfo statictisInfo = new StatictisInfo();
            statictisInfo.errCode = BaseConstants.CODE_SERVER_RETURN_ERROR;
            statictisInfo.detailErrorReason = this.f195699p;
            statictisInfo.retryCount = i16 + 1;
            statictisInfo.timeoutReason = BaseMessageHandler.getTimeoutReason(this.f195687d);
            statictisInfo.reportSucc = 1;
            this.f195684a.notifyCallBack(this.f195686c, 5006, false, new Object[]{Long.valueOf(this.f195689f), statictisInfo});
            this.f195684a.R3(this.f195688e, this.f195695l, this.f195689f, false);
        }
        if (this.f195693j == -7005 && QLog.isColorLevel()) {
            QLog.e("Q.msg.MessageHandler", 2, "ExtendFriendLimitChat SendC2CMessageResp_PB MessageForLimitChatConfirm Uniseq = " + this.f195689f + " replyCode = " + this.f195699p);
        }
        com.tencent.mobileqq.app.handler.d.e(this.f195684a, this.f195686c, this.f195687d, true);
        this.f195684a.removeSendMessageHandler(this.f195690g);
        com.tencent.mobileqq.app.handler.d.a(this.f195684a.Q, this.f195686c, this.f195687d);
        int i17 = this.f195695l;
        if (i17 == 1025 || i17 == 1024) {
            ((QidianHandler) this.f195684a.Q.getBusinessHandler(BusinessHandlerFactory.QIDIAN_HANDLER)).t3(this.f195688e, this.f195699p, this.f195701r.b(System.currentTimeMillis()));
        }
        this.f195685b = false;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h() {
        return this.f195685b;
    }

    public boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.f195696m;
    }
}
