package com.tencent.mobileqq.loginregister.servlet.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.loginregister.servlet.IRegisterServletService;
import com.tencent.mobileqq.loginregister.servlet.d;
import com.tencent.mobileqq.loginregister.servlet.e;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.BaseConstants;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
/* loaded from: classes15.dex */
public class RegisterServletServiceImpl implements IRegisterServletService {
    static IPatchRedirector $redirector_;
    private AppRuntime app;

    public RegisterServletServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.IRegisterServletService
    public void checkPhoneNumGatewayRegisterAccount(String str, Long l3, String str2, d dVar, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, str, l3, str2, dVar, bundle);
            return;
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), e.class);
        newIntent.putExtra("action", 2217);
        newIntent.putExtra(BaseConstants.ATTR_KET_PHONE_TOKEN, str);
        newIntent.putExtra("appid", l3);
        newIntent.putExtra("appVersion", str2);
        newIntent.setObserver(dVar);
        if (bundle != null) {
            newIntent.putExtras(bundle);
        }
        newIntent.withouLogin = true;
        this.app.startServlet(newIntent);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
        } else {
            this.app = appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.IRegisterServletService
    public void queryUpSmsStat(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) dVar);
            return;
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), e.class);
        newIntent.putExtra("action", 1022);
        newIntent.setObserver(dVar);
        newIntent.withouLogin = true;
        this.app.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.IRegisterServletService
    public void sendRegisterByCommitSmsVerifyCode(String str, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) dVar);
            return;
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), e.class);
        newIntent.putExtra("action", 1004);
        newIntent.putExtra("code", str);
        newIntent.setObserver(dVar);
        newIntent.withouLogin = true;
        this.app.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.IRegisterServletService
    public void sendRegisterByPhoneNumber(String str, byte b16, String str2, String str3, String str4, Long l3, String str5, Bundle bundle, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Byte.valueOf(b16), str2, str3, str4, l3, str5, bundle, dVar);
            return;
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), e.class);
        newIntent.putExtra("action", 1003);
        newIntent.putExtra("countryCode", str2);
        newIntent.putExtra(MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER, str3);
        newIntent.putExtra(IjkMediaMeta.IJKM_KEY_LANGUAGE, b16);
        newIntent.putExtra("appid", l3);
        newIntent.putExtra("verifySig", str);
        newIntent.putExtra("appVersion", str5);
        if (!TextUtils.isEmpty(str4)) {
            newIntent.putExtra("inviteCode", str4);
        }
        newIntent.putExtras(bundle);
        newIntent.withouLogin = true;
        newIntent.setObserver(dVar);
        this.app.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.IRegisterServletService
    public void sendRegisterByResendSms(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) dVar);
            return;
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), e.class);
        newIntent.putExtra("action", 1020);
        newIntent.withouLogin = true;
        newIntent.setObserver(dVar);
        this.app.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.IRegisterServletService
    public void sendRegisterBySetPass(String str, String str2, String str3, String str4, boolean z16, String str5, Bundle bundle, String str6, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, str, str2, str3, str4, Boolean.valueOf(z16), str5, bundle, str6, dVar);
            return;
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), e.class);
        newIntent.putExtra("action", 1005);
        newIntent.putExtra(NotificationActivity.PASSWORD, str);
        newIntent.putExtra("nick", str2);
        newIntent.putExtra("code", str3);
        newIntent.putExtra("bindMobile", z16);
        if (!TextUtils.isEmpty(str4)) {
            newIntent.putExtra("unBindlhUin", str4);
        }
        newIntent.putExtra("appVersion", str5);
        if (bundle != null) {
            newIntent.putExtras(bundle);
        }
        if (!TextUtils.isEmpty(str6)) {
            newIntent.putExtra("profileSig", str6);
        }
        newIntent.setObserver(dVar);
        newIntent.withouLogin = true;
        this.app.startServlet(newIntent);
    }

    @Override // com.tencent.mobileqq.loginregister.servlet.IRegisterServletService
    public void sendRegisterBySetPassWithLH(String str, String str2, String str3, String str4, boolean z16, String str5, Bundle bundle, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, str2, str3, str4, Boolean.valueOf(z16), str5, bundle, dVar);
            return;
        }
        NewIntent newIntent = new NewIntent(this.app.getApplication(), e.class);
        newIntent.putExtra("action", 1005);
        newIntent.putExtra(NotificationActivity.PASSWORD, str);
        newIntent.putExtra("nick", str2);
        newIntent.putExtra("code", str3);
        newIntent.putExtra("bindMobile", z16);
        newIntent.putExtra("lhuin", str4);
        newIntent.putExtra("appVersion", str5);
        if (bundle != null) {
            newIntent.putExtras(bundle);
        }
        newIntent.setObserver(dVar);
        newIntent.withouLogin = true;
        this.app.startServlet(newIntent);
    }
}
