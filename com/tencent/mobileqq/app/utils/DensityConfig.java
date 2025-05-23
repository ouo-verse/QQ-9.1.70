package com.tencent.mobileqq.app.utils;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ams.adcore.mma.api.Global;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001e2\u0006\u0010)\u001a\u00020*J\u000e\u0010+\u001a\u00020 2\u0006\u0010)\u001a\u00020*J\u000e\u0010,\u001a\u00020\u00102\u0006\u0010)\u001a\u00020*J\u001a\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001e2\u0006\u0010)\u001a\u00020*J6\u0010.\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u001e0&j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u001e`'2\u0006\u0010)\u001a\u00020*J\u0010\u0010/\u001a\u0002002\u0006\u0010)\u001a\u00020*H\u0002J\u000e\u00101\u001a\u0002002\u0006\u00102\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R6\u0010%\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u001e0&j\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u001e`'X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/app/utils/DensityConfig;", "", "()V", "CONFIG_BACKUP_DENSITY_COMPUTER_SWITCH", "", "CONFIG_KEY_ADJUST_RANGE_DOWN", "CONFIG_KEY_ADJUST_RANGE_UP", "CONFIG_KEY_DEFAULT_REVOLUTION", "CONFIG_KEY_MAX_SCALE_RANGE", "CONFIG_KEY_MIN_SCALE_RANGE", "DEFAULT_ADJUST_RANGE_DWON", "", "DEFAULT_ADJUST_RANGE_UP", "DEFAULT_MAX_SCALE", "DEFAULT_MIN_SCALE", "DEFAULT_REVOLUTION", "", "KEY_ADJUST_RANGE_DOWN", "KEY_ADJUST_RANGE_DOWN_NEW", "KEY_ADJUST_RANGE_UP", "KEY_ADJUST_RANGE_UP_NEW", "KEY_BACKUP_DENSITY_COMPUTER_SWITCH", "KEY_DEFAULT_REVOLUTION", "KEY_DEFAULT_REVOLUTION_NEW", "KEY_MAX_SCALE_RANGE", "KEY_MAX_SCALE_RANGE_NEW", "KEY_MIN_SCALE_RANGE", "KEY_MIN_SCALE_RANGE_NEW", "TAG", "adjustRange", "Lkotlin/Pair;", "backupDensityComputerSwitch", "", "backupDensityComputerSwitchConfig", "configLoaded", "defaultRevolution", "scaleRange", "supportDeviceWidthRange", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getAdjustRange", "context", "Landroid/content/Context;", "getBackupDenistyComputerSwitch", "getDefaultRevolution", "getScaleRange", "getSupportDeviceWidthRange", "loadConfig", "", "parseConfig", "configJson", "qqestablish_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class DensityConfig {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final String CONFIG_BACKUP_DENSITY_COMPUTER_SWITCH = "config_backup_density_computer_switch";

    @NotNull
    public static final String CONFIG_KEY_ADJUST_RANGE_DOWN = "adjust_range_down";

    @NotNull
    public static final String CONFIG_KEY_ADJUST_RANGE_UP = "adjust_range_up";

    @NotNull
    public static final String CONFIG_KEY_DEFAULT_REVOLUTION = "default_revolution";

    @NotNull
    public static final String CONFIG_KEY_MAX_SCALE_RANGE = "density_scale_max";

    @NotNull
    public static final String CONFIG_KEY_MIN_SCALE_RANGE = "density_scale_min";
    private static final float DEFAULT_ADJUST_RANGE_DWON = 0.85f;
    private static final float DEFAULT_ADJUST_RANGE_UP = 1.05f;
    private static final float DEFAULT_MAX_SCALE = 1.2f;
    private static final float DEFAULT_MIN_SCALE = 0.9f;
    private static final int DEFAULT_REVOLUTION = -1;

    @NotNull
    public static final DensityConfig INSTANCE;

    @NotNull
    public static final String KEY_ADJUST_RANGE_DOWN = "adjust_range_down";

    @NotNull
    public static final String KEY_ADJUST_RANGE_DOWN_NEW = "adjust_range_down_new";

    @NotNull
    public static final String KEY_ADJUST_RANGE_UP = "adjust_range_up";

    @NotNull
    public static final String KEY_ADJUST_RANGE_UP_NEW = "adjust_range_up_new";

    @NotNull
    public static final String KEY_BACKUP_DENSITY_COMPUTER_SWITCH = "key_backup_density_computer_switch";

    @NotNull
    public static final String KEY_DEFAULT_REVOLUTION = "default_revolution";

    @NotNull
    public static final String KEY_DEFAULT_REVOLUTION_NEW = "default_revolution_new";

    @NotNull
    public static final String KEY_MAX_SCALE_RANGE = "density_scale_max";

    @NotNull
    public static final String KEY_MAX_SCALE_RANGE_NEW = "density_scale_max_new";

    @NotNull
    public static final String KEY_MIN_SCALE_RANGE = "density_scale_min";

    @NotNull
    public static final String KEY_MIN_SCALE_RANGE_NEW = "density_scale_min_new";

    @NotNull
    private static final String TAG = "GlobalDisplayMetricsManager.DensityConfig";

    @NotNull
    private static Pair<Float, Float> adjustRange;
    private static boolean backupDensityComputerSwitch;

    @NotNull
    private static String backupDensityComputerSwitchConfig;
    private static boolean configLoaded;
    private static int defaultRevolution;

    @NotNull
    private static Pair<Float, Float> scaleRange;

    @NotNull
    private static final ArrayList<Pair<Integer, Integer>> supportDeviceWidthRange;

    static {
        ArrayList<Pair<Integer, Integer>> arrayListOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37292);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        INSTANCE = new DensityConfig();
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(new Pair(1080, 1440));
        supportDeviceWidthRange = arrayListOf;
        scaleRange = new Pair<>(Float.valueOf(0.9f), Float.valueOf(DEFAULT_MAX_SCALE));
        defaultRevolution = -1;
        adjustRange = new Pair<>(Float.valueOf(0.85f), Float.valueOf(DEFAULT_ADJUST_RANGE_UP));
        backupDensityComputerSwitchConfig = "1";
        backupDensityComputerSwitch = true;
    }

    DensityConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void loadConfig(Context context) {
        boolean z16;
        boolean z17;
        boolean z18;
        String str = TAG;
        if (configLoaded) {
            return;
        }
        configLoaded = true;
        try {
            try {
                if (MobileQQ.sProcessId == 1) {
                    String read = PropertiesUtils.read(context, KEY_MIN_SCALE_RANGE_NEW, "0.9");
                    Intrinsics.checkNotNullExpressionValue(read, "read(context, KEY_MIN_SC\u2026ULT_MIN_SCALE.toString())");
                    float parseFloat = Float.parseFloat(read);
                    String read2 = PropertiesUtils.read(context, KEY_MAX_SCALE_RANGE_NEW, Global.TRACKING_SDKVS_VALUE);
                    Intrinsics.checkNotNullExpressionValue(read2, "read(context, KEY_MAX_SC\u2026ULT_MAX_SCALE.toString())");
                    float parseFloat2 = Float.parseFloat(read2);
                    String read3 = PropertiesUtils.read(context, KEY_DEFAULT_REVOLUTION_NEW, "-1");
                    Intrinsics.checkNotNullExpressionValue(read3, "read(context, KEY_DEFAUL\u2026LT_REVOLUTION.toString())");
                    int parseInt = Integer.parseInt(read3);
                    String read4 = PropertiesUtils.read(context, KEY_ADJUST_RANGE_DOWN_NEW, "0.85");
                    Intrinsics.checkNotNullExpressionValue(read4, "read(context, KEY_ADJUST\u2026ST_RANGE_DWON.toString())");
                    float parseFloat3 = Float.parseFloat(read4);
                    String read5 = PropertiesUtils.read(context, KEY_ADJUST_RANGE_UP_NEW, "1.05");
                    Intrinsics.checkNotNullExpressionValue(read5, "read(context, KEY_ADJUST\u2026JUST_RANGE_UP.toString())");
                    float parseFloat4 = Float.parseFloat(read5);
                    String read6 = PropertiesUtils.read(context, "density_scale_min", "0.9");
                    Intrinsics.checkNotNullExpressionValue(read6, "read(context, KEY_MIN_SC\u2026ULT_MIN_SCALE.toString())");
                    float parseFloat5 = Float.parseFloat(read6);
                    String read7 = PropertiesUtils.read(context, "density_scale_max", Global.TRACKING_SDKVS_VALUE);
                    Intrinsics.checkNotNullExpressionValue(read7, "read(context, KEY_MAX_SC\u2026ULT_MAX_SCALE.toString())");
                    float parseFloat6 = Float.parseFloat(read7);
                    String read8 = PropertiesUtils.read(context, "default_revolution", "-1");
                    Intrinsics.checkNotNullExpressionValue(read8, "read(context, KEY_DEFAUL\u2026LT_REVOLUTION.toString())");
                    int parseInt2 = Integer.parseInt(read8);
                    String read9 = PropertiesUtils.read(context, "adjust_range_down", "0.85");
                    Intrinsics.checkNotNullExpressionValue(read9, "read(context, KEY_ADJUST\u2026ST_RANGE_DWON.toString())");
                    float parseFloat7 = Float.parseFloat(read9);
                    String read10 = PropertiesUtils.read(context, "adjust_range_up", "1.05");
                    Intrinsics.checkNotNullExpressionValue(read10, "read(context, KEY_ADJUST\u2026JUST_RANGE_UP.toString())");
                    float parseFloat8 = Float.parseFloat(read10);
                    boolean z19 = false;
                    if (parseFloat5 == parseFloat) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        PropertiesUtils.save(context, "density_scale_min", String.valueOf(parseFloat));
                    }
                    if (parseFloat6 == parseFloat2) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!z17) {
                        PropertiesUtils.save(context, "density_scale_max", String.valueOf(parseFloat2));
                    }
                    if (parseInt2 != parseInt) {
                        PropertiesUtils.save(context, "default_revolution", String.valueOf(parseInt));
                    }
                    if (parseFloat7 == parseFloat3) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (!z18) {
                        PropertiesUtils.save(context, "adjust_range_down", String.valueOf(parseFloat3));
                    }
                    if (parseFloat8 == parseFloat4) {
                        z19 = true;
                    }
                    if (!z19) {
                        PropertiesUtils.save(context, "adjust_range_up", String.valueOf(parseFloat4));
                    }
                    defaultRevolution = parseInt;
                    scaleRange = new Pair<>(Float.valueOf(parseFloat), Float.valueOf(parseFloat2));
                    adjustRange = new Pair<>(Float.valueOf(parseFloat3), Float.valueOf(parseFloat4));
                    String read11 = PropertiesUtils.read(context, KEY_BACKUP_DENSITY_COMPUTER_SWITCH, "1");
                    Intrinsics.checkNotNullExpressionValue(read11, "read(context, KEY_BACKUP\u2026ITY_COMPUTER_SWITCH, \"1\")");
                    backupDensityComputerSwitchConfig = read11;
                    backupDensityComputerSwitch = "1".equals(read11);
                } else {
                    String read12 = PropertiesUtils.read(context, "density_scale_min", "0.9");
                    Intrinsics.checkNotNullExpressionValue(read12, "read(context, KEY_MIN_SC\u2026ULT_MIN_SCALE.toString())");
                    float parseFloat9 = Float.parseFloat(read12);
                    String read13 = PropertiesUtils.read(context, "density_scale_max", Global.TRACKING_SDKVS_VALUE);
                    Intrinsics.checkNotNullExpressionValue(read13, "read(context, KEY_MAX_SC\u2026ULT_MAX_SCALE.toString())");
                    float parseFloat10 = Float.parseFloat(read13);
                    String read14 = PropertiesUtils.read(context, "default_revolution", "-1");
                    Intrinsics.checkNotNullExpressionValue(read14, "read(context, KEY_DEFAUL\u2026LT_REVOLUTION.toString())");
                    int parseInt3 = Integer.parseInt(read14);
                    String read15 = PropertiesUtils.read(context, "adjust_range_down", "0.85");
                    Intrinsics.checkNotNullExpressionValue(read15, "read(context, KEY_ADJUST\u2026ST_RANGE_DWON.toString())");
                    float parseFloat11 = Float.parseFloat(read15);
                    String read16 = PropertiesUtils.read(context, "adjust_range_up", "1.05");
                    Intrinsics.checkNotNullExpressionValue(read16, "read(context, KEY_ADJUST\u2026JUST_RANGE_UP.toString())");
                    float parseFloat12 = Float.parseFloat(read16);
                    defaultRevolution = parseInt3;
                    scaleRange = new Pair<>(Float.valueOf(parseFloat9), Float.valueOf(parseFloat10));
                    adjustRange = new Pair<>(Float.valueOf(parseFloat11), Float.valueOf(parseFloat12));
                    String read17 = PropertiesUtils.read(context, KEY_BACKUP_DENSITY_COMPUTER_SWITCH, "1");
                    Intrinsics.checkNotNullExpressionValue(read17, "read(context, KEY_BACKUP\u2026ITY_COMPUTER_SWITCH, \"1\")");
                    backupDensityComputerSwitchConfig = read17;
                    backupDensityComputerSwitch = "1".equals(read17);
                }
                String str2 = "[loadConfig]: minScale is " + scaleRange.getFirst().floatValue() + ", maxScale is " + scaleRange.getSecond().floatValue() + ", defaultRevolution is " + defaultRevolution + ", adjustRangeDown is " + adjustRange.getFirst().floatValue() + ", adjustRangeUp is " + adjustRange.getSecond().floatValue();
                str = TAG;
                QLog.i(str, 1, str2);
            } catch (Throwable th5) {
                th = th5;
                str = TAG;
                QLog.i(str, 1, "loadConfig", th);
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    @NotNull
    public final Pair<Float, Float> getAdjustRange(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Pair) iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        loadConfig(context);
        return adjustRange;
    }

    public final boolean getBackupDenistyComputerSwitch(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) context)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        loadConfig(context);
        return backupDensityComputerSwitch;
    }

    public final int getDefaultRevolution(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) context)).intValue();
        }
        Intrinsics.checkNotNullParameter(context, "context");
        loadConfig(context);
        return defaultRevolution;
    }

    @NotNull
    public final Pair<Float, Float> getScaleRange(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Pair) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        loadConfig(context);
        return scaleRange;
    }

    @NotNull
    public final ArrayList<Pair<Integer, Integer>> getSupportDeviceWidthRange(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ArrayList) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return supportDeviceWidthRange;
    }

    public final void parseConfig(@NotNull String configJson) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) configJson);
            return;
        }
        Intrinsics.checkNotNullParameter(configJson, "configJson");
        try {
            JSONObject jSONObject = new JSONObject(configJson);
            String minScale = jSONObject.optString("density_scale_min", "");
            String maxScale = jSONObject.optString("density_scale_max", "");
            String defaultRevolution2 = jSONObject.optString("default_revolution", "");
            String adjustRangeDown = jSONObject.optString("adjust_range_down", "");
            String adjustRangeUp = jSONObject.optString("adjust_range_up", "");
            Intrinsics.checkNotNullExpressionValue(minScale, "minScale");
            boolean z26 = false;
            if (minScale.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                PropertiesUtils.save(MobileQQ.sMobileQQ, KEY_MIN_SCALE_RANGE_NEW, minScale);
            }
            Intrinsics.checkNotNullExpressionValue(maxScale, "maxScale");
            if (maxScale.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                PropertiesUtils.save(MobileQQ.sMobileQQ, KEY_MAX_SCALE_RANGE_NEW, maxScale);
            }
            Intrinsics.checkNotNullExpressionValue(defaultRevolution2, "defaultRevolution");
            if (defaultRevolution2.length() > 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18) {
                PropertiesUtils.save(MobileQQ.sMobileQQ, KEY_DEFAULT_REVOLUTION_NEW, defaultRevolution2);
            }
            Intrinsics.checkNotNullExpressionValue(adjustRangeDown, "adjustRangeDown");
            if (adjustRangeDown.length() > 0) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (z19) {
                PropertiesUtils.save(MobileQQ.sMobileQQ, KEY_ADJUST_RANGE_DOWN_NEW, adjustRangeDown);
            }
            Intrinsics.checkNotNullExpressionValue(adjustRangeUp, "adjustRangeUp");
            if (adjustRangeUp.length() > 0) {
                z26 = true;
            }
            if (z26) {
                PropertiesUtils.save(MobileQQ.sMobileQQ, KEY_ADJUST_RANGE_UP_NEW, adjustRangeUp);
            }
            String optString = jSONObject.optString(CONFIG_BACKUP_DENSITY_COMPUTER_SWITCH, "1");
            if (!TextUtils.isEmpty(optString) && !optString.equals(backupDensityComputerSwitchConfig)) {
                PropertiesUtils.save(MobileQQ.sMobileQQ, KEY_BACKUP_DENSITY_COMPUTER_SWITCH, optString);
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "[parseConfig]: " + configJson);
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[parseConfig]", th5);
        }
    }
}
