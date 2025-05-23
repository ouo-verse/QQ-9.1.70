package com.tencent.luggage.wxa.cp;

import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.tencent.luggage.wxa.cp.l;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class x {
    public static InputStream a(b0 b0Var) {
        return a(b0Var, (l.h) null);
    }

    public static OutputStream b(v vVar) {
        return a(vVar.n(), vVar.x(), false);
    }

    public static RandomAccessFile c(String str, boolean z16) {
        return a(b0.b(str), z16);
    }

    public static OutputStream d(String str, boolean z16) {
        if (str != null && !str.isEmpty()) {
            return a(b0.b(str), (l.h) null, z16);
        }
        throw new FileNotFoundException("path is empty");
    }

    public static long e(String str) {
        i c16;
        if (str == null || str.isEmpty()) {
            return 0L;
        }
        l.h a16 = l.d().a(b0.b(str));
        if (!a16.a() || (c16 = a16.f123799a.c(a16.f123800b)) == null) {
            return 0L;
        }
        return c16.f123767c;
    }

    public static long f(String str) {
        i c16;
        if (str == null || str.isEmpty()) {
            return 0L;
        }
        l.h a16 = l.d().a(b0.b(str));
        if (!a16.a() || (c16 = a16.f123799a.c(a16.f123800b)) == null) {
            return 0L;
        }
        return c16.f123769e;
    }

    public static String g(String str) {
        String i3;
        int lastIndexOf;
        if (str == null || str.length() <= 0 || (lastIndexOf = (i3 = new v(str).i()).lastIndexOf(46)) <= 0 || lastIndexOf == i3.length() - 1) {
            return "";
        }
        return i3.substring(lastIndexOf + 1);
    }

    public static byte[] h(String str) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (str == null) {
            return null;
        }
        try {
            inputStream = n(str);
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                byte[] bArr = new byte[2048];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read >= 0) {
                        messageDigest.update(bArr, 0, read);
                    } else {
                        byte[] digest = messageDigest.digest();
                        c0.a(inputStream);
                        return digest;
                    }
                }
            } catch (Exception unused) {
                c0.a(inputStream);
                return null;
            } catch (Throwable th5) {
                inputStream2 = inputStream;
                th = th5;
                c0.a(inputStream2);
                throw th;
            }
        } catch (Exception unused2) {
            inputStream = null;
        } catch (Throwable th6) {
            th = th6;
        }
    }

    public static String i(String str) {
        byte[] h16 = h(str);
        if (h16 == null) {
            return null;
        }
        StringBuilder sb5 = new StringBuilder(32);
        for (byte b16 : h16) {
            sb5.append(Integer.toString((b16 & 255) + 256, 16).substring(1));
        }
        return sb5.toString();
    }

    public static String j(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        String i3 = new v(str).i();
        int lastIndexOf = i3.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return str;
        }
        if (lastIndexOf == 0) {
            return "";
        }
        return i3.substring(0, lastIndexOf);
    }

    public static String k(String str) {
        return new v(str).f().j();
    }

    public static void l(String str) {
        if (str != null && !str.isEmpty()) {
            l.h a16 = l.d().a(b0.b(str));
            if (!a16.a() || (a16.f123799a.a() & 2) == 0 || a16.f123799a.d(a16.f123800b, true) == null) {
                return;
            }
            try {
                a16.f123799a.a(a16.f123800b + "/.nomedia", false).close();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean m(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        v vVar = new v(str);
        if (!vVar.w() && !vVar.p()) {
            return false;
        }
        return true;
    }

    public static InputStream n(String str) {
        if (str != null && !str.isEmpty()) {
            return a(b0.b(str));
        }
        throw new FileNotFoundException("path is empty");
    }

    public static OutputStream o(String str) {
        return d(str, false);
    }

    public static String p(String str) {
        InputStreamReader inputStreamReader;
        StringBuilder sb5 = new StringBuilder();
        try {
            try {
                inputStreamReader = new InputStreamReader(n(str));
                try {
                    char[] cArr = new char[512];
                    while (true) {
                        int read = inputStreamReader.read(cArr);
                        if (read != -1) {
                            sb5.append(cArr, 0, read);
                        } else {
                            c0.a(inputStreamReader);
                            return sb5.toString();
                        }
                    }
                } catch (IOException e16) {
                    e = e16;
                    com.tencent.luggage.wxa.yp.b.b("MicroMsg.VFSFileOp", "readFileAsString(\"%s\" failed: %s", str, e.getMessage());
                    throw e;
                } catch (Throwable th5) {
                    th = th5;
                    c0.a(inputStreamReader);
                    throw th;
                }
            } catch (IOException e17) {
                e = e17;
            }
        } catch (Throwable th6) {
            th = th6;
            inputStreamReader = null;
        }
    }

    public static InputStream a(Uri uri) {
        return a(new b0(uri), (l.h) null);
    }

    public static String b(String str, boolean z16) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        return c0.a(b0.b(str), z16);
    }

    public static ParcelFileDescriptor c(String str, String str2) {
        return a(b0.b(str), (l.h) null, str2);
    }

    public static InputStream a(v vVar) {
        return a(vVar.n(), vVar.x());
    }

    public static boolean c(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        return new v(str).d();
    }

    public static InputStream a(b0 b0Var, l.h hVar) {
        l.h a16 = l.d().a(b0Var, hVar);
        if (a16.a()) {
            return a16.f123799a.a(a16.f123800b);
        }
        throw new FileNotFoundException("Cannot resolve path or URI: " + b0Var);
    }

    public static int b(String str, byte[] bArr) {
        return b(str, bArr, 0, bArr.length);
    }

    public static boolean d(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        l.h a16 = l.d().a(b0.b(str));
        if (a16.a()) {
            return a16.f123799a.i(a16.f123800b);
        }
        return false;
    }

    public static int b(String str, byte[] bArr, int i3, int i16) {
        if (bArr == null) {
            return -2;
        }
        if (bArr.length < i3 + i16) {
            return -3;
        }
        OutputStream outputStream = null;
        try {
            try {
                outputStream = o(str);
                outputStream.write(bArr, i3, i16);
                return 0;
            } catch (IOException e16) {
                com.tencent.luggage.wxa.yp.b.b("MicroMsg.VFSFileOp", "writeFile '%s' Failed: %s", str, e16.getMessage());
                c0.a(outputStream);
                return -1;
            }
        } finally {
            c0.a(outputStream);
        }
    }

    public static OutputStream a(b0 b0Var, l.h hVar, boolean z16) {
        l.h a16 = l.d().a(b0Var, hVar);
        if (a16.a()) {
            return a16.f123799a.a(a16.f123800b, z16);
        }
        throw new FileNotFoundException("Cannot resolve path or URI: " + b0Var);
    }

    public static int d(String str, String str2) {
        ZipInputStream zipInputStream;
        ZipInputStream zipInputStream2 = null;
        try {
            try {
                zipInputStream = new ZipInputStream(n(str));
                try {
                    HashSet hashSet = new HashSet();
                    byte[] bArr = new byte[4096];
                    while (true) {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry != null) {
                            String name = nextEntry.getName();
                            if (!name.contains("../") && !name.contains("..\\")) {
                                if (nextEntry.isDirectory()) {
                                    String substring = name.substring(0, name.length() - 1);
                                    if (hashSet.add(substring)) {
                                        new v(str2 + "/" + substring).w();
                                    }
                                } else {
                                    v vVar = new v(str2 + "/" + name);
                                    String b16 = c0.b(name);
                                    if (b16 != null && hashSet.add(b16)) {
                                        new v(str2 + "/" + b16).w();
                                    }
                                    OutputStream b17 = b(vVar);
                                    while (true) {
                                        int read = zipInputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        b17.write(bArr, 0, read);
                                    }
                                    b17.close();
                                }
                            }
                        } else {
                            c0.a(zipInputStream);
                            return 0;
                        }
                    }
                } catch (FileNotFoundException e16) {
                    e = e16;
                    zipInputStream2 = zipInputStream;
                    com.tencent.luggage.wxa.yp.b.b("MicroMsg.VFSFileOp", e, "");
                    c0.a(zipInputStream2);
                    return -1;
                } catch (IOException e17) {
                    e = e17;
                    zipInputStream2 = zipInputStream;
                    com.tencent.luggage.wxa.yp.b.b("MicroMsg.VFSFileOp", e, "");
                    c0.a(zipInputStream2);
                    return -2;
                } catch (Throwable th5) {
                    th = th5;
                    c0.a(zipInputStream);
                    throw th;
                }
            } catch (FileNotFoundException e18) {
                e = e18;
            } catch (IOException e19) {
                e = e19;
            }
        } catch (Throwable th6) {
            th = th6;
            zipInputStream = null;
        }
    }

    public static RandomAccessFile a(b0 b0Var, boolean z16) {
        String a16 = c0.a(b0Var, z16);
        if (a16 != null) {
            return new RandomAccessFile(a16, z16 ? "rw" : "r");
        }
        throw new FileNotFoundException("Cannot resolve path or URI: " + b0Var);
    }

    public static boolean b(String str, String str2) {
        return b(str, str2, true);
    }

    public static boolean b(String str, String str2, boolean z16) {
        if (str != null && str2 != null && str.length() != 0 && str2.length() != 0) {
            l.h a16 = l.d().a(b0.b(str));
            l.h a17 = l.d().a(b0.b(str2));
            if (a16.a() && a17.a()) {
                try {
                    boolean a18 = a17.f123799a.a(a17.f123800b, a16.f123799a, a16.f123800b);
                    if (!a18 && z16) {
                        a18 = a17.f123799a.a(a17.f123800b, a16.f123799a, a16.f123800b, false) >= 0;
                        if (a18) {
                            a16.f123799a.b(a16.f123800b);
                        }
                    }
                    return a18;
                } catch (IOException e16) {
                    com.tencent.luggage.wxa.yp.b.e("MicroMsg.VFSFileOp", "Failed to move file " + str + " -> " + str2 + MsgSummary.STR_COLON + e16.getMessage());
                }
            }
        }
        return false;
    }

    public static ParcelFileDescriptor a(Uri uri, String str) {
        return a(new b0(uri), (l.h) null, str);
    }

    public static ParcelFileDescriptor a(b0 b0Var, l.h hVar, String str) {
        l.h a16 = l.d().a(b0Var, hVar);
        if (a16.a()) {
            return a16.f123799a.a(a16.f123800b, str);
        }
        throw new FileNotFoundException("Cannot resolve path or URI: " + b0Var);
    }

    public static int a(String str, byte[] bArr) {
        return a(str, bArr, 0, bArr.length);
    }

    public static int a(String str, byte[] bArr, int i3, int i16) {
        if (bArr == null || bArr.length == 0 || bArr.length < i3 + i16) {
            return -2;
        }
        OutputStream outputStream = null;
        try {
            try {
                outputStream = d(str, true);
                outputStream.write(bArr, i3, i16);
                return 0;
            } catch (Exception e16) {
                com.tencent.luggage.wxa.yp.b.b("MicroMsg.VFSFileOp", e16, "");
                com.tencent.luggage.wxa.yp.b.d("MicroMsg.VFSFileOp", "file op appendToFile e type:%s, e msg:%s, fileName:%s, buf len:%d, bufOffset:%d, writeLen:%d", e16.getClass().getSimpleName(), e16.getMessage(), str, Integer.valueOf(bArr.length), Integer.valueOf(i3), Integer.valueOf(i16));
                c0.a(outputStream);
                return -1;
            }
        } finally {
            c0.a(outputStream);
        }
    }

    public static boolean b(String str) {
        return a(str, true);
    }

    public static long a(String str, String str2) {
        return a(str, str2, false);
    }

    public static long a(String str, String str2, boolean z16) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0 || str.equals(str2)) {
            return -1L;
        }
        l.h a16 = l.d().a(b0.b(str));
        l.h a17 = l.d().a(b0.b(str2));
        if (a16.a() && a17.a()) {
            try {
                return a17.f123799a.a(a17.f123800b, a16.f123799a, a16.f123800b, z16);
            } catch (IOException e16) {
                com.tencent.luggage.wxa.yp.b.e("MicroMsg.VFSFileOp", "Failed to copy file " + str + " -> " + str2 + MsgSummary.STR_COLON + e16.getMessage());
            }
        }
        return -1L;
    }

    public static boolean a(String str, boolean z16) {
        if (str == null || str.length() == 0) {
            return false;
        }
        l.h a16 = l.d().a(b0.b(str));
        if (a16.a()) {
            return a16.f123799a.b(a16.f123800b, z16);
        }
        return false;
    }

    public static boolean a(String str) {
        try {
            v vVar = new v(str);
            if (!vVar.e()) {
                if (!vVar.c()) {
                    return false;
                }
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }
}
