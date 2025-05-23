package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProPlayNodeExtInfo extends Serializable {
    long getCompereTinyid();

    boolean getEnableVolume();

    int getPauseDuration();

    int getPlayState();

    IGProPlayPushScene getPushScene();

    long getSourceNum();

    long getStartPlayTime();

    int getVolume();

    String toString();
}
