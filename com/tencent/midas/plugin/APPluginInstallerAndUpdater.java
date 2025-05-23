package com.tencent.midas.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.midas.comm.APLog;
import cooperation.qzone.patch.QZonePatchService;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* loaded from: classes9.dex */
public class APPluginInstallerAndUpdater {
    private static final int BUFFER_LENGTH = 8192;
    private static final int INSTALL_ERR_LOSTZIPFILE = -2;
    private static final int INSTALL_ERR_MD5CHECKFAIL = -3;
    static final int INSTALL_ERR_SYSTEM = -1;
    static final int INSTALL_FROM_ASSETS = 1;
    static final int INSTALL_FROM_LOCAL = 2;
    private static final int INSTALL_SUCC = 0;
    private static final String TAG = "APPluginInstallerAndUpdater";
    static Map<String, File> sInstallPathMap = new ConcurrentHashMap();
    static Map<String, PackageInfo> sPackageInfoMap = new ConcurrentHashMap();

    public static File getInstallPath(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = sInstallPathMap.get(str);
        if (file == null) {
            File pluginPath = APPluginConfig.getPluginPath(context);
            if (pluginPath == null) {
                return null;
            }
            for (File file2 : pluginPath.listFiles()) {
                if (file2.getName().startsWith(str)) {
                    sInstallPathMap.put(str, file2);
                    return file2;
                }
            }
        }
        return file;
    }

    public static String getInstallPathString(Context context, String str) {
        try {
            File installPath = getInstallPath(context, str);
            if (installPath == null) {
                return "";
            }
            return installPath.getCanonicalPath();
        } catch (IOException e16) {
            e16.printStackTrace();
            return "";
        }
    }

