package org.apache.commons.fileupload.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.fileupload.InvalidFileNameException;
import org.apache.commons.io.IOUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Streams {
    private static final int DEFAULT_BUFFER_SIZE = 8192;

    Streams() {
    }

    public static String asString(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream, true);
        return byteArrayOutputStream.toString();
    }

    public static String checkFileName(String str) {
        if (str != null) {
            if (str.indexOf(0) != -1) {
                StringBuilder sb5 = new StringBuilder();
                for (int i3 = 0; i3 < str.length(); i3++) {
                    char charAt = str.charAt(i3);
                    if (charAt != 0) {
                        sb5.append(charAt);
                    } else {
                        sb5.append("\\0");
                    }
                }
                throw new InvalidFileNameException(str, "Invalid file name: " + ((Object) sb5));
            }
        }
        return str;
    }

    public static long copy(InputStream inputStream, OutputStream outputStream, boolean z16) throws IOException {
        return copy(inputStream, outputStream, z16, new byte[8192]);
    }

    public static long copy(InputStream inputStream, OutputStream outputStream, boolean z16, byte[] bArr) throws IOException {
        long j3 = 0;
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                if (read > 0) {
                    j3 += read;
                    if (outputStream != null) {
                        outputStream.write(bArr, 0, read);
                    }
                }
            } catch (Throwable th5) {
                IOUtils.closeQuietly(inputStream);
                if (z16) {
                    IOUtils.closeQuietly(outputStream);
                }
                throw th5;
            }
        }
        if (outputStream != null) {
            if (z16) {
                outputStream.close();
            } else {
                outputStream.flush();
            }
            outputStream = null;
        }
        inputStream.close();
        IOUtils.closeQuietly((InputStream) null);
        if (z16) {
            IOUtils.closeQuietly(outputStream);
        }
        return j3;
    }

    public static String asString(InputStream inputStream, String str) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copy(inputStream, byteArrayOutputStream, true);
        return byteArrayOutputStream.toString(str);
    }
}
