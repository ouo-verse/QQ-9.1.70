package com.tencent.mobileqq.troop.troopmessage.handler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.observer.h;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import mqq.app.Constants;
import mt2.a;
import tencent.im.oidb.cmd0x8a7.cmd0x8a7$ReqBody;
import tencent.im.oidb.cmd0x8a7.cmd0x8a7$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopMessageHandler extends TroopBaseHandler implements a {
    static IPatchRedirector $redirector_;

    public TroopMessageHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    private void F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        String str;
        int i3;
        int i16;
        boolean z16;
        if (toServiceMsg != null && fromServiceMsg != null) {
            String string = toServiceMsg.extraData.getString(IProfileProtocolConst.PARAM_TROOP_CODE);
            String str2 = "";
            Object[] objArr = {string, Boolean.FALSE, "", ""};
            if (fromServiceMsg.getResultCode() != 1000) {
                notifyUI(h.f298022e, false, objArr);
                return;
            }
            try {
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                if (mergeFrom != null && mergeFrom.uint32_result.has() && mergeFrom.uint32_result.get() == 0 && mergeFrom.bytes_bodybuffer.has() && mergeFrom.bytes_bodybuffer.get() != null) {
                    cmd0x8a7$RspBody cmd0x8a7_rspbody = new cmd0x8a7$RspBody();
                    try {
                        cmd0x8a7_rspbody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                        boolean z17 = cmd0x8a7_rspbody.bool_can_at_all.get();
                        if (!cmd0x8a7_rspbody.bytes_prompt_msg_1.has()) {
                            str = "";
                        } else {
                            str = cmd0x8a7_rspbody.bytes_prompt_msg_1.get().toStringUtf8();
                        }
                        if (cmd0x8a7_rspbody.bytes_prompt_msg_2.has()) {
                            str2 = cmd0x8a7_rspbody.bytes_prompt_msg_2.get().toStringUtf8();
                        }
                        if (cmd0x8a7_rspbody.uint32_remain_at_all_count_for_group.has()) {
                            i3 = cmd0x8a7_rspbody.uint32_remain_at_all_count_for_group.get();
                        } else {
                            i3 = 0;
                        }
                        if (cmd0x8a7_rspbody.uint32_remain_at_all_count_for_uin.has()) {
                            i16 = cmd0x8a7_rspbody.uint32_remain_at_all_count_for_uin.get();
                        } else {
                            i16 = 0;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("TroopMessageHandler.atAll", 2, "handleGetAtAllRemainCountInfo:" + string + ", groupRemainCnt=" + i3 + ", memberRemainCnt=" + i16 + ", beCanAtAll=" + z17 + ", tips1=" + str + ", tips2=" + str2);
                        }
                        if (cmd0x8a7_rspbody.bool_show_at_all_lable.has()) {
                            z16 = cmd0x8a7_rspbody.bool_show_at_all_lable.get();
                        } else {
                            z16 = false;
                        }
                        notifyUI(h.f298022e, true, new Object[]{string, Boolean.valueOf(z17), str, str2, Boolean.valueOf(z16)});
                        return;
                    } catch (InvalidProtocolBufferMicroException unused) {
                        notifyUI(h.f298022e, false, objArr);
                        return;
                    }
                }
                notifyUI(h.f298022e, false, objArr);
            } catch (InvalidProtocolBufferMicroException unused2) {
                notifyUI(h.f298022e, false, objArr);
            }
        }
    }

    @Override // mt2.a
    public void getAtAllRemainCountInfo(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2);
            return;
        }
        cmd0x8a7$ReqBody cmd0x8a7_reqbody = new cmd0x8a7$ReqBody();
        cmd0x8a7_reqbody.uint32_sub_cmd.set(1);
        cmd0x8a7_reqbody.uint32_limit_interval_type_for_uin.set(2);
        cmd0x8a7_reqbody.uint32_limit_interval_type_for_group.set(1);
        try {
            cmd0x8a7_reqbody.uint64_uin.set(Long.parseLong(str));
            cmd0x8a7_reqbody.uint64_group_code.set(Long.parseLong(str2));
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(Constants.Action.ACTION_WTLOGIN_QUICK_LOGIN_BY_GATEWAY);
            oidb_sso_oidbssopkg.uint32_result.set(0);
            oidb_sso_oidbssopkg.uint32_service_type.set(0);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(cmd0x8a7_reqbody.toByteArray()));
            ToServiceMsg toServiceMsg = new ToServiceMsg("mobileqq.service", this.appRuntime.getCurrentAccountUin(), "OidbSvc.0x8a7_0");
            toServiceMsg.extraData.putString(IProfileProtocolConst.PARAM_TROOP_CODE, str2);
            toServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            sendPbReq(toServiceMsg);
        } catch (NumberFormatException unused) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopMessageHandler", 2, "getAnonymousChatNick error, NumberFormatException, uin : " + str + ", troopUin : " + str2);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.allowCmdSet == null) {
            this.allowCmdSet = new HashSet();
        }
        this.allowCmdSet.add("OidbSvc.0x8a7_0");
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TroopMessageHandler";
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return h.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg == null) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopMessageHandler", 2, "onReceive,resp == null");
                return;
            }
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (msgCmdFilter(serviceCmd)) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopMessageHandler", 2, "cmdfilter error=" + serviceCmd);
                return;
            }
            return;
        }
        if ("OidbSvc.0x8a7_0".equals(fromServiceMsg.getServiceCmd())) {
            F2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
