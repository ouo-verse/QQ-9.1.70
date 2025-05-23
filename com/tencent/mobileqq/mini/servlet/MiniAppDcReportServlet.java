package com.tencent.mobileqq.mini.servlet;

import NS_MINI_REPORT.REPORT$StDcReportRsp;
import NS_MINI_REPORT.REPORT$StGameDcReportRsp;
import NS_MINI_REPORT.REPORT$StThirdDcReportRsp;
import NS_QWEB_PROTOCAL.PROTOCAL;
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
public class MiniAppDcReportServlet extends MiniAppAbstractServlet {
    public static final String CMD_STRING = "LightAppSvc.mini_app_dcreport.DcReport";
    public static final String CMD_STRING_GAME_CP_REPORT = "LightAppSvc.mini_app_dcreport.GameDcReport";
    public static final String CMD_STRING_MINI_LOG = "MiniLogSvr.mini_app_apireport.DcReport";
    public static final String CMD_STRING_THIRD_PARTY_REPORT = "LightAppSvc.mini_app_dcreport.ThirdDcReport";
    public static final String KEY_CMD = "key_cmd";
    public static final String TAG = "MiniAppDcReportServlet";

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        int i3;
        Bundle bundle = new Bundle();
        try {
            bundle.putInt(MiniAppCmdUtil.KEY_INDEX, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1));
            if (fromServiceMsg != null) {
                if (fromServiceMsg.isSuccess()) {
                    PROTOCAL.StQWebRsp stQWebRsp = new PROTOCAL.StQWebRsp();
                    stQWebRsp.mergeFrom(fh.a(fromServiceMsg.getWupBuffer()));
                    bundle.putInt(MiniAppCmdUtil.KEY_INDEX, (int) stQWebRsp.Seq.get());
                    if (CMD_STRING_THIRD_PARTY_REPORT.equals(fromServiceMsg.getServiceCmd())) {
                        REPORT$StThirdDcReportRsp rEPORT$StThirdDcReportRsp = new REPORT$StThirdDcReportRsp();
                        rEPORT$StThirdDcReportRsp.mergeFrom(stQWebRsp.busiBuff.get().toByteArray());
                        i3 = rEPORT$StThirdDcReportRsp.ret.get();
                    } else if (CMD_STRING_GAME_CP_REPORT.equals(fromServiceMsg.getServiceCmd())) {
                        REPORT$StGameDcReportRsp rEPORT$StGameDcReportRsp = new REPORT$StGameDcReportRsp();
                        rEPORT$StGameDcReportRsp.mergeFrom(stQWebRsp.busiBuff.get().toByteArray());
                        i3 = rEPORT$StGameDcReportRsp.ret.get();
                    } else {
                        REPORT$StDcReportRsp rEPORT$StDcReportRsp = new REPORT$StDcReportRsp();
                        rEPORT$StDcReportRsp.mergeFrom(stQWebRsp.busiBuff.get().toByteArray());
                        i3 = rEPORT$StDcReportRsp.ret.get();
                    }
                    if (i3 == 0) {
                        bundle.putInt("ret", i3);
                        notifyObserver(intent, 1005, true, bundle, MiniAppObserver.class);
                    } else {
                        notifyObserver(intent, 1005, false, bundle, MiniAppObserver.class);
                    }
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d("MiniAppDcReportServlet", 2, "inform MiniAppGetLoginCodeServlet isSuccess false");
                    }
                    notifyObserver(intent, 1005, false, bundle, MiniAppObserver.class);
                }
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("MiniAppDcReportServlet", 2, "inform QZoneGetGroupCountServlet resultcode fail.");
                }
                notifyObserver(intent, 1005, false, bundle, MiniAppObserver.class);
            }
        } catch (Throwable th5) {
            QLog.e("MiniAppDcReportServlet", 1, th5 + "onReceive error");
            notifyObserver(intent, 1005, false, bundle, MiniAppObserver.class);
        }
        doReport(intent, fromServiceMsg);
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        setShouldPerformDCReport(false);
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_data");
        byte[] encode = new DcReportRequest(byteArrayExtra).encode(intent, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1), getTraceId());
        if (encode == null) {
            encode = new byte[4];
        }
        String stringExtra = intent.getStringExtra("key_cmd");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = CMD_STRING;
        }
        packet.setSSOCommand(stringExtra);
        packet.putSendData(fh.b(encode));
        packet.setTimeout(intent.getLongExtra("timeout", 30000L));
        super.onSend(intent, packet);
    }
}
