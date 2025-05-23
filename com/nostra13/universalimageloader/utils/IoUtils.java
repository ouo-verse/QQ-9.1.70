package com.nostra13.universalimageloader.utils;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class IoUtils {
    public static final int CONTINUE_LOADING_PERCENTAGE = 75;
    public static final int DEFAULT_BUFFER_SIZE = 32768;
    public static final int DEFAULT_IMAGE_TOTAL_SIZE = 512000;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface CopyListener {
        boolean onBytesCopied(int i3, int i16);
    }

    IoUtils() {
    }

    public static void closeSilently(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static boolean copyStream(InputStream inputStream, OutputStream outputStream, CopyListener copyListener) throws IOException {
        return copyStream(inputStream, outputStream, copyListener, 32768);
    }

    public static void readAndCloseStream(InputStream inputStream) {
        do {
            try {
            } catch (IOException unused) {
            } catch (Throwable th5) {
                closeSilently(inputStream);
                throw th5;
            }
        } while (inputStream.read(new byte[32768], 0, 32768) != -1);
        closeSilently(inputStream);
    }

    private static boolean shouldStopLoading(CopyListener copyListener, int i3, int i16) {
        if (copyListener != null && !copyListener.onBytesCopied(i3, i16) && (i3 * 100) / i16 < 75) {
            return true;
        }
        return false;
    }

    public static boolean copyStream(InputStream inputStream, OutputStream outputStream, CopyListener copyListener, int i3) throws IOException {
        int available = inputStream.available();
        if (available <= 0) {
            available = DEFAULT_IMAGE_TOTAL_SIZE;
        }
        byte[] bArr = new byte[i3];
        if (shouldStopLoading(copyListener, 0, available)) {
            return false;
        }
        int i16 = 0;
        do {
            int read = inputStream.read(bArr, 0, i3);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                i16 += read;
            } else {
                outputStream.flush();
                return true;
            }
        } while (!shouldStopLoading(copyListener, i16, available));
        return false;
    }
}
