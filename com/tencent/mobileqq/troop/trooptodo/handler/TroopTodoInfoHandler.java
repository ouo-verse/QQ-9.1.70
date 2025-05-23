package com.tencent.mobileqq.troop.trooptodo.handler;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.trooptodo.l;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0xf8e.oidb_0xf8e$ReqBody;
import tencent.im.oidb.cmd0xf8e.oidb_0xf8e$RspBody;
import ut2.b;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopTodoInfoHandler extends TroopBaseHandler implements b {
    static IPatchRedirector $redirector_;

    public TroopTodoInfoHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    private void F2(Long l3, String str, int i3, int i16) {
        oidb_0xf8e$ReqBody oidb_0xf8e_reqbody = new oidb_0xf8e$ReqBody();
        oidb_0xf8e_reqbody.group_code.set(l3.longValue());
        ToServiceMsg makeOIDBPkg = makeOIDBPkg(str, 3982, i3, oidb_0xf8e_reqbody.toByteArray());
        Bundle bundle = new Bundle();
        bundle.putInt(AppConstants.Key.SHARE_REQ_TYPE, i16);
        bundle.putLong("req_group_code", l3.longValue());
        makeOIDBPkg.extraData = bundle;
        makeOIDBPkg.setTimeout(30000L);
        sendPbReq(makeOIDBPkg);
    }

    private void G2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        long j3;
        int i3;
        if (toServiceMsg != null && fromServiceMsg != null) {
            Bundle bundle = toServiceMsg.extraData;
            if (bundle != null) {
                i3 = bundle.getInt(AppConstants.Key.SHARE_REQ_TYPE, 0);
                j3 = toServiceMsg.extraData.getLong("req_group_code");
            } else {
                j3 = 0;
                i3 = 0;
            }
            oidb_0xf8e$RspBody oidb_0xf8e_rspbody = new oidb_0xf8e$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, oidb_0xf8e_rspbody);
            QLog.i("TroopTodoInfoHandler-TodoInfo", 2, "[handleTroopTodoInfo] invoke 0xf8e,, groupCode = " + j3 + ", reqType = " + i3 + ", cmd = " + fromServiceMsg.getServiceCmd() + ", result = " + parseOIDBPkg);
            if (parseOIDBPkg != 0) {
                if ("OidbSvcTrpcTcp.0xf8e_1".equals(fromServiceMsg.getServiceCmd())) {
                    notifyUI(l.f301810e, false, new Object[]{Integer.valueOf(parseOIDBPkg), Integer.valueOf(i3)});
                    return;
                } else {
                    notifyUI(l.f301811f, false, new Object[]{Integer.valueOf(parseOIDBPkg), Integer.valueOf(i3), Long.valueOf(j3)});
                    return;
                }
            }
            int i16 = oidb_0xf8e_rspbody.exp_time.get();
            if ("OidbSvcTrpcTcp.0xf8e_1".equals(fromServiceMsg.getServiceCmd())) {
                notifyUI(l.f301810e, true, new Object[]{oidb_0xf8e_rspbody.info.get(), Integer.valueOf(i16), Integer.valueOf(i3)});
                return;
            } else {
                notifyUI(l.f301811f, true, new Object[]{oidb_0xf8e_rspbody.rpt_group_list.get(), Integer.valueOf(i16), Integer.valueOf(i3), Long.valueOf(j3)});
                return;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.w("TroopTodoInfoHandler-TodoInfo", 2, "[handleTroopTodoInfo] 0xf8e, resp == null || res == null");
        }
    }

    @Override // ut2.b
    public void D1(Long l3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) l3, i3);
        } else {
            F2(l3, "OidbSvcTrpcTcp.0xf8e_1", 1, i3);
        }
    }

    @Override // ut2.b
    public void K0(Long l3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) l3, i3);
        } else {
            F2(l3, "OidbSvcTrpcTcp.0xf8e_2", 2, i3);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvcTrpcTcp.0xf8e_1");
            this.allowCmdSet.add("OidbSvcTrpcTcp.0xf8e_2");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TroopTodoInfoHandler-TodoInfo";
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return l.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg != null && toServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                if (QLog.isColorLevel()) {
                    QLog.w("TroopTodoInfoHandler-TodoInfo", 2, "[onReceive] cmdfilter error = " + serviceCmd);
                    return;
                }
                return;
            }
            if (!getTag().equals(toServiceMsg.extraData.getString("REQ_TAG"))) {
                if (QLog.isColorLevel()) {
                    QLog.w("TroopTodoInfoHandler-TodoInfo", 2, "[onReceive] REQ_TAG doesn't match. cmd:  " + serviceCmd);
                    return;
                }
                return;
            }
            QLog.i("TroopTodoInfoHandler-TodoInfo", 2, "[onReceive] getServiceCmd = " + fromServiceMsg.getServiceCmd());
            G2(toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.w("TroopTodoInfoHandler-TodoInfo", 2, "[onReceive] resp == null or req == null");
        }
    }
}
