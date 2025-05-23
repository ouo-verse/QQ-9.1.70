package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StReportShareRsp;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniReportShareServlet extends MiniAppAbstractServlet {
    public static final String KEY_APPID = "key_appid";
    public static final String KEY_APP_TYPE = "key_app_type";
    public static final String KEY_DEST_ID = "key_dest_id";
    public static final String KEY_DEST_TYPE = "key_dest_type";
    public static final String KEY_EXT = "key_ext";
    public static final String KEY_REPORT_TIME = "key_report_time";
    public static final String KEY_SHARE_SCENE = "key_share_scene";
    public static final String KEY_SHARE_TYPE = "key_share_type";
    public static final String TAG = "MiniReportShareServlet";
    private int index;

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet
    public void onProcessData(Intent intent, Bundle bundle, byte[] bArr) throws InvalidProtocolBufferMicroException {
        new INTERFACE$StReportShareRsp().mergeFrom(bArr);
        notifyObserver(intent, 1063, true, bundle, MiniAppObserver.class);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        this.index = intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_ext");
        long longExtra = intent.getLongExtra(KEY_REPORT_TIME, 0L);
        String stringExtra = intent.getStringExtra("key_appid");
        int intExtra = intent.getIntExtra(KEY_APP_TYPE, 0);
        int intExtra2 = intent.getIntExtra(KEY_SHARE_SCENE, 0);
        int intExtra3 = intent.getIntExtra(KEY_SHARE_TYPE, 0);
        int intExtra4 = intent.getIntExtra(KEY_DEST_TYPE, 0);
        String stringExtra2 = intent.getStringExtra(KEY_DEST_ID);
        if (byteArrayExtra != null) {
            try {
                new COMM.StCommonExt().mergeFrom(byteArrayExtra);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "onSend. mergeFrom extData exception!");
                }
                e16.printStackTrace();
            }
        }
        byte[] encode = new ReportShareRequest(longExtra, stringExtra, intExtra, intExtra2, intExtra3, intExtra4, stringExtra2).encode(intent, this.index, getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setSSOCommand("LightAppSvc.mini_app_usr_time.ReportShare");
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
