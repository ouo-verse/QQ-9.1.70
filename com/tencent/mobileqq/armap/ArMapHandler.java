package com.tencent.mobileqq.armap;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0x95a.cmd0x95a$GetArActivityRedReq;
import tencent.im.oidb.cmd0x95a.cmd0x95a$GetArActivityRedRsp;
import tencent.im.oidb.cmd0x95a.cmd0x95a$ReqBody;
import tencent.im.oidb.cmd0x95a.cmd0x95a$RspBody;
import tencent.im.oidb.cmd0x95a.cmd0x95a$UpdateArCountRsp;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArMapHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    public ArMapHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    void D2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean isSuccess;
        String str;
        long j3;
        if (fromServiceMsg == null) {
            isSuccess = false;
        } else {
            isSuccess = fromServiceMsg.isSuccess();
        }
        int i3 = -1;
        int i16 = toServiceMsg.extraData.getInt("subcmd", -1);
        if (isSuccess) {
            cmd0x95a$RspBody cmd0x95a_rspbody = new cmd0x95a$RspBody();
            int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0x95a_rspbody);
            str = fromServiceMsg.extraData.getString("str_error_msg");
            if (parseOIDBPkg == 0) {
                if (i16 != 1) {
                    if (i16 == 5) {
                        E2(toServiceMsg, isSuccess, parseOIDBPkg, cmd0x95a_rspbody);
                    }
                } else if (cmd0x95a_rspbody.msg_update_ar_count_rsp.has()) {
                    cmd0x95a$UpdateArCountRsp cmd0x95a_updatearcountrsp = cmd0x95a_rspbody.msg_update_ar_count_rsp.get();
                    if (cmd0x95a_updatearcountrsp.uint64_uin.has()) {
                        j3 = cmd0x95a_updatearcountrsp.uint64_uin.get();
                    } else {
                        j3 = -1;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("ArMapHandler", 2, "handle0x95a report scanQRCode result,uin = " + j3);
                    }
                }
            }
            i3 = parseOIDBPkg;
        } else {
            str = "";
        }
        if (QLog.isColorLevel()) {
            QLog.d("ArMapHandler", 2, "handle0x95a errMsg:" + str + ",result:" + i3 + ",isSuc:" + isSuccess + ",subCmd:" + i16);
        }
    }

    void E2(ToServiceMsg toServiceMsg, boolean z16, int i3, cmd0x95a$RspBody cmd0x95a_rspbody) {
        cmd0x95a$GetArActivityRedRsp cmd0x95a_getaractivityredrsp;
        long j3;
        int i16;
        if (z16 && i3 == 0 && cmd0x95a_rspbody != null) {
            if (cmd0x95a_rspbody.msg_get_ar_activity_red_rsp.has()) {
                cmd0x95a_getaractivityredrsp = cmd0x95a_rspbody.msg_get_ar_activity_red_rsp.get();
            } else {
                cmd0x95a_getaractivityredrsp = null;
            }
            if (cmd0x95a_getaractivityredrsp != null) {
                long j16 = 0;
                if (cmd0x95a_getaractivityredrsp.uint64_uin.has()) {
                    j3 = cmd0x95a_getaractivityredrsp.uint64_uin.get();
                } else {
                    j3 = 0;
                }
                if (cmd0x95a_getaractivityredrsp.uint32_red_switch.has()) {
                    i16 = cmd0x95a_getaractivityredrsp.uint32_red_switch.get();
                } else {
                    i16 = 0;
                }
                if (cmd0x95a_getaractivityredrsp.uint64_server_activity_id.has()) {
                    j16 = cmd0x95a_getaractivityredrsp.uint64_server_activity_id.get();
                }
                if (QLog.isColorLevel()) {
                    QLog.d("ArMapHandler", 2, "handleGetARActRedDotInfo uin:" + j3 + ",redSwitch:" + i16 + ",actId:" + j16);
                }
                notifyUI(1, z16, new Object[]{Integer.valueOf(i16), Long.valueOf(j16)});
            }
        }
    }

    public void F2(long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ArMapHandler", 2, "reqActRedDotInfo,uin :" + j3 + ",actID :" + j16);
        }
        cmd0x95a$GetArActivityRedReq cmd0x95a_getaractivityredreq = new cmd0x95a$GetArActivityRedReq();
        cmd0x95a_getaractivityredreq.uint64_uin.set(j3);
        cmd0x95a_getaractivityredreq.uint64_client_activity_id.set(j16);
        cmd0x95a$ReqBody cmd0x95a_reqbody = new cmd0x95a$ReqBody();
        cmd0x95a_reqbody.msg_get_ar_activity_red_req.set(cmd0x95a_getaractivityredreq);
        ToServiceMsg makeOIDBPkg = makeOIDBPkg("OidbSvc.0x95a", 2394, 5, cmd0x95a_reqbody.toByteArray());
        makeOIDBPkg.extraData.putInt("subcmd", 5);
        sendPbReq(makeOIDBPkg);
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
            hashSet.add("OidbSvc.0x95a");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Class) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return b.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (toServiceMsg != null && fromServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                if (QLog.isColorLevel()) {
                    QLog.d("ArMapHandler", 2, "onReceive, msgCmdFilter is true,cmd  = " + serviceCmd);
                    return;
                }
                return;
            }
            if ("OidbSvc.0x95a".equals(serviceCmd)) {
                D2(toServiceMsg, fromServiceMsg, obj);
            }
        }
    }
}
