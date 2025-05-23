package com.tencent.mobileqq.app;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.avbiz.Constants;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.app.guard.GuardState;
import com.tencent.mobileqq.app.utils.GlobalDisplayMetricsManager;
import com.tencent.mobileqq.app.utils.PropertiesUtils;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInitMethod;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInject;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes11.dex */
public class FontSettingManager {
    static IPatchRedirector $redirector_ = null;
    private static final String[] BE_KILLED_PROCESS;
    private static final String[][] BRAND_AND_MODEL_BLACK_LIST;
    public static final String FONT_LEVEL_KEY = "font_setting_font_level_key";
    public static final String FONT_LEVEL_SP_NAME = "font_level_sp_name";
    public static final String FONT_SWITCHER_CLOSE = "0";
    public static final String FONT_SWITCHER_DEFAULT = "-1";
    public static final String FONT_SWITCHER_OPEN = "1";
    public static final int GET_FONT_LEVEL_ERROR = -1000;
    private static final String[] MODEL_BLACK_LIST;
    private static final String[] NONE_FONTSETTING_PROCESS_LIST;
    private static final String QQPROCESSNAME = "com.tencent.mobileqq";
    public static final String TAG = "FontSettingManager";
    public static DisplayMetrics customMetrics;
    private static float sFontLevel;
    private static StringBuilder sLogBuilder;

