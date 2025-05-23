package com.tencent.mobileqq.simpleui;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$RspBody;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d implements com.tencent.relation.common.handler.c {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private SimpleUIHandler a() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (peekAppRuntime instanceof QQAppInterface)) {
            BusinessHandler businessHandler = ((QQAppInterface) peekAppRuntime).getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER);
            if (businessHandler != null && (businessHandler instanceof SimpleUIHandler)) {
                return (SimpleUIHandler) businessHandler;
            }
            if (QLog.isColorLevel()) {
                QLog.d("SimpleUIExpLebaFrameModeHandlerProcessor", 1, "null == businessHandler || !(businessHandler instanceof SimpleUIHandler)");
            }
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SimpleUIExpLebaFrameModeHandlerProcessor", 1, "null == appRuntime || !(appRuntime instanceof QQAppInterface)");
        }
        return null;
    }

    @Override // com.tencent.relation.common.handler.c
    public oidb_0x5eb$ReqBody get0x5ebReqBody(Bundle bundle, oidb_0x5eb$ReqBody oidb_0x5eb_reqbody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (oidb_0x5eb$ReqBody) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle, (Object) oidb_0x5eb_reqbody);
        }
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                oidb_0x5eb_reqbody.rpt_uint64_uins.add(Long.valueOf(Long.parseLong(peekAppRuntime.getCurrentAccountUin())));
            }
        } catch (Exception e16) {
            QLog.d("SimpleUIExpLebaFrameModeHandlerProcessor", 1, "get0x5ebReqBody exception:", e16);
        }
        oidb_0x5eb_reqbody.unit32_concise_mode_flag.set(1);
        return oidb_0x5eb_reqbody;
    }

    @Override // com.tencent.relation.common.handler.c
    public int getBusinessType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 6;
    }

    @Override // com.tencent.relation.common.handler.c
    public Bundle getRequestExtraData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bundle) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.relation.common.handler.c
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj, oidb_0x5eb$RspBody oidb_0x5eb_rspbody, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, toServiceMsg, fromServiceMsg, obj, oidb_0x5eb_rspbody, Boolean.valueOf(z16));
            return;
        }
        SimpleUIHandler a16 = a();
        if (a16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("SimpleUIExpLebaFrameModeHandlerProcessor", 1, "onReceive simpleUIHandler == null");
            }
        } else {
            QLog.e("SimpleUIExpLebaFrameModeHandlerProcessor", 1, "invoke handleReqGetSimpleUIExpLebaFrameMode method to handle resp");
            a16.R2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
