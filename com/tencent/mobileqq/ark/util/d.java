package com.tencent.mobileqq.ark.util;

import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.open.appmanage.LocalAppManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileFilter;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes11.dex */
public class d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements FileFilter {
        a() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            if (!file.getName().startsWith("hc_") && !file.getName().startsWith(".hc_")) {
                return false;
            }
            return true;
        }
    }

    public static void a() {
        String resDirectory = ArkEnvironmentManager.getInstance().getResDirectory();
        String[] list = new File(resDirectory).list();
        if (list != null && list.length > 0) {
            for (String str : list) {
                File file = new File(resDirectory + "/" + str);
                if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles != null) {
                        QLog.i("ArkApp.ArkLocalCacheUtil", 1, String.format(Locale.CHINA, "cleanAppRes, count=%d, path=%s", Integer.valueOf(listFiles.length), file.getAbsolutePath()));
                        for (File file2 : listFiles) {
                            file2.delete();
                        }
                    }
                } else {
                    file.delete();
                }
            }
        }
    }

    public static void b() {
        new File(ArkEnvironmentManager.getInstance().getStorageDirectory() + "/storage.db").delete();
    }

    public static void c() {
        QLog.i("ArkApp.ArkLocalCacheUtil", 1, "cleanArkAppCache");
        d();
        a();
        LocalAppManager.deleteAllLocalApps();
    }

    public static void d() {
        File file = new File(ArkEnvironmentManager.getInstance().getCacheDirectory());
        File[] listFiles = file.listFiles(new a());
        if (listFiles != null) {
            QLog.i("ArkApp.ArkLocalCacheUtil", 1, String.format(Locale.CHINA, "cleanWebCache, count=%d, path=%s", Integer.valueOf(listFiles.length), file.getAbsolutePath()));
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
    }
}
