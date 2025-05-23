package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* compiled from: P */
/* loaded from: classes27.dex */
public class F2BEC {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final HashMap<String, spXPg> f381816a;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class spXPg {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public final ReentrantReadWriteLock f381817a;

        /* renamed from: b, reason: collision with root package name */
        public final AtomicInteger f381818b;

        public spXPg() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.f381817a = new ReentrantReadWriteLock();
                this.f381818b = new AtomicInteger(0);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17076);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f381816a = new HashMap<>();
        }
    }

    public static boolean a(String str, byte[] bArr, boolean z16) {
        spXPg spxpg;
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel;
        FileLock fileLock = null;
        if (z16) {
            HashMap<String, spXPg> hashMap = f381816a;
            synchronized (hashMap) {
                spxpg = hashMap.get(str);
                if (spxpg == null) {
                    spxpg = new spXPg();
                    hashMap.put(str, spxpg);
                }
                spxpg.f381818b.incrementAndGet();
            }
            spxpg.f381817a.writeLock().lock();
        } else {
            spxpg = null;
        }
        try {
            randomAccessFile = new RandomAccessFile(str, "rw");
            try {
                fileChannel = randomAccessFile.getChannel();
                if (z16) {
                    try {
                        fileLock = fileChannel.lock();
                    } catch (Throwable unused) {
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException unused2) {
                            }
                        }
                        HDnuc.a(fileChannel);
                        HDnuc.a(randomAccessFile);
                        if (spxpg == null) {
                            return false;
                        }
                        HashMap<String, spXPg> hashMap2 = f381816a;
                        synchronized (hashMap2) {
                            spxpg.f381817a.writeLock().unlock();
                            if (spxpg.f381818b.decrementAndGet() == 0) {
                                hashMap2.remove(str);
                            }
                        }
                        return false;
                    }
                }
                randomAccessFile.seek(0L);
                randomAccessFile.write(bArr);
                randomAccessFile.setLength(bArr.length);
                if (fileLock != null && fileLock.isValid()) {
                    try {
                        fileLock.release();
                    } catch (IOException unused3) {
                    }
                }
                HDnuc.a(fileChannel);
                HDnuc.a(randomAccessFile);
                if (spxpg == null) {
                    return true;
                }
                HashMap<String, spXPg> hashMap3 = f381816a;
                synchronized (hashMap3) {
                    spxpg.f381817a.writeLock().unlock();
                    if (spxpg.f381818b.decrementAndGet() == 0) {
                        hashMap3.remove(str);
                    }
                }
                return true;
            } catch (Throwable unused4) {
                fileChannel = null;
            }
        } catch (Throwable unused5) {
            randomAccessFile = null;
            fileChannel = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] a(String str, boolean z16) {
        spXPg spxpg;
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        FileChannel fileChannel;
        if (z16) {
            HashMap<String, spXPg> hashMap = f381816a;
            synchronized (hashMap) {
                spxpg = hashMap.get(str);
                if (spxpg == null) {
                    spxpg = new spXPg();
                    hashMap.put(str, spxpg);
                }
                spxpg.f381818b.incrementAndGet();
            }
            spxpg.f381817a.readLock().lock();
        } else {
            spxpg = null;
        }
        try {
            randomAccessFile = new RandomAccessFile(str, "r");
            try {
                fileChannel = randomAccessFile.getChannel();
                if (z16) {
                    try {
                        fileLock = fileChannel.lock(0L, Long.MAX_VALUE, true);
                    } catch (Throwable unused) {
                        fileLock = null;
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException unused2) {
                            }
                        }
                        HDnuc.a(fileChannel);
                        HDnuc.a(randomAccessFile);
                        if (spxpg != null) {
                            HashMap<String, spXPg> hashMap2 = f381816a;
                            synchronized (hashMap2) {
                                spxpg.f381817a.readLock().unlock();
                                if (spxpg.f381818b.decrementAndGet() == 0) {
                                    hashMap2.remove(str);
                                }
                            }
                        }
                        return null;
                    }
                } else {
                    fileLock = null;
                }
                try {
                    long length = randomAccessFile.length();
                    int i3 = (int) length;
                    if (i3 == length) {
                        byte[] bArr = new byte[i3];
                        randomAccessFile.readFully(bArr);
                        if (fileLock != null && fileLock.isValid()) {
                            try {
                                fileLock.release();
                            } catch (IOException unused3) {
                            }
                        }
                        HDnuc.a(fileChannel);
                        HDnuc.a(randomAccessFile);
                        if (spxpg != null) {
                            HashMap<String, spXPg> hashMap3 = f381816a;
                            synchronized (hashMap3) {
                                spxpg.f381817a.readLock().unlock();
                                if (spxpg.f381818b.decrementAndGet() == 0) {
                                    hashMap3.remove(str);
                                }
                            }
                        }
                        return bArr;
                    }
                    throw new IOException("");
                } catch (Throwable unused4) {
                    if (fileLock != null) {
                        fileLock.release();
                    }
                    HDnuc.a(fileChannel);
                    HDnuc.a(randomAccessFile);
                    if (spxpg != null) {
                    }
                    return null;
                }
            } catch (Throwable unused5) {
                fileLock = null;
                fileChannel = null;
            }
        } catch (Throwable unused6) {
            fileLock = null;
            randomAccessFile = null;
            fileChannel = null;
        }
    }

    public static byte[] a(String str, int i3) {
        FileInputStream fileInputStream;
        File file = new File(str);
        if (!file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            try {
                byte[] bArr = new byte[i3];
                int i16 = 0;
                do {
                    int read = fileInputStream.read(bArr, i16, i3 - i16);
                    if (read == -1) {
                        break;
                    }
                    i16 += read;
                } while (i16 < i3);
                if (i16 == 0) {
                    HDnuc.a(fileInputStream);
                    return null;
                }
                if (i16 < i3) {
                    byte[] bArr2 = new byte[i16];
                    System.arraycopy(bArr, 0, bArr2, 0, i16);
                    bArr = bArr2;
                }
                HDnuc.a(fileInputStream);
                return bArr;
            } catch (Throwable unused) {
                HDnuc.a(fileInputStream);
                return null;
            }
        } catch (Throwable unused2) {
            fileInputStream = null;
        }
    }

    public static byte[] a(String str) {
        FileInputStream fileInputStream;
        Throwable th5;
        ByteArrayOutputStream byteArrayOutputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                byteArrayOutputStream = new ByteArrayOutputStream(fileInputStream.available());
            } catch (Throwable th6) {
                th5 = th6;
                byteArrayOutputStream = null;
            }
        } catch (Throwable th7) {
            fileInputStream = null;
            th5 = th7;
            byteArrayOutputStream = null;
        }
        try {
            HDnuc.a(fileInputStream, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (byteArray == null) {
                byteArray = "".getBytes();
            }
            return byteArray;
        } catch (Throwable th8) {
            th5 = th8;
            try {
                throw th5;
            } finally {
                HDnuc.a(fileInputStream);
                HDnuc.a(byteArrayOutputStream);
            }
        }
    }

    public static boolean a(File file) {
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            try {
                return file.delete();
            } catch (Throwable unused) {
                return false;
            }
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                a(file2);
            }
        }
        try {
            return file.delete();
        } catch (Throwable unused2) {
            return false;
        }
    }
}
