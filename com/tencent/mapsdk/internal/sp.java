package com.tencent.mapsdk.internal;

import android.content.Context;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import com.tencent.mapsdk.internal.kp;
import com.tencent.mapsdk.internal.so;
import com.tencent.mapsdk.vector.VectorMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaSource;
import com.tencent.tencentmap.mapsdk.maps.model.OverSeaTileProvider;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class sp {

    /* renamed from: f, reason: collision with root package name */
    private static final int f150367f = 7;

    /* renamed from: a, reason: collision with root package name */
    public tr f150368a;

    /* renamed from: b, reason: collision with root package name */
    public so f150369b;

    /* renamed from: c, reason: collision with root package name */
    public OverSeaTileProvider f150370c;

    /* renamed from: e, reason: collision with root package name */
    public boolean f150372e;

    /* renamed from: h, reason: collision with root package name */
    private TileOverlayOptions f150374h;

    /* renamed from: g, reason: collision with root package name */
    private TileOverlay f150373g = null;

    /* renamed from: d, reason: collision with root package name */
    public volatile boolean f150371d = false;

    public sp(tr trVar) {
        this.f150368a = null;
        this.f150368a = trVar;
        if (kl.a("5.6.3.2", "4.0.9")) {
            ku.c(mz.a(this.f150368a.H(), (TencentMapOptions) null).a() + "/tencentmapsdk/rastermap/unmainland");
            ku.c(mz.a(this.f150368a.H(), (TencentMapOptions) null).b().getPath() + "/rastermap/taiwan");
        }
    }

    private void a(Context context, OverSeaSource overSeaSource) {
        so soVar = new so();
        this.f150369b = soVar;
        if (context != null) {
            soVar.f150357i = overSeaSource;
            kp.a((kp.g) new so.AnonymousClass2(context, overSeaSource)).a((kp.b.a) Boolean.FALSE, (kp.a<kp.b.a>) null);
        }
    }

    private boolean c() {
        return this.f150371d;
    }

    private void d() {
        this.f150371d = true;
    }

    private void e() {
        TileOverlay tileOverlay = this.f150373g;
        if (tileOverlay == null) {
            return;
        }
        tileOverlay.clearTileCache();
    }

    private void f() {
        if (kl.a("5.6.3.2", "4.0.9")) {
            ku.c(mz.a(this.f150368a.H(), (TencentMapOptions) null).a() + "/tencentmapsdk/rastermap/unmainland");
            ku.c(mz.a(this.f150368a.H(), (TencentMapOptions) null).b().getPath() + "/rastermap/taiwan");
        }
    }

    private void g() {
        M m3;
        ne neVar;
        tr trVar = this.f150368a;
        TileOverlay tileOverlay = this.f150373g;
        if (trVar != null && (m3 = trVar.e_) != 0 && (neVar = trVar.aC) != null && tileOverlay != null) {
            neVar.j(((VectorMap) m3).f151352p);
            neVar.k(true);
            tileOverlay.remove();
            this.f150373g = null;
            this.f150374h = null;
        }
    }

    private void h() {
        tr trVar;
        sx b16;
        if (this.f150373g != null || (trVar = this.f150368a) == null || trVar.e_ == 0 || trVar.aC == null || (b16 = this.f150369b.b()) == null) {
            return;
        }
        LogUtil.c(ky.f149103i, "\u83b7\u53d6\u6d77\u5916\u56fe\u56fe\u6e90\uff1a".concat(String.valueOf(b16)));
        ne neVar = this.f150368a.aC;
        neVar.j(false);
        neVar.k(false);
        this.f150370c = new sq(b16, this.f150369b.f150357i, neVar.f147918e);
        String d16 = this.f150369b.d();
        String a16 = this.f150369b.a();
        LogUtil.c(ky.f149103i, "\u6d77\u5916\u74e6\u7247\u7f13\u5b58\u76ee\u5f55\uff1a".concat(String.valueOf(a16)));
        TileOverlayOptions diskCacheDir = new TileOverlayOptions().tileProvider(this.f150370c).betterQuality(false).versionInfo(d16).zIndex(1).diskCacheDir(a16);
        this.f150374h = diskCacheDir;
        this.f150373g = neVar.K.b(diskCacheDir);
        LogUtil.c(ky.f149103i, "\u5f00\u542f\u6d77\u5916\u56fe");
    }

    private so i() {
        return this.f150369b;
    }

    private boolean j() {
        return this.f150369b.f150353e;
    }

    public final void b() {
        M m3;
        C c16;
        String str;
        LogUtil.c(ky.f149103i, "\u68c0\u67e5\u6d77\u5916\u56fe\u72b6\u6001");
        tr trVar = this.f150368a;
        if (trVar != null && (m3 = trVar.e_) != 0 && (c16 = trVar.d_) != 0) {
            if (((VectorMap) m3).s() < 7) {
                g();
                LogUtil.c(ky.f149103i, "\u7ea7\u522b\u65e0\u6548");
                return;
            }
            LogUtil.c(ky.f149103i, "\u7ea7\u522b\u6709\u6548");
            if (this.f150369b.f150353e && c16.f147921h) {
                LogUtil.c(ky.f149103i, "\u6743\u9650\u6709\u6548");
                if (!c16.f147920g) {
                    if (this.f150373g != null) {
                        g();
                    }
                    LogUtil.c(ky.f149103i, "\u8fb9\u754c\u7ebf\u65e0\u6548");
                    return;
                }
                LogUtil.c(ky.f149103i, "\u8fb9\u754c\u7ebf\u6709\u6548");
                boolean z16 = this.f150369b.f150356h;
                StringBuilder sb5 = new StringBuilder("\u6570\u636e\u914d\u7f6e\u6a21\u5f0f\uff1a");
                String str2 = "\u6697\u8272";
                if (z16) {
                    str = "\u6697\u8272";
                } else {
                    str = "\u4eae\u8272";
                }
                sb5.append(str);
                LogUtil.c(ky.f149103i, sb5.toString());
                boolean m16 = ((ne) this.f150368a.d_).m();
                StringBuilder sb6 = new StringBuilder("\u5f53\u524d\u5730\u56fe\u6a21\u5f0f\uff1a");
                if (!m16) {
                    str2 = "\u4eae\u8272";
                }
                sb6.append(str2);
                LogUtil.c(ky.f149103i, sb6.toString());
                if (m16 != z16) {
                    LogUtil.c(ky.f149103i, "\u66f4\u65b0\u6697\u8272\u6a21\u5f0f\uff1a".concat(String.valueOf(m16)));
                    this.f150369b.a(m16);
                    g();
                    OverSeaTileProvider overSeaTileProvider = this.f150370c;
                    if (overSeaTileProvider != null) {
                        overSeaTileProvider.onDayNightChange(z16);
                    }
                }
                if (this.f150372e) {
                    this.f150372e = false;
                    g();
                }
                if (this.f150373g == null) {
                    h();
                    return;
                }
                return;
            }
            if (this.f150373g != null) {
                g();
            }
            LogUtil.c(ky.f149103i, "\u6743\u9650\u65e0\u6548");
        }
    }

    public final void a() {
        b();
        TileOverlayOptions tileOverlayOptions = this.f150374h;
        if (tileOverlayOptions != null) {
            tileOverlayOptions.versionInfo(this.f150369b.d()).diskCacheDir(this.f150369b.a());
        }
        TileOverlay tileOverlay = this.f150373g;
        if (tileOverlay != null) {
            tileOverlay.reload();
        }
    }

    private void a(Language language) {
        if (language == null) {
            return;
        }
        so soVar = this.f150369b;
        if (soVar.f150358j != language) {
            soVar.f150358j = language;
            OverSeaTileProvider overSeaTileProvider = this.f150370c;
            if (overSeaTileProvider != null) {
                overSeaTileProvider.onLanguageChange(language);
            }
            a();
        }
    }

    private boolean a(ge[] geVarArr) {
        tr trVar = this.f150368a;
        if (trVar == null) {
            return true;
        }
        ge[] ag5 = trVar.ag();
        if (geVarArr == null) {
            return true;
        }
        return sm.a(ag5, geVarArr);
    }

    private void a(OverSeaTileProvider overSeaTileProvider) {
        if (this.f150370c != overSeaTileProvider) {
            LogUtil.c(ky.f149103i, "\u8bbe\u7f6e\u81ea\u5b9a\u4e49\u6d77\u5916\u56fe\u6e90\uff0cold[" + this.f150370c + "] to new[" + overSeaTileProvider + "]");
            this.f150370c = overSeaTileProvider;
            this.f150372e = true;
            so soVar = this.f150369b;
            soVar.f150359k = overSeaTileProvider;
            List<ss> c16 = soVar.c();
            tr trVar = this.f150368a;
            if (trVar != null) {
                trVar.a(false, c16);
            }
            a();
        }
    }
}
