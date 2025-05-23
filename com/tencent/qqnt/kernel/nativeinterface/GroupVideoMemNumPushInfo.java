package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GroupVideoMemNumPushInfo {
    public int actionType;
    public int gameId;
    public long groupCode;
    public String groupVideoRoomId;
    public ArrayList<Long> memberUins;
    public int onlineCount;

    public GroupVideoMemNumPushInfo() {
        this.memberUins = new ArrayList<>();
        this.groupVideoRoomId = "";
    }

    public int getActionType() {
        return this.actionType;
    }

    public int getGameId() {
        return this.gameId;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public String getGroupVideoRoomId() {
        return this.groupVideoRoomId;
    }

    public ArrayList<Long> getMemberUins() {
        return this.memberUins;
    }

    public int getOnlineCount() {
        return this.onlineCount;
    }

    public String toString() {
        return "GroupVideoMemNumPushInfo{groupCode=" + this.groupCode + ",onlineCount=" + this.onlineCount + ",actionType=" + this.actionType + ",gameId=" + this.gameId + ",memberUins=" + this.memberUins + ",groupVideoRoomId=" + this.groupVideoRoomId + ",}";
    }

    public GroupVideoMemNumPushInfo(long j3, int i3, int i16, int i17, ArrayList<Long> arrayList, String str) {
        new ArrayList();
        this.groupCode = j3;
        this.onlineCount = i3;
        this.actionType = i16;
        this.gameId = i17;
        this.memberUins = arrayList;
        this.groupVideoRoomId = str;
    }
}
