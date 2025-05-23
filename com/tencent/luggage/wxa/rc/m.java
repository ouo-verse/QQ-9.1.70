package com.tencent.luggage.wxa.rc;

import android.text.TextUtils;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.mm.plugin.appbrand.appstorage.FileStat;
import com.tencent.mm.plugin.appbrand.appstorage.FileStructStat;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class m {
    public static ByteBuffer a(com.tencent.luggage.wxa.cp.v vVar, long j3, long j16) {
        if (vVar != null && vVar.e() && vVar.q()) {
            int s16 = (int) vVar.s();
            if (s16 < 0) {
                return ByteBuffer.allocateDirect(0);
            }
            if ((j3 + j16) - 1 > s16 - 1) {
                return ByteBuffer.allocateDirect(0);
            }
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(s16);
            long j17 = s16;
            if (j16 < 0) {
                j16 = j17;
            }
            try {
                RandomAccessFile c16 = com.tencent.luggage.wxa.cp.x.c(vVar.g(), false);
                try {
                    c16.getChannel().read(allocateDirect);
                    allocateDirect.flip();
                    if (j3 == 0 && j16 == j17) {
                        c16.close();
                        return allocateDirect;
                    }
                    int i3 = (int) j16;
                    byte[] bArr = new byte[i3];
                    allocateDirect.position((int) j3);
                    allocateDirect.get(bArr, 0, i3);
                    ByteBuffer wrap = ByteBuffer.wrap(bArr);
                    c16.close();
                    return wrap;
                } finally {
                }
            } catch (IOException e16) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.FileSystemUtil[ZIP]", e16, "readAsDirectByteBuffer", new Object[0]);
                com.tencent.luggage.wxa.h6.a.a(allocateDirect);
                return ByteBuffer.allocateDirect(0);
            } catch (BufferOverflowException unused) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrand.FileSystemUtil[ZIP]", "BufferOverflow, file_length %d, byte_allocated %d", Long.valueOf(vVar.s()), Integer.valueOf(allocateDirect.capacity()));
                com.tencent.luggage.wxa.h6.a.a(allocateDirect);
                return ByteBuffer.allocateDirect(0);
            }
        }
        return ByteBuffer.allocateDirect(0);
    }

    public static long b(com.tencent.luggage.wxa.cp.v vVar) {
        long b16;
        if (vVar == null) {
            return -1L;
        }
        com.tencent.luggage.wxa.cp.v[] u16 = vVar.u();
        long j3 = 0;
        if (u16 == null) {
            return 0L;
        }
        for (com.tencent.luggage.wxa.cp.v vVar2 : u16) {
            if (vVar2.q()) {
                b16 = vVar2.s();
            } else {
                b16 = b(vVar2);
            }
            j3 += b16;
        }
        return j3;
    }

    public static ByteBuffer c(com.tencent.luggage.wxa.cp.v vVar) {
        return a(vVar, 0L, -1L);
    }

    public static void d(com.tencent.luggage.wxa.cp.v vVar) {
        if (vVar != null && vVar.p() && vVar.e()) {
            com.tencent.luggage.wxa.cp.v[] u16 = vVar.u();
            if (u16 != null) {
                for (com.tencent.luggage.wxa.cp.v vVar2 : u16) {
                    if (vVar2.p()) {
                        d(vVar2);
                    }
                    vVar2.d();
                }
            }
            vVar.d();
        }
    }

    public static String c(String str) {
        if (str != null) {
            str = str.trim();
        }
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i3 = 0;
        while (i3 < str.length() && '/' == str.charAt(i3)) {
            i3++;
        }
        return str.substring(i3);
    }

    public static String b(String str) {
        if (w0.c(str)) {
            return str;
        }
        int i3 = 0;
        while (i3 < str.length() && '/' == str.charAt(i3)) {
            i3++;
        }
        return str.substring(i3);
    }

    public static int a(ZipInputStream zipInputStream, String str) {
        try {
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry != null) {
                        String name = nextEntry.getName();
                        if (!name.contains("../") && !name.contains("..\\")) {
                            if (nextEntry.isDirectory()) {
                                new com.tencent.luggage.wxa.cp.v(str + "/" + name.substring(0, name.length() - 1)).w();
                            } else {
                                com.tencent.luggage.wxa.cp.v vVar = new com.tencent.luggage.wxa.cp.v(str + "/" + name);
                                vVar.k().w();
                                vVar.c();
                                OutputStream outputStream = null;
                                try {
                                    try {
                                        outputStream = com.tencent.luggage.wxa.cp.x.b(vVar);
                                        while (true) {
                                            int read = zipInputStream.read(bArr);
                                            if (read == -1) {
                                                break;
                                            }
                                            outputStream.write(bArr, 0, read);
                                            outputStream.flush();
                                        }
                                    } catch (Exception e16) {
                                        throw e16;
                                    }
                                } finally {
                                }
                            }
                        }
                    } else {
                        w0.a((Closeable) zipInputStream);
                        return 0;
                    }
                }
            } catch (FileNotFoundException e17) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.FileSystemUtil[ZIP]", e17, "unzipBytes", new Object[0]);
                w0.a((Closeable) zipInputStream);
                return -1;
            } catch (IOException e18) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.FileSystemUtil[ZIP]", e18, "unzipBytes", new Object[0]);
                w0.a((Closeable) zipInputStream);
                return -2;
            } catch (OutOfMemoryError e19) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.FileSystemUtil[ZIP]", e19, "unzipBytes", new Object[0]);
                w0.a((Closeable) zipInputStream);
                return -3;
            }
        } catch (Throwable th5) {
            w0.a((Closeable) zipInputStream);
            throw th5;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00cc, code lost:
    
        com.tencent.luggage.wxa.tn.w0.a((java.io.Closeable) r3);
        r9.f141499a = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d3, code lost:
    
        return com.tencent.luggage.wxa.rc.l.OK;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static l a(String str, com.tencent.luggage.wxa.tk.i iVar, String str2, long j3, long j16) {
        ZipInputStream zipInputStream;
        HashMap hashMap = new HashMap();
        ZipInputStream zipInputStream2 = null;
        try {
            try {
                zipInputStream = new ZipInputStream(com.tencent.luggage.wxa.cp.x.n(str));
                try {
                    byte[] bArr = new byte[16384];
                    while (true) {
                        ZipEntry nextEntry = zipInputStream.getNextEntry();
                        if (nextEntry == null) {
                            break;
                        }
                        String name = nextEntry.getName();
                        if (!name.contains("../") && !name.contains("..\\") && (w0.c(str2) || name.equals(str2))) {
                            if (nextEntry.isDirectory()) {
                                continue;
                            } else {
                                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                while (true) {
                                    try {
                                        int read = zipInputStream.read(bArr);
                                        if (read == -1) {
                                            break;
                                        }
                                        byteArrayOutputStream.write(bArr, 0, read);
                                    } finally {
                                    }
                                }
                                if (!w0.c(str2) && name.equals(str2)) {
                                    if (j16 == Long.MAX_VALUE) {
                                        j16 = byteArrayOutputStream.size() - j3;
                                    }
                                    int i3 = (int) j3;
                                    if (i3 >= 0 && j3 <= byteArrayOutputStream.size() - 1) {
                                        int i16 = (int) j16;
                                        if (i16 >= 1 && j16 <= byteArrayOutputStream.size() - j3) {
                                            byte[] bArr2 = new byte[i16];
                                            System.arraycopy(byteArrayOutputStream.toByteArray(), i3, bArr2, 0, i16);
                                            hashMap.put(name, ByteBuffer.wrap(bArr2));
                                            byteArrayOutputStream.close();
                                        }
                                        l lVar = l.ERR_ILLEGAL_READ_LENGTH;
                                        byteArrayOutputStream.close();
                                        w0.a((Closeable) zipInputStream);
                                        return lVar;
                                    }
                                    l lVar2 = l.ERR_ILLEGAL_READ_POSITION;
                                    byteArrayOutputStream.close();
                                    w0.a((Closeable) zipInputStream);
                                    return lVar2;
                                }
                                hashMap.put(name, ByteBuffer.wrap(byteArrayOutputStream.toByteArray()));
                                byteArrayOutputStream.close();
                            }
                        }
                    }
                } catch (Exception e16) {
                    e = e16;
                    zipInputStream2 = zipInputStream;
                    com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.FileSystemUtil[ZIP]", e, "readZipEntry", new Object[0]);
                    l lVar3 = l.ERR_OP_FAIL;
                    w0.a((Closeable) zipInputStream2);
                    return lVar3;
                } catch (Throwable th5) {
                    th = th5;
                    w0.a((Closeable) zipInputStream);
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                zipInputStream = zipInputStream2;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    public static void a(com.tencent.luggage.wxa.cp.v vVar, com.tencent.luggage.wxa.cp.w wVar) {
        com.tencent.luggage.wxa.cp.v[] a16 = vVar.a(wVar);
        if (a16 != null) {
            for (com.tencent.luggage.wxa.cp.v vVar2 : a16) {
                if (vVar2.p()) {
                    a(vVar2, wVar);
                }
            }
        }
    }

    public static boolean a(com.tencent.luggage.wxa.cp.v vVar) {
        if (vVar != null) {
            if (!vVar.e()) {
                return false;
            }
            try {
                FileStructStat fileStructStat = new FileStructStat();
                if (FileStat.vfsStat(vVar.g(), fileStructStat) == 0) {
                    com.tencent.luggage.wxa.tn.w.d("MicroMsg.AppBrand.FileSystemUtil[ZIP]", "constainsSymLink, path %s, stat.st_mode %d", vVar.g(), Integer.valueOf(fileStructStat.st_mode));
                    return fileStructStat.isSymLink();
                }
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.FileSystemUtil[ZIP]", e16, "", new Object[0]);
            }
            return false;
        }
        throw new NullPointerException("file should not be NULL");
    }

    public static String a(String str) {
        return a(str, true);
    }

    public static String a(String str, boolean z16) {
        int i3 = 0;
        if (z16) {
            com.tencent.luggage.wxa.tn.w.a("MicroMsg.AppBrand.FileSystemUtil[ZIP]", "eliminateDuplicateSlashForPkgFile, original file name = [%s]", str);
        }
        if (w0.c(str)) {
            return "";
        }
        String trim = str.trim();
        if (!trim.startsWith("/")) {
            return "/" + trim;
        }
        while (i3 < trim.length() && '/' == trim.charAt(i3)) {
            i3++;
        }
        return "/" + trim.substring(i3);
    }
}
