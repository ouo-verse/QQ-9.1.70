package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes23.dex */
public class LoginInfo implements Parcelable {
    public static final Parcelable.Creator<LoginInfo> CREATOR = new Parcelable.Creator<LoginInfo>() { // from class: com.tencent.qqmini.sdk.launcher.model.LoginInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LoginInfo createFromParcel(Parcel parcel) {
            LoginInfo loginInfo = new LoginInfo();
            loginInfo.loginType = parcel.readInt();
            loginInfo.account = parcel.readString();
            loginInfo.nickName = parcel.readString();
            loginInfo.payOpenId = parcel.readString();
            loginInfo.payOpenKey = parcel.readString();
            loginInfo.payAccessToken = parcel.readString();
            loginInfo.loginSig = parcel.createByteArray();
            loginInfo.platformId = parcel.readString();
            loginInfo.appId = parcel.readString();
            return loginInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public LoginInfo[] newArray(int i3) {
            return new LoginInfo[i3];
        }
    };
    private String account;
    private String appId;
    private byte[] loginSig;
    private int loginType;
    private String nickName;
    private String payAccessToken;
    private String payOpenId;
    private String payOpenKey;
    private String platformId;

    public LoginInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAccount() {
        return this.account;
    }

    public String getAppId() {
        return this.appId;
    }

    public byte[] getLoginSig() {
        return this.loginSig;
    }

    public int getLoginType() {
        return this.loginType;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getPayAccessToken() {
        return this.payAccessToken;
    }

    public String getPayOpenId() {
        return this.payOpenId;
    }

    public String getPayOpenKey() {
        return this.payOpenKey;
    }

    public String getPlatformId() {
        return this.platformId;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public void setLoginSig(byte[] bArr) {
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length];
            this.loginSig = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
    }

    public void setLoginType(int i3) {
        this.loginType = i3;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setPayAccessToken(String str) {
        this.payAccessToken = str;
    }

    public void setPayOpenId(String str) {
        this.payOpenId = str;
    }

    public void setPayOpenKey(String str) {
        this.payOpenKey = str;
    }

    public void setPlatformId(String str) {
        this.platformId = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.loginType);
        parcel.writeString(this.account);
        parcel.writeString(this.nickName);
        parcel.writeString(this.payOpenId);
        parcel.writeString(this.payOpenKey);
        parcel.writeString(this.payAccessToken);
        parcel.writeByteArray(this.loginSig);
        parcel.writeString(this.platformId);
        parcel.writeString(this.appId);
    }

    public LoginInfo(int i3, String str, String str2, String str3, String str4, String str5, byte[] bArr, String str6, String str7) {
        this.loginType = i3;
        this.account = str;
        this.nickName = str2;
        this.payOpenId = str3;
        this.payOpenKey = str4;
        this.payAccessToken = str5;
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length];
            this.loginSig = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
        this.payOpenId = str3;
        this.appId = str7;
    }
}
