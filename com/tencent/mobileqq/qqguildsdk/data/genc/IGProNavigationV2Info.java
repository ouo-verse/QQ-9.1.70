package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProNavigationV2Info extends Serializable {
    String getAppId();

    long getBeginVersion();

    String getBubbleDesc();

    long getCategoryId();

    long getEndVersion();

    IGProNavigationItemExt getExtInfo();

    long getIconId();

    String getIconUrl();

    String getJumpUrl();

    String getJumpUrlAuditDesc();

    int getJumpUrlAuditStatus();

    int getJumpUrlType();

    int getPlatForm();

    boolean getShowBubble();

    String getTitle();

    String getTitleAuditDesc();

    int getTitleAuditStatus();

    String getUuid();

    String toString();
}
