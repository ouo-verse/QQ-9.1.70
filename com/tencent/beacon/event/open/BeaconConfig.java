package com.tencent.beacon.event.open;

import com.tencent.beacon.base.net.adapter.AbstractNetAdapter;
import com.tencent.beacon.base.util.c;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: P */
/* loaded from: classes2.dex */
public class BeaconConfig {
    private final boolean A;

    /* renamed from: a, reason: collision with root package name */
    private final int f77981a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f77982b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f77983c;

    /* renamed from: d, reason: collision with root package name */
    private final long f77984d;

    /* renamed from: e, reason: collision with root package name */
    private final long f77985e;

    /* renamed from: f, reason: collision with root package name */
    private final int f77986f;

    /* renamed from: g, reason: collision with root package name */
    private final int f77987g;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f77988h;

    /* renamed from: i, reason: collision with root package name */
    private final AbstractNetAdapter f77989i;

    /* renamed from: j, reason: collision with root package name */
    private final String f77990j;

    /* renamed from: k, reason: collision with root package name */
    private final String f77991k;

    /* renamed from: l, reason: collision with root package name */
    private final boolean f77992l;

    /* renamed from: m, reason: collision with root package name */
    private final boolean f77993m;

    /* renamed from: n, reason: collision with root package name */
    private final boolean f77994n;

    /* renamed from: o, reason: collision with root package name */
    private final String f77995o;

    /* renamed from: p, reason: collision with root package name */
    private final String f77996p;

    /* renamed from: q, reason: collision with root package name */
    private final String f77997q;

    /* renamed from: r, reason: collision with root package name */
    private final String f77998r;

    /* renamed from: s, reason: collision with root package name */
    private final String f77999s;

    /* renamed from: t, reason: collision with root package name */
    private final String f78000t;

    /* renamed from: u, reason: collision with root package name */
    private final String f78001u;

    /* renamed from: v, reason: collision with root package name */
    private final String f78002v;

    /* renamed from: w, reason: collision with root package name */
    private final String f78003w;

    /* renamed from: x, reason: collision with root package name */
    private final String f78004x;

    /* renamed from: y, reason: collision with root package name */
    private final boolean f78005y;

