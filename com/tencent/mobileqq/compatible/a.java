package com.tencent.mobileqq.compatible;

import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.Arrays;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import mqq.inject.MqqInjectorManager;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends MSFServlet {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static String[] a(String[] strArr, String[] strArr2) {
        String[] strArr3 = (String[]) Arrays.copyOf(strArr, strArr.length + strArr2.length);
        System.arraycopy(strArr2, 0, strArr3, strArr.length, strArr2.length);
        return strArr3;
    }

    @Override // mqq.app.MSFServlet
    public String[] getPreferSSOCommands() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return a(MqqInjectorManager.instance().tempServletPreferSSOCommand(), new String[]{BaseConstants.CMD_MSF_NOTIFYRESP, "NearFieldDiscussSvr.NotifyList", "RegPrxySvc.QueryIpwdStat", IOnlineStatusService.CMD_RECV_MUSIC_STATUS_PUSH, "MessageSvc.PushGroupMsg", "RegPrxySvc.PushParam", "AccostSvc.SvrMsg"});
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        ToServiceMsg toServiceMsg;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if (intent != null) {
            toServiceMsg = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
            fromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), toServiceMsg);
        } else {
            toServiceMsg = new ToServiceMsg("", fromServiceMsg.getUin(), fromServiceMsg.getServiceCmd());
        }
        if ((getAppRuntime() instanceof BaseQQAppInterface) && toServiceMsg != null) {
            ((AppInterface) getAppRuntime()).receiveToService(toServiceMsg, fromServiceMsg);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        ToServiceMsg toServiceMsg;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        if (intent != null && (toServiceMsg = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getSimpleName())) != null) {
            packet.setSSOCommand(toServiceMsg.getServiceCmd());
            packet.putSendData(toServiceMsg.getWupBuffer());
            packet.setTimeout(toServiceMsg.getTimeout());
            packet.setAttributes(toServiceMsg.getAttributes());
            if (!toServiceMsg.isNeedCallback()) {
                packet.setNoResponse();
            }
        }
    }
}
