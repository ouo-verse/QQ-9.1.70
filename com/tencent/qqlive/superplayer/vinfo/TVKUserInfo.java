package com.tencent.qqlive.superplayer.vinfo;

import android.text.TextUtils;
import java.io.Serializable;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class TVKUserInfo implements Serializable {
    public static final int LOGIN_TYPE_OTHERS = 1;
    public static final int LOGIN_TYPE_QQ = 2;
    public static final int LOGIN_TYPE_WX = 3;
    public static final int VIP_TYPE_NONE = 1;
    public static final int VIP_TYPE_SUPPLEMENT_CARD = 3;
    public static final int VIP_TYPE_TENCENT_VIDEO = 2;
    private static final long serialVersionUID = 4925138540725095302L;
    private String mAccessToken;
    private Map<String, String> mCDNHttpHeader;
    private boolean mIsVip;
    private String mLoginCookie;

    @LoginType
    private int mLoginType;
    private String mOAuthConsumerKey;
    private String mOpenId;
    private String mPf;
    private String mUin;
    private String mVUserId;

    @VipType
    private int mVipType;
    private String mWXOpenID;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public @interface LoginType {
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public @interface VipType {
    }

    public TVKUserInfo(String str, String str2) {
        this.mUin = str;
        this.mLoginCookie = str2;
        this.mIsVip = false;
        this.mVipType = 1;
        this.mWXOpenID = "";
        this.mLoginType = 1;
    }

    public String getAccessToken() {
        return this.mAccessToken;
    }

    public Map<String, String> getCdnHttpHeader() {
        return this.mCDNHttpHeader;
    }

    public String getLoginCookie() {
        return this.mLoginCookie;
    }

    public int getLoginType() {
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

    public int getVipType() {
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

    public void setCdnHttpHeader(Map<String, String> map) {
        this.mCDNHttpHeader = map;
    }

    public void setLoginCookie(String str) {
        this.mLoginCookie = str;
    }

    public void setLoginType(@LoginType int i3) {
        this.mLoginType = i3;
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
            this.mVipType = 2;
        }
    }

    public void setVipType(@VipType int i3) {
        this.mVipType = i3;
    }

    public TVKUserInfo() {
        this.mUin = "";
        this.mLoginCookie = "";
        this.mIsVip = false;
        this.mVipType = 1;
        this.mWXOpenID = "";
        this.mLoginType = 1;
    }
}
