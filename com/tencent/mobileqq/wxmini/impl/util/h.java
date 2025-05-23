package com.tencent.mobileqq.wxmini.impl.util;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.mobileqq.utils.FileUtils;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes35.dex */
public class h {
    private static void b(File file) {
        if (file != null && file.exists() && file.isDirectory()) {
            String format = new SimpleDateFormat(DateUtil.DATE_FORMAT_8, Locale.US).format(new Date());
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return;
            }
            for (File file2 : listFiles) {
                String name = file2.getName();
                if (!TextUtils.isEmpty(name) && !name.contains(format) && !name.contains("mmap")) {
                    FileUtils.deleteFile(file2);
                }
            }
        }
    }

    public static void a(Context context) {
        File[] listFiles;
        if (context == null) {
            return;
        }
        File filesDir = context.getFilesDir();
        if (filesDir != null) {
            FileUtils.deleteDirectory(filesDir.getAbsolutePath() + "/public/wxaapp");
        }
        if ("mounted".equals(Environment.getExternalStorageState())) {
            File externalCacheDir = context.getExternalCacheDir();
            if (externalCacheDir != null) {
                String absolutePath = externalCacheDir.getAbsolutePath();
                FileUtils.deleteDirectory(absolutePath + "/wxacache");
                FileUtils.deleteDirectory(absolutePath + "/wxafiles");
            }
            File externalFilesDir = context.getExternalFilesDir("/wxa");
            if (externalFilesDir != null && externalFilesDir.isDirectory() && (listFiles = externalFilesDir.listFiles()) != null) {
                for (File file : listFiles) {
                    if ("xlog".equals(file.getName())) {
                        b(file);
                    } else {
                        FileUtils.deleteFile(file);
                    }
                }
            }
        }
        hb3.f.h().f();
    }
}
