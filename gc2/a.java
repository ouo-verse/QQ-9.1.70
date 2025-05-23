package gc2;

import android.content.Intent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import gc2.b;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static SosoLbsInfo f401913a;

    /* renamed from: b, reason: collision with root package name */
    private static String f401914b;

    /* renamed from: c, reason: collision with root package name */
    private static String f401915c;

    private static double a(double d16, double d17, double d18, double d19) {
        double d26 = d(d16);
        double d27 = d(d18);
        return Math.asin(Math.sqrt(Math.pow(Math.sin((d26 - d27) / 2.0d), 2.0d) + (Math.cos(d26) * Math.cos(d27) * Math.pow(Math.sin((d(d17) - d(d19)) / 2.0d), 2.0d)))) * 2.0d * 6378137.0d;
    }

    public static double b(LatLng latLng, LatLng latLng2) {
        return a(latLng.latitude, latLng.longitude, latLng2.latitude, latLng2.longitude);
    }

    public static void c(int i3, Intent intent, b.InterfaceC10368b interfaceC10368b) {
        boolean booleanExtra = intent.getBooleanExtra("isAppForeground", false);
        if (QLog.isColorLevel()) {
            QLog.e("LocationHelper", 2, "[status][LocationUtil] isAppForeground : " + booleanExtra);
        }
        if (booleanExtra) {
            ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).startLocation(new b(i3, intent, interfaceC10368b));
            return;
        }
        if (f401913a != null && f401914b != null && f401915c != null) {
            SosoLocation sosoLocation = f401913a.mLocation;
            LatLng latLng = new LatLng(sosoLocation.mLat02, sosoLocation.mLon02);
            interfaceC10368b.n(0, latLng.latitude, latLng.longitude, f401914b, f401915c, i3, intent);
        }
    }

    private static double d(double d16) {
        return (d16 * 3.141592653589793d) / 180.0d;
    }

    public static void e(SosoLbsInfo sosoLbsInfo, String str, String str2) {
        f401913a = sosoLbsInfo;
        f401914b = str;
        f401915c = str2;
    }
}
