package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StDelPhoneNumbersReq;
import NS_MINI_INTERFACE.INTERFACE$StDelPhoneNumbersRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

/* loaded from: classes33.dex */
public class MiniAppDelPhoneNumberServlet extends MiniAppAbstractServlet {
    private static final String CMD_STRING = "LightAppSvc.mini_user_info.DelPhoneNumbers";
    public static final String KEY_PURE_PHONE_NUMBER = "purePhoneNumber";

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        INTERFACE$StDelPhoneNumbersRsp iNTERFACE$StDelPhoneNumbersRsp = new INTERFACE$StDelPhoneNumbersRsp();
        long j3 = bundle.getLong("retCode");
        String string = bundle.getString("errMsg");
        if (j3 == 0) {
            iNTERFACE$StDelPhoneNumbersRsp.mergeFrom(bArr);
            notifyObserver(intent, 1074, true, bundle, MiniAppObserver.class);
            return;
        }
        notifyObserver(intent, 1074, false, bundle, MiniAppObserver.class);
        QLog.e(MiniAppAbstractServlet.TAG, 1, "MiniAppDelPhoneNumberServlet retCode : " + j3 + "; errMsg : " + string);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        this.observerId = 1074;
        final String stringExtra = intent.getStringExtra("key_appid");
        final String stringExtra2 = intent.getStringExtra("purePhoneNumber");
        byte[] encode = new ProtoBufRequest() { // from class: com.tencent.mobileqq.mini.servlet.MiniAppDelPhoneNumberServlet.1
            @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
            public byte[] getBusiBuf() {
                INTERFACE$StDelPhoneNumbersReq iNTERFACE$StDelPhoneNumbersReq = new INTERFACE$StDelPhoneNumbersReq();
                iNTERFACE$StDelPhoneNumbersReq.appId.set(stringExtra);
                iNTERFACE$StDelPhoneNumbersReq.purePhoneNumber.set(stringExtra2);
                return iNTERFACE$StDelPhoneNumbersReq.toByteArray();
            }
        }.encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
