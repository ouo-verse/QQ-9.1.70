package com.tencent.liteav.videobase.videobase;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.Size;
import com.tencent.liteav.base.util.i;
import com.tencent.liteav.base.util.k;

/* compiled from: P */
@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
public class SystemDisplayInfo {
    private static final String TAG = "SystemDisplayInfo";

    private static Display getDefaultDisplayByWindowManager() {
        Context c16 = i.a().c();
        if (c16 == null) {
            c16 = ContextUtils.getApplicationContext();
        }
        if (c16 == null) {
            LiteavLog.e(TAG, "context is null.");
            return null;
        }
        try {
            return ((WindowManager) c16.getSystemService("window")).getDefaultDisplay();
        } catch (Throwable th5) {
            LiteavLog.e(TAG, "error getting display from window service.", th5);
            return null;
        }
    }

    public static Display getDisplay() {
        if (nativeGetDisplayRotationObtainMethod() == 0) {
            Display displayByDisplayManager = getDisplayByDisplayManager();
            if (displayByDisplayManager != null) {
                return displayByDisplayManager;
            }
            return getDefaultDisplayByWindowManager();
        }
        Display defaultDisplayByWindowManager = getDefaultDisplayByWindowManager();
        if (defaultDisplayByWindowManager != null) {
            return defaultDisplayByWindowManager;
        }
        return getDisplayByDisplayManager();
    }

    private static Display getDisplayByDisplayManager() {
        if (LiteavSystemInfo.getSystemOSVersionInt() < 32) {
            return null;
        }
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null) {
            LiteavLog.e(TAG, "context is null.");
            return null;
        }
        try {
            return ((DisplayManager) applicationContext.getSystemService("display")).getDisplay(0);
        } catch (Throwable th5) {
            LiteavLog.e(TAG, "error getting display from display service.", th5);
            return null;
        }
    }

    public static k getDisplayRotation() {
        k displayRotationCorrection = getDisplayRotationCorrection();
        if (displayRotationCorrection != null) {
            return displayRotationCorrection;
        }
        try {
            Display display = getDisplay();
            if (display != null) {
                return surfaceRotationEnumToRotation(display.getRotation());
            }
        } catch (Exception e16) {
            LiteavLog.e(TAG, "error getting display rotation.", e16);
        }
        return k.NORMAL;
    }

    private static k getDisplayRotationCorrection() {
        int nativeGetDisplayRotationCorrection = nativeGetDisplayRotationCorrection();
        if (k.b(nativeGetDisplayRotationCorrection)) {
            return k.a(nativeGetDisplayRotationCorrection);
        }
        return null;
    }

    public static int getDisplayRotationDegree() {
        return getDisplayRotation().mValue;
    }

    public static Size getDisplaySize() {
        try {
            Display display = getDisplay();
            if (display != null) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                display.getRealMetrics(displayMetrics);
                return new Size(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
        } catch (Exception e16) {
            LiteavLog.e(TAG, "error getting display size.", e16);
        }
        return new Size(720, 1280);
    }

    private static native synchronized int nativeGetDisplayRotationCorrection();

    private static native synchronized int nativeGetDisplayRotationObtainMethod();

    private static k surfaceRotationEnumToRotation(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    return k.NORMAL;
                }
                return k.ROTATION_270;
            }
            return k.ROTATION_180;
        }
        return k.ROTATION_90;
    }
}
