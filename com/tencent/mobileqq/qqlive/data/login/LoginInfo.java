package com.tencent.mobileqq.qqlive.data.login;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.config.a;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qqlive.login.LiveLoginInfo;

/* compiled from: P */
@Deprecated
/* loaded from: classes17.dex */
public class LoginInfo {
    static IPatchRedirector $redirector_ = null;
    public static final long LIVE_A2_GAP_EXPIRE_TIME = 259200;
    public static final long QQ_ACCESS_TOKEN_EXPIRE_TIME = 6000;
    public static final long QQ_ACCESS_TOKEN_EXPIRE_TIME_NO_NETWORK = 300;

    /* renamed from: a2, reason: collision with root package name */
    public String f271214a2;
    public long a2ExpireTime;
    public String accessToken;
    public String appId;
    public String businessUid;
    public int clientType;
    public long lastLoginTime;
    public int loginType;
    private final LiveLoginInfo newLoginInfo;
    public String openId;
    public String originUin;
    public long tinyid;
    public long uid;
    public LiveUserInfo userInfo;

    public LoginInfo(LiveLoginInfo liveLoginInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) liveLoginInfo);
            return;
        }
        if (liveLoginInfo != null) {
            LiveUserInfo liveUserInfo = new LiveUserInfo();
            this.userInfo = liveUserInfo;
            liveUserInfo.uid = liveLoginInfo.q();
            this.userInfo.nick = liveLoginInfo.m();
            this.userInfo.headUrl = liveLoginInfo.j();
            this.userInfo.sex = liveLoginInfo.o();
            this.appId = liveLoginInfo.g();
            this.originUin = liveLoginInfo.r();
            this.openId = liveLoginInfo.n();
            this.accessToken = liveLoginInfo.f();
            this.businessUid = liveLoginInfo.k();
            this.tinyid = liveLoginInfo.p();
            this.uid = liveLoginInfo.q();
            this.f271214a2 = liveLoginInfo.c();
            this.a2ExpireTime = liveLoginInfo.e();
            this.lastLoginTime = liveLoginInfo.l();
            this.clientType = a.INSTANCE.a(liveLoginInfo.g()).a().e();
        }
        this.newLoginInfo = liveLoginInfo;
    }

    public boolean isValid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        LiveLoginInfo liveLoginInfo = this.newLoginInfo;
        if (liveLoginInfo != null && liveLoginInfo.t()) {
            return true;
        }
        return false;
    }

    @NonNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "uid=" + this.uid + ", tinyid=" + this.tinyid + ", openid=" + this.openId + ", businessUid=" + this.businessUid;
    }
}
