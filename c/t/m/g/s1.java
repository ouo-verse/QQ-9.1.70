package c.t.m.g;

import android.location.Location;
import android.text.format.DateFormat;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;

/* compiled from: P */
/* loaded from: classes.dex */
public class s1 {
    public static Location a(TencentLocation tencentLocation, boolean z16) {
        if (tencentLocation == null) {
            return null;
        }
        String provider = tencentLocation.getProvider();
        Location location = new Location(provider);
        location.setLatitude(tencentLocation.getLatitude());
        location.setLongitude(tencentLocation.getLongitude());
        location.setAccuracy(tencentLocation.getAccuracy());
        location.setTime(tencentLocation.getTime());
        if (z16 && "gps".equals(provider)) {
            double[] dArr = new double[2];
            t3.a(location, dArr);
            location.setLatitude(dArr[0]);
            location.setLongitude(dArr[1]);
            ((h3) tencentLocation).b(location);
        }
        return location;
    }

    public static String a(TencentLocation tencentLocation, int i3) {
        long time;
        if (tencentLocation == null) {
            time = System.currentTimeMillis();
        } else {
            time = tencentLocation.getTime();
        }
        return ((Object) DateFormat.format("yyyy-MM-dd kk:mm:ss", time)) + " error=" + i3 + tencentLocation + "\n";
    }

    public static void a(Location location) {
        if (LocationMonitor.getAccuracy(location) > 500.0f) {
            location.setAccuracy(500.0f);
        }
    }
}
