package com.tencent.mobileqq.service.message;

import AccostSvc.ReqGetBlackList;
import AccostSvc.ReqHeader;
import AccostSvc.RespGetBlackList;
import KQQ.ReqItem;
import KQQ.RespItem;
import com.qq.jce.wup.UniPacket;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.api.IMessageHandlerService;
import com.tencent.qphone.base.remote.FromServiceMsg;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d implements com.tencent.mobileqq.service.profile.a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static String f286191e;

    /* renamed from: d, reason: collision with root package name */
    private final AppInterface f286192d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45080);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f286191e = "GetBlackListItem";
        }
    }

    public d(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f286192d = appInterface;
        }
    }

    public static long a(long j3) {
        return j3 | 0;
    }

    @Override // com.tencent.mobileqq.service.profile.a
    public ReqItem d2(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ReqItem) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        ReqItem reqItem = new ReqItem();
        reqItem.eServiceID = 116;
        ReqHeader reqHeader = new ReqHeader();
        reqHeader.shVersion = (short) 0;
        reqHeader.lMID = a(Long.parseLong(this.f286192d.getAccount()));
        reqHeader.iAppID = AppSetting.f();
        ReqGetBlackList reqGetBlackList = new ReqGetBlackList(reqHeader, 0L, 1, 0);
        UniPacket uniPacket = new UniPacket();
        uniPacket.setServantName("AccostObj");
        uniPacket.setFuncName("CMD_GET_BlackList");
        uniPacket.put("ReqGetBlackList", reqGetBlackList);
        reqItem.vecParam = uniPacket.encode();
        return reqItem;
    }

    @Override // com.tencent.mobileqq.service.profile.a
    public void l2(RespItem respItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) respItem);
            return;
        }
        if (respItem.eServiceID == 116 && respItem.cResult == 2) {
            UniPacket uniPacket = new UniPacket();
            uniPacket.setEncodeName("utf-8");
            uniPacket.decode(respItem.vecUpdate);
            RespGetBlackList respGetBlackList = (RespGetBlackList) uniPacket.getByClass("RespGetBlackList", new RespGetBlackList());
            FromServiceMsg fromServiceMsg = new FromServiceMsg();
            fromServiceMsg.setMsgSuccess();
            fromServiceMsg.setServiceCmd("AccostSvc.ReqGetBlackList");
            ((IMessageHandlerService) QRoute.api(IMessageHandlerService.class)).handleGetBlackList(this.f286192d, null, fromServiceMsg, respGetBlackList);
        }
    }

    @Override // com.tencent.mobileqq.service.profile.a
    public int w0() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 1;
    }
}
