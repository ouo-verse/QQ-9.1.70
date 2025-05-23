package com.tencent.trpcprotocol.qqlog.qqlog_server;

import android.content.Intent;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes27.dex */
public class a extends MSFServlet {
    @Override // mqq.app.MSFServlet, mqq.app.Servlet
    public void service(Intent intent) {
        super.service(intent);
        if (intent.getIntExtra("action", 0) == 199) {
            int intExtra = intent.getIntExtra(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_COLOR_LEVEL, 1);
            ToServiceMsg toServiceMsg = new ToServiceMsg(MsfServiceSdk.get().getMsfServiceName(), MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin(), "");
            toServiceMsg.setMsfCommand(MsfCommand.msf_new_log_report_color);
            toServiceMsg.setTimeout(30000L);
            toServiceMsg.setNeedCallback(false);
            toServiceMsg.getAttributes().put(BaseConstants.ATTRIBUTE_KEY_LOGREPORT_COLOR_LEVEL, Integer.valueOf(intExtra));
            sendToMSF(intent, toServiceMsg);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
    }
}
