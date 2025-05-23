package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProContentRecommendGroup extends Serializable {
    long getGroupCode();

    String getGroupMembers();

    String getGroupName();

    String getGroupSummary();

    String getHeadUrl();

    String getJoinGroupAuth();

    String getJoinText();

    ArrayList<String> getRecommendReasons();

    String toString();
}
