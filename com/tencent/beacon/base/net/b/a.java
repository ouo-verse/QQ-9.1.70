package com.tencent.beacon.base.net.b;

import com.tencent.beacon.a.b.i;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class a {
    public static byte[] a(int i3, byte[] bArr) throws Exception {
        if (i3 == 1) {
            return d(bArr);
        }
        if (i3 == 2) {
            return a(bArr);
        }
        return null;
    }

    public static byte[] b(int i3, byte[] bArr) throws Exception {
        if (i3 == 1) {
            return c(bArr);
        }
        if (i3 == 2) {
            return b(bArr);
        }
        return null;
    }

    private static byte[] c(byte[] bArr) throws Exception {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        ZipInputStream zipInputStream = new ZipInputStream(byteArrayInputStream);
        byte[] bArr2 = null;
        while (zipInputStream.getNextEntry() != null) {
            byte[] bArr3 = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = zipInputStream.read(bArr3, 0, 1024);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr3, 0, read);
                }
            }
            bArr2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
        }
        zipInputStream.close();
        byteArrayInputStream.close();
        return bArr2;
    }

    private static byte[] d(byte[] bArr) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
        ZipEntry zipEntry = new ZipEntry("zip");
        zipEntry.setSize(bArr.length);
        zipOutputStream.putNextEntry(zipEntry);
        zipOutputStream.write(bArr);
        zipOutputStream.closeEntry();
        zipOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return byteArray;
    }

    private static byte[] a(byte[] bArr) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.finish();
        gZIPOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return byteArray;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009a  */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static byte[] b(byte[] bArr) throws Exception {
        ByteArrayInputStream byteArrayInputStream;
        GZIPInputStream gZIPInputStream;
        Exception exc;
        Exception exc2;
        byte[] bArr2;
        ByteArrayOutputStream byteArrayOutputStream = null;
        byte[] bArr3 = null;
        byteArrayOutputStream = null;
        byteArrayOutputStream = null;
        byteArrayOutputStream = null;
        byteArrayOutputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
        } catch (Exception e16) {
            exc = e16;
            byteArrayInputStream = null;
            gZIPInputStream = null;
        } catch (Throwable th5) {
            th = th5;
            byteArrayInputStream = null;
            gZIPInputStream = null;
        }
        try {
            gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            try {
                try {
                    byte[] bArr4 = new byte[1024];
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    while (true) {
                        try {
                            int read = gZIPInputStream.read(bArr4, 0, 1024);
                            if (read != -1) {
                                byteArrayOutputStream2.write(bArr4, 0, read);
                            } else {
                                bArr3 = byteArrayOutputStream2.toByteArray();
                                byteArrayOutputStream2.flush();
                                byteArrayOutputStream2.close();
                                gZIPInputStream.close();
                                byteArrayInputStream.close();
                                return bArr3;
                            }
                        } catch (Exception e17) {
                            exc2 = e17;
                            bArr2 = bArr3;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            i e18 = i.e();
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append("unzipData length: ");
                            sb5.append(bArr.length);
                            e18.a("509", sb5.toString(), exc2);
                            com.tencent.beacon.base.util.c.a(exc2);
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append("unGzip error ");
                            sb6.append(exc2.toString());
                            com.tencent.beacon.base.util.c.b(sb6.toString(), new Object[0]);
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            if (byteArrayInputStream != null) {
                                byteArrayInputStream.close();
                            }
                            return bArr2;
                        } catch (Throwable th6) {
                            th = th6;
                            byteArrayOutputStream = byteArrayOutputStream2;
                            if (byteArrayOutputStream != null) {
                                byteArrayOutputStream.close();
                            }
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            if (byteArrayInputStream != null) {
                                byteArrayInputStream.close();
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th7) {
                    th = th7;
                }
            } catch (Exception e19) {
                exc2 = e19;
                bArr2 = null;
            }
        } catch (Exception e26) {
            exc = e26;
            gZIPInputStream = null;
            exc2 = exc;
            bArr2 = gZIPInputStream;
            i e182 = i.e();
            StringBuilder sb52 = new StringBuilder();
            sb52.append("unzipData length: ");
            sb52.append(bArr.length);
            e182.a("509", sb52.toString(), exc2);
            com.tencent.beacon.base.util.c.a(exc2);
            StringBuilder sb62 = new StringBuilder();
            sb62.append("unGzip error ");
            sb62.append(exc2.toString());
            com.tencent.beacon.base.util.c.b(sb62.toString(), new Object[0]);
            if (byteArrayOutputStream != null) {
            }
            if (gZIPInputStream != null) {
            }
            if (byteArrayInputStream != null) {
            }
            return bArr2;
        } catch (Throwable th8) {
            th = th8;
            gZIPInputStream = null;
        }
    }
}
