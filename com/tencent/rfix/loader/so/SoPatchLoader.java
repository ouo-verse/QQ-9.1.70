package com.tencent.rfix.loader.so;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
import java.util.List;

/* loaded from: classes25.dex */
public class SoPatchLoader {
    private static final String TAG = "SoPatchLoader";

    private boolean abiIsNotEqual(SoConfig soConfig) {
        String substring = soConfig.oldSo.substring(soConfig.oldSo.indexOf("/") + 1, soConfig.oldSo.lastIndexOf("/"));
        if (!TextUtils.equals(substring, Build.CPU_ABI) && !TextUtils.equals(substring, Build.CPU_ABI2)) {
            return true;
        }
        return false;
    }

    private boolean inject(File file, List<SoConfig> list) throws Throwable {
        String str = null;
        for (SoConfig soConfig : list) {
            if (abiIsNotEqual(soConfig)) {
                Log.i(TAG, "abi not equal");
            } else {
                File parentFile = new File(file, soConfig.oldSo).getParentFile();
                if (parentFile == null) {
                    Log.e(TAG, "folder == null");
                } else {
                    String absolutePath = parentFile.getAbsolutePath();
                    if (!TextUtils.equals(absolutePath, str)) {
                        long currentTimeMillis = System.currentTimeMillis();
                        ClassLoader classLoader = getClass().getClassLoader();
                        Log.i(TAG, "before " + classLoader.toString());
                        RFixLoadLibrary.installNativeLibraryPath(classLoader, parentFile);
                        Log.i(TAG, "after " + classLoader.toString() + ", cost time = " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
                        str = absolutePath;
                    }
                }
            }
        }
        return true;
    }

    public boolean load(File file) {
        try {
            List<SoConfig> parseSoMeta = SoConfigParser.parseSoMeta(new File(file, SoConfigParser.SO_META_TXT));
            Log.i(TAG, "soConfigList size " + parseSoMeta.size());
            return inject(file, parseSoMeta);
        } catch (Throwable th5) {
            Log.e(TAG, "load: ", th5);
            return false;
        }
    }
}
