package com.tencent.ams.dsdk.monitor.metric.core;

import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.dsdk.monitor.metric.core.inner.Metric;
import com.tencent.ams.dsdk.monitor.metric.core.inner.MetricService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MetricReporter {
    static IPatchRedirector $redirector_;

    public MetricReporter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void flush() {
        if (!DKConfiguration.isEnableMetricReport()) {
            return;
        }
        MetricService.getInstance().flush();
    }

    public static void report(long j3, double d16, TagSet... tagSetArr) {
        if (DKConfiguration.isEnableMetricReport()) {
            Metric value = new Metric(j3).setValue(d16);
            if (tagSetArr != null) {
                for (TagSet tagSet : tagSetArr) {
                    if (tagSet != null) {
                        value.setTagSet(tagSet.tagName, tagSet.tagValue);
                    }
                }
            }
            MetricService.getInstance().handle(value);
        }
    }

    public static void shutdownSafely() {
        if (!DKConfiguration.isEnableMetricReport()) {
            return;
        }
        MetricService.getInstance().shutDownSafely();
    }

    public static void report(long j3, TagSet... tagSetArr) {
        if (DKConfiguration.isEnableMetricReport()) {
            report(j3, 1.0d, tagSetArr);
        }
    }

    public static void report(long j3, double d16, List<TagSet> list) {
        if (DKConfiguration.isEnableMetricReport()) {
            Metric value = new Metric(j3).setValue(d16);
            if (list != null) {
                for (TagSet tagSet : list) {
                    if (tagSet != null) {
                        value.setTagSet(tagSet.tagName, tagSet.tagValue);
                    }
                }
            }
            MetricService.getInstance().handle(value);
        }
    }

    public static void report(long j3, List<TagSet> list) {
        report(j3, 1.0d, list);
    }
}
