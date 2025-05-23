package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StGetPhoneNumberReq;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import mqq.app.Packet;

/* loaded from: classes33.dex */
public class MiniAppGetPhoneNumberServlet extends MiniAppAbstractServlet {
    private static final String CMD_STRING = "LightAppSvc.mini_user_info.GetPhoneNumber";

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        super.onProcessData(intent, bundle, bArr);
        bundle.putByteArray("data", bArr);
        notifyObserver(intent, 1053, true, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        this.observerId = 1053;
        final String stringExtra = intent.getStringExtra("key_appid");
        byte[] encode = new ProtoBufRequest() { // from class: com.tencent.mobileqq.mini.servlet.MiniAppGetPhoneNumberServlet.1
            @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
            public byte[] getBusiBuf() {
                INTERFACE$StGetPhoneNumberReq iNTERFACE$StGetPhoneNumberReq = new INTERFACE$StGetPhoneNumberReq();
                iNTERFACE$StGetPhoneNumberReq.appId.set(stringExtra);
                return iNTERFACE$StGetPhoneNumberReq.toByteArray();
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
