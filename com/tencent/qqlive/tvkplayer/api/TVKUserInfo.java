package com.tencent.qqlive.tvkplayer.api;

import android.text.TextUtils;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKUserInfo implements Serializable {
    private static final long serialVersionUID = 4925138540725095302L;
    private String mAccessToken;
    private boolean mIsVip;
    private String mLoginCookie;
    private LoginType mLoginType;
    private String mOAuthConsumerKey;
    private String mOpenId;
    private String mPf;
    private String mUin;
    private String mVUserId;
    private VipType mVipType;
    private String mWXOpenID;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public enum LoginType {
        OTHERS,
        LOGIN_QQ,
        LOGIN_WX
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public enum VipType {
        NONE,
        VIP,
        SUPPLEMENT_CARD,
        VVIP
    }

    public TVKUserInfo(String str, String str2) {
        this.mUin = str;
        this.mLoginCookie = str2;
        this.mIsVip = false;
        this.mVipType = VipType.NONE;
        this.mWXOpenID = "";
        this.mLoginType = LoginType.OTHERS;
    }

    public String getAccessToken() {
        return this.mAccessToken;
    }

    public String getLoginCookie() {
        return this.mLoginCookie;
    }

    public LoginType getLoginType() {
        return this.mLoginType;
    }

    public String getOauthConsumeKey() {
        return this.mOAuthConsumerKey;
    }

    public String getOpenId() {
        return this.mOpenId;
    }

    public String getPf() {
        return this.mPf;
    }

    public String getUin() {
        if (TextUtils.isEmpty(this.mUin)) {
            return "";
        }
        return this.mUin;
    }

    public String getVUserId() {
        return this.mVUserId;
    }

    public VipType getVipType() {
        return this.mVipType;
    }

    public String getWxOpenID() {
        if (TextUtils.isEmpty(this.mWXOpenID)) {
            return "";
        }
        return this.mWXOpenID;
    }

    public boolean isVip() {
        return this.mIsVip;
    }

    public void setLoginCookie(String str) {
        this.mLoginCookie = str;
    }

    public void setLoginType(LoginType loginType) {
        this.mLoginType = loginType;
    }

    public void setOpenApi(String str, String str2, String str3, String str4) {
        this.mOpenId = str;
        this.mAccessToken = str2;
        this.mOAuthConsumerKey = str3;
        this.mPf = str4;
    }

    public void setUin(String str) {
        this.mUin = str;
    }

    public void setVUserId(String str) {
        this.mVUserId = str;
    }

    public void setVip(boolean z16) {
        this.mIsVip = z16;
        if (z16) {
            this.mVipType = VipType.VIP;
        }
    }

    public void setVipType(VipType vipType) {
        this.mVipType = vipType;
    }

    public void setWxOpenID(String str) {
        this.mWXOpenID = str;
    }

    public TVKUserInfo() {
        this.mUin = "";
        this.mLoginCookie = "";
        this.mIsVip = false;
        this.mVipType = VipType.NONE;
        this.mWXOpenID = "";
        this.mLoginType = LoginType.OTHERS;
    }
}
