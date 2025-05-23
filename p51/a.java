package p51;

import com.tencent.minibox.common.log.LogUtils;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;
import java.util.zip.ZipFile;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
    }

    public static void c(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
    }

    public static long d(File file) {
        if (file == null || !file.exists()) {
            return -1L;
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    long e16 = e(fileInputStream2);
                    b(fileInputStream2);
                    return e16;
                } catch (Exception e17) {
                    e = e17;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    b(fileInputStream);
                    return -1L;
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = fileInputStream2;
                    b(fileInputStream);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e18) {
            e = e18;
        }
    }

    public static long e(InputStream inputStream) throws Exception {
        long currentTimeMillis = System.currentTimeMillis();
        int available = inputStream.available();
        byte[] bArr = new byte[8192];
        CRC32 crc32 = new CRC32();
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                crc32.update(bArr, 0, read);
            } else {
                long value = crc32.getValue();
                LogUtils.d(IOUtil.TAG, "getCRC32Value fileTotalSize = " + available + " takeTime = " + (System.currentTimeMillis() - currentTimeMillis));
                return value;
            }
        }
    }
}
