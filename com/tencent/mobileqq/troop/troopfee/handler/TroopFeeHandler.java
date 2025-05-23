package com.tencent.mobileqq.troop.troopfee.handler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.handler.TroopBaseHandler;
import com.tencent.mobileqq.troop.observer.g;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import gt2.a;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0x406.cmd0x406$GroupFeeMemberListQuery;
import tencent.im.oidb.cmd0x406.cmd0x406$ReqBody;
import tencent.im.oidb.cmd0x406.cmd0x406$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopFeeHandler extends TroopBaseHandler implements a {
    static IPatchRedirector $redirector_;

    public TroopFeeHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    public void F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (obj == null) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopFeeHandler.troop.troop_fee", 2, "handleGroupFeeMemberListQuery : data==null");
            }
            notifyUI(g.f298020e, false, null);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopFeeHandler.troop.troop_fee", 2, "handleGroupFeeMemberListQuery : resp.isSuccess=" + fromServiceMsg.isSuccess());
        }
        if (!fromServiceMsg.isSuccess()) {
            notifyUI(g.f298020e, false, null);
            return;
        }
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        try {
            oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
        } catch (InvalidProtocolBufferMicroException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TROOP_DISBAND, 2, "handleTroopFeeMemberListQuery|oidb_sso parseFrom byte " + e16.toString());
            }
            e16.printStackTrace();
        }
        if (oidb_sso_oidbssopkg != null) {
            i3 = oidb_sso_oidbssopkg.uint32_result.get();
            if (QLog.isColorLevel()) {
                QLog.d(LogTag.TROOP_DISBAND, 2, "handleTroopFeeMemberListQuery|oidb_sso.OIDBSSOPkg.result " + i3);
            }
        } else {
            i3 = -1;
        }
        if (i3 == 0 && oidb_sso_oidbssopkg != null) {
            cmd0x406$RspBody cmd0x406_rspbody = new cmd0x406$RspBody();
            try {
                cmd0x406_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                int i16 = cmd0x406_rspbody.uint32_ret.get();
                if (i16 == 0) {
                    notifyUI(g.f298020e, true, cmd0x406_rspbody.msg_member_list.get().msg_member_list.get());
                } else {
                    notifyUI(g.f298020e, false, null);
                }
                if (QLog.isColorLevel()) {
                    QLog.d("TroopFeeHandler.troop.troop_fee", 2, "ret :" + i16 + ",msg:" + cmd0x406_rspbody.string_msg.get().toString());
                    return;
                }
                return;
            } catch (InvalidProtocolBufferMicroException unused) {
                notifyUI(g.f298020e, false, null);
                if (QLog.isColorLevel()) {
                    QLog.d("TroopFeeHandler.troop.troop_fee", 2, "handleGroupFeeMemberListQuery : InvalidProtocolBufferMicroException");
                    return;
                }
                return;
            }
        }
        notifyUI(g.f298020e, false, null);
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
            hashSet.add("OidbSvc.0x406_3");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TroopFeeHandler";
    }

    @Override // gt2.a
    public void j1(String str, String str2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, str2, Integer.valueOf(i3));
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x406_3");
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1030);
        oidb_sso_oidbssopkg.uint32_service_type.set(3);
        cmd0x406$ReqBody cmd0x406_reqbody = new cmd0x406$ReqBody();
        cmd0x406$GroupFeeMemberListQuery cmd0x406_groupfeememberlistquery = new cmd0x406$GroupFeeMemberListQuery();
        cmd0x406_groupfeememberlistquery.string_project_id.set(str2);
        cmd0x406_groupfeememberlistquery.uint32_member_type.set(i3);
        cmd0x406_groupfeememberlistquery.uint32_page_index.set(0);
        cmd0x406_groupfeememberlistquery.uint32_page_size.set(-1);
        try {
            cmd0x406_reqbody.uint64_group_id.set(Long.valueOf(str).longValue());
            cmd0x406_reqbody.msg_member_list.set(cmd0x406_groupfeememberlistquery);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(cmd0x406_reqbody.toByteArray()));
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            sendPbReq(createToServiceMsg);
            if (QLog.isColorLevel()) {
                QLog.d("TroopFeeHandler.troop.troop_fee", 2, "getTroopFeeMembers, troopUin: " + str + " troopFeeId: " + str2);
            }
        } catch (NumberFormatException unused) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopFeeHandler.troop.troop_fee", 2, "NumberFormatException!getTroopFeeMembers, troopUin: " + str + " troopFeeId: " + str2);
            }
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return g.class;
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
                QLog.d("TroopFeeHandler", 2, "onReceive,resp == null");
                return;
            }
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (msgCmdFilter(serviceCmd)) {
            if (QLog.isColorLevel()) {
                QLog.d("TroopFeeHandler", 2, "cmdfilter error=" + serviceCmd);
                return;
            }
            return;
        }
        if ("OidbSvc.0x406_3".equals(fromServiceMsg.getServiceCmd())) {
            F2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
