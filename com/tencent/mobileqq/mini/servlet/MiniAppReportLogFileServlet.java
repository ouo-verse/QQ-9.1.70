package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StReportLogFileRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppReportLogFileServlet extends MiniAppAbstractServlet {
    public static final String KEY_APP_ID = "key_app_id";
    public static final String KEY_EXT = "key_ext";
    public static final String KEY_FILE_SIZE = "key_file_size";
    public static final String KEY_FILE_URL = "key_file_url";
    public static final String TAG = "MiniAppReportLogFileServlet";

    public MiniAppReportLogFileServlet() {
        this.observerId = 1024;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        new INTERFACE$StReportLogFileRsp().mergeFrom(bArr);
        notifyObserver(intent, 1035, true, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        COMM.StCommonExt stCommonExt;
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_ext");
        String stringExtra = intent.getStringExtra("key_app_id");
        String stringExtra2 = intent.getStringExtra(KEY_FILE_URL);
        int intExtra = intent.getIntExtra(KEY_FILE_SIZE, 0);
        int intExtra2 = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
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
        byte[] encode = new ReportLogFileRequest(stCommonExt, stringExtra, stringExtra2, intExtra).encode(intent, intExtra2, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand(ReportLogFileRequest.CMD_STRING);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
