package com.tencent.mobileqq.troop.fans.handler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.fans.api.a;
import com.tencent.mobileqq.troop.fans.api.b;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0x1132.oidb_0x1132$ReqBody;
import tencent.im.oidb.cmd0x1132.oidb_0x1132$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopFansHandler extends TroopBaseHandler implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    protected Set<String> f295410e;

    /* renamed from: f, reason: collision with root package name */
    protected HashSet<String> f295411f;

    public TroopFansHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f295411f = new HashSet<>();
        }
    }

    private void F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg == null) {
            notifyUI(b.f295402h, false, new Object[]{"", null, -1});
            return;
        }
        String string = toServiceMsg.extraData.getString(IProfileProtocolConst.PARAM_TROOP_CODE, "");
        oidb_0x1132$RspBody oidb_0x1132_rspbody = new oidb_0x1132$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0x1132_rspbody);
        notifyUI(b.f295402h, true, new Object[]{string, oidb_0x1132_rspbody, Integer.valueOf(parseOIDBPkg)});
        if (QLog.isColorLevel()) {
            QLog.i("TroopFansHandler", 2, "handleCheckFansSensitive result :" + parseOIDBPkg);
        }
    }

    @Override // com.tencent.mobileqq.troop.fans.api.a
    public void c1(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (this.f295411f.contains(str)) {
            return;
        }
        oidb_0x1132$ReqBody oidb_0x1132_reqbody = new oidb_0x1132$ReqBody();
        oidb_0x1132_reqbody.f435972msg.set(str2);
        oidb_0x1132_reqbody.scene.set("FAN_COMMUNITY");
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(4402);
        oidb_sso_oidbssopkg.uint32_service_type.set(1);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x1132_reqbody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvcTrpcTcp.0x1132_1");
        createToServiceMsg.extraData.putString(IProfileProtocolConst.PARAM_TROOP_CODE, str);
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        sendPbReq(createToServiceMsg);
        this.f295411f.add(str);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.f295410e == null) {
            HashSet hashSet = new HashSet();
            this.f295410e = hashSet;
            hashSet.add("OidbSvcTrpcTcp.0x1132_1");
        }
        return this.f295410e;
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TroopFansHandler";
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return b.class;
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
                    QLog.d("TroopFansHandler", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if (!getTag().equals(toServiceMsg.extraData.getString("REQ_TAG"))) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopFansHandler", 2, "REQ_TAG doesn't match. cmd:  " + serviceCmd);
                    return;
                }
                return;
            }
            if ("OidbSvcTrpcTcp.0x1132_1".equals(fromServiceMsg.getServiceCmd())) {
                F2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopFansHandler", 2, "onReceive,resp == null or req == null");
        }
    }
}
