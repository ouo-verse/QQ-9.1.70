package com.tencent.mobileqq.servlet;

import NS_MOBILE_NEWEST_FEEDS.newest_feeds_rsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.Collections;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes35.dex */
public class a extends MSFServlet {
    public static void requestAddFriendShowQZoneFeeds(long j3, BusinessObserver businessObserver) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        NewIntent newIntent = new NewIntent(peekAppRuntime.getApplication(), a.class);
        com.tencent.mobileqq.qzonestatus.d.b(newIntent, com.tencent.mobileqq.qzonestatus.d.a(8, peekAppRuntime.getLongAccountUin(), new ArrayList(Collections.singletonList(Long.valueOf(j3))), 0L, ""));
        newIntent.setObserver(businessObserver);
        peekAppRuntime.startServlet(newIntent);
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        Object obj;
        if (fromServiceMsg != null && fromServiceMsg.getResultCode() == 1000) {
            newest_feeds_rsp a16 = com.tencent.mobileqq.qzonestatus.c.a(fromServiceMsg.getWupBuffer());
            boolean z16 = a16 != null && a16.code == 0;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onReceive rsp status isSuccess | code = ");
            if (a16 != null) {
                obj = Integer.valueOf(a16.code);
            } else {
                obj = "result == null";
            }
            sb5.append(obj);
            QLog.d("AddFriendShowQZoneFeedServlet", 1, sb5.toString());
            if (z16) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", a16);
                notifyObserver(intent, 0, true, bundle, null);
                return;
            }
            return;
        }
        QLog.e("AddFriendShowQZoneFeedServlet", 1, "onReceive rsp status fail.");
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        if (intent == null) {
            return;
        }
        byte[] encode = new com.tencent.mobileqq.qzonestatus.c(com.tencent.mobileqq.qzonestatus.d.c(intent)).encode();
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setTimeout(60000L);
        packet.setSSOCommand(QZoneHelper.CMD_PREFIX_PUBLIC + "getAIONewestFeeds");
        packet.putSendData(encode);
    }
}
