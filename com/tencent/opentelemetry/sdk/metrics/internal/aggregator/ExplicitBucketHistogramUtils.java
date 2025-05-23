package com.tencent.opentelemetry.sdk.metrics.internal.aggregator;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.ToDoubleFunction;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ExplicitBucketHistogramUtils {
    static IPatchRedirector $redirector_;
    public static final List<Double> DEFAULT_HISTOGRAM_BUCKET_BOUNDARIES;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23197);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            DEFAULT_HISTOGRAM_BUCKET_BOUNDARIES = Collections.unmodifiableList(Arrays.asList(Double.valueOf(5.0d), Double.valueOf(10.0d), Double.valueOf(25.0d), Double.valueOf(50.0d), Double.valueOf(75.0d), Double.valueOf(100.0d), Double.valueOf(250.0d), Double.valueOf(500.0d), Double.valueOf(750.0d), Double.valueOf(1000.0d), Double.valueOf(2500.0d), Double.valueOf(5000.0d), Double.valueOf(7500.0d), Double.valueOf(10000.0d)));
        }
    }

    ExplicitBucketHistogramUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static double[] createBoundaryArray(List<Double> list) {
        Stream stream;
        DoubleStream mapToDouble;
        double[] array;
        stream = list.stream();
        mapToDouble = stream.mapToDouble(new ToDoubleFunction() { // from class: com.tencent.opentelemetry.sdk.metrics.internal.aggregator.e
            @Override // java.util.function.ToDoubleFunction
            public final double applyAsDouble(Object obj) {
                double doubleValue;
                doubleValue = ((Double) obj).doubleValue();
                return doubleValue;
            }
        });
        array = mapToDouble.toArray();
        return validateBucketBoundaries(array);
    }

    public static int findBucketIndex(double[] dArr, double d16) {
        for (int i3 = 0; i3 < dArr.length; i3++) {
            if (d16 <= dArr[i3]) {
                return i3;
            }
        }
        return dArr.length;
    }

    public static double[] validateBucketBoundaries(double[] dArr) {
        for (double d16 : dArr) {
            if (Double.isNaN(d16)) {
                throw new IllegalArgumentException("invalid bucket boundary: NaN");
            }
        }
        for (int i3 = 1; i3 < dArr.length; i3++) {
            int i16 = i3 - 1;
            if (dArr[i16] >= dArr[i3]) {
                throw new IllegalArgumentException("Bucket boundaries must be in increasing order: " + dArr[i16] + " >= " + dArr[i3]);
            }
        }
        if (dArr.length > 0) {
            if (dArr[0] != Double.NEGATIVE_INFINITY) {
                if (dArr[dArr.length - 1] == Double.POSITIVE_INFINITY) {
                    throw new IllegalArgumentException("invalid bucket boundary: +Inf");
                }
            } else {
                throw new IllegalArgumentException("invalid bucket boundary: -Inf");
            }
        }
        return dArr;
    }
}
