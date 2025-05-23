package com.tencent.opentelemetry.sdk.metrics.internal;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;
import com.tencent.opentelemetry.sdk.metrics.ViewBuilder;
import com.tencent.opentelemetry.sdk.metrics.internal.exemplar.ExemplarFilter;
import com.tencent.opentelemetry.sdk.metrics.internal.view.AttributesProcessor;
import com.tencent.opentelemetry.sdk.metrics.internal.view.StringPredicates;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.function.Predicate;

/* loaded from: classes22.dex */
public class SdkMeterProviderUtil {
    static IPatchRedirector $redirector_;

    SdkMeterProviderUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void addAttributesProcessor(ViewBuilder viewBuilder, AttributesProcessor attributesProcessor) {
        try {
            Method declaredMethod = ViewBuilder.class.getDeclaredMethod("addAttributesProcessor", AttributesProcessor.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(viewBuilder, attributesProcessor);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e16) {
            throw new IllegalStateException("Error adding AttributesProcessor to ViewBuilder", e16);
        }
    }

    public static void appendAllBaggageAttributes(ViewBuilder viewBuilder) {
        appendFilteredBaggageAttributes(viewBuilder, StringPredicates.ALL);
    }

    public static void appendFilteredBaggageAttributes(ViewBuilder viewBuilder, Predicate<String> predicate) {
        addAttributesProcessor(viewBuilder, AttributesProcessor.appendBaggageByKeyName(predicate));
    }

    public static void setExemplarFilter(SdkMeterProviderBuilder sdkMeterProviderBuilder, ExemplarFilter exemplarFilter) {
        try {
            Method declaredMethod = SdkMeterProviderBuilder.class.getDeclaredMethod("setExemplarFilter", ExemplarFilter.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(sdkMeterProviderBuilder, exemplarFilter);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e16) {
            throw new IllegalStateException("Error calling setExemplarFilter on SdkMeterProviderBuilder", e16);
        }
    }

    public static void setMinimumCollectionInterval(SdkMeterProviderBuilder sdkMeterProviderBuilder, Duration duration) {
        try {
            Method declaredMethod = SdkMeterProviderBuilder.class.getDeclaredMethod("setMinimumCollectionInterval", Duration.class);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(sdkMeterProviderBuilder, duration);
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e16) {
            throw new IllegalStateException("Error calling setMinimumCollectionInterval on SdkMeterProviderBuilder", e16);
        }
    }
}
