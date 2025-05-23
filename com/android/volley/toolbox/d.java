package com.android.volley.toolbox;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.android.volley.c;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
public class d implements com.android.volley.c {

    /* renamed from: a, reason: collision with root package name */
    private final Map<String, a> f31401a;

    /* renamed from: b, reason: collision with root package name */
    private long f31402b;

    /* renamed from: c, reason: collision with root package name */
    private final c f31403c;

    /* renamed from: d, reason: collision with root package name */
    private final int f31404d;

    /* compiled from: P */
    /* loaded from: classes.dex */
    public interface c {
        File get();
    }

    public d(c cVar, int i3) {
        this.f31401a = new LinkedHashMap(16, 0.75f, true);
        this.f31402b = 0L;
        this.f31403c = cVar;
        this.f31404d = i3;
    }

    private String f(String str) {
        int length = str.length() / 2;
        return String.valueOf(str.substring(0, length).hashCode()) + String.valueOf(str.substring(length).hashCode());
    }

    private void g() {
        if (!this.f31403c.get().exists()) {
            com.android.volley.k.b("Re-initializing cache after external clearing.", new Object[0]);
            this.f31401a.clear();
            this.f31402b = 0L;
            initialize();
        }
    }

    private void h() {
        if (this.f31402b < this.f31404d) {
            return;
        }
        if (com.android.volley.k.f31342b) {
            com.android.volley.k.e("Pruning old cache entries.", new Object[0]);
        }
        long j3 = this.f31402b;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Iterator<Map.Entry<String, a>> it = this.f31401a.entrySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            a value = it.next().getValue();
            if (e(value.f31406b).delete()) {
                this.f31402b -= value.f31405a;
            } else {
                String str = value.f31406b;
                com.android.volley.k.b("Could not delete cache entry for key=%s, filename=%s", str, f(str));
            }
            it.remove();
            i3++;
            if (((float) this.f31402b) < this.f31404d * 0.9f) {
                break;
            }
        }
        if (com.android.volley.k.f31342b) {
            com.android.volley.k.e("pruned %d files, %d bytes, %d ms", Integer.valueOf(i3), Long.valueOf(this.f31402b - j3), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
        }
    }

    private void i(String str, a aVar) {
        if (!this.f31401a.containsKey(str)) {
            this.f31402b += aVar.f31405a;
        } else {
            this.f31402b += aVar.f31405a - this.f31401a.get(str).f31405a;
        }
        this.f31401a.put(str, aVar);
    }

