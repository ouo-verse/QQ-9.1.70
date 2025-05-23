package com.tencent.mobileqq.app.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.RequiresApi;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.avbiz.Constants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.guard.GuardState;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.profilecard.api.ProfileContants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import kotlin.Pair;
import mqq.app.MobileQQ;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes11.dex */
public class GlobalDisplayMetricsManager {
    static IPatchRedirector $redirector_ = null;
    private static final int BASE_WIDTH_DEFAULT = 400;
    private static final String[] BE_KILLED_PROCESS;
    private static final int INVALID_DENSITY_DPI = 1;
    private static final int INVALID_REVOLUTION = -1;
    private static final float MAX_CHANGE = 0.15f;
    private static final String[] NONE_ADJUST_PROCESS_LIST;
    private static final String PROP_KEY_WIDTH = "metrics_base_width";
    private static final String PROP_KEY_WIDTH_ARR = "device_width_arr";
    private static final String PROP_KEY_WIDTH_ARR_NEW = "device_width_arr_new";
    private static final String PROP_KEY_WIDTH_VER = "device_width_ver";
    private static final String PROP_KEY_WIDTH_VER_NEW = "device_width_ver_new";
    private static final String QQPROCESSNAME = "com.tencent.mobileqq";
    public static final String TAG = "GlobalDisplayMetricsManager";
    private static int sAdjustResult;
    private static float sCurDensity;
    private static int sCurWidthVersion;
    private static int sDefaultDensityDpi;
    private static int sDefaultWidth;
    private static int sDeviceWidth;
    private static boolean sInitToggle;
    private static StringBuilder sLogBuilder;
    private static boolean sNeedAdjust;
    public static volatile DisplayMetrics sOriginDisplayMetrics;
    public static volatile DisplayMetrics sQQDisplayMetrics;
    private static final HashSet<Integer> sSupportedWidthSet;
    private static int sUIDesignWidth;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(ProfileContants.FILED_KID_MODE_SEARCH_FRIEND_SWITCH);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        sUIDesignWidth = -1;
        sDeviceWidth = -1;
        sCurDensity = -1.0f;
        sDefaultWidth = -1;
        sDefaultDensityDpi = -1;
        sAdjustResult = -1;
        sQQDisplayMetrics = new DisplayMetrics();
        sCurWidthVersion = -1;
        sSupportedWidthSet = new HashSet<>();
        sLogBuilder = new StringBuilder();
        NONE_ADJUST_PROCESS_LIST = new String[]{"com.tencent.mobileqq:qqreader", "com.tencent.mobileqq:photoplus", Constants.Process.VIDEO_PROCESS, "com.tencent.mobileqq:mini_internal", GuardState.PROCESS_NAME_MINIAPP, "com.tencent.mobileqq:mini1", "com.tencent.mobileqq:mini2", "com.tencent.mobileqq:mini3", "com.tencent.mobileqq:mini4", "com.tencent.mobileqq:mini5", "com.tencent.mobileqq:mini6", "com.tencent.mobileqq:mini7", "com.tencent.mobileqq:wxa_container0", "com.tencent.mobileqq:wxa_container1"};
        BE_KILLED_PROCESS = new String[]{"com.tencent.mobileqq:tool", "com.tencent.mobileqq:picture", "com.tencent.mobileqq:qqreader", "com.tencent.mobileqq:story", "com.tencent.mobileqq:qzone", "com.tencent.mobileqq:qwallet", "com.tencent.mobileqq:qqwifi", "com.tencent.mobileqq:qqfav", "com.tencent.mobileqq:dingdong", "com.tencent.mobileqq:buscard", "com.tencent.mobileqq:qqhotspot", "com.tencent.mobileqq"};
        sInitToggle = false;
        sNeedAdjust = false;
    }

    public GlobalDisplayMetricsManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static void addLog(String str) {
        StringBuilder sb5 = sLogBuilder;
        if (sb5 == null) {
            return;
        }
        try {
            sb5.append("file: ");
            sb5.append(str);
            sb5.append("\n");
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
    }

    public static void addSupportedWidthArr(Context context, JSONArray jSONArray, int i3, boolean z16) {
        if (jSONArray == null) {
            return;
        }
        HashSet hashSet = new HashSet(jSONArray.length());
        for (int length = jSONArray.length(); length >= 0; length--) {
            int optInt = jSONArray.optInt(length);
            if (optInt > 0) {
                hashSet.add(Integer.valueOf(optInt));
            }
        }
        if (!bl.b(hashSet)) {
            sSupportedWidthSet.addAll(hashSet);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "addAndSaveSupportedWidthArr: " + hashSet);
            }
        }
        if (z16 && 1 == MobileQQ.sProcessId) {
            PropertiesUtils.save(context, PROP_KEY_WIDTH_ARR, jSONArray.toString());
            PropertiesUtils.save(context, PROP_KEY_WIDTH_VER, String.valueOf(i3));
        }
        sCurWidthVersion = i3;
    }

    public static void adjustDisplayMetrics(Context context) {
        h.f196662a.b(context);
        e.f196658a.b(context);
        f.f196660a.b(context);
        if (context instanceof ContextWrapper) {
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            Resources resources = baseContext.getResources();
            densityResourceSetToOrigin(baseContext);
            adjustDisplayMetrics(baseContext, getBaseWidthFromProperties(context), true, false);
            FontSettingManager.doFontLevelSetting(baseContext, false, true);
            if (resources instanceof d) {
                ((d) resources).a();
            }
            checkDensity(baseContext.getResources());
        }
        densityResourceSetToOrigin(context);
        int adjustDisplayMetrics = adjustDisplayMetrics(context, getBaseWidthFromProperties(context), true, false);
        if (sAdjustResult < 0) {
            sAdjustResult = adjustDisplayMetrics;
        }
        FontSettingManager.doFontLevelSetting(context, false, true);
        r.f196682a.a(context);
        c.f196649a.b(String.valueOf(adjustDisplayMetrics), String.valueOf(sDeviceWidth), String.valueOf(sDefaultWidth), String.valueOf(sDefaultDensityDpi));
        checkDensity(context.getResources());
    }

    static void adjustFontScale(Resources resources) {
        if (resources == null) {
            return;
        }
        try {
            Configuration configuration = resources.getConfiguration();
            if (configuration == null) {
                return;
            }
            i.f196664a.i(configuration.fontScale, false);
            if (configuration.fontScale != 1.0f) {
                configuration.fontScale = 1.0f;
                resources.updateConfiguration(configuration, resources.getDisplayMetrics());
            }
        } catch (Throwable th5) {
            QLog.i(TAG, 1, "[adjustFontScale]: " + th5);
        }
    }

    public static boolean canSupportDeviceWidth(Context context, int i3) {
        initSupportedWidthSet(context);
        if (sSupportedWidthSet.contains(Integer.valueOf(i3))) {
            return true;
        }
        ArrayList<Pair<Integer, Integer>> supportDeviceWidthRange = DensityConfig.INSTANCE.getSupportDeviceWidthRange(context);
        if (supportDeviceWidthRange.isEmpty()) {
            QLog.i(TAG, 1, "supportRangeList is empty");
            return false;
        }
        QLog.i(TAG, 1, "canSupportDeviceWidth deviceWidth " + i3);
        Iterator<Pair<Integer, Integer>> it = supportDeviceWidthRange.iterator();
        while (it.hasNext()) {
            Pair<Integer, Integer> next = it.next();
            QLog.i(TAG, 1, "canSupportDeviceWidth supportRange " + next.getSecond());
            if (i3 >= next.getFirst().intValue() && i3 <= next.getSecond().intValue()) {
                return true;
            }
        }
        return false;
    }

    public static boolean canSupportDeviceWidthNew(int i3) {
        if (i3 >= 720 && i3 <= 1440) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean checkAdjustInRange(Context context, float f16, float f17) {
        float f18 = f16 / f17;
        Pair<Float, Float> adjustRange = DensityConfig.INSTANCE.getAdjustRange(context);
        if (f18 < adjustRange.getFirst().floatValue() || f18 > adjustRange.getSecond().floatValue()) {
            return false;
        }
        return true;
    }

    @RequiresApi(api = 17)
    public static void checkChangeOfSysDensity(Configuration configuration, Context context) {
        try {
            if (!com.tencent.mobileqq.startup.a.f289668i) {
                QLog.i(TAG, 1, "[checkChangeOfSysDensity]: codeStart not finish, return");
                return;
            }
            if (sOriginDisplayMetrics != null) {
                int i3 = sOriginDisplayMetrics.densityDpi;
                QLog.i(TAG, 1, "sysCurDensityDpi is " + i3 + " newSysDensityDpi is " + configuration.densityDpi);
                if (configuration.densityDpi != i3) {
                    if (com.tencent.util.l.f383986a.b("density_adjust_config_change_kill_9020", true)) {
                        boolean needAdjustDensity = needAdjustDensity(context);
                        float f16 = sOriginDisplayMetrics.density;
                        float f17 = Resources.getSystem().getDisplayMetrics().density;
                        if (needAdjustDensity) {
                            int i16 = sUIDesignWidth;
                            if (i16 < 0) {
                                i16 = 400;
                            }
                            f17 = computeNewDensity(context, f16, getScaleOfResolution(context, sDeviceWidth), getSystemDensityScale(true), sDeviceWidth, i16, false);
                            f16 = sCurDensity;
                        }
                        QLog.i(TAG, 1, "[configChange]: newDensity is " + f17 + " oldDensity is " + f16);
                        if (f17 > 0.0f && f16 > 0.0f && Math.abs(f17 - f16) >= 0.1d) {
                            killProcess();
                            return;
                        }
                        return;
                    }
                    killProcess();
                }
            }
        } catch (Throwable th5) {
            QLog.i(TAG, 1, "[checkChangeOfSysDensity]: " + th5);
        }
    }

    public static void checkDensity(Resources resources) {
        try {
            if (h.f196662a.a()) {
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                DisplayMetrics displayMetrics2 = FontSettingManager.customMetrics;
                if (displayMetrics2.density > 0.0f && FontSettingManager.needToSet(resources)) {
                    if (System.identityHashCode(displayMetrics) != System.identityHashCode(resources.getDisplayMetrics())) {
                        Configuration configuration = resources.getConfiguration();
                        configuration.fontScale = 1.0f;
                        configuration.densityDpi = displayMetrics2.densityDpi;
                        if (QLog.isDevelopLevel()) {
                            QLog.i(TAG, 4, "[checkDensity]: " + displayMetrics + " configDensityDpi is " + configuration.densityDpi);
                        }
                        resources.updateConfiguration(configuration, displayMetrics2);
                        if (QLog.isDevelopLevel()) {
                            QLog.i(TAG, 4, "[checkDensity]: after " + resources.getDisplayMetrics());
                        }
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.i(TAG, 1, "[checkDensity]", th5);
        }
        adjustFontScale(resources);
    }

    private static float computeNewDensity(Context context, float f16, float f17, float f18, int i3, float f19, boolean z16) {
        try {
            float doComputeNewDensity = doComputeNewDensity(context, f17, f18, i3, f19);
            if (!z16) {
                return doComputeNewDensity;
            }
            if (!checkAdjustInRange(context, doComputeNewDensity, f16)) {
                if (!DensityConfig.INSTANCE.getBackupDenistyComputerSwitch(context)) {
                    QLog.i(TAG, 1, "[computeNewDensity]: backupCompuerSwitch is false");
                    return -1.0f;
                }
                float a16 = j.f196669a.a(context, i3, f19, f17, f18);
                if (!checkAdjustInRange(context, a16, f16)) {
                    a16 = k.f196670a.a(context, i3, f19, f16, f18);
                    if (!checkAdjustInRange(context, a16, f16)) {
                        return -1.0f;
                    }
                }
                return a16;
            }
            return doComputeNewDensity;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "[computeNewDensity]", th5);
            return -1.0f;
        }
    }

    private static void densityResourceSetToOrigin(Context context) {
        Resources resources = context.getResources();
        if (resources instanceof d) {
            ((d) resources).e();
        }
    }

    private static float doComputeNewDensity(Context context, float f16, float f17, int i3, float f18) {
        Pair<Float, Float> scaleRange = DensityConfig.INSTANCE.getScaleRange(context);
        float f19 = f16 * f17;
        float floatValue = scaleRange.getFirst().floatValue();
        float floatValue2 = scaleRange.getSecond().floatValue();
        if (f19 < floatValue) {
            f19 = floatValue;
        } else if (f19 > floatValue2) {
            f19 = floatValue2;
        }
        QLog.i(TAG, 1, "revolutionScale is " + f16 + " dpiScale is " + f17 + " finalScale is " + f19 + " minScale is " + floatValue + " maxScale is " + floatValue2);
        addLog("revolutionScale is " + f16 + " dpiScale is " + f17 + " finalScale is " + f19 + " minScale is " + floatValue + " maxScale is " + floatValue2);
        return (f19 * i3) / f18;
    }

    public static int getBaseWidthFromProperties(Context context) {
        if (context == null) {
            return 400;
        }
        if (sUIDesignWidth < 0) {
            sUIDesignWidth = Integer.parseInt(PropertiesUtils.read(context, PROP_KEY_WIDTH, String.valueOf(400)));
        }
        if (QLog.isDevelopLevel()) {
            QLog.i(TAG, 4, "getBaseWidth is " + sUIDesignWidth);
        }
        return sUIDesignWidth;
    }

    public static int getCurrentDeviceWidth() {
        return sDeviceWidth;
    }

    public static int getDefaultDisplayDensity() {
        try {
            Class<?> cls = Class.forName("android.view.WindowManagerGlobal");
            Method method = cls.getMethod("getWindowManagerService", new Class[0]);
            method.setAccessible(true);
            Object invoke = method.invoke(cls, new Object[0]);
            Method method2 = invoke.getClass().getMethod("getInitialDisplayDensity", Integer.TYPE);
            method2.setAccessible(true);
            return ((Integer) method2.invoke(invoke, 0)).intValue();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getDefaultDisplayDensity err: " + e16);
            return 1;
        }
    }

    public static int getDefaultRevolution(Context context) {
        try {
            int defaultRevolution = DensityConfig.INSTANCE.getDefaultRevolution(context);
            if (defaultRevolution > 0) {
                return defaultRevolution;
            }
            Display.Mode[] supportedModes = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getSupportedModes();
            if (supportedModes == null || supportedModes.length <= 0) {
                return -1;
            }
            int min = Math.min(supportedModes[0].getPhysicalWidth(), supportedModes[0].getPhysicalHeight());
            QLog.i(TAG, 1, "getDeviceWidthOne: " + min);
            if (supportedModes.length > 1) {
                int min2 = Math.min(supportedModes[1].getPhysicalWidth(), supportedModes[1].getPhysicalHeight());
                if (min2 > 0 && min > 1440 && min2 < min) {
                    min = min2;
                }
                QLog.i(TAG, 1, "getDeviceWidthTwo: " + min2);
            }
            return min;
        } catch (Exception e16) {
            QLog.d(TAG, 1, "getDefaultRevolution err" + e16);
            return -1;
        }
    }

    private static int getDeviceWidth(Context context) {
        Display defaultDisplay;
        if (context == null) {
            QLog.d(TAG, 1, "getDeviceWidth err, context is null");
            return 0;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
            Display.Mode mode = defaultDisplay.getMode();
            QLog.i(TAG, 1, "getDeviceWidth mode is " + mode);
            if (mode != null) {
                return mode.getPhysicalWidth();
            }
            return getDeviceWidthByMetrics(context);
        }
        return getDeviceWidthByMetrics(context);
    }

    private static int getDeviceWidthByMetrics(Context context) {
        if (context == null) {
            QLog.d(TAG, 1, "getDeviceWidthByMetrics err, context is null");
            return 0;
        }
        Configuration configuration = context.getResources().getConfiguration();
        if (configuration == null) {
            QLog.d(TAG, 1, "getDeviceWidthByMetrics err, configuration is null");
            return 0;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics == null) {
            QLog.d(TAG, 1, "getDeviceWidthByMetrics err, displayMetrics is null");
            return 0;
        }
        if (configuration.orientation == 1) {
            return displayMetrics.widthPixels;
        }
        return displayMetrics.heightPixels;
    }

    public static float getScale() {
        if (sQQDisplayMetrics != null && sOriginDisplayMetrics != null) {
            if (sQQDisplayMetrics.density != 0.0f && sOriginDisplayMetrics.density != 0.0f) {
                float f16 = sQQDisplayMetrics.density / sOriginDisplayMetrics.density;
                if (!checkAdjustInRange(MobileQQ.sMobileQQ, sQQDisplayMetrics.density, sOriginDisplayMetrics.density)) {
                    QLog.d(TAG, 1, "getScale err: change is invalid");
                    return 1.0f;
                }
                return f16;
            }
            QLog.d(TAG, 1, "getScale err: sQQDisplayMetrics.density == 0 || sOriginDisplayMetrics.density == 0");
            return 1.0f;
        }
        QLog.d(TAG, 1, "getScale err: sQQDisplayMetrics == null || sOriginDisplayMetrics == null");
        return 1.0f;
    }

    public static float getScaleOfResolution(Context context, int i3) {
        if (context == null) {
            return 1.0f;
        }
        int defaultRevolution = getDefaultRevolution(context);
        sDefaultWidth = defaultRevolution;
        if (defaultRevolution == -1 || i3 <= 0) {
            return 1.0f;
        }
        float f16 = defaultRevolution / i3;
        QLog.i(TAG, 1, "default width is " + defaultRevolution + " currentWidth is " + i3);
        return f16;
    }

    private static int getSysPropHwFoldDisplay() {
        Stream of5;
        IntStream mapToInt;
        int[] array;
        try {
            String str = (String) SystemProperties.class.getMethod("get", String.class, String.class).invoke(SystemProperties.class, "ro.config.hw_fold_disp", "");
            if (str != null && !str.isEmpty()) {
                QLog.i(TAG, 1, "value " + str);
                if (Build.VERSION.SDK_INT >= 24) {
                    of5 = Stream.of((Object[]) str.split(","));
                    mapToInt = of5.mapToInt(new n());
                    array = mapToInt.toArray();
                    if (array.length > 3) {
                        return array[2];
                    }
                }
            }
        } catch (Exception e16) {
            addLog("getSysPropHwFoldDisplay " + e16);
            if (QLog.isDevelopLevel()) {
                QLog.i(TAG, 1, "getSysPropHwFoldDisplay " + e16);
            }
        }
        return 0;
    }

    private static int getSysPropOplusFoldDisplay() {
        Stream of5;
        IntStream mapToInt;
        int[] array;
        if (!isOPPOFold()) {
            return 0;
        }
        try {
            String str = (String) SystemProperties.class.getMethod("get", String.class, String.class).invoke(SystemProperties.class, "ro.config.oplus_fold_disp", "");
            QLog.i(TAG, 1, "getSysPropOplusFoldDisplay value " + str);
            addLog("getSysPropOplusFoldDisplay value " + str);
            if (!TextUtils.isEmpty(str) && Build.VERSION.SDK_INT >= 24) {
                of5 = Stream.of((Object[]) str.split(","));
                mapToInt = of5.mapToInt(new n());
                array = mapToInt.toArray();
                if (array.length <= 2) {
                    return 0;
                }
                return array[2];
            }
            return 0;
        } catch (Exception e16) {
            if (!QLog.isDevelopLevel()) {
                return 0;
            }
            addLog("getSysPropOplusFoldDisplay " + e16);
            QLog.i(TAG, 1, "getSysPropOplusFoldDisplay " + e16);
            return 0;
        }
    }

    public static float getSystemDensityScale(boolean z16) {
        DisplayMetrics displayMetrics;
        if (sOriginDisplayMetrics == null) {
            return 1.0f;
        }
        if (z16) {
            displayMetrics = Resources.getSystem().getDisplayMetrics();
        } else {
            displayMetrics = sOriginDisplayMetrics;
        }
        int i3 = displayMetrics.densityDpi;
        int defaultDisplayDensity = getDefaultDisplayDensity();
        sDefaultDensityDpi = defaultDisplayDensity;
        if (defaultDisplayDensity == 1) {
            return 1.0f;
        }
        QLog.i(TAG, 1, "sysCurDensityDpi is " + i3 + " sysDefultDensityDpi is " + defaultDisplayDensity);
        return i3 / defaultDisplayDensity;
    }

    private static void initSupportedWidthSet(Context context) {
        if (sCurWidthVersion != -1) {
            return;
        }
        HashSet<Integer> hashSet = sSupportedWidthSet;
        hashSet.add(720);
        hashSet.add(1080);
        hashSet.add(1440);
        hashSet.add(1212);
        hashSet.add(Integer.valueOf(gdt_analysis_event.EVENT_VIDEO_FIRST_FRAME_RENDERED));
        hashSet.add(1260);
        hashSet.add(1200);
        hashSet.add(1008);
        try {
            sCurWidthVersion = Integer.parseInt(PropertiesUtils.read(context, PROP_KEY_WIDTH_VER, "0"));
            String read = PropertiesUtils.read(context, PROP_KEY_WIDTH_ARR, "");
            boolean z16 = false;
            if (1 == MobileQQ.sProcessId) {
                String read2 = PropertiesUtils.read(context, PROP_KEY_WIDTH_ARR_NEW, "");
                int parseInt = Integer.parseInt(PropertiesUtils.read(context, PROP_KEY_WIDTH_VER_NEW, "0"));
                if (parseInt > sCurWidthVersion && !TextUtils.isEmpty(read2)) {
                    JSONArray jSONArray = new JSONArray(read2);
                    if (parseInt > sCurWidthVersion) {
                        z16 = true;
                    }
                    addSupportedWidthArr(context, jSONArray, parseInt, z16);
                    return;
                }
            }
            if (!TextUtils.isEmpty(read)) {
                addSupportedWidthArr(context, new JSONArray(read), sCurWidthVersion, false);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "readSupportedDeviceWidth exception : ", e16);
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "initSupportedWidthSet: currentProcess = " + MobileQQ.sProcessId + ", ver = " + sCurWidthVersion + ", set = " + sSupportedWidthSet);
        }
    }

    private static boolean isOPPOFold() {
        try {
            Class<?> cls = Class.forName("com.oplus.content.OplusFeatureConfigManager");
            Object invoke = cls.getDeclaredMethod("hasFeature", String.class).invoke(cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), "oplus.hardware.type.fold");
            if (!(invoke instanceof Boolean)) {
                return false;
            }
            return ((Boolean) invoke).booleanValue();
        } catch (Exception e16) {
            if (!QLog.isDevelopLevel()) {
                return false;
            }
            QLog.i(TAG, 1, "getSysPropOplusFoldDisplay " + e16);
            return false;
        }
    }

    public static void killProcess() {
        QLog.i(TAG, 1, "[killProcess]");
        for (String str : BE_KILLED_PROCESS) {
            killProcess(BaseApplication.getContext(), str);
        }
    }

    public static boolean needAdjustDensity(Context context) {
        return needAdjustDensity(context, false);
    }

    private static boolean needInit() {
        String str = MobileQQ.processName;
        for (String str2 : NONE_ADJUST_PROCESS_LIST) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static void resetMinWidth(Context context) {
        int parseInt = Integer.parseInt(PropertiesUtils.read(context, PropertiesUtils.KEY_MIN_SCREEN_WIDTH, "0"));
        if (parseInt != 0 && parseInt <= sDeviceWidth) {
            sDeviceWidth = parseInt;
            addLog("resetMinWidth sDeviceWidth is " + sDeviceWidth);
            QLog.d(TAG, 1, "resetMinWidth sDeviceWidth is " + sDeviceWidth);
            return;
        }
        saveMinWidth(context, sDefaultWidth);
    }

    public static void revertToLastDendisy(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        displayMetrics.density = sQQDisplayMetrics.density;
        displayMetrics.scaledDensity = sQQDisplayMetrics.density;
        displayMetrics.densityDpi = sQQDisplayMetrics.densityDpi;
    }

    private static void saveMinWidth(Context context, int i3) {
        try {
            if (Integer.parseInt(PropertiesUtils.read(context, PropertiesUtils.KEY_MIN_SCREEN_WIDTH, "0")) != i3) {
                PropertiesUtils.save(context, PropertiesUtils.KEY_MIN_SCREEN_WIDTH, String.valueOf(i3));
            }
        } catch (Throwable th5) {
            QLog.i(TAG, 1, "[saveMinWidth]: " + th5);
        }
    }

    private static void setBaseWidthToProperties(Context context, int i3) {
        if (context == null) {
            return;
        }
        PropertiesUtils.save(context, PROP_KEY_WIDTH, String.valueOf(i3));
    }

    public static void setGlobalDisplayMetrics(Context context, int i3, boolean z16) {
        adjustDisplayMetrics(context, i3, z16, true);
        if (z16) {
            setBaseWidthToProperties(context, i3);
            killProcess();
        }
    }

    public static void tryPrintLog() {
        StringBuilder sb5 = sLogBuilder;
        if (sb5 == null) {
            return;
        }
        try {
            String sb6 = sb5.toString();
            if (!TextUtils.isEmpty(sb6)) {
                QLog.e(TAG, 1, sb6);
            }
            i iVar = i.f196664a;
            if (!TextUtils.isEmpty(iVar.c())) {
                QLog.e(TAG, 1, "propertiesContent is " + iVar.c());
            }
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
        }
        sLogBuilder = null;
    }

    public static void updateSupportedWidthArrCache(Context context, JSONArray jSONArray, int i3) {
        if (i3 > sCurWidthVersion && jSONArray != null) {
            PropertiesUtils.save(context, PROP_KEY_WIDTH_ARR_NEW, jSONArray.toString());
            PropertiesUtils.save(context, PROP_KEY_WIDTH_VER_NEW, String.valueOf(i3));
        }
    }

    public static boolean needAdjustDensity(Context context, boolean z16) {
        if (context == null) {
            return false;
        }
        if (z16) {
            if (canSupportDeviceWidthNew(sDeviceWidth) && needInit()) {
                sNeedAdjust = true;
            }
            return sNeedAdjust;
        }
        if (!sInitToggle) {
            if (canSupportDeviceWidth(context, sDeviceWidth) && needInit()) {
                sNeedAdjust = true;
            }
            sInitToggle = true;
        }
        return sNeedAdjust;
    }

    private static boolean killProcess(Context context, String str) {
        if (context != null && str != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : SystemMethodProxy.getRunningAppProcesses((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY))) {
                if (runningAppProcessInfo.processName.equals(str)) {
                    SystemMethodProxy.killProcess(runningAppProcessInfo.pid);
                    return true;
                }
            }
        }
        return false;
    }

    private static int adjustDisplayMetrics(Context context, float f16, boolean z16, boolean z17) {
        if (context != null && f16 > 0.0f) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (sOriginDisplayMetrics == null) {
                sOriginDisplayMetrics = new DisplayMetrics();
                sOriginDisplayMetrics.setTo(displayMetrics);
            }
            if (sDeviceWidth < 0) {
                sDeviceWidth = getDeviceWidth(context);
                QLog.d(TAG, 1, "sDeviceWidth is " + sDeviceWidth);
                addLog("sDeviceWidth is " + sDeviceWidth);
            }
            if (!needAdjustDensity(context)) {
                QLog.i(TAG, 1, "do not need adjust first");
                addLog("do not need adjust first");
                if (e.f196658a.a()) {
                    int sysPropHwFoldDisplay = getSysPropHwFoldDisplay();
                    if (sysPropHwFoldDisplay > 0) {
                        sDeviceWidth = sysPropHwFoldDisplay;
                    } else if (f.f196660a.a()) {
                        sysPropHwFoldDisplay = getSysPropOplusFoldDisplay();
                        if (sysPropHwFoldDisplay > 0) {
                            sDeviceWidth = sysPropHwFoldDisplay;
                        } else {
                            resetMinWidth(context);
                        }
                    }
                    if (sysPropHwFoldDisplay == 0 || !needAdjustDensity(context, true)) {
                        QLog.i(TAG, 1, "do not need adjust second");
                        addLog("do not need adjust second");
                        sQQDisplayMetrics.setTo(displayMetrics);
                        sDefaultWidth = getDefaultRevolution(context);
                        sDefaultDensityDpi = getDefaultDisplayDensity();
                        return 0;
                    }
                } else {
                    QLog.i(TAG, 1, "do not need adjust");
                    sQQDisplayMetrics.setTo(displayMetrics);
                    sDefaultWidth = getDefaultRevolution(context);
                    sDefaultDensityDpi = getDefaultDisplayDensity();
                    return 0;
                }
            }
            if (!FontSettingManager.needToSet(context.getResources()) && !z17) {
                int i3 = sAdjustResult;
                if (i3 >= 0) {
                    return i3;
                }
                return 1;
            }
            saveMinWidth(context, sDefaultWidth);
            QLog.d(TAG, 1, "sDeviceWidth final is " + sDeviceWidth);
            addLog("sDeviceWidth final is " + sDeviceWidth);
            float f17 = displayMetrics.density;
            if (sCurDensity < 0.0f) {
                sCurDensity = computeNewDensity(context, f17, getScaleOfResolution(context, getDeviceWidth(context)), getSystemDensityScale(false), sDeviceWidth, f16, true);
                QLog.i(TAG, 1, "[adjustDisplayMetrics]: new Density is " + sCurDensity);
                addLog("[adjustDisplayMetrics]: new Density is " + sCurDensity);
            }
            float f18 = sCurDensity;
            float abs = Math.abs(f18 - f17) / f17;
            if (!checkAdjustInRange(context, f18, f17)) {
                QLog.i(TAG, 1, "change is invalid: " + abs + " oldDensity is " + f17 + " newDensity is " + f18);
                addLog("change is invalid: " + abs + " oldDensity is " + f17 + " newDensity is " + f18);
                sQQDisplayMetrics.setTo(displayMetrics);
                return 2;
            }
            displayMetrics.density = f18;
            float f19 = f18 / f17;
            displayMetrics.densityDpi = (int) (displayMetrics.densityDpi * f19);
            displayMetrics.scaledDensity *= f19;
            if (z16) {
                sQQDisplayMetrics.setTo(displayMetrics);
            }
            return 1;
        }
        QLog.i(TAG, 1, "context is null " + f16);
        return 0;
    }
}
