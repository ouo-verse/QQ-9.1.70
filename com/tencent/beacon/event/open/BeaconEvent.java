package com.tencent.beacon.event.open;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.beacon.a.c.c;
import com.tencent.beacon.event.c.d;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class BeaconEvent {

    /* renamed from: a, reason: collision with root package name */
    private String f78033a;

    /* renamed from: b, reason: collision with root package name */
    private String f78034b;

    /* renamed from: c, reason: collision with root package name */
    private EventType f78035c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f78036d;

    /* renamed from: e, reason: collision with root package name */
    private Map<String, String> f78037e;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        private String f78038a;

        /* renamed from: b, reason: collision with root package name */
        private String f78039b;

        /* renamed from: c, reason: collision with root package name */
        private EventType f78040c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f78041d;

        /* renamed from: e, reason: collision with root package name */
        private Map<String, String> f78042e;

        /* synthetic */ Builder(a aVar) {
            this();
        }

        public BeaconEvent build() {
            String b16 = d.b(this.f78039b);
            if (TextUtils.isEmpty(this.f78038a)) {
                this.f78038a = c.c().e();
            }
            d.a(b16, this.f78042e);
            return new BeaconEvent(this.f78038a, b16, this.f78040c, this.f78041d, this.f78042e, null);
        }

        public Builder withAppKey(String str) {
            this.f78038a = str;
            return this;
        }

        public Builder withCode(String str) {
            this.f78039b = str;
            return this;
        }

        public Builder withIsSucceed(boolean z16) {
            this.f78041d = z16;
            return this;
        }

        public Builder withParams(Map<String, String> map) {
            if (map != null) {
                this.f78042e.putAll(map);
            }
            return this;
        }

        public Builder withType(EventType eventType) {
            this.f78040c = eventType;
            return this;
        }

        /* synthetic */ Builder(BeaconEvent beaconEvent, a aVar) {
            this(beaconEvent);
        }

        public Builder withParams(@NonNull String str, String str2) {
            this.f78042e.put(str, str2);
            return this;
        }

        Builder() {
            this.f78040c = EventType.NORMAL;
            this.f78041d = true;
            this.f78042e = new HashMap();
        }

        Builder(BeaconEvent beaconEvent) {
            this.f78040c = EventType.NORMAL;
            this.f78041d = true;
            this.f78042e = new HashMap();
            this.f78038a = beaconEvent.f78033a;
            this.f78039b = beaconEvent.f78034b;
            this.f78040c = beaconEvent.f78035c;
            this.f78041d = beaconEvent.f78036d;
            this.f78042e.putAll(beaconEvent.f78037e);
        }
    }

    /* synthetic */ BeaconEvent(String str, String str2, EventType eventType, boolean z16, Map map, a aVar) {
        this(str, str2, eventType, z16, map);
    }

    public static Builder builder() {
        return new Builder((a) null);
    }

    public static Builder newBuilder(BeaconEvent beaconEvent) {
        return new Builder(beaconEvent, null);
    }

    public String getAppKey() {
        return this.f78033a;
    }

    public String getCode() {
        return this.f78034b;
    }

    public String getLogidPrefix() {
        switch (a.f78050a[this.f78035c.ordinal()]) {
            case 1:
            case 2:
                return "N";
            case 3:
            case 4:
                return "I";
            case 5:
            case 6:
                return "Y";
            default:
                return "";
        }
    }

    public Map<String, String> getParams() {
        return this.f78037e;
    }

    public EventType getType() {
        return this.f78035c;
    }

    public boolean isSucceed() {
        return this.f78036d;
    }

    public void setAppKey(String str) {
        this.f78033a = str;
    }

    public void setCode(String str) {
        this.f78034b = str;
    }

    public void setParams(Map<String, String> map) {
        this.f78037e = map;
    }

    public void setSucceed(boolean z16) {
        this.f78036d = z16;
    }

    public void setType(EventType eventType) {
        this.f78035c = eventType;
    }

    public String toString() {
        return super.toString();
    }

    BeaconEvent(String str, String str2, EventType eventType, boolean z16, Map<String, String> map) {
        this.f78033a = str;
        this.f78034b = str2;
        this.f78035c = eventType;
        this.f78036d = z16;
        this.f78037e = map;
    }
}
