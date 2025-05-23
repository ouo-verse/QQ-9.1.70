package com.tencent.mapsdk.internal;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.map.lib.callbacks.TileOverlayCallback;
import com.tencent.mapsdk.core.utils.cache.DiskCache;
import com.tencent.mapsdk.core.utils.cache.MemoryCache;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.jz;
import com.tencent.mapsdk.internal.lw;
import com.tencent.tencentmap.mapsdk.maps.model.Tile;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import com.tencent.tencentmap.mapsdk.maps.model.TileProvider;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: P */
/* loaded from: classes9.dex */
public class qz extends po implements TileOverlayCallback {

    /* renamed from: b, reason: collision with root package name */
    static final String f149994b = "%s" + File.separatorChar + "%d-%d-%d";

    /* renamed from: d, reason: collision with root package name */
    static final String f149995d = "/tile/";

    /* renamed from: u, reason: collision with root package name */
    private static final String f149996u = "GLTileOverlay";

    /* renamed from: v, reason: collision with root package name */
    private static final boolean f149997v = false;

    /* renamed from: w, reason: collision with root package name */
    private static final long f149998w = 1024;
    private final mb A;

    /* renamed from: p, reason: collision with root package name */
    int f149999p;

    /* renamed from: q, reason: collision with root package name */
    public final re f150000q;

    /* renamed from: r, reason: collision with root package name */
    public final TileOverlayOptions f150001r;

    /* renamed from: s, reason: collision with root package name */
    public jz<rb> f150002s;

    /* renamed from: t, reason: collision with root package name */
    final int f150003t;

    /* renamed from: x, reason: collision with root package name */
    private final Map<String, Integer> f150004x;

    /* renamed from: y, reason: collision with root package name */
    private lw f150005y;

    /* renamed from: z, reason: collision with root package name */
    private BlockingQueue<Runnable> f150006z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class a implements jz.b<rb> {
        a() {
        }

        @Override // com.tencent.mapsdk.internal.jz.b
        public final /* synthetic */ boolean a(rb rbVar) {
            rb rbVar2 = rbVar;
            if (rbVar2 == null) {
                return true;
            }
            rbVar2.f();
            return true;
        }

        /* synthetic */ a(byte b16) {
            this();
        }

        /* renamed from: a, reason: avoid collision after fix types in other method */
        private static boolean a2(rb rbVar) {
            if (rbVar == null) {
                return true;
            }
            rbVar.f();
            return true;
        }
    }

    public qz(re reVar, TileOverlayOptions tileOverlayOptions) {
        super((bb) reVar.f150022h.f147916c);
        this.f150004x = new ConcurrentHashMap();
        this.A = new mb() { // from class: com.tencent.mapsdk.internal.qz.1
            @Override // com.tencent.mapsdk.internal.mb, com.tencent.mapsdk.internal.lv
            public final void a(String str, byte[] bArr) {
                super.a(str, bArr);
                ne neVar = qz.this.f150000q.f150022h;
                if (neVar == null) {
                    return;
                }
                neVar.f149396i.a(str, bArr);
            }

            @Override // com.tencent.mapsdk.internal.mb, com.tencent.mapsdk.internal.lv
            public final void b(String str) {
                Runnable runnable;
                lw lwVar = qz.this.f150005y;
                if (lwVar != null) {
                    lw.a aVar = lwVar.f149267a.get(str);
                    if (aVar != null) {
                        runnable = aVar.f149281a;
                    } else {
                        runnable = null;
                    }
                    if (runnable != null) {
                        qz.this.f150006z.remove(runnable);
                    }
                }
            }
        };
        this.f150003t = reVar.f150022h.N;
        this.f150000q = reVar;
        this.f150001r = tileOverlayOptions;
        int i3 = -1;
        if (tileOverlayOptions == null) {
            this.f149999p = -1;
            return;
        }
        this.f150002s = g();
        boolean isBetterQuality = tileOverlayOptions.isBetterQuality();
        boolean isReuseTile = tileOverlayOptions.isReuseTile();
        if (reVar.f150020f != null) {
            lc.b(ky.f149097c, reVar.f150022h.N);
            i3 = reVar.f150020f.a(this, isBetterQuality, isReuseTile);
        }
        this.f149999p = i3;
        a(tileOverlayOptions.getZIndex());
    }

    private int i() {
        return this.f149999p;
    }

    private re j() {
        return this.f150000q;
    }

    private TileProvider k() {
        return this.f150001r.getTileProvider();
    }

    private rd l() {
        return new rd(this.f150000q);
    }

