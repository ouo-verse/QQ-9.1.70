package com.tencent.mobileqq.servlet;

import NS_MOBILE_AIONewestFeed.AIONewestFeedRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneNewestFeedRequest;
import java.util.ArrayList;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes35.dex */
public class j extends MSFServlet {
    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        intent.getStringExtra(MiniAppCmdUtil.KEY_CMD_STRING);
        if (fromServiceMsg == null || fromServiceMsg.getResultCode() != 1000) {
            if (fromServiceMsg != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("QZoneFeedsServlet", 2, "inform QZoneFeedsServlet resultcode fail.");
                }
                notifyObserver(null, 1001, false, new Bundle(), QZoneObserver.class);
                return;
            }
            return;
        }
        AIONewestFeedRsp onResponse = QZoneNewestFeedRequest.onResponse(fromServiceMsg.getWupBuffer(), (QQAppInterface) getAppRuntime(), new int[1]);
        if (onResponse != null) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("data", onResponse);
            notifyObserver(null, 1001, true, bundle, QZoneObserver.class);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("QZoneFeedsServlet", 2, "inform QZoneFeedsServlet isSuccess false:", fromServiceMsg.getBusinessFailMsg());
            }
            notifyObserver(null, 1001, false, new Bundle(), QZoneObserver.class);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        if (intent == null) {
            return;
        }
        long longExtra = intent.getLongExtra("selfuin", 0L);
        long[] longArrayExtra = intent.getLongArrayExtra("hostuin");
        if (longArrayExtra == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(longArrayExtra.length);
        for (long j3 : longArrayExtra) {
            arrayList.add(Long.valueOf(j3));
        }
        QZoneNewestFeedRequest qZoneNewestFeedRequest = new QZoneNewestFeedRequest(longExtra, arrayList, intent.getLongExtra("lasttime", 0L), intent.getStringExtra("refer"), intent.getIntExtra("src", 0));
        byte[] encode = qZoneNewestFeedRequest.encode();
        intent.putExtra(MiniAppCmdUtil.KEY_CMD_STRING, qZoneNewestFeedRequest.getCmdString());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setTimeout(60000L);
        packet.setSSOCommand(QZoneHelper.CMD_PREFIX_PUBLIC + "getAIONewestFeed");
        packet.putSendData(encode);
    }
}
