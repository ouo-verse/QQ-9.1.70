package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StAddPhoneNumberReq;
import NS_MINI_INTERFACE.INTERFACE$StAddPhoneNumberRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

/* loaded from: classes33.dex */
public class MiniAppAddPhoneNumberServlet extends MiniAppAbstractServlet {
    private static final String CMD_STRING = "LightAppSvc.mini_user_info.AddPhoneNumber";
    public static final String KEY_COUNTRY_CODE = "countryCode";
    public static final String KEY_IS_SAVE = "isSave";
    public static final String KEY_PURE_PHONE_NUMBER = "purePhoneNumber";

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        INTERFACE$StAddPhoneNumberRsp iNTERFACE$StAddPhoneNumberRsp = new INTERFACE$StAddPhoneNumberRsp();
        long j3 = bundle.getLong("retCode");
        String string = bundle.getString("errMsg");
        if (j3 == 0) {
            iNTERFACE$StAddPhoneNumberRsp.mergeFrom(bArr);
            bundle.putString(MiniConst.MiniAppCmdUtilConst.ENCRYPTED_DATA, iNTERFACE$StAddPhoneNumberRsp.encryptedData.get());
            bundle.putString("iv", iNTERFACE$StAddPhoneNumberRsp.f24957iv.get());
            bundle.putString(MiniConst.MiniAppCmdUtilConst.PHONE_NUMBER_ID, iNTERFACE$StAddPhoneNumberRsp.phoneNumberID.get());
            notifyObserver(intent, 1073, true, bundle, MiniAppObserver.class);
            return;
        }
        notifyObserver(intent, 1073, false, bundle, MiniAppObserver.class);
        QLog.e(MiniAppAbstractServlet.TAG, 1, "MiniAppAddPhoneNumberServlet retCode : " + j3 + "; errMsg : " + string);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        this.observerId = 1073;
        final String stringExtra = intent.getStringExtra("key_appid");
        final String stringExtra2 = intent.getStringExtra("purePhoneNumber");
        final String stringExtra3 = intent.getStringExtra("countryCode");
        final int intExtra = intent.getIntExtra(KEY_IS_SAVE, 0);
        byte[] encode = new ProtoBufRequest() { // from class: com.tencent.mobileqq.mini.servlet.MiniAppAddPhoneNumberServlet.1
            @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
            public byte[] getBusiBuf() {
                INTERFACE$StAddPhoneNumberReq iNTERFACE$StAddPhoneNumberReq = new INTERFACE$StAddPhoneNumberReq();
                iNTERFACE$StAddPhoneNumberReq.appId.set(stringExtra);
                iNTERFACE$StAddPhoneNumberReq.purePhoneNumber.set(stringExtra2);
                iNTERFACE$StAddPhoneNumberReq.countryCode.set(stringExtra3);
                iNTERFACE$StAddPhoneNumberReq.isSave.set(intExtra);
                return iNTERFACE$StAddPhoneNumberReq.toByteArray();
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
