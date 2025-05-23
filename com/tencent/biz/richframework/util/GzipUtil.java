package com.tencent.biz.richframework.util;

import com.tencent.biz.richframework.delegate.impl.RFWLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: P */
/* loaded from: classes5.dex */
public class GzipUtil {
    public static byte[] gzipCompress(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        byte[] bArr2 = new byte[0];
        try {
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                gZIPOutputStream.write(bArr);
                RFWIOUtil.flushAll(gZIPOutputStream);
                RFWIOUtil.closeAll(gZIPOutputStream);
                bArr2 = byteArrayOutputStream.toByteArray();
                RFWIOUtil.closeAll(byteArrayOutputStream);
            } catch (IOException e16) {
                RFWLog.e("GzipUtil", RFWLog.USR, e16);
                RFWIOUtil.closeAll(byteArrayOutputStream);
            }
            return bArr2;
        } catch (Throwable th5) {
            RFWIOUtil.closeAll(byteArrayOutputStream);
            throw th5;
        }
    }

    public static byte[] gzipDecompress(byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length * 2);
        byte[] bArr2 = new byte[0];
        GZIPInputStream gZIPInputStream2 = null;
        try {
            gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            byte[] bArr3 = new byte[2048];
            while (true) {
                int read = gZIPInputStream.read(bArr3, 0, 2048);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr3, 0, read);
            }
            bArr2 = byteArrayOutputStream.toByteArray();
            RFWIOUtil.closeAll(gZIPInputStream);
            RFWIOUtil.closeAll(byteArrayOutputStream);
        } catch (Throwable th6) {
            th = th6;
            gZIPInputStream2 = gZIPInputStream;
            try {
                RFWLog.e("GzipUtil", RFWLog.USR, th);
                RFWIOUtil.closeAll(gZIPInputStream2);
                RFWIOUtil.closeAll(byteArrayOutputStream);
                return bArr2;
            } catch (Throwable th7) {
                RFWIOUtil.closeAll(gZIPInputStream2);
                RFWIOUtil.closeAll(byteArrayOutputStream);
                throw th7;
            }
        }
        return bArr2;
    }
}
