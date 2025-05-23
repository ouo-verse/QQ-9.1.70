package com.tencent.opentelemetry.sdk.metrics.data;

import java.util.List;

/* loaded from: classes22.dex */
public interface HistogramPointData extends PointData {
    List<Double> getBoundaries();

    long getCount();

    List<Long> getCounts();

    double getMax();

    double getMin();

    double getSum();

    boolean hasMax();

    boolean hasMin();
}
