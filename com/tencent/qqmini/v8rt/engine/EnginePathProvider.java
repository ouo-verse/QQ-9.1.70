package com.tencent.qqmini.v8rt.engine;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import java.io.File;

/* loaded from: classes23.dex */
public class EnginePathProvider {
    public static final String ENGINE_DIR = "engine";
    public static final String ENGINE_JS_DIR = "js";
    public static final String LOG_TAG = "EnginePathProvider";
    public static final String ROOT_DIR = "tv8rt";
    public static final String TIMESTAMP = ".timestamp";
    Context ctx;
    private File jsDir;
    private File rootDir;

    public EnginePathProvider(Context context) {
        this.ctx = context;
    }

    private static boolean copyAssetsDir(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                AssetManager assets = context.getAssets();
                String[] strArr = {"console.js", "timer.js"};
                File file = new File(str2);
                if (!file.exists()) {
                    file.mkdir();
                }
                for (int i3 = 0; i3 < 2; i3++) {
                    String str3 = strArr[i3];
                    if (!TextUtils.isEmpty(str3)) {
                        File file2 = new File(str2, str3);
                        if (!file2.exists()) {
                            file2.getParentFile().mkdirs();
                        }
                        String str4 = str + File.separator + str3;
                        String absolutePath = file2.getAbsolutePath();
                        if (!AssetUtil.copyAssetToFile(assets, str4, absolutePath)) {
                            Logger.e(LOG_TAG, String.format("copyAssetToFile from=%s, to=%s fail", str4, absolutePath));
                            return false;
                        }
                    }
                }
                return true;
            } catch (Throwable th5) {
                Logger.e(LOG_TAG, String.format("copyFileOrDir assetsPath=%s, destPath=%s, exception", str, str2), th5);
                try {
                    File file3 = new File(str2);
                    if (file3.exists()) {
                        FileUtil.deleteFile(file3);
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return false;
    }

    public void copyEngineAssets(String str, boolean z16) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(getEngineJSDir(), TIMESTAMP);
            if (file.exists() && !z16) {
                Logger.i(LOG_TAG, "skip copy engine assets");
                return;
            }
            if (copyAssetsDir(this.ctx, str, getEngineJSDir())) {
                if (file.exists()) {
                    file.delete();
                }
                try {
                    file.createNewFile();
                    return;
                } catch (Exception unused) {
                    Logger.e(LOG_TAG, "create timestamp failed");
                    return;
                }
            }
            Logger.e(LOG_TAG, "copyEngineAssets failed");
            return;
        }
        Logger.e(LOG_TAG, "assetPath is empty");
    }

    public String getEngineJSDir() {
        if (this.rootDir == null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(this.ctx.getFilesDir().getPath());
            String str = File.separator;
            sb5.append(str);
            sb5.append("tv8rt");
            sb5.append(str);
            sb5.append(ENGINE_DIR);
            this.rootDir = new File(sb5.toString());
            File file = new File(this.rootDir, ENGINE_JS_DIR);
            this.jsDir = file;
            if (!file.exists() && !this.jsDir.mkdirs()) {
                Logger.e(LOG_TAG, "create dir failed " + this.jsDir.getAbsolutePath());
            }
        }
        return this.jsDir.getAbsolutePath();
    }
}
