package com.tencent.smtt.utils;

import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.UnknownFormatConversionException;

/* compiled from: P */
/* loaded from: classes25.dex */
public class e implements Closeable {

    /* renamed from: a, reason: collision with root package name */
    static final char[] f369680a = {'\u007f', 'E', 'L', 'F', 0};

    /* renamed from: b, reason: collision with root package name */
    final char[] f369681b;

    /* renamed from: c, reason: collision with root package name */
    boolean f369682c;

    /* renamed from: d, reason: collision with root package name */
    j[] f369683d;

    /* renamed from: e, reason: collision with root package name */
    l[] f369684e;

    /* renamed from: f, reason: collision with root package name */
    byte[] f369685f;

    /* renamed from: g, reason: collision with root package name */
    private final com.tencent.smtt.utils.c f369686g;

    /* renamed from: h, reason: collision with root package name */
    private final a f369687h;

    /* renamed from: i, reason: collision with root package name */
    private final k[] f369688i;

    /* renamed from: j, reason: collision with root package name */
    private byte[] f369689j;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        short f369690a;

        /* renamed from: b, reason: collision with root package name */
        short f369691b;

        /* renamed from: c, reason: collision with root package name */
        int f369692c;

        /* renamed from: d, reason: collision with root package name */
        int f369693d;

        /* renamed from: e, reason: collision with root package name */
        short f369694e;

        /* renamed from: f, reason: collision with root package name */
        short f369695f;

        /* renamed from: g, reason: collision with root package name */
        short f369696g;

        /* renamed from: h, reason: collision with root package name */
        short f369697h;

        /* renamed from: i, reason: collision with root package name */
        short f369698i;

        /* renamed from: j, reason: collision with root package name */
        short f369699j;

        abstract long a();

