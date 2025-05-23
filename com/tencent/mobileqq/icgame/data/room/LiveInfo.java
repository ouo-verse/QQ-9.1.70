package com.tencent.mobileqq.icgame.data.room;

import com.tencent.mobileqq.qqlive.data.room.LiveAnchorInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveRoomConfigInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveRoomInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveStreamIdInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveTrtcInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveWatchMediaInfo;
import t42.g;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LiveInfo {
    private static final String TAG = "ICGameLiveInfo";
    public LiveAnchorInfo anchorInfo;
    public LiveRoomConfigInfo configInfo;
    public LiveRoomInfo roomInfo;
    public LiveStreamIdInfo streamIdInfo;
    public LiveTrtcInfo trtcInfo;
    public LiveWatchMediaInfo watchMediaInfo;
    public int userFlag = 0;
    public int anchorType = 1;
    public int streamType = 0;
    public long nowTimeMs = 0;
    private long gameID = 0;

    public long getGameID() {
        return this.gameID;
    }

    public boolean isQQAnchor() {
        if (this.anchorType == 1) {
            return true;
        }
        return false;
    }

    public void setAnchorInfo(LiveAnchorInfo liveAnchorInfo) {
        this.anchorInfo = liveAnchorInfo;
        g.a(TAG, "setAnchorInfo in sub thread!");
    }

    public void setGameID(long j3) {
        this.gameID = j3;
    }

    public void setRoomInfo(LiveRoomInfo liveRoomInfo) {
        this.roomInfo = liveRoomInfo;
        g.a(TAG, "setRoomInfo in sub thread!");
    }
}
