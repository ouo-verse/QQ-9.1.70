package com.tencent.mobileqq.mini.servlet;

import NS_STORE_APP_CLIENT.MiniAppStore$StGetFirstPageByTypeReq;
import NS_STORE_APP_CLIENT.MiniAppStore$StGetFirstPageByTypeRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppStoreGetAppListServlet extends MiniAppAbstractServlet {
    private static final String CMD_STRING = "LightAppSvc.store_app_client.GetFirstPageByType";

    public MiniAppStoreGetAppListServlet() {
        this.observerId = 1022;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        MiniAppStore$StGetFirstPageByTypeRsp miniAppStore$StGetFirstPageByTypeRsp = new MiniAppStore$StGetFirstPageByTypeRsp();
        miniAppStore$StGetFirstPageByTypeRsp.mergeFrom(bArr);
        bundle.putString("data", com.tencent.mobileqq.jsonconverter.a.a(miniAppStore$StGetFirstPageByTypeRsp.vecAppInfo.get()).toString());
        notifyObserver(intent, 1022, true, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(final Intent intent, Packet packet) {
        byte[] encode = new ProtoBufRequest() { // from class: com.tencent.mobileqq.mini.servlet.MiniAppStoreGetAppListServlet.1
            @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
            public byte[] getBusiBuf() {
                MiniAppStore$StGetFirstPageByTypeReq miniAppStore$StGetFirstPageByTypeReq = new MiniAppStore$StGetFirstPageByTypeReq();
                miniAppStore$StGetFirstPageByTypeReq.uiPageType.set(intent.getIntExtra(MiniAppAbstractServlet.KEY_APP_STORE_GET_APP_LIST_TYPE, 0));
                return miniAppStore$StGetFirstPageByTypeReq.toByteArray();
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
