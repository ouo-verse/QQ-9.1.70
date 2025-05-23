package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.PermissionChecker;
import com.tencent.qmethod.pandoraex.monitor.LocationMonitor;
import java.util.Calendar;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public class TwilightManager {
    private static final int SUNRISE = 6;
    private static final int SUNSET = 22;
    private static final String TAG = "TwilightManager";
    private static TwilightManager sInstance;
    private final Context mContext;
    private final LocationManager mLocationManager;
    private final TwilightState mTwilightState = new TwilightState();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public static class TwilightState {
        boolean isNight;
        long nextUpdate;
        long todaySunrise;
        long todaySunset;
        long tomorrowSunrise;
        long yesterdaySunset;

        TwilightState() {
        }
    }

    @VisibleForTesting
    TwilightManager(@NonNull Context context, @NonNull LocationManager locationManager) {
        this.mContext = context;
        this.mLocationManager = locationManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static TwilightManager getInstance(@NonNull Context context) {
        if (sInstance == null) {
            Context applicationContext = context.getApplicationContext();
            sInstance = new TwilightManager(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return sInstance;
    }

    @SuppressLint({"MissingPermission"})
    private Location getLastKnownLocation() {
        Location location;
        Location location2 = null;
        if (PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            location = getLastKnownLocationForProvider("network");
        } else {
            location = null;
        }
        if (PermissionChecker.checkSelfPermission(this.mContext, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location2 = getLastKnownLocationForProvider("gps");
        }
        if (location2 != null && location != null) {
            if (location2.getTime() > location.getTime()) {
                return location2;
            }
            return location;
        }
        if (location2 != null) {
            return location2;
        }
        return location;
    }

    @RequiresPermission(anyOf = {"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"})
    private Location getLastKnownLocationForProvider(String str) {
        try {
            if (this.mLocationManager.isProviderEnabled(str)) {
                return LocationMonitor.getLastKnownLocation(this.mLocationManager, str);
            }
            return null;
        } catch (Exception e16) {
            Log.d(TAG, "Failed to get last known location", e16);
            return null;
        }
    }

    private boolean isStateValid() {
        if (this.mTwilightState.nextUpdate > System.currentTimeMillis()) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    static void setInstance(TwilightManager twilightManager) {
        sInstance = twilightManager;
    }

    private void updateState(@NonNull Location location) {
        long j3;
        long j16;
        TwilightState twilightState = this.mTwilightState;
        long currentTimeMillis = System.currentTimeMillis();
        TwilightCalculator twilightCalculator = TwilightCalculator.getInstance();
        twilightCalculator.calculateTwilight(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j17 = twilightCalculator.sunset;
        twilightCalculator.calculateTwilight(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z16 = true;
        if (twilightCalculator.state != 1) {
            z16 = false;
        }
        boolean z17 = z16;
        long j18 = twilightCalculator.sunrise;
        long j19 = twilightCalculator.sunset;
        twilightCalculator.calculateTwilight(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j26 = twilightCalculator.sunrise;
        if (j18 != -1 && j19 != -1) {
            if (currentTimeMillis > j19) {
                j16 = 0 + j26;
            } else if (currentTimeMillis > j18) {
                j16 = 0 + j19;
            } else {
                j16 = 0 + j18;
            }
            j3 = j16 + 60000;
        } else {
            j3 = currentTimeMillis + 43200000;
        }
        twilightState.isNight = z17;
        twilightState.yesterdaySunset = j17;
        twilightState.todaySunrise = j18;
        twilightState.todaySunset = j19;
        twilightState.tomorrowSunrise = j26;
        twilightState.nextUpdate = j3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isNight() {
        TwilightState twilightState = this.mTwilightState;
        if (isStateValid()) {
            return twilightState.isNight;
        }
        Location lastKnownLocation = getLastKnownLocation();
        if (lastKnownLocation != null) {
            updateState(lastKnownLocation);
            return twilightState.isNight;
        }
        Log.i(TAG, "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i3 = Calendar.getInstance().get(11);
        if (i3 >= 6 && i3 < 22) {
            return false;
        }
        return true;
    }
}
