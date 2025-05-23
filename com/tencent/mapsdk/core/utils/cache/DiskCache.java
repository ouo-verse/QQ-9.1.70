package com.tencent.mapsdk.core.utils.cache;

import android.support.annotation.Keep;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mapsdk.internal.jz;
import com.tencent.mapsdk.internal.ka;
import com.tencent.mapsdk.internal.kb;
import com.tencent.mapsdk.internal.kf;
import com.tencent.mapsdk.internal.kt;
import com.tencent.mapsdk.internal.ky;
import com.tencent.mapsdk.internal.lc;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class DiskCache<D extends ka> extends kf<D> {

    /* renamed from: a, reason: collision with root package name */
    private static final String f147628a = "DiskCache";

    /* renamed from: b, reason: collision with root package name */
    private static final String f147629b = ".disk_idx";

    /* renamed from: c, reason: collision with root package name */
    private static final String f147630c = ".disk_idx_root";

    /* renamed from: k, reason: collision with root package name */
    private static final a f147631k = new a() { // from class: com.tencent.mapsdk.core.utils.cache.DiskCache.1
        @Override // com.tencent.mapsdk.core.utils.cache.DiskCache.a
        public final File a(String str, String str2, byte[] bArr) {
            File file = new File(str2, str);
            kt.a(file, bArr);
            return file;
        }

        @Override // com.tencent.mapsdk.core.utils.cache.DiskCache.a
        public final byte[] a(String str, File file) {
            return kt.c(file);
        }

        @Override // com.tencent.mapsdk.core.utils.cache.DiskCache.a
        public final boolean a(File file) {
            return kt.b(file);
        }
    };

    /* renamed from: d, reason: collision with root package name */
    private kb.a<b> f147632d;

    /* renamed from: e, reason: collision with root package name */
    private c f147633e;

    /* renamed from: f, reason: collision with root package name */
    private File f147634f;

    /* renamed from: g, reason: collision with root package name */
    private File f147635g;

    /* renamed from: h, reason: collision with root package name */
    private Map<String, String> f147636h;

    /* renamed from: i, reason: collision with root package name */
    private List<String> f147637i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f147638j;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public interface a {
        File a(String str, String str2, byte[] bArr);

        boolean a(File file);

        byte[] a(String str, File file);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static final class b extends ka {

        /* renamed from: a, reason: collision with root package name */
        File f147639a;

        /* renamed from: b, reason: collision with root package name */
        private int f147640b;

        b(File file, int i3) {
            this.f147639a = file;
            this.f147640b = i3;
        }

        @Override // com.tencent.mapsdk.internal.ka
        public final void a(byte[] bArr) {
        }

        @Override // com.tencent.mapsdk.internal.ka
        public final byte[] b() {
            return new byte[this.f147640b];
        }

        public final String toString() {
            return this.f147639a.getName() + "," + this.f147640b;
        }

        @Override // com.tencent.mapsdk.internal.ka
        public final int a() {
            return this.f147640b;
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class c extends kf.c {

        /* renamed from: b, reason: collision with root package name */
        static final long f147641b = -1;

        /* renamed from: c, reason: collision with root package name */
        public File f147642c;

        /* renamed from: d, reason: collision with root package name */
        public String f147643d;

        /* renamed from: e, reason: collision with root package name */
        public a f147644e;

        /* renamed from: f, reason: collision with root package name */
        long f147645f;

        /* renamed from: g, reason: collision with root package name */
        int f147646g;

        /* renamed from: h, reason: collision with root package name */
        final jz.b<b> f147647h;

        /* renamed from: i, reason: collision with root package name */
        jz.b<File> f147648i;

        public c() {
            super(kf.a.DISK);
            this.f147642c = kt.f149081d;
            this.f147643d = "tmp";
            this.f147644e = DiskCache.f147631k;
            this.f147645f = -1L;
            this.f147647h = new jz.b<b>() { // from class: com.tencent.mapsdk.core.utils.cache.DiskCache.c.1
                @Override // com.tencent.mapsdk.internal.jz.b
                public final /* synthetic */ boolean a(b bVar) {
                    b bVar2 = bVar;
                    if (bVar2 == null) {
                        return false;
                    }
                    jz.b<File> bVar3 = c.this.f147648i;
                    boolean a16 = bVar3 != null ? bVar3.a(bVar2.f147639a) : false;
                    if (a16) {
                        return a16;
                    }
                    kt.b(bVar2.f147639a);
                    return true;
                }

                /* renamed from: a, reason: avoid collision after fix types in other method */
                private boolean a2(b bVar) {
                    if (bVar == null) {
                        return false;
                    }
                    jz.b<File> bVar2 = c.this.f147648i;
                    boolean a16 = bVar2 != null ? bVar2.a(bVar.f147639a) : false;
                    if (a16) {
                        return a16;
                    }
                    kt.b(bVar.f147639a);
                    return true;
                }
            };
        }

        @Override // com.tencent.mapsdk.internal.kf.c
        public final String toString() {
            return "Options{mCacheDirectory=" + this.f147642c + ", mCacheName='" + this.f147643d + "', fileAccessStrategy=" + this.f147644e + "} " + super.toString();
        }

        private c a(jz.b<File> bVar) {
            this.f147648i = bVar;
            return this;
        }

        private File d() {
            return new File(this.f147642c, this.f147643d);
        }

        public final c c() {
            this.f147645f = 1024L;
            return this;
        }

        private c a(a aVar) {
            this.f147644e = aVar;
            return this;
        }

        private c a(File file) {
            this.f147642c = file;
            return this;
        }

        private c a(String str) {
            this.f147643d = str;
            return this;
        }

        c(String str) {
            super(kf.a.DISK);
            this.f147642c = kt.f149081d;
            this.f147643d = "tmp";
            this.f147644e = DiskCache.f147631k;
            this.f147645f = -1L;
            this.f147647h = new jz.b<b>() { // from class: com.tencent.mapsdk.core.utils.cache.DiskCache.c.1
                @Override // com.tencent.mapsdk.internal.jz.b
                public final /* synthetic */ boolean a(b bVar) {
                    b bVar2 = bVar;
                    if (bVar2 == null) {
                        return false;
                    }
                    jz.b<File> bVar3 = c.this.f147648i;
                    boolean a16 = bVar3 != null ? bVar3.a(bVar2.f147639a) : false;
                    if (a16) {
                        return a16;
                    }
                    kt.b(bVar2.f147639a);
                    return true;
                }

                /* renamed from: a, reason: avoid collision after fix types in other method */
                private boolean a2(b bVar) {
                    if (bVar == null) {
                        return false;
                    }
                    jz.b<File> bVar2 = c.this.f147648i;
                    boolean a16 = bVar2 != null ? bVar2.a(bVar.f147639a) : false;
                    if (a16) {
                        return a16;
                    }
                    kt.b(bVar.f147639a);
                    return true;
                }
            };
            this.f147643d = str;
        }

        public c(int i3) {
            super(kf.a.DISK);
            this.f147642c = kt.f149081d;
            this.f147643d = "tmp";
            this.f147644e = DiskCache.f147631k;
            this.f147645f = -1L;
            this.f147647h = new jz.b<b>() { // from class: com.tencent.mapsdk.core.utils.cache.DiskCache.c.1
                @Override // com.tencent.mapsdk.internal.jz.b
                public final /* synthetic */ boolean a(b bVar) {
                    b bVar2 = bVar;
                    if (bVar2 == null) {
                        return false;
                    }
                    jz.b<File> bVar3 = c.this.f147648i;
                    boolean a16 = bVar3 != null ? bVar3.a(bVar2.f147639a) : false;
                    if (a16) {
                        return a16;
                    }
                    kt.b(bVar2.f147639a);
                    return true;
                }

                /* renamed from: a, reason: avoid collision after fix types in other method */
                private boolean a2(b bVar) {
                    if (bVar == null) {
                        return false;
                    }
                    jz.b<File> bVar2 = c.this.f147648i;
                    boolean a16 = bVar2 != null ? bVar2.a(bVar.f147639a) : false;
                    if (a16) {
                        return a16;
                    }
                    kt.b(bVar.f147639a);
                    return true;
                }
            };
            this.f147646g = i3;
        }
    }

    @Keep
    public DiskCache(c cVar) {
        super(cVar);
        boolean z16;
        this.f147633e = cVar;
        if (cVar != null) {
            this.f147634f = kt.a(cVar.f147642c, cVar.f147643d);
            c cVar2 = this.f147633e;
            int i3 = cVar2.f148969k;
            if (i3 == -1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this.f147638j = z16;
            if (!z16) {
                this.f147632d = new kb.a<>(i3, cVar2.f147647h);
            }
            this.f147635g = kt.b(this.f147634f, f147630c);
            this.f147637i = new ArrayList();
            this.f147636h = new HashMap();
            List<String> d16 = kt.d(this.f147635g);
            if (d16 != null) {
                for (String str : d16) {
                    if (str.length() > 0) {
                        String[] split = str.split("#");
                        if (split.length > 1) {
                            for (String str2 : split[1].split(",")) {
                                this.f147636h.put(str2, split[0]);
                            }
                        }
                    }
                }
            }
            lc.a("loadRootIndex count:" + this.f147636h.size(), "disk_cache_dir:" + this.f147634f);
        }
    }

    private c n() {
        return this.f147633e;
    }

    private void o() {
        this.f147635g = kt.b(this.f147634f, f147630c);
        this.f147637i = new ArrayList();
        this.f147636h = new HashMap();
        List<String> d16 = kt.d(this.f147635g);
        if (d16 != null) {
            for (String str : d16) {
                if (str.length() > 0) {
                    String[] split = str.split("#");
                    if (split.length > 1) {
                        for (String str2 : split[1].split(",")) {
                            this.f147636h.put(str2, split[0]);
                        }
                    }
                }
            }
        }
        lc.a("loadRootIndex count:" + this.f147636h.size(), "disk_cache_dir:" + this.f147634f);
    }

    @Override // com.tencent.mapsdk.internal.jz
    public final void a(String str, D d16) {
        if (TextUtils.isEmpty(str) || d16 == null) {
            return;
        }
        lc.b(ky.f149111q, str, this.f147633e.f147646g);
        String a16 = this.f147633e.f148970l.a(str);
        byte[] b16 = d16.b();
        if (b16 != null) {
            File a17 = this.f147633e.f147644e.a(a16, this.f147634f.getAbsolutePath(), b16);
            if (!this.f147638j || this.f147633e.f147645f != -1) {
                b bVar = new b(a17, b16.length);
                if (!this.f147638j) {
                    this.f147632d.a((kb.a<b>) a16, (String) bVar);
                }
                File file = bVar.f147639a;
                if (file != null) {
                    File parentFile = file.getParentFile();
                    File b17 = kt.b(parentFile, f147629b);
                    String str2 = a16 + "#" + bVar.toString();
                    if (kt.d(b17, str2) == -1) {
                        lc.a(f147628a).a("index writeLine data:".concat(String.valueOf(str2)));
                        kt.c(b17, str2);
                    }
                    int d17 = kt.d(this.f147635g, parentFile.getAbsolutePath());
                    if (d17 != -1) {
                        String concat = ",".concat(String.valueOf(a16));
                        String a18 = kt.a(this.f147635g, d17);
                        if (a18 != null && !a18.contains(a16)) {
                            lc.a(f147628a).a("root writeAppend data:".concat(String.valueOf(concat)));
                            kt.a(this.f147635g, d17, ",".concat(String.valueOf(a16)));
                        }
                    } else {
                        String str3 = parentFile.getAbsolutePath() + "#" + a16;
                        lc.a(f147628a).a("root writeLine data:".concat(String.valueOf(str3)));
                        kt.c(this.f147635g, str3);
                    }
                    this.f147636h.put(a16, parentFile.getAbsolutePath());
                }
            }
        }
        lc.a(ky.f149111q, str, (Object) "put data length", b16 != null ? b16.length : 0);
    }

    @Override // com.tencent.mapsdk.internal.jz
    public final void b() {
        File file = this.f147634f;
        if (file != null) {
            if (this.f147638j) {
                this.f147633e.f147644e.a(file);
            } else {
                this.f147632d.a();
                this.f147633e.f147644e.a(this.f147634f);
            }
        }
    }

    @Override // com.tencent.mapsdk.internal.jz
    public final long c() {
        int size;
        if (this.f147638j) {
            c cVar = this.f147633e;
            if (cVar == null || cVar.f147645f == -1) {
                return -1L;
            }
            size = this.f147636h.size();
        } else {
            size = this.f147632d.d().size();
        }
        return size;
    }

    @Override // com.tencent.mapsdk.internal.jz
    public final long d() {
        if (this.f147638j) {
            return -1L;
        }
        return this.f147632d.b();
    }

    @Override // com.tencent.mapsdk.internal.jz, com.tencent.mapsdk.internal.kg
    public final long e() {
        if (this.f147638j) {
            return -1L;
        }
        return this.f147632d.c();
    }

    public final void f() {
        c cVar = this.f147633e;
        if (cVar != null && cVar.f147645f != -1 && this.f147636h.size() > this.f147633e.f147645f) {
            lc.a("cached tile count:" + this.f147636h.size());
            Log.d("dorothy", "cached tile count:" + this.f147636h.size());
            b();
        }
    }

    @Override // com.tencent.mapsdk.internal.kf
    public final /* bridge */ /* synthetic */ kf.c g() {
        return this.f147633e;
    }

    private void d(String str) {
        String a16;
        String str2 = this.f147636h.get(str);
        if (str2 != null) {
            lc.a(f147628a).a("key\uff1a".concat(String.valueOf(str)), "dir : ".concat(str2));
            File file = new File(new File(str2), f147629b);
            int d16 = kt.d(file, str);
            if (d16 != -1) {
                kt.b(file, d16);
            }
            int d17 = kt.d(this.f147635g, str2);
            if (d17 == -1 || (a16 = kt.a(this.f147635g, d17)) == null || !a16.contains(str)) {
                return;
            }
            kt.b(this.f147635g, d17, a16.replaceAll(str + ",", ""));
        }
    }

    private void c(String str) {
        String str2 = this.f147636h.get(str);
        if (str2 == null || this.f147637i.contains(str2)) {
            return;
        }
        lc.a(f147628a).a("key\uff1a".concat(String.valueOf(str)), "dir : ".concat(str2));
        List<String> d16 = kt.d(kt.b(new File(str2), f147629b));
        if (d16 == null || d16.isEmpty()) {
            return;
        }
        lc.a(f147628a).a(d16.toArray());
        if (this.f147632d != null) {
            Iterator<String> it = d16.iterator();
            while (it.hasNext()) {
                String[] split = it.next().split("#");
                String[] split2 = split[1].split(",");
                this.f147632d.a((kb.a<b>) split[0], (String) new b(new File(str2, split2[0]), Integer.parseInt(split2[1])));
            }
        }
        if (d16.size() > 0) {
            this.f147637i.add(str2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x008b  */
    @Override // com.tencent.mapsdk.internal.jz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final D a(String str, Class<D> cls) {
        b bVar;
        File file;
        byte[] a16;
        String a17 = this.f147633e.f148970l.a(str);
        D d16 = null;
        if (!this.f147638j || this.f147633e.f147645f != -1) {
            c(a17);
            if (!this.f147638j && (bVar = (b) this.f147632d.b((kb.a<b>) a17)) != null) {
                file = bVar.f147639a;
                a16 = this.f147633e.f147644e.a(a17, file);
                if (a16 != null) {
                    try {
                        d16 = cls.newInstance();
                        d16.a(a16);
                    } catch (IllegalAccessException e16) {
                        throw new Error("The " + cls.getSimpleName() + " must have a empty construct. #" + e16.getMessage(), e16);
                    } catch (InstantiationException e17) {
                        throw new Error("The " + cls.getSimpleName() + " must have a empty construct. #" + e17.getMessage(), e17);
                    }
                }
                lc.a(ky.f149111q, str, (Object) "get data length", a16 != null ? 0 : a16.length);
                lc.f(ky.f149111q, str, this.f147633e.f147646g);
                return d16;
            }
        }
        file = null;
        a16 = this.f147633e.f147644e.a(a17, file);
        if (a16 != null) {
        }
        lc.a(ky.f149111q, str, (Object) "get data length", a16 != null ? 0 : a16.length);
        lc.f(ky.f149111q, str, this.f147633e.f147646g);
        return d16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mapsdk.internal.jz
    public final boolean a(String str) {
        String str2;
        String a16;
        String a17 = this.f147633e.f148970l.a(str);
        if (!this.f147638j || this.f147633e.f147645f != -1) {
            c(a17);
            if (!this.f147638j) {
                b bVar = (b) this.f147632d.b((kb.a<b>) a17);
                r1 = bVar != null ? bVar.f147639a : null;
                if (r1 != null && r1.exists()) {
                    this.f147632d.c(a17);
                }
            }
            if (r1 != null && r1.exists() && (str2 = this.f147636h.get(a17)) != null) {
                lc.a(f147628a).a("key\uff1a".concat(String.valueOf(a17)), "dir : ".concat(str2));
                File file = new File(new File(str2), f147629b);
                int d16 = kt.d(file, a17);
                if (d16 != -1) {
                    kt.b(file, d16);
                }
                int d17 = kt.d(this.f147635g, str2);
                if (d17 != -1 && (a16 = kt.a(this.f147635g, d17)) != null && a16.contains(a17)) {
                    kt.b(this.f147635g, d17, a16.replaceAll(a17 + ",", ""));
                }
            }
        }
        return this.f147633e.f147644e.a(r1);
    }

    private void a(String str, b bVar) {
        File file = bVar.f147639a;
        if (file == null) {
            return;
        }
        File parentFile = file.getParentFile();
        File b16 = kt.b(parentFile, f147629b);
        String str2 = str + "#" + bVar.toString();
        if (kt.d(b16, str2) == -1) {
            lc.a(f147628a).a("index writeLine data:".concat(String.valueOf(str2)));
            kt.c(b16, str2);
        }
        int d16 = kt.d(this.f147635g, parentFile.getAbsolutePath());
        if (d16 != -1) {
            String concat = ",".concat(String.valueOf(str));
            String a16 = kt.a(this.f147635g, d16);
            if (a16 != null && !a16.contains(str)) {
                lc.a(f147628a).a("root writeAppend data:".concat(String.valueOf(concat)));
                kt.a(this.f147635g, d16, ",".concat(String.valueOf(str)));
            }
        } else {
            String str3 = parentFile.getAbsolutePath() + "#" + str;
            lc.a(f147628a).a("root writeLine data:".concat(String.valueOf(str3)));
            kt.c(this.f147635g, str3);
        }
        this.f147636h.put(str, parentFile.getAbsolutePath());
    }
}
