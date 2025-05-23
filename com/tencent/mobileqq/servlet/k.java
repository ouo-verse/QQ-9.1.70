package com.tencent.mobileqq.servlet;

import NS_GROUP_COUNT.mobile_group_count_rsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.GetQzoneGroupCountRequest;
import cooperation.qzone.QZoneHelper;
import java.util.HashMap;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes35.dex */
public class k extends MSFServlet {
    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        GetQzoneGroupCountRequest getQzoneGroupCountRequest = new GetQzoneGroupCountRequest(Long.valueOf(intent.getLongExtra("key_uin", 0L)).longValue(), Long.valueOf(intent.getLongExtra("key_troop_uin", 0L)).longValue(), new HashMap());
        byte[] encode = getQzoneGroupCountRequest.encode();
        if (encode == null) {
            QLog.e("NotifyQZoneServer", 1, "onSend request encode result is null.cmd=" + getQzoneGroupCountRequest.uniKey());
            encode = new byte[4];
        }
        packet.setTimeout(30000L);
        packet.setSSOCommand(QZoneHelper.CMD_PREFIX_PUBLIC + GetQzoneGroupCountRequest.CMD_STRING);
        packet.putSendData(encode);
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg != null) {
            try {
                if (fromServiceMsg.getResultCode() == 1000) {
                    Long valueOf = Long.valueOf(intent.getLongExtra("key_troop_uin", 0L));
                    mobile_group_count_rsp onResponse = GetQzoneGroupCountRequest.onResponse(fromServiceMsg.getWupBuffer(), new int[1]);
                    if (onResponse != null) {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("data", onResponse);
                        ((QZoneManagerImp) getAppRuntime().getManager(QQManagerFactory.QZONE_MANAGER)).y(String.valueOf(valueOf), onResponse);
                        notifyObserver(null, 1006, true, bundle, QZoneObserver.class);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("QZoneGetGroupCountServlet", 2, "inform QZoneGetGroupCountServlet isSuccess false");
                    }
                    notifyObserver(null, 1006, false, new Bundle(), QZoneObserver.class);
                    return;
                }
            } catch (Throwable th5) {
                QLog.e("QZoneGetGroupCountServlet", 1, th5 + "onReceive error");
                notifyObserver(null, 1006, false, new Bundle(), QZoneObserver.class);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("QZoneGetGroupCountServlet", 2, "inform QZoneGetGroupCountServlet resultcode fail.");
        }
        notifyObserver(null, 1006, false, new Bundle(), QZoneObserver.class);
    }
}
