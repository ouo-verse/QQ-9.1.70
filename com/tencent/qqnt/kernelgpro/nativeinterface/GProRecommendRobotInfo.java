package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProRecommendRobotInfo implements Serializable {
    public String avatar;
    public String desc;
    public ArrayList<String> introduceList;
    public String name;
    public long robotUin;
    long serialVersionUID;

    public GProRecommendRobotInfo() {
        this.serialVersionUID = 1L;
        this.name = "";
        this.desc = "";
        this.avatar = "";
        this.introduceList = new ArrayList<>();
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getDesc() {
        return this.desc;
    }

    public ArrayList<String> getIntroduceList() {
        return this.introduceList;
    }

    public String getName() {
        return this.name;
    }

    public long getRobotUin() {
        return this.robotUin;
    }

    public String toString() {
        return "GProRecommendRobotInfo{name=" + this.name + ",desc=" + this.desc + ",avatar=" + this.avatar + ",introduceList=" + this.introduceList + ",robotUin=" + this.robotUin + ",}";
    }

    public GProRecommendRobotInfo(String str, String str2, String str3, ArrayList<String> arrayList, long j3) {
        this.serialVersionUID = 1L;
        this.name = "";
        this.desc = "";
        this.avatar = "";
        new ArrayList();
        this.name = str;
        this.desc = str2;
        this.avatar = str3;
        this.introduceList = arrayList;
        this.robotUin = j3;
    }
}
