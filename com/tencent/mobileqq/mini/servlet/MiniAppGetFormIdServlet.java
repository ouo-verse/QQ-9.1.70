package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StGetFormIdReq;
import NS_MINI_INTERFACE.INTERFACE$StGetFormIdRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppGetFormIdServlet extends MiniAppAbstractServlet {
    private static final String CMD_STRING = "LightAppSvc.mini_app_userapp.GetFormId";

    public MiniAppGetFormIdServlet() {
        this.observerId = 1020;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        INTERFACE$StGetFormIdRsp iNTERFACE$StGetFormIdRsp = new INTERFACE$StGetFormIdRsp();
        iNTERFACE$StGetFormIdRsp.mergeFrom(bArr);
        bundle.putString("formId", iNTERFACE$StGetFormIdRsp.formId.get());
        notifyObserver(intent, 1020, true, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        final String stringExtra = intent.getStringExtra("key_appid");
        byte[] encode = new ProtoBufRequest() { // from class: com.tencent.mobileqq.mini.servlet.MiniAppGetFormIdServlet.1
            @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
            public byte[] getBusiBuf() {
                INTERFACE$StGetFormIdReq iNTERFACE$StGetFormIdReq = new INTERFACE$StGetFormIdReq();
                iNTERFACE$StGetFormIdReq.appid.set(stringExtra);
                return iNTERFACE$StGetFormIdReq.toByteArray();
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
