package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StGetTCBTicketRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppGetTcbTicketServlet extends MiniAppAbstractServlet {
    public static final String KEY_APP_ID = "key_app_id";
    public static final String KEY_CREATE_TIME = "key_createTime";
    public static final String KEY_ENV_ID = "key_env_id";
    public static final String KEY_EXT_INFO = "key_ext_info";
    public static final String KEY_PERIOD = "key_period";
    public static final String KEY_TICKET = "key_ticket";
    public static final String TAG = "MiniAppGetTcbTicketServlet";

    public MiniAppGetTcbTicketServlet() {
        this.observerId = 1046;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        INTERFACE$StGetTCBTicketRsp iNTERFACE$StGetTCBTicketRsp = new INTERFACE$StGetTCBTicketRsp();
        long j3 = bundle.getLong("retCode");
        String string = bundle.getString("errMsg");
        if (j3 == 0) {
            iNTERFACE$StGetTCBTicketRsp.mergeFrom(bArr);
            bundle.putByteArray("key_ext_info", iNTERFACE$StGetTCBTicketRsp.extInfo.toByteArray());
            bundle.putString(KEY_TICKET, iNTERFACE$StGetTCBTicketRsp.ticket.get());
            bundle.putInt(KEY_CREATE_TIME, iNTERFACE$StGetTCBTicketRsp.createTime.get());
            bundle.putInt(KEY_PERIOD, iNTERFACE$StGetTCBTicketRsp.period.get());
            notifyObserver(intent, 1046, true, bundle, MiniAppObserver.class);
            return;
        }
        notifyObserver(intent, 1046, false, bundle, MiniAppObserver.class);
        QLog.e(TAG, 1, "MiniAppGetTcbTicketServlet retCode : " + j3 + "; errMsg : " + string);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        COMM.StCommonExt stCommonExt;
        String stringExtra = intent.getStringExtra("key_app_id");
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_ext_info");
        String stringExtra2 = intent.getStringExtra(KEY_ENV_ID);
        int intExtra = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
        if (byteArrayExtra != null) {
            stCommonExt = new COMM.StCommonExt();
            try {
                stCommonExt.mergeFrom(byteArrayExtra);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "onSend. mergeFrom exception!");
                }
                e16.printStackTrace();
            }
        } else {
            stCommonExt = null;
        }
        byte[] encode = new GetTcbTicketRequest(stCommonExt, stringExtra, stringExtra2).encode(intent, intExtra, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(GetTcbTicketRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
