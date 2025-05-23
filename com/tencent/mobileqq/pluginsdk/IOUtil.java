package com.tencent.mobileqq.pluginsdk;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.CRC32;
import java.util.zip.ZipFile;

/* compiled from: P */
/* loaded from: classes16.dex */
public class IOUtil {
    static IPatchRedirector $redirector_ = null;
    public static final long CRC32_VALUE_INVALID = -1;
    public static final String TAG = "IOUtil";

    public IOUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void closeStream(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
    }

    public static void closeZipFile(ZipFile zipFile) {
        if (zipFile != null) {
            try {
                zipFile.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
        }
    }

    public static boolean contentEquals(InputStream inputStream, InputStream inputStream2) throws IOException {
        if (!(inputStream instanceof BufferedInputStream)) {
            inputStream = new BufferedInputStream(inputStream);
        }
        if (!(inputStream2 instanceof BufferedInputStream)) {
            inputStream2 = new BufferedInputStream(inputStream2);
        }
        for (int read = inputStream.read(); -1 != read; read = inputStream.read()) {
            if (read != inputStream2.read()) {
                return false;
            }
        }
        return inputStream2.read() == -1;
    }

    public static long getCRC32Value(File file) {
        if (file == null || !file.exists()) {
            return -1L;
        }
        FileInputStream fileInputStream = null;
        try {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(file);
                try {
                    long cRC32Value = getCRC32Value(fileInputStream2);
                    closeStream(fileInputStream2);
                    return cRC32Value;
                } catch (Exception e16) {
                    e = e16;
                    fileInputStream = fileInputStream2;
                    e.printStackTrace();
                    closeStream(fileInputStream);
                    return -1L;
                } catch (Throwable th5) {
                    th = th5;
                    fileInputStream = fileInputStream2;
                    closeStream(fileInputStream);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [boolean] */
    public static byte[] readByte(String str) {
        FileInputStream fileInputStream;
        Closeable closeable = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        ?? exists = file.exists();
        try {
            if (exists == 0) {
                return null;
            }
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Exception e16) {
                e = e16;
                fileInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                closeStream(closeable);
                throw th;
            }
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                closeStream(fileInputStream);
                return bArr;
            } catch (Exception e17) {
                e = e17;
                e.printStackTrace();
                closeStream(fileInputStream);
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            closeable = exists;
        }
    }

    public static long getCRC32Value(InputStream inputStream) throws Exception {
        System.currentTimeMillis();
        inputStream.available();
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

    public static boolean contentEquals(File file, String str) {
        ByteArrayInputStream byteArrayInputStream;
        if (file == null || !file.exists() || str == null) {
            return false;
        }
        FileInputStream fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
                try {
                    boolean contentEquals = contentEquals(fileInputStream2, byteArrayInputStream);
                    closeStream(fileInputStream2);
                    closeStream(byteArrayInputStream);
                    return contentEquals;
                } catch (Exception e16) {
                    e = e16;
                    fileInputStream = fileInputStream2;
                    try {
                        e.printStackTrace();
                        closeStream(fileInputStream);
                        closeStream(byteArrayInputStream);
                        return false;
                    } catch (Throwable th5) {
                        th = th5;
                        closeStream(fileInputStream);
                        closeStream(byteArrayInputStream);
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    fileInputStream = fileInputStream2;
                    closeStream(fileInputStream);
                    closeStream(byteArrayInputStream);
                    throw th;
                }
            } catch (Exception e17) {
                e = e17;
                byteArrayInputStream = null;
            } catch (Throwable th7) {
                th = th7;
                byteArrayInputStream = null;
            }
        } catch (Exception e18) {
            e = e18;
            byteArrayInputStream = null;
        } catch (Throwable th8) {
            th = th8;
            byteArrayInputStream = null;
        }
    }
}
