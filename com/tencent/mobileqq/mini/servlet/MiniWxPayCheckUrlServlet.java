package com.tencent.mobileqq.mini.servlet;

import NS_MINI_APP_PAY.MiniAppMidasPay$StWxpayCheckMWebURLRsp;
import NS_QWEB_PROTOCAL.PROTOCAL;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

/* loaded from: classes33.dex */
public class MiniWxPayCheckUrlServlet extends MiniAppAbstractServlet {
    public static final String KEY_APPID = "key_appid";
    public static final String KEY_URL = "key_url";
    public static final String KEY_URL_VALID = "key_url_valid";
    public static final String TAG = "MiniWxPayCheckUrlServlet";

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        try {
            bundle.putInt(MiniAppCmdUtil.KEY_INDEX, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1));
            if (fromServiceMsg != null) {
                PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
                byte[] a16 = fh.a(fromServiceMsg.getWupBuffer());
                stQWebRsp.mergeFrom(a16);
                if (fromServiceMsg.isSuccess()) {
                    bundle.putInt("retCode", (int) stQWebRsp.retCode.get());
                    bundle.putString("errMsg", stQWebRsp.errMsg.get().toStringUtf8());
                    MiniAppMidasPay$StWxpayCheckMWebURLRsp onResponse = WxPayCheckUrlRequest.onResponse(a16);
                    if (onResponse != null) {
                        bundle.putInt("key_url_valid", onResponse.is_valid.get());
                    }
                    notifyObserver(intent, 1077, true, bundle, MiniAppObserver.class);
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "onReceive. MiniWxPayCheckUrlServlet rsp = " + stQWebRsp);
                    }
                    notifyObserver(intent, 1077, false, bundle, MiniAppObserver.class);
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onReceive. inform MiniWxPayCheckUrlServlet resultcode fail.");
                }
                notifyObserver(intent, 1077, false, bundle, MiniAppObserver.class);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5 + "onReceive error");
            notifyObserver(intent, 1077, false, bundle, MiniAppObserver.class);
        }
        doReport(intent, fromServiceMsg);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        String stringExtra = intent.getStringExtra("key_appid");
        String stringExtra2 = intent.getStringExtra("key_url");
        byte[] encode = new WxPayCheckUrlRequest(stringExtra, stringExtra2).encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(WxPayCheckUrlRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
