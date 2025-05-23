package com.tencent.av.zplan.avatar.resmgr;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes3.dex */
public class RequestCDNServerUseStateHandler extends BusinessHandler {

    /* renamed from: d, reason: collision with root package name */
    private final d f77316d;

    protected RequestCDNServerUseStateHandler(AppInterface appInterface) {
        super(appInterface);
        this.f77316d = new d(appInterface);
    }

    public d D2() {
        return this.f77316d;
    }

    public void E2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (fromServiceMsg.getResultCode() == 1000) {
            RequestCDNServerUseStatePb$GetResCtrRsp requestCDNServerUseStatePb$GetResCtrRsp = new RequestCDNServerUseStatePb$GetResCtrRsp();
            try {
                requestCDNServerUseStatePb$GetResCtrRsp.mergeFrom((byte[]) obj);
                boolean z16 = false;
                for (int i3 = 0; i3 < requestCDNServerUseStatePb$GetResCtrRsp.infos.size(); i3++) {
                    if (requestCDNServerUseStatePb$GetResCtrRsp.infos.get(i3).status.get() == 2) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        break;
                    }
                }
                QLog.i("AVAvatarResMgr_RequestCDNServerUseStateHandler", 1, "handleRsp successfully. infos.size(): " + requestCDNServerUseStatePb$GetResCtrRsp.infos.size() + ", isCDNOverload: " + z16);
                AVAvatarResMgr.v().C(z16);
                return;
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("AVAvatarResMgr_RequestCDNServerUseStateHandler", 1, "handleRsp failed. err: " + e16);
                AVAvatarResMgr.v().C(false);
                return;
            }
        }
        QLog.e("AVAvatarResMgr_RequestCDNServerUseStateHandler", 1, "handleRsp failed. retCode: " + fromServiceMsg.getResultCode());
        AVAvatarResMgr.v().C(false);
    }

    public void F2(ArrayList<String> arrayList) {
        RequestCDNServerUseStatePb$GetResCtrReq requestCDNServerUseStatePb$GetResCtrReq = new RequestCDNServerUseStatePb$GetResCtrReq();
        requestCDNServerUseStatePb$GetResCtrReq.res_names.addAll(arrayList);
        ToServiceMsg createToServiceMsg = createToServiceMsg("trpc.qq_resourse.manager.resourse_control.SsoGetInfo");
        createToServiceMsg.putWupBuffer(requestCDNServerUseStatePb$GetResCtrReq.toByteArray());
        this.f77316d.d(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("trpc.qq_resourse.manager.resourse_control.SsoGetInfo");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg != null && fromServiceMsg != null) {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            QLog.i("AVAvatarResMgr_RequestCDNServerUseStateHandler", 1, "onReceive. cmd: " + serviceCmd);
            if ("trpc.qq_resourse.manager.resourse_control.SsoGetInfo".equals(serviceCmd)) {
                E2(toServiceMsg, fromServiceMsg, obj);
            }
        }
    }
}
