package com.tencent.mobileqq.qqlive.sso;

import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.login.IQQLiveModuleLogin;
import com.tencent.mobileqq.qqlive.data.config.ConfigData;
import com.tencent.mobileqq.qqlive.data.config.QQLiveSDKConfig;
import com.tencent.mobileqq.qqlive.data.login.LoginInfo;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.util.QQDeviceInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public class i implements b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private IQQLiveModuleLogin f273211a;

    /* renamed from: b, reason: collision with root package name */
    private QQLiveSDKConfig f273212b;

    /* renamed from: c, reason: collision with root package name */
    private ConfigData f273213c;

    public i(IQQLiveModuleLogin iQQLiveModuleLogin, QQLiveSDKConfig qQLiveSDKConfig, ConfigData configData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, iQQLiveModuleLogin, qQLiveSDKConfig, configData);
            return;
        }
        this.f273211a = iQQLiveModuleLogin;
        this.f273212b = qQLiveSDKConfig;
        this.f273213c = configData;
    }

    @Override // com.tencent.mobileqq.qqlive.sso.b
    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        LoginInfo loginInfo = this.f273211a.getLoginInfo();
        if (loginInfo == null) {
            return "";
        }
        return loginInfo.accessToken;
    }

    @Override // com.tencent.mobileqq.qqlive.sso.b
    public int b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        int pullMsgClientType = this.f273213c.getPullMsgClientType();
        if (pullMsgClientType == -1) {
            return getPlatform();
        }
        return pullMsgClientType;
    }

    @Override // com.tencent.mobileqq.qqlive.sso.b
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        LoginInfo loginInfo = this.f273211a.getLoginInfo();
        if (loginInfo == null) {
            return "";
        }
        return loginInfo.f271214a2;
    }

    @Override // com.tencent.mobileqq.qqlive.sso.b
    public Boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Boolean) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return Boolean.FALSE;
    }

    @Override // com.tencent.mobileqq.qqlive.sso.b
    public String getClientId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        String qimei = QQDeviceInfo.getQIMEI();
        if (TextUtils.isEmpty(qimei)) {
            return com.tencent.mobileqq.qqlive.utils.e.a();
        }
        return qimei;
    }

    @Override // com.tencent.mobileqq.qqlive.sso.b
    public int getLoginType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        LoginInfo loginInfo = this.f273211a.getLoginInfo();
        if (loginInfo == null) {
            return 1;
        }
        return loginInfo.loginType;
    }

    @Override // com.tencent.mobileqq.qqlive.sso.b
    public String getOpenId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        LoginInfo loginInfo = this.f273211a.getLoginInfo();
        if (loginInfo == null) {
            return "";
        }
        return loginInfo.openId;
    }

    @Override // com.tencent.mobileqq.qqlive.sso.b
    public int getPlatform() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f273213c.getLiveClientType();
    }

    @Override // com.tencent.mobileqq.qqlive.sso.b
    public int getStreamType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.qqlive.sso.b
    public long getTinyId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Long) iPatchRedirector.redirect((short) 3, (Object) this)).longValue();
        }
        LoginInfo loginInfo = this.f273211a.getLoginInfo();
        if (loginInfo == null) {
            return 0L;
        }
        return loginInfo.tinyid;
    }

    @Override // com.tencent.mobileqq.qqlive.sso.b
    public long getUid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        LoginInfo loginInfo = this.f273211a.getLoginInfo();
        if (loginInfo == null) {
            return 0L;
        }
        return loginInfo.uid;
    }

    @Override // com.tencent.mobileqq.qqlive.sso.b
    public String getVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        String str = AppSetting.f99551k;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    @Override // com.tencent.mobileqq.qqlive.sso.b
    public int getVersionCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return TVKEventId.PLAYER_STATE_SWITCHDEF_START;
    }
}
