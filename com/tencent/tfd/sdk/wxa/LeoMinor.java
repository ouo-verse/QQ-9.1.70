package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
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
/* loaded from: classes26.dex */
public final class LeoMinor {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f375652a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f375653b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62683);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        StringBuilder a16 = Pyxis.a("mpdc_");
        a16.append(UrsaMinor.f375742a);
        a16.append("_");
        a16.append(1);
        f375652a = a16.toString();
        StringBuilder a17 = Pyxis.a("mpdc_r_");
        a17.append(UrsaMinor.f375742a);
        a17.append("_");
        a17.append(1);
        f375653b = a17.toString();
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0119 A[Catch: all -> 0x0243, TRY_ENTER, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0007, B:13:0x0119, B:15:0x011d, B:16:0x0136, B:25:0x01cc, B:30:0x01d7, B:52:0x021b, B:55:0x0221, B:58:0x0224, B:62:0x0232, B:65:0x0238, B:68:0x023b, B:75:0x01e3, B:76:0x0150, B:79:0x015a, B:81:0x0160, B:82:0x0167, B:99:0x0197, B:102:0x019d, B:105:0x01a0, B:109:0x01b2, B:112:0x01b8, B:115:0x01bb, B:122:0x0146, B:125:0x0013, B:130:0x0021, B:132:0x0025, B:135:0x002b, B:141:0x0042, B:144:0x0049, B:146:0x005d, B:148:0x0060, B:154:0x008a, B:161:0x008f, B:162:0x0093, B:166:0x0094, B:168:0x00b8, B:158:0x0087), top: B:3:0x0007, inners: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01cc A[Catch: all -> 0x0243, TRY_ENTER, TryCatch #2 {, blocks: (B:4:0x0007, B:13:0x0119, B:15:0x011d, B:16:0x0136, B:25:0x01cc, B:30:0x01d7, B:52:0x021b, B:55:0x0221, B:58:0x0224, B:62:0x0232, B:65:0x0238, B:68:0x023b, B:75:0x01e3, B:76:0x0150, B:79:0x015a, B:81:0x0160, B:82:0x0167, B:99:0x0197, B:102:0x019d, B:105:0x01a0, B:109:0x01b2, B:112:0x01b8, B:115:0x01bb, B:122:0x0146, B:125:0x0013, B:130:0x0021, B:132:0x0025, B:135:0x002b, B:141:0x0042, B:144:0x0049, B:146:0x005d, B:148:0x0060, B:154:0x008a, B:161:0x008f, B:162:0x0093, B:166:0x0094, B:168:0x00b8, B:158:0x0087), top: B:3:0x0007, inners: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0232 A[Catch: all -> 0x0243, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0007, B:13:0x0119, B:15:0x011d, B:16:0x0136, B:25:0x01cc, B:30:0x01d7, B:52:0x021b, B:55:0x0221, B:58:0x0224, B:62:0x0232, B:65:0x0238, B:68:0x023b, B:75:0x01e3, B:76:0x0150, B:79:0x015a, B:81:0x0160, B:82:0x0167, B:99:0x0197, B:102:0x019d, B:105:0x01a0, B:109:0x01b2, B:112:0x01b8, B:115:0x01bb, B:122:0x0146, B:125:0x0013, B:130:0x0021, B:132:0x0025, B:135:0x002b, B:141:0x0042, B:144:0x0049, B:146:0x005d, B:148:0x0060, B:154:0x008a, B:161:0x008f, B:162:0x0093, B:166:0x0094, B:168:0x00b8, B:158:0x0087), top: B:3:0x0007, inners: #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0114  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized String a(Context context, String str) {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        String str2;
        long j3;
        String str3;
        ByteArrayInputStream byteArrayInputStream;
        byte[] bArr;
        File file;
        FileChannel fileChannel;
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        String str4;
        File file2;
        RandomAccessFile randomAccessFile2;
        FileChannel fileChannel2;
        FileLock fileLock2;
        FileLock lock;
        synchronized (LeoMinor.class) {
            String packageName = context.getPackageName();
            if (!TextUtils.isEmpty(packageName)) {
                try {
                    packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), packageName, 64);
                } catch (Throwable unused) {
                }
                if (packageInfo != null && (applicationInfo = packageInfo.applicationInfo) != null && (str2 = applicationInfo.sourceDir) != null) {
                    File file3 = new File(str2);
                    int i3 = applicationInfo.flags;
                    long j16 = -1;
                    try {
                        j3 = file3.length();
                    } catch (Throwable unused2) {
                        j3 = -1;
                    }
                    try {
                        j16 = file3.lastModified() / 1000;
                    } catch (Throwable unused3) {
                    }
                    String str5 = packageInfo.versionName;
                    if (str5 == null) {
                        str5 = "";
                    }
                    int i16 = packageInfo.versionCode;
                    long j17 = packageInfo.firstInstallTime;
                    long j18 = packageInfo.lastUpdateTime;
                    System.currentTimeMillis();
                    String str6 = "";
                    Signature[] signatureArr = packageInfo.signatures;
                    if (signatureArr != null && signatureArr.length > 0) {
                        try {
                            byteArrayInputStream = new ByteArrayInputStream(signatureArr[0].toByteArray());
                        } catch (Throwable th5) {
                            th = th5;
                            byteArrayInputStream = null;
                        }
                        try {
                            str6 = Cepheus.a(((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(byteArrayInputStream)).getEncoded());
                        } catch (Throwable th6) {
                            th = th6;
                            try {
                                th.printStackTrace();
                                Cvolatile.a(byteArrayInputStream);
                                if (TextUtils.isEmpty(str6)) {
                                }
                                str3 = j3 + ":" + str6 + ":" + packageName + ":" + str5 + ":" + i16 + ":" + j17 + ":" + j18 + ":" + i3 + ":" + j16;
                                if (str3 == null) {
                                }
                            } catch (Throwable th7) {
                                Cvolatile.a(byteArrayInputStream);
                                throw th7;
                            }
                        }
                        Cvolatile.a(byteArrayInputStream);
                    }
                    if (TextUtils.isEmpty(str6)) {
                        try {
                            ArrayList arrayList = (ArrayList) Lyra.a(new File(str2));
                            if (arrayList.size() > 0) {
                                String str7 = (String) arrayList.get(0);
                                if (str7 == null) {
                                    str7 = "";
                                }
                                str6 = str7;
                            }
                        } catch (Throwable unused4) {
                        }
                    }
                    str3 = j3 + ":" + str6 + ":" + packageName + ":" + str5 + ":" + i16 + ":" + j17 + ":" + j18 + ":" + i3 + ":" + j16;
                    if (str3 == null) {
                        return "";
                    }
                    byte[] bytes = str3.getBytes();
                    try {
                        MessageDigest messageDigest = MessageDigest.getInstance(new String(Bennet.a("4D4435")));
                        messageDigest.update(bytes);
                        bArr = messageDigest.digest();
                    } catch (NoSuchAlgorithmException unused5) {
                        bArr = null;
                    }
                    String a16 = Bennet.a(bArr);
                    File dir = context.getDir("turingfd", 0);
                    if (dir == null) {
                        file = null;
                    } else {
                        file = new File(dir, str);
                    }
                    if (file != null) {
                        if (!file.exists()) {
                            str4 = "";
                        } else if (!file.isFile()) {
                            Cextends.a(file);
                            str4 = "";
                        } else {
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            try {
                                randomAccessFile = new RandomAccessFile(file, "rw");
                                try {
                                    fileChannel = randomAccessFile.getChannel();
                                    try {
                                        fileLock = fileChannel.lock();
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
                                                } catch (IOException unused6) {
                                                }
                                            }
                                            Cvolatile.a(fileChannel);
                                            Cvolatile.a(randomAccessFile);
                                            Cvolatile.a(byteArrayOutputStream);
                                            str4 = byteArrayOutputStream2;
                                        } catch (Throwable unused7) {
                                            if (fileLock != null) {
                                                try {
                                                    fileLock.release();
                                                } catch (IOException unused8) {
                                                }
                                            }
                                            Cvolatile.a(fileChannel);
                                            Cvolatile.a(randomAccessFile);
                                            Cvolatile.a(byteArrayOutputStream);
                                            str4 = null;
                                            if (str4 != null) {
                                            }
                                        }
                                    } catch (Throwable unused9) {
                                        fileLock = null;
                                        if (fileLock != null && fileLock.isValid()) {
                                            fileLock.release();
                                        }
                                        Cvolatile.a(fileChannel);
                                        Cvolatile.a(randomAccessFile);
                                        Cvolatile.a(byteArrayOutputStream);
                                        str4 = null;
                                        if (str4 != null) {
                                        }
                                    }
                                } catch (Throwable unused10) {
                                    fileChannel = null;
                                }
                            } catch (Throwable unused11) {
                                fileChannel = null;
                                randomAccessFile = null;
                            }
                        }
                        if (str4 != null) {
                            return "";
                        }
                        if (TextUtils.equals(str4, a16)) {
                            return "";
                        }
                        File dir2 = context.getDir("turingfd", 0);
                        if (dir2 == null) {
                            file2 = null;
                        } else {
                            file2 = new File(dir2, str);
                        }
                        if (file2 != null) {
                            try {
                                randomAccessFile2 = new RandomAccessFile(file2, "rw");
                                try {
                                    fileChannel2 = randomAccessFile2.getChannel();
                                    try {
                                        lock = fileChannel2.lock();
                                    } catch (Throwable unused12) {
                                        fileLock2 = null;
                                        if (fileLock2 != null) {
                                        }
                                        Cvolatile.a(fileChannel2);
                                        Cvolatile.a(randomAccessFile2);
                                        return str3;
                                    }
                                } catch (Throwable unused13) {
                                    fileChannel2 = null;
                                    fileLock2 = null;
                                    if (fileLock2 != null) {
                                        try {
                                            fileLock2.release();
                                        } catch (IOException unused14) {
                                        }
                                    }
                                    Cvolatile.a(fileChannel2);
                                    Cvolatile.a(randomAccessFile2);
                                    return str3;
                                }
                            } catch (Throwable unused15) {
                                randomAccessFile2 = null;
                            }
                            try {
                                byte[] bytes2 = a16.getBytes();
                                ByteBuffer allocate2 = ByteBuffer.allocate(bytes2.length);
                                allocate2.put(bytes2);
                                allocate2.flip();
                                while (allocate2.hasRemaining()) {
                                    fileChannel2.write(allocate2);
                                }
                                fileChannel2.truncate(bytes2.length);
                                if (lock != null && lock.isValid()) {
                                    try {
                                        lock.release();
                                    } catch (IOException unused16) {
                                    }
                                }
                                Cvolatile.a(fileChannel2);
                                Cvolatile.a(randomAccessFile2);
                            } catch (Throwable unused17) {
                                fileLock2 = lock;
                                if (fileLock2 != null && fileLock2.isValid()) {
                                    fileLock2.release();
                                }
                                Cvolatile.a(fileChannel2);
                                Cvolatile.a(randomAccessFile2);
                                return str3;
                            }
                        }
                        return str3;
                    }
                    str4 = null;
                    if (str4 != null) {
                    }
                }
            }
            str3 = null;
            if (str3 == null) {
            }
        }
    }
}
