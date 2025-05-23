package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$SetWXAppInfoReply;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class SetWxAppInfoServlet extends MiniAppAbstractServlet {
    public static final String CMD = "LightAppSvc.mini_wxapp_info.SetWXAppInfo";
    public static final String CMD_NAME = "SetWXAppInfo";

    public SetWxAppInfoServlet() {
        this.observerId = 1096;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        INTERFACE$SetWXAppInfoReply iNTERFACE$SetWXAppInfoReply = new INTERFACE$SetWXAppInfoReply();
        iNTERFACE$SetWXAppInfoReply.mergeFrom(bArr);
        notifyObserver(intent, this.observerId, iNTERFACE$SetWXAppInfoReply.retCode.get() == 0, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        int intExtra = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
        long longExtra = intent.getLongExtra("timeout", 30000L);
        byte[] encode = new SetWxAppInfoRequest(intent).encode(intent, intExtra, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(CMD);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(longExtra);
        super.onSend(intent, packet);
    }
}
