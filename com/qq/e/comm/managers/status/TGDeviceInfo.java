package com.qq.e.comm.managers.status;

import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes3.dex */
public class TGDeviceInfo {

    /* renamed from: a, reason: collision with root package name */
    private String f38261a;

    /* renamed from: b, reason: collision with root package name */
    private String f38262b;

    /* renamed from: c, reason: collision with root package name */
    private String f38263c;

    /* renamed from: d, reason: collision with root package name */
    private String f38264d;

    /* renamed from: e, reason: collision with root package name */
    private String f38265e;

    /* renamed from: f, reason: collision with root package name */
    private String f38266f;

    /* renamed from: g, reason: collision with root package name */
    private String f38267g;

    /* renamed from: h, reason: collision with root package name */
    private String f38268h;

    /* renamed from: i, reason: collision with root package name */
    private float f38269i;

    /* renamed from: j, reason: collision with root package name */
    private String f38270j;

    /* renamed from: k, reason: collision with root package name */
    private String f38271k;

    /* renamed from: l, reason: collision with root package name */
    private String f38272l;

    /* renamed from: m, reason: collision with root package name */
    private String f38273m;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class DeviceInfoBuilder {

        /* renamed from: a, reason: collision with root package name */
        private String f38274a;

        /* renamed from: b, reason: collision with root package name */
        private String f38275b;

        /* renamed from: c, reason: collision with root package name */
        private String f38276c;

        /* renamed from: d, reason: collision with root package name */
        private String f38277d;

        /* renamed from: e, reason: collision with root package name */
        private String f38278e;

        /* renamed from: f, reason: collision with root package name */
        private String f38279f;

        /* renamed from: g, reason: collision with root package name */
        private String f38280g;

        /* renamed from: h, reason: collision with root package name */
        private String f38281h;

        /* renamed from: i, reason: collision with root package name */
        private float f38282i;

        /* renamed from: j, reason: collision with root package name */
        private String f38283j;

        /* renamed from: k, reason: collision with root package name */
        private String f38284k;

        /* renamed from: l, reason: collision with root package name */
        private String f38285l;

        /* renamed from: m, reason: collision with root package name */
        private String f38286m;

        public DeviceInfoBuilder activeNetType(String str) {
            this.f38279f = str;
            return this;
        }

        public DeviceInfoBuilder androidId(String str) {
            this.f38285l = str;
            return this;
        }

        public TGDeviceInfo build() {
            return new TGDeviceInfo(this, (byte) 0);
        }

        public DeviceInfoBuilder buildModel(String str) {
            this.f38286m = str;
            return this;
        }

        public DeviceInfoBuilder deviceId(String str) {
            this.f38275b = str;
            return this;
        }

        public DeviceInfoBuilder imei(String str) {
            this.f38274a = str;
            return this;
        }

        public DeviceInfoBuilder imsi(String str) {
            this.f38276c = str;
            return this;
        }

        public DeviceInfoBuilder lat(String str) {
            this.f38280g = str;
            return this;
        }

        public DeviceInfoBuilder lng(String str) {
            this.f38281h = str;
            return this;
        }

        public DeviceInfoBuilder locationAccuracy(float f16) {
            this.f38282i = f16;
            return this;
        }

        public DeviceInfoBuilder netWorkType(String str) {
            this.f38278e = str;
            return this;
        }

        public DeviceInfoBuilder oaid(String str) {
            this.f38284k = str;
            return this;
        }

        public DeviceInfoBuilder operator(String str) {
            this.f38277d = str;
            return this;
        }

        public DeviceInfoBuilder taid(String str) {
            this.f38283j = str;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public static class InvalidValue {
        public static final int INT_VALUE = 1000;
        public static final long LONG_VALUE = 1000;
        public static final String STRING_VALUE = "1000";
    }

    TGDeviceInfo(DeviceInfoBuilder deviceInfoBuilder) {
        this.f38261a = deviceInfoBuilder.f38274a;
        this.f38264d = deviceInfoBuilder.f38277d;
        this.f38265e = deviceInfoBuilder.f38278e;
        this.f38266f = deviceInfoBuilder.f38279f;
        this.f38267g = deviceInfoBuilder.f38280g;
        this.f38268h = deviceInfoBuilder.f38281h;
        this.f38269i = deviceInfoBuilder.f38282i;
        this.f38270j = deviceInfoBuilder.f38283j;
        this.f38272l = deviceInfoBuilder.f38284k;
        this.f38273m = deviceInfoBuilder.f38285l;
        this.f38262b = deviceInfoBuilder.f38275b;
        this.f38263c = deviceInfoBuilder.f38276c;
        this.f38271k = deviceInfoBuilder.f38286m;
    }

    public String getActiveNetType() {
        return this.f38266f;
    }

    public String getAndroidId() {
        return this.f38273m;
    }

    public String getBuildModel() {
        return this.f38271k;
    }

    public String getDeviceId() {
        return this.f38262b;
    }

    public String getImei() {
        return this.f38261a;
    }

    public String getImsi() {
        return this.f38263c;
    }

    public String getLat() {
        return this.f38267g;
    }

    public String getLng() {
        return this.f38268h;
    }

    public float getLocationAccuracy() {
        return this.f38269i;
    }

    public String getNetWorkType() {
        return this.f38265e;
    }

    public String getOaid() {
        return this.f38272l;
    }

    public String getOperator() {
        return this.f38264d;
    }

    public String getTaid() {
        return this.f38270j;
    }

    public boolean isNeedLocationBySdk() {
        if (TextUtils.isEmpty(this.f38267g) && TextUtils.isEmpty(this.f38268h)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "TGSensitiveDeviceInfo{imei='" + this.f38261a + "', operator='" + this.f38264d + "', netWorkType='" + this.f38265e + "', activeNetType='" + this.f38266f + "', lat='" + this.f38267g + "', lng='" + this.f38268h + "', locationAccuracy=" + this.f38269i + ", taid='" + this.f38270j + "', oaid='" + this.f38272l + "', androidId='" + this.f38273m + "', buildModule='" + this.f38271k + "'}";
    }

    /* synthetic */ TGDeviceInfo(DeviceInfoBuilder deviceInfoBuilder, byte b16) {
        this(deviceInfoBuilder);
    }
}
