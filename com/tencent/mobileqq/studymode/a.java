package com.tencent.mobileqq.studymode;

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
public class a implements com.tencent.relation.common.handler.c {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
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
            QLog.d("AlphabeticFont0x5ebHandlerProcessor", 1, "get0x5ebReqBody exception:", e16);
        }
        oidb_0x5eb_reqbody.uint32_alphabetic_font_flag.set(1);
        return oidb_0x5eb_reqbody;
    }

    @Override // com.tencent.relation.common.handler.c
    public int getBusinessType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 4;
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
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (!(peekAppRuntime instanceof QQAppInterface)) {
            QLog.e("AlphabeticFont0x5ebHandlerProcessor", 1, "onReceive failed; getQQAppInterface is not QQAppInterface. app= " + peekAppRuntime);
            return;
        }
        BusinessHandler businessHandler = ((QQAppInterface) peekAppRuntime).getBusinessHandler(BusinessHandlerFactory.TEENS_MODE_ALPHABETIC_FONT_HANDLER);
        if (!(businessHandler instanceof AlphabeticFontHandler)) {
            QLog.e("AlphabeticFont0x5ebHandlerProcessor", 1, "onReceive failed; getHandler is not AlphabeticFontHandler. handler= " + businessHandler);
            return;
        }
        QLog.e("AlphabeticFont0x5ebHandlerProcessor", 1, "invoke handleGetAlphabeticFontStatusToFriendResp method to handle resp");
        ((AlphabeticFontHandler) businessHandler).E2(fromServiceMsg, obj);
    }
}
