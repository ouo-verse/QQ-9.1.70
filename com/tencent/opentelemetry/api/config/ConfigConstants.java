package com.tencent.opentelemetry.api.config;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface ConfigConstants {
    public static final String CONSTANT_DEFAULT_TENANT_ID = "default";
    public static final String CONSTANT_DEFAULT_TENANT_NAME = "default";
    public static final String CONSTANT_TENANT_ID_KEY = "tps.tenant.id";
    public static final String CONSTANT_TENANT_NAME_KEY = "tps.tenant.name";
    public static final double DEFAULT_FRACTION = 0.001d;
    public static final String DEFAULT_LOGGING_SERVICE_ADDRESS = "https://tpstelemetry.tencent.com/v1/logs";
    public static final String DEFAULT_METRIC_SERVICE_ADDRESS = "https://tpstelemetry.tencent.com/v1/metrics";
    public static final String DEFAULT_SAMPLER_SERVICE_ADDRESS = "https://tpstelemetry.tencent.com/api/sampler";
    public static final String DEFAULT_TRACE_SERVICE_ADDRESS = "https://tpstelemetry.tencent.com/v1/trace";
    public static final String FORCE_SAMPLE_KEY = "tps.force.sample";
    public static final String NTP_1 = "time1.cloud.tencent.com";
    public static final String NTP_2 = "time2.cloud.tencent.com";
    public static final String NTP_3 = "time3.cloud.tencent.com";
    public static final String NTP_4 = "time4.cloud.tencent.com";
    public static final String NTP_5 = "time5.cloud.tencent.com";
    public static final String SAMPLER_TAG_HEADER_FIELD = "Grpc-Metadata-X-Tps-TenantID";
    public static final long SYNC_SAMPLER_TIME = 600000;
    public static final String TENANT_KEY = "X-Tps-TenantID";
}
