package com.huawei.hms.videokit.hdrability.ability;

import android.content.Context;
import android.util.Log;
import android.view.SurfaceView;
import com.huawei.hms.videokit.hdrability.util.BrightnessUtil;
import com.huawei.hms.videokit.hdrability.util.a;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class HdrAbility {
    public static final int BRIGHTNESS_NIT_INVALID = -1;
    public static final int BRIGHTNESS_NIT_MAX = 10000;
    public static final int BRIGHTNESS_NIT_MIN = 203;
    public static final int HDR_ABILITY_ERROR_ILLEGAL_ARGUMENT = 3;
    public static final int HDR_ABILITY_ERROR_ILLEGAL_STATE = 2;
    public static final int HDR_ABILITY_ERROR_UNKNOWN = -1;
    public static final int HDR_ABILITY_ERROR_UNSUPPORTED = 1;
    public static final int HDR_ABILITY_SUCCESS = 0;

    HdrAbility() {
    }

    public static synchronized int getScreenBrightness() {
        int b16;
        synchronized (HdrAbility.class) {
            b16 = BrightnessUtil.b();
        }
        return b16;
    }

    public static String getSupportedHdrType() {
        Log.i("HdrAbility", "getSupportedHdrType");
        return a.a().b();
    }

    public static int init(Context context) {
        Log.i("HdrAbility", "init");
        if (context == null) {
            Log.e("HdrAbility", "init context is null");
            return 3;
        }
        BrightnessUtil.a(context);
        return 0;
    }

    public static synchronized int registerScreenBrightnessObserver(Context context) {
        synchronized (HdrAbility.class) {
            if (context == null) {
                Log.e("HdrAbility", "context is null");
                return 3;
            }
            BrightnessUtil.a(context);
            return BrightnessUtil.e();
        }
    }

    public static int setBrightness(int i3) {
        Log.i("HdrAbility", "setBrightness " + i3);
        return BrightnessUtil.b(i3);
    }

    public static boolean setCaptionsLayer(SurfaceView surfaceView, double d16) {
        String str;
        Log.i("HdrAbility", "setCaptionsLayer " + d16 + " " + surfaceView);
        if (d16 < 1.0d) {
            str = "setCaptionsLayer failed, illegal argument ratio " + d16;
        } else if (surfaceView == null) {
            str = "setCaptionsLayer failed, surfaceView is null";
        } else {
            if (a.a(surfaceView, d16) != 0) {
                return false;
            }
            return true;
        }
        Log.e("HdrAbility", str);
        return false;
    }

    public static boolean setHdrAbility(boolean z16) {
        Log.i("HdrAbility", "setHdrAbility " + z16);
        if (a.a(z16) == 0) {
            return true;
        }
        return false;
    }

    public static boolean setHdrLayer(SurfaceView surfaceView, boolean z16) {
        Log.i("HdrAbility", "setHdrLayer " + z16 + " " + surfaceView);
        if (surfaceView == null) {
            Log.e("HdrAbility", "setHdrLayer failed, surfaceView is null");
            return false;
        }
        if (a.a(surfaceView, z16) != 0) {
            return false;
        }
        return true;
    }

    public static synchronized int unregisterScreenBrightnessObserver() {
        int f16;
        synchronized (HdrAbility.class) {
            f16 = BrightnessUtil.f();
        }
        return f16;
    }
}
