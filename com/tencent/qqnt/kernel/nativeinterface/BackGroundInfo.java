package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class BackGroundInfo implements IKernelModel {
    public int c2cUnreadCnt;
    public int contactUnreadCnt;
    public int groupUnreadCnt;
    public ArrayList<Long> groupUnreadCodes;
    public int guildPsvboxUnreadCnt;
    public int guildUnreadCnt;
    public int verifyUnreadCnt;

    public BackGroundInfo() {
        this.groupUnreadCodes = new ArrayList<>();
    }

    public int getC2cUnreadCnt() {
        return this.c2cUnreadCnt;
    }

    public int getContactUnreadCnt() {
        return this.contactUnreadCnt;
    }

    public int getGroupUnreadCnt() {
        return this.groupUnreadCnt;
    }

    public ArrayList<Long> getGroupUnreadCodes() {
        return this.groupUnreadCodes;
    }

    public int getGuildPsvboxUnreadCnt() {
        return this.guildPsvboxUnreadCnt;
    }

    public int getGuildUnreadCnt() {
        return this.guildUnreadCnt;
    }

    public int getVerifyUnreadCnt() {
        return this.verifyUnreadCnt;
    }

    public void setC2cUnreadCnt(int i3) {
        this.c2cUnreadCnt = i3;
    }

    public void setContactUnreadCnt(int i3) {
        this.contactUnreadCnt = i3;
    }

    public void setGroupUnreadCnt(int i3) {
        this.groupUnreadCnt = i3;
    }

    public void setGroupUnreadCodes(ArrayList<Long> arrayList) {
        this.groupUnreadCodes = arrayList;
    }

    public void setGuildPsvboxUnreadCnt(int i3) {
        this.guildPsvboxUnreadCnt = i3;
    }

    public void setGuildUnreadCnt(int i3) {
        this.guildUnreadCnt = i3;
    }

    public void setVerifyUnreadCnt(int i3) {
        this.verifyUnreadCnt = i3;
    }

    public String toString() {
        return "BackGroundInfo{c2cUnreadCnt=" + this.c2cUnreadCnt + ",groupUnreadCnt=" + this.groupUnreadCnt + ",guildUnreadCnt=" + this.guildUnreadCnt + ",guildPsvboxUnreadCnt=" + this.guildPsvboxUnreadCnt + ",verifyUnreadCnt=" + this.verifyUnreadCnt + ",contactUnreadCnt=" + this.contactUnreadCnt + ",groupUnreadCodes=" + this.groupUnreadCodes + ",}";
    }

    public BackGroundInfo(int i3, int i16, int i17, int i18, int i19, int i26, ArrayList<Long> arrayList) {
        new ArrayList();
        this.c2cUnreadCnt = i3;
        this.groupUnreadCnt = i16;
        this.guildUnreadCnt = i17;
        this.guildPsvboxUnreadCnt = i18;
        this.verifyUnreadCnt = i19;
        this.contactUnreadCnt = i26;
        this.groupUnreadCodes = arrayList;
    }
}
