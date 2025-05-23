package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProGuildInit extends Serializable {
    ArrayList<IGProCategoryChannelIdList> getCategoryList();

    long getGuildId();

    IGProCategoryChannelIdList getUncategorizedChannels();

    String toString();
}
