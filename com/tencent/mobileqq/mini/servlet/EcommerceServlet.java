package com.tencent.mobileqq.mini.servlet;

import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class EcommerceServlet extends MSFServlet {
    public static final String CMD_SSO_GET_GOODS = "trpc.qqecommerce.access.CommAccess.SsoGetGoods";
    public static final String EXTRA_CMD = "cmd";
    public static final String EXTRA_DATA = "data";
    public static final String EXTRA_REQUEST_KEY = "requestKey";
    public static final String EXTRA_TIMEOUT = "timeout";
    private static final String TAG = "EcommerceServlet";

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        String str;
        if (intent != null && fromServiceMsg != null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onReceive cmd=" + intent.getStringExtra("cmd") + ",success=" + fromServiceMsg.isSuccess());
            }
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (serviceCmd == null) {
                return;
            }
            if (QLog.isColorLevel()) {
                boolean isSuccess = fromServiceMsg.isSuccess();
                StringBuilder sb5 = new StringBuilder();
                sb5.append("resp:");
                sb5.append(serviceCmd);
                sb5.append(" is ");
                if (isSuccess) {
                    str = "";
                } else {
                    str = "not";
                }
                sb5.append(str);
                sb5.append(" success");
                QLog.d(TAG, 2, sb5.toString());
            }
            if (serviceCmd.equals(CMD_SSO_GET_GOODS)) {
                EcommerceRequest.getInstance().onGetGoodsRsp(intent, fromServiceMsg);
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "onReceive error: null");
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        byte[] byteArrayExtra = intent.getByteArrayExtra("data");
        String stringExtra = intent.getStringExtra("cmd");
        long longExtra = intent.getLongExtra("timeout", 10000L);
        packet.setSSOCommand(stringExtra);
        packet.setTimeout(longExtra);
        packet.putSendData(byteArrayExtra);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onSend exit cmd=" + stringExtra);
        }
    }
}
