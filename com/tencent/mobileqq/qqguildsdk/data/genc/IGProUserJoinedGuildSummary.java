package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProUserJoinedGuildSummary extends Serializable {
    ArrayList<IGProRecommendChannelInfo> getGuildList();

    String getJoinedCountStr();

    String toString();
}
