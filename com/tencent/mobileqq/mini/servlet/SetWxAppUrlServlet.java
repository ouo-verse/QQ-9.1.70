package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$SetWXAppURLReply;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class SetWxAppUrlServlet extends MiniAppAbstractServlet {
    public static final String CMD = "LightAppSvc.mini_wxapp_info.SetWXAppURL";
    public static final String CMD_NAME = "SetWXAppURL";

    public SetWxAppUrlServlet() {
        this.observerId = 1094;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        INTERFACE$SetWXAppURLReply iNTERFACE$SetWXAppURLReply = new INTERFACE$SetWXAppURLReply();
        iNTERFACE$SetWXAppURLReply.mergeFrom(bArr);
        notifyObserver(intent, this.observerId, iNTERFACE$SetWXAppURLReply.retCode.get() == 0, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        int intExtra = intent.getIntExtra(MiniAppAbstractServlet.KEY_CODE_TYPE, 0);
        String stringExtra = intent.getStringExtra(MiniAppAbstractServlet.KEY_CODE);
        String stringExtra2 = intent.getStringExtra("key_url");
        int intExtra2 = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
        long longExtra = intent.getLongExtra("timeout", 30000L);
        byte[] encode = new SetWxAppUrlRequest(intExtra, stringExtra, stringExtra2).encode(intent, intExtra2, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(CMD);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(longExtra);
        super.onSend(intent, packet);
    }
}
