package com.tencent.opentelemetry.sdk.metrics.internal.data;

import com.google.auto.value.AutoValue;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.sdk.internal.PrimitiveLongList;
import com.tencent.opentelemetry.sdk.metrics.data.ExemplarData;
import com.tencent.opentelemetry.sdk.metrics.data.HistogramPointData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@AutoValue
@Immutable
/* loaded from: classes22.dex */
public abstract class ImmutableHistogramPointData implements HistogramPointData {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableHistogramPointData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static ImmutableHistogramPointData create(long j3, long j16, Attributes attributes, double d16, @Nullable Double d17, @Nullable Double d18, List<Double> list, List<Long> list2) {
        return create(j3, j16, attributes, d16, d17, d18, list, list2, Collections.emptyList());
    }

    private static boolean isStrictlyIncreasing(List<Double> list) {
        int i3 = 0;
        while (i3 < list.size() - 1) {
            Double d16 = list.get(i3);
            i3++;
            if (d16.compareTo(list.get(i3)) >= 0) {
                return false;
            }
        }
        return true;
    }

    public static ImmutableHistogramPointData create(long j3, long j16, Attributes attributes, double d16, @Nullable Double d17, @Nullable Double d18, List<Double> list, List<Long> list2, List<ExemplarData> list3) {
        if (list2.size() == list.size() + 1) {
            if (isStrictlyIncreasing(list)) {
                if (!list.isEmpty() && (list.get(0).isInfinite() || list.get(list.size() - 1).isInfinite())) {
                    throw new IllegalArgumentException("invalid boundaries: contains explicit +/-Inf");
                }
                long j17 = 0;
                for (long j18 : PrimitiveLongList.toArray(list2)) {
                    j17 += j18;
                }
                return new AutoValue_ImmutableHistogramPointData(j3, j16, attributes, list3, d16, j17, d17 != null, d17 != null ? d17.doubleValue() : -1.0d, d18 != null, d18 != null ? d18.doubleValue() : -1.0d, Collections.unmodifiableList(new ArrayList(list)), Collections.unmodifiableList(new ArrayList(list2)));
            }
            throw new IllegalArgumentException("invalid boundaries: " + list);
        }
        throw new IllegalArgumentException("invalid counts: size should be " + (list.size() + 1) + " instead of " + list2.size());
    }
}