    private static int j(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    static List<com.android.volley.e> k(b bVar) throws IOException {
        List<com.android.volley.e> arrayList;
        int l3 = l(bVar);
        if (l3 >= 0) {
            if (l3 == 0) {
                arrayList = Collections.emptyList();
            } else {
                arrayList = new ArrayList<>();
            }
            for (int i3 = 0; i3 < l3; i3++) {
                arrayList.add(new com.android.volley.e(n(bVar).intern(), n(bVar).intern()));
            }
            return arrayList;
        }
        throw new IOException("readHeaderList size=" + l3);
    }

    static int l(InputStream inputStream) throws IOException {
        return (j(inputStream) << 24) | (j(inputStream) << 0) | 0 | (j(inputStream) << 8) | (j(inputStream) << 16);
    }

    static long m(InputStream inputStream) throws IOException {
        return ((j(inputStream) & 255) << 0) | 0 | ((j(inputStream) & 255) << 8) | ((j(inputStream) & 255) << 16) | ((j(inputStream) & 255) << 24) | ((j(inputStream) & 255) << 32) | ((j(inputStream) & 255) << 40) | ((j(inputStream) & 255) << 48) | ((255 & j(inputStream)) << 56);
    }

    static String n(b bVar) throws IOException {
        return new String(q(bVar, m(bVar)), "UTF-8");
    }

    private void p(String str) {
        a remove = this.f31401a.remove(str);
        if (remove != null) {
            this.f31402b -= remove.f31405a;
        }
    }

    @VisibleForTesting
    static byte[] q(b bVar, long j3) throws IOException {
        long a16 = bVar.a();
        if (j3 >= 0 && j3 <= a16) {
            int i3 = (int) j3;
            if (i3 == j3) {
                byte[] bArr = new byte[i3];
                new DataInputStream(bVar).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j3 + ", maxLength=" + a16);
    }

    static void r(List<com.android.volley.e> list, OutputStream outputStream) throws IOException {
        if (list != null) {
            s(outputStream, list.size());
            for (com.android.volley.e eVar : list) {
                u(outputStream, eVar.a());
                u(outputStream, eVar.b());
            }
            return;
        }
        s(outputStream, 0);
    }

    static void s(OutputStream outputStream, int i3) throws IOException {
        outputStream.write((i3 >> 0) & 255);
        outputStream.write((i3 >> 8) & 255);
        outputStream.write((i3 >> 16) & 255);
        outputStream.write((i3 >> 24) & 255);
    }

    static void t(OutputStream outputStream, long j3) throws IOException {
        outputStream.write((byte) (j3 >>> 0));
        outputStream.write((byte) (j3 >>> 8));
        outputStream.write((byte) (j3 >>> 16));
        outputStream.write((byte) (j3 >>> 24));
        outputStream.write((byte) (j3 >>> 32));
        outputStream.write((byte) (j3 >>> 40));
        outputStream.write((byte) (j3 >>> 48));
        outputStream.write((byte) (j3 >>> 56));
    }

    static void u(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        t(outputStream, bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    @Override // com.android.volley.c
    public synchronized void a(String str, boolean z16) {
        c.a aVar = get(str);
        if (aVar != null) {
            aVar.f31322f = 0L;
            if (z16) {
                aVar.f31321e = 0L;
            }
            b(str, aVar);
        }
    }

    @Override // com.android.volley.c
    public synchronized void b(String str, c.a aVar) {
        BufferedOutputStream bufferedOutputStream;
        a aVar2;
        long j3 = this.f31402b;
        byte[] bArr = aVar.f31317a;
        long length = j3 + bArr.length;
        int i3 = this.f31404d;
        if (length > i3 && bArr.length > i3 * 0.9f) {
            return;
        }
        File e16 = e(str);
        try {
            bufferedOutputStream = new BufferedOutputStream(d(e16));
            aVar2 = new a(str, aVar);
        } catch (IOException unused) {
            if (!e16.delete()) {
                com.android.volley.k.b("Could not clean up file %s", e16.getAbsolutePath());
            }
            g();
        }
        if (aVar2.d(bufferedOutputStream)) {
            bufferedOutputStream.write(aVar.f31317a);
            bufferedOutputStream.close();
            aVar2.f31405a = e16.length();
            i(str, aVar2);
            h();
            return;
        }
        bufferedOutputStream.close();
        com.android.volley.k.b("Failed to write header for %s", e16.getAbsolutePath());
        throw new IOException();
    }

    @VisibleForTesting
    InputStream c(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    @VisibleForTesting
    OutputStream d(File file) throws FileNotFoundException {
        return new FileOutputStream(file);
    }

    public File e(String str) {
        return new File(this.f31403c.get(), f(str));
    }

    @Override // com.android.volley.c
    public synchronized c.a get(String str) {
        a aVar = this.f31401a.get(str);
        if (aVar == null) {
            return null;
        }
        File e16 = e(str);
        try {
            b bVar = new b(new BufferedInputStream(c(e16)), e16.length());
            try {
                a b16 = a.b(bVar);
                if (!TextUtils.equals(str, b16.f31406b)) {
                    com.android.volley.k.b("%s: key=%s, found=%s", e16.getAbsolutePath(), str, b16.f31406b);
                    p(str);
                    return null;
                }
                return aVar.c(q(bVar, bVar.a()));
            } finally {
                bVar.close();
            }
        } catch (IOException e17) {
            com.android.volley.k.b("%s: %s", e16.getAbsolutePath(), e17.toString());
            o(str);
            return null;
        }
    }

    @Override // com.android.volley.c
    public synchronized void initialize() {
        long length;
        b bVar;
        File file = this.f31403c.get();
        if (!file.exists()) {
            if (!file.mkdirs()) {
                com.android.volley.k.c("Unable to create cache dir %s", file.getAbsolutePath());
            }
            return;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file2 : listFiles) {
            try {
                length = file2.length();
                bVar = new b(new BufferedInputStream(c(file2)), length);
            } catch (IOException unused) {
                file2.delete();
            }
            try {
                a b16 = a.b(bVar);
                b16.f31405a = length;
                i(b16.f31406b, b16);
                bVar.close();
            } catch (Throwable th5) {
                bVar.close();
                throw th5;
                break;
            }
        }
    }

    public synchronized void o(String str) {
        boolean delete = e(str).delete();
        p(str);
        if (!delete) {
            com.android.volley.k.b("Could not delete cache entry for key=%s, filename=%s", str, f(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class b extends FilterInputStream {

        /* renamed from: d, reason: collision with root package name */
        private final long f31413d;

        /* renamed from: e, reason: collision with root package name */
        private long f31414e;

        b(InputStream inputStream, long j3) {
            super(inputStream);
            this.f31413d = j3;
        }

        long a() {
            return this.f31413d - this.f31414e;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.f31414e++;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i3, int i16) throws IOException {
            int read = super.read(bArr, i3, i16);
            if (read != -1) {
                this.f31414e += read;
            }
            return read;
        }
    }

    public d(c cVar) {
        this(cVar, 5242880);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        long f31405a;

        /* renamed from: b, reason: collision with root package name */
        final String f31406b;

        /* renamed from: c, reason: collision with root package name */
        final String f31407c;

        /* renamed from: d, reason: collision with root package name */
        final long f31408d;

        /* renamed from: e, reason: collision with root package name */
        final long f31409e;

        /* renamed from: f, reason: collision with root package name */
        final long f31410f;

        /* renamed from: g, reason: collision with root package name */
        final long f31411g;

        /* renamed from: h, reason: collision with root package name */
        final List<com.android.volley.e> f31412h;

        a(String str, String str2, long j3, long j16, long j17, long j18, List<com.android.volley.e> list) {
            this.f31406b = str;
            this.f31407c = "".equals(str2) ? null : str2;
            this.f31408d = j3;
            this.f31409e = j16;
            this.f31410f = j17;
            this.f31411g = j18;
            this.f31412h = list;
        }

        private static List<com.android.volley.e> a(c.a aVar) {
            List<com.android.volley.e> list = aVar.f31324h;
            if (list != null) {
                return list;
            }
            return e.i(aVar.f31323g);
        }

        static a b(b bVar) throws IOException {
            if (d.l(bVar) == 538247942) {
                return new a(d.n(bVar), d.n(bVar), d.m(bVar), d.m(bVar), d.m(bVar), d.m(bVar), d.k(bVar));
            }
            throw new IOException();
        }

        c.a c(byte[] bArr) {
            c.a aVar = new c.a();
            aVar.f31317a = bArr;
            aVar.f31318b = this.f31407c;
            aVar.f31319c = this.f31408d;
            aVar.f31320d = this.f31409e;
            aVar.f31321e = this.f31410f;
            aVar.f31322f = this.f31411g;
            aVar.f31323g = e.j(this.f31412h);
            aVar.f31324h = Collections.unmodifiableList(this.f31412h);
            return aVar;
        }

        boolean d(OutputStream outputStream) {
            try {
                d.s(outputStream, 538247942);
                d.u(outputStream, this.f31406b);
                String str = this.f31407c;
                if (str == null) {
                    str = "";
                }
                d.u(outputStream, str);
                d.t(outputStream, this.f31408d);
                d.t(outputStream, this.f31409e);
                d.t(outputStream, this.f31410f);
                d.t(outputStream, this.f31411g);
                d.r(this.f31412h, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e16) {
                com.android.volley.k.b("%s", e16.toString());
                return false;
            }
        }

        a(String str, c.a aVar) {
            this(str, aVar.f31318b, aVar.f31319c, aVar.f31320d, aVar.f31321e, aVar.f31322f, a(aVar));
        }
    }
}
