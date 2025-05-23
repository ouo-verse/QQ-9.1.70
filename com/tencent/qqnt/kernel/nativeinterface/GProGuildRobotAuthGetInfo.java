package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildRobotAuthGetInfo {
    public String className;
    public String desc;
    public int flag;

    /* renamed from: id, reason: collision with root package name */
    public int f359171id;
    public String method;
    public String name;
    public int needAdmin;
    public String title;

    public GProGuildRobotAuthGetInfo() {
        this.title = "";
        this.desc = "";
        this.className = "";
        this.name = "";
        this.method = "";
    }

    public String getClassName() {
        return this.className;
    }

    public String getDesc() {
        return this.desc;
    }

    public int getFlag() {
        return this.flag;
    }

    public int getId() {
        return this.f359171id;
    }

    public String getMethod() {
        return this.method;
    }

    public String getName() {
        return this.name;
    }

    public int getNeedAdmin() {
        return this.needAdmin;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProGuildRobotAuthGetInfo{id=" + this.f359171id + ",title=" + this.title + ",flag=" + this.flag + ",needAdmin=" + this.needAdmin + ",desc=" + this.desc + ",className=" + this.className + ",name=" + this.name + ",method=" + this.method + ",}";
    }

    public GProGuildRobotAuthGetInfo(int i3, String str, int i16, int i17, String str2, String str3, String str4, String str5) {
        this.f359171id = i3;
        this.title = str;
        this.flag = i16;
        this.needAdmin = i17;
        this.desc = str2;
        this.className = str3;
        this.name = str4;
        this.method = str5;
    }
}
