package com.tencent.smtt.utils;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.smtt.sdk.QbSdk;
import cooperation.qzone.patch.QZonePatchService;
import java.io.File;
import java.io.FileFilter;

/* compiled from: P */
/* loaded from: classes25.dex */
public class o {
    public static boolean a(Context context) {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            return b(context);
        }
        return true;
    }

    public static boolean b(Context context) {
        File c16;
        try {
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        if (Build.VERSION.SDK_INT > 25 || (c16 = c(context)) == null) {
            return true;
        }
        for (File file : c16.listFiles(new FileFilter() { // from class: com.tencent.smtt.utils.o.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                String name = file2.getName();
                if (!TextUtils.isEmpty(name) && name.endsWith(QZonePatchService.PATCH_SUFFIX_DEX)) {
                    return true;
                }
                return false;
            }
        })) {
            if (file.isFile() && file.exists()) {
                if (a(file)) {
                    TbsLog.w("TbsCheckUtils", "" + file + " is invalid --> check failed!");
                    file.delete();
                    return false;
                }
                TbsLog.i("TbsCheckUtils", "" + file + " #4 check success!");
            }
        }
        TbsLog.i("TbsCheckUtils", "checkTbsValidity -->#5 check ok!");
        return true;
    }

    private static File c(Context context) {
        File file = new File(QbSdk.getTbsFolderDir(context), "core_share");
        if (file.isDirectory() && file.exists()) {
            return file;
        }
        return null;
    }

    private static boolean a(File file) {
        try {
            return !e.b(file);
        } catch (Throwable th5) {
            Log.e("TbsCheckUtils", "isOatFileBroken exception: " + th5);
            return false;
        }
    }
}
