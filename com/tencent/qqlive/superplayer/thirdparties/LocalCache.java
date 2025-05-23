package com.tencent.qqlive.superplayer.thirdparties;

import android.content.Context;
import android.os.Process;
import com.tencent.qqlive.superplayer.tools.utils.d;
import com.tencent.qqlive.superplayer.tools.utils.f;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes22.dex */
public class LocalCache {

    /* renamed from: b, reason: collision with root package name */
    private static Map<String, LocalCache> f345394b = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private ACacheManager f345395a;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class ACacheManager {

        /* renamed from: a, reason: collision with root package name */
        protected File f345396a;

        /* renamed from: b, reason: collision with root package name */
        private final AtomicLong f345397b;

        /* renamed from: c, reason: collision with root package name */
        private final AtomicInteger f345398c;

        /* renamed from: d, reason: collision with root package name */
        private final long f345399d;

        /* renamed from: e, reason: collision with root package name */
        private final int f345400e;

        /* renamed from: f, reason: collision with root package name */
        private final Map<File, Long> f345401f;

        private void i() {
            f.f345491a.execute(new Runnable() { // from class: com.tencent.qqlive.superplayer.thirdparties.LocalCache.ACacheManager.1
                @Override // java.lang.Runnable
                public void run() {
                    File[] listFiles = ACacheManager.this.f345396a.listFiles();
                    if (listFiles != null) {
                        int i3 = 0;
                        int i16 = 0;
                        for (File file : listFiles) {
                            i3 = (int) (i3 + ACacheManager.this.j(file));
                            i16++;
                            ACacheManager.this.f345401f.put(file, Long.valueOf(file.lastModified()));
                        }
                        ACacheManager.this.f345397b.set(i3);
                        ACacheManager.this.f345398c.set(i16);
                    }
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public long j(File file) {
            if (file == null) {
                return 0L;
            }
            return file.length();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public File k(String str) {
            File l3 = l(str);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            l3.setLastModified(valueOf.longValue());
            this.f345401f.put(l3, valueOf);
            return l3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public File l(String str) {
            return new File(this.f345396a, str.hashCode() + "");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m(File file) {
            int i3 = this.f345398c.get();
            while (i3 + 1 > this.f345400e) {
                this.f345397b.addAndGet(-o());
                i3 = this.f345398c.addAndGet(-1);
            }
            this.f345398c.addAndGet(1);
            long j3 = j(file);
            long j16 = this.f345397b.get();
            while (j16 + j3 > this.f345399d) {
                j16 = this.f345397b.addAndGet(-o());
            }
            this.f345397b.addAndGet(j3);
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            file.setLastModified(valueOf.longValue());
            this.f345401f.put(file, valueOf);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean n(String str) {
            return k(str).delete();
        }

        private long o() {
            File file;
            if (this.f345401f.isEmpty()) {
                return 0L;
            }
            Set<Map.Entry<File, Long>> entrySet = this.f345401f.entrySet();
            synchronized (this.f345401f) {
                file = null;
                Long l3 = null;
                for (Map.Entry<File, Long> entry : entrySet) {
                    if (file == null) {
                        file = entry.getKey();
                        l3 = entry.getValue();
                    } else {
                        Long value = entry.getValue();
                        if (value.longValue() < l3.longValue()) {
                            file = entry.getKey();
                            l3 = value;
                        }
                    }
                }
            }
            if (file == null) {
                return 0L;
            }
            long j3 = j(file);
            if (file.delete()) {
                this.f345401f.remove(file);
            }
            return j3;
        }

        ACacheManager(File file, long j3, int i3) {
            this.f345401f = Collections.synchronizedMap(new HashMap());
            this.f345396a = file;
            this.f345399d = j3;
            this.f345400e = i3;
            this.f345397b = new AtomicLong();
            this.f345398c = new AtomicInteger();
            i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public static class b {
        /* JADX INFO: Access modifiers changed from: private */
        public static byte[] d(byte[] bArr) {
            if (h(bArr)) {
                return e(bArr, i(bArr, TokenParser.SP) + 1, bArr.length);
            }
            return bArr;
        }

        private static byte[] e(byte[] bArr, int i3, int i16) {
            int i17 = i16 - i3;
            if (i17 >= 0) {
                byte[] bArr2 = new byte[i17];
                System.arraycopy(bArr, i3, bArr2, 0, Math.min(bArr.length - i3, i17));
                return bArr2;
            }
            throw new IllegalArgumentException(i3 + " > " + i16);
        }

        private static String f(int i3) {
            String str = System.currentTimeMillis() + "";
            while (str.length() < 13) {
                str = "0" + str;
            }
            return str + "-" + i3 + TokenParser.SP;
        }

        private static String[] g(byte[] bArr) {
            if (h(bArr)) {
                return new String[]{new String(e(bArr, 0, 13)), new String(e(bArr, 14, i(bArr, TokenParser.SP)))};
            }
            return null;
        }

        private static boolean h(byte[] bArr) {
            if (bArr != null && bArr.length > 15 && bArr[13] == 45 && i(bArr, TokenParser.SP) > 14) {
                return true;
            }
            return false;
        }

        private static int i(byte[] bArr, char c16) {
            for (int i3 = 0; i3 < bArr.length; i3++) {
                if (bArr[i3] == c16) {
                    return i3;
                }
            }
            return -1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean j(byte[] bArr) {
            String[] g16 = g(bArr);
            if (g16 != null && g16.length == 2) {
                String str = g16[0];
                while (str.startsWith("0")) {
                    str = str.substring(1, str.length());
                }
                try {
                    if (System.currentTimeMillis() > Long.valueOf(str).longValue() + (Long.valueOf(g16[1]).longValue() * 1000)) {
                        return true;
                    }
                } catch (Exception unused) {
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static byte[] k(int i3, byte[] bArr) {
            byte[] bytes = f(i3).getBytes();
            byte[] bArr2 = new byte[bytes.length + bArr.length];
            System.arraycopy(bytes, 0, bArr2, 0, bytes.length);
            System.arraycopy(bArr, 0, bArr2, bytes.length, bArr.length);
            return bArr2;
        }
    }

    LocalCache(File file, long j3, int i3) throws Exception {
        if (!file.exists() && !file.mkdirs()) {
            this.f345395a = null;
        } else {
            this.f345395a = new ACacheManager(file, j3, i3);
        }
    }

    public static LocalCache a(Context context) {
        return b(context, "LocalCache");
    }

    public static LocalCache b(Context context, String str) {
        return c(new File(context.getCacheDir(), str), 50000000L, Integer.MAX_VALUE);
    }

    public static LocalCache c(File file, long j3, int i3) {
        LocalCache localCache;
        try {
            localCache = f345394b.get(file.getAbsoluteFile() + f());
        } catch (Exception e16) {
            d.b("MediaPlayerMgr[LocalCache.java]", e16);
            localCache = null;
        }
        if (localCache == null) {
            try {
                LocalCache localCache2 = new LocalCache(file, j3, i3);
                try {
                    f345394b.put(file.getAbsolutePath() + f(), localCache2);
                    return localCache2;
                } catch (Throwable th5) {
                    th = th5;
                    localCache = localCache2;
                    d.b("MediaPlayerMgr[LocalCache.java]", th);
                    return localCache;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        } else {
            return localCache;
        }
    }

    private static String f() {
        return "_" + Process.myPid();
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0066: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]) (LINE:103), block:B:58:0x0066 */
    public byte[] d(String str) {
        RandomAccessFile randomAccessFile;
        RandomAccessFile randomAccessFile2;
        ACacheManager aCacheManager = this.f345395a;
        RandomAccessFile randomAccessFile3 = null;
        try {
            if (aCacheManager != null) {
                try {
                    File k3 = aCacheManager.k(str);
                    if (!k3.exists()) {
                        return null;
                    }
                    randomAccessFile2 = new RandomAccessFile(k3, "r");
                    try {
                        byte[] bArr = new byte[(int) randomAccessFile2.length()];
                        if (randomAccessFile2.read(bArr) > 0) {
                            if (!b.j(bArr)) {
                                byte[] d16 = b.d(bArr);
                                try {
                                    randomAccessFile2.close();
                                } catch (IOException e16) {
                                    d.b("MediaPlayerMgr[LocalCache.java]", e16);
                                }
                                return d16;
                            }
                            try {
                                randomAccessFile2.close();
                            } catch (IOException e17) {
                                d.b("MediaPlayerMgr[LocalCache.java]", e17);
                            }
                            k(str);
                            return null;
                        }
                        try {
                            randomAccessFile2.close();
                        } catch (IOException e18) {
                            d.b("MediaPlayerMgr[LocalCache.java]", e18);
                        }
                        return null;
                    } catch (Exception e19) {
                        e = e19;
                        d.b("MediaPlayerMgr[LocalCache.java]", e);
                        if (randomAccessFile2 != null) {
                            try {
                                randomAccessFile2.close();
                            } catch (IOException e26) {
                                d.b("MediaPlayerMgr[LocalCache.java]", e26);
                            }
                        }
                        return null;
                    }
                } catch (Exception e27) {
                    e = e27;
                    randomAccessFile2 = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (randomAccessFile3 != null) {
                        try {
                            randomAccessFile3.close();
                        } catch (IOException e28) {
                            d.b("MediaPlayerMgr[LocalCache.java]", e28);
                        }
                    }
                    throw th;
                }
            } else {
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            randomAccessFile3 = randomAccessFile;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v1, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.io.ObjectInputStream] */
    /* JADX WARN: Type inference failed for: r6v5 */
    public Object e(String str) {
        ByteArrayInputStream byteArrayInputStream;
        ObjectInputStream objectInputStream;
        ?? d16 = d(str);
        try {
            if (d16 == 0) {
                return null;
            }
            try {
                byteArrayInputStream = new ByteArrayInputStream(d16);
            } catch (Exception e16) {
                e = e16;
                objectInputStream = null;
                byteArrayInputStream = null;
            } catch (Throwable th5) {
                byteArrayInputStream = null;
                th = th5;
                d16 = 0;
            }
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
            } catch (Exception e17) {
                e = e17;
                objectInputStream = null;
            } catch (Throwable th6) {
                th = th6;
                d16 = 0;
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e18) {
                        d.b("MediaPlayerMgr[LocalCache.java]", e18);
                    }
                }
                if (d16 != 0) {
                    try {
                        d16.close();
                        throw th;
                    } catch (IOException e19) {
                        d.b("MediaPlayerMgr[LocalCache.java]", e19);
                        throw th;
                    }
                }
                throw th;
            }
            try {
                Object readObject = objectInputStream.readObject();
                try {
                    byteArrayInputStream.close();
                } catch (IOException e26) {
                    d.b("MediaPlayerMgr[LocalCache.java]", e26);
                }
                try {
                    objectInputStream.close();
                } catch (IOException e27) {
                    d.b("MediaPlayerMgr[LocalCache.java]", e27);
                }
                return readObject;
            } catch (Exception e28) {
                e = e28;
                d.b("MediaPlayerMgr[LocalCache.java]", e);
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e29) {
                        d.b("MediaPlayerMgr[LocalCache.java]", e29);
                    }
                }
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e36) {
                        d.b("MediaPlayerMgr[LocalCache.java]", e36);
                    }
                }
                return null;
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }

    public void g(String str, Serializable serializable) {
        h(str, serializable, -1);
    }

    public void h(String str, Serializable serializable, int i3) {
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                } catch (Exception e16) {
                    e = e16;
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    objectOutputStream.writeObject(serializable);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    if (i3 != -1) {
                        j(str, byteArray, i3);
                    } else {
                        i(str, byteArray);
                    }
                    objectOutputStream.close();
                } catch (Exception e17) {
                    e = e17;
                    objectOutputStream2 = objectOutputStream;
                    d.b("MediaPlayerMgr[LocalCache.java]", e);
                    if (objectOutputStream2 != null) {
                        objectOutputStream2.close();
                    }
                } catch (Throwable th6) {
                    th = th6;
                    objectOutputStream2 = objectOutputStream;
                    d.b("MediaPlayerMgr[LocalCache.java]", th);
                    if (objectOutputStream2 != null) {
                        objectOutputStream2.close();
                    }
                }
            } catch (Throwable th7) {
                if (objectOutputStream2 != null) {
                    try {
                        objectOutputStream2.close();
                    } catch (Throwable th8) {
                        d.b("MediaPlayerMgr[LocalCache.java]", th8);
                    }
                }
                throw th7;
            }
        } catch (Throwable th9) {
            d.b("MediaPlayerMgr[LocalCache.java]", th9);
        }
    }

    public void i(String str, byte[] bArr) {
        ACacheManager aCacheManager = this.f345395a;
        if (aCacheManager != null) {
            File l3 = aCacheManager.l(str);
            FileOutputStream fileOutputStream = null;
            try {
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(l3);
                    try {
                        fileOutputStream2.write(bArr);
                    } catch (Exception e16) {
                        e = e16;
                        fileOutputStream = fileOutputStream2;
                        d.b("MediaPlayerMgr[LocalCache.java]", e);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.flush();
                                fileOutputStream.close();
                            } catch (IOException e17) {
                                e = e17;
                                d.b("MediaPlayerMgr[LocalCache.java]", e);
                                this.f345395a.m(l3);
                            }
                        }
                        this.f345395a.m(l3);
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.flush();
                                fileOutputStream.close();
                            } catch (IOException e18) {
                                d.b("MediaPlayerMgr[LocalCache.java]", e18);
                            }
                        }
                        this.f345395a.m(l3);
                        throw th;
                    }
                    try {
                        fileOutputStream2.flush();
                        fileOutputStream2.close();
                    } catch (IOException e19) {
                        e = e19;
                        d.b("MediaPlayerMgr[LocalCache.java]", e);
                        this.f345395a.m(l3);
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (Exception e26) {
                e = e26;
            }
            this.f345395a.m(l3);
        }
    }

    public void j(String str, byte[] bArr, int i3) {
        i(str, b.k(i3, bArr));
    }

    public boolean k(String str) {
        ACacheManager aCacheManager = this.f345395a;
        if (aCacheManager != null) {
            return aCacheManager.n(str);
        }
        return false;
    }
}
