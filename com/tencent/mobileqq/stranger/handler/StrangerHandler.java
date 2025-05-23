package com.tencent.mobileqq.stranger.handler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.stranger.observer.a;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4$DelResult;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4$ReqBody;
import tencent.im.oidb.cmd0x5d4.oidb_0x5d4$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes18.dex */
public class StrangerHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    public StrangerHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    public static StrangerHandler E2(AppRuntime appRuntime) {
        return (StrangerHandler) ((AppInterface) appRuntime).getBusinessHandler(StrangerHandler.class.getName());
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        oidb_sso$OIDBSSOPkg parseSSOPkg = parseSSOPkg(toServiceMsg, fromServiceMsg, obj);
        PBRepeatMessageField<oidb_0x5d4$DelResult> pBRepeatMessageField = null;
        if (parseSSOPkg != null) {
            try {
                oidb_0x5d4$RspBody oidb_0x5d4_rspbody = new oidb_0x5d4$RspBody();
                oidb_0x5d4_rspbody.mergeFrom(parseSSOPkg.bytes_bodybuffer.get().toByteArray());
                G2(oidb_0x5d4_rspbody.result);
                try {
                    pBRepeatMessageField = oidb_0x5d4_rspbody.result;
                    z16 = true;
                } catch (Exception e16) {
                    e = e16;
                    z16 = true;
                    QLog.e("StrangerHandler", 1, "handleDeleteStranger fail.", e);
                    if (QLog.isColorLevel()) {
                    }
                    notifyUI(3, z16, pBRepeatMessageField);
                }
            } catch (Exception e17) {
                e = e17;
                z16 = false;
            }
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("StrangerHandler", 2, String.format("handleDeleteStranger success=%s result=%s", Boolean.valueOf(z16), pBRepeatMessageField));
        }
        notifyUI(3, z16, pBRepeatMessageField);
    }

    private void G2(PBRepeatMessageField<oidb_0x5d4$DelResult> pBRepeatMessageField) {
        try {
            IRecentUserProxyService iRecentUserProxyService = (IRecentUserProxyService) this.appRuntime.getRuntimeService(IRecentUserProxyService.class, "");
            if (iRecentUserProxyService != null) {
                for (oidb_0x5d4$DelResult oidb_0x5d4_delresult : pBRepeatMessageField.get()) {
                    if (oidb_0x5d4_delresult.res.get() == 0) {
                        String valueOf = String.valueOf(oidb_0x5d4_delresult.uin.get());
                        RecentUserProxy recentUserCache = iRecentUserProxyService.getRecentUserCache();
                        RecentUser findRecentUser = recentUserCache.findRecentUser(valueOf, 0);
                        if (findRecentUser != null) {
                            recentUserCache.delRecentUser(findRecentUser);
                        }
                    }
                }
            }
        } catch (Exception e16) {
            QLog.e("StrangerHandler", 1, "notifyDeleteRecentUser fail.", e16);
        }
    }

    private static oidb_sso$OIDBSSOPkg parseSSOPkg(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        if (toServiceMsg != null && fromServiceMsg != null && fromServiceMsg.getResultCode() == 1000) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.e("StrangerHandler", 1, "parseSSOPkg fail.", e16);
            }
            if (oidb_sso_oidbssopkg.uint32_result.get() == 0 && oidb_sso_oidbssopkg.bytes_bodybuffer.get() != null) {
                return oidb_sso_oidbssopkg;
            }
        }
        return null;
    }

    public void D2(List<Long> list) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
            return;
        }
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[1];
            if (list != null) {
                str = Arrays.toString(list.toArray());
            } else {
                str = null;
            }
            objArr[0] = str;
            QLog.d("StrangerHandler", 2, String.format("deleteStrangers uinList=%s", objArr));
        }
        oidb_0x5d4$ReqBody oidb_0x5d4_reqbody = new oidb_0x5d4$ReqBody();
        oidb_0x5d4_reqbody.uin_list.set(list);
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(1492);
        oidb_sso_oidbssopkg.uint32_service_type.set(0);
        oidb_sso_oidbssopkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(oidb_0x5d4_reqbody.toByteArray()));
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0x5d4_0");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        sendPbReq(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Set) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add("OidbSvc.0x5d4_0");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        String serviceCmd = fromServiceMsg.getServiceCmd();
        if (QLog.isColorLevel()) {
            QLog.d("StrangerHandler", 2, String.format("onReceive cmd=%s", serviceCmd));
        }
        if ("OidbSvc.0x5d4_0".equals(serviceCmd)) {
            F2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
