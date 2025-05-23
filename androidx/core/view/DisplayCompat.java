package androidx.core.view;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.view.Display;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;

/* compiled from: P */
/* loaded from: classes.dex */
public final class DisplayCompat {
    private static final int DISPLAY_SIZE_4K_HEIGHT = 2160;
    private static final int DISPLAY_SIZE_4K_WIDTH = 3840;

    /* compiled from: P */
    @RequiresApi(17)
    /* loaded from: classes.dex */
    static class Api17Impl {
        Api17Impl() {
        }

        static void getRealSize(Display display, Point point) {
            display.getRealSize(point);
        }
    }

    DisplayCompat() {
    }

    static Point getCurrentDisplaySizeFromWorkarounds(@NonNull Context context, @NonNull Display display) {
        Point parsePhysicalDisplaySizeFromSystemProperties;
        if (Build.VERSION.SDK_INT < 28) {
            parsePhysicalDisplaySizeFromSystemProperties = parsePhysicalDisplaySizeFromSystemProperties("sys.display-size", display);
        } else {
            parsePhysicalDisplaySizeFromSystemProperties = parsePhysicalDisplaySizeFromSystemProperties("vendor.display-size", display);
        }
        if (parsePhysicalDisplaySizeFromSystemProperties != null) {
            return parsePhysicalDisplaySizeFromSystemProperties;
        }
        if (!isSonyBravia4kTv(context) || !isCurrentModeTheLargestMode(display)) {
            return null;
        }
        return new Point(3840, 2160);
    }

    @NonNull
    private static Point getDisplaySize(@NonNull Context context, @NonNull Display display) {
        Point currentDisplaySizeFromWorkarounds = getCurrentDisplaySizeFromWorkarounds(context, display);
        if (currentDisplaySizeFromWorkarounds != null) {
            return currentDisplaySizeFromWorkarounds;
        }
        Point point = new Point();
        Api17Impl.getRealSize(display, point);
        return point;
    }

    @NonNull
    public static ModeCompat getMode(@NonNull Context context, @NonNull Display display) {
        return Api23Impl.getMode(context, display);
    }

    @NonNull
    @SuppressLint({"ArrayReturn"})
    public static ModeCompat[] getSupportedModes(@NonNull Context context, @NonNull Display display) {
        return Api23Impl.getSupportedModes(context, display);
    }

    @Nullable
    private static String getSystemProperty(String str) {
        try {
            return (String) SystemProperties.class.getMethod("get", String.class).invoke(SystemProperties.class, str);
        } catch (Exception unused) {
            return null;
        }
    }

    static boolean isCurrentModeTheLargestMode(@NonNull Display display) {
        return Api23Impl.isCurrentModeTheLargestMode(display);
    }

    private static boolean isSonyBravia4kTv(@NonNull Context context) {
        if (isTv(context) && "Sony".equals(Build.MANUFACTURER) && DeviceInfoMonitor.getModel().startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd")) {
            return true;
        }
        return false;
    }

    private static boolean isTv(@NonNull Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService("uimode");
        if (uiModeManager != null && uiModeManager.getCurrentModeType() == 4) {
            return true;
        }
        return false;
    }

    private static Point parseDisplaySize(@NonNull String str) throws NumberFormatException {
        String[] split = str.trim().split(HippyTKDListViewAdapter.X, -1);
        if (split.length == 2) {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            if (parseInt > 0 && parseInt2 > 0) {
                return new Point(parseInt, parseInt2);
            }
        }
        throw new NumberFormatException();
    }

