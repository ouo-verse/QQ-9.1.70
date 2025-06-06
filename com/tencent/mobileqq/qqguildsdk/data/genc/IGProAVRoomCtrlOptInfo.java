package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProAVRoomCtrlOptInfo extends Serializable {
    IGProAVDevOptInfo getDevOpt();

    boolean getIsCurrentRoom();

    int getMicVolume();

    int getNumRoomId();

    String getPrivateMapKey();

    String getRoomId();

    int getSdkAppId();

    String toString();
}
