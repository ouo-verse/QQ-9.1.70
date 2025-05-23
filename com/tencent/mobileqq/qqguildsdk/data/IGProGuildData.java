package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.mobileqq.qqguildsdk.data.genc.IGProRecommendGuildInfo;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProGuildData extends Serializable {
    ArrayList<IGProRecommendCategoryInfo> getCategoryList();

    ArrayList<IGProRecommendChannelExtendInfo> getChannelExtendInfo();

    ArrayList<IGProPollingData> getDatas();

    IGProRecommendGuildInfo getGuildInfo();
}
