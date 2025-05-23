package com.tencent.opentelemetry.sdk.metrics.data;

import com.tencent.opentelemetry.sdk.metrics.data.PointData;
import java.util.Collection;
import javax.annotation.concurrent.Immutable;

/* compiled from: P */
@Immutable
/* loaded from: classes22.dex */
public interface Data<T extends PointData> {
    Collection<T> getPoints();
}
