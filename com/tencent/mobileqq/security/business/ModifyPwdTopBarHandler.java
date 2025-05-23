package com.tencent.mobileqq.security.business;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.login.ModifyPwdDisplayInfo$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* loaded from: classes18.dex */
public class ModifyPwdTopBarHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    public ModifyPwdTopBarHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    private ToServiceMsg E2(long j3) {
        oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
        oidb_sso_oidbssopkg.uint32_command.set(3788);
        oidb_sso_oidbssopkg.uint32_service_type.set(0);
        ToServiceMsg createToServiceMsg = createToServiceMsg("OidbSvc.0xecc_0");
        createToServiceMsg.putWupBuffer(oidb_sso_oidbssopkg.toByteArray());
        createToServiceMsg.extraData.putLong("mark_extra_tag", j3);
        createToServiceMsg.setTimeout(30000L);
        return createToServiceMsg;
    }

    private void F2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        boolean z17;
        boolean z18;
        int i3;
        String str;
        Exception exc;
        boolean z19;
        String str2;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        long j3 = toServiceMsg.extraData.getLong("mark_extra_tag");
        String str3 = "";
        if (z16) {
            ModifyPwdDisplayInfo$RspBody modifyPwdDisplayInfo$RspBody = new ModifyPwdDisplayInfo$RspBody();
            try {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                if (oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                    modifyPwdDisplayInfo$RspBody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                    if (modifyPwdDisplayInfo$RspBody.uint32_display_flag.has() && modifyPwdDisplayInfo$RspBody.uint32_display_flag.get() == 1) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    try {
                        if (!modifyPwdDisplayInfo$RspBody.str_hori_bar_content.has()) {
                            str2 = "";
                        } else {
                            str2 = modifyPwdDisplayInfo$RspBody.str_hori_bar_content.get();
                        }
                    } catch (Exception e16) {
                        z18 = z19;
                        exc = e16;
                        str = "";
                        QLog.e("ModifyPwdTopBarHandler", 1, "handleFetchBarDisplay exception: ", exc);
                        z17 = false;
                        i3 = 0;
                        QLog.d("ModifyPwdTopBarHandler", 1, "handleFetchBarDisplay, isSuccess: " + z17 + " displayFlag: " + z18 + " horiBarContent: " + str3 + " barUrl: " + str + " nextAccessTime: " + i3);
                        notifyUI(1, z17, new Object[]{Long.valueOf(j3), Boolean.valueOf(z18), str3, str, Integer.valueOf(i3)});
                    }
                    try {
                        if (modifyPwdDisplayInfo$RspBody.str_bar_url.has()) {
                            str3 = modifyPwdDisplayInfo$RspBody.str_bar_url.get();
                        }
                        if (modifyPwdDisplayInfo$RspBody.uint32_next_access_time.has()) {
                            boolean z26 = z16;
                            str = str3;
                            str3 = str2;
                            i3 = modifyPwdDisplayInfo$RspBody.uint32_next_access_time.get();
                            z18 = z19;
                            z17 = z26;
                        } else {
                            z18 = z19;
                            z17 = z16;
                            str = str3;
                            str3 = str2;
                            i3 = 0;
                        }
                    } catch (Exception e17) {
                        z18 = z19;
                        exc = e17;
                        str = str3;
                        str3 = str2;
                        QLog.e("ModifyPwdTopBarHandler", 1, "handleFetchBarDisplay exception: ", exc);
                        z17 = false;
                        i3 = 0;
                        QLog.d("ModifyPwdTopBarHandler", 1, "handleFetchBarDisplay, isSuccess: " + z17 + " displayFlag: " + z18 + " horiBarContent: " + str3 + " barUrl: " + str + " nextAccessTime: " + i3);
                        notifyUI(1, z17, new Object[]{Long.valueOf(j3), Boolean.valueOf(z18), str3, str, Integer.valueOf(i3)});
                    }
                } else {
                    QLog.e("ModifyPwdTopBarHandler", 1, "handleFetchBarDisplay error: uint32_result != 0");
                    str = "";
                    z17 = false;
                    z18 = false;
                    i3 = 0;
                }
            } catch (Exception e18) {
                exc = e18;
                z18 = false;
            }
        } else {
            z17 = z16;
            z18 = false;
            i3 = 0;
            str = "";
        }
        QLog.d("ModifyPwdTopBarHandler", 1, "handleFetchBarDisplay, isSuccess: " + z17 + " displayFlag: " + z18 + " horiBarContent: " + str3 + " barUrl: " + str + " nextAccessTime: " + i3);
        notifyUI(1, z17, new Object[]{Long.valueOf(j3), Boolean.valueOf(z18), str3, str, Integer.valueOf(i3)});
    }

    public void D2(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, j3);
            return;
        }
        QLog.d("ModifyPwdTopBarHandler", 1, "fetchDisplayInfo pbMark: " + j3);
        sendPbReq(E2(j3));
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
            hashSet.add("OidbSvc.0xecc_0");
        }
        return this.allowCmdSet;
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return a.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        QLog.d("ModifyPwdTopBarHandler", 1, "onReceive: " + fromServiceMsg.getServiceCmd());
        if (!msgCmdFilter(fromServiceMsg.getServiceCmd()) && "OidbSvc.0xecc_0".equals(fromServiceMsg.getServiceCmd())) {
            F2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
