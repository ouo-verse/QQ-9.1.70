package com.tencent.mobileqq.guild.live.model;

import com.tencent.mobileqq.guild.main.data.QQGuildChannelLive;
import com.tencent.mobileqq.qqguildsdk.data.ILiveProgramInfo;
import com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes14.dex */
public class LiveChannelRoomInfo implements Serializable {
    public static final String TAG = "QGL.LiveChannelRoomInfo";
    private String anchorIconUrl;
    private String anchorNick;
    private int platform;
    private String programId;
    private QQGuildChannelLive.LiveProgramInfo programInfo;
    private String roomId;
    private String roomName;
    private long viewer;

    public static LiveChannelRoomInfo parseFrom(QQGuildChannelLive.a aVar) {
        if (aVar == null) {
            return null;
        }
        if (aVar.j() == null && aVar.i() == null) {
            return null;
        }
        QLog.i(TAG, 1, "parseFromLiveRoomInfoUIData, roomId:" + aVar.j() + ",programId:" + aVar.h());
        LiveChannelRoomInfo liveChannelRoomInfo = new LiveChannelRoomInfo();
        liveChannelRoomInfo.setProgramId(aVar.h());
        liveChannelRoomInfo.setViewer(aVar.n());
        liveChannelRoomInfo.setAnchorNick(aVar.c());
        liveChannelRoomInfo.setRoomName(aVar.k());
        liveChannelRoomInfo.setRoomId(aVar.j());
        liveChannelRoomInfo.setPlatform(aVar.f());
        if (aVar.d() != null) {
            try {
                liveChannelRoomInfo.setProgramInfo(aVar.d().m188clone());
            } catch (CloneNotSupportedException e16) {
                QLog.e(TAG, 1, "getLiveProgramInfo clone error:" + e16.getMessage());
            }
        }
        return liveChannelRoomInfo;
    }

    public String getAnchorIconUrl() {
        return this.anchorIconUrl;
    }

    public String getAnchorNick() {
        return this.anchorNick;
    }

    public int getPlatform() {
        return this.platform;
    }

    public String getProgramId() {
        return this.programId;
    }

    public QQGuildChannelLive.LiveProgramInfo getProgramInfo() {
        return this.programInfo;
    }

    public String getRoomId() {
        return this.roomId;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public long getViewer() {
        return this.viewer;
    }

    public void setAnchorIconUrl(String str) {
        this.anchorIconUrl = str;
    }

    public void setAnchorNick(String str) {
        this.anchorNick = str;
    }

    public void setPlatform(int i3) {
        this.platform = i3;
    }

    public void setProgramId(String str) {
        this.programId = str;
    }

    public void setProgramInfo(QQGuildChannelLive.LiveProgramInfo liveProgramInfo) {
        this.programInfo = liveProgramInfo;
    }

    public void setRoomId(String str) {
        this.roomId = str;
    }

    public void setRoomName(String str) {
        this.roomName = str;
    }

    public void setViewer(long j3) {
        this.viewer = j3;
    }

    public void updateProgramInfo(ILiveProgramInfo iLiveProgramInfo) {
        if (iLiveProgramInfo != null) {
            setProgramInfo(QQGuildChannelLive.LiveProgramInfo.parse(iLiveProgramInfo));
        }
    }

    public static LiveChannelRoomInfo parseFrom(ILiveRoomInfo iLiveRoomInfo) {
        if (iLiveRoomInfo == null) {
            return null;
        }
        QLog.i(TAG, 1, "parseFromILiveRoomInfo, roomId:" + iLiveRoomInfo.getRoomId() + ",programId:" + iLiveRoomInfo.getProgramId());
        LiveChannelRoomInfo liveChannelRoomInfo = new LiveChannelRoomInfo();
        liveChannelRoomInfo.setProgramId(iLiveRoomInfo.getProgramId());
        liveChannelRoomInfo.setViewer(iLiveRoomInfo.getViewer());
        liveChannelRoomInfo.setRoomName(iLiveRoomInfo.getRoomTitle());
        liveChannelRoomInfo.setRoomId(iLiveRoomInfo.getRoomId());
        liveChannelRoomInfo.setPlatform(iLiveRoomInfo.getPlatform());
        if (iLiveRoomInfo.getAnchorInfo() != null) {
            liveChannelRoomInfo.setAnchorNick(iLiveRoomInfo.getAnchorInfo().getAnchorName());
            liveChannelRoomInfo.setAnchorIconUrl(iLiveRoomInfo.getAnchorInfo().getAnchorIcon());
        }
        liveChannelRoomInfo.setProgramInfo(QQGuildChannelLive.LiveProgramInfo.parse(iLiveRoomInfo.getProgramInfo()));
        return liveChannelRoomInfo;
    }
}
