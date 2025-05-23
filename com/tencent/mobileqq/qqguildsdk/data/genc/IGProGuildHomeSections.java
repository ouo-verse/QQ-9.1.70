package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProGuildHomeSections extends Serializable {
    ArrayList<IGProCategoryChannelInfoList> getCommonCategories();

    ArrayList<IGProChannel> getFeedChannels();

    String toString();
}
