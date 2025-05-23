package com.tencent.mobileqq.icgame.data.room;

import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataTrtcInfo;
import com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public class EnterRoomInfo implements BaseRoomInfo {
    private long openLiveType;
    private String shareToken;
    private QQLiveAnchorDataTrtcInfo trtcInfo;
    private long roomId = 0;
    private String source = "";
    private String programId = "";
    private String channelId = "";
    private String deviceId = "";
    private VideoDefinition targetDefinition = VideoDefinition.ORIGIN;
    private String transData = "";
    private String extraData = "";

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public enum VideoDefinition {
        UNKNOWN(-1),
        ORIGIN(0),
        SD(1),
        HD(2),
        SHD(3),
        FHD(4),
        THFD(5);

        public int level;

        VideoDefinition(int i3) {
            this.level = i3;
        }
    }

    public String getChannelId() {
        return this.channelId;
    }

    public String getDeviceMachineCode() {
        return this.deviceId;
    }

    public String getExtraData() {
        return this.extraData;
    }

    public long getOpenLiveType() {
        return this.openLiveType;
    }

    @Override // com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo
    public String getProgramId() {
        return this.programId;
    }

    @Override // com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo
    public long getRoomId() {
        return this.roomId;
    }

    public String getShareToken() {
        return this.shareToken;
    }

    public String getSource() {
        return this.source;
    }

    public VideoDefinition getTargetDefinition() {
        return this.targetDefinition;
    }

    public String getTransData() {
        return this.transData;
    }

    public QQLiveAnchorDataTrtcInfo getTrtcInfo() {
        return this.trtcInfo;
    }

    public void setChannelId(String str) {
        this.channelId = str;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setExtraData(String str) {
        this.extraData = str;
    }

    public void setOpenLiveType(long j3) {
        this.openLiveType = j3;
    }

    public void setProgramId(String str) {
        this.programId = str;
    }

    public void setRoomId(long j3) {
        this.roomId = j3;
    }

    public void setShareToken(String str) {
        this.shareToken = str;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setTargetDefinition(VideoDefinition videoDefinition) {
        this.targetDefinition = videoDefinition;
    }

    public void setTransData(String str) {
        this.transData = str;
    }

    public void setTrtcInfo(QQLiveAnchorDataTrtcInfo qQLiveAnchorDataTrtcInfo) {
        this.trtcInfo = qQLiveAnchorDataTrtcInfo;
    }

    public String toString() {
        return "EnterRoomInfo:[roomId=" + this.roomId + ";source=" + this.source + ";programId=" + this.programId + ";deviceId=" + this.deviceId + "]";
    }
}
