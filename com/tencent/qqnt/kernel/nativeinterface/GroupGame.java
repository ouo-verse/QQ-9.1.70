package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupGame {
    public int gameId;
    public GroupGameInfo gameInfo = new GroupGameInfo();
    public int notAllowSelected;

    public int getGameId() {
        return this.gameId;
    }

    public GroupGameInfo getGameInfo() {
        return this.gameInfo;
    }

    public int getNotAllowSelected() {
        return this.notAllowSelected;
    }

    public String toString() {
        return "GroupGame{gameId=" + this.gameId + ",gameInfo=" + this.gameInfo + ",notAllowSelected=" + this.notAllowSelected + ",}";
    }
}
