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
public class MiniAppSendArkMsgServlet extends MiniAppAbstractServlet {
    public static final String KEY_API_NAME = "key_api_name";
    public static final String KEY_APPID = "key_appid";
    public static final String KEY_ARK_JSON = "key_ark_json";
    public static final String KEY_EXT = "key_ext";
    public static final String KEY_OPENID = "key_openid";
    public static final String TAG = "MiniAppSendArkMsgServlet";
    private int index;

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onReceive.");
        }
        Bundle bundle = new Bundle();
        try {
            bundle.putInt(MiniAppCmdUtil.KEY_INDEX, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1));
            if (fromServiceMsg != null) {
                PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
                stQWebRsp.mergeFrom(fh.a(fromServiceMsg.getWupBuffer()));
                bundle.putInt(MiniAppCmdUtil.KEY_INDEX, (int) stQWebRsp.Seq.get());
                if (fromServiceMsg.isSuccess()) {
                    bundle.putParcelable("sendArkMsg", fromServiceMsg);
                    bundle.putLong("retCode", stQWebRsp.retCode.get());
                    bundle.putString("errMsg", stQWebRsp.errMsg.get().toStringUtf8());
                    notifyObserver(intent, 1061, true, bundle, MiniAppObserver.class);
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "onReceive. MiniAppSendArkMsgServlet rsp = " + stQWebRsp);
                    }
                    notifyObserver(intent, 1061, false, bundle, MiniAppObserver.class);
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onReceive. inform MiniAppSendArkMsgServlet resultcode fail.");
                }
                notifyObserver(intent, 1061, false, bundle, MiniAppObserver.class);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5 + "onReceive error");
            bundle.putInt(MiniAppCmdUtil.KEY_INDEX, this.index);
            notifyObserver(intent, 1061, false, bundle, MiniAppObserver.class);
        }
        doReport(intent, fromServiceMsg);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        COMM.StCommonExt stCommonExt;
        this.index = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_ext");
        String stringExtra = intent.getStringExtra("key_openid");
        String stringExtra2 = intent.getStringExtra(KEY_ARK_JSON);
        String stringExtra3 = intent.getStringExtra("key_appid");
        String stringExtra4 = intent.getStringExtra(KEY_API_NAME);
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
        byte[] encode = new MiniAppSendArkMsgRequest(stCommonExt, stringExtra3, stringExtra, stringExtra2, stringExtra4).encode(intent, this.index, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(MiniAppSendArkMsgRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
