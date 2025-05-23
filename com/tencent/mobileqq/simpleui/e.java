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
public class e implements com.tencent.relation.common.handler.c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private boolean f288517a;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f288517a = false;
        }
    }

    @Override // com.tencent.relation.common.handler.c
    public oidb_0x5eb$ReqBody get0x5ebReqBody(Bundle bundle, oidb_0x5eb$ReqBody oidb_0x5eb_reqbody) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (oidb_0x5eb$ReqBody) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle, (Object) oidb_0x5eb_reqbody);
        }
        int i3 = bundle.getInt("simple_open");
        int i16 = bundle.getInt("study_switch");
        int i17 = bundle.getInt("kid_switch");
        if (i3 == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (i16 == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (i17 == 1) {
            z18 = true;
        } else {
            z18 = false;
        }
        boolean z26 = z18 | z17;
        if (z26 && z16) {
            z16 = false;
        }
        if (!z16 && !z26) {
            z19 = true;
        } else {
            z19 = false;
        }
        this.f288517a = z19;
        if (QLog.isColorLevel()) {
            QLog.i("SimpleUIHandlerProcessor", 1, String.format("get0x5ebReqBody   isSimpleOpen\uff1a%b retKidOpen:%b mNotInterruptRsp: %b", Boolean.valueOf(z16), Boolean.valueOf(z26), Boolean.valueOf(this.f288517a)));
        }
        if (this.f288517a) {
            oidb_0x5eb_reqbody.uint32_simple_ui_switch.set(1);
            oidb_0x5eb_reqbody.uint32_simple_ui_pref.set(1);
            oidb_0x5eb_reqbody.uint32_flag_study_mode_switch.set(1);
            oidb_0x5eb_reqbody.uint32_elder_mode_flag.set(1);
            oidb_0x5eb_reqbody.uint32_flag_kid_mode_switch.set(1);
        }
        return oidb_0x5eb_reqbody;
    }

    @Override // com.tencent.relation.common.handler.c
    public int getBusinessType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 1;
    }

    @Override // com.tencent.relation.common.handler.c
    public Bundle getRequestExtraData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Bundle) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        if (QLog.isColorLevel()) {
            QLog.i("SimpleUIHandlerProcessor", 1, String.format("getRequestExtraData   mNotInterruptRsp: %b", Boolean.valueOf(this.f288517a)));
        }
        if (this.f288517a) {
            Bundle bundle = new Bundle();
            bundle.putBoolean("uint32_flag_color_note_recent_switch", true);
            return bundle;
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
        if (peekAppRuntime != null && (peekAppRuntime instanceof QQAppInterface) && this.f288517a) {
            BusinessHandler businessHandler = ((QQAppInterface) peekAppRuntime).getBusinessHandler(BusinessHandlerFactory.SIMPLE_UI_HANDLER);
            if (businessHandler != null && (businessHandler instanceof SimpleUIHandler)) {
                ((SimpleUIHandler) businessHandler).S2(toServiceMsg, fromServiceMsg, obj);
                return;
            } else {
                if (QLog.isColorLevel()) {
                    QLog.d("SimpleUIHandlerProcessor", 1, "onReceive  null == businessHandler || !(businessHandler instanceof SimpleUIHandler)");
                    return;
                }
                return;
            }
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("onReceive  null == appRuntime || !(appRuntime instanceof QQAppInterface) || !mNotInterruptRsp ==");
            sb5.append(!this.f288517a);
            QLog.d("SimpleUIHandlerProcessor", 1, sb5.toString());
        }
    }
}
