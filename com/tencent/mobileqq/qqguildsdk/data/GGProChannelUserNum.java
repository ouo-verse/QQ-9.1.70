package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannelUserNum;

/* loaded from: classes17.dex */
public class GGProChannelUserNum implements IGProChannelUserNum {
    public final GProChannelUserNum mInfo;

    public GGProChannelUserNum(GProChannelUserNum gProChannelUserNum) {
        this.mInfo = gProChannelUserNum;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum
    public long getDataVersion() {
        return this.mInfo.getDataVersion();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum
    public int getPlayersNum() {
        return this.mInfo.getPlayersNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum
    public int getRobotNum() {
        return this.mInfo.getRobotNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum
    public int getShowThreshold() {
        return this.mInfo.getShowThreshold();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum
    public int getSpeakOrderNum() {
        return this.mInfo.getSpeakOrderNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum
    public int getUserNum() {
        return this.mInfo.getUserNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum
    public int getViewersNum() {
        return this.mInfo.getViewersNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum
    public void setPlayersNum(int i3) {
        this.mInfo.playersNum = i3;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum
    public void setViewersNum(int i3) {
        this.mInfo.viewersNum = i3;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum
    public String toString() {
        return this.mInfo.toString();
    }
}
