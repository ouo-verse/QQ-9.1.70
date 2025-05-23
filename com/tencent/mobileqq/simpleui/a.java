package com.tencent.mobileqq.simpleui;

import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.util.NormalNightModeUtil;
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

    /* renamed from: a, reason: collision with root package name */
    private boolean f288516a;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f288516a = false;
        }
    }

    private NormalNightModeHandler a() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (peekAppRuntime instanceof QQAppInterface)) {
            BusinessHandler businessHandler = ((QQAppInterface) peekAppRuntime).getBusinessHandler(NormalNightModeHandler.class.getName());
            if (businessHandler != null && (businessHandler instanceof NormalNightModeHandler)) {
                return (NormalNightModeHandler) businessHandler;
            }
            if (QLog.isColorLevel()) {
                QLog.d("NormalNightModeHandlerProcessor", 1, "null == businessHandler || !(businessHandler instanceof NormalNightModeHandler)");
            }
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("NormalNightModeHandlerProcessor", 1, "null == appRuntime || !(appRuntime instanceof QQAppInterface)");
        }
        return null;
    }

    private void b(String str) {
        if (QLog.isColorLevel()) {
            QLog.i("NormalNightModeHandlerProcessor", 2, "setRoamingThemeId themeId: " + str);
        }
        NormalNightModeHandler a16 = a();
        if (a16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("NormalNightModeHandlerProcessor", 1, "setRoamingThemeId normalNightModeHandler == null");
                return;
            }
            return;
        }
        a16.K2(str);
    }

    @Override // com.tencent.relation.common.handler.c
    public oidb_0x5eb$ReqBody get0x5ebReqBody(Bundle bundle, oidb_0x5eb$ReqBody oidb_0x5eb_reqbody) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (oidb_0x5eb$ReqBody) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle, (Object) oidb_0x5eb_reqbody);
        }
        this.f288516a = !NormalNightModeUtil.getNormalNightModeFeatureSwitch();
        if (QLog.isColorLevel()) {
            QLog.d("NormalNightModeHandlerProcessor", 1, "get0x5ebReqBody init mInterruptReq " + this.f288516a);
        }
        if (this.f288516a) {
            return oidb_0x5eb_reqbody;
        }
        b(bundle.getString("theme_id"));
        try {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                oidb_0x5eb_reqbody.rpt_uint64_uins.add(Long.valueOf(Long.parseLong(peekAppRuntime.getCurrentAccountUin())));
            }
        } catch (Exception e16) {
            QLog.d("NormalNightModeHandlerProcessor", 1, "get0x5ebReqBody exception:", e16);
        }
        oidb_0x5eb_reqbody.uint32_simple_ui_switch.set(1);
        oidb_0x5eb_reqbody.uint32_elder_mode_flag.set(1);
        oidb_0x5eb_reqbody.uint32_normal_night_mode_flag.set(1);
        return oidb_0x5eb_reqbody;
    }

    @Override // com.tencent.relation.common.handler.c
    public int getBusinessType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 7;
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
        if (QLog.isColorLevel()) {
            QLog.d("NormalNightModeHandlerProcessor", 1, "onReceive mInterruptReq " + this.f288516a);
        }
        if (this.f288516a) {
            return;
        }
        NormalNightModeHandler a16 = a();
        if (a16 == null) {
            if (QLog.isColorLevel()) {
                QLog.d("NormalNightModeHandlerProcessor", 1, "onReceive normalNightModeHandler == null");
            }
        } else {
            QLog.e("NormalNightModeHandlerProcessor", 1, "invoke handleGetNormalNightModeSwitch method to handle resp");
            a16.E2(toServiceMsg, fromServiceMsg, obj);
        }
    }
}
