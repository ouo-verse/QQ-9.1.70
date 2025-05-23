package cooperation.vip.tianshu;

import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes28.dex */
public class TianShuServlet extends MSFServlet {
    public static final String CMD_TIANSHU_GETADS = "TianShu.GetAds";
    public static final String CMD_TIANSHU_REPORT = "TianShu.UserActionMultiReport";
    public static final String EXTRA_CMD = "cmd";
    public static final String EXTRA_DATA = "data";
    public static final String EXTRA_REQUEST_KEY = "requestKey";
    public static final String EXTRA_TIMEOUT = "timeout";
    private static final String TAG = "MonitorServlet";

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        String str;
        if (intent != null && fromServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "onReceive cmd=" + serviceCmd + ",success=" + fromServiceMsg.isSuccess());
            }
            if (serviceCmd == null) {
                return;
            }
            boolean isSuccess = fromServiceMsg.isSuccess();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("resp:");
            sb5.append(serviceCmd);
            sb5.append(" is ");
            if (isSuccess) {
                str = "";
            } else {
                str = "not";
            }
            sb5.append(str);
            sb5.append(" success");
            QLog.d(TAG, 2, sb5.toString());
            if (serviceCmd.equals(CMD_TIANSHU_REPORT)) {
                TianShuManager.getInstance().onTianShuReport(intent, fromServiceMsg);
            } else if (serviceCmd.equals(CMD_TIANSHU_GETADS)) {
                TianShuManager.getInstance().onGetTianShuAdvRsp(intent, fromServiceMsg);
            }
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        byte[] byteArrayExtra = intent.getByteArrayExtra("data");
        String stringExtra = intent.getStringExtra("cmd");
        long longExtra = intent.getLongExtra("timeout", 10000L);
        packet.setSSOCommand(stringExtra);
        packet.setTimeout(longExtra);
        packet.putSendData(byteArrayExtra);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onSend exit cmd=" + stringExtra);
        }
    }
}
