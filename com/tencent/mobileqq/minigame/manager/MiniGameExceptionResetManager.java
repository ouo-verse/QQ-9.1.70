package com.tencent.mobileqq.minigame.manager;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.api.IMiniGameConfig;
import com.tencent.mobileqq.mini.apkg.ApkgManager;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.FileUtils;
import com.tencent.mobileqq.mini.util.DateUtils;
import com.tencent.mobileqq.mini.utils.MiniGameMMKVUtils;
import com.tencent.mobileqq.minigame.report.MiniGamePkgExceptionReport;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u0012H\u0002J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u0012H\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\u0018\u0010 \u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010#\u001a\u00020\u001eH\u0002J\u0012\u0010$\u001a\u0004\u0018\u00010\"2\u0006\u0010!\u001a\u00020\u0004H\u0002J\u0010\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020\u0004H\u0002J\b\u0010'\u001a\u00020\u001eH\u0002J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*H\u0002J \u0010+\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020.H\u0002J\u000e\u0010/\u001a\u00020\u001e2\u0006\u00100\u001a\u00020\u0004J\u0018\u00101\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0004H\u0002J \u00103\u001a\u00020\u001e2\u0006\u0010\u001a\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u00042\u0006\u00104\u001a\u00020\u0004H\u0002J\b\u00105\u001a\u00020\u001eH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R*\u0010\u0010\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00120\u0011j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0012`\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\u0018\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0011j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004`\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/minigame/manager/MiniGameExceptionResetManager;", "", "()V", "EXCEPTION_PCK_PATH", "", "EXCEPTION_ZIPFILE_ALIVE_TIME", "", "KEY_APPID", "KEY_CRASH_COUNT", "KEY_EXCEPTION_FILE_PATH", "KEY_UPDATA_TIME", "KEY_ZIP_CREATE_TIME", "LIMIT_EXCEPTION_COUNT", "MMKV_KEY_EXCEPTION_INFO", "SUFFIX_LOG", "TAG", "exceptionInfoMap", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/minigame/manager/MiniGamePkgExceptionInfo;", "Lkotlin/collections/HashMap;", "fileLock", "Ljava/lang/Object;", "isSwitchEnable", "", "zipFilePathMap", "checkAndResetMiniGamePkgExceptionInfo", "info", "checkHandleCondition", "exceptionInfo", "checkZipFile", "", "clearExceptionPkgFolder", "doExceptionPkgLogic", "miniAppInfo", "Lcom/tencent/mobileqq/mini/apkg/MiniAppInfo;", "getAndCheckExceptionInfo", "getMiniAppInfo", "getPackageException", "appId", "init", "parseMiniGamePkgExceptionInfo", "dataJson", "Lorg/json/JSONObject;", "realExceptionResetLogic", "zipFileName", "packageFile", "Ljava/io/File;", "recordPackageException", "appInfo", "reportMiniGamePackageException", "zipFilePath", "saveExceptionGamePackageByZip", "packagePath", "saveMiniGamePkgExceptionInfo", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniGameExceptionResetManager {
    private static String EXCEPTION_PCK_PATH = null;
    private static final int EXCEPTION_ZIPFILE_ALIVE_TIME = 864000000;
    public static final MiniGameExceptionResetManager INSTANCE;
    private static final String KEY_APPID = "appId";
    private static final String KEY_CRASH_COUNT = "crashCount";
    private static final String KEY_EXCEPTION_FILE_PATH = "exceptionFilePath";
    private static final String KEY_UPDATA_TIME = "lastExceptionTime";
    private static final String KEY_ZIP_CREATE_TIME = "zipCreateTime";
    private static final int LIMIT_EXCEPTION_COUNT = 5;
    private static final String MMKV_KEY_EXCEPTION_INFO = "exception_info";
    private static final String SUFFIX_LOG = ".log";
    private static final String TAG = "MiniGameExceptionPackageManager";
    private static final HashMap<String, MiniGamePkgExceptionInfo> exceptionInfoMap;
    private static final Object fileLock;
    private static final boolean isSwitchEnable;
    private static final HashMap<String, String> zipFilePathMap;

    static {
        MiniGameExceptionResetManager miniGameExceptionResetManager = new MiniGameExceptionResetManager();
        INSTANCE = miniGameExceptionResetManager;
        isSwitchEnable = ((IMiniGameConfig) QRoute.api(IMiniGameConfig.class)).isMiniGamePackageExceptionSwitchEnable();
        EXCEPTION_PCK_PATH = ApkgManager.PATH_GAMEPKG_ROOT + "/exception";
        exceptionInfoMap = new HashMap<>();
        zipFilePathMap = new HashMap<>();
        fileLock = new Object();
        miniGameExceptionResetManager.init();
    }

    MiniGameExceptionResetManager() {
    }

    private final boolean checkAndResetMiniGamePkgExceptionInfo(MiniGamePkgExceptionInfo info) {
        if (info.getAppId().length() == 0) {
            return false;
        }
        if (!DateUtils.INSTANCE.isToday(info.getUpdateTime())) {
            info.setCrashCount(0);
        }
        if (info.getZipCreateTime() > 0 && System.currentTimeMillis() - info.getZipCreateTime() > 864000000) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 4, "check zipCreateTime:" + info.getZipCreateTime() + " false,");
            }
            return false;
        }
        if (!(info.getExceptionFilePath().length() > 0) || new File(info.getExceptionFilePath()).exists()) {
            return true;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "check path:" + info.getExceptionFilePath() + ", no exists");
        }
        info.setExceptionFilePath("");
        return false;
    }

    private final boolean checkHandleCondition(MiniGamePkgExceptionInfo exceptionInfo) {
        return exceptionInfo.getCrashCount() >= 5 && !DateUtils.INSTANCE.isToday(exceptionInfo.getZipCreateTime());
    }

    private final void checkZipFile() {
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.minigame.manager.r
            @Override // java.lang.Runnable
            public final void run() {
                MiniGameExceptionResetManager.checkZipFile$lambda$14();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkZipFile$lambda$14() {
        File[] listFiles;
        synchronized (fileLock) {
            File file = new File(EXCEPTION_PCK_PATH);
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                Intrinsics.checkNotNullExpressionValue(listFiles, "listFiles()");
                for (File file2 : listFiles) {
                    if (!zipFilePathMap.containsKey(file2.getPath())) {
                        QLog.i(TAG, 1, "delete file,path:" + file2.getPath());
                        FileUtils.deleteFile(file2.getPath());
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void clearExceptionPkgFolder() {
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.minigame.manager.t
            @Override // java.lang.Runnable
            public final void run() {
                MiniGameExceptionResetManager.clearExceptionPkgFolder$lambda$11();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void clearExceptionPkgFolder$lambda$11() {
        synchronized (fileLock) {
            File file = new File(EXCEPTION_PCK_PATH);
            if (file.exists() && file.isDirectory()) {
                FileUtils.deleteDirectory(EXCEPTION_PCK_PATH);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    private final synchronized void doExceptionPkgLogic(final MiniGamePkgExceptionInfo exceptionInfo, MiniAppInfo miniAppInfo) {
        MiniGameExceptionResetManager miniGameExceptionResetManager = INSTANCE;
        if (miniGameExceptionResetManager.checkHandleCondition(exceptionInfo)) {
            QLog.i(TAG, 1, "start do Exception Pkg Logic");
            final File file = new File(ApkgManager.getApkgFolderPath(miniAppInfo));
            final String str = file.getName() + SUFFIX_LOG;
            File file2 = new File(exceptionInfo.getExceptionFilePath());
            if (file2.exists() && Intrinsics.areEqual(file2.getName(), str)) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 1, "exceptionFilePath exits");
                }
            } else if (file.exists() && file.isDirectory()) {
                ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.minigame.manager.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        MiniGameExceptionResetManager.doExceptionPkgLogic$lambda$4$lambda$3(MiniGamePkgExceptionInfo.this, str, file);
                    }
                });
            } else {
                QLog.i(TAG, 1, "packageFile no exits");
                miniGameExceptionResetManager.saveMiniGamePkgExceptionInfo();
            }
        } else {
            exceptionInfoMap.put(exceptionInfo.getAppId(), exceptionInfo);
            miniGameExceptionResetManager.saveMiniGamePkgExceptionInfo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void doExceptionPkgLogic$lambda$4$lambda$3(MiniGamePkgExceptionInfo exceptionInfo, String zipFileName, File packageFile) {
        Intrinsics.checkNotNullParameter(exceptionInfo, "$exceptionInfo");
        Intrinsics.checkNotNullParameter(zipFileName, "$zipFileName");
        Intrinsics.checkNotNullParameter(packageFile, "$packageFile");
        INSTANCE.realExceptionResetLogic(exceptionInfo, zipFileName, packageFile);
    }

    private final void getAndCheckExceptionInfo() {
        String string = MiniGameMMKVUtils.INSTANCE.getString(MMKV_KEY_EXCEPTION_INFO);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "-->getAndCheckExceptionInfo,exceptionInfo:" + string);
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                Intrinsics.checkNotNullExpressionValue(jSONObject, "infoJsonArray.getJSONObject(index)");
                MiniGamePkgExceptionInfo parseMiniGamePkgExceptionInfo = parseMiniGamePkgExceptionInfo(jSONObject);
                if (checkAndResetMiniGamePkgExceptionInfo(parseMiniGamePkgExceptionInfo)) {
                    exceptionInfoMap.put(parseMiniGamePkgExceptionInfo.getAppId(), parseMiniGamePkgExceptionInfo);
                    if (parseMiniGamePkgExceptionInfo.getExceptionFilePath().length() > 0) {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 4, "zipFilePathMap key:" + parseMiniGamePkgExceptionInfo.getExceptionFilePath() + ",vlaue:" + parseMiniGamePkgExceptionInfo.getAppId());
                        }
                        zipFilePathMap.put(parseMiniGamePkgExceptionInfo.getExceptionFilePath(), parseMiniGamePkgExceptionInfo.getAppId());
                    }
                }
            }
        } catch (JSONException e16) {
            QLog.e(TAG, 1, "-->getAndCheckExceptionInfo,err", e16);
        }
    }

    private final MiniAppInfo getMiniAppInfo(String miniAppInfo) {
        List split$default;
        if (!(miniAppInfo.length() > 0)) {
            return null;
        }
        try {
            split$default = StringsKt__StringsKt.split$default((CharSequence) miniAppInfo, new String[]{"|"}, false, 0, 6, (Object) null);
            if (split$default.size() < 5) {
                return null;
            }
            MiniAppInfo miniAppInfo2 = new MiniAppInfo();
            miniAppInfo2.appId = (String) split$default.get(0);
            miniAppInfo2.name = (String) split$default.get(1);
            miniAppInfo2.versionId = (String) split$default.get(2);
            miniAppInfo2.verType = Integer.parseInt((String) split$default.get(3));
            miniAppInfo2.engineType = Integer.parseInt((String) split$default.get(4));
            return miniAppInfo2;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "parse miniAppInfo err", th5);
            return null;
        }
    }

    private final MiniGamePkgExceptionInfo getPackageException(String appId) {
        MiniGamePkgExceptionInfo miniGamePkgExceptionInfo = exceptionInfoMap.get(appId);
        if (miniGamePkgExceptionInfo == null) {
            miniGamePkgExceptionInfo = new MiniGamePkgExceptionInfo(appId, 0, 0L, null, 0L, 30, null);
        }
        miniGamePkgExceptionInfo.setCrashCount(miniGamePkgExceptionInfo.getCrashCount() + 1);
        miniGamePkgExceptionInfo.setUpdateTime(System.currentTimeMillis());
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "->getPackageException{" + appId + "," + miniGamePkgExceptionInfo.getCrashCount() + "," + miniGamePkgExceptionInfo.getUpdateTime() + "}");
        }
        return miniGamePkgExceptionInfo;
    }

    private final void init() {
        if (isSwitchEnable) {
            getAndCheckExceptionInfo();
            saveMiniGamePkgExceptionInfo();
            checkZipFile();
            return;
        }
        clearExceptionPkgFolder();
    }

    private final MiniGamePkgExceptionInfo parseMiniGamePkgExceptionInfo(JSONObject dataJson) {
        String appId = dataJson.optString("appId");
        int optInt = dataJson.optInt(KEY_CRASH_COUNT);
        long optLong = dataJson.optLong(KEY_UPDATA_TIME);
        String exceptionFilePath = dataJson.optString(KEY_EXCEPTION_FILE_PATH);
        long optLong2 = dataJson.optLong(KEY_ZIP_CREATE_TIME);
        Intrinsics.checkNotNullExpressionValue(appId, "appId");
        Intrinsics.checkNotNullExpressionValue(exceptionFilePath, "exceptionFilePath");
        return new MiniGamePkgExceptionInfo(appId, optInt, optLong, exceptionFilePath, optLong2);
    }

    private final void realExceptionResetLogic(MiniGamePkgExceptionInfo exceptionInfo, String zipFileName, File packageFile) {
        synchronized (fileLock) {
            try {
                QLog.i(TAG, 1, "start real Exception Pkg Logic!");
                MiniGameExceptionResetManager miniGameExceptionResetManager = INSTANCE;
                String path = packageFile.getPath();
                Intrinsics.checkNotNullExpressionValue(path, "packageFile.path");
                miniGameExceptionResetManager.saveExceptionGamePackageByZip(exceptionInfo, zipFileName, path);
                miniGameExceptionResetManager.saveMiniGamePkgExceptionInfo();
                FileUtils.deleteDirectory(packageFile.getPath());
            } catch (Exception e16) {
                QLog.e(TAG, 1, "zip minigame pkg err", e16);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    private final void reportMiniGamePackageException(String zipFilePath, String appId) {
        MiniGamePkgExceptionReport.reportEvent(zipFilePath, appId);
    }

    private final void saveExceptionGamePackageByZip(MiniGamePkgExceptionInfo info, String zipFileName, String packagePath) {
        QLog.i(TAG, 1, "saveExceptionGamePackageByZip zipFileName:" + zipFileName);
        synchronized (fileLock) {
            File file = new File(EXCEPTION_PCK_PATH);
            if (!file.exists()) {
                file.mkdir();
            }
            File file2 = new File(info.getExceptionFilePath());
            if (file2.exists() && !Intrinsics.areEqual(file2.getName(), zipFileName)) {
                FileUtils.deleteDirectory(file2.getPath());
            } else if (file2.exists() && !Intrinsics.areEqual(file2.getName(), zipFileName)) {
                QLog.d(TAG, 1, "ExceptionFile exit!");
                return;
            }
            File file3 = new File(file, zipFileName);
            QLog.i(TAG, 1, "start create zip file " + file3.getPath());
            com.tencent.open.base.l.d(packagePath, file3.getPath());
            String path = file3.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "zipFile.path");
            info.setExceptionFilePath(path);
            info.setZipCreateTime(System.currentTimeMillis());
            exceptionInfoMap.put(info.getAppId(), info);
            HashMap<String, String> hashMap = zipFilePathMap;
            String path2 = file3.getPath();
            Intrinsics.checkNotNullExpressionValue(path2, "zipFile.path");
            hashMap.put(path2, info.getAppId());
            INSTANCE.reportMiniGamePackageException(zipFileName, info.getAppId());
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void saveMiniGamePkgExceptionInfo() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 4, "-->saveMiniGamePkgExceptionInfo");
        }
        HashMap<String, MiniGamePkgExceptionInfo> hashMap = exceptionInfoMap;
        if (hashMap.isEmpty()) {
            MiniGameMMKVUtils.INSTANCE.saveString(MMKV_KEY_EXCEPTION_INFO, "");
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry<String, MiniGamePkgExceptionInfo> entry : hashMap.entrySet()) {
            JSONObject jSONObject = new JSONObject();
            MiniGamePkgExceptionInfo value = entry.getValue();
            jSONObject.put("appId", value.getAppId());
            jSONObject.put(KEY_CRASH_COUNT, value.getCrashCount());
            jSONObject.put(KEY_UPDATA_TIME, value.getUpdateTime());
            jSONObject.put(KEY_EXCEPTION_FILE_PATH, value.getExceptionFilePath());
            jSONObject.put(KEY_ZIP_CREATE_TIME, value.getZipCreateTime());
            jSONArray.mo162put(jSONObject);
        }
        MiniGameMMKVUtils miniGameMMKVUtils = MiniGameMMKVUtils.INSTANCE;
        String jSONArray2 = jSONArray.toString();
        Intrinsics.checkNotNullExpressionValue(jSONArray2, "jsonArray.toString()");
        miniGameMMKVUtils.saveString(MMKV_KEY_EXCEPTION_INFO, jSONArray2);
    }

    public final void recordPackageException(String appInfo) {
        MiniAppInfo miniAppInfo;
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "start recordPackageException,appid:" + appInfo);
        }
        if (!isSwitchEnable || (miniAppInfo = getMiniAppInfo(appInfo)) == null) {
            return;
        }
        String str = miniAppInfo.appId;
        Intrinsics.checkNotNullExpressionValue(str, "it.appId");
        if (str.length() > 0) {
            MiniGameExceptionResetManager miniGameExceptionResetManager = INSTANCE;
            String str2 = miniAppInfo.appId;
            Intrinsics.checkNotNullExpressionValue(str2, "it.appId");
            miniGameExceptionResetManager.doExceptionPkgLogic(miniGameExceptionResetManager.getPackageException(str2), miniAppInfo);
        }
    }
}
