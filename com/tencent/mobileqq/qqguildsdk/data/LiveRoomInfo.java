package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProLiveRoomInfo;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes17.dex */
public class LiveRoomInfo implements ILiveRoomInfo {
    private ILiveRoomAnchorInfo anchorInfo;
    private GProLiveRoomInfo liveRoomInfo;
    private ILiveProgramInfo programInfo;
    private int source;
    private long updateTime;

    public LiveRoomInfo(GProLiveRoomInfo gProLiveRoomInfo) {
        this.liveRoomInfo = gProLiveRoomInfo;
        this.anchorInfo = new LiveRoomAnchorInfo(gProLiveRoomInfo.getAnchorInfo());
        this.programInfo = new LiveProgramInfo(gProLiveRoomInfo.getProgramInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo
    public ILiveRoomAnchorInfo getAnchorInfo() {
        return this.anchorInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo
    public String getChannelId() {
        return this.liveRoomInfo.channelId;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo
    public String getCloseTips() {
        return this.liveRoomInfo.getCloseTips();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo
    public int getCloseType() {
        return this.liveRoomInfo.getCloseType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo
    public int getFakeNum() {
        return this.liveRoomInfo.getRoomInfo().getViewerExt().getFakeNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo
    public String getLiveStreamFlvUrl() {
        return this.liveRoomInfo.getStreamInfo().getFlvUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo
    public String getLiveStreamUrl() {
        return this.liveRoomInfo.getStreamInfo().getUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo
    public int getLiveTypeNum() {
        return this.liveRoomInfo.getLiveType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo
    public int getPlatform() {
        return this.liveRoomInfo.getPlatform();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo
    public String getProgramId() {
        return this.liveRoomInfo.getRoomInfo().getProgramId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo
    public ILiveProgramInfo getProgramInfo() {
        return this.programInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo
    public String getQueryId() {
        return com.tencent.mobileqq.qqguildsdk.util.g.X0(this.liveRoomInfo.getQueryId());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo
    public int getRealNum() {
        return this.liveRoomInfo.getRoomInfo().getViewerExt().getRealNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo
    public int getRobotNum() {
        return this.liveRoomInfo.getRoomInfo().getViewerExt().getRebotNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo
    public HashMap<String, String> getRoomIcons() {
        return this.liveRoomInfo.getRoomInfo().getRoomIcons();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo
    public String getRoomId() {
        return com.tencent.mobileqq.qqguildsdk.util.g.X0(this.liveRoomInfo.getRoomInfo().getRoomId());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo
    public String getRoomPv() {
        return this.liveRoomInfo.getRoomInfo().getRoomPv();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo
    public int getRoomState() {
        return this.liveRoomInfo.getRoomInfo().getRoomState();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo
    public String getRoomTitle() {
        return this.liveRoomInfo.getRoomInfo().getRoomName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo
    public int getSource() {
        return this.source;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo
    public long getUpdateTime() {
        return this.updateTime;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo
    public long getViewer() {
        return this.liveRoomInfo.getRoomInfo().getViewer();
    }

    public void setSource(int i3) {
        this.source = i3;
    }

    public void setUpdateTime(long j3) {
        if (j3 > 0) {
            this.updateTime = j3;
        }
    }
}
