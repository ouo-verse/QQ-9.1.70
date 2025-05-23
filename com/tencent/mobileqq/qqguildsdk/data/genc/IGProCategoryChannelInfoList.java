package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProCategoryChannelInfoList extends Serializable {
    String getCategoryAlias();

    long getCategoryId();

    int getCategoryType();

    ArrayList<IGProChannel> getChannelInfoList();

    boolean getCloseSwitch();

    boolean getFolded();

    String getName();

    IGProNavigationV2Info getNavigation();

    String getUrl();

    int getUrlType();

    String toString();
}
