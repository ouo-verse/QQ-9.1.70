package com.tencent.mobileqq.icgame.data.login;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.icgame.login.LiveLoginInfo;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import d32.a;

/* compiled from: P */
@Deprecated
/* loaded from: classes15.dex */
public class LoginInfo {
    public static final long LIVE_A2_GAP_EXPIRE_TIME = 259200;
    public static final long QQ_ACCESS_TOKEN_EXPIRE_TIME = 6000;
    public static final long QQ_ACCESS_TOKEN_EXPIRE_TIME_NO_NETWORK = 300;

    /* renamed from: a2, reason: collision with root package name */
    public String f237263a2;
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
        if (liveLoginInfo != null) {
            LiveUserInfo liveUserInfo = new LiveUserInfo();
            this.userInfo = liveUserInfo;
            liveUserInfo.uid = liveLoginInfo.getUid();
            this.userInfo.nick = liveLoginInfo.getNickname();
            this.userInfo.headUrl = liveLoginInfo.getAvatarUrl();
            this.userInfo.sex = liveLoginInfo.getSex();
            this.appId = liveLoginInfo.getAppId();
            this.originUin = liveLoginInfo.getUin();
            this.openId = liveLoginInfo.getOpenId();
            this.accessToken = liveLoginInfo.getAccessToken();
            this.businessUid = liveLoginInfo.getBusinessUid();
            this.tinyid = liveLoginInfo.getTinyId();
            this.uid = liveLoginInfo.getUid();
            this.f237263a2 = liveLoginInfo.getA2();
            this.a2ExpireTime = liveLoginInfo.getA2ExpireTime();
            this.lastLoginTime = liveLoginInfo.getLoginTime();
            this.clientType = a.INSTANCE.a(liveLoginInfo.getAppId()).a().getClientType();
        }
        this.newLoginInfo = liveLoginInfo;
    }

    public boolean isValid() {
        LiveLoginInfo liveLoginInfo = this.newLoginInfo;
        if (liveLoginInfo != null && liveLoginInfo.u()) {
            return true;
        }
        return false;
    }

    @NonNull
    public String toString() {
        return "uid=" + this.uid + ", tinyid=" + this.tinyid + ", openid=" + this.openId + ", businessUid=" + this.businessUid;
    }
}
