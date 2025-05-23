package com.tencent.tav.player;

import com.tencent.tav.player.IPlayer;

/* loaded from: classes26.dex */
public class PlayerStatusMsg {
    private String errorMsg;
    private IPlayer.PlayerStatus playerStatus;

    public PlayerStatusMsg(IPlayer.PlayerStatus playerStatus, String str) {
        this.playerStatus = playerStatus;
        this.errorMsg = str;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public IPlayer.PlayerStatus getPlayerStatus() {
        return this.playerStatus;
    }
}
