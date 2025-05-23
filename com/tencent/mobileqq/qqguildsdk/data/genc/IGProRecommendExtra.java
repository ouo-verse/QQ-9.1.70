package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProRecommendExtra extends Serializable {
    ArrayList<IGProRecommendEntry> getBizData();

    IGProItemCbData getCallback();

    ArrayList<IGProRecommendEntry> getReports();

    ArrayList<IGProRecommendTag> getTags();

    String toString();
}
