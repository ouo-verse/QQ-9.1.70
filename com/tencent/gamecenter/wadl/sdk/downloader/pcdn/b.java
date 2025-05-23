package com.tencent.gamecenter.wadl.sdk.downloader.pcdn;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.gamecenter.wadl.sdk.common.e.g;
import java.io.File;
import java.io.FileInputStream;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b {

    /* renamed from: j, reason: collision with root package name */
    private static final ConcurrentSkipListMap<String, Float> f107430j = new ConcurrentSkipListMap<>();

    /* renamed from: k, reason: collision with root package name */
    private static final Set<String> f107431k = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    private AtomicInteger f107433b;

    /* renamed from: i, reason: collision with root package name */
    private a f107440i;

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentSkipListMap<Integer, File> f107432a = new ConcurrentSkipListMap<>();

    /* renamed from: c, reason: collision with root package name */
    private int f107434c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f107435d = 0;

    /* renamed from: e, reason: collision with root package name */
    private long f107436e = 0;

    /* renamed from: f, reason: collision with root package name */
    private long f107437f = 0;

    /* renamed from: g, reason: collision with root package name */
    private long f107438g = 0;

    /* renamed from: h, reason: collision with root package name */
    private String f107439h = "";

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public interface a {
        void a(int i3);

        void a(byte[] bArr, int i3, String str);
    }

    private Integer a(long j3) {
        return Integer.valueOf((int) (j3 / 32768));
    }

    private Integer b(long j3) {
        return Integer.valueOf((int) (j3 % 32768));
    }

    private static String c(String str) {
        String str2;
        PCDNInitParam pCDNInitParam = com.tencent.gamecenter.wadl.sdk.common.a.f106996s;
        if (pCDNInitParam != null && !TextUtils.isEmpty(pCDNInitParam.pcdnBufferDirPath)) {
            str2 = com.tencent.gamecenter.wadl.sdk.common.a.f106996s.pcdnBufferDirPath;
        } else {
            str2 = com.tencent.gamecenter.wadl.sdk.common.a.b().getFilesDir().getAbsolutePath() + "/wadl/pcdn/buffers";
        }
        return str2 + "/" + str;
    }

    public static boolean d(String str) {
        return f107431k.contains(str);
    }

    private String a(long j3, int i3) {
        return j3 + "_" + ((j3 + (i3 == this.f107435d ? this.f107436e : i3 == this.f107434c ? this.f107437f : 32768L)) - 1) + ".txt";
    }

    private static String b(String str) {
        return c(str) + "/" + SystemClock.elapsedRealtime();
    }

    private void a() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.f107432a) {
            for (Map.Entry<Integer, File> entry : this.f107432a.entrySet()) {
                File value = entry.getValue();
                int length = (int) value.length();
                if (a(entry, length)) {
                    arrayList.add(entry.getKey());
                    if (!a(value, length)) {
                        break;
                    } else {
                        this.f107433b.incrementAndGet();
                    }
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f107432a.remove((Integer) it.next());
            }
        }
    }

    public void b() {
        try {
            g.b(this.f107439h);
            com.tencent.gamecenter.wadl.sdk.common.e.b.e("Wadl-downloader-PCDNManager", "deleteBufferDir:" + this.f107439h);
        } catch (Throwable th5) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-PCDNManager", "deleteBufferDir exception:" + th5.getMessage());
        }
    }

    private void a(int i3) {
        a aVar = this.f107440i;
        if (aVar != null) {
            aVar.a(i3);
        }
    }

    public void b(byte[] bArr, long j3) {
        a(bArr, j3);
    }

    public void a(a aVar) {
        this.f107440i = aVar;
    }

    public static void a(String str) {
        try {
            g.b(c(str));
            com.tencent.gamecenter.wadl.sdk.common.e.b.e("Wadl-downloader-PCDNManager", "deleteBufferRootDir:" + c(str));
        } catch (Exception e16) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-PCDNManager", "deleteBufferDir exception:" + e16.getMessage());
        }
    }

    public static void a(String str, float f16) {
        f107430j.put(str, Float.valueOf(f16));
    }

    public void a(String str, long j3, long j16) {
        long j17;
        f107431k.add(str);
        this.f107438g = b(j3).intValue();
        this.f107435d = a(j3).intValue();
        int intValue = a(j16).intValue();
        this.f107434c = intValue;
        if (this.f107435d == intValue) {
            j17 = (j16 - j3) + 1;
            this.f107436e = j17;
        } else {
            this.f107436e = 32768 - this.f107438g;
            j17 = (j16 % 32768) + 1;
        }
        this.f107437f = j17;
        this.f107433b = new AtomicInteger(this.f107435d);
        try {
            this.f107439h = b(str);
            File file = new File(this.f107439h);
            if (!file.exists()) {
                file.mkdirs();
            }
        } catch (Throwable th5) {
            com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-PCDNManager", "init exception:" + th5);
            a(-1000);
        }
        com.tencent.gamecenter.wadl.sdk.common.e.b.c("Wadl-downloader-PCDNManager", "init gameId:" + str + ",firstIndex:" + this.f107435d + ",firstSIze:" + this.f107436e + ",lastIndex:" + this.f107434c + ",lastSize:" + this.f107437f + ",currentFlushIndex:" + this.f107433b + ",startOffset:" + j3 + ",endOffset:" + j16 + ",bufferDirPath:" + this.f107439h + ",this:" + this);
    }

    public static void a(String str, String str2, int i3) {
        if (d(str)) {
            Float f16 = f107430j.get(str);
            c.a(str, str2, f16 != null ? f16.floatValue() : 0.0f, i3);
        }
    }

    private void a(byte[] bArr, long j3) {
        File file;
        RandomAccessFile randomAccessFile;
        if (bArr.length == 0) {
            return;
        }
        Integer a16 = a(j3);
        int intValue = b(j3).intValue();
        synchronized (this.f107432a) {
            file = this.f107432a.get(a16);
            if (file == null) {
                try {
                    file = new File(this.f107439h, a(j3, a16.intValue()));
                    this.f107432a.put(a16, file);
                } catch (Throwable th5) {
                    com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-PCDNManager", "flushIfNeeded exception:" + th5);
                    a(-1001);
                    return;
                }
            }
        }
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
        } catch (Throwable th6) {
            th = th6;
            randomAccessFile = null;
        }
        try {
            if (a16.intValue() == this.f107435d) {
                intValue = (int) (intValue - this.f107438g);
            }
            randomAccessFile.seek(intValue);
            randomAccessFile.write(bArr);
            try {
                randomAccessFile.close();
            } catch (Throwable th7) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-PCDNManager", "close exception:" + th7.getMessage());
            }
            a();
        } catch (Throwable th8) {
            th = th8;
            try {
                com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-PCDNManager", "flushIfNeeded exception:" + th);
                a(-1002);
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable th9) {
                        com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-PCDNManager", "close exception:" + th9.getMessage());
                    }
                }
            } catch (Throwable th10) {
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable th11) {
                        com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-PCDNManager", "close exception:" + th11.getMessage());
                    }
                }
                throw th10;
            }
        }
    }

    private boolean a(File file, int i3) {
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
        }
        try {
            byte[] bArr = new byte[i3];
            if (fileInputStream.read(bArr) != i3) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-PCDNManager", "Failed to read the expected amount of data from file ,this:" + hashCode());
                try {
                    fileInputStream.close();
                } catch (Throwable th6) {
                    com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-PCDNManager", "IOException:" + th6 + ",Thread:" + Thread.currentThread() + ",this:" + hashCode());
                }
                return false;
            }
            a aVar = this.f107440i;
            if (aVar != null) {
                aVar.a(bArr, i3, file.getName());
            }
            file.delete();
            try {
                fileInputStream.close();
                return true;
            } catch (Throwable th7) {
                com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-PCDNManager", "IOException:" + th7 + ",Thread:" + Thread.currentThread() + ",this:" + hashCode());
                return true;
            }
        } catch (Throwable th8) {
            th = th8;
            try {
                com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-PCDNManager", "flush exception:" + th);
                a(-1003);
                return false;
            } finally {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (Throwable th9) {
                        com.tencent.gamecenter.wadl.sdk.common.e.b.b("Wadl-downloader-PCDNManager", "IOException:" + th9 + ",Thread:" + Thread.currentThread() + ",this:" + hashCode());
                    }
                }
            }
        }
    }

    private boolean a(Map.Entry<Integer, File> entry, int i3) {
        return entry.getKey().intValue() == this.f107433b.get() && ((this.f107435d == this.f107433b.get() && ((long) i3) == this.f107436e) || ((this.f107433b.get() == this.f107434c && ((long) i3) == this.f107437f) || i3 == 32768));
    }
}
