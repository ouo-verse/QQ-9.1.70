package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$GetWXAppURLReply;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetWxAppUrlServlet extends MiniAppAbstractServlet {
    public static final String CMD = "LightAppSvc.mini_wxapp_info.GetWXAppURL";
    public static final String CMD_NAME = "GetWXAppURL";

    public GetWxAppUrlServlet() {
        this.observerId = 1095;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        INTERFACE$GetWXAppURLReply iNTERFACE$GetWXAppURLReply = new INTERFACE$GetWXAppURLReply();
        iNTERFACE$GetWXAppURLReply.mergeFrom(bArr);
        boolean z16 = iNTERFACE$GetWXAppURLReply.retCode.get() == 0;
        if (z16) {
            bundle.putString("key_url", iNTERFACE$GetWXAppURLReply.URL.get());
        }
        notifyObserver(intent, this.observerId, z16, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        int intExtra = intent.getIntExtra(MiniAppAbstractServlet.KEY_CODE_TYPE, 0);
        String stringExtra = intent.getStringExtra(MiniAppAbstractServlet.KEY_CODE);
        int intExtra2 = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
        long longExtra = intent.getLongExtra("timeout", 30000L);
        byte[] encode = new GetWxAppUrlRequest(intExtra, stringExtra).encode(intent, intExtra2, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(CMD);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(longExtra);
        super.onSend(intent, packet);
    }
}
