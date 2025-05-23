package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProGuildNavigationInfo extends Serializable {
    int getAuditStatus();

    int getCompatibleFlag();

    long getGuildId();

    String getGuildName();

    String getIconSelectorColor();

    String getIconSelectorUrl();

    ArrayList<IGProNavigationV2Info> getNavigationList();

    long getVersion();

    String toString();
}