    @QAutoInject(configPath = "AutoInjectYml/Foundation/Establish/Inject_QQReport.yml", version = 1)
    static com.tencent.mobileqq.inject.q sQQReport;
    private static ArrayList sQQReport_AutoGenClazzList_QAutoInjectTransform;
    public static DisplayMetrics systemMetrics;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public interface FontLevel {
        public static final float FONT_SIZE_LARGE = 17.0f;
        public static final float FONT_SIZE_MORE_SMALL = 13.92f;
        public static final float FONT_SIZE_SMALL = 15.0f;
        public static final float FONT_SIZE_STANDER = 16.0f;
        public static final float FONT_SIZE_XLARGE = 18.0f;
        public static final float FONT_SIZE_XXLARGE = 20.0f;
        public static final float FONT_SIZE_XXXLARGE = 21.24f;
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39623);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList arrayList = new ArrayList();
        sQQReport_AutoGenClazzList_QAutoInjectTransform = arrayList;
        arrayList.add(com.tencent.mobileqq.injector.ab.class);
        BE_KILLED_PROCESS = new String[]{"com.tencent.mobileqq:tool", "com.tencent.mobileqq:picture", "com.tencent.mobileqq:qqreader", "com.tencent.mobileqq:story", "com.tencent.mobileqq:qzone", "com.tencent.mobileqq:qwallet", "com.tencent.mobileqq:qqwifi", "com.tencent.mobileqq:qqfav", "com.tencent.mobileqq:dingdong", "com.tencent.mobileqq:buscard", "com.tencent.mobileqq:qqhotspot", "com.tencent.mobileqq"};
        systemMetrics = new DisplayMetrics();
        customMetrics = new DisplayMetrics();
        sLogBuilder = new StringBuilder();
        sFontLevel = 16.0f;
        NONE_FONTSETTING_PROCESS_LIST = new String[]{"com.tencent.mobileqq:qqreader", "com.tencent.mobileqq:photoplus", Constants.Process.VIDEO_PROCESS, "com.tencent.mobileqq:peak", "com.tencent.mobileqq:mini_internal", GuardState.PROCESS_NAME_MINIAPP, "com.tencent.mobileqq:mini1", "com.tencent.mobileqq:mini2", "com.tencent.mobileqq:mini3", "com.tencent.mobileqq:mini4", "com.tencent.mobileqq:mini5", "com.tencent.mobileqq:mini6", "com.tencent.mobileqq:mini7", "com.tencent.mobileqq:wxa_container0", "com.tencent.mobileqq:wxa_container1"};
        BRAND_AND_MODEL_BLACK_LIST = new String[][]{new String[]{"OPPO", "PHILIPS", "KONKA", "Sony", "Meitu", "GiONEE", "GiONEE", "GiONEE", "GiONEE", "alps", CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI, CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI, CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI, "Huawei", "BBK", "LGE"}, new String[]{"R815T", "W6500", "K5", "S39h", "MK150", "GN137", "GN705T", "GN708T", "E3T", "K5", "Mi-4c", "MI 4S", "MI NOTE Pro", "Nexus 6P", "vivo X3S W", "Nexus 5X"}};
        MODEL_BLACK_LIST = new String[]{"vivo Y13", "vivo X3t", "vivo Y11i T", "MI-ONE Plus", "vivoY11iT", "Coolpad 7270", "Coolpad 8122", "Lenovo A708T", "Lenovo S820", "Lenovo S898t", "GT-I9050", "GT-S7568", "DOOV S2y", "TCL J928", "vivo Y22", "ChanghongZ8t", "HUAWEI Y516-T00", "Lenovo A678t", "K-Touch T60", "vivo X710L", "HM MOTE 1TD", "Redmi 3"};
    }

    public FontSettingManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void doFontLevelSetting(Context context, boolean z16, boolean z17) {
        Resources resources = context.getResources();
        if (needToSet(resources)) {
            systemMetrics.setTo(GlobalDisplayMetricsManager.sQQDisplayMetrics);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "current density: " + systemMetrics.density + ", custom density: " + customMetrics.density);
            }
            com.tencent.mobileqq.app.utils.i.f196664a.i(resources.getConfiguration().fontScale, false);
            initFontSetting(context, z16, z17);
        }
    }

    private static void ensureInitInject() {
        boolean z16;
        if (sQQReport == null) {
            initQAutoInject();
        }
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[AutoInject] inject:");
            if (sQQReport != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.d(TAG, 2, sb5.toString());
        }
    }

    public static float getFontLevel() {
        return sFontLevel;
    }

    private static float getFontLevelFromProperties(Context context) {
        if (context == null) {
            return -1000.0f;
        }
        float f16 = 16.0f;
        float floatValue = Float.valueOf(PropertiesUtils.read(context, PropertiesUtils.KEY_FONT_LEVEL, String.valueOf(16.0f))).floatValue();
        if (floatValue >= 13.92f && floatValue <= 21.24f) {
            f16 = floatValue;
        }
        sFontLevel = f16;
        return f16;
    }

    public static float getFontScale() {
        return sFontLevel / 16.0f;
    }

    private static void initFontSetting(Context context, boolean z16, boolean z17) {
        float fontLevelFromProperties;
        if (!needInit(context)) {
            customMetrics.setTo(context.getResources().getDisplayMetrics());
            return;
        }
        QLog.d(TAG, 1, "[FontSetting] initFontSetting, to check font size change isConfigChange " + z16);
        com.tencent.mobileqq.app.utils.i.f196664a.a(context, true);
        if (z16) {
            fontLevelFromProperties = sFontLevel;
        } else {
            fontLevelFromProperties = getFontLevelFromProperties(context);
        }
        setCustomDensity(context, fontLevelFromProperties, z17);
    }

    @QAutoInitMethod
    static void initQAutoInject() {
        sQQReport = (com.tencent.mobileqq.inject.q) com.tencent.mobileqq.qroute.utils.b.a(sQQReport_AutoGenClazzList_QAutoInjectTransform);
    }

    public static boolean isDisplayMetricNoAnswer() {
        String str;
        ensureInitInject();
        com.tencent.mobileqq.inject.q qVar = sQQReport;
        String str2 = "";
        if (qVar == null) {
            str = "";
        } else {
            str = qVar.a();
        }
        com.tencent.mobileqq.inject.q qVar2 = sQQReport;
        if (qVar2 != null) {
            str2 = qVar2.getDeviceModel();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "current machine brandName:" + str + ", modelName:" + str2);
        }
        if (!str.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI) || !str2.equals("MI 4S")) {
            if (!str.equals("Huawei") || !str2.equals("Nexus 6P")) {
                if (!str.equals("BBK") || !str2.equals("vivo X3S W")) {
                    if ((str.equals("LGE") && str2.equals("Nexus 5X")) || str2.equals("Redmi 3")) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public static boolean isFontSizeLarge() {
        if (getFontLevel() >= 17.0f) {
            return true;
        }
        return false;
    }

    public static boolean isFontSizeNormal() {
        if (sFontLevel == 16.0f && GlobalDisplayMetricsManager.getScale() == 1.0f) {
            return true;
        }
        return false;
    }

    private static boolean isScaleValueRight(float f16) {
        if (f16 > 13.82f && f16 < 21.34f) {
            return true;
        }
        return false;
    }

    public static boolean isSupportDevice() {
        String str;
        ensureInitInject();
        com.tencent.mobileqq.inject.q qVar = sQQReport;
        String str2 = "";
        if (qVar == null) {
            str = "";
        } else {
            str = qVar.a();
        }
        com.tencent.mobileqq.inject.q qVar2 = sQQReport;
        if (qVar2 != null) {
            str2 = qVar2.getDeviceModel();
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "current machine brandName:" + str + ", modelName:" + str2);
        }
        for (int length = BRAND_AND_MODEL_BLACK_LIST[0].length - 1; length >= 0; length--) {
            String[][] strArr = BRAND_AND_MODEL_BLACK_LIST;
            if (str.equals(strArr[0][length]) && str2.equals(strArr[1][length])) {
                return false;
            }
        }
        for (String str3 : MODEL_BLACK_LIST) {
            if (str2.equals(str3)) {
                return false;
            }
        }
        return true;
    }

    public static void killProcess() {
        for (String str : BE_KILLED_PROCESS) {
            killProcess(BaseApplication.getContext(), str);
        }
    }

    private static boolean needInit(Context context) {
        String str = MobileQQ.processName;
        for (String str2 : NONE_FONTSETTING_PROCESS_LIST) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    public static boolean needToSet(Resources resources) {
        if (resources != null && (Math.abs(customMetrics.density - resources.getDisplayMetrics().density) > 0.01f || Math.abs(customMetrics.scaledDensity - resources.getDisplayMetrics().scaledDensity) > 0.01f || customMetrics.densityDpi != resources.getDisplayMetrics().densityDpi)) {
            return true;
        }
        return false;
    }

    public static void resetViewSize2Normal(Context context, View view) {
        if (view == null || isFontSizeNormal()) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                resetViewSize2Normal(context, viewGroup.getChildAt(i3));
            }
        }
        if (view instanceof TextView) {
            ((TextView) view).setTextSize(0, (int) ((systemMetrics.scaledDensity * com.tencent.mobileqq.util.x.i(context, r0.getTextSize())) + 0.5d));
        }
        view.setPadding((int) revertSize2Normal(context, view.getPaddingLeft()), (int) revertSize2Normal(context, view.getPaddingTop()), (int) revertSize2Normal(context, view.getPaddingRight()), (int) revertSize2Normal(context, view.getPaddingBottom()));
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.bottomMargin = (int) revertSize2Normal(context, marginLayoutParams.bottomMargin);
            marginLayoutParams.topMargin = (int) revertSize2Normal(context, marginLayoutParams.topMargin);
            marginLayoutParams.leftMargin = (int) revertSize2Normal(context, marginLayoutParams.leftMargin);
            marginLayoutParams.rightMargin = (int) revertSize2Normal(context, marginLayoutParams.rightMargin);
        }
        int i16 = layoutParams.width;
        if (i16 != -1 && i16 != -2) {
            layoutParams.width = (int) revertSize2Normal(context, i16);
        }
        int i17 = layoutParams.height;
        if (i17 != -1 && i17 != -2) {
            layoutParams.height = (int) revertSize2Normal(context, i17);
        }
        view.setLayoutParams(layoutParams);
    }

    public static void revert2SystemDensity(Context context) {
        if (context.getResources().getDisplayMetrics().density != systemMetrics.density) {
            setCustomDensity(context, 16.0f, true);
            QLog.e(TAG, 1, "revert2SystemDensity " + QLog.getStackTraceString(new Throwable()));
        }
    }

    public static float revertSize2Normal(Context context, float f16) {
        return (int) ((com.tencent.mobileqq.util.x.h(context, f16) * systemMetrics.density) + 0.5f);
    }

    public static void revertToLastDendisy(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        DisplayMetrics displayMetrics2 = customMetrics;
        displayMetrics.density = displayMetrics2.density;
        displayMetrics.scaledDensity = displayMetrics2.density;
        displayMetrics.densityDpi = displayMetrics2.densityDpi;
    }

    public static boolean setCustomDensity(Context context, float f16, boolean z16) {
        if (!isScaleValueRight(f16)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "wrong scale vale : " + f16);
            }
            return false;
        }
        float f17 = f16 / 16.0f;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        updateSystemMetrics(displayMetrics);
        DisplayMetrics displayMetrics2 = systemMetrics;
        float f18 = displayMetrics2.density * f17;
        displayMetrics.density = f18;
        displayMetrics.scaledDensity = displayMetrics2.density * f17;
        displayMetrics.densityDpi = (int) (displayMetrics2.densityDpi * f17);
        QLog.d(TAG, 1, "currentDm: ", Float.valueOf(f18), ", ", Float.valueOf(displayMetrics.scaledDensity), ", ", Integer.valueOf(displayMetrics.densityDpi));
        if (z16) {
            customMetrics.setTo(displayMetrics);
            if (sFontLevel != f16) {
                sFontLevel = f16;
                updateFontLevel(context, f16);
                return true;
            }
        }
        return false;
    }

    private static void setFontLevelToProperties(Context context, float f16) {
        if (context == null) {
            return;
        }
        PropertiesUtils.save(context, PropertiesUtils.KEY_FONT_LEVEL, String.valueOf(f16));
    }

    public static void updateFontLevel(Context context, float f16) {
        sFontLevel = f16;
        setFontLevelToProperties(context, f16);
    }

    private static void updateSystemMetrics(DisplayMetrics displayMetrics) {
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        displayMetrics2.setTo(displayMetrics);
        DisplayMetrics displayMetrics3 = systemMetrics;
        displayMetrics2.density = displayMetrics3.density;
        displayMetrics2.scaledDensity = displayMetrics3.scaledDensity;
        displayMetrics2.densityDpi = displayMetrics3.densityDpi;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "systemMetrics.density : " + systemMetrics.density);
            QLog.d(TAG, 2, "systemMetrics.scaledDensity : " + systemMetrics.scaledDensity);
            QLog.d(TAG, 2, "systemMetrics.densityDpi : " + systemMetrics.densityDpi);
        }
        systemMetrics = displayMetrics2;
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

    @Deprecated
    public static void resetFontIfNeeded(Context context, boolean z16, boolean z17) {
    }
}
