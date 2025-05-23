package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.GProRoom;
import com.tencent.mobileqq.qqguildsdk.data.IGProRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.ILiveRoomAnchorInfo;
import com.tencent.mobileqq.qqguildsdk.data.LiveRoomAnchorInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProLiveRoomInfo;

/* loaded from: classes17.dex */
public class GGProLiveRoomInfo implements IGProLiveRoomInfo {
    public final GProLiveRoomInfo mInfo;

    public GGProLiveRoomInfo(GProLiveRoomInfo gProLiveRoomInfo) {
        this.mInfo = gProLiveRoomInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLiveRoomInfo
    public ILiveRoomAnchorInfo getAnchorInfo() {
        return new LiveRoomAnchorInfo(this.mInfo.getAnchorInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLiveRoomInfo
    public String getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLiveRoomInfo
    public String getChannelName() {
        return this.mInfo.getChannelName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLiveRoomInfo
    public String getCloseTips() {
        return this.mInfo.getCloseTips();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLiveRoomInfo
    public int getCloseType() {
        return this.mInfo.getCloseType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLiveRoomInfo
    public boolean getIsActive() {
        return this.mInfo.getIsActive();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLiveRoomInfo
    public int getLiveType() {
        return this.mInfo.getLiveType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLiveRoomInfo
    public int getPlatform() {
        return this.mInfo.getPlatform();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLiveRoomInfo
    public IGProProgramInfo getProgramInfo() {
        return new GGProProgramInfo(this.mInfo.getProgramInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLiveRoomInfo
    public long getQueryId() {
        return this.mInfo.getQueryId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLiveRoomInfo
    public IGProRoomInfo getRoomInfo() {
        return new GProRoom(this.mInfo.getRoomInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLiveRoomInfo
    public IGProLiveStreamInfo getStreamInfo() {
        return new GGProLiveStreamInfo(this.mInfo.getStreamInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLiveRoomInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
