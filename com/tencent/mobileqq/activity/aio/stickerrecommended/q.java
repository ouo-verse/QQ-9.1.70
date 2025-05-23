package com.tencent.mobileqq.activity.aio.stickerrecommended;

import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.stickerrecommended.impl.StickerRecManagerImpl;
import com.tencent.mobileqq.transfile.ProtoServlet;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes10.dex */
public class q extends MSFServlet {
    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        AppRuntime appRuntime = getAppRuntime();
        if (appRuntime != null && (appRuntime instanceof AppInterface)) {
            StickerRecManagerImpl.get((AppInterface) appRuntime).handleResponse(intent, fromServiceMsg);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        if (intent == null) {
            QLog.e("StickerRecServlet", 1, "onSend : req is null");
            return;
        }
        packet.setSSOCommand(intent.getStringExtra("key_cmd"));
        packet.putSendData(intent.getByteArrayExtra(ProtoServlet.KEY_BODY));
        packet.setTimeout(intent.getLongExtra(ProtoServlet.KEY_TIMEOUT, 6000L));
    }
}
