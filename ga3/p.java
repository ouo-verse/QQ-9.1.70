package ga3;

import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.wink.storage.kv.MaskType;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes21.dex */
public class p {

    /* renamed from: v, reason: collision with root package name */
    private static final int[] f401639v = {0, 1, 4, 4, 8, 8};

    /* renamed from: w, reason: collision with root package name */
    private static final byte[] f401640w = new byte[0];

    /* renamed from: x, reason: collision with root package name */
    private static final int f401641x;

    /* renamed from: y, reason: collision with root package name */
    private static final int f401642y;

    /* renamed from: z, reason: collision with root package name */
    private static final int f401643z;

    /* renamed from: a, reason: collision with root package name */
    private final String f401644a;

    /* renamed from: b, reason: collision with root package name */
    private final String f401645b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, b> f401646c;

    /* renamed from: d, reason: collision with root package name */
    private FileChannel f401647d;

    /* renamed from: e, reason: collision with root package name */
    private FileChannel f401648e;

    /* renamed from: f, reason: collision with root package name */
    private MappedByteBuffer f401649f;

    /* renamed from: g, reason: collision with root package name */
    private MappedByteBuffer f401650g;

    /* renamed from: h, reason: collision with root package name */
    private m f401651h;

    /* renamed from: i, reason: collision with root package name */
    private int f401652i;

    /* renamed from: j, reason: collision with root package name */
    private long f401653j;

    /* renamed from: m, reason: collision with root package name */
    private int f401656m;

    /* renamed from: n, reason: collision with root package name */
    private int f401657n;

    /* renamed from: o, reason: collision with root package name */
    private int f401658o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f401659p;

    /* renamed from: q, reason: collision with root package name */
    private String f401660q;

    /* renamed from: r, reason: collision with root package name */
    private int f401661r;

    /* renamed from: t, reason: collision with root package name */
    private int f401663t;

    /* renamed from: k, reason: collision with root package name */
    private final Map<String, ga3.b> f401654k = new HashMap();

    /* renamed from: l, reason: collision with root package name */
    private boolean f401655l = false;

    /* renamed from: s, reason: collision with root package name */
    private final ArrayList<c> f401662s = new ArrayList<>();

