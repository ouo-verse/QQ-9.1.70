package com.tencent.libra.fd;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.RFWOSUtils;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.libra.util.LibraLogUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class HardwareConfigState {
    public static final boolean BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED;
    private static final File FD_SIZE_LIST;
    public static final boolean HARDWARE_BITMAPS_SUPPORTED;
    private static final int MAXIMUM_FDS_FOR_HARDWARE_CONFIGS_O = 700;
    private static final int MAXIMUM_FDS_FOR_HARDWARE_CONFIGS_P = 20000;
    private static final int MINIMUM_DECODES_BETWEEN_FD_CHECKS = 50;

    @VisibleForTesting
    static final int MIN_HARDWARE_DIMENSION_O = 128;
    private static final int MIN_HARDWARE_DIMENSION_P = 0;
    private static final String TAG = LibraLogUtil.INSTANCE.getLogTag("HardwareConfigState");
    private static volatile HardwareConfigState instance;

    @GuardedBy("this")
    private int decodesSinceLastFdCheck;

    @GuardedBy("this")
    private boolean isFdSizeBelowHardwareLimit = true;
    private final AtomicBoolean isHardwareConfigAllowedByAppState = new AtomicBoolean(false);
    private final boolean isHardwareConfigAllowedByDeviceModel = isHardwareConfigAllowedByDeviceModel();
    private final int minHardwareDimension;
    private final int sdkBasedMaxFdCount;

    static {
        boolean z16;
        int i3 = Build.VERSION.SDK_INT;
        boolean z17 = true;
        if (i3 < 29) {
            z16 = true;
        } else {
            z16 = false;
        }
        BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED = z16;
        if (i3 < 26) {
            z17 = false;
        }
        HARDWARE_BITMAPS_SUPPORTED = z17;
        FD_SIZE_LIST = new File("/proc/self/fd");
    }

    @VisibleForTesting
    HardwareConfigState() {
        if (Build.VERSION.SDK_INT >= 28) {
            this.sdkBasedMaxFdCount = 20000;
            this.minHardwareDimension = 0;
        } else {
            this.sdkBasedMaxFdCount = 700;
            this.minHardwareDimension = 128;
        }
    }

    private boolean areHardwareBitmapsBlockedByAppState() {
        if (BLOCK_HARDWARE_BITMAPS_WHEN_GL_CONTEXT_MIGHT_NOT_BE_INITIALIZED && !this.isHardwareConfigAllowedByAppState.get()) {
            return true;
        }
        return false;
    }

    public static void assertMainThread() {
        if (isOnMainThread()) {
        } else {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static HardwareConfigState getInstance() {
        if (instance == null) {
            synchronized (HardwareConfigState.class) {
                if (instance == null) {
                    instance = new HardwareConfigState();
                }
            }
        }
        return instance;
    }

    private int getMaxFdCount() {
        return this.sdkBasedMaxFdCount;
    }

    private static boolean isDisallowedByModelLG() {
        if (Build.VERSION.SDK_INT != 27) {
            return false;
        }
        if (!DeviceInfoMonitor.getModel().startsWith("LG-") && !DeviceInfoMonitor.getModel().startsWith("LGM-") && !DeviceInfoMonitor.getModel().startsWith("LM-")) {
            return false;
        }
        return true;
    }

    private static boolean isDisallowedBySMAndMoto() {
        if (Build.VERSION.SDK_INT != 26) {
            return false;
        }
        if (!DeviceInfoMonitor.getModel().startsWith("SC-") && !DeviceInfoMonitor.getModel().startsWith("SM-") && !DeviceInfoMonitor.getModel().startsWith("moto")) {
            return false;
        }
        return true;
    }

    private static boolean isDisallowedByViVoHasNavBar() {
        if (RFWOSUtils.isVivoSystem() && DisplayUtil.hasNavBar(RFWApplication.getApplication())) {
            return true;
        }
        return false;
    }

    private synchronized boolean isFdSizeBelowHardwareLimit() {
        int i3;
        boolean z16 = true;
        int i16 = this.decodesSinceLastFdCheck + 1;
        this.decodesSinceLastFdCheck = i16;
        if (i16 >= 50) {
            this.decodesSinceLastFdCheck = 0;
            String[] list = FD_SIZE_LIST.list();
            if (list != null) {
                i3 = list.length;
            } else {
                i3 = Integer.MAX_VALUE;
            }
            long maxFdCount = getMaxFdCount();
            if (i3 >= maxFdCount) {
                z16 = false;
            }
            this.isFdSizeBelowHardwareLimit = z16;
            if (!z16) {
                String str = TAG;
                if (Log.isLoggable(str, 5)) {
                    RFWLog.w(str, RFWLog.USR, "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + i3 + ", limit " + maxFdCount);
                }
            }
        }
        return this.isFdSizeBelowHardwareLimit;
    }

    private static boolean isHardwareConfigAllowedByDeviceModel() {
        if (!isDisallowedBySMAndMoto() && !isDisallowedByModelLG() && !isDisallowedByViVoHasNavBar()) {
            return true;
        }
        return false;
    }

    public static boolean isOnMainThread() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return true;
        }
        return false;
    }

    public boolean areHardwareBitmapsBlocked() {
        assertMainThread();
        return !this.isHardwareConfigAllowedByAppState.get();
    }

    public void blockHardwareBitmaps() {
        assertMainThread();
        this.isHardwareConfigAllowedByAppState.set(false);
    }

    public boolean isHardwareConfigAllowed(int i3, int i16, boolean z16, boolean z17) {
        if (!z16) {
            String str = TAG;
            if (Log.isLoggable(str, 2)) {
                Log.v(str, "Hardware config disallowed by caller");
            }
            return false;
        }
        if (!this.isHardwareConfigAllowedByDeviceModel) {
            String str2 = TAG;
            if (Log.isLoggable(str2, 2)) {
                Log.v(str2, "Hardware config disallowed by device model");
            }
            return false;
        }
        if (!HARDWARE_BITMAPS_SUPPORTED) {
            String str3 = TAG;
            if (Log.isLoggable(str3, 2)) {
                Log.v(str3, "Hardware config disallowed by sdk");
            }
            return false;
        }
        if (areHardwareBitmapsBlockedByAppState()) {
            String str4 = TAG;
            if (Log.isLoggable(str4, 2)) {
                Log.v(str4, "Hardware config disallowed by app state");
            }
            return false;
        }
        if (z17) {
            String str5 = TAG;
            if (Log.isLoggable(str5, 2)) {
                Log.v(str5, "Hardware config disallowed because exif orientation is required");
            }
            return false;
        }
        int i17 = this.minHardwareDimension;
        if (i3 < i17) {
            String str6 = TAG;
            if (Log.isLoggable(str6, 2)) {
                Log.v(str6, "Hardware config disallowed because width is too small");
            }
            return false;
        }
        if (i16 < i17) {
            String str7 = TAG;
            if (Log.isLoggable(str7, 2)) {
                Log.v(str7, "Hardware config disallowed because height is too small");
            }
            return false;
        }
        if (!isFdSizeBelowHardwareLimit()) {
            String str8 = TAG;
            if (Log.isLoggable(str8, 2)) {
                Log.v(str8, "Hardware config disallowed because there are insufficient FDs");
            }
            return false;
        }
        return true;
    }

    @TargetApi(26)
    public boolean setHardwareConfigIfAllowed(int i3, int i16, BitmapFactory.Options options, boolean z16, boolean z17) {
        Bitmap.Config config;
        boolean isHardwareConfigAllowed = isHardwareConfigAllowed(i3, i16, z16, z17);
        if (isHardwareConfigAllowed) {
            config = Bitmap.Config.HARDWARE;
            options.inPreferredConfig = config;
            options.inMutable = false;
        }
        return isHardwareConfigAllowed;
    }

    public void unblockHardwareBitmaps() {
        assertMainThread();
        this.isHardwareConfigAllowedByAppState.set(true);
    }
}
