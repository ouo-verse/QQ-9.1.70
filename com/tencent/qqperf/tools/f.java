package com.tencent.qqperf.tools;

import android.annotation.SuppressLint;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.commonsdk.pool.ByteArrayPool;
import com.tencent.commonsdk.pool.RecyclablePool;
import com.tencent.commonsdk.util.StringUtils;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static final RecyclablePool f363415a = new RecyclablePool(a.class, 30);

    /* renamed from: b, reason: collision with root package name */
    public static long f363416b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static int f363417c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static a f363418d = i();

    /* renamed from: e, reason: collision with root package name */
    private static Map<String, a> f363419e = new HashMap(30);

    /* renamed from: f, reason: collision with root package name */
    private static int f363420f = 0;

    /* renamed from: g, reason: collision with root package name */
    private static long f363421g = 0;

    /* renamed from: h, reason: collision with root package name */
    private static long f363422h = 0;

    /* renamed from: i, reason: collision with root package name */
    static int[] f363423i = new int[17];

    /* renamed from: j, reason: collision with root package name */
    static int[] f363424j = new int[17];

    /* renamed from: k, reason: collision with root package name */
    public static int f363425k = -1;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class a extends RecyclablePool.Recyclable {

        /* renamed from: h, reason: collision with root package name */
        public String f363426h;

        /* renamed from: i, reason: collision with root package name */
        public long f363427i;

        /* renamed from: j, reason: collision with root package name */
        public long f363428j;

        /* renamed from: k, reason: collision with root package name */
        public long f363429k;

        /* renamed from: l, reason: collision with root package name */
        public long f363430l;

        /* renamed from: m, reason: collision with root package name */
        public int f363431m;

        @Override // com.tencent.commonsdk.pool.RecyclablePool.Recyclable
        public void recycle() {
            super.recycle();
        }
    }

    public static long a(String str) {
        Object[] c16 = c(str);
        if (c16 == null) {
            return -1L;
        }
        return ((Long) c16[1]).longValue() + ((Long) c16[2]).longValue();
    }

    private static void b(String str, a aVar, boolean z16) {
        String str2;
        long j3;
        long j16;
        try {
            Object[] c16 = c(str);
            if (c16 != null) {
                str2 = (String) c16[0];
                j3 = ((Long) c16[1]).longValue();
                j16 = ((Long) c16[2]).longValue();
            } else {
                str2 = null;
                j3 = -100;
                j16 = -100;
            }
            if (z16) {
                aVar.f363427i = j3;
                aVar.f363428j = j16;
                aVar.f363426h = str2;
                return;
            }
            long j17 = aVar.f363427i;
            if (j17 == -100) {
                aVar.f363429k = -100L;
                aVar.f363430l = -100L;
            } else {
                aVar.f363429k = j3 - j17;
                aVar.f363430l = j16 - aVar.f363428j;
            }
        } catch (Exception unused) {
        }
    }

    public static Object[] c(String str) {
        RandomAccessFile g16 = g(str);
        byte[] buf = ByteArrayPool.getGenericInstance().getBuf(1024);
        try {
            g16.seek(0L);
            int read = g16.read(buf);
            int i3 = 0;
            int i16 = 0;
            while (i3 < read && i16 < 17) {
                while (i3 < read && buf[i3] == 32) {
                    i3++;
                }
                if (i3 < read) {
                    f363423i[i16] = i3;
                }
                while (i3 < read && buf[i3] != 32) {
                    i3++;
                }
                if (i3 < read) {
                    f363424j[i16] = i3;
                }
                i16++;
            }
            if (i16 == 17) {
                if (!"-2".equals(str)) {
                    int i17 = f363423i[1];
                    String str2 = new String(buf, i17 + 1, (f363424j[1] - i17) - 1);
                    int i18 = f363423i[13];
                    long parseLong = Long.parseLong(new String(buf, i18, f363424j[13] - i18));
                    int i19 = f363423i[15];
                    Long valueOf = Long.valueOf(parseLong + Long.parseLong(new String(buf, i19, f363424j[15] - i19)));
                    int i26 = f363423i[14];
                    long parseLong2 = Long.parseLong(new String(buf, i26, f363424j[14] - i26));
                    int i27 = f363423i[16];
                    Object[] objArr = {str2, valueOf, Long.valueOf(parseLong2 + Long.parseLong(new String(buf, i27, f363424j[16] - i27)))};
                    ByteArrayPool.getGenericInstance().returnBuf(buf);
                    try {
                        g16.close();
                    } catch (Exception unused) {
                    }
                    return objArr;
                }
                int i28 = f363423i[4];
                Long valueOf2 = Long.valueOf(Long.parseLong(new String(buf, i28, f363424j[4] - i28)));
                int i29 = f363423i[1];
                long parseLong3 = Long.parseLong(new String(buf, i29, f363424j[1] - i29));
                int i36 = f363423i[2];
                long parseLong4 = parseLong3 + Long.parseLong(new String(buf, i36, f363424j[2] - i36));
                int i37 = f363423i[3];
                long parseLong5 = parseLong4 + Long.parseLong(new String(buf, i37, f363424j[3] - i37));
                int i38 = f363423i[5];
                long parseLong6 = parseLong5 + Long.parseLong(new String(buf, i38, f363424j[5] - i38));
                int i39 = f363423i[6];
                long parseLong7 = parseLong6 + Long.parseLong(new String(buf, i39, f363424j[6] - i39));
                int i46 = f363423i[7];
                long parseLong8 = parseLong7 + Long.parseLong(new String(buf, i46, f363424j[7] - i46));
                int i47 = f363423i[8];
                Object[] objArr2 = {"device", valueOf2, Long.valueOf(parseLong8 + Long.parseLong(new String(buf, i47, f363424j[8] - i47)))};
                ByteArrayPool.getGenericInstance().returnBuf(buf);
                try {
                    g16.close();
                } catch (Exception unused2) {
                }
                return objArr2;
            }
        } catch (Exception unused3) {
        } catch (Throwable th5) {
            ByteArrayPool.getGenericInstance().returnBuf(buf);
            try {
                g16.close();
            } catch (Exception unused4) {
            }
            throw th5;
        }
        ByteArrayPool.getGenericInstance().returnBuf(buf);
        try {
            g16.close();
            return null;
        } catch (Exception unused5) {
            return null;
        }
    }

    public static final String d(int i3) {
        try {
            StringBuilder sb5 = new StringBuilder(i3 * 110);
            b("-1", f363418d, false);
            Log.d("CpuUsage", "read app :" + f363418d.f363427i + ", " + f363418d.f363428j);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(RuntimeMonitor.exec(Runtime.getRuntime(), "top -m " + i3 + " -s cpu -n 1").getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb5.append(readLine);
                    sb5.append("\r\n");
                } else {
                    b("-1", f363418d, false);
                    Log.d("CpuUsage", "read app :" + f363418d.f363427i + ", " + f363418d.f363428j);
                    return sb5.toString();
                }
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public static final List<String> e(int i3, boolean z16) {
        int i16;
        HashMap hashMap = new HashMap();
        if (z16) {
            ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
            int activeCount = threadGroup.activeCount();
            Thread[] threadArr = new Thread[activeCount];
            threadGroup.enumerate(threadArr);
            hashMap = new HashMap(activeCount);
            for (int i17 = 0; i17 < activeCount; i17++) {
                Thread thread = threadArr[i17];
                if (thread != null) {
                    hashMap.put(thread.getName(), thread);
                }
            }
        }
        ArrayList arrayList = new ArrayList(f363419e.size() / 2);
        for (String str : f363419e.keySet()) {
            a aVar = f363419e.get(str);
            if (aVar.f363431m >= i3) {
                if (z16) {
                    i16 = 300;
                } else {
                    i16 = 50;
                }
                StringBuilder sb5 = new StringBuilder(i16);
                sb5.append(aVar.f363426h);
                sb5.append("_");
                sb5.append(str);
                sb5.append(":");
                sb5.append(aVar.f363431m);
                sb5.append("\r\n");
                if (z16) {
                    Thread thread2 = (Thread) hashMap.get(aVar.f363426h);
                    if (thread2 != null) {
                        sb5.append(Arrays.toString(thread2.getStackTrace()));
                    }
                    char[] stringValue = StringUtils.getStringValue(sb5);
                    if (stringValue != null) {
                        arrayList.add(StringUtils.newStringWithData(stringValue));
                    } else {
                        arrayList.add(sb5.toString());
                    }
                }
            }
        }
        if (z16) {
            arrayList.add(Arrays.toString(Looper.getMainLooper().getThread().getStackTrace()));
        }
        return arrayList;
    }

    @SuppressLint({"NewApi"})
    public static final int f() {
        if (f363425k == -1) {
            f363425k = Runtime.getRuntime().availableProcessors();
        }
        return f363425k;
    }

    private static final RandomAccessFile g(String str) {
        RandomAccessFile randomAccessFile;
        try {
            if (str.equals("-2")) {
                randomAccessFile = new RandomAccessFile("/proc/stat", "r");
            } else if (str.equals("-1")) {
                randomAccessFile = new RandomAccessFile("/proc/" + Process.myPid() + "/stat", "r");
            } else {
                randomAccessFile = new RandomAccessFile("/proc/" + Process.myPid() + "/task/" + str + "/stat", "r");
            }
            return randomAccessFile;
        } catch (FileNotFoundException e16) {
            e16.printStackTrace();
            return null;
        } catch (OutOfMemoryError e17) {
            e17.printStackTrace();
            return null;
        }
    }

    private static final String[] h(long j3) {
        File file = new File("/proc/" + j3 + "/task");
        if (file.exists() && file.isDirectory()) {
            return file.list();
        }
        return null;
    }

    public static a i() {
        return (a) f363415a.obtain(a.class);
    }

    public static void j(a aVar) {
        aVar.recycle();
    }

    public static void k(boolean z16) {
        long j3;
        long j16;
        byte[] buf = ByteArrayPool.getGenericInstance().getBuf(1024);
        try {
            Object[] c16 = c("-2");
            if (c16 != null) {
                j3 = ((Long) c16[1]).longValue();
                j16 = ((Long) c16[2]).longValue();
            } else {
                j3 = -1;
                j16 = -1;
            }
            long j17 = ((j3 + j16) - f363422h) - f363421g;
            b("-1", f363418d, false);
            if (z16) {
                for (String str : f363419e.keySet()) {
                    a aVar = f363419e.get(str);
                    b(str, aVar, false);
                    aVar.f363431m = (int) (((aVar.f363430l + aVar.f363429k) * 100) / j17);
                }
            }
            f363417c = (int) (((j16 - f363422h) * 100) / j17);
            a aVar2 = f363418d;
            aVar2.f363431m = (int) (((aVar2.f363430l + aVar2.f363429k) * 100) / j17);
            f363416b = SystemClock.uptimeMillis();
        } catch (Exception unused) {
        } catch (Throwable th5) {
            ByteArrayPool.getGenericInstance().returnBuf(buf);
            throw th5;
        }
        ByteArrayPool.getGenericInstance().returnBuf(buf);
    }

    public static void l(boolean z16) {
        byte[] buf = ByteArrayPool.getGenericInstance().getBuf(1024);
        try {
            try {
                Object[] c16 = c("-2");
                if (c16 != null) {
                    f363421g = ((Long) c16[1]).longValue();
                    f363422h = ((Long) c16[2]).longValue();
                } else {
                    f363421g = -1L;
                    f363422h = -1L;
                }
                b("-1", f363418d, true);
                if (z16) {
                    Iterator<a> it = f363419e.values().iterator();
                    while (it.hasNext()) {
                        j(it.next());
                    }
                    f363419e.clear();
                    String[] h16 = h(Process.myPid());
                    if (h16 != null) {
                        for (String str : h16) {
                            a i3 = i();
                            b(str, i3, true);
                            f363419e.put(str, i3);
                        }
                    }
                }
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } finally {
            ByteArrayPool.getGenericInstance().returnBuf(buf);
        }
    }
}