    /* renamed from: u, reason: collision with root package name */
    private boolean f401664u = true;

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class a {

        /* renamed from: e, reason: collision with root package name */
        private static final Map<String, p> f401665e = new ConcurrentHashMap();

        /* renamed from: a, reason: collision with root package name */
        private final String f401666a;

        /* renamed from: b, reason: collision with root package name */
        private final String f401667b;

        /* renamed from: c, reason: collision with root package name */
        private b[] f401668c;

        /* renamed from: d, reason: collision with root package name */
        private int f401669d = 0;

        public a(String str, String str2) {
            if (str != null && !str.isEmpty()) {
                if (str2 != null && !str2.isEmpty()) {
                    if (!str.endsWith("/")) {
                        str = str + '/';
                    }
                    this.f401666a = str;
                    this.f401667b = str2;
                    return;
                }
                throw new IllegalArgumentException("name is empty");
            }
            throw new IllegalArgumentException("path is empty");
        }

        public p a() {
            String str = this.f401666a + this.f401667b;
            Map<String, p> map = f401665e;
            p pVar = map.get(str);
            if (pVar == null) {
                synchronized (a.class) {
                    pVar = map.get(str);
                    if (pVar == null) {
                        pVar = new p(this.f401666a, this.f401667b, this.f401668c, this.f401669d);
                        map.put(str, pVar);
                    }
                }
            }
            return pVar;
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface b<T> {
        T a(byte[] bArr, int i3, int i16);

        byte[] encode(T t16);

        String tag();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class c implements Comparable<c> {

        /* renamed from: d, reason: collision with root package name */
        int f401670d;

        /* renamed from: e, reason: collision with root package name */
        int f401671e;

        c(int i3, int i16) {
            this.f401670d = i3;
            this.f401671e = i16;
        }

        @Override // java.lang.Comparable
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            return this.f401670d - cVar.f401670d;
        }
    }

    static {
        int f16 = l.f();
        f401641x = f16;
        int max = Math.max(f16 << 1, 16384);
        f401642y = max;
        f401643z = max << 1;
    }

    p(String str, String str2, b[] bVarArr, int i3) {
        this.f401644a = str;
        this.f401645b = str2;
        this.f401663t = i3;
        HashMap hashMap = new HashMap();
        k kVar = k.f401631a;
        hashMap.put(kVar.tag(), kVar);
        if (bVarArr != null && bVarArr.length > 0) {
            for (b bVar : bVarArr) {
                String tag = bVar.tag();
                if (hashMap.containsKey(tag)) {
                    s("duplicate encoder tag:" + tag);
                } else {
                    hashMap.put(tag, bVar);
                }
            }
        }
        this.f401646c = hashMap;
        synchronized (this.f401654k) {
            q.a().execute(new Runnable() { // from class: ga3.n
                @Override // java.lang.Runnable
                public final void run() {
                    p.this.N();
                }
            });
            while (!this.f401655l) {
                try {
                    LockMethodProxy.wait(this.f401654k);
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    private void A0(String str, byte b16, int i3) {
        int n3 = m.n(str);
        i(n3);
        this.f401657n = n3 + 2 + i3;
        S();
        this.f401651h.q(b16);
        a0(str, n3);
    }

    private boolean B0(m mVar) {
        int length = mVar.f401635b.length;
        File file = new File(this.f401644a, this.f401645b + ".kva");
        File file2 = new File(this.f401644a, this.f401645b + ".kvb");
        try {
            if (l.g(file) && l.g(file2)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                long j3 = length;
                randomAccessFile.setLength(j3);
                randomAccessFile2.setLength(j3);
                this.f401647d = randomAccessFile.getChannel();
                this.f401648e = randomAccessFile2.getChannel();
                MappedByteBuffer map = this.f401647d.map(FileChannel.MapMode.READ_WRITE, 0L, j3);
                this.f401649f = map;
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                map.order(byteOrder);
                MappedByteBuffer map2 = this.f401648e.map(FileChannel.MapMode.READ_WRITE, 0L, j3);
                this.f401650g = map2;
                map2.order(byteOrder);
                this.f401649f.put(mVar.f401635b, 0, this.f401652i);
                this.f401650g.put(mVar.f401635b, 0, this.f401652i);
                return true;
            }
            throw new Exception("open file failed");
        } catch (Exception e16) {
            t(e16);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean C0() {
        try {
            File file = new File(this.f401644a, this.f401645b + ".tmp");
            if (l.g(file)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.setLength(this.f401652i);
                randomAccessFile.write(this.f401651h.f401635b, 0, this.f401652i);
                randomAccessFile.close();
                File file2 = new File(this.f401644a, this.f401645b + ".kvc");
                if (!file2.exists() || file2.delete()) {
                    if (file.renameTo(file2)) {
                        return true;
                    }
                    w0(new Exception("rename failed"));
                }
            }
        } catch (Exception e16) {
            t(e16);
        }
        return false;
    }

    private int F(int i3, int i16) {
        if (i16 <= 536870912) {
            int i17 = f401641x;
            if (i16 <= i17) {
                return i17;
            }
            while (i3 < i16) {
                int i18 = f401642y;
                if (i3 <= i18) {
                    i3 <<= 1;
                } else {
                    i3 += i18;
                }
            }
            return i3;
        }
        throw new IllegalStateException("data size out of limit");
    }

    private Object G(h hVar) {
        try {
            byte[] e16 = l.e(new File(this.f401644a + this.f401645b, (String) hVar.f401627b));
            if (e16 != null) {
                int i3 = e16[0] & 255;
                String str = new String(e16, 1, i3, StandardCharsets.UTF_8);
                b bVar = this.f401646c.get(str);
                if (bVar != null) {
                    int i16 = i3 + 1;
                    return bVar.a(e16, i16, e16.length - i16);
                }
                w0(new Exception("No encoder for tag:" + str));
                return null;
            }
            w0(new Exception("Read object data failed"));
            return null;
        } catch (Exception e17) {
            t(e17);
            return null;
        }
    }

    private String J(i iVar) {
        try {
            byte[] e16 = l.e(new File(this.f401644a + this.f401645b, (String) iVar.f401627b));
            if (e16 != null && e16.length != 0) {
                return new String(e16, StandardCharsets.UTF_8);
            }
            return "";
        } catch (Exception e17) {
            t(e17);
        }
        return "";
    }

    private void K(String str) {
        r.b("WinkKV", str);
    }

    private boolean L() {
        m mVar = new m(this.f401652i);
        M(this.f401650g, mVar, this.f401652i);
        byte[] bArr = this.f401651h.f401635b;
        byte[] bArr2 = mVar.f401635b;
        for (int i3 = 0; i3 < this.f401652i; i3++) {
            if (bArr[i3] != bArr2[i3]) {
                return false;
            }
        }
        return true;
    }

    private void M(MappedByteBuffer mappedByteBuffer, m mVar, int i3) {
        mappedByteBuffer.rewind();
        mappedByteBuffer.get(mVar.f401635b, 0, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void N() {
        synchronized (this.f401654k) {
            this.f401655l = true;
            this.f401654k.notify();
        }
        System.nanoTime();
        if (!P() && this.f401663t == 0) {
            O();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x017c A[Catch: Exception -> 0x018f, TryCatch #0 {Exception -> 0x018f, blocks: (B:3:0x003b, B:5:0x0041, B:7:0x0047, B:10:0x0076, B:13:0x0091, B:16:0x00ad, B:19:0x00b1, B:21:0x00cd, B:23:0x00d4, B:25:0x00eb, B:27:0x00f1, B:31:0x00fc, B:34:0x0102, B:37:0x011a, B:39:0x0120, B:41:0x0139, B:42:0x0146, B:44:0x015b, B:46:0x0161, B:48:0x017c, B:53:0x008d, B:54:0x0073, B:55:0x0186, B:56:0x018e), top: B:2:0x003b }] */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void O() {
        long j3;
        long j16;
        boolean z16;
        boolean z17;
        File file = new File(this.f401644a, this.f401645b + ".kva");
        File file2 = new File(this.f401644a, this.f401645b + ".kvb");
        try {
            if (l.g(file) && l.g(file2)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                long length = randomAccessFile.length();
                long length2 = randomAccessFile2.length();
                this.f401647d = randomAccessFile.getChannel();
                this.f401648e = randomAccessFile2.getChannel();
                FileChannel fileChannel = this.f401647d;
                FileChannel.MapMode mapMode = FileChannel.MapMode.READ_WRITE;
                if (length > 0) {
                    j3 = length;
                } else {
                    j3 = f401641x;
                }
                MappedByteBuffer map = fileChannel.map(mapMode, 0L, j3);
                this.f401649f = map;
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                map.order(byteOrder);
                FileChannel fileChannel2 = this.f401648e;
                FileChannel.MapMode mapMode2 = FileChannel.MapMode.READ_WRITE;
                if (length2 > 0) {
                    j16 = length2;
                } else {
                    j16 = f401641x;
                }
                MappedByteBuffer map2 = fileChannel2.map(mapMode2, 0L, j16);
                this.f401650g = map2;
                map2.order(byteOrder);
                this.f401651h = new m(this.f401649f.capacity());
                if (length == 0 && length2 == 0) {
                    this.f401652i = 12;
                    return;
                }
                int i3 = this.f401649f.getInt();
                long j17 = this.f401649f.getLong();
                int i16 = this.f401650g.getInt();
                long j18 = this.f401650g.getLong();
                if (i3 >= 0 && i3 <= length - 12) {
                    int i17 = i3 + 12;
                    this.f401652i = i17;
                    M(this.f401649f, this.f401651h, i17);
                    if (j17 == this.f401651h.f(12, i3) && R() == 0) {
                        this.f401653j = j17;
                        z16 = true;
                        if (!z16) {
                            if (length != length2 || !L()) {
                                w0(new Exception("B file error"));
                                n(this.f401649f, this.f401650g, this.f401652i);
                                return;
                            }
                            return;
                        }
                        if (i16 >= 0 && i16 <= length2 - 12) {
                            this.f401654k.clear();
                            l();
                            this.f401652i = i16 + 12;
                            if (this.f401651h.f401635b.length != this.f401650g.capacity()) {
                                this.f401651h = new m(this.f401650g.capacity());
                            }
                            M(this.f401650g, this.f401651h, this.f401652i);
                            if (j18 == this.f401651h.f(12, i16) && R() == 0) {
                                w0(new Exception("A file error"));
                                n(this.f401650g, this.f401649f, this.f401652i);
                                this.f401653j = j18;
                                z17 = true;
                                if (z17) {
                                    s("both files error");
                                    j0();
                                    return;
                                }
                                return;
                            }
                        }
                        z17 = false;
                        if (z17) {
                        }
                    }
                }
                z16 = false;
                if (!z16) {
                }
            } else {
                throw new Exception("open file failed");
            }
        } catch (Exception e16) {
            t(e16);
            n0();
        }
    }

    private boolean P() {
        File file = new File(this.f401644a, this.f401645b + ".kvc");
        File file2 = new File(this.f401644a, this.f401645b + ".tmp");
        boolean z16 = false;
        try {
            if (!file.exists()) {
                if (file2.exists()) {
                    file = file2;
                } else {
                    file = null;
                }
            }
            if (file != null) {
                long length = file.length();
                if (length != 0 && length <= 536870912) {
                    int i3 = (int) length;
                    byte[] bArr = new byte[F(f401641x, i3)];
                    l.i(file, bArr, i3);
                    m mVar = new m(bArr);
                    this.f401651h = mVar;
                    int i16 = mVar.i();
                    long j3 = mVar.j();
                    this.f401652i = i16 + 12;
                    if (i16 >= 0 && i16 <= i3 - 12 && j3 == mVar.f(12, i16) && R() == 0) {
                        this.f401653j = j3;
                        if (this.f401663t == 0) {
                            if (B0(mVar)) {
                                K("recover from c file");
                                z16 = true;
                            } else {
                                this.f401663t = 1;
                            }
                        }
                    } else {
                        k();
                    }
                    if (this.f401663t == 0) {
                        q();
                    }
                }
                q();
                return false;
            }
        } catch (Exception e16) {
            t(e16);
            q();
        }
        return z16;
    }

    private void Q() {
        int size = this.f401662s.size() - 1;
        c cVar = this.f401662s.get(size);
        while (size > 0) {
            size--;
            c cVar2 = this.f401662s.get(size);
            if (cVar.f401670d == cVar2.f401671e) {
                cVar2.f401671e = cVar.f401671e;
                this.f401662s.remove(size + 1);
            }
            cVar = cVar2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:98:0x016b, code lost:
    
        throw new java.lang.Exception("parse dara failed");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int R() {
        int l3;
        Object d16;
        m mVar = this.f401651h;
        mVar.f401636c = 12;
        while (true) {
            try {
                int i3 = mVar.f401636c;
                int i16 = this.f401652i;
                boolean z16 = false;
                if (i3 < i16) {
                    byte c16 = mVar.c();
                    byte b16 = (byte) (c16 & 63);
                    boolean z17 = true;
                    if (b16 < 1 || b16 > 8) {
                        break;
                    }
                    int c17 = mVar.c() & 255;
                    if (c16 < 0) {
                        mVar.f401636c += c17;
                        if (b16 <= 5) {
                            l3 = f401639v[b16];
                        } else {
                            l3 = mVar.l() & 65535;
                        }
                        m mVar2 = this.f401651h;
                        int i17 = mVar2.f401636c + l3;
                        mVar2.f401636c = i17;
                        o(i3, i17);
                    } else {
                        String m3 = mVar.m(c17);
                        int i18 = mVar.f401636c;
                        if (b16 <= 5) {
                            if (b16 != 1) {
                                if (b16 != 2) {
                                    if (b16 != 3) {
                                        if (b16 != 4) {
                                            this.f401654k.put(m3, new d(i18, mVar.g()));
                                        } else {
                                            this.f401654k.put(m3, new g(i18, mVar.j()));
                                        }
                                    } else {
                                        this.f401654k.put(m3, new e(i18, mVar.h()));
                                    }
                                } else {
                                    this.f401654k.put(m3, new f(i18, mVar.i()));
                                }
                            } else {
                                Map<String, ga3.b> map = this.f401654k;
                                if (mVar.c() == 1) {
                                    z16 = true;
                                }
                                map.put(m3, new ga3.c(i18, z16));
                            }
                        } else {
                            int l16 = 65535 & mVar.l();
                            if ((c16 & MaskType.MASK_TYPE_EXTERNAL) == 0) {
                                z17 = false;
                            }
                            j(l16, z17);
                            if (b16 != 6) {
                                if (b16 != 7) {
                                    if (z17) {
                                        this.f401654k.put(m3, new h(i3, i18 + 2, mVar.m(l16), l16, true));
                                    } else {
                                        int c18 = mVar.c() & 255;
                                        String m16 = mVar.m(c18);
                                        b bVar = this.f401646c.get(m16);
                                        int i19 = l16 - (c18 + 1);
                                        if (i19 >= 0) {
                                            if (bVar != null) {
                                                try {
                                                    Object a16 = bVar.a(mVar.f401635b, mVar.f401636c, i19);
                                                    if (a16 != null) {
                                                        this.f401654k.put(m3, new h(i3, i18 + 2, a16, l16, false));
                                                    }
                                                } catch (Exception e16) {
                                                    t(e16);
                                                }
                                            } else {
                                                s("object with tag: " + m16 + " without encoder");
                                            }
                                            mVar.f401636c += i19;
                                        } else {
                                            throw new Exception("parse dara failed");
                                        }
                                    }
                                } else {
                                    if (z17) {
                                        d16 = mVar.m(l16);
                                    } else {
                                        d16 = mVar.d(l16);
                                    }
                                    this.f401654k.put(m3, new ga3.a(i3, i18 + 2, d16, l16, z17));
                                }
                            } else {
                                this.f401654k.put(m3, new i(i3, i18 + 2, mVar.m(l16), l16, z17));
                            }
                        }
                    }
                } else {
                    if (i3 == i16) {
                        return 0;
                    }
                    w0(new Exception("parse dara failed"));
                    return -1;
                }
            } catch (Exception e17) {
                t(e17);
                return -1;
            }
        }
    }

    private void S() {
        r(this.f401657n);
        int i3 = this.f401652i;
        this.f401656m = i3;
        this.f401652i = this.f401657n + i3;
        this.f401651h.f401636c = i3;
        this.f401659p = true;
    }

    private void a0(String str, int i3) {
        this.f401651h.q((byte) i3);
        if (i3 == str.length()) {
            m mVar = this.f401651h;
            str.getBytes(0, i3, mVar.f401635b, mVar.f401636c);
            this.f401651h.f401636c += i3;
            return;
        }
        this.f401651h.x(str);
    }

    private void c(String str, Object obj, byte[] bArr, byte b16) {
        boolean z16;
        Object obj2;
        int length;
        ga3.b hVar;
        int k06 = k0(str, bArr, b16);
        if (k06 != 0) {
            String str2 = this.f401660q;
            if (str2 != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            boolean z17 = z16;
            if (z17) {
                this.f401660q = null;
                length = 32;
                obj2 = str2;
            } else {
                obj2 = obj;
                length = bArr.length;
            }
            if (b16 == 6) {
                hVar = new i(this.f401656m, k06, (String) obj2, length, z17);
            } else if (b16 == 7) {
                hVar = new ga3.a(this.f401656m, k06, obj2, length, z17);
            } else {
                hVar = new h(this.f401656m, k06, obj2, length, z17);
            }
            this.f401654k.put(str, hVar);
            r0();
        }
    }

    private void d(String str, Object obj, byte[] bArr, j jVar, byte b16) {
        if (jVar == null) {
            c(str, obj, bArr, b16);
        } else if (!jVar.f401630e && jVar.f401629d == bArr.length) {
            q0(jVar.f401621a, bArr);
            jVar.f401627b = obj;
        } else {
            u0(str, obj, bArr, jVar);
        }
        g();
    }

    private int e() {
        int i3 = this.f401652i;
        if (i3 <= 16384) {
            return 4096;
        }
        if (i3 > 65536) {
            return 16384;
        }
        return 8192;
    }

    private void f() {
        int i3;
        if (this.f401661r < (e() << 1)) {
            int size = this.f401662s.size();
            if (this.f401652i < 16384) {
                i3 = 80;
            } else {
                i3 = 160;
            }
            if (size < i3) {
                return;
            }
        }
        u(0);
    }

    private void f0(String str, int i3) {
        this.f401651h.w((short) i3);
        if (i3 == str.length()) {
            m mVar = this.f401651h;
            str.getBytes(0, i3, mVar.f401635b, mVar.f401636c);
        } else {
            this.f401651h.x(str);
        }
    }

    private void g() {
        if (this.f401663t != 0 && this.f401664u) {
            m();
        }
    }

    private void g0(byte b16, int i3, int i16) {
        o(i3, i16);
        byte[] bArr = this.f401651h.f401635b;
        this.f401653j = (((bArr[i3] ^ r9) & 255) << ((i3 & 7) << 3)) ^ this.f401653j;
        bArr[i3] = (byte) (b16 | Byte.MIN_VALUE);
        this.f401658o = i3;
    }

    private void h(String str) {
        if (str != null && !str.isEmpty()) {
        } else {
            throw new IllegalArgumentException("key is empty");
        }
    }

    private void i(int i3) {
        if (i3 <= 255) {
        } else {
            throw new IllegalArgumentException("key's length must less than 256");
        }
    }

    private void i0(MappedByteBuffer mappedByteBuffer) throws IOException {
        FileChannel fileChannel;
        int capacity = mappedByteBuffer.capacity();
        int i3 = f401641x;
        if (capacity != i3) {
            if (mappedByteBuffer == this.f401649f) {
                fileChannel = this.f401647d;
            } else {
                fileChannel = this.f401648e;
            }
            FileChannel fileChannel2 = fileChannel;
            fileChannel2.truncate(i3);
            MappedByteBuffer map = fileChannel2.map(FileChannel.MapMode.READ_WRITE, 0L, i3);
            map.order(ByteOrder.LITTLE_ENDIAN);
            if (mappedByteBuffer == this.f401649f) {
                this.f401649f = map;
            } else {
                this.f401650g = map;
            }
            mappedByteBuffer = map;
        }
        mappedByteBuffer.putInt(0, 0);
        mappedByteBuffer.putLong(4, 0L);
    }

    private void j(int i3, boolean z16) {
        if (z16) {
            if (i3 != 32) {
                throw new IllegalStateException("name size not match");
            }
        } else if (i3 >= 0 && i3 < 2048) {
        } else {
            throw new IllegalStateException("value size out of bound");
        }
    }

    private void j0() throws IOException {
        m mVar = this.f401651h;
        if (mVar == null || mVar.f401635b.length != f401641x) {
            this.f401651h = new m(f401641x);
        }
        if (this.f401663t == 0) {
            i0(this.f401649f);
            i0(this.f401650g);
        }
        k();
        l.c(new File(this.f401644a + this.f401645b));
    }

    private void k() {
        this.f401652i = 12;
        this.f401653j = 0L;
        l();
        this.f401654k.clear();
    }

    private int k0(String str, byte[] bArr, byte b16) {
        this.f401660q = null;
        if (bArr.length < 2048) {
            return y0(str, bArr, b16, false);
        }
        K("large value, key: " + str + ", size: " + bArr.length);
        String h16 = l.h();
        if (l.j(new File(this.f401644a + this.f401645b, h16), bArr)) {
            this.f401660q = h16;
            byte[] bArr2 = new byte[32];
            h16.getBytes(0, 32, bArr2, 0);
            return y0(str, bArr2, b16, true);
        }
        s("save large value failed");
        return 0;
    }

    private void l() {
        this.f401661r = 0;
        this.f401662s.clear();
    }

    private long l0(long j3, int i3) {
        int i16 = (i3 & 7) << 3;
        return (j3 >>> (64 - i16)) | (j3 << i16);
    }

    private boolean m() {
        int i3 = this.f401663t;
        if (i3 == 1) {
            q.a().execute(new Runnable() { // from class: ga3.o
                @Override // java.lang.Runnable
                public final void run() {
                    p.this.C0();
                }
            });
        } else if (i3 == 2) {
            return C0();
        }
        return true;
    }

    private void m0(MappedByteBuffer mappedByteBuffer) {
        if (this.f401659p && mappedByteBuffer != this.f401649f) {
            mappedByteBuffer.putInt(0, this.f401652i - 12);
        }
        mappedByteBuffer.putLong(4, this.f401653j);
        int i3 = this.f401658o;
        if (i3 != 0) {
            mappedByteBuffer.put(i3, this.f401651h.f401635b[i3]);
        }
        if (this.f401657n != 0) {
            mappedByteBuffer.position(this.f401656m);
            mappedByteBuffer.put(this.f401651h.f401635b, this.f401656m, this.f401657n);
        }
    }

    private void n(MappedByteBuffer mappedByteBuffer, MappedByteBuffer mappedByteBuffer2, int i3) {
        FileChannel fileChannel;
        if (mappedByteBuffer.capacity() != mappedByteBuffer2.capacity()) {
            try {
                if (mappedByteBuffer2 == this.f401650g) {
                    fileChannel = this.f401648e;
                } else {
                    fileChannel = this.f401647d;
                }
                MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, mappedByteBuffer.capacity());
                map.order(ByteOrder.LITTLE_ENDIAN);
                if (mappedByteBuffer2 == this.f401650g) {
                    this.f401650g = map;
                } else {
                    this.f401649f = map;
                }
                mappedByteBuffer2 = map;
            } catch (IOException e16) {
                t(e16);
                p();
                return;
            }
        }
        mappedByteBuffer.rewind();
        mappedByteBuffer2.rewind();
        mappedByteBuffer.limit(i3);
        mappedByteBuffer2.put(mappedByteBuffer);
        mappedByteBuffer.limit(mappedByteBuffer.capacity());
    }

    private void n0() {
        p();
        k();
        m mVar = this.f401651h;
        if (mVar != null && mVar.f401635b.length == f401641x) {
            mVar.t(0, 0);
            this.f401651h.u(4, 0L);
        } else {
            this.f401651h = new m(f401641x);
        }
    }

    private void o(int i3, int i16) {
        this.f401661r += i16 - i3;
        this.f401662s.add(new c(i3, i16));
    }

    private void o0(int i3) {
        int i16 = f401641x;
        int F = F(i16, i3 + i16);
        byte[] bArr = this.f401651h.f401635b;
        if (F >= bArr.length) {
            return;
        }
        byte[] bArr2 = new byte[F];
        System.arraycopy(bArr, 0, bArr2, 0, this.f401652i);
        this.f401651h.f401635b = bArr2;
        if (this.f401663t == 0) {
            try {
                long j3 = F;
                this.f401647d.truncate(j3);
                MappedByteBuffer map = this.f401647d.map(FileChannel.MapMode.READ_WRITE, 0L, j3);
                this.f401649f = map;
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                map.order(byteOrder);
                this.f401648e.truncate(j3);
                MappedByteBuffer map2 = this.f401648e.map(FileChannel.MapMode.READ_WRITE, 0L, j3);
                this.f401650g = map2;
                map2.order(byteOrder);
            } catch (IOException e16) {
                t(new Exception("map failed", e16));
                p();
            }
        }
        K("truncate finish");
    }

    private void p() {
        this.f401663t = 1;
        this.f401647d = null;
        this.f401648e = null;
        this.f401649f = null;
        this.f401650g = null;
    }

    private void p0(byte b16, int i3) {
        long l06 = this.f401653j ^ l0(1L, i3);
        this.f401653j = l06;
        if (this.f401663t == 0) {
            this.f401649f.putLong(4, l06);
            this.f401649f.put(i3, b16);
            this.f401650g.putLong(4, this.f401653j);
            this.f401650g.put(i3, b16);
        } else {
            this.f401651h.u(4, l06);
        }
        this.f401651h.f401635b[i3] = b16;
    }

    private void q() {
        try {
            l.c(new File(this.f401644a, this.f401645b + ".kvc"));
            l.c(new File(this.f401644a, this.f401645b + ".tmp"));
        } catch (Exception e16) {
            t(e16);
        }
    }

    private void q0(int i3, byte[] bArr) {
        int length = bArr.length;
        this.f401653j ^= this.f401651h.f(i3, length);
        m mVar = this.f401651h;
        mVar.f401636c = i3;
        mVar.r(bArr);
        long f16 = this.f401653j ^ this.f401651h.f(i3, length);
        this.f401653j = f16;
        if (this.f401663t == 0) {
            this.f401649f.putInt(0, -1);
            this.f401649f.putLong(4, this.f401653j);
            this.f401649f.position(i3);
            this.f401649f.put(bArr);
            this.f401649f.putInt(0, this.f401652i - 12);
            this.f401650g.putLong(4, this.f401653j);
            this.f401650g.position(i3);
            this.f401650g.put(bArr);
            return;
        }
        this.f401651h.u(4, f16);
    }

    private void r(int i3) {
        int length = this.f401651h.f401635b.length;
        int i16 = this.f401652i + i3;
        if (i16 >= length) {
            int i17 = this.f401661r;
            if (i17 > i3 && i17 > e()) {
                u(i3);
                return;
            }
            int F = F(length, i16);
            byte[] bArr = new byte[F];
            System.arraycopy(this.f401651h.f401635b, 0, bArr, 0, this.f401652i);
            this.f401651h.f401635b = bArr;
            if (this.f401663t == 0) {
                try {
                    long j3 = F;
                    MappedByteBuffer map = this.f401647d.map(FileChannel.MapMode.READ_WRITE, 0L, j3);
                    this.f401649f = map;
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    map.order(byteOrder);
                    MappedByteBuffer map2 = this.f401648e.map(FileChannel.MapMode.READ_WRITE, 0L, j3);
                    this.f401650g = map2;
                    map2.order(byteOrder);
                } catch (IOException e16) {
                    t(new Exception("map failed", e16));
                    this.f401651h.t(0, this.f401652i - 12);
                    this.f401651h.u(4, this.f401653j);
                    p();
                }
            }
        }
    }

    private void r0() {
        this.f401653j ^= this.f401651h.f(this.f401656m, this.f401657n);
        if (this.f401663t == 0) {
            this.f401649f.putInt(0, -1);
            m0(this.f401649f);
            this.f401649f.putInt(0, this.f401652i - 12);
            m0(this.f401650g);
        } else {
            if (this.f401659p) {
                this.f401651h.t(0, this.f401652i - 12);
            }
            this.f401651h.u(4, this.f401653j);
        }
        this.f401659p = false;
        this.f401658o = 0;
        this.f401657n = 0;
    }

    private void s(String str) {
        r.a("WinkKV", this.f401645b, new Throwable(str));
    }

    private void s0(int i3, long j3, int i16) {
        long l06 = l0(j3, i16) ^ this.f401653j;
        this.f401653j = l06;
        if (this.f401663t == 0) {
            this.f401649f.putLong(4, l06);
            this.f401649f.putInt(i16, i3);
            this.f401650g.putLong(4, this.f401653j);
            this.f401650g.putInt(i16, i3);
        } else {
            this.f401651h.u(4, l06);
        }
        this.f401651h.t(i16, i3);
    }

    private void t(Throwable th5) {
        r.a("WinkKV", this.f401645b, th5);
    }

    private void t0(long j3, long j16, int i3) {
        long l06 = l0(j16, i3) ^ this.f401653j;
        this.f401653j = l06;
        if (this.f401663t == 0) {
            this.f401649f.putLong(4, l06);
            this.f401649f.putLong(i3, j3);
            this.f401650g.putLong(4, this.f401653j);
            this.f401650g.putLong(i3, j3);
        } else {
            this.f401651h.u(4, l06);
        }
        this.f401651h.u(i3, j3);
    }

    private void u0(String str, Object obj, byte[] bArr, j jVar) {
        String str2;
        boolean z16;
        int k06 = k0(str, bArr, jVar.a());
        if (k06 != 0) {
            if (jVar.f401630e) {
                str2 = (String) jVar.f401627b;
            } else {
                str2 = null;
            }
            g0(jVar.a(), jVar.f401628c, jVar.f401621a + jVar.f401629d);
            String str3 = this.f401660q;
            if (str3 != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            jVar.f401628c = this.f401656m;
            jVar.f401621a = k06;
            jVar.f401630e = z16;
            if (z16) {
                jVar.f401627b = str3;
                jVar.f401629d = 32;
                this.f401660q = null;
            } else {
                jVar.f401627b = obj;
                jVar.f401629d = bArr.length;
            }
            r0();
            f();
            if (str2 != null) {
                l.c(new File(this.f401644a + this.f401645b, str2));
            }
        }
    }

    private void v0(int i3, int[] iArr) {
        for (ga3.b bVar : this.f401654k.values()) {
            int i16 = bVar.f401621a;
            if (i16 > i3) {
                int i17 = iArr[(l.a(iArr, i16) << 1) + 1];
                bVar.f401621a -= i17;
                if (bVar.a() >= 6) {
                    ((j) bVar).f401628c -= i17;
                }
            }
        }
    }

    private byte[] w(ga3.a aVar) {
        try {
            byte[] e16 = l.e(new File(this.f401644a + this.f401645b, (String) aVar.f401627b));
            if (e16 == null) {
                return f401640w;
            }
            return e16;
        } catch (Exception e17) {
            t(e17);
            return f401640w;
        }
    }

    private void w0(Exception exc) {
        r.c("WinkKV", this.f401645b, exc);
    }

    private void x0(String str, String str2, i iVar) {
        int n3 = m.n(str2);
        if (iVar == null) {
            int n16 = m.n(str);
            i(n16);
            int i3 = n16 + 4;
            this.f401657n = i3 + n3;
            S();
            this.f401651h.q((byte) 6);
            a0(str, n16);
            f0(str2, n3);
            Map<String, ga3.b> map = this.f401654k;
            int i16 = this.f401656m;
            map.put(str, new i(i16, i16 + i3, str2, n3, false));
            r0();
        } else {
            int i17 = iVar.f401621a;
            int i18 = i17 - iVar.f401628c;
            int i19 = iVar.f401629d;
            boolean z16 = false;
            String str3 = null;
            if (i19 == n3) {
                this.f401653j ^= this.f401651h.f(i17, i19);
                if (n3 == str2.length()) {
                    str2.getBytes(0, n3, this.f401651h.f401635b, iVar.f401621a);
                } else {
                    m mVar = this.f401651h;
                    mVar.f401636c = iVar.f401621a;
                    mVar.x(str2);
                }
                this.f401656m = iVar.f401621a;
                this.f401657n = n3;
            } else {
                this.f401657n = i18 + n3;
                S();
                this.f401651h.q((byte) 6);
                int i26 = i18 - 3;
                m mVar2 = this.f401651h;
                byte[] bArr = mVar2.f401635b;
                System.arraycopy(bArr, iVar.f401628c + 1, bArr, mVar2.f401636c, i26);
                this.f401651h.f401636c += i26;
                f0(str2, n3);
                g0((byte) 6, iVar.f401628c, iVar.f401621a + iVar.f401629d);
                if (iVar.f401630e) {
                    str3 = (String) iVar.f401627b;
                }
                iVar.f401630e = false;
                int i27 = this.f401656m;
                iVar.f401628c = i27;
                iVar.f401621a = i27 + i18;
                iVar.f401629d = n3;
                z16 = true;
            }
            iVar.f401627b = str2;
            r0();
            if (z16) {
                f();
            }
            if (str3 != null) {
                l.c(new File(this.f401644a + this.f401645b, str3));
            }
        }
        g();
    }

    private int y0(String str, byte[] bArr, byte b16, boolean z16) {
        if (z16) {
            b16 = (byte) (b16 | MaskType.MASK_TYPE_EXTERNAL);
        }
        A0(str, b16, bArr.length + 2);
        this.f401651h.w((short) bArr.length);
        m mVar = this.f401651h;
        int i3 = mVar.f401636c;
        mVar.r(bArr);
        return i3;
    }

    private void z0(String str, byte b16) {
        A0(str, b16, f401639v[b16]);
    }

    public synchronized double A(String str, double d16) {
        d dVar = (d) this.f401654k.get(str);
        if (dVar != null) {
            d16 = dVar.f401623b;
        }
        return d16;
    }

    public float B(String str) {
        return C(str, 0.0f);
    }

    public synchronized float C(String str, float f16) {
        e eVar = (e) this.f401654k.get(str);
        if (eVar != null) {
            f16 = eVar.f401624b;
        }
        return f16;
    }

    public int D(String str) {
        return E(str, 0);
    }

    public synchronized int E(String str, int i3) {
        f fVar = (f) this.f401654k.get(str);
        if (fVar != null) {
            i3 = fVar.f401625b;
        }
        return i3;
    }

    public String H(String str) {
        return I(str, "");
    }

    public synchronized String I(String str, String str2) {
        String str3;
        i iVar = (i) this.f401654k.get(str);
        if (iVar != null) {
            if (iVar.f401630e) {
                str3 = J(iVar);
            } else {
                str3 = (String) iVar.f401627b;
            }
            return str3;
        }
        return str2;
    }

    public void T(Map<String, Object> map) {
        U(map, null);
    }

    public synchronized void U(Map<String, Object> map, Map<Class, b> map2) {
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null && !key.isEmpty()) {
                if (value instanceof String) {
                    d0(key, (String) value);
                } else if (value instanceof Boolean) {
                    W(key, ((Boolean) value).booleanValue());
                } else if (value instanceof Integer) {
                    Z(key, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    b0(key, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    Y(key, ((Float) value).floatValue());
                } else if (value instanceof Double) {
                    X(key, ((Double) value).doubleValue());
                } else if (value instanceof Set) {
                    Set set = (Set) value;
                    if (!set.isEmpty() && (set.iterator().next() instanceof String)) {
                        e0(key, (Set) value);
                    }
                } else if (value instanceof byte[]) {
                    V(key, (byte[]) value);
                } else if (map2 != null) {
                    b bVar = map2.get(value.getClass());
                    if (bVar != null) {
                        c0(key, value, bVar);
                    } else {
                        w0(new Exception("missing encoder for type:" + value.getClass()));
                    }
                } else {
                    w0(new Exception("missing encoders"));
                }
            }
        }
    }

    public synchronized void V(String str, byte[] bArr) {
        h(str);
        if (bArr == null) {
            h0(str);
        } else {
            d(str, bArr, bArr, (ga3.a) this.f401654k.get(str), (byte) 7);
        }
    }

    public synchronized void W(String str, boolean z16) {
        h(str);
        ga3.c cVar = (ga3.c) this.f401654k.get(str);
        int i3 = 0;
        if (cVar == null) {
            z0(str, (byte) 1);
            m mVar = this.f401651h;
            int i16 = mVar.f401636c;
            if (z16) {
                i3 = 1;
            }
            mVar.q((byte) i3);
            r0();
            this.f401654k.put(str, new ga3.c(i16, z16));
            g();
        } else if (cVar.f401622b != z16) {
            cVar.f401622b = z16;
            if (z16) {
                i3 = 1;
            }
            p0((byte) i3, cVar.f401621a);
            g();
        }
    }

    public synchronized void X(String str, double d16) {
        h(str);
        d dVar = (d) this.f401654k.get(str);
        if (dVar == null) {
            z0(str, (byte) 5);
            m mVar = this.f401651h;
            int i3 = mVar.f401636c;
            mVar.v(Double.doubleToRawLongBits(d16));
            r0();
            this.f401654k.put(str, new d(i3, d16));
            g();
        } else if (dVar.f401623b != d16) {
            long doubleToRawLongBits = Double.doubleToRawLongBits(d16);
            long doubleToRawLongBits2 = Double.doubleToRawLongBits(dVar.f401623b) ^ doubleToRawLongBits;
            dVar.f401623b = d16;
            t0(doubleToRawLongBits, doubleToRawLongBits2, dVar.f401621a);
            g();
        }
    }

    public synchronized void Y(String str, float f16) {
        h(str);
        e eVar = (e) this.f401654k.get(str);
        if (eVar == null) {
            z0(str, (byte) 3);
            m mVar = this.f401651h;
            int i3 = mVar.f401636c;
            mVar.s(Float.floatToRawIntBits(f16));
            r0();
            this.f401654k.put(str, new e(i3, f16));
            g();
        } else if (eVar.f401624b != f16) {
            eVar.f401624b = f16;
            s0(Float.floatToRawIntBits(f16), (Float.floatToRawIntBits(eVar.f401624b) ^ r6) & 4294967295L, eVar.f401621a);
            g();
        }
    }

    public synchronized void Z(String str, int i3) {
        h(str);
        f fVar = (f) this.f401654k.get(str);
        if (fVar == null) {
            z0(str, (byte) 2);
            m mVar = this.f401651h;
            int i16 = mVar.f401636c;
            mVar.s(i3);
            r0();
            this.f401654k.put(str, new f(i16, i3));
            g();
        } else {
            if (fVar.f401625b != i3) {
                fVar.f401625b = i3;
                s0(i3, (r6 ^ i3) & 4294967295L, fVar.f401621a);
                g();
            }
        }
    }

    public synchronized void b0(String str, long j3) {
        h(str);
        g gVar = (g) this.f401654k.get(str);
        if (gVar == null) {
            z0(str, (byte) 4);
            m mVar = this.f401651h;
            int i3 = mVar.f401636c;
            mVar.v(j3);
            r0();
            this.f401654k.put(str, new g(i3, j3));
            g();
        } else {
            long j16 = gVar.f401626b;
            if (j16 != j3) {
                gVar.f401626b = j3;
                t0(j3, j3 ^ j16, gVar.f401621a);
                g();
            }
        }
    }

    public synchronized <T> void c0(String str, T t16, b<T> bVar) {
        byte[] bArr;
        h(str);
        if (bVar != null) {
            String tag = bVar.tag();
            if (tag != null && !tag.isEmpty() && tag.length() <= 50) {
                if (this.f401646c.containsKey(tag)) {
                    if (t16 == null) {
                        h0(str);
                        return;
                    }
                    try {
                        bArr = bVar.encode(t16);
                    } catch (Exception e16) {
                        t(e16);
                        bArr = null;
                    }
                    if (bArr == null) {
                        h0(str);
                        return;
                    }
                    int n3 = m.n(tag);
                    m mVar = new m(n3 + 1 + bArr.length);
                    mVar.q((byte) n3);
                    mVar.x(tag);
                    mVar.r(bArr);
                    d(str, t16, mVar.f401635b, (h) this.f401654k.get(str), (byte) 8);
                    return;
                }
                throw new IllegalArgumentException("Encoder hasn't been registered");
            }
            throw new IllegalArgumentException("Invalid encoder tag:" + tag);
        }
        throw new IllegalArgumentException("Encoder is null");
    }

    public synchronized void d0(String str, String str2) {
        byte[] bytes;
        h(str);
        if (str2 == null) {
            h0(str);
        } else {
            i iVar = (i) this.f401654k.get(str);
            if (str2.length() * 3 < 2048) {
                x0(str, str2, iVar);
            } else {
                if (str2.isEmpty()) {
                    bytes = f401640w;
                } else {
                    bytes = str2.getBytes(StandardCharsets.UTF_8);
                }
                d(str, str2, bytes, iVar, (byte) 6);
            }
        }
    }

    public synchronized void e0(String str, Set<String> set) {
        if (set == null) {
            h0(str);
        } else {
            c0(str, set, k.f401631a);
        }
    }

    public synchronized void h0(String str) {
        ga3.b bVar = this.f401654k.get(str);
        if (bVar != null) {
            this.f401654k.remove(str);
            byte a16 = bVar.a();
            String str2 = null;
            if (a16 <= 5) {
                int n3 = m.n(str);
                int i3 = bVar.f401621a;
                g0(a16, i3 - (n3 + 2), i3 + f401639v[a16]);
            } else {
                j jVar = (j) bVar;
                g0(a16, jVar.f401628c, jVar.f401621a + jVar.f401629d);
                if (jVar.f401630e) {
                    str2 = (String) jVar.f401627b;
                }
            }
            byte b16 = (byte) (a16 | Byte.MIN_VALUE);
            if (this.f401663t == 0) {
                this.f401649f.putLong(4, this.f401653j);
                this.f401649f.put(this.f401658o, b16);
                this.f401650g.putLong(4, this.f401653j);
                this.f401650g.put(this.f401658o, b16);
            } else {
                this.f401651h.u(4, this.f401653j);
            }
            this.f401658o = 0;
            if (str2 != null) {
                l.c(new File(this.f401644a + this.f401645b, str2));
            }
            f();
            g();
        }
    }

    public synchronized String toString() {
        return "WinkKV: path:" + this.f401644a + " name:" + this.f401645b;
    }

    void u(int i3) {
        boolean z16;
        int i16;
        Collections.sort(this.f401662s);
        Q();
        c cVar = this.f401662s.get(0);
        int i17 = cVar.f401670d;
        int i18 = this.f401652i;
        int i19 = i18 - this.f401661r;
        int i26 = i19 - 12;
        int i27 = i19 - i17;
        int i28 = i18 - i17;
        if (i26 < i28 + i27) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            this.f401653j ^= this.f401651h.f(i17, i28);
        }
        int size = this.f401662s.size();
        int i29 = size - 1;
        int i36 = this.f401652i - this.f401662s.get(i29).f401671e;
        if (i36 > 0) {
            i16 = size;
        } else {
            i16 = i29;
        }
        int[] iArr = new int[i16 << 1];
        int i37 = cVar.f401670d;
        int i38 = cVar.f401671e;
        for (int i39 = 1; i39 < size; i39++) {
            c cVar2 = this.f401662s.get(i39);
            int i46 = cVar2.f401670d - i38;
            byte[] bArr = this.f401651h.f401635b;
            System.arraycopy(bArr, i38, bArr, i37, i46);
            int i47 = (i39 - 1) << 1;
            iArr[i47] = i38;
            iArr[i47 + 1] = i38 - i37;
            i37 += i46;
            i38 = cVar2.f401671e;
        }
        if (i36 > 0) {
            byte[] bArr2 = this.f401651h.f401635b;
            System.arraycopy(bArr2, i38, bArr2, i37, i36);
            int i48 = i29 << 1;
            iArr[i48] = i38;
            iArr[i48 + 1] = i38 - i37;
        }
        l();
        if (z16) {
            this.f401653j = this.f401651h.f(12, i26);
        } else {
            this.f401653j ^= this.f401651h.f(i17, i27);
        }
        this.f401652i = i19;
        if (this.f401663t == 0) {
            this.f401649f.putInt(0, -1);
            this.f401649f.putLong(4, this.f401653j);
            this.f401649f.position(i17);
            this.f401649f.put(this.f401651h.f401635b, i17, i27);
            this.f401649f.putInt(0, i26);
            this.f401650g.putInt(0, i26);
            this.f401650g.putLong(4, this.f401653j);
            this.f401650g.position(i17);
            this.f401650g.put(this.f401651h.f401635b, i17, i27);
        } else {
            this.f401651h.t(0, i26);
            this.f401651h.u(4, this.f401653j);
        }
        v0(i17, iArr);
        int i49 = i19 + i3;
        if (this.f401651h.f401635b.length - i49 > f401643z) {
            o0(i49);
        }
        K("gc finish");
    }

    public synchronized Map<String, Object> v() {
        Object valueOf;
        int size = this.f401654k.size();
        if (size == 0) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap(((size * 4) / 3) + 1);
        for (Map.Entry<String, ga3.b> entry : this.f401654k.entrySet()) {
            String key = entry.getKey();
            ga3.b value = entry.getValue();
            switch (value.a()) {
                case 1:
                    valueOf = Boolean.valueOf(((ga3.c) value).f401622b);
                    break;
                case 2:
                    valueOf = Integer.valueOf(((f) value).f401625b);
                    break;
                case 3:
                    valueOf = Float.valueOf(((e) value).f401624b);
                    break;
                case 4:
                    valueOf = Long.valueOf(((g) value).f401626b);
                    break;
                case 5:
                    valueOf = Double.valueOf(((d) value).f401623b);
                    break;
                case 6:
                    i iVar = (i) value;
                    if (iVar.f401630e) {
                        valueOf = J(iVar);
                        break;
                    } else {
                        valueOf = iVar.f401627b;
                        break;
                    }
                case 7:
                    ga3.a aVar = (ga3.a) value;
                    if (aVar.f401630e) {
                        valueOf = w(aVar);
                        break;
                    } else {
                        valueOf = aVar.f401627b;
                        break;
                    }
                case 8:
                    h hVar = (h) value;
                    if (hVar.f401630e) {
                        valueOf = G(hVar);
                        break;
                    } else {
                        valueOf = ((h) value).f401627b;
                        break;
                    }
                default:
                    valueOf = null;
                    break;
            }
            hashMap.put(key, valueOf);
        }
        return hashMap;
    }

    public synchronized boolean x(String str) {
        return y(str, false);
    }

    public synchronized boolean y(String str, boolean z16) {
        ga3.c cVar = (ga3.c) this.f401654k.get(str);
        if (cVar != null) {
            z16 = cVar.f401622b;
        }
        return z16;
    }

    public double z(String str) {
        return A(str, 0.0d);
    }
}
