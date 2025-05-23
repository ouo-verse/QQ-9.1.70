package com.tencent.mobileqq.msf.core;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import com.tencent.commonsdk.soload.SoLoadCore;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.asset.ITVKAsset;
import com.tencent.rfix.loader.utils.RFixConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    private static final String f247560a = "MSF.C.CoreUtil";

    /* renamed from: b, reason: collision with root package name */
    static int f247561b = -1;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19619);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static byte[] a(int i3) {
        return new byte[]{(byte) ((i3 >>> 24) & 255), (byte) ((i3 >>> 16) & 255), (byte) ((i3 >>> 8) & 255), (byte) (i3 & 255)};
    }

    public static synchronized String b(Context context) {
        synchronized (c.class) {
            String absolutePath = context.getFilesDir().getAbsolutePath();
            if (absolutePath == null) {
                if (QLog.isColorLevel()) {
                    QLog.w(f247560a, 2, "getFilePath dir is null");
                }
                return null;
            }
            File file = new File(absolutePath);
            if (!file.exists()) {
                file.mkdirs();
            }
            return absolutePath;
        }
    }

    public static int c(Context context) {
        if (f247561b == -1 && context != null) {
            try {
                f247561b = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionCode;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return f247561b;
    }

    public static String d(Context context) {
        if (context != null) {
            try {
                return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 0).versionName;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return "";
    }

    private static String[] e(Context context) {
        String[] strArr = {"", ""};
        try {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(context.getFilesDir() + "/jni.ini")));
                int i3 = 0;
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null || i3 >= 2) {
                        break;
                    }
                    strArr[i3] = readLine;
                    i3++;
                }
                for (int i16 = 0; i16 < 2; i16++) {
                    String str = strArr[i16];
                    if (str != null) {
                        str.trim();
                        if (strArr[i16].length() > 4) {
                            strArr[i16] = strArr[i16].substring(4);
                        }
                    }
                }
                bufferedReader.close();
            } catch (IOException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(f247560a, 2, "get oldJniID IOException " + e16.getMessage());
                }
            }
        } catch (IOException e17) {
            if (QLog.isColorLevel()) {
                QLog.d(f247560a, 2, "get oldJniID FileNotFoundException " + e17.getMessage());
            }
            e17.printStackTrace();
        }
        QLog.d(f247560a, 1, "get old jni id = " + Arrays.toString(strArr));
        return strArr;
    }

    public static String f(Context context) {
        return context.getFilesDir() + "/verFile2";
    }

    private static String[] g(Context context) {
        boolean z16;
        boolean z17;
        String[] strArr = new String[2];
        try {
            InputStream open = context.getAssets().open("jni.ini");
            if (open != null) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open));
                int i3 = 0;
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (i3 < 2) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!z16 || !z17) {
                        break;
                    }
                    strArr[i3] = readLine;
                    i3++;
                }
                for (int i16 = 0; i16 < 2; i16++) {
                    String str = strArr[i16];
                    if (str != null) {
                        str.trim();
                        if (strArr[i16].length() > 4) {
                            strArr[i16] = strArr[i16].substring(4);
                        }
                    }
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f247560a, 2, "read jni error " + e16);
            }
            strArr = new String[]{"0", "0"};
        }
        QLog.d(f247560a, 1, "get new jni id = " + Arrays.toString(strArr));
        return strArr;
    }

    public static synchronized String h(Context context) {
        synchronized (c.class) {
            String str = Build.CPU_ABI;
            if (str != null && str.contains(ResourceAttributes.HostArchValues.X86)) {
                return ResourceAttributes.HostArchValues.X86;
            }
            if (str != null) {
                if (str.contains("mip")) {
                    return "mips";
                }
            }
            return "armeabi";
        }
    }

    public static synchronized String i(Context context) {
        String absolutePath;
        synchronized (c.class) {
            try {
                File filesDir = context.getFilesDir();
                if (filesDir == null) {
                    File cacheDir = context.getCacheDir();
                    if (cacheDir == null) {
                        if (QLog.isColorLevel()) {
                            QLog.w(f247560a, 2, "load cache dir is null");
                        }
                        absolutePath = null;
                    } else {
                        absolutePath = cacheDir.getAbsolutePath();
                        int lastIndexOf = absolutePath.lastIndexOf(47);
                        if (lastIndexOf != -1) {
                            absolutePath = absolutePath.substring(0, lastIndexOf) + "/files/";
                        }
                    }
                } else {
                    absolutePath = filesDir.getAbsolutePath();
                }
                if (absolutePath == null) {
                    absolutePath = Environment.getExternalStorageDirectory().getPath() + "/MSF/files";
                    File file = new File(absolutePath);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                } else {
                    File file2 = new File(absolutePath);
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    if (!file2.exists() || !file2.canWrite()) {
                        absolutePath = Environment.getExternalStorageDirectory().getPath() + "/MSF/files";
                        new File(absolutePath).mkdirs();
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d(f247560a, 2, "load save root dir is " + absolutePath);
                }
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.w(f247560a, 2, "getSaveRootPath error ", th5);
                }
                return null;
            }
        }
        return absolutePath;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0058 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x004f -> B:16:0x0061). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int j(Context context) {
        FileInputStream fileInputStream;
        Exception e16;
        File file = new File(f(context));
        if (file.exists()) {
            file.delete();
        }
        File file2 = new File(m(context));
        int i3 = -1;
        if (file2.exists()) {
            FileInputStream fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(file2);
                } catch (Exception e17) {
                    fileInputStream = null;
                    e16 = e17;
                } catch (Throwable th5) {
                    th = th5;
                    if (fileInputStream2 != null) {
                    }
                    throw th;
                }
            } catch (IOException e18) {
                e18.printStackTrace();
            }
            try {
                try {
                    if (fileInputStream.available() == 4) {
                        byte[] bArr = new byte[4];
                        fileInputStream.read(bArr);
                        i3 = a(bArr, 0);
                    }
                    fileInputStream.close();
                } catch (Throwable th6) {
                    th = th6;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        try {
                            fileInputStream2.close();
                        } catch (IOException e19) {
                            e19.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e26) {
                e16 = e26;
                e16.printStackTrace();
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return i3;
            }
        }
        return i3;
    }

    public static long k(Context context) {
        try {
            StatFs statFs = new StatFs(l(context));
            return (statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1024;
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static String l(Context context) {
        return context.getFilesDir().getParent() + SoLoadCore.PATH_TX_LIB;
    }

    public static String m(Context context) {
        return context.getFilesDir() + "/verFile";
    }

    public static synchronized File a(String str) {
        File file;
        synchronized (c.class) {
            file = new File(str + "/load/");
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return file;
    }

    private static synchronized boolean a(String str, String str2, Context context) {
        InputStream inputStream;
        int read;
        synchronized (c.class) {
            boolean z16 = false;
            if (context != null && str != null) {
                if (str.contains(".so")) {
                    if (str2 == null || str2.trim().length() == 0) {
                        if (QLog.isColorLevel()) {
                            QLog.e(f247560a, 2, "not define lib out path");
                        }
                        str2 = context.getFilesDir().getAbsolutePath();
                    }
                    new File(str2).mkdirs();
                    int lastIndexOf = str.lastIndexOf(47);
                    String substring = lastIndexOf >= 0 ? str.substring(lastIndexOf + 1) : str;
                    if (QLog.isColorLevel()) {
                        QLog.d(f247560a, 2, "copy lib:" + str);
                    }
                    FileOutputStream fileOutputStream = null;
                    try {
                        inputStream = context.getAssets().open(str);
                        try {
                            File file = new File(str2 + "/" + substring);
                            if (file.exists()) {
                                file.delete();
                            }
                            file.createNewFile();
                            FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                            try {
                                byte[] bArr = new byte[4096];
                                while (inputStream.available() > 0 && (read = inputStream.read(bArr)) > 0) {
                                    fileOutputStream2.write(bArr, 0, read);
                                }
                                fileOutputStream2.close();
                                inputStream.close();
                                z16 = true;
                            } catch (Exception unused) {
                                fileOutputStream = fileOutputStream2;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException unused3) {
                                    }
                                }
                                return z16;
                            }
                        } catch (Exception unused4) {
                        }
                    } catch (Exception unused5) {
                        inputStream = null;
                    }
                    return z16;
                }
            }
            return false;
        }
    }

    public static synchronized File b(String str) {
        File file;
        synchronized (c.class) {
            file = new File(str + "/cacheTemp/");
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return file;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, int i3) {
        FileOutputStream fileOutputStream;
        Exception e16;
        File file = new File(m(context));
        if (file.exists()) {
            file.delete();
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                file.createNewFile();
                fileOutputStream = new FileOutputStream(file);
            } catch (Exception e17) {
                fileOutputStream = null;
                e16 = e17;
            } catch (Throwable th5) {
                th = th5;
                if (fileOutputStream2 != null) {
                }
                throw th;
            }
            try {
                try {
                    fileOutputStream.write(a(i3));
                    fileOutputStream.close();
                } catch (Throwable th6) {
                    th = th6;
                    fileOutputStream2 = fileOutputStream;
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (IOException e18) {
                            e18.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e19) {
                e16 = e19;
                e16.printStackTrace();
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            }
        } catch (IOException e26) {
            e26.printStackTrace();
        }
    }

    public static String a(InputStream inputStream) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        byte[] bArr = new byte[64];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                stringBuffer.append(new String(bArr, 0, read));
            } else {
                return stringBuffer.toString();
            }
        }
    }

    public static void a(Context context) throws IOException {
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        if (QLog.isColorLevel()) {
            QLog.d(f247560a, 2, "MsfCore init ->copy jni file...");
        }
        FileOutputStream fileOutputStream2 = null;
        try {
            inputStream = context.getAssets().open("jni.ini");
            try {
                fileOutputStream = new FileOutputStream(context.getFilesDir() + "/jni.ini");
                try {
                    byte[] bArr = new byte[128];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        } else {
                            fileOutputStream.write(bArr, 0, read);
                        }
                    }
                    inputStream.close();
                } catch (Exception unused) {
                    fileOutputStream2 = fileOutputStream;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream = fileOutputStream2;
                        fileOutputStream.close();
                    }
                    return;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream2 = fileOutputStream;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw th;
                }
            } catch (Exception unused2) {
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception unused3) {
            inputStream = null;
        } catch (Throwable th7) {
            th = th7;
            inputStream = null;
        }
        fileOutputStream.close();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(String str, Context context) {
        boolean z16;
        if (context == null) {
            return false;
        }
        File file = new File(l(context) + RFixConstants.SO_PATH + str + ".so");
        if (!file.exists()) {
            file = new File(context.getFilesDir().getParent() + "/lib/lib" + str + ".so");
        }
        if (file.exists()) {
            try {
                System.load(file.getAbsolutePath());
                z16 = true;
            } catch (UnsatisfiedLinkError unused) {
                if (QLog.isColorLevel()) {
                    QLog.d(f247560a, 2, "cannot load library " + file.getAbsolutePath());
                }
            }
            if (!z16) {
                return z16;
            }
            try {
                System.loadLibrary(str);
                return true;
            } catch (UnsatisfiedLinkError unused2) {
                if (QLog.isColorLevel()) {
                    QLog.d(f247560a, 2, "cannot load library " + str);
                }
                return false;
            }
        }
        z16 = false;
        if (!z16) {
        }
    }

    public static int a(byte[] bArr, int i3) {
        return ((bArr[i3 + 0] << 24) & (-16777216)) | (bArr[i3 + 3] & 255) | ((bArr[i3 + 2] << 8) & 65280) | ((bArr[i3 + 1] << RegisterType.UNINIT_REF) & ITVKAsset.VOD_ASSET_MASK_BIT);
    }

    public static boolean a() {
        System.out.println("bRet=false");
        return false;
    }
}
