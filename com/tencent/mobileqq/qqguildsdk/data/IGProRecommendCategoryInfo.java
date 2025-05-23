package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProRecommendCategoryInfo extends Serializable {
    long getCategoryId();

    int getCategoryIndex();

    String getCategoryName();

    ArrayList<IGProChannel> getChannelInfoList();
}