    private void m() {
        jz<rb> jzVar = this.f150002s;
        if (jzVar == null) {
            return;
        }
        if (jzVar instanceof kc) {
            jz a16 = ((kc) jzVar).a(0);
            if (a16 instanceof MemoryCache) {
                a16.b();
            }
            jz a17 = ((kc) this.f150002s).a(1);
            if (a17 instanceof DiskCache) {
                ((DiskCache) a17).f();
            }
        } else if (jzVar instanceof MemoryCache) {
            jzVar.b();
        }
        this.f150004x.clear();
    }

    protected int b(int i3) {
        return i3 + 100;
    }

    public final synchronized lw d() {
        if (this.f150005y == null) {
            lw lwVar = new lw();
            this.f150005y = lwVar;
            lwVar.a(this.A);
            ThreadPoolExecutor c16 = hu.c();
            this.f150006z = c16.getQueue();
            this.f150005y.f149268b = c16;
        }
        return this.f150005y;
    }

    public final void e() {
        if (this.f150000q != null && this.f149999p >= 0) {
            m();
            this.f150000q.b(this.f149999p);
            BlockingQueue<Runnable> blockingQueue = this.f150006z;
            if (blockingQueue != null) {
                blockingQueue.clear();
            }
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof qz) || this.f149999p != ((qz) obj).f149999p) {
            return false;
        }
        return true;
    }

    public final void f() {
        jz<rb> jzVar = this.f150002s;
        if (jzVar == null) {
            return;
        }
        jzVar.b();
        this.f150004x.clear();
    }

    @Override // com.tencent.mapsdk.internal.aw
    public final aq f_() {
        return null;
    }

    public final jz<rb> g() {
        TileOverlayOptions tileOverlayOptions;
        if (this.f150000q == null) {
            return null;
        }
        MemoryCache.a aVar = new MemoryCache.a(this.f150003t);
        aVar.f147658d = false;
        aVar.f147656b = this.f150001r.getMaxMemoryCacheSize(this.f150000q.f150022h);
        aVar.f147657c = new a((byte) 0);
        if (!TextUtils.isEmpty(this.f150000q.f150023i) && (tileOverlayOptions = this.f150001r) != null && !TextUtils.isEmpty(tileOverlayOptions.getDiskCacheDir())) {
            DiskCache.c cVar = new DiskCache.c(this.f150003t);
            if (!TextUtils.isEmpty(h())) {
                cVar.c();
            }
            String str = h() + this.f150001r.getDiskCacheDir();
            cVar.f147642c = new File(this.f150000q.f150023i);
            cVar.f147643d = str;
            cVar.f148969k = -1;
            cVar.f148970l = new ra();
            cVar.f147644e = new rc(this.f150000q.f150023i + File.separator + str);
            return kd.a(this.f150003t, rb.class, aVar, cVar);
        }
        return kd.a(this.f150003t, rb.class, aVar);
    }

    protected String h() {
        return f149995d;
    }

    @Override // com.tencent.mapsdk.internal.po
    public final void h_() {
        if (this.f150000q != null && this.f149999p >= 0) {
            m();
            synchronized (this) {
                lw lwVar = this.f150005y;
                if (lwVar != null) {
                    lwVar.a();
                    this.f150005y = null;
                }
            }
            re reVar = this.f150000q;
            int i3 = this.f149999p;
            if (reVar.f150020f != null) {
                reVar.f150021g.remove(Integer.valueOf(i3));
                reVar.f150020f.d(i3);
                lc.c(ky.f149097c, reVar.f150022h.N);
            }
        }
    }

    public int hashCode() {
        return y().hashCode();
    }

    @Override // com.tencent.map.lib.callbacks.TileOverlayCallback
    public Bitmap onLoadTile(int i3, int i16, int i17, byte[] bArr) {
        int i18;
        int intValue;
        TileOverlayOptions tileOverlayOptions = this.f150001r;
        if (tileOverlayOptions != null && tileOverlayOptions.getTileProvider() != null) {
            String format = String.format(f149994b, kt.b(this.f150001r.getVersionInfo()), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            int e16 = lc.e(ky.f149097c, "load-count", this.f150003t);
            int d16 = lc.d(ky.f149097c, "cache-count", this.f150003t);
            int d17 = lc.d(ky.f149097c, "data-count", this.f150003t);
            int d18 = lc.d(ky.f149097c, "req-count", this.f150003t);
            int d19 = lc.d(ky.f149097c, "cancel-count", this.f150003t);
            rb rbVar = (rb) kd.a(this.f150002s).b(format, rb.class);
            if (rbVar != null) {
                d16 = lc.e(ky.f149097c, "cache-count", this.f150003t);
                i18 = rbVar.f148978e;
                if (e16 == d18 + d17 + d16 + d19) {
                    lc.d(ky.f149097c, this.f150003t);
                }
            } else {
                i18 = 0;
            }
            lc.a("get from cache of cacheId:".concat(String.valueOf(format)), "dataLength:".concat(String.valueOf(i18)), "loadCount:".concat(String.valueOf(e16)), "reqCount:".concat(String.valueOf(d18)), "dataCount:".concat(String.valueOf(d17)), "cacheCount:".concat(String.valueOf(d16)), "cancelCount:".concat(String.valueOf(d19)));
            if (rbVar != null) {
                this.f150004x.remove(format);
                rbVar.e();
                return rbVar.c();
            }
            Integer num = this.f150004x.get(format);
            if (num != null && num.intValue() > 10) {
                Iterator<Map.Entry<String, Integer>> it = this.f150004x.entrySet().iterator();
                int i19 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (it.next().getValue().intValue() > 10) {
                        i19++;
                    }
                    if (i19 > 50) {
                        LogUtil.d("\u8d85\u8fc750\u4e2a\u74e6\u7247\u8bf7\u6c42\u5927\u4e8e10\u6b21\uff0c\u91cd\u65b0\u52a0\u8f7dTileOverlay");
                        e();
                        break;
                    }
                }
                StringBuilder sb5 = new StringBuilder(128);
                sb5.append("tileOverlay://getTile/");
                sb5.append(this.f149999p);
                sb5.append("?x=");
                sb5.append(i3);
                sb5.append("&y=");
                sb5.append(i16);
                sb5.append("&z=");
                sb5.append(i17);
                byte[] bytes = sb5.toString().getBytes();
                System.arraycopy(bytes, 0, bArr, 0, bytes.length);
                return null;
            }
            Map<String, Integer> map = this.f150004x;
            if (num == null) {
                intValue = 0;
            } else {
                intValue = num.intValue() + 1;
            }
            map.put(format, Integer.valueOf(intValue));
            StringBuilder sb6 = new StringBuilder(128);
            sb6.append("tileOverlay://getTile/");
            sb6.append(this.f149999p);
            sb6.append("?x=");
            sb6.append(i3);
            sb6.append("&y=");
            sb6.append(i16);
            sb6.append("&z=");
            sb6.append(i17);
            byte[] bytes2 = sb6.toString().getBytes();
            System.arraycopy(bytes2, 0, bArr, 0, bytes2.length);
            return null;
        }
        return null;
    }

    @Override // com.tencent.map.lib.callbacks.TileOverlayCallback
    public void onLoadTileFinish(int i3, int i16, int i17) {
        rb rbVar = (rb) kd.a(this.f150002s).b(String.format(f149994b, kt.b(this.f150001r.getVersionInfo()), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17)), rb.class);
        if (rbVar != null) {
            rbVar.d();
        }
    }

    @Override // com.tencent.mapsdk.internal.aw, com.tencent.tencentmap.mapsdk.maps.interfaces.Tappable
    public boolean onTap(float f16, float f17) {
        return false;
    }

    public final void a(int i3) {
        if (this.f150000q == null || this.f149999p < 0) {
            return;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        this.f150000q.a(this.f149999p, b(i3));
    }

    public final void a(int i3, int i16) {
        int i17;
        re reVar = this.f150000q;
        if (reVar == null || (i17 = this.f149999p) < 0) {
            return;
        }
        reVar.a(i17, i3, i16);
    }

    private void a(String str) {
        if (this.f150001r == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f150001r.diskCacheDir(str);
        this.f150002s = g();
    }

    private byte[] a(int i3, int i16, int i17) {
        TileOverlayOptions tileOverlayOptions = this.f150001r;
        if (tileOverlayOptions != null && tileOverlayOptions.getTileProvider() != null && i17 >= 0) {
            String format = String.format(f149994b, kt.b(this.f150001r.getVersionInfo()), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            Tile tile = this.f150001r.getTileProvider().getTile(i3, i16, i17);
            if (tile == null) {
                LogUtil.d(ky.f149097c, "Provider\u6ca1\u6709\u74e6\u7247\u6570\u636e\uff0c\u8fd4\u56de\u7a7a\u74e6\u5757");
                return hn.a();
            }
            byte[] bArr = tile.mData;
            if (bArr != null && bArr.length > 0) {
                lc.b(ky.f149097c, "cacheId", (Object) format, this.f150003t);
                rb rbVar = new rb(bArr);
                jz<rb> jzVar = this.f150002s;
                if (jzVar != null) {
                    kg a16 = kd.a(jzVar);
                    if (a16 != null) {
                        a16.b(format, (String) rbVar);
                    } else {
                        this.f150002s.a(format, (String) rbVar);
                    }
                }
            }
            return bArr;
        }
        LogUtil.d(ky.f149097c, "\u65e0\u6548\u5750\u6807\uff0c\u8fd4\u56de\u7a7a\u74e6\u5757");
        return hn.a();
    }

    @Override // com.tencent.map.lib.callbacks.TileOverlayCallback
    public void onWriteTile(int i3, int i16, int i17, String str, byte[] bArr) {
    }
}
