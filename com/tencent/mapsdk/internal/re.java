package com.tencent.mapsdk.internal;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.tencent.map.lib.callbacks.TileOverlayCallback;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Tile;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import java.io.File;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class re {

    /* renamed from: a, reason: collision with root package name */
    public static final String f150012a = "tileOverlay";

    /* renamed from: b, reason: collision with root package name */
    public static final String f150013b = "getTile";

    /* renamed from: c, reason: collision with root package name */
    public static final int f150014c = 1;

    /* renamed from: d, reason: collision with root package name */
    public static final int f150015d = 2;

    /* renamed from: e, reason: collision with root package name */
    public static final int f150016e = 100;

    /* renamed from: j, reason: collision with root package name */
    private static final String f150017j = "x";

    /* renamed from: k, reason: collision with root package name */
    private static final String f150018k = "y";

    /* renamed from: l, reason: collision with root package name */
    private static final String f150019l = "z";

    /* renamed from: f, reason: collision with root package name */
    public tk f150020f;

    /* renamed from: g, reason: collision with root package name */
    public Map<Integer, qz> f150021g = new Hashtable(4);

    /* renamed from: h, reason: collision with root package name */
    public ne f150022h;

    /* renamed from: i, reason: collision with root package name */
    String f150023i;

    /* renamed from: m, reason: collision with root package name */
    private rg f150024m;

    /* renamed from: n, reason: collision with root package name */
    private Context f150025n;

    public re(Context context, ne neVar) {
        this.f150025n = context;
        this.f150022h = neVar;
        this.f150020f = neVar.f149396i;
        this.f150023i = mz.a(context, (TencentMapOptions) null).b().getPath();
    }

    private ne b() {
        return this.f150022h;
    }

    private boolean c() {
        return this.f150020f.v();
    }

    private void d() {
        Map<Integer, qz> map = this.f150021g;
        if (map != null && !map.isEmpty()) {
            for (qz qzVar : (qz[]) this.f150021g.values().toArray(new qz[this.f150021g.keySet().size()])) {
                qzVar.remove();
            }
        }
    }

    public final qz a(int i3) {
        if (i3 >= 0) {
            return this.f150021g.get(Integer.valueOf(i3));
        }
        return null;
    }

    private Context a() {
        return this.f150025n;
    }

    private void c(int i3) {
        if (this.f150020f == null) {
            return;
        }
        this.f150021g.remove(Integer.valueOf(i3));
        this.f150020f.d(i3);
        lc.c(ky.f149097c, this.f150022h.N);
    }

    public final TileOverlay b(TileOverlayOptions tileOverlayOptions) {
        qz a16 = a(tileOverlayOptions);
        lc.a(ky.f149097c, this.f150022h.N);
        return new ba(a16);
    }

    public final void a(qz qzVar) {
        int i3;
        if (qzVar == null || (i3 = qzVar.f149999p) <= 0) {
            return;
        }
        this.f150021g.put(Integer.valueOf(i3), qzVar);
    }

    public final qz a(TileOverlayOptions tileOverlayOptions) {
        if (this.f150024m == null) {
            this.f150024m = new rg(this);
        }
        return this.f150024m.a(tileOverlayOptions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(int i3) {
        tk tkVar = this.f150020f;
        if (tkVar == null) {
            return;
        }
        tkVar.e(i3);
    }

    private void a(boolean z16) {
        this.f150020f.j(z16);
    }

    private int a(TileOverlayCallback tileOverlayCallback, boolean z16, boolean z17) {
        if (this.f150020f == null) {
            return -1;
        }
        lc.b(ky.f149097c, this.f150022h.N);
        return this.f150020f.a(tileOverlayCallback, z16, z17);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(int i3, int i16) {
        tk tkVar = this.f150020f;
        if (tkVar == null) {
            return;
        }
        tkVar.b(i3, i16);
    }

    public final void a(int i3, int i16, int i17) {
        tk tkVar = this.f150020f;
        if (tkVar == null) {
            return;
        }
        tkVar.a(i3, i16, i17);
    }

    public final byte[] a(String str) {
        int a16;
        qz qzVar;
        try {
            Uri parse = Uri.parse(str);
            if (!hs.a(parse.getAuthority(), f150013b) || (a16 = a(parse)) == -1 || (qzVar = this.f150021g.get(Integer.valueOf(a16))) == null) {
                return null;
            }
            int a17 = a(parse, "x");
            int a18 = a(parse, "y");
            int a19 = a(parse, "z");
            TileOverlayOptions tileOverlayOptions = qzVar.f150001r;
            if (tileOverlayOptions != null && tileOverlayOptions.getTileProvider() != null && a19 >= 0) {
                String format = String.format(qz.f149994b, kt.b(qzVar.f150001r.getVersionInfo()), Integer.valueOf(a17), Integer.valueOf(a18), Integer.valueOf(a19));
                Tile tile = qzVar.f150001r.getTileProvider().getTile(a17, a18, a19);
                if (tile == null) {
                    LogUtil.d(ky.f149097c, "Provider\u6ca1\u6709\u74e6\u7247\u6570\u636e\uff0c\u8fd4\u56de\u7a7a\u74e6\u5757");
                    return hn.a();
                }
                byte[] bArr = tile.mData;
                if (bArr != null && bArr.length > 0) {
                    lc.b(ky.f149097c, "cacheId", (Object) format, qzVar.f150003t);
                    rb rbVar = new rb(bArr);
                    jz<rb> jzVar = qzVar.f150002s;
                    if (jzVar != null) {
                        kg a26 = kd.a(jzVar);
                        if (a26 != null) {
                            a26.b(format, (String) rbVar);
                        } else {
                            qzVar.f150002s.a(format, (String) rbVar);
                        }
                    }
                }
                return bArr;
            }
            LogUtil.d(ky.f149097c, "\u65e0\u6548\u5750\u6807\uff0c\u8fd4\u56de\u7a7a\u74e6\u5757");
            return hn.a();
        } catch (Exception e16) {
            LogUtil.d(Log.getStackTraceString(e16));
            return null;
        }
    }

    private static int a(Uri uri) {
        String lastPathSegment;
        if (uri == null || (lastPathSegment = uri.getLastPathSegment()) == null) {
            return -1;
        }
        try {
            return Integer.parseInt(lastPathSegment);
        } catch (NumberFormatException e16) {
            LogUtil.d(Log.getStackTraceString(e16));
            return -1;
        }
    }

    private static int a(Uri uri, String str) {
        if (uri == null) {
            return -1;
        }
        try {
            return Integer.parseInt(uri.getQueryParameter(str));
        } catch (NumberFormatException e16) {
            LogUtil.d(Log.getStackTraceString(e16));
            return -1;
        }
    }

    private static void a(Context context) {
        File[] listFiles;
        if (context == null) {
            return;
        }
        File file = new File(mz.a(context, (TencentMapOptions) null).b().getPath() + "/tile/");
        if (!file.exists() || (listFiles = file.listFiles()) == null || listFiles.length == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        for (File file2 : listFiles) {
            if (currentTimeMillis - file2.lastModified() > TimeUnit.DAYS.toMillis(7L)) {
                kt.b(file2);
            }
        }
    }
}
