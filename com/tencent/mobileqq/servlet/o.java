package com.tencent.mobileqq.servlet;

import NS_MOBILE_EXTRA.mobile_get_qzone_public_msg_rsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.impl.QZoneApiProxyImpl;
import cooperation.qzone.GetQzonePublicMsgRequest;
import cooperation.qzone.QZoneHelper;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes35.dex */
public class o extends MSFServlet {
    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        long longExtra = intent.getLongExtra("key_uin", 0L);
        String stringExtra = intent.getStringExtra("has_photo");
        HashMap hashMap = new HashMap();
        hashMap.put("has_photo", stringExtra);
        GetQzonePublicMsgRequest getQzonePublicMsgRequest = new GetQzonePublicMsgRequest(longExtra, hashMap);
        byte[] encode = getQzonePublicMsgRequest.encode();
        if (encode == null) {
            QLog.e("NotifyQZoneServer", 1, "onSend request encode result is null.cmd=" + getQzonePublicMsgRequest.uniKey());
            encode = new byte[4];
        }
        packet.setTimeout(30000L);
        packet.setSSOCommand(QZoneHelper.CMD_PREFIX_PUBLIC + getQzonePublicMsgRequest.uniKey());
        packet.putSendData(encode);
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg != null) {
            try {
                if (fromServiceMsg.getResultCode() == 1000) {
                    mobile_get_qzone_public_msg_rsp onResponse = GetQzonePublicMsgRequest.onResponse(fromServiceMsg.getWupBuffer(), new int[1]);
                    if (onResponse != null) {
                        if (getAppRuntime() != null && getAppRuntime().getApplication() != null) {
                            MobileQQ application = getAppRuntime().getApplication();
                            Map<String, String> map = onResponse.map_ext;
                            boolean z16 = map != null && "1".equals(map.get("show_feeds"));
                            Map<String, String> map2 = onResponse.map_ext;
                            QZoneApiProxyImpl.recordSubFeedConfig(application, z16, map2 == null ? null : map2.get("title_name"));
                        }
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("data", onResponse);
                        notifyObserver(null, 1004, true, bundle, QZoneObserver.class);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("QzonePublicMsgServlet", 2, "inform QzonePublicMsgServlet isSuccess false");
                    }
                    notifyObserver(null, 1004, false, new Bundle(), QZoneObserver.class);
                    return;
                }
            } catch (Throwable th5) {
                QLog.e("QzonePublicMsgServlet", 1, th5 + "onReceive error");
                notifyObserver(null, 1004, false, new Bundle(), QZoneObserver.class);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("QzonePublicMsgServlet", 2, "inform QzonePublicMsgServlet resultcode fail.");
        }
        notifyObserver(null, 1004, false, new Bundle(), QZoneObserver.class);
    }
}
