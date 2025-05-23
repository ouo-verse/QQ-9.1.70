package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProRobotStateInfo extends Serializable {
    long getBotTrtcId();

    boolean getNoLoopInfo();

    int getPlayState();

    String getPlayText();

    String toString();
}
