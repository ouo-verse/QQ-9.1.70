package com.tencent.map.geolocation;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes9.dex */
public class TencentGeofence {

    /* renamed from: a, reason: collision with root package name */
    public final int f147553a;

    /* renamed from: b, reason: collision with root package name */
    public final double f147554b;

    /* renamed from: c, reason: collision with root package name */
    public final double f147555c;

    /* renamed from: d, reason: collision with root package name */
    public final float f147556d;

    /* renamed from: e, reason: collision with root package name */
    public final long f147557e;

    /* renamed from: f, reason: collision with root package name */
    public final String f147558f;

    /* renamed from: g, reason: collision with root package name */
    public final long f147559g;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        public double f147560a;

        /* renamed from: b, reason: collision with root package name */
        public double f147561b;

        /* renamed from: c, reason: collision with root package name */
        public float f147562c;

        /* renamed from: d, reason: collision with root package name */
        public long f147563d;

        /* renamed from: e, reason: collision with root package name */
        public String f147564e;

        public static void a(long j3) {
            if (j3 >= 0) {
                return;
            }
            throw new IllegalArgumentException("invalid duration: " + j3);
        }

        public TencentGeofence build() {
            return new TencentGeofence(0, this.f147560a, this.f147561b, this.f147562c, this.f147563d, this.f147564e);
        }

        public Builder setCircularRegion(double d16, double d17, float f16) {
            a(f16);
            a(d16, d17);
            this.f147560a = d16;
            this.f147561b = d17;
            this.f147562c = f16;
            return this;
        }

        public Builder setExpirationDuration(long j3) {
            a(j3);
            this.f147563d = j3;
            return this;
        }

        public Builder setTag(String str) {
            if (!TextUtils.isEmpty(str)) {
                this.f147564e = str;
                return this;
            }
            throw null;
        }

        public static void a(float f16) {
            if (f16 > 0.0f) {
                return;
            }
            throw new IllegalArgumentException("invalid radius: " + f16);
        }

        public static void a(double d16, double d17) {
            if (d16 > 90.0d || d16 < -90.0d) {
                throw new IllegalArgumentException("invalid latitude: " + d16);
            }
            if (d17 > 180.0d || d17 < -180.0d) {
                throw new IllegalArgumentException("invalid longitude: " + d17);
            }
        }
    }

    public static void a(int i3) {
        if (i3 == 0) {
            return;
        }
        throw new IllegalArgumentException("invalid type: " + i3);
    }

    public static String b(int i3) {
        if (i3 != 0) {
            a(i3);
            return null;
        }
        return "CIRCLE";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TencentGeofence tencentGeofence = (TencentGeofence) obj;
        if (Double.doubleToLongBits(this.f147554b) != Double.doubleToLongBits(tencentGeofence.f147554b) || Double.doubleToLongBits(this.f147555c) != Double.doubleToLongBits(tencentGeofence.f147555c)) {
            return false;
        }
        String str = this.f147558f;
        if (str == null) {
            if (tencentGeofence.f147558f != null) {
                return false;
            }
        } else if (!str.equals(tencentGeofence.f147558f)) {
            return false;
        }
        return true;
    }

    public long getDuration() {
        return this.f147559g;
    }

    public long getExpireAt() {
        return this.f147557e;
    }

    public double getLatitude() {
        return this.f147554b;
    }

    public double getLongitude() {
        return this.f147555c;
    }

    public float getRadius() {
        return this.f147556d;
    }

    public String getTag() {
        return this.f147558f;
    }

    public int hashCode() {
        int hashCode;
        long doubleToLongBits = Double.doubleToLongBits(this.f147554b);
        long doubleToLongBits2 = Double.doubleToLongBits(this.f147555c);
        int i3 = (((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) (doubleToLongBits2 ^ (doubleToLongBits2 >>> 32)))) * 31;
        String str = this.f147558f;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return i3 + hashCode;
    }

    public String toString() {
        return String.format(Locale.US, "TencentGeofence[tag=%s, type=%s, loc=(%.6f, %.6f), radius=%.2fm life=%.2fs]", this.f147558f, b(this.f147553a), Double.valueOf(this.f147554b), Double.valueOf(this.f147555c), Float.valueOf(this.f147556d), Double.valueOf((this.f147557e - SystemClock.elapsedRealtime()) / 1000.0d));
    }

    public TencentGeofence(int i3, double d16, double d17, float f16, long j3, String str) {
        this.f147553a = i3;
        this.f147554b = d16;
        this.f147555c = d17;
        this.f147556d = f16;
        this.f147559g = j3;
        this.f147557e = SystemClock.elapsedRealtime() + j3;
        this.f147558f = str;
    }
}
