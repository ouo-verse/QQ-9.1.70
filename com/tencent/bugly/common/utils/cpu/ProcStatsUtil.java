package com.tencent.bugly.common.utils.cpu;

import android.os.StrictMode;
import com.tencent.rmonitor.common.logger.Logger;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class ProcStatsUtil {
    private static final boolean DEBUG = false;
    private static final int READ_SIZE = 1024;
    private static final String TAG = "ProcStatsUtil";

    ProcStatsUtil() {
    }

    public static String readNullSeparatedFile(String str) {
        String readSingleLineProcFile = readSingleLineProcFile(str);
        if (readSingleLineProcFile == null) {
            return null;
        }
        int indexOf = readSingleLineProcFile.indexOf("\u0000\u0000");
        if (indexOf != -1) {
            readSingleLineProcFile = readSingleLineProcFile.substring(0, indexOf);
        }
        return readSingleLineProcFile.replace("\u0000", " ");
    }

    public static String readSingleLineProcFile(String str) {
        return readTerminatedProcFile(str, (byte) 10);
    }

    public static String readTerminatedProcFile(String str, byte b16) {
        boolean z16;
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = null;
                do {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    int i3 = 0;
                    while (true) {
                        if (i3 < read) {
                            if (bArr[i3] == b16) {
                                break;
                            }
                            i3++;
                        } else {
                            i3 = -1;
                            break;
                        }
                    }
                    if (i3 != -1) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16 && byteArrayOutputStream == null) {
                        String str2 = new String(bArr, 0, i3);
                        fileInputStream.close();
                        return str2;
                    }
                    if (byteArrayOutputStream == null) {
                        byteArrayOutputStream = new ByteArrayOutputStream(1024);
                    }
                    if (z16) {
                        read = i3;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                } while (!z16);
                if (byteArrayOutputStream == null) {
                    fileInputStream.close();
                    return "";
                }
                String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                fileInputStream.close();
                return byteArrayOutputStream2;
            } catch (Throwable th5) {
                try {
                    throw th5;
                } catch (Throwable th6) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th7) {
                        th5.addSuppressed(th7);
                    }
                    throw th6;
                }
            }
        } catch (IOException e16) {
            Logger.f365497g.b(TAG, "Failed to open proc file", e16);
            return null;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }
}
