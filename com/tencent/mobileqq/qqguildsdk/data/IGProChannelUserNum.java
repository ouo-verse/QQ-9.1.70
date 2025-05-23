package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProChannelUserNum extends Serializable {
    long getDataVersion();

    int getPlayersNum();

    int getRobotNum();

    int getShowThreshold();

    int getSpeakOrderNum();

    int getUserNum();

    int getViewersNum();

    void setPlayersNum(int i3);

    void setViewersNum(int i3);

    String toString();
}
