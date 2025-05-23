package com.facebook.soloader;

import android.content.Context;
import android.os.Parcel;
import android.os.StrictMode;
import android.util.Log;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class UnpackingSoSource extends com.facebook.soloader.d {

    /* renamed from: c, reason: collision with root package name */
    protected final Context f32802c;

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    protected String f32803d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    private String[] f32804e;

    /* renamed from: f, reason: collision with root package name */
    private final Map<String, Object> f32805f;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: d, reason: collision with root package name */
        public final String f32811d;

        /* renamed from: e, reason: collision with root package name */
        public final String f32812e;

        public a(String str, String str2) {
            this.f32811d = str;
            this.f32812e = str2;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final a[] f32813a;

        public b(a[] aVarArr) {
            this.f32813a = aVarArr;
        }

        static final b a(DataInput dataInput) throws IOException {
            if (dataInput.readByte() == 1) {
                int readInt = dataInput.readInt();
                if (readInt >= 0) {
                    a[] aVarArr = new a[readInt];
                    for (int i3 = 0; i3 < readInt; i3++) {
                        aVarArr[i3] = new a(dataInput.readUTF(), dataInput.readUTF());
                    }
                    return new b(aVarArr);
                }
                throw new RuntimeException("illegal number of shared libraries");
            }
            throw new RuntimeException("wrong dso manifest version");
        }

        public final void b(DataOutput dataOutput) throws IOException {
            dataOutput.writeByte(1);
            dataOutput.writeInt(this.f32813a.length);
            int i3 = 0;
            while (true) {
                a[] aVarArr = this.f32813a;
                if (i3 < aVarArr.length) {
                    dataOutput.writeUTF(aVarArr[i3].f32811d);
                    dataOutput.writeUTF(this.f32813a[i3].f32812e);
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class c implements Closeable {

        /* renamed from: d, reason: collision with root package name */
        public final a f32814d;

        /* renamed from: e, reason: collision with root package name */
        public final InputStream f32815e;

        public c(a aVar, InputStream inputStream) {
            this.f32814d = aVar;
            this.f32815e = inputStream;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f32815e.close();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public UnpackingSoSource(Context context, String str) {
        super(l(context, str), 1);
        this.f32805f = new HashMap();
        this.f32802c = context;
    }

    private void g(a[] aVarArr) throws IOException {
        String[] list = this.f32822a.list();
        if (list != null) {
            for (String str : list) {
                if (!str.equals("dso_state") && !str.equals("dso_lock") && !str.equals("dso_deps") && !str.equals("dso_manifest")) {
                    boolean z16 = false;
                    for (int i3 = 0; !z16 && i3 < aVarArr.length; i3++) {
                        if (aVarArr[i3].f32811d.equals(str)) {
                            z16 = true;
                        }
                    }
                    if (!z16) {
                        File file = new File(this.f32822a, str);
                        Log.v("fb-UnpackingSoSource", "deleting unaccounted-for file " + file);
                        l.c(file);
                    }
                }
            }
            return;
        }
        throw new IOException("unable to list directory " + this.f32822a);
    }

    private void h(c cVar, byte[] bArr) throws IOException {
        Log.i("fb-UnpackingSoSource", "extracting DSO " + cVar.f32814d.f32811d);
        try {
            if (this.f32822a.setWritable(true)) {
                i(cVar, bArr);
            } else {
                throw new IOException("cannot make directory writable for us: " + this.f32822a);
            }
        } finally {
            if (!this.f32822a.setWritable(false)) {
                Log.w("fb-UnpackingSoSource", "error removing " + this.f32822a.getCanonicalPath() + " write permission");
            }
        }
    }

    private void i(c cVar, byte[] bArr) throws IOException {
        RandomAccessFile randomAccessFile;
        File file = new File(this.f32822a, cVar.f32814d.f32811d);
        RandomAccessFile randomAccessFile2 = null;
        try {
            try {
                if (file.exists() && !file.setWritable(true)) {
                    Log.w("fb-UnpackingSoSource", "error adding write permission to: " + file);
                }
                try {
                    randomAccessFile = new RandomAccessFile(file, "rw");
                } catch (IOException e16) {
                    Log.w("fb-UnpackingSoSource", "error overwriting " + file + " trying to delete and start over", e16);
                    l.c(file);
                    randomAccessFile = new RandomAccessFile(file, "rw");
                }
                randomAccessFile2 = randomAccessFile;
                int available = cVar.f32815e.available();
                if (available > 1) {
                    l.d(randomAccessFile2.getFD(), available);
                }
                l.a(randomAccessFile2, cVar.f32815e, Integer.MAX_VALUE, bArr);
                randomAccessFile2.setLength(randomAccessFile2.getFilePointer());
                if (file.setExecutable(true, false)) {
                    if (!file.setWritable(false)) {
                        Log.w("fb-UnpackingSoSource", "error removing " + file + " write permission");
                    }
                    randomAccessFile2.close();
                    return;
                }
                throw new IOException("cannot make file executable: " + file);
            } catch (IOException e17) {
                l.c(file);
                throw e17;
            }
        } catch (Throwable th5) {
            if (!file.setWritable(false)) {
                Log.w("fb-UnpackingSoSource", "error removing " + file + " write permission");
            }
            if (randomAccessFile2 != null) {
                randomAccessFile2.close();
            }
            throw th5;
        }
    }

    private Object k(String str) {
        Object obj;
        synchronized (this.f32805f) {
            obj = this.f32805f.get(str);
            if (obj == null) {
                obj = new Object();
                this.f32805f.put(str, obj);
            }
        }
        return obj;
    }

    public static File l(Context context, String str) {
        return new File(context.getApplicationInfo().dataDir + "/" + str);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00aa A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean o(final g gVar, int i3, final byte[] bArr) throws IOException {
        byte b16;
        e m3;
        b a16;
        d d16;
        b bVar;
        final File file = new File(this.f32822a, "dso_state");
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        try {
            b16 = randomAccessFile.readByte();
        } catch (EOFException unused) {
        } catch (Throwable th5) {
            try {
                throw th5;
            } finally {
            }
        }
        if (b16 != 1) {
            Log.v("fb-UnpackingSoSource", "dso store " + this.f32822a + " regeneration interrupted: wiping clean");
            b16 = 0;
        }
        randomAccessFile.close();
        final File file2 = new File(this.f32822a, "dso_deps");
        randomAccessFile = new RandomAccessFile(file2, "rw");
        try {
            int length = (int) randomAccessFile.length();
            byte[] bArr2 = new byte[length];
            if (randomAccessFile.read(bArr2) != length) {
                Log.v("fb-UnpackingSoSource", "short read of so store deps file: marking unclean");
                b16 = 0;
            }
            if (!Arrays.equals(bArr2, bArr)) {
                Log.v("fb-UnpackingSoSource", "deps mismatch on deps store: regenerating");
                b16 = 0;
            }
            try {
                try {
                    if (b16 != 0 && (i3 & 2) == 0) {
                        bVar = null;
                        randomAccessFile.close();
                        if (bVar != null) {
                            return false;
                        }
                        final b bVar2 = bVar;
                        Runnable runnable = new Runnable() { // from class: com.facebook.soloader.UnpackingSoSource.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    try {
                                        Log.v("fb-UnpackingSoSource", "starting syncer worker");
                                        RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                                        try {
                                            randomAccessFile2.write(bArr);
                                            randomAccessFile2.setLength(randomAccessFile2.getFilePointer());
                                            randomAccessFile2.close();
                                            randomAccessFile2 = new RandomAccessFile(new File(UnpackingSoSource.this.f32822a, "dso_manifest"), "rw");
                                            try {
                                                bVar2.b(randomAccessFile2);
                                                randomAccessFile2.close();
                                                l.f(UnpackingSoSource.this.f32822a);
                                                UnpackingSoSource.r(file, (byte) 1);
                                            } finally {
                                            }
                                        } finally {
                                            try {
                                                throw th;
                                            } finally {
                                            }
                                        }
                                    } finally {
                                        Log.v("fb-UnpackingSoSource", "releasing dso store lock for " + UnpackingSoSource.this.f32822a + " (from syncer thread)");
                                        gVar.close();
                                    }
                                } catch (IOException e16) {
                                    throw new RuntimeException(e16);
                                }
                            }
                        };
                        if ((i3 & 1) != 0) {
                            new BaseThread(runnable, "SoSync:" + this.f32822a.getName()).start();
                        } else {
                            runnable.run();
                        }
                        return true;
                    }
                    p(b16, a16, d16);
                    if (d16 != null) {
                        d16.close();
                    }
                    m3.close();
                    bVar = a16;
                    randomAccessFile.close();
                    if (bVar != null) {
                    }
                } finally {
                }
                a16 = m3.a();
                d16 = m3.d();
            } finally {
            }
            Log.v("fb-UnpackingSoSource", "so store dirty: regenerating");
            r(file, (byte) 0);
            m3 = m();
        } catch (Throwable th52) {
            try {
                throw th52;
            } finally {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x005f A[Catch: all -> 0x003a, TRY_LEAVE, TryCatch #3 {all -> 0x003a, blocks: (B:66:0x0035, B:6:0x0048, B:7:0x004f, B:8:0x0059, B:10:0x005f, B:30:0x00a5, B:43:0x00a2, B:49:0x009f, B:69:0x003e, B:38:0x0096, B:46:0x009a, B:14:0x0067, B:16:0x006c, B:18:0x007a, B:22:0x008b, B:27:0x0092), top: B:65:0x0035, inners: #1, #2, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0048 A[Catch: all -> 0x003a, TryCatch #3 {all -> 0x003a, blocks: (B:66:0x0035, B:6:0x0048, B:7:0x004f, B:8:0x0059, B:10:0x005f, B:30:0x00a5, B:43:0x00a2, B:49:0x009f, B:69:0x003e, B:38:0x0096, B:46:0x009a, B:14:0x0067, B:16:0x006c, B:18:0x007a, B:22:0x008b, B:27:0x0092), top: B:65:0x0035, inners: #1, #2, #5, #6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void p(byte b16, b bVar, d dVar) throws IOException {
        b a16;
        Log.v("fb-UnpackingSoSource", "regenerating DSO store " + getClass().getName());
        RandomAccessFile randomAccessFile = new RandomAccessFile(new File(this.f32822a, "dso_manifest"), "rw");
        if (b16 == 1) {
            try {
                try {
                    a16 = b.a(randomAccessFile);
                } catch (Exception e16) {
                    Log.i("fb-UnpackingSoSource", "error reading existing DSO manifest", e16);
                }
                if (a16 == null) {
                    a16 = new b(new a[0]);
                }
                g(bVar.f32813a);
                byte[] bArr = new byte[32768];
                while (dVar.hasNext()) {
                    c a17 = dVar.a();
                    boolean z16 = true;
                    int i3 = 0;
                    while (z16) {
                        try {
                            a[] aVarArr = a16.f32813a;
                            if (i3 >= aVarArr.length) {
                                break;
                            }
                            if (aVarArr[i3].f32811d.equals(a17.f32814d.f32811d) && a16.f32813a[i3].f32812e.equals(a17.f32814d.f32812e)) {
                                z16 = false;
                            }
                            i3++;
                        } finally {
                        }
                    }
                    if (z16) {
                        h(a17, bArr);
                    }
                    if (a17 != null) {
                        a17.close();
                    }
                }
                randomAccessFile.close();
                Log.v("fb-UnpackingSoSource", "Finished regenerating DSO store " + getClass().getName());
            } catch (Throwable th5) {
                try {
                    throw th5;
                } catch (Throwable th6) {
                    try {
                        randomAccessFile.close();
                    } catch (Throwable th7) {
                        th5.addSuppressed(th7);
                    }
                    throw th6;
                }
            }
        }
        a16 = null;
        if (a16 == null) {
        }
        g(bVar.f32813a);
        byte[] bArr2 = new byte[32768];
        while (dVar.hasNext()) {
        }
        randomAccessFile.close();
        Log.v("fb-UnpackingSoSource", "Finished regenerating DSO store " + getClass().getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void r(File file, byte b16) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        try {
            randomAccessFile.seek(0L);
            randomAccessFile.write(b16);
            randomAccessFile.setLength(randomAccessFile.getFilePointer());
            randomAccessFile.getFD().sync();
            randomAccessFile.close();
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                try {
                    randomAccessFile.close();
                } catch (Throwable th7) {
                    th5.addSuppressed(th7);
                }
                throw th6;
            }
        }
    }

    @Override // com.facebook.soloader.d, com.facebook.soloader.k
    public int a(String str, int i3, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        int e16;
        synchronized (k(str)) {
            e16 = e(str, i3, this.f32822a, threadPolicy);
        }
        return e16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.facebook.soloader.k
    public void b(int i3) throws IOException {
        l.j(this.f32822a);
        g a16 = g.a(new File(this.f32822a, "dso_lock"));
        try {
            Log.v("fb-UnpackingSoSource", "locked dso store " + this.f32822a);
            if (o(a16, i3, j())) {
                a16 = null;
            } else {
                Log.i("fb-UnpackingSoSource", "dso store is up-to-date: " + this.f32822a);
            }
        } finally {
            if (a16 != null) {
                Log.v("fb-UnpackingSoSource", "releasing dso store lock for " + this.f32822a);
                a16.close();
            } else {
                Log.v("fb-UnpackingSoSource", "not releasing dso store lock for " + this.f32822a + " (syncer thread started)");
            }
        }
    }

    protected byte[] j() throws IOException {
        Parcel obtain = Parcel.obtain();
        e m3 = m();
        try {
            a[] aVarArr = m3.a().f32813a;
            obtain.writeByte((byte) 1);
            obtain.writeInt(aVarArr.length);
            for (int i3 = 0; i3 < aVarArr.length; i3++) {
                obtain.writeString(aVarArr[i3].f32811d);
                obtain.writeString(aVarArr[i3].f32812e);
            }
            m3.close();
            byte[] marshall = obtain.marshall();
            OaidMonitor.parcelRecycle(obtain);
            return marshall;
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                if (m3 != null) {
                    try {
                        m3.close();
                    } catch (Throwable th7) {
                        th5.addSuppressed(th7);
                    }
                }
                throw th6;
            }
        }
    }

    protected abstract e m() throws IOException;

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void n(String str) throws IOException {
        synchronized (k(str)) {
            this.f32803d = str;
            b(2);
        }
    }

    public void q(String[] strArr) {
        this.f32804e = strArr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class d implements Closeable {
        public abstract c a() throws IOException;

        public abstract boolean hasNext();

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class e implements Closeable {
        protected abstract b a() throws IOException;

        protected abstract d d() throws IOException;

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }
    }
}
