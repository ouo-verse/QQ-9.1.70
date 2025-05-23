package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_QWEB_PROTOCAL.PROTOCAL;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniMidasConsumeServlet extends MiniAppAbstractServlet {
    public static final String KEY_APPID = "key_appid";
    public static final String KEY_BALANCE_AMOUNT = "key_balance_amount";
    public static final String KEY_EXT = "key_ext";
    public static final String KEY_EXTENDINFO = "key_extendinfo";
    public static final String KEY_PAY_CHANNEL = "key_pay_channel";
    public static final String KEY_PAY_ENV = "key_pay_env";
    public static final String KEY_PREPAY_ID = "key_prepay_id";
    public static final String KEY_STAR_CURRENCY = "key_star_currency";
    public static final String KEY_TOPUP_AMOUNT = "key_topup_amount";
    public static final String TAG = "MiniMidasConsumeServlet";

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        try {
            bundle.putInt(MiniAppCmdUtil.KEY_INDEX, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1));
            if (fromServiceMsg != null) {
                PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
                stQWebRsp.mergeFrom(fh.a(fromServiceMsg.getWupBuffer()));
                if (fromServiceMsg.isSuccess()) {
                    bundle.putParcelable("getMidasConsumeResult", fromServiceMsg);
                    bundle.putInt("getMidasConsumeResultRetCode", (int) stQWebRsp.retCode.get());
                    bundle.putString("getMidasConsumeResultErrMsg", stQWebRsp.errMsg.get().toStringUtf8());
                    notifyObserver(intent, 1025, true, bundle, MiniAppObserver.class);
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "onReceive. MiniAppPayServlet rsp = " + stQWebRsp);
                    }
                    notifyObserver(intent, 1025, false, bundle, MiniAppObserver.class);
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onReceive. inform MiniAppPayServlet resultcode fail.");
                }
                notifyObserver(intent, 1025, false, bundle, MiniAppObserver.class);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5 + "onReceive error");
            notifyObserver(intent, 1025, false, bundle, MiniAppObserver.class);
        }
        doReport(intent, fromServiceMsg);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        COMM.StCommonExt stCommonExt;
        String stringExtra = intent.getStringExtra("key_appid");
        String stringExtra2 = intent.getStringExtra("key_prepay_id");
        int intExtra = intent.getIntExtra("key_star_currency", 0);
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_ext");
        int intExtra2 = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
        int intExtra3 = intent.getIntExtra(KEY_BALANCE_AMOUNT, -1);
        int intExtra4 = intent.getIntExtra(KEY_TOPUP_AMOUNT, -1);
        int intExtra5 = intent.getIntExtra(KEY_PAY_CHANNEL, -1);
        int intExtra6 = intent.getIntExtra(KEY_PAY_ENV, 0);
        if (byteArrayExtra != null) {
            COMM.StCommonExt stCommonExt2 = new COMM.StCommonExt();
            try {
                stCommonExt2.mergeFrom(byteArrayExtra);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "onSend. mergeFrom extData exception!");
                }
                e16.printStackTrace();
            }
            stCommonExt = stCommonExt2;
        } else {
            stCommonExt = null;
        }
        byte[] encode = new PayRequest(stringExtra, stCommonExt, stringExtra2, intExtra, intExtra3, intExtra4, intExtra5, intExtra6).encode(intent, intExtra2, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(PayRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
