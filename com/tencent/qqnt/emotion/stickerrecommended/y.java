package com.tencent.qqnt.emotion.stickerrecommended;

import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.ProtoServlet;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.stickerrecommended.impl.StickerRecManagerImpl;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes24.dex */
public class y extends MSFServlet {
    static IPatchRedirector $redirector_;

    public y() {
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
            return;
        }
        AppRuntime appRuntime = getAppRuntime();
        if (appRuntime != null && (appRuntime instanceof AppInterface)) {
            StickerRecManagerImpl.get((AppInterface) appRuntime).handleResponse(intent, fromServiceMsg);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
        } else {
            if (intent == null) {
                QLog.e("StickerRecServlet", 1, "onSend : req is null");
                return;
            }
            packet.setSSOCommand(intent.getStringExtra("key_cmd"));
            packet.putSendData(intent.getByteArrayExtra(ProtoServlet.KEY_BODY));
            packet.setTimeout(intent.getLongExtra(ProtoServlet.KEY_TIMEOUT, 6000L));
        }
    }
}
