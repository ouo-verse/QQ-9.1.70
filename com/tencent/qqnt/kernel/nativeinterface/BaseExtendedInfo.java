package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class BaseExtendedInfo {
    public String address;
    public String city;
    public String college;
    public int constellation;
    public String country;
    public String homeTown;
    public String interest;
    public int kBloodType;
    public ArrayList<String> labels;
    public int makeFriendCareer;
    public String pos;
    public String postCode;
    public String province;
    public QQLevel qqLevel;
    public int regTime;
    public int shengXiao;

    public BaseExtendedInfo() {
        this.homeTown = "";
        this.pos = "";
        this.college = "";
        this.country = "";
        this.province = "";
        this.city = "";
        this.postCode = "";
        this.address = "";
        this.interest = "";
        this.labels = new ArrayList<>();
        this.qqLevel = new QQLevel();
    }

    public String getAddress() {
        return this.address;
    }

    public String getCity() {
        return this.city;
    }

    public String getCollege() {
        return this.college;
    }

    public int getConstellation() {
        return this.constellation;
    }

    public String getCountry() {
        return this.country;
    }

    public String getHomeTown() {
        return this.homeTown;
    }

    public String getInterest() {
        return this.interest;
    }

    public int getKBloodType() {
        return this.kBloodType;
    }

    public ArrayList<String> getLabels() {
        return this.labels;
    }

    public int getMakeFriendCareer() {
        return this.makeFriendCareer;
    }

    public String getPos() {
        return this.pos;
    }

    public String getPostCode() {
        return this.postCode;
    }

    public String getProvince() {
        return this.province;
    }

    public QQLevel getQqLevel() {
        return this.qqLevel;
    }

    public int getRegTime() {
        return this.regTime;
    }

    public int getShengXiao() {
        return this.shengXiao;
    }

    public BaseExtendedInfo(int i3, int i16, int i17, String str, int i18, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i19, String str9, ArrayList<String> arrayList, QQLevel qQLevel) {
        this.homeTown = "";
        this.pos = "";
        this.college = "";
        this.country = "";
        this.province = "";
        this.city = "";
        this.postCode = "";
        this.address = "";
        this.interest = "";
        this.labels = new ArrayList<>();
        new QQLevel();
        this.constellation = i3;
        this.shengXiao = i16;
        this.kBloodType = i17;
        this.homeTown = str;
        this.makeFriendCareer = i18;
        this.pos = str2;
        this.college = str3;
        this.country = str4;
        this.province = str5;
        this.city = str6;
        this.postCode = str7;
        this.address = str8;
        this.regTime = i19;
        this.interest = str9;
        this.labels = arrayList;
        this.qqLevel = qQLevel;
    }
}
