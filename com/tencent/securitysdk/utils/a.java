package com.tencent.securitysdk.utils;

import android.util.Pair;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.commonsdk.soload.MyZipConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.securitysdk.utils.ApkSignatureSchemeV2Verifier;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Properties;
import java.util.zip.ZipException;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final e f368861a;

    /* renamed from: b, reason: collision with root package name */
    private static final e f368862b;

    /* renamed from: c, reason: collision with root package name */
    private static int f368863c;

    /* renamed from: d, reason: collision with root package name */
    private static final e f368864d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35704);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f368861a = new e(84298576L);
        f368862b = new e(50613072L);
        f368863c = 0;
        f368864d = new e(MyZipConstants.ENDSIG);
    }

    private static byte[] c(byte[] bArr) throws IOException {
        if (bArr == null) {
            return null;
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        e eVar = f368861a;
        byte[] bArr2 = new byte[eVar.a().length];
        wrap.get(bArr2);
        if (eVar.equals(new e(bArr2))) {
            return bArr;
        }
        e eVar2 = f368862b;
        if (eVar2.equals(new e(bArr2))) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(eVar2.a());
        byteArrayOutputStream.write(new f(bArr.length).a());
        byteArrayOutputStream.write(bArr);
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0103, code lost:
    
        if (r8 != 0) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0105, code lost:
    
        r6.putLong(r20.length + 4);
        r6.putInt(r19);
        r6.put(r20);
        r8 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0113, code lost:
    
        r0 = r18.getLong() + r8;
        r6.putLong(r0);
        r6.put(r18.array(), r18.array().length - 16, 16);
        r6.position(0);
        r6.putLong(r0);
        r6.position(0);
        r6.limit(((int) r0) + 8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0143, code lost:
    
        return android.util.Pair.create(r6, java.lang.Long.valueOf(r8));
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00e7, code lost:
    
        throw new com.tencent.securitysdk.utils.ApkSignatureSchemeV2Verifier.SignatureNotFoundException("APK Signing Block entry #" + r8 + " size out of range: " + r12);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Pair<ByteBuffer, Long> d(ByteBuffer byteBuffer, int i3, byte[] bArr) throws ApkSignatureSchemeV2Verifier.SignatureNotFoundException, UnsupportedEncodingException {
        long j3;
        ApkSignatureSchemeV2Verifier.a(byteBuffer);
        int i16 = 8;
        ByteBuffer i17 = ApkSignatureSchemeV2Verifier.i(byteBuffer, 8, byteBuffer.capacity() - 24);
        int length = bArr.length + 12;
        ByteBuffer allocate = ByteBuffer.allocate(byteBuffer.capacity() + length);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.position(8);
        int i18 = 0;
        while (true) {
            if (i17.hasRemaining()) {
                i18++;
                if (i17.remaining() >= i16) {
                    long j16 = i17.getLong();
                    if (j16 < 4 || j16 > TTL.MAX_VALUE) {
                        break;
                    }
                    int i19 = (int) j16;
                    int position = i17.position() + i19;
                    if (i19 <= i17.remaining()) {
                        int i26 = i17.getInt();
                        if (i26 == i3) {
                            j3 = (bArr.length + 4) - i19;
                            allocate.putLong(bArr.length + 4);
                            allocate.putInt(i26);
                            allocate.put(bArr);
                            i17.position(position);
                            allocate.put(i17.array(), i17.arrayOffset(), i17.remaining());
                            i17.position(i17.limit());
                            break;
                        }
                        allocate.putLong(j16);
                        allocate.putInt(i26);
                        allocate.put(ApkSignatureSchemeV2Verifier.e(i17, i19 - 4));
                        i17.position(position);
                        i16 = 8;
                    } else {
                        throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("APK Signing Block entry #" + i18 + " size out of range: " + i19 + ", available: " + i17.remaining());
                    }
                } else {
                    throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("Insufficient data to read size of APK Signing Block entry #" + i18);
                }
            } else {
                j3 = 0;
                break;
            }
        }
    }

    private static ByteBuffer e(RandomAccessFile randomAccessFile, long j3, int i3) throws IOException {
        ByteBuffer allocate = ByteBuffer.allocate(i3);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        randomAccessFile.seek(j3);
        randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
        return allocate;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0093 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String f(File file) throws IOException {
        RandomAccessFile randomAccessFile;
        byte[] bArr;
        RandomAccessFile randomAccessFile2;
        QLog.i("ApkExternalInfoTool", 1, "enter getSecurityCodeV1");
        C9792a c9792a = null;
        if (file == null) {
            return null;
        }
        QLog.i("ApkExternalInfoTool", 1, "apkFile filename:" + file.getName());
        try {
            if (ApkSignatureSchemeV2Verifier.h(file.getAbsolutePath())) {
                bArr = i(file.getAbsolutePath(), 2036624993);
            } else {
                bArr = null;
            }
            if (bArr == null) {
                randomAccessFile = new RandomAccessFile(file, "r");
                try {
                    bArr = h(randomAccessFile);
                    randomAccessFile2 = randomAccessFile;
                } catch (Throwable th5) {
                    th = th5;
                    try {
                        th.printStackTrace();
                        return null;
                    } finally {
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                        }
                        QLog.i("ApkExternalInfoTool", 1, "exit getSecurityCodeV1");
                    }
                }
            } else {
                randomAccessFile2 = null;
            }
        } catch (Throwable th6) {
            th = th6;
            randomAccessFile = null;
        }
        try {
            if (bArr == null) {
                QLog.i("ApkExternalInfoTool", 1, "null == readComment");
                QLog.i("ApkExternalInfoTool", 1, "exit");
                if (randomAccessFile2 != null) {
                    randomAccessFile2.close();
                }
                QLog.i("ApkExternalInfoTool", 1, "exit getSecurityCodeV1");
                return null;
            }
            b bVar = new b(c9792a);
            bVar.a(bArr);
            String property = bVar.f368865a.getProperty("apkSecurityCode");
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            QLog.i("ApkExternalInfoTool", 1, "exit getSecurityCodeV1");
            return property;
        } catch (Throwable th7) {
            randomAccessFile = randomAccessFile2;
            th = th7;
            th.printStackTrace();
            return null;
        }
    }

    private static String g(byte[] bArr) {
        if (bArr != null) {
            StringBuilder sb5 = new StringBuilder();
            for (byte b16 : bArr) {
                sb5.append((int) b16);
                sb5.append(",");
            }
            return sb5.toString();
        }
        return GlobalUtil.DEF_STRING;
    }

    public static byte[] h(RandomAccessFile randomAccessFile) throws IOException {
        boolean z16;
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] a16 = f368864d.a();
        int read = randomAccessFile.read();
        while (true) {
            z16 = false;
            if (read != -1) {
                if (read == a16[0] && randomAccessFile.read() == a16[1] && randomAccessFile.read() == a16[2] && randomAccessFile.read() == a16[3]) {
                    z16 = true;
                    break;
                }
                length--;
                randomAccessFile.seek(length);
                read = randomAccessFile.read();
            } else {
                break;
            }
        }
        if (z16) {
            long j3 = length + 16 + 4;
            randomAccessFile.seek(j3);
            if (f368863c != j3) {
                f368863c = (int) j3;
            }
            byte[] bArr = new byte[2];
            randomAccessFile.readFully(bArr);
            QLog.d("ApkExternalInfoTool", 1, "readComment:length bytes data = " + g(bArr));
            int b16 = new f(bArr).b();
            if (b16 == 0) {
                return null;
            }
            byte[] bArr2 = new byte[b16];
            randomAccessFile.read(bArr2);
            return bArr2;
        }
        QLog.e("ApkExternalInfoTool", 1, "archive is not a ZIP archive");
        throw new ZipException("archive is not a ZIP archive");
    }

    private static byte[] i(String str, int i3) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(str, "r");
        } catch (Throwable th5) {
            th = th5;
            randomAccessFile = null;
        }
        try {
            Pair<ByteBuffer, Long> g16 = ApkSignatureSchemeV2Verifier.g(randomAccessFile);
            ByteBuffer byteBuffer = (ByteBuffer) g16.first;
            long longValue = ((Long) g16.second).longValue();
            if (!g.i(randomAccessFile, longValue)) {
                ByteBuffer d16 = ApkSignatureSchemeV2Verifier.d((ByteBuffer) ApkSignatureSchemeV2Verifier.c(randomAccessFile, ApkSignatureSchemeV2Verifier.f(byteBuffer, longValue)).first, i3);
                int remaining = d16.remaining();
                byte[] bArr = new byte[remaining];
                d16.get(bArr, 0, remaining);
                randomAccessFile.close();
                return bArr;
            }
            throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
        } catch (Throwable th6) {
            th = th6;
            try {
                th.printStackTrace();
                return null;
            } finally {
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            }
        }
    }

    public static void j(File file, String str) throws IOException {
        if (ApkSignatureSchemeV2Verifier.h(file.getAbsolutePath())) {
            l(file, str);
        } else {
            k(file, str);
        }
    }

    private static void k(File file, String str) throws IOException {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2 = null;
        byte b16 = 0;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            byte[] c16 = c(h(randomAccessFile));
            b bVar = new b(b16 == true ? 1 : 0);
            bVar.a(c16);
            bVar.f368865a.setProperty("apkSecurityCode", str);
            byte[] b17 = bVar.b();
            randomAccessFile.seek(f368863c);
            randomAccessFile.write(new f(b17.length).a());
            randomAccessFile.write(b17);
            randomAccessFile.setLength(f368863c + b17.length + 2);
            QLog.d("ApkExternalInfoTool", 1, "file length is = " + randomAccessFile.length());
            randomAccessFile.close();
            QLog.i("ApkExternalInfoTool", 1, "exit writeSecurityCode");
        } catch (Throwable th6) {
            th = th6;
            randomAccessFile2 = randomAccessFile;
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            QLog.i("ApkExternalInfoTool", 1, "exit writeSecurityCode");
            throw th;
        }
    }

    private static void l(File file, String str) throws IOException {
        try {
            byte[] c16 = c(i(file.getAbsolutePath(), 2036624993));
            b bVar = new b(null);
            bVar.a(c16);
            bVar.f368865a.setProperty("apkSecurityCode", str);
            m(file.getAbsolutePath(), 2036624993, bVar.b());
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x00bd, code lost:
    
        if (r0 == null) goto L32;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void m(String str, int i3, byte[] bArr) throws IOException, ApkSignatureSchemeV2Verifier.SignatureNotFoundException {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        ByteBuffer byteBuffer;
        long longValue;
        RandomAccessFile randomAccessFile3 = null;
        RandomAccessFile randomAccessFile4 = null;
        RandomAccessFile randomAccessFile5 = null;
        try {
            try {
                randomAccessFile2 = new RandomAccessFile(str, "rw");
                try {
                    Pair<ByteBuffer, Long> g16 = ApkSignatureSchemeV2Verifier.g(randomAccessFile2);
                    byteBuffer = (ByteBuffer) g16.first;
                    longValue = ((Long) g16.second).longValue();
                } catch (FileNotFoundException e16) {
                    e = e16;
                    randomAccessFile4 = randomAccessFile2;
                    e.printStackTrace();
                    randomAccessFile3 = randomAccessFile4;
                    randomAccessFile = randomAccessFile4;
                } catch (IllegalArgumentException e17) {
                    e = e17;
                    randomAccessFile5 = randomAccessFile2;
                    e.printStackTrace();
                    randomAccessFile3 = randomAccessFile5;
                    if (randomAccessFile5 != null) {
                        randomAccessFile = randomAccessFile5;
                        randomAccessFile.close();
                        randomAccessFile3 = randomAccessFile;
                    }
                    return;
                } catch (Throwable th5) {
                    th = th5;
                    randomAccessFile3 = randomAccessFile2;
                    if (randomAccessFile3 != null) {
                        randomAccessFile3.close();
                    }
                    throw th;
                }
            } catch (FileNotFoundException e18) {
                e = e18;
            } catch (IllegalArgumentException e19) {
                e = e19;
            }
            if (!g.i(randomAccessFile2, longValue)) {
                long f16 = ApkSignatureSchemeV2Verifier.f(byteBuffer, longValue);
                ByteBuffer e26 = e(randomAccessFile2, f16, (int) (longValue - f16));
                Pair<ByteBuffer, Long> c16 = ApkSignatureSchemeV2Verifier.c(randomAccessFile2, f16);
                ByteBuffer byteBuffer2 = (ByteBuffer) c16.first;
                long longValue2 = ((Long) c16.second).longValue();
                Pair<ByteBuffer, Long> d16 = d(byteBuffer2, i3, bArr);
                ByteBuffer byteBuffer3 = (ByteBuffer) d16.first;
                long longValue3 = ((Long) d16.second).longValue();
                g.k(byteBuffer, f16 + longValue3);
                randomAccessFile2.seek(longValue2);
                randomAccessFile2.write(byteBuffer3.array(), byteBuffer3.arrayOffset() + byteBuffer3.position(), byteBuffer3.remaining());
                randomAccessFile2.write(e26.array(), e26.arrayOffset() + e26.position(), e26.remaining());
                randomAccessFile2.write(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
                if (longValue3 < 0) {
                    randomAccessFile2.setLength(randomAccessFile2.length() + longValue3);
                }
                randomAccessFile2.close();
                randomAccessFile3 = byteBuffer;
                return;
            }
            throw new ApkSignatureSchemeV2Verifier.SignatureNotFoundException("ZIP64 APK not supported");
        } catch (Throwable th6) {
            th = th6;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        Properties f368865a;

        /* renamed from: b, reason: collision with root package name */
        byte[] f368866b;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                this.f368865a = new Properties();
            } else {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        void a(byte[] bArr) throws IOException {
            if (bArr != null && bArr.length != 0) {
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                int length = a.f368861a.a().length;
                byte[] bArr2 = new byte[length];
                wrap.get(bArr2);
                if (a.f368861a.equals(new e(bArr2))) {
                    if (bArr.length - length <= 2) {
                        QLog.i("ApkExternalInfoTool", 1, "data.length - securityMarkLength <= 2");
                        return;
                    }
                    byte[] bArr3 = new byte[2];
                    wrap.get(bArr3);
                    int b16 = new f(bArr3).b();
                    if ((bArr.length - length) - 2 < b16) {
                        QLog.i("ApkExternalInfoTool", 1, "data.length - securityMarkLength - 2 < len");
                        QLog.i("ApkExternalInfoTool", 1, "exit");
                        return;
                    }
                    byte[] bArr4 = new byte[b16];
                    wrap.get(bArr4);
                    this.f368865a.load(new ByteArrayInputStream(bArr4));
                    int length2 = ((bArr.length - length) - b16) - 2;
                    if (length2 > 0) {
                        int length3 = a.f368862b.a().length;
                        byte[] bArr5 = new byte[length3];
                        wrap.get(bArr5);
                        if (a.f368862b.equals(new e(bArr5))) {
                            int i3 = length2 - length3;
                            if (i3 <= 2) {
                                QLog.i("ApkExternalInfoTool", 1, "data.length - oriMarkLength <= 2");
                                return;
                            }
                            byte[] bArr6 = new byte[2];
                            wrap.get(bArr6);
                            int b17 = new f(bArr6).b();
                            if (i3 - 2 < b17) {
                                QLog.i("ApkExternalInfoTool", 1, "data.length - oriMarkLength - 2 < len");
                                QLog.i("ApkExternalInfoTool", 1, "exit");
                                return;
                            } else {
                                byte[] bArr7 = new byte[b17];
                                this.f368866b = bArr7;
                                wrap.get(bArr7);
                                return;
                            }
                        }
                        return;
                    }
                    return;
                }
                if (a.f368862b.equals(new e(bArr2))) {
                    int length4 = a.f368862b.a().length;
                    if (bArr.length - length <= 2) {
                        QLog.i("ApkExternalInfoTool", 1, "data.length - oriMarkLength <= 2");
                        return;
                    }
                    byte[] bArr8 = new byte[2];
                    wrap.get(bArr8);
                    int b18 = new f(bArr8).b();
                    if ((bArr.length - length4) - 2 < b18) {
                        QLog.i("ApkExternalInfoTool", 1, "data.length - oriMarkLength - 2 < len");
                        QLog.i("ApkExternalInfoTool", 1, "exit");
                        return;
                    } else {
                        byte[] bArr9 = new byte[b18];
                        this.f368866b = bArr9;
                        wrap.get(bArr9);
                        return;
                    }
                }
                throw new ProtocolException("unknow protocl [" + Arrays.toString(bArr) + "]");
            }
        }

        byte[] b() throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (this.f368865a.size() > 0) {
                byteArrayOutputStream.write(a.f368861a.a());
                String str = "";
                for (Object obj : this.f368865a.keySet()) {
                    str = str + obj + ContainerUtils.KEY_VALUE_DELIMITER + this.f368865a.getProperty((String) obj) + "\r\n";
                }
                byte[] bytes = str.getBytes();
                byteArrayOutputStream.write(new f(bytes.length).a());
                byteArrayOutputStream.write(bytes);
            }
            byte[] bArr = this.f368866b;
            if (bArr != null && bArr.length > 0) {
                byteArrayOutputStream.write(a.f368862b.a());
                byteArrayOutputStream.write(new f(this.f368866b.length).a());
                byteArrayOutputStream.write(this.f368866b);
            }
            return byteArrayOutputStream.toByteArray();
        }

        /* synthetic */ b(C9792a c9792a) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) c9792a);
        }
    }
}
