package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes17.dex */
public interface IGProRecommendLabel extends Serializable {
    int getBussiLabelType();

    String getLabelName();

    int getLabelType();

    int getLabelValue();

    String getValue();

    ArrayList<String> getValueList();

    String toString();
}
