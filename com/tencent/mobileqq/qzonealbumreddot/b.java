package com.tencent.mobileqq.qzonealbumreddot;

import NS_MOBILE_PHOTO.operation_red_touch_req;
import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import java.io.Serializable;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b extends MSFServlet {
    static IPatchRedirector $redirector_;

    public b() {
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
        if (fromServiceMsg != null) {
            if (QLog.isColorLevel()) {
                QLog.d("QzoneAlbumRedDotServlet", 2, "resultcode:" + fromServiceMsg.getResultCode() + ",failMsg:" + fromServiceMsg.getBusinessFailMsg());
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("QzoneAlbumRedDotServlet", 2, "fromServiceMsg==msg");
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        Serializable serializableExtra = intent.getSerializableExtra("req");
        if (serializableExtra != null && (serializableExtra instanceof operation_red_touch_req)) {
            a aVar = new a(getAppRuntime().getLongAccountUin(), (operation_red_touch_req) serializableExtra);
            byte[] encode = aVar.encode();
            if (encode == null) {
                encode = new byte[4];
            }
            packet.setTimeout(60000L);
            packet.setSSOCommand(QZoneHelper.CMD_PREFIX_PUBLIC + aVar.uniKey());
            packet.putSendData(encode);
        }
    }
}
