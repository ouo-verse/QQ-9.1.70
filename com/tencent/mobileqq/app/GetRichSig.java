package com.tencent.mobileqq.app;

import KQQ.ReqItem;
import KQQ.RespItem;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.subaccount.api.ISubAccountService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class GetRichSig extends FriendListHandler implements com.tencent.mobileqq.service.profile.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private ToServiceMsg f194722d;

    public GetRichSig(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        }
    }

    @Override // com.tencent.mobileqq.service.profile.a
    public ReqItem d2(int i3) {
        ArrayList<String> arrayList;
        BaseProtocolCoder lookupCoder;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ReqItem) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        ArrayList arrayList2 = new ArrayList(2);
        arrayList2.add(this.app.getAccount());
        ISubAccountService iSubAccountService = (ISubAccountService) this.app.getRuntimeService(ISubAccountService.class, "");
        if (iSubAccountService != null) {
            arrayList = iSubAccountService.getAllSubUin();
        } else {
            arrayList = null;
        }
        if (arrayList != null && arrayList.size() > 0) {
            arrayList2.addAll(arrayList);
        }
        String[] strArr = new String[arrayList2.size()];
        arrayList2.toArray(strArr);
        getRichStatus(strArr);
        ToServiceMsg toServiceMsg = this.f194722d;
        if (toServiceMsg == null || (lookupCoder = this.app.mqqService.lookupCoder(toServiceMsg.getServiceCmd())) == null) {
            return null;
        }
        UniPacket uniPacket = new UniPacket(true);
        uniPacket.setEncodeName("utf-8");
        if (!lookupCoder.encodeReqMsg(this.f194722d, uniPacket)) {
            return null;
        }
        ReqItem reqItem = new ReqItem();
        reqItem.eServiceID = 119;
        reqItem.vecParam = uniPacket.encode();
        return reqItem;
    }

    @Override // com.tencent.mobileqq.service.profile.a
    public void l2(RespItem respItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) respItem);
            return;
        }
        if (respItem.eServiceID == 119 && respItem.cResult == 2) {
            FromServiceMsg fromServiceMsg = new FromServiceMsg(this.app.getAccount(), ProfileContants.CMD_GETSIGNATURE);
            fromServiceMsg.setMsgSuccess();
            fromServiceMsg.putWupBuffer(respItem.vecUpdate);
            this.app.receiveToService(this.f194722d, fromServiceMsg);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void send(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg);
        } else {
            this.f194722d = toServiceMsg;
        }
    }

    @Override // com.tencent.mobileqq.service.profile.a
    public int w0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 1;
    }
}
