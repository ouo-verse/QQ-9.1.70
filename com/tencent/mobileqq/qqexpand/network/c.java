package com.tencent.mobileqq.qqexpand.network;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.qqexpand.manager.ExpandManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes35.dex */
public class c extends MSFServlet {
    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        ToServiceMsg toServiceMsg;
        if (intent != null) {
            toServiceMsg = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
            fromServiceMsg.attributes.put(FromServiceMsg.class.getSimpleName(), toServiceMsg);
        } else {
            toServiceMsg = new ToServiceMsg("", fromServiceMsg.getUin(), fromServiceMsg.getServiceCmd());
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(ToServiceMsg.class.getSimpleName(), toServiceMsg);
        bundle.putParcelable(FromServiceMsg.class.getSimpleName(), fromServiceMsg);
        AppRuntime runtime = BaseApplicationImpl.sApplication.getRuntime();
        QQAppInterface qQAppInterface = runtime instanceof QQAppInterface ? (QQAppInterface) runtime : null;
        if (qQAppInterface != null) {
            ((ExpandManager) qQAppInterface.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER)).s0().f(toServiceMsg, fromServiceMsg);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        ToServiceMsg toServiceMsg;
        if (intent == null || (toServiceMsg = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getSimpleName())) == null) {
            return;
        }
        packet.setSSOCommand(toServiceMsg.getServiceCmd());
        packet.putSendData(toServiceMsg.getWupBuffer());
        packet.setTimeout(toServiceMsg.getTimeout());
        packet.setAttributes(toServiceMsg.getAttributes());
        if (toServiceMsg.isNeedCallback()) {
            return;
        }
        packet.setNoResponse();
    }
}
