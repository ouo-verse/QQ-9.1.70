package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class UserInfo implements Serializable {
    public int countryCode;
    public byte[] encryptUin;
    long serialVersionUID = 1;
    public String account = "";
    public AccountType accountType = AccountType.values()[0];

    public String getAccount() {
        return this.account;
    }

    public AccountType getAccountType() {
        return this.accountType;
    }

    public int getCountryCode() {
        return this.countryCode;
    }

    public byte[] getEncryptUin() {
        return this.encryptUin;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public void setCountryCode(int i3) {
        this.countryCode = i3;
    }

    public void setEncryptUin(byte[] bArr) {
        this.encryptUin = bArr;
    }

    public String toString() {
        return "UserInfo{account=" + this.account + ",accountType=" + this.accountType + ",countryCode=" + this.countryCode + ",encryptUin=" + this.encryptUin + ",}";
    }
}
