package jz3;

import android.text.TextUtils;
import com.tencent.rdelivery.reshub.util.m;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.zip.CRC32;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes25.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f411255a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b, reason: collision with root package name */
    private static long f411256b = 200;

    /* renamed from: c, reason: collision with root package name */
    private static WeakHashMap<String, ReadWriteLock> f411257c = new WeakHashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class a extends com.tencent.rdelivery.reshub.util.zip.b {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ File f411258d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f411259e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(long j3, long j16, File file, boolean z16) {
            super(j3, j16);
            this.f411258d = file;
            this.f411259e = z16;
        }

        @Override // com.tencent.rdelivery.reshub.util.zip.b
        public void b(com.tencent.rdelivery.reshub.util.zip.e eVar, File file) {
            if (file.equals(this.f411258d) && !this.f411259e) {
                return;
            }
            file.delete();
        }
    }

    public static boolean a(String str, String str2) {
        String str3;
        boolean z16 = false;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        long h16 = h(new File(str));
        String str4 = null;
        if (h16 > 0) {
            try {
                str4 = String.format("%08x", Long.valueOf(h16));
            } catch (Exception e16) {
                d.d("FileUtil", "checkCrc32Equal format exception ", e16);
            }
            z16 = m.c(str4, str2);
            if (!z16) {
                str4 = Long.toHexString(h16);
                z16 = m.c(str4, str2);
            }
        }
        if (!z16) {
            String str5 = " FilePath: " + str;
            File file = new File(str);
            if (!file.exists()) {
                str3 = str5 + " (File Not Exist)";
            } else if (file.isDirectory()) {
                str3 = str5 + " (File is Directory)";
            } else {
                str3 = str5 + " FileSize: " + file.length();
            }
            d.c("FileUtil", "File Crc32 Compare Fail! Expect: " + str2 + " Actual: " + str4 + str3);
        }
        d.a("FileUtil", "checkCrc32Equal, isEquals = " + z16 + ",filePath = " + str + ",targetCrc32HexStr = " + str2);
        return z16;
    }

    public static boolean b(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2)) {
            return a(str, str2);
        }
        return c(str, str3);
    }

    public static boolean c(String str, String str2) {
        String str3;
        String l3 = l(str);
        boolean c16 = m.c(l3, str2);
        if (!c16) {
            String str4 = " FilePath: " + str;
            File file = new File(str);
            if (!file.exists()) {
                str3 = str4 + " (File Not Exist)";
            } else if (file.isDirectory()) {
                str3 = str4 + " (File is Directory)";
            } else {
                str3 = str4 + " FileSize: " + file.length();
            }
            d.c("FileUtil", "checkMd5Equal,File MD5 Compare Fail! Expect: " + str2 + " Actual: " + l3 + str3);
        }
        d.a("FileUtil", "checkMd5Equal, isEquals = " + c16 + ",filePath = " + str + ",targetMd5 = " + str2);
        return c16;
    }

    public static void d(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
    }

    public static boolean e(File file, File file2) {
        BufferedInputStream bufferedInputStream;
        BufferedOutputStream bufferedOutputStream = null;
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
            try {
                try {
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file2));
                    try {
                        byte[] bArr = new byte[256];
                        while (true) {
                            int read = bufferedInputStream.read(bArr);
                            if (read != -1) {
                                bufferedOutputStream2.write(bArr, 0, read);
                            } else {
                                bufferedOutputStream2.flush();
                                try {
                                    bufferedOutputStream2.close();
                                    bufferedInputStream.close();
                                    return true;
                                } catch (IOException e16) {
                                    d.d("FileUtil", "File Copy Exception.", e16);
                                    return false;
                                }
                            }
                        }
                    } catch (IOException e17) {
                        e = e17;
                        bufferedOutputStream = bufferedOutputStream2;
                        d.d("FileUtil", "File Copy Exception.", e);
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e18) {
                                d.d("FileUtil", "File Copy Exception.", e18);
                                return false;
                            }
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        return false;
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedOutputStream = bufferedOutputStream2;
                        if (bufferedOutputStream != null) {
                            try {
                                bufferedOutputStream.close();
                            } catch (IOException e19) {
                                d.d("FileUtil", "File Copy Exception.", e19);
                                return false;
                            }
                        }
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (IOException e26) {
                e = e26;
            }
        } catch (IOException e27) {
            e = e27;
            bufferedInputStream = null;
        } catch (Throwable th7) {
            th = th7;
            bufferedInputStream = null;
        }
    }

    public static void f(File file, boolean z16) {
        if (!file.exists()) {
            return;
        }
        String absolutePath = file.getAbsolutePath();
        if (!absolutePath.isEmpty() && !absolutePath.equals(File.separator)) {
            com.tencent.rdelivery.reshub.util.zip.a aVar = new com.tencent.rdelivery.reshub.util.zip.a();
            aVar.b(false);
            try {
                aVar.c(file, true, new a(f411256b, 200L, file, z16));
                return;
            } catch (Exception e16) {
                d.b("FileUtil", "Delete File Exception: " + absolutePath, e16);
                return;
            }
        }
        d.c("FileUtil", "Cannot Delete Root Path.");
    }

    public static void g(String str, boolean z16) {
        if (!str.isEmpty() && !str.equals(File.separator)) {
            f(new File(str), z16);
        } else {
            d.c("FileUtil", "Cannot Delete Root Path.");
        }
    }

    public static long h(File file) {
        if (file == null || !file.exists()) {
            return -1L;
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    long i3 = i(fileInputStream2);
                    d(fileInputStream2);
                    return i3;
                } catch (Exception e16) {
                    e = e16;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    d(fileInputStream);
                    return -1L;
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = fileInputStream2;
                    d(fileInputStream);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    public static long i(InputStream inputStream) throws Exception {
        byte[] bArr = new byte[8192];
        CRC32 crc32 = new CRC32();
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                crc32.update(bArr, 0, read);
            } else {
                return crc32.getValue();
            }
        }
    }

    public static ReadWriteLock j(String str) {
        synchronized (f411257c) {
            try {
                if (str != null) {
                    ReadWriteLock readWriteLock = f411257c.get(str);
                    if (readWriteLock != null) {
                        return readWriteLock;
                    }
                    ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
                    f411257c.put(str, reentrantReadWriteLock);
                    return reentrantReadWriteLock;
                }
                throw new NullPointerException("can not lock a null file");
            } catch (Throwable th5) {
                throw th5;
            }
        }
    }

    /* JADX WARN: Not initialized variable reg: 5, insn: 0x00c7: MOVE (r1 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:200), block:B:56:0x00c7 */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String k(File file) {
        FileInputStream fileInputStream;
        MessageDigest messageDigest;
        FileInputStream fileInputStream2;
        boolean z16;
        FileInputStream fileInputStream3 = null;
        if (file == null) {
            d.c("FileUtil", "getFileMD5 return for null file");
            return null;
        }
        if (!file.isFile()) {
            d.c("FileUtil", "getFileMD5 return for not file,length = " + file.length() + ",exist = " + file.exists() + ",isDir = " + file.isDirectory() + ",path = " + file.getAbsolutePath());
            return null;
        }
        byte[] bArr = new byte[1024];
        try {
            try {
                try {
                    messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                    try {
                        fileInputStream2 = new FileInputStream(file);
                        while (true) {
                            z16 = false;
                            try {
                                int read = fileInputStream2.read(bArr, 0, 1024);
                                if (read != -1) {
                                    messageDigest.update(bArr, 0, read);
                                } else {
                                    try {
                                        break;
                                    } catch (IOException e16) {
                                        e16.printStackTrace();
                                    }
                                }
                            } catch (Exception e17) {
                                e = e17;
                                d.d("FileUtil", "File(" + file.getAbsolutePath() + ") MD5 Exception: " + e.getMessage(), e);
                                if (fileInputStream2 != null) {
                                    try {
                                        fileInputStream2.close();
                                    } catch (IOException e18) {
                                        e18.printStackTrace();
                                    }
                                }
                                z16 = true;
                                if (!z16) {
                                }
                            }
                        }
                        fileInputStream2.close();
                    } catch (Exception e19) {
                        e = e19;
                        fileInputStream2 = null;
                    }
                } catch (Throwable th5) {
                    th = th5;
                    if (fileInputStream3 != null) {
                        try {
                            fileInputStream3.close();
                        } catch (IOException e26) {
                            e26.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e27) {
                e = e27;
                messageDigest = null;
                fileInputStream2 = null;
            }
            if (!z16) {
                d.c("FileUtil", "getFileMD5 return for error");
                return null;
            }
            return q(messageDigest.digest());
        } catch (Throwable th6) {
            th = th6;
            fileInputStream3 = fileInputStream;
        }
    }

    public static String l(String str) {
        if (str != null && !str.isEmpty()) {
            return k(new File(str));
        }
        d.c("FileUtil", "getMd5ByFile return null, filePath = " + str);
        return null;
    }

    private static synchronized void m(File file) throws IOException {
        synchronized (c.class) {
            if (file.exists()) {
                if (file.isDirectory()) {
                    return;
                }
                if (!file.delete()) {
                    throw new IOException(file.getAbsolutePath());
                }
            }
            if (!file.mkdirs() && !file.isDirectory()) {
                throw new IOException(file.getAbsolutePath());
            }
        }
    }

    public static synchronized File n(String str) throws IOException {
        File file;
        synchronized (c.class) {
            file = new File(str);
            if (!file.exists()) {
                m(file.getParentFile());
                file.createNewFile();
            }
        }
        return file;
    }

    public static synchronized File o(String str) throws IOException {
        File file;
        synchronized (c.class) {
            file = new File(str);
            f(file, true);
            n(str);
        }
        return file;
    }

    public static void p(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static String q(byte[] bArr) {
        int length = bArr.length;
        StringBuilder sb5 = new StringBuilder(length * 2);
        for (int i3 = 0; i3 < length; i3++) {
            char[] cArr = f411255a;
            sb5.append(cArr[(bArr[i3] & 240) >>> 4]);
            sb5.append(cArr[bArr[i3] & RegisterType.DOUBLE_HI]);
        }
        return sb5.toString();
    }
}
