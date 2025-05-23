package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StUpdateUserSettingRsp;
import NS_MINI_INTERFACE.INTERFACE$StUserSettingInfo;
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
public class MiniAppUpdateUserSettingServlet extends MiniAppAbstractServlet {
    public static final String KEY_APPID = "key_appid";
    public static final String KEY_EXT = "key_ext";
    public static final String KEY_SETTING_INFO = "key_setting_info";
    public static final String TAG = "MiniAppUpdateUserSettingServlet";

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        try {
            bundle.putInt(MiniAppCmdUtil.KEY_INDEX, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1));
            if (fromServiceMsg != null && fromServiceMsg.isSuccess()) {
                PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
                stQWebRsp.mergeFrom(fh.a(fromServiceMsg.getWupBuffer()));
                new INTERFACE$StUpdateUserSettingRsp().mergeFrom(stQWebRsp.busiBuff.get().toByteArray());
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onReceive. inform MiniAppUpdateUserSettingServlet resultcode success.");
                }
                notifyObserver(intent, 1052, true, bundle, MiniAppObserver.class);
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "onReceive. inform MiniAppUpdateUserSettingServlet resultcode fail.");
                }
                notifyObserver(intent, 1052, false, bundle, MiniAppObserver.class);
            }
        } catch (Throwable th5) {
            notifyObserver(intent, 1052, true, bundle, MiniAppObserver.class);
            QLog.e(TAG, 1, th5 + "onReceive error");
        }
        doReport(intent, fromServiceMsg);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        COMM.StCommonExt stCommonExt;
        String stringExtra = intent.getStringExtra("key_appid");
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_ext");
        byte[] byteArrayExtra2 = intent.getByteArrayExtra(KEY_SETTING_INFO);
        int intExtra = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
        INTERFACE$StUserSettingInfo iNTERFACE$StUserSettingInfo = null;
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
            iNTERFACE$StUserSettingInfo = new INTERFACE$StUserSettingInfo();
            try {
                iNTERFACE$StUserSettingInfo.mergeFrom(byteArrayExtra2);
            } catch (InvalidProtocolBufferMicroException e17) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "onSend. mergeFrom authData exception!");
                }
                e17.printStackTrace();
            }
        }
        byte[] encode = new UpdateUserSettingRequest(stCommonExt, stringExtra, iNTERFACE$StUserSettingInfo).encode(intent, intExtra, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(UpdateUserSettingRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
