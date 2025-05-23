package com.tencent.mobileqq.profilecard.bussiness.qzone;

import NS_MOBILE_NEWEST_FEEDS.newest_feeds_rsp;
import android.content.Intent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qzonestatus.c;
import com.tencent.mobileqq.qzonestatus.d;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QZoneUrgeUpdateFeedServlet extends MSFServlet {
    static IPatchRedirector $redirector_ = null;
    private static final String CMD_PREFIX_PUBLIC = "SQQzoneSvc.";
    private static final String TAG = "QZoneUrgeUpdateFeedServlet";
    private static final int TIMEOUT = 60000;

    public QZoneUrgeUpdateFeedServlet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if (fromServiceMsg != null && fromServiceMsg.getResultCode() == 1000) {
            int[] iArr = new int[1];
            newest_feeds_rsp b16 = c.b(fromServiceMsg.getWupBuffer(), iArr);
            if (b16 != null && b16.code == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            int i3 = iArr[0];
            SimpleEventBus.getInstance().dispatchEvent(new QZoneUrgeUpdateRspResultEvent(z16, i3));
            QLog.d(TAG, 1, "onReceive rsp status finish | isSuccess = " + z16 + " | code = " + i3);
            return;
        }
        QLog.e(TAG, 1, "onReceive rsp status fail.");
        SimpleEventBus.getInstance().dispatchEvent(new QZoneUrgeUpdateRspResultEvent(false, -1));
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
        packet.setSSOCommand("SQQzoneSvc.getAIONewestFeeds");
        packet.putSendData(encode);
    }
}
