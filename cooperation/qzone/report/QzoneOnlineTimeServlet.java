package cooperation.qzone.report;

import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import java.io.Serializable;
import java.util.ArrayList;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QzoneOnlineTimeServlet extends MSFServlet {
    private static final int TIMEOUT = 60000;

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        if (fromServiceMsg != null) {
            QzoneOnlineTimeCollectRptService.getInstance().onTaskResponse(fromServiceMsg.getResultCode());
        } else if (QLog.isColorLevel()) {
            QLog.d("QzoneOnlineTimeServlet", 2, "fromServiceMsg==msg");
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        Serializable serializableExtra = intent.getSerializableExtra("list");
        QLog.d("QzoneOnlineTimeServlet", 1, "uin:" + getAppRuntime().getLongAccountUin());
        QzoneOnlineTimeCollectReportRequest qzoneOnlineTimeCollectReportRequest = new QzoneOnlineTimeCollectReportRequest(getAppRuntime().getLongAccountUin(), (ArrayList) serializableExtra);
        byte[] encode = qzoneOnlineTimeCollectReportRequest.encode();
        if (encode == null) {
            encode = new byte[4];
        }
        packet.setTimeout(60000L);
        packet.setSSOCommand(QZoneHelper.CMD_PREFIX_PUBLIC + qzoneOnlineTimeCollectReportRequest.uniKey());
        packet.putSendData(encode);
    }
}
