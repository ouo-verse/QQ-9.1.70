package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StCheckBindingStateRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class CheckBindingStateServlet extends MiniAppAbstractServlet {
    public static final String KEY_APPID = "key_appId";
    public static final String KEY_BINDTYPE = "key_bindType";
    public static final String KEY_CHECK_STATE = "key_check_State";
    public static final String KEY_MSG = "key_Msg";
    public static final String KEY_UID = "key_uid";
    public static final String TAG = "CheckBindingStateServlet";

    public CheckBindingStateServlet() {
        this.observerId = 1083;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        INTERFACE$StCheckBindingStateRsp iNTERFACE$StCheckBindingStateRsp = new INTERFACE$StCheckBindingStateRsp();
        long j3 = bundle.getLong("retCode");
        if (j3 == 0) {
            iNTERFACE$StCheckBindingStateRsp.mergeFrom(bArr);
            bundle.putInt(KEY_CHECK_STATE, iNTERFACE$StCheckBindingStateRsp.bindingState.get());
            bundle.putString("key_Msg", iNTERFACE$StCheckBindingStateRsp.f24958msg.get());
            notifyObserver(intent, 1083, true, bundle, MiniAppObserver.class);
            QLog.i(TAG, 1, "CheckBindingStateServlet retCode : " + j3 + "; Msg : " + iNTERFACE$StCheckBindingStateRsp.f24958msg.get());
            return;
        }
        notifyObserver(intent, 1083, false, bundle, MiniAppObserver.class);
        QLog.e(TAG, 1, "CheckBindingStateServlet retCode : " + j3 + "; errMsg : result is null");
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        byte[] encode = new CheckBindingStateRequest(intent.getStringExtra("key_appId"), intent.getStringExtra("key_uid"), intent.getIntExtra(KEY_BINDTYPE, 0)).encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(CheckBindingStateRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