        abstract long b();
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    static class b extends a {

        /* renamed from: k, reason: collision with root package name */
        int f369700k;

        /* renamed from: l, reason: collision with root package name */
        int f369701l;

        /* renamed from: m, reason: collision with root package name */
        int f369702m;

        b() {
        }

        @Override // com.tencent.smtt.utils.e.a
        long a() {
            return this.f369702m;
        }

        @Override // com.tencent.smtt.utils.e.a
        long b() {
            return this.f369701l;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class c extends j {

        /* renamed from: a, reason: collision with root package name */
        int f369703a;

        /* renamed from: b, reason: collision with root package name */
        int f369704b;

        /* renamed from: c, reason: collision with root package name */
        int f369705c;

        /* renamed from: d, reason: collision with root package name */
        int f369706d;

        /* renamed from: e, reason: collision with root package name */
        int f369707e;

        /* renamed from: f, reason: collision with root package name */
        int f369708f;

        c() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    static class d extends k {

        /* renamed from: a, reason: collision with root package name */
        int f369709a;

        /* renamed from: b, reason: collision with root package name */
        int f369710b;

        /* renamed from: c, reason: collision with root package name */
        int f369711c;

        /* renamed from: d, reason: collision with root package name */
        int f369712d;

        /* renamed from: e, reason: collision with root package name */
        int f369713e;

        /* renamed from: f, reason: collision with root package name */
        int f369714f;

        d() {
        }

        @Override // com.tencent.smtt.utils.e.k
        public int a() {
            return this.f369712d;
        }

        @Override // com.tencent.smtt.utils.e.k
        public long b() {
            return this.f369711c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.smtt.utils.e$e, reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C9800e extends l {

        /* renamed from: a, reason: collision with root package name */
        int f369715a;

        /* renamed from: b, reason: collision with root package name */
        int f369716b;

        C9800e() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    static class f extends a {

        /* renamed from: k, reason: collision with root package name */
        long f369717k;

        /* renamed from: l, reason: collision with root package name */
        long f369718l;

        /* renamed from: m, reason: collision with root package name */
        long f369719m;

        f() {
        }

        @Override // com.tencent.smtt.utils.e.a
        long a() {
            return this.f369719m;
        }

        @Override // com.tencent.smtt.utils.e.a
        long b() {
            return this.f369718l;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class g extends j {

        /* renamed from: a, reason: collision with root package name */
        long f369720a;

        /* renamed from: b, reason: collision with root package name */
        long f369721b;

        /* renamed from: c, reason: collision with root package name */
        long f369722c;

        /* renamed from: d, reason: collision with root package name */
        long f369723d;

        /* renamed from: e, reason: collision with root package name */
        long f369724e;

        /* renamed from: f, reason: collision with root package name */
        long f369725f;

        g() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    static class h extends k {

        /* renamed from: a, reason: collision with root package name */
        long f369726a;

        /* renamed from: b, reason: collision with root package name */
        long f369727b;

        /* renamed from: c, reason: collision with root package name */
        long f369728c;

        /* renamed from: d, reason: collision with root package name */
        long f369729d;

        /* renamed from: e, reason: collision with root package name */
        long f369730e;

        /* renamed from: f, reason: collision with root package name */
        long f369731f;

        h() {
        }

        @Override // com.tencent.smtt.utils.e.k
        public int a() {
            return (int) this.f369729d;
        }

        @Override // com.tencent.smtt.utils.e.k
        public long b() {
            return this.f369728c;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static class i extends l {

        /* renamed from: a, reason: collision with root package name */
        long f369732a;

        /* renamed from: b, reason: collision with root package name */
        long f369733b;

        i() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static abstract class j {

        /* renamed from: g, reason: collision with root package name */
        int f369734g;

        /* renamed from: h, reason: collision with root package name */
        int f369735h;

        j() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static abstract class k {

        /* renamed from: g, reason: collision with root package name */
        int f369736g;

        /* renamed from: h, reason: collision with root package name */
        int f369737h;

        /* renamed from: i, reason: collision with root package name */
        int f369738i;

        /* renamed from: j, reason: collision with root package name */
        int f369739j;

        public abstract int a();

        public abstract long b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public static abstract class l {

        /* renamed from: c, reason: collision with root package name */
        int f369740c;

        /* renamed from: d, reason: collision with root package name */
        char f369741d;

        /* renamed from: e, reason: collision with root package name */
        char f369742e;

        /* renamed from: f, reason: collision with root package name */
        short f369743f;

        l() {
        }
    }

    public e(File file) throws IOException, UnknownFormatConversionException {
        char[] cArr = new char[16];
        this.f369681b = cArr;
        com.tencent.smtt.utils.c cVar = new com.tencent.smtt.utils.c(file);
        this.f369686g = cVar;
        cVar.a(cArr);
        if (a()) {
            cVar.a(e());
            boolean d16 = d();
            if (d16) {
                f fVar = new f();
                fVar.f369690a = cVar.a();
                fVar.f369691b = cVar.a();
                fVar.f369692c = cVar.b();
                fVar.f369717k = cVar.c();
                fVar.f369718l = cVar.c();
                fVar.f369719m = cVar.c();
                this.f369687h = fVar;
            } else {
                b bVar = new b();
                bVar.f369690a = cVar.a();
                bVar.f369691b = cVar.a();
                bVar.f369692c = cVar.b();
                bVar.f369700k = cVar.b();
                bVar.f369701l = cVar.b();
                bVar.f369702m = cVar.b();
                this.f369687h = bVar;
            }
            a aVar = this.f369687h;
            aVar.f369693d = cVar.b();
            aVar.f369694e = cVar.a();
            aVar.f369695f = cVar.a();
            aVar.f369696g = cVar.a();
            aVar.f369697h = cVar.a();
            aVar.f369698i = cVar.a();
            aVar.f369699j = cVar.a();
            this.f369688i = new k[aVar.f369698i];
            for (int i3 = 0; i3 < aVar.f369698i; i3++) {
                cVar.a(aVar.a() + (aVar.f369697h * i3));
                if (d16) {
                    h hVar = new h();
                    hVar.f369736g = cVar.b();
                    hVar.f369737h = cVar.b();
                    hVar.f369726a = cVar.c();
                    hVar.f369727b = cVar.c();
                    hVar.f369728c = cVar.c();
                    hVar.f369729d = cVar.c();
                    hVar.f369738i = cVar.b();
                    hVar.f369739j = cVar.b();
                    hVar.f369730e = cVar.c();
                    hVar.f369731f = cVar.c();
                    this.f369688i[i3] = hVar;
                } else {
                    d dVar = new d();
                    dVar.f369736g = cVar.b();
                    dVar.f369737h = cVar.b();
                    dVar.f369709a = cVar.b();
                    dVar.f369710b = cVar.b();
                    dVar.f369711c = cVar.b();
                    dVar.f369712d = cVar.b();
                    dVar.f369738i = cVar.b();
                    dVar.f369739j = cVar.b();
                    dVar.f369713e = cVar.b();
                    dVar.f369714f = cVar.b();
                    this.f369688i[i3] = dVar;
                }
            }
            short s16 = aVar.f369699j;
            if (s16 > -1) {
                k[] kVarArr = this.f369688i;
                if (s16 < kVarArr.length) {
                    k kVar = kVarArr[s16];
                    if (kVar.f369737h == 3) {
                        this.f369689j = new byte[kVar.a()];
                        cVar.a(kVar.b());
                        cVar.a(this.f369689j);
                        if (this.f369682c) {
                            f();
                            return;
                        }
                        return;
                    }
                    throw new UnknownFormatConversionException("Wrong string section e_shstrndx=" + ((int) aVar.f369699j));
                }
            }
            throw new UnknownFormatConversionException("Invalid e_shstrndx=" + ((int) aVar.f369699j));
        }
        throw new UnknownFormatConversionException("Invalid elf magic: " + file);
    }

    private void f() throws IOException {
        int i3;
        a aVar = this.f369687h;
        com.tencent.smtt.utils.c cVar = this.f369686g;
        boolean d16 = d();
        k a16 = a(".dynsym");
        if (a16 != null) {
            cVar.a(a16.b());
            int a17 = a16.a();
            if (d16) {
                i3 = 24;
            } else {
                i3 = 16;
            }
            int i16 = a17 / i3;
            this.f369684e = new l[i16];
            char[] cArr = new char[1];
            for (int i17 = 0; i17 < i16; i17++) {
                if (d16) {
                    i iVar = new i();
                    iVar.f369740c = cVar.b();
                    cVar.a(cArr);
                    iVar.f369741d = cArr[0];
                    cVar.a(cArr);
                    iVar.f369742e = cArr[0];
                    iVar.f369732a = cVar.c();
                    iVar.f369733b = cVar.c();
                    iVar.f369743f = cVar.a();
                    this.f369684e[i17] = iVar;
                } else {
                    C9800e c9800e = new C9800e();
                    c9800e.f369740c = cVar.b();
                    c9800e.f369715a = cVar.b();
                    c9800e.f369716b = cVar.b();
                    cVar.a(cArr);
                    c9800e.f369741d = cArr[0];
                    cVar.a(cArr);
                    c9800e.f369742e = cArr[0];
                    c9800e.f369743f = cVar.a();
                    this.f369684e[i17] = c9800e;
                }
            }
            k kVar = this.f369688i[a16.f369738i];
            cVar.a(kVar.b());
            byte[] bArr = new byte[kVar.a()];
            this.f369685f = bArr;
            cVar.a(bArr);
        }
        this.f369683d = new j[aVar.f369696g];
        for (int i18 = 0; i18 < aVar.f369696g; i18++) {
            cVar.a(aVar.b() + (aVar.f369695f * i18));
            if (d16) {
                g gVar = new g();
                gVar.f369734g = cVar.b();
                gVar.f369735h = cVar.b();
                gVar.f369720a = cVar.c();
                gVar.f369721b = cVar.c();
                gVar.f369722c = cVar.c();
                gVar.f369723d = cVar.c();
                gVar.f369724e = cVar.c();
                gVar.f369725f = cVar.c();
                this.f369683d[i18] = gVar;
            } else {
                c cVar2 = new c();
                cVar2.f369734g = cVar.b();
                cVar2.f369735h = cVar.b();
                cVar2.f369703a = cVar.b();
                cVar2.f369704b = cVar.b();
                cVar2.f369705c = cVar.b();
                cVar2.f369706d = cVar.b();
                cVar2.f369707e = cVar.b();
                cVar2.f369708f = cVar.b();
                this.f369683d[i18] = cVar2;
            }
        }
    }

    private static boolean g() {
        String property = System.getProperty("java.vm.version");
        if (property != null && property.startsWith("2")) {
            return true;
        }
        return false;
    }

    final boolean a() {
        return this.f369681b[0] == f369680a[0];
    }

    final char b() {
        return this.f369681b[4];
    }

    final char c() {
        return this.f369681b[5];
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f369686g.close();
    }

    public final boolean d() {
        if (b() == 2) {
            return true;
        }
        return false;
    }

    public final boolean e() {
        if (c() == 1) {
            return true;
        }
        return false;
    }

    public static boolean b(File file) {
        if (!g() || !a(file)) {
            return true;
        }
        try {
            new e(file);
            return true;
        } catch (IOException e16) {
            Log.e("ELF", "checkElfFile IOException: " + e16);
            return false;
        } catch (UnknownFormatConversionException e17) {
            Log.e("ELF", "checkElfFile UnknownFormatConversionException: " + e17);
            return true;
        } catch (Throwable th5) {
            Log.e("ELF", "checkElfFile Throwable: " + th5);
            return true;
        }
    }

    public final k a(String str) {
        for (k kVar : this.f369688i) {
            if (str.equals(a(kVar.f369736g))) {
                return kVar;
            }
        }
        return null;
    }

    public final String a(int i3) {
        if (i3 == 0) {
            return "SHN_UNDEF";
        }
        int i16 = i3;
        while (true) {
            byte[] bArr = this.f369689j;
            if (bArr[i16] == 0) {
                return new String(bArr, i3, i16 - i3);
            }
            i16++;
        }
    }

    public static boolean a(File file) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            long readInt = randomAccessFile.readInt();
            randomAccessFile.close();
            return readInt == 2135247942;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }
}
