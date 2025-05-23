package com.tencent.opentelemetry.sdk.metrics.data;

import java.util.List;

/* loaded from: classes22.dex */
public interface SummaryPointData extends PointData {
    long getCount();

    double getSum();

    List<ValueAtQuantile> getValues();
}