    /* renamed from: z, reason: collision with root package name */
    private final boolean f78006z;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class Builder {

        /* renamed from: d, reason: collision with root package name */
        private ScheduledExecutorService f78010d;

        /* renamed from: f, reason: collision with root package name */
        private AbstractNetAdapter f78012f;

        /* renamed from: k, reason: collision with root package name */
        private String f78017k;

        /* renamed from: l, reason: collision with root package name */
        private String f78018l;

        /* renamed from: a, reason: collision with root package name */
        private int f78007a = 10000;

        /* renamed from: b, reason: collision with root package name */
        private boolean f78008b = true;

        /* renamed from: c, reason: collision with root package name */
        private boolean f78009c = true;

        /* renamed from: e, reason: collision with root package name */
        private boolean f78011e = true;

        /* renamed from: g, reason: collision with root package name */
        private long f78013g = 2000;

        /* renamed from: h, reason: collision with root package name */
        private long f78014h = 5000;

        /* renamed from: i, reason: collision with root package name */
        private int f78015i = 48;

        /* renamed from: j, reason: collision with root package name */
        private int f78016j = 48;

        /* renamed from: m, reason: collision with root package name */
        private boolean f78019m = false;

        /* renamed from: n, reason: collision with root package name */
        private boolean f78020n = true;

        /* renamed from: o, reason: collision with root package name */
        private boolean f78021o = true;

        /* renamed from: p, reason: collision with root package name */
        private String f78022p = "";

        /* renamed from: q, reason: collision with root package name */
        private String f78023q = "";

        /* renamed from: r, reason: collision with root package name */
        private String f78024r = "";

        /* renamed from: s, reason: collision with root package name */
        private String f78025s = "";

        /* renamed from: t, reason: collision with root package name */
        private String f78026t = "";

        /* renamed from: u, reason: collision with root package name */
        private String f78027u = "";

        /* renamed from: v, reason: collision with root package name */
        private String f78028v = "";

        /* renamed from: w, reason: collision with root package name */
        private String f78029w = "";

        /* renamed from: x, reason: collision with root package name */
        private String f78030x = "";

        /* renamed from: y, reason: collision with root package name */
        private String f78031y = "";

        /* renamed from: z, reason: collision with root package name */
        private boolean f78032z = true;
        private boolean A = true;
        private boolean B = true;

        public Builder auditEnable(boolean z16) {
            this.f78008b = z16;
            return this;
        }

        public Builder bidEnable(boolean z16) {
            this.f78009c = z16;
            return this;
        }

        public BeaconConfig build() {
            ScheduledExecutorService scheduledExecutorService = this.f78010d;
            if (scheduledExecutorService != null) {
                com.tencent.beacon.a.b.a.a(scheduledExecutorService);
            }
            return new BeaconConfig(this);
        }

        @Deprecated
        public Builder eventReportEnable(boolean z16) {
            c.b("eventReportEnable is deprecated!", new Object[0]);
            return this;
        }

        public Builder maxDBCount(int i3) {
            this.f78007a = i3;
            return this;
        }

        public Builder pagePathEnable(boolean z16) {
            this.f78021o = z16;
            return this;
        }

        public Builder qmspEnable(boolean z16) {
            this.f78020n = z16;
            return this;
        }

        public Builder setAndroidID(String str) {
            this.f78022p = str;
            return this;
        }

        public Builder setConfigHost(String str) {
            this.f78018l = str;
            return this;
        }

        public Builder setExecutorService(ScheduledExecutorService scheduledExecutorService) {
            this.f78010d = scheduledExecutorService;
            return this;
        }

        public Builder setForceEnableAtta(boolean z16) {
            this.f78019m = z16;
            return this;
        }

        public Builder setHttpAdapter(AbstractNetAdapter abstractNetAdapter) {
            this.f78012f = abstractNetAdapter;
            return this;
        }

        public Builder setImei(String str) {
            this.f78023q = str;
            return this;
        }

        public Builder setImei2(String str) {
            this.f78024r = str;
            return this;
        }

        public Builder setImsi(String str) {
            this.f78025s = str;
            return this;
        }

        public Builder setIsSocketMode(boolean z16) {
            this.f78011e = z16;
            return this;
        }

        public Builder setMac(String str) {
            this.f78028v = str;
            return this;
        }

        public Builder setMeid(String str) {
            this.f78026t = str;
            return this;
        }

        public Builder setModel(String str) {
            this.f78027u = str;
            return this;
        }

        public Builder setNeedAttaReport(boolean z16) {
            this.B = z16;
            return this;
        }

        public Builder setNeedInitQimei(boolean z16) {
            this.f78032z = z16;
            return this;
        }

        public Builder setNeedReportRqdEvent(boolean z16) {
            this.A = z16;
            return this;
        }

        public Builder setNormalPollingTime(long j3) {
            this.f78014h = j3;
            return this;
        }

        public Builder setNormalUploadNum(int i3) {
            this.f78016j = i3;
            return this;
        }

        public Builder setOaid(String str) {
            this.f78031y = str;
            return this;
        }

        public Builder setRealtimePollingTime(long j3) {
            this.f78013g = j3;
            return this;
        }

        public Builder setRealtimeUploadNum(int i3) {
            this.f78015i = i3;
            return this;
        }

        public Builder setUploadHost(String str) {
            this.f78017k = str;
            return this;
        }

        public Builder setWifiMacAddress(String str) {
            this.f78029w = str;
            return this;
        }

        public Builder setWifiSSID(String str) {
            this.f78030x = str;
            return this;
        }
    }

