package com.qq.e.comm.plugin.k;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import com.qq.e.tg.splash.image.TGSplashFileUtil;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import cooperation.qzone.report.QZonePushReporter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ai {
    public static long a(File file) {
        File[] listFiles;
        long length;
        long j3 = 0;
        if (file != null && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    length = a(file2);
                } else {
                    length = file2.length();
                }
                j3 += length;
            }
        }
        return j3;
    }

    public static void b(File file) {
        File[] listFiles;
        if (file == null || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return;
        }
        for (File file2 : listFiles) {
            if (file2 != null) {
                if (file2.isDirectory()) {
                    b(file2);
                } else {
                    file2.delete();
                }
            }
        }
        file.delete();
    }

    public static String c(File file) {
        if (file != null && file.exists()) {
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                fileInputStream.close();
                return new String(bArr, ag.f39619a);
            } catch (FileNotFoundException e16) {
                GDTLogger.e("plugin file not found " + e16);
            } catch (IOException e17) {
                GDTLogger.e("plugin file error " + e17);
            }
        }
        return null;
    }

    public static File d() {
        File j3 = j();
        File externalFilesDir = (((PublicApi.DownloadManagerApi) PublicApiHelper.getModuleApi(PublicApi.DownloadManagerApi.class)).isSetMediaCustomDownloader() && com.qq.e.comm.plugin.j.c.a("support_custom_downloader", 1, 1)) ? GDTADManager.getInstance().getAppContext().getApplicationContext().getExternalFilesDir("") : null;
        return externalFilesDir != null ? externalFilesDir : j3 != null ? j3 : GDTADManager.getInstance().getAppContext().getApplicationContext().getCacheDir();
    }

    public static File e() {
        File d16 = d();
        if (d16 == null) {
            return null;
        }
        File file = new File(d16, "com_qq_e_download");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File f() {
        File j3 = j();
        File cacheDir = GDTADManager.getInstance().getAppContext().getApplicationContext().getCacheDir();
        if (j3 == null) {
            j3 = cacheDir;
        }
        if (j3 == null) {
            return null;
        }
        File file = new File(j3, "com_qq_e_download");
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, "rewardVideo");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    public static File g() {
        File e16 = e();
        if (e16 == null) {
            return null;
        }
        File file = new File(e16, "video");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public static File h() {
        File a16 = a();
        if (a16 == null) {
            return null;
        }
        return new File(a16.getAbsolutePath() + File.separator + QZonePushReporter.EVENT_CODE_TYPE2_PUSH_EXPOSURE);
    }

    public static int i() {
        Context appContext = GDTADManager.getInstance().getAppContext();
        int i3 = 0;
        if (appContext == null) {
            return 0;
        }
        try {
            if (appContext.checkSelfPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0) {
                i3 = 1;
            }
            if (appContext.checkSelfPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0) {
                return i3 | 2;
            }
            return i3;
        } catch (Throwable th5) {
            GDTLogger.e("getSDCardStoragePermission + ", th5);
            return i3;
        }
    }

    private static File j() {
        try {
            return GDTADManager.getInstance().getAppContext().getApplicationContext().getExternalCacheDir();
        } catch (Throwable th5) {
            GDTLogger.e("PluginFileUtil getExternalCacheDir error", th5);
            return null;
        }
    }

    private static void d(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        try {
            file.setLastModified(System.currentTimeMillis());
        } catch (Throwable th5) {
            GDTLogger.e("setLastModified failed :", th5);
        }
    }

    public static void a(File file, String str) {
        if (file == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(str.getBytes(ag.f39619a));
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e16) {
            GDTLogger.e("plugin file not found " + e16);
        } catch (IOException e17) {
            GDTLogger.e("plugin file error " + e17);
        }
    }

    public static boolean b() {
        return a(a()) >= (((long) GDTADManager.getInstance().getSM().getInteger("adnetDirMaxSize", 50)) * 1024) * 1024;
    }

    public static File c() {
        File file = new File(GDTADManager.getInstance().getAppContext().getDir("firstplay", 0).getAbsolutePath());
        file.mkdirs();
        return file;
    }

    public static File b(String str) {
        File g16 = g();
        if (g16 == null || TextUtils.isEmpty(str)) {
            return null;
        }
        String a16 = a(str);
        if (TextUtils.isEmpty(a16)) {
            return null;
        }
        File file = new File(g16, a16);
        d(file);
        return file;
    }

    public static List<File> c(String str) {
        List<File> a16 = a(str, new ArrayList());
        if (a16 != null) {
            try {
                if (a16.size() > 0) {
                    Collections.sort(a16, new Comparator<File>() { // from class: com.qq.e.comm.plugin.k.ai.1
                        @Override // java.util.Comparator
                        /* renamed from: a, reason: merged with bridge method [inline-methods] */
                        public int compare(File file, File file2) {
                            if (file == null || file2 == null) {
                                return 0;
                            }
                            if (file.lastModified() < file2.lastModified()) {
                                return 1;
                            }
                            if (file.lastModified() == file2.lastModified()) {
                                return 0;
                            }
                            return -1;
                        }
                    });
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return a16;
    }

    public static String a(String str) {
        return Md5Util.encode(str);
    }

    public static File a() {
        return GDTADManager.getInstance().getAppContext().getDir(TGSplashFileUtil.ADNET, 0);
    }

    public static List<File> a(String str, List<File> list) {
        File[] listFiles;
        File file = new File(str);
        if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length != 0) {
            for (File file2 : listFiles) {
                if (file2 != null) {
                    if (file2.isDirectory()) {
                        a(file2.getAbsolutePath(), list);
                    } else if (!list.contains(file2)) {
                        list.add(file2);
                    }
                }
            }
        }
        return list;
    }
}
