package com.tencent.timi.game.liveroom.impl.room.playtogether;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes26.dex */
public class LiveTeamStatusInfo implements Serializable {
    public String liveRoomId = "";
    public long teamId = 0;
    public boolean isTeamOwner = false;
    public boolean isVolumeOpen = true;
    public int teamPlayStatus = 2;
}
