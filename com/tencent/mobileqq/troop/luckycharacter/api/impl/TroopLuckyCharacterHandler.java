package com.tencent.mobileqq.troop.luckycharacter.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IDBUtilApi;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.luckycharacter.api.a;
import com.tencent.mobileqq.troop.luckycharacter.api.b;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0xef1.oidb_0xef1$QueryGroupLuckyWordStatusRequest;
import tencent.im.oidb.cmd0xef1.oidb_0xef1$QueryGroupLuckyWordStatusResponse;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopLuckyCharacterHandler extends TroopBaseHandler implements a {
    static IPatchRedirector $redirector_;

    public TroopLuckyCharacterHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    public void F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (toServiceMsg != null && fromServiceMsg != null) {
            String string = toServiceMsg.extraData.getString("troopUin");
            oidb_0xef1$QueryGroupLuckyWordStatusResponse oidb_0xef1_querygroupluckywordstatusresponse = new oidb_0xef1$QueryGroupLuckyWordStatusResponse();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xef1_querygroupluckywordstatusresponse);
            if (parseOIDBPkg != 0) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopLuckyCharacterHandler", 2, "handleGetTroopLuckyCharacterStatus result = " + parseOIDBPkg + ",troopUin = " + string);
                }
                notifyUI(b.f297772e, false, new Object[]{string, ""});
                return;
            }
            String str = oidb_0xef1_querygroupluckywordstatusresponse.wording.get();
            ((IDBUtilApi) QRoute.api(IDBUtilApi.class)).setTroopLuckyCharacterStatus(this.appRuntime.getCurrentAccountUin(), string, str);
            notifyUI(b.f297772e, true, new Object[]{string, str});
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopLuckyCharacterHandler", 2, "handleGetTroopLuckyCharacterStatus resp == null || res == null");
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Set) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvc.0xef1_2");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TroopLuckyCharacterHandler";
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg != null && toServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopLuckyCharacterHandler", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if (!getTag().equals(toServiceMsg.extraData.getString("REQ_TAG"))) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopLuckyCharacterHandler", 2, "REQ_TAG doesn't match. cmd:  " + serviceCmd);
                    return;
                }
                return;
            }
            if ("OidbSvc.0xef1_2".equals(fromServiceMsg.getServiceCmd())) {
                F2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopLuckyCharacterHandler", 2, "onReceive,resp == null or req == null");
        }
    }

    @Override // com.tencent.mobileqq.troop.luckycharacter.api.a
    public void r0(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        try {
            long longValue = Long.valueOf(str).longValue();
            if (QLog.isColorLevel()) {
                QLog.d("TroopLuckyCharacterHandler", 2, "getTroopLuckyCharacterStatus troopUin =" + str);
            }
            oidb_0xef1$QueryGroupLuckyWordStatusRequest oidb_0xef1_querygroupluckywordstatusrequest = new oidb_0xef1$QueryGroupLuckyWordStatusRequest();
            oidb_0xef1_querygroupluckywordstatusrequest.group_code.set(longValue);
            ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0xef1_2", 3825, 2, oidb_0xef1_querygroupluckywordstatusrequest.toByteArray(), 30000L);
            makeOIDBPkg.extraData.putString("troopUin", str);
            if (QLog.isColorLevel()) {
                QLog.d("TroopLuckyCharacterHandler", 2, "sendPbRequest. cmd=" + makeOIDBPkg.getServiceCmd());
            }
            super.sendPbReq(makeOIDBPkg);
        } catch (Exception unused) {
        }
    }
}
