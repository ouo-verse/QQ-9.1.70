package com.tencent.biz.richframework.util;

import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFWIOUtil {
    public static void closeAll(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    public static byte[] convertInputStream2ByteArray(@NonNull InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static long copy(@NonNull InputStream inputStream, @NonNull OutputStream outputStream) {
        try {
            try {
                byte[] bArr = new byte[4096];
                long j3 = 0;
                while (true) {
                    int read = inputStream.read(bArr);
                    if (-1 != read) {
                        outputStream.write(bArr, 0, read);
                        j3 += read;
                    } else {
                        closeAll(inputStream, outputStream);
                        return j3;
                    }
                }
            } catch (Exception e16) {
                RFWLog.e("RFWIOUtil", RFWLog.USR, "[copy] ", e16);
                closeAll(inputStream, outputStream);
                return -1L;
            }
        } catch (Throwable th5) {
            closeAll(inputStream, outputStream);
            throw th5;
        }
    }

    public static void flushAll(Flushable... flushableArr) {
        if (flushableArr == null) {
            return;
        }
        for (Flushable flushable : flushableArr) {
            if (flushable != null) {
                try {
                    flushable.flush();
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }
}
