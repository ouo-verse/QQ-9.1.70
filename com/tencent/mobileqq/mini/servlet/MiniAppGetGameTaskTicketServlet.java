package com.tencent.mobileqq.mini.servlet;

import NS_MINI_INTERFACE.INTERFACE$StGenTaskTicketRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppGetGameTaskTicketServlet extends MiniAppAbstractServlet {
    public static final String CMD_STRING = "LightAppSvc.mini_app_userapp.GenTaskTicket";
    public static final String KEY_APPID = "appId";
    public static final String KEY_TASKID = "taskId";
    public static final String KEY_TICKET = "ticket";

    public MiniAppGetGameTaskTicketServlet() {
        this.observerId = 1098;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        INTERFACE$StGenTaskTicketRsp iNTERFACE$StGenTaskTicketRsp = new INTERFACE$StGenTaskTicketRsp();
        iNTERFACE$StGenTaskTicketRsp.mergeFrom(bArr);
        String str = iNTERFACE$StGenTaskTicketRsp.ticket.get();
        int i3 = iNTERFACE$StGenTaskTicketRsp.taskID.get();
        bundle.putString("ticket", str);
        bundle.putInt(KEY_TASKID, i3);
        notifyObserver(intent, 1098, true, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        QLog.i(MiniAppAbstractServlet.TAG, 4, "onSend");
        byte[] encode = new GetGameTaskTicketRequest(intent.getStringExtra("appId"), intent.getIntExtra(KEY_TASKID, 1)).encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
