package com.tencent.hippy.qq.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlReportBuilder;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qqgamepub.utils.GamePubAccountHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.http2.HttpConnectionService;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyUtils {
    public static final String BASE_API_PROVIDER_CLASS_NAME = "com.tencent.hippy.qq.app.HippyQQAPIProvider";
    private static final String CONFIG_ID_ENABLE_HTTP2 = "100496";
    public static final String GAMECENTER_API_PROVIDER_CLASS_NAME = "com.tencent.hippy.qq.app.GameCenterApiProvider";
    private static final String HIPPY_FONE_FOLDER = "hippy_font";
    private static final String HIPPY_FONT_DIR;
    private static final float RATIO_MIN_SCREEN = 0.71f;
    private static final String TAG = "HippyUtils";
    private static HashMap<String, Constructor<?>> gProviderConstructorMap = new HashMap<>();
    private static DeviceType mDeviceType;
    private static final AtomicBoolean mHasCheckDeviceType;

    static {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(BaseApplication.getContext().getFilesDir());
        String str = File.separator;
        sb5.append(str);
        sb5.append(HIPPY_FONE_FOLDER);
        sb5.append(str);
        HIPPY_FONT_DIR = sb5.toString();
        mHasCheckDeviceType = new AtomicBoolean(false);
        mDeviceType = DeviceType.PHONE;
    }

    private static synchronized void addApiProvider(List<HippyAPIProvider> list, String str) {
        synchronized (HippyUtils.class) {
            if (list != null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        Constructor<?> constructor = gProviderConstructorMap.get(str);
                        if (constructor == null) {
                            constructor = Class.forName(str).getConstructor(new Class[0]);
                            gProviderConstructorMap.put(str, constructor);
                        }
                        Object newInstance = constructor.newInstance(new Object[0]);
                        if (newInstance instanceof HippyAPIProvider) {
                            list.add((HippyAPIProvider) newInstance);
                        }
                    } catch (Throwable th5) {
                        QLog.e(TAG, 1, "addApiProvider e:" + th5);
                    }
                }
            }
        }
    }

    public static void addBaseApiProvider(List<HippyAPIProvider> list) {
        addApiProvider(list, BASE_API_PROVIDER_CLASS_NAME);
    }

    public static void addGameCenterApiProvider(List<HippyAPIProvider> list) {
        addApiProvider(list, GAMECENTER_API_PROVIDER_CLASS_NAME);
    }

    public static boolean enableHttp2() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn(CONFIG_ID_ENABLE_HTTP2, false);
    }

    public static AppInterface getAppInterface() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (MobileQQ.sProcessId == 7 && waitAppRuntime != null) {
            waitAppRuntime = waitAppRuntime.getAppRuntime("modular_web");
        }
        if (!(waitAppRuntime instanceof AppInterface)) {
            return null;
        }
        return (AppInterface) waitAppRuntime;
    }

    public static DisplayMetrics getDisplayMetrics() {
        BaseApplication context = BaseApplication.getContext();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay == null) {
            return null;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        displayMetrics2.setTo(displayMetrics);
        defaultDisplay.getRealMetrics(displayMetrics2);
        return displayMetrics;
    }

    public static String getHippyFontRootDir() {
        return HIPPY_FONT_DIR;
    }

    public static Pair<Integer, Integer> getScreenSize(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return new Pair<>(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
    }

    public static void gotoBrowserActivity(Context context, String str) {
        try {
            Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", str);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "gotoBrowserActivity e:", e16);
        }
    }

    public static void gotoGamePubAccountErrorUrl(Activity activity, String str) {
        WadlReportBuilder wadlReportBuilder = new WadlReportBuilder();
        wadlReportBuilder.setDcId(WadlProxyConsts.TAG_DC_00087).setOperModule("771").setOperId("206612").setExt(1, "76918").setExt(11, "1").setExt(12, "160");
        wadlReportBuilder.setExt(24, GamePubAccountHelper.s());
        wadlReportBuilder.setRetId(-4);
        wadlReportBuilder.report();
        ((IQQGameHelper) QRoute.api(IQQGameHelper.class)).enterAIO(activity);
    }

    public static boolean isFold() {
        if (PadUtil.a(BaseApplication.getContext()) == DeviceType.FOLD) {
            return true;
        }
        return false;
    }

    public static boolean isFolderScreenOpenMode(Context context) {
        int intValue = ((Integer) getScreenSize(context).first).intValue();
        int intValue2 = ((Integer) getScreenSize(context).second).intValue();
        boolean z16 = false;
        if (intValue > 0 && intValue2 > 0) {
            float f16 = (intValue * 1.0f) / intValue2;
            if (f16 >= RATIO_MIN_SCREEN && f16 <= 1.4084507f) {
                z16 = true;
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "[isFolderScreenOpenMode] " + z16 + ",curRatio:" + f16);
            }
        }
        return z16;
    }

    public static boolean isPadOrFoldDevice() {
        boolean z16;
        DeviceType a16 = PadUtil.a(BaseApplication.getContext());
        if (a16 != DeviceType.TABLET && (a16 != DeviceType.FOLD || !isFolderScreenOpenMode(BaseApplication.getContext()))) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[isPadOrFoldDevice] isPadOrFoldDevice:" + z16 + ",model:" + ah.s());
        }
        return z16;
    }

    public static HttpURLConnection openConnection(URL url) throws IOException {
        return new HttpConnectionService(enableHttp2()).openConnection(url);
    }

    public static void reportEngineRemoved(String str, int i3, int i16, String str2) {
        QLog.d(TAG, 1, "reportEngineRemoved moduleName", str, " moduleVersion:", Integer.valueOf(i3), " retCode:", Integer.valueOf(i16), " from:", str2);
    }

    public static void safeClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e16) {
                QLog.e(HippyQQConstants.HIPPY_TAG, 1, "safeClose e:", e16);
            }
        }
    }

    public static String safelyGetJsFrameworkType(String str, String str2) {
        if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                str = Uri.parse(str2).getQueryParameter("framework");
            } catch (Exception e16) {
                QLog.e(TAG, 1, "safelyGetJsFrameworkType error:" + e16);
            }
        }
        if (str != null && str.toLowerCase().contains("react")) {
            return "react";
        }
        return HippyQQConstants.HIPPY_VUE;
    }

    public static void startToolProcess(Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            ((IWebProcessPreload) QRoute.api(IWebProcessPreload.class)).preloadWebProcessWithData(14, intent.getExtras());
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "startToolProcess error:", th5);
        }
    }
}