    private static int installFromAssets(Context context) {
        APPluginUtils.copyEmtpyResAPKFromAssets(context);
        if (TextUtils.isEmpty("MidasPay.zip")) {
            return -2;
        }
        InputStream inputStream = null;
        try {
            try {
                inputStream = context.getAssets().open("MidasPay.zip");
                installFromZipStream(context, inputStream);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return 0;
                    } catch (IOException e16) {
                        e16.printStackTrace();
                        return 0;
                    }
                }
                return 0;
            } catch (IOException e17) {
                e17.printStackTrace();
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return -1;
                    } catch (IOException e18) {
                        e18.printStackTrace();
                        return -1;
                    }
                }
                return -1;
            }
        } catch (Throwable th5) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e19) {
                    e19.printStackTrace();
                }
            }
            throw th5;
        }
    }

    private static int installFromData(Context context) {
        APPluginUtils.copyEmtpyResAPKFromAssets(context);
        File dataZipFile = APPluginUtils.getDataZipFile(context);
        APLog.i("APPluginUtils", "installFromData zipFile:" + dataZipFile);
        if (dataZipFile == null) {
            return -2;
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                APLog.i("APPluginUtils", "installFromData filePath:" + dataZipFile.getCanonicalPath());
                FileInputStream fileInputStream2 = new FileInputStream(dataZipFile);
                try {
                    installFromZipStream(context, fileInputStream2);
                    try {
                        fileInputStream2.close();
                        return 0;
                    } catch (IOException e16) {
                        e16.printStackTrace();
                        return 0;
                    }
                } catch (IOException e17) {
                    e = e17;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                            return -1;
                        } catch (IOException e18) {
                            e18.printStackTrace();
                            return -1;
                        }
                    }
                    return -1;
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (IOException e26) {
            e = e26;
        }
    }

    public static int installFromLocal(Context context) {
        int i3;
        APLog.d(TAG, "Calling into installFromLocal " + Thread.currentThread().getStackTrace()[3].toString());
        APPluginUtils.deleteBKPlugin(context);
        APPluginUtils.copyDirect(context, APPluginConfig.getPluginUpdatePath(context), APPluginConfig.getPluginBackUpPath(context));
        try {
            File pluginUpdatePath = APPluginConfig.getPluginUpdatePath(context);
            i3 = installFromLocalByPath(context, pluginUpdatePath);
            APLog.d(TAG, "Calling into installFromLocal, installFromLocalByPath result state = " + i3 + " install src = " + pluginUpdatePath);
        } catch (Exception unused) {
            i3 = -1;
        }
        if (i3 != 0) {
            unInstallPlugin(context);
            i3 = installFromLocalByPath(context, APPluginConfig.getPluginBackUpPath(context));
            if (i3 != 0) {
                unInstallPlugin(context);
            }
        } else {
            APPluginUtils.deleteUpdatePlugin(context);
        }
        APLog.i("APPluginUtils", "installFromLocal state:" + i3);
        return i3;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(22:(2:10|11)|(3:142|143|(6:(2:152|153)|(1:147)|(1:149)|150|151|42))|13|(5:99|100|101|(13:105|106|107|108|109|110|111|112|113|(2:115|116)(1:118)|117|102|103)|133)|15|16|17|18|19|21|22|23|24|25|(3:26|27|(4:29|30|31|33)(1:73))|74|75|76|77|78|42|8) */
    /* JADX WARN: Can't wrap try/catch for region: R(23:10|11|(3:142|143|(6:(2:152|153)|(1:147)|(1:149)|150|151|42))|13|(5:99|100|101|(13:105|106|107|108|109|110|111|112|113|(2:115|116)(1:118)|117|102|103)|133)|15|16|17|18|19|21|22|23|24|25|(3:26|27|(4:29|30|31|33)(1:73))|74|75|76|77|78|42|8) */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x015f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0160, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0171, code lost:
    
        r12 = -1;
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x016a, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x016b, code lost:
    
        r12 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x017d, code lost:
    
        r12 = -1;
        r13 = 0;
        r8 = r4;
        r10 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0177, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0178, code lost:
    
        r12 = -1;
        r2 = r0;
        r8 = r4;
        r10 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0187, code lost:
    
        r12 = -1;
        r13 = 0;
        r10 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0193, code lost:
    
        r8 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0182, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0183, code lost:
    
        r12 = -1;
        r2 = r0;
        r10 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x018e, code lost:
    
        r8 = r17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0191, code lost:
    
        r12 = -1;
        r13 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x018b, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x018c, code lost:
    
        r12 = -1;
        r2 = r0;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x01c4 A[Catch: Exception -> 0x01be, IOException -> 0x01c0, TryCatch #12 {IOException -> 0x01c0, blocks: (B:45:0x01ba, B:38:0x01c4, B:40:0x01c9), top: B:44:0x01ba, outer: #20 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01c9 A[Catch: Exception -> 0x01be, IOException -> 0x01c0, TRY_LEAVE, TryCatch #12 {IOException -> 0x01c0, blocks: (B:45:0x01ba, B:38:0x01c4, B:40:0x01c9), top: B:44:0x01ba, outer: #20 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01d0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x01ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01a5 A[Catch: IOException -> 0x01a1, Exception -> 0x01be, TryCatch #24 {IOException -> 0x01a1, blocks: (B:72:0x019d, B:60:0x01a5, B:62:0x01aa), top: B:71:0x019d, outer: #20 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01aa A[Catch: IOException -> 0x01a1, Exception -> 0x01be, TRY_LEAVE, TryCatch #24 {IOException -> 0x01a1, blocks: (B:72:0x019d, B:60:0x01a5, B:62:0x01aa), top: B:71:0x019d, outer: #20 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[Catch: Exception -> 0x01be, SYNTHETIC, TRY_LEAVE, TryCatch #20 {Exception -> 0x01be, blocks: (B:72:0x019d, B:60:0x01a5, B:62:0x01aa, B:67:0x01b1, B:66:0x01ae, B:45:0x01ba, B:38:0x01c4, B:40:0x01c9, B:49:0x01cd, B:76:0x0155, B:81:0x0160), top: B:44:0x01ba, inners: #12, #24, #25 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x019d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int installFromLocalByPath(Context context, File file) {
        int i3;
        int i16;
        Throwable th5;
        File[] fileArr;
        int i17;
        File file2;
        String name;
        String name2;
        int i18 = -1;
        if (file == null) {
            APLog.e(TAG, "Cannot install plugin with null path!");
            return -1;
        }
        try {
            File pluginPath = APPluginConfig.getPluginPath(context);
            File[] listFiles = file.listFiles();
            int i19 = 0;
            BufferedOutputStream bufferedOutputStream = null;
            FileInputStream fileInputStream = null;
            FileOutputStream fileOutputStream = null;
            int i26 = 0;
            while (i26 < listFiles.length) {
                try {
                    file2 = listFiles[i26];
                    name = file2.getName();
                    APLog.i("APPluginUtils", "installFromLocal src fileName:" + name);
                } catch (IOException unused) {
                    i3 = i18;
                    fileArr = listFiles;
                    i17 = i19;
                } catch (Throwable th6) {
                    i3 = i18;
                    th5 = th6;
                }
                if (!name.endsWith(".apk")) {
                    try {
                    } catch (IOException unused2) {
                        i3 = i18;
                        fileArr = listFiles;
                        i17 = i19;
                        if (bufferedOutputStream != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        if (fileOutputStream == null) {
                        }
                        i26++;
                        i18 = i3;
                        i19 = i17;
                        listFiles = fileArr;
                    } catch (Throwable th7) {
                        th = th7;
                        th5 = th;
                        i3 = i18;
                        if (bufferedOutputStream != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                    }
                    if (!name.endsWith(".ini")) {
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e16) {
                                e16.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        i3 = i18;
                        fileArr = listFiles;
                        i17 = i19;
                        i26++;
                        i18 = i3;
                        i19 = i17;
                        listFiles = fileArr;
                    }
                }
                String str = name.split("\\_")[i19];
                APLog.i("APPluginUtils", "installFromLocal name:" + str);
                if (pluginPath != null) {
                    try {
                        try {
                            File[] listFiles2 = pluginPath.listFiles();
                            int i27 = i19;
                            while (i27 < listFiles2.length) {
                                try {
                                    File file3 = listFiles2[i27];
                                    try {
                                        try {
                                            name2 = file3.getName();
                                            fileArr = listFiles;
                                        } catch (IOException unused3) {
                                            fileArr = listFiles;
                                        }
                                        try {
                                            StringBuilder sb5 = new StringBuilder();
                                            BufferedOutputStream bufferedOutputStream2 = bufferedOutputStream;
                                            try {
                                                sb5.append("installFromLocal destFileName:");
                                                sb5.append(name2);
                                                APLog.i("APPluginUtils", sb5.toString());
                                                if (name2.startsWith(str)) {
                                                    file3.delete();
                                                }
                                                i27++;
                                                listFiles = fileArr;
                                                bufferedOutputStream = bufferedOutputStream2;
                                                i18 = -1;
                                            } catch (IOException unused4) {
                                                bufferedOutputStream = bufferedOutputStream2;
                                                i3 = -1;
                                                i17 = 0;
                                                if (bufferedOutputStream != null) {
                                                }
                                                if (fileInputStream != null) {
                                                }
                                                if (fileOutputStream == null) {
                                                }
                                                i26++;
                                                i18 = i3;
                                                i19 = i17;
                                                listFiles = fileArr;
                                            } catch (Throwable th8) {
                                                th5 = th8;
                                                bufferedOutputStream = bufferedOutputStream2;
                                                i3 = -1;
                                                if (bufferedOutputStream != null) {
                                                }
                                                if (fileInputStream != null) {
                                                }
                                                if (fileOutputStream != null) {
                                                }
                                            }
                                        } catch (IOException unused5) {
                                            i3 = -1;
                                            i17 = 0;
                                            if (bufferedOutputStream != null) {
                                            }
                                            if (fileInputStream != null) {
                                            }
                                            if (fileOutputStream == null) {
                                            }
                                            i26++;
                                            i18 = i3;
                                            i19 = i17;
                                            listFiles = fileArr;
                                        }
                                    } catch (Throwable th9) {
                                        th5 = th9;
                                    }
                                } catch (IOException unused6) {
                                    fileArr = listFiles;
                                    i3 = i18;
                                }
                            }
                        } catch (Throwable th10) {
                            th = th10;
                            th5 = th;
                            i3 = i18;
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (IOException e17) {
                                    e17.printStackTrace();
                                    throw th5;
                                }
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                                throw th5;
                            }
                            throw th5;
                        }
                    } catch (IOException unused7) {
                        fileArr = listFiles;
                        i3 = i18;
                        i17 = i19;
                        if (bufferedOutputStream != null) {
                            try {
                                try {
                                    bufferedOutputStream.close();
                                } catch (Exception e18) {
                                    e = e18;
                                    e.printStackTrace();
                                    APPluginUtils.installErrMsg = APPluginUtils.getFullExceptionStacktrace(e);
                                    i16 = i3;
                                    APLog.d(TAG, "installFromLocalByPath finish result = " + i16 + " install src = " + file + " About to clear pluginsTemp dir!");
                                    APPluginUtils.clearDirContent(APPluginConfig.getPluginUpdatePath(context));
                                    return i16;
                                }
                            } catch (IOException e19) {
                                e19.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (fileOutputStream == null) {
                            fileOutputStream.close();
                        }
                        i26++;
                        i18 = i3;
                        i19 = i17;
                        listFiles = fileArr;
                    }
                }
                fileArr = listFiles;
                BufferedOutputStream bufferedOutputStream3 = bufferedOutputStream;
                File file4 = new File(pluginPath.getCanonicalPath() + File.separator + name);
                StringBuilder sb6 = new StringBuilder();
                sb6.append("installFromLocal destfileName:");
                sb6.append(name);
                APLog.i("APPluginUtils", sb6.toString());
                FileOutputStream fileOutputStream2 = new FileOutputStream(file4);
                BufferedOutputStream bufferedOutputStream4 = new BufferedOutputStream(fileOutputStream2);
                FileInputStream fileInputStream2 = new FileInputStream(file2.getCanonicalPath());
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    i3 = -1;
                    if (read == -1) {
                        break;
                    }
                    i17 = 0;
                    try {
                        bufferedOutputStream4.write(bArr, 0, read);
                    } catch (IOException unused8) {
                        bufferedOutputStream = bufferedOutputStream4;
                        fileOutputStream = fileOutputStream2;
                        fileInputStream = fileInputStream2;
                        if (bufferedOutputStream != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        if (fileOutputStream == null) {
                        }
                        i26++;
                        i18 = i3;
                        i19 = i17;
                        listFiles = fileArr;
                    } catch (Throwable th11) {
                        th = th11;
                        th5 = th;
                        bufferedOutputStream = bufferedOutputStream4;
                        fileOutputStream = fileOutputStream2;
                        fileInputStream = fileInputStream2;
                        if (bufferedOutputStream != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        if (fileOutputStream != null) {
                        }
                    }
                }
                i17 = 0;
                bufferedOutputStream4.flush();
                bufferedOutputStream4.close();
                fileInputStream2.close();
                fileOutputStream2.close();
                bufferedOutputStream = bufferedOutputStream4;
                fileOutputStream = fileOutputStream2;
                fileInputStream = fileInputStream2;
                i26++;
                i18 = i3;
                i19 = i17;
                listFiles = fileArr;
            }
            i16 = i19;
        } catch (Exception e26) {
            e = e26;
            i3 = i18;
        }
        APLog.d(TAG, "installFromLocalByPath finish result = " + i16 + " install src = " + file + " About to clear pluginsTemp dir!");
        APPluginUtils.clearDirContent(APPluginConfig.getPluginUpdatePath(context));
        return i16;
    }

    static int installFromZipStream(Context context, InputStream inputStream) {
        String str;
        FileOutputStream fileOutputStream;
        APPluginUtils.copyEmtpyResAPKFromAssets(context);
        if (inputStream == null) {
            return -2;
        }
        ZipInputStream zipInputStream = null;
        r1 = null;
        r1 = null;
        r1 = null;
        BufferedOutputStream bufferedOutputStream = null;
        zipInputStream = null;
        try {
            try {
                ZipInputStream zipInputStream2 = new ZipInputStream(inputStream);
                try {
                    ZipEntry nextEntry = zipInputStream2.getNextEntry();
                    String absolutePath = APPluginConfig.getPluginPath(context).getAbsolutePath();
                    while (nextEntry != null) {
                        String name = nextEntry.getName();
                        if (!nextEntry.isDirectory() && !name.contains("../")) {
                            if (name.endsWith(QZonePatchService.PATCH_SUFFIX)) {
                                int lastIndexOf = name.lastIndexOf(QZonePatchService.PATCH_SUFFIX);
                                if (lastIndexOf != -1) {
                                    name = name.substring(0, lastIndexOf);
                                }
                                String str2 = name.split("_")[3];
                                str = absolutePath + File.separator + name + ".apk";
                            } else {
                                str = absolutePath + File.separator + name;
                            }
                            try {
                                fileOutputStream = new FileOutputStream(new File(str));
                                try {
                                    try {
                                        BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(fileOutputStream);
                                        try {
                                            byte[] bArr = new byte[8192];
                                            while (true) {
                                                int read = zipInputStream2.read(bArr);
                                                if (read == -1) {
                                                    break;
                                                }
                                                bufferedOutputStream2.write(bArr, 0, read);
                                            }
                                            bufferedOutputStream2.flush();
                                            ZipEntry nextEntry2 = zipInputStream2.getNextEntry();
                                            try {
                                                bufferedOutputStream2.close();
                                                fileOutputStream.close();
                                            } catch (IOException e16) {
                                                e16.printStackTrace();
                                            }
                                            nextEntry = nextEntry2;
                                        } catch (Exception e17) {
                                            e = e17;
                                            bufferedOutputStream = bufferedOutputStream2;
                                            e.printStackTrace();
                                            APPluginUtils.installErrMsg = APPluginUtils.getFullExceptionStacktrace(e);
                                            if (bufferedOutputStream != null) {
                                                try {
                                                    bufferedOutputStream.close();
                                                } catch (IOException e18) {
                                                    e18.printStackTrace();
                                                    zipInputStream2.close();
                                                    return -1;
                                                }
                                            }
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                            try {
                                                zipInputStream2.close();
                                            } catch (IOException e19) {
                                                e19.printStackTrace();
                                            }
                                            return -1;
                                        } catch (Throwable th5) {
                                            th = th5;
                                            bufferedOutputStream = bufferedOutputStream2;
                                            if (bufferedOutputStream != null) {
                                                try {
                                                    bufferedOutputStream.close();
                                                } catch (IOException e26) {
                                                    e26.printStackTrace();
                                                    throw th;
                                                }
                                            }
                                            if (fileOutputStream != null) {
                                                fileOutputStream.close();
                                            }
                                            throw th;
                                        }
                                    } catch (Exception e27) {
                                        e = e27;
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                }
                            } catch (Exception e28) {
                                e = e28;
                                fileOutputStream = null;
                            } catch (Throwable th7) {
                                th = th7;
                                fileOutputStream = null;
                            }
                        }
                        nextEntry = zipInputStream2.getNextEntry();
                    }
                    try {
                        zipInputStream2.close();
                    } catch (IOException e29) {
                        e29.printStackTrace();
                    }
                    return 0;
                } catch (Exception e36) {
                    e = e36;
                    zipInputStream = zipInputStream2;
                    e.printStackTrace();
                    APPluginUtils.installErrMsg = APPluginUtils.getFullExceptionStacktrace(e);
                    if (zipInputStream != null) {
                        try {
                            zipInputStream.close();
                        } catch (IOException e37) {
                            e37.printStackTrace();
                        }
                    }
                    return -1;
                } catch (Throwable th8) {
                    th = th8;
                    zipInputStream = zipInputStream2;
                    if (zipInputStream != null) {
                        try {
                            zipInputStream.close();
                        } catch (IOException e38) {
                            e38.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th9) {
                th = th9;
            }
        } catch (Exception e39) {
            e = e39;
        }
    }

    public static int installPlugin(Context context, int i3) {
        APLog.d(TAG, "installPlugin from = " + i3);
        int i16 = 0;
        try {
            unInstallPlugin(context);
            if (i3 == 1) {
                i16 = installFromAssets(context);
            } else if (i3 == 2) {
                i16 = installFromData(context);
            }
            if (i16 != 0) {
                unInstallPlugin(context);
            }
        } catch (Exception e16) {
            APLog.w("APPluginUtils", "installPlugin Exception:" + e16.toString());
            APPluginUtils.installErrMsg = APPluginUtils.getFullExceptionStacktrace(e16);
        }
        return i16;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0067 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int isNeedUpdateFromAssets(Context context, String str) {
        String str2;
        int i3;
        int i16;
        try {
            str2 = getInstallPath(context, "MidasCore").getCanonicalPath();
        } catch (Exception unused) {
            str2 = "";
        }
        try {
            if (!TextUtils.isEmpty(str2)) {
                i3 = APPluginUtils.getPackageInfo(context, str2).versionCode;
            } else {
                i3 = 0;
            }
        } catch (Exception unused2) {
            i3 = 0;
        }
        try {
            i16 = APPluginUtils.getAssetsVersionCode(context);
        } catch (Exception unused3) {
            i16 = 0;
            APLog.i("APPluginUtils", "isNeedUpdateFromAssets coreVC:" + i3 + " assetsVC:" + i16);
            if (!"release".equals(str)) {
                final Activity activity = (Activity) context;
                activity.runOnUiThread(new Runnable() { // from class: com.tencent.midas.plugin.APPluginInstallerAndUpdater.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(activity, "\u5185\u6838\u7248\u672c\u4e0d\u4e00\u81f4\uff01\u8bf7\u68c0\u67e5Assets\u76ee\u5f55\u4e0bMidasPay.zip\u662f\u5426\u66f4\u65b0\u3002", 1).show();
                    }
                });
            }
            if (i16 <= i3) {
            }
        }
        APLog.i("APPluginUtils", "isNeedUpdateFromAssets coreVC:" + i3 + " assetsVC:" + i16);
        if (!"release".equals(str) && 198003 != i16 && context != null && (context instanceof Activity)) {
            final Activity activity2 = (Activity) context;
            activity2.runOnUiThread(new Runnable() { // from class: com.tencent.midas.plugin.APPluginInstallerAndUpdater.1
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(activity2, "\u5185\u6838\u7248\u672c\u4e0d\u4e00\u81f4\uff01\u8bf7\u68c0\u67e5Assets\u76ee\u5f55\u4e0bMidasPay.zip\u662f\u5426\u66f4\u65b0\u3002", 1).show();
                }
            });
        }
        if (i16 <= i3) {
            return 1;
        }
        File dataZipFile = APPluginUtils.getDataZipFile(context);
        if (dataZipFile != null) {
            int zipVersionCodeWtihFileName = APPluginUtils.getZipVersionCodeWtihFileName(context, dataZipFile.getAbsolutePath());
            APLog.i("APPluginUtils", "isNeedUpdateFromAssets dataVC:" + zipVersionCodeWtihFileName);
            if (zipVersionCodeWtihFileName > i3) {
                return 2;
            }
        }
        return 0;
    }

    public static boolean isNeedUpdateFromLocal(Context context) {
        APLog.d(TAG, "isNeedUpdateFromLocal");
        File pluginUpdatePath = APPluginConfig.getPluginUpdatePath(context);
        try {
            File file = new File(pluginUpdatePath, APPluginConfig.SIGN_FILE_NAME);
            if (!file.exists()) {
                APLog.d(TAG, "isNeedUpdateFromLocal, sign file not exist, return false!");
                return false;
            }
            APLog.d(TAG, "isNeedUpdateFromLocal, sign file exist!");
            HashMap hashMap = new HashMap();
            APPluginUtils.readSingInfoItems(hashMap, file);
            File[] listFiles = pluginUpdatePath.listFiles();
            if (listFiles == null) {
                APLog.d(TAG, "isNeedUpdateFromLocal, cannot get local file list, return false!");
                return false;
            }
            if (listFiles.length == 0) {
                APLog.d(TAG, "isNeedUpdateFromLocal, empty local file list, return false!");
                return false;
            }
            boolean z16 = false;
            for (File file2 : listFiles) {
                String name = file2.getName();
                APLog.d(TAG, "isNeedUpdateFromLocal, iterating update dir file list, current = " + name);
                if (name.startsWith("MidasCore")) {
                    z16 = true;
                }
                if (!name.endsWith(".apk")) {
                    APLog.d(TAG, "isNeedUpdateFromLocal, iterating update dir file list, current = " + name + ", not apk file, continue!");
                } else {
                    boolean checkFileMD5 = APPluginUtils.checkFileMD5(file2.getCanonicalPath(), ((APSignIniItem) hashMap.get(name.split("\\_")[0])).md5);
                    APLog.d(TAG, "isNeedUpdateFromLocal, iterating update dir file list, current = " + name + " valid = " + checkFileMD5);
                    if (!checkFileMD5) {
                        APPluginUtils.clearDirContent(pluginUpdatePath);
                        return false;
                    }
                    hashMap.remove(name.split("\\_")[0]);
                }
            }
            if (hashMap.size() > 0) {
                APLog.d(TAG, "isNeedUpdateFromLocal, update dir file list iterate finish! sigMap size = " + hashMap.size());
                File pluginPath = APPluginConfig.getPluginPath(context);
                for (APSignIniItem aPSignIniItem : hashMap.values()) {
                    APLog.d(TAG, "isNeedUpdateFromLocal, iterating sigMap left, current = " + aPSignIniItem.fullName);
                    if (!new File(pluginPath, aPSignIniItem.fullName).exists()) {
                        APLog.e(TAG, "isNeedUpdateFromLocal, iterating sigMap left, current = " + aPSignIniItem.fullName + " missing in midasplugins!");
                        APPluginUtils.clearDirContent(pluginUpdatePath);
                        return false;
                    }
                    APLog.d(TAG, "isNeedUpdateFromLocal, iterating sigMap left, current = " + aPSignIniItem.fullName + " exist in midasplugins!");
                }
            } else {
                APLog.d(TAG, "isNeedUpdateFromLocal, update dir file list iterate finish! sigMap size is 0");
            }
            if (!z16) {
                APLog.d(TAG, "isNeedUpdateFromLocal, hasMidasCoreFile == false!");
                return false;
            }
            APLog.d(TAG, "isNeedUpdateFromLocal, hasMidasCoreFile == true!");
            APLog.e(TAG, "isNeedUpdateFromLocal, return true!");
            return true;
        } catch (Exception e16) {
            APLog.e(TAG, "isNeedUpdateFromLocal, got exception = " + e16);
            e16.printStackTrace();
            return false;
        }
    }

    public static void unInstallPlugin(Context context) {
        APLog.d(TAG, "unInstallPlugin " + Thread.currentThread().getStackTrace()[3].toString());
        APPluginUtils.deletePlugin(context);
        APPluginUtils.deleteDex(context);
        APPluginUtils.deleteLibs(context);
        sInstallPathMap.clear();
        sPackageInfoMap.clear();
        APPluginStatic.release();
        APPluginConfig.libExtend++;
    }
}
