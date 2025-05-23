package com.tencent.mobileqq.mini.servlet;

import NS_QWEB_PROTOCAL.PROTOCAL;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppCheckSessionServlet extends MiniAppAbstractServlet {
    public static final String TAG = "MiniAppCheckSessionServlet";

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        try {
            bundle.putInt(MiniAppCmdUtil.KEY_INDEX, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1));
            if (fromServiceMsg != null) {
                if (fromServiceMsg.isSuccess()) {
                    PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
                    stQWebRsp.mergeFrom(fh.a(fromServiceMsg.getWupBuffer()));
                    bundle.putInt(MiniAppCmdUtil.KEY_INDEX, (int) stQWebRsp.Seq.get());
                    PBInt64Field pBInt64Field = stQWebRsp.retCode;
                    if (pBInt64Field != null && stQWebRsp.errMsg != null) {
                        bundle.putLong("ret", pBInt64Field.get());
                        bundle.putString("errMsg", stQWebRsp.errMsg.get().toString());
                        notifyObserver(intent, 1002, true, bundle, MiniAppObserver.class);
                    } else {
                        notifyObserver(intent, 1002, false, bundle, MiniAppObserver.class);
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "inform MiniAppGetLoginCodeServlet isSuccess false");
                    }
                    notifyObserver(intent, 1002, false, bundle, MiniAppObserver.class);
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "inform QZoneGetGroupCountServlet resultcode fail.");
                }
                notifyObserver(intent, 1002, false, bundle, MiniAppObserver.class);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5 + "onReceive error");
            notifyObserver(intent, 1002, false, bundle, MiniAppObserver.class);
        }
        doReport(intent, fromServiceMsg);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        String stringExtra = intent.getStringExtra("key_appid");
        Long valueOf = Long.valueOf(intent.getLongExtra("key_uin", 0L));
        byte[] encode = new CheckSessionRequest(valueOf.longValue(), stringExtra).encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(CheckSessionRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
