package com.tencent.mobileqq.gamecenter.protocols;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes12.dex */
public class e extends MSFServlet {
    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        long j3;
        byte[] bArr;
        if (QLog.isColorLevel()) {
            j3 = System.currentTimeMillis();
            QLog.d("GameCenterUnissoServlet", 2, "onReceive cmd=" + intent.getStringExtra("cmd") + ",success=" + fromServiceMsg.isSuccess());
        } else {
            j3 = 0;
        }
        if (fromServiceMsg.isSuccess()) {
            int length = fromServiceMsg.getWupBuffer().length - 4;
            bArr = new byte[length];
            PkgTools.copyData(bArr, 0, fromServiceMsg.getWupBuffer(), 4, length);
        } else {
            bArr = null;
        }
        GameCenterUnissoHandler N2 = GameCenterUnissoHandler.N2();
        if (N2 != null) {
            N2.onReceive(intent, fromServiceMsg, bArr);
        }
        if (QLog.isColorLevel()) {
            QLog.d("GameCenterUnissoServlet", 2, "onReceive exit|cost: " + (System.currentTimeMillis() - j3));
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        String stringExtra = intent.getStringExtra("cmd");
        byte[] byteArrayExtra = intent.getByteArrayExtra("data");
        long longExtra = intent.getLongExtra("timeout", 30000L);
        if (!TextUtils.isEmpty(stringExtra)) {
            packet.setSSOCommand(stringExtra);
            packet.setTimeout(longExtra);
            if (byteArrayExtra != null) {
                byte[] bArr = new byte[byteArrayExtra.length + 4];
                PkgTools.DWord2Byte(bArr, 0, byteArrayExtra.length + 4);
                PkgTools.copyData(bArr, 4, byteArrayExtra, byteArrayExtra.length);
                packet.putSendData(bArr);
            } else {
                byte[] bArr2 = new byte[4];
                PkgTools.DWord2Byte(bArr2, 0, 4L);
                packet.putSendData(bArr2);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("GameCenterUnissoServlet", 2, "onSend exit cmd=" + stringExtra);
        }
    }
}
