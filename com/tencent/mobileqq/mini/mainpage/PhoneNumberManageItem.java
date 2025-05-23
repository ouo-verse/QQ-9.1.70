package com.tencent.mobileqq.mini.mainpage;

import java.io.Serializable;

/* loaded from: classes33.dex */
public class PhoneNumberManageItem implements Serializable {
    private String countryCode;
    private String encryptedData;
    private boolean isEditState;
    private int itemType;

    /* renamed from: iv, reason: collision with root package name */
    private String f246635iv;
    private String phoneNumberID;
    private int phoneType;
    private String purePhoneNumber;

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getEncryptedData() {
        return this.encryptedData;
    }

    public int getItemType() {
        return this.itemType;
    }

    public String getIv() {
        return this.f246635iv;
    }

    public String getPhoneNumberID() {
        return this.phoneNumberID;
    }

    public int getPhoneType() {
        return this.phoneType;
    }

    public String getPurePhoneNumber() {
        return this.purePhoneNumber;
    }

    public boolean isEditState() {
        return this.isEditState;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public void setEditState(boolean z16) {
        this.isEditState = z16;
    }

    public void setEncryptedData(String str) {
        this.encryptedData = str;
    }

    public void setItemType(int i3) {
        this.itemType = i3;
    }

    public void setIv(String str) {
        this.f246635iv = str;
    }

    public void setPhoneNumberID(String str) {
        this.phoneNumberID = str;
    }

    public void setPhoneType(int i3) {
        this.phoneType = i3;
    }

    public void setPurePhoneNumber(String str) {
        this.purePhoneNumber = str;
    }
}
