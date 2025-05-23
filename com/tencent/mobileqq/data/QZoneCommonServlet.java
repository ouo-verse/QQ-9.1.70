package com.tencent.mobileqq.data;

import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import cooperation.qzone.QZoneCommonRequest;
import cooperation.qzone.QZoneHelper;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QZoneCommonServlet extends MSFServlet {
    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        if (intent == null || !(intent instanceof QzoneCommonIntent)) {
            return;
        }
        QzoneCommonIntent qzoneCommonIntent = (QzoneCommonIntent) intent;
        qzoneCommonIntent.getProcessor().accept(this, qzoneCommonIntent, fromServiceMsg);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        if (intent instanceof QzoneCommonIntent) {
            QZoneCommonRequest request = ((QzoneCommonIntent) intent).getRequest();
            byte[] encode = request.encode();
            if (encode == null) {
                encode = new byte[4];
            }
            packet.setTimeout(30000L);
            packet.setSSOCommand(QZoneHelper.CMD_PREFIX_PUBLIC + request.uniKey());
            packet.putSendData(encode);
        }
    }
}
