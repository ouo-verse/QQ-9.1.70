package com.tencent.tbs.one.impl.c.a;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UnknownFormatConversionException;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class e implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    static final char[] f374665a = {'\u007f', 'E', 'L', 'F', 0};

    /* renamed from: b, reason: collision with root package name */
    final char[] f374666b;

    /* renamed from: c, reason: collision with root package name */
    boolean f374667c;

    /* renamed from: d, reason: collision with root package name */
    j[] f374668d;

    /* renamed from: e, reason: collision with root package name */
    l[] f374669e;

    /* renamed from: f, reason: collision with root package name */
    byte[] f374670f;

    /* renamed from: g, reason: collision with root package name */
    private final com.tencent.tbs.one.impl.c.a.a f374671g;

    /* renamed from: h, reason: collision with root package name */
    private final a f374672h;

    /* renamed from: i, reason: collision with root package name */
    private final k[] f374673i;

    /* renamed from: j, reason: collision with root package name */
    private byte[] f374674j;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        short f374675a;

        /* renamed from: b, reason: collision with root package name */
        short f374676b;

        /* renamed from: c, reason: collision with root package name */
        int f374677c;

        /* renamed from: d, reason: collision with root package name */
        int f374678d;

        /* renamed from: e, reason: collision with root package name */
        short f374679e;

        /* renamed from: f, reason: collision with root package name */
        short f374680f;

        /* renamed from: g, reason: collision with root package name */
        short f374681g;

        /* renamed from: h, reason: collision with root package name */
        short f374682h;

        /* renamed from: i, reason: collision with root package name */
        short f374683i;

        /* renamed from: j, reason: collision with root package name */
        short f374684j;

        abstract long a();

        abstract long b();
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    static class b extends a {

        /* renamed from: k, reason: collision with root package name */
        int f374685k;

        /* renamed from: l, reason: collision with root package name */
        int f374686l;

        /* renamed from: m, reason: collision with root package name */
        int f374687m;

        b() {
        }

        @Override // com.tencent.tbs.one.impl.c.a.e.a
        final long a() {
            return this.f374687m;
        }

        @Override // com.tencent.tbs.one.impl.c.a.e.a
        final long b() {
            return this.f374686l;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class c extends j {

        /* renamed from: c, reason: collision with root package name */
        int f374688c;

        /* renamed from: d, reason: collision with root package name */
        int f374689d;

        /* renamed from: e, reason: collision with root package name */
        int f374690e;

        /* renamed from: f, reason: collision with root package name */
        int f374691f;

        /* renamed from: g, reason: collision with root package name */
        int f374692g;

        /* renamed from: h, reason: collision with root package name */
        int f374693h;

        c() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    static class d extends k {

        /* renamed from: e, reason: collision with root package name */
        int f374694e;

        /* renamed from: f, reason: collision with root package name */
        int f374695f;

        /* renamed from: g, reason: collision with root package name */
        int f374696g;

        /* renamed from: h, reason: collision with root package name */
        int f374697h;

        /* renamed from: i, reason: collision with root package name */
        int f374698i;

        /* renamed from: j, reason: collision with root package name */
        int f374699j;

        d() {
        }

        @Override // com.tencent.tbs.one.impl.c.a.e.k
        public final int a() {
            return this.f374697h;
        }

        @Override // com.tencent.tbs.one.impl.c.a.e.k
        public final long b() {
            return this.f374696g;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.tbs.one.impl.c.a.e$e, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static class C9888e extends l {

        /* renamed from: e, reason: collision with root package name */
        int f374700e;

        /* renamed from: f, reason: collision with root package name */
        int f374701f;

        C9888e() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    static class f extends a {

        /* renamed from: k, reason: collision with root package name */
        long f374702k;

        /* renamed from: l, reason: collision with root package name */
        long f374703l;

        /* renamed from: m, reason: collision with root package name */
        long f374704m;

        f() {
        }

        @Override // com.tencent.tbs.one.impl.c.a.e.a
        final long a() {
            return this.f374704m;
        }

        @Override // com.tencent.tbs.one.impl.c.a.e.a
        final long b() {
            return this.f374703l;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class g extends j {

        /* renamed from: c, reason: collision with root package name */
        long f374705c;

        /* renamed from: d, reason: collision with root package name */
        long f374706d;

        /* renamed from: e, reason: collision with root package name */
        long f374707e;

        /* renamed from: f, reason: collision with root package name */
        long f374708f;

        /* renamed from: g, reason: collision with root package name */
        long f374709g;

        /* renamed from: h, reason: collision with root package name */
        long f374710h;

        g() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    static class h extends k {

        /* renamed from: e, reason: collision with root package name */
        long f374711e;

        /* renamed from: f, reason: collision with root package name */
        long f374712f;

        /* renamed from: g, reason: collision with root package name */
        long f374713g;

        /* renamed from: h, reason: collision with root package name */
        long f374714h;

        /* renamed from: i, reason: collision with root package name */
        long f374715i;

        /* renamed from: j, reason: collision with root package name */
        long f374716j;

        h() {
        }

        @Override // com.tencent.tbs.one.impl.c.a.e.k
        public final int a() {
            return (int) this.f374714h;
        }

        @Override // com.tencent.tbs.one.impl.c.a.e.k
        public final long b() {
            return this.f374713g;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class i extends l {

        /* renamed from: e, reason: collision with root package name */
        long f374717e;

        /* renamed from: f, reason: collision with root package name */
        long f374718f;

        i() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static abstract class j {

        /* renamed from: a, reason: collision with root package name */
        int f374719a;

        /* renamed from: b, reason: collision with root package name */
        int f374720b;

        j() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static abstract class k {

        /* renamed from: a, reason: collision with root package name */
        int f374721a;

        /* renamed from: b, reason: collision with root package name */
        int f374722b;

        /* renamed from: c, reason: collision with root package name */
        int f374723c;

        /* renamed from: d, reason: collision with root package name */
        int f374724d;

        public abstract int a();

        public abstract long b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static abstract class l {

        /* renamed from: a, reason: collision with root package name */
        int f374725a;

        /* renamed from: b, reason: collision with root package name */
        char f374726b;

        /* renamed from: c, reason: collision with root package name */
        char f374727c;

        /* renamed from: d, reason: collision with root package name */
        short f374728d;

        l() {
        }
    }

    public e(File file) throws IOException, UnknownFormatConversionException {
        boolean z16;
        char[] cArr = new char[16];
        this.f374666b = cArr;
        com.tencent.tbs.one.impl.c.a.a aVar = new com.tencent.tbs.one.impl.c.a.a(file);
        this.f374671g = aVar;
        aVar.a(cArr);
        if (cArr[0] == f374665a[0]) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            aVar.f374639a = cArr[5] == 1;
            boolean a16 = a();
            if (a16) {
                f fVar = new f();
                fVar.f374675a = aVar.a();
                fVar.f374676b = aVar.a();
                fVar.f374677c = aVar.b();
                fVar.f374702k = aVar.c();
                fVar.f374703l = aVar.c();
                fVar.f374704m = aVar.c();
                this.f374672h = fVar;
            } else {
                b bVar = new b();
                bVar.f374675a = aVar.a();
                bVar.f374676b = aVar.a();
                bVar.f374677c = aVar.b();
                bVar.f374685k = aVar.b();
                bVar.f374686l = aVar.b();
                bVar.f374687m = aVar.b();
                this.f374672h = bVar;
            }
            a aVar2 = this.f374672h;
            aVar2.f374678d = aVar.b();
            aVar2.f374679e = aVar.a();
            aVar2.f374680f = aVar.a();
            aVar2.f374681g = aVar.a();
            aVar2.f374682h = aVar.a();
            aVar2.f374683i = aVar.a();
            aVar2.f374684j = aVar.a();
            this.f374673i = new k[aVar2.f374683i];
            for (int i3 = 0; i3 < aVar2.f374683i; i3++) {
                aVar.a(aVar2.a() + (aVar2.f374682h * i3));
                if (a16) {
                    h hVar = new h();
                    hVar.f374721a = aVar.b();
                    hVar.f374722b = aVar.b();
                    hVar.f374711e = aVar.c();
                    hVar.f374712f = aVar.c();
                    hVar.f374713g = aVar.c();
                    hVar.f374714h = aVar.c();
                    hVar.f374723c = aVar.b();
                    hVar.f374724d = aVar.b();
                    hVar.f374715i = aVar.c();
                    hVar.f374716j = aVar.c();
                    this.f374673i[i3] = hVar;
                } else {
                    d dVar = new d();
                    dVar.f374721a = aVar.b();
                    dVar.f374722b = aVar.b();
                    dVar.f374694e = aVar.b();
                    dVar.f374695f = aVar.b();
                    dVar.f374696g = aVar.b();
                    dVar.f374697h = aVar.b();
                    dVar.f374723c = aVar.b();
                    dVar.f374724d = aVar.b();
                    dVar.f374698i = aVar.b();
                    dVar.f374699j = aVar.b();
                    this.f374673i[i3] = dVar;
                }
            }
            short s16 = aVar2.f374684j;
            if (s16 >= 0) {
                k[] kVarArr = this.f374673i;
                if (s16 < kVarArr.length) {
                    k kVar = kVarArr[s16];
                    if (kVar.f374722b == 3) {
                        this.f374674j = new byte[kVar.a()];
                        aVar.a(kVar.b());
                        aVar.a(this.f374674j);
                        if (this.f374667c) {
                            b();
                            return;
                        }
                        return;
                    }
                    throw new UnknownFormatConversionException("Wrong string section e_shstrndx=" + ((int) aVar2.f374684j));
                }
            }
            throw new UnknownFormatConversionException("Invalid e_shstrndx=" + ((int) aVar2.f374684j));
        }
        throw new UnknownFormatConversionException("Invalid elf magic: " + file);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0038 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0037 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(File file) {
        RandomAccessFile randomAccessFile;
        Object th5;
        long j3;
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (Throwable th6) {
            randomAccessFile = null;
            th5 = th6;
        }
        try {
            j3 = randomAccessFile.readInt();
        } catch (Throwable th7) {
            th5 = th7;
            try {
                com.tencent.tbs.one.impl.a.g.c("Failed to read file %s to determine if it is a elf file", file.getAbsolutePath(), th5);
                com.tencent.tbs.one.impl.a.d.a(randomAccessFile);
                j3 = 0;
                if (j3 != 2135247942) {
                }
            } finally {
                com.tencent.tbs.one.impl.a.d.a(randomAccessFile);
            }
        }
        return j3 != 2135247942;
    }

    private void b() throws IOException {
        k kVar;
        int i3;
        byte[] bArr;
        String str;
        a aVar = this.f374672h;
        com.tencent.tbs.one.impl.c.a.a aVar2 = this.f374671g;
        boolean a16 = a();
        k[] kVarArr = this.f374673i;
        int length = kVarArr.length;
        int i16 = 0;
        while (true) {
            if (i16 < length) {
                kVar = kVarArr[i16];
                int i17 = kVar.f374721a;
                if (i17 == 0) {
                    str = "SHN_UNDEF";
                } else {
                    int i18 = i17;
                    while (true) {
                        bArr = this.f374674j;
                        if (bArr[i18] == 0) {
                            break;
                        } else {
                            i18++;
                        }
                    }
                    str = new String(bArr, i17, i18 - i17);
                }
                if (".dynsym".equals(str)) {
                    break;
                } else {
                    i16++;
                }
            } else {
                kVar = null;
                break;
            }
        }
        if (kVar != null) {
            aVar2.a(kVar.b());
            int a17 = kVar.a();
            if (a16) {
                i3 = 24;
            } else {
                i3 = 16;
            }
            int i19 = a17 / i3;
            this.f374669e = new l[i19];
            char[] cArr = new char[1];
            for (int i26 = 0; i26 < i19; i26++) {
                if (a16) {
                    i iVar = new i();
                    iVar.f374725a = aVar2.b();
                    aVar2.a(cArr);
                    iVar.f374726b = cArr[0];
                    aVar2.a(cArr);
                    iVar.f374727c = cArr[0];
                    iVar.f374717e = aVar2.c();
                    iVar.f374718f = aVar2.c();
                    iVar.f374728d = aVar2.a();
                    this.f374669e[i26] = iVar;
                } else {
                    C9888e c9888e = new C9888e();
                    c9888e.f374725a = aVar2.b();
                    c9888e.f374700e = aVar2.b();
                    c9888e.f374701f = aVar2.b();
                    aVar2.a(cArr);
                    c9888e.f374726b = cArr[0];
                    aVar2.a(cArr);
                    c9888e.f374727c = cArr[0];
                    c9888e.f374728d = aVar2.a();
                    this.f374669e[i26] = c9888e;
                }
            }
            k kVar2 = this.f374673i[kVar.f374723c];
            aVar2.a(kVar2.b());
            byte[] bArr2 = new byte[kVar2.a()];
            this.f374670f = bArr2;
            aVar2.a(bArr2);
        }
        this.f374668d = new j[aVar.f374681g];
        for (int i27 = 0; i27 < aVar.f374681g; i27++) {
            aVar2.a(aVar.b() + (aVar.f374680f * i27));
            if (a16) {
                g gVar = new g();
                gVar.f374719a = aVar2.b();
                gVar.f374720b = aVar2.b();
                gVar.f374705c = aVar2.c();
                gVar.f374706d = aVar2.c();
                gVar.f374707e = aVar2.c();
                gVar.f374708f = aVar2.c();
                gVar.f374709g = aVar2.c();
                gVar.f374710h = aVar2.c();
                this.f374668d[i27] = gVar;
            } else {
                c cVar = new c();
                cVar.f374719a = aVar2.b();
                cVar.f374720b = aVar2.b();
                cVar.f374688c = aVar2.b();
                cVar.f374689d = aVar2.b();
                cVar.f374690e = aVar2.b();
                cVar.f374691f = aVar2.b();
                cVar.f374692g = aVar2.b();
                cVar.f374693h = aVar2.b();
                this.f374668d[i27] = cVar;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f374671g.close();
    }

    private boolean a() {
        return this.f374666b[4] == 2;
    }
}
