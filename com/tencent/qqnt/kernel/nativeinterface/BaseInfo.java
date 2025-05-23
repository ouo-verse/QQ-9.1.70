package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class BaseInfo implements Serializable {
    public int age;
    public int birthdayDay;
    public int birthdayMonth;
    public int birthdayYear;
    public int categoryId;
    public String eMail;
    public String longNick;
    public String phoneNum;
    public String qid;
    public byte[] richBuffer;
    public int richTime;
    long serialVersionUID;
    public int sex;

    public BaseInfo() {
        this.serialVersionUID = 1L;
        this.qid = "";
        this.longNick = "";
        this.eMail = "";
        this.phoneNum = "";
        this.richBuffer = new byte[0];
    }

    public int getAge() {
        return this.age;
    }

    public int getBirthdayDay() {
        return this.birthdayDay;
    }

    public int getBirthdayMonth() {
        return this.birthdayMonth;
    }

    public int getBirthdayYear() {
        return this.birthdayYear;
    }

    public int getCategoryId() {
        return this.categoryId;
    }

    public String getEMail() {
        return this.eMail;
    }

    public String getLongNick() {
        return this.longNick;
    }

    public String getPhoneNum() {
        return this.phoneNum;
    }

    public String getQid() {
        return this.qid;
    }

    public byte[] getRichBuffer() {
        return this.richBuffer;
    }

    public int getRichTime() {
        return this.richTime;
    }

    public int getSex() {
        return this.sex;
    }

    public BaseInfo(String str, String str2, int i3, int i16, int i17, int i18, int i19, String str3, String str4, int i26, int i27, byte[] bArr) {
        this.serialVersionUID = 1L;
        this.qid = str;
        this.longNick = str2;
        this.birthdayYear = i3;
        this.birthdayMonth = i16;
        this.birthdayDay = i17;
        this.age = i18;
        this.sex = i19;
        this.eMail = str3;
        this.phoneNum = str4;
        this.categoryId = i26;
        this.richTime = i27;
        this.richBuffer = bArr;
    }
}
