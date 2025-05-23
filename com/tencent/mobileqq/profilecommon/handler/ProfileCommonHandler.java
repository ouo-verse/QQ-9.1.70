package com.tencent.mobileqq.profilecommon.handler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.profilecommon.api.impl.ProfileCommonServiceImpl;
import com.tencent.mobileqq.profilecommon.observer.a;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* loaded from: classes16.dex */
public class ProfileCommonHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    protected ProfileCommonHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    private void E2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean isSuccess = fromServiceMsg.isSuccess();
        int resultCode = fromServiceMsg.getResultCode();
        if (isSuccess) {
            try {
                resultCode = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj).uint32_result.get();
                if (resultCode == 0) {
                    isSuccess = true;
                }
            } catch (Exception e16) {
                QLog.e("ProfileCommonHandler", 1, "handleSetProfileInfo fail.", e16);
            }
            isSuccess = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ProfileCommonHandler", 2, String.format("handleSetProfileInfo success=%s resultCode=%s", Boolean.valueOf(isSuccess), Integer.valueOf(resultCode)));
        }
        ProfileCommonServiceImpl.getProfileCommonService(this.appRuntime).responseSetProfileDetail(toServiceMsg.extraData, isSuccess);
    }

    public void D2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        boolean isSuccess = fromServiceMsg.isSuccess();
        int resultCode = fromServiceMsg.getResultCode();
        oidb_0x5eb$UdcUinData oidb_0x5eb_udcuindata = null;
        if (isSuccess) {
            try {
                oidb_sso$OIDBSSOPkg mergeFrom = new oidb_sso$OIDBSSOPkg().mergeFrom((byte[]) obj);
                resultCode = mergeFrom.uint32_result.get();
                if (resultCode == 0) {
                    isSuccess = true;
                } else {
                    isSuccess = false;
                }
                if (isSuccess && mergeFrom.bytes_bodybuffer.has()) {
                    oidb_0x5eb$RspBody oidb_0x5eb_rspbody = new oidb_0x5eb$RspBody();
                    oidb_0x5eb_rspbody.mergeFrom(mergeFrom.bytes_bodybuffer.get().toByteArray());
                    if (oidb_0x5eb_rspbody.rpt_msg_uin_data.size() > 0) {
                        oidb_0x5eb_udcuindata = oidb_0x5eb_rspbody.rpt_msg_uin_data.get(0);
                    }
                }
            } catch (Exception e16) {
                QLog.e("ProfileCommonHandler", 1, "handleGetProfileInfo fail.", e16);
                isSuccess = false;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d("ProfileCommonHandler", 2, String.format("handleGetProfileInfo success=%s resultCode=%s udcUinData=%s", Boolean.valueOf(isSuccess), Integer.valueOf(resultCode), oidb_0x5eb_udcuindata));
        }
        ProfileCommonServiceImpl.getProfileCommonService(this.appRuntime).responseGetProfileDetail(toServiceMsg.extraData, isSuccess, oidb_0x5eb_udcuindata);
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
            hashSet.add("OidbSvc.0x5eb_common");
            this.allowCmdSet.add("OidbSvc.0x587_common");
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
        if (msgCmdFilter(serviceCmd)) {
            return;
        }
        if ("OidbSvc.0x5eb_common".equals(serviceCmd)) {
            D2(toServiceMsg, fromServiceMsg, obj);
        } else if ("OidbSvc.0x587_common".equals(serviceCmd)) {
            E2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
