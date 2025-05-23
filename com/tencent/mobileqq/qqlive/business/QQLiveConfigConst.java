package com.tencent.mobileqq.qqlive.business;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;

/* compiled from: P */
@Deprecated
/* loaded from: classes17.dex */
public class QQLiveConfigConst {
    static IPatchRedirector $redirector_ = null;
    public static final String APP_ID;
    public static final String APP_KEY;
    public static final int CLIENT_TYPE;
    public static final String KAIYANG_VERIFY_URL = "https://accounts.qq.com/kaiyang/sms?_wv=3&appid=101956380";
    public static final String LOGIN_AUTH_APPID;
    public static final String LOGIN_EXT_DATA;
    public static final String OPEN_SDK_APP_ID;
    public static final int PULL_MSG_CLIENT_TYPE;
    public static final String SMART_EYE_APP_ID = "";
    public static final String TRTC_SDK_APP_ID;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51978);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        QQLiveBusinessConfig qQLiveBusinessConfig = QQLiveBusinessConfig.f271165b;
        APP_ID = qQLiveBusinessConfig.a().c();
        LOGIN_EXT_DATA = qQLiveBusinessConfig.a().g();
        LOGIN_AUTH_APPID = qQLiveBusinessConfig.a().f();
        APP_KEY = qQLiveBusinessConfig.a().d();
        CLIENT_TYPE = qQLiveBusinessConfig.a().e();
        PULL_MSG_CLIENT_TYPE = qQLiveBusinessConfig.a().i();
        OPEN_SDK_APP_ID = qQLiveBusinessConfig.a().h();
        TRTC_SDK_APP_ID = qQLiveBusinessConfig.a().j();
    }

    public QQLiveConfigConst() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
