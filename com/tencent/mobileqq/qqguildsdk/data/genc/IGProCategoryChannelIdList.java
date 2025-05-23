package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProCategoryChannelIdList extends Serializable {
    String getCategoryAlias();

    long getCategoryId();

    int getCategoryType();

    ArrayList<Long> getChannelList();

    boolean getCloseSwitch();

    boolean getFolded();

    String getName();

    String getUrl();

    int getUrlType();

    String toString();
}
