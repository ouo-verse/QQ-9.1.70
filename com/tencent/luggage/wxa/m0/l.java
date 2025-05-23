package com.tencent.luggage.wxa.m0;

import android.util.SparseArray;
import com.tencent.luggage.wxa.tn.w;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.NavigableSet;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class l implements com.tencent.luggage.wxa.m0.a {

    /* renamed from: f, reason: collision with root package name */
    public static final a f134006f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    public final m f134007a;

    /* renamed from: b, reason: collision with root package name */
    public final File f134008b;

    /* renamed from: c, reason: collision with root package name */
    public final j f134009c;

    /* renamed from: d, reason: collision with root package name */
    public final String f134010d;

    /* renamed from: e, reason: collision with root package name */
    public final SparseArray f134011e;

    public /* synthetic */ l(m mVar, File file, j jVar, DefaultConstructorMarker defaultConstructorMarker) {
        this(mVar, file, jVar);
    }

    @Override // com.tencent.luggage.wxa.m0.a
    public void a(File file) {
        this.f134007a.a(file);
    }

    @Override // com.tencent.luggage.wxa.m0.a
    public NavigableSet b(String str) {
        return this.f134007a.b(str);
    }

    @Override // com.tencent.luggage.wxa.m0.a
    public void c(String str, long j3) {
        this.f134007a.c(str, j3);
    }

    public l(m mVar, File file, j jVar) {
        this.f134007a = mVar;
        this.f134008b = file;
        this.f134009c = jVar;
        this.f134010d = "MicroMsg.AppBrand.MultiProcessSupportSimpleCache#" + hashCode();
        this.f134011e = new SparseArray();
    }

    @Override // com.tencent.luggage.wxa.m0.a
    public long a() {
        return this.f134007a.a();
    }

    @Override // com.tencent.luggage.wxa.m0.a
    public void b(g gVar) {
        this.f134007a.b(gVar);
    }

    @Override // com.tencent.luggage.wxa.m0.a
    public long a(String str, long j3, long j16) {
        return this.f134007a.a(str, j3, j16);
    }

    @Override // com.tencent.luggage.wxa.m0.a
    public File b(String str, long j3, long j16) {
        return this.f134007a.b(str, j3, j16);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final l a(File cacheDir, f evictor) {
            Intrinsics.checkNotNullParameter(cacheDir, "cacheDir");
            Intrinsics.checkNotNullParameter(evictor, "evictor");
            j jVar = new j(cacheDir, null, false);
            return new l(new m(cacheDir, evictor, jVar), cacheDir, jVar, null);
        }

        public final File a(File cacheDir, int i3) {
            Intrinsics.checkNotNullParameter(cacheDir, "cacheDir");
            return new File(cacheDir, i3 + ".v1.lock");
        }
    }

    @Override // com.tencent.luggage.wxa.m0.a
    public long a(String str) {
        return this.f134007a.a(str);
    }

    @Override // com.tencent.luggage.wxa.m0.a
    public g b(String str, long j3) {
        return this.f134007a.b(str, j3);
    }

    @Override // com.tencent.luggage.wxa.m0.a
    public synchronized g a(String str, long j3) {
        FileLock fileLock;
        n a16 = this.f134007a.a(str, j3);
        if (a16 == null) {
            w.d(this.f134010d, "startReadWriteNonBlocking, write case, lock not available.");
            return null;
        }
        if (a16.f133988d) {
            w.d(this.f134010d, "startReadWriteNonBlocking, read case.");
            return a16;
        }
        w.d(this.f134010d, "startReadWriteNonBlocking, write case, lock available.");
        int b16 = this.f134009c.b(str);
        File a17 = f134006f.a(this.f134008b, b16);
        w.d(this.f134010d, "startReadWriteNonBlocking, lockFile: " + a17);
        try {
            w.d(this.f134010d, "startReadWriteNonBlocking, try lock");
            fileLock = new RandomAccessFile(a17, "rw").getChannel().tryLock();
        } catch (Exception e16) {
            w.f(this.f134010d, "startReadWriteNonBlocking, try lock fail since " + e16);
            fileLock = null;
        }
        if (fileLock != null) {
            this.f134011e.put(b16, fileLock);
            w.d(this.f134010d, "startReadWriteNonBlocking, write case, file lock available.");
            return a16;
        }
        w.d(this.f134010d, "startReadWriteNonBlocking, write case, file lock not available.");
        return null;
    }

    @Override // com.tencent.luggage.wxa.m0.a
    public synchronized void a(g holeSpan) {
        Intrinsics.checkNotNullParameter(holeSpan, "holeSpan");
        try {
            w.d(this.f134010d, "releaseHoleSpan, release lock");
            int i3 = this.f134009c.c(holeSpan.f133985a).f133991a;
            ((FileLock) this.f134011e.get(i3)).release();
            this.f134011e.remove(i3);
        } catch (Exception e16) {
            w.f(this.f134010d, "releaseHoleSpan, release lock fail since " + e16);
        }
        this.f134007a.a(holeSpan);
    }
}
