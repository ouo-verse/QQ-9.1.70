package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsExtensionFunctionManager;
import com.tencent.smtt.sdk.TbsPVConfig;
import com.tencent.smtt.sdk.TbsShareManager;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.util.jar.JarFile;
import java.util.regex.Pattern;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0069: MOVE (r3 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:35:0x0069 */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(File file) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        MessageDigest messageDigest;
        int i3;
        char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[32];
        FileInputStream fileInputStream3 = null;
        try {
            try {
                messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                fileInputStream = new FileInputStream(file);
            } catch (Exception e16) {
                e = e16;
                fileInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                if (fileInputStream3 != null) {
                }
                throw th;
            }
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                }
                byte[] digest = messageDigest.digest();
                int i16 = 0;
                for (i3 = 0; i3 < 16; i3++) {
                    byte b16 = digest[i3];
                    int i17 = i16 + 1;
                    cArr2[i16] = cArr[(b16 >>> 4) & 15];
                    i16 = i17 + 1;
                    cArr2[i17] = cArr[b16 & RegisterType.DOUBLE_HI];
                }
                String str = new String(cArr2);
                try {
                    fileInputStream.close();
                } catch (IOException e17) {
                    e17.printStackTrace();
                }
                return str;
            } catch (Exception e18) {
                e = e18;
                e.printStackTrace();
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e19) {
                        e19.printStackTrace();
                    }
                }
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            fileInputStream3 = fileInputStream2;
            if (fileInputStream3 != null) {
                try {
                    fileInputStream3.close();
                } catch (IOException e26) {
                    e26.printStackTrace();
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x006c, code lost:
    
        r1 = r1[1].trim();
        com.tencent.smtt.utils.TbsLog.i(com.tencent.smtt.sdk.TbsDownloader.LOGTAG, "getApkVersionByReadFile version is " + r1);
        r1 = java.lang.Integer.parseInt(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008f, code lost:
    
        r7.close();
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00be, code lost:
    
        if (r2 != null) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00cc A[Catch: all -> 0x00bc, Exception -> 0x00cf, TRY_LEAVE, TryCatch #1 {Exception -> 0x00cf, blocks: (B:54:0x00c7, B:49:0x00cc), top: B:53:0x00c7 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int b(File file) {
        JarFile jarFile;
        Throwable th5;
        BufferedReader bufferedReader;
        Exception e16;
        String[] split;
        int parseInt;
        TbsLog.i(TbsDownloader.LOGTAG, "getApkVersionByReadFile" + file + "exists:" + file.exists() + ";canread:" + file.canRead());
        synchronized (a.class) {
            try {
                try {
                    jarFile = new JarFile(file);
                } catch (Exception e17) {
                    jarFile = null;
                    e16 = e17;
                    bufferedReader = null;
                } catch (Throwable th6) {
                    jarFile = null;
                    th5 = th6;
                    bufferedReader = null;
                }
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(jarFile.getInputStream(jarFile.getJarEntry("assets/webkit/tbs.conf"))));
                    while (true) {
                        try {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine != null) {
                                    if (readLine.contains("tbs_core_version") && (split = readLine.split(ContainerUtils.KEY_VALUE_DELIMITER)) != null && split.length == 2) {
                                        break;
                                    }
                                } else {
                                    bufferedReader.close();
                                    break;
                                }
                            } catch (Throwable th7) {
                                th5 = th7;
                                if (bufferedReader != null) {
                                    try {
                                        bufferedReader.close();
                                    } catch (Exception unused) {
                                        throw th5;
                                    }
                                }
                                if (jarFile != null) {
                                    jarFile.close();
                                }
                                throw th5;
                            }
                        } catch (Exception e18) {
                            e16 = e18;
                            TbsLog.i(e16);
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                        }
                    }
                } catch (Exception e19) {
                    e16 = e19;
                    bufferedReader = null;
                } catch (Throwable th8) {
                    th5 = th8;
                    bufferedReader = null;
                    if (bufferedReader != null) {
                    }
                    if (jarFile != null) {
                    }
                    throw th5;
                }
                jarFile.close();
            } catch (Exception unused2) {
            }
            return -1;
        }
        return parseInt;
    }

    public static int a(Context context, File file) {
        return a(context, file, 0);
    }

    public static int a(Context context, File file, int i3) {
        try {
            return a(context, file, !TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.DISABLE_GET_APK_VERSION_SWITCH_FILE_NAME), i3);
        } catch (Exception unused) {
            TbsLog.i("ApkUtil", "getApkVersion Failed");
            return 0;
        }
    }

    public static final String a(boolean z16, int i3) {
        boolean is64BitImpl;
        if (i3 == 64) {
            is64BitImpl = true;
        } else {
            is64BitImpl = i3 == 32 ? false : AppUtil.is64BitImpl();
        }
        return is64BitImpl ? z16 ? "x5.64.decouple.backup" : "x5.64.backup" : z16 ? "x5.decouple.backup" : "x5.backup";
    }

    private static int a(boolean z16, File file, int i3) {
        try {
            File parentFile = file.getParentFile();
            if (parentFile == null) {
                return -1;
            }
            File[] listFiles = parentFile.listFiles();
            Pattern compile = Pattern.compile(a(z16, i3) + "(.*)");
            for (File file2 : listFiles) {
                if (compile.matcher(file2.getName()).find() && file2.isFile() && file2.exists()) {
                    return Integer.parseInt(file2.getName().substring(file2.getName().lastIndexOf(".") + 1));
                }
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static int a(Context context, File file, boolean z16, int i3) {
        if (file != null) {
            try {
                if (file.exists()) {
                    boolean contains = file.getName().contains("tbs.org");
                    boolean contains2 = file.getName().contains("x5.tbs.decouple");
                    if (contains || contains2) {
                        int a16 = a(contains2, file, i3);
                        if (a16 > 0) {
                            return a16;
                        }
                        if (!TbsShareManager.isThirdPartyApp(context) && !file.getAbsolutePath().contains(context.getApplicationInfo().packageName)) {
                            return 0;
                        }
                    }
                    int i16 = Build.VERSION.SDK_INT;
                    boolean z17 = (i16 == 23 || i16 == 25) && Build.MANUFACTURER.toLowerCase().contains("mi");
                    TbsPVConfig.releaseInstance();
                    int readApk = TbsPVConfig.getInstance(context).getReadApk();
                    if (readApk == 1) {
                        z16 = false;
                        z17 = false;
                    } else if (readApk == 2) {
                        return 0;
                    }
                    if (z16 || z17) {
                        int b16 = b(file);
                        if (b16 > 0) {
                            return b16;
                        }
                    }
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
        if (file == null || !file.exists()) {
            return 0;
        }
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 1);
            if (packageArchiveInfo != null) {
                return packageArchiveInfo.versionCode;
            }
            return 0;
        } catch (Throwable th6) {
            th6.printStackTrace();
            return -1;
        }
    }
}
