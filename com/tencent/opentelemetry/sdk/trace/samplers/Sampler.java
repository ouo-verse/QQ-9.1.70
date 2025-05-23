package com.tencent.opentelemetry.sdk.trace.samplers;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.trace.SpanKind;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.trace.data.LinkData;
import java.util.List;
import javax.annotation.concurrent.ThreadSafe;

/* compiled from: P */
@ThreadSafe
/* loaded from: classes22.dex */
public interface Sampler {
    public static final IPatchRedirector $redirector_ = null;

    String getDescription();

    SamplingResult shouldSample(Context context, String str, String str2, SpanKind spanKind, Attributes attributes, List<LinkData> list);
}
