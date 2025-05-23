package com.tencent.mobileqq.activity.recent.guidebanner;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.phonecontact.permission.PermissionChecker;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x59f.oidb_0x59f$Guidelines_8410;
import tencent.im.oidb.cmd0x59f.oidb_0x59f$ReqBody;
import tencent.im.oidb.cmd0x59f.oidb_0x59f$RspBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes10.dex */
public class NewerGuideBannerHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    protected NewerGuideBannerHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    private void D2(FromServiceMsg fromServiceMsg, Object obj) {
        boolean z16;
        if (fromServiceMsg.isSuccess() && obj != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        oidb_0x59f$Guidelines_8410 oidb_0x59f_guidelines_8410 = null;
        if (z16) {
            try {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
                if (oidb_sso_oidbssopkg.uint32_result.has() && oidb_sso_oidbssopkg.uint32_result.get() == 0) {
                    oidb_0x59f$RspBody oidb_0x59f_rspbody = new oidb_0x59f$RspBody();
                    oidb_0x59f_rspbody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                    if (oidb_0x59f_rspbody.msg_guidelines8410.has()) {
                        oidb_0x59f_guidelines_8410 = oidb_0x59f_rspbody.msg_guidelines8410.get();
                        z16 = true;
                    } else {
                        QLog.d("NewerGuideBannerHandler", 1, "[handlerGetNewerGuideBannerInfo] msg_guidelines8410 does not exist");
                    }
                }
            } catch (Throwable th5) {
                QLog.d("NewerGuideBannerHandler", 1, "handlerGetNewerGuideBannerInfo failed", th5);
            }
            z16 = false;
        }
        QLog.d("NewerGuideBannerHandler", 1, "handlerGetNewerGuideBannerInfo, result " + z16);
        notifyUI(0, z16, oidb_0x59f_guidelines_8410);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void E2() {
        QLog.d("NewerGuideBannerHandler", 1, "requestGetNewerGuideBannerInfo");
        oidb_0x59f$ReqBody oidb_0x59f_reqbody = new oidb_0x59f$ReqBody();
        oidb_0x59f_reqbody.uint32_contact_right.set(PermissionChecker.h().g() ? 1 : 0);
        sendPbReq(makeOIDBPkg("OidbSvc.0x59f_newer_guide_banner", 1439, 1, oidb_0x59f_reqbody.toByteArray()));
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return c.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
        } else if (fromServiceMsg.isSuccess() && TextUtils.equals("OidbSvc.0x59f_newer_guide_banner", fromServiceMsg.getServiceCmd())) {
            D2(fromServiceMsg, obj);
        }
    }
}
