package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StSetAuthsRsp;
import NS_MINI_INTERFACE.INTERFACE$StUserAuthInfo;
import NS_QWEB_PROTOCAL.PROTOCAL;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppSetAuthsServlet extends MiniAppAbstractServlet {
    public static final String KEY_APPID = "key_appid";
    public static final String KEY_AUTH_INFO = "key_auth_info";
    public static final String KEY_AUTH_LIST_INFO = "key_auth_list_info";
    public static final String KEY_EXT = "key_ext";
    public static final long NOT_LOGIN_ERR_CODE = -101510007;
    public static final String TAG = "MiniAppSetAuthsServlet";

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        try {
            bundle.putInt(MiniAppCmdUtil.KEY_INDEX, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1));
            if (fromServiceMsg != null && fromServiceMsg.isSuccess()) {
                PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
                stQWebRsp.mergeFrom(fh.a(fromServiceMsg.getWupBuffer()));
                new INTERFACE$StSetAuthsRsp().mergeFrom(stQWebRsp.busiBuff.get().toByteArray());
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onReceive. inform MiniAppSetAuthsServlet resultcode success.");
                }
                bundle.putLong("retCode", stQWebRsp.retCode.get());
                notifyObserver(intent, 1042, true, bundle, MiniAppObserver.class);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onReceive. inform MiniAppSetAuthsServlet resultcode fail.");
                }
                notifyObserver(intent, 1042, false, bundle, MiniAppObserver.class);
            }
        } catch (Throwable th5) {
            notifyObserver(intent, 1042, true, bundle, MiniAppObserver.class);
            QLog.e(TAG, 1, th5 + "onReceive error");
        }
        doReport(intent, fromServiceMsg);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        COMM.StCommonExt stCommonExt;
        SetAuthsRequest setAuthsRequest;
        String stringExtra = intent.getStringExtra("key_appid");
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_ext");
        byte[] byteArrayExtra2 = intent.getByteArrayExtra(KEY_AUTH_INFO);
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra(KEY_AUTH_LIST_INFO);
        int intExtra = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
        if (byteArrayExtra != null) {
            stCommonExt = new COMM.StCommonExt();
            try {
                stCommonExt.mergeFrom(byteArrayExtra);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "onSend. mergeFrom extData exception!");
                }
                e16.printStackTrace();
            }
        } else {
            stCommonExt = null;
        }
        if (byteArrayExtra2 != null) {
            INTERFACE$StUserAuthInfo iNTERFACE$StUserAuthInfo = new INTERFACE$StUserAuthInfo();
            try {
                iNTERFACE$StUserAuthInfo.mergeFrom(byteArrayExtra2);
            } catch (InvalidProtocolBufferMicroException e17) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "onSend. mergeFrom authData exception!");
                }
                e17.printStackTrace();
            }
            setAuthsRequest = new SetAuthsRequest(stCommonExt, stringExtra, iNTERFACE$StUserAuthInfo);
        } else {
            setAuthsRequest = arrayList != null ? new SetAuthsRequest(stCommonExt, stringExtra, arrayList) : null;
        }
        byte[] encode = setAuthsRequest != null ? setAuthsRequest.encode(intent, intExtra, getTraceId()) : null;
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(SetAuthsRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
