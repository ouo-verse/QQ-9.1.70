package com.tencent.mobileqq.filemanager.app;

import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes12.dex */
public class e extends MSFServlet {
    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        if (QLog.isColorLevel()) {
            QLog.d("FileTransferServlet<FileAssistant>", 2, "onReceive called");
        }
        if (intent == null) {
            QLog.e("FileTransferServlet<FileAssistant>", 1, "onReceive : req is null");
            return;
        }
        intent.getExtras().putParcelable("response", fromServiceMsg);
        QQAppInterface qQAppInterface = (QQAppInterface) getAppRuntime();
        ToServiceMsg toServiceMsg = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
        fromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), toServiceMsg);
        qQAppInterface.getFileTransferHandler().j0(toServiceMsg, fromServiceMsg);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        if (QLog.isColorLevel()) {
            QLog.d("FileTransferServlet<FileAssistant>", 2, "onSend called");
        }
        if (intent == null) {
            QLog.e("FileTransferServlet<FileAssistant>", 1, "onSend : req is null");
            return;
        }
        ToServiceMsg toServiceMsg = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
        if (toServiceMsg != null) {
            packet.setSSOCommand(toServiceMsg.getServiceCmd());
            packet.putSendData(toServiceMsg.getWupBuffer());
            packet.setTimeout(toServiceMsg.getTimeout());
            packet.addAttribute("fastresend", Boolean.TRUE);
            if (!toServiceMsg.isNeedCallback()) {
                packet.setNoResponse();
                return;
            }
            return;
        }
        QLog.e("FileTransferServlet<FileAssistant>", 1, "onSend : toMsg is null");
    }
}
