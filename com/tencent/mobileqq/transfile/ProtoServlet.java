package com.tencent.mobileqq.transfile;

import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* loaded from: classes19.dex */
public class ProtoServlet extends MSFServlet {
    static IPatchRedirector $redirector_ = null;
    public static final String KEY_BODY = "key_body";
    public static final String KEY_CMD = "key_cmd";
    public static final String KEY_FAST_RESEND_ENABLE = "key_fastresend";
    public static final String KEY_TIMEOUT = "key_timeout";
    public static final String QUICK_SEND_ENABLE = "quickSendEnable";
    public static final String QUICK_SEND_STRATEGY = "quickSendStrategy";

    public ProtoServlet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if ("LongConn.OffPicUp".equalsIgnoreCase(fromServiceMsg.getServiceCmd()) || "ImgStore.GroupPicUp".equalsIgnoreCase(fromServiceMsg.getServiceCmd())) {
            QLog.d(ProtoReqManagerImpl.TAG, 1, "onRecieve." + fromServiceMsg.getStringForLog());
        }
        ((IProtoReqManager) getAppRuntime().getRuntimeService(IProtoReqManager.class, "")).onReceive(intent, fromServiceMsg);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        if (intent != null) {
            packet.setSSOCommand(intent.getStringExtra("key_cmd"));
            packet.putSendData(intent.getByteArrayExtra(KEY_BODY));
            packet.setTimeout(intent.getLongExtra(KEY_TIMEOUT, 30000L));
            boolean booleanExtra = intent.getBooleanExtra(KEY_FAST_RESEND_ENABLE, false);
            packet.addAttribute("fastresend", Boolean.valueOf(booleanExtra));
            packet.autoResend = booleanExtra;
            packet.addAttribute(BaseConstants.ATTRIBUTE_NEED_REMIND_SLOW_NETWORK, Boolean.valueOf(intent.getBooleanExtra(BaseConstants.ATTRIBUTE_NEED_REMIND_SLOW_NETWORK, true)));
            packet.setQuickSend(intent.getBooleanExtra(QUICK_SEND_ENABLE, false), intent.getIntExtra(QUICK_SEND_STRATEGY, 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.MSFServlet
    public void sendToMSF(Intent intent, ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) toServiceMsg);
            return;
        }
        if ("LongConn.OffPicUp".equalsIgnoreCase(toServiceMsg.getServiceCmd()) || "ImgStore.GroupPicUp".equalsIgnoreCase(toServiceMsg.getServiceCmd())) {
            QLog.d(ProtoReqManagerImpl.TAG, 1, "onSend." + toServiceMsg.getStringForLog());
        }
        super.sendToMSF(intent, toServiceMsg);
    }
}
