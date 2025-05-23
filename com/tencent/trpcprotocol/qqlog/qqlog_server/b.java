package com.tencent.trpcprotocol.qqlog.qqlog_server;

import android.content.Intent;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes27.dex */
public class b extends MSFServlet {
    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        QLog.i("LogPush.QqlogReportServlet", 1, "[onReceive] report type=" + intent.getIntExtra(AdMetricTag.Report.TYPE, -1) + "processStatus=" + intent.getIntExtra("processStatus", -1) + ", success=" + fromServiceMsg.isSuccess() + ", retCode=" + fromServiceMsg.getResultCode());
        if (fromServiceMsg.isSuccess()) {
            QqlogServer$SsoReportRsp qqlogServer$SsoReportRsp = new QqlogServer$SsoReportRsp();
            try {
                qqlogServer$SsoReportRsp.mergeFrom(fh.a(fromServiceMsg.getWupBuffer()));
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.i("LogPush.QqlogReportServlet", 1, "QqlogServer.SsoReportRsp error", e16);
            }
            QLog.i("LogPush.QqlogReportServlet", 1, "rsp.seq=" + qqlogServer$SsoReportRsp.seq.get());
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        byte[] byteArrayExtra = intent.getByteArrayExtra("data");
        packet.setSSOCommand("trpc.qqlog.qqlog_server.Portal.SsoReport");
        packet.setTimeout(30000L);
        packet.putSendData(byteArrayExtra);
    }
}
