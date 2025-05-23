package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Blueberry {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f382611a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f382612b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10826);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        StringBuilder a16 = Flat.a("mpdc_");
        a16.append(Nectarine.f382928a);
        a16.append("_");
        a16.append(1);
        f382611a = a16.toString();
        StringBuilder a17 = Flat.a("mpdc_r_");
        a17.append(Nectarine.f382928a);
        a17.append("_");
        a17.append(1);
        f382612b = a17.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0096 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        String str;
        long j3;
        String str2;
        ByteArrayInputStream byteArrayInputStream;
        ByteArrayInputStream byteArrayInputStream2;
        String packageName = context.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            return null;
        }
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), packageName, 64);
            if (packageInfo == null) {
                return null;
            }
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo == null || (str = applicationInfo.sourceDir) == null) {
                return null;
            }
            File file = new File(str);
            int i3 = applicationInfo.flags;
            long j16 = -1;
            try {
                j3 = file.length();
            } catch (Throwable unused) {
                j3 = -1;
            }
            try {
                j16 = file.lastModified() / 1000;
            } catch (Throwable unused2) {
            }
            String str3 = packageInfo.versionName;
            if (str3 == null) {
                str3 = "";
            }
            int i16 = packageInfo.versionCode;
            long j17 = packageInfo.firstInstallTime;
            long j18 = packageInfo.lastUpdateTime;
            System.currentTimeMillis();
            Signature[] signatureArr = packageInfo.signatures;
            if (signatureArr == null || signatureArr.length <= 0) {
                str2 = "";
            } else {
                try {
                    byteArrayInputStream2 = new ByteArrayInputStream(signatureArr[0].toByteArray());
                } catch (Throwable th5) {
                    th = th5;
                    byteArrayInputStream = null;
                }
                try {
                    str2 = Vulpecula.a(((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream2)).getEncoded());
                } catch (Throwable th6) {
                    th = th6;
                    byteArrayInputStream = byteArrayInputStream2;
                    try {
                        th.printStackTrace();
                        str2 = "";
                        byteArrayInputStream2 = byteArrayInputStream;
                        if (TextUtils.isEmpty(str2)) {
                        }
                        return j3 + ":" + str2 + ":" + packageName + ":" + str3 + ":" + i16 + ":" + j17 + ":" + j18 + ":" + i3 + ":" + j16;
                    } finally {
                        Eridanus.a(byteArrayInputStream);
                    }
                }
            }
            if (TextUtils.isEmpty(str2)) {
                try {
                    ArrayList arrayList = (ArrayList) Carambola.a(new File(str));
                    if (arrayList.size() > 0) {
                        String str4 = (String) arrayList.get(0);
                        str2 = str4 == null ? "" : str4;
                    }
                } catch (Throwable unused3) {
                }
            }
            return j3 + ":" + str2 + ":" + packageName + ":" + str3 + ":" + i16 + ":" + j17 + ":" + j18 + ":" + i3 + ":" + j16;
        } catch (Throwable unused4) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bc A[Catch: all -> 0x0131, TRY_ENTER, TryCatch #6 {, blocks: (B:4:0x0003, B:10:0x000e, B:13:0x0013, B:14:0x0023, B:23:0x00bc, B:28:0x00c7, B:47:0x010a, B:50:0x0110, B:53:0x0113, B:57:0x0120, B:60:0x0126, B:63:0x0129, B:67:0x00d2, B:68:0x003d, B:71:0x0048, B:73:0x004e, B:74:0x0055, B:90:0x0084, B:93:0x008a, B:96:0x008d, B:100:0x00a2, B:103:0x00a8, B:106:0x00ab, B:113:0x0033), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String a(Context context, String str) {
        byte[] bArr;
        FileChannel fileChannel;
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        String str2;
        RandomAccessFile randomAccessFile2;
        FileChannel fileChannel2;
        synchronized (Blueberry.class) {
            String a16 = a(context);
            if (a16 == null) {
                return "";
            }
            byte[] bytes = a16.getBytes();
            FileLock fileLock2 = null;
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
                messageDigest.update(bytes);
                bArr = messageDigest.digest();
            } catch (NoSuchAlgorithmException unused) {
                bArr = null;
            }
            String a17 = Plum.a(bArr);
            File dir = context.getDir("turingfd", 0);
            File file = dir == null ? null : new File(dir, str);
            if (file != null) {
                if (!file.exists()) {
                    str2 = "";
                } else if (!file.isFile()) {
                    Csynchronized.a(file);
                    str2 = "";
                } else {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        randomAccessFile = new RandomAccessFile(file, "rw");
                        try {
                            fileChannel = randomAccessFile.getChannel();
                            try {
                                fileLock = fileChannel.lock();
                            } catch (Throwable unused2) {
                                fileLock = null;
                            }
                        } catch (Throwable unused3) {
                            fileChannel = null;
                            fileLock = null;
                        }
                    } catch (Throwable unused4) {
                        fileChannel = null;
                        randomAccessFile = null;
                        fileLock = null;
                    }
                    try {
                        ByteBuffer allocate = ByteBuffer.allocate(32);
                        while (true) {
                            int read = fileChannel.read(allocate);
                            if (read <= 0) {
                                break;
                            }
                            byteArrayOutputStream.write(allocate.array(), 0, read);
                        }
                        String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException unused5) {
                            }
                        }
                        Eridanus.a(fileChannel);
                        Eridanus.a(randomAccessFile);
                        Eridanus.a(byteArrayOutputStream);
                        str2 = byteArrayOutputStream2;
                    } catch (Throwable unused6) {
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException unused7) {
                            }
                        }
                        Eridanus.a(fileChannel);
                        Eridanus.a(randomAccessFile);
                        Eridanus.a(byteArrayOutputStream);
                        str2 = null;
                        if (str2 == null) {
                        }
                    }
                }
                if (str2 == null) {
                    return "";
                }
                if (TextUtils.equals(str2, a17)) {
                    return "";
                }
                File dir2 = context.getDir("turingfd", 0);
                File file2 = dir2 == null ? null : new File(dir2, str);
                if (file2 != null) {
                    try {
                        randomAccessFile2 = new RandomAccessFile(file2, "rw");
                        try {
                            fileChannel2 = randomAccessFile2.getChannel();
                            try {
                                fileLock2 = fileChannel2.lock();
                                byte[] bytes2 = a17.getBytes();
                                ByteBuffer allocate2 = ByteBuffer.allocate(bytes2.length);
                                allocate2.put(bytes2);
                                allocate2.flip();
                                while (allocate2.hasRemaining()) {
                                    fileChannel2.write(allocate2);
                                }
                                fileChannel2.truncate(bytes2.length);
                                if (fileLock2 != null && fileLock2.isValid()) {
                                    try {
                                        fileLock2.release();
                                    } catch (IOException unused8) {
                                    }
                                }
                                Eridanus.a(fileChannel2);
                                Eridanus.a(randomAccessFile2);
                            } catch (Throwable unused9) {
                                if (fileLock2 != null && fileLock2.isValid()) {
                                    try {
                                        fileLock2.release();
                                    } catch (IOException unused10) {
                                    }
                                }
                                Eridanus.a(fileChannel2);
                                Eridanus.a(randomAccessFile2);
                                return a16;
                            }
                        } catch (Throwable unused11) {
                            fileChannel2 = null;
                        }
                    } catch (Throwable unused12) {
                        randomAccessFile2 = null;
                        fileChannel2 = null;
                    }
                }
                return a16;
            }
            str2 = null;
            if (str2 == null) {
            }
        }
    }
}
