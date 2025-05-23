package com.tencent.gamematrix.gmcg.sdk.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.tencent.gamematrix.gmcg.base.log.CGLog;
import com.tencent.gamematrix.gmcg.base.utils.CGPermissionUtil;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class CGLocationGetter {
    private static Location sCachedLocation;
    private final Context mContext;
    private LocationListener mLocationListener;
    private LocationManager mLocationManager;
    private final CGLocationResultListener mLocationResultListener;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface CGLocationResultListener {
        void onGotLocation(Location location);
    }

    public CGLocationGetter(Context context, CGLocationResultListener cGLocationResultListener) {
        this.mContext = context;
        this.mLocationResultListener = cGLocationResultListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LogE(String str) {
        CGLog.e("CGLocationGetter " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void LogI(String str) {
        CGLog.i("CGLocationGetter " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void afterGotLocation(Location location) {
        LogI("Location: got location " + location.toString());
        sCachedLocation = location;
        CGLocationResultListener cGLocationResultListener = this.mLocationResultListener;
        if (cGLocationResultListener != null) {
            cGLocationResultListener.onGotLocation(location);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:14|(1:42)(2:18|(7:20|(2:38|(1:40))|22|23|24|25|(2:27|28)(4:29|30|31|32)))|41|23|24|25|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x008a, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0091  */
    @SuppressLint({"MissingPermission"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void startGetLocation() {
        String str;
        Location location;
        LogI("Location: getLocation");
        if (!CGPermissionUtil.hasPermissions(this.mContext, "android.permission.ACCESS_FINE_LOCATION")) {
            LogI("Location: not have location permission");
            return;
        }
        if (sCachedLocation != null) {
            LogI("Location: has cached location");
            afterGotLocation(sCachedLocation);
            return;
        }
        LocationManager locationManager = (LocationManager) this.mContext.getSystemService("location");
        this.mLocationManager = locationManager;
        if (locationManager == null) {
            LogE("Location: failed to get LOCATION_SERVICE");
            return;
        }
        List<String> providers = locationManager.getProviders(true);
        if (providers != null && !providers.isEmpty()) {
            if (!providers.contains("fused")) {
                String str2 = "network";
                if (!providers.contains("network")) {
                    str2 = "gps";
                    if (!providers.contains("gps")) {
                        LogE("Location: no valid enabled location providers");
                    }
                }
                str = str2;
                LogI("Location: do actual getLastKnownLocation");
                location = LocationMonitor.getLastKnownLocation(this.mLocationManager, str);
                if (location == null) {
                    afterGotLocation(location);
                    return;
                }
                this.mLocationListener = new LocationListener() { // from class: com.tencent.gamematrix.gmcg.sdk.impl.CGLocationGetter.1
                    @Override // android.location.LocationListener
                    public void onLocationChanged(Location location2) {
                        CGLocationGetter.this.LogI("Location onLocationChanged: " + location2.toString());
                        CGLocationGetter.this.afterGotLocation(location2);
                    }

                    @Override // android.location.LocationListener
                    public void onProviderDisabled(String str3) {
                        CGLocationGetter.this.LogE("Location onProviderEnabled: " + str3 + " disabled");
                    }

                    @Override // android.location.LocationListener
                    public void onProviderEnabled(String str3) {
                        CGLocationGetter.this.LogI("Location onProviderEnabled: " + str3 + " enabled");
                    }

                    @Override // android.location.LocationListener
                    public void onStatusChanged(String str3, int i3, Bundle bundle) {
                        if (i3 == 0) {
                            CGLocationGetter.this.LogI("Location onStatusChanged: " + str3 + " is out of service");
                        }
                        if (i3 == 2) {
                            CGLocationGetter.this.LogI("Location onStatusChanged: " + str3 + " is available");
                        }
                        if (i3 == 1) {
                            CGLocationGetter.this.LogI("Location onStatusChanged: " + str3 + "is temporarily unavailable");
                        }
                    }
                };
                LogI("Location: requestLocationUpdates " + str);
                try {
                    LocationMonitor.requestLocationUpdates(this.mLocationManager, str, 1000L, 0.0f, this.mLocationListener);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
        } else {
            LogE("Location: no enabled location providers");
        }
        str = "fused";
        LogI("Location: do actual getLastKnownLocation");
        location = LocationMonitor.getLastKnownLocation(this.mLocationManager, str);
        if (location == null) {
        }
    }

    @SuppressLint({"MissingPermission"})
    public void stopGetLocation() {
        LocationListener locationListener;
        LogI("Location: destroy gps manager");
        try {
            LocationManager locationManager = this.mLocationManager;
            if (locationManager != null && (locationListener = this.mLocationListener) != null) {
                LocationMonitor.removeUpdates(locationManager, locationListener);
            }
        } catch (Exception unused) {
        }
        this.mLocationListener = null;
        this.mLocationManager = null;
    }
}
