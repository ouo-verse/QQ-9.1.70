package com.tencent.mobileqq.mini.servlet;

import android.content.Intent;
import android.util.Log;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

/* loaded from: classes33.dex */
public class MiniGameAddRecentPlayServlet extends MiniAppAbstractServlet {
    public static final String KEY_APP_ID = "key_app_id";
    public static final String KEY_SOURCE = "key_source";
    private static final String TAG = "MiniGameAddRecentPlayServlet";

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        String stringExtra = intent.getStringExtra("key_app_id");
        int intExtra = intent.getIntExtra("key_source", 0);
        byte[] encode = new AddRecentPlayRequest(stringExtra, intExtra).encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(AddRecentPlayRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        try {
            if (fromServiceMsg != null) {
                QLog.d(TAG, 4, "onReceive. inform MiniGameAddRecentPlayServlet " + fromServiceMsg.isSuccess());
            } else {
                QLog.e(TAG, 1, "onReceive. inform MiniGameAddRecentPlayServlet response is null.");
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5 + ", onReceive exception: " + Log.getStackTraceString(th5));
        }
        doReport(intent, fromServiceMsg);
    }
}
