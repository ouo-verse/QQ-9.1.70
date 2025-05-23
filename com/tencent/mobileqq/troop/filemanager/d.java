package com.tencent.mobileqq.troop.filemanager;

import android.content.Intent;
import com.tencent.mobileqq.filemanager.api.ITroopFileProtoReqMgr;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.ProtoServlet;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d extends MSFServlet {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
        } else {
            ((ITroopFileProtoReqMgr) getAppRuntime().getRuntimeService(ITroopFileProtoReqMgr.class, "")).onReceive(intent, fromServiceMsg);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        if (intent == null) {
            return;
        }
        byte[] byteArrayExtra = intent.getByteArrayExtra("data");
        packet.setSSOCommand(intent.getStringExtra("cmd"));
        packet.putSendData(fh.b(byteArrayExtra));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        boolean booleanExtra = intent.getBooleanExtra("fastresendenable", false);
        packet.addAttribute("fastresend", Boolean.valueOf(booleanExtra));
        packet.autoResend = booleanExtra;
        packet.setQuickSend(intent.getBooleanExtra(ProtoServlet.QUICK_SEND_ENABLE, false), intent.getIntExtra(ProtoServlet.QUICK_SEND_STRATEGY, 0));
        packet.addAttribute(BaseConstants.ATTRIBUTE_NEED_REMIND_SLOW_NETWORK, Boolean.valueOf(intent.getBooleanExtra(BaseConstants.ATTRIBUTE_NEED_REMIND_SLOW_NETWORK, true)));
    }
}
