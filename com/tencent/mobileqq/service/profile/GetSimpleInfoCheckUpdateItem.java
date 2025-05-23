package com.tencent.mobileqq.service.profile;

import KQQ.ReqItem;
import KQQ.RespItem;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.BaseProtocolCoder;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes18.dex */
public class GetSimpleInfoCheckUpdateItem extends FriendListHandler implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static String f286372e;

    /* renamed from: d, reason: collision with root package name */
    private ToServiceMsg f286373d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74992);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f286372e = "GetSimpleInfoCheckUpdateItem";
        }
    }

    public GetSimpleInfoCheckUpdateItem(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        }
    }

    @Override // com.tencent.mobileqq.service.profile.a
    public ReqItem d2(int i3) {
        BaseProtocolCoder lookupCoder;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ReqItem) iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        getFriendInfo(this.app.getAccount());
        ToServiceMsg toServiceMsg = this.f286373d;
        if (toServiceMsg != null && (lookupCoder = this.app.mqqService.lookupCoder(toServiceMsg.getServiceCmd())) != null) {
            UniPacket uniPacket = new UniPacket(true);
            uniPacket.setEncodeName("utf-8");
            if (lookupCoder.encodeReqMsg(this.f286373d, uniPacket)) {
                ReqItem reqItem = new ReqItem();
                reqItem.eServiceID = 113;
                reqItem.vecParam = uniPacket.encode();
                return reqItem;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.service.profile.a
    public void l2(RespItem respItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) respItem);
            return;
        }
        if (respItem.eServiceID == 113 && respItem.cResult == 2) {
            FromServiceMsg fromServiceMsg = new FromServiceMsg(this.app.getAccount(), ProfileContants.CMD_GETSIMPLEINFO);
            fromServiceMsg.setMsgSuccess();
            fromServiceMsg.putWupBuffer(respItem.vecUpdate);
            this.app.receiveToService(this.f286373d, fromServiceMsg);
        }
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void send(ToServiceMsg toServiceMsg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) toServiceMsg);
        } else {
            this.f286373d = toServiceMsg;
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
