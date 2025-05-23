package com.tencent.mobileqq.apollo.handler;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class a extends MSFServlet {
    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        long j3;
        byte[] bArr;
        if (QLog.isColorLevel()) {
            j3 = System.currentTimeMillis();
            QLog.d("VasExtensionServlet", 2, "onReceive cmd=" + intent.getStringExtra("cmd") + ",success=" + fromServiceMsg.isSuccess());
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
        ApolloExtensionHandler apolloExtensionHandler = (ApolloExtensionHandler) ((QQAppInterface) super.getAppRuntime()).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
        if (apolloExtensionHandler != null) {
            apolloExtensionHandler.onReceive(intent, fromServiceMsg, bArr);
        }
        if (QLog.isColorLevel()) {
            QLog.d("VasExtensionServlet", 2, "onReceive exit|cost: " + (System.currentTimeMillis() - j3));
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
                PkgTools.dWord2Byte(bArr, 0, byteArrayExtra.length + 4);
                PkgTools.copyData(bArr, 4, byteArrayExtra, byteArrayExtra.length);
                packet.putSendData(bArr);
            } else {
                byte[] bArr2 = new byte[4];
                PkgTools.dWord2Byte(bArr2, 0, 4L);
                packet.putSendData(bArr2);
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("VasExtensionServlet", 2, "onSend exit cmd=" + stringExtra);
        }
    }
}
