package com.tencent.imcore.message.decoder;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.data.MessageForDarenAssistant;
import com.tencent.mobileqq.data.MessageForQQWalletTips;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.bt;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class e implements j {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void b(Message message, AppRuntime appRuntime) {
        if (QLog.isColorLevel()) {
            QLog.e("Q.msg.BaseMessageManager", 2, "<0x7f_trace>  0x7f in MsgTab decodeMsg method !");
        }
        message.f203106msg = appRuntime.getApp().getString(R.string.ael) + "(0x7f)";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.StringBuilder] */
    private void c(Message message) {
        String str = "Q.msg.BaseMessageManager";
        StringBuilder sb5 = new StringBuilder(message.f203106msg);
        String extInfoFromExtStr = message.getExtInfoFromExtStr("disc_at_info_list");
        if (message.istroop == 3000 && !TextUtils.isEmpty(extInfoFromExtStr)) {
            try {
                AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
                if (QQAppInterface.class.isInstance(runtime)) {
                    ?? k3 = com.tencent.mobileqq.troop.text.a.k((QQAppInterface) runtime, sb5, extInfoFromExtStr, message.frienduin, message.isSend());
                    sb5 = k3;
                    str = k3;
                } else {
                    str = str;
                    if (QLog.isColorLevel()) {
                        QLog.e("Q.msg.BaseMessageManager", 1, "We get error AppRuntime");
                        str = str;
                    }
                }
            } catch (Exception e16) {
                QLog.e(str, 1, "replaceAtMsgByMarkName", e16);
            }
        }
        if (message.msgtype == -1000) {
            message.emoRecentMsg = new QQText(bt.q(sb5.toString()), 3, 16);
        } else {
            message.emoRecentMsg = new QQText(sb5, 3, 16);
        }
    }

    private void d(Message message, String str, AppRuntime appRuntime) {
        int intValue;
        long longValue;
        String[] split = str.split("\u0016")[1].split("\\|");
        if (split == null) {
            return;
        }
        if (split.length < 2) {
            intValue = 1;
        } else {
            intValue = Integer.valueOf(split[2]).intValue();
        }
        message.fileType = intValue;
        try {
            if (split.length < 2) {
                longValue = -1;
            } else {
                longValue = Long.valueOf(split[1]).longValue();
            }
            message.fileSize = longValue;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.w("Q.msg.BaseMessageManager", 2, "decodeMsg filesize exception", e16);
            }
            message.fileSize = -1L;
        }
        if (intValue != 0) {
            if (intValue != 1) {
                if (intValue != 2) {
                    if (intValue != 65538) {
                        return;
                    }
                } else {
                    message.f203106msg = appRuntime.getApp().getString(R.string.ael);
                    message.pttUrl = split[0];
                    return;
                }
            }
            if (message.msgtype == -3001) {
                message.f203106msg = appRuntime.getApp().getString(R.string.cqt);
                return;
            } else {
                message.f203106msg = appRuntime.getApp().getString(R.string.image);
                return;
            }
        }
        message.f203106msg = appRuntime.getApp().getString(R.string.b5h);
    }

    private void e(Message message, AppRuntime appRuntime) {
        MessageForQQWalletTips messageForQQWalletTips = new MessageForQQWalletTips();
        messageForQQWalletTips.init(message.selfuin, message.frienduin, message.senderuin, "[QQWallet Tips]", com.tencent.mobileqq.service.message.e.K0(), message.msgtype, message.istroop, com.tencent.mobileqq.service.message.e.K0());
        messageForQQWalletTips.msgData = message.msgData;
        messageForQQWalletTips.isread = true;
        messageForQQWalletTips.parse();
        messageForQQWalletTips.buildQQWalletTips((QQAppInterface) appRuntime, appRuntime.getApp(), null);
        message.f203106msg = messageForQQWalletTips.summary;
    }

    private boolean f(String str) {
        if (str.charAt(0) == 22) {
            String[] split = str.split("\u0016")[1].split("\\|");
            if (split.length < 2) {
                return true;
            }
            if (split.length > 3) {
                try {
                    Long.valueOf(split[1]);
                    Integer.valueOf(split[2]);
                    Boolean.valueOf(split[3]);
                    return true;
                } catch (NumberFormatException unused) {
                }
            }
        }
        return false;
    }

    @Override // com.tencent.imcore.message.decoder.j
    public void a(Message message, IMessageManager iMessageManager, AppRuntime appRuntime) throws Exception {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, message, iMessageManager, appRuntime);
            return;
        }
        String str2 = message.f203106msg;
        if (str2 != null) {
            String str3 = "";
            if (!"".equals(str2)) {
                String str4 = message.f203106msg;
                if (f(str4)) {
                    d(message, str4, appRuntime);
                    return;
                }
                int i3 = message.msgtype;
                if (i3 == -2006) {
                    b(message, appRuntime);
                    return;
                }
                if (i3 == -2008) {
                    message.f203106msg = appRuntime.getApp().getString(R.string.f173091hb0);
                    return;
                }
                if (message.f203106msg.indexOf(AppConstants.GOOGLEMAP_URL_HTTPS) != -1) {
                    String[] m3 = com.tencent.mobileqq.service.message.s.m(message.f203106msg);
                    if (m3 != null && (str = m3[2]) != null) {
                        str3 = str;
                    }
                    message.fileType = 65536;
                    message.f203106msg = "[" + appRuntime.getApp().getString(R.string.f173220i45) + "] " + str3;
                    return;
                }
                int i16 = message.msgtype;
                if (i16 == -2029) {
                    e(message, appRuntime);
                    return;
                }
                if (i16 == -2068) {
                    MessageForDarenAssistant messageForDarenAssistant = new MessageForDarenAssistant();
                    messageForDarenAssistant.msgData = message.msgData;
                    messageForDarenAssistant.parse();
                    message.f203106msg = messageForDarenAssistant.f203106msg;
                    return;
                }
                if (com.tencent.mobileqq.mutualmark.oldlogic.c.c((QQAppInterface) appRuntime, message)) {
                    message.emoRecentMsg = com.tencent.mobileqq.mutualmark.oldlogic.c.k(appRuntime.getApp(), message.f203106msg);
                } else {
                    c(message);
                }
            }
        }
    }
}
