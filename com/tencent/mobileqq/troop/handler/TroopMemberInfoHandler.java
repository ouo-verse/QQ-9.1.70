package com.tencent.mobileqq.troop.handler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.handler.f;
import com.tencent.mobileqq.troop.api.observer.e;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.oidb_0x783.oidb_0x783$RemarkInfo;
import tencent.im.oidb.oidb_0x783.oidb_0x783$ReqBody;
import tencent.im.oidb.oidb_0x783.oidb_0x783$RspBody;
import tencent.im.oidb.oidb_0x783.oidb_0x783$UinListInfo;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopMemberInfoHandler extends TroopBaseHandler implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    protected Set<String> f296252e;

    public TroopMemberInfoHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    private void F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        try {
            oidb_0x783$RspBody oidb_0x783_rspbody = new oidb_0x783$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0x783_rspbody);
            if (parseOIDBPkg == 0) {
                int i3 = oidb_0x783_rspbody.uint32_result.get();
                if (i3 == 0) {
                    List<oidb_0x783$RemarkInfo> list = oidb_0x783_rspbody.rpt_remark_infos.get();
                    if (list != null && list.size() > 0) {
                        String stringUtf8 = list.get(0).bytes_remark.get().toStringUtf8();
                        notifyUI(e.TYPE_GET_TROOP_MEMBER_AUTO_REMARK, true, new Object[]{(String) toServiceMsg.extraData.get("memberUin"), stringUtf8});
                    }
                } else {
                    QLog.e("TroopMemberInfoHandler", 1, "handleGetAutoRemark result failed! result code = ", Integer.valueOf(i3), oidb_0x783_rspbody.str_errmsg.get());
                }
            } else {
                QLog.e("TroopMemberInfoHandler", 1, "handleGetAutoRemark failed! retCode = ", Integer.valueOf(parseOIDBPkg));
            }
        } catch (Exception e16) {
            QLog.e("TroopMemberInfoHandler", 1, "handleGetAutoRemark exception. e=", e16);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.f296252e == null) {
            HashSet hashSet = new HashSet();
            this.f296252e = hashSet;
            hashSet.add("oidbSvc.0x783_15");
        }
        return this.f296252e;
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TroopMemberInfoHandler";
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return e.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg != null && toServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopMemberInfoHandler", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if (!getTag().equals(toServiceMsg.extraData.getString("REQ_TAG"))) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopMemberInfoHandler", 2, "REQ_TAG doesn't match. cmd:  " + serviceCmd);
                    return;
                }
                return;
            }
            if ("oidbSvc.0x783_15".equals(fromServiceMsg.getServiceCmd())) {
                F2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopMemberInfoHandler", 2, "onReceive,resp == null or req == null");
        }
    }

    @Override // com.tencent.mobileqq.troop.api.handler.f
    public void x(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        try {
            oidb_0x783$ReqBody oidb_0x783_reqbody = new oidb_0x783$ReqBody();
            oidb_0x783$UinListInfo oidb_0x783_uinlistinfo = new oidb_0x783$UinListInfo();
            oidb_0x783_uinlistinfo.uint64_uin.set(Long.valueOf(str).longValue());
            oidb_0x783_reqbody.rpt_uinlist.add(oidb_0x783_uinlistinfo);
            oidb_0x783_reqbody.uint32_subcmd.set(3);
            oidb_0x783_reqbody.uint32_type.set(15);
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(1923);
            oidb_sso_oidbssopkg.uint32_service_type.set(15);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x783_reqbody.toByteArray()));
            ToServiceMsg createToServiceMsg = createToServiceMsg("oidbSvc.0x783_15");
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            createToServiceMsg.setTimeout(5000L);
            createToServiceMsg.extraData.putString("memberUin", str);
            sendPbReq(createToServiceMsg);
        } catch (NumberFormatException unused) {
            if (QLog.isColorLevel()) {
                QLog.e("TroopMemberInfoHandler", 2, "NumberFormatException");
            }
        }
    }
}
