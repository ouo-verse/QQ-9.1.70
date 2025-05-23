package com.tencent.luggage.wxa.tn;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Debug;
import android.os.Handler;
import android.os.Message;
import com.tencent.luggage.wxa.tn.e0;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.io.Closeable;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.zip.GZIPOutputStream;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    public static final WeakHashMap f141544a = new WeakHashMap();

    /* renamed from: b, reason: collision with root package name */
    public static final Handler f141545b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f141546c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements e0.a {
        @Override // com.tencent.luggage.wxa.tn.e0.a
        public boolean a() {
            c.a();
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements Handler.Callback {

        /* renamed from: a, reason: collision with root package name */
        public boolean f141547a = false;

        /* renamed from: b, reason: collision with root package name */
        public long f141548b = 0;

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            PrintWriter printWriter;
            boolean unused = c.f141546c = false;
            Runtime runtime = Runtime.getRuntime();
            long j3 = runtime.totalMemory();
            long freeMemory = runtime.freeMemory();
            long j16 = j3 - freeMemory;
            w.d("MicroMsg.BitmapTracer", "Memory level: %s (+%s) / %s", c.b(j16), c.b(freeMemory), c.b(runtime.maxMemory()));
            if (!this.f141547a && j16 > 209715200) {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f141548b > 180000) {
                    System.gc();
                    this.f141548b = currentTimeMillis;
                    return true;
                }
                PrintWriter printWriter2 = null;
                try {
                    try {
                        printWriter = new PrintWriter(new GZIPOutputStream(new FileOutputStream(com.tencent.luggage.wxa.db.a.e() + "BitmapTraces.txt.gz")));
                        try {
                            c.b(printWriter, 0L, -1);
                        } catch (Exception e16) {
                            e = e16;
                            printWriter2 = printWriter;
                            w.a("MicroMsg.BitmapTracer", e, "", new Object[0]);
                            printWriter = printWriter2;
                            w0.a((Closeable) printWriter);
                            Debug.dumpHprofData(com.tencent.luggage.wxa.db.a.e() + "Memory.hprof");
                            this.f141547a = true;
                            return true;
                        } catch (Throwable th5) {
                            th = th5;
                            printWriter2 = printWriter;
                            w0.a((Closeable) printWriter2);
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (Exception e17) {
                    e = e17;
                }
                w0.a((Closeable) printWriter);
                try {
                    Debug.dumpHprofData(com.tencent.luggage.wxa.db.a.e() + "Memory.hprof");
                } catch (Exception e18) {
                    w.a("MicroMsg.BitmapTracer", e18, "", new Object[0]);
                }
                this.f141547a = true;
            }
            return true;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.tn.c$c, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6768c extends Writer {

        /* renamed from: a, reason: collision with root package name */
        public StringWriter f141549a;

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            flush();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            StringWriter stringWriter = this.f141549a;
            if (stringWriter == null) {
                return;
            }
            String stringWriter2 = stringWriter.toString();
            this.f141549a = null;
            w.f("MicroMsg.BitmapTracer", stringWriter2);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i3, int i16) {
            if (this.f141549a == null) {
                this.f141549a = new StringWriter();
            }
            this.f141549a.write(cArr, i3, i16);
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class d {

        /* renamed from: a, reason: collision with root package name */
        public final StackTraceElement[] f141550a;

        /* renamed from: b, reason: collision with root package name */
        public final String f141551b;

        /* renamed from: c, reason: collision with root package name */
        public final BitmapFactory.Options f141552c;

        /* renamed from: d, reason: collision with root package name */
        public final long f141553d;

        public d(String str, BitmapFactory.Options options) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            this.f141550a = (StackTraceElement[]) Arrays.copyOfRange(stackTrace, 4, stackTrace.length);
            this.f141551b = str;
            this.f141552c = options;
            this.f141553d = System.currentTimeMillis();
        }
    }

    static {
        if (b()) {
            f141545b = null;
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("BitmapBriefTracer");
            baseHandlerThread.start();
            new e0(baseHandlerThread.getLooper(), (e0.a) new a(), true).a(120000L);
            return;
        }
        BaseHandlerThread baseHandlerThread2 = new BaseHandlerThread("BitmapTracer");
        baseHandlerThread2.start();
        f141545b = new Handler(baseHandlerThread2.getLooper(), new b());
    }

    public static boolean b() {
        return false;
    }

    public static String b(long j3) {
        return j3 >= 1073741824 ? String.format("%.2f GB", Double.valueOf(j3 / 1.073741824E9d)) : j3 >= 1048576 ? String.format("%.2f MB", Double.valueOf(j3 / 1048576.0d)) : j3 >= 1024 ? String.format("%.2f kB", Double.valueOf(j3 / 1024.0d)) : String.format("%d bytes", Long.valueOf(j3));
    }

    public static void a() {
        a(2097152L, 3);
    }

    public static void a(long j3, int i3) {
        b(new PrintWriter((Writer) new C6768c(), false), j3, i3);
    }

    public static void b(PrintWriter printWriter, long j3, int i3) {
        int i16;
        int i17;
        Bitmap bitmap;
        d dVar;
        long j16 = 0;
        if (j3 > 0) {
            printWriter.format("Statistics for all Bitmaps larger than %.2f MB:\n", Double.valueOf(j3 / 1048576.0d));
        } else {
            printWriter.print("Statistics for all Bitmaps alive:\n");
        }
        printWriter.flush();
        long currentTimeMillis = System.currentTimeMillis();
        WeakHashMap weakHashMap = f141544a;
        synchronized (weakHashMap) {
            ArrayList arrayList = new ArrayList();
            try {
                arrayList.addAll(weakHashMap.entrySet());
                Iterator it = arrayList.iterator();
                int i18 = 0;
                i16 = 0;
                Bitmap bitmap2 = null;
                d dVar2 = null;
                long j17 = 0;
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    Bitmap bitmap3 = (Bitmap) entry.getKey();
                    Iterator it5 = it;
                    d dVar3 = (d) entry.getValue();
                    if (bitmap3 != null) {
                        if (bitmap3.isRecycled()) {
                            i18++;
                        } else {
                            int i19 = i18;
                            long allocationByteCount = bitmap3.getAllocationByteCount();
                            long j18 = j16 + allocationByteCount;
                            int i26 = i16 + 1;
                            if (bitmap2 != null) {
                                Bitmap bitmap4 = bitmap2;
                                d dVar4 = dVar2;
                                if (allocationByteCount <= bitmap2.getAllocationByteCount()) {
                                    bitmap2 = bitmap4;
                                    dVar2 = dVar4;
                                    if (allocationByteCount >= j3 && (i3 == -1 || j17 < i3)) {
                                        j17++;
                                        printWriter.append('#').println(i26);
                                        a(printWriter, bitmap3, dVar3, currentTimeMillis);
                                    }
                                    i16 = i26;
                                    i18 = i19;
                                    it = it5;
                                    j16 = j18;
                                }
                            }
                            dVar2 = dVar3;
                            bitmap2 = bitmap3;
                            if (allocationByteCount >= j3) {
                                j17++;
                                printWriter.append('#').println(i26);
                                a(printWriter, bitmap3, dVar3, currentTimeMillis);
                            }
                            i16 = i26;
                            i18 = i19;
                            it = it5;
                            j16 = j18;
                        }
                    }
                    it = it5;
                }
                i17 = i18;
                bitmap = bitmap2;
                dVar = dVar2;
            } catch (ConcurrentModificationException unused) {
                printWriter.print("ConcurrentModificationException occur.");
                printWriter.flush();
                printWriter.close();
                return;
            }
        }
        if (bitmap != null && dVar != null) {
            printWriter.append("# Biggest Bitmap");
            a(printWriter, bitmap, dVar, currentTimeMillis);
        }
        printWriter.format("\n\nLiving Bitmaps: %d, %s\n", Integer.valueOf(i16), b(j16));
        printWriter.append("Recycled Bitmaps: ").println(i17);
        printWriter.flush();
        printWriter.close();
    }

    public static Bitmap a(Bitmap bitmap) {
        return a(bitmap, (String) null, (BitmapFactory.Options) null);
    }

    public static Bitmap a(Bitmap bitmap, String str, BitmapFactory.Options options) {
        if (bitmap == null) {
            return null;
        }
        if (bitmap.getAllocationByteCount() < 1048576 && !b()) {
            return bitmap;
        }
        d dVar = new d(str, options);
        WeakHashMap weakHashMap = f141544a;
        synchronized (weakHashMap) {
            weakHashMap.put(bitmap, dVar);
            Handler handler = f141545b;
            if (handler != null && !f141546c) {
                handler.sendEmptyMessageDelayed(0, 5000L);
                f141546c = true;
            }
        }
        return bitmap;
    }

    public static void a(StackTraceElement[] stackTraceElementArr, PrintWriter printWriter) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            printWriter.append("  at ").println(stackTraceElement.toString());
        }
    }

    public static void a(PrintWriter printWriter, Bitmap bitmap, d dVar, long j3) {
        Bitmap.Config config = bitmap.getConfig();
        Object[] objArr = new Object[4];
        objArr[0] = b(bitmap.getAllocationByteCount());
        objArr[1] = Integer.valueOf(bitmap.getWidth());
        objArr[2] = Integer.valueOf(bitmap.getHeight());
        objArr[3] = config == null ? "UNKNOWN" : config.name();
        printWriter.format("\nSize: %s (%d x %d, %s)\n", objArr);
        printWriter.append("Source: ").println(dVar.f141551b);
        printWriter.format("Acquired: %d seconds ago\n", Long.valueOf((j3 - dVar.f141553d) / 1000));
        printWriter.print("Stack:\n");
        a(dVar.f141550a, printWriter);
        printWriter.print("=======================================================\n");
        printWriter.flush();
    }
}
