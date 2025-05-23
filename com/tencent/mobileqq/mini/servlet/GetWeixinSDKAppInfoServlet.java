package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StGetWeixinSDKAppInfoRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GetWeixinSDKAppInfoServlet extends MiniAppAbstractServlet {
    public static final String TAG = "[mini] GetWeixinSDKAppInfoServlet";

    public GetWeixinSDKAppInfoServlet() {
        this.observerId = 1092;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        INTERFACE$StGetWeixinSDKAppInfoRsp iNTERFACE$StGetWeixinSDKAppInfoRsp = new INTERFACE$StGetWeixinSDKAppInfoRsp();
        iNTERFACE$StGetWeixinSDKAppInfoRsp.mergeFrom(bArr);
        if (iNTERFACE$StGetWeixinSDKAppInfoRsp.appInfo != null) {
            bundle.putByteArray("mini_app_info_pb_data", bArr);
            notifyObserver(intent, this.observerId, true, bundle, MiniAppObserver.class);
        } else {
            notifyObserver(intent, this.observerId, false, bundle, MiniAppObserver.class);
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        String stringExtra = intent.getStringExtra(MiniAppAbstractServlet.KEY_CODE);
        byte[] encode = new GetWeixinSDKAppInfoRequest(stringExtra).encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(GetWeixinSDKAppInfoRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
