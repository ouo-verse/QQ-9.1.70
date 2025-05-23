package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ReportHandler extends BusinessHandler {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static String f195002e;

    /* renamed from: f, reason: collision with root package name */
    public static String f195003f;

    /* renamed from: d, reason: collision with root package name */
    private String f195004d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(69922);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f195002e = "Add_friend_to_desktop|";
            f195003f = "Click_desktop_friend|";
        }
    }

    ReportHandler(QQAppInterface qQAppInterface) {
        super(qQAppInterface);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qQAppInterface);
        } else {
            this.f195004d = "FuMeiTiCeSu|";
        }
    }

    public static String D2(String str, String str2, String str3, String str4) {
        return "PLUG|" + str + "|" + str2 + "|internal|" + str3 + "|PB|" + str4 + "||";
    }

    public void E2(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
        } else if (bundle != null && bundle.containsKey("data")) {
            ToServiceMsg createToServiceMsg = createToServiceMsg(BaseConstants.CMD_REPORTSTAT);
            createToServiceMsg.extraData.putAll(bundle);
            super.send(createToServiceMsg);
        }
    }

    public void F2(String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) strArr);
            return;
        }
        ToServiceMsg createToServiceMsg = createToServiceMsg(BaseConstants.CMD_REPORTSTAT);
        createToServiceMsg.extraData.putStringArray("data", strArr);
        super.send(createToServiceMsg);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, toServiceMsg, fromServiceMsg, obj);
        }
    }
}
