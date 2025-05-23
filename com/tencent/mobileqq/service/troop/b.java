package com.tencent.mobileqq.service.troop;

import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import friendlist.ModifyGroupCardReq;
import friendlist.stUinInfo;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private AppInterface f286414a;

    public b(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f286414a = appInterface;
        }
    }

    private boolean b(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        Long.parseLong(toServiceMsg.getUin());
        ArrayList<stUinInfo> arrayList = (ArrayList) toServiceMsg.extraData.getSerializable("vecUinInfo");
        long j3 = toServiceMsg.extraData.getLong("dwZero");
        long j16 = toServiceMsg.extraData.getLong("dwGroupCode");
        long j17 = toServiceMsg.extraData.getLong("dwNewSeq");
        ModifyGroupCardReq modifyGroupCardReq = new ModifyGroupCardReq();
        modifyGroupCardReq.dwGroupCode = j16;
        modifyGroupCardReq.dwNewSeq = j17;
        modifyGroupCardReq.dwZero = j3;
        modifyGroupCardReq.vecUinInfo = arrayList;
        uniPacket.setServantName("mqq.IMService.FriendListServiceServantObj");
        uniPacket.setFuncName("ModifyGroupCardReq");
        uniPacket.put("MGCREQ", modifyGroupCardReq);
        return true;
    }

    public boolean a(ToServiceMsg toServiceMsg, UniPacket uniPacket) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg, (Object) uniPacket)).booleanValue();
        }
        String serviceCmd = toServiceMsg.getServiceCmd();
        if (QLog.isColorLevel()) {
            QLog.d("TroopSender", 2, "create wup buffer cmd: " + serviceCmd);
        }
        if ("friendlist.ModifyGroupCardReq".equalsIgnoreCase(serviceCmd)) {
            return b(toServiceMsg, uniPacket);
        }
        return false;
    }
}
