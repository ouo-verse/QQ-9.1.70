package c.t.m.g;

import android.app.PendingIntent;
import android.location.Location;
import com.tencent.map.geolocation.TencentGeofence;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes.dex */
public class r1 {

    /* renamed from: a, reason: collision with root package name */
    public final TencentGeofence f29958a;

    /* renamed from: b, reason: collision with root package name */
    public final Location f29959b;

    /* renamed from: c, reason: collision with root package name */
    public final long f29960c;

    /* renamed from: d, reason: collision with root package name */
    public final PendingIntent f29961d;

    /* renamed from: e, reason: collision with root package name */
    public int f29962e = 0;

    /* renamed from: f, reason: collision with root package name */
    public double f29963f = Double.MAX_VALUE;

    /* renamed from: g, reason: collision with root package name */
    public Object f29964g;

    public r1(TencentGeofence tencentGeofence, long j3, String str, PendingIntent pendingIntent) {
        this.f29958a = tencentGeofence;
        this.f29960c = j3;
        this.f29961d = pendingIntent;
        Location location = new Location("");
        this.f29959b = location;
        location.setLatitude(tencentGeofence.getLatitude());
        location.setLongitude(tencentGeofence.getLongitude());
        location.setTime(0L);
        location.setSpeed(-0.001f);
    }

    public int a(Location location) {
        if (location == this.f29964g) {
            return 0;
        }
        this.f29964g = location;
        double d16 = this.f29963f;
        double a16 = t3.a(location.getLatitude(), location.getLongitude(), this.f29959b.getLatitude(), this.f29959b.getLongitude());
        long time = this.f29959b.getTime();
        long time2 = location.getTime();
        float a17 = (float) a(d16, a16, time, time2);
        this.f29959b.setTime(time2);
        this.f29959b.setSpeed(a17);
        this.f29963f = a16;
        int i3 = this.f29962e;
        if (a16 <= ((double) this.f29958a.getRadius())) {
            this.f29962e = 1;
            if (i3 != 1) {
                return 1;
            }
        } else {
            this.f29962e = 2;
            if (i3 == 1) {
                return 2;
            }
        }
        return 0;
    }

    public float b() {
        float speed = this.f29959b.getSpeed();
        if (speed <= -0.001f) {
            return -0.001f;
        }
        if (speed > 25.0f) {
            return 25.0f;
        }
        if (speed < 1.0f) {
            return 1.0f;
        }
        return speed;
    }

    public boolean c() {
        if (this.f29962e != 1 && this.f29959b.getSpeed() >= 0.0f) {
            return true;
        }
        return false;
    }

    public String toString() {
        String str;
        int i3 = this.f29962e;
        if (i3 != 1) {
            if (i3 != 2) {
                str = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
            } else {
                str = "OUT";
            }
        } else {
            str = "IN";
        }
        return String.format(Locale.US, "%s dist=%5gm speed=%.2fm/s state=%s", this.f29958a.toString(), Double.valueOf(this.f29963f), Float.valueOf(b()), str);
    }

    public final double a(double d16, double d17, long j3, long j16) {
        if (j3 == 0) {
            return -0.0010000000474974513d;
        }
        if (d17 >= d16) {
            return 0.0d;
        }
        if (d17 >= d16) {
            return -0.0010000000474974513d;
        }
        long abs = Math.abs(j16 - j3) / 1000;
        double abs2 = Math.abs(d16 - d17);
        if (abs == 0) {
            abs++;
        }
        return abs2 / abs;
    }

    public double a() {
        if (Double.compare(this.f29963f, Double.MAX_VALUE) == 0) {
            return Double.MAX_VALUE;
        }
        return Math.abs(this.f29958a.getRadius() - this.f29963f);
    }
}
