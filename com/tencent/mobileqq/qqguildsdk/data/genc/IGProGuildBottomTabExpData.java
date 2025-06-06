package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProGuildBottomTabExpData extends Serializable {
    IGProDiscoveryData getDiscoveryData();

    long getExpId();

    String getExpIndex();

    boolean getIsHit();

    int getTabType();

    IGProNewUserGuideData getUserGuideData();

    String toString();
}
