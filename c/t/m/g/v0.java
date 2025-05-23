package c.t.m.g;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/* compiled from: P */
/* loaded from: classes.dex */
public class v0 {
    @Deprecated
    public static void a(Closeable closeable) {
        a1.a(closeable);
    }

    public static byte[] a(File file) {
        byte[] bArr;
        if (file.exists() && file.length() != 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] a16 = j0.a().a(2048);
            BufferedInputStream bufferedInputStream = null;
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                while (true) {
                    try {
                        int read = bufferedInputStream2.read(a16);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(a16, 0, read);
                    } catch (Throwable th5) {
                        th = th5;
                        bufferedInputStream = bufferedInputStream2;
                        try {
                            c1.a("FileUtil", "toByteArray error.", th);
                            bArr = k0.f29815a;
                            j0.a().a(a16);
                            a1.a(bufferedInputStream);
                            a1.a(byteArrayOutputStream);
                            return bArr;
                        } catch (Throwable th6) {
                            j0.a().a(a16);
                            a1.a(bufferedInputStream);
                            a1.a(byteArrayOutputStream);
                            throw th6;
                        }
                    }
                }
                bArr = byteArrayOutputStream.toByteArray();
                j0.a().a(a16);
                a1.a(bufferedInputStream2);
            } catch (Throwable th7) {
                th = th7;
            }
            a1.a(byteArrayOutputStream);
            return bArr;
        }
        return k0.f29815a;
    }

    public static boolean a(File file, byte[] bArr, boolean z16) {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(file, z16);
            try {
                fileOutputStream2.write(bArr);
                a1.a(fileOutputStream2);
                return true;
            } catch (Throwable th5) {
                th = th5;
                fileOutputStream = fileOutputStream2;
                try {
                    c1.a("FileUtil", "byteArrayToFile error.", th);
                    a1.a(fileOutputStream);
                    return false;
                } catch (Throwable th6) {
                    a1.a(fileOutputStream);
                    throw th6;
                }
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }
}
