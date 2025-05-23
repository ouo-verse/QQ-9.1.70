package com.tencent.mobileqq.qzonestatus;

import NS_MOBILE_NEWEST_FEEDS.newest_feeds_rsp;
import android.content.Intent;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import cooperation.qzone.QZoneHelper;
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
        int resultCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if (fromServiceMsg != null && fromServiceMsg.getResultCode() == 1000) {
            newest_feeds_rsp a16 = c.a(fromServiceMsg.getWupBuffer());
            if (a16 != null) {
                RFWLog.d("QZoneVideoContactsFeedServlet", RFWLog.CLR, "inform QZoneVideoContactsFeedServlet success");
                a.h().k(a16);
                return;
            } else {
                RFWLog.d("QZoneVideoContactsFeedServlet", RFWLog.CLR, "inform QZoneVideoContactsFeedServlet false");
                return;
            }
        }
        int i3 = RFWLog.CLR;
        Object[] objArr = new Object[1];
        StringBuilder sb5 = new StringBuilder();
        sb5.append("inform QZoneVideoContactsFeedServlet resultCode fail. ");
        if (fromServiceMsg == null) {
            resultCode = -1;
        } else {
            resultCode = fromServiceMsg.getResultCode();
        }
        sb5.append(resultCode);
        objArr[0] = sb5.toString();
        RFWLog.d("QZoneVideoContactsFeedServlet", i3, objArr);
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
        byte[] encode = new c(d.c(intent)).encode();
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setTimeout(60000L);
        packet.setSSOCommand(QZoneHelper.CMD_PREFIX_PUBLIC + "getAIONewestFeeds");
        RFWLog.d("QZoneVideoContactsFeedServlet", RFWLog.USR, "start QZoneVideoContactsFeedServlet");
        packet.putSendData(encode);
    }
}
