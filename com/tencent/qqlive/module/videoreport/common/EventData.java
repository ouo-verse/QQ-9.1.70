package com.tencent.qqlive.module.videoreport.common;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class EventData {
    private final String appKey;

    /* renamed from: id, reason: collision with root package name */
    private final String f345239id;
    private final Map<String, Object> params;
    private final WeakReference<Object> source;
    private final EventAgingType type;

    public EventData(Object obj, String str, Map<String, Object> map, EventAgingType eventAgingType, String str2) {
        this.source = new WeakReference<>(obj);
        this.f345239id = str;
        this.params = map;
        this.type = eventAgingType;
        this.appKey = str2;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder newBuilder(EventData eventData) {
        return new Builder();
    }

    public String getAppKey() {
        return this.appKey;
    }

    public String getId() {
        return this.f345239id;
    }

    public Map<String, Object> getParams() {
        return this.params;
    }

    public Object getSource() {
        return this.source.get();
    }

    public EventAgingType getType() {
        return this.type;
    }

    public String toString() {
        return "EventData{source=" + this.source + ", id='" + this.f345239id + "', params=" + this.params + ", type=" + this.type + ", appKey='" + this.appKey + "'}";
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static final class Builder {
        private String appKey;

        /* renamed from: id, reason: collision with root package name */
        private String f345240id;
        private Map<String, Object> params;
        private Object source;
        private EventAgingType type;

        public EventData build() {
            return new EventData(this.source, this.f345240id, this.params, this.type, this.appKey);
        }

        public Builder withAppKey(String str) {
            this.appKey = str;
            return this;
        }

        public Builder withId(String str) {
            this.f345240id = str;
            return this;
        }

        public Builder withParam(String str, Object obj) {
            this.params.put(str, obj);
            return this;
        }

        public Builder withParams(Map<String, Object> map) {
            if (map != null) {
                this.params.putAll(map);
            }
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
        }

        Builder(EventData eventData) {
            this.params = new HashMap();
            this.source = eventData.source;
            this.f345240id = eventData.f345239id;
            this.appKey = eventData.appKey;
            this.type = eventData.type;
            this.params.putAll(eventData.params);
        }
    }
}
