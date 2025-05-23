package com.tencent.mobileqq.guild.message.mobapremadesteam;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import ku1.a;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* loaded from: classes14.dex */
public class MobaPremadesTeamHandler extends BusinessHandler {

    /* renamed from: d, reason: collision with root package name */
    private AppInterface f230652d;

    public MobaPremadesTeamHandler(AppInterface appInterface) {
        super(appInterface);
        this.f230652d = appInterface;
    }

    void D2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int i3;
        boolean z16 = false;
        if (fromServiceMsg.getResultCode() == 1000 && obj != null) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("MobaPremadesTeamHandler", 2, "handleMobaPremadesTeamMsg|oidb_sso parseFrom byte " + e16.toString());
                }
                e16.printStackTrace();
            }
            i3 = oidb_sso_oidbssopkg.uint32_result.get();
            if (i3 == 0) {
                z16 = true;
            }
        } else {
            i3 = -1;
        }
        if (QLog.isColorLevel()) {
            QLog.i("MobaPremadesTeamHandler", 2, "handleMobaPremadesTeamMsg result:" + i3 + " isSuccess:" + z16);
        }
        notifyUI(a.f413039e, z16, null);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvcTrpcTcp.0xffa_2");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg != null && toServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (msgCmdFilter(serviceCmd)) {
                if (QLog.isColorLevel()) {
                    QLog.d("MobaPremadesTeamHandler", 2, "cmdfilter error=" + serviceCmd);
                    return;
                }
                return;
            }
            if ("OidbSvcTrpcTcp.0xffa_2".equals(fromServiceMsg.getServiceCmd())) {
                D2(toServiceMsg, fromServiceMsg, obj);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MobaPremadesTeamHandler", 2, "onReceive,resp == null or req == null");
        }
    }
}