    @Nullable
    private static Point parsePhysicalDisplaySizeFromSystemProperties(@NonNull String str, @NonNull Display display) {
        if (display.getDisplayId() != 0) {
            return null;
        }
        String systemProperty = getSystemProperty(str);
        if (TextUtils.isEmpty(systemProperty)) {
            return null;
        }
        try {
            return parseDisplaySize(systemProperty);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @RequiresApi(23)
    /* loaded from: classes.dex */
    public static class Api23Impl {
        Api23Impl() {
        }

        @NonNull
        static ModeCompat getMode(@NonNull Context context, @NonNull Display display) {
            Display.Mode mode = display.getMode();
            Point currentDisplaySizeFromWorkarounds = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(context, display);
            if (currentDisplaySizeFromWorkarounds != null && !physicalSizeEquals(mode, currentDisplaySizeFromWorkarounds)) {
                return new ModeCompat(mode, currentDisplaySizeFromWorkarounds);
            }
            return new ModeCompat(mode, true);
        }

        @NonNull
        @SuppressLint({"ArrayReturn"})
        public static ModeCompat[] getSupportedModes(@NonNull Context context, @NonNull Display display) {
            ModeCompat modeCompat;
            Display.Mode[] supportedModes = display.getSupportedModes();
            ModeCompat[] modeCompatArr = new ModeCompat[supportedModes.length];
            Display.Mode mode = display.getMode();
            Point currentDisplaySizeFromWorkarounds = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(context, display);
            if (currentDisplaySizeFromWorkarounds != null && !physicalSizeEquals(mode, currentDisplaySizeFromWorkarounds)) {
                for (int i3 = 0; i3 < supportedModes.length; i3++) {
                    if (physicalSizeEquals(supportedModes[i3], mode)) {
                        modeCompat = new ModeCompat(supportedModes[i3], currentDisplaySizeFromWorkarounds);
                    } else {
                        modeCompat = new ModeCompat(supportedModes[i3], false);
                    }
                    modeCompatArr[i3] = modeCompat;
                }
            } else {
                for (int i16 = 0; i16 < supportedModes.length; i16++) {
                    modeCompatArr[i16] = new ModeCompat(supportedModes[i16], physicalSizeEquals(supportedModes[i16], mode));
                }
            }
            return modeCompatArr;
        }

        static boolean isCurrentModeTheLargestMode(@NonNull Display display) {
            Display.Mode mode = display.getMode();
            Display.Mode[] supportedModes = display.getSupportedModes();
            for (int i3 = 0; i3 < supportedModes.length; i3++) {
                if (mode.getPhysicalHeight() < supportedModes[i3].getPhysicalHeight() || mode.getPhysicalWidth() < supportedModes[i3].getPhysicalWidth()) {
                    return false;
                }
            }
            return true;
        }

        static boolean physicalSizeEquals(Display.Mode mode, Point point) {
            return (mode.getPhysicalWidth() == point.x && mode.getPhysicalHeight() == point.y) || (mode.getPhysicalWidth() == point.y && mode.getPhysicalHeight() == point.x);
        }

        static boolean physicalSizeEquals(Display.Mode mode, Display.Mode mode2) {
            return mode.getPhysicalWidth() == mode2.getPhysicalWidth() && mode.getPhysicalHeight() == mode2.getPhysicalHeight();
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public static final class ModeCompat {
        private final boolean mIsNative;
        private final Display.Mode mMode;
        private final Point mPhysicalSize;

        ModeCompat(@NonNull Point point) {
            Preconditions.checkNotNull(point, "physicalSize == null");
            this.mPhysicalSize = point;
            this.mMode = null;
            this.mIsNative = true;
        }

        public int getPhysicalHeight() {
            return this.mPhysicalSize.y;
        }

        public int getPhysicalWidth() {
            return this.mPhysicalSize.x;
        }

        @Deprecated
        public boolean isNative() {
            return this.mIsNative;
        }

        @Nullable
        @RequiresApi(23)
        public Display.Mode toMode() {
            return this.mMode;
        }

        @RequiresApi(23)
        ModeCompat(@NonNull Display.Mode mode, boolean z16) {
            Preconditions.checkNotNull(mode, "mode == null, can't wrap a null reference");
            this.mPhysicalSize = new Point(mode.getPhysicalWidth(), mode.getPhysicalHeight());
            this.mMode = mode;
            this.mIsNative = z16;
        }

        @RequiresApi(23)
        ModeCompat(@NonNull Display.Mode mode, @NonNull Point point) {
            Preconditions.checkNotNull(mode, "mode == null, can't wrap a null reference");
            Preconditions.checkNotNull(point, "physicalSize == null");
            this.mPhysicalSize = point;
            this.mMode = mode;
            this.mIsNative = true;
        }
    }
}
