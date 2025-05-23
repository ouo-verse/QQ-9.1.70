package com.tencent.mobileqq.mini.servlet;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppSSOCmdServlet extends MiniAppAbstractServlet {
    private static final String TAG = "MiniAppSSOCmdServlet";

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        boolean z16;
        Bundle bundle = new Bundle();
        if (fromServiceMsg != null) {
            z16 = fromServiceMsg.isSuccess();
            bundle.putParcelable("msg", fromServiceMsg);
        } else {
            z16 = false;
        }
        notifyObserver(intent, 0, z16, bundle, MiniAppSSOCmdObserver.class);
        super.onReceive(intent, fromServiceMsg);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        int intExtra = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
        final byte[] byteArrayExtra = intent.getByteArrayExtra("key_data");
        String stringExtra = intent.getStringExtra(MiniAppAbstractServlet.KEY_CMD_NAME);
        intent.getStringExtra("key_appid");
        if (TextUtils.isEmpty(stringExtra)) {
            QLog.e(TAG, 2, "onSend empty cmd name");
            return;
        }
        if (byteArrayExtra == null) {
            QLog.e(TAG, 2, "onSend", " business data is empty");
            return;
        }
        byte[] encode = new ProtoBufRequest() { // from class: com.tencent.mobileqq.mini.servlet.MiniAppSSOCmdServlet.1
            @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
            public byte[] getBusiBuf() {
                return byteArrayExtra;
            }
        }.encode(intent, intExtra, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(stringExtra);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
