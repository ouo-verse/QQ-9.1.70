package com.tencent.mobileqq.troop.handler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.OidbWrapper;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.config.af;
import com.tencent.mobileqq.troop.api.observer.e;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.im.oidb.cmd0xaf6.cmd0xaf6$GroupMember;
import tencent.im.oidb.cmd0xaf6.cmd0xaf6$ReqBody;
import tencent.im.oidb.cmd0xaf6.cmd0xaf6$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopMemberListHandler extends TroopBaseHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    protected Set<String> f296253e;

    /* renamed from: f, reason: collision with root package name */
    private final List<Long> f296254f;

    public TroopMemberListHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        } else {
            this.f296254f = new ArrayList();
            af.a();
        }
    }

    private void G2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        cmd0xaf6$RspBody cmd0xaf6_rspbody = new cmd0xaf6$RspBody();
        int parseOIDBPkg = OidbWrapper.parseOIDBPkg(fromServiceMsg, obj, cmd0xaf6_rspbody);
        if (parseOIDBPkg == 0) {
            StringBuffer stringBuffer = new StringBuffer("groupUins:");
            if (cmd0xaf6_rspbody.group_member.has()) {
                ITroopInfoService iTroopInfoService = (ITroopInfoService) this.appRuntime.getRuntimeService(ITroopInfoService.class, "");
                List<cmd0xaf6$GroupMember> list = cmd0xaf6_rspbody.group_member.get();
                ArrayList arrayList = new ArrayList();
                for (cmd0xaf6$GroupMember cmd0xaf6_groupmember : list) {
                    long j3 = cmd0xaf6_groupmember.group_id.get();
                    TroopInfo troopInfo = iTroopInfoService.getTroopInfo(String.valueOf(j3));
                    ArrayList arrayList2 = new ArrayList();
                    Iterator<Long> it = cmd0xaf6_groupmember.uins.get().iterator();
                    while (it.hasNext()) {
                        long longValue = it.next().longValue();
                        arrayList2.add(String.valueOf(longValue));
                        stringBuffer.append(longValue);
                        stringBuffer.append("|");
                    }
                    af.c(this.appRuntime, troopInfo, arrayList2);
                    arrayList.add(Long.valueOf(j3));
                }
                synchronized (this.f296254f) {
                    this.f296254f.removeAll(arrayList);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("TroopMemberListHandler", 2, "handleGetTroopMemberListForHeadBatch:" + stringBuffer.toString());
                return;
            }
            return;
        }
        QLog.e("TroopMemberListHandler", 1, "getTroopMemberListBatch failed! retCode = " + parseOIDBPkg);
    }

    public void F2(List<Long> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
            return;
        }
        ArrayList arrayList = new ArrayList();
        synchronized (this.f296254f) {
            if (this.f296254f.isEmpty()) {
                arrayList.addAll(list);
                this.f296254f.addAll(list);
            } else {
                for (Long l3 : list) {
                    if (!this.f296254f.contains(l3)) {
                        arrayList.add(l3);
                        this.f296254f.add(l3);
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListHandler", 2, "getTroopMemberListForHeadBatch, troopUins.size = " + list.size() + ", needRequestTroop.size=" + arrayList.size());
        }
        if (arrayList.isEmpty()) {
            return;
        }
        int ceil = (int) Math.ceil(arrayList.size() / 50.0d);
        int i3 = 0;
        while (i3 < ceil) {
            int i16 = i3 + 1;
            List<Long> subList = arrayList.subList(i3 * 50, Math.min(arrayList.size(), i16 * 50));
            cmd0xaf6$ReqBody cmd0xaf6_reqbody = new cmd0xaf6$ReqBody();
            cmd0xaf6_reqbody.group_id.set(subList);
            cmd0xaf6_reqbody.get_member_num.set(9L);
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            oidb_sso_oidbssopkg.uint32_command.set(2806);
            oidb_sso_oidbssopkg.uint32_result.set(0);
            oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(cmd0xaf6_reqbody.toByteArray()));
            oidb_sso_oidbssopkg.uint32_service_type.set(0);
            ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0xaf6_0");
            createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
            createToServiceMsg.setTimeout(30000L);
            sendPbReq(createToServiceMsg);
            i3 = i16;
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Set) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (this.f296253e == null) {
            HashSet hashSet = new HashSet();
            this.f296253e = hashSet;
            hashSet.add("OidbSvc.0xaf6_0");
        }
        return this.f296253e;
    }

    @Override // com.tencent.mobileqq.troop.handler.TroopBaseHandler
    protected String getTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "TroopMemberListHandler";
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
                    QLog.d("TroopMemberListHandler", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if (!getTag().equals(toServiceMsg.extraData.getString("REQ_TAG"))) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopMemberListHandler", 2, "REQ_TAG doesn't match. cmd:  " + serviceCmd);
                    return;
                }
                return;
            }
            if ("OidbSvc.0xaf6_0".equals(fromServiceMsg.getServiceCmd())) {
                G2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopMemberListHandler", 2, "onReceive,resp == null or req == null");
        }
    }
}
