package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class BuddySetting {
    public int addFriendSetting;
    public String buddyUid;
    public long buddyUin;
    public boolean isContactFriend;
    public String phoneNumber;
    public ArrayList<String> question;

    public BuddySetting() {
        this.buddyUid = "";
        this.phoneNumber = "";
        this.question = new ArrayList<>();
    }

    public int getAddFriendSetting() {
        return this.addFriendSetting;
    }

    public String getBuddyUid() {
        return this.buddyUid;
    }

    public long getBuddyUin() {
        return this.buddyUin;
    }

    public boolean getIsContactFriend() {
        return this.isContactFriend;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public ArrayList<String> getQuestion() {
        return this.question;
    }

    public BuddySetting(String str, long j3, String str2, int i3, ArrayList<String> arrayList, boolean z16) {
        this.buddyUid = "";
        this.phoneNumber = "";
        new ArrayList();
        this.buddyUid = str;
        this.buddyUin = j3;
        this.phoneNumber = str2;
        this.addFriendSetting = i3;
        this.question = arrayList;
        this.isContactFriend = z16;
    }
}
