package m51;

import androidx.annotation.Nullable;
import com.tencent.minibox.common.log.LogUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

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

    public static boolean b(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read != -1) {
                            fileOutputStream2.write(bArr, 0, read);
                        } else {
                            fileOutputStream2.flush();
                            a(inputStream);
                            a(fileOutputStream2);
                            return true;
                        }
                    }
                } catch (Exception e16) {
                    e = e16;
                    fileOutputStream = fileOutputStream2;
                    LogUtils.e("FileUtil", "copyFile: exception.", e);
                    a(inputStream);
                    a(fileOutputStream);
                    return false;
                } catch (Throwable th5) {
                    th = th5;
                    fileOutputStream = fileOutputStream2;
                    a(inputStream);
                    a(fileOutputStream);
                    throw th;
                }
            } catch (Exception e17) {
                e = e17;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    @Nullable
    public static File c(String str) {
        File file = new File(str);
        if (!file.exists()) {
            try {
                if (file.getParentFile() != null && !file.getParentFile().exists()) {
                    if (file.getParentFile().mkdirs()) {
                        file.createNewFile();
                    }
                } else {
                    file.createNewFile();
                }
            } catch (Throwable unused) {
                return null;
            }
        }
        return file;
    }

    public static void d(String str) {
        e(new File(str));
    }

    public static void e(File file) {
        File[] listFiles;
        if (file != null && file.exists()) {
            if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    e(file2);
                }
            }
            if (!file.delete()) {
                LogUtils.e("FileUtil", "deleteFile failed, file=" + file.getAbsolutePath());
            }
        }
    }

    public static long f(File file) {
        File[] listFiles;
        long j3 = 0;
        if (file != null && file.exists()) {
            if (file.isFile()) {
                return file.length();
            }
            if (file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    j3 += f(file2);
                }
            }
        }
        return j3;
    }
}
