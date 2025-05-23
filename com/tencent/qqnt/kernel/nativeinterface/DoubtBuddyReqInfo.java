package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class DoubtBuddyReqInfo {
    public int age;
    public int commFriendNum;
    public Long groupCode;

    /* renamed from: msg, reason: collision with root package name */
    public String f359166msg;
    public String nameMore;
    public String nick;
    public String reason;
    public long reqTime;
    public int sex;
    public String source;
    public String uid;

    public DoubtBuddyReqInfo() {
        this.uid = "";
        this.nick = "";
        this.f359166msg = "";
        this.source = "";
        this.reason = "";
    }

    public int getAge() {
        return this.age;
    }

    public int getCommFriendNum() {
        return this.commFriendNum;
    }

    public Long getGroupCode() {
        return this.groupCode;
    }

    public String getMsg() {
        return this.f359166msg;
    }

    public String getNameMore() {
        return this.nameMore;
    }

    public String getNick() {
        return this.nick;
    }

    public String getReason() {
        return this.reason;
    }

    public long getReqTime() {
        return this.reqTime;
    }

    public int getSex() {
        return this.sex;
    }

    public String getSource() {
        return this.source;
    }

    public String getUid() {
        return this.uid;
    }

    public DoubtBuddyReqInfo(String str, String str2, int i3, int i16, int i17, long j3, String str3, String str4, String str5, Long l3, String str6) {
        this.uid = str;
        this.nick = str2;
        this.age = i3;
        this.sex = i16;
        this.commFriendNum = i17;
        this.reqTime = j3;
        this.f359166msg = str3;
        this.source = str4;
        this.reason = str5;
        this.groupCode = l3;
        this.nameMore = str6;
    }
}
