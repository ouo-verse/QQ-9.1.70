package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProClientPresenceInfo extends Serializable {
    String getBigIcon();

    int getClientId();

    String getClientName();

    String getDetails();

    long getEndTimeStamp();

    long getExpireTimeStamp();

    long getPartyMax();

    long getPartySize();

    String getRole();

    String getSmallIcon();

    long getStartTimeStamp();

    String getState();
}