    public BeaconConfig(Builder builder) {
        this.f77981a = builder.f78007a;
        this.f77982b = builder.f78008b;
        this.f77983c = builder.f78009c;
        this.f77984d = builder.f78013g;
        this.f77985e = builder.f78014h;
        this.f77986f = builder.f78015i;
        this.f77987g = builder.f78016j;
        this.f77988h = builder.f78011e;
        this.f77989i = builder.f78012f;
        this.f77990j = builder.f78017k;
        this.f77991k = builder.f78018l;
        this.f77992l = builder.f78019m;
        this.f77993m = builder.f78020n;
        this.f77994n = builder.f78021o;
        this.f77995o = builder.f78022p;
        this.f77996p = builder.f78023q;
        this.f77997q = builder.f78024r;
        this.f77998r = builder.f78025s;
        this.f77999s = builder.f78026t;
        this.f78000t = builder.f78027u;
        this.f78001u = builder.f78028v;
        this.f78002v = builder.f78029w;
        this.f78003w = builder.f78030x;
        this.f78004x = builder.f78031y;
        this.f78005y = builder.f78032z;
        this.f78006z = builder.A;
        this.A = builder.B;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getAndroidID() {
        return this.f77995o;
    }

    public String getConfigHost() {
        return this.f77991k;
    }

    public AbstractNetAdapter getHttpAdapter() {
        return this.f77989i;
    }

    public String getImei() {
        return this.f77996p;
    }

    public String getImei2() {
        return this.f77997q;
    }

    public String getImsi() {
        return this.f77998r;
    }

    public String getMac() {
        return this.f78001u;
    }

    public int getMaxDBCount() {
        return this.f77981a;
    }

    public String getMeid() {
        return this.f77999s;
    }

    public String getModel() {
        return this.f78000t;
    }

    public long getNormalPollingTIme() {
        return this.f77985e;
    }

    public int getNormalUploadNum() {
        return this.f77987g;
    }

    public String getOaid() {
        return this.f78004x;
    }

    public long getRealtimePollingTime() {
        return this.f77984d;
    }

    public int getRealtimeUploadNum() {
        return this.f77986f;
    }

    public String getUploadHost() {
        return this.f77990j;
    }

    public String getWifiMacAddress() {
        return this.f78002v;
    }

    public String getWifiSSID() {
        return this.f78003w;
    }

    public boolean isAuditEnable() {
        return this.f77982b;
    }

    public boolean isBidEnable() {
        return this.f77983c;
    }

    public boolean isEnableQmsp() {
        return this.f77993m;
    }

    public boolean isForceEnableAtta() {
        return this.f77992l;
    }

    public boolean isNeedInitQimei() {
        return this.f78005y;
    }

    public boolean isPagePathEnable() {
        return this.f77994n;
    }

    public boolean isSocketMode() {
        return this.f77988h;
    }

    public boolean needAttaReport() {
        return this.A;
    }

    public boolean needReportRqdEvent() {
        return this.f78006z;
    }

    public String toString() {
        return "BeaconConfig{maxDBCount=" + this.f77981a + ", auditEnable=" + this.f77982b + ", bidEnable=" + this.f77983c + ", realtimePollingTime=" + this.f77984d + ", normalPollingTIme=" + this.f77985e + ", normalUploadNum=" + this.f77987g + ", realtimeUploadNum=" + this.f77986f + ", httpAdapter=" + this.f77989i + ", uploadHost='" + this.f77990j + "', configHost='" + this.f77991k + "', forceEnableAtta=" + this.f77992l + ", enableQmsp=" + this.f77993m + ", pagePathEnable=" + this.f77994n + ", androidID='" + this.f77995o + "', imei='" + this.f77996p + "', imei2='" + this.f77997q + "', imsi='" + this.f77998r + "', meid='" + this.f77999s + "', model='" + this.f78000t + "', mac='" + this.f78001u + "', wifiMacAddress='" + this.f78002v + "', wifiSSID='" + this.f78003w + "', oaid='" + this.f78004x + "', needInitQ='" + this.f78005y + "'}";
    }
}
