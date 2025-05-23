package com.tencent.mobileqq.qqguildsdk.data;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProStickyFeedChannel extends Serializable {
    String getActiveMemberCount();

    ArrayList<IGProUserInfo> getActiveMemberList();

    String getFeedCount();

    ArrayList<IGProFeedSummary> getFeedSummaryList();
}
