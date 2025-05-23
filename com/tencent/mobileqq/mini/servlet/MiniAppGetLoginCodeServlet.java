package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StGetCodeRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.fh;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppGetLoginCodeServlet extends MiniAppAbstractServlet {
    public static final String TAG = "MiniAppGetLoginCodeServlet";

    public MiniAppGetLoginCodeServlet() {
        this.observerId = 1000;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        INTERFACE$StGetCodeRsp iNTERFACE$StGetCodeRsp = new INTERFACE$StGetCodeRsp();
        iNTERFACE$StGetCodeRsp.mergeFrom(bArr);
        PBStringField pBStringField = iNTERFACE$StGetCodeRsp.code;
        if (pBStringField != null) {
            bundle.putString("code", pBStringField.get());
            notifyObserver(intent, 1000, true, bundle, MiniAppObserver.class);
        } else {
            notifyObserver(intent, 1000, false, bundle, MiniAppObserver.class);
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        String stringExtra = intent.getStringExtra("key_appid");
        byte[] encode = new GetLoginCodeRequest(stringExtra).encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(GetLoginCodeRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
