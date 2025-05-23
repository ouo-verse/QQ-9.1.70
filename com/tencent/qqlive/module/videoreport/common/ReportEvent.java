package com.tencent.qqlive.module.videoreport.common;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ReportEvent {
    private final String appKey;
    private final boolean isSampleHit;
    private final String key;
    private final Map<String, String> params;
    private final Map<String, Object> rawParams;
    private double remoteSampleRate;
    private final Object source;
    private final EventAgingType type;
    private boolean remoteSampled = true;
    private boolean remoteSampleHit = false;

    public ReportEvent(Object obj, String str, Map<String, String> map, Map<String, Object> map2, EventAgingType eventAgingType, String str2, boolean z16) {
        this.source = obj;
        this.key = str;
        this.params = map;
        this.rawParams = map2;
        this.type = eventAgingType;
        this.appKey = str2;
        this.isSampleHit = z16;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder newBuilder(ReportEvent reportEvent) {
        return new Builder();
    }

    public String getAppKey() {
        return this.appKey;
    }

    public String getKey() {
        return this.key;
    }

    public Map<String, String> getParams() {
        return this.params;
    }

    public Map<String, Object> getRawParams() {
        return this.rawParams;
    }

    public double getRemoteSampleRate() {
        return this.remoteSampleRate;
    }

    public Object getSource() {
        return this.source;
    }

    public EventAgingType getType() {
        return this.type;
    }

    public boolean isRemoteSampleHit() {
        return this.remoteSampleHit;
    }

    public boolean isRemoteSampled() {
        return this.remoteSampled;
    }

    public boolean isSampleHit() {
        return this.isSampleHit;
    }

    public void remoteSampleHit(boolean z16) {
        this.remoteSampleHit = z16;
    }

    public void remoteSampleRate(double d16) {
        this.remoteSampleRate = d16;
    }

    public void remoteSampled(boolean z16) {
        this.remoteSampled = z16;
    }

    public String toString() {
        return "ReportEvent{source=" + this.source + ", key='" + this.key + "', params=" + this.params + ", rawParams=" + this.rawParams + ", type=" + this.type + ", appKey='" + this.appKey + "'}";
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class Builder {
        private String appKey;
        private boolean isSampleHit;
        private String key;
        private Map<String, String> params;
        private Map<String, Object> rawParams;
        private Object source;
        private EventAgingType type;

        public ReportEvent build() {
            return new ReportEvent(this.source, this.key, this.params, this.rawParams, this.type, this.appKey, this.isSampleHit);
        }

        public Builder withAppKey(String str) {
            this.appKey = str;
            return this;
        }

        public Builder withKey(String str) {
            this.key = str;
            return this;
        }

        public Builder withParams(Map<String, String> map) {
            if (map != null) {
                this.params.putAll(map);
            }
            return this;
        }

        public Builder withRawParams(Map<String, Object> map) {
            if (map != null) {
                this.rawParams.putAll(map);
            }
            return this;
        }

        public Builder withSampleHit(boolean z16) {
            this.isSampleHit = z16;
            return this;
        }

        public Builder withSource(Object obj) {
            this.source = obj;
            return this;
        }

        public Builder withType(EventAgingType eventAgingType) {
            this.type = eventAgingType;
            return this;
        }

        Builder() {
            this.params = new HashMap();
            this.rawParams = new HashMap();
            this.type = EventAgingType.NORMAL;
            this.isSampleHit = false;
        }

        Builder(ReportEvent reportEvent) {
            this.params = new HashMap();
            this.rawParams = new HashMap();
            this.type = EventAgingType.NORMAL;
            this.isSampleHit = false;
            this.source = reportEvent.source;
            this.key = reportEvent.key;
            this.appKey = reportEvent.appKey;
            this.type = reportEvent.type;
            this.params.putAll(reportEvent.params);
            this.rawParams.putAll(reportEvent.rawParams);
        }
    }
}
