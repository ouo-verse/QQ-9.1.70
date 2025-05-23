package com.tencent.mobileqq.pushdialog;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xefe.oidb_cmd0xefe$ReqBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes16.dex */
public class SafeBlowHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static final String f261333d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74309);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f261333d = SafeBlowHandler.class.getName();
        }
    }

    protected SafeBlowHandler(AppInterface appInterface) {
        super(appInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appInterface);
        }
    }

    private void D2(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        int resultCode = fromServiceMsg.getResultCode();
        if (QLog.isColorLevel()) {
            QLog.d("SafeBlowHandler", 2, "onReceiverOxefe called with: resultCode = " + resultCode + ", req = " + toServiceMsg + ", res = " + fromServiceMsg);
        }
        if (fromServiceMsg.isSuccess()) {
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg = oidb_sso_oidbssopkg.mergeFrom((byte[]) obj);
            } catch (Exception e16) {
                QLog.d("SafeBlowHandler", 1, "onReceiverOxefe throw e", e16);
            }
            if (oidb_sso_oidbssopkg.uint32_service_type.get() == 4) {
                notifyUI(3838, true, 4);
                return;
            }
            return;
        }
        notifyUI(3838, false, -1);
    }

    public void E2(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, j3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SafeBlowHandler", 2, "sendClickEvtPbReq() called: friendUin = " + j3);
        }
        oidb_cmd0xefe$ReqBody oidb_cmd0xefe_reqbody = new oidb_cmd0xefe$ReqBody();
        oidb_cmd0xefe_reqbody.friend_uin.set(j3);
        sendPbReq(makeOIDBPkg("OidbSvc.0xefe", 3838, 4, oidb_cmd0xefe_reqbody.toByteArray()));
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Class) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return d.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, toServiceMsg, fromServiceMsg, obj);
            return;
        }
        if (fromServiceMsg != null && obj != null) {
            if (TextUtils.equals("OidbSvc.0xefe", fromServiceMsg.getServiceCmd())) {
                D2(toServiceMsg, fromServiceMsg, obj);
            }
        } else {
            QLog.e("SafeBlowHandler", 1, "onReceive params: res = " + fromServiceMsg + ", data = " + obj);
        }
    }
}
