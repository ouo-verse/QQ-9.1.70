package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProUserDevState;

/* loaded from: classes17.dex */
public class GProUserDevStateData implements IGProUserDevStateData {
    private GProUserDevState mUserDevState;

    public GProUserDevStateData(GProUserDevState gProUserDevState) {
        this.mUserDevState = gProUserDevState;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserDevStateData
    public int getCameraState() {
        return this.mUserDevState.getCameraState();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserDevStateData
    public int getMicState() {
        return this.mUserDevState.getMicState();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserDevStateData
    public int getNetworkQuality() {
        return this.mUserDevState.getNetworkQuality();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserDevStateData
    public int getScreenState() {
        return this.mUserDevState.getScreenState();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserDevStateData
    public int getSysMicBusy() {
        return this.mUserDevState.getSysMicBusy();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserDevStateData
    public void setCameraState(int i3) {
        this.mUserDevState.setCameraState(i3);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserDevStateData
    public void setMicState(int i3) {
        this.mUserDevState.setMicState(i3);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserDevStateData
    public void setNetworkQuality(int i3) {
        this.mUserDevState.setNetworkQuality(i3);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserDevStateData
    public void setScreenState(int i3) {
        this.mUserDevState.setScreenState(i3);
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserDevStateData
    public void setSysMicBusy(int i3) {
        this.mUserDevState.setSysMicBusy(i3);
    }
}
