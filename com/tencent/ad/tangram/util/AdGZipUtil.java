package com.tencent.ad.tangram.util;

import android.support.annotation.Nullable;
import com.tencent.ad.tangram.log.AdLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class AdGZipUtil {
    private static final String TAG = "AdZipUtil";

    @Nullable
    public static byte[] compress(@Nullable byte[] bArr) {
        GZIPOutputStream gZIPOutputStream;
        if (bArr != null && bArr.length != 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = null;
            try {
                try {
                    gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                } catch (Throwable th5) {
                    th = th5;
                    gZIPOutputStream = null;
                }
                try {
                    gZIPOutputStream.write(bArr);
                    gZIPOutputStream.finish();
                    bArr2 = byteArrayOutputStream.toByteArray();
                    gZIPOutputStream.close();
                    byteArrayOutputStream.close();
                } catch (Throwable th6) {
                    th = th6;
                    try {
                        AdLog.e(TAG, "compressByGzip exception", th);
                        if (gZIPOutputStream != null) {
                            gZIPOutputStream.close();
                        }
                        byteArrayOutputStream.close();
                        return bArr2;
                    } catch (Throwable th7) {
                        if (gZIPOutputStream != null) {
                            try {
                                gZIPOutputStream.close();
                            } catch (Throwable th8) {
                                AdLog.e(TAG, "compressByGzip exception", th8);
                                throw th7;
                            }
                        }
                        byteArrayOutputStream.close();
                        throw th7;
                    }
                }
            } catch (Throwable th9) {
                AdLog.e(TAG, "compressByGzip exception", th9);
            }
            return bArr2;
        }
        return bArr;
    }

    @Nullable
    public static byte[] decompress(@Nullable byte[] bArr) {
        GZIPInputStream gZIPInputStream;
        if (bArr != null && bArr.length != 0) {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = null;
            try {
                try {
                    gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                } catch (Throwable th5) {
                    th = th5;
                    gZIPInputStream = null;
                }
            } catch (Throwable th6) {
                AdLog.e(TAG, "compressByGzip", th6);
            }
            try {
                byte[] bArr3 = new byte[256];
                while (true) {
                    int read = gZIPInputStream.read(bArr3);
                    if (read < 0) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr3, 0, read);
                }
                byteArrayOutputStream.flush();
                bArr2 = byteArrayOutputStream.toByteArray();
                gZIPInputStream.close();
                byteArrayInputStream.close();
                byteArrayOutputStream.close();
            } catch (Throwable th7) {
                th = th7;
                try {
                    AdLog.e(TAG, "decompressByGzip", th);
                    if (gZIPInputStream != null) {
                        gZIPInputStream.close();
                    }
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                    return bArr2;
                } catch (Throwable th8) {
                    if (gZIPInputStream != null) {
                        try {
                            gZIPInputStream.close();
                        } catch (Throwable th9) {
                            AdLog.e(TAG, "compressByGzip", th9);
                            throw th8;
                        }
                    }
                    byteArrayInputStream.close();
                    byteArrayOutputStream.close();
                    throw th8;
                }
            }
            return bArr2;
        }
        return bArr;
    }
}
