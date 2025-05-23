package com.tencent.mobileqq.servlet;

import NS_MOBILE_PHOTO.get_albumlist_num_rsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneGetAlbumListNumRequest;
import cooperation.qzone.QZoneHelper;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes35.dex */
public class i extends MSFServlet {
    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg != null && fromServiceMsg.getResultCode() == 1000) {
            get_albumlist_num_rsp onResponse = QZoneGetAlbumListNumRequest.onResponse(fromServiceMsg.getWupBuffer());
            if (onResponse != null) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("data", onResponse);
                notifyObserver(null, 1002, true, bundle, com.tencent.mobileqq.activity.photo.album.l.class);
                return;
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("QZoneAlbumListNumServlet", 2, "inform QZoneAlbumListNumServlet isSuccess false");
                }
                notifyObserver(null, 1002, false, new Bundle(), com.tencent.mobileqq.activity.photo.album.l.class);
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("QZoneAlbumListNumServlet", 2, "inform QZoneAlbumListNumServlet resultcode fail.");
        }
        notifyObserver(null, 1002, false, new Bundle(), com.tencent.mobileqq.activity.photo.album.l.class);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        if (intent == null) {
            return;
        }
        byte[] encode = new QZoneGetAlbumListNumRequest(intent.getLongExtra("selfuin", 0L), intent.getStringExtra("refer")).encode();
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setTimeout(60000L);
        packet.setSSOCommand(QZoneHelper.CMD_PREFIX_PUBLIC + "getAlbumListNum");
        packet.putSendData(encode);
    }
}
