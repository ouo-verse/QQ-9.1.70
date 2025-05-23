package com.tencent.qqnt.avatar.disklrucache;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
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
/* loaded from: classes23.dex */
public final class a implements Closeable {
    static IPatchRedirector $redirector_;
    private final int C;
    private long D;
    private Writer E;
    private final LinkedHashMap<String, d> F;
    private int G;
    private long H;
    final ThreadPoolExecutor I;
    private final Callable<Void> J;

    /* renamed from: d, reason: collision with root package name */
    private final File f352739d;

    /* renamed from: e, reason: collision with root package name */
    private final File f352740e;

    /* renamed from: f, reason: collision with root package name */
    private final File f352741f;

    /* renamed from: h, reason: collision with root package name */
    private final File f352742h;

    /* renamed from: i, reason: collision with root package name */
    private final int f352743i;

    /* renamed from: m, reason: collision with root package name */
    private long f352744m;

    /* compiled from: P */
    /* renamed from: com.tencent.qqnt.avatar.disklrucache.a$a, reason: collision with other inner class name */
    /* loaded from: classes23.dex */
    class CallableC9509a implements Callable<Void> {
        static IPatchRedirector $redirector_;

        CallableC9509a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Void) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            synchronized (a.this) {
                if (a.this.E != null) {
                    a.this.B();
                    if (a.this.s()) {
                        a.this.y();
                        a.this.G = 0;
                    }
                    return null;
                }
                return null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    private static final class b implements ThreadFactory {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (Thread) iPatchRedirector.redirect((short) 2, (Object) this, (Object) runnable);
            }
            BaseThread baseThread = new BaseThread(runnable, "glide-disk-lru-cache-thread");
            baseThread.setPriority(1);
            return baseThread;
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public final class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final d f352746a;

        /* renamed from: b, reason: collision with root package name */
        private final boolean[] f352747b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f352748c;

        c(d dVar) {
            boolean[] zArr;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) dVar);
                return;
            }
            this.f352746a = dVar;
            if (dVar.f352754e) {
                zArr = null;
            } else {
                zArr = new boolean[a.this.C];
            }
            this.f352747b = zArr;
        }

        public void c() throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                a.this.l(this, false);
            } else {
                iPatchRedirector.redirect((short) 6, (Object) this);
            }
        }

        public void d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this);
            } else if (!this.f352748c) {
                try {
                    c();
                } catch (IOException unused) {
                }
            }
        }

        public void e() throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
                a.this.l(this, true);
                this.f352748c = true;
            } else {
                iPatchRedirector.redirect((short) 5, (Object) this);
            }
        }

        public File f(int i3) throws IOException {
            File k3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (File) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            synchronized (a.this) {
                if (this.f352746a.f352755f == this) {
                    if (!this.f352746a.f352754e) {
                        this.f352747b[i3] = true;
                    }
                    k3 = this.f352746a.k(i3);
                    a.this.f352739d.mkdirs();
                } else {
                    throw new IllegalStateException();
                }
            }
            return k3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes23.dex */
    public final class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final String f352750a;

        /* renamed from: b, reason: collision with root package name */
        private final long[] f352751b;

        /* renamed from: c, reason: collision with root package name */
        File[] f352752c;

        /* renamed from: d, reason: collision with root package name */
        File[] f352753d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f352754e;

        /* renamed from: f, reason: collision with root package name */
        private c f352755f;

        /* renamed from: g, reason: collision with root package name */
        private long f352756g;

        d(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) str);
                return;
            }
            this.f352750a = str;
            this.f352751b = new long[a.this.C];
            this.f352752c = new File[a.this.C];
            this.f352753d = new File[a.this.C];
            StringBuilder sb5 = new StringBuilder(str);
            sb5.append('.');
            int length = sb5.length();
            for (int i3 = 0; i3 < a.this.C; i3++) {
                sb5.append(i3);
                this.f352752c[i3] = new File(a.this.f352739d, sb5.toString());
                sb5.append(".tmp");
                this.f352753d[i3] = new File(a.this.f352739d, sb5.toString());
                sb5.setLength(length);
            }
        }

        private IOException m(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n(String[] strArr) throws IOException {
            if (strArr.length == a.this.C) {
                for (int i3 = 0; i3 < strArr.length; i3++) {
                    try {
                        this.f352751b[i3] = Long.parseLong(strArr[i3]);
                    } catch (NumberFormatException unused) {
                        throw m(strArr);
                    }
                }
                return;
            }
            throw m(strArr);
        }

        public File j(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (File) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return this.f352752c[i3];
        }

        public File k(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (File) iPatchRedirector.redirect((short) 4, (Object) this, i3);
            }
            return this.f352753d[i3];
        }

        public String l() throws IOException {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            StringBuilder sb5 = new StringBuilder();
            for (long j3 : this.f352751b) {
                sb5.append(TokenParser.SP);
                sb5.append(j3);
            }
            return sb5.toString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public final class e {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private final String f352758a;

        /* renamed from: b, reason: collision with root package name */
        private final long f352759b;

        /* renamed from: c, reason: collision with root package name */
        private final long[] f352760c;

        /* renamed from: d, reason: collision with root package name */
        private final File[] f352761d;

        e(String str, long j3, File[] fileArr, long[] jArr) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, str, Long.valueOf(j3), fileArr, jArr);
                return;
            }
            this.f352758a = str;
            this.f352759b = j3;
            this.f352761d = fileArr;
            this.f352760c = jArr;
        }

        public File a(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (File) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return this.f352761d[i3];
        }
    }

    a(File file, int i3, int i16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, file, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3));
            return;
        }
        this.D = 0L;
        this.F = new LinkedHashMap<>(0, 0.75f, true);
        this.H = 0L;
        this.I = new BaseThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b());
        this.J = new CallableC9509a();
        this.f352739d = file;
        this.f352743i = i3;
        this.f352740e = new File(file, "journal");
        this.f352741f = new File(file, "journal.tmp");
        this.f352742h = new File(file, "journal.bkp");
        this.C = i16;
        this.f352744m = j3;
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
        while (this.D > this.f352744m) {
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
        d dVar = cVar.f352746a;
        if (dVar.f352755f == cVar) {
            if (z16 && !dVar.f352754e) {
                for (int i3 = 0; i3 < this.C; i3++) {
                    if (cVar.f352747b[i3]) {
                        if (!dVar.k(i3).exists()) {
                            cVar.c();
                            return;
                        }
                    } else {
                        cVar.c();
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
                        long j16 = dVar.f352751b[i16];
                        long length = j3.length();
                        dVar.f352751b[i16] = length;
                        this.D = (this.D - j16) + length;
                    }
                } else {
                    n(k3);
                }
            }
            this.G++;
            dVar.f352755f = null;
            if (dVar.f352754e | z16) {
                dVar.f352754e = true;
                this.E.append((CharSequence) "CLEAN");
                this.E.append(TokenParser.SP);
                this.E.append((CharSequence) dVar.f352750a);
                this.E.append((CharSequence) dVar.l());
                this.E.append('\n');
                if (z16) {
                    long j17 = this.H;
                    this.H = 1 + j17;
                    dVar.f352756g = j17;
                }
            } else {
                this.F.remove(dVar.f352750a);
                this.E.append((CharSequence) "REMOVE");
                this.E.append(TokenParser.SP);
                this.E.append((CharSequence) dVar.f352750a);
                this.E.append('\n');
            }
            q(this.E);
            if (this.D > this.f352744m || s()) {
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
        if (j3 != -1 && (dVar == null || dVar.f352756g != j3)) {
            return null;
        }
        if (dVar == null) {
            dVar = new d(str);
            this.F.put(str, dVar);
        } else if (dVar.f352755f != null) {
            return null;
        }
        c cVar = new c(dVar);
        dVar.f352755f = cVar;
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

    public static a t(File file, int i3, int i16, long j3) throws IOException {
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
                a aVar = new a(file, i3, i16, j3);
                if (aVar.f352740e.exists()) {
                    try {
                        aVar.w();
                        aVar.u();
                        return aVar;
                    } catch (IOException e16) {
                        System.out.println("DiskLruCache " + file + " is corrupt: " + e16.getMessage() + ", removing");
                        aVar.m();
                    }
                }
                file.mkdirs();
                a aVar2 = new a(file, i3, i16, j3);
                aVar2.y();
                return aVar2;
            }
            throw new IllegalArgumentException("valueCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    private void u() throws IOException {
        n(this.f352741f);
        Iterator<d> it = this.F.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i3 = 0;
            if (next.f352755f != null) {
                next.f352755f = null;
                while (i3 < this.C) {
                    n(next.j(i3));
                    n(next.k(i3));
                    i3++;
                }
                it.remove();
            } else {
                while (i3 < this.C) {
                    this.D += next.f352751b[i3];
                    i3++;
                }
            }
        }
    }

    private void w() throws IOException {
        com.tencent.qqnt.avatar.disklrucache.b bVar = new com.tencent.qqnt.avatar.disklrucache.b(new FileInputStream(this.f352740e), com.tencent.qqnt.avatar.disklrucache.c.f352769a);
        try {
            String readLine = bVar.readLine();
            String readLine2 = bVar.readLine();
            String readLine3 = bVar.readLine();
            String readLine4 = bVar.readLine();
            String readLine5 = bVar.readLine();
            if ("libcore.io.DiskLruCache".equals(readLine) && "1".equals(readLine2) && Integer.toString(this.f352743i).equals(readLine3) && Integer.toString(this.C).equals(readLine4) && "".equals(readLine5)) {
                int i3 = 0;
                while (true) {
                    try {
                        x(bVar.readLine());
                        i3++;
                    } catch (EOFException unused) {
                        this.G = i3 - this.F.size();
                        if (bVar.e()) {
                            y();
                        } else {
                            this.E = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f352740e, true), com.tencent.qqnt.avatar.disklrucache.c.f352769a));
                        }
                        com.tencent.qqnt.avatar.disklrucache.c.a(bVar);
                        return;
                    }
                }
            } else {
                throw new IOException("unexpected journal header: [" + readLine + ", " + readLine2 + ", " + readLine4 + ", " + readLine5 + "]");
            }
        } catch (Throwable th5) {
            com.tencent.qqnt.avatar.disklrucache.c.a(bVar);
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
            if (dVar == null) {
                dVar = new d(substring);
                this.F.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.f352754e = true;
                dVar.f352755f = null;
                dVar.n(split);
                return;
            }
            if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.f352755f = new c(dVar);
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
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f352741f), com.tencent.qqnt.avatar.disklrucache.c.f352769a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f352743i));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.C));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (d dVar : this.F.values()) {
                if (dVar.f352755f != null) {
                    bufferedWriter.write("DIRTY " + dVar.f352750a + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + dVar.f352750a + dVar.l() + '\n');
                }
            }
            k(bufferedWriter);
            if (this.f352740e.exists()) {
                A(this.f352740e, this.f352742h, true);
            }
            A(this.f352741f, this.f352740e, false);
            this.f352742h.delete();
            this.E = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f352740e, true), com.tencent.qqnt.avatar.disklrucache.c.f352769a));
        } catch (Throwable th5) {
            k(bufferedWriter);
            throw th5;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (this.E == null) {
            return;
        }
        Iterator it = new ArrayList(this.F.values()).iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.f352755f != null) {
                dVar.f352755f.c();
            }
        }
        B();
        k(this.E);
        this.E = null;
    }

    public void m() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            close();
            com.tencent.qqnt.avatar.disklrucache.c.b(this.f352739d);
        }
    }

    public c o(String str) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (c) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        return p(str, -1L);
    }

    public synchronized e r(String str) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (e) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        j();
        d dVar = this.F.get(str);
        if (dVar == null) {
            return null;
        }
        if (!dVar.f352754e) {
            return null;
        }
        for (File file : dVar.f352752c) {
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
        return new e(str, dVar.f352756g, dVar.f352752c, dVar.f352751b);
    }

    public synchronized boolean z(String str) throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str)).booleanValue();
        }
        j();
        d dVar = this.F.get(str);
        if (dVar != null && dVar.f352755f == null) {
            for (int i3 = 0; i3 < this.C; i3++) {
                File j3 = dVar.j(i3);
                if (j3.exists() && !j3.delete()) {
                    throw new IOException("failed to delete " + j3);
                }
                this.D -= dVar.f352751b[i3];
                dVar.f352751b[i3] = 0;
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
