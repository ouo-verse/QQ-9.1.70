package com.tencent.luggage.wxa.tk;

import android.content.res.AssetFileDescriptor;
import android.webkit.URLUtil;
import androidx.arch.core.util.Function;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.tn.z;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static Function f141493a;

    public static String a(AssetFileDescriptor assetFileDescriptor) {
        if (assetFileDescriptor == null) {
            return "";
        }
        try {
            FileInputStream createInputStream = assetFileDescriptor.createInputStream();
            try {
                String b16 = b(createInputStream);
                if (createInputStream != null) {
                    createInputStream.close();
                }
                return b16;
            } finally {
            }
        } catch (IOException e16) {
            w.b("MicroMsg.AppBrandIOUtil", "openReadFdAsString(%s) createInputStream get exception %s", assetFileDescriptor, e16);
            return "";
        }
    }

    public static Function b() {
        return f141493a;
    }

    public static boolean c(String str) {
        if (!w0.c(str) && (URLUtil.isHttpsUrl(str) || URLUtil.isHttpUrl(str))) {
            return true;
        }
        return false;
    }

    public static String b(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        char[] cArr = new char[16384];
        StringWriter stringWriter = new StringWriter();
        while (true) {
            try {
                try {
                    int read = inputStreamReader.read(cArr);
                    if (-1 != read) {
                        stringWriter.write(cArr, 0, read);
                    } else {
                        w0.a((Closeable) inputStreamReader);
                        w0.a((Closeable) inputStream);
                        return stringWriter.toString();
                    }
                } catch (Exception e16) {
                    w.b("MicroMsg.AppBrandIOUtil", "convertStreamToString: read, %s", e16.getMessage());
                    w0.a((Closeable) inputStreamReader);
                    w0.a((Closeable) inputStream);
                    return "";
                }
            } catch (Throwable th5) {
                w0.a((Closeable) inputStreamReader);
                w0.a((Closeable) inputStream);
                throw th5;
            }
        }
    }

    public static byte[] a(String str) {
        InputStream inputStream;
        try {
            inputStream = z.b().open(str);
        } catch (Exception e16) {
            w.b("MicroMsg.AppBrandIOUtil", "openRead file( %s ) failed, exp = %s", str, w0.a((Throwable) e16));
            inputStream = null;
        }
        return inputStream == null ? new byte[0] : a(inputStream);
    }

    public static byte[] a(InputStream inputStream, long j3, long j16) {
        int read;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        try {
            try {
                int available = inputStream.available();
                if (available < 0) {
                    byte[] bArr2 = new byte[0];
                    try {
                        inputStream.close();
                    } catch (Exception e16) {
                        w.b("MicroMsg.AppBrandIOUtil", "convertStreamToByteArray close: " + e16);
                    }
                    return bArr2;
                }
                if ((j3 + j16) - 1 > available - 1) {
                    byte[] bArr3 = new byte[0];
                    try {
                        inputStream.close();
                    } catch (Exception e17) {
                        w.b("MicroMsg.AppBrandIOUtil", "convertStreamToByteArray close: " + e17);
                    }
                    return bArr3;
                }
                long j17 = available;
                if (j16 < 0) {
                    j16 = j17;
                }
                inputStream.skip(j3);
                int i3 = 0;
                while (true) {
                    long j18 = i3;
                    if (j18 >= j16 || (read = inputStream.read(bArr, 0, 16384)) == -1) {
                        break;
                    }
                    int min = (int) Math.min(read, j16 - j18);
                    byteArrayOutputStream.write(bArr, 0, min);
                    i3 += min;
                }
                byteArrayOutputStream.flush();
                try {
                    inputStream.close();
                } catch (Exception e18) {
                    w.b("MicroMsg.AppBrandIOUtil", "convertStreamToByteArray close: " + e18);
                }
                return byteArrayOutputStream.toByteArray();
            } catch (Exception e19) {
                w.b("MicroMsg.AppBrandIOUtil", "convertStreamToByteArray: " + e19);
                byte[] bArr4 = new byte[0];
                try {
                    inputStream.close();
                } catch (Exception e26) {
                    w.b("MicroMsg.AppBrandIOUtil", "convertStreamToByteArray close: " + e26);
                }
                return bArr4;
            }
        } catch (Throwable th5) {
            try {
                inputStream.close();
            } catch (Exception e27) {
                w.b("MicroMsg.AppBrandIOUtil", "convertStreamToByteArray close: " + e27);
            }
            throw th5;
        }
    }

    public static String b(String str) {
        InputStream inputStream;
        try {
            inputStream = z.b().open(str);
        } catch (Exception e16) {
            w.b("MicroMsg.AppBrandIOUtil", "openRead file( %s ) failed, exp = %s", str, w0.a((Throwable) e16));
            inputStream = null;
        }
        return inputStream == null ? "" : b(inputStream);
    }

    public static byte[] a(InputStream inputStream) {
        return a(inputStream, 0L, -1L);
    }

    public static byte[] a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return new byte[0];
        }
        if (!byteBuffer.isDirect()) {
            return byteBuffer.array();
        }
        int position = byteBuffer.position();
        byteBuffer.position(0);
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        byteBuffer.position(position);
        return bArr;
    }

    public static String a() {
        return com.tencent.luggage.wxa.db.a.e();
    }
}
