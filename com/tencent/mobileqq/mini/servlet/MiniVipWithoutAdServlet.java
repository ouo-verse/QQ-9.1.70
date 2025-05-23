package com.tencent.mobileqq.mini.servlet;

import NS_MINI_AD.MiniAppAd$StGetMemberStateRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniVipWithoutAdServlet extends MiniAppAbstractServlet {
    public static final String CMD = "LightAppSvc.mini_app_ad.GetMemberState";
    public static final String KEY_GET_MEMBER_STATE_RSP = "getMemberStateRsp";
    public static final String KEY_GET_MEMBER_STATE_RSP_MSG = "getMemberStateRspMsg";
    private static final String TAG = "MiniVipWithoutAdServlet";

    public MiniVipWithoutAdServlet() {
        this.observerId = 1102;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        try {
            bundle.putInt(MiniAppCmdUtil.KEY_INDEX, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1));
            if (fromServiceMsg != null) {
                MiniAppAd$StGetMemberStateRsp miniAppAd$StGetMemberStateRsp = new MiniAppAd$StGetMemberStateRsp();
                miniAppAd$StGetMemberStateRsp.mergeFrom(fh.a(fromServiceMsg.getWupBuffer()));
                if (fromServiceMsg.isSuccess()) {
                    bundle.putParcelable(KEY_GET_MEMBER_STATE_RSP_MSG, fromServiceMsg);
                    notifyObserver(intent, 1102, true, bundle, MiniAppObserver.class);
                } else {
                    QLog.d(TAG, 2, "onReceive MiniVipWithoutAdServlet rsp = " + miniAppAd$StGetMemberStateRsp);
                    notifyObserver(intent, 1102, false, bundle, MiniAppObserver.class);
                }
            } else {
                QLog.d(TAG, 2, "onReceive MiniVipWithoutAdServlet result code fail");
                notifyObserver(intent, 1102, false, bundle, MiniAppObserver.class);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "onReceive error" + th5);
            notifyObserver(intent, 1102, false, bundle, MiniAppObserver.class);
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        int intExtra = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
        long longExtra = intent.getLongExtra("timeout", 30000L);
        byte[] encode = new MiniVipWithoutAdRequest().encode(intent, intExtra, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(CMD);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(longExtra);
        super.onSend(intent, packet);
    }
}
