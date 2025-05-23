package ga3;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes21.dex */
public class l {

    /* compiled from: P */
    /* loaded from: classes21.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        static final SecureRandom f401632a = new SecureRandom();

        /* renamed from: b, reason: collision with root package name */
        static final char[] f401633b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(int[] iArr, int i3) {
        int length = (iArr.length >> 1) - 1;
        int i16 = 0;
        while (i16 <= length) {
            int i17 = (i16 + length) >>> 1;
            int i18 = iArr[i17 << 1];
            if (i18 < i3) {
                i16 = i17 + 1;
            } else if (i18 > i3) {
                length = i17 - 1;
            } else {
                return i17;
            }
        }
        return length;
    }

    private static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(File file) {
        try {
            if (file.exists()) {
                d(file);
            }
        } catch (Exception unused) {
        }
    }

    private static void d(File file) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                d(file2);
            }
        }
        file.delete();
    }

    public static byte[] e(File file) throws IOException {
        if (!file.isFile()) {
            return null;
        }
        long length = file.length();
        if ((length >> 32) == 0) {
            int i3 = (int) length;
            byte[] bArr = new byte[i3];
            i(file, bArr, i3);
            return bArr;
        }
        throw new IllegalArgumentException("file too large, path:" + file.getPath());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            Method declaredMethod = cls.getDeclaredMethod("pageSize", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Integer) declaredMethod.invoke(declaredField.get(null), new Object[0])).intValue();
        } catch (Throwable unused) {
            return 4096;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean g(File file) throws IOException {
        if (file.isFile()) {
            return true;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && ((parentFile.isDirectory() || parentFile.mkdirs()) && file.createNewFile())) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String h() {
        byte[] bArr = new byte[16];
        a.f401632a.nextBytes(bArr);
        char[] cArr = new char[32];
        for (int i3 = 0; i3 < 16; i3++) {
            byte b16 = bArr[i3];
            int i16 = i3 << 1;
            char[] cArr2 = a.f401633b;
            cArr[i16] = cArr2[(b16 >> 4) & 15];
            cArr[i16 + 1] = cArr2[b16 & RegisterType.DOUBLE_HI];
        }
        return new String(cArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(File file, byte[] bArr, int i3) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        int i16 = 0;
        while (i16 < i3) {
            try {
                int read = randomAccessFile.read(bArr, i16, i3 - i16);
                if (read < 0) {
                    break;
                } else {
                    i16 += read;
                }
            } finally {
                b(randomAccessFile);
            }
        }
    }

    public static boolean j(File file, byte[] bArr) {
        File file2;
        try {
            file2 = new File(file.getParent(), file.getName() + ".tmp");
        } catch (Exception e16) {
            w53.b.d("WinkRequestETagUtils", "Save Bytes exception", e16);
        }
        if (!g(file2)) {
            return false;
        }
        RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
        try {
            randomAccessFile.setLength(bArr.length);
            randomAccessFile.write(bArr);
            b(randomAccessFile);
            if (!file.exists() || file.delete()) {
                return file2.renameTo(file);
            }
            return false;
        } catch (Throwable th5) {
            b(randomAccessFile);
            throw th5;
        }
    }
}
