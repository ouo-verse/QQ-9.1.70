package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: P */
/* loaded from: classes2.dex */
public class BksUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final String f37960a = "BksUtil";

    /* renamed from: b, reason: collision with root package name */
    private static final String f37961b = "com.huawei.hwid";

    /* renamed from: c, reason: collision with root package name */
    private static final String f37962c = "com.huawei.hwid";

    /* renamed from: d, reason: collision with root package name */
    private static final String f37963d = "com.huawei.hms";

    /* renamed from: e, reason: collision with root package name */
    private static final String f37964e = "com.huawei.hwid.tv";

    /* renamed from: g, reason: collision with root package name */
    private static final String f37966g = "files/hmsrootcas.bks";

    /* renamed from: h, reason: collision with root package name */
    private static final String f37967h = "4.0.2.300";

    /* renamed from: i, reason: collision with root package name */
    private static final String f37968i = "aegis";

    /* renamed from: j, reason: collision with root package name */
    private static final String f37969j = "hmsrootcas.bks";

    /* renamed from: k, reason: collision with root package name */
    private static final long f37970k = 604800000;

    /* renamed from: l, reason: collision with root package name */
    private static final String f37971l = "last_update_time";

    /* renamed from: m, reason: collision with root package name */
    private static final String f37972m = "B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05";

    /* renamed from: n, reason: collision with root package name */
    private static final String f37973n = "3517262215D8D3008CBF888750B6418EDC4D562AC33ED6874E0D73ABA667BC3C";

    /* renamed from: q, reason: collision with root package name */
    private static final String f37976q = "";

    /* renamed from: r, reason: collision with root package name */
    private static final String f37977r = "bks_hash";

    /* renamed from: f, reason: collision with root package name */
    private static final Uri f37965f = Uri.parse("content://com.huawei.hwid");

    /* renamed from: o, reason: collision with root package name */
    private static final String f37974o = "E49D5C2C0E11B3B1B96CA56C6DE2A14EC7DAB5CCC3B5F300D03E5B4DBA44F539";

    /* renamed from: p, reason: collision with root package name */
    private static final String[] f37975p = {"B92825C2BD5D6D6D1E7F39EECD17843B7D9016F611136B75441BC6F4D3F00F05", f37974o};

    BksUtil() {
    }

    private static boolean a(int i3) {
        return i3 >= 40002300;
    }

    private static String b(Context context) {
        return a(context) + File.separator + "hmsrootcas.bks";
    }

    private static boolean c(Context context) {
        return new File(a(context) + File.separator + "hmsrootcas.bks").exists();
    }

    public static synchronized InputStream getBksFromTss(Context context) {
        InputStream inputStream;
        InputStream inputStream2;
        InputStream inputStream3;
        String a16;
        String b16;
        synchronized (BksUtil.class) {
            g.c(f37960a, "get bks from tss begin");
            if (context != null) {
                c.a(context);
            }
            Context a17 = c.a();
            InputStream inputStream4 = null;
            if (a17 == null) {
                g.b(f37960a, "context is null");
                return null;
            }
            if (!b(h.a("com.huawei.hwid")) && !b(h.a("com.huawei.hms"))) {
                g.b(f37960a, "hms version code is too low : " + h.a("com.huawei.hwid"));
                return null;
            }
            if (!c(a17, "com.huawei.hwid") && !b(a17, "com.huawei.hms")) {
                g.b(f37960a, "hms sign error");
                return null;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                inputStream2 = a17.getContentResolver().openInputStream(Uri.withAppendedPath(f37965f, f37966g));
                try {
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = inputStream2.read(bArr);
                            if (read <= -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        byteArrayOutputStream.flush();
                        inputStream3 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                        try {
                            a16 = i.a(f37977r, "", a17);
                            b16 = b(byteArrayOutputStream.toByteArray());
                        } catch (Exception e16) {
                            e = e16;
                            inputStream4 = inputStream3;
                            g.b(f37960a, "Get bks from HMS_VERSION_CODE exception : No content provider" + e.getMessage());
                            f.a(inputStream2);
                            f.a((OutputStream) byteArrayOutputStream);
                            f.a(inputStream4);
                            return getFilesBksIS(a17);
                        } catch (Throwable th5) {
                            th = th5;
                            f.a(inputStream2);
                            f.a((OutputStream) byteArrayOutputStream);
                            f.a(inputStream3);
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        InputStream inputStream5 = inputStream2;
                        inputStream = inputStream4;
                        inputStream4 = inputStream5;
                        inputStream3 = inputStream;
                        inputStream2 = inputStream4;
                        f.a(inputStream2);
                        f.a((OutputStream) byteArrayOutputStream);
                        f.a(inputStream3);
                        throw th;
                    }
                } catch (Exception e17) {
                    e = e17;
                }
            } catch (Exception e18) {
                e = e18;
                inputStream2 = null;
            } catch (Throwable th7) {
                th = th7;
                inputStream = null;
                inputStream3 = inputStream;
                inputStream2 = inputStream4;
                f.a(inputStream2);
                f.a((OutputStream) byteArrayOutputStream);
                f.a(inputStream3);
                throw th;
            }
            if (c(a17) && a16.equals(b16)) {
                g.c(f37960a, "bks not update");
                f.a(inputStream2);
                f.a((OutputStream) byteArrayOutputStream);
                f.a(inputStream3);
                return getFilesBksIS(a17);
            }
            g.c(f37960a, "update bks and sp");
            a(inputStream3, a17);
            i.b(f37977r, b16, a17);
            f.a(inputStream2);
            f.a((OutputStream) byteArrayOutputStream);
            f.a(inputStream3);
            return getFilesBksIS(a17);
        }
    }

    public static InputStream getFilesBksIS(Context context) {
        if (c(context)) {
            g.c(f37960a, "getFilesBksIS ");
            try {
                return new FileInputStream(b(context));
            } catch (FileNotFoundException unused) {
                g.b(f37960a, "FileNotFoundExceptio: ");
                return null;
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    private static void a(InputStream inputStream, Context context) {
        if (inputStream == null || context == null) {
            return;
        }
        String a16 = a(context);
        if (!new File(a16).exists()) {
            a(a16);
        }
        File file = new File(a16, "hmsrootcas.bks");
        if (file.exists()) {
            file.delete();
        }
        ?? r75 = 0;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                g.c(f37960a, "write output stream ");
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                r75 = 2048;
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int read = inputStream.read(bArr, 0, 2048);
                        if (read == -1) {
                            break;
                        } else {
                            fileOutputStream2.write(bArr, 0, read);
                        }
                    }
                    f.a((OutputStream) fileOutputStream2);
                } catch (IOException unused) {
                    fileOutputStream = fileOutputStream2;
                    g.b(f37960a, " IOException");
                    f.a((OutputStream) fileOutputStream);
                    r75 = fileOutputStream;
                } catch (Throwable th5) {
                    th = th5;
                    r75 = fileOutputStream2;
                    f.a((OutputStream) r75);
                    throw th;
                }
            } catch (IOException unused2) {
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private static boolean b(String str) {
        int parseInt;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        g.c(f37960a, "hms version code is : " + str);
        String[] split = str.split("\\.");
        String[] split2 = f37967h.split("\\.");
        int length = split.length;
        int length2 = split2.length;
        int max = Math.max(length, length2);
        int i3 = 0;
        while (i3 < max) {
            if (i3 < length) {
                try {
                    parseInt = Integer.parseInt(split[i3]);
                } catch (Exception e16) {
                    g.b(f37960a, " exception : " + e16.getMessage());
                    return i3 >= length2;
                }
            } else {
                parseInt = 0;
            }
            int parseInt2 = i3 < length2 ? Integer.parseInt(split2[i3]) : 0;
            if (parseInt < parseInt2) {
                return false;
            }
            if (parseInt > parseInt2) {
                return true;
            }
            i3++;
        }
        return true;
    }

    private static boolean c(Context context, String str) {
        byte[] a16 = a(context, str);
        for (String str2 : f37975p) {
            if (str2.equalsIgnoreCase(c(a16))) {
                return true;
            }
        }
        return false;
    }

    private static String c(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        try {
            return a(MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256).digest(bArr));
        } catch (NoSuchAlgorithmException e16) {
            Log.e(f37960a, "NoSuchAlgorithmException" + e16.getMessage());
            return "";
        }
    }

    private static boolean b(Context context, String str) {
        return f37974o.equalsIgnoreCase(c(a(context, str)));
    }

    private static String b(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA256);
            messageDigest.update(bArr);
            return a(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            g.b(f37960a, "inputstraem exception");
            return "";
        }
    }

    private static int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        File file = new File(str);
        if (file.exists()) {
            g.e(f37960a, "The directory  has already exists");
            return 1;
        }
        if (file.mkdirs()) {
            g.a(f37960a, "create directory  success");
            return 0;
        }
        g.b(f37960a, "create directory  failed");
        return -1;
    }

    private static String a(Context context) {
        Context createDeviceProtectedStorageContext;
        if (Build.VERSION.SDK_INT >= 24) {
            StringBuilder sb5 = new StringBuilder();
            createDeviceProtectedStorageContext = context.createDeviceProtectedStorageContext();
            sb5.append(createDeviceProtectedStorageContext.getFilesDir());
            sb5.append(File.separator);
            sb5.append(f37968i);
            return sb5.toString();
        }
        return context.getApplicationContext().getFilesDir() + File.separator + f37968i;
    }

    private static byte[] a(Context context, String str) {
        PackageInfo packageInfo;
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && (packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, str, 64)) != null) {
                    return packageInfo.signatures[0].toByteArray();
                }
            } catch (PackageManager.NameNotFoundException e16) {
                Log.e(f37960a, "PackageManager.NameNotFoundException : " + e16.getMessage());
            } catch (Exception e17) {
                Log.e(f37960a, "get pm exception : " + e17.getMessage());
            }
            return new byte[0];
        }
        Log.e(f37960a, "packageName is null or context is null");
        return new byte[0];
    }

    private static String a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        for (byte b16 : bArr) {
            String hexString = Integer.toHexString(b16 & 255);
            if (hexString.length() == 1) {
                sb5.append('0');
            }
            sb5.append(hexString);
        }
        return sb5.toString();
    }
}
