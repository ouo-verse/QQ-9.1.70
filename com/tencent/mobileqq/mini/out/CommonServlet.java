package com.tencent.mobileqq.mini.out;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes15.dex */
public class CommonServlet extends MSFServlet {
    public static final int GET_MAP_POI_LIST = 1;
    public static final int GET_USER_LOCATION = 2;
    public static final String IS_PB_PACKET = "is_pb_packet";

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        if (intent != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            boolean isSuccess = fromServiceMsg.isSuccess();
            ToServiceMsg toServiceMsg = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getSimpleName());
            Bundle bundle = new Bundle();
            bundle.putParcelable("req", toServiceMsg);
            if (isSuccess && ((Boolean) toServiceMsg.getAttribute(IS_PB_PACKET, Boolean.FALSE)).booleanValue()) {
                fromServiceMsg.putWupBuffer(fh.a(fromServiceMsg.getWupBuffer()));
            }
            bundle.putParcelable("rsp", fromServiceMsg);
            if ("LbsShareSvr.location".equals(serviceCmd)) {
                notifyObserver(intent, 1, isSuccess, bundle, CommonObserver.class);
            } else if ("NeighborSvc.ReqGetPoint".equals(serviceCmd)) {
                notifyObserver(intent, 2, isSuccess, bundle, CommonObserver.class);
            }
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        ToServiceMsg toServiceMsg;
        if (intent != null && (toServiceMsg = (ToServiceMsg) intent.getParcelableExtra(ToServiceMsg.class.getSimpleName())) != null) {
            String serviceCmd = toServiceMsg.getServiceCmd();
            packet.setTimeout(toServiceMsg.getTimeout());
            packet.setAttributes(toServiceMsg.getAttributes());
            packet.setSSOCommand(serviceCmd);
            if (((Boolean) toServiceMsg.getAttribute(IS_PB_PACKET, Boolean.FALSE)).booleanValue()) {
                packet.putSendData(fh.b(toServiceMsg.getWupBuffer()));
            } else {
                packet.putSendData(toServiceMsg.getWupBuffer());
            }
            if (!toServiceMsg.isNeedCallback()) {
                packet.setNoResponse();
            }
        }
    }
}
