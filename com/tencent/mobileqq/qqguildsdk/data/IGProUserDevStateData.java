package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProUserDevStateData extends Serializable {
    int getCameraState();

    int getMicState();

    int getNetworkQuality();

    int getScreenState();

    int getSysMicBusy();

    void setCameraState(int i3);

    void setMicState(int i3);

    void setNetworkQuality(int i3);

    void setScreenState(int i3);

    void setSysMicBusy(int i3);
}
