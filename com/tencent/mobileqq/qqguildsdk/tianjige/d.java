package com.tencent.mobileqq.qqguildsdk.tianjige;

import com.tencent.opentelemetry.api.common.Attributes;
import com.tencent.opentelemetry.api.internal.OtelEncodingUtils;
import com.tencent.opentelemetry.api.trace.SpanKind;
import com.tencent.opentelemetry.context.Context;
import com.tencent.opentelemetry.sdk.trace.data.LinkData;
import com.tencent.opentelemetry.sdk.trace.samplers.Sampler;
import com.tencent.opentelemetry.sdk.trace.samplers.SamplingDecision;
import com.tencent.opentelemetry.sdk.trace.samplers.SamplingResult;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class d implements Sampler {

    /* renamed from: d, reason: collision with root package name */
    public static String f268501d = "GuildTraceSamplerKey";

    /* renamed from: e, reason: collision with root package name */
    private static final SamplingResult f268502e = com.tencent.opentelemetry.sdk.trace.samplers.b.b(SamplingDecision.RECORD_AND_SAMPLE);

    /* renamed from: f, reason: collision with root package name */
    private static final SamplingResult f268503f = com.tencent.opentelemetry.sdk.trace.samplers.b.b(SamplingDecision.DROP);

    private static long a(String str) {
        return OtelEncodingUtils.longFromBase16String(str, 16);
    }

    @Override // com.tencent.opentelemetry.sdk.trace.samplers.Sampler
    public String getDescription() {
        return "";
    }

    @Override // com.tencent.opentelemetry.sdk.trace.samplers.Sampler
    public SamplingResult shouldSample(Context context, String str, String str2, SpanKind spanKind, Attributes attributes, List<LinkData> list) {
        long j3;
        Double d16 = (Double) attributes.get(com.tencent.opentelemetry.api.common.e.d(f268501d));
        if (d16 != null && d16.doubleValue() >= 0.0d && d16.doubleValue() <= 1.0d && Math.abs(d16.doubleValue() - 0.0d) >= 1.0E-5d) {
            if (Math.abs(d16.doubleValue() - 1.0d) < 1.0E-5d) {
                j3 = Long.MAX_VALUE;
            } else {
                j3 = (long) (d16.doubleValue() * 9.223372036854776E18d);
            }
        } else {
            j3 = Long.MIN_VALUE;
        }
        if (Math.abs(a(str)) < j3) {
            return f268502e;
        }
        return f268503f;
    }
}
