package com.tencent.qidian.util;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.bmqq.protocol.Crm$CrmCCNotify;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.f;
import com.tencent.mobileqq.graytip.g;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.ab;
import com.tencent.mobileqq.service.message.e;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.msg.im_msg_body$Elem;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static void a(AppInterface appInterface, int i3, String str, String str2, String str3, String str4, long j3) {
        int indexOf;
        if (TextUtils.isEmpty(str4) || (indexOf = str4.indexOf(appInterface.getApp().getString(R.string.f0l))) == -1) {
            return;
        }
        g gVar = new g(str, appInterface.getCurrentAccountUin(), str4, i3, MessageRecord.MSG_TYPE_UNITE_TAB_HISTORI_INVI, 1245186, e.K0());
        gVar.f213695r = false;
        gVar.f213686i = j3;
        Bundle bundle = new Bundle();
        bundle.putInt("key_action", 12);
        gVar.b(indexOf, indexOf + 4, bundle);
        MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
        messageForUniteGrayTip.initGrayTipMsg(appInterface, gVar);
        messageForUniteGrayTip.masterUin = str2;
        messageForUniteGrayTip.extUin = str;
        messageForUniteGrayTip.taskId = str3;
        f.a(appInterface, messageForUniteGrayTip);
    }

    public static void b(QQAppInterface qQAppInterface, String str, String str2, int i3, String str3) {
        long K0 = e.K0();
        g gVar = new g(str, qQAppInterface.getCurrentAccountUin(), str2, i3, MessageRecord.MSG_TYPE_UNITE_GRAY_TAB_INVI, 1245187, K0);
        gVar.f213695r = false;
        gVar.f213686i = K0;
        gVar.f213693p = str3;
        MessageForUniteGrayTip messageForUniteGrayTip = new MessageForUniteGrayTip();
        messageForUniteGrayTip.initGrayTipMsg(qQAppInterface, gVar);
        f.a(qQAppInterface, messageForUniteGrayTip);
    }

    public static int c(String str) {
        int i3 = 0;
        try {
            String[] split = str.split("\\.");
            int i16 = 24;
            int i17 = 0;
            while (i3 < split.length) {
                try {
                    i17 = (int) (i17 | (Long.parseLong(split[i3]) << i16));
                    i16 -= 8;
                    i3++;
                } catch (Exception e16) {
                    e = e16;
                    i3 = i17;
                    e.printStackTrace();
                    return i3;
                }
            }
            return i17;
        } catch (Exception e17) {
            e = e17;
        }
    }

    public static void d(ab abVar, msg_comm$Msg msg_comm_msg, MessageRecord messageRecord) {
        if (abVar != null && abVar.f286173a == 1024 && msg_comm_msg.msg_body.rich_text.has() && msg_comm_msg.msg_body.rich_text.elems.has()) {
            for (im_msg_body$Elem im_msg_body_elem : msg_comm_msg.msg_body.rich_text.elems.get()) {
                if (im_msg_body_elem.has() && im_msg_body_elem.crm_elem.has() && im_msg_body_elem.crm_elem.crm_buf.has()) {
                    Crm$CrmCCNotify crm$CrmCCNotify = new Crm$CrmCCNotify();
                    try {
                        crm$CrmCCNotify.mergeFrom(im_msg_body_elem.crm_elem.crm_buf.get().toByteArray());
                        if (crm$CrmCCNotify.str_ext_nick_name.has()) {
                            messageRecord.saveExtInfoToExtStr("qidian_ext_nick_name", crm$CrmCCNotify.str_ext_nick_name.get());
                        }
                    } catch (InvalidProtocolBufferMicroException e16) {
                        QLog.d("QidianUtils", 2, "qidian add ext name in master session " + e16);
                    }
                }
            }
        }
    }

    private static void e(QQAppInterface qQAppInterface, String str, int i3, int i16, int i17, String str2) {
        String str3;
        String str4;
        if (str != null && !str.equals(qQAppInterface.getCurrentAccountUin()) && !TextUtils.isEmpty(str2)) {
            if (i16 == -1000) {
                str3 = "1";
            } else if (i16 == -2000) {
                str3 = "2";
            } else if (i16 == -2005) {
                str3 = "3";
            } else if (i16 == -2011) {
                str3 = "4";
            } else {
                str3 = "0";
            }
            String str5 = str3;
            if (i3 == 0) {
                str4 = "0X800980B";
            } else if (i3 == 1024) {
                str4 = "0X8009810";
            } else if (i3 == 1025) {
                str4 = "0X8009811";
            } else if (i3 == 1000) {
                str4 = "0X800980E";
            } else {
                str4 = null;
            }
            String str6 = str4;
            if (str6 != null) {
                ReportController.o(qQAppInterface, "dc00899", "Qidian", str, str6, "1", 1, 0, str5, "0", String.valueOf(i17), str2);
            }
        }
    }

    public static void f(QQAppInterface qQAppInterface, List<MessageRecord> list, msg_comm$Msg msg_comm_msg, ab abVar, Crm$CrmCCNotify crm$CrmCCNotify) {
        if (list.isEmpty()) {
            return;
        }
        int i3 = 0;
        MessageRecord messageRecord = list.get(0);
        if (messageRecord != null && !messageRecord.isSend()) {
            String valueOf = String.valueOf(msg_comm_msg.msg_head.from_uin.get());
            if (abVar != null) {
                i3 = abVar.f286173a;
            }
            e(qQAppInterface, valueOf, i3, messageRecord.msgtype, msg_comm_msg.msg_head.msg_time.get(), crm$CrmCCNotify.str_check_id.get());
        }
    }
}
