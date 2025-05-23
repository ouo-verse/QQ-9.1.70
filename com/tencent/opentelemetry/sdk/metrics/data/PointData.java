package com.tencent.opentelemetry.sdk.metrics.data;

import com.tencent.opentelemetry.api.common.Attributes;
import java.util.List;
import javax.annotation.concurrent.Immutable;

@Immutable
/* loaded from: classes22.dex */
public interface PointData {
    Attributes getAttributes();

    long getEpochNanos();

    List<ExemplarData> getExemplars();

    long getStartEpochNanos();
}
