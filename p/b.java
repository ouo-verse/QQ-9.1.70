package p;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.thread.monitor.plugin.proxy.BaseThreadPoolExecutor;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes.dex */
public final class b implements Closeable {
    private final int C;
    private Writer E;
    private int G;

    /* renamed from: d, reason: collision with root package name */
    private final File f424824d;

    /* renamed from: e, reason: collision with root package name */
    private final File f424825e;

    /* renamed from: f, reason: collision with root package name */
    private final File f424826f;

    /* renamed from: h, reason: collision with root package name */
    private final File f424827h;

    /* renamed from: i, reason: collision with root package name */
    private final int f424828i;

    /* renamed from: m, reason: collision with root package name */
    private long f424829m;
    private long D = 0;
    private final LinkedHashMap<String, d> F = new LinkedHashMap<>(0, 0.75f, true);
    private long H = 0;
    final ThreadPoolExecutor I = new BaseThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC10970b(null));
    private final Callable<Void> J = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public class a implements Callable<Void> {
        a() {
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            synchronized (b.this) {
                if (b.this.E != null) {
                    b.this.B();
                    if (b.this.s()) {
                        b.this.y();
                        b.this.G = 0;
                    }
                    return null;
                }
                return null;
            }
        }
    }

    /* compiled from: P */
    /* renamed from: p.b$b, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static final class ThreadFactoryC10970b implements ThreadFactory {
        ThreadFactoryC10970b() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            BaseThread baseThread;
            baseThread = new BaseThread(runnable, "glide-disk-lru-cache-thread");
            baseThread.setPriority(1);
            return baseThread;
        }

        /* synthetic */ ThreadFactoryC10970b(a aVar) {
            this();
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public final class c {

        /* renamed from: a, reason: collision with root package name */
        private final d f424831a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean[] f424832b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f424833c;

        /* synthetic */ c(b bVar, d dVar, a aVar) {
            this(dVar);
        }

        public void a() throws IOException {
            b.this.l(this, false);
        }

        public void b() {
            if (!this.f424833c) {
                try {
                    a();
                } catch (IOException unused) {
                }
            }
        }

        public void e() throws IOException {
            b.this.l(this, true);
            this.f424833c = true;
        }

        public File f(int i3) throws IOException {
            File k3;
            synchronized (b.this) {
                if (this.f424831a.f424840f == this) {
                    if (!this.f424831a.f424839e) {
                        this.f424832b[i3] = true;
                    }
                    k3 = this.f424831a.k(i3);
                    b.this.f424824d.mkdirs();
                } else {
                    throw new IllegalStateException();
                }
            }
            return k3;
        }

        c(d dVar) {
            this.f424831a = dVar;
            this.f424832b = dVar.f424839e ? null : new boolean[b.this.C];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes.dex */
    public final class d {

        /* renamed from: a, reason: collision with root package name */
        private final String f424835a;

        /* renamed from: b, reason: collision with root package name */
        private final long[] f424836b;

        /* renamed from: c, reason: collision with root package name */
        File[] f424837c;

        /* renamed from: d, reason: collision with root package name */
        File[] f424838d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f424839e;

        /* renamed from: f, reason: collision with root package name */
        private c f424840f;

        /* renamed from: g, reason: collision with root package name */
        private long f424841g;

        /* synthetic */ d(b bVar, String str, a aVar) {
            this(str);
        }

        private IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(String[] strArr) throws IOException {
            if (strArr.length == b.this.C) {
                for (int i3 = 0; i3 < strArr.length; i3++) {
                    try {
                        this.f424836b[i3] = Long.parseLong(strArr[i3]);
                    } catch (NumberFormatException unused) {
                        throw m(strArr);
                    }
                }
                return;
            }
            throw m(strArr);
        }

        public File j(int i3) {
            return this.f424837c[i3];
        }

        public File k(int i3) {
            return this.f424838d[i3];
        }

        public String l() throws IOException {
            StringBuilder sb5 = new StringBuilder();
            for (long j3 : this.f424836b) {
                sb5.append(TokenParser.SP);
                sb5.append(j3);
            }
            return sb5.toString();
        }

        d(String str) {
            this.f424835a = str;
            this.f424836b = new long[b.this.C];
            this.f424837c = new File[b.this.C];
            this.f424838d = new File[b.this.C];
            StringBuilder sb5 = new StringBuilder(str);
            sb5.append('.');
            int length = sb5.length();
            for (int i3 = 0; i3 < b.this.C; i3++) {
                sb5.append(i3);
                this.f424837c[i3] = new File(b.this.f424824d, sb5.toString());
                sb5.append(".tmp");
                this.f424838d[i3] = new File(b.this.f424824d, sb5.toString());
                sb5.setLength(length);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes.dex */
    public final class e {

        /* renamed from: a, reason: collision with root package name */
        private final String f424843a;

        /* renamed from: b, reason: collision with root package name */
        private final long f424844b;

        /* renamed from: c, reason: collision with root package name */
        private final long[] f424845c;

        /* renamed from: d, reason: collision with root package name */
        private final File[] f424846d;

        /* synthetic */ e(b bVar, String str, long j3, File[] fileArr, long[] jArr, a aVar) {
            this(str, j3, fileArr, jArr);
        }

        public File a(int i3) {
            return this.f424846d[i3];
        }

        e(String str, long j3, File[] fileArr, long[] jArr) {
            this.f424843a = str;
            this.f424844b = j3;
            this.f424846d = fileArr;
            this.f424845c = jArr;
        }
    }

    b(File file, int i3, int i16, long j3) {
        this.f424824d = file;
        this.f424828i = i3;
        this.f424825e = new File(file, "journal");
        this.f424826f = new File(file, "journal.tmp");
        this.f424827h = new File(file, "journal.bkp");
        this.C = i16;
        this.f424829m = j3;
    }

    private static void A(File file, File file2, boolean z16) throws IOException {
        if (z16) {
            n(file2);
        }
        if (file.renameTo(file2)) {
        } else {
            throw new IOException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() throws IOException {
        while (this.D > this.f424829m) {
            z(this.F.entrySet().iterator().next().getKey());
        }
    }

    private void j() {
        if (this.E != null) {
        } else {
            throw new IllegalStateException("cache is closed");
        }
    }

    @TargetApi(26)
    private static void k(Writer writer) throws IOException {
        StrictMode.ThreadPolicy.Builder permitUnbufferedIo;
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        permitUnbufferedIo = new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo();
        StrictMode.setThreadPolicy(permitUnbufferedIo.build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void l(c cVar, boolean z16) throws IOException {
        d dVar = cVar.f424831a;
        if (dVar.f424840f == cVar) {
            if (z16 && !dVar.f424839e) {
                for (int i3 = 0; i3 < this.C; i3++) {
                    if (cVar.f424832b[i3]) {
                        if (!dVar.k(i3).exists()) {
                            cVar.a();
                            return;
                        }
                    } else {
                        cVar.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i3);
                    }
                }
            }
            for (int i16 = 0; i16 < this.C; i16++) {
                File k3 = dVar.k(i16);
                if (z16) {
                    if (k3.exists()) {
                        File j3 = dVar.j(i16);
                        k3.renameTo(j3);
                        long j16 = dVar.f424836b[i16];
                        long length = j3.length();
                        dVar.f424836b[i16] = length;
                        this.D = (this.D - j16) + length;
                    }
                } else {
                    n(k3);
                }
            }
            this.G++;
            dVar.f424840f = null;
            if (dVar.f424839e | z16) {
                dVar.f424839e = true;
                this.E.append((CharSequence) "CLEAN");
                this.E.append(TokenParser.SP);
                this.E.append((CharSequence) dVar.f424835a);
                this.E.append((CharSequence) dVar.l());
                this.E.append('\n');
                if (z16) {
                    long j17 = this.H;
                    this.H = 1 + j17;
                    dVar.f424841g = j17;
                }
            } else {
                this.F.remove(dVar.f424835a);
                this.E.append((CharSequence) "REMOVE");
                this.E.append(TokenParser.SP);
                this.E.append((CharSequence) dVar.f424835a);
                this.E.append('\n');
            }
            q(this.E);
            if (this.D > this.f424829m || s()) {
                this.I.submit(this.J);
            }
            return;
        }
        throw new IllegalStateException();
    }

    private static void n(File file) throws IOException {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private synchronized c p(String str, long j3) throws IOException {
        j();
        d dVar = this.F.get(str);
        a aVar = null;
        if (j3 != -1 && (dVar == null || dVar.f424841g != j3)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(this, str, aVar);
            this.F.put(str, dVar);
        } else if (dVar.f424840f != null) {
            return null;
        }
        c cVar = new c(this, dVar, aVar);
        dVar.f424840f = cVar;
        this.E.append((CharSequence) "DIRTY");
        this.E.append(TokenParser.SP);
        this.E.append((CharSequence) str);
        this.E.append('\n');
        q(this.E);
        return cVar;
    }

    @TargetApi(26)
    private static void q(Writer writer) throws IOException {
        StrictMode.ThreadPolicy.Builder permitUnbufferedIo;
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        permitUnbufferedIo = new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo();
        StrictMode.setThreadPolicy(permitUnbufferedIo.build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s() {
        int i3 = this.G;
        if (i3 >= 2000 && i3 >= this.F.size()) {
            return true;
        }
        return false;
    }

    public static b t(File file, int i3, int i16, long j3) throws IOException {
        if (j3 > 0) {
            if (i16 > 0) {
                File file2 = new File(file, "journal.bkp");
                if (file2.exists()) {
                    File file3 = new File(file, "journal");
                    if (file3.exists()) {
                        file2.delete();
                    } else {
                        A(file2, file3, false);
                    }
                }
                b bVar = new b(file, i3, i16, j3);
                if (bVar.f424825e.exists()) {
                    try {
                        bVar.w();
                        bVar.u();
                        return bVar;
                    } catch (IOException e16) {
                        System.out.println("DiskLruCache " + file + " is corrupt: " + e16.getMessage() + ", removing");
                        bVar.m();
                    }
                }
                file.mkdirs();
                b bVar2 = new b(file, i3, i16, j3);
                bVar2.y();
                return bVar2;
            }
            throw new IllegalArgumentException("valueCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private void u() throws IOException {
        n(this.f424826f);
        Iterator<d> it = this.F.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i3 = 0;
            if (next.f424840f != null) {
                next.f424840f = null;
                while (i3 < this.C) {
                    n(next.j(i3));
                    n(next.k(i3));
                    i3++;
                }
                it.remove();
            } else {
                while (i3 < this.C) {
                    this.D += next.f424836b[i3];
                    i3++;
                }
            }
        }
    }

    private void w() throws IOException {
        p.c cVar = new p.c(new FileInputStream(this.f424825e), p.d.f424854a);
        try {
            String readLine = cVar.readLine();
            String readLine2 = cVar.readLine();
            String readLine3 = cVar.readLine();
            String readLine4 = cVar.readLine();
            String readLine5 = cVar.readLine();
            if ("libcore.io.DiskLruCache".equals(readLine) && "1".equals(readLine2) && Integer.toString(this.f424828i).equals(readLine3) && Integer.toString(this.C).equals(readLine4) && "".equals(readLine5)) {
                int i3 = 0;
                while (true) {
                    try {
                        x(cVar.readLine());
                        i3++;
                    } catch (EOFException unused) {
                        this.G = i3 - this.F.size();
                        if (cVar.e()) {
                            y();
                        } else {
                            this.E = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f424825e, true), p.d.f424854a));
                        }
                        p.d.a(cVar);
                        return;
                    }
                }
            } else {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
        } catch (Throwable th5) {
            p.d.a(cVar);
            throw th5;
        }
    }

    private void x(String str) throws IOException {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i3 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i3);
            if (indexOf2 == -1) {
                substring = str.substring(i3);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.F.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i3, indexOf2);
            }
            d dVar = this.F.get(substring);
            a aVar = null;
            if (dVar == null) {
                dVar = new d(this, substring, aVar);
                this.F.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.f424839e = true;
                dVar.f424840f = null;
                dVar.n(split);
                return;
            }
            if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.f424840f = new c(this, dVar, aVar);
                return;
            }
            if (indexOf2 == -1 && indexOf == 4 && str.startsWith("READ")) {
                return;
            }
            throw new IOException("unexpected journal line: " + str);
        }
        throw new IOException("unexpected journal line: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void y() throws IOException {
        Writer writer = this.E;
        if (writer != null) {
            k(writer);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f424826f), p.d.f424854a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f424828i));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.C));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (d dVar : this.F.values()) {
                if (dVar.f424840f != null) {
                    bufferedWriter.write("DIRTY " + dVar.f424835a + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + dVar.f424835a + dVar.l() + '\n');
                }
            }
            k(bufferedWriter);
            if (this.f424825e.exists()) {
                A(this.f424825e, this.f424827h, true);
            }
            A(this.f424826f, this.f424825e, false);
            this.f424827h.delete();
            this.E = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f424825e, true), p.d.f424854a));
        } catch (Throwable th5) {
            k(bufferedWriter);
            throw th5;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.E == null) {
            return;
        }
        Iterator it = new ArrayList(this.F.values()).iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.f424840f != null) {
                dVar.f424840f.a();
            }
        }
        B();
        k(this.E);
        this.E = null;
    }

    public void m() throws IOException {
        close();
        p.d.b(this.f424824d);
    }

    public c o(String str) throws IOException {
        return p(str, -1L);
    }

    public synchronized e r(String str) throws IOException {
        j();
        d dVar = this.F.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.f424839e) {
            return null;
        }
        for (File file : dVar.f424837c) {
            if (!file.exists()) {
                return null;
            }
        }
        this.G++;
        this.E.append((CharSequence) "READ");
        this.E.append(TokenParser.SP);
        this.E.append((CharSequence) str);
        this.E.append('\n');
        if (s()) {
            this.I.submit(this.J);
        }
        return new e(this, str, dVar.f424841g, dVar.f424837c, dVar.f424836b, null);
    }

    public synchronized boolean z(String str) throws IOException {
        j();
        d dVar = this.F.get(str);
        if (dVar != null && dVar.f424840f == null) {
            for (int i3 = 0; i3 < this.C; i3++) {
                File j3 = dVar.j(i3);
                if (j3.exists() && !j3.delete()) {
                    throw new IOException("failed to delete " + j3);
                }
                this.D -= dVar.f424836b[i3];
                dVar.f424836b[i3] = 0;
            }
            this.G++;
            this.E.append((CharSequence) "REMOVE");
            this.E.append(TokenParser.SP);
            this.E.append((CharSequence) str);
            this.E.append('\n');
            this.F.remove(str);
            if (s()) {
                this.I.submit(this.J);
            }
            return true;
        }
        return false;
    }
}
