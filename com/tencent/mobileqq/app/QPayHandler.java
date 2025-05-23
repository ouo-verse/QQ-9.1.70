package com.tencent.mobileqq.app;

import android.content.Intent;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPayReminderActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.text.DateFormat;
import java.util.Date;
import tencent.im.s2c.msgtype0x210.submsgtype0x72.SubMsgType0x72$MsgBody;
import tencent.mobileim.structmsg.QPayReminderMsg$GetInfoReq;
import tencent.mobileim.structmsg.QPayReminderMsg$GetInfoRsp;

/* loaded from: classes11.dex */
public class QPayHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private String f194968d;

    public QPayHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        }
    }

    private void E2(int i3, int i16, String str, String str2) {
        Intent intent = new Intent(BaseActivity.sTopActivity, (Class<?>) QPayReminderActivity.class);
        intent.putExtra("URGENCY", i3);
        intent.putExtra("TEMPLATE", i16);
        intent.putExtra("CONTENT", str);
        BaseActivity.sTopActivity.startActivity(intent);
        BaseActivity.sTopActivity.overridePendingTransition(R.anim.f155030h6, R.anim.f154442w);
        if (QLog.isColorLevel()) {
            QLog.d("QPayHandler", 2, "QPayReminder: lauching popup QPayReminderActivity");
        }
        H2(str2);
    }

    private void F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (!((Boolean) toServiceMsg.getAttribute("is_query", Boolean.FALSE)).booleanValue()) {
            return;
        }
        try {
            QPayReminderMsg$GetInfoRsp mergeFrom = new QPayReminderMsg$GetInfoRsp().mergeFrom((byte[]) obj);
            if (mergeFrom.result_code.get() != 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("QPayHandler", 2, "QPayReminder: receive pull response, but result_code = " + mergeFrom.result_code.get());
                    return;
                }
                return;
            }
            int i3 = mergeFrom.urgency.get();
            int i16 = mergeFrom.template_no.get();
            String str = mergeFrom.content.get();
            String str2 = mergeFrom.info_date.get();
            if (QLog.isColorLevel()) {
                QLog.d("QPayHandler", 2, "QPayReminder: receive pull response, message content: " + str);
            }
            E2(i3, i16, str, str2);
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d("QPayHandler", 2, "QPayReminder: receive pull response, parse error");
            }
        }
    }

    public void D2(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bArr);
            return;
        }
        if (bArr == null) {
            return;
        }
        try {
            SubMsgType0x72$MsgBody mergeFrom = new SubMsgType0x72$MsgBody().mergeFrom(bArr);
            if (mergeFrom.uint32_sub_cmd.get() != 2) {
                G2(false);
                return;
            }
            int i3 = mergeFrom.uint32_urgency.get();
            int i16 = mergeFrom.uint32_template_no.get();
            String str = mergeFrom.str_content.get();
            String str2 = mergeFrom.str_info_date.get();
            if (QLog.isColorLevel()) {
                QLog.d("QPayHandler", 2, "QPayReminder: receive online push message, message content: " + str);
            }
            E2(i3, i16, str, str2);
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d("QPayHandler", 2, "QPayReminder: receive online push message, parse error");
            }
        }
    }

    public void G2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        if (z16) {
            String str = this.appRuntime.getAccount() + ":" + DateFormat.getDateInstance().format(new Date());
            String str2 = this.f194968d;
            if (str2 != null && str2.equals(str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("QPayHandler", 2, "QPayReminder: only one offline msg is processed everyday");
                    return;
                }
                return;
            }
            this.f194968d = str;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("QPayReminderSvc.query_over_due_info");
        QPayReminderMsg$GetInfoReq qPayReminderMsg$GetInfoReq = new QPayReminderMsg$GetInfoReq();
        qPayReminderMsg$GetInfoReq.scene.set("qpay");
        qPayReminderMsg$GetInfoReq.sub_cmd.set("query_overdue");
        createToServiceMsg.putWupBuffer(qPayReminderMsg$GetInfoReq.toByteArray());
        createToServiceMsg.addAttribute("is_query", Boolean.TRUE);
        sendPbReq(createToServiceMsg);
        if (QLog.isColorLevel()) {
            QLog.d("QPayHandler", 2, "QPayReminder: send pull request");
        }
    }

    public void H2(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("QPayReminderSvc.query_over_due_info");
        QPayReminderMsg$GetInfoReq qPayReminderMsg$GetInfoReq = new QPayReminderMsg$GetInfoReq();
        qPayReminderMsg$GetInfoReq.scene.set("qpay");
        qPayReminderMsg$GetInfoReq.sub_cmd.set("feedback_overdue");
        qPayReminderMsg$GetInfoReq.info_date.set(str);
        createToServiceMsg.putWupBuffer(qPayReminderMsg$GetInfoReq.toByteArray());
        createToServiceMsg.setNeedCallback(false);
        sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
        } else if ("QPayReminderSvc.query_over_due_info".equals(fromServiceMsg.getServiceCmd())) {
            F2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
