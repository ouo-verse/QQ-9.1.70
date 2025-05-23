package com.tencent.opentelemetry.sdk.metrics.internal.aggregator;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.sdk.metrics.Aggregation;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AggregationUtil {
    static IPatchRedirector $redirector_ = null;
    private static final String AGGREGATION_DEFAULT = "default";
    private static final String AGGREGATION_DROP = "drop";
    private static final String AGGREGATION_EXPLICIT_BUCKET_HISTOGRAM = "explicit_bucket_histogram";
    private static final String AGGREGATION_LAST_VALUE = "last_value";
    private static final String AGGREGATION_SUM = "sum";
    private static final Map<String, Aggregation> aggregationByName;
    private static final Map<Class<? extends Aggregation>, String> nameByAggregation;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23789);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        HashMap hashMap = new HashMap();
        aggregationByName = hashMap;
        hashMap.put("default", com.tencent.opentelemetry.sdk.metrics.b.a());
        hashMap.put(AGGREGATION_SUM, com.tencent.opentelemetry.sdk.metrics.b.f());
        hashMap.put(AGGREGATION_LAST_VALUE, com.tencent.opentelemetry.sdk.metrics.b.e());
        hashMap.put(AGGREGATION_DROP, com.tencent.opentelemetry.sdk.metrics.b.b());
        hashMap.put(AGGREGATION_EXPLICIT_BUCKET_HISTOGRAM, com.tencent.opentelemetry.sdk.metrics.b.c());
        HashMap hashMap2 = new HashMap();
        nameByAggregation = hashMap2;
        hashMap2.put(com.tencent.opentelemetry.sdk.metrics.b.a().getClass(), "default");
        hashMap2.put(com.tencent.opentelemetry.sdk.metrics.b.f().getClass(), AGGREGATION_SUM);
        hashMap2.put(com.tencent.opentelemetry.sdk.metrics.b.e().getClass(), AGGREGATION_LAST_VALUE);
        hashMap2.put(com.tencent.opentelemetry.sdk.metrics.b.b().getClass(), AGGREGATION_DROP);
        hashMap2.put(com.tencent.opentelemetry.sdk.metrics.b.c().getClass(), AGGREGATION_EXPLICIT_BUCKET_HISTOGRAM);
    }

    AggregationUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String aggregationName(Aggregation aggregation) {
        String str = nameByAggregation.get(aggregation.getClass());
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Unrecognized aggregation " + aggregation.getClass().getName());
    }

    public static Aggregation forName(String str) {
        Aggregation aggregation = aggregationByName.get(str);
        if (aggregation != null) {
            return aggregation;
        }
        throw new IllegalArgumentException("Unrecognized aggregation name " + str);
    }
}
