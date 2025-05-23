package com.tencent.mobileqq.troop.clockin.handler;

import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.clockin.api.a;
import com.tencent.mobileqq.troop.clockin.api.b;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7$ReqBody;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7$RspBody;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7$StSignInStatusReq;
import tencent.im.oidb.cmd0xeb7.oidb_0xeb7$StSignInWriteReq;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopClockInHandler extends TroopBaseHandler implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    protected Set<String> f294685e;

    public TroopClockInHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    private void F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        if (toServiceMsg != null && fromServiceMsg != null) {
            Boolean valueOf = Boolean.valueOf(toServiceMsg.extraData.getBoolean("isWrite"));
            String string = toServiceMsg.extraData.getString("troopUin");
            String string2 = toServiceMsg.extraData.getString("memberUin");
            int i16 = toServiceMsg.extraData.getInt("signInScene");
            if (valueOf.booleanValue()) {
                i3 = b.f294684f;
            } else {
                i3 = b.f294683e;
            }
            oidb_0xeb7$RspBody oidb_0xeb7_rspbody = new oidb_0xeb7$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xeb7_rspbody);
            if (parseOIDBPkg != 0) {
                if (QLog.isColorLevel()) {
                    QLog.i("TroopClockInHandler", 2, "handleInvokeSignInStatusResp failed result: " + parseOIDBPkg);
                }
                notifyUI(i3, false, null);
                return;
            }
            if (valueOf.booleanValue()) {
                if (oidb_0xeb7_rspbody.signInWriteRsp.has()) {
                    notifyUI(i3, true, new Object[]{string, string2, oidb_0xeb7_rspbody.signInWriteRsp.get()});
                    return;
                } else {
                    notifyUI(i3, false, new Object[]{string, string2, null});
                    return;
                }
            }
            if (oidb_0xeb7_rspbody.signInStatusRsp.has()) {
                notifyUI(i3, true, new Object[]{string, string2, oidb_0xeb7_rspbody.signInStatusRsp.get(), Integer.valueOf(i16)});
                return;
            } else {
                notifyUI(i3, false, new Object[]{string, string2, null, Integer.valueOf(i16)});
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopClockInHandler", 2, "handleInvokeSignInStatusResp resp == null || res == null");
        }
    }

    private void G2(String str, String str2, int i3, boolean z16) {
        int i16;
        try {
            oidb_0xeb7$ReqBody oidb_0xeb7_reqbody = new oidb_0xeb7$ReqBody();
            if (z16) {
                oidb_0xeb7$StSignInWriteReq oidb_0xeb7_stsigninwritereq = new oidb_0xeb7$StSignInWriteReq();
                oidb_0xeb7_stsigninwritereq.groupId.set(str);
                oidb_0xeb7_stsigninwritereq.uid.set(str2);
                oidb_0xeb7_stsigninwritereq.clientVersion.set(AppSetting.f99551k);
                oidb_0xeb7_reqbody.signInWriteReq.set(oidb_0xeb7_stsigninwritereq);
                i16 = 1;
            } else {
                oidb_0xeb7$StSignInStatusReq oidb_0xeb7_stsigninstatusreq = new oidb_0xeb7$StSignInStatusReq();
                oidb_0xeb7_stsigninstatusreq.groupId.set(str);
                oidb_0xeb7_stsigninstatusreq.uid.set(str2);
                oidb_0xeb7_stsigninstatusreq.scene.set(i3);
                oidb_0xeb7_stsigninstatusreq.clientVersion.set(AppSetting.f99551k);
                oidb_0xeb7_reqbody.signInStatusReq.set(oidb_0xeb7_stsigninstatusreq);
                i16 = 0;
            }
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xeb7", 3767, i16, oidb_0xeb7_reqbody.toByteArray(), 30000L);
            makeOIDBPkg.extraData.putString("troopUin", str);
            makeOIDBPkg.extraData.putString("memberUin", str2);
            makeOIDBPkg.extraData.putInt("signInScene", i3);
            makeOIDBPkg.extraData.putBoolean("isWrite", z16);
            sendPbReq(makeOIDBPkg);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.troop.clockin.api.a
    public void B2(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, str2, Integer.valueOf(i3));
        } else {
            G2(str, str2, i3, false);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.f294685e == null) {
            HashSet hashSet = new HashSet();
            this.f294685e = hashSet;
            hashSet.add("OidbSvc.0xeb7");
        }
        return this.f294685e;
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TroopClockInHandler";
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
                    QLog.d("TroopClockInHandler", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if (!getTag().equals(toServiceMsg.extraData.getString("REQ_TAG"))) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopClockInHandler", 2, "REQ_TAG doesn't match. cmd:  " + serviceCmd);
                    return;
                }
                return;
            }
            if ("OidbSvc.0xeb7".equals(fromServiceMsg.getServiceCmd())) {
                F2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopClockInHandler", 2, "onReceive,resp == null or req == null");
        }
    }

    @Override // com.tencent.mobileqq.troop.clockin.api.a
    public void s0(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
        } else {
            G2(str, str2, 0, true);
        }
    }
}
