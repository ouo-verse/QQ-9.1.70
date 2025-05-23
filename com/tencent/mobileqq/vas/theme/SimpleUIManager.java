package com.tencent.mobileqq.vas.theme;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import com.tencent.theme.n;
import com.tencent.util.AppSetting;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class SimpleUIManager {
    private static final String SIMPLE_MODE_RES_CHECK_SUC_VERSION = "simple_mode_res_check_suc_version";
    private static final String SIMPLE_MODE_RES_NAME_WITH_VERSION = "simple_mode_res_name_with_version";
    private static final String SIMPLE_MODE_RES_SP_NAME = "simple_mode_res_check";
    private static final String TAG = "SimpleUIManager";
    protected static String sSimpleSkinRootPath;

    private static void checkResLegalAndUnzip(final Context context, String str, String str2) {
        boolean z16;
        File file = new File(str);
        if (file.exists() && checkSimpleResValid(context, str)) {
            QLog.d(TAG, 1, "unzip file check pass");
            return;
        }
        if (file.exists()) {
            QLog.d(TAG, 1, "unzip file check not pass, dest file exists");
            FileUtils.deleteDirectory(str);
        }
        QLog.d(TAG, 1, "dest file not exit");
        String unzipPath = new ThemeLocator().setThemeId("1001").init(context, ThemeConstants.THEME_ID_SIMPLE_SPEC, "tmpDir").getUnzipPath();
        File file2 = new File(unzipPath);
        if (file2.exists()) {
            FileUtils.deleteDirectory(file2.getAbsolutePath());
        }
        file2.mkdirs();
        if (uncompressZip(context, unzipPath, "simpleTheme/" + str2 + ".zip")) {
            z16 = file2.renameTo(file);
            QLog.d(TAG, 1, "rename result : ", Boolean.valueOf(z16));
        } else {
            z16 = false;
        }
        if (!z16) {
            ThemeSwitcher.startSwitch("1000", ThemeReporter.FROM_ENGINE, null);
            if (file.exists()) {
                FileUtils.deleteDirectory(file.getAbsolutePath());
            }
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.vas.theme.SimpleUIManager.1
                    @Override // java.lang.Runnable
                    public void run() {
                        QQToast.makeText(context, 1, HardCodeUtil.qqStr(R.string.f230046y3), 0).show();
                    }
                });
            } else {
                QQToast.makeText(context, 1, HardCodeUtil.qqStr(R.string.f230046y3), 0).show();
            }
        }
    }

    private static boolean checkSimpleResValid(Context context, String str) {
        QLog.d(TAG, 1, "checkSimpleResValid:::start check res valid");
        if (!needCheck() && FileUtils.fileExists(str)) {
            QLog.d(TAG, 1, "checkSimpleResValid:::start check interrupt!!!!");
            return true;
        }
        String themeZipMd5 = getThemeZipMd5(context);
        if (themeZipMd5 == null) {
            QLog.d(TAG, 1, "checkSimpleResValid:::assets zip name is null");
            return false;
        }
        try {
            InputStream open = context.getAssets().open("simpleTheme/" + themeZipMd5 + ".zip");
            try {
                boolean checkUnzipResult = FileUtils.checkUnzipResult(open, str);
                if (checkUnzipResult) {
                    String reportVersionName = AppSetting.getReportVersionName();
                    QLog.d(TAG, 1, "checkSimpleResValid:::check suc and put version to mmkv: " + reportVersionName);
                    QMMKV.fromSpAdapter(BaseApplication.getContext(), SIMPLE_MODE_RES_SP_NAME, "common_mmkv_configurations").edit().putString(SIMPLE_MODE_RES_CHECK_SUC_VERSION, reportVersionName).apply();
                }
                if (open != null) {
                    open.close();
                }
                return checkUnzipResult;
            } finally {
            }
        } catch (IOException e16) {
            QLog.d(TAG, 1, "checkSimpleResValid:::error : ", e16);
            return false;
        }
    }

    private static boolean copySimpleAssetToSDCard(Context context, String str) {
        String simpleZipPath = getSimpleZipPath(context);
        File file = new File(simpleZipPath);
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        if (file.exists()) {
            file.delete();
        }
        return FileUtils.copyAssetToFile(context, str, simpleZipPath);
    }

    public static boolean delayThemeInitAfterLogin(AppRuntime appRuntime, AppRuntime appRuntime2) {
        QLog.d(TAG, 1, "start check need delay or not");
        if (appRuntime != null && !TextUtils.isEmpty(appRuntime.getAccount())) {
            String userThemeIDForReset = ThemeUtil.getUserThemeIDForReset(appRuntime);
            if (!QQTheme.isThemeSimpleUI(userThemeIDForReset)) {
                QLog.d(TAG, 1, "target theme not simple theme");
                return false;
            }
            if (appRuntime2 == null || appRuntime2.getAccount() == null || appRuntime2.getAccount().equals(appRuntime.getAccount())) {
                return false;
            }
            String userThemeIDForReset2 = ThemeUtil.getUserThemeIDForReset(appRuntime2);
            QLog.d(TAG, 1, "cur theme : ", userThemeIDForReset2, " target theme : ", userThemeIDForReset);
            if (userThemeIDForReset2 != null && !userThemeIDForReset2.equals(userThemeIDForReset)) {
                return true;
            }
            return false;
        }
        QLog.d(TAG, 1, "cur app interface null or not login");
        return false;
    }

    public static void deleteSkinRootPath(Context context) {
        String themeZipMd5 = getThemeZipMd5(context);
        QLog.d(TAG, 1, "start deleteSkinRootPath");
        if (themeZipMd5 == null) {
            QLog.d(TAG, 1, "deleteSkinRootPath, name is null");
            return;
        }
        String unzipPath = new ThemeLocator().setThemeId("1001").init(context, ThemeConstants.THEME_ID_SIMPLE_SPEC, themeZipMd5).getUnzipPath();
        if (!new File(unzipPath).exists()) {
            QLog.d(TAG, 1, "deleteSkinRootPath, path not exit");
        } else {
            FileUtils.deleteDirectory(unzipPath);
        }
    }

    public static long getDelayMillions(AppRuntime appRuntime) {
        boolean z16;
        String currentThemeId = QQTheme.getCurrentThemeId();
        String userThemeIDForReset = ThemeUtil.getUserThemeIDForReset(appRuntime);
        if (!"2920".equals(currentThemeId) && !"2920".equals(userThemeIDForReset)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return 1500L;
        }
        return 200L;
    }

    public static String getLocalPath(Context context) {
        unzipResZip(context);
        return sSimpleSkinRootPath;
    }

    private static String getResNameByMMKV() {
        String str = "";
        String string = QMMKV.fromSpAdapter(BaseApplication.getContext(), SIMPLE_MODE_RES_SP_NAME, "common_mmkv_configurations").getString(SIMPLE_MODE_RES_NAME_WITH_VERSION, "");
        if (!TextUtils.isEmpty(string) && string.contains("/")) {
            String[] split = string.split("/");
            String str2 = split[1];
            if (!TextUtils.isEmpty(str2) && TextUtils.equals(str2, AppSetting.getReportVersionName())) {
                str = split[0];
            }
        }
        QLog.d(TAG, 1, "getResNameByMMKV::: curKeyWithVersion: " + SIMPLE_MODE_RES_NAME_WITH_VERSION + " - " + string + ", after spilt:" + str);
        return str;
    }

    private static String getSimpleZipPath(Context context) {
        ThemeLocator themeLocator = new ThemeLocator();
        themeLocator.setThemeId(ThemeConstants.THEME_ID_SIMPLE_SPEC);
        return themeLocator.getBasePath(context) + ThemeUtil.THEME_SIMPLE_SKIN_NAME;
    }

    protected static String getThemeZipMd5(Context context) {
        String resNameByMMKV = getResNameByMMKV();
        if (!TextUtils.isEmpty(resNameByMMKV)) {
            return resNameByMMKV;
        }
        try {
            String[] list = context.getAssets().list("simpleTheme");
            if (list.length == 0) {
                QLog.d(TAG, 1, "list length is 0");
                return null;
            }
            String[] split = list[0].split("\\.");
            String str = split[0] + "/" + AppSetting.getReportVersionName();
            QLog.d(TAG, 1, "getThemeZipMd5 and put it to mmkv:" + SIMPLE_MODE_RES_NAME_WITH_VERSION + " - " + str);
            QMMKV.fromSpAdapter(BaseApplication.getContext(), SIMPLE_MODE_RES_SP_NAME, "common_mmkv_configurations").edit().putString(SIMPLE_MODE_RES_NAME_WITH_VERSION, str).apply();
            return split[0];
        } catch (IOException e16) {
            QLog.d(TAG, 1, "getThemeZipName error : ", e16);
            return null;
        }
    }

    public static boolean initLocalSimpleSkin(Context context) {
        unzipResZip(context);
        n nVar = new n();
        nVar.f376085a = sSimpleSkinRootPath;
        return SkinEngine.getInstances().switchToSimpleModel(context, nVar);
    }

    public static void initSkinEngine() {
        if (MobileQQ.sProcessId == 1) {
            return;
        }
        try {
            boolean z16 = InitSkin.sInited;
            InitSkin.class.getMethod("startInitSkinEngine", new Class[0]).invoke(InitSkin.class, new Object[0]);
            QLog.d(TAG, 1, "initSkinEngine success");
        } catch (Exception e16) {
            QLog.e(TAG, 1, "invoke init engine error : ", e16);
        }
    }

    public static boolean isNewSimpleUI() {
        return SkinEngine.getInstances().isInSimpleModel();
    }

    private static boolean needCheck() {
        String string = QMMKV.fromSpAdapter(BaseApplication.getContext(), SIMPLE_MODE_RES_SP_NAME, "common_mmkv_configurations").getString(SIMPLE_MODE_RES_CHECK_SUC_VERSION, "");
        String reportVersionName = AppSetting.getReportVersionName();
        QLog.d(TAG, 1, "checkSimpleResValid:::checkSucVersion: " + string + ", curVersion:" + reportVersionName);
        if (TextUtils.isEmpty(string) || !TextUtils.equals(string, reportVersionName)) {
            return true;
        }
        return false;
    }

    public static void resetFlagToRecheckRes() {
        QMMKV.fromSpAdapter(BaseApplication.getContext(), SIMPLE_MODE_RES_SP_NAME, "common_mmkv_configurations").edit().putString(SIMPLE_MODE_RES_CHECK_SUC_VERSION, "").apply();
        QLog.w(TAG, 1, "resetFlagToRecheckRes");
    }

    public static boolean skinInitFinish() {
        try {
            boolean z16 = InitSkin.sInited;
            return ((Boolean) InitSkin.class.getField("sInited").get(InitSkin.class)).booleanValue();
        } catch (Exception e16) {
            QLog.e(TAG, 1, "invoke init engine error : ", e16);
            return false;
        }
    }

    private static boolean uncompressZip(Context context, String str, String str2) {
        boolean copySimpleAssetToSDCard = copySimpleAssetToSDCard(context, str2);
        if (!copySimpleAssetToSDCard) {
            QLog.d(TAG, 1, "copyAssetResult : ", Boolean.valueOf(copySimpleAssetToSDCard));
            return false;
        }
        try {
            FileUtils.uncompressZip(getSimpleZipPath(context), str, false);
            return true;
        } catch (Exception e16) {
            QLog.d(TAG, 1, "uncompressZipEntry error : ", e16);
            return false;
        }
    }

    private static synchronized void unzipResZip(Context context) {
        synchronized (SimpleUIManager.class) {
            String themeZipMd5 = getThemeZipMd5(context);
            if (themeZipMd5 == null) {
                ThemeSwitcher.startSwitch("1000", ThemeReporter.FROM_ENGINE, null);
                return;
            }
            String unzipPath = new ThemeLocator().setThemeId("1001").init(context, ThemeConstants.THEME_ID_SIMPLE_SPEC, themeZipMd5).getUnzipPath();
            sSimpleSkinRootPath = unzipPath;
            QLog.d(TAG, 1, "unzipResZip, rootPath : ", unzipPath);
            if (MobileQQ.sProcessId != 1) {
                QLog.d(TAG, 1, "only main process can unzip simple theme res");
            } else {
                checkResLegalAndUnzip(context, unzipPath, themeZipMd5);
            }
        }
    }
}
