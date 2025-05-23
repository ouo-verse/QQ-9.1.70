package com.qq.e.comm.plugin.k;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.Md5Util;
import com.qq.e.tg.splash.image.TGSplashFileUtil;
import com.tencent.hippy.qq.api.MMKVCommonFileKeys;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/* compiled from: P */
/* loaded from: classes3.dex */
public class k {
    public static File a() {
        return GDTADManager.getInstance().getAppContext().getDir(TGSplashFileUtil.ADNET, 0);
    }

    public static File b() {
        return GDTADManager.getInstance().getAppContext().getDir(Constants.TangramFiles.TANGRAM_FILES_DIR, 0);
    }

    public static File c() {
        Context applicationContext = GDTADManager.getInstance().getAppContext().getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        File externalCacheDir = applicationContext.getExternalCacheDir();
        File externalFilesDir = applicationContext.getExternalFilesDir("");
        File cacheDir = applicationContext.getCacheDir();
        if (externalCacheDir == null) {
            externalCacheDir = externalFilesDir != null ? externalFilesDir : cacheDir;
        }
        if (externalCacheDir == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(externalCacheDir);
        String str = File.separator;
        sb5.append(str);
        sb5.append("com_qq_e_download");
        sb5.append(str);
        sb5.append("wx_preload");
        File file = new File(sb5.toString());
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public static File d() {
        File file = new File(a().getAbsolutePath() + File.separator + "splash_button_url");
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public static boolean e() {
        return a(a()) >= (((long) GDTADManager.getInstance().getSM().getInteger("adnetDirMaxSize", 50)) * 1024) * 1024;
    }

    public static File f() {
        File file = new File(b().getAbsolutePath() + File.separator + "tg_pcdn");
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public static File a(String str) {
        File file = new File(a().getAbsolutePath() + File.separator + str);
        file.mkdir();
        return file;
    }

    public static long b(String str, boolean z16) {
        String str2;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(a(str).getAbsolutePath());
        if (z16) {
            str2 = File.separator + "hotStart";
        } else {
            str2 = "";
        }
        sb5.append(str2);
        sb5.append(File.separator);
        sb5.append("timeflag");
        File file = new File(sb5.toString());
        if (file.exists()) {
            return file.lastModified();
        }
        return -1L;
    }

    public static boolean e(File file) {
        File[] listFiles;
        if (file != null && file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && "index.html".equals(file2.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String d(File file) {
        FileInputStream fileInputStream;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
        }
        try {
            String str = (String) new ObjectInputStream(fileInputStream).readObject();
            try {
                fileInputStream.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            return str;
        } catch (Throwable th6) {
            th = th6;
            try {
                GDTLogger.e("CommonPluginFileUtil", th);
                if (fileInputStream == null) {
                    return null;
                }
                try {
                    fileInputStream.close();
                    return null;
                } catch (IOException e17) {
                    e17.printStackTrace();
                    return null;
                }
            } catch (Throwable th7) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e18) {
                        e18.printStackTrace();
                    }
                }
                throw th7;
            }
        }
    }

    public static File a(String str, boolean z16) {
        String str2;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(a(str).getAbsolutePath());
        if (z16) {
            str2 = File.separator + "hotStart";
        } else {
            str2 = "";
        }
        sb5.append(str2);
        File file = new File(sb5.toString());
        if (!file.exists()) {
            file.mkdir();
        }
        return new File(file.getAbsolutePath() + File.separator + "timeflag");
    }

    public static File b(String str, String str2) {
        File a16;
        File o16 = com.tencent.ams.fusion.a.b.o(3, str2);
        if ((o16 != null && o16.exists()) || (a16 = a(str, str2)) == null) {
            return o16;
        }
        return new File(a16.getAbsolutePath() + File.separator + "index.html");
    }

    public static File c(String str, boolean z16) {
        String str2;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(a(str).getAbsolutePath());
        if (z16) {
            str2 = File.separator + "hotStart";
        } else {
            str2 = "";
        }
        sb5.append(str2);
        File file = new File(sb5.toString());
        try {
            if (!file.exists()) {
                file.mkdir();
            }
            return new File(file.getAbsolutePath() + File.separator + "preload");
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    public static File a(int i3, String str, String str2) {
        File c16 = com.tencent.ams.fusion.a.b.c(i3, str2);
        if (c16 == null || !c16.exists()) {
            c16 = new File(a(str).getAbsolutePath() + File.separator + c(str2));
        }
        GDTLogger.d("fusion_Ad getSplashDownloadFile : exist:" + c16.exists() + ", " + c16.getAbsolutePath() + ", " + str2);
        return c16;
    }

    public static File b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            File c16 = com.tencent.ams.fusion.a.b.c(1, str);
            if (c16 != null && c16.exists()) {
                return c16;
            }
            return new File(d().getAbsolutePath() + File.separator + c(str, ".png"));
        } catch (Throwable th5) {
            GDTLogger.e("getSplashButtonSrcAPngPath error:", th5);
            return null;
        }
    }

    public static String c(String str) {
        return Md5Util.encode(str);
    }

    public static String c(String str, String str2) {
        return Md5Util.encode(str) + str2;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x002b -> B:15:0x0059). Please report as a decompilation issue!!! */
    public static String c(File file) {
        FileInputStream fileInputStream;
        String str = null;
        str = null;
        str = null;
        str = null;
        str = null;
        FileInputStream fileInputStream2 = null;
        str = null;
        str = null;
        if (file != null) {
            ?? exists = file.exists();
            try {
                try {
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream2 = exists;
                }
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            if (exists != 0) {
                try {
                    fileInputStream = new FileInputStream(file);
                } catch (FileNotFoundException e17) {
                    e = e17;
                    fileInputStream = null;
                } catch (IOException e18) {
                    e = e18;
                    fileInputStream = null;
                } catch (Throwable th6) {
                    th = th6;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                    }
                    throw th;
                }
                try {
                    byte[] bArr = new byte[fileInputStream.available()];
                    str = fileInputStream.read(bArr) != -1 ? new String(bArr, ag.f39619a) : null;
                    fileInputStream.close();
                } catch (FileNotFoundException e26) {
                    e = e26;
                    GDTLogger.e("CommonPluginFileUtil", e);
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return str;
                } catch (IOException e27) {
                    e = e27;
                    GDTLogger.e("CommonPluginFileUtil", e);
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return str;
                }
            }
        }
        return str;
    }

    public static File a(int i3, String str) {
        File file = new File(com.tencent.ams.fusion.a.b.b(i3), c(str));
        GDTLogger.d("fusion_Ad getSplashDownloadFile : exist:" + file.exists() + ", " + file.getAbsolutePath());
        return file;
    }

    public static void b(File file) {
        if (file.isFile()) {
            file.delete();
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                b(file2);
            }
            file.delete();
        }
    }

    public static File a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        File r16 = com.tencent.ams.fusion.a.b.r(3, str2);
        if (r16 != null && r16.exists()) {
            return r16;
        }
        return new File(a(str).getAbsolutePath() + File.separator + MMKVCommonFileKeys.WEB_PREFIX + c(str2));
    }

    public static long a(File file) {
        File[] listFiles;
        long length;
        long j3 = 0;
        if (file != null) {
            try {
                if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        if (file2 != null) {
                            if (file2.isDirectory()) {
                                length = a(file2);
                            } else {
                                length = file2.length();
                            }
                            j3 += length;
                        }
                    }
                }
            } catch (Throwable th5) {
                GDTLogger.e(th5.getMessage());
            }
        }
        return j3;
    }

    public static void a(File file, String str) {
        if (file == null || TextUtils.isEmpty(str)) {
            return;
        }
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(str.getBytes(ag.f39619a));
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                    } catch (FileNotFoundException e16) {
                        e = e16;
                        fileOutputStream = fileOutputStream2;
                        GDTLogger.e("CommonPluginFileUtil", e);
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (IOException e17) {
                        e = e17;
                        fileOutputStream = fileOutputStream2;
                        GDTLogger.e("CommonPluginFileUtil", e);
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = fileOutputStream2;
                        GDTLogger.e("CommonPluginFileUtil", th);
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                    }
                } catch (FileNotFoundException e18) {
                    e = e18;
                } catch (IOException e19) {
                    e = e19;
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (IOException e26) {
                e26.printStackTrace();
            }
        } catch (Throwable th7) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e27) {
                    e27.printStackTrace();
                }
            }
            throw th7;
        }
    }
}
